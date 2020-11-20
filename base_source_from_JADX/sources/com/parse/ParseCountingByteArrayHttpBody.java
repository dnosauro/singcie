package com.parse;

import java.io.OutputStream;

class ParseCountingByteArrayHttpBody extends ParseByteArrayHttpBody {
    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private final ProgressCallback progressCallback;

    public ParseCountingByteArrayHttpBody(byte[] bArr, String str, ProgressCallback progressCallback2) {
        super(bArr, str);
        this.progressCallback = progressCallback2;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            int i = 0;
            int length = this.content.length;
            while (i < length) {
                int min = Math.min(length - i, 4096);
                outputStream.write(this.content, i, min);
                outputStream.flush();
                ProgressCallback progressCallback2 = this.progressCallback;
                if (progressCallback2 != null) {
                    i += min;
                    progressCallback2.done(Integer.valueOf((i * 100) / length));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }
}
