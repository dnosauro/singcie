package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdfx implements zzdfj<JSONObject> {
    private final AdvertisingIdClient.Info zzhbx;
    private final String zzhby;

    public zzdfx(AdvertisingIdClient.Info info, String str) {
        this.zzhbx = info;
        this.zzhby = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzbk.zzb((JSONObject) obj, "pii");
            if (this.zzhbx == null || TextUtils.isEmpty(this.zzhbx.getId())) {
                zzb.put("pdid", this.zzhby);
                zzb.put("pdidtype", "ssaid");
                return;
            }
            zzb.put("rdid", this.zzhbx.getId());
            zzb.put("is_lat", this.zzhbx.isLimitAdTrackingEnabled());
            zzb.put("idtype", "adid");
        } catch (JSONException e) {
            zzd.zza("Failed putting Ad ID.", e);
        }
    }
}
