package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

public final class zzbzv implements zzp {
    private final zzbtr zzfzy;
    private final zzbxu zzfzz;

    public zzbzv(zzbtr zzbtr, zzbxu zzbxu) {
        this.zzfzy = zzbtr;
        this.zzfzz = zzbxu;
    }

    public final void onPause() {
        this.zzfzy.onPause();
    }

    public final void onResume() {
        this.zzfzy.onResume();
    }

    public final void onUserLeaveHint() {
        this.zzfzy.onUserLeaveHint();
    }

    public final void zza(zzl zzl) {
        this.zzfzy.zza(zzl);
        this.zzfzz.onHide();
    }

    public final void zzux() {
        this.zzfzy.zzux();
        this.zzfzz.zzalv();
    }
}
