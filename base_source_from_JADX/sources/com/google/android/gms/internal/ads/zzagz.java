package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzagz implements zzahv<Object> {
    private final zzagy zzdfr;

    public zzagz(zzagy zzagy) {
        this.zzdfr = zzagy;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzdfr != null) {
            String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (str == null) {
                zzd.zzez("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzbk.zzh(new JSONObject(map.get("info")));
                } catch (JSONException e) {
                    zzd.zzc("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzd.zzey("Failed to convert ad metadata to Bundle.");
            } else {
                this.zzdfr.zza(str, bundle);
            }
        }
    }
}
