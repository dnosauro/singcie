package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzdra<E> {
    /* access modifiers changed from: private */
    public static final zzdyz<?> zzhnp = zzdyr.zzag(null);
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzfru;
    /* access modifiers changed from: private */
    public final zzdzc zzggb;
    /* access modifiers changed from: private */
    public final zzdrm<E> zzhnq;

    public zzdra(zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService, zzdrm<E> zzdrm) {
        this.zzggb = zzdzc;
        this.zzfru = scheduledExecutorService;
        this.zzhnq = zzdrm;
    }

    public final zzdrc zza(E e, zzdyz<?>... zzdyzArr) {
        return new zzdrc(this, e, Arrays.asList(zzdyzArr));
    }

    public final <I> zzdrg<I> zza(E e, zzdyz<I> zzdyz) {
        return new zzdrg(this, e, (String) null, zzdyz, Collections.singletonList(zzdyz), zzdyz, (zzdqz) null);
    }

    public final zzdre zzu(E e) {
        return new zzdre(this, e);
    }

    /* access modifiers changed from: protected */
    public abstract String zzv(E e);
}
