package com.unboundid.util.parallel;

import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@InternalUseOnly
public final class AsynchronousParallelProcessor<I, O> {
    /* access modifiers changed from: private */
    public final AtomicReference<Throwable> invocationException;
    private final AsynchronousParallelProcessor<I, O>.InvokerThread invokerThread;
    /* access modifiers changed from: private */
    public final ParallelProcessor<I, O> parallelProcessor;
    /* access modifiers changed from: private */
    public final BlockingQueue<I> pendingQueue;
    /* access modifiers changed from: private */
    public final ResultProcessor<I, O> resultProcessor;
    /* access modifiers changed from: private */
    public final AtomicBoolean shutdown;

    private final class InvokerThread extends Thread {
        private InvokerThread() {
            super("Asynchronous Parallel Processor");
            setDaemon(true);
        }

        public void run() {
            while (true) {
                if (!AsynchronousParallelProcessor.this.shutdown.get() || !AsynchronousParallelProcessor.this.pendingQueue.isEmpty()) {
                    try {
                        Object poll = AsynchronousParallelProcessor.this.pendingQueue.poll(100, TimeUnit.MILLISECONDS);
                        if (poll != null) {
                            ArrayList arrayList = new ArrayList(AsynchronousParallelProcessor.this.pendingQueue.size() + 1);
                            arrayList.add(poll);
                            AsynchronousParallelProcessor.this.pendingQueue.drainTo(arrayList);
                            for (Result processResult : AsynchronousParallelProcessor.this.parallelProcessor.processAll(arrayList)) {
                                AsynchronousParallelProcessor.this.resultProcessor.processResult(processResult);
                            }
                        }
                    } catch (Throwable th) {
                        Debug.debugException(th);
                        AsynchronousParallelProcessor.this.invocationException.compareAndSet((Object) null, th);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private static final class OutputEnqueuer<I, O> implements ResultProcessor<I, O> {
        private final BlockingQueue<Result<I, O>> outputQueue;

        private OutputEnqueuer(BlockingQueue<Result<I, O>> blockingQueue) {
            this.outputQueue = blockingQueue;
        }

        public void processResult(Result<I, O> result) {
            this.outputQueue.put(result);
        }
    }

    public AsynchronousParallelProcessor(BlockingQueue<I> blockingQueue, ParallelProcessor<I, O> parallelProcessor2, ResultProcessor<I, O> resultProcessor2) {
        this.shutdown = new AtomicBoolean(false);
        this.invocationException = new AtomicReference<>();
        this.pendingQueue = blockingQueue;
        this.parallelProcessor = parallelProcessor2;
        this.resultProcessor = resultProcessor2;
        this.invokerThread = new InvokerThread();
        this.invokerThread.start();
    }

    public AsynchronousParallelProcessor(BlockingQueue<I> blockingQueue, ParallelProcessor<I, O> parallelProcessor2, BlockingQueue<Result<I, O>> blockingQueue2) {
        this(blockingQueue, parallelProcessor2, new OutputEnqueuer(blockingQueue2));
    }

    public synchronized void shutdown() {
        if (!this.shutdown.getAndSet(true)) {
            this.invokerThread.join();
            this.parallelProcessor.shutdown();
        }
    }

    public synchronized void submit(I i) {
        if (!this.shutdown.get()) {
            Throwable th = this.invocationException.get();
            if (th == null) {
                this.pendingQueue.put(i);
            } else {
                shutdown();
                throw new RuntimeException(th);
            }
        } else {
            throw new IllegalStateException("cannot call submit() after shutdown()");
        }
    }
}
