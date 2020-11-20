package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdcv implements zzepf<zzdct> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;

    private zzdcv(zzeps<Context> zzeps, zzeps<zzdzc> zzeps2) {
        this.zzevi = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzdcv zzbc(zzeps<Context> zzeps, zzeps<zzdzc> zzeps2) {
        return new zzdcv(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdct(this.zzevi.get(), this.zzevg.get());
    }
}
