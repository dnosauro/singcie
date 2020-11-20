package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONException;

public final class zzbrp extends zzyq {
    private final List<zzvr> zzadt;
    private final String zzfxn;
    private final String zzfxo;

    public zzbrp(zzdmu zzdmu, String str, zzcrg zzcrg) {
        this.zzfxo = zzdmu == null ? null : zzdmu.zzfxo;
        String zzb = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzb(zzdmu) : null;
        this.zzfxn = zzb == null ? str : zzb;
        this.zzadt = zzcrg.getAdapterResponses();
    }

    private static String zzb(zzdmu zzdmu) {
        try {
            return zzdmu.zzhha.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    public final List<zzvr> getAdapterResponses() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            return null;
        }
        return this.zzadt;
    }

    public final String getMediationAdapterClassName() {
        return this.zzfxn;
    }

    public final String getResponseId() {
        return this.zzfxo;
    }
}
