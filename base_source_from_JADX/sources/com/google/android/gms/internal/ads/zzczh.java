package com.google.android.gms.internal.ads;

final /* synthetic */ class zzczh implements Runnable {
    private final zzcyx zzgxl;
    private final zzcgh[] zzgxo;

    zzczh(zzcyx zzcyx, zzcgh[] zzcghArr) {
        this.zzgxl = zzcyx;
        this.zzgxo = zzcghArr;
    }

    public final void run() {
        this.zzgxl.zza(this.zzgxo);
    }
}
