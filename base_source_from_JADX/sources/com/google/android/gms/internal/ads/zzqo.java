package com.google.android.gms.internal.ads;

final class zzqo implements Runnable {
    private final /* synthetic */ zzjm zzajh;
    private final /* synthetic */ zzqj zzbmw;

    zzqo(zzqj zzqj, zzjm zzjm) {
        this.zzbmw = zzqj;
        this.zzajh = zzjm;
    }

    public final void run() {
        this.zzajh.zzgn();
        this.zzbmw.zzbmx.zzf(this.zzajh);
    }
}
