package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcvg implements Runnable {
    private final zzcif zzgra;

    private zzcvg(zzcif zzcif) {
        this.zzgra = zzcif;
    }

    static Runnable zza(zzcif zzcif) {
        return new zzcvg(zzcif);
    }

    public final void run() {
        this.zzgra.zzapd();
    }
}
