package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcpu implements Callable {
    private final zzcpp zzgox;

    private zzcpu(zzcpp zzcpp) {
        this.zzgox = zzcpp;
    }

    static Callable zza(zzcpp zzcpp) {
        return new zzcpu(zzcpp);
    }

    public final Object call() {
        return this.zzgox.getWritableDatabase();
    }
}
