package com.google.android.gms.internal.ads;

import com.parse.ParseQuery;

public enum zzuo implements zzekj {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(ParseQuery.MAX_LIMIT);
    
    private static final zzekm<zzuo> zzep = null;
    private final int value;

    static {
        zzep = new zzun();
    }

    private zzuo(int i) {
        this.value = i;
    }

    public static zzuo zzcd(int i) {
        if (i == 1000) {
            return ENUM_UNKNOWN;
        }
        switch (i) {
            case 0:
                return ENUM_FALSE;
            case 1:
                return ENUM_TRUE;
            default:
                return null;
        }
    }

    public static zzekl zzw() {
        return zzup.zzer;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.value;
    }
}
