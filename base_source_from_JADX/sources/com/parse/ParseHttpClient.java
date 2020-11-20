package com.parse;

import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;

class ParseHttpClient {
    private boolean hasExecuted;
    private OkHttpClient okHttpClient;

    private static class ParseOkHttpRequestBody extends RequestBody {
        private ParseHttpBody parseBody;

        ParseOkHttpRequestBody(ParseHttpBody parseHttpBody) {
            this.parseBody = parseHttpBody;
        }

        public long contentLength() {
            return this.parseBody.getContentLength();
        }

        public MediaType contentType() {
            if (this.parseBody.getContentType() == null) {
                return null;
            }
            return MediaType.parse(this.parseBody.getContentType());
        }

        public void writeTo(BufferedSink bufferedSink) {
            this.parseBody.writeTo(bufferedSink.outputStream());
        }
    }

    ParseHttpClient(OkHttpClient.Builder builder) {
        this.okHttpClient = (builder == null ? new OkHttpClient.Builder() : builder).build();
    }

    static ParseHttpClient createClient(OkHttpClient.Builder builder) {
        return new ParseHttpClient(builder);
    }

    public final ParseHttpResponse execute(ParseHttpRequest parseHttpRequest) {
        if (!this.hasExecuted) {
            this.hasExecuted = true;
        }
        return executeInternal(parseHttpRequest);
    }

    /* access modifiers changed from: package-private */
    public ParseHttpResponse executeInternal(ParseHttpRequest parseHttpRequest) {
        return getResponse(this.okHttpClient.newCall(getRequest(parseHttpRequest)).execute());
    }

    /* access modifiers changed from: package-private */
    public Request getRequest(ParseHttpRequest parseHttpRequest) {
        Request.Builder builder = new Request.Builder();
        ParseHttpRequest.Method method = parseHttpRequest.getMethod();
        switch (method) {
            case GET:
                builder.get();
                break;
            case DELETE:
            case POST:
            case PUT:
                break;
            default:
                throw new IllegalStateException("Unsupported http method " + method.toString());
        }
        builder.url(parseHttpRequest.getUrl());
        Headers.Builder builder2 = new Headers.Builder();
        for (Map.Entry next : parseHttpRequest.getAllHeaders().entrySet()) {
            builder2.add((String) next.getKey(), (String) next.getValue());
        }
        builder.headers(builder2.build());
        ParseHttpBody body = parseHttpRequest.getBody();
        ParseOkHttpRequestBody parseOkHttpRequestBody = null;
        if (body != null) {
            parseOkHttpRequestBody = new ParseOkHttpRequestBody(body);
        }
        switch (method) {
            case DELETE:
                builder.delete(parseOkHttpRequestBody);
                break;
            case POST:
                builder.post(parseOkHttpRequestBody);
                break;
            case PUT:
                builder.put(parseOkHttpRequestBody);
                break;
        }
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public ParseHttpResponse getResponse(Response response) {
        int code = response.code();
        InputStream byteStream = response.body().byteStream();
        int contentLength = (int) response.body().contentLength();
        String message = response.message();
        HashMap hashMap = new HashMap();
        for (String next : response.headers().names()) {
            hashMap.put(next, response.header(next));
        }
        String str = null;
        ResponseBody body = response.body();
        if (!(body == null || body.contentType() == null)) {
            str = body.contentType().toString();
        }
        return new ParseHttpResponse.Builder().setStatusCode(code).setContent(byteStream).setTotalSize((long) contentLength).setReasonPhrase(message).setHeaders(hashMap).setContentType(str).build();
    }
}
