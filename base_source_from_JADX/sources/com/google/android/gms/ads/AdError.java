package com.google.android.gms.ads;

import android.os.IBinder;
import com.google.android.gms.internal.ads.zzve;
import org.json.JSONException;
import org.json.JSONObject;

public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int code;
    private final String zzacm;
    private final String zzacn;
    private final AdError zzaco;

    public AdError(int i, String str, String str2) {
        this.code = i;
        this.zzacm = str;
        this.zzacn = str2;
        this.zzaco = null;
    }

    public AdError(int i, String str, String str2, AdError adError) {
        this.code = i;
        this.zzacm = str;
        this.zzacn = str2;
        this.zzaco = adError;
    }

    public AdError getCause() {
        return this.zzaco;
    }

    public int getCode() {
        return this.code;
    }

    public String getDomain() {
        return this.zzacn;
    }

    public String getMessage() {
        return this.zzacm;
    }

    public String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final zzve zzdq() {
        AdError adError = this.zzaco;
        return new zzve(this.code, this.zzacm, this.zzacn, adError == null ? null : new zzve(adError.code, adError.zzacm, adError.zzacn, (zzve) null, (IBinder) null), (IBinder) null);
    }

    public JSONObject zzdr() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.code);
        jSONObject.put("Message", this.zzacm);
        jSONObject.put("Domain", this.zzacn);
        AdError adError = this.zzaco;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzdr());
        }
        return jSONObject;
    }
}
