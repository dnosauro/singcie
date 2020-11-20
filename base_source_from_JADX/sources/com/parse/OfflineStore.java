package com.parse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.OfflineQueryLogic;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineStore {
    private static final int MAX_SQL_VARIABLES = 999;
    private final WeakValueHashMap<Pair<String, String>, ParseObject> classNameAndObjectIdToObjectMap;
    /* access modifiers changed from: private */
    public final WeakHashMap<ParseObject, Task<ParseObject>> fetchedObjects;
    /* access modifiers changed from: private */
    public final OfflineSQLiteOpenHelper helper;
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public final WeakHashMap<ParseObject, Task<String>> objectToUuidMap;
    /* access modifiers changed from: private */
    public final WeakValueHashMap<String, ParseObject> uuidToObjectMap;

    private class OfflineDecoder extends ParseDecoder {
        private Map<String, Task<ParseObject>> offlineObjects;

        private OfflineDecoder(Map<String, Task<ParseObject>> map) {
            this.offlineObjects = map;
        }

        public Object decode(Object obj) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.optString("__type").equals("OfflineObject")) {
                    return this.offlineObjects.get(jSONObject.optString("uuid")).getResult();
                }
            }
            return super.decode(obj);
        }
    }

    private class OfflineEncoder extends ParseEncoder {

        /* renamed from: db */
        private ParseSQLiteDatabase f7069db;
        /* access modifiers changed from: private */
        public ArrayList<Task<Void>> tasks = new ArrayList<>();
        /* access modifiers changed from: private */
        public final Object tasksLock = new Object();

        public OfflineEncoder(ParseSQLiteDatabase parseSQLiteDatabase) {
            this.f7069db = parseSQLiteDatabase;
        }

        public JSONObject encodeRelatedObject(ParseObject parseObject) {
            try {
                if (parseObject.getObjectId() != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("__type", "Pointer");
                    jSONObject.put(ParseObject.KEY_OBJECT_ID, parseObject.getObjectId());
                    jSONObject.put("className", parseObject.getClassName());
                    return jSONObject;
                }
                final JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("__type", "OfflineObject");
                synchronized (this.tasksLock) {
                    this.tasks.add(OfflineStore.this.getOrCreateUUIDAsync(parseObject, this.f7069db).onSuccess(new Continuation<String, Void>() {
                        public Void then(Task<String> task) {
                            jSONObject2.put("uuid", task.getResult());
                            return null;
                        }
                    }));
                }
                return jSONObject2;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public Task<Void> whenFinished() {
            return Task.whenAll(this.tasks).continueWithTask(new Continuation<Void, Task<Void>>() {
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
                    return r1;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:6:0x0017  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public bolts.Task<java.lang.Void> then(bolts.Task<java.lang.Void> r4) {
                    /*
                        r3 = this;
                        com.parse.OfflineStore$OfflineEncoder r4 = com.parse.OfflineStore.OfflineEncoder.this
                        java.lang.Object r4 = r4.tasksLock
                        monitor-enter(r4)
                        com.parse.OfflineStore$OfflineEncoder r0 = com.parse.OfflineStore.OfflineEncoder.this     // Catch:{ all -> 0x003b }
                        java.util.ArrayList r0 = r0.tasks     // Catch:{ all -> 0x003b }
                        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003b }
                    L_0x0011:
                        boolean r1 = r0.hasNext()     // Catch:{ all -> 0x003b }
                        if (r1 == 0) goto L_0x002b
                        java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x003b }
                        bolts.Task r1 = (bolts.Task) r1     // Catch:{ all -> 0x003b }
                        boolean r2 = r1.isFaulted()     // Catch:{ all -> 0x003b }
                        if (r2 != 0) goto L_0x0029
                        boolean r2 = r1.isCancelled()     // Catch:{ all -> 0x003b }
                        if (r2 == 0) goto L_0x0011
                    L_0x0029:
                        monitor-exit(r4)     // Catch:{ all -> 0x003b }
                        return r1
                    L_0x002b:
                        com.parse.OfflineStore$OfflineEncoder r0 = com.parse.OfflineStore.OfflineEncoder.this     // Catch:{ all -> 0x003b }
                        java.util.ArrayList r0 = r0.tasks     // Catch:{ all -> 0x003b }
                        r0.clear()     // Catch:{ all -> 0x003b }
                        r0 = 0
                        bolts.Task r0 = bolts.Task.forResult(r0)     // Catch:{ all -> 0x003b }
                        monitor-exit(r4)     // Catch:{ all -> 0x003b }
                        return r0
                    L_0x003b:
                        r0 = move-exception
                        monitor-exit(r4)     // Catch:{ all -> 0x003b }
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.parse.OfflineStore.OfflineEncoder.C27641.then(bolts.Task):bolts.Task");
                }
            });
        }
    }

    private interface SQLiteDatabaseCallable<T> {
        T call(ParseSQLiteDatabase parseSQLiteDatabase);
    }

    OfflineStore(Context context) {
        this(new OfflineSQLiteOpenHelper(context));
    }

    OfflineStore(OfflineSQLiteOpenHelper offlineSQLiteOpenHelper) {
        this.lock = new Object();
        this.uuidToObjectMap = new WeakValueHashMap<>();
        this.objectToUuidMap = new WeakHashMap<>();
        this.fetchedObjects = new WeakHashMap<>();
        this.classNameAndObjectIdToObjectMap = new WeakValueHashMap<>();
        this.helper = offlineSQLiteOpenHelper;
    }

    /* access modifiers changed from: private */
    public <T extends ParseObject> Task<Integer> countFromPinAsync(String str, final ParseQuery.State<T> state, final ParseUser parseUser, final ParseSQLiteDatabase parseSQLiteDatabase) {
        return (str != null ? getParsePin(str, parseSQLiteDatabase) : Task.forResult(null)).onSuccessTask(new Continuation<ParsePin, Task<Integer>>() {
            public Task<Integer> then(Task<ParsePin> task) {
                return OfflineStore.this.findAsync(state, parseUser, task.getResult(), true, parseSQLiteDatabase).onSuccess(new Continuation<List<T>, Integer>() {
                    public Integer then(Task<List<T>> task) {
                        return Integer.valueOf(task.getResult().size());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> deleteDataForObjectAsync(final ParseObject parseObject, final ParseSQLiteDatabase parseSQLiteDatabase) {
        final Capture capture = new Capture();
        synchronized (this.lock) {
            Task task = this.objectToUuidMap.get(parseObject);
            if (task != null) {
                return task.onSuccessTask(new Continuation<String, Task<String>>() {
                    public Task<String> then(Task<String> task) {
                        capture.set(task.getResult());
                        return task;
                    }
                }).onSuccessTask(new Continuation<String, Task<Cursor>>() {
                    public Task<Cursor> then(Task<String> task) {
                        String[] strArr = {(String) capture.get()};
                        return parseSQLiteDatabase.queryAsync("Dependencies", new String[]{"key"}, "uuid=?", strArr);
                    }
                }).onSuccessTask(new Continuation<Cursor, Task<Void>>() {
                    public Task<Void> then(Task<Cursor> task) {
                        Cursor result = task.getResult();
                        ArrayList<String> arrayList = new ArrayList<>();
                        result.moveToFirst();
                        while (!result.isAfterLast()) {
                            arrayList.add(result.getString(0));
                            result.moveToNext();
                        }
                        result.close();
                        ArrayList arrayList2 = new ArrayList();
                        for (final String str : arrayList) {
                            arrayList2.add(OfflineStore.this.getPointerAsync(str, parseSQLiteDatabase).onSuccessTask(new Continuation<ParseObject, Task<ParsePin>>() {
                                public Task<ParsePin> then(Task<ParseObject> task) {
                                    return OfflineStore.this.fetchLocallyAsync((ParsePin) task.getResult(), parseSQLiteDatabase);
                                }
                            }).continueWithTask(new Continuation<ParsePin, Task<Void>>() {
                                public Task<Void> then(Task<ParsePin> task) {
                                    ParsePin result = task.getResult();
                                    List<ParseObject> objects = result.getObjects();
                                    if (objects == null || !objects.contains(parseObject)) {
                                        return task.makeVoid();
                                    }
                                    objects.remove(parseObject);
                                    if (objects.size() == 0) {
                                        return OfflineStore.this.unpinAsync(str, parseSQLiteDatabase);
                                    }
                                    result.setObjects(objects);
                                    return OfflineStore.this.saveLocallyAsync((ParseObject) result, true, parseSQLiteDatabase);
                                }
                            }));
                        }
                        return Task.whenAll(arrayList2);
                    }
                }).onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return parseSQLiteDatabase.deleteAsync("Dependencies", "uuid=?", new String[]{(String) capture.get()});
                    }
                }).onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return parseSQLiteDatabase.deleteAsync("ParseObjects", "uuid=?", new String[]{(String) capture.get()});
                    }
                }).onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        synchronized (OfflineStore.this.lock) {
                            OfflineStore.this.fetchedObjects.remove(parseObject);
                        }
                        return task;
                    }
                });
            }
            Task<Void> forResult = Task.forResult(null);
            return forResult;
        }
    }

    /* access modifiers changed from: private */
    public Task<Void> deleteObjects(final List<String> list, final ParseSQLiteDatabase parseSQLiteDatabase) {
        if (list.size() <= 0) {
            return Task.forResult(null);
        }
        if (list.size() > MAX_SQL_VARIABLES) {
            return deleteObjects(list.subList(0, MAX_SQL_VARIABLES), parseSQLiteDatabase).onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    OfflineStore offlineStore = OfflineStore.this;
                    List list = list;
                    return offlineStore.deleteObjects(list.subList(OfflineStore.MAX_SQL_VARIABLES, list.size()), parseSQLiteDatabase);
                }
            });
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = "?";
        }
        return parseSQLiteDatabase.deleteAsync("ParseObjects", "uuid IN (" + TextUtils.join(",", strArr) + ")", (String[]) list.toArray(new String[list.size()]));
    }

    /* access modifiers changed from: private */
    public <T extends ParseObject> Task<List<T>> findAsync(final ParseQuery.State<T> state, ParseUser parseUser, ParsePin parsePin, boolean z, final ParseSQLiteDatabase parseSQLiteDatabase) {
        Task<Cursor> task;
        final OfflineQueryLogic offlineQueryLogic = new OfflineQueryLogic(this);
        ArrayList arrayList = new ArrayList();
        if (parsePin == null) {
            task = parseSQLiteDatabase.queryAsync("ParseObjects", new String[]{"uuid"}, "className=?" + " AND isDeletingEventually=0", new String[]{state.className()});
        } else {
            Task task2 = this.objectToUuidMap.get(parsePin);
            if (task2 == null) {
                return Task.forResult(arrayList);
            }
            task = task2.onSuccessTask(new Continuation<String, Task<Cursor>>() {
                public Task<Cursor> then(Task<String> task) {
                    return parseSQLiteDatabase.queryAsync("ParseObjects A  INNER JOIN Dependencies B  ON A.uuid=B.uuid", new String[]{"A.uuid"}, "className=? AND key=?" + " AND isDeletingEventually=0", new String[]{state.className(), task.getResult()});
                }
            });
        }
        final ParseQuery.State<T> state2 = state;
        final ParseUser parseUser2 = parseUser;
        final ParseSQLiteDatabase parseSQLiteDatabase2 = parseSQLiteDatabase;
        final ArrayList arrayList2 = arrayList;
        final ArrayList arrayList3 = arrayList;
        final ParseQuery.State<T> state3 = state;
        final boolean z2 = z;
        final ParseSQLiteDatabase parseSQLiteDatabase3 = parseSQLiteDatabase;
        return task.onSuccessTask(new Continuation<Cursor, Task<Void>>() {
            public Task<Void> then(Task<Cursor> task) {
                Cursor result = task.getResult();
                ArrayList<String> arrayList = new ArrayList<>();
                result.moveToFirst();
                while (!result.isAfterLast()) {
                    arrayList.add(result.getString(0));
                    result.moveToNext();
                }
                result.close();
                final OfflineQueryLogic.ConstraintMatcher createMatcher = offlineQueryLogic.createMatcher(state2, parseUser2);
                Task<TContinuationResult> forResult = Task.forResult(null);
                for (final String str : arrayList) {
                    final Capture capture = new Capture();
                    forResult = forResult.onSuccessTask(new Continuation<Void, Task<T>>() {
                        public Task<T> then(Task<Void> task) {
                            return OfflineStore.this.getPointerAsync(str, parseSQLiteDatabase2);
                        }
                    }).onSuccessTask(new Continuation<T, Task<T>>() {
                        public Task<T> then(Task<T> task) {
                            capture.set(task.getResult());
                            return OfflineStore.this.fetchLocallyAsync((ParseObject) capture.get(), parseSQLiteDatabase2);
                        }
                    }).onSuccessTask(new Continuation<T, Task<Boolean>>() {
                        public Task<Boolean> then(Task<T> task) {
                            return !((ParseObject) capture.get()).isDataAvailable() ? Task.forResult(false) : createMatcher.matchesAsync((ParseObject) capture.get(), parseSQLiteDatabase2);
                        }
                    }).onSuccess(new Continuation<Boolean, Void>() {
                        public Void then(Task<Boolean> task) {
                            if (!task.getResult().booleanValue()) {
                                return null;
                            }
                            arrayList2.add(capture.get());
                            return null;
                        }
                    });
                }
                return forResult;
            }
        }).onSuccessTask(new Continuation<Void, Task<List<T>>>() {
            public Task<List<T>> then(Task<Void> task) {
                OfflineQueryLogic.sort(arrayList3, state3);
                final List<ParseObject> list = arrayList3;
                int skip = state3.skip();
                if (!z2 && skip >= 0) {
                    list = list.subList(Math.min(state3.skip(), list.size()), list.size());
                }
                int limit = state3.limit();
                if (!z2 && limit >= 0 && list.size() > limit) {
                    list = list.subList(0, limit);
                }
                Task forResult = Task.forResult(null);
                for (final ParseObject parseObject : list) {
                    forResult = forResult.onSuccessTask(new Continuation<Void, Task<Void>>() {
                        public Task<Void> then(Task<Void> task) {
                            return OfflineQueryLogic.fetchIncludesAsync(OfflineStore.this, parseObject, state3, parseSQLiteDatabase3);
                        }
                    });
                }
                return forResult.onSuccess(new Continuation<Void, List<T>>() {
                    public List<T> then(Task<Void> task) {
                        return list;
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public <T extends ParseObject> Task<List<T>> findFromPinAsync(String str, final ParseQuery.State<T> state, final ParseUser parseUser, final ParseSQLiteDatabase parseSQLiteDatabase) {
        return (str != null ? getParsePin(str, parseSQLiteDatabase) : Task.forResult(null)).onSuccessTask(new Continuation<ParsePin, Task<List<T>>>() {
            public Task<List<T>> then(Task<ParsePin> task) {
                return OfflineStore.this.findAsync(state, parseUser, task.getResult(), false, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<String> getOrCreateUUIDAsync(final ParseObject parseObject, ParseSQLiteDatabase parseSQLiteDatabase) {
        final String uuid = UUID.randomUUID().toString();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.lock) {
            Task<String> task = this.objectToUuidMap.get(parseObject);
            if (task != null) {
                return task;
            }
            this.objectToUuidMap.put(parseObject, taskCompletionSource.getTask());
            this.uuidToObjectMap.put(uuid, parseObject);
            this.fetchedObjects.put(parseObject, taskCompletionSource.getTask().onSuccess(new Continuation<String, ParseObject>() {
                public ParseObject then(Task<String> task) {
                    return parseObject;
                }
            }));
            ContentValues contentValues = new ContentValues();
            contentValues.put("uuid", uuid);
            contentValues.put("className", parseObject.getClassName());
            parseSQLiteDatabase.insertOrThrowAsync("ParseObjects", contentValues).continueWith(new Continuation<Void, Void>() {
                public Void then(Task<Void> task) {
                    taskCompletionSource.setResult(uuid);
                    return null;
                }
            });
            return taskCompletionSource.getTask();
        }
    }

    private Task<ParsePin> getParsePin(final String str, ParseSQLiteDatabase parseSQLiteDatabase) {
        return findAsync(new ParseQuery.State.Builder(ParsePin.class).whereEqualTo("_name", str).build(), (ParseUser) null, (ParsePin) null, parseSQLiteDatabase).onSuccess(new Continuation<List<ParsePin>, ParsePin>() {
            public ParsePin then(Task<List<ParsePin>> task) {
                ParsePin parsePin = (task.getResult() == null || task.getResult().size() <= 0) ? null : (ParsePin) task.getResult().get(0);
                if (parsePin != null) {
                    return parsePin;
                }
                ParsePin parsePin2 = (ParsePin) ParseObject.create(ParsePin.class);
                parsePin2.setName(str);
                return parsePin2;
            }
        });
    }

    /* access modifiers changed from: private */
    public <T extends ParseObject> Task<T> getPointerAsync(final String str, ParseSQLiteDatabase parseSQLiteDatabase) {
        synchronized (this.lock) {
            ParseObject parseObject = this.uuidToObjectMap.get(str);
            if (parseObject != null) {
                Task<T> forResult = Task.forResult(parseObject);
                return forResult;
            }
            return parseSQLiteDatabase.queryAsync("ParseObjects", new String[]{"className", ParseObject.KEY_OBJECT_ID}, "uuid = ?", new String[]{str}).onSuccess(new Continuation<Cursor, T>() {
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
                    return r4;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public T then(bolts.Task<android.database.Cursor> r4) {
                    /*
                        r3 = this;
                        java.lang.Object r4 = r4.getResult()
                        android.database.Cursor r4 = (android.database.Cursor) r4
                        r4.moveToFirst()
                        boolean r0 = r4.isAfterLast()
                        if (r0 != 0) goto L_0x005a
                        com.parse.OfflineStore r0 = com.parse.OfflineStore.this
                        java.lang.Object r0 = r0.lock
                        monitor-enter(r0)
                        com.parse.OfflineStore r1 = com.parse.OfflineStore.this     // Catch:{ all -> 0x0057 }
                        com.parse.WeakValueHashMap r1 = r1.uuidToObjectMap     // Catch:{ all -> 0x0057 }
                        java.lang.String r2 = r5     // Catch:{ all -> 0x0057 }
                        java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0057 }
                        com.parse.ParseObject r1 = (com.parse.ParseObject) r1     // Catch:{ all -> 0x0057 }
                        if (r1 == 0) goto L_0x0028
                        monitor-exit(r0)     // Catch:{ all -> 0x0057 }
                        return r1
                    L_0x0028:
                        r1 = 0
                        java.lang.String r1 = r4.getString(r1)     // Catch:{ all -> 0x0057 }
                        r2 = 1
                        java.lang.String r2 = r4.getString(r2)     // Catch:{ all -> 0x0057 }
                        r4.close()     // Catch:{ all -> 0x0057 }
                        com.parse.ParseObject r4 = com.parse.ParseObject.createWithoutData((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0057 }
                        if (r2 != 0) goto L_0x0055
                        com.parse.OfflineStore r1 = com.parse.OfflineStore.this     // Catch:{ all -> 0x0057 }
                        com.parse.WeakValueHashMap r1 = r1.uuidToObjectMap     // Catch:{ all -> 0x0057 }
                        java.lang.String r2 = r5     // Catch:{ all -> 0x0057 }
                        r1.put(r2, r4)     // Catch:{ all -> 0x0057 }
                        com.parse.OfflineStore r1 = com.parse.OfflineStore.this     // Catch:{ all -> 0x0057 }
                        java.util.WeakHashMap r1 = r1.objectToUuidMap     // Catch:{ all -> 0x0057 }
                        java.lang.String r2 = r5     // Catch:{ all -> 0x0057 }
                        bolts.Task r2 = bolts.Task.forResult(r2)     // Catch:{ all -> 0x0057 }
                        r1.put(r4, r2)     // Catch:{ all -> 0x0057 }
                    L_0x0055:
                        monitor-exit(r0)     // Catch:{ all -> 0x0057 }
                        return r4
                    L_0x0057:
                        r4 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0057 }
                        throw r4
                    L_0x005a:
                        r4.close()
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "Attempted to find non-existent uuid "
                        r0.append(r1)
                        java.lang.String r1 = r5
                        r0.append(r1)
                        java.lang.String r0 = r0.toString()
                        r4.<init>(r0)
                        throw r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.parse.OfflineStore.C27253.then(bolts.Task):com.parse.ParseObject");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public <T extends ParseObject> Task<Void> pinAllObjectsAsync(String str, final List<T> list, final boolean z, final ParseSQLiteDatabase parseSQLiteDatabase) {
        return (list == null || list.size() == 0) ? Task.forResult(null) : getParsePin(str, parseSQLiteDatabase).onSuccessTask(new Continuation<ParsePin, Task<Void>>() {
            public Task<Void> then(Task<ParsePin> task) {
                ParsePin result = task.getResult();
                List objects = result.getObjects();
                if (objects == null) {
                    objects = new ArrayList(list);
                } else {
                    for (ParseObject parseObject : list) {
                        if (!objects.contains(parseObject)) {
                            objects.add(parseObject);
                        }
                    }
                }
                result.setObjects(objects);
                return z ? OfflineStore.this.saveLocallyAsync((ParseObject) result, true, parseSQLiteDatabase) : OfflineStore.this.saveLocallyAsync((ParseObject) result, result.getObjects(), parseSQLiteDatabase);
            }
        });
    }

    private <T> Task<T> runWithManagedConnection(final SQLiteDatabaseCallable<Task<T>> sQLiteDatabaseCallable) {
        return this.helper.getWritableDatabaseAsync().onSuccessTask(new Continuation<ParseSQLiteDatabase, Task<T>>() {
            public Task<T> then(Task<ParseSQLiteDatabase> task) {
                final ParseSQLiteDatabase result = task.getResult();
                return ((Task) sQLiteDatabaseCallable.call(result)).continueWithTask(new Continuation<T, Task<T>>() {
                    public Task<T> then(Task<T> task) {
                        result.closeAsync();
                        return task;
                    }
                });
            }
        });
    }

    private Task<Void> runWithManagedTransaction(final SQLiteDatabaseCallable<Task<Void>> sQLiteDatabaseCallable) {
        return this.helper.getWritableDatabaseAsync().onSuccessTask(new Continuation<ParseSQLiteDatabase, Task<Void>>() {
            public Task<Void> then(Task<ParseSQLiteDatabase> task) {
                final ParseSQLiteDatabase result = task.getResult();
                return result.beginTransactionAsync().onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return ((Task) sQLiteDatabaseCallable.call(result)).onSuccessTask(new Continuation<Void, Task<Void>>() {
                            public Task<Void> then(Task<Void> task) {
                                return result.setTransactionSuccessfulAsync();
                            }
                        }).continueWithTask(new Continuation<Void, Task<Void>>() {
                            public Task<Void> then(Task<Void> task) {
                                result.endTransactionAsync();
                                result.closeAsync();
                                return task;
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> saveLocallyAsync(final ParseObject parseObject, List<ParseObject> list, final ParseSQLiteDatabase parseSQLiteDatabase) {
        final ArrayList<ParseObject> arrayList = list != null ? new ArrayList<>(list) : new ArrayList<>();
        if (!arrayList.contains(parseObject)) {
            arrayList.add(parseObject);
        }
        ArrayList arrayList2 = new ArrayList();
        for (ParseObject fetchLocallyAsync : arrayList) {
            arrayList2.add(fetchLocallyAsync(fetchLocallyAsync, parseSQLiteDatabase).makeVoid());
        }
        return Task.whenAll(arrayList2).continueWithTask(new Continuation<Void, Task<String>>() {
            public Task<String> then(Task<Void> task) {
                return (Task) OfflineStore.this.objectToUuidMap.get(parseObject);
            }
        }).onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                String result = task.getResult();
                if (result == null) {
                    return null;
                }
                return OfflineStore.this.unpinAsync(result, parseSQLiteDatabase);
            }
        }).onSuccessTask(new Continuation<Void, Task<String>>() {
            public Task<String> then(Task<Void> task) {
                return OfflineStore.this.getOrCreateUUIDAsync(parseObject, parseSQLiteDatabase);
            }
        }).onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                String result = task.getResult();
                ArrayList arrayList = new ArrayList();
                for (ParseObject access$600 : arrayList) {
                    arrayList.add(OfflineStore.this.saveLocallyAsync(result, access$600, parseSQLiteDatabase));
                }
                return Task.whenAll(arrayList);
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> saveLocallyAsync(ParseObject parseObject, boolean z, ParseSQLiteDatabase parseSQLiteDatabase) {
        final ArrayList arrayList = new ArrayList();
        if (!z) {
            arrayList.add(parseObject);
        } else {
            new ParseTraverser() {
                /* access modifiers changed from: protected */
                public boolean visit(Object obj) {
                    if (!(obj instanceof ParseObject)) {
                        return true;
                    }
                    arrayList.add((ParseObject) obj);
                    return true;
                }
            }.setYieldRoot(true).setTraverseParseObjects(true).traverse(parseObject);
        }
        return saveLocallyAsync(parseObject, (List<ParseObject>) arrayList, parseSQLiteDatabase);
    }

    /* access modifiers changed from: private */
    public Task<Void> saveLocallyAsync(final String str, final ParseObject parseObject, final ParseSQLiteDatabase parseSQLiteDatabase) {
        if (parseObject.getObjectId() != null && !parseObject.isDataAvailable() && !parseObject.hasChanges() && !parseObject.hasOutstandingOperations()) {
            return Task.forResult(null);
        }
        final Capture capture = new Capture();
        return getOrCreateUUIDAsync(parseObject, parseSQLiteDatabase).onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                String result = task.getResult();
                capture.set(result);
                return OfflineStore.this.updateDataForObjectAsync(result, parseObject, parseSQLiteDatabase);
            }
        }).onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", str);
                contentValues.put("uuid", (String) capture.get());
                return parseSQLiteDatabase.insertWithOnConflict("Dependencies", contentValues, 4);
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> unpinAllObjectsAsync(String str, final ParseSQLiteDatabase parseSQLiteDatabase) {
        return getParsePin(str, parseSQLiteDatabase).continueWithTask(new Continuation<ParsePin, Task<Void>>() {
            public Task<Void> then(Task<ParsePin> task) {
                if (task.isFaulted()) {
                    return task.makeVoid();
                }
                return OfflineStore.this.unpinAsync((ParseObject) task.getResult(), parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: private */
    public <T extends ParseObject> Task<Void> unpinAllObjectsAsync(String str, final List<T> list, final ParseSQLiteDatabase parseSQLiteDatabase) {
        return (list == null || list.size() == 0) ? Task.forResult(null) : getParsePin(str, parseSQLiteDatabase).onSuccessTask(new Continuation<ParsePin, Task<Void>>() {
            public Task<Void> then(Task<ParsePin> task) {
                ParsePin result = task.getResult();
                List<ParseObject> objects = result.getObjects();
                if (objects == null) {
                    return Task.forResult(null);
                }
                objects.removeAll(list);
                if (objects.size() == 0) {
                    return OfflineStore.this.unpinAsync((ParseObject) result, parseSQLiteDatabase);
                }
                result.setObjects(objects);
                return OfflineStore.this.saveLocallyAsync((ParseObject) result, true, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> unpinAsync(ParseObject parseObject, final ParseSQLiteDatabase parseSQLiteDatabase) {
        Task task = this.objectToUuidMap.get(parseObject);
        return task == null ? Task.forResult(null) : task.continueWithTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                String result = task.getResult();
                return result == null ? Task.forResult(null) : OfflineStore.this.unpinAsync(result, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> unpinAsync(final String str, final ParseSQLiteDatabase parseSQLiteDatabase) {
        final LinkedList linkedList = new LinkedList();
        return Task.forResult(null).continueWithTask(new Continuation<Void, Task<Cursor>>() {
            public Task<Cursor> then(Task<Void> task) {
                return parseSQLiteDatabase.rawQueryAsync("SELECT uuid FROM Dependencies WHERE key=? AND uuid IN ( SELECT uuid FROM Dependencies GROUP BY uuid HAVING COUNT(uuid)=1)", new String[]{str});
            }
        }).onSuccessTask(new Continuation<Cursor, Task<Void>>() {
            public Task<Void> then(Task<Cursor> task) {
                Cursor result = task.getResult();
                while (result.moveToNext()) {
                    linkedList.add(result.getString(0));
                }
                result.close();
                return OfflineStore.this.deleteObjects(linkedList, parseSQLiteDatabase);
            }
        }).onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return parseSQLiteDatabase.deleteAsync("Dependencies", "key=?", new String[]{str});
            }
        }).onSuccess(new Continuation<Void, Void>() {
            public Void then(Task<Void> task) {
                synchronized (OfflineStore.this.lock) {
                    for (String str : linkedList) {
                        ParseObject parseObject = (ParseObject) OfflineStore.this.uuidToObjectMap.get(str);
                        if (parseObject != null) {
                            OfflineStore.this.objectToUuidMap.remove(parseObject);
                            OfflineStore.this.uuidToObjectMap.remove(str);
                        }
                    }
                }
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> updateDataForObjectAsync(final ParseObject parseObject, final ParseSQLiteDatabase parseSQLiteDatabase) {
        synchronized (this.lock) {
            Task task = this.objectToUuidMap.get(parseObject);
            if (task != null) {
                return task.onSuccessTask(new Continuation<String, Task<Void>>() {
                    public Task<Void> then(Task<String> task) {
                        return OfflineStore.this.updateDataForObjectAsync(task.getResult(), parseObject, parseSQLiteDatabase);
                    }
                });
            }
            Task<Void> forResult = Task.forResult(null);
            return forResult;
        }
    }

    /* access modifiers changed from: private */
    public Task<Void> updateDataForObjectAsync(String str, ParseObject parseObject, ParseSQLiteDatabase parseSQLiteDatabase) {
        OfflineEncoder offlineEncoder = new OfflineEncoder(parseSQLiteDatabase);
        final JSONObject rest = parseObject.toRest(offlineEncoder);
        final ParseObject parseObject2 = parseObject;
        final String str2 = str;
        final ParseSQLiteDatabase parseSQLiteDatabase2 = parseSQLiteDatabase;
        return offlineEncoder.whenFinished().onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                String className = parseObject2.getClassName();
                String objectId = parseObject2.getObjectId();
                int i = rest.getInt("__isDeletingEventually");
                ContentValues contentValues = new ContentValues();
                contentValues.put("className", className);
                contentValues.put("json", rest.toString());
                if (objectId != null) {
                    contentValues.put(ParseObject.KEY_OBJECT_ID, objectId);
                }
                contentValues.put("isDeletingEventually", Integer.valueOf(i));
                return parseSQLiteDatabase2.updateAsync("ParseObjects", contentValues, "uuid = ?", new String[]{str2}).makeVoid();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void clearDatabase(Context context) {
        this.helper.clearDatabase(context);
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<Integer> countFromPinAsync(final String str, final ParseQuery.State<T> state, final ParseUser parseUser) {
        return runWithManagedConnection(new SQLiteDatabaseCallable<Task<Integer>>() {
            public Task<Integer> call(ParseSQLiteDatabase parseSQLiteDatabase) {
                return OfflineStore.this.countFromPinAsync(str, state, parseUser, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Task<Void> deleteDataForObjectAsync(final ParseObject parseObject) {
        return this.helper.getWritableDatabaseAsync().continueWithTask(new Continuation<ParseSQLiteDatabase, Task<Void>>() {
            public Task<Void> then(Task<ParseSQLiteDatabase> task) {
                final ParseSQLiteDatabase result = task.getResult();
                return result.beginTransactionAsync().onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return OfflineStore.this.deleteDataForObjectAsync(parseObject, result).onSuccessTask(new Continuation<Void, Task<Void>>() {
                            public Task<Void> then(Task<Void> task) {
                                return result.setTransactionSuccessfulAsync();
                            }
                        }).continueWithTask(new Continuation<Void, Task<Void>>() {
                            public Task<Void> then(Task<Void> task) {
                                result.endTransactionAsync();
                                result.closeAsync();
                                return task;
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<T> fetchLocallyAsync(final T t) {
        return runWithManagedConnection(new SQLiteDatabaseCallable<Task<T>>() {
            public Task<T> call(ParseSQLiteDatabase parseSQLiteDatabase) {
                return OfflineStore.this.fetchLocallyAsync(t, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        r1 = r11.getClassName();
        r3 = r11.getObjectId();
        r4 = bolts.Task.forResult(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r3 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (r2 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r1 = new java.lang.String[]{"json"};
        r3 = new bolts.Capture();
        r1 = r2.onSuccessTask(new com.parse.OfflineStore.C27628(r10));
        r2 = new com.parse.OfflineStore.C27617(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        if (r2 == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        r0.setError(new java.lang.IllegalStateException("This object must have already been fetched from the local datastore, but isn't marked as fetched."));
        r2 = r10.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r10.fetchedObjects.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        return r0.getTask();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        r1 = r12.queryAsync("ParseObjects", new java.lang.String[]{"json", "uuid"}, java.lang.String.format("%s = ? AND %s = ?", new java.lang.Object[]{"className", com.parse.ParseObject.KEY_OBJECT_ID}), new java.lang.String[]{r1, r3});
        r2 = new com.parse.OfflineStore.C27639(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a1, code lost:
        r4 = r1.onSuccess(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b7, code lost:
        return r4.onSuccessTask(new com.parse.OfflineStore.C269611(r10)).continueWithTask(new com.parse.OfflineStore.C269510(r10));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.parse.ParseObject> bolts.Task<T> fetchLocallyAsync(final T r11, final com.parse.ParseSQLiteDatabase r12) {
        /*
            r10 = this;
            bolts.TaskCompletionSource r0 = new bolts.TaskCompletionSource
            r0.<init>()
            java.lang.Object r1 = r10.lock
            monitor-enter(r1)
            java.util.WeakHashMap<com.parse.ParseObject, bolts.Task<com.parse.ParseObject>> r2 = r10.fetchedObjects     // Catch:{ all -> 0x00b8 }
            boolean r2 = r2.containsKey(r11)     // Catch:{ all -> 0x00b8 }
            if (r2 == 0) goto L_0x001a
            java.util.WeakHashMap<com.parse.ParseObject, bolts.Task<com.parse.ParseObject>> r12 = r10.fetchedObjects     // Catch:{ all -> 0x00b8 }
            java.lang.Object r11 = r12.get(r11)     // Catch:{ all -> 0x00b8 }
            bolts.Task r11 = (bolts.Task) r11     // Catch:{ all -> 0x00b8 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
            return r11
        L_0x001a:
            java.util.WeakHashMap<com.parse.ParseObject, bolts.Task<com.parse.ParseObject>> r2 = r10.fetchedObjects     // Catch:{ all -> 0x00b8 }
            bolts.Task r3 = r0.getTask()     // Catch:{ all -> 0x00b8 }
            r2.put(r11, r3)     // Catch:{ all -> 0x00b8 }
            java.util.WeakHashMap<com.parse.ParseObject, bolts.Task<java.lang.String>> r2 = r10.objectToUuidMap     // Catch:{ all -> 0x00b8 }
            java.lang.Object r2 = r2.get(r11)     // Catch:{ all -> 0x00b8 }
            bolts.Task r2 = (bolts.Task) r2     // Catch:{ all -> 0x00b8 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = r11.getClassName()
            java.lang.String r3 = r11.getObjectId()
            r4 = 0
            bolts.Task r4 = bolts.Task.forResult(r4)
            if (r3 != 0) goto L_0x0058
            if (r2 != 0) goto L_0x003e
            goto L_0x00a5
        L_0x003e:
            java.lang.String r1 = "json"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            bolts.Capture r3 = new bolts.Capture
            r3.<init>()
            com.parse.OfflineStore$8 r4 = new com.parse.OfflineStore$8
            r4.<init>(r3, r12, r1)
            bolts.Task r1 = r2.onSuccessTask(r4)
            com.parse.OfflineStore$7 r2 = new com.parse.OfflineStore$7
            r2.<init>(r3)
            goto L_0x00a1
        L_0x0058:
            if (r2 == 0) goto L_0x0075
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r1 = "This object must have already been fetched from the local datastore, but isn't marked as fetched."
            r12.<init>(r1)
            r0.setError(r12)
            java.lang.Object r2 = r10.lock
            monitor-enter(r2)
            java.util.WeakHashMap<com.parse.ParseObject, bolts.Task<com.parse.ParseObject>> r12 = r10.fetchedObjects     // Catch:{ all -> 0x0072 }
            r12.remove(r11)     // Catch:{ all -> 0x0072 }
            monitor-exit(r2)     // Catch:{ all -> 0x0072 }
            bolts.Task r11 = r0.getTask()
            return r11
        L_0x0072:
            r11 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0072 }
            throw r11
        L_0x0075:
            java.lang.String r2 = "json"
            java.lang.String r4 = "uuid"
            java.lang.String[] r2 = new java.lang.String[]{r2, r4}
            java.lang.String r4 = "%s = ? AND %s = ?"
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.String r7 = "className"
            r8 = 0
            r6[r8] = r7
            java.lang.String r7 = "objectId"
            r9 = 1
            r6[r9] = r7
            java.lang.String r4 = java.lang.String.format(r4, r6)
            java.lang.String[] r5 = new java.lang.String[r5]
            r5[r8] = r1
            r5[r9] = r3
            java.lang.String r1 = "ParseObjects"
            bolts.Task r1 = r12.queryAsync(r1, r2, r4, r5)
            com.parse.OfflineStore$9 r2 = new com.parse.OfflineStore$9
            r2.<init>(r11)
        L_0x00a1:
            bolts.Task r4 = r1.onSuccess(r2)
        L_0x00a5:
            com.parse.OfflineStore$11 r1 = new com.parse.OfflineStore$11
            r1.<init>(r12, r11)
            bolts.Task r12 = r4.onSuccessTask(r1)
            com.parse.OfflineStore$10 r1 = new com.parse.OfflineStore$10
            r1.<init>(r0, r11)
            bolts.Task r11 = r12.continueWithTask(r1)
            return r11
        L_0x00b8:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.OfflineStore.fetchLocallyAsync(com.parse.ParseObject, com.parse.ParseSQLiteDatabase):bolts.Task");
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<List<T>> findAsync(ParseQuery.State<T> state, ParseUser parseUser, ParsePin parsePin, ParseSQLiteDatabase parseSQLiteDatabase) {
        return findAsync(state, parseUser, parsePin, false, parseSQLiteDatabase);
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<List<T>> findFromPinAsync(final String str, final ParseQuery.State<T> state, final ParseUser parseUser) {
        return runWithManagedConnection(new SQLiteDatabaseCallable<Task<List<T>>>() {
            public Task<List<T>> call(ParseSQLiteDatabase parseSQLiteDatabase) {
                return OfflineStore.this.findFromPinAsync(str, state, parseUser, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public ParseObject getObject(String str, String str2) {
        ParseObject parseObject;
        if (str2 != null) {
            Pair create = Pair.create(str, str2);
            synchronized (this.lock) {
                parseObject = this.classNameAndObjectIdToObjectMap.get(create);
            }
            return parseObject;
        }
        throw new IllegalStateException("objectId cannot be null.");
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<Void> pinAllObjectsAsync(final String str, final List<T> list, final boolean z) {
        return runWithManagedTransaction(new SQLiteDatabaseCallable<Task<Void>>() {
            public Task<Void> call(ParseSQLiteDatabase parseSQLiteDatabase) {
                return OfflineStore.this.pinAllObjectsAsync(str, list, z, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void registerNewObject(ParseObject parseObject) {
        synchronized (this.lock) {
            String objectId = parseObject.getObjectId();
            if (objectId != null) {
                this.classNameAndObjectIdToObjectMap.put(Pair.create(parseObject.getClassName(), objectId), parseObject);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void simulateReboot() {
        synchronized (this.lock) {
            this.uuidToObjectMap.clear();
            this.objectToUuidMap.clear();
            this.classNameAndObjectIdToObjectMap.clear();
            this.fetchedObjects.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> unpinAllObjectsAsync(final String str) {
        return runWithManagedTransaction(new SQLiteDatabaseCallable<Task<Void>>() {
            public Task<Void> call(ParseSQLiteDatabase parseSQLiteDatabase) {
                return OfflineStore.this.unpinAllObjectsAsync(str, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<Void> unpinAllObjectsAsync(final String str, final List<T> list) {
        return runWithManagedTransaction(new SQLiteDatabaseCallable<Task<Void>>() {
            public Task<Void> call(ParseSQLiteDatabase parseSQLiteDatabase) {
                return OfflineStore.this.unpinAllObjectsAsync(str, list, parseSQLiteDatabase);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void unregisterObject(ParseObject parseObject) {
        synchronized (this.lock) {
            String objectId = parseObject.getObjectId();
            if (objectId != null) {
                this.classNameAndObjectIdToObjectMap.remove(Pair.create(parseObject.getClassName(), objectId));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> updateDataForObjectAsync(final ParseObject parseObject) {
        synchronized (this.lock) {
            Task task = this.fetchedObjects.get(parseObject);
            if (task != null) {
                return task.continueWithTask(new Continuation<ParseObject, Task<Void>>() {
                    public Task<Void> then(Task<ParseObject> task) {
                        return task.isFaulted() ? (!(task.getError() instanceof ParseException) || ((ParseException) task.getError()).getCode() != 120) ? task.makeVoid() : Task.forResult(null) : OfflineStore.this.helper.getWritableDatabaseAsync().continueWithTask(new Continuation<ParseSQLiteDatabase, Task<Void>>() {
                            public Task<Void> then(Task<ParseSQLiteDatabase> task) {
                                final ParseSQLiteDatabase result = task.getResult();
                                return result.beginTransactionAsync().onSuccessTask(new Continuation<Void, Task<Void>>() {
                                    public Task<Void> then(Task<Void> task) {
                                        return OfflineStore.this.updateDataForObjectAsync(parseObject, result).onSuccessTask(new Continuation<Void, Task<Void>>() {
                                            public Task<Void> then(Task<Void> task) {
                                                return result.setTransactionSuccessfulAsync();
                                            }
                                        }).continueWithTask(new Continuation<Void, Task<Void>>() {
                                            public Task<Void> then(Task<Void> task) {
                                                result.endTransactionAsync();
                                                result.closeAsync();
                                                return task;
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
            Task<Void> forError = Task.forError(new IllegalStateException("An object cannot be updated if it wasn't fetched."));
            return forError;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateObjectId(ParseObject parseObject, String str, String str2) {
        if (str == null) {
            Pair create = Pair.create(parseObject.getClassName(), str2);
            synchronized (this.lock) {
                ParseObject parseObject2 = this.classNameAndObjectIdToObjectMap.get(create);
                if (parseObject2 != null) {
                    if (parseObject2 != parseObject) {
                        throw new RuntimeException("Attempted to change an objectId to one that's already known to the Offline Store.");
                    }
                }
                this.classNameAndObjectIdToObjectMap.put(create, parseObject);
            }
        } else if (!str.equals(str2)) {
            if (!(parseObject instanceof ParseInstallation) || str2 != null) {
                throw new RuntimeException("objectIds cannot be changed in offline mode.");
            }
            synchronized (this.lock) {
                this.classNameAndObjectIdToObjectMap.remove(Pair.create(parseObject.getClassName(), str));
            }
        }
    }
}
