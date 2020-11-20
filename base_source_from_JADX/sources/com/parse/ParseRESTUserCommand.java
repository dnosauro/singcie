package com.parse;

import bolts.Task;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRESTUserCommand extends ParseRESTCommand {
    private static final String HEADER_REVOCABLE_SESSION = "X-Parse-Revocable-Session";
    private static final String HEADER_TRUE = "1";
    private boolean isRevocableSessionEnabled;
    private int statusCode;

    private ParseRESTUserCommand(String str, ParseHttpRequest.Method method, Map<String, ?> map, String str2) {
        this(str, method, map, str2, false);
    }

    private ParseRESTUserCommand(String str, ParseHttpRequest.Method method, Map<String, ?> map, String str2, boolean z) {
        super(str, method, map, str2);
        this.isRevocableSessionEnabled = z;
    }

    private ParseRESTUserCommand(String str, ParseHttpRequest.Method method, JSONObject jSONObject, String str2, boolean z) {
        super(str, method, jSONObject, str2);
        this.isRevocableSessionEnabled = z;
    }

    public static ParseRESTUserCommand getCurrentUserCommand(String str) {
        return new ParseRESTUserCommand("users/me", ParseHttpRequest.Method.GET, (Map<String, ?>) null, str);
    }

    public static ParseRESTUserCommand logInUserCommand(String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("username", str);
        hashMap.put("password", str2);
        return new ParseRESTUserCommand(FirebaseAnalytics.Event.LOGIN, ParseHttpRequest.Method.GET, (Map<String, ?>) hashMap, (String) null, z);
    }

    public static ParseRESTUserCommand resetPasswordResetCommand(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Scopes.EMAIL, str);
        return new ParseRESTUserCommand("requestPasswordReset", ParseHttpRequest.Method.POST, hashMap, (String) null);
    }

    public static ParseRESTUserCommand serviceLogInUserCommand(String str, Map<String, String> map, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, PointerEncoder.get().encode(map));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("authData", jSONObject);
            return serviceLogInUserCommand(jSONObject2, (String) null, z);
        } catch (JSONException unused) {
            throw new RuntimeException("could not serialize object to JSON");
        }
    }

    public static ParseRESTUserCommand serviceLogInUserCommand(JSONObject jSONObject, String str, boolean z) {
        return new ParseRESTUserCommand("users", ParseHttpRequest.Method.POST, jSONObject, str, z);
    }

    public static ParseRESTUserCommand signUpUserCommand(JSONObject jSONObject, String str, boolean z) {
        return new ParseRESTUserCommand("users", ParseHttpRequest.Method.POST, jSONObject, str, z);
    }

    /* access modifiers changed from: protected */
    public void addAdditionalHeaders(ParseHttpRequest.Builder builder) {
        super.addAdditionalHeaders(builder);
        if (this.isRevocableSessionEnabled) {
            builder.addHeader(HEADER_REVOCABLE_SESSION, HEADER_TRUE);
        }
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    /* access modifiers changed from: protected */
    public Task<JSONObject> onResponseAsync(ParseHttpResponse parseHttpResponse, ProgressCallback progressCallback) {
        this.statusCode = parseHttpResponse.getStatusCode();
        return super.onResponseAsync(parseHttpResponse, progressCallback);
    }
}
