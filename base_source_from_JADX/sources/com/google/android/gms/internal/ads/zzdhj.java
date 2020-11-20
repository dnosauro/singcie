package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdhj implements zzdfj<JSONObject> {
    private Bundle zzhcv;

    public zzdhj(Bundle bundle) {
        this.zzhcv = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.zzhcv != null) {
            try {
                zzbk.zzb(zzbk.zzb(jSONObject, "device"), "play_store").put("parental_controls", zzp.zzkq().zzc(this.zzhcv));
            } catch (JSONException unused) {
                zzd.zzee("Failed putting parental controls bundle.");
            }
        }
    }
}
