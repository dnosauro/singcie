package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbov implements zzp {
    private final zzbsu zzfvh;
    private AtomicBoolean zzfvi = new AtomicBoolean(false);

    public zzbov(zzbsu zzbsu) {
        this.zzfvh = zzbsu;
    }

    public final boolean isClosed() {
        return this.zzfvi.get();
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
        this.zzfvi.set(true);
        this.zzfvh.onAdClosed();
    }

    public final void zzux() {
        this.zzfvh.onAdOpened();
    }
}
