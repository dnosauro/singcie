package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.Callable;

final class zzo implements Callable<zzef> {
    private final /* synthetic */ zzj zzbpl;

    zzo(zzj zzj) {
        this.zzbpl = zzj;
    }

    public final /* synthetic */ Object call() {
        return new zzef(zzeg.zzb(this.zzbpl.zzbpd.zzbrf, this.zzbpl.context, false));
    }
}
