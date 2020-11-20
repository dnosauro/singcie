package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.List;

public final class zzbrb implements zzepf<zzbqz> {
    private final zzeps<zzf> zzfcl;
    private final zzeps<zzdfl<Bundle>> zzffl;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<zzdro> zzftw;
    private final zzeps<ApplicationInfo> zzfxa;
    private final zzeps<String> zzfxb;
    private final zzeps<List<String>> zzfxc;
    private final zzeps<PackageInfo> zzfxd;
    private final zzeps<zzdyz<String>> zzfxe;
    private final zzeps<String> zzfxf;

    private zzbrb(zzeps<zzdro> zzeps, zzeps<zzazh> zzeps2, zzeps<ApplicationInfo> zzeps3, zzeps<String> zzeps4, zzeps<List<String>> zzeps5, zzeps<PackageInfo> zzeps6, zzeps<zzdyz<String>> zzeps7, zzeps<zzf> zzeps8, zzeps<String> zzeps9, zzeps<zzdfl<Bundle>> zzeps10) {
        this.zzftw = zzeps;
        this.zzfrq = zzeps2;
        this.zzfxa = zzeps3;
        this.zzfxb = zzeps4;
        this.zzfxc = zzeps5;
        this.zzfxd = zzeps6;
        this.zzfxe = zzeps7;
        this.zzfcl = zzeps8;
        this.zzfxf = zzeps9;
        this.zzffl = zzeps10;
    }

    public static zzbrb zza(zzeps<zzdro> zzeps, zzeps<zzazh> zzeps2, zzeps<ApplicationInfo> zzeps3, zzeps<String> zzeps4, zzeps<List<String>> zzeps5, zzeps<PackageInfo> zzeps6, zzeps<zzdyz<String>> zzeps7, zzeps<zzf> zzeps8, zzeps<String> zzeps9, zzeps<zzdfl<Bundle>> zzeps10) {
        return new zzbrb(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8, zzeps9, zzeps10);
    }

    public final /* synthetic */ Object get() {
        return new zzbqz(this.zzftw.get(), this.zzfrq.get(), this.zzfxa.get(), this.zzfxb.get(), this.zzfxc.get(), this.zzfxd.get(), zzepg.zzat(this.zzfxe), this.zzfcl.get(), this.zzfxf.get(), this.zzffl.get());
    }
}
