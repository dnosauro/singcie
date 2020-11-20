package com.parse;

import bolts.AggregateException;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import java.util.concurrent.CancellationException;

class ParseTaskUtils {
    ParseTaskUtils() {
    }

    static Task<Void> callbackOnMainThreadAsync(Task<Void> task, ParseCallback1<ParseException> parseCallback1) {
        return callbackOnMainThreadAsync(task, parseCallback1, false);
    }

    static Task<Void> callbackOnMainThreadAsync(Task<Void> task, final ParseCallback1<ParseException> parseCallback1, boolean z) {
        return parseCallback1 == null ? task : callbackOnMainThreadAsync(task, new ParseCallback2<Void, ParseException>() {
            public void done(Void voidR, ParseException parseException) {
                parseCallback1.done(parseException);
            }
        }, z);
    }

    static <T> Task<T> callbackOnMainThreadAsync(Task<T> task, ParseCallback2<T, ParseException> parseCallback2) {
        return callbackOnMainThreadAsync(task, parseCallback2, false);
    }

    static <T> Task<T> callbackOnMainThreadAsync(Task<T> task, final ParseCallback2<T, ParseException> parseCallback2, final boolean z) {
        if (parseCallback2 == null) {
            return task;
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        task.continueWith(new Continuation<T, Void>() {
            public Void then(final Task<T> task) {
                if (!task.isCancelled() || z) {
                    ParseExecutors.main().execute(new Runnable() {
                        public void run() {
                            try {
                                Exception error = task.getError();
                                if (error != null && !(error instanceof ParseException)) {
                                    error = new ParseException(error);
                                }
                                parseCallback2.done(task.getResult(), (ParseException) error);
                                if (task.isCancelled()) {
                                    taskCompletionSource.setCancelled();
                                } else if (task.isFaulted()) {
                                    taskCompletionSource.setError(task.getError());
                                } else {
                                    taskCompletionSource.setResult(task.getResult());
                                }
                            } catch (Throwable th) {
                                if (task.isCancelled()) {
                                    taskCompletionSource.setCancelled();
                                } else if (task.isFaulted()) {
                                    taskCompletionSource.setError(task.getError());
                                } else {
                                    taskCompletionSource.setResult(task.getResult());
                                }
                                throw th;
                            }
                        }
                    });
                    return null;
                }
                taskCompletionSource.setCancelled();
                return null;
            }
        });
        return taskCompletionSource.getTask();
    }

    static <T> T wait(Task<T> task) {
        try {
            task.waitForCompletion();
            if (task.isFaulted()) {
                Exception error = task.getError();
                if (error instanceof ParseException) {
                    throw ((ParseException) error);
                } else if (error instanceof AggregateException) {
                    throw new ParseException(error);
                } else if (error instanceof RuntimeException) {
                    throw ((RuntimeException) error);
                } else {
                    throw new RuntimeException(error);
                }
            } else if (!task.isCancelled()) {
                return task.getResult();
            } else {
                throw new RuntimeException(new CancellationException());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
