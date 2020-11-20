package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzdhc implements Callable {
    private final zzdhd zzhcr;

    zzdhc(zzdhd zzdhd) {
        this.zzhcr = zzdhd;
    }

    public final Object call() {
        zzdhd zzdhd = this.zzhcr;
        return new zzdha(zzdhd.zzhcs.zzf(zzdhd.zzdtc));
    }
}
