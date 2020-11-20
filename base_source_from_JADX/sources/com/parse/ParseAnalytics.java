package com.parse;

import android.content.Intent;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseAnalytics {
    private static final String TAG = "com.parse.ParseAnalytics";
    private static final Map<String, Boolean> lruSeenPushes = new LinkedHashMap<String, Boolean>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<String, Boolean> entry) {
            return size() > 10;
        }
    };

    static void clear() {
        synchronized (lruSeenPushes) {
            lruSeenPushes.clear();
        }
    }

    static ParseAnalyticsController getAnalyticsController() {
        return ParseCorePlugins.getInstance().getAnalyticsController();
    }

    static String getPushHashFromIntent(Intent intent) {
        String string = (intent == null || intent.getExtras() == null) ? null : intent.getExtras().getString(ParsePushBroadcastReceiver.KEY_PUSH_DATA);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string).optString("push_hash");
        } catch (JSONException e) {
            PLog.m8816e(TAG, "Failed to parse push data: " + e.getMessage());
            return null;
        }
    }

    public static Task<Void> trackAppOpenedInBackground(Intent intent) {
        String pushHashFromIntent = getPushHashFromIntent(intent);
        final Capture capture = new Capture();
        if (pushHashFromIntent != null && pushHashFromIntent.length() > 0) {
            synchronized (lruSeenPushes) {
                if (lruSeenPushes.containsKey(pushHashFromIntent)) {
                    Task<Void> forResult = Task.forResult(null);
                    return forResult;
                }
                lruSeenPushes.put(pushHashFromIntent, true);
                capture.set(pushHashFromIntent);
            }
        }
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                return ParseAnalytics.getAnalyticsController().trackAppOpenedInBackground((String) capture.get(), task.getResult());
            }
        });
    }

    public static void trackAppOpenedInBackground(Intent intent, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(trackAppOpenedInBackground(intent), (ParseCallback1<ParseException>) saveCallback);
    }

    public static Task<Void> trackEventInBackground(String str) {
        return trackEventInBackground(str, (Map<String, String>) null);
    }

    public static Task<Void> trackEventInBackground(final String str, Map<String, String> map) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("A name for the custom event must be provided.");
        }
        final Map unmodifiableMap = map != null ? Collections.unmodifiableMap(new HashMap(map)) : null;
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                return ParseAnalytics.getAnalyticsController().trackEventInBackground(str, unmodifiableMap, task.getResult());
            }
        });
    }

    public static void trackEventInBackground(String str, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(trackEventInBackground(str), (ParseCallback1<ParseException>) saveCallback);
    }

    public static void trackEventInBackground(String str, Map<String, String> map, SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(trackEventInBackground(str, map), (ParseCallback1<ParseException>) saveCallback);
    }
}
