package com.google.android.gms.internal.ads;

final class zzazz implements zzdyo<T> {
    private final /* synthetic */ zzazu zzehe;
    private final /* synthetic */ zzazs zzehf;

    zzazz(zzazx zzazx, zzazu zzazu, zzazs zzazs) {
        this.zzehe = zzazu;
        this.zzehf = zzazs;
    }

    public final void onSuccess(T t) {
        this.zzehe.zzh(t);
    }

    public final void zzb(Throwable th) {
        this.zzehf.run();
    }
}
