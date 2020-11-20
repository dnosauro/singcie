package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbsl extends zzbwk<zzbsm> {
    private boolean zzfxv = false;

    public zzbsl(Set<zzbxy<zzbsm>> set) {
        super(set);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfxv) {
            zza(zzbsk.zzfxs);
            this.zzfxv = true;
        }
    }
}
