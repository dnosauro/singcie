package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbwz implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzbwp zzfzf;

    private zzbwz(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbwz zzq(zzbwp zzbwp) {
        return new zzbwz(zzbwp);
    }

    public static Set<zzbxy<zzbtj>> zzr(zzbwp zzbwp) {
        return (Set) zzepl.zza(zzbwp.zzali(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzr(this.zzfzf);
    }
}
