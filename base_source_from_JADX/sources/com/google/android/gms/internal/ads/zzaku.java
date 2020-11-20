package com.google.android.gms.internal.ads;

final class zzaku implements Runnable {
    private final /* synthetic */ String zzdil;
    private final /* synthetic */ zzakq zzdim;

    zzaku(zzakq zzakq, String str) {
        this.zzdim = zzakq;
        this.zzdil = str;
    }

    public final void run() {
        this.zzdim.zzdii.loadData(this.zzdil, "text/html", "UTF-8");
    }
}
