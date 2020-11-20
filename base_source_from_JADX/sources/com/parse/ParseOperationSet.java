package com.parse;

import android.os.Parcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

class ParseOperationSet extends HashMap<String, ParseFieldOperation> {
    private static final String REST_KEY_IS_SAVE_EVENTUALLY = "__isSaveEventually";
    private static final String REST_KEY_UUID = "__uuid";
    private static final long serialVersionUID = 1;
    private boolean isSaveEventually;
    private final String uuid;

    public ParseOperationSet() {
        this(UUID.randomUUID().toString());
    }

    public ParseOperationSet(ParseOperationSet parseOperationSet) {
        super(parseOperationSet);
        this.isSaveEventually = false;
        this.uuid = parseOperationSet.getUUID();
        this.isSaveEventually = parseOperationSet.isSaveEventually;
    }

    private ParseOperationSet(String str) {
        this.isSaveEventually = false;
        this.uuid = str;
    }

    static ParseOperationSet fromParcel(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
        ParseOperationSet parseOperationSet = new ParseOperationSet(parcel.readString());
        boolean z = true;
        if (parcel.readByte() != 1) {
            z = false;
        }
        parseOperationSet.setIsSaveEventually(z);
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            parseOperationSet.put(parcel.readString(), (ParseFieldOperation) parseParcelDecoder.decode(parcel));
        }
        return parseOperationSet;
    }

    public static ParseOperationSet fromRest(JSONObject jSONObject, ParseDecoder parseDecoder) {
        Iterator<String> keys = jSONObject.keys();
        String[] strArr = new String[jSONObject.length()];
        int i = 0;
        while (keys.hasNext()) {
            strArr[i] = keys.next();
            i++;
        }
        JSONObject jSONObject2 = new JSONObject(jSONObject, strArr);
        String str = (String) jSONObject2.remove(REST_KEY_UUID);
        ParseOperationSet parseOperationSet = str == null ? new ParseOperationSet() : new ParseOperationSet(str);
        boolean optBoolean = jSONObject2.optBoolean(REST_KEY_IS_SAVE_EVENTUALLY);
        jSONObject2.remove(REST_KEY_IS_SAVE_EVENTUALLY);
        parseOperationSet.setIsSaveEventually(optBoolean);
        Iterator<String> keys2 = jSONObject2.keys();
        while (keys2.hasNext()) {
            String next = keys2.next();
            Object decode = parseDecoder.decode(jSONObject2.get(next));
            if (next.equals("ACL")) {
                decode = ParseACL.createACLFromJSONObject(jSONObject2.getJSONObject(next), parseDecoder);
            }
            parseOperationSet.put(next, decode instanceof ParseFieldOperation ? (ParseFieldOperation) decode : new ParseSetOperation(decode));
        }
        return parseOperationSet;
    }

    public String getUUID() {
        return this.uuid;
    }

    public boolean isSaveEventually() {
        return this.isSaveEventually;
    }

    public void mergeFrom(ParseOperationSet parseOperationSet) {
        for (String str : parseOperationSet.keySet()) {
            ParseFieldOperation parseFieldOperation = (ParseFieldOperation) parseOperationSet.get(str);
            ParseFieldOperation parseFieldOperation2 = (ParseFieldOperation) get(str);
            if (parseFieldOperation2 != null) {
                parseFieldOperation = parseFieldOperation2.mergeWithPrevious(parseFieldOperation);
            }
            put(str, parseFieldOperation);
        }
    }

    public void setIsSaveEventually(boolean z) {
        this.isSaveEventually = z;
    }

    /* access modifiers changed from: package-private */
    public void toParcel(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        parcel.writeString(this.uuid);
        parcel.writeByte(this.isSaveEventually ? (byte) 1 : 0);
        parcel.writeInt(size());
        for (String str : keySet()) {
            parcel.writeString(str);
            parseParcelEncoder.encode(get(str), parcel);
        }
    }

    public JSONObject toRest(ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet()) {
            jSONObject.put(str, ((ParseFieldOperation) get(str)).encode(parseEncoder));
        }
        jSONObject.put(REST_KEY_UUID, this.uuid);
        if (this.isSaveEventually) {
            jSONObject.put(REST_KEY_IS_SAVE_EVENTUALLY, true);
        }
        return jSONObject;
    }
}
