package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

public final class zzbtr extends zzbwk<zzp> implements zzp {
    public zzbtr(Set<zzbxy<zzp>> set) {
        super(set);
    }

    public final synchronized void onPause() {
        zza(zzbts.zzfxs);
    }

    public final synchronized void onResume() {
        zza(zzbtv.zzfxs);
    }

    public final synchronized void onUserLeaveHint() {
        zza(zzbtt.zzfxs);
    }

    public final synchronized void zza(zzl zzl) {
        zza(new zzbtq(zzl));
    }

    public final synchronized void zzux() {
        zza(zzbtu.zzfxs);
    }
}
