package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

class zzdwk<E> extends zzdwn<E> {
    int size = 0;
    Object[] zzhus;
    boolean zzhut;

    zzdwk(int i) {
        zzdwg.zzh(i, "initialCapacity");
        this.zzhus = new Object[i];
    }

    private final void zzep(int i) {
        Object[] objArr = this.zzhus;
        if (objArr.length < i) {
            int length = objArr.length;
            if (i >= 0) {
                int i2 = length + (length >> 1) + 1;
                if (i2 < i) {
                    i2 = Integer.highestOneBit(i - 1) << 1;
                }
                if (i2 < 0) {
                    i2 = Integer.MAX_VALUE;
                }
                this.zzhus = Arrays.copyOf(objArr, i2);
                this.zzhut = false;
                return;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        } else if (this.zzhut) {
            this.zzhus = (Object[]) objArr.clone();
            this.zzhut = false;
        }
    }

    /* renamed from: zzab */
    public zzdwk<E> zzac(E e) {
        zzdvv.checkNotNull(e);
        zzep(this.size + 1);
        Object[] objArr = this.zzhus;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e;
        return this;
    }

    public zzdwn<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzep(this.size + collection.size());
            if (collection instanceof zzdwl) {
                this.size = ((zzdwl) collection).zza(this.zzhus, this.size);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
