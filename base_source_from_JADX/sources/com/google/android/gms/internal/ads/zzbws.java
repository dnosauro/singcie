package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbws implements zzepf<Set<zzbxy<zzbsp>>> {
    private final zzbwp zzfzf;

    private zzbws(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbws zzj(zzbwp zzbwp) {
        return new zzbws(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
