package com.google.android.gms.internal.ads;

final class zzij implements Runnable {
    private final /* synthetic */ zzjm zzaja;
    private final /* synthetic */ zzik zzajb;

    zzij(zzik zzik, zzjm zzjm) {
        this.zzajb = zzik;
        this.zzaja = zzjm;
    }

    public final void run() {
        this.zzajb.zzajc.zza(this.zzaja);
    }
}
