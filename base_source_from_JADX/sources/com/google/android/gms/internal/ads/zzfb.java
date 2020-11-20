package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

final class zzfb implements Runnable {
    private final /* synthetic */ int zzzj;
    private final /* synthetic */ boolean zzzk;
    private final /* synthetic */ zzfa zzzl;

    zzfb(zzfa zzfa, int i, boolean z) {
        this.zzzl = zzfa;
        this.zzzj = i;
        this.zzzk = z;
    }

    public final void run() {
        zzcf.zza zzb = this.zzzl.zzb(this.zzzj, this.zzzk);
        zzcf.zza unused = this.zzzl.zzzc = zzb;
        if (zzfa.zza(this.zzzj, zzb)) {
            this.zzzl.zza(this.zzzj + 1, this.zzzk);
        }
    }
}
