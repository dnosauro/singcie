package com.google.firebase.crashlytics.internal.network;

import okhttp3.Headers;
import okhttp3.Response;

public class HttpResponse {
    private String body;
    private int code;
    private Headers headers;

    HttpResponse(int i, String str, Headers headers2) {
        this.code = i;
        this.body = str;
        this.headers = headers2;
    }

    static HttpResponse create(Response response) {
        return new HttpResponse(response.code(), response.body() == null ? null : response.body().string(), response.headers());
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }

    public String header(String str) {
        return this.headers.get(str);
    }
}
