package com.parse;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class ParseTraverser {
    private boolean traverseParseObjects = false;
    private boolean yieldRoot = false;

    private void traverseInternal(Object obj, boolean z, IdentityHashMap<Object, Object> identityHashMap) {
        ParseUser unresolvedUser;
        if (obj != null && !identityHashMap.containsKey(obj)) {
            if (!z || visit(obj)) {
                identityHashMap.put(obj, obj);
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        try {
                            traverseInternal(jSONObject.get(keys.next()), true, identityHashMap);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    int i = 0;
                    while (i < jSONArray.length()) {
                        try {
                            traverseInternal(jSONArray.get(i), true, identityHashMap);
                            i++;
                        } catch (JSONException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                } else if (obj instanceof Map) {
                    for (Object traverseInternal : ((Map) obj).values()) {
                        traverseInternal(traverseInternal, true, identityHashMap);
                    }
                } else if (obj instanceof List) {
                    for (Object traverseInternal2 : (List) obj) {
                        traverseInternal(traverseInternal2, true, identityHashMap);
                    }
                } else if (obj instanceof ParseObject) {
                    if (this.traverseParseObjects) {
                        ParseObject parseObject = (ParseObject) obj;
                        for (String str : parseObject.keySet()) {
                            traverseInternal(parseObject.get(str), true, identityHashMap);
                        }
                    }
                } else if ((obj instanceof ParseACL) && (unresolvedUser = ((ParseACL) obj).getUnresolvedUser()) != null && unresolvedUser.isCurrentUser()) {
                    traverseInternal(unresolvedUser, true, identityHashMap);
                }
            }
        }
    }

    public ParseTraverser setTraverseParseObjects(boolean z) {
        this.traverseParseObjects = z;
        return this;
    }

    public ParseTraverser setYieldRoot(boolean z) {
        this.yieldRoot = z;
        return this;
    }

    public void traverse(Object obj) {
        traverseInternal(obj, this.yieldRoot, new IdentityHashMap());
    }

    /* access modifiers changed from: protected */
    public abstract boolean visit(Object obj);
}
