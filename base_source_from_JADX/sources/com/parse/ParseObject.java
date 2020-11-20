package com.parse;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseObject implements Parcelable {
    private static final String AUTO_CLASS_NAME = "_Automatic";
    public static final Parcelable.Creator<ParseObject> CREATOR = new Parcelable.Creator<ParseObject>() {
        public ParseObject createFromParcel(Parcel parcel) {
            return ParseObject.createFromParcel(parcel, new ParseObjectParcelDecoder());
        }

        public ParseObject[] newArray(int i) {
            return new ParseObject[i];
        }
    };
    public static final String DEFAULT_PIN = "_default";
    private static final String KEY_ACL = "ACL";
    private static final String KEY_CLASS_NAME = "className";
    private static final String KEY_COMPLETE = "__complete";
    public static final String KEY_CREATED_AT = "createdAt";
    static final String KEY_IS_DELETING_EVENTUALLY = "__isDeletingEventually";
    private static final String KEY_IS_DELETING_EVENTUALLY_OLD = "isDeletingEventually";
    public static final String KEY_OBJECT_ID = "objectId";
    private static final String KEY_OPERATIONS = "__operations";
    private static final String KEY_SELECTED_KEYS = "__selectedKeys";
    public static final String KEY_UPDATED_AT = "updatedAt";
    private static final String NEW_OFFLINE_OBJECT_ID_PLACEHOLDER = "*** Offline Object ***";
    private static final String TAG = "ParseObject";
    private static final ThreadLocal<String> isCreatingPointerForObjectId = new ThreadLocal<String>() {
        /* access modifiers changed from: protected */
        public String initialValue() {
            return null;
        }
    };
    /* access modifiers changed from: private */
    public final Map<String, Object> estimatedData;
    boolean isDeleted;
    boolean isDeleting;
    int isDeletingEventually;
    private boolean ldsEnabledWhenParceling;
    String localId;
    final Object mutex;
    final LinkedList<ParseOperationSet> operationSetQueue;
    /* access modifiers changed from: private */
    public final ParseMulticastDelegate<ParseObject> saveEvent;
    /* access modifiers changed from: private */
    public State state;
    final TaskQueue taskQueue;

    static class State {
        private final Set<String> availableKeys;
        private final String className;
        private final long createdAt;
        private final boolean isComplete;
        private final String objectId;
        private final Map<String, Object> serverData;
        private final long updatedAt;

        static class Builder extends Init<Builder> {
            public Builder(State state) {
                super(state);
            }

            public Builder(String str) {
                super(str);
            }

            public State build() {
                return new State(this);
            }

            /* access modifiers changed from: package-private */
            public Builder self() {
                return this;
            }
        }

        static abstract class Init<T extends Init> {
            /* access modifiers changed from: private */
            public Set<String> availableKeys = new HashSet();
            /* access modifiers changed from: private */
            public final String className;
            /* access modifiers changed from: private */
            public long createdAt = -1;
            /* access modifiers changed from: private */
            public boolean isComplete;
            /* access modifiers changed from: private */
            public String objectId;
            Map<String, Object> serverData = new HashMap();
            /* access modifiers changed from: private */
            public long updatedAt = -1;

            Init(State state) {
                this.className = state.className();
                this.objectId = state.objectId();
                this.createdAt = state.createdAt();
                this.updatedAt = state.updatedAt();
                this.availableKeys = Collections.synchronizedSet(new HashSet(state.availableKeys()));
                for (String next : state.keySet()) {
                    this.serverData.put(next, state.get(next));
                    this.availableKeys.add(next);
                }
                this.isComplete = state.isComplete();
            }

            public Init(String str) {
                this.className = str;
            }

            public T apply(State state) {
                if (state.objectId() != null) {
                    objectId(state.objectId());
                }
                if (state.createdAt() > 0) {
                    createdAt(state.createdAt());
                }
                if (state.updatedAt() > 0) {
                    updatedAt(state.updatedAt());
                }
                isComplete(this.isComplete || state.isComplete());
                for (String next : state.keySet()) {
                    put(next, state.get(next));
                }
                availableKeys(state.availableKeys());
                return self();
            }

            public T apply(ParseOperationSet parseOperationSet) {
                for (String str : parseOperationSet.keySet()) {
                    Object apply = ((ParseFieldOperation) parseOperationSet.get(str)).apply(this.serverData.get(str), str);
                    if (apply != null) {
                        put(str, apply);
                    } else {
                        remove(str);
                    }
                }
                return self();
            }

            public T availableKeys(Collection<String> collection) {
                this.availableKeys.addAll(collection);
                return self();
            }

            /* access modifiers changed from: package-private */
            public abstract <S extends State> S build();

            public T clear() {
                this.objectId = null;
                this.createdAt = -1;
                this.updatedAt = -1;
                this.isComplete = false;
                this.serverData.clear();
                this.availableKeys.clear();
                return self();
            }

            public T createdAt(long j) {
                this.createdAt = j;
                return self();
            }

            public T createdAt(Date date) {
                this.createdAt = date.getTime();
                return self();
            }

            public T isComplete(boolean z) {
                this.isComplete = z;
                return self();
            }

            public T objectId(String str) {
                this.objectId = str;
                return self();
            }

            public T put(String str, Object obj) {
                this.serverData.put(str, obj);
                this.availableKeys.add(str);
                return self();
            }

            public T remove(String str) {
                this.serverData.remove(str);
                return self();
            }

            /* access modifiers changed from: package-private */
            public abstract T self();

            public T updatedAt(long j) {
                this.updatedAt = j;
                return self();
            }

            public T updatedAt(Date date) {
                this.updatedAt = date.getTime();
                return self();
            }
        }

        State(Parcel parcel, String str, ParseParcelDecoder parseParcelDecoder) {
            this.className = str;
            boolean z = true;
            this.objectId = parcel.readByte() == 1 ? parcel.readString() : null;
            this.createdAt = parcel.readLong();
            long readLong = parcel.readLong();
            this.updatedAt = readLong <= 0 ? this.createdAt : readLong;
            int readInt = parcel.readInt();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < readInt; i++) {
                hashMap.put(parcel.readString(), parseParcelDecoder.decode(parcel));
            }
            this.serverData = Collections.unmodifiableMap(hashMap);
            this.isComplete = parcel.readByte() != 1 ? false : z;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.availableKeys = new HashSet(arrayList);
        }

        State(Init<?> init) {
            this.className = init.className;
            this.objectId = init.objectId;
            this.createdAt = init.createdAt;
            this.updatedAt = init.updatedAt > 0 ? init.updatedAt : this.createdAt;
            this.serverData = Collections.unmodifiableMap(new HashMap(init.serverData));
            this.isComplete = init.isComplete;
            this.availableKeys = Collections.synchronizedSet(init.availableKeys);
        }

        static State createFromParcel(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
            String readString = parcel.readString();
            return "_User".equals(readString) ? new ParseUser.State(parcel, readString, parseParcelDecoder) : new State(parcel, readString, parseParcelDecoder);
        }

        public static Init<?> newBuilder(String str) {
            return "_User".equals(str) ? new ParseUser.State.Builder() : new Builder(str);
        }

        public Set<String> availableKeys() {
            return this.availableKeys;
        }

        public String className() {
            return this.className;
        }

        public long createdAt() {
            return this.createdAt;
        }

        public Object get(String str) {
            return this.serverData.get(str);
        }

        public boolean isComplete() {
            return this.isComplete;
        }

        public Set<String> keySet() {
            return this.serverData.keySet();
        }

        public <T extends Init<?>> T newBuilder() {
            return new Builder(this);
        }

        public String objectId() {
            return this.objectId;
        }

        public String toString() {
            return String.format(Locale.US, "%s@%s[className=%s, objectId=%s, createdAt=%d, updatedAt=%d, isComplete=%s, serverData=%s, availableKeys=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), this.className, this.objectId, Long.valueOf(this.createdAt), Long.valueOf(this.updatedAt), Boolean.valueOf(this.isComplete), this.serverData, this.availableKeys});
        }

        public long updatedAt() {
            return this.updatedAt;
        }

        /* access modifiers changed from: protected */
        public void writeToParcel(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
            parcel.writeString(this.className);
            parcel.writeByte(this.objectId != null ? (byte) 1 : 0);
            String str = this.objectId;
            if (str != null) {
                parcel.writeString(str);
            }
            parcel.writeLong(this.createdAt);
            parcel.writeLong(this.updatedAt);
            parcel.writeInt(this.serverData.size());
            for (String next : this.serverData.keySet()) {
                parcel.writeString(next);
                parseParcelEncoder.encode(this.serverData.get(next), parcel);
            }
            parcel.writeByte(this.isComplete ? (byte) 1 : 0);
            parcel.writeStringList(new ArrayList(this.availableKeys));
        }
    }

    protected ParseObject() {
        this(AUTO_CLASS_NAME);
    }

    public ParseObject(String str) {
        boolean z;
        this.mutex = new Object();
        this.taskQueue = new TaskQueue();
        this.saveEvent = new ParseMulticastDelegate<>();
        String str2 = isCreatingPointerForObjectId.get();
        if (str != null) {
            str = AUTO_CLASS_NAME.equals(str) ? getSubclassingController().getClassName(getClass()) : str;
            if (getSubclassingController().isSubclassValid(str, getClass())) {
                this.operationSetQueue = new LinkedList<>();
                this.operationSetQueue.add(new ParseOperationSet());
                this.estimatedData = new HashMap();
                State.Init<?> newStateBuilder = newStateBuilder(str);
                if (str2 == null) {
                    setDefaultValues();
                    z = true;
                } else {
                    if (!str2.equals(NEW_OFFLINE_OBJECT_ID_PLACEHOLDER)) {
                        newStateBuilder.objectId(str2);
                    }
                    z = false;
                }
                newStateBuilder.isComplete(z);
                this.state = newStateBuilder.build();
                OfflineStore localDatastore = Parse.getLocalDatastore();
                if (localDatastore != null) {
                    localDatastore.registerNewObject(this);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("You must create this type of ParseObject using ParseObject.create() or the proper subclass.");
        }
        throw new IllegalArgumentException("You must specify a Parse class name when creating a new ParseObject.");
    }

    private void applyOperations(ParseOperationSet parseOperationSet, Map<String, Object> map) {
        for (String str : parseOperationSet.keySet()) {
            Object apply = ((ParseFieldOperation) parseOperationSet.get(str)).apply(map.get(str), str);
            if (apply != null) {
                map.put(str, apply);
            } else {
                map.remove(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean canBeSerialized() {
        boolean booleanValue;
        synchronized (this.mutex) {
            final Capture capture = new Capture(true);
            new ParseTraverser() {
                /* access modifiers changed from: protected */
                public boolean visit(Object obj) {
                    if ((obj instanceof ParseFile) && ((ParseFile) obj).isDirty()) {
                        capture.set(false);
                    }
                    if ((obj instanceof ParseObject) && ((ParseObject) obj).getObjectId() == null) {
                        capture.set(false);
                    }
                    return ((Boolean) capture.get()).booleanValue();
                }
            }.setYieldRoot(false).setTraverseParseObjects(true).traverse(this);
            booleanValue = ((Boolean) capture.get()).booleanValue();
        }
        return booleanValue;
    }

    private void checkGetAccess(String str) {
        if (!isDataAvailable(str)) {
            throw new IllegalStateException("ParseObject has no data for '" + str + "'. Call fetchIfNeeded() to get the data.");
        }
    }

    private void checkKeyIsMutable(String str) {
        if (!isKeyMutable(str)) {
            throw new IllegalArgumentException("Cannot modify `" + str + "` property of an " + getClassName() + " object.");
        }
    }

    private static void collectDirtyChildren(Object obj, Collection<ParseObject> collection, Collection<ParseFile> collection2) {
        collectDirtyChildren(obj, collection, collection2, new HashSet(), new HashSet());
    }

    /* access modifiers changed from: private */
    public static void collectDirtyChildren(Object obj, final Collection<ParseObject> collection, final Collection<ParseFile> collection2, final Set<ParseObject> set, final Set<ParseObject> set2) {
        new ParseTraverser() {
            /* access modifiers changed from: protected */
            public boolean visit(Object obj) {
                HashSet hashSet;
                if (obj instanceof ParseFile) {
                    if (collection2 == null) {
                        return true;
                    }
                    ParseFile parseFile = (ParseFile) obj;
                    if (parseFile.getUrl() == null) {
                        collection2.add(parseFile);
                    }
                    return true;
                } else if (!(obj instanceof ParseObject) || collection == null) {
                    return true;
                } else {
                    ParseObject parseObject = (ParseObject) obj;
                    Set set = set;
                    Set set2 = set2;
                    if (parseObject.getObjectId() != null) {
                        hashSet = new HashSet();
                    } else if (!set2.contains(parseObject)) {
                        HashSet hashSet2 = new HashSet(set2);
                        hashSet2.add(parseObject);
                        hashSet = hashSet2;
                    } else {
                        throw new RuntimeException("Found a circular dependency while saving.");
                    }
                    if (set.contains(parseObject)) {
                        return true;
                    }
                    HashSet hashSet3 = new HashSet(set);
                    hashSet3.add(parseObject);
                    ParseObject.collectDirtyChildren(parseObject.estimatedData, collection, collection2, hashSet3, hashSet);
                    if (parseObject.isDirty(false)) {
                        collection.add(parseObject);
                    }
                    return true;
                }
            }
        }.setYieldRoot(true).traverse(obj);
    }

    /* access modifiers changed from: private */
    public Map<String, ParseObject> collectFetchedObjects() {
        final HashMap hashMap = new HashMap();
        new ParseTraverser() {
            /* access modifiers changed from: protected */
            public boolean visit(Object obj) {
                if (!(obj instanceof ParseObject)) {
                    return true;
                }
                ParseObject parseObject = (ParseObject) obj;
                State state = parseObject.getState();
                if (state.objectId() == null || !state.isComplete()) {
                    return true;
                }
                hashMap.put(state.objectId(), parseObject);
                return true;
            }
        }.traverse(this.estimatedData);
        return hashMap;
    }

    public static <T extends ParseObject> T create(Class<T> cls) {
        return create(getSubclassingController().getClassName(cls));
    }

    public static ParseObject create(String str) {
        return getSubclassingController().newInstance(str);
    }

    static ParseObject createFromParcel(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
        ParseObject createWithoutData = createWithoutData(parcel.readString(), parcel.readByte() == 1 ? parcel.readString() : null);
        if (parseParcelDecoder instanceof ParseObjectParcelDecoder) {
            ((ParseObjectParcelDecoder) parseParcelDecoder).addKnownObject(createWithoutData);
        }
        createWithoutData.setState(State.createFromParcel(parcel, parseParcelDecoder));
        if (parcel.readByte() == 1) {
            createWithoutData.localId = parcel.readString();
        }
        if (parcel.readByte() == 1) {
            createWithoutData.isDeleted = true;
        }
        boolean z = !createWithoutData.ldsEnabledWhenParceling;
        ParseOperationSet fromParcel = ParseOperationSet.fromParcel(parcel, parseParcelDecoder);
        if (z) {
            for (String str : fromParcel.keySet()) {
                createWithoutData.performOperation(str, (ParseFieldOperation) fromParcel.get(str));
            }
        }
        createWithoutData.onRestoreInstanceState(parcel.readBundle(ParseObject.class.getClassLoader()));
        return createWithoutData;
    }

    public static <T extends ParseObject> T createWithoutData(Class<T> cls, String str) {
        return createWithoutData(getSubclassingController().getClassName(cls), str);
    }

    public static ParseObject createWithoutData(String str, String str2) {
        OfflineStore localDatastore = Parse.getLocalDatastore();
        if (str2 == null) {
            try {
                isCreatingPointerForObjectId.set(NEW_OFFLINE_OBJECT_ID_PLACEHOLDER);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException("Failed to create instance of subclass.", e2);
            } catch (Throwable th) {
                isCreatingPointerForObjectId.set((Object) null);
                throw th;
            }
        } else {
            isCreatingPointerForObjectId.set(str2);
        }
        ParseObject object = (localDatastore == null || str2 == null) ? null : localDatastore.getObject(str, str2);
        if (object == null) {
            object = create(str);
            if (object.hasChanges()) {
                throw new IllegalStateException("A ParseObject subclass default constructor must not make changes to the object that cause it to be dirty.");
            }
        }
        isCreatingPointerForObjectId.set((Object) null);
        return object;
    }

    private ParseOperationSet currentOperations() {
        ParseOperationSet last;
        synchronized (this.mutex) {
            last = this.operationSetQueue.getLast();
        }
        return last;
    }

    private ParseRESTObjectCommand currentSaveEventuallyCommand(ParseOperationSet parseOperationSet, ParseEncoder parseEncoder, String str) {
        State state2 = getState();
        return ParseRESTObjectCommand.saveObjectCommand(state2, toJSONObjectForSaving(state2, parseOperationSet, parseEncoder), str);
    }

    /* access modifiers changed from: private */
    public static Task<Void> deepSaveAsync(Object obj, final String str) {
        HashSet<ParseObject> hashSet = new HashSet<>();
        HashSet<ParseFile> hashSet2 = new HashSet<>();
        collectDirtyChildren(obj, hashSet, hashSet2);
        HashSet<ParseUser> hashSet3 = new HashSet<>();
        for (ParseObject parseObject : hashSet) {
            if (parseObject instanceof ParseUser) {
                ParseUser parseUser = (ParseUser) parseObject;
                if (parseUser.isLazy()) {
                    hashSet3.add(parseUser);
                }
            }
        }
        hashSet.removeAll(hashSet3);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ArrayList arrayList = new ArrayList();
        for (ParseFile saveAsync : hashSet2) {
            arrayList.add(saveAsync.saveAsync(str, (ProgressCallback) null, (Task<Void>) null));
        }
        Task<TContinuationResult> continueWith = Task.whenAll(arrayList).continueWith(new Continuation<Void, Void>() {
            public Void then(Task<Void> task) {
                atomicBoolean.set(true);
                return null;
            }
        });
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        ArrayList arrayList2 = new ArrayList();
        for (ParseUser saveAsync2 : hashSet3) {
            arrayList2.add(saveAsync2.saveAsync(str));
        }
        Task<TContinuationResult> continueWith2 = Task.whenAll(arrayList2).continueWith(new Continuation<Void, Void>() {
            public Void then(Task<Void> task) {
                atomicBoolean2.set(true);
                return null;
            }
        });
        final Capture capture = new Capture(hashSet);
        return Task.whenAll(Arrays.asList(new Task[]{continueWith, continueWith2, Task.forResult(null).continueWhile(new Callable<Boolean>() {
            public Boolean call() {
                return Boolean.valueOf(((Set) capture.get()).size() > 0);
            }
        }, new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                final ArrayList arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                for (ParseObject parseObject : (Set) capture.get()) {
                    if (parseObject.canBeSerialized()) {
                        arrayList.add(parseObject);
                    } else {
                        hashSet.add(parseObject);
                    }
                }
                capture.set(hashSet);
                if (arrayList.size() != 0 || !atomicBoolean.get() || !atomicBoolean2.get()) {
                    return arrayList.size() == 0 ? Task.forResult(null) : ParseObject.enqueueForAll(arrayList, new Continuation<Void, Task<Void>>() {
                        public Task<Void> then(Task<Void> task) {
                            return ParseObject.saveAllAsync(arrayList, str, task);
                        }
                    });
                }
                throw new RuntimeException("Unable to save a ParseObject with a relation to a cycle.");
            }
        })}));
    }

    public static <T extends ParseObject> void deleteAll(List<T> list) {
        ParseTaskUtils.wait(deleteAllInBackground(list));
    }

    /* access modifiers changed from: private */
    public static <T extends ParseObject> Task<Void> deleteAllAsync(List<T> list, final String str) {
        if (list.size() == 0) {
            return Task.forResult(null);
        }
        int size = list.size();
        final ArrayList arrayList = new ArrayList(size);
        HashSet hashSet = new HashSet();
        for (int i = 0; i < size; i++) {
            ParseObject parseObject = (ParseObject) list.get(i);
            if (!hashSet.contains(parseObject.getObjectId())) {
                hashSet.add(parseObject.getObjectId());
                arrayList.add(parseObject);
            }
        }
        return enqueueForAll(arrayList, new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseObject.deleteAllAsync(arrayList, str, task);
            }
        });
    }

    /* access modifiers changed from: private */
    public static <T extends ParseObject> Task<Void> deleteAllAsync(final List<T> list, final String str, Task<Void> task) {
        return task.continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    ParseObject parseObject = (ParseObject) list.get(i);
                    parseObject.validateDelete();
                    arrayList.add(parseObject.getState());
                }
                List<Task<Void>> deleteAllAsync = ParseObject.getObjectController().deleteAllAsync(arrayList, str);
                ArrayList arrayList2 = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    final ParseObject parseObject2 = (ParseObject) list.get(i2);
                    arrayList2.add(deleteAllAsync.get(i2).onSuccessTask(new Continuation<Void, Task<Void>>() {
                        public Task<Void> then(final Task<Void> task) {
                            return parseObject2.handleDeleteResultAsync().continueWithTask(new Continuation<Void, Task<Void>>() {
                                public Task<Void> then(Task<Void> task) {
                                    return task;
                                }
                            });
                        }
                    }));
                }
                return Task.whenAll(arrayList2);
            }
        });
    }

    public static <T extends ParseObject> Task<Void> deleteAllInBackground(final List<T> list) {
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                return ParseObject.deleteAllAsync(list, task.getResult());
            }
        });
    }

    public static <T extends ParseObject> void deleteAllInBackground(List<T> list, DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(deleteAllInBackground(list), (ParseCallback1<ParseException>) deleteCallback);
    }

    /* access modifiers changed from: private */
    public Task<Void> deleteAsync(final String str, Task<Void> task) {
        validateDelete();
        return task.onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                ParseObject parseObject = ParseObject.this;
                parseObject.isDeleting = true;
                return parseObject.state.objectId() == null ? task.cast() : ParseObject.this.deleteAsync(str);
            }
        }).onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseObject.this.handleDeleteResultAsync();
            }
        }).continueWith(new Continuation<Void, Void>() {
            public Void then(Task<Void> task) {
                ParseObject.this.isDeleting = false;
                if (!task.isFaulted()) {
                    return null;
                }
                throw task.getError();
            }
        });
    }

    static <T> Task<T> enqueueForAll(List<? extends ParseObject> list, Continuation<Void, Task<T>> continuation) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ArrayList arrayList = new ArrayList(list.size());
        for (ParseObject parseObject : list) {
            arrayList.add(parseObject.taskQueue.getLock());
        }
        LockSet lockSet = new LockSet(arrayList);
        lockSet.lock();
        try {
            final Task<T> then = continuation.then(taskCompletionSource.getTask());
            final ArrayList arrayList2 = new ArrayList();
            for (ParseObject parseObject2 : list) {
                parseObject2.taskQueue.enqueue(new Continuation<Void, Task<T>>() {
                    public Task<T> then(Task<Void> task) {
                        arrayList2.add(task);
                        return then;
                    }
                });
            }
            Task.whenAll(arrayList2).continueWith(new Continuation<Void, Void>() {
                public Void then(Task<Void> task) {
                    taskCompletionSource.setResult(null);
                    return null;
                }
            });
            lockSet.unlock();
            return then;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            lockSet.unlock();
            throw th;
        }
    }

    private void enqueueSaveEventuallyOperationAsync(final ParseOperationSet parseOperationSet) {
        if (parseOperationSet.isSaveEventually()) {
            this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return task.continueWithTask(new Continuation<Void, Task<Void>>() {
                        public Task<Void> then(Task<Void> task) {
                            return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(parseOperationSet, (EventuallyPin) null).makeVoid();
                        }
                    });
                }
            });
            return;
        }
        throw new IllegalStateException("This should only be used to enqueue saveEventually operation sets");
    }

    public static <T extends ParseObject> List<T> fetchAll(List<T> list) {
        return (List) ParseTaskUtils.wait(fetchAllInBackground(list));
    }

    /* access modifiers changed from: private */
    public static <T extends ParseObject> Task<List<T>> fetchAllAsync(final List<T> list, final ParseUser parseUser, final boolean z, Task<Void> task) {
        if (list.size() == 0) {
            return Task.forResult(list);
        }
        ArrayList arrayList = new ArrayList();
        String str = null;
        for (T t : list) {
            if (!z || !t.isDataAvailable()) {
                if (str == null || t.getClassName().equals(str)) {
                    str = t.getClassName();
                    if (t.getObjectId() != null) {
                        arrayList.add(t.getObjectId());
                    } else if (!z) {
                        throw new IllegalArgumentException("All objects must exist on the server");
                    }
                } else {
                    throw new IllegalArgumentException("All objects should have the same class");
                }
            }
        }
        if (arrayList.size() == 0) {
            return Task.forResult(list);
        }
        final ParseQuery limit = ParseQuery.getQuery(str).whereContainedIn(KEY_OBJECT_ID, arrayList).setLimit(arrayList.size());
        return task.continueWithTask(new Continuation<Void, Task<List<T>>>() {
            public Task<List<T>> then(Task<Void> task) {
                ParseQuery parseQuery = limit;
                return parseQuery.findAsync(parseQuery.getBuilder().build(), parseUser, (Task<Void>) null);
            }
        }).onSuccess(new Continuation<List<T>, List<T>>() {
            public List<T> then(Task<List<T>> task) {
                HashMap hashMap = new HashMap();
                for (T t : task.getResult()) {
                    hashMap.put(t.getObjectId(), t);
                }
                for (ParseObject parseObject : list) {
                    if (!z || !parseObject.isDataAvailable()) {
                        ParseObject parseObject2 = (ParseObject) hashMap.get(parseObject.getObjectId());
                        if (parseObject2 == null) {
                            throw new ParseException(101, "Object id " + parseObject.getObjectId() + " does not exist");
                        } else if (!Parse.isLocalDatastoreEnabled()) {
                            parseObject.mergeFromObject(parseObject2);
                        }
                    }
                }
                return list;
            }
        });
    }

    private static <T extends ParseObject> Task<List<T>> fetchAllAsync(final List<T> list, final boolean z) {
        return ParseUser.getCurrentUserAsync().onSuccessTask(new Continuation<ParseUser, Task<List<T>>>() {
            public Task<List<T>> then(Task<ParseUser> task) {
                final ParseUser result = task.getResult();
                return ParseObject.enqueueForAll(list, new Continuation<Void, Task<List<T>>>() {
                    public Task<List<T>> then(Task<Void> task) {
                        return ParseObject.fetchAllAsync(list, result, z, task);
                    }
                });
            }
        });
    }

    public static <T extends ParseObject> List<T> fetchAllIfNeeded(List<T> list) {
        return (List) ParseTaskUtils.wait(fetchAllIfNeededInBackground(list));
    }

    public static <T extends ParseObject> Task<List<T>> fetchAllIfNeededInBackground(List<T> list) {
        return fetchAllAsync(list, true);
    }

    public static <T extends ParseObject> void fetchAllIfNeededInBackground(List<T> list, FindCallback<T> findCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchAllIfNeededInBackground(list), findCallback);
    }

    public static <T extends ParseObject> Task<List<T>> fetchAllInBackground(List<T> list) {
        return fetchAllAsync(list, false);
    }

    public static <T extends ParseObject> void fetchAllInBackground(List<T> list, FindCallback<T> findCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchAllInBackground(list), findCallback);
    }

    static <T extends ParseObject> T from(State state2) {
        T createWithoutData = createWithoutData(state2.className(), state2.objectId());
        synchronized (createWithoutData.mutex) {
            if (!state2.isComplete()) {
                state2 = createWithoutData.getState().newBuilder().apply(state2).build();
            }
            createWithoutData.setState(state2);
        }
        return createWithoutData;
    }

    public static <T extends ParseObject> T fromJSON(JSONObject jSONObject, String str, ParseDecoder parseDecoder) {
        String optString = jSONObject.optString(KEY_CLASS_NAME, str);
        if (optString == null) {
            return null;
        }
        T createWithoutData = createWithoutData(optString, jSONObject.optString(KEY_OBJECT_ID, (String) null));
        createWithoutData.setState(createWithoutData.mergeFromServer(createWithoutData.getState(), jSONObject, parseDecoder, !jSONObject.has(KEY_SELECTED_KEYS)));
        return createWithoutData;
    }

    public static <T extends ParseObject> T fromJSON(JSONObject jSONObject, String str, ParseDecoder parseDecoder, Set<String> set) {
        if (set != null && !set.isEmpty()) {
            try {
                jSONObject.put(KEY_SELECTED_KEYS, new JSONArray(set));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return fromJSON(jSONObject, str, parseDecoder);
    }

    static <T extends ParseObject> T fromJSONPayload(JSONObject jSONObject, ParseDecoder parseDecoder) {
        String optString = jSONObject.optString(KEY_CLASS_NAME);
        if (optString == null || ParseTextUtils.isEmpty(optString)) {
            return null;
        }
        T createWithoutData = createWithoutData(optString, jSONObject.optString(KEY_OBJECT_ID, (String) null));
        createWithoutData.build(jSONObject, parseDecoder);
        return createWithoutData;
    }

    /* access modifiers changed from: private */
    public ParseACL getACL(boolean z) {
        synchronized (this.mutex) {
            checkGetAccess(KEY_ACL);
            Object obj = this.estimatedData.get(KEY_ACL);
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof ParseACL)) {
                throw new RuntimeException("only ACLs can be stored in the ACL key");
            } else if (!z || !((ParseACL) obj).isShared()) {
                ParseACL parseACL = (ParseACL) obj;
                return parseACL;
            } else {
                ParseACL parseACL2 = new ParseACL((ParseACL) obj);
                this.estimatedData.put(KEY_ACL, parseACL2);
                return parseACL2;
            }
        }
    }

    private static LocalIdManager getLocalIdManager() {
        return ParseCorePlugins.getInstance().getLocalIdManager();
    }

    /* access modifiers changed from: private */
    public static ParseObjectController getObjectController() {
        return ParseCorePlugins.getInstance().getObjectController();
    }

    private static ParseObjectSubclassingController getSubclassingController() {
        return ParseCorePlugins.getInstance().getSubclassingController();
    }

    private boolean hasDirtyChildren() {
        boolean z;
        synchronized (this.mutex) {
            ArrayList arrayList = new ArrayList();
            collectDirtyChildren(this.estimatedData, arrayList, (Collection<ParseFile>) null);
            z = arrayList.size() > 0;
        }
        return z;
    }

    private void notifyObjectIdChanged(String str, String str2) {
        synchronized (this.mutex) {
            OfflineStore localDatastore = Parse.getLocalDatastore();
            if (localDatastore != null) {
                localDatastore.updateObjectId(this, str, str2);
            }
            if (this.localId != null) {
                getLocalIdManager().setObjectId(this.localId, str2);
                this.localId = null;
            }
        }
    }

    public static <T extends ParseObject> void pinAll(String str, List<T> list) {
        ParseTaskUtils.wait(pinAllInBackground(str, list));
    }

    public static <T extends ParseObject> void pinAll(List<T> list) {
        ParseTaskUtils.wait(pinAllInBackground(DEFAULT_PIN, list));
    }

    public static <T extends ParseObject> Task<Void> pinAllInBackground(String str, List<T> list) {
        return pinAllInBackground(str, list, true);
    }

    private static <T extends ParseObject> Task<Void> pinAllInBackground(final String str, final List<T> list, final boolean z) {
        if (Parse.isLocalDatastoreEnabled()) {
            Task forResult = Task.forResult(null);
            for (T r2 : list) {
                forResult = forResult.onSuccessTask(new Continuation<Void, Task<Void>>(r2) {
                    final /* synthetic */ ParseObject val$object;

                    {
                        this.val$object = r1;
                    }

                    public Task<Void> then(Task<Void> task) {
                        if (!this.val$object.isDataAvailable(ParseObject.KEY_ACL)) {
                            return Task.forResult(null);
                        }
                        ParseACL access$900 = this.val$object.getACL(false);
                        if (access$900 == null) {
                            return Task.forResult(null);
                        }
                        ParseUser unresolvedUser = access$900.getUnresolvedUser();
                        return (unresolvedUser == null || !unresolvedUser.isCurrentUser()) ? Task.forResult(null) : ParseUser.pinCurrentUserIfNeededAsync(unresolvedUser);
                    }
                });
            }
            return forResult.onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    OfflineStore localDatastore = Parse.getLocalDatastore();
                    String str = str;
                    if (str == null) {
                        str = ParseObject.DEFAULT_PIN;
                    }
                    return localDatastore.pinAllObjectsAsync(str, list, z);
                }
            }).onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    if ("_currentUser".equals(str)) {
                        return task;
                    }
                    for (ParseObject parseObject : list) {
                        if (parseObject instanceof ParseUser) {
                            ParseUser parseUser = (ParseUser) parseObject;
                            if (parseUser.isCurrentUser()) {
                                return ParseUser.pinCurrentUserIfNeededAsync(parseUser);
                            }
                        }
                    }
                    return task;
                }
            });
        }
        throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }

    public static <T extends ParseObject> Task<Void> pinAllInBackground(List<T> list) {
        return pinAllInBackground(DEFAULT_PIN, list);
    }

    public static <T extends ParseObject> void pinAllInBackground(String str, List<T> list, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(pinAllInBackground(str, list), (ParseCallback1<ParseException>) saveCallback);
    }

    public static <T extends ParseObject> void pinAllInBackground(List<T> list, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(pinAllInBackground(DEFAULT_PIN, list), (ParseCallback1<ParseException>) saveCallback);
    }

    private void rebuildEstimatedData() {
        synchronized (this.mutex) {
            this.estimatedData.clear();
            for (String next : this.state.keySet()) {
                this.estimatedData.put(next, this.state.get(next));
            }
            Iterator it = this.operationSetQueue.iterator();
            while (it.hasNext()) {
                applyOperations((ParseOperationSet) it.next(), this.estimatedData);
            }
        }
    }

    static void registerParseSubclasses() {
        registerSubclass(ParseUser.class);
        registerSubclass(ParseRole.class);
        registerSubclass(ParseInstallation.class);
        registerSubclass(ParseSession.class);
        registerSubclass(ParsePin.class);
        registerSubclass(EventuallyPin.class);
    }

    public static void registerSubclass(Class<? extends ParseObject> cls) {
        getSubclassingController().registerSubclass(cls);
    }

    public static <T extends ParseObject> void saveAll(List<T> list) {
        ParseTaskUtils.wait(saveAllInBackground(list));
    }

    /* access modifiers changed from: private */
    public static <T extends ParseObject> Task<Void> saveAllAsync(final List<T> list, final String str, Task<Void> task) {
        return task.continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                ArrayList arrayList2 = new ArrayList(size);
                ArrayList arrayList3 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    ParseObject parseObject = (ParseObject) list.get(i);
                    parseObject.updateBeforeSave();
                    parseObject.validateSave();
                    arrayList.add(parseObject.getState());
                    arrayList2.add(parseObject.startSave());
                    arrayList3.add(new KnownParseObjectDecoder(parseObject.collectFetchedObjects()));
                }
                List<Task<State>> saveAllAsync = ParseObject.getObjectController().saveAllAsync(arrayList, arrayList2, str, arrayList3);
                ArrayList arrayList4 = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    final ParseObject parseObject2 = (ParseObject) list.get(i2);
                    final ParseOperationSet parseOperationSet = (ParseOperationSet) arrayList2.get(i2);
                    arrayList4.add(saveAllAsync.get(i2).continueWithTask(new Continuation<State, Task<Void>>() {
                        public Task<Void> then(final Task<State> task) {
                            return parseObject2.handleSaveResultAsync(task.getResult(), parseOperationSet).continueWithTask(new Continuation<Void, Task<Void>>() {
                                public Task<Void> then(Task<Void> task) {
                                    return (task.isFaulted() || task.isCancelled()) ? task : task.makeVoid();
                                }
                            });
                        }
                    }));
                }
                return Task.whenAll(arrayList4);
            }
        });
    }

    public static <T extends ParseObject> Task<Void> saveAllInBackground(final List<T> list) {
        return ParseUser.getCurrentUserAsync().onSuccessTask(new Continuation<ParseUser, Task<String>>() {
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
                r1 = com.parse.ParseObject.access$900(r1, false);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
                r2 = r1.getUnresolvedUser();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public bolts.Task<java.lang.String> then(bolts.Task<com.parse.ParseUser> r5) {
                /*
                    r4 = this;
                    java.lang.Object r5 = r5.getResult()
                    com.parse.ParseUser r5 = (com.parse.ParseUser) r5
                    r0 = 0
                    if (r5 != 0) goto L_0x000e
                    bolts.Task r5 = bolts.Task.forResult(r0)
                    return r5
                L_0x000e:
                    boolean r1 = r5.isLazy()
                    if (r1 != 0) goto L_0x001d
                    java.lang.String r5 = r5.getSessionToken()
                    bolts.Task r5 = bolts.Task.forResult(r5)
                    return r5
                L_0x001d:
                    java.util.List r5 = r2
                    java.util.Iterator r5 = r5.iterator()
                L_0x0023:
                    boolean r1 = r5.hasNext()
                    if (r1 == 0) goto L_0x005a
                    java.lang.Object r1 = r5.next()
                    com.parse.ParseObject r1 = (com.parse.ParseObject) r1
                    java.lang.String r2 = "ACL"
                    boolean r2 = r1.isDataAvailable(r2)
                    if (r2 != 0) goto L_0x0038
                    goto L_0x0023
                L_0x0038:
                    r2 = 0
                    com.parse.ParseACL r1 = r1.getACL(r2)
                    if (r1 != 0) goto L_0x0040
                    goto L_0x0023
                L_0x0040:
                    com.parse.ParseUser r2 = r1.getUnresolvedUser()
                    if (r2 == 0) goto L_0x0023
                    boolean r3 = r2.isCurrentUser()
                    if (r3 == 0) goto L_0x0023
                    bolts.Task r5 = r2.saveAsync(r0)
                    com.parse.ParseObject$15$1 r0 = new com.parse.ParseObject$15$1
                    r0.<init>(r1, r2)
                    bolts.Task r5 = r5.onSuccess(r0)
                    return r5
                L_0x005a:
                    bolts.Task r5 = bolts.Task.forResult(r0)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseObject.C284215.then(bolts.Task):bolts.Task");
            }
        }).onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                return ParseObject.deepSaveAsync(list, task.getResult());
            }
        });
    }

    public static <T extends ParseObject> void saveAllInBackground(List<T> list, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(saveAllInBackground(list), (ParseCallback1<ParseException>) saveCallback);
    }

    private void setState(State state2, boolean z) {
        synchronized (this.mutex) {
            String objectId = this.state.objectId();
            String objectId2 = state2.objectId();
            this.state = state2;
            if (z && !ParseTextUtils.equals(objectId, objectId2)) {
                notifyObjectIdChanged(objectId, objectId2);
            }
            rebuildEstimatedData();
        }
    }

    public static void unpinAll() {
        ParseTaskUtils.wait(unpinAllInBackground());
    }

    public static void unpinAll(String str) {
        ParseTaskUtils.wait(unpinAllInBackground(str));
    }

    public static <T extends ParseObject> void unpinAll(String str, List<T> list) {
        ParseTaskUtils.wait(unpinAllInBackground(str, list));
    }

    public static <T extends ParseObject> void unpinAll(List<T> list) {
        ParseTaskUtils.wait(unpinAllInBackground(DEFAULT_PIN, list));
    }

    public static Task<Void> unpinAllInBackground() {
        return unpinAllInBackground(DEFAULT_PIN);
    }

    public static Task<Void> unpinAllInBackground(String str) {
        if (Parse.isLocalDatastoreEnabled()) {
            if (str == null) {
                str = DEFAULT_PIN;
            }
            return Parse.getLocalDatastore().unpinAllObjectsAsync(str);
        }
        throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }

    public static <T extends ParseObject> Task<Void> unpinAllInBackground(String str, List<T> list) {
        if (Parse.isLocalDatastoreEnabled()) {
            if (str == null) {
                str = DEFAULT_PIN;
            }
            return Parse.getLocalDatastore().unpinAllObjectsAsync(str, list);
        }
        throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }

    public static <T extends ParseObject> Task<Void> unpinAllInBackground(List<T> list) {
        return unpinAllInBackground(DEFAULT_PIN, list);
    }

    public static void unpinAllInBackground(DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(), (ParseCallback1<ParseException>) deleteCallback);
    }

    public static void unpinAllInBackground(String str, DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(str), (ParseCallback1<ParseException>) deleteCallback);
    }

    public static <T extends ParseObject> void unpinAllInBackground(String str, List<T> list, DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(str, list), (ParseCallback1<ParseException>) deleteCallback);
    }

    public static <T extends ParseObject> void unpinAllInBackground(List<T> list, DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(DEFAULT_PIN, list), (ParseCallback1<ParseException>) deleteCallback);
    }

    static void unregisterParseSubclasses() {
        unregisterSubclass(ParseUser.class);
        unregisterSubclass(ParseRole.class);
        unregisterSubclass(ParseInstallation.class);
        unregisterSubclass(ParseSession.class);
        unregisterSubclass(ParsePin.class);
        unregisterSubclass(EventuallyPin.class);
    }

    static void unregisterSubclass(Class<? extends ParseObject> cls) {
        getSubclassingController().unregisterSubclass(cls);
    }

    public void add(String str, Object obj) {
        addAll(str, Collections.singletonList(obj));
    }

    public void addAll(String str, Collection<?> collection) {
        performOperation(str, new ParseAddOperation(collection));
    }

    public void addAllUnique(String str, Collection<?> collection) {
        performOperation(str, new ParseAddUniqueOperation(collection));
    }

    public void addUnique(String str, Object obj) {
        addAllUnique(str, Collections.singletonList(obj));
    }

    /* access modifiers changed from: package-private */
    public void build(JSONObject jSONObject, ParseDecoder parseDecoder) {
        try {
            State.Builder builder = (State.Builder) new State.Builder(this.state).isComplete(true);
            builder.clear();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!next.equals(KEY_CLASS_NAME)) {
                    if (next.equals(KEY_OBJECT_ID)) {
                        builder.objectId(jSONObject.getString(next));
                    } else if (next.equals(KEY_CREATED_AT)) {
                        builder.createdAt(ParseDateFormat.getInstance().parse(jSONObject.getString(next)));
                    } else if (next.equals(KEY_UPDATED_AT)) {
                        builder.updatedAt(ParseDateFormat.getInstance().parse(jSONObject.getString(next)));
                    } else {
                        Object decode = parseDecoder.decode(jSONObject.get(next));
                        if (decode instanceof ParseFieldOperation) {
                            performOperation(next, (ParseFieldOperation) decode);
                        } else {
                            put(next, decode);
                        }
                    }
                }
            }
            setState(builder.build());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean containsKey(String str) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.estimatedData.containsKey(str);
        }
        return containsKey;
    }

    /* access modifiers changed from: package-private */
    public void copyChangesFrom(ParseObject parseObject) {
        synchronized (this.mutex) {
            ParseOperationSet first = parseObject.operationSetQueue.getFirst();
            for (String str : first.keySet()) {
                performOperation(str, (ParseFieldOperation) first.get(str));
            }
        }
    }

    public final void delete() {
        ParseTaskUtils.wait(deleteInBackground());
    }

    /* access modifiers changed from: package-private */
    public Task<Void> deleteAsync(String str) {
        return getObjectController().deleteAsync(getState(), str);
    }

    public final Task<Void> deleteEventually() {
        Task<JSONObject> enqueueEventuallyAsync;
        synchronized (this.mutex) {
            validateDelete();
            this.isDeletingEventually++;
            String str = null;
            if (getObjectId() == null) {
                str = getOrCreateLocalId();
            }
            ParseRESTObjectCommand deleteObjectCommand = ParseRESTObjectCommand.deleteObjectCommand(getState(), ParseUser.getCurrentSessionToken());
            deleteObjectCommand.setLocalId(str);
            enqueueEventuallyAsync = Parse.getEventuallyQueue().enqueueEventuallyAsync(deleteObjectCommand, this);
        }
        return Parse.isLocalDatastoreEnabled() ? enqueueEventuallyAsync.makeVoid() : enqueueEventuallyAsync.onSuccessTask(new Continuation<JSONObject, Task<Void>>() {
            public Task<Void> then(Task<JSONObject> task) {
                return ParseObject.this.handleDeleteEventuallyResultAsync();
            }
        });
    }

    public final void deleteEventually(DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(deleteEventually(), (ParseCallback1<ParseException>) deleteCallback);
    }

    public final Task<Void> deleteInBackground() {
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                final String result = task.getResult();
                return ParseObject.this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return ParseObject.this.deleteAsync(result, task);
                    }
                });
            }
        });
    }

    public final void deleteInBackground(DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(deleteInBackground(), (ParseCallback1<ParseException>) deleteCallback);
    }

    public int describeContents() {
        return 0;
    }

    public <T extends ParseObject> T fetch() {
        return (ParseObject) ParseTaskUtils.wait(fetchInBackground());
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<T> fetchAsync(final String str, Task<Void> task) {
        return task.onSuccessTask(new Continuation<Void, Task<State>>() {
            public Task<State> then(Task<Void> task) {
                State state;
                Map access$700;
                synchronized (ParseObject.this.mutex) {
                    state = ParseObject.this.getState();
                    access$700 = ParseObject.this.collectFetchedObjects();
                }
                return ParseObject.getObjectController().fetchAsync(state, str, new KnownParseObjectDecoder(access$700));
            }
        }).onSuccessTask(new Continuation<State, Task<Void>>() {
            public Task<Void> then(Task<State> task) {
                return ParseObject.this.handleFetchResultAsync(task.getResult());
            }
        }).onSuccess(new Continuation<Void, T>() {
            public T then(Task<Void> task) {
                return ParseObject.this;
            }
        });
    }

    public void fetchFromLocalDatastore() {
        ParseTaskUtils.wait(fetchFromLocalDatastoreAsync());
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<T> fetchFromLocalDatastoreAsync() {
        if (Parse.isLocalDatastoreEnabled()) {
            return Parse.getLocalDatastore().fetchLocallyAsync(this);
        }
        throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }

    public <T extends ParseObject> void fetchFromLocalDatastoreInBackground(GetCallback<T> getCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchFromLocalDatastoreAsync(), getCallback);
    }

    public <T extends ParseObject> T fetchIfNeeded() {
        return (ParseObject) ParseTaskUtils.wait(fetchIfNeededInBackground());
    }

    public final <T extends ParseObject> Task<T> fetchIfNeededInBackground() {
        return isDataAvailable() ? Task.forResult(this) : ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<T>>() {
            public Task<T> then(Task<String> task) {
                final String result = task.getResult();
                return ParseObject.this.taskQueue.enqueue(new Continuation<Void, Task<T>>() {
                    public Task<T> then(Task<Void> task) {
                        return ParseObject.this.isDataAvailable() ? Task.forResult(ParseObject.this) : ParseObject.this.fetchAsync(result, task);
                    }
                });
            }
        });
    }

    public final <T extends ParseObject> void fetchIfNeededInBackground(GetCallback<T> getCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchIfNeededInBackground(), getCallback);
    }

    public final <T extends ParseObject> Task<T> fetchInBackground() {
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<T>>() {
            public Task<T> then(Task<String> task) {
                final String result = task.getResult();
                return ParseObject.this.taskQueue.enqueue(new Continuation<Void, Task<T>>() {
                    public Task<T> then(Task<Void> task) {
                        return ParseObject.this.fetchAsync(result, task);
                    }
                });
            }
        });
    }

    public final <T extends ParseObject> void fetchInBackground(GetCallback<T> getCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(fetchInBackground(), getCallback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mutex
            monitor-enter(r0)
            java.lang.String r1 = "ACL"
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0011
            com.parse.ParseACL r4 = r3.getACL()     // Catch:{ all -> 0x0026 }
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r4
        L_0x0011:
            r3.checkGetAccess(r4)     // Catch:{ all -> 0x0026 }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r3.estimatedData     // Catch:{ all -> 0x0026 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0026 }
            boolean r2 = r1 instanceof com.parse.ParseRelation     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0024
            r2 = r1
            com.parse.ParseRelation r2 = (com.parse.ParseRelation) r2     // Catch:{ all -> 0x0026 }
            r2.ensureParentAndKey(r3, r4)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r1
        L_0x0026:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseObject.get(java.lang.String):java.lang.Object");
    }

    public ParseACL getACL() {
        return getACL(true);
    }

    public boolean getBoolean(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof Boolean)) {
                return false;
            }
            boolean booleanValue = ((Boolean) obj).booleanValue();
            return booleanValue;
        }
    }

    public byte[] getBytes(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof byte[])) {
                return null;
            }
            byte[] bArr = (byte[]) obj;
            return bArr;
        }
    }

    public String getClassName() {
        String className;
        synchronized (this.mutex) {
            className = this.state.className();
        }
        return className;
    }

    public Date getCreatedAt() {
        long createdAt = getState().createdAt();
        if (createdAt > 0) {
            return new Date(createdAt);
        }
        return null;
    }

    public Date getDate(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof Date)) {
                return null;
            }
            Date date = (Date) obj;
            return date;
        }
    }

    public double getDouble(String str) {
        Number number = getNumber(str);
        if (number == null) {
            return 0.0d;
        }
        return number.doubleValue();
    }

    public int getInt(String str) {
        Number number = getNumber(str);
        if (number == null) {
            return 0;
        }
        return number.intValue();
    }

    public JSONArray getJSONArray(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (obj instanceof List) {
                obj = PointerOrLocalIdEncoder.get().encode(obj);
            }
            if (!(obj instanceof JSONArray)) {
                return null;
            }
            JSONArray jSONArray = (JSONArray) obj;
            return jSONArray;
        }
    }

    public JSONObject getJSONObject(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (obj instanceof Map) {
                obj = PointerOrLocalIdEncoder.get().encode(obj);
            }
            if (!(obj instanceof JSONObject)) {
                return null;
            }
            JSONObject jSONObject = (JSONObject) obj;
            return jSONObject;
        }
    }

    public <T> List<T> getList(String str) {
        synchronized (this.mutex) {
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof List)) {
                return null;
            }
            List<T> list = (List) obj;
            return list;
        }
    }

    public long getLong(String str) {
        Number number = getNumber(str);
        if (number == null) {
            return 0;
        }
        return number.longValue();
    }

    public <V> Map<String, V> getMap(String str) {
        synchronized (this.mutex) {
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof Map)) {
                return null;
            }
            Map<String, V> map = (Map) obj;
            return map;
        }
    }

    public Number getNumber(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof Number)) {
                return null;
            }
            Number number = (Number) obj;
            return number;
        }
    }

    public String getObjectId() {
        String objectId;
        synchronized (this.mutex) {
            objectId = this.state.objectId();
        }
        return objectId;
    }

    /* access modifiers changed from: package-private */
    public String getOrCreateLocalId() {
        String str;
        synchronized (this.mutex) {
            if (this.localId == null) {
                if (this.state.objectId() == null) {
                    this.localId = getLocalIdManager().createLocalId();
                } else {
                    throw new IllegalStateException("Attempted to get a localId for an object with an objectId.");
                }
            }
            str = this.localId;
        }
        return str;
    }

    public ParseFile getParseFile(String str) {
        Object obj = get(str);
        if (!(obj instanceof ParseFile)) {
            return null;
        }
        return (ParseFile) obj;
    }

    public ParseGeoPoint getParseGeoPoint(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof ParseGeoPoint)) {
                return null;
            }
            ParseGeoPoint parseGeoPoint = (ParseGeoPoint) obj;
            return parseGeoPoint;
        }
    }

    public ParseObject getParseObject(String str) {
        Object obj = get(str);
        if (!(obj instanceof ParseObject)) {
            return null;
        }
        return (ParseObject) obj;
    }

    public ParsePolygon getParsePolygon(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof ParsePolygon)) {
                return null;
            }
            ParsePolygon parsePolygon = (ParsePolygon) obj;
            return parsePolygon;
        }
    }

    public ParseUser getParseUser(String str) {
        Object obj = get(str);
        if (!(obj instanceof ParseUser)) {
            return null;
        }
        return (ParseUser) obj;
    }

    public <T extends ParseObject> ParseRelation<T> getRelation(String str) {
        synchronized (this.mutex) {
            Object obj = this.estimatedData.get(str);
            if (obj instanceof ParseRelation) {
                ParseRelation<T> parseRelation = (ParseRelation) obj;
                parseRelation.ensureParentAndKey(this, str);
                return parseRelation;
            }
            ParseRelation<T> parseRelation2 = new ParseRelation<>(this, str);
            this.estimatedData.put(str, parseRelation2);
            return parseRelation2;
        }
    }

    /* access modifiers changed from: package-private */
    public State getState() {
        State state2;
        synchronized (this.mutex) {
            state2 = this.state;
        }
        return state2;
    }

    public String getString(String str) {
        synchronized (this.mutex) {
            checkGetAccess(str);
            Object obj = this.estimatedData.get(str);
            if (!(obj instanceof String)) {
                return null;
            }
            String str2 = (String) obj;
            return str2;
        }
    }

    public Date getUpdatedAt() {
        long updatedAt = getState().updatedAt();
        if (updatedAt > 0) {
            return new Date(updatedAt);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> handleDeleteEventuallyResultAsync() {
        synchronized (this.mutex) {
            this.isDeletingEventually--;
        }
        return handleDeleteResultAsync().onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                Parse.getEventuallyQueue().notifyTestHelper(6);
                return task;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Task<Void> handleDeleteResultAsync() {
        Task<Void> forResult = Task.forResult(null);
        synchronized (this.mutex) {
            this.isDeleted = true;
        }
        final OfflineStore localDatastore = Parse.getLocalDatastore();
        return localDatastore != null ? forResult.continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                synchronized (ParseObject.this.mutex) {
                    if (ParseObject.this.isDeleted) {
                        localDatastore.unregisterObject(ParseObject.this);
                        Task<Void> deleteDataForObjectAsync = localDatastore.deleteDataForObjectAsync(ParseObject.this);
                        return deleteDataForObjectAsync;
                    }
                    Task<Void> updateDataForObjectAsync = localDatastore.updateDataForObjectAsync(ParseObject.this);
                    return updateDataForObjectAsync;
                }
            }
        }) : forResult;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> handleFetchResultAsync(final State state2) {
        Task forResult = Task.forResult(null);
        final OfflineStore localDatastore = Parse.getLocalDatastore();
        if (localDatastore != null) {
            forResult = forResult.onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return localDatastore.fetchLocallyAsync(ParseObject.this).makeVoid();
                }
            }).continueWithTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    if (!(task.getError() instanceof ParseException) || ((ParseException) task.getError()).getCode() != 120) {
                        return task;
                    }
                    return null;
                }
            });
        }
        Task<Void> onSuccessTask = forResult.onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                synchronized (ParseObject.this.mutex) {
                    ParseObject.this.setState(state2.isComplete() ? state2 : ParseObject.this.getState().newBuilder().apply(state2).build());
                }
                return null;
            }
        });
        return localDatastore != null ? onSuccessTask.onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return localDatastore.updateDataForObjectAsync(ParseObject.this);
            }
        }).continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                if (!(task.getError() instanceof ParseException) || ((ParseException) task.getError()).getCode() != 120) {
                    return task;
                }
                return null;
            }
        }) : onSuccessTask;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> handleSaveEventuallyResultAsync(JSONObject jSONObject, ParseOperationSet parseOperationSet) {
        final boolean z = jSONObject != null;
        return handleSaveResultAsync(jSONObject, parseOperationSet).onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                if (z) {
                    Parse.getEventuallyQueue().notifyTestHelper(5);
                }
                return task;
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r7 = r0.continueWith(new com.parse.ParseObject.C285525(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r1 == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        r7 = r7.onSuccessTask(new com.parse.ParseObject.C285626(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
        return r7.onSuccess(new com.parse.ParseObject.C285727(r6));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bolts.Task<java.lang.Void> handleSaveResultAsync(final com.parse.ParseObject.State r7, final com.parse.ParseOperationSet r8) {
        /*
            r6 = this;
            r0 = 0
            bolts.Task r0 = bolts.Task.forResult(r0)
            com.parse.OfflineStore r1 = com.parse.Parse.getLocalDatastore()
            if (r1 == 0) goto L_0x0014
            com.parse.ParseObject$23 r2 = new com.parse.ParseObject$23
            r2.<init>(r1)
            bolts.Task r0 = r0.onSuccessTask(r2)
        L_0x0014:
            if (r7 == 0) goto L_0x0018
            r2 = 1
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            java.lang.Object r3 = r6.mutex
            monitor-enter(r3)
            java.util.LinkedList<com.parse.ParseOperationSet> r4 = r6.operationSetQueue     // Catch:{ all -> 0x0065 }
            java.util.LinkedList<com.parse.ParseOperationSet> r5 = r6.operationSetQueue     // Catch:{ all -> 0x0065 }
            int r5 = r5.indexOf(r8)     // Catch:{ all -> 0x0065 }
            java.util.ListIterator r4 = r4.listIterator(r5)     // Catch:{ all -> 0x0065 }
            r4.next()     // Catch:{ all -> 0x0065 }
            r4.remove()     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0046
            java.lang.Object r7 = r4.next()     // Catch:{ all -> 0x0065 }
            com.parse.ParseOperationSet r7 = (com.parse.ParseOperationSet) r7     // Catch:{ all -> 0x0065 }
            r7.mergeFrom(r8)     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0044
            com.parse.ParseObject$24 r7 = new com.parse.ParseObject$24     // Catch:{ all -> 0x0065 }
            r7.<init>(r1)     // Catch:{ all -> 0x0065 }
            bolts.Task r0 = r0.continueWithTask(r7)     // Catch:{ all -> 0x0065 }
        L_0x0044:
            monitor-exit(r3)     // Catch:{ all -> 0x0065 }
            return r0
        L_0x0046:
            monitor-exit(r3)     // Catch:{ all -> 0x0065 }
            com.parse.ParseObject$25 r2 = new com.parse.ParseObject$25
            r2.<init>(r7, r8)
            bolts.Task r7 = r0.continueWith(r2)
            if (r1 == 0) goto L_0x005b
            com.parse.ParseObject$26 r8 = new com.parse.ParseObject$26
            r8.<init>(r1)
            bolts.Task r7 = r7.onSuccessTask(r8)
        L_0x005b:
            com.parse.ParseObject$27 r8 = new com.parse.ParseObject$27
            r8.<init>()
            bolts.Task r7 = r7.onSuccess(r8)
            return r7
        L_0x0065:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0065 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseObject.handleSaveResultAsync(com.parse.ParseObject$State, com.parse.ParseOperationSet):bolts.Task");
    }

    /* access modifiers changed from: package-private */
    public Task<Void> handleSaveResultAsync(JSONObject jSONObject, ParseOperationSet parseOperationSet) {
        State state2;
        if (jSONObject != null) {
            synchronized (this.mutex) {
                state2 = ParseObjectCoder.get().decode(getState().newBuilder().clear(), jSONObject, new KnownParseObjectDecoder(collectFetchedObjects())).isComplete(false).build();
            }
        } else {
            state2 = null;
        }
        return handleSaveResultAsync(state2, parseOperationSet);
    }

    public boolean has(String str) {
        return containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public boolean hasChanges() {
        boolean z;
        synchronized (this.mutex) {
            z = currentOperations().size() > 0;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean hasOutstandingOperations() {
        boolean z;
        synchronized (this.mutex) {
            z = true;
            if (this.operationSetQueue.size() <= 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean hasSameId(ParseObject parseObject) {
        boolean z;
        synchronized (this.mutex) {
            z = getClassName() != null && getObjectId() != null && getClassName().equals(parseObject.getClassName()) && getObjectId().equals(parseObject.getObjectId());
        }
        return z;
    }

    public void increment(String str) {
        increment(str, 1);
    }

    public void increment(String str, Number number) {
        performOperation(str, new ParseIncrementOperation(number));
    }

    public boolean isDataAvailable() {
        boolean isComplete;
        synchronized (this.mutex) {
            isComplete = this.state.isComplete();
        }
        return isComplete;
    }

    public boolean isDataAvailable(String str) {
        boolean z;
        synchronized (this.mutex) {
            if (!isDataAvailable() && !this.state.availableKeys().contains(str)) {
                if (!this.estimatedData.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isDirty() {
        return isDirty(true);
    }

    public boolean isDirty(String str) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = currentOperations().containsKey(str);
        }
        return containsKey;
    }

    /* access modifiers changed from: package-private */
    public boolean isDirty(boolean z) {
        boolean z2;
        synchronized (this.mutex) {
            if (!this.isDeleted && getObjectId() != null && !hasChanges()) {
                if (!z || !hasDirtyChildren()) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean isKeyMutable(String str) {
        return true;
    }

    public Set<String> keySet() {
        Set<String> unmodifiableSet;
        synchronized (this.mutex) {
            unmodifiableSet = Collections.unmodifiableSet(this.estimatedData.keySet());
        }
        return unmodifiableSet;
    }

    /* access modifiers changed from: package-private */
    public void markAllFieldsDirty() {
        synchronized (this.mutex) {
            for (String next : this.state.keySet()) {
                performPut(next, this.state.get(next));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeFromObject(ParseObject parseObject) {
        synchronized (this.mutex) {
            if (this != parseObject) {
                setState(parseObject.getState().newBuilder().build(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[Catch:{ JSONException -> 0x0136 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.parse.ParseObject.State mergeFromServer(com.parse.ParseObject.State r11, org.json.JSONObject r12, com.parse.ParseDecoder r13, boolean r14) {
        /*
            r10 = this;
            com.parse.ParseObject$State$Init r0 = r11.newBuilder()     // Catch:{ JSONException -> 0x0136 }
            if (r14 == 0) goto L_0x0009
            r0.clear()     // Catch:{ JSONException -> 0x0136 }
        L_0x0009:
            boolean r11 = r11.isComplete()     // Catch:{ JSONException -> 0x0136 }
            r1 = 0
            r2 = 1
            if (r11 != 0) goto L_0x0016
            if (r14 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r11 = 0
            goto L_0x0017
        L_0x0016:
            r11 = 1
        L_0x0017:
            r0.isComplete(r11)     // Catch:{ JSONException -> 0x0136 }
            java.util.Iterator r11 = r12.keys()     // Catch:{ JSONException -> 0x0136 }
        L_0x001e:
            boolean r14 = r11.hasNext()     // Catch:{ JSONException -> 0x0136 }
            if (r14 == 0) goto L_0x0131
            java.lang.Object r14 = r11.next()     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r3 = "__type"
            boolean r3 = r14.equals(r3)     // Catch:{ JSONException -> 0x0136 }
            if (r3 != 0) goto L_0x001e
            java.lang.String r3 = "className"
            boolean r3 = r14.equals(r3)     // Catch:{ JSONException -> 0x0136 }
            if (r3 == 0) goto L_0x003b
            goto L_0x001e
        L_0x003b:
            java.lang.String r3 = "objectId"
            boolean r3 = r14.equals(r3)     // Catch:{ JSONException -> 0x0136 }
            if (r3 == 0) goto L_0x004b
            java.lang.String r14 = r12.getString(r14)     // Catch:{ JSONException -> 0x0136 }
            r0.objectId(r14)     // Catch:{ JSONException -> 0x0136 }
            goto L_0x001e
        L_0x004b:
            java.lang.String r3 = "createdAt"
            boolean r3 = r14.equals(r3)     // Catch:{ JSONException -> 0x0136 }
            if (r3 == 0) goto L_0x0063
            com.parse.ParseDateFormat r3 = com.parse.ParseDateFormat.getInstance()     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r14 = r12.getString(r14)     // Catch:{ JSONException -> 0x0136 }
            java.util.Date r14 = r3.parse(r14)     // Catch:{ JSONException -> 0x0136 }
            r0.createdAt((java.util.Date) r14)     // Catch:{ JSONException -> 0x0136 }
            goto L_0x001e
        L_0x0063:
            java.lang.String r3 = "updatedAt"
            boolean r3 = r14.equals(r3)     // Catch:{ JSONException -> 0x0136 }
            if (r3 == 0) goto L_0x007b
            com.parse.ParseDateFormat r3 = com.parse.ParseDateFormat.getInstance()     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r14 = r12.getString(r14)     // Catch:{ JSONException -> 0x0136 }
            java.util.Date r14 = r3.parse(r14)     // Catch:{ JSONException -> 0x0136 }
            r0.updatedAt((java.util.Date) r14)     // Catch:{ JSONException -> 0x0136 }
            goto L_0x001e
        L_0x007b:
            java.lang.String r3 = "ACL"
            boolean r3 = r14.equals(r3)     // Catch:{ JSONException -> 0x0136 }
            if (r3 == 0) goto L_0x0091
            org.json.JSONObject r14 = r12.getJSONObject(r14)     // Catch:{ JSONException -> 0x0136 }
            com.parse.ParseACL r14 = com.parse.ParseACL.createACLFromJSONObject(r14, r13)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r3 = "ACL"
            r0.put(r3, r14)     // Catch:{ JSONException -> 0x0136 }
            goto L_0x001e
        L_0x0091:
            java.lang.String r3 = "__selectedKeys"
            boolean r3 = r14.equals(r3)     // Catch:{ JSONException -> 0x0136 }
            if (r3 == 0) goto L_0x00ce
            org.json.JSONArray r14 = r12.getJSONArray(r14)     // Catch:{ JSONException -> 0x0136 }
            int r3 = r14.length()     // Catch:{ JSONException -> 0x0136 }
            if (r3 <= 0) goto L_0x001e
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ JSONException -> 0x0136 }
            r3.<init>()     // Catch:{ JSONException -> 0x0136 }
            r4 = 0
        L_0x00a9:
            int r5 = r14.length()     // Catch:{ JSONException -> 0x0136 }
            if (r4 >= r5) goto L_0x00c9
            java.lang.String r5 = r14.getString(r4)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r6 = "."
            boolean r6 = r5.contains(r6)     // Catch:{ JSONException -> 0x0136 }
            if (r6 == 0) goto L_0x00c3
            java.lang.String r6 = "\\."
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ JSONException -> 0x0136 }
            r5 = r5[r1]     // Catch:{ JSONException -> 0x0136 }
        L_0x00c3:
            r3.add(r5)     // Catch:{ JSONException -> 0x0136 }
            int r4 = r4 + 1
            goto L_0x00a9
        L_0x00c9:
            r0.availableKeys(r3)     // Catch:{ JSONException -> 0x0136 }
            goto L_0x001e
        L_0x00ce:
            java.lang.Object r3 = r12.get(r14)     // Catch:{ JSONException -> 0x0136 }
            boolean r4 = r3 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0136 }
            if (r4 == 0) goto L_0x0128
            java.lang.String r4 = "__selectedKeys"
            boolean r4 = r12.has(r4)     // Catch:{ JSONException -> 0x0136 }
            if (r4 == 0) goto L_0x0128
            java.lang.String r4 = "__selectedKeys"
            org.json.JSONArray r4 = r12.getJSONArray(r4)     // Catch:{ JSONException -> 0x0136 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0136 }
            r5.<init>()     // Catch:{ JSONException -> 0x0136 }
            r6 = 0
        L_0x00ea:
            int r7 = r4.length()     // Catch:{ JSONException -> 0x0136 }
            if (r6 >= r7) goto L_0x011a
            java.lang.String r7 = r4.getString(r6)     // Catch:{ JSONException -> 0x0136 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0136 }
            r8.<init>()     // Catch:{ JSONException -> 0x0136 }
            r8.append(r14)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r9 = "."
            r8.append(r9)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0136 }
            boolean r8 = r7.startsWith(r8)     // Catch:{ JSONException -> 0x0136 }
            if (r8 == 0) goto L_0x0117
            int r8 = r14.length()     // Catch:{ JSONException -> 0x0136 }
            int r8 = r8 + r2
            java.lang.String r7 = r7.substring(r8)     // Catch:{ JSONException -> 0x0136 }
            r5.put(r7)     // Catch:{ JSONException -> 0x0136 }
        L_0x0117:
            int r6 = r6 + 1
            goto L_0x00ea
        L_0x011a:
            int r4 = r5.length()     // Catch:{ JSONException -> 0x0136 }
            if (r4 <= 0) goto L_0x0128
            r4 = r3
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r6 = "__selectedKeys"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0136 }
        L_0x0128:
            java.lang.Object r3 = r13.decode(r3)     // Catch:{ JSONException -> 0x0136 }
            r0.put(r14, r3)     // Catch:{ JSONException -> 0x0136 }
            goto L_0x001e
        L_0x0131:
            com.parse.ParseObject$State r11 = r0.build()     // Catch:{ JSONException -> 0x0136 }
            return r11
        L_0x0136:
            r11 = move-exception
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseObject.mergeFromServer(com.parse.ParseObject$State, org.json.JSONObject, com.parse.ParseDecoder, boolean):com.parse.ParseObject$State");
    }

    /* access modifiers changed from: package-private */
    public void mergeREST(State state2, JSONObject jSONObject, ParseDecoder parseDecoder) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mutex) {
            try {
                boolean z = jSONObject.getBoolean(KEY_COMPLETE);
                this.isDeletingEventually = ParseJSONUtils.getInt(jSONObject, Arrays.asList(new String[]{KEY_IS_DELETING_EVENTUALLY, KEY_IS_DELETING_EVENTUALLY_OLD}));
                JSONArray jSONArray = jSONObject.getJSONArray(KEY_OPERATIONS);
                ParseOperationSet currentOperations = currentOperations();
                this.operationSetQueue.clear();
                ParseOperationSet parseOperationSet = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    ParseOperationSet fromRest = ParseOperationSet.fromRest(jSONArray.getJSONObject(i), parseDecoder);
                    if (fromRest.isSaveEventually()) {
                        if (parseOperationSet != null) {
                            this.operationSetQueue.add(parseOperationSet);
                            parseOperationSet = null;
                        }
                        arrayList.add(fromRest);
                        this.operationSetQueue.add(fromRest);
                    } else {
                        if (parseOperationSet != null) {
                            fromRest.mergeFrom(parseOperationSet);
                        }
                        parseOperationSet = fromRest;
                    }
                }
                if (parseOperationSet != null) {
                    this.operationSetQueue.add(parseOperationSet);
                }
                currentOperations().mergeFrom(currentOperations);
                boolean z2 = true;
                if (state2.updatedAt() >= 0) {
                    if (jSONObject.has(KEY_UPDATED_AT)) {
                        if (new Date(state2.updatedAt()).compareTo(ParseDateFormat.getInstance().parse(jSONObject.getString(KEY_UPDATED_AT))) < 0) {
                        }
                    }
                    z2 = false;
                }
                if (z2) {
                    setState(mergeFromServer(state2, ParseJSONUtils.create(jSONObject, Arrays.asList(new String[]{KEY_COMPLETE, KEY_IS_DELETING_EVENTUALLY, KEY_IS_DELETING_EVENTUALLY_OLD, KEY_OPERATIONS})), parseDecoder, z));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            enqueueSaveEventuallyOperationAsync((ParseOperationSet) it.next());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean needsDefaultACL() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public State.Init<?> newStateBuilder(String str) {
        return new State.Builder(str);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public void performOperation(String str, ParseFieldOperation parseFieldOperation) {
        synchronized (this.mutex) {
            Object apply = parseFieldOperation.apply(this.estimatedData.get(str), str);
            if (apply != null) {
                this.estimatedData.put(str, apply);
            } else {
                this.estimatedData.remove(str);
            }
            currentOperations().put(str, parseFieldOperation.mergeWithPrevious((ParseFieldOperation) currentOperations().get(str)));
        }
    }

    /* access modifiers changed from: package-private */
    public void performPut(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("key may not be null.");
        } else if (obj != null) {
            if (obj instanceof JSONObject) {
                obj = ParseDecoder.get().convertJSONObjectToMap((JSONObject) obj);
            } else if (obj instanceof JSONArray) {
                obj = ParseDecoder.get().convertJSONArrayToList((JSONArray) obj);
            }
            if (ParseEncoder.isValidType(obj)) {
                performOperation(str, new ParseSetOperation(obj));
                return;
            }
            throw new IllegalArgumentException("invalid type for value: " + obj.getClass().toString());
        } else {
            throw new IllegalArgumentException("value may not be null.");
        }
    }

    /* access modifiers changed from: package-private */
    public void performRemove(String str) {
        synchronized (this.mutex) {
            if (get(str) != null) {
                performOperation(str, ParseDeleteOperation.getInstance());
            }
        }
    }

    public void pin() {
        ParseTaskUtils.wait(pinInBackground());
    }

    public void pin(String str) {
        ParseTaskUtils.wait(pinInBackground(str));
    }

    public Task<Void> pinInBackground() {
        return pinAllInBackground(DEFAULT_PIN, Collections.singletonList(this));
    }

    public Task<Void> pinInBackground(String str) {
        return pinAllInBackground(str, Collections.singletonList(this));
    }

    /* access modifiers changed from: package-private */
    public Task<Void> pinInBackground(String str, boolean z) {
        return pinAllInBackground(str, Collections.singletonList(this), z);
    }

    public void pinInBackground(SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(pinInBackground(), (ParseCallback1<ParseException>) saveCallback);
    }

    public void pinInBackground(String str, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(pinInBackground(str), (ParseCallback1<ParseException>) saveCallback);
    }

    public void put(String str, Object obj) {
        checkKeyIsMutable(str);
        performPut(str, obj);
    }

    /* access modifiers changed from: package-private */
    public void registerSaveListener(GetCallback<ParseObject> getCallback) {
        synchronized (this.mutex) {
            this.saveEvent.subscribe(getCallback);
        }
    }

    public void remove(String str) {
        checkKeyIsMutable(str);
        performRemove(str);
    }

    public void removeAll(String str, Collection<?> collection) {
        checkKeyIsMutable(str);
        performOperation(str, new ParseRemoveOperation(collection));
    }

    public void revert() {
        synchronized (this.mutex) {
            if (isDirty()) {
                currentOperations().clear();
                rebuildEstimatedData();
            }
        }
    }

    public void revert(String str) {
        synchronized (this.mutex) {
            if (isDirty(str)) {
                currentOperations().remove(str);
                rebuildEstimatedData();
            }
        }
    }

    public final void save() {
        ParseTaskUtils.wait(saveInBackground());
    }

    /* access modifiers changed from: package-private */
    public Task<JSONObject> saveAsync(ParseHttpClient parseHttpClient, ParseOperationSet parseOperationSet, String str) {
        return currentSaveEventuallyCommand(parseOperationSet, PointerEncoder.get(), str).executeAsync(parseHttpClient);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(final String str) {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseObject.this.saveAsync(str, task);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(final String str, Task<Void> task) {
        final ParseOperationSet startSave;
        Task<Void> deepSaveAsync;
        if (!isDirty()) {
            return Task.forResult(null);
        }
        synchronized (this.mutex) {
            updateBeforeSave();
            validateSave();
            startSave = startSave();
        }
        synchronized (this.mutex) {
            deepSaveAsync = deepSaveAsync(this.estimatedData, str);
        }
        return deepSaveAsync.onSuccessTask(TaskQueue.waitFor(task)).onSuccessTask(new Continuation<Void, Task<State>>() {
            public Task<State> then(Task<Void> task) {
                return ParseObject.getObjectController().saveAsync(ParseObject.this.getState(), startSave, str, new KnownParseObjectDecoder(ParseObject.this.collectFetchedObjects()));
            }
        }).continueWithTask(new Continuation<State, Task<Void>>() {
            public Task<Void> then(final Task<State> task) {
                return ParseObject.this.handleSaveResultAsync(task.getResult(), startSave).continueWithTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return (task.isFaulted() || task.isCancelled()) ? task : task.makeVoid();
                    }
                });
            }
        });
    }

    public final Task<Void> saveEventually() {
        final ParseOperationSet startSave;
        ParseRESTObjectCommand currentSaveEventuallyCommand;
        String str = null;
        if (!isDirty()) {
            Parse.getEventuallyQueue().fakeObjectUpdate();
            return Task.forResult(null);
        }
        synchronized (this.mutex) {
            updateBeforeSave();
            try {
                validateSaveEventually();
                ArrayList<ParseObject> arrayList = new ArrayList<>();
                collectDirtyChildren(this.estimatedData, arrayList, (Collection<ParseFile>) null);
                if (getObjectId() == null) {
                    str = getOrCreateLocalId();
                }
                startSave = startSave();
                startSave.setIsSaveEventually(true);
                currentSaveEventuallyCommand = currentSaveEventuallyCommand(startSave, PointerOrLocalIdEncoder.get(), ParseUser.getCurrentSessionToken());
                currentSaveEventuallyCommand.setLocalId(str);
                currentSaveEventuallyCommand.setOperationSetUUID(startSave.getUUID());
                currentSaveEventuallyCommand.retainLocalIds();
                for (ParseObject saveEventually : arrayList) {
                    saveEventually.saveEventually();
                }
            } catch (ParseException e) {
                return Task.forError(e);
            }
        }
        Task<JSONObject> enqueueEventuallyAsync = Parse.getEventuallyQueue().enqueueEventuallyAsync(currentSaveEventuallyCommand, this);
        enqueueSaveEventuallyOperationAsync(startSave);
        currentSaveEventuallyCommand.releaseLocalIds();
        return Parse.isLocalDatastoreEnabled() ? enqueueEventuallyAsync.makeVoid() : enqueueEventuallyAsync.onSuccessTask(new Continuation<JSONObject, Task<Void>>() {
            public Task<Void> then(Task<JSONObject> task) {
                return ParseObject.this.handleSaveEventuallyResultAsync(task.getResult(), startSave);
            }
        });
    }

    public final void saveEventually(SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(saveEventually(), (ParseCallback1<ParseException>) saveCallback);
    }

    public final Task<Void> saveInBackground() {
        return ParseUser.getCurrentUserAsync().onSuccessTask(new Continuation<ParseUser, Task<String>>() {
            public Task<String> then(Task<ParseUser> task) {
                ParseUser result = task.getResult();
                if (result == null) {
                    return Task.forResult(null);
                }
                if (!result.isLazy()) {
                    return Task.forResult(result.getSessionToken());
                }
                if (!ParseObject.this.isDataAvailable(ParseObject.KEY_ACL)) {
                    return Task.forResult(null);
                }
                final ParseACL access$900 = ParseObject.this.getACL(false);
                if (access$900 == null) {
                    return Task.forResult(null);
                }
                final ParseUser unresolvedUser = access$900.getUnresolvedUser();
                return (unresolvedUser == null || !unresolvedUser.isCurrentUser()) ? Task.forResult(null) : unresolvedUser.saveAsync((String) null).onSuccess(new Continuation<Void, String>() {
                    public String then(Task<Void> task) {
                        if (!access$900.hasUnresolvedUser()) {
                            return unresolvedUser.getSessionToken();
                        }
                        throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
                    }
                });
            }
        }).onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                return ParseObject.this.saveAsync(task.getResult());
            }
        });
    }

    public final void saveInBackground(SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(), (ParseCallback1<ParseException>) saveCallback);
    }

    public void setACL(ParseACL parseACL) {
        put(KEY_ACL, parseACL);
    }

    /* access modifiers changed from: package-private */
    public void setDefaultValues() {
        if (needsDefaultACL() && ParseACL.getDefaultACL() != null) {
            setACL(ParseACL.getDefaultACL());
        }
    }

    public void setObjectId(String str) {
        synchronized (this.mutex) {
            String objectId = this.state.objectId();
            if (!ParseTextUtils.equals(objectId, str)) {
                this.state = this.state.newBuilder().objectId(str).build();
                notifyObjectIdChanged(objectId, str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setState(State state2) {
        synchronized (this.mutex) {
            setState(state2, true);
        }
    }

    /* access modifiers changed from: package-private */
    public ParseOperationSet startSave() {
        ParseOperationSet currentOperations;
        synchronized (this.mutex) {
            currentOperations = currentOperations();
            this.operationSetQueue.addLast(new ParseOperationSet());
        }
        return currentOperations;
    }

    /* access modifiers changed from: package-private */
    public <T extends State> JSONObject toJSONObjectForSaving(T t, ParseOperationSet parseOperationSet, ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : parseOperationSet.keySet()) {
                jSONObject.put(str, parseEncoder.encode((ParseFieldOperation) parseOperationSet.get(str)));
            }
            if (t.objectId() != null) {
                jSONObject.put(KEY_OBJECT_ID, t.objectId());
            }
            return jSONObject;
        } catch (JSONException unused) {
            throw new RuntimeException("could not serialize object to JSON");
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject toRest(ParseEncoder parseEncoder) {
        State state2;
        ArrayList arrayList;
        synchronized (this.mutex) {
            state2 = getState();
            int size = this.operationSetQueue.size();
            arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(new ParseOperationSet(this.operationSetQueue.get(i)));
            }
        }
        return toRest(state2, arrayList, parseEncoder);
    }

    /* access modifiers changed from: package-private */
    public JSONObject toRest(State state2, List<ParseOperationSet> list, ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CLASS_NAME, state2.className());
            if (state2.objectId() != null) {
                jSONObject.put(KEY_OBJECT_ID, state2.objectId());
            }
            if (state2.createdAt() > 0) {
                jSONObject.put(KEY_CREATED_AT, ParseDateFormat.getInstance().format(new Date(state2.createdAt())));
            }
            if (state2.updatedAt() > 0) {
                jSONObject.put(KEY_UPDATED_AT, ParseDateFormat.getInstance().format(new Date(state2.updatedAt())));
            }
            for (String next : state2.keySet()) {
                jSONObject.put(next, parseEncoder.encode(state2.get(next)));
            }
            jSONObject.put(KEY_COMPLETE, state2.isComplete());
            jSONObject.put(KEY_IS_DELETING_EVENTUALLY, this.isDeletingEventually);
            jSONObject.put(KEY_SELECTED_KEYS, new JSONArray(state2.availableKeys()));
            JSONArray jSONArray = new JSONArray();
            for (ParseOperationSet rest : list) {
                jSONArray.put(rest.toRest(parseEncoder));
            }
            jSONObject.put(KEY_OPERATIONS, jSONArray);
            return jSONObject;
        } catch (JSONException unused) {
            throw new RuntimeException("could not serialize object to JSON");
        }
    }

    public void unpin() {
        ParseTaskUtils.wait(unpinInBackground());
    }

    public void unpin(String str) {
        ParseTaskUtils.wait(unpinInBackground(str));
    }

    public Task<Void> unpinInBackground() {
        return unpinAllInBackground(DEFAULT_PIN, Collections.singletonList(this));
    }

    public Task<Void> unpinInBackground(String str) {
        return unpinAllInBackground(str, Collections.singletonList(this));
    }

    public void unpinInBackground(DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinInBackground(), (ParseCallback1<ParseException>) deleteCallback);
    }

    public void unpinInBackground(String str, DeleteCallback deleteCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(unpinInBackground(str), (ParseCallback1<ParseException>) deleteCallback);
    }

    /* access modifiers changed from: package-private */
    public void unregisterSaveListener(GetCallback<ParseObject> getCallback) {
        synchronized (this.mutex) {
            this.saveEvent.unsubscribe(getCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateBeforeSave() {
    }

    /* access modifiers changed from: package-private */
    public void validateDelete() {
    }

    /* access modifiers changed from: package-private */
    public void validateSave() {
    }

    /* access modifiers changed from: package-private */
    public void validateSaveEventually() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, (ParseParcelEncoder) new ParseObjectParcelEncoder(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(android.os.Parcel r7, com.parse.ParseParcelEncoder r8) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mutex
            monitor-enter(r0)
            boolean r1 = com.parse.Parse.isLocalDatastoreEnabled()     // Catch:{ all -> 0x00a8 }
            r6.ldsEnabledWhenParceling = r1     // Catch:{ all -> 0x00a8 }
            boolean r1 = r6.hasOutstandingOperations()     // Catch:{ all -> 0x00a8 }
            boolean r2 = r6.isDeleting     // Catch:{ all -> 0x00a8 }
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x001a
            int r2 = r6.isDeletingEventually     // Catch:{ all -> 0x00a8 }
            if (r2 <= 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r2 = 0
            goto L_0x001b
        L_0x001a:
            r2 = 1
        L_0x001b:
            if (r1 == 0) goto L_0x0024
            java.lang.String r1 = "ParseObject"
            java.lang.String r5 = "About to parcel a ParseObject while a save / saveEventually operation is going on. If recovered from LDS, the unparceled object will be internally updated when these tasks end. If not, it will act as if these tasks have failed. This means that the subsequent call to save() will update again the same keys, and this is dangerous for certain operations, like increment(). To avoid inconsistencies, wait for operations to end before parceling."
            com.parse.PLog.m8822w(r1, r5)     // Catch:{ all -> 0x00a8 }
        L_0x0024:
            if (r2 == 0) goto L_0x002d
            java.lang.String r1 = "ParseObject"
            java.lang.String r2 = "About to parcel a ParseObject while a delete / deleteEventually operation is going on. If recovered from LDS, the unparceled object will be internally updated when these tasks end. If not, it will assume it's not deleted, and might incorrectly return false for isDirty(). To avoid inconsistencies, wait for operations to end before parceling."
            com.parse.PLog.m8822w(r1, r2)     // Catch:{ all -> 0x00a8 }
        L_0x002d:
            java.lang.String r1 = r6.getClassName()     // Catch:{ all -> 0x00a8 }
            r7.writeString(r1)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = r6.getObjectId()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x003c
            r2 = 1
            goto L_0x003d
        L_0x003c:
            r2 = 0
        L_0x003d:
            r7.writeByte(r2)     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0045
            r7.writeString(r1)     // Catch:{ all -> 0x00a8 }
        L_0x0045:
            com.parse.ParseObject$State r1 = r6.state     // Catch:{ all -> 0x00a8 }
            r1.writeToParcel(r7, r8)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = r6.localId     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0050
            r1 = 1
            goto L_0x0051
        L_0x0050:
            r1 = 0
        L_0x0051:
            r7.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = r6.localId     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r6.localId     // Catch:{ all -> 0x00a8 }
            r7.writeString(r1)     // Catch:{ all -> 0x00a8 }
        L_0x005d:
            boolean r1 = r6.isDeleted     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r3 = 0
        L_0x0063:
            r7.writeByte(r3)     // Catch:{ all -> 0x00a8 }
            boolean r1 = r6.hasOutstandingOperations()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x008d
            com.parse.ParseOperationSet r1 = new com.parse.ParseOperationSet     // Catch:{ all -> 0x00a8 }
            r1.<init>()     // Catch:{ all -> 0x00a8 }
            java.util.LinkedList<com.parse.ParseOperationSet> r2 = r6.operationSetQueue     // Catch:{ all -> 0x00a8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00a8 }
        L_0x0077:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00a8 }
            if (r3 == 0) goto L_0x0095
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00a8 }
            com.parse.ParseOperationSet r3 = (com.parse.ParseOperationSet) r3     // Catch:{ all -> 0x00a8 }
            com.parse.ParseOperationSet r5 = new com.parse.ParseOperationSet     // Catch:{ all -> 0x00a8 }
            r5.<init>((com.parse.ParseOperationSet) r3)     // Catch:{ all -> 0x00a8 }
            r5.mergeFrom(r1)     // Catch:{ all -> 0x00a8 }
            r1 = r5
            goto L_0x0077
        L_0x008d:
            java.util.LinkedList<com.parse.ParseOperationSet> r1 = r6.operationSetQueue     // Catch:{ all -> 0x00a8 }
            java.lang.Object r1 = r1.getLast()     // Catch:{ all -> 0x00a8 }
            com.parse.ParseOperationSet r1 = (com.parse.ParseOperationSet) r1     // Catch:{ all -> 0x00a8 }
        L_0x0095:
            r1.setIsSaveEventually(r4)     // Catch:{ all -> 0x00a8 }
            r1.toParcel(r7, r8)     // Catch:{ all -> 0x00a8 }
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x00a8 }
            r8.<init>()     // Catch:{ all -> 0x00a8 }
            r6.onSaveInstanceState(r8)     // Catch:{ all -> 0x00a8 }
            r7.writeBundle(r8)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            return
        L_0x00a8:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseObject.writeToParcel(android.os.Parcel, com.parse.ParseParcelEncoder):void");
    }
}
