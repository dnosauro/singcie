package com.google.android.gms.internal.ads;

import java.io.InputStream;

public final class zztt {
    private final InputStream zzbio;
    private final boolean zzbuu;
    private final boolean zzbuv;
    private final long zzbuw;
    private final boolean zzbux;

    private zztt(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        this.zzbio = inputStream;
        this.zzbuu = z;
        this.zzbux = z2;
        this.zzbuw = j;
        this.zzbuv = z3;
    }

    public static zztt zza(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        return new zztt(inputStream, z, z2, j, z3);
    }

    public final InputStream getInputStream() {
        return this.zzbio;
    }

    public final boolean zzmy() {
        return this.zzbuu;
    }

    public final boolean zzmz() {
        return this.zzbuv;
    }

    public final long zzna() {
        return this.zzbuw;
    }

    public final boolean zznb() {
        return this.zzbux;
    }
}
