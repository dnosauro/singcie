package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcqn implements Callable {
    private final zzcqo zzgqf;

    zzcqn(zzcqo zzcqo) {
        this.zzgqf = zzcqo;
    }

    public final Object call() {
        return this.zzgqf.getWritableDatabase();
    }
}
