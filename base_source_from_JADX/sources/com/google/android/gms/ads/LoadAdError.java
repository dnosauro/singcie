package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;
import org.json.JSONException;
import org.json.JSONObject;

public final class LoadAdError extends AdError {
    private final ResponseInfo zzadi;

    public LoadAdError(int i, String str, String str2, AdError adError, ResponseInfo responseInfo) {
        super(i, str, str2, adError);
        this.zzadi = responseInfo;
    }

    public final ResponseInfo getResponseInfo() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            return this.zzadi;
        }
        return null;
    }

    public final String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzdr() {
        JSONObject zzdr = super.zzdr();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            zzdr.put("Response Info", "null");
        } else {
            zzdr.put("Response Info", responseInfo.zzdr());
        }
        return zzdr;
    }
}
