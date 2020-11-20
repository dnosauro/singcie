package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzeis extends zzeio<Boolean> implements zzekp<Boolean>, zzeme, RandomAccess {
    private static final zzeis zziis;
    private int size;
    private boolean[] zziit;

    static {
        zzeis zzeis = new zzeis(new boolean[0], 0);
        zziis = zzeis;
        zzeis.zzbfl();
    }

    zzeis() {
        this(new boolean[10], 0);
    }

    private zzeis(boolean[] zArr, int i) {
        this.zziit = zArr;
        this.size = i;
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

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfw(i));
        }
        boolean[] zArr = this.zziit;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zziit, i, zArr2, i + 1, this.size - i);
            this.zziit = zArr2;
        }
        this.zziit[i] = booleanValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbfm();
        zzekk.checkNotNull(collection);
        if (!(collection instanceof zzeis)) {
            return super.addAll(collection);
        }
        zzeis zzeis = (zzeis) collection;
        int i = zzeis.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zziit;
            if (i3 > zArr.length) {
                this.zziit = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzeis.zziit, 0, this.zziit, this.size, zzeis.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        zzbfm();
        int i = this.size;
        boolean[] zArr = this.zziit;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zziit = zArr2;
        }
        boolean[] zArr3 = this.zziit;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeis)) {
            return super.equals(obj);
        }
        zzeis zzeis = (zzeis) obj;
        if (this.size != zzeis.size) {
            return false;
        }
        boolean[] zArr = zzeis.zziit;
        for (int i = 0; i < this.size; i++) {
            if (this.zziit[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzfv(i);
        return Boolean.valueOf(this.zziit[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzekk.zzbu(this.zziit[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zziit[i] == booleanValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        zzfv(i);
        boolean[] zArr = this.zziit;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zziit[i]))) {
                boolean[] zArr = this.zziit;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbfm();
        if (i2 >= i) {
            boolean[] zArr = this.zziit;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbfm();
        zzfv(i);
        boolean[] zArr = this.zziit;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= this.size) {
            return new zzeis(Arrays.copyOf(this.zziit, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
