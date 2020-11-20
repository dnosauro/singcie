package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcrm implements Runnable {
    private final zzcif zzgra;

    private zzcrm(zzcif zzcif) {
        this.zzgra = zzcif;
    }

    static Runnable zza(zzcif zzcif) {
        return new zzcrm(zzcif);
    }

    public final void run() {
        this.zzgra.zzapd();
    }
}
