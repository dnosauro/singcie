package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzdxe<E> extends zzdwt<E> {
    private final transient E zzhvr;
    private transient int zzhvs;

    zzdxe(E e) {
        this.zzhvr = zzdvv.checkNotNull(e);
    }

    zzdxe(E e, int i) {
        this.zzhvr = e;
        this.zzhvs = i;
    }

    public final boolean contains(Object obj) {
        return this.zzhvr.equals(obj);
    }

    public final int hashCode() {
        int i = this.zzhvs;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzhvr.hashCode();
        this.zzhvs = hashCode;
        return hashCode;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zzhvr.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zzhvr;
        return i + 1;
    }

    public final zzdxh<E> zzayp() {
        return new zzdwv(this.zzhvr);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzayu() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaza() {
        return this.zzhvs != 0;
    }

    /* access modifiers changed from: package-private */
    public final zzdwm<E> zzazb() {
        return zzdwm.zzad(this.zzhvr);
    }
}
