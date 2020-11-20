package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzu;

final class zzcgp implements zzp, zzu, zzagy, zzaha, zzva {
    private zzva zzcgp;
    private zzagy zzdfr;
    private zzaha zzdfs;
    private zzp zzdrm;
    private zzu zzdrq;

    private zzcgp() {
    }

    /* synthetic */ zzcgp(zzcgm zzcgm) {
        this();
    }

    /* access modifiers changed from: private */
    public final synchronized void zza(zzva zzva, zzagy zzagy, zzp zzp, zzaha zzaha, zzu zzu) {
        this.zzcgp = zzva;
        this.zzdfr = zzagy;
        this.zzdrm = zzp;
        this.zzdfs = zzaha;
        this.zzdrq = zzu;
    }

    public final synchronized void onAdClicked() {
        if (this.zzcgp != null) {
            this.zzcgp.onAdClicked();
        }
    }

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzdfs != null) {
            this.zzdfs.onAppEvent(str, str2);
        }
    }

    public final synchronized void onPause() {
        if (this.zzdrm != null) {
            this.zzdrm.onPause();
        }
    }

    public final synchronized void onResume() {
        if (this.zzdrm != null) {
            this.zzdrm.onResume();
        }
    }

    public final synchronized void onUserLeaveHint() {
        if (this.zzdrm != null) {
            this.zzdrm.onUserLeaveHint();
        }
    }

    public final synchronized void zza(zzl zzl) {
        if (this.zzdrm != null) {
            this.zzdrm.zza(zzl);
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        if (this.zzdfr != null) {
            this.zzdfr.zza(str, bundle);
        }
    }

    public final synchronized void zzux() {
        if (this.zzdrm != null) {
            this.zzdrm.zzux();
        }
    }

    public final synchronized void zzvo() {
        if (this.zzdrq != null) {
            this.zzdrq.zzvo();
        }
    }
}
