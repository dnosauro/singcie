package com.parse;

import android.os.Parcel;
import com.parse.ParseObject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseRelationOperation<T extends ParseObject> implements ParseFieldOperation {
    static final String OP_NAME_ADD = "AddRelation";
    static final String OP_NAME_BATCH = "Batch";
    static final String OP_NAME_REMOVE = "RemoveRelation";
    private final Set<ParseObject> relationsToAdd;
    private final Set<ParseObject> relationsToRemove;
    private final String targetClass;

    private ParseRelationOperation(String str, Set<ParseObject> set, Set<ParseObject> set2) {
        this.targetClass = str;
        this.relationsToAdd = new HashSet(set);
        this.relationsToRemove = new HashSet(set2);
    }

    ParseRelationOperation(Set<T> set, Set<T> set2) {
        this.relationsToAdd = new HashSet();
        this.relationsToRemove = new HashSet();
        String str = null;
        if (set != null) {
            for (T t : set) {
                addParseObjectToSet(t, this.relationsToAdd);
                if (str == null) {
                    str = t.getClassName();
                } else if (!str.equals(t.getClassName())) {
                    throw new IllegalArgumentException("All objects in a relation must be of the same class.");
                }
            }
        }
        if (set2 != null) {
            for (T t2 : set2) {
                addParseObjectToSet(t2, this.relationsToRemove);
                if (str == null) {
                    str = t2.getClassName();
                } else if (!str.equals(t2.getClassName())) {
                    throw new IllegalArgumentException("All objects in a relation must be of the same class.");
                }
            }
        }
        if (str != null) {
            this.targetClass = str;
            return;
        }
        throw new IllegalArgumentException("Cannot create a ParseRelationOperation with no objects.");
    }

    private void addAllParseObjectsToSet(Collection<ParseObject> collection, Set<ParseObject> set) {
        for (ParseObject addParseObjectToSet : collection) {
            addParseObjectToSet(addParseObjectToSet, set);
        }
    }

    private void addParseObjectToSet(ParseObject parseObject, Set<ParseObject> set) {
        if (Parse.getLocalDatastore() != null || parseObject.getObjectId() == null) {
            set.add(parseObject);
            return;
        }
        for (ParseObject next : set) {
            if (parseObject.getObjectId().equals(next.getObjectId())) {
                set.remove(next);
            }
        }
        set.add(parseObject);
    }

    private void removeAllParseObjectsFromSet(Collection<ParseObject> collection, Set<ParseObject> set) {
        for (ParseObject removeParseObjectFromSet : collection) {
            removeParseObjectFromSet(removeParseObjectFromSet, set);
        }
    }

    private void removeParseObjectFromSet(ParseObject parseObject, Set<ParseObject> set) {
        if (Parse.getLocalDatastore() != null || parseObject.getObjectId() == null) {
            set.remove(parseObject);
            return;
        }
        for (ParseObject next : set) {
            if (parseObject.getObjectId().equals(next.getObjectId())) {
                set.remove(next);
            }
        }
    }

    public Object apply(Object obj, String str) {
        ParseRelation parseRelation;
        if (obj == null) {
            parseRelation = new ParseRelation(this.targetClass);
        } else if (obj instanceof ParseRelation) {
            parseRelation = (ParseRelation) obj;
            String str2 = this.targetClass;
            if (str2 != null && !str2.equals(parseRelation.getTargetClass())) {
                throw new IllegalArgumentException("Related object object must be of class " + parseRelation.getTargetClass() + ", but " + this.targetClass + " was passed in.");
            }
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
        for (ParseObject addKnownObject : this.relationsToAdd) {
            parseRelation.addKnownObject(addKnownObject);
        }
        for (ParseObject removeKnownObject : this.relationsToRemove) {
            parseRelation.removeKnownObject(removeKnownObject);
        }
        return parseRelation;
    }

    /* access modifiers changed from: package-private */
    public JSONArray convertSetToArray(Set<ParseObject> set, ParseEncoder parseEncoder) {
        JSONArray jSONArray = new JSONArray();
        for (ParseObject encode : set) {
            jSONArray.put(parseEncoder.encode(encode));
        }
        return jSONArray;
    }

    public JSONObject encode(ParseEncoder parseEncoder) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (this.relationsToAdd.size() > 0) {
            jSONObject = new JSONObject();
            jSONObject.put("__op", OP_NAME_ADD);
            jSONObject.put("objects", convertSetToArray(this.relationsToAdd, parseEncoder));
        } else {
            jSONObject = null;
        }
        if (this.relationsToRemove.size() > 0) {
            jSONObject2 = new JSONObject();
            jSONObject2.put("__op", OP_NAME_REMOVE);
            jSONObject2.put("objects", convertSetToArray(this.relationsToRemove, parseEncoder));
        }
        if (jSONObject != null && jSONObject2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("__op", OP_NAME_BATCH);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONArray.put(jSONObject2);
            jSONObject3.put("ops", jSONArray);
            return jSONObject3;
        } else if (jSONObject != null) {
            return jSONObject;
        } else {
            if (jSONObject2 != null) {
                return jSONObject2;
            }
            throw new IllegalArgumentException("A ParseRelationOperation was created without any data.");
        }
    }

    public void encode(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        if (!this.relationsToAdd.isEmpty() || !this.relationsToRemove.isEmpty()) {
            if (this.relationsToAdd.size() > 0 && this.relationsToRemove.size() > 0) {
                parcel.writeString(OP_NAME_BATCH);
            }
            if (this.relationsToAdd.size() > 0) {
                parcel.writeString(OP_NAME_ADD);
                parcel.writeInt(this.relationsToAdd.size());
                for (ParseObject encode : this.relationsToAdd) {
                    parseParcelEncoder.encode(encode, parcel);
                }
            }
            if (this.relationsToRemove.size() > 0) {
                parcel.writeString(OP_NAME_REMOVE);
                parcel.writeInt(this.relationsToRemove.size());
                for (ParseObject encode2 : this.relationsToRemove) {
                    parseParcelEncoder.encode(encode2, parcel);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("A ParseRelationOperation was created without any data.");
    }

    /* access modifiers changed from: package-private */
    public String getTargetClass() {
        return this.targetClass;
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parseFieldOperation) {
        if (parseFieldOperation == null) {
            return this;
        }
        if (parseFieldOperation instanceof ParseDeleteOperation) {
            throw new IllegalArgumentException("You can't modify a relation after deleting it.");
        } else if (parseFieldOperation instanceof ParseRelationOperation) {
            ParseRelationOperation parseRelationOperation = (ParseRelationOperation) parseFieldOperation;
            String str = parseRelationOperation.targetClass;
            if (str == null || str.equals(this.targetClass)) {
                HashSet hashSet = new HashSet(parseRelationOperation.relationsToAdd);
                HashSet hashSet2 = new HashSet(parseRelationOperation.relationsToRemove);
                Set<ParseObject> set = this.relationsToAdd;
                if (set != null) {
                    addAllParseObjectsToSet(set, hashSet);
                    removeAllParseObjectsFromSet(this.relationsToAdd, hashSet2);
                }
                Set<ParseObject> set2 = this.relationsToRemove;
                if (set2 != null) {
                    removeAllParseObjectsFromSet(set2, hashSet);
                    addAllParseObjectsToSet(this.relationsToRemove, hashSet2);
                }
                return new ParseRelationOperation(this.targetClass, hashSet, hashSet2);
            }
            throw new IllegalArgumentException("Related object object must be of class " + parseRelationOperation.targetClass + ", but " + this.targetClass + " was passed in.");
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
