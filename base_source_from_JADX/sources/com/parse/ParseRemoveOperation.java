package com.parse;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseRemoveOperation implements ParseFieldOperation {
    static final String OP_NAME = "Remove";
    protected final HashSet<Object> objects = new HashSet<>();

    public ParseRemoveOperation(Collection<?> collection) {
        this.objects.addAll(collection);
    }

    public Object apply(Object obj, String str) {
        if (obj == null) {
            return new ArrayList();
        }
        if (obj instanceof JSONArray) {
            return new JSONArray((ArrayList) apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray) obj), str));
        }
        if (obj instanceof List) {
            ArrayList arrayList = new ArrayList((List) obj);
            arrayList.removeAll(this.objects);
            ArrayList arrayList2 = new ArrayList(this.objects);
            arrayList2.removeAll(arrayList);
            HashSet hashSet = new HashSet();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof ParseObject) {
                    hashSet.add(((ParseObject) next).getObjectId());
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                if ((next2 instanceof ParseObject) && hashSet.contains(((ParseObject) next2).getObjectId())) {
                    it2.remove();
                }
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
            if ((value instanceof JSONArray) || (value instanceof List)) {
                return new ParseSetOperation(apply(value, (String) null));
            }
            throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
        } else if (parseFieldOperation instanceof ParseRemoveOperation) {
            HashSet hashSet = new HashSet(((ParseRemoveOperation) parseFieldOperation).objects);
            hashSet.addAll(this.objects);
            return new ParseRemoveOperation(hashSet);
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
