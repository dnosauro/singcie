package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

public final class zzckw implements zzepf<zzcku> {
    private final zzeps<Clock> zzfrf;
    private final zzeps<zzcko> zzgkp;
    private final zzeps<Set<zzckt>> zzgkq;

    private zzckw(zzeps<zzcko> zzeps, zzeps<Set<zzckt>> zzeps2, zzeps<Clock> zzeps3) {
        this.zzgkp = zzeps;
        this.zzgkq = zzeps2;
        this.zzfrf = zzeps3;
    }

    public static zzckw zzo(zzeps<zzcko> zzeps, zzeps<Set<zzckt>> zzeps2, zzeps<Clock> zzeps3) {
        return new zzckw(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcku(this.zzgkp.get(), this.zzgkq.get(), this.zzfrf.get());
    }
}
