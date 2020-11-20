package com.parse;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ParseJSONUtils {
    ParseJSONUtils() {
    }

    public static JSONObject create(JSONObject jSONObject, Collection<String> collection) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!collection.contains(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return jSONObject2;
    }

    public static int getInt(JSONObject jSONObject, List<String> list) {
        for (String str : list) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        throw new JSONException("No value for " + list);
    }

    public static Iterable<String> keys(final JSONObject jSONObject) {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return jSONObject.keys();
            }
        };
    }
}
