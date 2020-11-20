package com.unboundid.ldap.sdk;

import com.unboundid.util.StaticUtils;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

final class CompactAttribute implements Serializable {
    private static final int MAX_CACHED_NAMES = 1000;
    private static final ConcurrentHashMap<String, String> cachedNames = new ConcurrentHashMap<>(1000);
    private static final long serialVersionUID = 9056952830029621727L;
    private final String name;
    private final byte[][] values;

    CompactAttribute(Attribute attribute) {
        this.name = internName(attribute.getName());
        this.values = attribute.getValueByteArrays();
    }

    private static String internName(String str) {
        String str2 = cachedNames.get(str);
        if (str2 != null) {
            return str2;
        }
        if (cachedNames.size() >= 1000) {
            cachedNames.clear();
        }
        cachedNames.put(str, str);
        return str;
    }

    /* access modifiers changed from: package-private */
    public byte[][] getByteValues() {
        return this.values;
    }

    /* access modifiers changed from: package-private */
    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public String[] getStringValues() {
        String[] strArr = new String[this.values.length];
        int i = 0;
        while (true) {
            byte[][] bArr = this.values;
            if (i >= bArr.length) {
                return strArr;
            }
            strArr[i] = StaticUtils.toUTF8String(bArr[i]);
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public Attribute toAttribute() {
        return new Attribute(this.name, this.values);
    }
}
