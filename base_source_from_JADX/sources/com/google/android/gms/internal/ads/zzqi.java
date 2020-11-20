package com.google.android.gms.internal.ads;

final class zzqi implements Runnable {
    private final /* synthetic */ zzjm zzaja;
    private final /* synthetic */ zzqj zzbmw;

    zzqi(zzqj zzqj, zzjm zzjm) {
        this.zzbmw = zzqj;
        this.zzaja = zzjm;
    }

    public final void run() {
        this.zzbmw.zzbmx.zze(this.zzaja);
    }
}
