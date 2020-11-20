package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

final class zzbea implements zzp {
    private zzp zzdrm;
    private zzbdv zzeqa;

    public zzbea(zzbdv zzbdv, zzp zzp) {
        this.zzeqa = zzbdv;
        this.zzdrm = zzp;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
        zzp zzp = this.zzdrm;
        if (zzp != null) {
            zzp.onUserLeaveHint();
        }
    }

    public final void zza(zzl zzl) {
        zzp zzp = this.zzdrm;
        if (zzp != null) {
            zzp.zza(zzl);
        }
        this.zzeqa.zzacl();
    }

    public final void zzux() {
        zzp zzp = this.zzdrm;
        if (zzp != null) {
            zzp.zzux();
        }
        this.zzeqa.zzvj();
    }
}
