package com.parse.http;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ParseHttpResponse {
    private final InputStream content;
    private final String contentType;
    private final Map<String, String> headers;
    private final String reasonPhrase;
    private final int statusCode;
    private final long totalSize;

    public static final class Builder {
        /* access modifiers changed from: private */
        public InputStream content;
        /* access modifiers changed from: private */
        public String contentType;
        /* access modifiers changed from: private */
        public Map<String, String> headers;
        /* access modifiers changed from: private */
        public String reasonPhrase;
        /* access modifiers changed from: private */
        public int statusCode;
        /* access modifiers changed from: private */
        public long totalSize;

        public Builder() {
            this.totalSize = -1;
            this.headers = new HashMap();
        }

        public Builder(ParseHttpResponse parseHttpResponse) {
            setStatusCode(parseHttpResponse.getStatusCode());
            setContent(parseHttpResponse.getContent());
            setTotalSize(parseHttpResponse.getTotalSize());
            setContentType(parseHttpResponse.getContentType());
            setHeaders(parseHttpResponse.getAllHeaders());
            setReasonPhrase(parseHttpResponse.getReasonPhrase());
        }

        public Builder addHeader(String str, String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public Builder addHeaders(Map<String, String> map) {
            this.headers.putAll(map);
            return this;
        }

        public ParseHttpResponse build() {
            return new ParseHttpResponse(this);
        }

        public Builder setContent(InputStream inputStream) {
            this.content = inputStream;
            return this;
        }

        public Builder setContentType(String str) {
            this.contentType = str;
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.headers = new HashMap(map);
            return this;
        }

        public Builder setReasonPhrase(String str) {
            this.reasonPhrase = str;
            return this;
        }

        public Builder setStatusCode(int i) {
            this.statusCode = i;
            return this;
        }

        public Builder setTotalSize(long j) {
            this.totalSize = j;
            return this;
        }
    }

    private ParseHttpResponse(Builder builder) {
        this.statusCode = builder.statusCode;
        this.content = builder.content;
        this.totalSize = builder.totalSize;
        this.reasonPhrase = builder.reasonPhrase;
        this.headers = Collections.unmodifiableMap(new HashMap(builder.headers));
        this.contentType = builder.contentType;
    }

    public Map<String, String> getAllHeaders() {
        return this.headers;
    }

    public InputStream getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getHeader(String str) {
        return this.headers.get(str);
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public long getTotalSize() {
        return this.totalSize;
    }
}
