package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhv;
import java.util.Arrays;

public final class zzkq {
    private static final zzkq zza = new zzkq(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzkq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzkq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzkq zza() {
        return zza;
    }

    static zzkq zza(zzkq zzkq, zzkq zzkq2) {
        int i = zzkq.zzb + zzkq2.zzb;
        int[] copyOf = Arrays.copyOf(zzkq.zzc, i);
        System.arraycopy(zzkq2.zzc, 0, copyOf, zzkq.zzb, zzkq2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzkq.zzd, i);
        System.arraycopy(zzkq2.zzd, 0, copyOf2, zzkq.zzb, zzkq2.zzb);
        return new zzkq(i, copyOf, copyOf2, true);
    }

    private static void zza(int i, Object obj, zzlk zzlk) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    zzlk.zza(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    zzlk.zzd(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    zzlk.zza(i2, (zzgm) obj);
                    return;
                case 3:
                    if (zzlk.zza() == zzhv.zze.zzj) {
                        zzlk.zza(i2);
                        ((zzkq) obj).zzb(zzlk);
                        zzlk.zzb(i2);
                        return;
                    }
                    zzlk.zzb(i2);
                    ((zzkq) obj).zzb(zzlk);
                    zzlk.zza(i2);
                    return;
                default:
                    throw new RuntimeException(zzig.zzf());
            }
        } else {
            zzlk.zzd(i2, ((Integer) obj).intValue());
        }
    }

    static zzkq zzb() {
        return new zzkq();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzkq)) {
            return false;
        }
        zzkq zzkq = (zzkq) obj;
        int i = this.zzb;
        if (i == zzkq.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzkq.zzc;
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
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzkq.zzd;
                int i3 = this.zzb;
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
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            if (i2 == this.zzc.length) {
                int i3 = this.zzb + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(this.zzc, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr = this.zzc;
            int i4 = this.zzb;
            iArr[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzlk zzlk) {
        if (zzlk.zza() == zzhv.zze.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzlk.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzlk.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjh.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzb(zzlk zzlk) {
        if (this.zzb != 0) {
            if (zzlk.zza() == zzhv.zze.zzj) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzlk);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzlk);
            }
        }
    }

    public final void zzc() {
        this.zzf = false;
    }

    public final int zzd() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzhf.zzd(this.zzc[i3] >>> 3, (zzgm) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int zze() {
        int zzi;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 5) {
                switch (i6) {
                    case 0:
                        zzi = zzhf.zze(i5, ((Long) this.zzd[i3]).longValue());
                        break;
                    case 1:
                        zzi = zzhf.zzg(i5, ((Long) this.zzd[i3]).longValue());
                        break;
                    case 2:
                        zzi = zzhf.zzc(i5, (zzgm) this.zzd[i3]);
                        break;
                    case 3:
                        zzi = (zzhf.zze(i5) << 1) + ((zzkq) this.zzd[i3]).zze();
                        break;
                    default:
                        throw new IllegalStateException(zzig.zzf());
                }
            } else {
                zzi = zzhf.zzi(i5, ((Integer) this.zzd[i3]).intValue());
            }
            i2 += zzi;
        }
        this.zze = i2;
        return i2;
    }
}
