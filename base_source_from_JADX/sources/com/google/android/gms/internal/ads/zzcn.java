package com.google.android.gms.internal.ads;

import com.parse.ParseQuery;

public enum zzcn implements zzekj {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(ParseQuery.MAX_LIMIT);
    
    private static final zzekm<zzcn> zzep = null;
    private final int value;

    static {
        zzep = new zzcq();
    }

    private zzcn(int i) {
        this.value = i;
    }

    public static zzcn zzn(int i) {
        if (i == 1000) {
            return ENUM_UNKNOWN;
        }
        switch (i) {
            case 0:
                return ENUM_FALSE;
            case 1:
                return ENUM_TRUE;
            case 2:
                return ENUM_FAILURE;
            default:
                return null;
        }
    }

    public static zzekl zzw() {
        return zzcp.zzer;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.value;
    }
}
