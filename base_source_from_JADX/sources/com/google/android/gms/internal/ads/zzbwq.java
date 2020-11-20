package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbwq implements zzepf<zzbrx> {
    private final zzbwp zzfzf;
    private final zzeps<Set<zzbxy<zzbrz>>> zzfzg;

    private zzbwq(zzbwp zzbwp, zzeps<Set<zzbxy<zzbrz>>> zzeps) {
        this.zzfzf = zzbwp;
        this.zzfzg = zzeps;
    }

    public static zzbwq zza(zzbwp zzbwp, zzeps<Set<zzbxy<zzbrz>>> zzeps) {
        return new zzbwq(zzbwp, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbrx) zzepl.zza(this.zzfzf.zzc(this.zzfzg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
