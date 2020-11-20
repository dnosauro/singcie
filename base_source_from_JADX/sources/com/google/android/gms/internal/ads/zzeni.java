package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzeni {
    private static final zzeni zzirz = new zzeni(0, new int[0], new Object[0], false);
    private int count;
    private boolean zziin;
    private int zzinp;
    private Object[] zzipr;
    private int[] zzisa;

    private zzeni() {
        this(0, new int[8], new Object[8], true);
    }

    private zzeni(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzinp = -1;
        this.count = i;
        this.zzisa = iArr;
        this.zzipr = objArr;
        this.zziin = z;
    }

    static zzeni zza(zzeni zzeni, zzeni zzeni2) {
        int i = zzeni.count + zzeni2.count;
        int[] copyOf = Arrays.copyOf(zzeni.zzisa, i);
        System.arraycopy(zzeni2.zzisa, 0, copyOf, zzeni.count, zzeni2.count);
        Object[] copyOf2 = Arrays.copyOf(zzeni.zzipr, i);
        System.arraycopy(zzeni2.zzipr, 0, copyOf2, zzeni.count, zzeni2.count);
        return new zzeni(i, copyOf, copyOf2, true);
    }

    private static void zzb(int i, Object obj, zzeoc zzeoc) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    zzeoc.zzq(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    zzeoc.zzk(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    zzeoc.zza(i2, (zzeiu) obj);
                    return;
                case 3:
                    if (zzeoc.zzbhd() == zzeob.zziug) {
                        zzeoc.zzhd(i2);
                        ((zzeni) obj).zzb(zzeoc);
                        zzeoc.zzhe(i2);
                        return;
                    }
                    zzeoc.zzhe(i2);
                    ((zzeni) obj).zzb(zzeoc);
                    zzeoc.zzhd(i2);
                    return;
                default:
                    throw new RuntimeException(zzeks.zzbin());
            }
        } else {
            zzeoc.zzaf(i2, ((Integer) obj).intValue());
        }
    }

    public static zzeni zzbkg() {
        return zzirz;
    }

    static zzeni zzbkh() {
        return new zzeni();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzeni)) {
            return false;
        }
        zzeni zzeni = (zzeni) obj;
        int i = this.count;
        if (i == zzeni.count) {
            int[] iArr = this.zzisa;
            int[] iArr2 = zzeni.zzisa;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzipr;
                Object[] objArr2 = zzeni.zzipr;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzisa;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzipr;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeoc zzeoc) {
        if (zzeoc.zzbhd() == zzeob.zziuh) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzeoc.zzc(this.zzisa[i] >>> 3, this.zzipr[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzeoc.zzc(this.zzisa[i2] >>> 3, this.zzipr[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzelt.zza(sb, i, String.valueOf(this.zzisa[i2] >>> 3), this.zzipr[i2]);
        }
    }

    public final void zzb(zzeoc zzeoc) {
        if (this.count != 0) {
            if (zzeoc.zzbhd() == zzeob.zziug) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzisa[i], this.zzipr[i], zzeoc);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzisa[i2], this.zzipr[i2], zzeoc);
            }
        }
    }

    public final void zzbfl() {
        this.zziin = false;
    }

    public final int zzbhz() {
        int zzaj;
        int i = this.zzinp;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzisa[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 5) {
                switch (i6) {
                    case 0:
                        zzaj = zzejo.zzm(i5, ((Long) this.zzipr[i3]).longValue());
                        break;
                    case 1:
                        zzaj = zzejo.zzo(i5, ((Long) this.zzipr[i3]).longValue());
                        break;
                    case 2:
                        zzaj = zzejo.zzc(i5, (zzeiu) this.zzipr[i3]);
                        break;
                    case 3:
                        zzaj = (zzejo.zzgu(i5) << 1) + ((zzeni) this.zzipr[i3]).zzbhz();
                        break;
                    default:
                        throw new IllegalStateException(zzeks.zzbin());
                }
            } else {
                zzaj = zzejo.zzaj(i5, ((Integer) this.zzipr[i3]).intValue());
            }
            i2 += zzaj;
        }
        this.zzinp = i2;
        return i2;
    }

    public final int zzbki() {
        int i = this.zzinp;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzejo.zzd(this.zzisa[i3] >>> 3, (zzeiu) this.zzipr[i3]);
        }
        this.zzinp = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, Object obj) {
        if (this.zziin) {
            int i2 = this.count;
            if (i2 == this.zzisa.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzisa = Arrays.copyOf(this.zzisa, i3);
                this.zzipr = Arrays.copyOf(this.zzipr, i3);
            }
            int[] iArr = this.zzisa;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzipr[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
