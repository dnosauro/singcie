package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzdcb implements zzdfi<zzdby> {
    private final zzdnn zzfvl;
    private final zzdzc zzggb;
    private final String zzgxt;
    private final zzcis zzgzp;

    public zzdcb(zzdzc zzdzc, zzcis zzcis, zzdnn zzdnn, String str) {
        this.zzggb = zzdzc;
        this.zzgzp = zzcis;
        this.zzfvl = zzdnn;
        this.zzgxt = str;
    }

    public final zzdyz<zzdby> zzasm() {
        return this.zzggb.zze(new zzdca(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdby zzass() {
        JSONObject zzq;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcss)).booleanValue() && (zzq = this.zzgzp.zzq(this.zzfvl.zzhip, this.zzgxt)) != null) {
            return new zzdby(zzq.toString());
        }
        return null;
    }
}
