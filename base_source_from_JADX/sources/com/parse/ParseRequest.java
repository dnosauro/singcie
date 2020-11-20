package com.parse;

import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ParseRequest<Response> {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    static final long DEFAULT_INITIAL_RETRY_DELAY = 1000;
    protected static final int DEFAULT_MAX_RETRIES = 4;
    private static final long KEEP_ALIVE_TIME = 1;
    private static final int MAX_POOL_SIZE;
    private static final int MAX_QUEUE_SIZE = 128;
    protected static final ExecutorService NETWORK_EXECUTOR = newThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(128), sThreadFactory);
    private static long defaultInitialRetryDelay = DEFAULT_INITIAL_RETRY_DELAY;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ParseRequest.NETWORK_EXECUTOR-thread-" + this.mCount.getAndIncrement());
        }
    };
    ParseHttpRequest.Method method;
    String url;

    private static class ParseRequestException extends ParseException {
        boolean isPermanentFailure = false;

        public ParseRequestException(int i, String str) {
            super(i, str);
        }

        public ParseRequestException(int i, String str, Throwable th) {
            super(i, str, th);
        }
    }

    static {
        int i = CPU_COUNT;
        CORE_POOL_SIZE = (i * 2) + 1;
        MAX_POOL_SIZE = (i * 2 * 2) + 1;
    }

    public ParseRequest(ParseHttpRequest.Method method2, String str) {
        this.method = method2;
        this.url = str;
    }

    public ParseRequest(String str) {
        this(ParseHttpRequest.Method.GET, str);
    }

    /* access modifiers changed from: private */
    public Task<Response> executeAsync(ParseHttpClient parseHttpClient, ParseHttpRequest parseHttpRequest, int i, long j, ProgressCallback progressCallback, Task<Void> task) {
        if (task != null && task.isCancelled()) {
            return Task.cancelled();
        }
        ParseHttpClient parseHttpClient2 = parseHttpClient;
        ParseHttpRequest parseHttpRequest2 = parseHttpRequest;
        final Task<Void> task2 = task;
        final int i2 = i;
        final long j2 = j;
        final ParseHttpClient parseHttpClient3 = parseHttpClient;
        final ParseHttpRequest parseHttpRequest3 = parseHttpRequest;
        final ProgressCallback progressCallback2 = progressCallback;
        return sendOneRequestAsync(parseHttpClient, parseHttpRequest, progressCallback).continueWithTask(new Continuation<Response, Task<Response>>() {
            public Task<Response> then(Task<Response> task) {
                Exception error = task.getError();
                if (!task.isFaulted() || !(error instanceof ParseException)) {
                    return task;
                }
                Task task2 = task2;
                if (task2 != null && task2.isCancelled()) {
                    return Task.cancelled();
                }
                if (((error instanceof ParseRequestException) && ((ParseRequestException) error).isPermanentFailure) || i2 >= ParseRequest.maxRetries()) {
                    return task;
                }
                PLog.m8818i("com.parse.ParseRequest", "Request failed. Waiting " + j2 + " milliseconds before attempt #" + (i2 + 1));
                final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                ParseExecutors.scheduled().schedule(new Runnable() {
                    public void run() {
                        ParseRequest.this.executeAsync(parseHttpClient3, parseHttpRequest3, i2 + 1, j2 * 2, progressCallback2, task2).continueWithTask(new Continuation<Response, Task<Void>>() {
                            public Task<Void> then(Task<Response> task) {
                                if (task.isCancelled()) {
                                    taskCompletionSource.setCancelled();
                                    return null;
                                } else if (task.isFaulted()) {
                                    taskCompletionSource.setError(task.getError());
                                    return null;
                                } else {
                                    taskCompletionSource.setResult(task.getResult());
                                    return null;
                                }
                            }
                        });
                    }
                }, j2, TimeUnit.MILLISECONDS);
                return taskCompletionSource.getTask();
            }
        });
    }

    private Task<Response> executeAsync(ParseHttpClient parseHttpClient, ParseHttpRequest parseHttpRequest, ProgressCallback progressCallback, Task<Void> task) {
        long j = defaultInitialRetryDelay;
        return executeAsync(parseHttpClient, parseHttpRequest, 0, j + ((long) (((double) j) * Math.random())), progressCallback, task);
    }

    public static long getDefaultInitialRetryDelay() {
        return defaultInitialRetryDelay;
    }

    /* access modifiers changed from: private */
    public static int maxRetries() {
        if (ParsePlugins.get() == null) {
            return 4;
        }
        return ParsePlugins.get().configuration().maxRetries;
    }

    private static ThreadPoolExecutor newThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue, threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    private Task<Response> sendOneRequestAsync(final ParseHttpClient parseHttpClient, final ParseHttpRequest parseHttpRequest, final ProgressCallback progressCallback) {
        return Task.forResult(null).onSuccessTask(new Continuation<Void, Task<Response>>() {
            public Task<Response> then(Task<Void> task) {
                return ParseRequest.this.onResponseAsync(parseHttpClient.execute(parseHttpRequest), progressCallback);
            }
        }, (Executor) NETWORK_EXECUTOR).continueWithTask(new Continuation<Response, Task<Response>>() {
            public Task<Response> then(Task<Response> task) {
                if (!task.isFaulted()) {
                    return task;
                }
                Exception error = task.getError();
                return error instanceof IOException ? Task.forError(ParseRequest.this.newTemporaryException("i/o failure", (Throwable) error)) : task;
            }
        }, (Executor) Task.BACKGROUND_EXECUTOR);
    }

    public static void setDefaultInitialRetryDelay(long j) {
        defaultInitialRetryDelay = j;
    }

    public Task<Response> executeAsync(ParseHttpClient parseHttpClient) {
        return executeAsync(parseHttpClient, (ProgressCallback) null, (ProgressCallback) null, (Task<Void>) null);
    }

    public Task<Response> executeAsync(ParseHttpClient parseHttpClient, Task<Void> task) {
        return executeAsync(parseHttpClient, (ProgressCallback) null, (ProgressCallback) null, task);
    }

    public Task<Response> executeAsync(ParseHttpClient parseHttpClient, ProgressCallback progressCallback, ProgressCallback progressCallback2) {
        return executeAsync(parseHttpClient, progressCallback, progressCallback2, (Task<Void>) null);
    }

    public Task<Response> executeAsync(ParseHttpClient parseHttpClient, ProgressCallback progressCallback, ProgressCallback progressCallback2, Task<Void> task) {
        return executeAsync(parseHttpClient, newRequest(this.method, this.url, progressCallback), progressCallback2, task);
    }

    /* access modifiers changed from: protected */
    public ParseHttpBody newBody(ProgressCallback progressCallback) {
        return null;
    }

    /* access modifiers changed from: protected */
    public ParseException newPermanentException(int i, String str) {
        ParseRequestException parseRequestException = new ParseRequestException(i, str);
        parseRequestException.isPermanentFailure = true;
        return parseRequestException;
    }

    /* access modifiers changed from: protected */
    public ParseHttpRequest newRequest(ParseHttpRequest.Method method2, String str, ProgressCallback progressCallback) {
        ParseHttpRequest.Builder url2 = new ParseHttpRequest.Builder().setMethod(method2).setUrl(str);
        switch (method2) {
            case GET:
            case DELETE:
                break;
            case POST:
            case PUT:
                url2.setBody(newBody(progressCallback));
                break;
            default:
                throw new IllegalStateException("Invalid method " + method2);
        }
        return url2.build();
    }

    /* access modifiers changed from: protected */
    public ParseException newTemporaryException(int i, String str) {
        ParseRequestException parseRequestException = new ParseRequestException(i, str);
        parseRequestException.isPermanentFailure = false;
        return parseRequestException;
    }

    /* access modifiers changed from: protected */
    public ParseException newTemporaryException(String str, Throwable th) {
        ParseRequestException parseRequestException = new ParseRequestException(100, str, th);
        parseRequestException.isPermanentFailure = false;
        return parseRequestException;
    }

    /* access modifiers changed from: protected */
    public abstract Task<Response> onResponseAsync(ParseHttpResponse parseHttpResponse, ProgressCallback progressCallback);
}
