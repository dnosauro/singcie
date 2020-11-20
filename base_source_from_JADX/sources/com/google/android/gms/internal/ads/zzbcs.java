package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;

public final class zzbcs extends zza {
    final zzbbe zzehi;
    private final String zzeiv;
    private final String[] zzeiw;
    final zzbcx zzeny;

    zzbcs(zzbbe zzbbe, zzbcx zzbcx, String str, String[] strArr) {
        this.zzehi = zzbbe;
        this.zzeny = zzbcx;
        this.zzeiv = str;
        this.zzeiw = strArr;
        zzp.zzlm().zza(this);
    }

    public final void zzvm() {
        try {
            this.zzeny.zze(this.zzeiv, this.zzeiw);
        } finally {
            zzm.zzedd.post(new zzbcv(this));
        }
    }
}
