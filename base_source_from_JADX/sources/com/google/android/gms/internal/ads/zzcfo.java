package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcfo {
    private final Executor zzfqx;
    private final zzbxx zzgav;
    private final zzbkr zzggz;

    zzcfo(Executor executor, zzbkr zzbkr, zzbxx zzbxx) {
        this.zzfqx = executor;
        this.zzgav = zzbxx;
        this.zzggz = zzbkr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzbdv zzbdv, Map map) {
        this.zzggz.disable();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzbdv zzbdv, Map map) {
        this.zzggz.enable();
    }

    public final void zzl(zzbdv zzbdv) {
        if (zzbdv != null) {
            this.zzgav.zzv(zzbdv.getView());
            this.zzgav.zza(new zzcfn(zzbdv), this.zzfqx);
            this.zzgav.zza(new zzcfq(zzbdv), this.zzfqx);
            this.zzgav.zza(this.zzggz, this.zzfqx);
            this.zzggz.zzg(zzbdv);
            zzbdv.zza("/trackActiveViewUnit", (zzahv<? super zzbdv>) new zzcfp(this));
            zzbdv.zza("/untrackActiveViewUnit", (zzahv<? super zzbdv>) new zzcfs(this));
        }
    }
}
