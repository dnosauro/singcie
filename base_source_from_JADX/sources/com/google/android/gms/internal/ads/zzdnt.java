package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

final /* synthetic */ class zzdnt implements zzahv {
    private final zzdrz zzhjb;
    private final zzcqo zzhjc;

    zzdnt(zzdrz zzdrz, zzcqo zzcqo) {
        this.zzhjb = zzdrz;
        this.zzhjc = zzcqo;
    }

    /* JADX WARNING: type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbex, com.google.android.gms.internal.ads.zzbdk] */
    public final void zza(Object obj, Map map) {
        zzdrz zzdrz = this.zzhjb;
        zzcqo zzcqo = this.zzhjc;
        ? r9 = (zzbdk) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzd.zzfa("URL missing from click GMSG.");
            return;
        }
        String zza = zzahc.zza(r9, str);
        if (!r9.zzabw().zzhhq) {
            zzdrz.zzeo(zza);
            return;
        }
        long currentTimeMillis = zzp.zzkx().currentTimeMillis();
        String str2 = r9.zzadk().zzbvf;
        zzp.zzkq();
        zzcqo.zza(new zzcqv(currentTimeMillis, str2, zza, zzm.zzbc(((zzbex) r9).getContext()) ? zzcql.zzgqc : zzcql.zzgqb));
    }
}
