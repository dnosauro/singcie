package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONObject;

final class zzcph implements zzame<zzcpi> {
    zzcph() {
    }

    public final /* synthetic */ JSONObject zzj(Object obj) {
        zzcpi zzcpi = (zzcpi) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcpi.zzgoh.zzvu());
        jSONObject2.put("signals", zzcpi.zzgoi);
        jSONObject3.put("body", zzcpi.zzgok.zzdul);
        jSONObject3.put("headers", zzp.zzkq().zzj((Map<String, ?>) zzcpi.zzgok.zzal));
        jSONObject3.put("response_code", zzcpi.zzgok.zzgos);
        jSONObject3.put("latency", zzcpi.zzgok.zzgot);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcpi.zzgoh.zzvx());
        return jSONObject;
    }
}
