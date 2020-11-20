package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdaj implements zzepf<zzdae> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzdyz<String>> zzgyk;

    private zzdaj(zzeps<zzdyz<String>> zzeps, zzeps<Executor> zzeps2) {
        this.zzgyk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzdaj zzay(zzeps<zzdyz<String>> zzeps, zzeps<Executor> zzeps2) {
        return new zzdaj(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdae(this.zzgyk.get(), this.zzevg.get());
    }
}
