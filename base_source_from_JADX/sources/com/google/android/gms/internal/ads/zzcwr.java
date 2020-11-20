package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import javax.annotation.concurrent.GuardedBy;

public final class zzcwr implements zzg {
    @GuardedBy("this")
    private zzg zzguy;

    public final synchronized void zza(zzg zzg) {
        this.zzguy = zzg;
    }

    public final synchronized void zzh(View view) {
        if (this.zzguy != null) {
            this.zzguy.zzh(view);
        }
    }

    public final synchronized void zzkb() {
        if (this.zzguy != null) {
            this.zzguy.zzkb();
        }
    }

    public final synchronized void zzkc() {
        if (this.zzguy != null) {
            this.zzguy.zzkc();
        }
    }
}
