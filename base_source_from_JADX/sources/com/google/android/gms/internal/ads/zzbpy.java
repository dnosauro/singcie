package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

public final class zzbpy implements zzepf<zza> {
    private final zzeps<Context> zzevi;
    private final zzbpv zzfwf;
    private final zzeps<zzawq> zzfwg;

    private zzbpy(zzbpv zzbpv, zzeps<Context> zzeps, zzeps<zzawq> zzeps2) {
        this.zzfwf = zzbpv;
        this.zzevi = zzeps;
        this.zzfwg = zzeps2;
    }

    public static zzbpy zza(zzbpv zzbpv, zzeps<Context> zzeps, zzeps<zzawq> zzeps2) {
        return new zzbpy(zzbpv, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zza) zzepl.zza(new zza(this.zzevi.get(), this.zzfwg.get(), (zzasw) null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
