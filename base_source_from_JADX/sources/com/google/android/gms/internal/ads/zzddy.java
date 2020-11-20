package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public final class zzddy implements zzepf<zzddz> {
    private final zzeps<PackageInfo> zzfxd;
    private final zzeps<ApplicationInfo> zzgmm;

    private zzddy(zzeps<ApplicationInfo> zzeps, zzeps<PackageInfo> zzeps2) {
        this.zzgmm = zzeps;
        this.zzfxd = zzeps2;
    }

    public static zzddz zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzddz(applicationInfo, packageInfo);
    }

    public static zzddy zzbe(zzeps<ApplicationInfo> zzeps, zzeps<PackageInfo> zzeps2) {
        return new zzddy(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzgmm.get(), this.zzfxd.get());
    }
}
