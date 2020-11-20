package com.google.android.gms.internal.ads;

import java.util.Map;

final /* synthetic */ class zzbcd implements Runnable {
    private final Map zzegi;
    private final zzbbe zzenn;

    zzbcd(zzbbe zzbbe, Map map) {
        this.zzenn = zzbbe;
        this.zzegi = map;
    }

    public final void run() {
        this.zzenn.zza("onGcacheInfoEvent", this.zzegi);
    }
}
