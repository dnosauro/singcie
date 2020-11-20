package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzctl implements zzcre<zzdoe, zzcst> {
    private final zzciq zzglg;

    public zzctl(zzciq zzciq) {
        this.zzglg = zzciq;
    }

    public final zzcrb<zzdoe, zzcst> zzf(String str, JSONObject jSONObject) {
        zzdoe zzd = this.zzglg.zzd(str, jSONObject);
        if (zzd == null) {
            return null;
        }
        return new zzcrb<>(zzd, new zzcst(), str);
    }
}
