package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzceo {
    private final zzdzc zzggb;
    private final zzces zzggc;
    private final zzcfc zzggd;

    public zzceo(zzdzc zzdzc, zzces zzces, zzcfc zzcfc) {
        this.zzggb = zzdzc;
        this.zzggc = zzces;
        this.zzggd = zzcfc;
    }

    public final zzdyz<zzcce> zza(zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        JSONObject optJSONObject;
        zzdyz zzb;
        JSONObject jSONObject2 = jSONObject;
        zzdnj zzdnj2 = zzdnj;
        zzdyz zze = this.zzggb.zze(new zzcen(this, zzdnj, zzdmu, jSONObject2));
        zzdyz<List<zzadv>> zzd = this.zzggc.zzd(jSONObject2, "images");
        zzdyz<zzadv> zzc = this.zzggc.zzc(jSONObject2, "secondary_image");
        zzdyz<zzadv> zzc2 = this.zzggc.zzc(jSONObject2, "app_icon");
        zzdyz<zzadq> zze2 = this.zzggc.zze(jSONObject2, "attribution");
        zzdyz<zzbdv> zzm = this.zzggc.zzm(jSONObject2);
        zzces zzces = this.zzggc;
        if (jSONObject2.optBoolean("enable_omid") && (optJSONObject = jSONObject2.optJSONObject("omid_settings")) != null) {
            String optString = optJSONObject.optString("omid_html");
            if (!TextUtils.isEmpty(optString)) {
                zzb = zzdyr.zzb(zzdyr.zzag(null), new zzcew(zzces, optString), (Executor) zzazj.zzegt);
                zzdyz zzdyz = zzb;
                zzdyz<List<zzcfd>> zzg = this.zzggd.zzg(jSONObject2, "custom_assets");
                return zzdyr.zza((zzdyz<? extends V>[]) new zzdyz[]{zze, zzd, zzc, zzc2, zze2, zzm, zzdyz, zzg}).zza(new zzceq(this, zze, zzd, zzc2, zzc, zze2, jSONObject, zzm, zzdyz, zzg), this.zzggb);
            }
        }
        zzb = zzdyr.zzag(null);
        zzdyz zzdyz2 = zzb;
        zzdyz<List<zzcfd>> zzg2 = this.zzggd.zzg(jSONObject2, "custom_assets");
        return zzdyr.zza((zzdyz<? extends V>[]) new zzdyz[]{zze, zzd, zzc, zzc2, zze2, zzm, zzdyz2, zzg2}).zza(new zzceq(this, zze, zzd, zzc2, zzc, zze2, jSONObject, zzm, zzdyz2, zzg2), this.zzggb);
    }
}
