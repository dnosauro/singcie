package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzcod implements zzcoi {
    private final zzdzc zzggb;
    private final Map<String, zzeps<zzcoi>> zzgnr;
    /* access modifiers changed from: private */
    public final zzbuh zzgns;

    public zzcod(Map<String, zzeps<zzcoi>> map, zzdzc zzdzc, zzbuh zzbuh) {
        this.zzgnr = map;
        this.zzggb = zzdzc;
        this.zzgns = zzbuh;
    }

    public final zzdyz<zzdnj> zzh(zzatl zzatl) {
        this.zzgns.zzd(zzatl);
        zzdyz<zzdnj> immediateFailedFuture = zzdyr.immediateFailedFuture(new zzcme(zzdok.NO_FILL));
        for (String trim : ((String) zzwq.zzqe().zzd(zzabf.zzcyv)).split(",")) {
            zzeps zzeps = this.zzgnr.get(trim.trim());
            if (zzeps != null) {
                immediateFailedFuture = zzdyr.zzb(immediateFailedFuture, zzcme.class, new zzcog(zzeps, zzatl), this.zzggb);
            }
        }
        zzdyr.zza(immediateFailedFuture, new zzcof(this), zzazj.zzegu);
        return immediateFailedFuture;
    }
}
