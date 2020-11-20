package com.google.android.gms.internal.ads;

final class zzaiu implements Runnable {
    private final /* synthetic */ zzait zzdhm;

    zzaiu(zzait zzait) {
        this.zzdhm = zzait;
    }

    public final void run() {
        this.zzdhm.disconnect();
    }
}
