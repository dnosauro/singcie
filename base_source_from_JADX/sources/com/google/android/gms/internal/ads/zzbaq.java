package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbaq implements Runnable {
    private final zzbap zzeij;

    private zzbaq(zzbap zzbap) {
        this.zzeij = zzbap;
    }

    static Runnable zza(zzbap zzbap) {
        return new zzbaq(zzbap);
    }

    public final void run() {
        this.zzeij.stop();
    }
}
