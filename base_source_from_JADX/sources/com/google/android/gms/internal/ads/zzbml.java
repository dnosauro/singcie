package com.google.android.gms.internal.ads;

import android.view.View;

public final class zzbml implements zzepf<View> {
    private final zzbmh zzftq;

    public zzbml(zzbmh zzbmh) {
        this.zzftq = zzbmh;
    }

    public static View zza(zzbmh zzbmh) {
        return (View) zzepl.zza(zzbmh.zzaiz(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzftq);
    }
}
