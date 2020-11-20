package com.parse;

import android.os.Parcel;
import android.os.Parcelable;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseRelation<T extends ParseObject> implements Parcelable {
    public static final Parcelable.Creator<ParseRelation> CREATOR = new Parcelable.Creator<ParseRelation>() {
        public ParseRelation createFromParcel(Parcel parcel) {
            return new ParseRelation(parcel, (ParseParcelDecoder) new ParseObjectParcelDecoder());
        }

        public ParseRelation[] newArray(int i) {
            return new ParseRelation[i];
        }
    };
    private String key;
    private Set<ParseObject> knownObjects;
    private final Object mutex;
    private WeakReference<ParseObject> parent;
    private String parentClassName;
    private String parentObjectId;
    private String targetClass;

    ParseRelation(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
        this.mutex = new Object();
        this.knownObjects = new HashSet();
        if (parcel.readByte() == 1) {
            this.key = parcel.readString();
        }
        if (parcel.readByte() == 1) {
            this.targetClass = parcel.readString();
        }
        if (parcel.readByte() == 1) {
            this.parentClassName = parcel.readString();
        }
        if (parcel.readByte() == 1) {
            this.parentObjectId = parcel.readString();
        }
        if (parcel.readByte() == 1) {
            this.parent = new WeakReference<>((ParseObject) parseParcelDecoder.decode(parcel));
        }
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.knownObjects.add((ParseObject) parseParcelDecoder.decode(parcel));
        }
    }

    ParseRelation(ParseObject parseObject, String str) {
        this.mutex = new Object();
        this.knownObjects = new HashSet();
        this.parent = new WeakReference<>(parseObject);
        this.parentObjectId = parseObject.getObjectId();
        this.parentClassName = parseObject.getClassName();
        this.key = str;
        this.targetClass = null;
    }

    ParseRelation(String str) {
        this.mutex = new Object();
        this.knownObjects = new HashSet();
        this.parent = null;
        this.parentObjectId = null;
        this.parentClassName = null;
        this.key = null;
        this.targetClass = str;
    }

    ParseRelation(JSONObject jSONObject, ParseDecoder parseDecoder) {
        this.mutex = new Object();
        this.knownObjects = new HashSet();
        this.parent = null;
        this.parentObjectId = null;
        this.parentClassName = null;
        this.key = null;
        this.targetClass = jSONObject.optString("className", (String) null);
        JSONArray optJSONArray = jSONObject.optJSONArray("objects");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.knownObjects.add((ParseObject) parseDecoder.decode(optJSONArray.optJSONObject(i)));
            }
        }
    }

    public void add(T t) {
        synchronized (this.mutex) {
            ParseRelationOperation parseRelationOperation = new ParseRelationOperation(Collections.singleton(t), (Set) null);
            this.targetClass = parseRelationOperation.getTargetClass();
            getParent().performOperation(this.key, parseRelationOperation);
            this.knownObjects.add(t);
        }
    }

    /* access modifiers changed from: package-private */
    public void addKnownObject(ParseObject parseObject) {
        synchronized (this.mutex) {
            this.knownObjects.add(parseObject);
        }
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public JSONObject encodeToJSON(ParseEncoder parseEncoder) {
        JSONObject jSONObject;
        synchronized (this.mutex) {
            jSONObject = new JSONObject();
            jSONObject.put("__type", "Relation");
            jSONObject.put("className", this.targetClass);
            JSONArray jSONArray = new JSONArray();
            for (ParseObject encodeRelatedObject : this.knownObjects) {
                try {
                    jSONArray.put(parseEncoder.encodeRelatedObject(encodeRelatedObject));
                } catch (Exception unused) {
                }
            }
            jSONObject.put("objects", jSONArray);
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void ensureParentAndKey(ParseObject parseObject, String str) {
        synchronized (this.mutex) {
            if (this.parent == null) {
                this.parent = new WeakReference<>(parseObject);
                this.parentObjectId = parseObject.getObjectId();
                this.parentClassName = parseObject.getClassName();
            }
            if (this.key == null) {
                this.key = str;
            }
            if (this.parent.get() != parseObject) {
                throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different ParseObjects.");
            } else if (!this.key.equals(str)) {
                throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different keys.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getKey() {
        return this.key;
    }

    /* access modifiers changed from: package-private */
    public Set<ParseObject> getKnownObjects() {
        return this.knownObjects;
    }

    /* access modifiers changed from: package-private */
    public ParseObject getParent() {
        WeakReference<ParseObject> weakReference = this.parent;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get() == null ? ParseObject.createWithoutData(this.parentClassName, this.parentObjectId) : (ParseObject) this.parent.get();
    }

    public ParseQuery<T> getQuery() {
        ParseQuery<T> parseQuery;
        synchronized (this.mutex) {
            ParseQuery.State.Builder redirectClassNameForKey = this.targetClass == null ? new ParseQuery.State.Builder(this.parentClassName).redirectClassNameForKey(this.key) : new ParseQuery.State.Builder(this.targetClass);
            redirectClassNameForKey.whereRelatedTo(getParent(), this.key);
            parseQuery = new ParseQuery<>(redirectClassNameForKey);
        }
        return parseQuery;
    }

    /* access modifiers changed from: package-private */
    public String getTargetClass() {
        String str;
        synchronized (this.mutex) {
            str = this.targetClass;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public boolean hasKnownObject(ParseObject parseObject) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.knownObjects.contains(parseObject);
        }
        return contains;
    }

    public void remove(T t) {
        synchronized (this.mutex) {
            ParseRelationOperation parseRelationOperation = new ParseRelationOperation((Set) null, Collections.singleton(t));
            this.targetClass = parseRelationOperation.getTargetClass();
            getParent().performOperation(this.key, parseRelationOperation);
            this.knownObjects.remove(t);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeKnownObject(ParseObject parseObject) {
        synchronized (this.mutex) {
            this.knownObjects.remove(parseObject);
        }
    }

    /* access modifiers changed from: package-private */
    public void setTargetClass(String str) {
        synchronized (this.mutex) {
            this.targetClass = str;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, (ParseParcelEncoder) new ParseObjectParcelEncoder());
    }

    /* access modifiers changed from: package-private */
    public void writeToParcel(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        synchronized (this.mutex) {
            byte b = 1;
            parcel.writeByte(this.key != null ? (byte) 1 : 0);
            if (this.key != null) {
                parcel.writeString(this.key);
            }
            parcel.writeByte(this.targetClass != null ? (byte) 1 : 0);
            if (this.targetClass != null) {
                parcel.writeString(this.targetClass);
            }
            parcel.writeByte(this.parentClassName != null ? (byte) 1 : 0);
            if (this.parentClassName != null) {
                parcel.writeString(this.parentClassName);
            }
            parcel.writeByte(this.parentObjectId != null ? (byte) 1 : 0);
            if (this.parentObjectId != null) {
                parcel.writeString(this.parentObjectId);
            }
            boolean z = (this.parent == null || this.parent.get() == null) ? false : true;
            if (!z) {
                b = 0;
            }
            parcel.writeByte(b);
            if (z) {
                parseParcelEncoder.encode(this.parent.get(), parcel);
            }
            parcel.writeInt(this.knownObjects.size());
            for (ParseObject encode : this.knownObjects) {
                parseParcelEncoder.encode(encode, parcel);
            }
        }
    }
}
