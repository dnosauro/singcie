package com.parse;

import com.parse.ParseObject;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class ParseObjectCoder {
    private static final ParseObjectCoder INSTANCE = new ParseObjectCoder();
    private static final String KEY_ACL = "ACL";
    private static final String KEY_CLASS_NAME = "className";
    private static final String KEY_CREATED_AT = "createdAt";
    private static final String KEY_OBJECT_ID = "objectId";
    private static final String KEY_UPDATED_AT = "updatedAt";

    ParseObjectCoder() {
    }

    public static ParseObjectCoder get() {
        return INSTANCE;
    }

    public <T extends ParseObject.State.Init<?>> T decode(T t, JSONObject jSONObject, ParseDecoder parseDecoder) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!next.equals("__type")) {
                    if (!next.equals(KEY_CLASS_NAME)) {
                        if (next.equals("objectId")) {
                            t.objectId(jSONObject.getString(next));
                        } else if (next.equals("createdAt")) {
                            t.createdAt(ParseDateFormat.getInstance().parse(jSONObject.getString(next)));
                        } else if (next.equals("updatedAt")) {
                            t.updatedAt(ParseDateFormat.getInstance().parse(jSONObject.getString(next)));
                        } else if (next.equals(KEY_ACL)) {
                            t.put(KEY_ACL, ParseACL.createACLFromJSONObject(jSONObject.getJSONObject(next), parseDecoder));
                        } else {
                            t.put(next, parseDecoder.decode(jSONObject.get(next)));
                        }
                    }
                }
            }
            return t;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends ParseObject.State> JSONObject encode(T t, ParseOperationSet parseOperationSet, ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : parseOperationSet.keySet()) {
                jSONObject.put(str, parseEncoder.encode((ParseFieldOperation) parseOperationSet.get(str)));
            }
            if (t.objectId() != null) {
                jSONObject.put("objectId", t.objectId());
            }
            return jSONObject;
        } catch (JSONException unused) {
            throw new RuntimeException("could not serialize object to JSON");
        }
    }
}
