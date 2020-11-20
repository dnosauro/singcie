package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzari;

public final class zzv extends zzari {
    private Activity zzaap;
    private boolean zzdqo = false;
    private AdOverlayInfoParcel zzdrw;
    private boolean zzdrx = false;

    public zzv(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdrw = adOverlayInfoParcel;
        this.zzaap = activity;
    }

    private final synchronized void zzvp() {
        if (!this.zzdrx) {
            if (this.zzdrw.zzdrm != null) {
                this.zzdrw.zzdrm.zza(zzl.OTHER);
            }
            this.zzdrx = true;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
    }

    public final void onCreate(Bundle bundle) {
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdrw;
        if (adOverlayInfoParcel != null && !z) {
            if (bundle == null) {
                if (adOverlayInfoParcel.zzcgp != null) {
                    this.zzdrw.zzcgp.onAdClicked();
                }
                if (!(this.zzaap.getIntent() == null || !this.zzaap.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || this.zzdrw.zzdrm == null)) {
                    this.zzdrw.zzdrm.zzux();
                }
            }
            zzp.zzko();
            if (!zza.zza((Context) this.zzaap, this.zzdrw.zzdrl, this.zzdrw.zzdrq)) {
                this.zzaap.finish();
                return;
            }
            return;
        }
        this.zzaap.finish();
    }

    public final void onDestroy() {
        if (this.zzaap.isFinishing()) {
            zzvp();
        }
    }

    public final void onPause() {
        if (this.zzdrw.zzdrm != null) {
            this.zzdrw.zzdrm.onPause();
        }
        if (this.zzaap.isFinishing()) {
            zzvp();
        }
    }

    public final void onRestart() {
    }

    public final void onResume() {
        if (this.zzdqo) {
            this.zzaap.finish();
            return;
        }
        this.zzdqo = true;
        if (this.zzdrw.zzdrm != null) {
            this.zzdrw.zzdrm.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdqo);
    }

    public final void onStart() {
    }

    public final void onStop() {
        if (this.zzaap.isFinishing()) {
            zzvp();
        }
    }

    public final void onUserLeaveHint() {
        if (this.zzdrw.zzdrm != null) {
            this.zzdrw.zzdrm.onUserLeaveHint();
        }
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
    }

    public final void zzdp() {
    }

    public final boolean zzve() {
        return false;
    }
}
