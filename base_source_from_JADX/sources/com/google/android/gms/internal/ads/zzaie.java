package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final class zzaie implements zzaih {
    private final /* synthetic */ zzazq zzdhe;

    zzaie(zzaif zzaif, zzazq zzazq) {
        this.zzdhe = zzazq;
    }

    public final void onFailure(String str) {
        this.zzdhe.setException(new zzama(str));
    }

    public final void zzc(JSONObject jSONObject) {
        this.zzdhe.set(jSONObject);
    }
}
