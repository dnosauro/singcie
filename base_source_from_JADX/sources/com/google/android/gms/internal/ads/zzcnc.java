package com.google.android.gms.internal.ads;

public abstract class zzcnc implements zzdyb<zzatl, zzdnj> {
    /* access modifiers changed from: private */
    public final zzbuh zzgmr;

    public zzcnc(zzbuh zzbuh) {
        this.zzgmr = zzbuh;
    }

    /* access modifiers changed from: protected */
    public abstract zzdyz<zzdnj> zzb(zzatl zzatl);

    public final /* synthetic */ zzdyz zzf(Object obj) {
        zzatl zzatl = (zzatl) obj;
        this.zzgmr.zzd(zzatl);
        zzdyz<zzdnj> zzb = zzb(zzatl);
        zzdyr.zza(zzb, new zzcnb(this), zzazj.zzegu);
        return zzb;
    }
}
