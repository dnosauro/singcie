package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcoe implements zzepf<zzcob> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzawx> zzfpf;

    private zzcoe(zzeps<Context> zzeps, zzeps<zzawx> zzeps2) {
        this.zzevi = zzeps;
        this.zzfpf = zzeps2;
    }

    public static zzcoe zzat(zzeps<Context> zzeps, zzeps<zzawx> zzeps2) {
        return new zzcoe(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcob(this.zzevi.get(), this.zzfpf.get());
    }
}
