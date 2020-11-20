package com.parse;

import android.net.Uri;
import com.parse.ParseObject;
import com.parse.http.ParseHttpRequest;
import org.json.JSONObject;

class ParseRESTObjectCommand extends ParseRESTCommand {
    public ParseRESTObjectCommand(String str, ParseHttpRequest.Method method, JSONObject jSONObject, String str2) {
        super(str, method, jSONObject, str2);
    }

    private static ParseRESTObjectCommand createObjectCommand(String str, JSONObject jSONObject, String str2) {
        return new ParseRESTObjectCommand(String.format("classes/%s", new Object[]{Uri.encode(str)}), ParseHttpRequest.Method.POST, jSONObject, str2);
    }

    public static ParseRESTObjectCommand deleteObjectCommand(ParseObject.State state, String str) {
        String format = String.format("classes/%s", new Object[]{Uri.encode(state.className())});
        String objectId = state.objectId();
        if (objectId != null) {
            format = format + String.format("/%s", new Object[]{Uri.encode(objectId)});
        }
        return new ParseRESTObjectCommand(format, ParseHttpRequest.Method.DELETE, (JSONObject) null, str);
    }

    public static ParseRESTObjectCommand getObjectCommand(String str, String str2, String str3) {
        return new ParseRESTObjectCommand(String.format("classes/%s/%s", new Object[]{Uri.encode(str2), Uri.encode(str)}), ParseHttpRequest.Method.GET, (JSONObject) null, str3);
    }

    public static ParseRESTObjectCommand saveObjectCommand(ParseObject.State state, JSONObject jSONObject, String str) {
        return state.objectId() == null ? createObjectCommand(state.className(), jSONObject, str) : updateObjectCommand(state.objectId(), state.className(), jSONObject, str);
    }

    private static ParseRESTObjectCommand updateObjectCommand(String str, String str2, JSONObject jSONObject, String str3) {
        return new ParseRESTObjectCommand(String.format("classes/%s/%s", new Object[]{Uri.encode(str2), Uri.encode(str)}), ParseHttpRequest.Method.PUT, jSONObject, str3);
    }
}
