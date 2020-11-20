package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzckd implements zzepf<zzcke> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzckq> zzewm;
    private final zzeps<zzdoa> zzexf;
    private final zzeps<zzdmu> zzfqj;
    private final zzeps<zzcqo> zzgia;
    private final zzeps<zzdnj> zzgjz;

    private zzckd(zzeps<Context> zzeps, zzeps<zzdoa> zzeps2, zzeps<zzckq> zzeps3, zzeps<zzdnj> zzeps4, zzeps<zzdmu> zzeps5, zzeps<zzcqo> zzeps6) {
        this.zzevi = zzeps;
        this.zzexf = zzeps2;
        this.zzewm = zzeps3;
        this.zzgjz = zzeps4;
        this.zzfqj = zzeps5;
        this.zzgia = zzeps6;
    }

    public static zzckd zza(zzeps<Context> zzeps, zzeps<zzdoa> zzeps2, zzeps<zzckq> zzeps3, zzeps<zzdnj> zzeps4, zzeps<zzdmu> zzeps5, zzeps<zzcqo> zzeps6) {
        return new zzckd(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6);
    }

    public final /* synthetic */ Object get() {
        return new zzcke(this.zzevi.get(), this.zzexf.get(), this.zzewm.get(), this.zzgjz.get(), this.zzfqj.get(), this.zzgia.get());
    }
}
