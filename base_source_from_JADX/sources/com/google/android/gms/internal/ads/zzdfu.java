package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdfu implements zzepf<zzdfs> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;

    private zzdfu(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        this.zzevg = zzeps;
        this.zzevi = zzeps2;
    }

    public static zzdfu zzbj(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        return new zzdfu(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdfs(this.zzevg.get(), this.zzevi.get());
    }
}
