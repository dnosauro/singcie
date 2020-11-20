package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzczs implements zzdyb<zzatl, zzczx> {
    private Executor executor;
    private zzcmx zzgxv;

    public zzczs(Executor executor2, zzcmx zzcmx) {
        this.executor = executor2;
        this.zzgxv = zzcmx;
    }

    public final /* synthetic */ zzdyz zzf(Object obj) {
        zzatl zzatl = (zzatl) obj;
        return zzdyr.zzb(this.zzgxv.zzg(zzatl), new zzczv(zzatl), this.executor);
    }
}
