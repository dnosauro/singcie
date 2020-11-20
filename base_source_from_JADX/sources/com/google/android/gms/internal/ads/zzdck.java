package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdck implements zzepf<zzdcg> {
    private final zzeps<zzamy> zzewn;
    private final zzeps<zzf> zzfcl;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<ApplicationInfo> zzgmm;

    private zzdck(zzeps<zzamy> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<zzf> zzeps3, zzeps<ApplicationInfo> zzeps4, zzeps<zzdnn> zzeps5) {
        this.zzewn = zzeps;
        this.zzfqh = zzeps2;
        this.zzfcl = zzeps3;
        this.zzgmm = zzeps4;
        this.zzfts = zzeps5;
    }

    public static zzdck zzh(zzeps<zzamy> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<zzf> zzeps3, zzeps<ApplicationInfo> zzeps4, zzeps<zzdnn> zzeps5) {
        return new zzdck(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzdcg(this.zzewn.get(), this.zzfqh.get(), this.zzfcl.get(), this.zzgmm.get(), this.zzfts.get());
    }
}
