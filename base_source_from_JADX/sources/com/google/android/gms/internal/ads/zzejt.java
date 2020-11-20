package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzejt extends zzeio<Double> implements zzekp<Double>, zzeme, RandomAccess {
    private static final zzejt zzike;
    private int size;
    private double[] zzikf;

    static {
        zzejt zzejt = new zzejt(new double[0], 0);
        zzike = zzejt;
        zzejt.zzbfl();
    }

    zzejt() {
        this(new double[10], 0);
    }

    private zzejt(double[] dArr, int i) {
        this.zzikf = dArr;
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
        double doubleValue = ((Double) obj).doubleValue();
        zzbfm();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfw(i));
        }
        double[] dArr = this.zzikf;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzikf, i, dArr2, i + 1, this.size - i);
            this.zzikf = dArr2;
        }
        this.zzikf[i] = doubleValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzbfm();
        zzekk.checkNotNull(collection);
        if (!(collection instanceof zzejt)) {
            return super.addAll(collection);
        }
        zzejt zzejt = (zzejt) collection;
        int i = zzejt.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzikf;
            if (i3 > dArr.length) {
                this.zzikf = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzejt.zzikf, 0, this.zzikf, this.size, zzejt.size);
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
        if (!(obj instanceof zzejt)) {
            return super.equals(obj);
        }
        zzejt zzejt = (zzejt) obj;
        if (this.size != zzejt.size) {
            return false;
        }
        double[] dArr = zzejt.zzikf;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzikf[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzfv(i);
        return Double.valueOf(this.zzikf[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzekk.zzfq(Double.doubleToLongBits(this.zzikf[i2]));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzikf[i] == doubleValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbfm();
        zzfv(i);
        double[] dArr = this.zzikf;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final boolean remove(Object obj) {
        zzbfm();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzikf[i]))) {
                double[] dArr = this.zzikf;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
            double[] dArr = this.zzikf;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbfm();
        zzfv(i);
        double[] dArr = this.zzikf;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.size;
    }

    public final void zze(double d) {
        zzbfm();
        int i = this.size;
        double[] dArr = this.zzikf;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzikf = dArr2;
        }
        double[] dArr3 = this.zzikf;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    public final /* synthetic */ zzekp zzfx(int i) {
        if (i >= this.size) {
            return new zzejt(Arrays.copyOf(this.zzikf, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
