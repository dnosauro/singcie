package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public final class zzcmu implements zzepf<PackageInfo> {
    private final zzeps<Context> zzevi;
    private final zzeps<ApplicationInfo> zzgmm;

    private zzcmu(zzeps<Context> zzeps, zzeps<ApplicationInfo> zzeps2) {
        this.zzevi = zzeps;
        this.zzgmm = zzeps2;
    }

    public static zzcmu zzas(zzeps<Context> zzeps, zzeps<ApplicationInfo> zzeps2) {
        return new zzcmu(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zzcmk.zza(this.zzevi.get(), this.zzgmm.get());
    }
}
