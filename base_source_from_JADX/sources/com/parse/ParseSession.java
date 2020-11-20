package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ParseClassName("_Session")
public class ParseSession extends ParseObject {
    private static final String KEY_CREATED_WITH = "createdWith";
    private static final String KEY_EXPIRES_AT = "expiresAt";
    private static final String KEY_INSTALLATION_ID = "installationId";
    private static final String KEY_RESTRICTED = "restricted";
    private static final String KEY_SESSION_TOKEN = "sessionToken";
    private static final String KEY_USER = "user";
    private static final List<String> READ_ONLY_KEYS = Collections.unmodifiableList(Arrays.asList(new String[]{KEY_SESSION_TOKEN, KEY_CREATED_WITH, KEY_RESTRICTED, KEY_USER, KEY_EXPIRES_AT, KEY_INSTALLATION_ID}));

    public static Task<ParseSession> getCurrentSessionInBackground() {
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<ParseSession>>() {
            public Task<ParseSession> then(Task<String> task) {
                String result = task.getResult();
                return result == null ? Task.forResult(null) : ParseSession.getSessionController().getSessionAsync(result).onSuccess(new Continuation<ParseObject.State, ParseSession>() {
                    public ParseSession then(Task<ParseObject.State> task) {
                        return (ParseSession) ParseObject.from(task.getResult());
                    }
                });
            }
        });
    }

    public static void getCurrentSessionInBackground(GetCallback<ParseSession> getCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getCurrentSessionInBackground(), getCallback);
    }

    public static ParseQuery<ParseSession> getQuery() {
        return ParseQuery.getQuery(ParseSession.class);
    }

    /* access modifiers changed from: private */
    public static ParseSessionController getSessionController() {
        return ParseCorePlugins.getInstance().getSessionController();
    }

    static boolean isRevocableSessionToken(String str) {
        return str.contains("r:");
    }

    static Task<Void> revokeAsync(String str) {
        return (str == null || !isRevocableSessionToken(str)) ? Task.forResult(null) : getSessionController().revokeAsync(str);
    }

    static Task<String> upgradeToRevocableSessionAsync(String str) {
        return (str == null || isRevocableSessionToken(str)) ? Task.forResult(str) : getSessionController().upgradeToRevocable(str).onSuccess(new Continuation<ParseObject.State, String>() {
            public String then(Task<ParseObject.State> task) {
                return ((ParseSession) ParseObject.from(task.getResult())).getSessionToken();
            }
        });
    }

    public String getSessionToken() {
        return getString(KEY_SESSION_TOKEN);
    }

    /* access modifiers changed from: package-private */
    public boolean isKeyMutable(String str) {
        return !READ_ONLY_KEYS.contains(str);
    }

    /* access modifiers changed from: package-private */
    public boolean needsDefaultACL() {
        return false;
    }
}
