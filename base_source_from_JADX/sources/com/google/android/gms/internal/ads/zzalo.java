package com.google.android.gms.internal.ads;

public final class zzalo extends zzazx<zzalz> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final zzals zzdjj;
    private boolean zzdjk;

    public zzalo(zzals zzals) {
        this.zzdjj = zzals;
    }

    public final void release() {
        synchronized (this.lock) {
            if (!this.zzdjk) {
                this.zzdjk = true;
                zza(new zzalr(this), new zzazv());
                zza(new zzalq(this), new zzalt(this));
            }
        }
    }
}
