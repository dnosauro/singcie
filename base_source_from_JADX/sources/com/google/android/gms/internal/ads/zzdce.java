package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzdce implements zzepf<zzdms> {
    private final zzeps<Clock> zzfrf;

    public zzdce(zzeps<Clock> zzeps) {
        this.zzfrf = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (zzdms) zzepl.zza(new zzdms(this.zzfrf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
