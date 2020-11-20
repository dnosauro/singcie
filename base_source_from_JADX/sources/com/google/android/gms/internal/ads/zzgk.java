package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;

public final class zzgk extends zzgl {
    private final View zzaaq;

    public zzgk(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2, View view) {
        super(zzfa, str, str2, zza, i, 57);
        this.zzaaq = view;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (this.zzaaq != null) {
            Boolean bool = (Boolean) zzwq.zzqe().zzd(zzabf.zzcrm);
            DisplayMetrics displayMetrics = this.zzwb.getContext().getResources().getDisplayMetrics();
            zzfi zzfi = new zzfi((String) this.zzabi.invoke((Object) null, new Object[]{this.zzaaq, displayMetrics, bool}));
            zzcf.zza.zzf.C3706zza zzax = zzcf.zza.zzf.zzax();
            zzax.zzcy(zzfi.zzaak.longValue()).zzcz(zzfi.zzaal.longValue()).zzda(zzfi.zzaam.longValue());
            if (bool.booleanValue()) {
                zzax.zzdb(zzfi.zzaan.longValue());
            }
            this.zzaay.zza((zzcf.zza.zzf) ((zzekh) zzax.zzbhv()));
        }
    }
}
