package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.spongycastle.asn1.eac.CertificateBody;

public abstract class zzhf extends zzgn {
    private static final Logger zzb = Logger.getLogger(zzhf.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzkt.zza();
    zzhh zza;

    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zza(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L_0x0015
                java.lang.String r3 = r0.concat(r3)
                goto L_0x001a
            L_0x0015:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L_0x001a:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhf.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static class zzb extends zzhf {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i2 | 0 | (bArr.length - i2)) >= 0) {
                this.zzb = bArr;
                this.zzc = 0;
                this.zze = 0;
                this.zzd = i2;
            } else {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zze, i2);
                this.zze += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)}), e);
            }
        }

        public final int zza() {
            return this.zzd - this.zze;
        }

        public final void zza(byte b) {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zza(int i) {
            if (i >= 0) {
                zzb(i);
            } else {
                zza((long) i);
            }
        }

        public final void zza(int i, int i2) {
            zzb((i << 3) | i2);
        }

        public final void zza(int i, long j) {
            zza(i, 0);
            zza(j);
        }

        public final void zza(int i, zzgm zzgm) {
            zza(i, 2);
            zza(zzgm);
        }

        public final void zza(int i, zzjg zzjg) {
            zza(1, 3);
            zzc(2, i);
            zza(3, 2);
            zza(zzjg);
            zza(1, 4);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzjg zzjg, zzjv zzjv) {
            zza(i, 2);
            zzgd zzgd = (zzgd) zzjg;
            int zzbl = zzgd.zzbl();
            if (zzbl == -1) {
                zzbl = zzjv.zzb(zzgd);
                zzgd.zzc(zzbl);
            }
            zzb(zzbl);
            zzjv.zza(zzjg, (zzlk) this.zza);
        }

        public final void zza(int i, String str) {
            zza(i, 2);
            zza(str);
        }

        public final void zza(int i, boolean z) {
            zza(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zza(long j) {
            if (!zzhf.zzc || zza() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zze;
                    this.zze = i + 1;
                    bArr[i] = (byte) ((((int) j) & CertificateBody.profileType) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.zzb;
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    zzkt.zza(bArr3, (long) i3, (byte) ((((int) j) & CertificateBody.profileType) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.zzb;
                int i4 = this.zze;
                this.zze = i4 + 1;
                zzkt.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zza(zzgm zzgm) {
            zzb(zzgm.zza());
            zzgm.zza((zzgn) this);
        }

        public final void zza(zzjg zzjg) {
            zzb(zzjg.zzbp());
            zzjg.zza(this);
        }

        public final void zza(String str) {
            int i = this.zze;
            try {
                int zzg = zzg(str.length() * 3);
                int zzg2 = zzg(str.length());
                if (zzg2 == zzg) {
                    this.zze = i + zzg2;
                    int zza = zzkw.zza(str, this.zzb, this.zze, zza());
                    this.zze = i;
                    zzb((zza - i) - zzg2);
                    this.zze = zza;
                    return;
                }
                zzb(zzkw.zza((CharSequence) str));
                this.zze = zzkw.zza(str, this.zzb, this.zze, zza());
            } catch (zzkz e) {
                this.zze = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) {
            zzc(bArr, i, i2);
        }

        public final void zzb(int i) {
            if (!zzhf.zzc || zzgj.zza() || zza() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    bArr[i2] = (byte) ((i & CertificateBody.profileType) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
                }
            } else {
                if ((i & -128) != 0) {
                    byte[] bArr3 = this.zzb;
                    int i4 = this.zze;
                    this.zze = i4 + 1;
                    zzkt.zza(bArr3, (long) i4, (byte) (i | 128));
                    i >>>= 7;
                    if ((i & -128) != 0) {
                        byte[] bArr4 = this.zzb;
                        int i5 = this.zze;
                        this.zze = i5 + 1;
                        zzkt.zza(bArr4, (long) i5, (byte) (i | 128));
                        i >>>= 7;
                        if ((i & -128) != 0) {
                            byte[] bArr5 = this.zzb;
                            int i6 = this.zze;
                            this.zze = i6 + 1;
                            zzkt.zza(bArr5, (long) i6, (byte) (i | 128));
                            i >>>= 7;
                            if ((i & -128) != 0) {
                                byte[] bArr6 = this.zzb;
                                int i7 = this.zze;
                                this.zze = i7 + 1;
                                zzkt.zza(bArr6, (long) i7, (byte) (i | 128));
                                i >>>= 7;
                            }
                        }
                    }
                }
                byte[] bArr7 = this.zzb;
                int i8 = this.zze;
                this.zze = i8 + 1;
                zzkt.zza(bArr7, (long) i8, (byte) i);
            }
        }

        public final void zzb(int i, int i2) {
            zza(i, 0);
            zza(i2);
        }

        public final void zzb(int i, zzgm zzgm) {
            zza(1, 3);
            zzc(2, i);
            zza(3, zzgm);
            zza(1, 4);
        }

        public final void zzb(byte[] bArr, int i, int i2) {
            zzb(i2);
            zzc(bArr, 0, i2);
        }

        public final void zzc(int i, int i2) {
            zza(i, 0);
            zzb(i2);
        }

        public final void zzc(int i, long j) {
            zza(i, 1);
            zzc(j);
        }

        public final void zzc(long j) {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.zzb;
                int i2 = this.zze;
                this.zze = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.zzb;
                int i3 = this.zze;
                this.zze = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.zzb;
                int i4 = this.zze;
                this.zze = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.zzb;
                int i5 = this.zze;
                this.zze = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.zzb;
                int i6 = this.zze;
                this.zze = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.zzb;
                int i7 = this.zze;
                this.zze = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.zzb;
                int i8 = this.zze;
                this.zze = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zzd(int i) {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                this.zze = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.zzb;
                int i3 = this.zze;
                this.zze = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.zzb;
                int i4 = this.zze;
                this.zze = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.zzb;
                int i5 = this.zze;
                this.zze = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zze(int i, int i2) {
            zza(i, 5);
            zzd(i2);
        }
    }

    private zzhf() {
    }

    public static int zza(int i, zzil zzil) {
        int zzg = zzg(i << 3);
        int zzb2 = zzil.zzb();
        return zzg + zzg(zzb2) + zzb2;
    }

    public static int zza(zzil zzil) {
        int zzb2 = zzil.zzb();
        return zzg(zzb2) + zzb2;
    }

    static int zza(zzjg zzjg, zzjv zzjv) {
        zzgd zzgd = (zzgd) zzjg;
        int zzbl = zzgd.zzbl();
        if (zzbl == -1) {
            zzbl = zzjv.zzb(zzgd);
            zzgd.zzc(zzbl);
        }
        return zzg(zzbl) + zzbl;
    }

    public static zzhf zza(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(int i, double d) {
        return zzg(i << 3) + 8;
    }

    public static int zzb(int i, float f) {
        return zzg(i << 3) + 4;
    }

    public static int zzb(int i, zzil zzil) {
        return (zzg(8) << 1) + zzg(2, i) + zza(3, zzil);
    }

    public static int zzb(int i, zzjg zzjg) {
        return (zzg(8) << 1) + zzg(2, i) + zzg(24) + zzb(zzjg);
    }

    static int zzb(int i, zzjg zzjg, zzjv zzjv) {
        return zzg(i << 3) + zza(zzjg, zzjv);
    }

    public static int zzb(int i, String str) {
        return zzg(i << 3) + zzb(str);
    }

    public static int zzb(int i, boolean z) {
        return zzg(i << 3) + 1;
    }

    public static int zzb(zzgm zzgm) {
        int zza2 = zzgm.zza();
        return zzg(zza2) + zza2;
    }

    public static int zzb(zzjg zzjg) {
        int zzbp = zzjg.zzbp();
        return zzg(zzbp) + zzbp;
    }

    public static int zzb(String str) {
        int i;
        try {
            i = zzkw.zza((CharSequence) str);
        } catch (zzkz unused) {
            i = str.getBytes(zzhx.zza).length;
        }
        return zzg(i) + i;
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zzc(int i, zzgm zzgm) {
        int zzg = zzg(i << 3);
        int zza2 = zzgm.zza();
        return zzg + zzg(zza2) + zza2;
    }

    @Deprecated
    static int zzc(int i, zzjg zzjg, zzjv zzjv) {
        int zzg = zzg(i << 3) << 1;
        zzgd zzgd = (zzgd) zzjg;
        int zzbl = zzgd.zzbl();
        if (zzbl == -1) {
            zzbl = zzjv.zzb(zzgd);
            zzgd.zzc(zzbl);
        }
        return zzg + zzbl;
    }

    @Deprecated
    public static int zzc(zzjg zzjg) {
        return zzjg.zzbp();
    }

    public static int zzd(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zzd(int i, zzgm zzgm) {
        return (zzg(8) << 1) + zzg(2, i) + zzc(3, zzgm);
    }

    public static int zzd(long j) {
        return zze(j);
    }

    public static int zze(int i) {
        return zzg(i << 3);
    }

    public static int zze(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zze(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzf(int i) {
        if (i >= 0) {
            return zzg(i);
        }
        return 10;
    }

    public static int zzf(int i, int i2) {
        return zzg(i << 3) + zzf(i2);
    }

    public static int zzf(int i, long j) {
        return zzg(i << 3) + zze(zzi(j));
    }

    public static int zzf(long j) {
        return zze(zzi(j));
    }

    public static int zzg(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzg(int i, int i2) {
        return zzg(i << 3) + zzg(i2);
    }

    public static int zzg(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zzg(long j) {
        return 8;
    }

    public static int zzh(int i) {
        return zzg(zzm(i));
    }

    public static int zzh(int i, int i2) {
        return zzg(i << 3) + zzg(zzm(i2));
    }

    public static int zzh(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(int i) {
        return 4;
    }

    public static int zzi(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzj(int i) {
        return 4;
    }

    public static int zzj(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzk(int i) {
        return zzf(i);
    }

    public static int zzk(int i, int i2) {
        return zzg(i << 3) + zzf(i2);
    }

    @Deprecated
    public static int zzl(int i) {
        return zzg(i);
    }

    private static int zzm(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b);

    public final void zza(double d) {
        zzc(Double.doubleToRawLongBits(d));
    }

    public final void zza(float f) {
        zzd(Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i);

    public final void zza(int i, double d) {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zza(int i, float f) {
        zze(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, int i2);

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzgm zzgm);

    public abstract void zza(int i, zzjg zzjg);

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzjg zzjg, zzjv zzjv);

    public abstract void zza(int i, String str);

    public abstract void zza(int i, boolean z);

    public abstract void zza(long j);

    public abstract void zza(zzgm zzgm);

    public abstract void zza(zzjg zzjg);

    public abstract void zza(String str);

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzkz zzkz) {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzkz);
        byte[] bytes = str.getBytes(zzhx.zza);
        try {
            zzb(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    public final void zza(boolean z) {
        zza(z ? (byte) 1 : 0);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzb(int i);

    public abstract void zzb(int i, int i2);

    public final void zzb(int i, long j) {
        zza(i, zzi(j));
    }

    public abstract void zzb(int i, zzgm zzgm);

    public final void zzb(long j) {
        zza(zzi(j));
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(byte[] bArr, int i, int i2);

    public final void zzc(int i) {
        zzb(zzm(i));
    }

    public abstract void zzc(int i, int i2);

    public abstract void zzc(int i, long j);

    public abstract void zzc(long j);

    public abstract void zzd(int i);

    public final void zzd(int i, int i2) {
        zzc(i, zzm(i2));
    }

    public abstract void zze(int i, int i2);
}
