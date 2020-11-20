package com.parse;

import android.os.Parcel;
import org.json.JSONObject;

class ParseDeleteOperation implements ParseFieldOperation {
    static final String OP_NAME = "Delete";
    private static final ParseDeleteOperation defaultInstance = new ParseDeleteOperation();

    private ParseDeleteOperation() {
    }

    public static ParseDeleteOperation getInstance() {
        return defaultInstance;
    }

    public Object apply(Object obj, String str) {
        return null;
    }

    public JSONObject encode(ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__op", OP_NAME);
        return jSONObject;
    }

    public void encode(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        parcel.writeString(OP_NAME);
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parseFieldOperation) {
        return this;
    }
}
