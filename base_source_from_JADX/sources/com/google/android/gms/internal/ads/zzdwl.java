package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdwl<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzhuu = new Object[0];

    zzdwl() {
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@NullableDecl Object obj);

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(zzhuu);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzdvv.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzayq = zzayq();
            if (zzayq != null) {
                return Arrays.copyOfRange(zzayq, zzayr(), zzays(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzdxh zzdxh = (zzdxh) iterator();
        while (zzdxh.hasNext()) {
            objArr[i] = zzdxh.next();
            i++;
        }
        return i;
    }

    /* renamed from: zzayp */
    public abstract zzdxh<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzayq() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int zzayr() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzays() {
        throw new UnsupportedOperationException();
    }

    public zzdwm<E> zzayt() {
        return isEmpty() ? zzdwm.zzayv() : zzdwm.zzc(toArray());
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzayu();
}
