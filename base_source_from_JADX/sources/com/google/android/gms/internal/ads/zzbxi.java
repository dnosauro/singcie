package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbxi implements zzepf<Set<zzbxy<zzbyd>>> {
    private final zzbwp zzfzf;

    private zzbxi(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxi zzaa(zzbwp zzbwp) {
        return new zzbxi(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
