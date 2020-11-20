package com.parse;

import bolts.Task;
import com.parse.ParseObject;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;

class FileObjectStore<T extends ParseObject> implements ParseObjectStore<T> {
    /* access modifiers changed from: private */
    public final String className;
    /* access modifiers changed from: private */
    public final ParseObjectCurrentCoder coder;
    /* access modifiers changed from: private */
    public final File file;

    public FileObjectStore(Class<T> cls, File file2, ParseObjectCurrentCoder parseObjectCurrentCoder) {
        this(getSubclassingController().getClassName(cls), file2, parseObjectCurrentCoder);
    }

    public FileObjectStore(String str, File file2, ParseObjectCurrentCoder parseObjectCurrentCoder) {
        this.className = str;
        this.file = file2;
        this.coder = parseObjectCurrentCoder;
    }

    /* access modifiers changed from: private */
    public static <T extends ParseObject> T getFromDisk(ParseObjectCurrentCoder parseObjectCurrentCoder, File file2, ParseObject.State.Init init) {
        try {
            return ParseObject.from(parseObjectCurrentCoder.decode(init, ParseFileUtils.readFileToJSONObject(file2), ParseDecoder.get()).isComplete(true).build());
        } catch (IOException | JSONException unused) {
            return null;
        }
    }

    private static ParseObjectSubclassingController getSubclassingController() {
        return ParseCorePlugins.getInstance().getSubclassingController();
    }

    /* access modifiers changed from: private */
    public static void saveToDisk(ParseObjectCurrentCoder parseObjectCurrentCoder, ParseObject parseObject, File file2) {
        try {
            ParseFileUtils.writeJSONObjectToFile(file2, parseObjectCurrentCoder.encode(parseObject.getState(), (ParseOperationSet) null, PointerEncoder.get()));
        } catch (IOException unused) {
        }
    }

    public Task<Void> deleteAsync() {
        return Task.call(new Callable<Void>() {
            public Void call() {
                if (!FileObjectStore.this.file.exists() || ParseFileUtils.deleteQuietly(FileObjectStore.this.file)) {
                    return null;
                }
                throw new RuntimeException("Unable to delete");
            }
        }, ParseExecutors.m8824io());
    }

    public Task<Boolean> existsAsync() {
        return Task.call(new Callable<Boolean>() {
            public Boolean call() {
                return Boolean.valueOf(FileObjectStore.this.file.exists());
            }
        }, ParseExecutors.m8824io());
    }

    public Task<T> getAsync() {
        return Task.call(new Callable<T>() {
            public T call() {
                if (!FileObjectStore.this.file.exists()) {
                    return null;
                }
                return FileObjectStore.getFromDisk(FileObjectStore.this.coder, FileObjectStore.this.file, ParseObject.State.newBuilder(FileObjectStore.this.className));
            }
        }, ParseExecutors.m8824io());
    }

    public Task<Void> setAsync(final T t) {
        return Task.call(new Callable<Void>() {
            public Void call() {
                FileObjectStore.saveToDisk(FileObjectStore.this.coder, t, FileObjectStore.this.file);
                return null;
            }
        }, ParseExecutors.m8824io());
    }
}
