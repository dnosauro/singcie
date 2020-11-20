package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbgo implements zzepf<Context> {
    private final zzbgl zzevc;

    public zzbgo(zzbgl zzbgl) {
        this.zzevc = zzbgl;
    }

    public static Context zza(zzbgl zzbgl) {
        return (Context) zzepl.zza(zzbgl.zzaef(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzevc);
    }
}
