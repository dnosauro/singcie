package com.google.android.gms.internal.ads;

import java.util.Map;

final /* synthetic */ class zzbeo implements Runnable {
    private final Map zzegi;
    private final zzbep zzesn;

    zzbeo(zzbep zzbep, Map map) {
        this.zzesn = zzbep;
        this.zzegi = map;
    }

    public final void run() {
        this.zzesn.zzl(this.zzegi);
    }
}
