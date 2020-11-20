package com.parse;

import com.parse.ParseObject;
import com.parse.ParseUser;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ParseUserCurrentCoder extends ParseObjectCurrentCoder {
    private static final ParseUserCurrentCoder INSTANCE = new ParseUserCurrentCoder();
    private static final String KEY_AUTH_DATA = "auth_data";
    private static final String KEY_SESSION_TOKEN = "session_token";

    ParseUserCurrentCoder() {
    }

    public static ParseUserCurrentCoder get() {
        return INSTANCE;
    }

    public <T extends ParseObject.State.Init<?>> T decode(T t, JSONObject jSONObject, ParseDecoder parseDecoder) {
        T t2 = (ParseUser.State.Builder) super.decode(t, jSONObject, parseDecoder);
        t2.sessionToken(jSONObject.optString(KEY_SESSION_TOKEN, (String) null));
        JSONObject optJSONObject = jSONObject.optJSONObject(KEY_AUTH_DATA);
        if (optJSONObject == null) {
            t2.authData((Map<String, Map<String, String>>) null);
        } else {
            try {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!optJSONObject.isNull(next)) {
                        t2.putAuthData(next, (Map) ParseDecoder.get().decode(optJSONObject.getJSONObject(next)));
                    }
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return t2;
    }

    public <T extends ParseObject.State> JSONObject encode(T t, ParseOperationSet parseOperationSet, ParseEncoder parseEncoder) {
        JSONObject encode = super.encode(t, parseOperationSet, parseEncoder);
        ParseUser.State state = (ParseUser.State) t;
        String sessionToken = state.sessionToken();
        if (sessionToken != null) {
            try {
                encode.put(KEY_SESSION_TOKEN, sessionToken);
            } catch (JSONException unused) {
                throw new RuntimeException("could not encode value for key: session_token");
            }
        }
        Map<String, Map<String, String>> authData = state.authData();
        if (authData.size() > 0) {
            try {
                encode.put(KEY_AUTH_DATA, parseEncoder.encode(authData));
            } catch (JSONException unused2) {
                throw new RuntimeException("could not attach key: auth_data");
            }
        }
        return encode;
    }
}
