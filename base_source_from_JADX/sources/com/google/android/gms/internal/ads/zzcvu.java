package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzcvu implements zzcre<zzapo, zzcst> {
    private final zzcwx zzgty;

    public zzcvu(zzcwx zzcwx) {
        this.zzgty = zzcwx;
    }

    public final zzcrb<zzapo, zzcst> zzf(String str, JSONObject jSONObject) {
        zzapo zzgm = this.zzgty.zzgm(str);
        if (zzgm == null) {
            return null;
        }
        return new zzcrb<>(zzgm, new zzcst(), str);
    }
}
