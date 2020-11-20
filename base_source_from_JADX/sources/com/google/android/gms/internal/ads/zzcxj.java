package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcxj extends zzwx {
    private final zzcyh zzgvm;

    public zzcxj(Context context, zzbgm zzbgm, zzdnp zzdnp, zzccl zzccl, zzwt zzwt) {
        zzcyj zzcyj = new zzcyj(zzccl);
        zzcyj.zzd(zzwt);
        this.zzgvm = new zzcyh(new zzcyp(zzbgm, context, zzcyj, zzdnp), zzdnp.zzauq());
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.zzgvm.getMediationAdapterClassName();
    }

    public final synchronized boolean isLoading() {
        return this.zzgvm.isLoading();
    }

    public final synchronized void zza(zzvk zzvk, int i) {
        this.zzgvm.zza(zzvk, i);
    }

    public final void zzb(zzvk zzvk) {
        this.zzgvm.zza(zzvk, 1);
    }

    public final synchronized String zzkg() {
        return this.zzgvm.zzkg();
    }
}
