package com.google.android.gms.internal.ads;

import java.util.Map;

final /* synthetic */ class zzakm implements Runnable {
    private final zzakn zzdic;
    private final zzahv zzdid;
    private final Map zzdie;

    zzakm(zzakn zzakn, zzahv zzahv, Map map) {
        this.zzdic = zzakn;
        this.zzdid = zzahv;
        this.zzdie = map;
    }

    public final void run() {
        this.zzdic.zza(this.zzdid, this.zzdie);
    }
}
