package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzcvi implements zzdvm {
    private final zzdmu zzfto;
    private final zzbdv zzgfj;
    private final zzcve zzgtl;
    private final zzche zzgtm;

    zzcvi(zzcve zzcve, zzbdv zzbdv, zzdmu zzdmu, zzche zzche) {
        this.zzgtl = zzcve;
        this.zzgfj = zzbdv;
        this.zzfto = zzdmu;
        this.zzgtm = zzche;
    }

    public final Object apply(Object obj) {
        zzbdv zzbdv = this.zzgfj;
        zzdmu zzdmu = this.zzfto;
        zzche zzche = this.zzgtm;
        if (zzdmu.zzdxi) {
            zzbdv.zzadf();
        }
        zzbdv.zzacm();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcoc)).booleanValue()) {
            zzp.zzks();
            zzu.zza(zzbdv);
        }
        return zzche.zzahq();
    }
}
