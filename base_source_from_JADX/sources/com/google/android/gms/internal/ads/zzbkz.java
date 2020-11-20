package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbkz implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzbkx zzfsd;
    private final zzeps<zzbnt> zzfse;

    public zzbkz(zzbkx zzbkx, zzeps<zzbnt> zzeps) {
        this.zzfsd = zzbkx;
        this.zzfse = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(new zzbxy(this.zzfse.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
