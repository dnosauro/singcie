package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class zzazx<T> {
    private final zzazq<T> zzehc = new zzazq<>();
    /* access modifiers changed from: private */
    public final AtomicInteger zzehd = new AtomicInteger(0);

    public zzazx() {
        zzdyr.zza(this.zzehc, new zzazw(this), zzazj.zzegu);
    }

    @Deprecated
    public final int getStatus() {
        return this.zzehd.get();
    }

    @Deprecated
    public final void reject() {
        this.zzehc.setException(new Exception());
    }

    @Deprecated
    public final void zza(zzazu<T> zzazu, zzazs zzazs) {
        zzdyr.zza(this.zzehc, new zzazz(this, zzazu, zzazs), zzazj.zzegu);
    }

    @Deprecated
    public final void zzm(T t) {
        this.zzehc.set(t);
    }
}
