package com.parse;

import com.parse.http.ParseHttpRequest;
import org.json.JSONObject;

class ParseRESTSessionCommand extends ParseRESTCommand {
    private ParseRESTSessionCommand(String str, ParseHttpRequest.Method method, JSONObject jSONObject, String str2) {
        super(str, method, jSONObject, str2);
    }

    public static ParseRESTSessionCommand getCurrentSessionCommand(String str) {
        return new ParseRESTSessionCommand("sessions/me", ParseHttpRequest.Method.GET, (JSONObject) null, str);
    }

    public static ParseRESTSessionCommand revoke(String str) {
        return new ParseRESTSessionCommand("logout", ParseHttpRequest.Method.POST, new JSONObject(), str);
    }

    public static ParseRESTSessionCommand upgradeToRevocableSessionCommand(String str) {
        return new ParseRESTSessionCommand("upgradeToRevocableSession", ParseHttpRequest.Method.POST, new JSONObject(), str);
    }
}
