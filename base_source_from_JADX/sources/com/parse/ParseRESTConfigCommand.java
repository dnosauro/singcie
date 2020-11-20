package com.parse;

import com.parse.http.ParseHttpRequest;
import java.util.HashMap;
import java.util.Map;

class ParseRESTConfigCommand extends ParseRESTCommand {
    public ParseRESTConfigCommand(String str, ParseHttpRequest.Method method, Map<String, ?> map, String str2) {
        super(str, method, map, str2);
    }

    public static ParseRESTConfigCommand fetchConfigCommand(String str) {
        return new ParseRESTConfigCommand("config", ParseHttpRequest.Method.GET, (Map<String, ?>) null, str);
    }

    public static ParseRESTConfigCommand updateConfigCommand(Map<String, ?> map, String str) {
        HashMap hashMap;
        if (map != null) {
            hashMap = new HashMap();
            hashMap.put("params", map);
        } else {
            hashMap = null;
        }
        return new ParseRESTConfigCommand("config", ParseHttpRequest.Method.PUT, hashMap, str);
    }
}
