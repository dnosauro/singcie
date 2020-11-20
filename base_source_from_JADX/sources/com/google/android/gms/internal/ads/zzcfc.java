package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzcfc {
    private final Executor executor;
    private final zzces zzggc;

    public zzcfc(Executor executor2, zzces zzces) {
        this.executor = executor2;
        this.zzggc = zzces;
    }

    public final zzdyz<List<zzcfd>> zzg(JSONObject jSONObject, String str) {
        zzdyz<O> zzdyz;
        String optString;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdyr.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optString = optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME)) == null)) {
                String optString2 = optJSONObject.optString("type");
                switch ("string".equals(optString2) ? 1 : "image".equals(optString2) ? (char) 2 : 0) {
                    case 1:
                        zzdyz = zzdyr.zzag(new zzcfd(optString, optJSONObject.optString("string_value")));
                        continue;
                    case 2:
                        zzdyz = zzdyr.zzb(this.zzggc.zzc(optJSONObject, "image_value"), new zzcfe(optString), this.executor);
                        continue;
                }
            }
            zzdyz = zzdyr.zzag(null);
            arrayList.add(zzdyz);
        }
        return zzdyr.zzb(zzdyr.zzi(arrayList), zzcfb.zzdza, this.executor);
    }
}
