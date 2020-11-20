package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

public final class zzcrc<DelegateT, AdapterT> implements zzcqz<AdapterT> {
    @VisibleForTesting
    private final zzcqz<DelegateT> zzgqq;
    private final zzdvm<DelegateT, AdapterT> zzgqr;

    public zzcrc(zzcqz<DelegateT> zzcqz, zzdvm<DelegateT, AdapterT> zzdvm) {
        this.zzgqq = zzcqz;
        this.zzgqr = zzdvm;
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return this.zzgqq.zza(zzdnj, zzdmu);
    }

    public final zzdyz<AdapterT> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdyr.zzb(this.zzgqq.zzb(zzdnj, zzdmu), this.zzgqr, (Executor) zzazj.zzegp);
    }
}
