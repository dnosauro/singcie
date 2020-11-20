package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzbxz implements zzepf<zzbxx> {
    private final zzeps<Context> zzevi;
    private final zzeps<Set<zzbxy<zzqu>>> zzftr;
    private final zzeps<zzdmu> zzfuk;

    private zzbxz(zzeps<Context> zzeps, zzeps<Set<zzbxy<zzqu>>> zzeps2, zzeps<zzdmu> zzeps3) {
        this.zzevi = zzeps;
        this.zzftr = zzeps2;
        this.zzfuk = zzeps3;
    }

    public static zzbxz zzk(zzeps<Context> zzeps, zzeps<Set<zzbxy<zzqu>>> zzeps2, zzeps<zzdmu> zzeps3) {
        return new zzbxz(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbxx(this.zzevi.get(), this.zzftr.get(), this.zzfuk.get());
    }
}
