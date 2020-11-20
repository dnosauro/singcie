package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbww implements zzepf<Set<zzbxy<zzva>>> {
    private final zzbwp zzfzf;

    private zzbww(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbww zzn(zzbwp zzbwp) {
        return new zzbww(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzaln(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
