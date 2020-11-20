package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbxb implements zzepf<Set<zzbxy<zzbto>>> {
    private final zzbwp zzfzf;

    private zzbxb(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxb zzt(zzbwp zzbwp) {
        return new zzbxb(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzalp(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
