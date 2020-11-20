package com.google.android.gms.internal.ads;

final class zzmt implements Runnable {
    private final /* synthetic */ zzmo zzbei;
    private final /* synthetic */ zzmu zzbek;

    zzmt(zzmo zzmo, zzmu zzmu) {
        this.zzbei = zzmo;
        this.zzbek = zzmu;
    }

    public final void run() {
        this.zzbek.release();
        int size = this.zzbei.zzbds.size();
        for (int i = 0; i < size; i++) {
            ((zzni) this.zzbei.zzbds.valueAt(i)).disable();
        }
    }
}
