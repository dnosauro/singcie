package com.google.android.gms.internal.ads;

final /* synthetic */ class zzclz implements Runnable {
    private final String zzdha;
    private final zzcma zzglr;

    zzclz(zzcma zzcma, String str) {
        this.zzglr = zzcma;
        this.zzdha = str;
    }

    public final void run() {
        zzcma zzcma = this.zzglr;
        zzcma.zzgls.zzgh(this.zzdha);
    }
}
