package com.parse;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

class LocalIdManager {
    private final File diskPath;
    private final Random random = new Random();

    private static class MapEntry {
        String objectId;
        int retainCount;

        private MapEntry() {
        }
    }

    LocalIdManager(File file) {
        this.diskPath = new File(file, "LocalId");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        return new com.parse.LocalIdManager.MapEntry((com.parse.LocalIdManager.C26421) null);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.parse.LocalIdManager.MapEntry getMapEntry(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.isLocalId(r5)     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0032
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException | JSONException -> 0x002b }
            java.io.File r2 = r4.diskPath     // Catch:{ IOException | JSONException -> 0x002b }
            r1.<init>(r2, r5)     // Catch:{ IOException | JSONException -> 0x002b }
            org.json.JSONObject r5 = com.parse.ParseFileUtils.readFileToJSONObject(r1)     // Catch:{ IOException | JSONException -> 0x002b }
            com.parse.LocalIdManager$MapEntry r1 = new com.parse.LocalIdManager$MapEntry     // Catch:{ IOException | JSONException -> 0x002b }
            r1.<init>()     // Catch:{ IOException | JSONException -> 0x002b }
            java.lang.String r2 = "retainCount"
            r3 = 0
            int r2 = r5.optInt(r2, r3)     // Catch:{ IOException | JSONException -> 0x002b }
            r1.retainCount = r2     // Catch:{ IOException | JSONException -> 0x002b }
            java.lang.String r2 = "objectId"
            java.lang.String r5 = r5.optString(r2, r0)     // Catch:{ IOException | JSONException -> 0x002b }
            r1.objectId = r5     // Catch:{ IOException | JSONException -> 0x002b }
            monitor-exit(r4)
            return r1
        L_0x002b:
            com.parse.LocalIdManager$MapEntry r5 = new com.parse.LocalIdManager$MapEntry     // Catch:{ all -> 0x004e }
            r5.<init>()     // Catch:{ all -> 0x004e }
            monitor-exit(r4)
            return r5
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r1.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "Tried to get invalid local id: \""
            r1.append(r2)     // Catch:{ all -> 0x004e }
            r1.append(r5)     // Catch:{ all -> 0x004e }
            java.lang.String r5 = "\"."
            r1.append(r5)     // Catch:{ all -> 0x004e }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x004e }
            r0.<init>(r5)     // Catch:{ all -> 0x004e }
            throw r0     // Catch:{ all -> 0x004e }
        L_0x004e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.LocalIdManager.getMapEntry(java.lang.String):com.parse.LocalIdManager$MapEntry");
    }

    private boolean isLocalId(String str) {
        if (!str.startsWith("local_")) {
            return false;
        }
        for (int i = 6; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && (charAt < 'a' || charAt > 'f')) {
                return false;
            }
        }
        return true;
    }

    private synchronized void putMapEntry(String str, MapEntry mapEntry) {
        if (isLocalId(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retainCount", mapEntry.retainCount);
                if (mapEntry.objectId != null) {
                    jSONObject.put(ParseObject.KEY_OBJECT_ID, mapEntry.objectId);
                }
                File file = new File(this.diskPath, str);
                if (!this.diskPath.exists()) {
                    this.diskPath.mkdirs();
                }
                try {
                    ParseFileUtils.writeJSONObjectToFile(file, jSONObject);
                } catch (IOException unused) {
                }
            } catch (JSONException e) {
                throw new IllegalStateException("Error creating local id map entry.", e);
            }
        } else {
            throw new IllegalStateException("Tried to get invalid local id: \"" + str + "\".");
        }
    }

    private synchronized void removeMapEntry(String str) {
        if (isLocalId(str)) {
            ParseFileUtils.deleteQuietly(new File(this.diskPath, str));
        } else {
            throw new IllegalStateException("Tried to get invalid local id: \"" + str + "\".");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean clear() {
        String[] list = this.diskPath.list();
        int i = 0;
        if (list == null) {
            return false;
        }
        if (list.length == 0) {
            return false;
        }
        int length = list.length;
        while (i < length) {
            String str = list[i];
            if (new File(this.diskPath, str).delete()) {
                i++;
            } else {
                throw new IOException("Unable to delete file " + str + " in localId cache.");
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized String createLocalId() {
        String str;
        long nextLong = this.random.nextLong();
        str = "local_" + Long.toHexString(nextLong);
        if (!isLocalId(str)) {
            throw new IllegalStateException("Generated an invalid local id: \"" + str + "\". This should never happen. Open a bug at https://github.com/parse-community/parse-server");
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public synchronized String getObjectId(String str) {
        return getMapEntry(str).objectId;
    }

    /* access modifiers changed from: package-private */
    public synchronized void releaseLocalIdOnDisk(String str) {
        MapEntry mapEntry = getMapEntry(str);
        mapEntry.retainCount--;
        if (mapEntry.retainCount > 0) {
            putMapEntry(str, mapEntry);
        } else {
            removeMapEntry(str);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void retainLocalIdOnDisk(String str) {
        MapEntry mapEntry = getMapEntry(str);
        mapEntry.retainCount++;
        putMapEntry(str, mapEntry);
    }

    /* access modifiers changed from: package-private */
    public synchronized void setObjectId(String str, String str2) {
        MapEntry mapEntry = getMapEntry(str);
        if (mapEntry.retainCount > 0) {
            if (mapEntry.objectId == null) {
                mapEntry.objectId = str2;
                putMapEntry(str, mapEntry);
            } else {
                throw new IllegalStateException("Tried to set an objectId for a localId that already has one.");
            }
        }
    }
}
