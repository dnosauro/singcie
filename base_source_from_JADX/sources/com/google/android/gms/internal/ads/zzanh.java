package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzanh {
    private final long zzdlq;
    public final List<zzane> zzdlr;
    private final List<String> zzdls;
    private final List<String> zzdlt;
    private final List<String> zzdlu;
    private final List<String> zzdlv;
    private final List<String> zzdlw;
    private final boolean zzdlx;
    private final String zzdly;
    private final long zzdlz;
    private final String zzdma;
    private final int zzdmb;
    private final int zzdmc;
    private final long zzdmd;
    private final boolean zzdme;
    private final boolean zzdmf;
    private final boolean zzdmg;
    private final boolean zzdmh;
    private int zzdmi;
    private int zzdmj;
    private boolean zzdmk;

    public zzanh(JSONObject jSONObject) {
        if (zzd.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzd.zzee(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzane zzane = new zzane(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzane.zzdlp)) {
                    this.zzdmk = true;
                }
                arrayList.add(zzane);
                if (i < 0) {
                    Iterator<String> it = zzane.zzdkw.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdmi = i;
        this.zzdmj = jSONArray.length();
        this.zzdlr = Collections.unmodifiableList(arrayList);
        this.zzdly = jSONObject.optString("qdata");
        this.zzdmc = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.zzdmd = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzdlq = optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzp.zzli();
            this.zzdls = zzang.zza(optJSONObject, "click_urls");
            zzp.zzli();
            this.zzdlt = zzang.zza(optJSONObject, "imp_urls");
            zzp.zzli();
            this.zzdlu = zzang.zza(optJSONObject, "downloaded_imp_urls");
            zzp.zzli();
            this.zzdlv = zzang.zza(optJSONObject, "nofill_urls");
            zzp.zzli();
            this.zzdlw = zzang.zza(optJSONObject, "remote_ping_urls");
            this.zzdlx = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzdlz = optLong > 0 ? 1000 * optLong : j;
            zzava zza = zzava.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzdma = null;
                this.zzdmb = 0;
            } else {
                this.zzdma = zza.type;
                this.zzdmb = zza.zzdxu;
            }
            this.zzdme = optJSONObject.optBoolean("use_displayed_impression", false);
            this.zzdmf = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzdmg = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.zzdmh = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzdlq = -1;
        this.zzdls = null;
        this.zzdlt = null;
        this.zzdlu = null;
        this.zzdlv = null;
        this.zzdlw = null;
        this.zzdlz = -1;
        this.zzdma = null;
        this.zzdmb = 0;
        this.zzdme = false;
        this.zzdlx = false;
        this.zzdmf = false;
        this.zzdmg = false;
        this.zzdmh = false;
    }
}
