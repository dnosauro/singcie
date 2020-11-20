package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;

final class zzbbg implements Runnable {
    private boolean zzbsq = false;
    private zzbar zzejf;

    zzbbg(zzbar zzbar) {
        this.zzejf = zzbar;
    }

    private final void zzaas() {
        zzm.zzedd.removeCallbacks(this);
        zzm.zzedd.postDelayed(this, 250);
    }

    public final void pause() {
        this.zzbsq = true;
        this.zzejf.zzzz();
    }

    public final void resume() {
        this.zzbsq = false;
        zzaas();
    }

    public final void run() {
        if (!this.zzbsq) {
            this.zzejf.zzzz();
            zzaas();
        }
    }
}
