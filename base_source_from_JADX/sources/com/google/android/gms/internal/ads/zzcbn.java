package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

public final class zzcbn implements zzepf<zzbxx> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdmu> zzfuk;

    public zzcbn(zzeps<Context> zzeps, zzeps<zzdmu> zzeps2) {
        this.zzevi = zzeps;
        this.zzfuk = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzbxx) zzepl.zza(new zzbxx(this.zzevi.get(), new HashSet(), this.zzfuk.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
