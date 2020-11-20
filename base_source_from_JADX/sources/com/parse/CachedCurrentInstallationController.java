package com.parse;

import bolts.Continuation;
import bolts.Task;

class CachedCurrentInstallationController implements ParseCurrentInstallationController {
    static final String TAG = "com.parse.CachedCurrentInstallationController";
    ParseInstallation currentInstallation;
    /* access modifiers changed from: private */
    public final InstallationId installationId;
    /* access modifiers changed from: private */
    public final Object mutex = new Object();
    /* access modifiers changed from: private */
    public final ParseObjectStore<ParseInstallation> store;
    private final TaskQueue taskQueue = new TaskQueue();

    public CachedCurrentInstallationController(ParseObjectStore<ParseInstallation> parseObjectStore, InstallationId installationId2) {
        this.store = parseObjectStore;
        this.installationId = installationId2;
    }

    public void clearFromDisk() {
        synchronized (this.mutex) {
            this.currentInstallation = null;
        }
        try {
            this.installationId.clear();
            ParseTaskUtils.wait(this.store.deleteAsync());
        } catch (ParseException unused) {
        }
    }

    public void clearFromMemory() {
        synchronized (this.mutex) {
            this.currentInstallation = null;
        }
    }

    public Task<Boolean> existsAsync() {
        synchronized (this.mutex) {
            if (this.currentInstallation == null) {
                return this.taskQueue.enqueue(new Continuation<Void, Task<Boolean>>() {
                    public Task<Boolean> then(Task<Void> task) {
                        return task.continueWithTask(new Continuation<Void, Task<Boolean>>() {
                            public Task<Boolean> then(Task<Void> task) {
                                return CachedCurrentInstallationController.this.store.existsAsync();
                            }
                        });
                    }
                });
            }
            Task<Boolean> forResult = Task.forResult(true);
            return forResult;
        }
    }

    public Task<ParseInstallation> getAsync() {
        synchronized (this.mutex) {
            if (this.currentInstallation == null) {
                return this.taskQueue.enqueue(new Continuation<Void, Task<ParseInstallation>>() {
                    public Task<ParseInstallation> then(Task<Void> task) {
                        return task.continueWithTask(new Continuation<Void, Task<ParseInstallation>>() {
                            public Task<ParseInstallation> then(Task<Void> task) {
                                synchronized (CachedCurrentInstallationController.this.mutex) {
                                    if (CachedCurrentInstallationController.this.currentInstallation == null) {
                                        return CachedCurrentInstallationController.this.store.getAsync().continueWith(new Continuation<ParseInstallation, ParseInstallation>() {
                                            public ParseInstallation then(Task<ParseInstallation> task) {
                                                ParseInstallation result = task.getResult();
                                                if (result == null) {
                                                    result = (ParseInstallation) ParseObject.create(ParseInstallation.class);
                                                    result.updateDeviceInfo(CachedCurrentInstallationController.this.installationId);
                                                } else {
                                                    CachedCurrentInstallationController.this.installationId.set(result.getInstallationId());
                                                    PLog.m8820v(CachedCurrentInstallationController.TAG, "Successfully deserialized Installation object");
                                                }
                                                synchronized (CachedCurrentInstallationController.this.mutex) {
                                                    CachedCurrentInstallationController.this.currentInstallation = result;
                                                }
                                                return result;
                                            }
                                        }, ParseExecutors.m8824io());
                                    }
                                    Task<ParseInstallation> forResult = Task.forResult(CachedCurrentInstallationController.this.currentInstallation);
                                    return forResult;
                                }
                            }
                        });
                    }
                });
            }
            Task<ParseInstallation> forResult = Task.forResult(this.currentInstallation);
            return forResult;
        }
    }

    public boolean isCurrent(ParseInstallation parseInstallation) {
        boolean z;
        synchronized (this.mutex) {
            z = this.currentInstallation == parseInstallation;
        }
        return z;
    }

    public Task<Void> setAsync(final ParseInstallation parseInstallation) {
        return !isCurrent(parseInstallation) ? Task.forResult(null) : this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return task.continueWithTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return CachedCurrentInstallationController.this.store.setAsync(parseInstallation);
                    }
                }).continueWithTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        CachedCurrentInstallationController.this.installationId.set(parseInstallation.getInstallationId());
                        return task;
                    }
                }, ParseExecutors.m8824io());
            }
        });
    }
}
