package com.google.android.gms.internal.ads;

final class zzql implements Runnable {
    private final /* synthetic */ String zzaje;
    private final /* synthetic */ long zzajf;
    private final /* synthetic */ long zzajg;
    private final /* synthetic */ zzqj zzbmw;

    zzql(zzqj zzqj, String str, long j, long j2) {
        this.zzbmw = zzqj;
        this.zzaje = str;
        this.zzajf = j;
        this.zzajg = j2;
    }

    public final void run() {
        this.zzbmw.zzbmx.zzd(this.zzaje, this.zzajf, this.zzajg);
    }
}
