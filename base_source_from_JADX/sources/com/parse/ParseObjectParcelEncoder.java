package com.parse;

import android.os.Parcel;
import java.util.HashSet;
import java.util.Set;

class ParseObjectParcelEncoder extends ParseParcelEncoder {
    private Set<String> ids = new HashSet();

    public ParseObjectParcelEncoder() {
    }

    public ParseObjectParcelEncoder(ParseObject parseObject) {
        this.ids.add(getObjectOrLocalId(parseObject));
    }

    private String getObjectOrLocalId(ParseObject parseObject) {
        return parseObject.getObjectId() != null ? parseObject.getObjectId() : parseObject.getOrCreateLocalId();
    }

    /* access modifiers changed from: protected */
    public void encodeParseObject(ParseObject parseObject, Parcel parcel) {
        String objectOrLocalId = getObjectOrLocalId(parseObject);
        if (this.ids.contains(objectOrLocalId)) {
            encodePointer(parseObject.getClassName(), objectOrLocalId, parcel);
            return;
        }
        this.ids.add(objectOrLocalId);
        super.encodeParseObject(parseObject, parcel);
    }
}
