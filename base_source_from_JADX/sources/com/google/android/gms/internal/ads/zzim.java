package com.google.android.gms.internal.ads;

final class zzim implements Runnable {
    private final /* synthetic */ zzik zzajb;
    private final /* synthetic */ String zzaje;
    private final /* synthetic */ long zzajf;
    private final /* synthetic */ long zzajg;

    zzim(zzik zzik, String str, long j, long j2) {
        this.zzajb = zzik;
        this.zzaje = str;
        this.zzajf = j;
        this.zzajg = j2;
    }

    public final void run() {
        this.zzajb.zzajc.zza(this.zzaje, this.zzajf, this.zzajg);
    }
}
