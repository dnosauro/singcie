package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzcgj implements zzdyb {
    private final String zzdha;
    private final zzcgh zzghl;
    private final JSONObject zzghm;

    zzcgj(zzcgh zzcgh, String str, JSONObject jSONObject) {
        this.zzghl = zzcgh;
        this.zzdha = str;
        this.zzghm = jSONObject;
    }

    public final zzdyz zzf(Object obj) {
        return this.zzghl.zza(this.zzdha, this.zzghm, (zzbdv) obj);
    }
}
