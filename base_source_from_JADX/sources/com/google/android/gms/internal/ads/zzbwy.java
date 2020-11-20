package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbwy implements zzepf<Set<zzbxy<zzbsi>>> {
    private final zzbwp zzfzf;

    private zzbwy(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbwy zzp(zzbwp zzbwp) {
        return new zzbwy(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzalk(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
