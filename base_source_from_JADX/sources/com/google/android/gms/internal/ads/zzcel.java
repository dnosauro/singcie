package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcel implements zzepf<zzcej> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzax> zzfgi;
    private final zzeps<Clock> zzfrf;

    public zzcel(zzeps<zzax> zzeps, zzeps<Clock> zzeps2, zzeps<Executor> zzeps3) {
        this.zzfgi = zzeps;
        this.zzfrf = zzeps2;
        this.zzevg = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcej(this.zzfgi.get(), this.zzfrf.get(), this.zzevg.get());
    }
}
