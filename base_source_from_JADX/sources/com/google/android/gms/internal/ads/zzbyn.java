package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

public final class zzbyn extends zzbwk<VideoController.VideoLifecycleCallbacks> {
    @GuardedBy("this")
    private boolean zzesq;

    protected zzbyn(Set<zzbxy<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoEnd() {
        zza(zzbyp.zzfxs);
    }

    public final void onVideoPause() {
        zza(zzbyq.zzfxs);
    }

    public final synchronized void onVideoPlay() {
        if (!this.zzesq) {
            zza(zzbyr.zzfxs);
            this.zzesq = true;
        }
        zza(zzbyu.zzfxs);
    }

    public final synchronized void onVideoStart() {
        zza(zzbys.zzfxs);
        this.zzesq = true;
    }
}
