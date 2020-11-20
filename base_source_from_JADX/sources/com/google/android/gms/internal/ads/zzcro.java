package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzcro implements zzdvm {
    private final zzdmu zzfto;
    private final zzbdv zzgfj;
    private final zzcrk zzgqv;
    private final zzbln zzgrc;

    zzcro(zzcrk zzcrk, zzbdv zzbdv, zzdmu zzdmu, zzbln zzbln) {
        this.zzgqv = zzcrk;
        this.zzgfj = zzbdv;
        this.zzfto = zzdmu;
        this.zzgrc = zzbln;
    }

    public final Object apply(Object obj) {
        zzbdv zzbdv = this.zzgfj;
        zzdmu zzdmu = this.zzfto;
        zzbln zzbln = this.zzgrc;
        if (zzdmu.zzdxi) {
            zzbdv.zzadf();
        }
        zzbdv.zzacm();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcoc)).booleanValue()) {
            zzp.zzks();
            zzu.zza(zzbdv);
        }
        return zzbln.zzagq();
    }
}
