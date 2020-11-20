package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdoq implements zzepf<zzdon> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzayq> zzfca;

    private zzdoq(zzeps<Context> zzeps, zzeps<zzayq> zzeps2) {
        this.zzevi = zzeps;
        this.zzfca = zzeps2;
    }

    public static zzdoq zzbk(zzeps<Context> zzeps, zzeps<zzayq> zzeps2) {
        return new zzdoq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdon(this.zzevi.get(), this.zzfca.get());
    }
}
