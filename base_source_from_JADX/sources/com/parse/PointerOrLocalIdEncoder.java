package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

public class PointerOrLocalIdEncoder extends ParseEncoder {
    private static final PointerOrLocalIdEncoder INSTANCE = new PointerOrLocalIdEncoder();

    public static PointerOrLocalIdEncoder get() {
        return INSTANCE;
    }

    public JSONObject encodeRelatedObject(ParseObject parseObject) {
        String str;
        String orCreateLocalId;
        JSONObject jSONObject = new JSONObject();
        try {
            if (parseObject.getObjectId() != null) {
                jSONObject.put("__type", "Pointer");
                jSONObject.put("className", parseObject.getClassName());
                str = ParseObject.KEY_OBJECT_ID;
                orCreateLocalId = parseObject.getObjectId();
            } else {
                jSONObject.put("__type", "Pointer");
                jSONObject.put("className", parseObject.getClassName());
                str = "localId";
                orCreateLocalId = parseObject.getOrCreateLocalId();
            }
            jSONObject.put(str, orCreateLocalId);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
