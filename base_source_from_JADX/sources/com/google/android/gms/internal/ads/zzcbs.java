package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcbs implements zzepf<zzbkr> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<Clock> zzfrf;
    private final zzeps<zzqr> zzgbs;

    public zzcbs(zzeps<zzqr> zzeps, zzeps<Executor> zzeps2, zzeps<Context> zzeps3, zzeps<Clock> zzeps4) {
        this.zzgbs = zzeps;
        this.zzevg = zzeps2;
        this.zzevi = zzeps3;
        this.zzfrf = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return (zzbkr) zzepl.zza(new zzbkr(this.zzevg.get(), new zzbkg(this.zzevi.get(), this.zzgbs.get()), this.zzfrf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
