package com.google.android.gms.internal.ads;

public enum zzgn implements zzekj {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    UNKNOWN(999);
    
    private static final zzekm<zzgn> zzep = null;
    private final int value;

    static {
        zzep = new zzgq();
    }

    private zzgn(int i) {
        this.value = i;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    public final int zzv() {
        return this.value;
    }
}
