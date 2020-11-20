package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbxa implements zzepf<Set<zzbxy<zzbru>>> {
    private final zzbwp zzfzf;

    private zzbxa(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxa zzs(zzbwp zzbwp) {
        return new zzbxa(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzalh(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
