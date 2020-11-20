package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private Task<Void> tail;

    TaskQueue() {
    }

    private Task<Void> getTaskToAwait() {
        this.lock.lock();
        try {
            return (this.tail != null ? this.tail : Task.forResult(null)).continueWith(new Continuation<Void, Void>() {
                public Void then(Task<Void> task) {
                    return null;
                }
            });
        } finally {
            this.lock.unlock();
        }
    }

    static <T> Continuation<T, Task<T>> waitFor(final Task<Void> task) {
        return new Continuation<T, Task<T>>() {
            public Task<T> then(final Task<T> task) {
                return task.continueWithTask(new Continuation<Void, Task<T>>() {
                    public Task<T> then(Task<Void> task) {
                        return task;
                    }
                });
            }
        };
    }

    /* access modifiers changed from: package-private */
    public <T> Task<T> enqueue(Continuation<Void, Task<T>> continuation) {
        this.lock.lock();
        try {
            Task<Void> forResult = this.tail != null ? this.tail : Task.forResult(null);
            Task<T> then = continuation.then(getTaskToAwait());
            this.tail = Task.whenAll(Arrays.asList(new Task[]{forResult, then}));
            this.lock.unlock();
            return then;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public Lock getLock() {
        return this.lock;
    }

    /* access modifiers changed from: package-private */
    public void waitUntilFinished() {
        this.lock.lock();
        try {
            if (this.tail != null) {
                this.tail.waitForCompletion();
                this.lock.unlock();
            }
        } finally {
            this.lock.unlock();
        }
    }
}
