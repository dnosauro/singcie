package com.parse;

import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseDecoder {
    private static final ParseDecoder INSTANCE = new ParseDecoder();

    protected ParseDecoder() {
    }

    public static ParseDecoder get() {
        return INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public List<Object> convertJSONArrayToList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(decode(jSONArray.opt(i)));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> convertJSONObjectToMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, decode(jSONObject.opt(next)));
        }
        return hashMap;
    }

    public Object decode(Object obj) {
        if (obj instanceof JSONArray) {
            return convertJSONArrayToList((JSONArray) obj);
        }
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return obj;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optString("__op", (String) null) != null) {
            try {
                return ParseFieldOperations.decode(jSONObject, this);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            String optString = jSONObject.optString("__type", (String) null);
            if (optString == null) {
                return convertJSONObjectToMap(jSONObject);
            }
            if (optString.equals("Date")) {
                return ParseDateFormat.getInstance().parse(jSONObject.optString("iso"));
            } else if (optString.equals("Bytes")) {
                return Base64.decode(jSONObject.optString("base64"), 2);
            } else {
                if (optString.equals("Pointer")) {
                    return decodePointer(jSONObject.optString("className"), jSONObject.optString(ParseObject.KEY_OBJECT_ID));
                }
                if (optString.equals("File")) {
                    return new ParseFile(jSONObject, this);
                }
                if (optString.equals("GeoPoint")) {
                    try {
                        return new ParseGeoPoint(jSONObject.getDouble("latitude"), jSONObject.getDouble("longitude"));
                    } catch (JSONException e2) {
                        throw new RuntimeException(e2);
                    }
                } else if (optString.equals("Polygon")) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("coordinates");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                            arrayList.add(new ParseGeoPoint(jSONArray2.getDouble(0), jSONArray2.getDouble(1)));
                        }
                        return new ParsePolygon((List<ParseGeoPoint>) arrayList);
                    } catch (JSONException e3) {
                        throw new RuntimeException(e3);
                    }
                } else if (optString.equals("Object")) {
                    return ParseObject.fromJSON(jSONObject, (String) null, this);
                } else {
                    if (optString.equals("Relation")) {
                        return new ParseRelation(jSONObject, this);
                    }
                    if (!optString.equals("OfflineObject")) {
                        return null;
                    }
                    throw new RuntimeException("An unexpected offline pointer was encountered.");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ParseObject decodePointer(String str, String str2) {
        return ParseObject.createWithoutData(str, str2);
    }
}
