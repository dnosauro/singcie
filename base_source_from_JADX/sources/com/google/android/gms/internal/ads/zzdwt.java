package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdwt<E> extends zzdwl<E> implements Set<E> {
    @NullableDecl
    private transient zzdwm<E> zzhvd;

    zzdwt() {
    }

    /* access modifiers changed from: private */
    public static <E> zzdwt<E> zza(int i, Object... objArr) {
        while (true) {
            switch (i) {
                case 0:
                    return zzdxc.zzhvo;
                case 1:
                    return zzae(objArr[0]);
                default:
                    int zzeq = zzeq(i);
                    Object[] objArr2 = new Object[zzeq];
                    int i2 = zzeq - 1;
                    int i3 = 0;
                    int i4 = 0;
                    for (int i5 = 0; i5 < i; i5++) {
                        Object zzd = zzdwx.zzd(objArr[i5], i5);
                        int hashCode = zzd.hashCode();
                        int zzeo = zzdwi.zzeo(hashCode);
                        while (true) {
                            int i6 = zzeo & i2;
                            Object obj = objArr2[i6];
                            if (obj == null) {
                                objArr[i4] = zzd;
                                objArr2[i6] = zzd;
                                i3 += hashCode;
                                i4++;
                            } else if (!obj.equals(zzd)) {
                                zzeo++;
                            }
                        }
                    }
                    Arrays.fill(objArr, i4, i, (Object) null);
                    if (i4 == 1) {
                        return new zzdxe(objArr[0], i3);
                    }
                    if (zzeq(i4) < zzeq / 2) {
                        i = i4;
                    } else {
                        if (zzw(i4, objArr.length)) {
                            objArr = Arrays.copyOf(objArr, i4);
                        }
                        return new zzdxc(objArr, i3, objArr2, i2, i4);
                    }
            }
        }
    }

    @SafeVarargs
    public static <E> zzdwt<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        zzdvv.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        Object[] objArr = new Object[(eArr.length + 6)];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return zza(objArr.length, objArr);
    }

    public static <E> zzdwt<E> zzae(E e) {
        return new zzdxe(e);
    }

    static int zzeq(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        zzdvv.checkArgument(z, "collection too large");
        return 1073741824;
    }

    public static <E> zzdws<E> zzer(int i) {
        zzdwg.zzh(i, "expectedSize");
        return new zzdws<>(i);
    }

    /* access modifiers changed from: private */
    public static boolean zzw(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdwt) || !zzaza() || !((zzdwt) obj).zzaza() || hashCode() == obj.hashCode()) {
            return zzdxf.zza(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzdxf.zzg(this);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public zzdwm<E> zzayt() {
        zzdwm<E> zzdwm = this.zzhvd;
        if (zzdwm != null) {
            return zzdwm;
        }
        zzdwm<E> zzazb = zzazb();
        this.zzhvd = zzazb;
        return zzazb;
    }

    /* access modifiers changed from: package-private */
    public boolean zzaza() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public zzdwm<E> zzazb() {
        return zzdwm.zzc(toArray());
    }
}
