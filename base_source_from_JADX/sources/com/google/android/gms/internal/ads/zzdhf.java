package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdhf implements zzdfj<JSONObject> {
    private final Location zzmy;

    public zzdhf(Location location) {
        this.zzmy = location;
    }

    public final /* synthetic */ void zzs(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (this.zzmy != null) {
                JSONObject jSONObject2 = new JSONObject();
                Float valueOf = Float.valueOf(this.zzmy.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(this.zzmy.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (this.zzmy.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (this.zzmy.getLongitude() * 1.0E7d));
                jSONObject2.put("radius", valueOf);
                jSONObject2.put("lat", valueOf3);
                jSONObject2.put("long", valueOf4);
                jSONObject2.put("time", valueOf2);
                jSONObject.put("uule", jSONObject2);
            }
        } catch (JSONException e) {
            zzd.zza("Failed adding location to the request JSON.", e);
        }
    }
}
