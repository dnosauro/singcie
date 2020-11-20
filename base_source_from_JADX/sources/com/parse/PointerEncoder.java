package com.parse;

import org.json.JSONObject;

public class PointerEncoder extends PointerOrLocalIdEncoder {
    private static final PointerEncoder INSTANCE = new PointerEncoder();

    public static PointerEncoder get() {
        return INSTANCE;
    }

    public JSONObject encodeRelatedObject(ParseObject parseObject) {
        if (parseObject.getObjectId() != null) {
            return super.encodeRelatedObject(parseObject);
        }
        throw new IllegalStateException("unable to encode an association with an unsaved ParseObject");
    }
}
