package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdfj;

final class zzdbz<S extends zzdfj<?>> {
    private final Clock zzbpw;
    public final zzdyz<S> zzgzm;
    private final long zzgzn;

    public zzdbz(zzdyz<S> zzdyz, long j, Clock clock) {
        this.zzgzm = zzdyz;
        this.zzbpw = clock;
        this.zzgzn = clock.elapsedRealtime() + j;
    }

    public final boolean hasExpired() {
        return this.zzgzn < this.zzbpw.elapsedRealtime();
    }
}
