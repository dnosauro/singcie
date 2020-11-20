package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzcnn implements zzdyb {
    private final zzcno zzgmz;
    private final zzvc zzgna;

    zzcnn(zzcno zzcno, zzvc zzvc) {
        this.zzgmz = zzcno;
        this.zzgna = zzvc;
    }

    public final zzdyz zzf(Object obj) {
        zzvc zzvc = this.zzgna;
        String str = (String) obj;
        String str2 = zzvc.zzcgq;
        String str3 = zzvc.zzcgr;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put("body", str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzdyr.zzag(jSONObject);
    }
}
