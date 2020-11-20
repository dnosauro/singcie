package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdhx implements zzdfj<JSONObject> {
    private final Map<String, Object> zzhcy;

    public zzdhx(Map<String, Object> map) {
        this.zzhcy = map;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzp.zzkq().zzj((Map<String, ?>) this.zzhcy));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.zzee(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
