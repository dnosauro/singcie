package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzeii extends WeakReference<Throwable> {
    private final int zziii;

    public zzeii(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zziii = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzeii zzeii = (zzeii) obj;
            return this.zziii == zzeii.zziii && get() == zzeii.get();
        }
    }

    public final int hashCode() {
        return this.zziii;
    }
}
