package com.parse;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseAddOperation implements ParseFieldOperation {
    static final String OP_NAME = "Add";
    protected final ArrayList<Object> objects = new ArrayList<>();

    public ParseAddOperation(Collection<?> collection) {
        this.objects.addAll(collection);
    }

    public Object apply(Object obj, String str) {
        if (obj == null) {
            return this.objects;
        }
        if (obj instanceof JSONArray) {
            return new JSONArray((ArrayList) apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray) obj), str));
        }
        if (obj instanceof List) {
            ArrayList arrayList = new ArrayList((List) obj);
            arrayList.addAll(this.objects);
            return arrayList;
        }
        throw new IllegalArgumentException("Operation is invalid after previous operation.");
    }

    public JSONObject encode(ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__op", OP_NAME);
        jSONObject.put("objects", parseEncoder.encode(this.objects));
        return jSONObject;
    }

    public void encode(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        parcel.writeString(OP_NAME);
        parcel.writeInt(this.objects.size());
        Iterator<Object> it = this.objects.iterator();
        while (it.hasNext()) {
            parseParcelEncoder.encode(it.next(), parcel);
        }
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parseFieldOperation) {
        if (parseFieldOperation == null) {
            return this;
        }
        if (parseFieldOperation instanceof ParseDeleteOperation) {
            return new ParseSetOperation(this.objects);
        }
        if (parseFieldOperation instanceof ParseSetOperation) {
            Object value = ((ParseSetOperation) parseFieldOperation).getValue();
            if (value instanceof JSONArray) {
                ArrayList<Object> jsonArrayAsArrayList = ParseFieldOperations.jsonArrayAsArrayList((JSONArray) value);
                jsonArrayAsArrayList.addAll(this.objects);
                return new ParseSetOperation(new JSONArray(jsonArrayAsArrayList));
            } else if (value instanceof List) {
                ArrayList arrayList = new ArrayList((List) value);
                arrayList.addAll(this.objects);
                return new ParseSetOperation(arrayList);
            } else {
                throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
            }
        } else if (parseFieldOperation instanceof ParseAddOperation) {
            ArrayList arrayList2 = new ArrayList(((ParseAddOperation) parseFieldOperation).objects);
            arrayList2.addAll(this.objects);
            return new ParseAddOperation(arrayList2);
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
