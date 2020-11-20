package com.google.android.gms.internal.ads;

final /* synthetic */ class zzaxb implements Runnable {
    private final String zzdgt;
    private final zzawx zzeab;
    private final zzaxn zzeac;

    zzaxb(zzawx zzawx, zzaxn zzaxn, String str) {
        this.zzeab = zzawx;
        this.zzeac = zzaxn;
        this.zzdgt = str;
    }

    public final void run() {
        this.zzeab.zza(this.zzeac, this.zzdgt);
    }
}
