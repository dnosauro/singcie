package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Arrays;
import java.util.Map;

class CachedCurrentUserController implements ParseCurrentUserController {
    ParseUser currentUser;
    boolean currentUserMatchesDisk = false;
    /* access modifiers changed from: private */
    public final Object mutex = new Object();
    /* access modifiers changed from: private */
    public final ParseObjectStore<ParseUser> store;
    private final TaskQueue taskQueue = new TaskQueue();

    public CachedCurrentUserController(ParseObjectStore<ParseUser> parseObjectStore) {
        this.store = parseObjectStore;
    }

    /* access modifiers changed from: private */
    public ParseUser lazyLogIn() {
        return lazyLogIn("anonymous", ParseAnonymousUtils.getAuthData());
    }

    public void clearFromDisk() {
        synchronized (this.mutex) {
            this.currentUser = null;
            this.currentUserMatchesDisk = false;
        }
        try {
            ParseTaskUtils.wait(this.store.deleteAsync());
        } catch (ParseException unused) {
        }
    }

    public void clearFromMemory() {
        synchronized (this.mutex) {
            this.currentUser = null;
            this.currentUserMatchesDisk = false;
        }
    }

    public Task<Boolean> existsAsync() {
        synchronized (this.mutex) {
            if (this.currentUser == null) {
                return this.taskQueue.enqueue(new Continuation<Void, Task<Boolean>>() {
                    public Task<Boolean> then(Task<Void> task) {
                        return task.continueWithTask(new Continuation<Void, Task<Boolean>>() {
                            public Task<Boolean> then(Task<Void> task) {
                                return CachedCurrentUserController.this.store.existsAsync();
                            }
                        });
                    }
                });
            }
            Task<Boolean> forResult = Task.forResult(true);
            return forResult;
        }
    }

    public Task<ParseUser> getAsync() {
        return getAsync(ParseUser.isAutomaticUserEnabled());
    }

    public Task<ParseUser> getAsync(final boolean z) {
        synchronized (this.mutex) {
            if (this.currentUser == null) {
                return this.taskQueue.enqueue(new Continuation<Void, Task<ParseUser>>() {
                    public Task<ParseUser> then(Task<Void> task) {
                        return task.continueWithTask(new Continuation<Void, Task<ParseUser>>() {
                            public Task<ParseUser> then(Task<Void> task) {
                                ParseUser parseUser;
                                boolean z;
                                synchronized (CachedCurrentUserController.this.mutex) {
                                    parseUser = CachedCurrentUserController.this.currentUser;
                                    z = CachedCurrentUserController.this.currentUserMatchesDisk;
                                }
                                if (parseUser != null) {
                                    return Task.forResult(parseUser);
                                }
                                if (!z) {
                                    return CachedCurrentUserController.this.store.getAsync().continueWith(new Continuation<ParseUser, ParseUser>() {
                                        public ParseUser then(Task<ParseUser> task) {
                                            ParseUser result = task.getResult();
                                            boolean z = !task.isFaulted();
                                            synchronized (CachedCurrentUserController.this.mutex) {
                                                CachedCurrentUserController.this.currentUser = result;
                                                CachedCurrentUserController.this.currentUserMatchesDisk = z;
                                            }
                                            if (result != null) {
                                                synchronized (result.mutex) {
                                                    result.setIsCurrentUser(true);
                                                }
                                                return result;
                                            } else if (z) {
                                                return CachedCurrentUserController.this.lazyLogIn();
                                            } else {
                                                return null;
                                            }
                                        }
                                    });
                                }
                                if (z) {
                                    return Task.forResult(CachedCurrentUserController.this.lazyLogIn());
                                }
                                return null;
                            }
                        });
                    }
                });
            }
            Task<ParseUser> forResult = Task.forResult(this.currentUser);
            return forResult;
        }
    }

    public Task<String> getCurrentSessionTokenAsync() {
        return getAsync(false).onSuccess(new Continuation<ParseUser, String>() {
            public String then(Task<ParseUser> task) {
                ParseUser result = task.getResult();
                if (result != null) {
                    return result.getSessionToken();
                }
                return null;
            }
        });
    }

    public boolean isCurrent(ParseUser parseUser) {
        boolean z;
        synchronized (this.mutex) {
            z = this.currentUser == parseUser;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public ParseUser lazyLogIn(String str, Map<String, String> map) {
        ParseUser parseUser = (ParseUser) ParseObject.create(ParseUser.class);
        synchronized (parseUser.mutex) {
            parseUser.setIsCurrentUser(true);
            parseUser.putAuthData(str, map);
        }
        synchronized (this.mutex) {
            this.currentUserMatchesDisk = false;
            this.currentUser = parseUser;
        }
        return parseUser;
    }

    public Task<Void> logOutAsync() {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                final Task<ParseUser> async = CachedCurrentUserController.this.getAsync(false);
                return Task.whenAll(Arrays.asList(new Task[]{async, task})).continueWithTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return Task.whenAll(Arrays.asList(new Task[]{async.onSuccessTask(new Continuation<ParseUser, Task<Void>>() {
                            public Task<Void> then(Task<ParseUser> task) {
                                ParseUser result = task.getResult();
                                return result == null ? task.cast() : result.logOutAsync();
                            }
                        }), CachedCurrentUserController.this.store.deleteAsync().continueWith(new Continuation<Void, Void>() {
                            public Void then(Task<Void> task) {
                                boolean z = !task.isFaulted();
                                synchronized (CachedCurrentUserController.this.mutex) {
                                    CachedCurrentUserController.this.currentUserMatchesDisk = z;
                                    CachedCurrentUserController.this.currentUser = null;
                                }
                                return null;
                            }
                        })}));
                    }
                });
            }
        });
    }

    public Task<Void> setAsync(final ParseUser parseUser) {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return task.continueWithTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        ParseUser parseUser;
                        synchronized (CachedCurrentUserController.this.mutex) {
                            parseUser = CachedCurrentUserController.this.currentUser;
                        }
                        return (parseUser == null || parseUser == parseUser) ? task : parseUser.logOutAsync(false).continueWith(new Continuation<Void, Void>() {
                            public Void then(Task<Void> task) {
                                return null;
                            }
                        });
                    }
                }).onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        parseUser.setIsCurrentUser(true);
                        return parseUser.synchronizeAllAuthDataAsync();
                    }
                }).onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return CachedCurrentUserController.this.store.setAsync(parseUser).continueWith(new Continuation<Void, Void>() {
                            public Void then(Task<Void> task) {
                                synchronized (CachedCurrentUserController.this.mutex) {
                                    CachedCurrentUserController.this.currentUserMatchesDisk = !task.isFaulted();
                                    CachedCurrentUserController.this.currentUser = parseUser;
                                }
                                return null;
                            }
                        });
                    }
                });
            }
        });
    }

    public Task<Void> setIfNeededAsync(ParseUser parseUser) {
        synchronized (this.mutex) {
            if (parseUser.isCurrentUser()) {
                if (!this.currentUserMatchesDisk) {
                    return setAsync(parseUser);
                }
            }
            Task<Void> forResult = Task.forResult(null);
            return forResult;
        }
    }
}
