package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcmt implements zzepf<String> {
    private final zzeps<Context> zzevi;

    private zzcmt(zzeps<Context> zzeps) {
        this.zzevi = zzeps;
    }

    public static zzcmt zzac(zzeps<Context> zzeps) {
        return new zzcmt(zzeps);
    }

    public static String zzci(Context context) {
        return (String) zzepl.zza(context.getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzci(this.zzevi.get());
    }
}
