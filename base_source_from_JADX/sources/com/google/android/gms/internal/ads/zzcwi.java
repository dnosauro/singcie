package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcwi implements zzg {
    private final zzbyc zzfte;
    private final zzbsl zzgar;
    private final zzbrt zzgas;
    private final zzbki zzgat;
    private final zzbxx zzgav;
    private AtomicBoolean zzgun = new AtomicBoolean(false);

    zzcwi(zzbrt zzbrt, zzbsl zzbsl, zzbyc zzbyc, zzbxx zzbxx, zzbki zzbki) {
        this.zzgas = zzbrt;
        this.zzgar = zzbsl;
        this.zzfte = zzbyc;
        this.zzgav = zzbxx;
        this.zzgat = zzbki;
    }

    public final synchronized void zzh(View view) {
        if (this.zzgun.compareAndSet(false, true)) {
            this.zzgat.onAdImpression();
            this.zzgav.zzv(view);
        }
    }

    public final void zzkb() {
        if (this.zzgun.get()) {
            this.zzgas.onAdClicked();
        }
    }

    public final void zzkc() {
        if (this.zzgun.get()) {
            this.zzgar.onAdImpression();
            this.zzfte.zzalx();
        }
    }
}
