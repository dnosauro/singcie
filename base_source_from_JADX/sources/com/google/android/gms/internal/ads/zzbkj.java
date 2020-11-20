package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzbkj implements zzepf<zzbki> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzamq> zzfrc;
    private final zzeps<zzbkg> zzfrd;
    private final zzeps<zzbjz> zzfre;
    private final zzeps<Clock> zzfrf;

    private zzbkj(zzeps<zzamq> zzeps, zzeps<zzbkg> zzeps2, zzeps<Executor> zzeps3, zzeps<zzbjz> zzeps4, zzeps<Clock> zzeps5) {
        this.zzfrc = zzeps;
        this.zzfrd = zzeps2;
        this.zzevg = zzeps3;
        this.zzfre = zzeps4;
        this.zzfrf = zzeps5;
    }

    public static zzbkj zza(zzeps<zzamq> zzeps, zzeps<zzbkg> zzeps2, zzeps<Executor> zzeps3, zzeps<zzbjz> zzeps4, zzeps<Clock> zzeps5) {
        return new zzbkj(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzbki(this.zzfrc.get(), this.zzfrd.get(), this.zzevg.get(), this.zzfre.get(), this.zzfrf.get());
    }
}
