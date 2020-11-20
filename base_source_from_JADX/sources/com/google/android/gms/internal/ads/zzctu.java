package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzctu implements Callable {
    private final zzdyz zzfvd;
    private final zzdyz zzfxh;
    private final zzctn zzgsk;
    private final zzdnj zzgsn;
    private final zzdmu zzgso;
    private final JSONObject zzgsp;

    zzctu(zzctn zzctn, zzdyz zzdyz, zzdyz zzdyz2, zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        this.zzgsk = zzctn;
        this.zzfxh = zzdyz;
        this.zzfvd = zzdyz2;
        this.zzgsn = zzdnj;
        this.zzgso = zzdmu;
        this.zzgsp = jSONObject;
    }

    public final Object call() {
        return this.zzgsk.zza(this.zzfxh, this.zzfvd, this.zzgsn, this.zzgso, this.zzgsp);
    }
}
