package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbxd implements zzepf<Set<zzbxy<AppEventListener>>> {
    private final zzbwp zzfzf;

    private zzbxd(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxd zzv(zzbwp zzbwp) {
        return new zzbxd(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzalm(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
