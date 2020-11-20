package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzvr;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdapterResponseInfo {
    private final zzvr zzadd;
    private final AdError zzade;

    private AdapterResponseInfo(zzvr zzvr) {
        this.zzadd = zzvr;
        this.zzade = zzvr.zzcia == null ? null : zzvr.zzcia.zzpl();
    }

    public static AdapterResponseInfo zza(zzvr zzvr) {
        if (zzvr != null) {
            return new AdapterResponseInfo(zzvr);
        }
        return null;
    }

    public final AdError getAdError() {
        return this.zzade;
    }

    public final String getAdapterClassName() {
        return this.zzadd.zzchy;
    }

    public final Bundle getCredentials() {
        return this.zzadd.zzcib;
    }

    public final long getLatencyMillis() {
        return this.zzadd.zzchz;
    }

    public final String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzdr() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.zzadd.zzchy);
        jSONObject.put("Latency", this.zzadd.zzchz);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.zzadd.zzcib.keySet()) {
            jSONObject2.put(str, this.zzadd.zzcib.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.zzade;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzdr());
        }
        return jSONObject;
    }
}
