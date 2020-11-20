package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.util.List;

public final class zzdhn {
    private final zzatl zzgnh;
    private final int zzgon;

    public zzdhn(zzatl zzatl, int i) {
        this.zzgnh = zzatl;
        this.zzgon = i;
    }

    public final String zzatj() {
        return this.zzgnh.packageName;
    }

    public final String zzatk() {
        return this.zzgnh.zzdvx.getString("ms");
    }

    public final PackageInfo zzatl() {
        return this.zzgnh.zzdss;
    }

    public final boolean zzatm() {
        return this.zzgnh.zzdvy;
    }

    public final List<String> zzatn() {
        return this.zzgnh.zzdtc;
    }

    public final ApplicationInfo zzato() {
        return this.zzgnh.applicationInfo;
    }

    public final String zzatp() {
        return this.zzgnh.zzdvz;
    }

    public final int zzatq() {
        return this.zzgon;
    }
}
