package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdxc<E> extends zzdwt<E> {
    static final zzdxc<Object> zzhvo = new zzdxc(new Object[0], 0, (Object[]) null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzaht;
    private final transient Object[] zzhvp;
    private final transient Object[] zzhvq;

    zzdxc(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzhvp = objArr;
        this.zzhvq = objArr2;
        this.mask = i2;
        this.zzaht = i;
        this.size = i3;
    }

    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzhvq;
        if (obj == null || objArr == null) {
            return false;
        }
        int zzeo = zzdwi.zzeo(obj == null ? 0 : obj.hashCode());
        while (true) {
            int i = zzeo & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzeo = i + 1;
        }
    }

    public final int hashCode() {
        return this.zzaht;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhvp, 0, objArr, i, this.size);
        return i + this.size;
    }

    public final zzdxh<E> zzayp() {
        return (zzdxh) zzayt().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzayq() {
        return this.zzhvp;
    }

    /* access modifiers changed from: package-private */
    public final int zzayr() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzays() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzayu() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaza() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final zzdwm<E> zzazb() {
        return zzdwm.zzb(this.zzhvp, this.size);
    }
}
