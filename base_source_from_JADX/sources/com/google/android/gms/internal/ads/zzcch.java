package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcch extends zzcci {
    private final boolean zzdmf;
    private final boolean zzdmg;
    private final boolean zzdvl;
    private final JSONObject zzgdg;
    private final boolean zzgdh;

    public zzcch(zzdmu zzdmu, JSONObject jSONObject) {
        super(zzdmu);
        this.zzgdg = zzbk.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzdmg = zzbk.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdmf = zzbk.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdvl = zzbk.zza(false, jSONObject, "enable_omid");
        if (!(jSONObject == null || jSONObject.optJSONObject("overlay") == null)) {
            z = true;
        }
        this.zzgdh = z;
    }

    public final boolean zzamy() {
        return this.zzdvl;
    }

    public final JSONObject zzann() {
        JSONObject jSONObject = this.zzgdg;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzgdi.zzduv);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzano() {
        return this.zzgdh;
    }

    public final boolean zzanp() {
        return this.zzdmg;
    }

    public final boolean zzanq() {
        return this.zzdmf;
    }
}
