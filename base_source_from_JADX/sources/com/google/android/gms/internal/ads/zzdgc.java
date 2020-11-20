package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

public final class zzdgc implements zzdfi<zzdgd> {
    private final Executor executor;
    private final PackageInfo zzdss;
    private final zzayc zzhbw;
    private final String zzhca;

    public zzdgc(zzayc zzayc, Executor executor2, String str, PackageInfo packageInfo) {
        this.zzhbw = zzayc;
        this.executor = executor2;
        this.zzhca = str;
        this.zzdss = packageInfo;
    }

    public final zzdyz<zzdgd> zzasm() {
        return zzdyr.zzb(zzdyr.zzb(this.zzhbw.zza(this.zzhca, this.zzdss), zzdgf.zzdza, this.executor), Throwable.class, new zzdge(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzg(Throwable th) {
        return zzdyr.zzag(new zzdgd(this.zzhca));
    }
}
