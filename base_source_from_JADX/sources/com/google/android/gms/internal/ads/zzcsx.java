package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcsx implements Runnable {
    private final zzcif zzgra;

    private zzcsx(zzcif zzcif) {
        this.zzgra = zzcif;
    }

    static Runnable zza(zzcif zzcif) {
        return new zzcsx(zzcif);
    }

    public final void run() {
        this.zzgra.zzapd();
    }
}
