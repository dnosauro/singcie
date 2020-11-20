package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.parse.ParseFile;
import com.parse.ParseRESTFileCommand;
import com.parse.http.ParseHttpRequest;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import org.json.JSONObject;

class ParseFileController {
    private final File cachePath;
    private ParseHttpClient fileClient;
    private final Object lock = new Object();
    private final ParseHttpClient restClient;

    public ParseFileController(ParseHttpClient parseHttpClient, File file) {
        this.restClient = parseHttpClient;
        this.cachePath = file;
    }

    public void clearCache() {
        File[] listFiles = this.cachePath.listFiles();
        if (listFiles != null) {
            for (File deleteQuietly : listFiles) {
                ParseFileUtils.deleteQuietly(deleteQuietly);
            }
        }
    }

    public Task<File> fetchAsync(ParseFile.State state, String str, ProgressCallback progressCallback, Task<Void> task) {
        if (task != null && task.isCancelled()) {
            return Task.cancelled();
        }
        final File cacheFile = getCacheFile(state);
        final Task<Void> task2 = task;
        final ParseFile.State state2 = state;
        final ProgressCallback progressCallback2 = progressCallback;
        return Task.call(new Callable<Boolean>() {
            public Boolean call() {
                return Boolean.valueOf(cacheFile.exists());
            }
        }, ParseExecutors.m8824io()).continueWithTask(new Continuation<Boolean, Task<File>>() {
            public Task<File> then(Task<Boolean> task) {
                if (task.getResult().booleanValue()) {
                    return Task.forResult(cacheFile);
                }
                Task task2 = task2;
                if (task2 != null && task2.isCancelled()) {
                    return Task.cancelled();
                }
                final File tempFile = ParseFileController.this.getTempFile(state2);
                return new ParseFileRequest(ParseHttpRequest.Method.GET, state2.url(), tempFile).executeAsync(ParseFileController.this.fileClient(), (ProgressCallback) null, progressCallback2, (Task<Void>) task2).continueWithTask(new Continuation<Void, Task<File>>() {
                    public Task<File> then(Task<Void> task) {
                        if (task2 != null && task2.isCancelled()) {
                            throw new CancellationException();
                        } else if (task.isFaulted()) {
                            ParseFileUtils.deleteQuietly(tempFile);
                            return task.cast();
                        } else {
                            ParseFileUtils.deleteQuietly(cacheFile);
                            ParseFileUtils.moveFile(tempFile, cacheFile);
                            return Task.forResult(cacheFile);
                        }
                    }
                }, ParseExecutors.m8824io());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public ParseFileController fileClient(ParseHttpClient parseHttpClient) {
        synchronized (this.lock) {
            this.fileClient = parseHttpClient;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public ParseHttpClient fileClient() {
        ParseHttpClient parseHttpClient;
        synchronized (this.lock) {
            if (this.fileClient == null) {
                this.fileClient = ParsePlugins.get().fileClient();
            }
            parseHttpClient = this.fileClient;
        }
        return parseHttpClient;
    }

    public File getCacheFile(ParseFile.State state) {
        return new File(this.cachePath, state.name());
    }

    /* access modifiers changed from: package-private */
    public File getTempFile(ParseFile.State state) {
        if (state.url() == null) {
            return null;
        }
        File file = this.cachePath;
        return new File(file, state.url() + ".tmp");
    }

    public boolean isDataAvailable(ParseFile.State state) {
        return getCacheFile(state).exists();
    }

    public Task<ParseFile.State> saveAsync(final ParseFile.State state, final File file, String str, ProgressCallback progressCallback, Task<Void> task) {
        return state.url() != null ? Task.forResult(state) : (task == null || !task.isCancelled()) ? ((ParseRESTFileCommand.Builder) new ParseRESTFileCommand.Builder().fileName(state.name()).file(file).contentType(state.mimeType()).sessionToken(str)).build().executeAsync(this.restClient, progressCallback, (ProgressCallback) null, task).onSuccess(new Continuation<JSONObject, ParseFile.State>() {
            public ParseFile.State then(Task<JSONObject> task) {
                JSONObject result = task.getResult();
                ParseFile.State build = new ParseFile.State.Builder(state).name(result.getString(AppMeasurementSdk.ConditionalUserProperty.NAME)).url(result.getString(ImagesContract.URL)).build();
                try {
                    ParseFileUtils.copyFile(file, ParseFileController.this.getCacheFile(build));
                } catch (IOException unused) {
                }
                return build;
            }
        }, ParseExecutors.m8824io()) : Task.cancelled();
    }

    public Task<ParseFile.State> saveAsync(final ParseFile.State state, final byte[] bArr, String str, ProgressCallback progressCallback, Task<Void> task) {
        return state.url() != null ? Task.forResult(state) : (task == null || !task.isCancelled()) ? ((ParseRESTFileCommand.Builder) new ParseRESTFileCommand.Builder().fileName(state.name()).data(bArr).contentType(state.mimeType()).sessionToken(str)).build().executeAsync(this.restClient, progressCallback, (ProgressCallback) null, task).onSuccess(new Continuation<JSONObject, ParseFile.State>() {
            public ParseFile.State then(Task<JSONObject> task) {
                JSONObject result = task.getResult();
                ParseFile.State build = new ParseFile.State.Builder(state).name(result.getString(AppMeasurementSdk.ConditionalUserProperty.NAME)).url(result.getString(ImagesContract.URL)).build();
                try {
                    ParseFileUtils.writeByteArrayToFile(ParseFileController.this.getCacheFile(build), bArr);
                } catch (IOException unused) {
                }
                return build;
            }
        }, ParseExecutors.m8824io()) : Task.cancelled();
    }
}
