package com.parse;

import com.parse.ParseObject;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseObjectCurrentCoder extends ParseObjectCoder {
    private static final ParseObjectCurrentCoder INSTANCE = new ParseObjectCurrentCoder();
    private static final String KEY_ACL = "ACL";
    private static final String KEY_CLASS_NAME = "classname";
    private static final String KEY_CREATED_AT = "createdAt";
    private static final String KEY_DATA = "data";
    private static final String KEY_OBJECT_ID = "objectId";
    private static final String KEY_OLD_CREATED_AT = "created_at";
    private static final String KEY_OLD_OBJECT_ID = "id";
    private static final String KEY_OLD_POINTERS = "pointers";
    private static final String KEY_OLD_UPDATED_AT = "updated_at";
    private static final String KEY_UPDATED_AT = "updatedAt";

    ParseObjectCurrentCoder() {
    }

    public static ParseObjectCurrentCoder get() {
        return INSTANCE;
    }

    public <T extends ParseObject.State.Init<?>> T decode(T t, JSONObject jSONObject, ParseDecoder parseDecoder) {
        String string;
        String string2;
        try {
            if (jSONObject.has(KEY_OLD_OBJECT_ID)) {
                t.objectId(jSONObject.getString(KEY_OLD_OBJECT_ID));
            }
            if (jSONObject.has(KEY_OLD_CREATED_AT) && (string2 = jSONObject.getString(KEY_OLD_CREATED_AT)) != null) {
                t.createdAt(ParseImpreciseDateFormat.getInstance().parse(string2));
            }
            if (jSONObject.has(KEY_OLD_UPDATED_AT) && (string = jSONObject.getString(KEY_OLD_UPDATED_AT)) != null) {
                t.updatedAt(ParseImpreciseDateFormat.getInstance().parse(string));
            }
            if (jSONObject.has(KEY_OLD_POINTERS)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(KEY_OLD_POINTERS);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject2.getJSONArray(next);
                    t.put(next, ParseObject.createWithoutData(jSONArray.optString(0), jSONArray.optString(1)));
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(KEY_DATA);
            if (optJSONObject != null) {
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    char c = 65535;
                    int hashCode = next2.hashCode();
                    if (hashCode != -1949194674) {
                        if (hashCode != 64618) {
                            if (hashCode != 90495162) {
                                if (hashCode == 598371643) {
                                    if (next2.equals("createdAt")) {
                                        c = 1;
                                    }
                                }
                            } else if (next2.equals("objectId")) {
                                c = 0;
                            }
                        } else if (next2.equals(KEY_ACL)) {
                            c = 3;
                        }
                    } else if (next2.equals("updatedAt")) {
                        c = 2;
                    }
                    switch (c) {
                        case 0:
                            t.objectId(optJSONObject.getString(next2));
                            break;
                        case 1:
                            t.createdAt(ParseDateFormat.getInstance().parse(optJSONObject.getString(next2)));
                            break;
                        case 2:
                            t.updatedAt(ParseDateFormat.getInstance().parse(optJSONObject.getString(next2)));
                            break;
                        case 3:
                            t.put(KEY_ACL, ParseACL.createACLFromJSONObject(optJSONObject.getJSONObject(next2), parseDecoder));
                            break;
                        default:
                            t.put(next2, parseDecoder.decode(optJSONObject.get(next2)));
                            break;
                    }
                }
            }
            return t;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends ParseObject.State> JSONObject encode(T t, ParseOperationSet parseOperationSet, ParseEncoder parseEncoder) {
        if (parseOperationSet == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (String next : t.keySet()) {
                    jSONObject2.put(next, parseEncoder.encode(t.get(next)));
                }
                if (t.createdAt() > 0) {
                    jSONObject2.put("createdAt", ParseDateFormat.getInstance().format(new Date(t.createdAt())));
                }
                if (t.updatedAt() > 0) {
                    jSONObject2.put("updatedAt", ParseDateFormat.getInstance().format(new Date(t.updatedAt())));
                }
                if (t.objectId() != null) {
                    jSONObject2.put("objectId", t.objectId());
                }
                jSONObject.put(KEY_DATA, jSONObject2);
                jSONObject.put(KEY_CLASS_NAME, t.className());
                return jSONObject;
            } catch (JSONException unused) {
                throw new RuntimeException("could not serialize object to JSON");
            }
        } else {
            throw new IllegalArgumentException("Parameter ParseOperationSet is not null");
        }
    }
}
