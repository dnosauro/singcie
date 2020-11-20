package com.parse;

import android.os.Bundle;
import android.os.Parcel;
import bolts.Continuation;
import bolts.Task;
import com.parse.ParseObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@ParseClassName("_User")
public class ParseUser extends ParseObject {
    private static final String KEY_AUTH_DATA = "authData";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_SESSION_TOKEN = "sessionToken";
    private static final String KEY_USERNAME = "username";
    private static final String PARCEL_KEY_IS_CURRENT_USER = "_isCurrentUser";
    private static final List<String> READ_ONLY_KEYS = Collections.unmodifiableList(Arrays.asList(new String[]{KEY_SESSION_TOKEN, KEY_AUTH_DATA}));
    private static boolean autoUserEnabled;
    private static final Object isAutoUserEnabledMutex = new Object();
    private boolean isCurrentUser = false;

    static class State extends ParseObject.State {
        private final boolean isNew;

        static class Builder extends ParseObject.State.Init<Builder> {
            /* access modifiers changed from: private */
            public boolean isNew;

            public Builder() {
                super("_User");
            }

            Builder(State state) {
                super((ParseObject.State) state);
                this.isNew = state.isNew();
            }

            public Builder apply(ParseObject.State state) {
                isNew(((State) state).isNew());
                return (Builder) super.apply(state);
            }

            public Builder authData(Map<String, Map<String, String>> map) {
                return (Builder) put(ParseUser.KEY_AUTH_DATA, map);
            }

            public State build() {
                return new State(this);
            }

            public Builder isNew(boolean z) {
                this.isNew = z;
                return this;
            }

            public Builder putAuthData(String str, Map<String, String> map) {
                Map map2 = (Map) this.serverData.get(ParseUser.KEY_AUTH_DATA);
                if (map2 == null) {
                    map2 = new HashMap();
                }
                map2.put(str, map);
                this.serverData.put(ParseUser.KEY_AUTH_DATA, map2);
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder self() {
                return this;
            }

            public Builder sessionToken(String str) {
                return (Builder) put(ParseUser.KEY_SESSION_TOKEN, str);
            }
        }

        State(Parcel parcel, String str, ParseParcelDecoder parseParcelDecoder) {
            super(parcel, str, parseParcelDecoder);
            this.isNew = parcel.readByte() != 1 ? false : true;
        }

        private State(Builder builder) {
            super(builder);
            this.isNew = builder.isNew;
        }

        public Map<String, Map<String, String>> authData() {
            Map<String, Map<String, String>> map = (Map) get(ParseUser.KEY_AUTH_DATA);
            return map == null ? new HashMap() : map;
        }

        public boolean isNew() {
            return this.isNew;
        }

        public Builder newBuilder() {
            return new Builder(this);
        }

        public String sessionToken() {
            return (String) get(ParseUser.KEY_SESSION_TOKEN);
        }

        /* access modifiers changed from: protected */
        public void writeToParcel(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
            super.writeToParcel(parcel, parseParcelEncoder);
            parcel.writeByte(this.isNew ? (byte) 1 : 0);
        }
    }

    public static ParseUser become(String str) {
        return (ParseUser) ParseTaskUtils.wait(becomeInBackground(str));
    }

    public static Task<ParseUser> becomeInBackground(String str) {
        if (str != null) {
            return getUserController().getUserAsync(str).onSuccessTask(new Continuation<State, Task<ParseUser>>() {
                public Task<ParseUser> then(Task<State> task) {
                    final ParseUser parseUser = (ParseUser) ParseObject.from(task.getResult());
                    return ParseUser.saveCurrentUserAsync(parseUser).onSuccess(new Continuation<Void, ParseUser>() {
                        public ParseUser then(Task<Void> task) {
                            return parseUser;
                        }
                    });
                }
            });
        }
        throw new IllegalArgumentException("Must specify a sessionToken for the user to log in with");
    }

    public static void becomeInBackground(String str, LogInCallback logInCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(becomeInBackground(str), logInCallback);
    }

    static void disableAutomaticUser() {
        synchronized (isAutoUserEnabledMutex) {
            autoUserEnabled = false;
        }
    }

    public static void enableAutomaticUser() {
        synchronized (isAutoUserEnabledMutex) {
            autoUserEnabled = true;
        }
    }

    public static Task<Void> enableRevocableSessionInBackground() {
        ParseCorePlugins.getInstance().registerUserController(new NetworkUserController(ParsePlugins.get().restClient(), true));
        return getCurrentUserController().getAsync(false).onSuccessTask(new Continuation<ParseUser, Task<Void>>() {
            public Task<Void> then(Task<ParseUser> task) {
                ParseUser result = task.getResult();
                return result == null ? Task.forResult(null) : result.upgradeToRevocableSessionAsync();
            }
        });
    }

    /* access modifiers changed from: private */
    public Map<String, String> getAuthData(String str) {
        return getAuthData().get(str);
    }

    static ParseAuthenticationManager getAuthenticationManager() {
        return ParseCorePlugins.getInstance().getAuthenticationManager();
    }

    public static String getCurrentSessionToken() {
        ParseUser currentUser = getCurrentUser();
        if (currentUser != null) {
            return currentUser.getSessionToken();
        }
        return null;
    }

    public static Task<String> getCurrentSessionTokenAsync() {
        return getCurrentUserController().getCurrentSessionTokenAsync();
    }

    public static ParseUser getCurrentUser() {
        return getCurrentUser(isAutomaticUserEnabled());
    }

    private static ParseUser getCurrentUser(boolean z) {
        try {
            return (ParseUser) ParseTaskUtils.wait(getCurrentUserController().getAsync(z));
        } catch (ParseException unused) {
            return null;
        }
    }

    static Task<ParseUser> getCurrentUserAsync() {
        return getCurrentUserController().getAsync();
    }

    static ParseCurrentUserController getCurrentUserController() {
        return ParseCorePlugins.getInstance().getCurrentUserController();
    }

    public static ParseQuery<ParseUser> getQuery() {
        return ParseQuery.getQuery(ParseUser.class);
    }

    static ParseUserController getUserController() {
        return ParseCorePlugins.getInstance().getUserController();
    }

    static boolean isAutomaticUserEnabled() {
        boolean z;
        synchronized (isAutoUserEnabledMutex) {
            z = autoUserEnabled;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public Task<Void> linkWithAsync(final String str, Map<String, String> map, Task<Void> task, String str2) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.mutex) {
            boolean isLazy = isLazy();
            final Map<String, String> authData = getAuthData("anonymous");
            stripAnonymity();
            putAuthData(str, map);
            continueWithTask = saveAsync(str2, isLazy, task).continueWithTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    synchronized (ParseUser.this.mutex) {
                        if (!task.isFaulted()) {
                            if (!task.isCancelled()) {
                                Task<Void> synchronizeAuthDataAsync = ParseUser.this.synchronizeAuthDataAsync(str);
                                return synchronizeAuthDataAsync;
                            }
                        }
                        ParseUser.this.removeAuthData(str);
                        ParseUser.this.restoreAnonymity(authData);
                        return task;
                    }
                }
            });
        }
        return continueWithTask;
    }

    private Task<Void> linkWithAsync(final String str, final Map<String, String> map, final String str2) {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseUser.this.linkWithAsync(str, map, task, str2);
            }
        });
    }

    public static ParseUser logIn(String str, String str2) {
        return (ParseUser) ParseTaskUtils.wait(logInInBackground(str, str2));
    }

    public static Task<ParseUser> logInInBackground(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Must specify a username for the user to log in with");
        } else if (str2 != null) {
            return getUserController().logInAsync(str, str2).onSuccessTask(new Continuation<State, Task<ParseUser>>() {
                public Task<ParseUser> then(Task<State> task) {
                    final ParseUser parseUser = (ParseUser) ParseObject.from(task.getResult());
                    return ParseUser.saveCurrentUserAsync(parseUser).onSuccess(new Continuation<Void, ParseUser>() {
                        public ParseUser then(Task<Void> task) {
                            return parseUser;
                        }
                    });
                }
            });
        } else {
            throw new IllegalArgumentException("Must specify a password for the user to log in with");
        }
    }

    public static void logInInBackground(String str, String str2, LogInCallback logInCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(str, str2), logInCallback);
    }

    public static Task<ParseUser> logInWithInBackground(final String str, final Map<String, String> map) {
        if (str != null) {
            final C30103 r0 = new Continuation<Void, Task<ParseUser>>() {
                public Task<ParseUser> then(Task<Void> task) {
                    return ParseUser.getUserController().logInAsync(str, (Map<String, String>) map).onSuccessTask(new Continuation<State, Task<ParseUser>>() {
                        public Task<ParseUser> then(Task<State> task) {
                            final ParseUser parseUser = (ParseUser) ParseObject.from(task.getResult());
                            return ParseUser.saveCurrentUserAsync(parseUser).onSuccess(new Continuation<Void, ParseUser>() {
                                public ParseUser then(Task<Void> task) {
                                    return parseUser;
                                }
                            });
                        }
                    });
                }
            };
            return getCurrentUserController().getAsync(false).onSuccessTask(new Continuation<ParseUser, Task<ParseUser>>() {
                public Task<ParseUser> then(Task<ParseUser> task) {
                    final ParseUser result = task.getResult();
                    if (result != null) {
                        synchronized (result.mutex) {
                            if (ParseAnonymousUtils.isLinked(result)) {
                                if (result.isLazy()) {
                                    final Map access$100 = result.getAuthData("anonymous");
                                    Task<ParseUser> enqueue = result.taskQueue.enqueue(new Continuation<Void, Task<ParseUser>>() {
                                        public Task<ParseUser> then(Task<Void> task) {
                                            return task.continueWithTask(new Continuation<Void, Task<Void>>() {
                                                public Task<Void> then(Task<Void> task) {
                                                    Task<Void> resolveLazinessAsync;
                                                    synchronized (result.mutex) {
                                                        result.stripAnonymity();
                                                        result.putAuthData(str, map);
                                                        resolveLazinessAsync = result.resolveLazinessAsync(task);
                                                    }
                                                    return resolveLazinessAsync;
                                                }
                                            }).continueWithTask(new Continuation<Void, Task<ParseUser>>() {
                                                public Task<ParseUser> then(Task<Void> task) {
                                                    synchronized (result.mutex) {
                                                        if (task.isFaulted()) {
                                                            result.removeAuthData(str);
                                                            result.restoreAnonymity(access$100);
                                                            Task<ParseUser> forError = Task.forError(task.getError());
                                                            return forError;
                                                        } else if (task.isCancelled()) {
                                                            Task<ParseUser> cancelled = Task.cancelled();
                                                            return cancelled;
                                                        } else {
                                                            Task<ParseUser> forResult = Task.forResult(result);
                                                            return forResult;
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    });
                                    return enqueue;
                                }
                                Task<TContinuationResult> continueWithTask = result.linkWithInBackground(str, map).continueWithTask(new Continuation<Void, Task<ParseUser>>() {
                                    public Task<ParseUser> then(Task<Void> task) {
                                        if (task.isFaulted()) {
                                            Exception error = task.getError();
                                            if ((error instanceof ParseException) && ((ParseException) error).getCode() == 208) {
                                                return Task.forResult(null).continueWithTask(r0);
                                            }
                                        }
                                        return task.isCancelled() ? Task.cancelled() : Task.forResult(result);
                                    }
                                });
                                return continueWithTask;
                            }
                        }
                    }
                    return Task.forResult(null).continueWithTask(r0);
                }
            });
        }
        throw new IllegalArgumentException("Invalid authType: " + null);
    }

    public static void logOut() {
        try {
            ParseTaskUtils.wait(logOutInBackground());
        } catch (ParseException unused) {
        }
    }

    public static Task<Void> logOutInBackground() {
        return getCurrentUserController().logOutAsync();
    }

    public static void logOutInBackground(LogOutCallback logOutCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(logOutInBackground(), (ParseCallback1<ParseException>) logOutCallback);
    }

    static Task<Void> pinCurrentUserIfNeededAsync(ParseUser parseUser) {
        if (Parse.isLocalDatastoreEnabled()) {
            return getCurrentUserController().setIfNeededAsync(parseUser);
        }
        throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }

    public static void registerAuthenticationCallback(String str, AuthenticationCallback authenticationCallback) {
        getAuthenticationManager().register(str, authenticationCallback);
    }

    /* access modifiers changed from: private */
    public void removeAuthData(String str) {
        synchronized (this.mutex) {
            Map<String, Map<String, String>> authData = getAuthData();
            authData.remove(str);
            performPut(KEY_AUTH_DATA, authData);
        }
    }

    public static void requestPasswordReset(String str) {
        ParseTaskUtils.wait(requestPasswordResetInBackground(str));
    }

    public static Task<Void> requestPasswordResetInBackground(String str) {
        return getUserController().requestPasswordResetAsync(str);
    }

    public static void requestPasswordResetInBackground(String str, RequestPasswordResetCallback requestPasswordResetCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(requestPasswordResetInBackground(str), (ParseCallback1<ParseException>) requestPasswordResetCallback);
    }

    /* access modifiers changed from: private */
    public void restoreAnonymity(Map<String, String> map) {
        synchronized (this.mutex) {
            if (map != null) {
                putAuthData("anonymous", map);
            }
        }
    }

    /* access modifiers changed from: private */
    public static Task<Void> saveCurrentUserAsync(ParseUser parseUser) {
        return getCurrentUserController().setAsync(parseUser);
    }

    /* access modifiers changed from: private */
    public Task<Void> setSessionTokenInBackground(String str) {
        synchronized (this.mutex) {
            State state = getState();
            if (str.equals(state.sessionToken())) {
                Task<Void> forResult = Task.forResult(null);
                return forResult;
            }
            setState(state.newBuilder().sessionToken(str).build());
            Task<Void> saveCurrentUserAsync = saveCurrentUserAsync(this);
            return saveCurrentUserAsync;
        }
    }

    /* access modifiers changed from: private */
    public void stripAnonymity() {
        synchronized (this.mutex) {
            if (ParseAnonymousUtils.isLinked(this)) {
                if (getObjectId() != null) {
                    putAuthData("anonymous", (Map<String, String>) null);
                } else {
                    removeAuthData("anonymous");
                }
            }
        }
    }

    private Task<Void> synchronizeAuthDataAsync(ParseAuthenticationManager parseAuthenticationManager, final String str, Map<String, String> map) {
        return parseAuthenticationManager.restoreAuthenticationAsync(str, map).continueWithTask(new Continuation<Boolean, Task<Void>>() {
            public Task<Void> then(Task<Boolean> task) {
                return !(!task.isFaulted() && task.getResult().booleanValue()) ? ParseUser.this.unlinkFromInBackground(str) : task.makeVoid();
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> upgradeToRevocableSessionAsync(Task<Void> task) {
        final String sessionToken = getSessionToken();
        return task.continueWithTask(new Continuation<Void, Task<String>>() {
            public Task<String> then(Task<Void> task) {
                return ParseSession.upgradeToRevocableSessionAsync(sessionToken);
            }
        }).onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                return ParseUser.this.setSessionTokenInBackground(task.getResult());
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r3.hasNext() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r5 = r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r5.getValue() != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r3.remove();
        r1.add(r0.restoreAuthenticationAsync((java.lang.String) r5.getKey(), (java.util.Map<java.lang.String, java.lang.String>) null).makeVoid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        setState(getState().newBuilder().authData(r2).build());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0068, code lost:
        return bolts.Task.whenAll(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r1 = new java.util.ArrayList();
        r3 = r2.entrySet().iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bolts.Task<java.lang.Void> cleanUpAuthDataAsync() {
        /*
            r7 = this;
            com.parse.ParseAuthenticationManager r0 = getAuthenticationManager()
            java.lang.Object r1 = r7.mutex
            monitor-enter(r1)
            com.parse.ParseUser$State r2 = r7.getState()     // Catch:{ all -> 0x0069 }
            java.util.Map r2 = r2.authData()     // Catch:{ all -> 0x0069 }
            int r3 = r2.size()     // Catch:{ all -> 0x0069 }
            r4 = 0
            if (r3 != 0) goto L_0x001c
            bolts.Task r0 = bolts.Task.forResult(r4)     // Catch:{ all -> 0x0069 }
            monitor-exit(r1)     // Catch:{ all -> 0x0069 }
            return r0
        L_0x001c:
            monitor-exit(r1)     // Catch:{ all -> 0x0069 }
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Set r3 = r2.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x002a:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0051
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getValue()
            if (r6 != 0) goto L_0x002a
            r3.remove()
            java.lang.Object r5 = r5.getKey()
            java.lang.String r5 = (java.lang.String) r5
            bolts.Task r5 = r0.restoreAuthenticationAsync(r5, r4)
            bolts.Task r5 = r5.makeVoid()
            r1.add(r5)
            goto L_0x002a
        L_0x0051:
            com.parse.ParseUser$State r0 = r7.getState()
            com.parse.ParseUser$State$Builder r0 = r0.newBuilder()
            com.parse.ParseUser$State$Builder r0 = r0.authData(r2)
            com.parse.ParseUser$State r0 = r0.build()
            r7.setState(r0)
            bolts.Task r0 = bolts.Task.whenAll(r1)
            return r0
        L_0x0069:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0069 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseUser.cleanUpAuthDataAsync():bolts.Task");
    }

    public ParseUser fetch() {
        return (ParseUser) super.fetch();
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<T> fetchAsync(String str, Task<Void> task) {
        if (isLazy()) {
            return Task.forResult(this);
        }
        Task<T> fetchAsync = super.fetchAsync(str, task);
        return isCurrentUser() ? fetchAsync.onSuccessTask(new Continuation<T, Task<Void>>() {
            public Task<Void> then(Task<T> task) {
                return ParseUser.this.cleanUpAuthDataAsync();
            }
        }).onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseUser.saveCurrentUserAsync(ParseUser.this);
            }
        }).onSuccess(new Continuation<Void, T>() {
            public T then(Task<Void> task) {
                return ParseUser.this;
            }
        }) : fetchAsync;
    }

    /* access modifiers changed from: package-private */
    public <T extends ParseObject> Task<T> fetchFromLocalDatastoreAsync() {
        return isLazy() ? Task.forResult(this) : super.fetchFromLocalDatastoreAsync();
    }

    public ParseUser fetchIfNeeded() {
        return (ParseUser) super.fetchIfNeeded();
    }

    /* access modifiers changed from: package-private */
    public Map<String, Map<String, String>> getAuthData() {
        Map<String, Map<String, String>> map;
        synchronized (this.mutex) {
            map = getMap(KEY_AUTH_DATA);
            if (map == null) {
                map = new HashMap<>();
            }
        }
        return map;
    }

    public String getEmail() {
        return getString("email");
    }

    /* access modifiers changed from: package-private */
    public String getPassword() {
        return getString(KEY_PASSWORD);
    }

    public String getSessionToken() {
        return getState().sessionToken();
    }

    /* access modifiers changed from: package-private */
    public State getState() {
        return (State) super.getState();
    }

    public String getUsername() {
        return getString(KEY_USERNAME);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> handleSaveResultAsync(ParseObject.State state, ParseOperationSet parseOperationSet) {
        if (state != null) {
            parseOperationSet.remove(KEY_PASSWORD);
        }
        return super.handleSaveResultAsync(state, parseOperationSet);
    }

    public boolean isAuthenticated() {
        boolean z;
        synchronized (this.mutex) {
            ParseUser currentUser = getCurrentUser();
            if (!isLazy()) {
                if (getState().sessionToken() == null || currentUser == null || !getObjectId().equals(currentUser.getObjectId())) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrentUser() {
        boolean z;
        synchronized (this.mutex) {
            z = this.isCurrentUser;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isKeyMutable(String str) {
        return !READ_ONLY_KEYS.contains(str);
    }

    /* access modifiers changed from: package-private */
    public boolean isLazy() {
        boolean z;
        synchronized (this.mutex) {
            z = getObjectId() == null && ParseAnonymousUtils.isLinked(this);
        }
        return z;
    }

    public boolean isLinked(String str) {
        Map<String, Map<String, String>> authData = getAuthData();
        return authData.containsKey(str) && authData.get(str) != null;
    }

    public boolean isNew() {
        return getState().isNew();
    }

    public Task<Void> linkWithInBackground(String str, Map<String, String> map) {
        if (str != null) {
            return linkWithAsync(str, map, getSessionToken());
        }
        throw new IllegalArgumentException("Invalid authType: " + null);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> logOutAsync() {
        return logOutAsync(true);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> logOutAsync(boolean z) {
        String sessionToken;
        ParseAuthenticationManager authenticationManager = getAuthenticationManager();
        ArrayList arrayList = new ArrayList();
        synchronized (this.mutex) {
            sessionToken = getState().sessionToken();
            for (Map.Entry<String, Map<String, String>> key : getAuthData().entrySet()) {
                arrayList.add(authenticationManager.deauthenticateAsync((String) key.getKey()));
            }
            State build = getState().newBuilder().sessionToken((String) null).isNew(false).build();
            this.isCurrentUser = false;
            setState(build);
        }
        if (z) {
            arrayList.add(ParseSession.revokeAsync(sessionToken));
        }
        return Task.whenAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public boolean needsDefaultACL() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public State.Builder newStateBuilder(String str) {
        return new State.Builder();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        setIsCurrentUser(bundle.getBoolean(PARCEL_KEY_IS_CURRENT_USER, false));
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        synchronized (this.mutex) {
            bundle.putBoolean(PARCEL_KEY_IS_CURRENT_USER, this.isCurrentUser);
        }
    }

    public void put(String str, Object obj) {
        synchronized (this.mutex) {
            if (KEY_USERNAME.equals(str)) {
                stripAnonymity();
            }
            super.put(str, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void putAuthData(String str, Map<String, String> map) {
        synchronized (this.mutex) {
            Map<String, Map<String, String>> authData = getAuthData();
            authData.put(str, map);
            performPut(KEY_AUTH_DATA, authData);
        }
    }

    public void remove(String str) {
        if (!KEY_USERNAME.equals(str)) {
            super.remove(str);
            return;
        }
        throw new IllegalArgumentException("Can't remove the username key.");
    }

    /* access modifiers changed from: package-private */
    public Task<Void> resolveLazinessAsync(Task<Void> task) {
        synchronized (this.mutex) {
            if (getAuthData().size() == 0) {
                Task<Void> signUpAsync = signUpAsync(task);
                return signUpAsync;
            }
            final ParseOperationSet startSave = startSave();
            Task<TContinuationResult> onSuccessTask = task.onSuccessTask(new Continuation<Void, Task<Void>>() {
                public Task<Void> then(Task<Void> task) {
                    return ParseUser.getUserController().logInAsync(ParseUser.this.getState(), startSave).onSuccessTask(new Continuation<State, Task<Void>>() {
                        public Task<Void> then(Task<State> task) {
                            final State result = task.getResult();
                            return ((!Parse.isLocalDatastoreEnabled() || result.isNew()) ? ParseUser.this.handleSaveResultAsync(result, startSave).onSuccess(new Continuation<Void, State>() {
                                public State then(Task<Void> task) {
                                    return result;
                                }
                            }) : Task.forResult(result)).onSuccessTask(new Continuation<State, Task<Void>>() {
                                public Task<Void> then(Task<State> task) {
                                    State result = task.getResult();
                                    return !result.isNew() ? ParseUser.saveCurrentUserAsync((ParseUser) ParseObject.from(result)) : task.makeVoid();
                                }
                            });
                        }
                    });
                }
            });
            return onSuccessTask;
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(String str, Task<Void> task) {
        return saveAsync(str, isLazy(), task);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(String str, boolean z, Task<Void> task) {
        Task<Void> resolveLazinessAsync = z ? resolveLazinessAsync(task) : super.saveAsync(str, task);
        return isCurrentUser() ? resolveLazinessAsync.onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseUser.this.cleanUpAuthDataAsync();
            }
        }).onSuccessTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseUser.saveCurrentUserAsync(ParseUser.this);
            }
        }) : resolveLazinessAsync;
    }

    public void setEmail(String str) {
        put("email", str);
    }

    /* access modifiers changed from: package-private */
    public void setIsCurrentUser(boolean z) {
        synchronized (this.mutex) {
            this.isCurrentUser = z;
        }
    }

    public void setPassword(String str) {
        put(KEY_PASSWORD, str);
    }

    /* access modifiers changed from: package-private */
    public void setState(ParseObject.State state) {
        if (isCurrentUser()) {
            State.Builder builder = (State.Builder) state.newBuilder();
            if (getSessionToken() != null && state.get(KEY_SESSION_TOKEN) == null) {
                builder.put(KEY_SESSION_TOKEN, getSessionToken());
            }
            if (getAuthData().size() > 0 && state.get(KEY_AUTH_DATA) == null) {
                builder.put(KEY_AUTH_DATA, getAuthData());
            }
            state = builder.build();
        }
        super.setState(state);
    }

    public void setUsername(String str) {
        put(KEY_USERNAME, str);
    }

    public void signUp() {
        ParseTaskUtils.wait(signUpInBackground());
    }

    /* access modifiers changed from: package-private */
    public Task<Void> signUpAsync(Task<Void> task) {
        final String str;
        final ParseUser currentUser = getCurrentUser();
        synchronized (this.mutex) {
            if (currentUser != null) {
                try {
                    str = currentUser.getSessionToken();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                str = null;
            }
            if (ParseTextUtils.isEmpty(getUsername())) {
                Task<Void> forError = Task.forError(new IllegalArgumentException("Username cannot be missing or blank"));
                return forError;
            } else if (ParseTextUtils.isEmpty(getPassword())) {
                Task<Void> forError2 = Task.forError(new IllegalArgumentException("Password cannot be missing or blank"));
                return forError2;
            } else if (getObjectId() != null) {
                Map<String, Map<String, String>> authData = getAuthData();
                if (!authData.containsKey("anonymous") || authData.get("anonymous") != null) {
                    Task<Void> forError3 = Task.forError(new IllegalArgumentException("Cannot sign up a user that has already signed up."));
                    return forError3;
                }
                Task<Void> saveAsync = saveAsync(str, task);
                return saveAsync;
            } else if (this.operationSetQueue.size() > 1) {
                Task<Void> forError4 = Task.forError(new IllegalArgumentException("Cannot sign up a user that is already signing up."));
                return forError4;
            } else if (currentUser == null || !ParseAnonymousUtils.isLinked(currentUser)) {
                final ParseOperationSet startSave = startSave();
                Task<TContinuationResult> onSuccessTask = task.onSuccessTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        return ParseUser.getUserController().signUpAsync(ParseUser.this.getState(), startSave, str).continueWithTask(new Continuation<State, Task<Void>>() {
                            public Task<Void> then(final Task<State> task) {
                                return ParseUser.this.handleSaveResultAsync(task.getResult(), startSave).continueWithTask(new Continuation<Void, Task<Void>>() {
                                    public Task<Void> then(Task<Void> task) {
                                        return (task.isCancelled() || task.isFaulted()) ? task.makeVoid() : ParseUser.saveCurrentUserAsync(ParseUser.this);
                                    }
                                });
                            }
                        });
                    }
                });
                return onSuccessTask;
            } else if (this == currentUser) {
                Task<Void> forError5 = Task.forError(new IllegalArgumentException("Attempt to merge currentUser with itself."));
                return forError5;
            } else {
                boolean isLazy = currentUser.isLazy();
                final String username = currentUser.getUsername();
                final String password = currentUser.getPassword();
                final Map<String, String> authData2 = currentUser.getAuthData("anonymous");
                currentUser.copyChangesFrom(this);
                currentUser.setUsername(getUsername());
                currentUser.setPassword(getPassword());
                revert();
                Task<TContinuationResult> continueWithTask = currentUser.saveAsync(str, isLazy, task).continueWithTask(new Continuation<Void, Task<Void>>() {
                    public Task<Void> then(Task<Void> task) {
                        if (task.isCancelled() || task.isFaulted()) {
                            synchronized (currentUser.mutex) {
                                if (username != null) {
                                    currentUser.setUsername(username);
                                } else {
                                    currentUser.revert(ParseUser.KEY_USERNAME);
                                }
                                if (password != null) {
                                    currentUser.setPassword(password);
                                } else {
                                    currentUser.revert(ParseUser.KEY_PASSWORD);
                                }
                                currentUser.restoreAnonymity(authData2);
                            }
                            return task;
                        }
                        currentUser.revert(ParseUser.KEY_PASSWORD);
                        ParseUser.this.revert(ParseUser.KEY_PASSWORD);
                        ParseUser.this.mergeFromObject(currentUser);
                        return ParseUser.saveCurrentUserAsync(ParseUser.this);
                    }
                });
                return continueWithTask;
            }
        }
    }

    public Task<Void> signUpInBackground() {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseUser.this.signUpAsync(task);
            }
        });
    }

    public void signUpInBackground(SignUpCallback signUpCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(signUpInBackground(), (ParseCallback1<ParseException>) signUpCallback);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r0 = new java.util.ArrayList(r1.size());
        r1 = r1.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r1.hasNext() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r0.add(synchronizeAuthDataAsync(r1.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        return bolts.Task.whenAll(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bolts.Task<java.lang.Void> synchronizeAllAuthDataAsync() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mutex
            monitor-enter(r0)
            boolean r1 = r3.isCurrentUser()     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x0010
            r1 = 0
            bolts.Task r1 = bolts.Task.forResult(r1)     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return r1
        L_0x0010:
            java.util.Map r1 = r3.getAuthData()     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r1.size()
            r0.<init>(r2)
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0026:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x003a
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            bolts.Task r2 = r3.synchronizeAuthDataAsync(r2)
            r0.add(r2)
            goto L_0x0026
        L_0x003a:
            bolts.Task r0 = bolts.Task.whenAll(r0)
            return r0
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseUser.synchronizeAllAuthDataAsync():bolts.Task");
    }

    /* access modifiers changed from: package-private */
    public Task<Void> synchronizeAuthDataAsync(String str) {
        synchronized (this.mutex) {
            if (!isCurrentUser()) {
                Task<Void> forResult = Task.forResult(null);
                return forResult;
            }
            Map<String, String> authData = getAuthData(str);
            return synchronizeAuthDataAsync(getAuthenticationManager(), str, authData);
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject toRest(ParseObject.State state, List<ParseOperationSet> list, ParseEncoder parseEncoder) {
        List<ParseOperationSet> list2 = list;
        for (int i = 0; i < list.size(); i++) {
            ParseOperationSet parseOperationSet = list.get(i);
            if (parseOperationSet.containsKey(KEY_PASSWORD)) {
                if (list2 == list) {
                    list2 = new LinkedList<>(list);
                }
                ParseOperationSet parseOperationSet2 = new ParseOperationSet(parseOperationSet);
                parseOperationSet2.remove(KEY_PASSWORD);
                list2.set(i, parseOperationSet2);
            }
        }
        return super.toRest(state, list2, parseEncoder);
    }

    public Task<Void> unlinkFromInBackground(String str) {
        if (str == null) {
            return Task.forResult(null);
        }
        synchronized (this.mutex) {
            if (!getAuthData().containsKey(str)) {
                Task<Void> forResult = Task.forResult(null);
                return forResult;
            }
            putAuthData(str, (Map<String, String>) null);
            return saveInBackground();
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> upgradeToRevocableSessionAsync() {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseUser.this.upgradeToRevocableSessionAsync(task);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void validateDelete() {
        synchronized (this.mutex) {
            super.validateDelete();
            if (!isAuthenticated()) {
                if (isDirty()) {
                    throw new IllegalArgumentException("Cannot delete a ParseUser that is not authenticated.");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (com.parse.Parse.isLocalDatastoreEnabled() != false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        r0 = getCurrentUser();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        if (r0 == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (getObjectId().equals(r0.getObjectId()) == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        throw new java.lang.IllegalArgumentException("Cannot save a ParseUser that is not authenticated.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void validateSave() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mutex
            monitor-enter(r0)
            java.lang.String r1 = r3.getObjectId()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0042
            boolean r1 = r3.isAuthenticated()     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0040
            boolean r1 = r3.isDirty()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0040
            boolean r1 = r3.isCurrentUser()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x001c
            goto L_0x0040
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            boolean r0 = com.parse.Parse.isLocalDatastoreEnabled()
            if (r0 != 0) goto L_0x0038
            com.parse.ParseUser r0 = getCurrentUser()
            if (r0 == 0) goto L_0x0038
            java.lang.String r1 = r3.getObjectId()
            java.lang.String r0 = r0.getObjectId()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0038
            return
        L_0x0038:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot save a ParseUser that is not authenticated."
            r0.<init>(r1)
            throw r0
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return
        L_0x0042:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x004a }
            java.lang.String r2 = "Cannot save a ParseUser until it has been signed up. Call signUp first."
            r1.<init>(r2)     // Catch:{ all -> 0x004a }
            throw r1     // Catch:{ all -> 0x004a }
        L_0x004a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseUser.validateSave():void");
    }

    /* access modifiers changed from: package-private */
    public void validateSaveEventually() {
        if (isDirty(KEY_PASSWORD)) {
            throw new ParseException(-1, "Unable to saveEventually on a ParseUser with dirty password");
        }
    }
}
