package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzff<E> extends zzex<E> implements Set<E> {
    @NullableDecl
    private transient zzew<E> zza;

    zzff() {
    }

    static int zza(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        zzdw.zza(z, (Object) "collection too large");
        return 1073741824;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzff) || !zza() || !((zzff) obj).zza() || hashCode() == obj.hashCode()) {
            return zzfq.zza(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzfq.zza(this);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* access modifiers changed from: package-private */
    public boolean zza() {
        return false;
    }

    public zzew<E> zzc() {
        zzew<E> zzew = this.zza;
        if (zzew != null) {
            return zzew;
        }
        zzew<E> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public zzew<E> zzh() {
        return zzew.zza(toArray());
    }
}
