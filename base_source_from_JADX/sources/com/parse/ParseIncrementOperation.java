package com.parse;

import android.os.Parcel;
import org.json.JSONObject;

class ParseIncrementOperation implements ParseFieldOperation {
    static final String OP_NAME = "Increment";
    private final Number amount;

    public ParseIncrementOperation(Number number) {
        this.amount = number;
    }

    public Object apply(Object obj, String str) {
        if (obj == null) {
            return this.amount;
        }
        if (obj instanceof Number) {
            return Numbers.add((Number) obj, this.amount);
        }
        throw new IllegalArgumentException("You cannot increment a non-number.");
    }

    public JSONObject encode(ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__op", OP_NAME);
        jSONObject.put("amount", this.amount);
        return jSONObject;
    }

    public void encode(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        parcel.writeString(OP_NAME);
        parseParcelEncoder.encode(this.amount, parcel);
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parseFieldOperation) {
        if (parseFieldOperation == null) {
            return this;
        }
        if (parseFieldOperation instanceof ParseDeleteOperation) {
            return new ParseSetOperation(this.amount);
        }
        if (parseFieldOperation instanceof ParseSetOperation) {
            Object value = ((ParseSetOperation) parseFieldOperation).getValue();
            if (value instanceof Number) {
                return new ParseSetOperation(Numbers.add((Number) value, this.amount));
            }
            throw new IllegalArgumentException("You cannot increment a non-number.");
        } else if (parseFieldOperation instanceof ParseIncrementOperation) {
            return new ParseIncrementOperation(Numbers.add(((ParseIncrementOperation) parseFieldOperation).amount, this.amount));
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
