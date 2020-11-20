package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzceq implements Callable {
    private final zzdyz zzfvd;
    private final zzdyz zzfxh;
    private final zzceo zzgfy;
    private final zzdyz zzggg;
    private final zzdyz zzggh;
    private final zzdyz zzggi;
    private final JSONObject zzggj;
    private final zzdyz zzggk;
    private final zzdyz zzggl;
    private final zzdyz zzggm;

    zzceq(zzceo zzceo, zzdyz zzdyz, zzdyz zzdyz2, zzdyz zzdyz3, zzdyz zzdyz4, zzdyz zzdyz5, JSONObject jSONObject, zzdyz zzdyz6, zzdyz zzdyz7, zzdyz zzdyz8) {
        this.zzgfy = zzceo;
        this.zzfxh = zzdyz;
        this.zzfvd = zzdyz2;
        this.zzggg = zzdyz3;
        this.zzggh = zzdyz4;
        this.zzggi = zzdyz5;
        this.zzggj = jSONObject;
        this.zzggk = zzdyz6;
        this.zzggl = zzdyz7;
        this.zzggm = zzdyz8;
    }

    public final Object call() {
        zzdyz zzdyz = this.zzfxh;
        zzdyz zzdyz2 = this.zzfvd;
        zzdyz zzdyz3 = this.zzggg;
        zzdyz zzdyz4 = this.zzggh;
        zzdyz zzdyz5 = this.zzggi;
        JSONObject jSONObject = this.zzggj;
        zzdyz zzdyz6 = this.zzggk;
        zzdyz zzdyz7 = this.zzggl;
        zzdyz zzdyz8 = this.zzggm;
        zzcce zzcce = (zzcce) zzdyz.get();
        zzcce.setImages((List) zzdyz2.get());
        zzcce.zza((zzaej) zzdyz3.get());
        zzcce.zzb((zzaej) zzdyz4.get());
        zzcce.zza((zzaeb) zzdyz5.get());
        zzcce.zzh(zzces.zzj(jSONObject));
        zzcce.zza(zzces.zzk(jSONObject));
        zzbdv zzbdv = (zzbdv) zzdyz6.get();
        if (zzbdv != null) {
            zzcce.zzi(zzbdv);
            zzcce.zzac(zzbdv.getView());
            zzcce.zzb((zzys) zzbdv.zzaah());
        }
        zzbdv zzbdv2 = (zzbdv) zzdyz7.get();
        if (zzbdv2 != null) {
            zzcce.zzj(zzbdv2);
        }
        for (zzcfd zzcfd : (List) zzdyz8.get()) {
            switch (zzcfd.type) {
                case 1:
                    zzcce.zzn(zzcfd.zzck, zzcfd.zzdpv);
                    break;
                case 2:
                    zzcce.zza(zzcfd.zzck, zzcfd.zzggw);
                    break;
            }
        }
        return zzcce;
    }
}
