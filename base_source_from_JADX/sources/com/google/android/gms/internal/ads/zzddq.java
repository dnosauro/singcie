package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzf;

public final class zzddq implements zzepf<zzddn> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<zzf> zzfcl;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<PackageInfo> zzfxd;

    public zzddq(zzeps<zzdzc> zzeps, zzeps<zzdnn> zzeps2, zzeps<PackageInfo> zzeps3, zzeps<zzf> zzeps4) {
        this.zzevg = zzeps;
        this.zzfts = zzeps2;
        this.zzfxd = zzeps3;
        this.zzfcl = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzddn(this.zzevg.get(), this.zzfts.get(), this.zzfxd.get(), this.zzfcl.get());
    }
}
