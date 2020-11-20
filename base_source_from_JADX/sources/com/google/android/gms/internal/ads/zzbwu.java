package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

public final class zzbwu implements zzepf<Set<zzbxy<zzp>>> {
    private final zzbwp zzfzf;

    private zzbwu(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbwu zzl(zzbwp zzbwp) {
        return new zzbwu(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzalr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
