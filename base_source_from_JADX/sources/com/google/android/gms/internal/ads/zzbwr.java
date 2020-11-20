package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbwr implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzbwp zzfzf;

    private zzbwr(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbwr zzh(zzbwp zzbwp) {
        return new zzbwr(zzbwp);
    }

    public static Set<zzbxy<zzbtj>> zzi(zzbwp zzbwp) {
        return (Set) zzepl.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzi(this.zzfzf);
    }
}
