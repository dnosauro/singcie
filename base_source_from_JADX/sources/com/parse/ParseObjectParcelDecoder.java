package com.parse;

import android.os.Parcel;
import java.util.HashMap;
import java.util.Map;

class ParseObjectParcelDecoder extends ParseParcelDecoder {
    private Map<String, ParseObject> objects = new HashMap();

    private String getObjectOrLocalId(ParseObject parseObject) {
        return parseObject.getObjectId() != null ? parseObject.getObjectId() : parseObject.getOrCreateLocalId();
    }

    public void addKnownObject(ParseObject parseObject) {
        this.objects.put(getObjectOrLocalId(parseObject), parseObject);
    }

    /* access modifiers changed from: protected */
    public ParseObject decodePointer(Parcel parcel) {
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        if (this.objects.containsKey(readString2)) {
            return this.objects.get(readString2);
        }
        ParseObject createWithoutData = ParseObject.createWithoutData(readString, readString2);
        this.objects.put(readString2, createWithoutData);
        return createWithoutData;
    }
}
