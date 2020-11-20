package com.parse;

import android.content.Context;
import android.os.Build;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.parse.Parse;
import java.io.File;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ParsePlugins {
    private static final String INSTALLATION_ID_LOCATION = "installationId";
    private static final Object LOCK = new Object();
    private static ParsePlugins instance;
    private Context applicationContext;
    File cacheDir;
    /* access modifiers changed from: private */
    public final Parse.Configuration configuration;
    ParseHttpClient fileClient;
    File filesDir;
    private InstallationId installationId;
    final Object lock = new Object();
    File parseDir;
    ParseHttpClient restClient;

    private ParsePlugins(Context context, Parse.Configuration configuration2) {
        if (context != null) {
            this.applicationContext = context.getApplicationContext();
        }
        this.configuration = configuration2;
    }

    private static File createFileDir(File file) {
        if (file.exists() || !file.mkdirs()) {
        }
        return file;
    }

    public static ParsePlugins get() {
        ParsePlugins parsePlugins;
        synchronized (LOCK) {
            parsePlugins = instance;
        }
        return parsePlugins;
    }

    static void initialize(Context context, Parse.Configuration configuration2) {
        set(new ParsePlugins(context, configuration2));
    }

    static void reset() {
        synchronized (LOCK) {
            instance = null;
        }
    }

    static void set(ParsePlugins parsePlugins) {
        synchronized (LOCK) {
            if (instance == null) {
                instance = parsePlugins;
            } else {
                throw new IllegalStateException("ParsePlugins is already initialized");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Context applicationContext() {
        return this.applicationContext;
    }

    public String applicationId() {
        return this.configuration.applicationId;
    }

    public String clientKey() {
        return this.configuration.clientKey;
    }

    /* access modifiers changed from: package-private */
    public Parse.Configuration configuration() {
        return this.configuration;
    }

    /* access modifiers changed from: package-private */
    public ParseHttpClient fileClient() {
        ParseHttpClient parseHttpClient;
        synchronized (this.lock) {
            if (this.fileClient == null) {
                this.fileClient = ParseHttpClient.createClient(this.configuration.clientBuilder);
            }
            parseHttpClient = this.fileClient;
        }
        return parseHttpClient;
    }

    /* access modifiers changed from: package-private */
    public File getCacheDir() {
        File createFileDir;
        synchronized (this.lock) {
            if (this.cacheDir == null) {
                this.cacheDir = new File(this.applicationContext.getCacheDir(), "com.parse");
            }
            createFileDir = createFileDir(this.cacheDir);
        }
        return createFileDir;
    }

    /* access modifiers changed from: package-private */
    public File getFilesDir() {
        File createFileDir;
        synchronized (this.lock) {
            if (this.filesDir == null) {
                this.filesDir = new File(this.applicationContext.getFilesDir(), "com.parse");
            }
            createFileDir = createFileDir(this.filesDir);
        }
        return createFileDir;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public File getParseDir() {
        File createFileDir;
        synchronized (this.lock) {
            if (this.parseDir == null) {
                this.parseDir = this.applicationContext.getDir("Parse", 0);
            }
            createFileDir = createFileDir(this.parseDir);
        }
        return createFileDir;
    }

    /* access modifiers changed from: package-private */
    public InstallationId installationId() {
        InstallationId installationId2;
        synchronized (this.lock) {
            if (this.installationId == null) {
                this.installationId = new InstallationId(new File(getParseDir(), INSTALLATION_ID_LOCATION));
            }
            installationId2 = this.installationId;
        }
        return installationId2;
    }

    /* access modifiers changed from: package-private */
    public ParseHttpClient restClient() {
        ParseHttpClient parseHttpClient;
        synchronized (this.lock) {
            if (this.restClient == null) {
                OkHttpClient.Builder builder = this.configuration.clientBuilder;
                if (builder == null) {
                    builder = new OkHttpClient.Builder();
                }
                builder.interceptors().add(0, new Interceptor() {
                    public Response intercept(Interceptor.Chain chain) {
                        Request request = chain.request();
                        Headers.Builder builder = request.headers().newBuilder().set("X-Parse-Application-Id", ParsePlugins.this.configuration.applicationId).set("X-Parse-App-Build-Version", String.valueOf(ManifestInfo.getVersionCode())).set("X-Parse-App-Display-Version", ManifestInfo.getVersionName()).set("X-Parse-OS-Version", Build.VERSION.RELEASE).set(AbstractSpiCall.HEADER_USER_AGENT, ParsePlugins.this.userAgent());
                        if (request.header("X-Parse-Installation-Id") == null) {
                            builder.set("X-Parse-Installation-Id", ParsePlugins.this.installationId().get());
                        }
                        if (ParsePlugins.this.configuration.clientKey != null) {
                            builder.set("X-Parse-Client-Key", ParsePlugins.this.configuration.clientKey);
                        }
                        return chain.proceed(request.newBuilder().headers(builder.build()).build());
                    }
                });
                this.restClient = ParseHttpClient.createClient(builder);
            }
            parseHttpClient = this.restClient;
        }
        return parseHttpClient;
    }

    public String server() {
        return this.configuration.server;
    }

    /* access modifiers changed from: package-private */
    public String userAgent() {
        return "Parse Android SDK API Level " + Build.VERSION.SDK_INT;
    }
}
