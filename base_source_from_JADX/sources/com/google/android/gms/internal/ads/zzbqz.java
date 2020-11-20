package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.List;

public final class zzbqz {
    private final String packageName;
    private final zzazh zzbos;
    private final PackageInfo zzdss;
    private final List<String> zzdtc;
    private final String zzdvz;
    private final zzf zzebt;
    private final zzdro zzfvm;
    private final ApplicationInfo zzfww;
    private final zzeoz<zzdyz<String>> zzfwx;
    private final zzdfl<Bundle> zzfwy;

    public zzbqz(zzdro zzdro, zzazh zzazh, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, zzeoz<zzdyz<String>> zzeoz, zzf zzf, String str2, zzdfl<Bundle> zzdfl) {
        this.zzfvm = zzdro;
        this.zzbos = zzazh;
        this.zzfww = applicationInfo;
        this.packageName = str;
        this.zzdtc = list;
        this.zzdss = packageInfo;
        this.zzfwx = zzeoz;
        this.zzebt = zzf;
        this.zzdvz = str2;
        this.zzfwy = zzdfl;
    }

    public final zzdyz<Bundle> zzakq() {
        return this.zzfvm.zzu(zzdrl.SIGNALS).zze(this.zzfwy.zzt(new Bundle())).zzaww();
    }

    public final zzdyz<zzatl> zzakr() {
        zzdyz<Bundle> zzakq = zzakq();
        return this.zzfvm.zza(zzdrl.REQUEST_PARCEL, (zzdyz<?>[]) new zzdyz[]{zzakq, this.zzfwx.get()}).zzb(new zzbrc(this, zzakq)).zzaww();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzatl zzc(zzdyz zzdyz) {
        return new zzatl((Bundle) zzdyz.get(), this.zzbos, this.zzfww, this.packageName, this.zzdtc, this.zzdss, (String) this.zzfwx.get().get(), this.zzebt.zzxt(), this.zzdvz, (zzdpk) null, (String) null);
    }
}
