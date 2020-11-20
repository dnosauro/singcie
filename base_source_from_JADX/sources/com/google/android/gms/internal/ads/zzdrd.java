package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzdrd implements Callable {
    private final zzdqy zzhnt;

    zzdrd(zzdqy zzdqy) {
        this.zzhnt = zzdqy;
    }

    public final Object call() {
        this.zzhnt.run();
        return null;
    }
}
