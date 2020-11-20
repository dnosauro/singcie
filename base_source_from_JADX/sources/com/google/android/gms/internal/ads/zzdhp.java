package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

public final class zzdhp implements zzepf<ApplicationInfo> {
    private final zzdhn zzhcw;

    public zzdhp(zzdhn zzdhn) {
        this.zzhcw = zzdhn;
    }

    public static ApplicationInfo zzc(zzdhn zzdhn) {
        return (ApplicationInfo) zzepl.zza(zzdhn.zzato(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzc(this.zzhcw);
    }
}
