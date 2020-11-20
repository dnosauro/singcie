package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzekd extends zzeio<Float> implements zzekp<Float>, zzeme, RandomAccess {
    private static final zzekd zzinb;
    private int size;
    private float[] zzinc;

    static {
        zzekd zzekd = new zzekd(new float[0], 0);
        zzinb = zzekd;
        zzekd.zzbfl();
    }

    zzekd() {
        this(new float[10], 0);
    }

    private zzekd(float[] fArr, int i) {
        this.zzinc = fArr;
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
        float floatValue = ((Float) obj).floatValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfw(i));
        }
        float[] fArr = this.zzinc;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzinc, i, fArr2, i + 1, this.size - i);
            this.zzinc = fArr2;
        }
        this.zzinc[i] = floatValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzh(((Float) obj).floatValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzbfm();
        zzekk.checkNotNull(collection);
        if (!(collection instanceof zzekd)) {
            return super.addAll(collection);
        }
        zzekd zzekd = (zzekd) collection;
        int i = zzekd.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzinc;
            if (i3 > fArr.length) {
                this.zzinc = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzekd.zzinc, 0, this.zzinc, this.size, zzekd.size);
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
        if (!(obj instanceof zzekd)) {
            return super.equals(obj);
        }
        zzekd zzekd = (zzekd) obj;
        if (this.size != zzekd.size) {
            return false;
        }
        float[] fArr = zzekd.zzinc;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzinc[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzfv(i);
        return Float.valueOf(this.zzinc[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzinc[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzinc[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        zzfv(i);
        float[] fArr = this.zzinc;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzinc[i]))) {
                float[] fArr = this.zzinc;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
            float[] fArr = this.zzinc;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbfm();
        zzfv(i);
        float[] fArr = this.zzinc;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= this.size) {
            return new zzekd(Arrays.copyOf(this.zzinc, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(float f) {
        zzbfm();
        int i = this.size;
        float[] fArr = this.zzinc;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzinc = fArr2;
        }
        float[] fArr3 = this.zzinc;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }
}
