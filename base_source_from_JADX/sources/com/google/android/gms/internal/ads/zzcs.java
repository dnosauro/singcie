package com.google.android.gms.internal.ads;

public enum zzcs implements zzekj {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);
    
    private static final zzekm<zzcs> zzep = null;
    private final int value;

    static {
        zzep = new zzcr();
    }

    private zzcs(int i) {
        this.value = i;
    }

    public static zzcs zzo(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_PROTO;
            case 1:
                return AFMA_SIGNALS;
            case 2:
                return UNITY_SIGNALS;
            case 3:
                return PARTNER_SIGNALS;
            default:
                return null;
        }
    }

    public static zzekl zzw() {
        return zzct.zzer;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.value;
    }
}
