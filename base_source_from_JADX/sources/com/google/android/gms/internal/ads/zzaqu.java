package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

public class zzaqu {
    private final zzbdv zzdii;
    private final String zzdpj;

    public zzaqu(zzbdv zzbdv) {
        this(zzbdv, "");
    }

    public zzaqu(zzbdv zzbdv, String str) {
        this.zzdii = zzbdv;
        this.zzdpj = str;
    }

    public final void zza(int i, int i2, int i3, int i4) {
        try {
            this.zzdii.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzd.zzc("Error occurred while dispatching size change.", e);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzdii.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzd.zzc("Error occurred while obtaining screen information.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzdii.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzd.zzc("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzdt(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.zzdpj);
            if (this.zzdii != null) {
                this.zzdii.zzb("onError", put);
            }
        } catch (JSONException e) {
            zzd.zzc("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzdu(String str) {
        try {
            this.zzdii.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzd.zzc("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzdv(String str) {
        try {
            this.zzdii.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzd.zzc("Error occurred while dispatching state change.", e);
        }
    }
}
