package com.parse;

import android.os.Parcel;

class ParseSetOperation implements ParseFieldOperation {
    static final String OP_NAME = "Set";
    private final Object value;

    public ParseSetOperation(Object obj) {
        this.value = obj;
    }

    public Object apply(Object obj, String str) {
        return this.value;
    }

    public Object encode(ParseEncoder parseEncoder) {
        return parseEncoder.encode(this.value);
    }

    public void encode(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        parcel.writeString(OP_NAME);
        parseParcelEncoder.encode(this.value, parcel);
    }

    public Object getValue() {
        return this.value;
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parseFieldOperation) {
        return this;
    }
}
