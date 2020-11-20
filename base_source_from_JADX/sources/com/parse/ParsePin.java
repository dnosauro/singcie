package com.parse;

import java.util.List;

@ParseClassName("_Pin")
class ParsePin extends ParseObject {
    static final String KEY_NAME = "_name";
    private static final String KEY_OBJECTS = "_objects";

    public String getName() {
        return getString(KEY_NAME);
    }

    public List<ParseObject> getObjects() {
        return getList(KEY_OBJECTS);
    }

    /* access modifiers changed from: package-private */
    public boolean needsDefaultACL() {
        return false;
    }

    public void setName(String str) {
        put(KEY_NAME, str);
    }

    public void setObjects(List<ParseObject> list) {
        put(KEY_OBJECTS, list);
    }
}
