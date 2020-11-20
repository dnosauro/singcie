package com.google.android.gms.internal.ads;

final class zzv implements Runnable {
    private final Runnable mRunnable;
    private final zzaa zzah;
    private final zzaj zzai;

    public zzv(zzaa zzaa, zzaj zzaj, Runnable runnable) {
        this.zzah = zzaa;
        this.zzai = zzaj;
        this.mRunnable = runnable;
    }

    public final void run() {
        this.zzah.isCanceled();
        if (this.zzai.isSuccess()) {
            this.zzah.zza(this.zzai.result);
        } else {
            this.zzah.zzb(this.zzai.zzbr);
        }
        if (this.zzai.zzbs) {
            this.zzah.zzc("intermediate-response");
        } else {
            this.zzah.zzd("done");
        }
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }
}
