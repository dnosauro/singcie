package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;

final class zzcwv implements zzg {
    private final /* synthetic */ zzbyz zzgva;

    zzcwv(zzcwu zzcwu, zzbyz zzbyz) {
        this.zzgva = zzbyz;
    }

    public final void zzh(View view) {
    }

    public final void zzkb() {
        this.zzgva.zzafs().onAdClicked();
    }

    public final void zzkc() {
        this.zzgva.zzaft().onAdImpression();
        this.zzgva.zzafu().zzalx();
    }
}
