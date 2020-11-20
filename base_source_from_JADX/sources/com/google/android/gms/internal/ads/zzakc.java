package com.google.android.gms.internal.ads;

final /* synthetic */ class zzakc implements Runnable {
    private final String zzdha;
    private final zzaka zzdhz;

    zzakc(zzaka zzaka, String str) {
        this.zzdhz = zzaka;
        this.zzdha = str;
    }

    public final void run() {
        this.zzdhz.zzda(this.zzdha);
    }
}
