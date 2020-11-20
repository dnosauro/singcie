package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcen implements Callable {
    private final zzdmu zzfto;
    private final zzceo zzgfy;
    private final zzdnj zzgfz;
    private final JSONObject zzgga;

    zzcen(zzceo zzceo, zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        this.zzgfy = zzceo;
        this.zzgfz = zzdnj;
        this.zzfto = zzdmu;
        this.zzgga = jSONObject;
    }

    public final Object call() {
        zzdnj zzdnj = this.zzgfz;
        zzdmu zzdmu = this.zzfto;
        JSONObject jSONObject = this.zzgga;
        zzcce zzcce = new zzcce();
        zzcce.zzdz(jSONObject.optInt("template_id", -1));
        zzcce.zzfx(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzcce.zzfy(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzdnn zzdnn = zzdnj.zzhij.zzfvl;
        if (zzdnn.zzhiq.contains(Integer.toString(zzcce.zzanc()))) {
            if (zzcce.zzanc() == 3) {
                if (zzcce.getCustomTemplateId() == null) {
                    throw new zzcuq(zzdok.INTERNAL_ERROR, "No custom template id for custom template ad response.");
                } else if (!zzdnn.zzhir.contains(zzcce.getCustomTemplateId())) {
                    throw new zzcuq(zzdok.INTERNAL_ERROR, "Unexpected custom template id in the response.");
                }
            }
            zzcce.setStarRating(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzdmu.zzdxi) {
                zzp.zzkq();
                String zzyi = zzm.zzyi();
                StringBuilder sb = new StringBuilder(String.valueOf(zzyi).length() + 3 + String.valueOf(optString).length());
                sb.append(zzyi);
                sb.append(" : ");
                sb.append(optString);
                optString = sb.toString();
            }
            zzcce.zzn("headline", optString);
            zzcce.zzn("body", jSONObject.optString("body", (String) null));
            zzcce.zzn("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzcce.zzn("store", jSONObject.optString("store", (String) null));
            zzcce.zzn(FirebaseAnalytics.Param.PRICE, jSONObject.optString(FirebaseAnalytics.Param.PRICE, (String) null));
            zzcce.zzn("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzcce;
        }
        zzdok zzdok = zzdok.INTERNAL_ERROR;
        int zzanc = zzcce.zzanc();
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid template ID: ");
        sb2.append(zzanc);
        throw new zzcuq(zzdok, sb2.toString());
    }
}
