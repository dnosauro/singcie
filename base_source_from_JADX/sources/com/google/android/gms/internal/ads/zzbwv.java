package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbwv implements zzepf<Set<zzbxy<zzbrz>>> {
    private final zzbwp zzfzf;

    private zzbwv(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbwv zzm(zzbwp zzbwp) {
        return new zzbwv(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzalj(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
