package com.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

class ParseCountingFileHttpBody extends ParseFileHttpBody {
    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int EOF = -1;
    private final ProgressCallback progressCallback;

    public ParseCountingFileHttpBody(File file, ProgressCallback progressCallback2) {
        this(file, (String) null, progressCallback2);
    }

    public ParseCountingFileHttpBody(File file, String str, ProgressCallback progressCallback2) {
        super(file, str);
        this.progressCallback = progressCallback2;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            FileInputStream fileInputStream = new FileInputStream(this.file);
            try {
                byte[] bArr = new byte[4096];
                long length = this.file.length();
                long j = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (-1 != read) {
                        outputStream.write(bArr, 0, read);
                        j += (long) read;
                        if (this.progressCallback != null) {
                            this.progressCallback.done(Integer.valueOf((int) ((100 * j) / length)));
                        }
                    } else {
                        return;
                    }
                }
            } finally {
                ParseIOUtils.closeQuietly((InputStream) fileInputStream);
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }
}
