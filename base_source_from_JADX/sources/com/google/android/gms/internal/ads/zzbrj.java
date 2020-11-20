package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbrj implements zzepf<Context> {
    private final zzeps<Context> zzfwi;
    private final zzbrg zzfxl;

    private zzbrj(zzbrg zzbrg, zzeps<Context> zzeps) {
        this.zzfxl = zzbrg;
        this.zzfwi = zzeps;
    }

    public static zzbrj zza(zzbrg zzbrg, zzeps<Context> zzeps) {
        return new zzbrj(zzbrg, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Context) zzepl.zza(this.zzfxl.zzcf(this.zzfwi.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
