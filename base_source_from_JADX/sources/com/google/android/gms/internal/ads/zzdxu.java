package com.google.android.gms.internal.ads;

final class zzdxu implements Runnable {
    private final /* synthetic */ zzdyz zzhwr;
    private final /* synthetic */ int zzhws;
    private final /* synthetic */ zzdxv zzhwt;

    zzdxu(zzdxv zzdxv, zzdyz zzdyz, int i) {
        this.zzhwt = zzdxv;
        this.zzhwr = zzdyz;
        this.zzhws = i;
    }

    public final void run() {
        try {
            if (this.zzhwr.isCancelled()) {
                zzdwl unused = this.zzhwt.zzhwu = null;
                this.zzhwt.cancel(false);
            } else {
                this.zzhwt.zza(this.zzhws, this.zzhwr);
            }
        } finally {
            this.zzhwt.zza((zzdwl) null);
        }
    }
}
