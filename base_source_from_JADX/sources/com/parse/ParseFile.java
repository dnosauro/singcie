package com.parse;

import android.os.Parcel;
import android.os.Parcelable;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class ParseFile implements Parcelable {
    public static final Parcelable.Creator<ParseFile> CREATOR = new Parcelable.Creator<ParseFile>() {
        public ParseFile createFromParcel(Parcel parcel) {
            return new ParseFile(parcel);
        }

        public ParseFile[] newArray(int i) {
            return new ParseFile[i];
        }
    };
    /* access modifiers changed from: private */
    public Set<TaskCompletionSource<?>> currentTasks;
    byte[] data;
    File file;
    /* access modifiers changed from: private */
    public State state;
    final TaskQueue taskQueue;

    static class State {
        private final String contentType;
        private final String name;
        private final String url;

        static class Builder {
            /* access modifiers changed from: private */
            public String mimeType;
            /* access modifiers changed from: private */
            public String name;
            /* access modifiers changed from: private */
            public String url;

            public Builder() {
            }

            public Builder(State state) {
                this.name = state.name();
                this.mimeType = state.mimeType();
                this.url = state.url();
            }

            public State build() {
                return new State(this);
            }

            public Builder mimeType(String str) {
                this.mimeType = str;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder url(String str) {
                this.url = str;
                return this;
            }
        }

        private State(Builder builder) {
            this.name = builder.name != null ? builder.name : "file";
            this.contentType = builder.mimeType;
            this.url = builder.url;
        }

        public String mimeType() {
            return this.contentType;
        }

        public String name() {
            return this.name;
        }

        public String url() {
            return this.url;
        }
    }

    protected ParseFile(Parcel parcel) {
        this(parcel, ParseParcelDecoder.get());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    ParseFile(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
        this(new State.Builder().url(parcel.readString()).name(parcel.readString()).mimeType(parcel.readByte() == 1 ? parcel.readString() : null).build());
    }

    ParseFile(State state2) {
        this.taskQueue = new TaskQueue();
        this.currentTasks = Collections.synchronizedSet(new HashSet());
        this.state = state2;
    }

    public ParseFile(File file2) {
        this(file2, (String) null);
    }

    public ParseFile(File file2, String str) {
        this(new State.Builder().name(file2.getName()).mimeType(str).build());
        this.file = file2;
    }

    public ParseFile(String str, byte[] bArr) {
        this(str, bArr, (String) null);
    }

    public ParseFile(String str, byte[] bArr, String str2) {
        this(new State.Builder().name(str).mimeType(str2).build());
        this.data = bArr;
    }

    ParseFile(JSONObject jSONObject, ParseDecoder parseDecoder) {
        this(new State.Builder().name(jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME)).url(jSONObject.optString(ImagesContract.URL)).build());
    }

    public ParseFile(byte[] bArr) {
        this((String) null, bArr, (String) null);
    }

    public ParseFile(byte[] bArr, String str) {
        this((String) null, bArr, str);
    }

    /* access modifiers changed from: private */
    public Task<File> fetchInBackground(final ProgressCallback progressCallback, Task<Void> task, final Task<Void> task2) {
        return (task2 == null || !task2.isCancelled()) ? task.continueWithTask(new Continuation<Void, Task<File>>() {
            public Task<File> then(Task<Void> task) {
                Task task2 = task2;
                return (task2 == null || !task2.isCancelled()) ? ParseFile.getFileController().fetchAsync(ParseFile.this.state, (String) null, ParseFile.progressCallbackOnMainThread(progressCallback), task2) : Task.cancelled();
            }
        }) : Task.cancelled();
    }

    static ParseFileController getFileController() {
        return ParseCorePlugins.getInstance().getFileController();
    }

    /* access modifiers changed from: private */
    public static ProgressCallback progressCallbackOnMainThread(final ProgressCallback progressCallback) {
        if (progressCallback == null) {
            return null;
        }
        return new ProgressCallback() {
            public void done(final Integer num) {
                Task.call(new Callable<Void>() {
                    public Void call() {
                        progressCallback.done(num);
                        return null;
                    }
                }, ParseExecutors.main());
            }
        };
    }

    /* access modifiers changed from: private */
    public Task<Void> saveAsync(final String str, final ProgressCallback progressCallback, Task<Void> task, final Task<Void> task2) {
        return !isDirty() ? Task.forResult(null) : (task2 == null || !task2.isCancelled()) ? task.continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                if (!ParseFile.this.isDirty()) {
                    return Task.forResult(null);
                }
                Task task2 = task2;
                if (task2 != null && task2.isCancelled()) {
                    return Task.cancelled();
                }
                return (ParseFile.this.data != null ? ParseFile.getFileController().saveAsync(ParseFile.this.state, ParseFile.this.data, str, ParseFile.progressCallbackOnMainThread(progressCallback), (Task<Void>) task2) : ParseFile.getFileController().saveAsync(ParseFile.this.state, ParseFile.this.file, str, ParseFile.progressCallbackOnMainThread(progressCallback), (Task<Void>) task2)).onSuccessTask(new Continuation<State, Task<Void>>() {
                    public Task<Void> then(Task<State> task) {
                        State unused = ParseFile.this.state = task.getResult();
                        ParseFile.this.data = null;
                        ParseFile.this.file = null;
                        return task.makeVoid();
                    }
                });
            }
        }) : Task.cancelled();
    }

    public void cancel() {
        HashSet<TaskCompletionSource> hashSet = new HashSet<>(this.currentTasks);
        for (TaskCompletionSource trySetCancelled : hashSet) {
            trySetCancelled.trySetCancelled();
        }
        this.currentTasks.removeAll(hashSet);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__type", "File");
        jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, getName());
        if (getUrl() != null) {
            jSONObject.put(ImagesContract.URL, getUrl());
            return jSONObject;
        }
        throw new IllegalStateException("Unable to encode an unsaved ParseFile.");
    }

    public byte[] getData() {
        return (byte[]) ParseTaskUtils.wait(getDataInBackground());
    }

    public Task<byte[]> getDataInBackground() {
        return getDataInBackground((ProgressCallback) null);
    }

    public Task<byte[]> getDataInBackground(final ProgressCallback progressCallback) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.currentTasks.add(taskCompletionSource);
        return this.taskQueue.enqueue(new Continuation<Void, Task<byte[]>>() {
            public Task<byte[]> then(Task<Void> task) {
                return ParseFile.this.fetchInBackground(progressCallback, task, taskCompletionSource.getTask()).onSuccess(new Continuation<File, byte[]>() {
                    public byte[] then(Task<File> task) {
                        try {
                            return ParseFileUtils.readFileToByteArray(task.getResult());
                        } catch (IOException unused) {
                            return null;
                        }
                    }
                });
            }
        }).continueWithTask(new Continuation<byte[], Task<byte[]>>() {
            public Task<byte[]> then(Task<byte[]> task) {
                taskCompletionSource.trySetResult(null);
                ParseFile.this.currentTasks.remove(taskCompletionSource);
                return task;
            }
        });
    }

    public void getDataInBackground(GetDataCallback getDataCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataInBackground(), getDataCallback);
    }

    public void getDataInBackground(GetDataCallback getDataCallback, ProgressCallback progressCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataInBackground(progressCallback), getDataCallback);
    }

    public InputStream getDataStream() {
        return (InputStream) ParseTaskUtils.wait(getDataStreamInBackground());
    }

    public Task<InputStream> getDataStreamInBackground() {
        return getDataStreamInBackground((ProgressCallback) null);
    }

    public Task<InputStream> getDataStreamInBackground(final ProgressCallback progressCallback) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.currentTasks.add(taskCompletionSource);
        return this.taskQueue.enqueue(new Continuation<Void, Task<InputStream>>() {
            public Task<InputStream> then(Task<Void> task) {
                return ParseFile.this.fetchInBackground(progressCallback, task, taskCompletionSource.getTask()).onSuccess(new Continuation<File, InputStream>() {
                    public InputStream then(Task<File> task) {
                        return new FileInputStream(task.getResult());
                    }
                });
            }
        }).continueWithTask(new Continuation<InputStream, Task<InputStream>>() {
            public Task<InputStream> then(Task<InputStream> task) {
                taskCompletionSource.trySetResult(null);
                ParseFile.this.currentTasks.remove(taskCompletionSource);
                return task;
            }
        });
    }

    public void getDataStreamInBackground(GetDataStreamCallback getDataStreamCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataStreamInBackground(), getDataStreamCallback);
    }

    public void getDataStreamInBackground(GetDataStreamCallback getDataStreamCallback, ProgressCallback progressCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getDataStreamInBackground(progressCallback), getDataStreamCallback);
    }

    public File getFile() {
        return (File) ParseTaskUtils.wait(getFileInBackground());
    }

    public Task<File> getFileInBackground() {
        return getFileInBackground((ProgressCallback) null);
    }

    public Task<File> getFileInBackground(final ProgressCallback progressCallback) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.currentTasks.add(taskCompletionSource);
        return this.taskQueue.enqueue(new Continuation<Void, Task<File>>() {
            public Task<File> then(Task<Void> task) {
                return ParseFile.this.fetchInBackground(progressCallback, task, taskCompletionSource.getTask());
            }
        }).continueWithTask(new Continuation<File, Task<File>>() {
            public Task<File> then(Task<File> task) {
                taskCompletionSource.trySetResult(null);
                ParseFile.this.currentTasks.remove(taskCompletionSource);
                return task;
            }
        });
    }

    public void getFileInBackground(GetFileCallback getFileCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getFileInBackground(), getFileCallback);
    }

    public void getFileInBackground(GetFileCallback getFileCallback, ProgressCallback progressCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(getFileInBackground(progressCallback), getFileCallback);
    }

    public String getName() {
        return this.state.name();
    }

    /* access modifiers changed from: package-private */
    public State getState() {
        return this.state;
    }

    public String getUrl() {
        return this.state.url();
    }

    public boolean isDataAvailable() {
        return this.data != null || getFileController().isDataAvailable(this.state);
    }

    public boolean isDirty() {
        return this.state.url() == null;
    }

    public void save() {
        ParseTaskUtils.wait(saveInBackground());
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(final String str, final ProgressCallback progressCallback, final Task<Void> task) {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                return ParseFile.this.saveAsync(str, progressCallback, task, task);
            }
        });
    }

    public Task<Void> saveInBackground() {
        return saveInBackground((ProgressCallback) null);
    }

    public Task<Void> saveInBackground(final ProgressCallback progressCallback) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.currentTasks.add(taskCompletionSource);
        return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation<String, Task<Void>>() {
            public Task<Void> then(Task<String> task) {
                return ParseFile.this.saveAsync(task.getResult(), progressCallback, taskCompletionSource.getTask());
            }
        }).continueWithTask(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) {
                taskCompletionSource.trySetResult(null);
                ParseFile.this.currentTasks.remove(taskCompletionSource);
                return task;
            }
        });
    }

    public void saveInBackground(SaveCallback saveCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(), (ParseCallback1<ParseException>) saveCallback);
    }

    public void saveInBackground(SaveCallback saveCallback, ProgressCallback progressCallback) {
        ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(progressCallback), (ParseCallback1<ParseException>) saveCallback);
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, ParseParcelEncoder.get());
    }

    /* access modifiers changed from: package-private */
    public void writeToParcel(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        if (!isDirty()) {
            parcel.writeString(getUrl());
            parcel.writeString(getName());
            String mimeType = this.state.mimeType();
            parcel.writeByte(mimeType != null ? (byte) 1 : 0);
            if (mimeType != null) {
                parcel.writeString(mimeType);
                return;
            }
            return;
        }
        throw new RuntimeException("Unable to parcel an unsaved ParseFile.");
    }
}
