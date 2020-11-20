package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbxe implements zzepf<Set<zzbxy<zzbub>>> {
    private final zzbwp zzfzf;

    private zzbxe(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxe zzw(zzbwp zzbwp) {
        return new zzbxe(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzalq(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
