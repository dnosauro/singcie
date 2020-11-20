package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzcis {
    private final Executor executor;
    private final Map<String, Map<String, JSONObject>> zzgjd = new ConcurrentHashMap();
    private JSONObject zzgje;
    private boolean zzwm;

    public zzcis(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzapj */
    public final synchronized void zzapm() {
        Map map;
        this.zzwm = true;
        zzayh zzxv = zzp.zzku().zzwz().zzxv();
        if (zzxv != null) {
            JSONObject zzxi = zzxv.zzxi();
            if (zzxi != null) {
                this.zzgje = zzxi.optJSONObject("ad_unit_patterns");
                JSONArray optJSONArray = zzxi.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("ad_unit_id");
                            String optString2 = optJSONObject.optString("format");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                            if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                                if (this.zzgjd.containsKey(optString2)) {
                                    map = this.zzgjd.get(optString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.zzgjd.put(optString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(optString, optJSONObject2);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void zzapi() {
        zzp.zzku().zzwz().zzb(new zzcir(this));
        this.executor.execute(new zzciu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzapl() {
        this.executor.execute(new zzcit(this));
    }

    @CheckForNull
    public final JSONObject zzq(String str, String str2) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcss)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzwm) {
            zzapm();
        }
        Map map = this.zzgjd.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza = zzciv.zza(this.zzgje, str, str2);
        if (zza == null) {
            return null;
        }
        return (JSONObject) map.get(zza);
    }
}
