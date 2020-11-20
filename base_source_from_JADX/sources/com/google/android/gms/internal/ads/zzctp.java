package com.google.android.gms.internal.ads;

import org.json.JSONArray;

final /* synthetic */ class zzctp implements zzdyb {
    private final zzdmu zzfto;
    private final zzdnj zzgfz;
    private final zzctn zzgsk;

    zzctp(zzctn zzctn, zzdnj zzdnj, zzdmu zzdmu) {
        this.zzgsk = zzctn;
        this.zzgfz = zzdnj;
        this.zzfto = zzdmu;
    }

    public final zzdyz zzf(Object obj) {
        return this.zzgsk.zza(this.zzgfz, this.zzfto, (JSONArray) obj);
    }
}
