package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

final /* synthetic */ class zzdnw implements zzahv {
    private final zzdrz zzhjb;
    private final zzcqo zzhjc;

    zzdnw(zzdrz zzdrz, zzcqo zzcqo) {
        this.zzhjb = zzdrz;
        this.zzhjc = zzcqo;
    }

    public final void zza(Object obj, Map map) {
        zzdrz zzdrz = this.zzhjb;
        zzcqo zzcqo = this.zzhjc;
        zzbdk zzbdk = (zzbdk) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzd.zzfa("URL missing from httpTrack GMSG.");
        } else if (!zzbdk.zzabw().zzhhq) {
            zzdrz.zzeo(str);
        } else {
            zzcqo.zza(new zzcqv(zzp.zzkx().currentTimeMillis(), ((zzbeq) zzbdk).zzadk().zzbvf, str, zzcql.zzgqc));
        }
    }
}
