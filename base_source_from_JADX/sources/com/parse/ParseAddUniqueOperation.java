package com.parse;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseAddUniqueOperation implements ParseFieldOperation {
    static final String OP_NAME = "AddUnique";
    protected final LinkedHashSet<Object> objects = new LinkedHashSet<>();

    public ParseAddUniqueOperation(Collection<?> collection) {
        this.objects.addAll(collection);
    }

    public Object apply(Object obj, String str) {
        if (obj == null) {
            return new ArrayList(this.objects);
        }
        if (obj instanceof JSONArray) {
            return new JSONArray((ArrayList) apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray) obj), str));
        }
        if (obj instanceof List) {
            ArrayList arrayList = new ArrayList((List) obj);
            HashMap hashMap = new HashMap();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) instanceof ParseObject) {
                    hashMap.put(((ParseObject) arrayList.get(i)).getObjectId(), Integer.valueOf(i));
                }
            }
            Iterator it = this.objects.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof ParseObject) {
                    String objectId = ((ParseObject) next).getObjectId();
                    if (objectId != null && hashMap.containsKey(objectId)) {
                        arrayList.set(((Integer) hashMap.get(objectId)).intValue(), next);
                    } else if (arrayList.contains(next)) {
                    }
                } else if (arrayList.contains(next)) {
                }
                arrayList.add(next);
            }
            return arrayList;
        }
        throw new IllegalArgumentException("Operation is invalid after previous operation.");
    }

    public JSONObject encode(ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__op", OP_NAME);
        jSONObject.put("objects", parseEncoder.encode(new ArrayList(this.objects)));
        return jSONObject;
    }

    public void encode(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        parcel.writeString(OP_NAME);
        parcel.writeInt(this.objects.size());
        Iterator it = this.objects.iterator();
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
            if ((value instanceof JSONArray) || (value instanceof List)) {
                return new ParseSetOperation(apply(value, (String) null));
            }
            throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
        } else if (parseFieldOperation instanceof ParseAddUniqueOperation) {
            return new ParseAddUniqueOperation((List) apply(new ArrayList(((ParseAddUniqueOperation) parseFieldOperation).objects), (String) null));
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
