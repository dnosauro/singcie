package com.google.android.gms.internal.ads;

final class zzakw implements Runnable {
    private final /* synthetic */ zzakq zzdim;
    private final /* synthetic */ String zzdio;

    zzakw(zzakq zzakq, String str) {
        this.zzdim = zzakq;
        this.zzdio = str;
    }

    public final void run() {
        this.zzdim.zzdii.loadUrl(this.zzdio);
    }
}
