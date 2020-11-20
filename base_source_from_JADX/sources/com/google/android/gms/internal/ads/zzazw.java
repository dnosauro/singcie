package com.google.android.gms.internal.ads;

final class zzazw implements zzdyo<T> {
    private final /* synthetic */ zzazx zzehb;

    zzazw(zzazx zzazx) {
        this.zzehb = zzazx;
    }

    public final void onSuccess(T t) {
        this.zzehb.zzehd.set(1);
    }

    public final void zzb(Throwable th) {
        this.zzehb.zzehd.set(-1);
    }
}
