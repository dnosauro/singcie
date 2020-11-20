package com.google.android.gms.internal.measurement;

final class zzez<E> extends zzee<E> {
    private final zzew<E> zza;

    zzez(zzew<E> zzew, int i) {
        super(zzew.size(), i);
        this.zza = zzew;
    }

    /* access modifiers changed from: protected */
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
