package com.parse;

import android.content.Context;
import android.content.Intent;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.ConnectivityNotifier;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

class ParseCommandCache extends ParseEventuallyQueue {
    private static final String TAG = "com.parse.ParseCommandCache";
    private static int filenameCounter = 0;
    /* access modifiers changed from: private */
    public static final Object lock = new Object();
    private File cachePath;
    private final ParseHttpClient httpClient;
    ConnectivityNotifier.ConnectivityListener listener = new ConnectivityNotifier.ConnectivityListener() {
        public void networkConnectivityStatusChanged(Context context, Intent intent) {
            final boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            final boolean isConnected = ConnectivityNotifier.isConnected(context);
            Task.call(new Callable<Void>() {
                public Void call() {
                    boolean z;
                    ParseCommandCache parseCommandCache;
                    if (booleanExtra) {
                        parseCommandCache = ParseCommandCache.this;
                        z = false;
                    } else {
                        parseCommandCache = ParseCommandCache.this;
                        z = isConnected;
                    }
                    parseCommandCache.setConnected(z);
                    return null;
                }
            }, ParseExecutors.m8824io());
        }
    };
    private Logger log;
    private int maxCacheSizeBytes = 10485760;
    ConnectivityNotifier notifier;
    private HashMap<File, TaskCompletionSource<JSONObject>> pendingTasks = new HashMap<>();
    private boolean running;
    private final Object runningLock;
    private boolean shouldStop;
    private int timeoutMaxRetries = 5;
    private double timeoutRetryWaitSeconds = 600.0d;
    private boolean unprocessedCommandsExist;

    public ParseCommandCache(Context context, ParseHttpClient parseHttpClient) {
        setConnected(false);
        this.shouldStop = false;
        this.running = false;
        this.runningLock = new Object();
        this.httpClient = parseHttpClient;
        this.log = Logger.getLogger(TAG);
        this.cachePath = getCacheDir();
        if (Parse.hasPermission("android.permission.ACCESS_NETWORK_STATE")) {
            setConnected(ConnectivityNotifier.isConnected(context));
            this.notifier = ConnectivityNotifier.getNotifier(context);
            this.notifier.addListener(this.listener);
            resume();
        }
    }

    private Task<JSONObject> enqueueEventuallyAsync(ParseRESTCommand parseRESTCommand, boolean z, ParseObject parseObject) {
        Object obj;
        Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (parseObject != null) {
            try {
                if (parseObject.getObjectId() == null) {
                    parseRESTCommand.setLocalId(parseObject.getOrCreateLocalId());
                }
            } catch (UnsupportedEncodingException e) {
                if (5 >= Parse.getLogLevel()) {
                    this.log.log(Level.WARNING, "UTF-8 isn't supported.  This shouldn't happen.", e);
                }
            }
        }
        byte[] bytes = parseRESTCommand.toJSONObject().toString().getBytes("UTF-8");
        if (bytes.length > this.maxCacheSizeBytes) {
            if (5 >= Parse.getLogLevel()) {
                this.log.warning("Unable to save command for later because it's too big.");
            }
            notifyTestHelper(4);
            return Task.forResult(null);
        }
        synchronized (lock) {
            try {
                String[] list = this.cachePath.list();
                if (list != null) {
                    Arrays.sort(list);
                    int i = 0;
                    int i2 = 0;
                    for (String file : list) {
                        i2 += (int) new File(this.cachePath, file).length();
                    }
                    int length = i2 + bytes.length;
                    if (length > this.maxCacheSizeBytes) {
                        if (z) {
                            if (5 >= Parse.getLogLevel()) {
                                this.log.warning("Unable to save command for later because storage is full.");
                            }
                            Task<JSONObject> forResult = Task.forResult(null);
                            lock.notifyAll();
                            return forResult;
                        }
                        if (5 >= Parse.getLogLevel()) {
                            this.log.warning("Deleting old commands to make room in command cache.");
                        }
                        while (length > this.maxCacheSizeBytes && i < list.length) {
                            File file2 = new File(this.cachePath, list[i]);
                            length -= (int) file2.length();
                            removeFile(file2);
                            i++;
                        }
                    }
                }
                String hexString = Long.toHexString(System.currentTimeMillis());
                if (hexString.length() < 16) {
                    char[] cArr = new char[(16 - hexString.length())];
                    Arrays.fill(cArr, '0');
                    hexString = new String(cArr) + hexString;
                }
                int i3 = filenameCounter;
                filenameCounter = i3 + 1;
                String hexString2 = Integer.toHexString(i3);
                if (hexString2.length() < 8) {
                    char[] cArr2 = new char[(8 - hexString2.length())];
                    Arrays.fill(cArr2, '0');
                    hexString2 = new String(cArr2) + hexString2;
                }
                File createTempFile = File.createTempFile("CachedCommand_" + hexString + "_" + hexString2 + "_", "", this.cachePath);
                this.pendingTasks.put(createTempFile, taskCompletionSource);
                parseRESTCommand.retainLocalIds();
                ParseFileUtils.writeByteArrayToFile(createTempFile, bytes);
                notifyTestHelper(3);
                this.unprocessedCommandsExist = true;
                obj = lock;
            } catch (IOException e2) {
                try {
                    if (5 >= Parse.getLogLevel()) {
                        this.log.log(Level.WARNING, "Unable to save command for later.", e2);
                    }
                    obj = lock;
                } catch (Throwable th) {
                    lock.notifyAll();
                    throw th;
                }
            }
            obj.notifyAll();
            return taskCompletionSource.getTask();
        }
    }

    private static File getCacheDir() {
        File file = new File(Parse.getParseDir(), "CommandCache");
        file.mkdirs();
        return file;
    }

    public static int getPendingCount() {
        int length;
        synchronized (lock) {
            String[] list = getCacheDir().list();
            length = list == null ? 0 : list.length;
        }
        return length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x013a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013b, code lost:
        r17 = r5;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0142, code lost:
        if (6 >= com.parse.Parse.getLogLevel()) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0144, code lost:
        r1.log.log(java.util.logging.Level.SEVERE, "Unable to create ParseCommand from JSON.", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0195, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00df */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void maybeRunAllCommandsNow(int r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.lang.Object r3 = lock
            monitor-enter(r3)
            r4 = 0
            r1.unprocessedCommandsExist = r4     // Catch:{ all -> 0x0196 }
            boolean r0 = r18.isConnected()     // Catch:{ all -> 0x0196 }
            if (r0 != 0) goto L_0x0012
            monitor-exit(r3)     // Catch:{ all -> 0x0196 }
            return
        L_0x0012:
            java.io.File r0 = r1.cachePath     // Catch:{ all -> 0x0196 }
            java.lang.String[] r5 = r0.list()     // Catch:{ all -> 0x0196 }
            if (r5 == 0) goto L_0x0194
            int r0 = r5.length     // Catch:{ all -> 0x0196 }
            if (r0 != 0) goto L_0x001f
            goto L_0x0194
        L_0x001f:
            java.util.Arrays.sort(r5)     // Catch:{ all -> 0x0196 }
            int r6 = r5.length     // Catch:{ all -> 0x0196 }
            r7 = 0
        L_0x0024:
            if (r7 >= r6) goto L_0x0192
            r0 = r5[r7]     // Catch:{ all -> 0x0196 }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0196 }
            java.io.File r9 = r1.cachePath     // Catch:{ all -> 0x0196 }
            r8.<init>(r9, r0)     // Catch:{ all -> 0x0196 }
            r9 = 6
            org.json.JSONObject r0 = com.parse.ParseFileUtils.readFileToJSONObject(r8)     // Catch:{ FileNotFoundException -> 0x0179, IOException -> 0x0165, JSONException -> 0x0151 }
            java.util.HashMap<java.io.File, bolts.TaskCompletionSource<org.json.JSONObject>> r10 = r1.pendingTasks     // Catch:{ all -> 0x0196 }
            boolean r10 = r10.containsKey(r8)     // Catch:{ all -> 0x0196 }
            r11 = 0
            if (r10 == 0) goto L_0x0046
            java.util.HashMap<java.io.File, bolts.TaskCompletionSource<org.json.JSONObject>> r10 = r1.pendingTasks     // Catch:{ all -> 0x0196 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ all -> 0x0196 }
            bolts.TaskCompletionSource r10 = (bolts.TaskCompletionSource) r10     // Catch:{ all -> 0x0196 }
            goto L_0x0047
        L_0x0046:
            r10 = r11
        L_0x0047:
            com.parse.ParseRESTCommand r0 = r1.commandFromJSON(r0)     // Catch:{ JSONException -> 0x013a }
            r12 = 1
            if (r0 != 0) goto L_0x005d
            bolts.Task r0 = bolts.Task.forResult(r11)     // Catch:{ ParseException -> 0x0082 }
            if (r10 == 0) goto L_0x0057
            r10.setResult(r11)     // Catch:{ ParseException -> 0x0082 }
        L_0x0057:
            r11 = 8
            r1.notifyTestHelper(r11)     // Catch:{ ParseException -> 0x0082 }
            goto L_0x006c
        L_0x005d:
            com.parse.ParseHttpClient r11 = r1.httpClient     // Catch:{ ParseException -> 0x0082 }
            bolts.Task r11 = r0.executeAsync(r11)     // Catch:{ ParseException -> 0x0082 }
            com.parse.ParseCommandCache$4 r13 = new com.parse.ParseCommandCache$4     // Catch:{ ParseException -> 0x0082 }
            r13.<init>(r0, r10)     // Catch:{ ParseException -> 0x0082 }
            bolts.Task r0 = r11.continueWithTask(r13)     // Catch:{ ParseException -> 0x0082 }
        L_0x006c:
            r1.waitForTaskWithoutLock(r0)     // Catch:{ ParseException -> 0x0082 }
            if (r10 == 0) goto L_0x0078
            bolts.Task r0 = r10.getTask()     // Catch:{ ParseException -> 0x0082 }
            r1.waitForTaskWithoutLock(r0)     // Catch:{ ParseException -> 0x0082 }
        L_0x0078:
            r1.removeFile(r8)     // Catch:{ ParseException -> 0x0082 }
            r1.notifyTestHelper(r12)     // Catch:{ ParseException -> 0x0082 }
            r17 = r5
            goto L_0x018c
        L_0x0082:
            r0 = move-exception
            int r10 = r0.getCode()     // Catch:{ all -> 0x0196 }
            r11 = 100
            if (r10 != r11) goto L_0x0121
            if (r2 <= 0) goto L_0x0116
            int r0 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0196 }
            r8 = 4
            if (r8 < r0) goto L_0x00b9
            java.util.logging.Logger r0 = r1.log     // Catch:{ all -> 0x0196 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0196 }
            r9.<init>()     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = "Network timeout in command cache. Waiting for "
            r9.append(r10)     // Catch:{ all -> 0x0196 }
            double r10 = r1.timeoutRetryWaitSeconds     // Catch:{ all -> 0x0196 }
            r9.append(r10)     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = " seconds and then retrying "
            r9.append(r10)     // Catch:{ all -> 0x0196 }
            r9.append(r2)     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = " times."
            r9.append(r10)     // Catch:{ all -> 0x0196 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0196 }
            r0.info(r9)     // Catch:{ all -> 0x0196 }
        L_0x00b9:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0196 }
            double r13 = r1.timeoutRetryWaitSeconds     // Catch:{ all -> 0x0196 }
            r15 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r13 = r13 * r15
            long r13 = (long) r13     // Catch:{ all -> 0x0196 }
            long r13 = r13 + r9
        L_0x00c8:
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 >= 0) goto L_0x010c
            boolean r0 = r18.isConnected()     // Catch:{ all -> 0x0196 }
            if (r0 == 0) goto L_0x00fd
            boolean r0 = r1.shouldStop     // Catch:{ all -> 0x0196 }
            if (r0 == 0) goto L_0x00d7
            goto L_0x00fd
        L_0x00d7:
            java.lang.Object r0 = lock     // Catch:{ InterruptedException -> 0x00df }
            long r9 = r13 - r9
            r0.wait(r9)     // Catch:{ InterruptedException -> 0x00df }
            goto L_0x00e1
        L_0x00df:
            r1.shouldStop = r12     // Catch:{ all -> 0x0196 }
        L_0x00e1:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0196 }
            r17 = r5
            double r4 = r1.timeoutRetryWaitSeconds     // Catch:{ all -> 0x0196 }
            double r4 = r4 * r15
            long r4 = (long) r4     // Catch:{ all -> 0x0196 }
            long r4 = r13 - r4
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x00f9
            double r4 = r1.timeoutRetryWaitSeconds     // Catch:{ all -> 0x0196 }
            double r4 = r4 * r15
            long r4 = (long) r4     // Catch:{ all -> 0x0196 }
            long r9 = r13 - r4
        L_0x00f9:
            r5 = r17
            r4 = 0
            goto L_0x00c8
        L_0x00fd:
            int r0 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0196 }
            if (r8 < r0) goto L_0x010a
            java.util.logging.Logger r0 = r1.log     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "Aborting wait because runEventually thread should stop."
            r0.info(r2)     // Catch:{ all -> 0x0196 }
        L_0x010a:
            monitor-exit(r3)     // Catch:{ all -> 0x0196 }
            return
        L_0x010c:
            r17 = r5
            int r0 = r2 + -1
            r1.maybeRunAllCommandsNow(r0)     // Catch:{ all -> 0x0196 }
            r4 = 0
            goto L_0x018c
        L_0x0116:
            r17 = r5
            r1.setConnected(r4)     // Catch:{ all -> 0x0196 }
            r0 = 7
            r1.notifyTestHelper(r0)     // Catch:{ all -> 0x0196 }
            goto L_0x018c
        L_0x0121:
            r17 = r5
            int r5 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0196 }
            if (r9 < r5) goto L_0x0132
            java.util.logging.Logger r5 = r1.log     // Catch:{ all -> 0x0196 }
            java.util.logging.Level r9 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = "Failed to run command."
            r5.log(r9, r10, r0)     // Catch:{ all -> 0x0196 }
        L_0x0132:
            r1.removeFile(r8)     // Catch:{ all -> 0x0196 }
            r5 = 2
            r1.notifyTestHelper(r5, r0)     // Catch:{ all -> 0x0196 }
            goto L_0x018c
        L_0x013a:
            r0 = move-exception
            r17 = r5
            r5 = r0
            int r0 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0196 }
            if (r9 < r0) goto L_0x014d
            java.util.logging.Logger r0 = r1.log     // Catch:{ all -> 0x0196 }
            java.util.logging.Level r9 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = "Unable to create ParseCommand from JSON."
            r0.log(r9, r10, r5)     // Catch:{ all -> 0x0196 }
        L_0x014d:
            r1.removeFile(r8)     // Catch:{ all -> 0x0196 }
            goto L_0x018c
        L_0x0151:
            r0 = move-exception
            r17 = r5
            r5 = r0
            int r0 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0196 }
            if (r9 < r0) goto L_0x014d
            java.util.logging.Logger r0 = r1.log     // Catch:{ all -> 0x0196 }
            java.util.logging.Level r9 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = "Error parsing JSON found in cache."
            r0.log(r9, r10, r5)     // Catch:{ all -> 0x0196 }
            goto L_0x014d
        L_0x0165:
            r0 = move-exception
            r17 = r5
            r5 = r0
            int r0 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0196 }
            if (r9 < r0) goto L_0x014d
            java.util.logging.Logger r0 = r1.log     // Catch:{ all -> 0x0196 }
            java.util.logging.Level r9 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0196 }
            java.lang.String r10 = "Unable to read contents of file in cache."
            r0.log(r9, r10, r5)     // Catch:{ all -> 0x0196 }
            goto L_0x014d
        L_0x0179:
            r0 = move-exception
            r17 = r5
            r5 = r0
            int r0 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x0196 }
            if (r9 < r0) goto L_0x018c
            java.util.logging.Logger r0 = r1.log     // Catch:{ all -> 0x0196 }
            java.util.logging.Level r8 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0196 }
            java.lang.String r9 = "File disappeared from cache while being read."
            r0.log(r8, r9, r5)     // Catch:{ all -> 0x0196 }
        L_0x018c:
            int r7 = r7 + 1
            r5 = r17
            goto L_0x0024
        L_0x0192:
            monitor-exit(r3)     // Catch:{ all -> 0x0196 }
            return
        L_0x0194:
            monitor-exit(r3)     // Catch:{ all -> 0x0196 }
            return
        L_0x0196:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0196 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.maybeRunAllCommandsNow(int):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|4|5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeFile(java.io.File r3) {
        /*
            r2 = this;
            java.lang.Object r0 = lock
            monitor-enter(r0)
            java.util.HashMap<java.io.File, bolts.TaskCompletionSource<org.json.JSONObject>> r1 = r2.pendingTasks     // Catch:{ all -> 0x0018 }
            r1.remove(r3)     // Catch:{ all -> 0x0018 }
            org.json.JSONObject r1 = com.parse.ParseFileUtils.readFileToJSONObject(r3)     // Catch:{ Exception -> 0x0013 }
            com.parse.ParseRESTCommand r1 = r2.commandFromJSON(r1)     // Catch:{ Exception -> 0x0013 }
            r1.releaseLocalIds()     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            com.parse.ParseFileUtils.deleteQuietly(r3)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.removeFile(java.io.File):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:32|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r3 = lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r8.shouldStop != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        if (java.lang.Thread.interrupted() != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        if (r0 == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        r0 = lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        maybeRunAllCommandsNow(r8.timeoutMaxRetries);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003e, code lost:
        if (r8.shouldStop != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0042, code lost:
        if (r8.unprocessedCommandsExist != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        lock.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r8.shouldStop = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0055, code lost:
        if (6 >= com.parse.Parse.getLogLevel()) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0057, code lost:
        r8.log.log(java.util.logging.Level.SEVERE, "saveEventually thread had an error.", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0066, code lost:
        r2 = r8.shouldStop;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0068, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006c, code lost:
        r0 = r8.runningLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006e, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r8.running = false;
        r8.runningLock.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0076, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x007b, code lost:
        if (4 < com.parse.Parse.getLogLevel()) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x007d, code lost:
        r8.log.info("saveEventually thread has stopped processing commands.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runLoop() {
        /*
            r8 = this;
            int r0 = com.parse.Parse.getLogLevel()
            r1 = 4
            if (r1 < r0) goto L_0x000e
            java.util.logging.Logger r0 = r8.log
            java.lang.String r2 = "Parse command cache has started processing queued commands."
            r0.info(r2)
        L_0x000e:
            java.lang.Object r0 = r8.runningLock
            monitor-enter(r0)
            boolean r2 = r8.running     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x0017:
            r2 = 1
            r8.running = r2     // Catch:{ all -> 0x008b }
            java.lang.Object r3 = r8.runningLock     // Catch:{ all -> 0x008b }
            r3.notifyAll()     // Catch:{ all -> 0x008b }
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            java.lang.Object r3 = lock
            monitor-enter(r3)
            boolean r0 = r8.shouldStop     // Catch:{ all -> 0x0088 }
            r4 = 0
            if (r0 != 0) goto L_0x0030
            boolean r0 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            monitor-exit(r3)     // Catch:{ all -> 0x0088 }
        L_0x0032:
            if (r0 == 0) goto L_0x006c
            java.lang.Object r0 = lock
            monitor-enter(r0)
            int r3 = r8.timeoutMaxRetries     // Catch:{ Exception -> 0x004f }
            r8.maybeRunAllCommandsNow(r3)     // Catch:{ Exception -> 0x004f }
            boolean r3 = r8.shouldStop     // Catch:{ Exception -> 0x004f }
            if (r3 != 0) goto L_0x0060
            boolean r3 = r8.unprocessedCommandsExist     // Catch:{ InterruptedException -> 0x004a }
            if (r3 != 0) goto L_0x0060
            java.lang.Object r3 = lock     // Catch:{ InterruptedException -> 0x004a }
            r3.wait()     // Catch:{ InterruptedException -> 0x004a }
            goto L_0x0060
        L_0x004a:
            r8.shouldStop = r2     // Catch:{ Exception -> 0x004f }
            goto L_0x0060
        L_0x004d:
            r1 = move-exception
            goto L_0x0066
        L_0x004f:
            r3 = move-exception
            r5 = 6
            int r6 = com.parse.Parse.getLogLevel()     // Catch:{ all -> 0x004d }
            if (r5 < r6) goto L_0x0060
            java.util.logging.Logger r5 = r8.log     // Catch:{ all -> 0x004d }
            java.util.logging.Level r6 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x004d }
            java.lang.String r7 = "saveEventually thread had an error."
            r5.log(r6, r7, r3)     // Catch:{ all -> 0x004d }
        L_0x0060:
            boolean r3 = r8.shouldStop     // Catch:{ all -> 0x0069 }
            r3 = r3 ^ r2
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            r0 = r3
            goto L_0x0032
        L_0x0066:
            boolean r2 = r8.shouldStop     // Catch:{ all -> 0x0069 }
            throw r1     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r1
        L_0x006c:
            java.lang.Object r0 = r8.runningLock
            monitor-enter(r0)
            r8.running = r4     // Catch:{ all -> 0x0085 }
            java.lang.Object r2 = r8.runningLock     // Catch:{ all -> 0x0085 }
            r2.notifyAll()     // Catch:{ all -> 0x0085 }
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            int r0 = com.parse.Parse.getLogLevel()
            if (r1 < r0) goto L_0x0084
            java.util.logging.Logger r0 = r8.log
            java.lang.String r1 = "saveEventually thread has stopped processing commands."
            r0.info(r1)
        L_0x0084:
            return
        L_0x0085:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            throw r1
        L_0x0088:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0088 }
            throw r0
        L_0x008b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.runLoop():void");
    }

    private <T> T waitForTaskWithoutLock(Task<T> task) {
        T wait;
        synchronized (lock) {
            final Capture capture = new Capture(false);
            task.continueWith((Continuation<T, TContinuationResult>) new Continuation<T, Void>() {
                public Void then(Task<T> task) {
                    capture.set(true);
                    synchronized (ParseCommandCache.lock) {
                        ParseCommandCache.lock.notifyAll();
                    }
                    return null;
                }
            }, (Executor) Task.BACKGROUND_EXECUTOR);
            while (!((Boolean) capture.get()).booleanValue()) {
                try {
                    lock.wait();
                } catch (InterruptedException unused) {
                    this.shouldStop = true;
                }
            }
            wait = ParseTaskUtils.wait(task);
        }
        return wait;
    }

    public void clear() {
        synchronized (lock) {
            File[] listFiles = this.cachePath.listFiles();
            if (listFiles != null) {
                for (File removeFile : listFiles) {
                    removeFile(removeFile);
                }
                this.pendingTasks.clear();
            }
        }
    }

    public Task<JSONObject> enqueueEventuallyAsync(ParseRESTCommand parseRESTCommand, ParseObject parseObject) {
        return enqueueEventuallyAsync(parseRESTCommand, false, parseObject);
    }

    /* access modifiers changed from: package-private */
    public void fakeObjectUpdate() {
        notifyTestHelper(3);
        notifyTestHelper(1);
        notifyTestHelper(5);
    }

    public void onDestroy() {
        this.notifier.removeListener(this.listener);
    }

    public void pause() {
        synchronized (this.runningLock) {
            if (this.running) {
                synchronized (lock) {
                    this.shouldStop = true;
                    lock.notifyAll();
                }
            }
            while (this.running) {
                try {
                    this.runningLock.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public int pendingCount() {
        return getPendingCount();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void resume() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.runningLock
            monitor-enter(r0)
            boolean r1 = r3.running     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0027
            com.parse.ParseCommandCache$2 r1 = new com.parse.ParseCommandCache$2     // Catch:{ all -> 0x0029 }
            java.lang.String r2 = "ParseCommandCache.runLoop()"
            r1.<init>(r2)     // Catch:{ all -> 0x0029 }
            r1.start()     // Catch:{ all -> 0x0029 }
            java.lang.Object r1 = r3.runningLock     // Catch:{ InterruptedException -> 0x0017 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0017 }
            goto L_0x0027
        L_0x0017:
            java.lang.Object r1 = lock     // Catch:{ all -> 0x0029 }
            monitor-enter(r1)     // Catch:{ all -> 0x0029 }
            r2 = 1
            r3.shouldStop = r2     // Catch:{ all -> 0x0024 }
            java.lang.Object r2 = lock     // Catch:{ all -> 0x0024 }
            r2.notifyAll()     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0027
        L_0x0024:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            throw r2     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0029:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseCommandCache.resume():void");
    }

    public void setConnected(boolean z) {
        synchronized (lock) {
            if (isConnected() != z && z) {
                lock.notifyAll();
            }
            super.setConnected(z);
        }
    }

    public void setMaxCacheSizeBytes(int i) {
        synchronized (lock) {
            this.maxCacheSizeBytes = i;
        }
    }

    public void setTimeoutMaxRetries(int i) {
        synchronized (lock) {
            this.timeoutMaxRetries = i;
        }
    }

    public void setTimeoutRetryWaitSeconds(double d) {
        synchronized (lock) {
            this.timeoutRetryWaitSeconds = d;
        }
    }

    /* access modifiers changed from: package-private */
    public void simulateReboot() {
        synchronized (lock) {
            this.pendingTasks.clear();
        }
    }
}
