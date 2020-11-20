package com.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

class InstallationId {
    private static final String TAG = "InstallationId";
    private final File file;
    private String installationId;
    private final Object lock = new Object();

    public InstallationId(File file2) {
        this.file = file2;
    }

    private void setInternal(String str) {
        synchronized (this.lock) {
            try {
                ParseFileUtils.writeStringToFile(this.file, str, "UTF-8");
            } catch (IOException e) {
                PLog.m8817e(TAG, "Unexpected exception writing installation id to disk", e);
            }
            this.installationId = str;
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        synchronized (this.lock) {
            this.installationId = null;
            ParseFileUtils.deleteQuietly(this.file);
        }
    }

    public String get() {
        synchronized (this.lock) {
            if (this.installationId == null) {
                try {
                    this.installationId = ParseFileUtils.readFileToString(this.file, "UTF-8");
                } catch (FileNotFoundException unused) {
                    PLog.m8818i(TAG, "Couldn't find existing installationId file. Creating one instead.");
                } catch (IOException e) {
                    PLog.m8817e(TAG, "Unexpected exception reading installation id from disk", e);
                }
            }
            if (this.installationId == null) {
                setInternal(UUID.randomUUID().toString());
            }
        }
        return this.installationId;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void set(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            boolean r1 = com.parse.ParseTextUtils.isEmpty(r3)     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0019
            java.lang.String r1 = r2.get()     // Catch:{ all -> 0x001b }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0014
            goto L_0x0019
        L_0x0014:
            r2.setInternal(r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.InstallationId.set(java.lang.String):void");
    }
}
