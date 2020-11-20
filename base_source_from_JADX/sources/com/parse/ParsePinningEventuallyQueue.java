package com.parse;

import android.content.Context;
import android.content.Intent;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.ConnectivityNotifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

class ParsePinningEventuallyQueue extends ParseEventuallyQueue {
    private static final String TAG = "ParsePinningEventuallyQueue";
    private final Object connectionLock = new Object();
    private TaskCompletionSource<Void> connectionTaskCompletionSource = new TaskCompletionSource<>();
    /* access modifiers changed from: private */
    public ArrayList<String> eventuallyPinUUIDQueue = new ArrayList<>();
    /* access modifiers changed from: private */
    public final ParseHttpClient httpClient;
    private ConnectivityNotifier.ConnectivityListener listener = new ConnectivityNotifier.ConnectivityListener() {
        public void networkConnectivityStatusChanged(Context context, Intent intent) {
            if (intent.getBooleanExtra("noConnectivity", false)) {
                ParsePinningEventuallyQueue.this.setConnected(false);
            } else {
                ParsePinningEventuallyQueue.this.setConnected(ConnectivityNotifier.isConnected(context));
            }
        }
    };
    private ConnectivityNotifier notifier;
    private TaskQueue operationSetTaskQueue = new TaskQueue();
    /* access modifiers changed from: private */
    public HashMap<String, TaskCompletionSource<JSONObject>> pendingEventuallyTasks = new HashMap<>();
    /* access modifiers changed from: private */
    public HashMap<String, TaskCompletionSource<JSONObject>> pendingOperationSetUUIDTasks = new HashMap<>();
    private TaskQueue taskQueue = new TaskQueue();
    /* access modifiers changed from: private */
    public final Object taskQueueSyncLock = new Object();
    /* access modifiers changed from: private */
    public HashMap<String, EventuallyPin> uuidToEventuallyPin = new HashMap<>();
    /* access modifiers changed from: private */
    public HashMap<String, ParseOperationSet> uuidToOperationSet = new HashMap<>();

    private static class PauseException extends Exception {
        private PauseException() {
        }
    }

    public ParsePinningEventuallyQueue(Context context, ParseHttpClient parseHttpClient) {
        setConnected(ConnectivityNotifier.isConnected(context));
        this.httpClient = parseHttpClient;
        this.notifier = ConnectivityNotifier.getNotifier(context);
        this.notifier.addListener(this.listener);
        resume();
    }

    /* access modifiers changed from: private */
    public Task<Void> enqueueEventuallyAsync(final ParseRESTCommand parseRESTCommand, final ParseObject parseObject, Task<Void> task, final TaskCompletionSource<JSONObject> taskCompletionSource) {
        return task.continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return EventuallyPin.pinEventuallyCommand(parseObject, parseRESTCommand).continueWithTask(new Continuation<EventuallyPin, Task<Void>>() {
                    public Task<Void> then(Task<EventuallyPin> task) {
                        EventuallyPin result = task.getResult();
                        Exception error = task.getError();
                        if (error != null) {
                            if (5 >= Parse.getLogLevel()) {
                                PLog.m8823w(ParsePinningEventuallyQueue.TAG, "Unable to save command for later.", error);
                            }
                            ParsePinningEventuallyQueue.this.notifyTestHelper(4);
                            return Task.forResult(null);
                        }
                        ParsePinningEventuallyQueue.this.pendingOperationSetUUIDTasks.put(result.getUUID(), taskCompletionSource);
                        ParsePinningEventuallyQueue.this.populateQueueAsync().continueWithTask(new Continuation<Void, Task<Void>>() {
                            public Task<Void> then(Task<Void> task) {
                                ParsePinningEventuallyQueue.this.notifyTestHelper(3);
                                return task;
                            }
                        });
                        return task.makeVoid();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> populateQueueAsync() {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParsePinningEventuallyQueue.this.populateQueueAsync(task);
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> populateQueueAsync(Task<Void> task) {
        return task.continueWithTask(new Continuation<Void, Task<List<EventuallyPin>>>() {
            public Task<List<EventuallyPin>> then(Task<Void> task) {
                return EventuallyPin.findAllPinned(ParsePinningEventuallyQueue.this.eventuallyPinUUIDQueue);
            }
        }).onSuccessTask(new Continuation<List<EventuallyPin>, Task<Void>>() {
            public Task<Void> then(Task<List<EventuallyPin>> task) {
                for (EventuallyPin access$500 : task.getResult()) {
                    Task unused = ParsePinningEventuallyQueue.this.runEventuallyAsync(access$500);
                }
                return task.makeVoid();
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<JSONObject> process(final EventuallyPin eventuallyPin, final ParseOperationSet parseOperationSet) {
        return waitForConnectionAsync().onSuccessTask(new Continuation<Void, Task<JSONObject>>() {
            public Task<JSONObject> then(Task<Void> task) {
                Task<JSONObject> task2;
                final int type = eventuallyPin.getType();
                final ParseObject object = eventuallyPin.getObject();
                String sessionToken = eventuallyPin.getSessionToken();
                if (type == 1) {
                    task2 = object.saveAsync(ParsePinningEventuallyQueue.this.httpClient, parseOperationSet, sessionToken);
                } else if (type == 2) {
                    task2 = object.deleteAsync(sessionToken).cast();
                } else {
                    ParseRESTCommand command = eventuallyPin.getCommand();
                    if (command == null) {
                        task2 = Task.forResult(null);
                        ParsePinningEventuallyQueue.this.notifyTestHelper(8);
                    } else {
                        task2 = command.executeAsync(ParsePinningEventuallyQueue.this.httpClient);
                    }
                }
                return task2.continueWithTask(new Continuation<JSONObject, Task<JSONObject>>() {
                    public Task<JSONObject> then(final Task<JSONObject> task) {
                        Exception error = task.getError();
                        if (error == null || !(error instanceof ParseException) || ((ParseException) error).getCode() != 100) {
                            return eventuallyPin.unpinInBackground(EventuallyPin.PIN_NAME).continueWithTask(new Continuation<Void, Task<Void>>() {
                                public Task<Void> then(Task<Void> task) {
                                    return type == 1 ? object.handleSaveEventuallyResultAsync((JSONObject) task.getResult(), parseOperationSet) : (type != 2 || task.isFaulted()) ? task : object.handleDeleteEventuallyResultAsync();
                                }
                            }).continueWithTask(new Continuation<Void, Task<JSONObject>>() {
                                public Task<JSONObject> then(Task<Void> task) {
                                    return task;
                                }
                            });
                        }
                        ParsePinningEventuallyQueue.this.setConnected(false);
                        ParsePinningEventuallyQueue.this.notifyTestHelper(7);
                        return ParsePinningEventuallyQueue.this.process(eventuallyPin, parseOperationSet);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> runEventuallyAsync(final EventuallyPin eventuallyPin) {
        final String uuid = eventuallyPin.getUUID();
        if (this.eventuallyPinUUIDQueue.contains(uuid)) {
            return Task.forResult(null);
        }
        this.eventuallyPinUUIDQueue.add(uuid);
        this.operationSetTaskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParsePinningEventuallyQueue.this.runEventuallyAsync(eventuallyPin, task).continueWithTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        ParsePinningEventuallyQueue.this.eventuallyPinUUIDQueue.remove(uuid);
                        return task;
                    }
                });
            }
        });
        return Task.forResult(null);
    }

    /* access modifiers changed from: private */
    public Task<Void> runEventuallyAsync(final EventuallyPin eventuallyPin, Task<Void> task) {
        return task.continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParsePinningEventuallyQueue.this.waitForConnectionAsync();
            }
        }).onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParsePinningEventuallyQueue.this.waitForOperationSetAndEventuallyPin((ParseOperationSet) null, eventuallyPin).continueWithTask(new Continuation<JSONObject, Task<Void>>() {
                    public Task<Void> then(Task<JSONObject> task) {
                        Exception error = task.getError();
                        if (error == null) {
                            ParsePinningEventuallyQueue.this.notifyTestHelper(1);
                        } else if (error instanceof PauseException) {
                            return task.makeVoid();
                        } else {
                            if (6 >= Parse.getLogLevel()) {
                                PLog.m8817e(ParsePinningEventuallyQueue.TAG, "Failed to run command.", error);
                            }
                            ParsePinningEventuallyQueue.this.notifyTestHelper(2, error);
                        }
                        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) ParsePinningEventuallyQueue.this.pendingOperationSetUUIDTasks.remove(eventuallyPin.getUUID());
                        if (taskCompletionSource != null) {
                            if (error != null) {
                                taskCompletionSource.setError(error);
                            } else {
                                taskCompletionSource.setResult(task.getResult());
                            }
                        }
                        return task.makeVoid();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> waitForConnectionAsync() {
        Task<Void> task;
        synchronized (this.connectionLock) {
            task = this.connectionTaskCompletionSource.getTask();
        }
        return task;
    }

    private Task<Void> whenAll(Collection<TaskQueue> collection) {
        ArrayList arrayList = new ArrayList();
        for (TaskQueue enqueue : collection) {
            arrayList.add(enqueue.enqueue(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return task;
                }
            }));
        }
        return Task.whenAll(arrayList);
    }

    public void clear() {
        pause();
        try {
            ParseTaskUtils.wait(this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return task.continueWithTask(new Continuation<Void, Task<Void>>() {
                        public Task<Void> then(Task<Void> task) {
                            return EventuallyPin.findAllPinned().onSuccessTask(new Continuation<List<EventuallyPin>, Task<Void>>() {
                                public Task<Void> then(Task<List<EventuallyPin>> task) {
                                    ArrayList arrayList = new ArrayList();
                                    for (EventuallyPin unpinInBackground : task.getResult()) {
                                        arrayList.add(unpinInBackground.unpinInBackground(EventuallyPin.PIN_NAME));
                                    }
                                    return Task.whenAll(arrayList);
                                }
                            });
                        }
                    });
                }
            }));
            simulateReboot();
            resume();
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }
    }

    public Task<JSONObject> enqueueEventuallyAsync(final ParseRESTCommand parseRESTCommand, final ParseObject parseObject) {
        Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParsePinningEventuallyQueue.this.enqueueEventuallyAsync(parseRESTCommand, parseObject, task, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void onDestroy() {
        this.notifier.removeListener(this.listener);
    }

    public void pause() {
        synchronized (this.connectionLock) {
            this.connectionTaskCompletionSource.trySetError(new PauseException());
            this.connectionTaskCompletionSource = new TaskCompletionSource<>();
            this.connectionTaskCompletionSource.trySetError(new PauseException());
        }
        synchronized (this.taskQueueSyncLock) {
            for (String str : this.pendingEventuallyTasks.keySet()) {
                this.pendingEventuallyTasks.get(str).trySetError(new PauseException());
            }
            this.pendingEventuallyTasks.clear();
            this.uuidToOperationSet.clear();
            this.uuidToEventuallyPin.clear();
        }
        try {
            ParseTaskUtils.wait(whenAll(Arrays.asList(new TaskQueue[]{this.taskQueue, this.operationSetTaskQueue})));
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }
    }

    public int pendingCount() {
        try {
            return ((Integer) ParseTaskUtils.wait(pendingCountAsync())).intValue();
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }
    }

    public Task<Integer> pendingCountAsync() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParsePinningEventuallyQueue.this.pendingCountAsync(task).continueWithTask(new Continuation<Integer, Task<Void>>() {
                    public Task<Void> then(Task<Integer> task) {
                        taskCompletionSource.setResult(Integer.valueOf(task.getResult().intValue()));
                        return Task.forResult(null);
                    }
                });
            }
        });
        return taskCompletionSource.getTask();
    }

    public Task<Integer> pendingCountAsync(Task<Void> task) {
        return task.continueWithTask(new Continuation<Void, Task<Integer>>() {
            public Task<Integer> then(Task<Void> task) {
                return EventuallyPin.findAllPinned().continueWithTask(new Continuation<List<EventuallyPin>, Task<Integer>>() {
                    public Task<Integer> then(Task<List<EventuallyPin>> task) {
                        return Task.forResult(Integer.valueOf(task.getResult().size()));
                    }
                });
            }
        });
    }

    public void resume() {
        if (isConnected()) {
            this.connectionTaskCompletionSource.trySetResult(null);
            this.connectionTaskCompletionSource = new TaskCompletionSource<>();
            this.connectionTaskCompletionSource.trySetResult(null);
        } else {
            this.connectionTaskCompletionSource = new TaskCompletionSource<>();
        }
        populateQueueAsync();
    }

    public void setConnected(boolean z) {
        synchronized (this.connectionLock) {
            if (isConnected() != z) {
                super.setConnected(z);
                if (z) {
                    this.connectionTaskCompletionSource.trySetResult(null);
                    this.connectionTaskCompletionSource = new TaskCompletionSource<>();
                    this.connectionTaskCompletionSource.trySetResult(null);
                } else {
                    this.connectionTaskCompletionSource = new TaskCompletionSource<>();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void simulateReboot() {
        pause();
        this.pendingOperationSetUUIDTasks.clear();
        this.pendingEventuallyTasks.clear();
        this.uuidToOperationSet.clear();
        this.uuidToEventuallyPin.clear();
        resume();
    }

    /* access modifiers changed from: package-private */
    public Task<JSONObject> waitForOperationSetAndEventuallyPin(ParseOperationSet parseOperationSet, EventuallyPin eventuallyPin) {
        final String str;
        TaskCompletionSource taskCompletionSource;
        if (eventuallyPin != null && eventuallyPin.getType() != 1) {
            return process(eventuallyPin, (ParseOperationSet) null);
        }
        synchronized (this.taskQueueSyncLock) {
            if (parseOperationSet != null && eventuallyPin == null) {
                String uuid = parseOperationSet.getUUID();
                this.uuidToOperationSet.put(uuid, parseOperationSet);
                str = uuid;
            } else if (parseOperationSet != null || eventuallyPin == null) {
                throw new IllegalStateException("Either operationSet or eventuallyPin must be set.");
            } else {
                str = eventuallyPin.getOperationSetUUID();
                this.uuidToEventuallyPin.put(str, eventuallyPin);
            }
            EventuallyPin eventuallyPin2 = this.uuidToEventuallyPin.get(str);
            ParseOperationSet parseOperationSet2 = this.uuidToOperationSet.get(str);
            if (eventuallyPin2 != null) {
                if (parseOperationSet2 != null) {
                    final TaskCompletionSource taskCompletionSource2 = this.pendingEventuallyTasks.get(str);
                    return process(eventuallyPin2, parseOperationSet2).continueWithTask(new Continuation<JSONObject, Task<JSONObject>>() {
                        public Task<JSONObject> then(Task<JSONObject> task) {
                            synchronized (ParsePinningEventuallyQueue.this.taskQueueSyncLock) {
                                ParsePinningEventuallyQueue.this.pendingEventuallyTasks.remove(str);
                                ParsePinningEventuallyQueue.this.uuidToOperationSet.remove(str);
                                ParsePinningEventuallyQueue.this.uuidToEventuallyPin.remove(str);
                            }
                            Exception error = task.getError();
                            if (error != null) {
                                taskCompletionSource2.trySetError(error);
                            } else if (task.isCancelled()) {
                                taskCompletionSource2.trySetCancelled();
                            } else {
                                taskCompletionSource2.trySetResult(task.getResult());
                            }
                            return taskCompletionSource2.getTask();
                        }
                    });
                }
            }
            if (this.pendingEventuallyTasks.containsKey(str)) {
                taskCompletionSource = this.pendingEventuallyTasks.get(str);
            } else {
                TaskCompletionSource taskCompletionSource3 = new TaskCompletionSource();
                this.pendingEventuallyTasks.put(str, taskCompletionSource3);
                taskCompletionSource = taskCompletionSource3;
            }
            Task<JSONObject> task = taskCompletionSource.getTask();
            return task;
        }
    }
}
