package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzane {
    private final String zzdku;
    private final String zzdkv;
    public final List<String> zzdkw;
    private final String zzdkx;
    private final String zzdky;
    private final List<String> zzdkz;
    private final List<String> zzdla;
    private final List<String> zzdlb;
    private final List<String> zzdlc;
    private final List<String> zzdld;
    public final String zzdle;
    private final List<String> zzdlf;
    private final List<String> zzdlg;
    private final List<String> zzdlh;
    private final String zzdli;
    private final String zzdlj;
    private final String zzdlk;
    private final String zzdll;
    private final String zzdlm;
    private final List<String> zzdln;
    private final String zzdlo;
    public final String zzdlp;
    private final long zzdlq;

    public zzane(JSONObject jSONObject) {
        List<String> list;
        this.zzdkv = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdkw = Collections.unmodifiableList(arrayList);
        this.zzdkx = jSONObject.optString("allocation_id", (String) null);
        zzp.zzli();
        this.zzdkz = zzang.zza(jSONObject, "clickurl");
        zzp.zzli();
        this.zzdla = zzang.zza(jSONObject, "imp_urls");
        zzp.zzli();
        this.zzdlb = zzang.zza(jSONObject, "downloaded_imp_urls");
        zzp.zzli();
        this.zzdld = zzang.zza(jSONObject, "fill_urls");
        zzp.zzli();
        this.zzdlf = zzang.zza(jSONObject, "video_start_urls");
        zzp.zzli();
        this.zzdlh = zzang.zza(jSONObject, "video_complete_urls");
        zzp.zzli();
        this.zzdlg = zzang.zza(jSONObject, "video_reward_urls");
        this.zzdli = jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        this.zzdlj = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzp.zzli();
            list = zzang.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzdlc = list;
        this.zzdku = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdle = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzdky = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzdlk = jSONObject.optString("html_template", (String) null);
        this.zzdll = jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzdlm = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzp.zzli();
        this.zzdln = zzang.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzdlo = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzdlp = jSONObject.optString("response_type", (String) null);
        this.zzdlq = jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
