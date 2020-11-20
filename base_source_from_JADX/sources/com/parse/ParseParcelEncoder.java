package com.parse;

import android.os.Parcel;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import org.json.JSONObject;

class ParseParcelEncoder {
    private static final ParseParcelEncoder INSTANCE = new ParseParcelEncoder();
    static final String TYPE_ACL = "Acl";
    static final String TYPE_BYTES = "Bytes";
    static final String TYPE_COLLECTION = "Collection";
    static final String TYPE_DATE = "Date";
    static final String TYPE_FILE = "File";
    static final String TYPE_GEOPOINT = "GeoPoint";
    static final String TYPE_JSON_NULL = "JsonNull";
    static final String TYPE_MAP = "Map";
    static final String TYPE_NATIVE = "Native";
    static final String TYPE_NULL = "Null";
    static final String TYPE_OBJECT = "Object";
    static final String TYPE_OP = "Operation";
    static final String TYPE_POINTER = "Pointer";
    static final String TYPE_POLYGON = "Polygon";
    static final String TYPE_RELATION = "Relation";

    ParseParcelEncoder() {
    }

    public static ParseParcelEncoder get() {
        return INSTANCE;
    }

    private static boolean isValidType(Object obj) {
        return ParseEncoder.isValidType(obj);
    }

    public void encode(Object obj, Parcel parcel) {
        String str;
        try {
            if (obj instanceof ParseObject) {
                encodeParseObject((ParseObject) obj, parcel);
                return;
            }
            if (obj instanceof Date) {
                parcel.writeString(TYPE_DATE);
                str = ParseDateFormat.getInstance().format((Date) obj);
            } else if (obj instanceof byte[]) {
                parcel.writeString(TYPE_BYTES);
                byte[] bArr = (byte[]) obj;
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(bArr);
                return;
            } else if (obj instanceof ParseFieldOperation) {
                parcel.writeString(TYPE_OP);
                ((ParseFieldOperation) obj).encode(parcel, this);
                return;
            } else if (obj instanceof ParseFile) {
                parcel.writeString(TYPE_FILE);
                ((ParseFile) obj).writeToParcel(parcel, this);
                return;
            } else if (obj instanceof ParseGeoPoint) {
                parcel.writeString(TYPE_GEOPOINT);
                ((ParseGeoPoint) obj).writeToParcel(parcel, this);
                return;
            } else if (obj instanceof ParsePolygon) {
                parcel.writeString(TYPE_POLYGON);
                ((ParsePolygon) obj).writeToParcel(parcel, this);
                return;
            } else if (obj instanceof ParseACL) {
                parcel.writeString(TYPE_ACL);
                ((ParseACL) obj).writeToParcel(parcel, this);
                return;
            } else if (obj instanceof ParseRelation) {
                parcel.writeString(TYPE_RELATION);
                ((ParseRelation) obj).writeToParcel(parcel, this);
                return;
            } else if (obj instanceof Map) {
                parcel.writeString(TYPE_MAP);
                Map map = (Map) obj;
                parcel.writeInt(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    parcel.writeString((String) entry.getKey());
                    encode(entry.getValue(), parcel);
                }
                return;
            } else if (obj instanceof Collection) {
                parcel.writeString(TYPE_COLLECTION);
                Collection<Object> collection = (Collection) obj;
                parcel.writeInt(collection.size());
                for (Object encode : collection) {
                    encode(encode, parcel);
                }
                return;
            } else if (obj == JSONObject.NULL) {
                str = TYPE_JSON_NULL;
            } else if (obj == null) {
                str = TYPE_NULL;
            } else if (isValidType(obj)) {
                parcel.writeString(TYPE_NATIVE);
                parcel.writeValue(obj);
                return;
            } else {
                throw new IllegalArgumentException("Could not encode this object into Parcel. " + obj.getClass().toString());
            }
            parcel.writeString(str);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not encode this object into Parcel. " + obj.getClass().toString());
        }
    }

    /* access modifiers changed from: protected */
    public void encodeParseObject(ParseObject parseObject, Parcel parcel) {
        parcel.writeString(TYPE_OBJECT);
        parseObject.writeToParcel(parcel, this);
    }

    /* access modifiers changed from: protected */
    public void encodePointer(String str, String str2, Parcel parcel) {
        parcel.writeString(TYPE_POINTER);
        parcel.writeString(str);
        parcel.writeString(str2);
    }
}
