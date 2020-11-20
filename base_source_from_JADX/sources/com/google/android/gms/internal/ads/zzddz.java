package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

public final class zzddz implements zzdfi<zzdfj<Bundle>>, zzdfj<Bundle> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdss;

    zzddz(ApplicationInfo applicationInfo2, PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo2;
        this.zzdss = packageInfo;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        return zzdyr.zzag(this);
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdss;
        String str2 = null;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle.putString("pn", str);
        if (valueOf != null) {
            bundle.putInt("vc", valueOf.intValue());
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwd)).booleanValue()) {
            PackageInfo packageInfo2 = this.zzdss;
            if (packageInfo2 != null) {
                str2 = packageInfo2.versionName;
            }
            if (str2 != null) {
                bundle.putString("vnm", str2);
            }
        }
    }
}
