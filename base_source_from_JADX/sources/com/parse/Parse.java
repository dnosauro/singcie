package com.parse;

import android.content.Context;
import android.content.pm.ResolveInfo;
import bolts.Continuation;
import bolts.Task;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import okhttp3.OkHttpClient;

public class Parse {
    private static final int DEFAULT_MAX_RETRIES = 4;
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_NONE = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARNING = 5;
    private static final Object MUTEX = new Object();
    private static final Object MUTEX_CALLBACKS = new Object();
    private static final String TAG = "com.parse.Parse";
    private static Set<ParseCallbacks> callbacks = new HashSet();
    static ParseEventuallyQueue eventuallyQueue = null;
    private static boolean isLocalDatastoreEnabled;
    private static OfflineStore offlineStore;

    public static final class Configuration {
        final String applicationId;
        final OkHttpClient.Builder clientBuilder;
        final String clientKey;
        final Context context;
        final boolean localDataStoreEnabled;
        final int maxRetries;
        final String server;

        public static final class Builder {
            /* access modifiers changed from: private */
            public String applicationId;
            /* access modifiers changed from: private */
            public OkHttpClient.Builder clientBuilder;
            /* access modifiers changed from: private */
            public String clientKey;
            /* access modifiers changed from: private */
            public Context context;
            /* access modifiers changed from: private */
            public boolean localDataStoreEnabled;
            /* access modifiers changed from: private */
            public int maxRetries = 4;
            /* access modifiers changed from: private */
            public String server;

            public Builder(Context context2) {
                this.context = context2;
            }

            private Builder setLocalDatastoreEnabled(boolean z) {
                this.localDataStoreEnabled = z;
                return this;
            }

            public Builder applicationId(String str) {
                this.applicationId = str;
                return this;
            }

            public Configuration build() {
                return new Configuration(this);
            }

            public Builder clientBuilder(OkHttpClient.Builder builder) {
                this.clientBuilder = builder;
                return this;
            }

            public Builder clientKey(String str) {
                this.clientKey = str;
                return this;
            }

            public Builder enableLocalDataStore() {
                this.localDataStoreEnabled = true;
                return this;
            }

            public Builder maxRetries(int i) {
                this.maxRetries = i;
                return this;
            }

            public Builder server(String str) {
                this.server = Parse.validateServerUrl(str);
                return this;
            }
        }

        private Configuration(Builder builder) {
            this.context = builder.context;
            this.applicationId = builder.applicationId;
            this.clientKey = builder.clientKey;
            this.server = builder.server;
            this.localDataStoreEnabled = builder.localDataStoreEnabled;
            this.clientBuilder = builder.clientBuilder;
            this.maxRetries = builder.maxRetries;
        }
    }

    interface ParseCallbacks {
        void onParseInitialized();
    }

    private Parse() {
        throw new AssertionError();
    }

    private static boolean allParsePushIntentReceiversInternal() {
        for (ResolveInfo resolveInfo : ManifestInfo.getIntentReceivers(ParsePushBroadcastReceiver.ACTION_PUSH_RECEIVE, ParsePushBroadcastReceiver.ACTION_PUSH_DELETE, ParsePushBroadcastReceiver.ACTION_PUSH_OPEN)) {
            if (resolveInfo.activityInfo.exported) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0043 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void checkCacheApplicationId() {
        /*
            java.lang.Object r0 = MUTEX
            monitor-enter(r0)
            com.parse.ParsePlugins r1 = com.parse.ParsePlugins.get()     // Catch:{ all -> 0x005d }
            java.lang.String r1 = r1.applicationId()     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x005b
            java.io.File r2 = getParseCacheDir()     // Catch:{ all -> 0x005d }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "applicationId"
            r3.<init>(r2, r4)     // Catch:{ all -> 0x005d }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x0043
            r4 = 0
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x003e }
            java.lang.String r6 = "r"
            r5.<init>(r3, r6)     // Catch:{ IOException -> 0x003e }
            long r6 = r5.length()     // Catch:{ IOException -> 0x003e }
            int r3 = (int) r6     // Catch:{ IOException -> 0x003e }
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x003e }
            r5.readFully(r3)     // Catch:{ IOException -> 0x003e }
            r5.close()     // Catch:{ IOException -> 0x003e }
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x003e }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r3, r6)     // Catch:{ IOException -> 0x003e }
            boolean r4 = r5.equals(r1)     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            if (r4 != 0) goto L_0x0043
            com.parse.ParseFileUtils.deleteDirectory(r2)     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "applicationId"
            r3.<init>(r2, r4)     // Catch:{ all -> 0x005d }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x005b }
            r2.<init>(r3)     // Catch:{ IOException -> 0x005b }
            java.lang.String r3 = "UTF-8"
            byte[] r1 = r1.getBytes(r3)     // Catch:{ IOException -> 0x005b }
            r2.write(r1)     // Catch:{ IOException -> 0x005b }
            r2.close()     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x005d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.Parse.checkCacheApplicationId():void");
    }

    static void checkContext() {
        if (ParsePlugins.get().applicationContext() == null) {
            throw new RuntimeException("applicationContext is null. You must call Parse.initialize(Context) before using the Parse library.");
        }
    }

    public static void checkInit() {
        if (ParsePlugins.get() == null) {
            throw new RuntimeException("You must call Parse.initialize(Context) before using the Parse library.");
        } else if (ParsePlugins.get().applicationId() == null) {
            throw new RuntimeException("applicationId is null. You must call Parse.initialize(Context) before using the Parse library.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.parse.Parse.ParseCallbacks[] collectParseCallbacks() {
        /*
            java.lang.Object r0 = MUTEX_CALLBACKS
            monitor-enter(r0)
            java.util.Set<com.parse.Parse$ParseCallbacks> r1 = callbacks     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x000a
            r1 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r1
        L_0x000a:
            java.util.Set<com.parse.Parse$ParseCallbacks> r1 = callbacks     // Catch:{ all -> 0x0024 }
            int r1 = r1.size()     // Catch:{ all -> 0x0024 }
            com.parse.Parse$ParseCallbacks[] r1 = new com.parse.Parse.ParseCallbacks[r1]     // Catch:{ all -> 0x0024 }
            java.util.Set<com.parse.Parse$ParseCallbacks> r2 = callbacks     // Catch:{ all -> 0x0024 }
            int r2 = r2.size()     // Catch:{ all -> 0x0024 }
            if (r2 <= 0) goto L_0x0022
            java.util.Set<com.parse.Parse$ParseCallbacks> r2 = callbacks     // Catch:{ all -> 0x0024 }
            java.lang.Object[] r1 = r2.toArray(r1)     // Catch:{ all -> 0x0024 }
            com.parse.Parse$ParseCallbacks[] r1 = (com.parse.Parse.ParseCallbacks[]) r1     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r1
        L_0x0024:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.Parse.collectParseCallbacks():com.parse.Parse$ParseCallbacks[]");
    }

    public static void destroy() {
        ParseEventuallyQueue parseEventuallyQueue;
        ParseObject.unregisterParseSubclasses();
        synchronized (MUTEX) {
            parseEventuallyQueue = eventuallyQueue;
            eventuallyQueue = null;
        }
        if (parseEventuallyQueue != null) {
            parseEventuallyQueue.onDestroy();
        }
        ParseCorePlugins.getInstance().reset();
        ParsePlugins.reset();
        setLocalDatastore((OfflineStore) null);
    }

    static void disableLocalDatastore() {
        setLocalDatastore((OfflineStore) null);
        ParseCorePlugins.getInstance().reset();
    }

    private static void dispatchOnParseInitialized() {
        ParseCallbacks[] collectParseCallbacks = collectParseCallbacks();
        if (collectParseCallbacks != null) {
            for (ParseCallbacks onParseInitialized : collectParseCallbacks) {
                onParseInitialized.onParseInitialized();
            }
        }
    }

    public static void enableLocalDatastore(Context context) {
        if (!isInitialized()) {
            isLocalDatastoreEnabled = true;
            return;
        }
        throw new IllegalStateException("`Parse#enableLocalDatastore(Context)` must be invoked before `Parse#initialize(Context)`");
    }

    public static Context getApplicationContext() {
        checkContext();
        return ParsePlugins.get().applicationContext();
    }

    static ParseEventuallyQueue getEventuallyQueue() {
        return getEventuallyQueue(ParsePlugins.get().applicationContext());
    }

    /* access modifiers changed from: private */
    public static ParseEventuallyQueue getEventuallyQueue(Context context) {
        ParseEventuallyQueue parseEventuallyQueue;
        synchronized (MUTEX) {
            boolean isLocalDatastoreEnabled2 = isLocalDatastoreEnabled();
            if (eventuallyQueue == null || ((isLocalDatastoreEnabled2 && (eventuallyQueue instanceof ParseCommandCache)) || (!isLocalDatastoreEnabled2 && (eventuallyQueue instanceof ParsePinningEventuallyQueue)))) {
                checkContext();
                ParseHttpClient restClient = ParsePlugins.get().restClient();
                eventuallyQueue = isLocalDatastoreEnabled2 ? new ParsePinningEventuallyQueue(context, restClient) : new ParseCommandCache(context, restClient);
                if (isLocalDatastoreEnabled2 && ParseCommandCache.getPendingCount() > 0) {
                    new ParseCommandCache(context, restClient);
                }
            }
            parseEventuallyQueue = eventuallyQueue;
        }
        return parseEventuallyQueue;
    }

    static OfflineStore getLocalDatastore() {
        return offlineStore;
    }

    public static int getLogLevel() {
        return PLog.getLogLevel();
    }

    static File getParseCacheDir() {
        return ParsePlugins.get().getCacheDir();
    }

    public static File getParseCacheDir(String str) {
        File file;
        synchronized (MUTEX) {
            file = new File(getParseCacheDir(), str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    @Deprecated
    static File getParseDir() {
        return ParsePlugins.get().getParseDir();
    }

    static File getParseFilesDir() {
        return ParsePlugins.get().getFilesDir();
    }

    static File getParseFilesDir(String str) {
        File file;
        synchronized (MUTEX) {
            file = new File(getParseFilesDir(), str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    public static String getServer() {
        URL url = ParseRESTCommand.server;
        if (url == null) {
            return null;
        }
        return url.toString();
    }

    static boolean hasPermission(String str) {
        return getApplicationContext().checkCallingOrSelfPermission(str) == 0;
    }

    public static void initialize(Configuration configuration) {
        initialize(configuration, (ParsePlugins) null);
    }

    static void initialize(Configuration configuration, ParsePlugins parsePlugins) {
        if (isInitialized()) {
            PLog.m8822w(TAG, "Parse is already initialized");
            return;
        }
        isLocalDatastoreEnabled = configuration.localDataStoreEnabled;
        if (parsePlugins == null) {
            ParsePlugins.initialize(configuration.context, configuration);
        } else {
            ParsePlugins.set(parsePlugins);
        }
        try {
            ParseRESTCommand.server = new URL(configuration.server);
            ParseObject.registerParseSubclasses();
            if (configuration.localDataStoreEnabled) {
                offlineStore = new OfflineStore(configuration.context);
            } else {
                ParseKeyValueCache.initialize(configuration.context);
            }
            checkCacheApplicationId();
            final Context context = configuration.context;
            Task.callInBackground(new Callable<Void>() {
                public Void call() {
                    ParseEventuallyQueue unused = Parse.getEventuallyQueue(context);
                    return null;
                }
            });
            ParseFieldOperations.registerDefaultDecoders();
            if (allParsePushIntentReceiversInternal()) {
                ParseUser.getCurrentUserAsync().makeVoid().continueWith(new Continuation<Void, Void>() {
                    public Void then(Task<Void> task) {
                        ParseConfig.getCurrentConfig();
                        return null;
                    }
                }, (Executor) Task.BACKGROUND_EXECUTOR);
                dispatchOnParseInitialized();
                synchronized (MUTEX_CALLBACKS) {
                    callbacks = null;
                }
                return;
            }
            throw new SecurityException("To prevent external tampering to your app's notifications, all receivers registered to handle the following actions must have their exported attributes set to false: com.parse.push.intent.RECEIVE, com.parse.push.intent.OPEN, com.parse.push.intent.DELETE");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean isInitialized() {
        return ParsePlugins.get() != null;
    }

    public static boolean isLocalDatastoreEnabled() {
        return isLocalDatastoreEnabled;
    }

    static void registerParseCallbacks(ParseCallbacks parseCallbacks) {
        if (!isInitialized()) {
            synchronized (MUTEX_CALLBACKS) {
                if (callbacks != null) {
                    callbacks.add(parseCallbacks);
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("You must register callbacks before Parse.initialize(Context)");
    }

    static void requirePermission(String str) {
        if (!hasPermission(str)) {
            throw new IllegalStateException("To use this functionality, add this to your AndroidManifest.xml:\n<uses-permission android:name=\"" + str + "\" />");
        }
    }

    static void setLocalDatastore(OfflineStore offlineStore2) {
        isLocalDatastoreEnabled = offlineStore2 != null;
        offlineStore = offlineStore2;
    }

    public static void setLogLevel(int i) {
        PLog.setLogLevel(i);
    }

    public static void setServer(String str) {
        try {
            ParseRESTCommand.server = new URL(validateServerUrl(str));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static void unregisterParseCallbacks(ParseCallbacks parseCallbacks) {
        synchronized (MUTEX_CALLBACKS) {
            if (callbacks != null) {
                callbacks.remove(parseCallbacks);
            }
        }
    }

    /* access modifiers changed from: private */
    public static String validateServerUrl(String str) {
        if (str == null || str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }
}
