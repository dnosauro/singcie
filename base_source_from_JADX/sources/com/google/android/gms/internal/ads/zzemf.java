package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.RandomAccess;

final class zzemf<E> extends zzeio<E> implements RandomAccess {
    private static final zzemf<Object> zziqm;
    private int size;
    private E[] zzhvh;

    static {
        zzemf<Object> zzemf = new zzemf<>(new Object[0], 0);
        zziqm = zzemf;
        zzemf.zzbfl();
    }

    zzemf() {
        this(new Object[10], 0);
    }

    private zzemf(E[] eArr, int i) {
        this.zzhvh = eArr;
        this.size = i;
    }

    public static <E> zzemf<E> zzbjm() {
        return zziqm;
    }

    private final void zzfv(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfw(i));
        }
    }

    private final String zzfw(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void add(int i, E e) {
        int i2;
        zzbfm();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfw(i));
        }
        E[] eArr = this.zzhvh;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzhvh, i, eArr2, i + 1, this.size - i);
            this.zzhvh = eArr2;
        }
        this.zzhvh[i] = e;
        this.size++;
        this.modCount++;
    }

    public final boolean add(E e) {
        zzbfm();
        int i = this.size;
        E[] eArr = this.zzhvh;
        if (i == eArr.length) {
            this.zzhvh = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzhvh;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final E get(int i) {
        zzfv(i);
        return this.zzhvh[i];
    }

    public final E remove(int i) {
        zzbfm();
        zzfv(i);
        E[] eArr = this.zzhvh;
        E e = eArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzbfm();
        zzfv(i);
        E[] eArr = this.zzhvh;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= this.size) {
            return new zzemf(Arrays.copyOf(this.zzhvh, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
