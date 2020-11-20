package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.google.android.gms.actions.SearchIntents;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineQueryLogic {
    /* access modifiers changed from: private */
    public final OfflineStore store;

    abstract class ConstraintMatcher<T extends ParseObject> {
        final ParseUser user;

        public ConstraintMatcher(ParseUser parseUser) {
            this.user = parseUser;
        }

        /* access modifiers changed from: package-private */
        public abstract Task<Boolean> matchesAsync(T t, ParseSQLiteDatabase parseSQLiteDatabase);
    }

    private interface Decider {
        boolean decide(Object obj, Object obj2);
    }

    private abstract class SubQueryMatcher<T extends ParseObject> extends ConstraintMatcher<T> {
        private final ParseQuery.State<T> subQuery;
        private Task<List<T>> subQueryResults = null;

        public SubQueryMatcher(ParseUser parseUser, ParseQuery.State<T> state) {
            super(parseUser);
            this.subQuery = state;
        }

        /* access modifiers changed from: protected */
        public abstract boolean matches(T t, List<T> list);

        public Task<Boolean> matchesAsync(final T t, ParseSQLiteDatabase parseSQLiteDatabase) {
            if (this.subQueryResults == null) {
                this.subQueryResults = OfflineQueryLogic.this.store.findAsync(this.subQuery, this.user, (ParsePin) null, parseSQLiteDatabase);
            }
            return this.subQueryResults.onSuccess(new Continuation<List<T>, Boolean>() {
                public Boolean then(Task<List<T>> task) {
                    return Boolean.valueOf(SubQueryMatcher.this.matches(t, task.getResult()));
                }
            });
        }
    }

    OfflineQueryLogic(OfflineStore offlineStore) {
        this.store = offlineStore;
    }

    private static ParseQuery.KeyConstraints cleanRegexStartsWith(ParseQuery.KeyConstraints keyConstraints) {
        if (!isStartsWithRegex(keyConstraints)) {
            return null;
        }
        String replaceAll = ((String) keyConstraints.get("$regex")).replaceAll("([^\\\\])(\\\\E)", "$1").replaceAll("([^\\\\])(\\\\Q)", "$1").replaceAll("^\\\\E", "").replaceAll("^\\\\Q", "").replaceAll("([^'])'", "$1''").replaceAll("^'([^'])", "''$1");
        keyConstraints.put("$regex", replaceAll + ".*");
        return keyConstraints;
    }

    private static Collection<?> cleanRegexStartsWith(Collection<?> collection) {
        ParseQuery.KeyConstraints cleanRegexStartsWith;
        ArrayList arrayList = new ArrayList();
        for (Object next : collection) {
            if (!(next instanceof ParseQuery.KeyConstraints) || (cleanRegexStartsWith = cleanRegexStartsWith((ParseQuery.KeyConstraints) next)) == null) {
                return null;
            }
            arrayList.add(cleanRegexStartsWith);
        }
        return arrayList;
    }

    private static boolean compare(Object obj, Object obj2, Decider decider) {
        return obj2 instanceof List ? compareList(obj, (List) obj2, decider) : obj2 instanceof JSONArray ? compareArray(obj, (JSONArray) obj2, decider) : decider.decide(obj, obj2);
    }

    private static boolean compareArray(Object obj, JSONArray jSONArray, Decider decider) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                if (decider.decide(obj, jSONArray.get(i))) {
                    return true;
                }
                i++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    private static boolean compareList(Object obj, List<?> list, Decider decider) {
        for (Object decide : list) {
            if (decider.decide(obj, decide)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static int compareTo(Object obj, Object obj2) {
        boolean z = obj == JSONObject.NULL || obj == null;
        boolean z2 = obj2 == JSONObject.NULL || obj2 == null;
        if (z || z2) {
            if (!z) {
                return 1;
            }
            return !z2 ? -1 : 0;
        } else if ((obj instanceof Date) && (obj2 instanceof Date)) {
            return ((Date) obj).compareTo((Date) obj2);
        } else {
            if ((obj instanceof String) && (obj2 instanceof String)) {
                return ((String) obj).compareTo((String) obj2);
            }
            if ((obj instanceof Number) && (obj2 instanceof Number)) {
                return Numbers.compare((Number) obj, (Number) obj2);
            }
            throw new IllegalArgumentException(String.format("Cannot compare %s against %s", new Object[]{obj, obj2}));
        }
    }

    private <T extends ParseObject> ConstraintMatcher<T> createDontSelectMatcher(ParseUser parseUser, Object obj, String str) {
        final ConstraintMatcher createSelectMatcher = createSelectMatcher(parseUser, obj, str);
        return new ConstraintMatcher<T>(parseUser) {
            public Task<Boolean> matchesAsync(T t, ParseSQLiteDatabase parseSQLiteDatabase) {
                return createSelectMatcher.matchesAsync(t, parseSQLiteDatabase).onSuccess(new Continuation<Boolean, Boolean>() {
                    public Boolean then(Task<Boolean> task) {
                        return Boolean.valueOf(!task.getResult().booleanValue());
                    }
                });
            }
        };
    }

    private <T extends ParseObject> ConstraintMatcher<T> createInQueryMatcher(ParseUser parseUser, Object obj, final String str) {
        return new SubQueryMatcher<T>(parseUser, ((ParseQuery.State.Builder) obj).build()) {
            /* access modifiers changed from: protected */
            public boolean matches(T t, List<T> list) {
                return OfflineQueryLogic.matchesInConstraint(list, OfflineQueryLogic.getValue(t, str));
            }
        };
    }

    private <T extends ParseObject> ConstraintMatcher<T> createMatcher(ParseUser parseUser, ParseQuery.QueryConstraints queryConstraints) {
        Object r2;
        final ArrayList arrayList = new ArrayList();
        for (final String str : queryConstraints.keySet()) {
            final Object obj = queryConstraints.get(str);
            if (str.equals("$or")) {
                r2 = createOrMatcher(parseUser, (ArrayList) obj);
            } else if (obj instanceof ParseQuery.KeyConstraints) {
                ParseQuery.KeyConstraints keyConstraints = (ParseQuery.KeyConstraints) obj;
                for (String str2 : keyConstraints.keySet()) {
                    arrayList.add(createMatcher(parseUser, str2, keyConstraints.get(str2), str, keyConstraints));
                }
            } else if (obj instanceof ParseQuery.RelationConstraint) {
                final ParseQuery.RelationConstraint relationConstraint = (ParseQuery.RelationConstraint) obj;
                r2 = new ConstraintMatcher<T>(parseUser) {
                    public Task<Boolean> matchesAsync(T t, ParseSQLiteDatabase parseSQLiteDatabase) {
                        return Task.forResult(Boolean.valueOf(relationConstraint.getRelation().hasKnownObject(t)));
                    }
                };
            } else {
                arrayList.add(new ConstraintMatcher<T>(parseUser) {
                    public Task<Boolean> matchesAsync(T t, ParseSQLiteDatabase parseSQLiteDatabase) {
                        try {
                            return Task.forResult(Boolean.valueOf(OfflineQueryLogic.matchesEqualConstraint(obj, OfflineQueryLogic.getValue(t, str))));
                        } catch (ParseException e) {
                            return Task.forError(e);
                        }
                    }
                });
            }
            arrayList.add(r2);
        }
        return new ConstraintMatcher<T>(parseUser) {
            public Task<Boolean> matchesAsync(final T t, final ParseSQLiteDatabase parseSQLiteDatabase) {
                Task<TContinuationResult> forResult = Task.forResult(true);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    final ConstraintMatcher constraintMatcher = (ConstraintMatcher) it.next();
                    forResult = forResult.onSuccessTask(new Continuation<Boolean, Task<Boolean>>() {
                        public Task<Boolean> then(Task<Boolean> task) {
                            return !task.getResult().booleanValue() ? task : constraintMatcher.matchesAsync(t, parseSQLiteDatabase);
                        }
                    });
                }
                return forResult;
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T extends com.parse.ParseObject> com.parse.OfflineQueryLogic.ConstraintMatcher<T> createMatcher(com.parse.ParseUser r9, java.lang.String r10, java.lang.Object r11, java.lang.String r12, com.parse.ParseQuery.KeyConstraints r13) {
        /*
            r8 = this;
            int r0 = r10.hashCode()
            r1 = -721570031(0xffffffffd4fdb711, float:-8.7175846E12)
            if (r0 == r1) goto L_0x0037
            r1 = 242866687(0xe79d9ff, float:3.079658E-30)
            if (r0 == r1) goto L_0x002d
            r1 = 427054964(0x19745774, float:1.2632165E-23)
            if (r0 == r1) goto L_0x0023
            r1 = 979339808(0x3a5f8a20, float:8.527357E-4)
            if (r0 == r1) goto L_0x0019
            goto L_0x0041
        L_0x0019:
            java.lang.String r0 = "$select"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0041
            r0 = 2
            goto L_0x0042
        L_0x0023:
            java.lang.String r0 = "$notInQuery"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0041
            r0 = 1
            goto L_0x0042
        L_0x002d:
            java.lang.String r0 = "$inQuery"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0041
            r0 = 0
            goto L_0x0042
        L_0x0037:
            java.lang.String r0 = "$dontSelect"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0041
            r0 = 3
            goto L_0x0042
        L_0x0041:
            r0 = -1
        L_0x0042:
            switch(r0) {
                case 0: goto L_0x0061;
                case 1: goto L_0x005c;
                case 2: goto L_0x0057;
                case 3: goto L_0x0052;
                default: goto L_0x0045;
            }
        L_0x0045:
            com.parse.OfflineQueryLogic$17 r7 = new com.parse.OfflineQueryLogic$17
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r12
            r4 = r10
            r5 = r11
            r6 = r13
            r0.<init>(r2, r3, r4, r5, r6)
            return r7
        L_0x0052:
            com.parse.OfflineQueryLogic$ConstraintMatcher r9 = r8.createDontSelectMatcher(r9, r11, r12)
            return r9
        L_0x0057:
            com.parse.OfflineQueryLogic$ConstraintMatcher r9 = r8.createSelectMatcher(r9, r11, r12)
            return r9
        L_0x005c:
            com.parse.OfflineQueryLogic$ConstraintMatcher r9 = r8.createNotInQueryMatcher(r9, r11, r12)
            return r9
        L_0x0061:
            com.parse.OfflineQueryLogic$ConstraintMatcher r9 = r8.createInQueryMatcher(r9, r11, r12)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.OfflineQueryLogic.createMatcher(com.parse.ParseUser, java.lang.String, java.lang.Object, java.lang.String, com.parse.ParseQuery$KeyConstraints):com.parse.OfflineQueryLogic$ConstraintMatcher");
    }

    private <T extends ParseObject> ConstraintMatcher<T> createNotInQueryMatcher(ParseUser parseUser, Object obj, String str) {
        final ConstraintMatcher createInQueryMatcher = createInQueryMatcher(parseUser, obj, str);
        return new ConstraintMatcher<T>(parseUser) {
            public Task<Boolean> matchesAsync(T t, ParseSQLiteDatabase parseSQLiteDatabase) {
                return createInQueryMatcher.matchesAsync(t, parseSQLiteDatabase).onSuccess(new Continuation<Boolean, Boolean>() {
                    public Boolean then(Task<Boolean> task) {
                        return Boolean.valueOf(!task.getResult().booleanValue());
                    }
                });
            }
        };
    }

    private <T extends ParseObject> ConstraintMatcher<T> createOrMatcher(ParseUser parseUser, ArrayList<ParseQuery.QueryConstraints> arrayList) {
        final ArrayList arrayList2 = new ArrayList();
        Iterator<ParseQuery.QueryConstraints> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(createMatcher(parseUser, it.next()));
        }
        return new ConstraintMatcher<T>(parseUser) {
            public Task<Boolean> matchesAsync(final T t, final ParseSQLiteDatabase parseSQLiteDatabase) {
                Task<TContinuationResult> forResult = Task.forResult(false);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    final ConstraintMatcher constraintMatcher = (ConstraintMatcher) it.next();
                    forResult = forResult.onSuccessTask(new Continuation<Boolean, Task<Boolean>>() {
                        public Task<Boolean> then(Task<Boolean> task) {
                            return task.getResult().booleanValue() ? task : constraintMatcher.matchesAsync(t, parseSQLiteDatabase);
                        }
                    });
                }
                return forResult;
            }
        };
    }

    private <T extends ParseObject> ConstraintMatcher<T> createSelectMatcher(ParseUser parseUser, Object obj, String str) {
        Map map = (Map) obj;
        ParseQuery.State build = ((ParseQuery.State.Builder) map.get(SearchIntents.EXTRA_QUERY)).build();
        final String str2 = (String) map.get("key");
        final String str3 = str;
        return new SubQueryMatcher<T>(parseUser, build) {
            /* access modifiers changed from: protected */
            public boolean matches(T t, List<T> list) {
                Object access$100 = OfflineQueryLogic.getValue(t, str3);
                for (T access$1002 : list) {
                    if (OfflineQueryLogic.matchesEqualConstraint(access$100, OfflineQueryLogic.getValue(access$1002, str2))) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /* access modifiers changed from: private */
    public static Task<Void> fetchIncludeAsync(final OfflineStore offlineStore, final Object obj, final String str, final ParseSQLiteDatabase parseSQLiteDatabase) {
        if (obj == null) {
            return Task.forResult(null);
        }
        if (obj instanceof Collection) {
            Task<TContinuationResult> forResult = Task.forResult(null);
            for (final Object next : (Collection) obj) {
                forResult = forResult.onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return OfflineQueryLogic.fetchIncludeAsync(offlineStore, next, str, parseSQLiteDatabase);
                    }
                });
            }
            return forResult;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            Task<TContinuationResult> forResult2 = Task.forResult(null);
            for (int i = 0; i < jSONArray.length(); i++) {
                final OfflineStore offlineStore2 = offlineStore;
                final JSONArray jSONArray2 = jSONArray;
                final int i2 = i;
                final String str2 = str;
                final ParseSQLiteDatabase parseSQLiteDatabase2 = parseSQLiteDatabase;
                forResult2 = forResult2.onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return OfflineQueryLogic.fetchIncludeAsync(offlineStore2, jSONArray2.get(i2), str2, parseSQLiteDatabase2);
                    }
                });
            }
            return forResult2;
        } else if (str == null) {
            return JSONObject.NULL.equals(obj) ? Task.forResult(null) : obj instanceof ParseObject ? offlineStore.fetchLocallyAsync((ParseObject) obj, parseSQLiteDatabase).makeVoid() : Task.forError(new ParseException(121, "include is invalid for non-ParseObjects"));
        } else {
            String[] split = str.split("\\.", 2);
            final String str3 = split[0];
            final String str4 = split.length > 1 ? split[1] : null;
            return Task.forResult(null).continueWithTask(new Continuation<Void, Task<Object>>() {
                public Task<Object> then(Task<Void> task) {
                    Object obj = obj;
                    if (obj instanceof ParseObject) {
                        return OfflineQueryLogic.fetchIncludeAsync(offlineStore, obj, (String) null, parseSQLiteDatabase).onSuccess(new Continuation<Void, Object>() {
                            public Object then(Task<Void> task) {
                                return ((ParseObject) obj).get(str3);
                            }
                        });
                    }
                    if (obj instanceof Map) {
                        return Task.forResult(((Map) obj).get(str3));
                    }
                    if (obj instanceof JSONObject) {
                        return Task.forResult(((JSONObject) obj).opt(str3));
                    }
                    if (JSONObject.NULL.equals(obj)) {
                        return null;
                    }
                    return Task.forError(new IllegalStateException("include is invalid"));
                }
            }).onSuccessTask(new Continuation<Object, Task<Void>>() {
                public Task<Void> then(Task<Object> task) {
                    return OfflineQueryLogic.fetchIncludeAsync(offlineStore, task.getResult(), str4, parseSQLiteDatabase);
                }
            });
        }
    }

    static <T extends ParseObject> Task<Void> fetchIncludesAsync(final OfflineStore offlineStore, final T t, ParseQuery.State<T> state, final ParseSQLiteDatabase parseSQLiteDatabase) {
        Set<String> includes = state.includes();
        Task<TContinuationResult> forResult = Task.forResult(null);
        for (final String next : includes) {
            forResult = forResult.onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return OfflineQueryLogic.fetchIncludeAsync(offlineStore, t, next, parseSQLiteDatabase);
                }
            });
        }
        return forResult;
    }

    /* access modifiers changed from: private */
    public static Object getValue(Object obj, String str) {
        return getValue(obj, str, 0);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        if (r7.equals("_created_at") != false) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object getValue(java.lang.Object r6, java.lang.String r7, int r8) {
        /*
            java.lang.String r0 = "."
            boolean r0 = r7.contains(r0)
            r1 = 2
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r7.split(r0, r1)
            r1 = r0[r3]
            int r5 = r8 + 1
            java.lang.Object r6 = getValue(r6, r1, r5)
            if (r6 == 0) goto L_0x004f
            java.lang.Object r1 = org.json.JSONObject.NULL
            if (r6 == r1) goto L_0x004f
            boolean r1 = r6 instanceof java.util.Map
            if (r1 != 0) goto L_0x004f
            boolean r1 = r6 instanceof org.json.JSONObject
            if (r1 != 0) goto L_0x004f
            if (r8 <= 0) goto L_0x003d
            com.parse.PointerEncoder r8 = com.parse.PointerEncoder.get()     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r2 = r8.encode(r6)     // Catch:{ Exception -> 0x0032 }
        L_0x0032:
            boolean r6 = r2 instanceof org.json.JSONObject
            if (r6 == 0) goto L_0x003d
            r6 = r0[r4]
            java.lang.Object r6 = getValue(r2, r6, r5)
            return r6
        L_0x003d:
            com.parse.ParseException r6 = new com.parse.ParseException
            r8 = 102(0x66, float:1.43E-43)
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r7
            java.lang.String r7 = "Key %s is invalid."
            java.lang.String r7 = java.lang.String.format(r7, r0)
            r6.<init>(r8, r7)
            throw r6
        L_0x004f:
            r7 = r0[r4]
            java.lang.Object r6 = getValue(r6, r7, r5)
            return r6
        L_0x0056:
            boolean r8 = r6 instanceof com.parse.ParseObject
            r0 = 121(0x79, float:1.7E-43)
            if (r8 == 0) goto L_0x00c6
            com.parse.ParseObject r6 = (com.parse.ParseObject) r6
            boolean r8 = r6.isDataAvailable()
            if (r8 == 0) goto L_0x00b6
            r8 = -1
            int r0 = r7.hashCode()
            switch(r0) {
                case -1949194674: goto L_0x0094;
                case -1836974455: goto L_0x008b;
                case 90495162: goto L_0x0081;
                case 598371643: goto L_0x0077;
                case 792848342: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x009e
        L_0x006d:
            java.lang.String r0 = "_updated_at"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x009e
            r1 = 4
            goto L_0x009f
        L_0x0077:
            java.lang.String r0 = "createdAt"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x009e
            r1 = 1
            goto L_0x009f
        L_0x0081:
            java.lang.String r0 = "objectId"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x009e
            r1 = 0
            goto L_0x009f
        L_0x008b:
            java.lang.String r0 = "_created_at"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x009e
            goto L_0x009f
        L_0x0094:
            java.lang.String r0 = "updatedAt"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x009e
            r1 = 3
            goto L_0x009f
        L_0x009e:
            r1 = -1
        L_0x009f:
            switch(r1) {
                case 0: goto L_0x00b1;
                case 1: goto L_0x00ac;
                case 2: goto L_0x00ac;
                case 3: goto L_0x00a7;
                case 4: goto L_0x00a7;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            java.lang.Object r6 = r6.get(r7)
            return r6
        L_0x00a7:
            java.util.Date r6 = r6.getUpdatedAt()
            return r6
        L_0x00ac:
            java.util.Date r6 = r6.getCreatedAt()
            return r6
        L_0x00b1:
            java.lang.String r6 = r6.getObjectId()
            return r6
        L_0x00b6:
            com.parse.ParseException r6 = new com.parse.ParseException
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r8[r3] = r7
            java.lang.String r7 = "Bad key: %s"
            java.lang.String r7 = java.lang.String.format(r7, r8)
            r6.<init>(r0, r7)
            throw r6
        L_0x00c6:
            boolean r8 = r6 instanceof org.json.JSONObject
            if (r8 == 0) goto L_0x00d1
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            java.lang.Object r6 = r6.opt(r7)
            return r6
        L_0x00d1:
            boolean r8 = r6 instanceof java.util.Map
            if (r8 == 0) goto L_0x00dc
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r6.get(r7)
            return r6
        L_0x00dc:
            java.lang.Object r8 = org.json.JSONObject.NULL
            if (r6 != r8) goto L_0x00e1
            return r2
        L_0x00e1:
            if (r6 != 0) goto L_0x00e4
            return r2
        L_0x00e4:
            com.parse.ParseException r6 = new com.parse.ParseException
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r8[r3] = r7
            java.lang.String r7 = "Bad key: %s"
            java.lang.String r7 = java.lang.String.format(r7, r8)
            r6.<init>(r0, r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.OfflineQueryLogic.getValue(java.lang.Object, java.lang.String, int):java.lang.Object");
    }

    static <T extends ParseObject> boolean hasReadAccess(ParseUser parseUser, T t) {
        ParseACL acl;
        if (parseUser == t || (acl = t.getACL()) == null || acl.getPublicReadAccess()) {
            return true;
        }
        return parseUser != null && acl.getReadAccess(parseUser);
    }

    static <T extends ParseObject> boolean hasWriteAccess(ParseUser parseUser, T t) {
        ParseACL acl;
        if (parseUser == t || (acl = t.getACL()) == null || acl.getPublicWriteAccess()) {
            return true;
        }
        return parseUser != null && acl.getWriteAccess(parseUser);
    }

    private static boolean isAnyValueRegexStartsWith(Collection<?> collection) {
        for (Object isStartsWithRegex : collection) {
            if (isStartsWithRegex(isStartsWithRegex)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStartsWithRegex(Object obj) {
        if (obj == null || !(obj instanceof ParseQuery.KeyConstraints)) {
            return false;
        }
        ParseQuery.KeyConstraints keyConstraints = (ParseQuery.KeyConstraints) obj;
        return keyConstraints.size() == 1 && keyConstraints.containsKey("$regex") && ((String) keyConstraints.get("$regex")).startsWith("^");
    }

    private static boolean matchesAllConstraint(Object obj, Object obj2) {
        if (obj2 == null || obj2 == JSONObject.NULL) {
            return false;
        }
        if (!(obj2 instanceof Collection)) {
            throw new IllegalArgumentException("Value type not supported for $all queries.");
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            if (!isAnyValueRegexStartsWith(collection) || (obj = cleanRegexStartsWith((Collection<?>) collection)) != null) {
                for (Object matchesEqualConstraint : (Collection) obj) {
                    if (!matchesEqualConstraint(matchesEqualConstraint, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException("All values in $all queries must be of starting with regex or non regex.");
        } else {
            throw new IllegalArgumentException("Constraint type not supported for $all queries.");
        }
    }

    /* access modifiers changed from: private */
    public static boolean matchesEqualConstraint(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return obj == obj2;
        }
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return compareTo(obj, obj2) == 0;
        }
        if ((obj instanceof ParseGeoPoint) && (obj2 instanceof ParseGeoPoint)) {
            ParseGeoPoint parseGeoPoint = (ParseGeoPoint) obj;
            ParseGeoPoint parseGeoPoint2 = (ParseGeoPoint) obj2;
            return parseGeoPoint.getLatitude() == parseGeoPoint2.getLatitude() && parseGeoPoint.getLongitude() == parseGeoPoint2.getLongitude();
        } else if ((obj instanceof ParsePolygon) && (obj2 instanceof ParsePolygon)) {
            return ((ParsePolygon) obj).equals((ParsePolygon) obj2);
        } else {
            return compare(obj, obj2, isStartsWithRegex(obj) ? new Decider() {
                public boolean decide(Object obj, Object obj2) {
                    return ((String) obj2).matches(((ParseQuery.KeyConstraints) obj).get("$regex").toString());
                }
            } : new Decider() {
                public boolean decide(Object obj, Object obj2) {
                    return obj.equals(obj2);
                }
            });
        }
    }

    private static boolean matchesExistsConstraint(Object obj, Object obj2) {
        return (obj == null || !((Boolean) obj).booleanValue()) ? obj2 == null || obj2 == JSONObject.NULL : (obj2 == null || obj2 == JSONObject.NULL) ? false : true;
    }

    private static boolean matchesGeoIntersectsConstraint(Object obj, Object obj2) {
        if (obj2 == null || obj2 == JSONObject.NULL) {
            return false;
        }
        return ((ParsePolygon) obj2).containsPoint((ParseGeoPoint) ((HashMap) obj).get("$point"));
    }

    private static boolean matchesGeoWithinConstraint(Object obj, Object obj2) {
        if (obj2 == null || obj2 == JSONObject.NULL) {
            return false;
        }
        return new ParsePolygon((List<ParseGeoPoint>) (List) ((HashMap) obj).get("$polygon")).containsPoint((ParseGeoPoint) obj2);
    }

    private static boolean matchesGreaterThanConstraint(Object obj, Object obj2) {
        return compare(obj, obj2, new Decider() {
            public boolean decide(Object obj, Object obj2) {
                return (obj2 == null || obj2 == JSONObject.NULL || OfflineQueryLogic.compareTo(obj, obj2) >= 0) ? false : true;
            }
        });
    }

    private static boolean matchesGreaterThanOrEqualToConstraint(Object obj, Object obj2) {
        return compare(obj, obj2, new Decider() {
            public boolean decide(Object obj, Object obj2) {
                return (obj2 == null || obj2 == JSONObject.NULL || OfflineQueryLogic.compareTo(obj, obj2) > 0) ? false : true;
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean matchesInConstraint(Object obj, Object obj2) {
        if (obj instanceof Collection) {
            for (Object matchesEqualConstraint : (Collection) obj) {
                if (matchesEqualConstraint(matchesEqualConstraint, obj2)) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Constraint type not supported for $in queries.");
    }

    private static boolean matchesLessThanConstraint(Object obj, Object obj2) {
        return compare(obj, obj2, new Decider() {
            public boolean decide(Object obj, Object obj2) {
                return (obj2 == null || obj2 == JSONObject.NULL || OfflineQueryLogic.compareTo(obj, obj2) <= 0) ? false : true;
            }
        });
    }

    private static boolean matchesLessThanOrEqualToConstraint(Object obj, Object obj2) {
        return compare(obj, obj2, new Decider() {
            public boolean decide(Object obj, Object obj2) {
                return (obj2 == null || obj2 == JSONObject.NULL || OfflineQueryLogic.compareTo(obj, obj2) < 0) ? false : true;
            }
        });
    }

    private static boolean matchesNearSphereConstraint(Object obj, Object obj2, Double d) {
        if (obj2 == null || obj2 == JSONObject.NULL) {
            return false;
        }
        return d == null || ((ParseGeoPoint) obj).distanceInRadiansTo((ParseGeoPoint) obj2) <= d.doubleValue();
    }

    private static boolean matchesNotEqualConstraint(Object obj, Object obj2) {
        return !matchesEqualConstraint(obj, obj2);
    }

    private static boolean matchesNotInConstraint(Object obj, Object obj2) {
        return !matchesInConstraint(obj, obj2);
    }

    private static boolean matchesRegexConstraint(Object obj, Object obj2, String str) {
        int i = 0;
        if (obj2 == null || obj2 == JSONObject.NULL) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        if (str.matches("^[imxs]*$")) {
            if (str.contains("i")) {
                i = 2;
            }
            if (str.contains("m")) {
                i |= 8;
            }
            if (str.contains("x")) {
                i |= 4;
            }
            if (str.contains("s")) {
                i |= 32;
            }
            return Pattern.compile((String) obj, i).matcher((String) obj2).find();
        }
        throw new ParseException(102, String.format("Invalid regex options: %s", new Object[]{str}));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean matchesStatelessConstraint(java.lang.String r3, java.lang.Object r4, java.lang.Object r5, com.parse.ParseQuery.KeyConstraints r6) {
        /*
            int r0 = r3.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -2013624456: goto L_0x00ae;
                case -1622199595: goto L_0x00a3;
                case -443727559: goto L_0x0098;
                case 37905: goto L_0x008e;
                case 37961: goto L_0x0084;
                case 38060: goto L_0x007a;
                case 38107: goto L_0x0070;
                case 1169149: goto L_0x0066;
                case 1175156: goto L_0x005c;
                case 1179961: goto L_0x0052;
                case 1181551: goto L_0x0047;
                case 596003200: goto L_0x003b;
                case 1097791887: goto L_0x002f;
                case 1139041955: goto L_0x0023;
                case 1362155002: goto L_0x0017;
                case 1785385921: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00b9
        L_0x000b:
            java.lang.String r0 = "$geoIntersects"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 15
            goto L_0x00ba
        L_0x0017:
            java.lang.String r0 = "$options"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 9
            goto L_0x00ba
        L_0x0023:
            java.lang.String r0 = "$regex"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 8
            goto L_0x00ba
        L_0x002f:
            java.lang.String r0 = "$within"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 13
            goto L_0x00ba
        L_0x003b:
            java.lang.String r0 = "$exists"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 10
            goto L_0x00ba
        L_0x0047:
            java.lang.String r0 = "$nin"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 6
            goto L_0x00ba
        L_0x0052:
            java.lang.String r0 = "$lte"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 2
            goto L_0x00ba
        L_0x005c:
            java.lang.String r0 = "$gte"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 4
            goto L_0x00ba
        L_0x0066:
            java.lang.String r0 = "$all"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 7
            goto L_0x00ba
        L_0x0070:
            java.lang.String r0 = "$ne"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 0
            goto L_0x00ba
        L_0x007a:
            java.lang.String r0 = "$lt"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 1
            goto L_0x00ba
        L_0x0084:
            java.lang.String r0 = "$in"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 5
            goto L_0x00ba
        L_0x008e:
            java.lang.String r0 = "$gt"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 3
            goto L_0x00ba
        L_0x0098:
            java.lang.String r0 = "$nearSphere"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 11
            goto L_0x00ba
        L_0x00a3:
            java.lang.String r0 = "$maxDistance"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 12
            goto L_0x00ba
        L_0x00ae:
            java.lang.String r0 = "$geoWithin"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00b9
            r0 = 14
            goto L_0x00ba
        L_0x00b9:
            r0 = -1
        L_0x00ba:
            switch(r0) {
                case 0: goto L_0x0120;
                case 1: goto L_0x011b;
                case 2: goto L_0x0116;
                case 3: goto L_0x0111;
                case 4: goto L_0x010c;
                case 5: goto L_0x0107;
                case 6: goto L_0x0102;
                case 7: goto L_0x00fd;
                case 8: goto L_0x00f0;
                case 9: goto L_0x00ef;
                case 10: goto L_0x00ea;
                case 11: goto L_0x00dd;
                case 12: goto L_0x00dc;
                case 13: goto L_0x00d7;
                case 14: goto L_0x00d2;
                case 15: goto L_0x00cd;
                default: goto L_0x00bd;
            }
        L_0x00bd:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r3
            java.lang.String r3 = "The offline store does not yet support the %s operator."
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r4.<init>(r3)
            throw r4
        L_0x00cd:
            boolean r3 = matchesGeoIntersectsConstraint(r4, r5)
            return r3
        L_0x00d2:
            boolean r3 = matchesGeoWithinConstraint(r4, r5)
            return r3
        L_0x00d7:
            boolean r3 = matchesWithinConstraint(r4, r5)
            return r3
        L_0x00dc:
            return r2
        L_0x00dd:
            java.lang.String r3 = "$maxDistance"
            java.lang.Object r3 = r6.get(r3)
            java.lang.Double r3 = (java.lang.Double) r3
            boolean r3 = matchesNearSphereConstraint(r4, r5, r3)
            return r3
        L_0x00ea:
            boolean r3 = matchesExistsConstraint(r4, r5)
            return r3
        L_0x00ef:
            return r2
        L_0x00f0:
            java.lang.String r3 = "$options"
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = matchesRegexConstraint(r4, r5, r3)
            return r3
        L_0x00fd:
            boolean r3 = matchesAllConstraint(r4, r5)
            return r3
        L_0x0102:
            boolean r3 = matchesNotInConstraint(r4, r5)
            return r3
        L_0x0107:
            boolean r3 = matchesInConstraint(r4, r5)
            return r3
        L_0x010c:
            boolean r3 = matchesGreaterThanOrEqualToConstraint(r4, r5)
            return r3
        L_0x0111:
            boolean r3 = matchesGreaterThanConstraint(r4, r5)
            return r3
        L_0x0116:
            boolean r3 = matchesLessThanOrEqualToConstraint(r4, r5)
            return r3
        L_0x011b:
            boolean r3 = matchesLessThanConstraint(r4, r5)
            return r3
        L_0x0120:
            boolean r3 = matchesNotEqualConstraint(r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.OfflineQueryLogic.matchesStatelessConstraint(java.lang.String, java.lang.Object, java.lang.Object, com.parse.ParseQuery$KeyConstraints):boolean");
    }

    private static boolean matchesWithinConstraint(Object obj, Object obj2) {
        if (obj2 == null || obj2 == JSONObject.NULL) {
            return false;
        }
        ArrayList arrayList = (ArrayList) ((HashMap) obj).get("$box");
        ParseGeoPoint parseGeoPoint = (ParseGeoPoint) arrayList.get(0);
        ParseGeoPoint parseGeoPoint2 = (ParseGeoPoint) arrayList.get(1);
        ParseGeoPoint parseGeoPoint3 = (ParseGeoPoint) obj2;
        if (parseGeoPoint2.getLongitude() < parseGeoPoint.getLongitude()) {
            throw new ParseException(102, "whereWithinGeoBox queries cannot cross the International Date Line.");
        } else if (parseGeoPoint2.getLatitude() < parseGeoPoint.getLatitude()) {
            throw new ParseException(102, "The southwest corner of a geo box must be south of the northeast corner.");
        } else if (parseGeoPoint2.getLongitude() - parseGeoPoint.getLongitude() <= 180.0d) {
            return parseGeoPoint3.getLatitude() >= parseGeoPoint.getLatitude() && parseGeoPoint3.getLatitude() <= parseGeoPoint2.getLatitude() && parseGeoPoint3.getLongitude() >= parseGeoPoint.getLongitude() && parseGeoPoint3.getLongitude() <= parseGeoPoint2.getLongitude();
        } else {
            throw new ParseException(102, "Geo box queries larger than 180 degrees in longitude are not supported. Please check point order.");
        }
    }

    static <T extends ParseObject> void sort(List<T> list, ParseQuery.State<T> state) {
        final List<String> order = state.order();
        for (String next : state.order()) {
            if (!next.matches("^-?[A-Za-z][A-Za-z0-9_]*$") && !"_created_at".equals(next) && !"_updated_at".equals(next)) {
                throw new ParseException(105, String.format("Invalid key name: \"%s\".", new Object[]{next}));
            }
        }
        final String str = null;
        final ParseGeoPoint parseGeoPoint = null;
        for (String str2 : state.constraints().keySet()) {
            Object obj = state.constraints().get(str2);
            if (obj instanceof ParseQuery.KeyConstraints) {
                ParseQuery.KeyConstraints keyConstraints = (ParseQuery.KeyConstraints) obj;
                if (keyConstraints.containsKey("$nearSphere")) {
                    parseGeoPoint = (ParseGeoPoint) keyConstraints.get("$nearSphere");
                    str = str2;
                }
            }
        }
        if (order.size() != 0 || str != null) {
            Collections.sort(list, new Comparator<T>() {
                public int compare(T t, T t2) {
                    boolean z;
                    String str = str;
                    if (str != null) {
                        try {
                            ParseGeoPoint parseGeoPoint = (ParseGeoPoint) OfflineQueryLogic.getValue(t, str);
                            ParseGeoPoint parseGeoPoint2 = (ParseGeoPoint) OfflineQueryLogic.getValue(t2, str);
                            double distanceInRadiansTo = parseGeoPoint.distanceInRadiansTo(parseGeoPoint);
                            double distanceInRadiansTo2 = parseGeoPoint2.distanceInRadiansTo(parseGeoPoint);
                            if (distanceInRadiansTo != distanceInRadiansTo2) {
                                return distanceInRadiansTo - distanceInRadiansTo2 > 0.0d ? 1 : -1;
                            }
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    for (String str2 : order) {
                        if (str2.startsWith("-")) {
                            str2 = str2.substring(1);
                            z = true;
                        } else {
                            z = false;
                        }
                        try {
                            try {
                                int access$000 = OfflineQueryLogic.compareTo(OfflineQueryLogic.getValue(t, str2), OfflineQueryLogic.getValue(t2, str2));
                                if (access$000 != 0) {
                                    return z ? -access$000 : access$000;
                                }
                            } catch (IllegalArgumentException e2) {
                                throw new IllegalArgumentException(String.format("Unable to sort by key %s.", new Object[]{str2}), e2);
                            }
                        } catch (ParseException e3) {
                            throw new RuntimeException(e3);
                        }
                    }
                    return 0;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> ConstraintMatcher<T> createMatcher(ParseQuery.State<T> state, ParseUser parseUser) {
        final boolean ignoreACLs = state.ignoreACLs();
        final ConstraintMatcher createMatcher = createMatcher(parseUser, state.constraints());
        return new ConstraintMatcher<T>(parseUser) {
            public Task<Boolean> matchesAsync(T t, ParseSQLiteDatabase parseSQLiteDatabase) {
                return (ignoreACLs || OfflineQueryLogic.hasReadAccess(this.user, t)) ? createMatcher.matchesAsync(t, parseSQLiteDatabase) : Task.forResult(false);
            }
        };
    }
}
