package com.parse;

import com.parse.ParseQuery;
import com.parse.http.ParseHttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

class ParseRESTQueryCommand extends ParseRESTCommand {
    static final String KEY_COUNT = "count";
    static final String KEY_INCLUDE = "include";
    static final String KEY_KEYS = "keys";
    static final String KEY_LIMIT = "limit";
    static final String KEY_ORDER = "order";
    static final String KEY_SKIP = "skip";
    static final String KEY_TRACE = "trace";
    static final String KEY_WHERE = "where";

    private ParseRESTQueryCommand(String str, ParseHttpRequest.Method method, Map<String, ?> map, String str2) {
        super(str, method, map, str2);
    }

    public static <T extends ParseObject> ParseRESTQueryCommand countCommand(ParseQuery.State<T> state, String str) {
        return new ParseRESTQueryCommand(String.format("classes/%s", new Object[]{state.className()}), ParseHttpRequest.Method.GET, encode(state, true), str);
    }

    static <T extends ParseObject> Map<String, String> encode(ParseQuery.State<T> state, boolean z) {
        PointerEncoder pointerEncoder = PointerEncoder.get();
        HashMap hashMap = new HashMap();
        List<String> order = state.order();
        if (!order.isEmpty()) {
            hashMap.put(KEY_ORDER, ParseTextUtils.join(",", order));
        }
        ParseQuery.QueryConstraints constraints = state.constraints();
        if (!constraints.isEmpty()) {
            hashMap.put(KEY_WHERE, ((JSONObject) pointerEncoder.encode(constraints)).toString());
        }
        Set<String> selectedKeys = state.selectedKeys();
        if (selectedKeys != null) {
            hashMap.put(KEY_KEYS, ParseTextUtils.join(",", selectedKeys));
        }
        Set<String> includes = state.includes();
        if (!includes.isEmpty()) {
            hashMap.put(KEY_INCLUDE, ParseTextUtils.join(",", includes));
        }
        int limit = state.limit();
        if (limit >= 0) {
            hashMap.put(KEY_LIMIT, Integer.toString(limit));
        }
        if (z) {
            hashMap.put(KEY_COUNT, Integer.toString(1));
        } else {
            int skip = state.skip();
            if (skip > 0) {
                hashMap.put(KEY_SKIP, Integer.toString(skip));
            }
        }
        for (Map.Entry next : state.extraOptions().entrySet()) {
            hashMap.put(next.getKey(), pointerEncoder.encode(next.getValue()).toString());
        }
        if (state.isTracingEnabled()) {
            hashMap.put(KEY_TRACE, Integer.toString(1));
        }
        return hashMap;
    }

    public static <T extends ParseObject> ParseRESTQueryCommand findCommand(ParseQuery.State<T> state, String str) {
        return new ParseRESTQueryCommand(String.format("classes/%s", new Object[]{state.className()}), ParseHttpRequest.Method.GET, encode(state, false), str);
    }
}
