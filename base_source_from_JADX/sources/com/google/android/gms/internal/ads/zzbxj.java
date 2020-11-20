package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;

public final class zzbxj implements zzepf<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbwp zzfzf;

    private zzbxj(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxj zzab(zzbwp zzbwp) {
        return new zzbxj(zzbwp);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
