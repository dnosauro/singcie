package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcmg implements Callable {
    private final zzcmd zzgmd;
    private final zzatl zzgme;

    zzcmg(zzcmd zzcmd, zzatl zzatl) {
        this.zzgmd = zzcmd;
        this.zzgme = zzatl;
    }

    public final Object call() {
        return this.zzgmd.zzf(this.zzgme);
    }
}
