package com.parse;

import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.google.android.gms.actions.SearchIntents;
import com.parse.ParseObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseQuery<T extends ParseObject> {
    public static final int MAX_LIMIT = 1000;
    private final State.Builder<T> builder;
    /* access modifiers changed from: private */
    public Set<TaskCompletionSource<?>> currentTasks;
    private ParseUser user;

    public enum CachePolicy {
        IGNORE_CACHE,
        CACHE_ONLY,
        NETWORK_ONLY,
        CACHE_ELSE_NETWORK,
        NETWORK_ELSE_CACHE,
        CACHE_THEN_NETWORK
    }

    private interface CacheThenNetworkCallable<T extends ParseObject, TResult> {
        TResult call(State<T> state, ParseUser parseUser, Task<Void> task);
    }

    static class KeyConstraints extends HashMap<String, Object> {
        KeyConstraints() {
        }
    }

    static class QueryConstraints extends HashMap<String, Object> {
        public QueryConstraints() {
        }

        public QueryConstraints(Map<? extends String, ?> map) {
            super(map);
        }
    }

    static class RelationConstraint {
        private String key;
        private ParseObject object;

        public RelationConstraint(String str, ParseObject parseObject) {
            if (str == null || parseObject == null) {
                throw new IllegalArgumentException("Arguments must not be null.");
            }
            this.key = str;
            this.object = parseObject;
        }

        public JSONObject encode(ParseEncoder parseEncoder) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", this.key);
                jSONObject.put("object", parseEncoder.encodeRelatedObject(this.object));
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public String getKey() {
            return this.key;
        }

        public ParseObject getObject() {
            return this.object;
        }

        public ParseRelation<ParseObject> getRelation() {
            return this.object.getRelation(this.key);
        }
    }

    public static class State<T extends ParseObject> {
        private final CachePolicy cachePolicy;
        private final String className;
        private final Map<String, Object> extraOptions;
        private final boolean ignoreACLs;
        private final Set<String> include;
        private final boolean isFromLocalDatastore;
        private final int limit;
        private final long maxCacheAge;
        private final List<String> order;
        private final String pinName;
        private final Set<String> selectedKeys;
        private final int skip;
        private final boolean trace;
        private final QueryConstraints where;

        public static class Builder<T extends ParseObject> {
            /* access modifiers changed from: private */
            public CachePolicy cachePolicy;
            /* access modifiers changed from: private */
            public final String className;
            /* access modifiers changed from: private */
            public final Map<String, Object> extraOptions;
            /* access modifiers changed from: private */
            public boolean ignoreACLs;
            /* access modifiers changed from: private */
            public final Set<String> includes;
            /* access modifiers changed from: private */
            public boolean isFromLocalDatastore;
            /* access modifiers changed from: private */
            public int limit;
            /* access modifiers changed from: private */
            public long maxCacheAge;
            /* access modifiers changed from: private */
            public List<String> order;
            /* access modifiers changed from: private */
            public String pinName;
            /* access modifiers changed from: private */
            public Set<String> selectedKeys;
            /* access modifiers changed from: private */
            public int skip;
            /* access modifiers changed from: private */
            public boolean trace;
            /* access modifiers changed from: private */
            public final QueryConstraints where;

            public Builder(Builder<T> builder) {
                this.where = new QueryConstraints();
                this.includes = new HashSet();
                this.extraOptions = new HashMap();
                this.limit = -1;
                this.skip = 0;
                this.order = new ArrayList();
                this.cachePolicy = CachePolicy.IGNORE_CACHE;
                this.maxCacheAge = Long.MAX_VALUE;
                this.isFromLocalDatastore = false;
                this.className = builder.className;
                this.where.putAll(builder.where);
                this.includes.addAll(builder.includes);
                Set<String> set = builder.selectedKeys;
                this.selectedKeys = set != null ? new HashSet(set) : null;
                this.limit = builder.limit;
                this.skip = builder.skip;
                this.order.addAll(builder.order);
                this.extraOptions.putAll(builder.extraOptions);
                this.trace = builder.trace;
                this.cachePolicy = builder.cachePolicy;
                this.maxCacheAge = builder.maxCacheAge;
                this.isFromLocalDatastore = builder.isFromLocalDatastore;
                this.pinName = builder.pinName;
                this.ignoreACLs = builder.ignoreACLs;
            }

            public Builder(State state) {
                this.where = new QueryConstraints();
                this.includes = new HashSet();
                this.extraOptions = new HashMap();
                this.limit = -1;
                this.skip = 0;
                this.order = new ArrayList();
                this.cachePolicy = CachePolicy.IGNORE_CACHE;
                this.maxCacheAge = Long.MAX_VALUE;
                this.isFromLocalDatastore = false;
                this.className = state.className();
                this.where.putAll(state.constraints());
                this.includes.addAll(state.includes());
                this.selectedKeys = state.selectedKeys() != null ? new HashSet(state.selectedKeys()) : null;
                this.limit = state.limit();
                this.skip = state.skip();
                this.order.addAll(state.order());
                this.extraOptions.putAll(state.extraOptions());
                this.trace = state.isTracingEnabled();
                this.cachePolicy = state.cachePolicy();
                this.maxCacheAge = state.maxCacheAge();
                this.isFromLocalDatastore = state.isFromLocalDatastore();
                this.pinName = state.pinName();
                this.ignoreACLs = state.ignoreACLs();
            }

            public Builder(Class<T> cls) {
                this(ParseQuery.getSubclassingController().getClassName(cls));
            }

            public Builder(String str) {
                this.where = new QueryConstraints();
                this.includes = new HashSet();
                this.extraOptions = new HashMap();
                this.limit = -1;
                this.skip = 0;
                this.order = new ArrayList();
                this.cachePolicy = CachePolicy.IGNORE_CACHE;
                this.maxCacheAge = Long.MAX_VALUE;
                this.isFromLocalDatastore = false;
                this.className = str;
            }

            /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private com.parse.ParseQuery.State.Builder<T> addConditionInternal(java.lang.String r3, java.lang.String r4, java.lang.Object r5) {
                /*
                    r2 = this;
                    com.parse.ParseQuery$QueryConstraints r0 = r2.where
                    boolean r0 = r0.containsKey(r3)
                    if (r0 == 0) goto L_0x0015
                    com.parse.ParseQuery$QueryConstraints r0 = r2.where
                    java.lang.Object r0 = r0.get(r3)
                    boolean r1 = r0 instanceof com.parse.ParseQuery.KeyConstraints
                    if (r1 == 0) goto L_0x0015
                    com.parse.ParseQuery$KeyConstraints r0 = (com.parse.ParseQuery.KeyConstraints) r0
                    goto L_0x0016
                L_0x0015:
                    r0 = 0
                L_0x0016:
                    if (r0 != 0) goto L_0x001d
                    com.parse.ParseQuery$KeyConstraints r0 = new com.parse.ParseQuery$KeyConstraints
                    r0.<init>()
                L_0x001d:
                    r0.put(r4, r5)
                    com.parse.ParseQuery$QueryConstraints r4 = r2.where
                    r4.put(r3, r0)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseQuery.State.Builder.addConditionInternal(java.lang.String, java.lang.String, java.lang.Object):com.parse.ParseQuery$State$Builder");
            }

            private Builder<T> addOrder(String str) {
                this.order.add(str);
                return this;
            }

            /* renamed from: or */
            public static <T extends ParseObject> Builder<T> m8826or(List<Builder<T>> list) {
                if (!list.isEmpty()) {
                    String str = null;
                    ArrayList arrayList = new ArrayList();
                    for (Builder next : list) {
                        if (str != null && !next.className.equals(str)) {
                            throw new IllegalArgumentException("All of the queries in an or query must be on the same class ");
                        } else if (next.limit >= 0) {
                            throw new IllegalArgumentException("Cannot have limits in sub queries of an 'OR' query");
                        } else if (next.skip > 0) {
                            throw new IllegalArgumentException("Cannot have skips in sub queries of an 'OR' query");
                        } else if (!next.order.isEmpty()) {
                            throw new IllegalArgumentException("Cannot have an order in sub queries of an 'OR' query");
                        } else if (!next.includes.isEmpty()) {
                            throw new IllegalArgumentException("Cannot have an include in sub queries of an 'OR' query");
                        } else if (next.selectedKeys == null) {
                            str = next.className;
                            arrayList.add(next.where);
                        } else {
                            throw new IllegalArgumentException("Cannot have an selectKeys in sub queries of an 'OR' query");
                        }
                    }
                    return new Builder(str).whereSatifiesAnyOf(arrayList);
                }
                throw new IllegalArgumentException("Can't take an or of an empty list of queries");
            }

            private Builder<T> setOrder(String str) {
                this.order.clear();
                this.order.add(str);
                return this;
            }

            private Builder<T> whereSatifiesAnyOf(List<QueryConstraints> list) {
                this.where.put("$or", list);
                return this;
            }

            public Builder<T> addAscendingOrder(String str) {
                return addOrder(str);
            }

            public Builder<T> addCondition(String str, String str2, Object obj) {
                return addConditionInternal(str, str2, obj);
            }

            public Builder<T> addCondition(String str, String str2, Collection<?> collection) {
                return addConditionInternal(str, str2, Collections.unmodifiableCollection(collection));
            }

            public Builder<T> addDescendingOrder(String str) {
                return addOrder(String.format("-%s", new Object[]{str}));
            }

            public State<T> build() {
                if (this.isFromLocalDatastore || !this.ignoreACLs) {
                    return new State<>(this);
                }
                throw new IllegalStateException("`ignoreACLs` cannot be combined with network queries");
            }

            /* access modifiers changed from: package-private */
            public Builder<T> clear(String str) {
                this.where.remove(str);
                return this;
            }

            public Builder<T> fromLocalDatastore() {
                return fromPin((String) null);
            }

            public Builder<T> fromNetwork() {
                ParseQuery.throwIfLDSDisabled();
                this.isFromLocalDatastore = false;
                this.pinName = null;
                return this;
            }

            public Builder<T> fromPin() {
                return fromPin(ParseObject.DEFAULT_PIN);
            }

            public Builder<T> fromPin(String str) {
                ParseQuery.throwIfLDSDisabled();
                this.isFromLocalDatastore = true;
                this.pinName = str;
                return this;
            }

            public CachePolicy getCachePolicy() {
                ParseQuery.throwIfLDSEnabled();
                return this.cachePolicy;
            }

            public String getClassName() {
                return this.className;
            }

            public int getLimit() {
                return this.limit;
            }

            public long getMaxCacheAge() {
                ParseQuery.throwIfLDSEnabled();
                return this.maxCacheAge;
            }

            public int getSkip() {
                return this.skip;
            }

            public Builder<T> ignoreACLs() {
                ParseQuery.throwIfLDSDisabled();
                this.ignoreACLs = true;
                return this;
            }

            public Builder<T> include(String str) {
                this.includes.add(str);
                return this;
            }

            public boolean isFromLocalDatstore() {
                return this.isFromLocalDatastore;
            }

            public boolean isFromNetwork() {
                ParseQuery.throwIfLDSDisabled();
                return !this.isFromLocalDatastore;
            }

            public Builder<T> maxDistance(String str, double d) {
                return addCondition(str, "$maxDistance", (Object) Double.valueOf(d));
            }

            public Builder<T> orderByAscending(String str) {
                return setOrder(str);
            }

            public Builder<T> orderByDescending(String str) {
                return setOrder(String.format("-%s", new Object[]{str}));
            }

            /* access modifiers changed from: package-private */
            public Builder<T> redirectClassNameForKey(String str) {
                this.extraOptions.put("redirectClassNameForKey", str);
                return this;
            }

            public Builder<T> selectKeys(Collection<String> collection) {
                if (this.selectedKeys == null) {
                    this.selectedKeys = new HashSet();
                }
                this.selectedKeys.addAll(collection);
                return this;
            }

            public Builder<T> setCachePolicy(CachePolicy cachePolicy2) {
                ParseQuery.throwIfLDSEnabled();
                this.cachePolicy = cachePolicy2;
                return this;
            }

            public Builder<T> setLimit(int i) {
                this.limit = i;
                return this;
            }

            public Builder<T> setMaxCacheAge(long j) {
                ParseQuery.throwIfLDSEnabled();
                this.maxCacheAge = j;
                return this;
            }

            public Builder<T> setSkip(int i) {
                this.skip = i;
                return this;
            }

            public Builder<T> setTracingEnabled(boolean z) {
                this.trace = z;
                return this;
            }

            public Builder<T> whereDoesNotMatchKeyInQuery(String str, String str2, Builder<?> builder) {
                HashMap hashMap = new HashMap();
                hashMap.put("key", str2);
                hashMap.put(SearchIntents.EXTRA_QUERY, builder);
                return addConditionInternal(str, "$dontSelect", Collections.unmodifiableMap(hashMap));
            }

            public Builder<T> whereDoesNotMatchQuery(String str, Builder<?> builder) {
                return addConditionInternal(str, "$notInQuery", builder);
            }

            public Builder<T> whereEqualTo(String str, Object obj) {
                this.where.put(str, obj);
                return this;
            }

            public Builder<T> whereGeoIntersects(String str, ParseGeoPoint parseGeoPoint) {
                HashMap hashMap = new HashMap();
                hashMap.put("$point", parseGeoPoint);
                return addCondition(str, "$geoIntersects", (Object) hashMap);
            }

            public Builder<T> whereGeoWithin(String str, List<ParseGeoPoint> list) {
                HashMap hashMap = new HashMap();
                hashMap.put("$polygon", list);
                return addCondition(str, "$geoWithin", (Object) hashMap);
            }

            public Builder<T> whereMatchesKeyInQuery(String str, String str2, Builder<?> builder) {
                HashMap hashMap = new HashMap();
                hashMap.put("key", str2);
                hashMap.put(SearchIntents.EXTRA_QUERY, builder);
                return addConditionInternal(str, "$select", Collections.unmodifiableMap(new HashMap(hashMap)));
            }

            public Builder<T> whereMatchesQuery(String str, Builder<?> builder) {
                return addConditionInternal(str, "$inQuery", builder);
            }

            public Builder<T> whereNear(String str, ParseGeoPoint parseGeoPoint) {
                return addCondition(str, "$nearSphere", (Object) parseGeoPoint);
            }

            /* access modifiers changed from: package-private */
            public Builder<T> whereObjectIdEquals(String str) {
                this.where.clear();
                this.where.put(ParseObject.KEY_OBJECT_ID, str);
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder<T> whereRelatedTo(ParseObject parseObject, String str) {
                this.where.put("$relatedTo", new RelationConstraint(str, parseObject));
                return this;
            }

            public Builder<T> whereText(String str, String str2) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap.put("$term", str2);
                hashMap2.put("$search", hashMap);
                return addCondition(str, "$text", (Object) hashMap2);
            }

            public Builder<T> whereWithin(String str, ParseGeoPoint parseGeoPoint, ParseGeoPoint parseGeoPoint2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(parseGeoPoint);
                arrayList.add(parseGeoPoint2);
                HashMap hashMap = new HashMap();
                hashMap.put("$box", arrayList);
                return addCondition(str, "$within", (Object) hashMap);
            }
        }

        private State(Builder<T> builder) {
            this.className = builder.className;
            this.where = new QueryConstraints(builder.where);
            this.include = Collections.unmodifiableSet(new HashSet(builder.includes));
            this.selectedKeys = builder.selectedKeys != null ? Collections.unmodifiableSet(new HashSet(builder.selectedKeys)) : null;
            this.limit = builder.limit;
            this.skip = builder.skip;
            this.order = Collections.unmodifiableList(new ArrayList(builder.order));
            this.extraOptions = Collections.unmodifiableMap(new HashMap(builder.extraOptions));
            this.trace = builder.trace;
            this.cachePolicy = builder.cachePolicy;
            this.maxCacheAge = builder.maxCacheAge;
            this.isFromLocalDatastore = builder.isFromLocalDatastore;
            this.pinName = builder.pinName;
            this.ignoreACLs = builder.ignoreACLs;
        }

        public CachePolicy cachePolicy() {
            return this.cachePolicy;
        }

        public String className() {
            return this.className;
        }

        public QueryConstraints constraints() {
            return this.where;
        }

        public Map<String, Object> extraOptions() {
            return this.extraOptions;
        }

        public boolean ignoreACLs() {
            return this.ignoreACLs;
        }

        public Set<String> includes() {
            return this.include;
        }

        public boolean isFromLocalDatastore() {
            return this.isFromLocalDatastore;
        }

        public boolean isTracingEnabled() {
            return this.trace;
        }

        public int limit() {
            return this.limit;
        }

        public long maxCacheAge() {
            return this.maxCacheAge;
        }

        public List<String> order() {
            return this.order;
        }

        public String pinName() {
            return this.pinName;
        }

        public Set<String> selectedKeys() {
            return this.selectedKeys;
        }

        public int skip() {
            return this.skip;
        }

        /* access modifiers changed from: package-private */
        public JSONObject toJSON(ParseEncoder parseEncoder) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("className", this.className);
                jSONObject.put("where", parseEncoder.encode(this.where));
                if (this.limit >= 0) {
                    jSONObject.put("limit", this.limit);
                }
                if (this.skip > 0) {
                    jSONObject.put("skip", this.skip);
                }
                if (!this.order.isEmpty()) {
                    jSONObject.put("order", ParseTextUtils.join(",", this.order));
                }
                if (!this.include.isEmpty()) {
                    jSONObject.put("include", ParseTextUtils.join(",", this.include));
                }
                if (this.selectedKeys != null) {
                    jSONObject.put("fields", ParseTextUtils.join(",", this.selectedKeys));
                }
                if (this.trace) {
                    jSONObject.put("trace", 1);
                }
                for (String next : this.extraOptions.keySet()) {
                    jSONObject.put(next, parseEncoder.encode(this.extraOptions.get(next)));
                }
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public String toString() {
            return String.format(Locale.US, "%s[className=%s, where=%s, include=%s, selectedKeys=%s, limit=%s, skip=%s, order=%s, extraOptions=%s, cachePolicy=%s, maxCacheAge=%s, trace=%s]", new Object[]{getClass().getName(), this.className, this.where, this.include, this.selectedKeys, Integer.valueOf(this.limit), Integer.valueOf(this.skip), this.order, this.extraOptions, this.cachePolicy, Long.valueOf(this.maxCacheAge), Boolean.valueOf(this.trace)});
        }
    }

    public ParseQuery(State.Builder<T> builder2) {
        this.currentTasks = Collections.synchronizedSet(new HashSet());
        this.builder = builder2;
    }

    public ParseQuery(ParseQuery<T> parseQuery) {
        this(new State.Builder(parseQuery.getBuilder()));
        this.user = parseQuery.user;
    }

    public ParseQuery(Class<T> cls) {
        this(getSubclassingController().getClassName(cls));
    }

    public ParseQuery(String str) {
        this(new State.Builder(str));
    }

    private String buildStartsWithRegex(String str) {
        return "^" + Pattern.quote(str);
    }

    public static void clearAllCachedResults() {
        throwIfLDSEnabled();
        ParseKeyValueCache.clearKeyValueCacheDir();
    }

    private Task<Integer> countAsync(final State<T> state) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return perform(new Callable<Task<Integer>>() {
            public Task<Integer> call() {
                return ParseQuery.this.getUserAsync(state).onSuccessTask(new Continuation<ParseUser, Task<Integer>>() {
                    public Task<Integer> then(Task<ParseUser> task) {
                        return ParseQuery.this.countAsync(state, task.getResult(), taskCompletionSource.getTask());
                    }
                });
            }
        }, taskCompletionSource);
    }

    /* access modifiers changed from: private */
    public Task<Integer> countAsync(State<T> state, ParseUser parseUser, Task<Void> task) {
        return getQueryController().countAsync(state, parseUser, task);
    }

    private <TResult> Task<TResult> doCacheThenNetwork(State<T> state, ParseCallback2<TResult, ParseException> parseCallback2, CacheThenNetworkCallable<T, Task<TResult>> cacheThenNetworkCallable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final State<T> state2 = state;
        final CacheThenNetworkCallable<T, Task<TResult>> cacheThenNetworkCallable2 = cacheThenNetworkCallable;
        final TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
        final ParseCallback2<TResult, ParseException> parseCallback22 = parseCallback2;
        return perform(new Callable<Task<TResult>>() {
            public Task<TResult> call() {
                return ParseQuery.this.getUserAsync(state2).onSuccessTask(new Continuation<ParseUser, Task<TResult>>() {
                    public Task<TResult> then(Task<ParseUser> task) {
                        final ParseUser result = task.getResult();
                        State build = new State.Builder(state2).setCachePolicy(CachePolicy.CACHE_ONLY).build();
                        final State build2 = new State.Builder(state2).setCachePolicy(CachePolicy.NETWORK_ONLY).build();
                        return ParseTaskUtils.callbackOnMainThreadAsync((Task) cacheThenNetworkCallable2.call(build, result, taskCompletionSource2.getTask()), parseCallback22).continueWithTask(new Continuation<TResult, Task<TResult>>() {
                            public Task<TResult> then(Task<TResult> task) {
                                return task.isCancelled() ? task : (Task) cacheThenNetworkCallable2.call(build2, result, taskCompletionSource2.getTask());
                            }
                        });
                    }
                });
            }
        }, taskCompletionSource);
    }

    private Task<List<T>> findAsync(final State<T> state) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return perform(new Callable<Task<List<T>>>() {
            public Task<List<T>> call() {
                return ParseQuery.this.getUserAsync(state).onSuccessTask(new Continuation<ParseUser, Task<List<T>>>() {
                    public Task<List<T>> then(Task<ParseUser> task) {
                        return ParseQuery.this.findAsync(state, task.getResult(), taskCompletionSource.getTask());
                    }
                });
            }
        }, taskCompletionSource);
    }

    private Task<T> getFirstAsync(final State<T> state) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return perform(new Callable<Task<T>>() {
            public Task<T> call() {
                return ParseQuery.this.getUserAsync(state).onSuccessTask(new Continuation<ParseUser, Task<T>>() {
                    public Task<T> then(Task<ParseUser> task) {
                        return ParseQuery.this.getFirstAsync(state, task.getResult(), taskCompletionSource.getTask());
                    }
                });
            }
        }, taskCompletionSource);
    }

    /* access modifiers changed from: private */
    public Task<T> getFirstAsync(State<T> state, ParseUser parseUser, Task<Void> task) {
        return getQueryController().getFirstAsync(state, parseUser, task);
    }

    public static <T extends ParseObject> ParseQuery<T> getQuery(Class<T> cls) {
        return new ParseQuery<>(cls);
    }

    public static <T extends ParseObject> ParseQuery<T> getQuery(String str) {
        return new ParseQuery<>(str);
    }

    private static ParseQueryController getQueryController() {
        return ParseCorePlugins.getInstance().getQueryController();
    }

    /* access modifiers changed from: private */
    public static ParseObjectSubclassingController getSubclassingController() {
        return ParseCorePlugins.getInstance().getSubclassingController();
    }

    /* renamed from: or */
    public static <T extends ParseObject> ParseQuery<T> m8825or(List<ParseQuery<T>> list) {
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ParseQuery<T> builder2 : list) {
                arrayList.add(builder2.getBuilder());
            }
            return new ParseQuery<>(State.Builder.m8826or(arrayList));
        }
        throw new IllegalArgumentException("Can't take an or of an empty list of queries");
    }

    private <TResult> Task<TResult> perform(Callable<Task<TResult>> callable, final TaskCompletionSource<?> taskCompletionSource) {
        Task task;
        this.currentTasks.add(taskCompletionSource);
        try {
            task = callable.call();
        } catch (Exception e) {
            task = Task.forError(e);
        }
        return task.continueWithTask(new Continuation<TResult, Task<TResult>>() {
            public Task<TResult> then(Task<TResult> task) {
                taskCompletionSource.trySetResult(null);
                ParseQuery.this.currentTasks.remove(taskCompletionSource);
                return task;
            }
        });
    }

    /* access modifiers changed from: private */
    public static void throwIfLDSDisabled() {
        throwIfLDSEnabled(true);
    }

    /* access modifiers changed from: private */
    public static void throwIfLDSEnabled() {
        throwIfLDSEnabled(false);
    }

    private static void throwIfLDSEnabled(boolean z) {
        boolean isLocalDatastoreEnabled = Parse.isLocalDatastoreEnabled();
        if (z && !isLocalDatastoreEnabled) {
            throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
        } else if (!z && isLocalDatastoreEnabled) {
            throw new IllegalStateException("Unsupported method when Local Datastore is enabled.");
        }
    }

    public ParseQuery<T> addAscendingOrder(String str) {
        this.builder.addAscendingOrder(str);
        return this;
    }

    public ParseQuery<T> addDescendingOrder(String str) {
        this.builder.addDescendingOrder(str);
        return this;
    }

    public void cancel() {
        HashSet<TaskCompletionSource> hashSet = new HashSet<>(this.currentTasks);
        for (TaskCompletionSource trySetCancelled : hashSet) {
            trySetCancelled.trySetCancelled();
        }
        this.currentTasks.removeAll(hashSet);
    }

    public ParseQuery<T> clear(String str) {
        this.builder.clear(str);
        return this;
    }

    public void clearCachedResult() {
        ParseUser parseUser;
        throwIfLDSEnabled();
        State<T> build = this.builder.build();
        String str = null;
        try {
            parseUser = (ParseUser) ParseTaskUtils.wait(getUserAsync(build));
        } catch (ParseException unused) {
            parseUser = null;
        }
        if (parseUser != null) {
            str = parseUser.getSessionToken();
        }
        ParseKeyValueCache.clearFromKeyValueCache(ParseRESTQueryCommand.findCommand(build, str).getCacheKey());
    }

    public int count() {
        return ((Integer) ParseTaskUtils.wait(countInBackground())).intValue();
    }

    public Task<Integer> countInBackground() {
        return countAsync(new State.Builder(this.builder).setLimit(0).build());
    }

    public void countInBackground(final CountCallback countCallback) {
        State build = new State.Builder(this.builder).setLimit(0).build();
        C29406 r1 = countCallback != null ? new ParseCallback2<Integer, ParseException>() {
            public void done(Integer num, ParseException parseException) {
                countCallback.done(parseException == null ? num.intValue() : -1, parseException);
            }
        } : null;
        ParseTaskUtils.callbackOnMainThreadAsync((build.cachePolicy() != CachePolicy.CACHE_THEN_NETWORK || build.isFromLocalDatastore()) ? countAsync(build) : doCacheThenNetwork(build, r1, new CacheThenNetworkCallable<T, Task<Integer>>() {
            public Task<Integer> call(State<T> state, ParseUser parseUser, Task<Void> task) {
                return ParseQuery.this.countAsync(state, parseUser, task);
            }
        }), r1);
    }

    public List<T> find() {
        return (List) ParseTaskUtils.wait(findInBackground());
    }

    /* access modifiers changed from: package-private */
    public Task<List<T>> findAsync(State<T> state, ParseUser parseUser, Task<Void> task) {
        return getQueryController().findAsync(state, parseUser, task);
    }

    public Task<List<T>> findInBackground() {
        return findAsync(this.builder.build());
    }

    public void findInBackground(FindCallback<T> findCallback) {
        State<T> build = this.builder.build();
        ParseTaskUtils.callbackOnMainThreadAsync((build.cachePolicy() != CachePolicy.CACHE_THEN_NETWORK || build.isFromLocalDatastore()) ? findAsync(build) : doCacheThenNetwork(build, findCallback, new CacheThenNetworkCallable<T, Task<List<T>>>() {
            public Task<List<T>> call(State<T> state, ParseUser parseUser, Task<Void> task) {
                return ParseQuery.this.findAsync(state, parseUser, task);
            }
        }), findCallback);
    }

    public ParseQuery<T> fromLocalDatastore() {
        this.builder.fromLocalDatastore();
        return this;
    }

    public ParseQuery<T> fromNetwork() {
        this.builder.fromNetwork();
        return this;
    }

    public ParseQuery<T> fromPin() {
        this.builder.fromPin();
        return this;
    }

    public ParseQuery<T> fromPin(String str) {
        this.builder.fromPin(str);
        return this;
    }

    public T get(String str) {
        return (ParseObject) ParseTaskUtils.wait(getInBackground(str));
    }

    public State.Builder<T> getBuilder() {
        return this.builder;
    }

    public CachePolicy getCachePolicy() {
        return this.builder.getCachePolicy();
    }

    public String getClassName() {
        return this.builder.getClassName();
    }

    public T getFirst() {
        return (ParseObject) ParseTaskUtils.wait(getFirstInBackground());
    }

    public Task<T> getFirstInBackground() {
        return getFirstAsync(this.builder.setLimit(1).build());
    }

    public void getFirstInBackground(GetCallback<T> getCallback) {
        State<T> build = this.builder.setLimit(1).build();
        ParseTaskUtils.callbackOnMainThreadAsync((build.cachePolicy() != CachePolicy.CACHE_THEN_NETWORK || build.isFromLocalDatastore()) ? getFirstAsync(build) : doCacheThenNetwork(build, getCallback, new CacheThenNetworkCallable<T, Task<T>>() {
            public Task<T> call(State<T> state, ParseUser parseUser, Task<Void> task) {
                return ParseQuery.this.getFirstAsync(state, parseUser, task);
            }
        }), getCallback);
    }

    public Task<T> getInBackground(String str) {
        return getFirstAsync(this.builder.setSkip(-1).whereObjectIdEquals(str).build());
    }

    public void getInBackground(String str, GetCallback<T> getCallback) {
        State<T> build = this.builder.setSkip(-1).whereObjectIdEquals(str).build();
        ParseTaskUtils.callbackOnMainThreadAsync((build.cachePolicy() != CachePolicy.CACHE_THEN_NETWORK || build.isFromLocalDatastore()) ? getFirstAsync(build) : doCacheThenNetwork(build, getCallback, new CacheThenNetworkCallable<T, Task<T>>() {
            public Task<T> call(State<T> state, ParseUser parseUser, Task<Void> task) {
                return ParseQuery.this.getFirstAsync(state, parseUser, task);
            }
        }), getCallback);
    }

    public int getLimit() {
        return this.builder.getLimit();
    }

    public long getMaxCacheAge() {
        return this.builder.getMaxCacheAge();
    }

    public int getSkip() {
        return this.builder.getSkip();
    }

    /* access modifiers changed from: package-private */
    public Task<ParseUser> getUserAsync(State<T> state) {
        if (state.ignoreACLs()) {
            return Task.forResult(null);
        }
        ParseUser parseUser = this.user;
        return parseUser != null ? Task.forResult(parseUser) : ParseUser.getCurrentUserAsync();
    }

    public boolean hasCachedResult() {
        ParseUser parseUser;
        throwIfLDSEnabled();
        State<T> build = this.builder.build();
        String str = null;
        try {
            parseUser = (ParseUser) ParseTaskUtils.wait(getUserAsync(build));
        } catch (ParseException unused) {
            parseUser = null;
        }
        if (parseUser != null) {
            str = parseUser.getSessionToken();
        }
        return ParseKeyValueCache.loadFromKeyValueCache(ParseRESTQueryCommand.findCommand(build, str).getCacheKey(), build.maxCacheAge()) != null;
    }

    public ParseQuery<T> ignoreACLs() {
        this.builder.ignoreACLs();
        return this;
    }

    public ParseQuery<T> include(String str) {
        this.builder.include(str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean isFromNetwork() {
        return this.builder.isFromNetwork();
    }

    public boolean isRunning() {
        return this.currentTasks.size() > 0;
    }

    public ParseQuery<T> orderByAscending(String str) {
        this.builder.orderByAscending(str);
        return this;
    }

    public ParseQuery<T> orderByDescending(String str) {
        this.builder.orderByDescending(str);
        return this;
    }

    public ParseQuery<T> selectKeys(Collection<String> collection) {
        this.builder.selectKeys(collection);
        return this;
    }

    public ParseQuery<T> setCachePolicy(CachePolicy cachePolicy) {
        this.builder.setCachePolicy(cachePolicy);
        return this;
    }

    public ParseQuery<T> setLimit(int i) {
        this.builder.setLimit(i);
        return this;
    }

    public ParseQuery<T> setMaxCacheAge(long j) {
        this.builder.setMaxCacheAge(j);
        return this;
    }

    public ParseQuery<T> setSkip(int i) {
        this.builder.setSkip(i);
        return this;
    }

    public ParseQuery<T> setTrace(boolean z) {
        this.builder.setTracingEnabled(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ParseQuery<T> setUser(ParseUser parseUser) {
        this.user = parseUser;
        return this;
    }

    public ParseQuery<T> whereContainedIn(String str, Collection<?> collection) {
        this.builder.addCondition(str, "$in", collection);
        return this;
    }

    public ParseQuery<T> whereContains(String str, String str2) {
        whereMatches(str, Pattern.quote(str2));
        return this;
    }

    public ParseQuery<T> whereContainsAll(String str, Collection<?> collection) {
        this.builder.addCondition(str, "$all", collection);
        return this;
    }

    public ParseQuery<T> whereContainsAllStartsWith(String str, Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        for (String buildStartsWithRegex : collection) {
            KeyConstraints keyConstraints = new KeyConstraints();
            keyConstraints.put("$regex", buildStartsWithRegex(buildStartsWithRegex));
            arrayList.add(keyConstraints);
        }
        return whereContainsAll(str, arrayList);
    }

    public ParseQuery<T> whereDoesNotExist(String str) {
        this.builder.addCondition(str, "$exists", (Object) false);
        return this;
    }

    public ParseQuery<T> whereDoesNotMatchKeyInQuery(String str, String str2, ParseQuery<?> parseQuery) {
        this.builder.whereDoesNotMatchKeyInQuery(str, str2, parseQuery.getBuilder());
        return this;
    }

    public ParseQuery<T> whereDoesNotMatchQuery(String str, ParseQuery<?> parseQuery) {
        this.builder.whereDoesNotMatchQuery(str, parseQuery.getBuilder());
        return this;
    }

    public ParseQuery<T> whereEndsWith(String str, String str2) {
        whereMatches(str, Pattern.quote(str2) + "$");
        return this;
    }

    public ParseQuery<T> whereEqualTo(String str, Object obj) {
        this.builder.whereEqualTo(str, obj);
        return this;
    }

    public ParseQuery<T> whereExists(String str) {
        this.builder.addCondition(str, "$exists", (Object) true);
        return this;
    }

    public ParseQuery<T> whereFullText(String str, String str2) {
        this.builder.whereText(str, str2);
        return this;
    }

    public ParseQuery<T> whereGreaterThan(String str, Object obj) {
        this.builder.addCondition(str, "$gt", obj);
        return this;
    }

    public ParseQuery<T> whereGreaterThanOrEqualTo(String str, Object obj) {
        this.builder.addCondition(str, "$gte", obj);
        return this;
    }

    public ParseQuery<T> whereLessThan(String str, Object obj) {
        this.builder.addCondition(str, "$lt", obj);
        return this;
    }

    public ParseQuery<T> whereLessThanOrEqualTo(String str, Object obj) {
        this.builder.addCondition(str, "$lte", obj);
        return this;
    }

    public ParseQuery<T> whereMatches(String str, String str2) {
        this.builder.addCondition(str, "$regex", (Object) str2);
        return this;
    }

    public ParseQuery<T> whereMatches(String str, String str2, String str3) {
        this.builder.addCondition(str, "$regex", (Object) str2);
        if (str3.length() != 0) {
            this.builder.addCondition(str, "$options", (Object) str3);
        }
        return this;
    }

    public ParseQuery<T> whereMatchesKeyInQuery(String str, String str2, ParseQuery<?> parseQuery) {
        this.builder.whereMatchesKeyInQuery(str, str2, parseQuery.getBuilder());
        return this;
    }

    public ParseQuery<T> whereMatchesQuery(String str, ParseQuery<?> parseQuery) {
        this.builder.whereMatchesQuery(str, parseQuery.getBuilder());
        return this;
    }

    public ParseQuery<T> whereNear(String str, ParseGeoPoint parseGeoPoint) {
        this.builder.whereNear(str, parseGeoPoint);
        return this;
    }

    public ParseQuery<T> whereNotContainedIn(String str, Collection<?> collection) {
        this.builder.addCondition(str, "$nin", collection);
        return this;
    }

    public ParseQuery<T> whereNotEqualTo(String str, Object obj) {
        this.builder.addCondition(str, "$ne", obj);
        return this;
    }

    public ParseQuery<T> wherePolygonContains(String str, ParseGeoPoint parseGeoPoint) {
        this.builder.whereGeoIntersects(str, parseGeoPoint);
        return this;
    }

    public ParseQuery<T> whereStartsWith(String str, String str2) {
        whereMatches(str, buildStartsWithRegex(str2));
        return this;
    }

    public ParseQuery<T> whereWithinGeoBox(String str, ParseGeoPoint parseGeoPoint, ParseGeoPoint parseGeoPoint2) {
        this.builder.whereWithin(str, parseGeoPoint, parseGeoPoint2);
        return this;
    }

    public ParseQuery<T> whereWithinKilometers(String str, ParseGeoPoint parseGeoPoint, double d) {
        return whereWithinRadians(str, parseGeoPoint, d / ParseGeoPoint.EARTH_MEAN_RADIUS_KM);
    }

    public ParseQuery<T> whereWithinMiles(String str, ParseGeoPoint parseGeoPoint, double d) {
        return whereWithinRadians(str, parseGeoPoint, d / ParseGeoPoint.EARTH_MEAN_RADIUS_MILE);
    }

    public ParseQuery<T> whereWithinPolygon(String str, ParsePolygon parsePolygon) {
        return whereWithinPolygon(str, parsePolygon.getCoordinates());
    }

    public ParseQuery<T> whereWithinPolygon(String str, List<ParseGeoPoint> list) {
        this.builder.whereGeoWithin(str, list);
        return this;
    }

    public ParseQuery<T> whereWithinRadians(String str, ParseGeoPoint parseGeoPoint, double d) {
        this.builder.whereNear(str, parseGeoPoint).maxDistance(str, d);
        return this;
    }
}
