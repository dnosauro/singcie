package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcqf implements zzepf<zzcqe> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzcpx> zzfcv;
    private final zzeps<zzcpr> zzffo;
    private final zzeps<zzbqz> zzgpt;

    private zzcqf(zzeps<Context> zzeps, zzeps<zzbqz> zzeps2, zzeps<zzcpx> zzeps3, zzeps<zzcpr> zzeps4) {
        this.zzevi = zzeps;
        this.zzgpt = zzeps2;
        this.zzfcv = zzeps3;
        this.zzffo = zzeps4;
    }

    public static zzcqf zze(zzeps<Context> zzeps, zzeps<zzbqz> zzeps2, zzeps<zzcpx> zzeps3, zzeps<zzcpr> zzeps4) {
        return new zzcqf(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzcqe(this.zzevi.get(), this.zzgpt.get(), this.zzfcv.get(), this.zzffo.get());
    }
}
