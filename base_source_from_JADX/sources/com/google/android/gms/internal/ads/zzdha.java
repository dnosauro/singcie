package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdha implements zzdfj<JSONObject> {
    private List<String> zzdtc;

    public zzdha(List<String> list) {
        this.zzdtc = list;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.zzdtc));
        } catch (JSONException unused) {
            zzd.zzee("Failed putting experiment ids.");
        }
    }
}
