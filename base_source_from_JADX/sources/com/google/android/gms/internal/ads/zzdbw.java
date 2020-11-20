package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdfj;
import java.util.concurrent.atomic.AtomicReference;

public final class zzdbw<S extends zzdfj<?>> implements zzdfi<S> {
    private final Clock zzbpw;
    private final AtomicReference<zzdbz<S>> zzgzj = new AtomicReference<>();
    private final zzdfi<S> zzgzk;
    private final long zzgzl;

    public zzdbw(zzdfi<S> zzdfi, long j, Clock clock) {
        this.zzbpw = clock;
        this.zzgzk = zzdfi;
        this.zzgzl = j;
    }

    public final zzdyz<S> zzasm() {
        zzdbz zzdbz = this.zzgzj.get();
        if (zzdbz == null || zzdbz.hasExpired()) {
            zzdbz = new zzdbz(this.zzgzk.zzasm(), this.zzgzl, this.zzbpw);
            this.zzgzj.set(zzdbz);
        }
        return zzdbz.zzgzm;
    }
}
