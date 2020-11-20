package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseObject;
import java.util.Arrays;
import java.util.List;

class OfflineObjectStore<T extends ParseObject> implements ParseObjectStore<T> {
    private final String className;
    /* access modifiers changed from: private */
    public final ParseObjectStore<T> legacy;
    /* access modifiers changed from: private */
    public final String pinName;

    public OfflineObjectStore(Class<T> cls, String str, ParseObjectStore<T> parseObjectStore) {
        this(getSubclassingController().getClassName(cls), str, parseObjectStore);
    }

    public OfflineObjectStore(String str, String str2, ParseObjectStore<T> parseObjectStore) {
        this.className = str;
        this.pinName = str2;
        this.legacy = parseObjectStore;
    }

    private static ParseObjectSubclassingController getSubclassingController() {
        return ParseCorePlugins.getInstance().getSubclassingController();
    }

    /* access modifiers changed from: private */
    public static <T extends ParseObject> Task<T> migrate(final ParseObjectStore<T> parseObjectStore, final ParseObjectStore<T> parseObjectStore2) {
        return parseObjectStore.getAsync().onSuccessTask(new Continuation<T, Task<T>>() {
            public Task<T> then(Task<T> task) {
                final ParseObject parseObject = (ParseObject) task.getResult();
                if (parseObject == null) {
                    return task;
                }
                return Task.whenAll(Arrays.asList(new Task[]{parseObjectStore.deleteAsync(), parseObjectStore2.setAsync(parseObject)})).continueWith(new Continuation<Void, T>() {
                    public T then(Task<Void> task) {
                        return parseObject;
                    }
                });
            }
        });
    }

    public Task<Void> deleteAsync() {
        final Task<Void> unpinAllInBackground = ParseObject.unpinAllInBackground(this.pinName);
        return Task.whenAll(Arrays.asList(new Task[]{this.legacy.deleteAsync(), unpinAllInBackground})).continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return unpinAllInBackground;
            }
        });
    }

    public Task<Boolean> existsAsync() {
        return ParseQuery.getQuery(this.className).fromPin(this.pinName).ignoreACLs().countInBackground().onSuccessTask(new Continuation<Integer, Task<Boolean>>() {
            public Task<Boolean> then(Task<Integer> task) {
                return task.getResult().intValue() == 1 ? Task.forResult(true) : OfflineObjectStore.this.legacy.existsAsync();
            }
        });
    }

    public Task<T> getAsync() {
        return ParseQuery.getQuery(this.className).fromPin(this.pinName).ignoreACLs().findInBackground().onSuccessTask(new Continuation<List<T>, Task<T>>() {
            public Task<T> then(Task<List<T>> task) {
                List result = task.getResult();
                return result != null ? result.size() == 1 ? Task.forResult(result.get(0)) : ParseObject.unpinAllInBackground(OfflineObjectStore.this.pinName).cast() : Task.forResult(null);
            }
        }).onSuccessTask(new Continuation<T, Task<T>>() {
            public Task<T> then(Task<T> task) {
                return ((ParseObject) task.getResult()) != null ? task : OfflineObjectStore.migrate(OfflineObjectStore.this.legacy, OfflineObjectStore.this).cast();
            }
        });
    }

    public Task<Void> setAsync(final T t) {
        return ParseObject.unpinAllInBackground(this.pinName).continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return t.pinInBackground(OfflineObjectStore.this.pinName, false);
            }
        });
    }
}
