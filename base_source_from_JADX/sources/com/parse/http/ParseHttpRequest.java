package com.parse.http;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ParseHttpRequest {
    /* access modifiers changed from: private */
    public final ParseHttpBody body;
    /* access modifiers changed from: private */
    public final Map<String, String> headers;
    /* access modifiers changed from: private */
    public final Method method;
    /* access modifiers changed from: private */
    public final String url;

    public static final class Builder {
        /* access modifiers changed from: private */
        public ParseHttpBody body;
        /* access modifiers changed from: private */
        public Map<String, String> headers;
        /* access modifiers changed from: private */
        public Method method;
        /* access modifiers changed from: private */
        public String url;

        public Builder() {
            this.headers = new HashMap();
        }

        public Builder(ParseHttpRequest parseHttpRequest) {
            this.url = parseHttpRequest.url;
            this.method = parseHttpRequest.method;
            this.headers = new HashMap(parseHttpRequest.headers);
            this.body = parseHttpRequest.body;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public Builder addHeaders(Map<String, String> map) {
            this.headers.putAll(map);
            return this;
        }

        public ParseHttpRequest build() {
            return new ParseHttpRequest(this);
        }

        public Builder setBody(ParseHttpBody parseHttpBody) {
            this.body = parseHttpBody;
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.headers = new HashMap(map);
            return this;
        }

        public Builder setMethod(Method method2) {
            this.method = method2;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public enum Method {
        GET,
        POST,
        PUT,
        DELETE;

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.parse.http.ParseHttpRequest.Method fromString(java.lang.String r3) {
            /*
                int r0 = r3.hashCode()
                r1 = 70454(0x11336, float:9.8727E-41)
                if (r0 == r1) goto L_0x0037
                r1 = 79599(0x136ef, float:1.11542E-40)
                if (r0 == r1) goto L_0x002d
                r1 = 2461856(0x2590a0, float:3.449795E-39)
                if (r0 == r1) goto L_0x0023
                r1 = 2012838315(0x77f979ab, float:1.0119919E34)
                if (r0 == r1) goto L_0x0019
                goto L_0x0041
            L_0x0019:
                java.lang.String r0 = "DELETE"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L_0x0041
                r0 = 3
                goto L_0x0042
            L_0x0023:
                java.lang.String r0 = "POST"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L_0x0041
                r0 = 1
                goto L_0x0042
            L_0x002d:
                java.lang.String r0 = "PUT"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L_0x0041
                r0 = 2
                goto L_0x0042
            L_0x0037:
                java.lang.String r0 = "GET"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L_0x0041
                r0 = 0
                goto L_0x0042
            L_0x0041:
                r0 = -1
            L_0x0042:
                switch(r0) {
                    case 0: goto L_0x006a;
                    case 1: goto L_0x0067;
                    case 2: goto L_0x0064;
                    case 3: goto L_0x0061;
                    default: goto L_0x0045;
                }
            L_0x0045:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid http method: <"
                r1.append(r2)
                r1.append(r3)
                java.lang.String r3 = ">"
                r1.append(r3)
                java.lang.String r3 = r1.toString()
                r0.<init>(r3)
                throw r0
            L_0x0061:
                com.parse.http.ParseHttpRequest$Method r3 = DELETE
                goto L_0x006c
            L_0x0064:
                com.parse.http.ParseHttpRequest$Method r3 = PUT
                goto L_0x006c
            L_0x0067:
                com.parse.http.ParseHttpRequest$Method r3 = POST
                goto L_0x006c
            L_0x006a:
                com.parse.http.ParseHttpRequest$Method r3 = GET
            L_0x006c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.parse.http.ParseHttpRequest.Method.fromString(java.lang.String):com.parse.http.ParseHttpRequest$Method");
        }

        public String toString() {
            switch (this) {
                case GET:
                    return "GET";
                case POST:
                    return "POST";
                case PUT:
                    return "PUT";
                case DELETE:
                    return "DELETE";
                default:
                    throw new IllegalArgumentException("Invalid http method: <" + this + ">");
            }
        }
    }

    private ParseHttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = Collections.unmodifiableMap(new HashMap(builder.headers));
        this.body = builder.body;
    }

    public Map<String, String> getAllHeaders() {
        return this.headers;
    }

    public ParseHttpBody getBody() {
        return this.body;
    }

    public String getHeader(String str) {
        return this.headers.get(str);
    }

    public Method getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }
}
