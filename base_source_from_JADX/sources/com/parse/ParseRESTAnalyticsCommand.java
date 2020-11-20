package com.parse;

import android.net.Uri;
import com.parse.http.ParseHttpRequest;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRESTAnalyticsCommand extends ParseRESTCommand {
    static final String EVENT_APP_OPENED = "AppOpened";
    private static final String KEY_AT = "at";
    private static final String KEY_DIMENSIONS = "dimensions";
    private static final String KEY_PUSH_HASH = "push_hash";
    private static final String PATH = "events/%s";

    public ParseRESTAnalyticsCommand(String str, ParseHttpRequest.Method method, JSONObject jSONObject, String str2) {
        super(str, method, jSONObject, str2);
    }

    public static ParseRESTAnalyticsCommand trackAppOpenedCommand(String str, String str2) {
        return trackEventCommand(EVENT_APP_OPENED, str, (Map<String, String>) null, str2);
    }

    static ParseRESTAnalyticsCommand trackEventCommand(String str, String str2, Map<String, String> map, String str3) {
        String format = String.format(PATH, new Object[]{Uri.encode(str)});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_AT, NoObjectsEncoder.get().encode(new Date()));
            if (str2 != null) {
                jSONObject.put(KEY_PUSH_HASH, str2);
            }
            if (map != null) {
                jSONObject.put(KEY_DIMENSIONS, NoObjectsEncoder.get().encode(map));
            }
            return new ParseRESTAnalyticsCommand(format, ParseHttpRequest.Method.POST, jSONObject, str3);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static ParseRESTAnalyticsCommand trackEventCommand(String str, Map<String, String> map, String str2) {
        return trackEventCommand(str, (String) null, map, str2);
    }
}
