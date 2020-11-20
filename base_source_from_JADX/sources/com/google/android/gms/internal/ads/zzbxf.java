package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbxf implements zzepf<Set<zzbxy<zzqu>>> {
    private final zzbwp zzfzf;

    private zzbxf(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxf zzx(zzbwp zzbwp) {
        return new zzbxf(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
