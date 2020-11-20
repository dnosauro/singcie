package com.parse;

import com.parse.http.ParseHttpRequest;
import org.json.JSONObject;

class ParseRESTPushCommand extends ParseRESTCommand {
    static final String KEY_CHANNELS = "channels";
    static final String KEY_DATA = "data";
    static final String KEY_DEVICE_TYPE = "deviceType";
    static final String KEY_EXPIRATION_INTERVAL = "expiration_interval";
    static final String KEY_EXPIRATION_TIME = "expiration_time";
    static final String KEY_PUSH_TIME = "push_time";
    static final String KEY_WHERE = "where";

    public ParseRESTPushCommand(String str, ParseHttpRequest.Method method, JSONObject jSONObject, String str2) {
        super(str, method, jSONObject, str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.parse.ParseRESTPushCommand sendPushCommand(com.parse.ParseQuery.State<com.parse.ParseInstallation> r2, java.util.Set<java.lang.String> r3, java.lang.Long r4, java.lang.Long r5, java.lang.Long r6, org.json.JSONObject r7, java.lang.String r8) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r3 == 0) goto L_0x0014
            java.lang.String r2 = "channels"
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0012 }
            r1.<init>(r3)     // Catch:{ JSONException -> 0x0012 }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0012 }
            goto L_0x0032
        L_0x0012:
            r2 = move-exception
            goto L_0x0059
        L_0x0014:
            r3 = 0
            if (r2 == 0) goto L_0x0026
            com.parse.ParseQuery$QueryConstraints r2 = r2.constraints()     // Catch:{ JSONException -> 0x0012 }
            com.parse.PointerEncoder r3 = com.parse.PointerEncoder.get()     // Catch:{ JSONException -> 0x0012 }
            java.lang.Object r2 = r3.encode(r2)     // Catch:{ JSONException -> 0x0012 }
            r3 = r2
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ JSONException -> 0x0012 }
        L_0x0026:
            if (r3 != 0) goto L_0x002d
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0012 }
            r3.<init>()     // Catch:{ JSONException -> 0x0012 }
        L_0x002d:
            java.lang.String r2 = "where"
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x0012 }
        L_0x0032:
            if (r4 == 0) goto L_0x003a
            java.lang.String r2 = "expiration_time"
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x0012 }
            goto L_0x0041
        L_0x003a:
            if (r5 == 0) goto L_0x0041
            java.lang.String r2 = "expiration_interval"
            r0.put(r2, r5)     // Catch:{ JSONException -> 0x0012 }
        L_0x0041:
            if (r6 == 0) goto L_0x0048
            java.lang.String r2 = "push_time"
            r0.put(r2, r6)     // Catch:{ JSONException -> 0x0012 }
        L_0x0048:
            if (r7 == 0) goto L_0x004f
            java.lang.String r2 = "data"
            r0.put(r2, r7)     // Catch:{ JSONException -> 0x0012 }
        L_0x004f:
            com.parse.ParseRESTPushCommand r2 = new com.parse.ParseRESTPushCommand
            java.lang.String r3 = "push"
            com.parse.http.ParseHttpRequest$Method r4 = com.parse.http.ParseHttpRequest.Method.POST
            r2.<init>(r3, r4, r0, r8)
            return r2
        L_0x0059:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseRESTPushCommand.sendPushCommand(com.parse.ParseQuery$State, java.util.Set, java.lang.Long, java.lang.Long, java.lang.Long, org.json.JSONObject, java.lang.String):com.parse.ParseRESTPushCommand");
    }
}
