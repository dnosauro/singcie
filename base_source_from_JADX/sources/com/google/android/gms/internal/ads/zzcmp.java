package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class zzcmp implements zzepf<ApplicationInfo> {
    private final zzeps<Context> zzevi;

    private zzcmp(zzeps<Context> zzeps) {
        this.zzevi = zzeps;
    }

    public static zzcmp zzab(zzeps<Context> zzeps) {
        return new zzcmp(zzeps);
    }

    public static ApplicationInfo zzch(Context context) {
        return (ApplicationInfo) zzepl.zza(context.getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzch(this.zzevi.get());
    }
}
