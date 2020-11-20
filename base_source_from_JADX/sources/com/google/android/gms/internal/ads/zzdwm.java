package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdwm<E> extends zzdwl<E> implements List<E>, RandomAccess {
    private static final zzdxg<Object> zzhuv = new zzdwo(zzdww.zzhvg, 0);

    zzdwm() {
    }

    public static <E> zzdwm<E> zzad(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzdwx.zzd(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzdwm<E> zzayv() {
        return zzdww.zzhvg;
    }

    public static <E> zzdwm<E> zzb(Collection<? extends E> collection) {
        Object[] array;
        int length;
        if (collection instanceof zzdwl) {
            zzdwm<E> zzayt = ((zzdwl) collection).zzayt();
            if (!zzayt.zzayu()) {
                return zzayt;
            }
            array = zzayt.toArray();
            length = array.length;
        } else {
            array = collection.toArray();
            int length2 = array.length;
            for (int i = 0; i < length2; i++) {
                zzdwx.zzd(array[i], i);
            }
            length = array.length;
        }
        return zzb(array, length);
    }

    public static <E> zzdwm<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return zzdww.zzhvg;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdwx.zzd(objArr[i], i);
        }
        return zzb(objArr, objArr.length);
    }

    static <E> zzdwm<E> zzb(Object[] objArr, int i) {
        return i == 0 ? zzdww.zzhvg : new zzdww(objArr, i);
    }

    static <E> zzdwm<E> zzc(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    public static <E> zzdwm<E> zzh(Iterable<? extends E> iterable) {
        zzdvv.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return zzb((Collection) iterable);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return zzdww.zzhvg;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzad(next);
        }
        zzdwp zzdwp = (zzdwp) ((zzdwp) new zzdwp().zzac(next)).zza(it);
        zzdwp.zzhut = true;
        return zzb(zzdwp.zzhus, zzdwp.size);
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdvv.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(this instanceof RandomAccess) || !(list instanceof RandomAccess)) {
                    zzdwm zzdwm = this;
                    int size2 = zzdwm.size();
                    Iterator it = list.iterator();
                    int i = 0;
                    while (true) {
                        if (i < size2) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object obj2 = zzdwm.get(i);
                            i++;
                            if (!zzdvs.equal(obj2, it.next())) {
                                break;
                            }
                        } else if (!it.hasNext()) {
                            return true;
                        }
                    }
                } else {
                    int i2 = 0;
                    while (i2 < size) {
                        if (zzdvs.equal(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzdvs.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            if (obj == null) {
                for (int size = size() - 1; size >= 0; size--) {
                    if (get(size) == null) {
                        return size;
                    }
                }
            } else {
                for (int size2 = size() - 1; size2 >= 0; size2--) {
                    if (obj.equals(get(size2))) {
                        return size2;
                    }
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (zzdvs.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzdxg) listIterator(0);
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzdvv.zzu(i, size());
        return isEmpty() ? zzhuv : new zzdwo(this, i);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public final zzdxh<E> zzayp() {
        return (zzdxg) listIterator();
    }

    public final zzdwm<E> zzayt() {
        return this;
    }

    /* renamed from: zzv */
    public zzdwm<E> subList(int i, int i2) {
        zzdvv.zzf(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? zzdww.zzhvg : new zzdwr(this, i, i3);
    }
}
