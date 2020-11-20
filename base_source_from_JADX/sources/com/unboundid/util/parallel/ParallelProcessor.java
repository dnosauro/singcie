package com.unboundid.util.parallel;

import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.LDAPSDKThreadFactory;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@InternalUseOnly
public final class ParallelProcessor<I, O> {
    private final AtomicReference<List<? extends I>> inputItems;
    private final int minPerThread;
    private final AtomicInteger nextToProcess;
    private final AtomicReference<List<Result<I, O>>> outputItems;
    /* access modifiers changed from: private */
    public volatile CountDownLatch processingCompleteSignal;
    private final Processor<I, O> processor;
    /* access modifiers changed from: private */
    public final AtomicBoolean shutdown;
    /* access modifiers changed from: private */
    public final Semaphore workerSemaphore;
    private final List<Thread> workers;

    private final class ProcessResult implements Result<I, O> {
        private final Throwable failureCause;
        private final I inputItem;
        private final O outputItem;

        private ProcessResult(I i, O o, Throwable th) {
            this.inputItem = i;
            this.outputItem = o;
            this.failureCause = th;
        }

        public Throwable getFailureCause() {
            return this.failureCause;
        }

        public I getInput() {
            return this.inputItem;
        }

        public O getOutput() {
            return this.outputItem;
        }
    }

    private final class Worker implements Runnable {
        private Worker() {
        }

        public void run() {
            while (true) {
                try {
                    ParallelProcessor.this.workerSemaphore.acquire();
                } catch (InterruptedException e) {
                    Debug.debugException(e);
                }
                if (!ParallelProcessor.this.shutdown.get()) {
                    try {
                        ParallelProcessor.this.processInParallel();
                    } finally {
                        ParallelProcessor.this.processingCompleteSignal.countDown();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public ParallelProcessor(Processor<I, O> processor2, int i, int i2) {
        this(processor2, (ThreadFactory) null, i, i2);
    }

    public ParallelProcessor(Processor<I, O> processor2, ThreadFactory threadFactory, int i, int i2) {
        this.workerSemaphore = new Semaphore(0);
        this.inputItems = new AtomicReference<>();
        this.outputItems = new AtomicReference<>();
        this.nextToProcess = new AtomicInteger();
        this.shutdown = new AtomicBoolean();
        Validator.ensureNotNull(processor2);
        Validator.ensureTrue(i >= 1, "ParallelProcessor.totalThreads must be at least 1.");
        Validator.ensureTrue(i <= 1000, "ParallelProcessor.totalThreads must not be greater than 1000.");
        Validator.ensureTrue(i2 >= 1, "ParallelProcessor.minPerThread must be at least 1.");
        this.processor = processor2;
        this.minPerThread = i2;
        threadFactory = threadFactory == null ? new LDAPSDKThreadFactory("ParallelProcessor-Worker", true) : threadFactory;
        int i3 = i - 1;
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            Thread newThread = threadFactory.newThread(new Worker());
            arrayList.add(newThread);
            newThread.start();
        }
        this.workers = arrayList;
    }

    private ParallelProcessor<I, O>.ProcessResult process(I i) {
        Throwable th;
        O o;
        try {
            th = null;
            o = this.processor.process(i);
        } catch (Throwable th2) {
            o = null;
            th = th2;
        }
        return new ProcessResult(i, o, th);
    }

    /* access modifiers changed from: private */
    public void processInParallel() {
        try {
            List list = this.inputItems.get();
            List list2 = this.outputItems.get();
            int size = list.size();
            while (true) {
                int andIncrement = this.nextToProcess.getAndIncrement();
                if (andIncrement < size) {
                    list2.set(andIncrement, process(list.get(andIncrement)));
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
            Debug.debugException(th);
        }
    }

    public synchronized ArrayList<Result<I, O>> processAll(List<? extends I> list) {
        if (!this.shutdown.get()) {
            Validator.ensureNotNull(list);
            int min = Math.min((list.size() / this.minPerThread) - 1, this.workers.size());
            if (min <= 0) {
                ArrayList<Result<I, O>> arrayList = new ArrayList<>(list.size());
                for (Object process : list) {
                    arrayList.add(process(process));
                }
                return arrayList;
            }
            this.processingCompleteSignal = new CountDownLatch(min);
            this.inputItems.set(list);
            ArrayList<Result<I, O>> arrayList2 = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                arrayList2.add((Object) null);
            }
            this.outputItems.set(arrayList2);
            this.nextToProcess.set(0);
            this.workerSemaphore.release(min);
            processInParallel();
            this.processingCompleteSignal.await();
            return arrayList2;
        }
        throw new IllegalStateException("cannot call processAll() after shutdown()");
    }

    public synchronized void shutdown() {
        if (!this.shutdown.getAndSet(true)) {
            this.workerSemaphore.release(this.workers.size());
            for (Thread join : this.workers) {
                join.join();
            }
        }
    }
}
