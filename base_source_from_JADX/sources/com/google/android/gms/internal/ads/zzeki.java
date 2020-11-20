package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzeki extends zzeio<Integer> implements zzeko, zzeme, RandomAccess {
    private static final zzeki zzins;
    private int size;
    private int[] zzint;

    static {
        zzeki zzeki = new zzeki(new int[0], 0);
        zzins = zzeki;
        zzeki.zzbfl();
    }

    zzeki() {
        this(new int[10], 0);
    }

    private zzeki(int[] iArr, int i) {
        this.zzint = iArr;
        this.size = i;
    }

    public static zzeki zzbig() {
        return zzins;
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
        int intValue = ((Integer) obj).intValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfw(i));
        }
        int[] iArr = this.zzint;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzint, i, iArr2, i + 1, this.size - i);
            this.zzint = iArr2;
        }
        this.zzint[i] = intValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzhg(((Integer) obj).intValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbfm();
        zzekk.checkNotNull(collection);
        if (!(collection instanceof zzeki)) {
            return super.addAll(collection);
        }
        zzeki zzeki = (zzeki) collection;
        int i = zzeki.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzint;
            if (i3 > iArr.length) {
                this.zzint = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzeki.zzint, 0, this.zzint, this.size, zzeki.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeki)) {
            return super.equals(obj);
        }
        zzeki zzeki = (zzeki) obj;
        if (this.size != zzeki.size) {
            return false;
        }
        int[] iArr = zzeki.zzint;
        for (int i = 0; i < this.size; i++) {
            if (this.zzint[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzfv(i);
        return this.zzint[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzint[i2];
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzint[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        zzfv(i);
        int[] iArr = this.zzint;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzint[i]))) {
                int[] iArr = this.zzint;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
            int[] iArr = this.zzint;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbfm();
        zzfv(i);
        int[] iArr = this.zzint;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.size;
    }

    /* renamed from: zzhf */
    public final zzeko zzfx(int i) {
        if (i >= this.size) {
            return new zzeki(Arrays.copyOf(this.zzint, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzhg(int i) {
        zzbfm();
        int i2 = this.size;
        int[] iArr = this.zzint;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzint = iArr2;
        }
        int[] iArr3 = this.zzint;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }
}
