package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdgh implements zzdfj<JSONObject> {
    private final JSONObject zzhce;

    public zzdgh(JSONObject jSONObject) {
        this.zzhce = jSONObject;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzbk.zzb((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.zzhce;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject.get(next));
            }
        } catch (JSONException unused) {
            zzd.zzee("Failed putting app indexing json.");
        }
    }
}
