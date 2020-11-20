package com.parse.http;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class ParseHttpBody {
    private final long contentLength;
    private final String contentType;

    public ParseHttpBody(String str, long j) {
        this.contentType = str;
        this.contentLength = j;
    }

    public abstract InputStream getContent();

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public abstract void writeTo(OutputStream outputStream);
}
