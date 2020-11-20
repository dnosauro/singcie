package com.google.android.gms.internal.ads;

public enum zzcm implements zzekj {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3),
    DG(4),
    DG_XTEA(5);
    
    private static final zzekm<zzcm> zzep = null;
    private final int value;

    static {
        zzep = new zzcl();
    }

    private zzcm(int i) {
        this.value = i;
    }

    public static zzcm zzm(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_ENCRYPTION_METHOD;
            case 1:
                return BITSLICER;
            case 2:
                return TINK_HYBRID;
            case 3:
                return UNENCRYPTED;
            case 4:
                return DG;
            case 5:
                return DG_XTEA;
            default:
                return null;
        }
    }

    public static zzekl zzw() {
        return zzco.zzer;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.value;
    }
}
