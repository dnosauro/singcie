package com.parse;

import bolts.Task;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ParseAnonymousUtils {
    static final String AUTH_TYPE = "anonymous";

    private ParseAnonymousUtils() {
    }

    static Map<String, String> getAuthData() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", UUID.randomUUID().toString());
        return hashMap;
    }

    public static boolean isLinked(ParseUser parseUser) {
        return parseUser.isLinked(AUTH_TYPE);
    }

    public static void logIn(LogInCallback logInCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(), logInCallback);
    }

    public static Task<ParseUser> logInInBackground() {
        return ParseUser.logInWithInBackground(AUTH_TYPE, getAuthData());
    }
}
