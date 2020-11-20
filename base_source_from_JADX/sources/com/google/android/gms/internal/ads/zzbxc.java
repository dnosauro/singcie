package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbxc implements zzepf<Set<zzbxy<AdMetadataListener>>> {
    private final zzbwp zzfzf;

    private zzbxc(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxc zzu(zzbwp zzbwp) {
        return new zzbxc(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzf.zzall(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
