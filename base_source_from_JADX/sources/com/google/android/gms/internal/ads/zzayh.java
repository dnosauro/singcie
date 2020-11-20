package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzayh {
    private String zzdto;
    private final long zzeay;
    private final List<String> zzeaz = new ArrayList();
    private final List<String> zzeba = new ArrayList();
    private final Map<String, zzanh> zzebb = new HashMap();
    private String zzebc;
    private JSONObject zzebd;
    private boolean zzebe;

    public zzayh(String str, long j) {
        JSONObject optJSONObject;
        this.zzebe = false;
        this.zzdto = str;
        this.zzeay = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zzebd = new JSONObject(str);
                if (this.zzebd.optInt("status", -1) != 1) {
                    this.zzebe = false;
                    zzd.zzfa("App settings could not be fetched successfully.");
                    return;
                }
                this.zzebe = true;
                this.zzebc = this.zzebd.optString("app_id");
                JSONArray optJSONArray = this.zzebd.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        String optString = jSONObject.optString("format");
                        String optString2 = jSONObject.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.zzeba.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject.optJSONObject("mediation_config")) != null) {
                                    this.zzebb.put(optString2, new zzanh(optJSONObject));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = this.zzebd.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.zzeaz.add(optJSONArray2.optString(i2));
                    }
                }
            } catch (JSONException e) {
                zzd.zzd("Exception occurred while processing app setting json", e);
                zzp.zzku().zza(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final long zzxd() {
        return this.zzeay;
    }

    public final boolean zzxe() {
        return this.zzebe;
    }

    public final String zzxf() {
        return this.zzdto;
    }

    public final String zzxg() {
        return this.zzebc;
    }

    public final Map<String, zzanh> zzxh() {
        return this.zzebb;
    }

    public final JSONObject zzxi() {
        return this.zzebd;
    }
}
