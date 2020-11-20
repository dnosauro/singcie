package com.parse;

import bolts.Task;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

class ParseFileRequest extends ParseRequest<Void> {
    /* access modifiers changed from: private */
    public final File tempFile;

    public ParseFileRequest(ParseHttpRequest.Method method, String str, File file) {
        super(method, str);
        this.tempFile = file;
    }

    /* access modifiers changed from: protected */
    public Task<Void> onResponseAsync(final ParseHttpResponse parseHttpResponse, final ProgressCallback progressCallback) {
        int statusCode = parseHttpResponse.getStatusCode();
        if ((statusCode < 200 || statusCode >= 300) && statusCode != 304) {
            return Task.forError(new ParseException(100, String.format("%s file server failed. %s", new Object[]{this.method == ParseHttpRequest.Method.GET ? "Download from" : "Upload to", parseHttpResponse.getReasonPhrase()})));
        } else if (this.method != ParseHttpRequest.Method.GET) {
            return null;
        } else {
            return Task.call(new Callable<Void>() {
                public Void call() {
                    FileOutputStream fileOutputStream;
                    InputStream inputStream;
                    long totalSize = parseHttpResponse.getTotalSize();
                    try {
                        inputStream = parseHttpResponse.getContent();
                        try {
                            fileOutputStream = ParseFileUtils.openOutputStream(ParseFileRequest.this.tempFile);
                            try {
                                byte[] bArr = new byte[32768];
                                long j = 0;
                                while (true) {
                                    int read = inputStream.read(bArr, 0, bArr.length);
                                    if (read != -1) {
                                        fileOutputStream.write(bArr, 0, read);
                                        j += (long) read;
                                        if (!(progressCallback == null || totalSize == -1)) {
                                            progressCallback.done(Integer.valueOf(Math.round((((float) j) / ((float) totalSize)) * 100.0f)));
                                        }
                                    } else {
                                        ParseIOUtils.closeQuietly(inputStream);
                                        ParseIOUtils.closeQuietly((OutputStream) fileOutputStream);
                                        return null;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                ParseIOUtils.closeQuietly(inputStream);
                                ParseIOUtils.closeQuietly((OutputStream) fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                            ParseIOUtils.closeQuietly(inputStream);
                            ParseIOUtils.closeQuietly((OutputStream) fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        fileOutputStream = null;
                        ParseIOUtils.closeQuietly(inputStream);
                        ParseIOUtils.closeQuietly((OutputStream) fileOutputStream);
                        throw th;
                    }
                }
            }, ParseExecutors.m8824io());
        }
    }
}
