package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzgb extends WeakReference<Throwable> {
    private final int zza;

    public zzgb(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zza = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzgb zzgb = (zzgb) obj;
            return this.zza == zzgb.zza && get() == zzgb.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
