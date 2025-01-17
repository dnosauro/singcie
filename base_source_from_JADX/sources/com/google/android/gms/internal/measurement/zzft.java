package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzft<E> extends zzff<E> {
    private final transient E zza;
    private transient int zzb;

    zzft(E e) {
        this.zza = zzdw.zza(e);
    }

    zzft(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zzb != 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    public final zzfs<E> zzb() {
        return new zzfg(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final zzew<E> zzh() {
        return zzew.zza(this.zza);
    }
}
