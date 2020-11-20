package com.parse;

import bolts.Task;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

class ParseRESTCommand extends ParseRequest<JSONObject> {
    static final String HEADER_APPLICATION_ID = "X-Parse-Application-Id";
    static final String HEADER_APP_BUILD_VERSION = "X-Parse-App-Build-Version";
    static final String HEADER_APP_DISPLAY_VERSION = "X-Parse-App-Display-Version";
    static final String HEADER_CLIENT_KEY = "X-Parse-Client-Key";
    static final String HEADER_INSTALLATION_ID = "X-Parse-Installation-Id";
    private static final String HEADER_MASTER_KEY = "X-Parse-Master-Key";
    static final String HEADER_OS_VERSION = "X-Parse-OS-Version";
    private static final String HEADER_SESSION_TOKEN = "X-Parse-Session-Token";
    private static final String PARAMETER_METHOD_OVERRIDE = "_method";
    static final String USER_AGENT = "User-Agent";
    static URL server;
    String httpPath;
    private String installationId;
    final JSONObject jsonParameters;
    private String localId;
    public String masterKey;
    private String operationSetUUID;
    private final String sessionToken;

    public static class Builder extends Init<Builder> {
        public ParseRESTCommand build() {
            return new ParseRESTCommand(this);
        }

        /* access modifiers changed from: package-private */
        public Builder self() {
            return this;
        }
    }

    static abstract class Init<T extends Init<T>> {
        /* access modifiers changed from: private */
        public String httpPath;
        /* access modifiers changed from: private */
        public String installationId;
        /* access modifiers changed from: private */
        public JSONObject jsonParameters;
        /* access modifiers changed from: private */
        public String localId;
        public String masterKey;
        /* access modifiers changed from: private */
        public ParseHttpRequest.Method method = ParseHttpRequest.Method.GET;
        /* access modifiers changed from: private */
        public String operationSetUUID;
        /* access modifiers changed from: private */
        public String sessionToken;

        Init() {
        }

        public T httpPath(String str) {
            this.httpPath = str;
            return self();
        }

        public T installationId(String str) {
            this.installationId = str;
            return self();
        }

        public T jsonParameters(JSONObject jSONObject) {
            this.jsonParameters = jSONObject;
            return self();
        }

        public T localId(String str) {
            this.localId = str;
            return self();
        }

        public T masterKey(String str) {
            this.masterKey = str;
            return self();
        }

        public T method(ParseHttpRequest.Method method2) {
            this.method = method2;
            return self();
        }

        public T operationSetUUID(String str) {
            this.operationSetUUID = str;
            return self();
        }

        /* access modifiers changed from: package-private */
        public abstract T self();

        public T sessionToken(String str) {
            this.sessionToken = str;
            return self();
        }
    }

    ParseRESTCommand(Init<?> init) {
        super(init.method, createUrl(init.httpPath));
        this.sessionToken = init.sessionToken;
        this.installationId = init.installationId;
        this.masterKey = init.masterKey;
        this.httpPath = init.httpPath;
        this.jsonParameters = init.jsonParameters;
        this.operationSetUUID = init.operationSetUUID;
        this.localId = init.localId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ParseRESTCommand(String str, ParseHttpRequest.Method method, Map<String, ?> map, String str2) {
        this(str, method, map != null ? (JSONObject) NoObjectsEncoder.get().encode(map) : null, str2);
    }

    public ParseRESTCommand(String str, ParseHttpRequest.Method method, JSONObject jSONObject, String str2) {
        this(str, method, jSONObject, (String) null, str2);
    }

    private ParseRESTCommand(String str, ParseHttpRequest.Method method, JSONObject jSONObject, String str2, String str3) {
        super(method, createUrl(str));
        this.httpPath = str;
        this.jsonParameters = jSONObject;
        this.localId = str2;
        this.sessionToken = str3;
    }

    private static void addToStringer(JSONStringer jSONStringer, Object obj) {
        if (obj instanceof JSONObject) {
            jSONStringer.object();
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            ArrayList arrayList = new ArrayList();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            Collections.sort(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                jSONStringer.key(str);
                addToStringer(jSONStringer, jSONObject.opt(str));
            }
            jSONStringer.endObject();
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            jSONStringer.array();
            for (int i = 0; i < jSONArray.length(); i++) {
                addToStringer(jSONStringer, jSONArray.get(i));
            }
            jSONStringer.endArray();
        } else {
            jSONStringer.value(obj);
        }
    }

    private static String createUrl(String str) {
        if (str == null) {
            return server.toString();
        }
        try {
            return new URL(server, str).toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ParseRESTCommand fromJSONObject(JSONObject jSONObject) {
        String optString = jSONObject.optString("httpPath");
        ParseHttpRequest.Method fromString = ParseHttpRequest.Method.fromString(jSONObject.optString("httpMethod"));
        String optString2 = jSONObject.optString("sessionToken", (String) null);
        return new ParseRESTCommand(optString, fromString, jSONObject.optJSONObject("parameters"), jSONObject.optString("localId", (String) null), optString2);
    }

    private static LocalIdManager getLocalIdManager() {
        return ParseCorePlugins.getInstance().getLocalIdManager();
    }

    protected static void getLocalPointersIn(Object obj, ArrayList<JSONObject> arrayList) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (!"Pointer".equals(jSONObject.opt("__type")) || !jSONObject.has("localId")) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    getLocalPointersIn(jSONObject.get(keys.next()), arrayList);
                }
            } else {
                arrayList.add(jSONObject);
                return;
            }
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.length(); i++) {
                getLocalPointersIn(jSONArray.get(i), arrayList);
            }
        }
    }

    static boolean isValidCommandJSONObject(JSONObject jSONObject) {
        return jSONObject.has("httpPath");
    }

    static boolean isValidOldFormatCommandJSONObject(JSONObject jSONObject) {
        return jSONObject.has("op");
    }

    private void maybeChangeServerOperation() {
        String objectId;
        if (this.localId != null && (objectId = getLocalIdManager().getObjectId(this.localId)) != null) {
            this.localId = null;
            this.httpPath += String.format("/%s", new Object[]{objectId});
            this.url = createUrl(this.httpPath);
            if (this.httpPath.startsWith("classes") && this.method == ParseHttpRequest.Method.POST) {
                this.method = ParseHttpRequest.Method.PUT;
            }
        }
    }

    static String toDeterministicString(Object obj) {
        JSONStringer jSONStringer = new JSONStringer();
        addToStringer(jSONStringer, obj);
        return jSONStringer.toString();
    }

    /* access modifiers changed from: protected */
    public void addAdditionalHeaders(ParseHttpRequest.Builder builder) {
        String str = this.installationId;
        if (str != null) {
            builder.addHeader(HEADER_INSTALLATION_ID, str);
        }
        String str2 = this.sessionToken;
        if (str2 != null) {
            builder.addHeader(HEADER_SESSION_TOKEN, str2);
        }
        String str3 = this.masterKey;
        if (str3 != null) {
            builder.addHeader(HEADER_MASTER_KEY, str3);
        }
    }

    public Task<JSONObject> executeAsync(ParseHttpClient parseHttpClient, ProgressCallback progressCallback, ProgressCallback progressCallback2, Task<Void> task) {
        resolveLocalIds();
        return super.executeAsync(parseHttpClient, progressCallback, progressCallback2, task);
    }

    public String getCacheKey() {
        String str;
        JSONObject jSONObject = this.jsonParameters;
        if (jSONObject != null) {
            try {
                str = toDeterministicString(jSONObject);
            } catch (JSONException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            str = "";
        }
        if (this.sessionToken != null) {
            str = str + this.sessionToken;
        }
        return String.format("ParseRESTCommand.%s.%s.%s", new Object[]{this.method.toString(), ParseDigestUtils.md5(this.httpPath), ParseDigestUtils.md5(str)});
    }

    public String getLocalId() {
        return this.localId;
    }

    public String getOperationSetUUID() {
        return this.operationSetUUID;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    /* access modifiers changed from: protected */
    public ParseHttpBody newBody(ProgressCallback progressCallback) {
        JSONObject jSONObject = this.jsonParameters;
        if (jSONObject != null) {
            try {
                if (this.method == ParseHttpRequest.Method.GET || this.method == ParseHttpRequest.Method.DELETE) {
                    jSONObject = new JSONObject(this.jsonParameters.toString());
                    jSONObject.put(PARAMETER_METHOD_OVERRIDE, this.method.toString());
                }
                return new ParseByteArrayHttpBody(jSONObject.toString(), AbstractSpiCall.ACCEPT_JSON_VALUE);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new IllegalArgumentException(String.format("Trying to execute a %s command without body parameters.", new Object[]{this.method.toString()}));
        }
    }

    /* access modifiers changed from: protected */
    public ParseHttpRequest newRequest(ParseHttpRequest.Method method, String str, ProgressCallback progressCallback) {
        if (!(this.jsonParameters == null || method == ParseHttpRequest.Method.POST || method == ParseHttpRequest.Method.PUT)) {
            method = ParseHttpRequest.Method.POST;
        }
        ParseHttpRequest.Builder builder = new ParseHttpRequest.Builder(super.newRequest(method, str, progressCallback));
        addAdditionalHeaders(builder);
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public Task<JSONObject> onResponseAsync(ParseHttpResponse parseHttpResponse, ProgressCallback progressCallback) {
        ParseException newPermanentException;
        InputStream inputStream = null;
        try {
            inputStream = parseHttpResponse.getContent();
            String str = new String(ParseIOUtils.toByteArray(inputStream));
            ParseIOUtils.closeQuietly(inputStream);
            int statusCode = parseHttpResponse.getStatusCode();
            if (statusCode < 200 || statusCode >= 600) {
                newPermanentException = newPermanentException(-1, str);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return (statusCode < 400 || statusCode >= 500) ? statusCode >= 500 ? Task.forError(newTemporaryException(jSONObject.optInt("code"), jSONObject.optString("error"))) : Task.forResult(jSONObject) : Task.forError(newPermanentException(jSONObject.optInt("code"), jSONObject.optString("error")));
                } catch (JSONException e) {
                    newPermanentException = newTemporaryException("bad json response", (Throwable) e);
                }
            }
            return Task.forError(newPermanentException);
        } catch (IOException e2) {
            Task<JSONObject> forError = Task.forError(e2);
            ParseIOUtils.closeQuietly(inputStream);
            return forError;
        } catch (Throwable th) {
            ParseIOUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    public void releaseLocalIds() {
        if (this.localId != null) {
            getLocalIdManager().releaseLocalIdOnDisk(this.localId);
        }
        try {
            ArrayList arrayList = new ArrayList();
            getLocalPointersIn(this.jsonParameters, arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                getLocalIdManager().releaseLocalIdOnDisk((String) ((JSONObject) it.next()).get("localId"));
            }
        } catch (JSONException unused) {
        }
    }

    public void resolveLocalIds() {
        try {
            ArrayList arrayList = new ArrayList();
            getLocalPointersIn(this.jsonParameters, arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = (JSONObject) it.next();
                String objectId = getLocalIdManager().getObjectId((String) jSONObject.get("localId"));
                if (objectId != null) {
                    jSONObject.put(ParseObject.KEY_OBJECT_ID, objectId);
                    jSONObject.remove("localId");
                } else {
                    throw new IllegalStateException("Tried to serialize a command referencing a new, unsaved object.");
                }
            }
            maybeChangeServerOperation();
        } catch (JSONException unused) {
        }
    }

    public void retainLocalIds() {
        if (this.localId != null) {
            getLocalIdManager().retainLocalIdOnDisk(this.localId);
        }
        try {
            ArrayList arrayList = new ArrayList();
            getLocalPointersIn(this.jsonParameters, arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                getLocalIdManager().retainLocalIdOnDisk((String) ((JSONObject) it.next()).get("localId"));
            }
        } catch (JSONException unused) {
        }
    }

    public void setLocalId(String str) {
        this.localId = str;
    }

    /* access modifiers changed from: package-private */
    public void setOperationSetUUID(String str) {
        this.operationSetUUID = str;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.httpPath != null) {
                jSONObject.put("httpPath", this.httpPath);
            }
            jSONObject.put("httpMethod", this.method.toString());
            if (this.jsonParameters != null) {
                jSONObject.put("parameters", this.jsonParameters);
            }
            if (this.sessionToken != null) {
                jSONObject.put("sessionToken", this.sessionToken);
            }
            if (this.localId != null) {
                jSONObject.put("localId", this.localId);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
