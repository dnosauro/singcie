package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

public final class zzday implements zzdfi<zzdfj<Bundle>> {
    private final Executor executor;
    private final zzayg zzbpt;

    zzday(Executor executor2, zzayg zzayg) {
        this.executor = executor2;
        this.zzbpt = zzayg;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcrd)).booleanValue() ? zzdyr.zzag(null) : zzdyr.zzb(this.zzbpt.zzxa(), zzdbb.zzdza, this.executor);
    }
}
