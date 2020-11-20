package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;

final class zzj extends zza {
    final /* synthetic */ zze zzdrb;

    private zzj(zze zze) {
        this.zzdrb = zze;
    }

    public final void zzvm() {
        Bitmap zza = zzp.zzlj().zza(Integer.valueOf(this.zzdrb.zzdqi.zzdrt.zzboz));
        if (zza != null) {
            zzm.zzedd.post(new zzm(this, zzp.zzks().zza(this.zzdrb.zzaap, zza, this.zzdrb.zzdqi.zzdrt.zzbox, this.zzdrb.zzdqi.zzdrt.zzboy)));
        }
    }
}
