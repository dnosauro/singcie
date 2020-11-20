package com.google.android.gms.internal.ads;

final class zzqm implements Runnable {
    private final /* synthetic */ zzqj zzbmw;
    private final /* synthetic */ int zzbmy;
    private final /* synthetic */ int zzbmz;
    private final /* synthetic */ int zzbna;
    private final /* synthetic */ float zzbnb;

    zzqm(zzqj zzqj, int i, int i2, int i3, float f) {
        this.zzbmw = zzqj;
        this.zzbmy = i;
        this.zzbmz = i2;
        this.zzbna = i3;
        this.zzbnb = f;
    }

    public final void run() {
        this.zzbmw.zzbmx.zza(this.zzbmy, this.zzbmz, this.zzbna, this.zzbnb);
    }
}
