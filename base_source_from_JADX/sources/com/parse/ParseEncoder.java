package com.parse;

import android.util.Base64;
import com.parse.ParseQuery;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ParseEncoder {
    static boolean isValidType(Object obj) {
        return (obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Date) || (obj instanceof List) || (obj instanceof Map) || (obj instanceof byte[]) || obj == JSONObject.NULL || (obj instanceof ParseObject) || (obj instanceof ParseACL) || (obj instanceof ParseFile) || (obj instanceof ParseGeoPoint) || (obj instanceof ParsePolygon) || (obj instanceof ParseRelation);
    }

    public Object encode(Object obj) {
        try {
            if (obj instanceof ParseObject) {
                return encodeRelatedObject((ParseObject) obj);
            }
            if (obj instanceof ParseQuery.State.Builder) {
                return encode(((ParseQuery.State.Builder) obj).build());
            }
            if (obj instanceof ParseQuery.State) {
                return ((ParseQuery.State) obj).toJSON(this);
            }
            if (obj instanceof Date) {
                return encodeDate((Date) obj);
            }
            if (obj instanceof byte[]) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("__type", "Bytes");
                jSONObject.put("base64", Base64.encodeToString((byte[]) obj, 2));
                return jSONObject;
            } else if (obj instanceof ParseFile) {
                return ((ParseFile) obj).encode();
            } else {
                if (obj instanceof ParseGeoPoint) {
                    ParseGeoPoint parseGeoPoint = (ParseGeoPoint) obj;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("__type", "GeoPoint");
                    jSONObject2.put("latitude", parseGeoPoint.getLatitude());
                    jSONObject2.put("longitude", parseGeoPoint.getLongitude());
                    return jSONObject2;
                } else if (obj instanceof ParsePolygon) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("__type", "Polygon");
                    jSONObject3.put("coordinates", ((ParsePolygon) obj).coordinatesToJSONArray());
                    return jSONObject3;
                } else if (obj instanceof ParseACL) {
                    return ((ParseACL) obj).toJSONObject(this);
                } else {
                    if (obj instanceof Map) {
                        JSONObject jSONObject4 = new JSONObject();
                        for (Map.Entry entry : ((Map) obj).entrySet()) {
                            jSONObject4.put((String) entry.getKey(), encode(entry.getValue()));
                        }
                        return jSONObject4;
                    } else if (obj instanceof Collection) {
                        JSONArray jSONArray = new JSONArray();
                        for (Object encode : (Collection) obj) {
                            jSONArray.put(encode(encode));
                        }
                        return jSONArray;
                    } else if (obj instanceof ParseRelation) {
                        return ((ParseRelation) obj).encodeToJSON(this);
                    } else {
                        if (obj instanceof ParseFieldOperation) {
                            return ((ParseFieldOperation) obj).encode(this);
                        }
                        if (obj instanceof ParseQuery.RelationConstraint) {
                            return ((ParseQuery.RelationConstraint) obj).encode(this);
                        }
                        if (obj == null) {
                            return JSONObject.NULL;
                        }
                        if (isValidType(obj)) {
                            return obj;
                        }
                        throw new IllegalArgumentException("invalid type for ParseObject: " + obj.getClass().toString());
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject encodeDate(Date date) {
        JSONObject jSONObject = new JSONObject();
        String format = ParseDateFormat.getInstance().format(date);
        try {
            jSONObject.put("__type", "Date");
            jSONObject.put("iso", format);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract JSONObject encodeRelatedObject(ParseObject parseObject);
}
