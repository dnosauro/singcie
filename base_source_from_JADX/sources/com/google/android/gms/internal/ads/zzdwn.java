package com.google.android.gms.internal.ads;

import java.util.Iterator;

public abstract class zzdwn<E> {
    zzdwn() {
    }

    public zzdwn<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzac(it.next());
        }
        return this;
    }

    public abstract zzdwn<E> zzac(E e);

    public zzdwn<E> zzg(Iterable<? extends E> iterable) {
        for (Object zzac : iterable) {
            zzac(zzac);
        }
        return this;
    }
}
