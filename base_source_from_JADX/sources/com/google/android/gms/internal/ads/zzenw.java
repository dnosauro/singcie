package com.google.android.gms.internal.ads;

public enum zzenw {
    DOUBLE(zzenz.DOUBLE, 1),
    FLOAT(zzenz.FLOAT, 5),
    INT64(zzenz.LONG, 0),
    UINT64(zzenz.LONG, 0),
    INT32(zzenz.INT, 0),
    FIXED64(zzenz.LONG, 1),
    FIXED32(zzenz.INT, 5),
    BOOL(zzenz.BOOLEAN, 0),
    STRING(zzenz.STRING, 2),
    GROUP(zzenz.MESSAGE, 3),
    MESSAGE(zzenz.MESSAGE, 2),
    BYTES(zzenz.BYTE_STRING, 2),
    UINT32(zzenz.INT, 0),
    ENUM(zzenz.ENUM, 0),
    SFIXED32(zzenz.INT, 5),
    SFIXED64(zzenz.LONG, 1),
    SINT32(zzenz.INT, 0),
    SINT64(zzenz.LONG, 0);
    
    private final zzenz zzitt;
    private final int zzitu;

    private zzenw(zzenz zzenz, int i) {
        this.zzitt = zzenz;
        this.zzitu = i;
    }

    public final zzenz zzbkp() {
        return this.zzitt;
    }

    public final int zzbkq() {
        return this.zzitu;
    }
}
