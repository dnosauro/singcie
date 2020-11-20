package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaqq {
    private final boolean zzdpe;
    private final boolean zzdpf;
    private final boolean zzdpg;
    private final boolean zzdph;
    private final boolean zzdpi;

    private zzaqq(zzaqs zzaqs) {
        this.zzdpe = zzaqs.zzdpe;
        this.zzdpf = zzaqs.zzdpf;
        this.zzdpg = zzaqs.zzdpg;
        this.zzdph = zzaqs.zzdph;
        this.zzdpi = zzaqs.zzdpi;
    }

    public final JSONObject zzdr() {
        try {
            return new JSONObject().put("sms", this.zzdpe).put("tel", this.zzdpf).put("calendar", this.zzdpg).put("storePicture", this.zzdph).put("inlineVideo", this.zzdpi);
        } catch (JSONException e) {
            zzd.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
