package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzelg extends zzeio<Long> implements zzekq, zzeme, RandomAccess {
    private static final zzelg zzipg;
    private int size;
    private long[] zziph;

    static {
        zzelg zzelg = new zzelg(new long[0], 0);
        zzipg = zzelg;
        zzelg.zzbfl();
    }

    zzelg() {
        this(new long[10], 0);
    }

    private zzelg(long[] jArr, int i) {
        this.zziph = jArr;
        this.size = i;
    }

    public static zzelg zzbiz() {
        return zzipg;
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
        long longValue = ((Long) obj).longValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfw(i));
        }
        long[] jArr = this.zziph;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zziph, i, jArr2, i + 1, this.size - i);
            this.zziph = jArr2;
        }
        this.zziph[i] = longValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzfr(((Long) obj).longValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzbfm();
        zzekk.checkNotNull(collection);
        if (!(collection instanceof zzelg)) {
            return super.addAll(collection);
        }
        zzelg zzelg = (zzelg) collection;
        int i = zzelg.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zziph;
            if (i3 > jArr.length) {
                this.zziph = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzelg.zziph, 0, this.zziph, this.size, zzelg.size);
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
        if (!(obj instanceof zzelg)) {
            return super.equals(obj);
        }
        zzelg zzelg = (zzelg) obj;
        if (this.size != zzelg.size) {
            return false;
        }
        long[] jArr = zzelg.zziph;
        for (int i = 0; i < this.size; i++) {
            if (this.zziph[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzfv(i);
        return this.zziph[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzekk.zzfq(this.zziph[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zziph[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        zzfv(i);
        long[] jArr = this.zziph;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zziph[i]))) {
                long[] jArr = this.zziph;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
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
            long[] jArr = this.zziph;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbfm();
        zzfv(i);
        long[] jArr = this.zziph;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.size;
    }

    public final void zzfr(long j) {
        zzbfm();
        int i = this.size;
        long[] jArr = this.zziph;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zziph = jArr2;
        }
        long[] jArr3 = this.zziph;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    /* renamed from: zzhh */
    public final zzekq zzfx(int i) {
        if (i >= this.size) {
            return new zzelg(Arrays.copyOf(this.zziph, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
