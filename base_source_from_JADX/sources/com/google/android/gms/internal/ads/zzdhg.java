package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdhg implements zzepf<zzdhe> {
    private final zzeps<zzamy> zzewn;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<ApplicationInfo> zzgmm;
    private final zzeps<Boolean> zzhct;

    public zzdhg(zzeps<zzamy> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<Boolean> zzeps3, zzeps<ApplicationInfo> zzeps4) {
        this.zzewn = zzeps;
        this.zzfqh = zzeps2;
        this.zzhct = zzeps3;
        this.zzgmm = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzdhe(this.zzewn.get(), this.zzfqh.get(), this.zzhct.get().booleanValue(), this.zzgmm.get());
    }
}
