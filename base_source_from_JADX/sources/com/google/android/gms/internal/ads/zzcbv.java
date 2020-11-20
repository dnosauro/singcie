package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcbv implements Runnable {
    private final zzccm zzgcg;

    private zzcbv(zzccm zzccm) {
        this.zzgcg = zzccm;
    }

    static Runnable zza(zzccm zzccm) {
        return new zzcbv(zzccm);
    }

    public final void run() {
        this.zzgcg.zzamt();
    }
}
