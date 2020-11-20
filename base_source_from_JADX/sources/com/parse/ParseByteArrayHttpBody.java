package com.parse;

import com.parse.http.ParseHttpBody;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

class ParseByteArrayHttpBody extends ParseHttpBody {
    final byte[] content;
    final InputStream contentInputStream;

    public ParseByteArrayHttpBody(String str, String str2) {
        this(str.getBytes("UTF-8"), str2);
    }

    public ParseByteArrayHttpBody(byte[] bArr, String str) {
        super(str, (long) bArr.length);
        this.content = bArr;
        this.contentInputStream = new ByteArrayInputStream(bArr);
    }

    public InputStream getContent() {
        return this.contentInputStream;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream != null) {
            outputStream.write(this.content);
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }
}
