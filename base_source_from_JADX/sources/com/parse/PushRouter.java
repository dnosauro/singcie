package com.parse;

import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PushRouter {
    private static final String LEGACY_STATE_LOCATION = "pushState";
    private static final int MAX_HISTORY_LENGTH = 10;
    private static final String STATE_LOCATION = "push";
    private static final String TAG = "com.parse.ParsePushRouter";
    private static PushRouter instance;
    private final File diskState;
    private final PushHistory history;

    private PushRouter(File file, PushHistory pushHistory) {
        this.diskState = file;
        this.history = pushHistory;
    }

    public static synchronized PushRouter getInstance() {
        PushRouter pushRouter;
        synchronized (PushRouter.class) {
            if (instance == null) {
                instance = pushRouterFromState(new File(ParsePlugins.get().getFilesDir(), STATE_LOCATION), new File(ParsePlugins.get().getParseDir(), LEGACY_STATE_LOCATION), 10);
            }
            pushRouter = instance;
        }
        return pushRouter;
    }

    static PushRouter pushRouterFromState(File file, File file2, int i) {
        JSONObject readJSONFileQuietly;
        JSONObject readJSONFileQuietly2 = readJSONFileQuietly(file);
        PushHistory pushHistory = new PushHistory(i, readJSONFileQuietly2 != null ? readJSONFileQuietly2.optJSONObject("history") : null);
        boolean z = false;
        if (pushHistory.getLastReceivedTimestamp() == null && (readJSONFileQuietly = readJSONFileQuietly(file2)) != null) {
            String optString = readJSONFileQuietly.optString("lastTime", (String) null);
            if (optString != null) {
                pushHistory.setLastReceivedTimestamp(optString);
            }
            z = true;
        }
        PushRouter pushRouter = new PushRouter(file, pushHistory);
        if (z) {
            pushRouter.saveStateToDisk();
            ParseFileUtils.deleteQuietly(file2);
        }
        return pushRouter;
    }

    private static JSONObject readJSONFileQuietly(File file) {
        if (file != null) {
            try {
                return ParseFileUtils.readFileToJSONObject(file);
            } catch (IOException | JSONException unused) {
            }
        }
        return null;
    }

    static synchronized void resetInstance() {
        synchronized (PushRouter.class) {
            ParseFileUtils.deleteQuietly(new File(ParsePlugins.get().getFilesDir(), STATE_LOCATION));
            instance = null;
        }
    }

    private synchronized void saveStateToDisk() {
        try {
            ParseFileUtils.writeJSONObjectToFile(this.diskState, toJSON());
        } catch (IOException | JSONException e) {
            PLog.m8817e(TAG, "Unexpected error when serializing push state to " + this.diskState, e);
        }
        return;
    }

    public synchronized String getLastReceivedTimestamp() {
        return this.history.getLastReceivedTimestamp();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean handlePush(java.lang.String r3, java.lang.String r4, java.lang.String r5, org.json.JSONObject r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = com.parse.ParseTextUtils.isEmpty(r3)     // Catch:{ all -> 0x0054 }
            r1 = 0
            if (r0 != 0) goto L_0x0052
            boolean r0 = com.parse.ParseTextUtils.isEmpty(r4)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x000f
            goto L_0x0052
        L_0x000f:
            com.parse.PushHistory r0 = r2.history     // Catch:{ all -> 0x0054 }
            boolean r3 = r0.tryInsertPush(r3, r4)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0019
            monitor-exit(r2)
            return r1
        L_0x0019:
            r2.saveStateToDisk()     // Catch:{ all -> 0x0054 }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0054 }
            r3.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = "com.parse.Channel"
            r3.putString(r4, r5)     // Catch:{ all -> 0x0054 }
            if (r6 != 0) goto L_0x0030
            java.lang.String r4 = "com.parse.Data"
            java.lang.String r5 = "{}"
        L_0x002c:
            r3.putString(r4, r5)     // Catch:{ all -> 0x0054 }
            goto L_0x0037
        L_0x0030:
            java.lang.String r4 = "com.parse.Data"
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0054 }
            goto L_0x002c
        L_0x0037:
            android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "com.parse.push.intent.RECEIVE"
            r4.<init>(r5)     // Catch:{ all -> 0x0054 }
            r4.putExtras(r3)     // Catch:{ all -> 0x0054 }
            android.content.Context r3 = com.parse.Parse.getApplicationContext()     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = r3.getPackageName()     // Catch:{ all -> 0x0054 }
            r4.setPackage(r5)     // Catch:{ all -> 0x0054 }
            r3.sendBroadcast(r4)     // Catch:{ all -> 0x0054 }
            r3 = 1
            monitor-exit(r2)
            return r3
        L_0x0052:
            monitor-exit(r2)
            return r1
        L_0x0054:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.PushRouter.handlePush(java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject):boolean");
    }

    /* access modifiers changed from: package-private */
    public synchronized JSONObject toJSON() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("history", this.history.toJSON());
        return jSONObject;
    }
}
