package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

public final class zzbyt implements zzepf<zzbyn> {
    private final zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> zzftr;

    private zzbyt(zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbyt zzv(zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> zzeps) {
        return new zzbyt(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbyn(this.zzftr.get());
    }
}
