package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbwx implements zzepf<Set<zzbxy<zzbsm>>> {
    private final zzbwp zzfzf;

    private zzbwx(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbwx zzo(zzbwp zzbwp) {
        return new zzbwx(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzalo(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
