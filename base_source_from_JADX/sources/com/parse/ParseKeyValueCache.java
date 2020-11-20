package com.parse;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import org.apache.commons.p172io.FilenameUtils;
import org.json.JSONException;
import org.json.JSONObject;

class ParseKeyValueCache {
    static final int DEFAULT_MAX_KEY_VALUE_CACHE_BYTES = 2097152;
    static final int DEFAULT_MAX_KEY_VALUE_CACHE_FILES = 1000;
    private static final String DIR_NAME = "ParseKeyValueCache";
    private static final Object MUTEX_IO = new Object();
    private static final String TAG = "ParseKeyValueCache";
    private static File directory;
    static int maxKeyValueCacheBytes = 2097152;
    static int maxKeyValueCacheFiles = 1000;

    ParseKeyValueCache() {
    }

    static void clearFromKeyValueCache(String str) {
        synchronized (MUTEX_IO) {
            File keyValueCacheFile = getKeyValueCacheFile(str);
            if (keyValueCacheFile != null) {
                keyValueCacheFile.delete();
            }
        }
    }

    static void clearKeyValueCacheDir() {
        synchronized (MUTEX_IO) {
            File keyValueCacheDir = getKeyValueCacheDir();
            if (keyValueCacheDir != null) {
                File[] listFiles = keyValueCacheDir.listFiles();
                if (listFiles != null) {
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                }
            }
        }
    }

    private static File createKeyValueCacheFile(String str) {
        return new File(getKeyValueCacheDir(), String.valueOf(new Date().getTime()) + FilenameUtils.EXTENSION_SEPARATOR + str);
    }

    private static long getKeyValueCacheAge(File file) {
        String name = file.getName();
        try {
            return Long.parseLong(name.substring(0, name.indexOf(46)));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private static File getKeyValueCacheDir() {
        File file = directory;
        if (file != null && !file.exists()) {
            directory.mkdir();
        }
        return directory;
    }

    private static File getKeyValueCacheFile(String str) {
        final String str2 = FilenameUtils.EXTENSION_SEPARATOR + str;
        File[] listFiles = getKeyValueCacheDir().listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(str2);
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        return listFiles[0];
    }

    static void initialize(Context context) {
        initialize(new File(context.getCacheDir(), "ParseKeyValueCache"));
    }

    static void initialize(File file) {
        if (file.isDirectory() || file.mkdir()) {
            directory = file;
            return;
        }
        throw new RuntimeException("Could not create ParseKeyValueCache directory");
    }

    static JSONObject jsonFromKeyValueCache(String str, long j) {
        String loadFromKeyValueCache = loadFromKeyValueCache(str, j);
        if (loadFromKeyValueCache == null) {
            return null;
        }
        try {
            return new JSONObject(loadFromKeyValueCache);
        } catch (JSONException e) {
            PLog.m8817e("ParseKeyValueCache", "corrupted cache for " + str, e);
            clearFromKeyValueCache(str);
            return null;
        }
    }

    static String loadFromKeyValueCache(String str, long j) {
        synchronized (MUTEX_IO) {
            File keyValueCacheFile = getKeyValueCacheFile(str);
            if (keyValueCacheFile == null) {
                return null;
            }
            Date date = new Date();
            if (getKeyValueCacheAge(keyValueCacheFile) < Math.max(0, date.getTime() - j)) {
                return null;
            }
            keyValueCacheFile.setLastModified(date.getTime());
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(keyValueCacheFile, "r");
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                String str2 = new String(bArr, "UTF-8");
                return str2;
            } catch (IOException e) {
                PLog.m8817e("ParseKeyValueCache", "error reading from cache", e);
                return null;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:2|3|(1:5)|6|7|8|9|10|11|(2:13|(1:15)(5:16|(1:18)|40|19|(2:25|(1:(2:27|(1:32)(2:41|31))(1:42)))(2:23|24)))) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0019 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void saveToKeyValueCache(java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.Object r0 = MUTEX_IO
            monitor-enter(r0)
            java.io.File r1 = getKeyValueCacheFile(r8)     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x000c
            r1.delete()     // Catch:{ all -> 0x006d }
        L_0x000c:
            java.io.File r8 = createKeyValueCacheFile(r8)     // Catch:{ all -> 0x006d }
            java.lang.String r1 = "UTF-8"
            byte[] r9 = r9.getBytes(r1)     // Catch:{ IOException -> 0x0019 }
            com.parse.ParseFileUtils.writeByteArrayToFile(r8, r9)     // Catch:{ IOException -> 0x0019 }
        L_0x0019:
            java.io.File r8 = getKeyValueCacheDir()     // Catch:{ all -> 0x006d }
            java.io.File[] r8 = r8.listFiles()     // Catch:{ all -> 0x006d }
            if (r8 == 0) goto L_0x006b
            int r9 = r8.length     // Catch:{ all -> 0x006d }
            if (r9 != 0) goto L_0x0027
            goto L_0x006b
        L_0x0027:
            int r9 = r8.length     // Catch:{ all -> 0x006d }
            int r1 = r8.length     // Catch:{ all -> 0x006d }
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x002c:
            if (r3 >= r1) goto L_0x003a
            r5 = r8[r3]     // Catch:{ all -> 0x006d }
            long r6 = (long) r4     // Catch:{ all -> 0x006d }
            long r4 = r5.length()     // Catch:{ all -> 0x006d }
            long r6 = r6 + r4
            int r4 = (int) r6     // Catch:{ all -> 0x006d }
            int r3 = r3 + 1
            goto L_0x002c
        L_0x003a:
            int r1 = maxKeyValueCacheFiles     // Catch:{ all -> 0x006d }
            if (r9 > r1) goto L_0x0044
            int r1 = maxKeyValueCacheBytes     // Catch:{ all -> 0x006d }
            if (r4 > r1) goto L_0x0044
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return
        L_0x0044:
            com.parse.ParseKeyValueCache$2 r1 = new com.parse.ParseKeyValueCache$2     // Catch:{ all -> 0x006d }
            r1.<init>()     // Catch:{ all -> 0x006d }
            java.util.Arrays.sort(r8, r1)     // Catch:{ all -> 0x006d }
            int r1 = r8.length     // Catch:{ all -> 0x006d }
        L_0x004d:
            if (r2 >= r1) goto L_0x0069
            r3 = r8[r2]     // Catch:{ all -> 0x006d }
            int r9 = r9 + -1
            long r4 = (long) r4     // Catch:{ all -> 0x006d }
            long r6 = r3.length()     // Catch:{ all -> 0x006d }
            long r4 = r4 - r6
            int r4 = (int) r4     // Catch:{ all -> 0x006d }
            r3.delete()     // Catch:{ all -> 0x006d }
            int r3 = maxKeyValueCacheFiles     // Catch:{ all -> 0x006d }
            if (r9 > r3) goto L_0x0066
            int r3 = maxKeyValueCacheBytes     // Catch:{ all -> 0x006d }
            if (r4 > r3) goto L_0x0066
            goto L_0x0069
        L_0x0066:
            int r2 = r2 + 1
            goto L_0x004d
        L_0x0069:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return
        L_0x006d:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseKeyValueCache.saveToKeyValueCache(java.lang.String, java.lang.String):void");
    }

    static int size() {
        File[] listFiles = getKeyValueCacheDir().listFiles();
        if (listFiles == null) {
            return 0;
        }
        return listFiles.length;
    }
}
