package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzcsz implements zzdvm {
    private final zzdmu zzfto;
    private final zzbdv zzgfj;
    private final zzcsv zzgsd;
    private final zzbyz zzgse;

    zzcsz(zzcsv zzcsv, zzbdv zzbdv, zzdmu zzdmu, zzbyz zzbyz) {
        this.zzgsd = zzcsv;
        this.zzgfj = zzbdv;
        this.zzfto = zzdmu;
        this.zzgse = zzbyz;
    }

    public final Object apply(Object obj) {
        zzbdv zzbdv = this.zzgfj;
        zzdmu zzdmu = this.zzfto;
        zzbyz zzbyz = this.zzgse;
        if (zzdmu.zzdxi) {
            zzbdv.zzadf();
        }
        zzbdv.zzacm();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcoc)).booleanValue()) {
            zzp.zzks();
            zzu.zza(zzbdv);
        }
        return zzbyz.zzahh();
    }
}
