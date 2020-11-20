package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.spongycastle.asn1.eac.CertificateBody;

public abstract class zzejo extends zzeiv {
    private static final Logger logger = Logger.getLogger(zzejo.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzikb = zzenl.zzbkj();
    zzejr zzikc;

    static class zza extends zzejo {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i2 | 0 | (bArr.length - i2)) >= 0) {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i2;
            } else {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
        }

        private final void write(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void writeTag(int i, int i2) {
            zzgr((i << 3) | i2);
        }

        public final void zza(int i, zzeiu zzeiu) {
            writeTag(i, 2);
            zzai(zzeiu);
        }

        public final void zza(int i, zzels zzels) {
            writeTag(1, 3);
            zzad(2, i);
            writeTag(3, 2);
            zzg(zzels);
            writeTag(1, 4);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzels zzels, zzemn zzemn) {
            writeTag(i, 2);
            zzeik zzeik = (zzeik) zzels;
            int zzbfh = zzeik.zzbfh();
            if (zzbfh == -1) {
                zzbfh = zzemn.zzau(zzeik);
                zzeik.zzfu(zzbfh);
            }
            zzgr(zzbfh);
            zzemn.zza(zzels, this.zzikc);
        }

        public final void zzac(int i, int i2) {
            writeTag(i, 0);
            zzgq(i2);
        }

        public final void zzad(int i, int i2) {
            writeTag(i, 0);
            zzgr(i2);
        }

        public final void zzaf(int i, int i2) {
            writeTag(i, 5);
            zzgt(i2);
        }

        public final void zzai(zzeiu zzeiu) {
            zzgr(zzeiu.size());
            zzeiu.zza((zzeiv) this);
        }

        public final void zzb(int i, zzeiu zzeiu) {
            writeTag(1, 3);
            zzad(2, i);
            zza(3, zzeiu);
            writeTag(1, 4);
        }

        public final int zzbha() {
            return this.limit - this.position;
        }

        public final void zzd(byte b) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzfh(long j) {
            if (!zzejo.zzikb || zzbha() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & CertificateBody.profileType) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzenl.zza(bArr3, (long) i3, (byte) ((((int) j) & CertificateBody.profileType) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzenl.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzfj(long j) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzg(zzels zzels) {
            zzgr(zzels.zzbhz());
            zzels.zzb(this);
        }

        public final void zzgq(int i) {
            if (i >= 0) {
                zzgr(i);
            } else {
                zzfh((long) i);
            }
        }

        public final void zzgr(int i) {
            if (!zzejo.zzikb || zzeir.zzbfn() || zzbha() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & CertificateBody.profileType) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                if ((i & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    zzenl.zza(bArr3, (long) i4, (byte) (i | 128));
                    i >>>= 7;
                    if ((i & -128) != 0) {
                        byte[] bArr4 = this.buffer;
                        int i5 = this.position;
                        this.position = i5 + 1;
                        zzenl.zza(bArr4, (long) i5, (byte) (i | 128));
                        i >>>= 7;
                        if ((i & -128) != 0) {
                            byte[] bArr5 = this.buffer;
                            int i6 = this.position;
                            this.position = i6 + 1;
                            zzenl.zza(bArr5, (long) i6, (byte) (i | 128));
                            i >>>= 7;
                            if ((i & -128) != 0) {
                                byte[] bArr6 = this.buffer;
                                int i7 = this.position;
                                this.position = i7 + 1;
                                zzenl.zza(bArr6, (long) i7, (byte) (i | 128));
                                i >>>= 7;
                            }
                        }
                    }
                }
                byte[] bArr7 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzenl.zza(bArr7, (long) i8, (byte) i);
            }
        }

        public final void zzgt(int i) {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzh(int i, boolean z) {
            writeTag(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzht(String str) {
            int i = this.position;
            try {
                int zzgw = zzgw(str.length() * 3);
                int zzgw2 = zzgw(str.length());
                if (zzgw2 == zzgw) {
                    this.position = i + zzgw2;
                    int zza = zzeno.zza(str, this.buffer, this.position, zzbha());
                    this.position = i;
                    zzgr((zza - i) - zzgw2);
                    this.position = zza;
                    return;
                }
                zzgr(zzeno.zzc(str));
                this.position = zzeno.zza(str, this.buffer, this.position, zzbha());
            } catch (zzenr e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        public final void zzi(int i, long j) {
            writeTag(i, 0);
            zzfh(j);
        }

        public final void zzi(int i, String str) {
            writeTag(i, 2);
            zzht(str);
        }

        public final void zzi(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public final void zzk(int i, long j) {
            writeTag(i, 1);
            zzfj(j);
        }

        public final void zzk(byte[] bArr, int i, int i2) {
            zzgr(i2);
            write(bArr, 0, i2);
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejo.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzejo() {
    }

    public static int zza(int i, zzekx zzekx) {
        int zzgw = zzgw(i << 3);
        int zzbhz = zzekx.zzbhz();
        return zzgw + zzgw(zzbhz) + zzbhz;
    }

    public static int zza(zzekx zzekx) {
        int zzbhz = zzekx.zzbhz();
        return zzgw(zzbhz) + zzbhz;
    }

    static int zza(zzels zzels, zzemn zzemn) {
        zzeik zzeik = (zzeik) zzels;
        int zzbfh = zzeik.zzbfh();
        if (zzbfh == -1) {
            zzbfh = zzemn.zzau(zzeik);
            zzeik.zzfu(zzbfh);
        }
        return zzgw(zzbfh) + zzbfh;
    }

    public static int zzag(int i, int i2) {
        return zzgw(i << 3) + zzgv(i2);
    }

    public static int zzah(int i, int i2) {
        return zzgw(i << 3) + zzgw(i2);
    }

    public static int zzai(int i, int i2) {
        return zzgw(i << 3) + zzgw(zzhb(i2));
    }

    public static int zzaj(int i, int i2) {
        return zzgw(i << 3) + 4;
    }

    public static int zzaj(zzeiu zzeiu) {
        int size = zzeiu.size();
        return zzgw(size) + size;
    }

    public static int zzak(int i, int i2) {
        return zzgw(i << 3) + 4;
    }

    public static int zzal(int i, int i2) {
        return zzgw(i << 3) + zzgv(i2);
    }

    public static int zzb(int i, float f) {
        return zzgw(i << 3) + 4;
    }

    public static int zzb(int i, zzekx zzekx) {
        return (zzgw(8) << 1) + zzah(2, i) + zza(3, zzekx);
    }

    public static int zzb(int i, zzels zzels) {
        return (zzgw(8) << 1) + zzah(2, i) + zzgw(24) + zzh(zzels);
    }

    static int zzb(int i, zzels zzels, zzemn zzemn) {
        return zzgw(i << 3) + zza(zzels, zzemn);
    }

    public static int zzbt(boolean z) {
        return 1;
    }

    public static int zzc(int i, double d) {
        return zzgw(i << 3) + 8;
    }

    public static int zzc(int i, zzeiu zzeiu) {
        int zzgw = zzgw(i << 3);
        int size = zzeiu.size();
        return zzgw + zzgw(size) + size;
    }

    @Deprecated
    static int zzc(int i, zzels zzels, zzemn zzemn) {
        int zzgw = zzgw(i << 3) << 1;
        zzeik zzeik = (zzeik) zzels;
        int zzbfh = zzeik.zzbfh();
        if (zzbfh == -1) {
            zzbfh = zzemn.zzau(zzeik);
            zzeik.zzfu(zzbfh);
        }
        return zzgw + zzbfh;
    }

    public static int zzd(double d) {
        return 8;
    }

    public static int zzd(int i, zzeiu zzeiu) {
        return (zzgw(8) << 1) + zzah(2, i) + zzc(3, zzeiu);
    }

    public static int zzfk(long j) {
        return zzfl(j);
    }

    public static int zzfl(long j) {
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

    public static int zzfm(long j) {
        return zzfl(zzfp(j));
    }

    public static int zzfn(long j) {
        return 8;
    }

    public static int zzfo(long j) {
        return 8;
    }

    private static long zzfp(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzgu(int i) {
        return zzgw(i << 3);
    }

    public static int zzgv(int i) {
        if (i >= 0) {
            return zzgw(i);
        }
        return 10;
    }

    public static int zzgw(int i) {
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

    public static int zzgx(int i) {
        return zzgw(zzhb(i));
    }

    public static int zzgy(int i) {
        return 4;
    }

    public static int zzgz(int i) {
        return 4;
    }

    public static int zzh(zzels zzels) {
        int zzbhz = zzels.zzbhz();
        return zzgw(zzbhz) + zzbhz;
    }

    public static int zzha(int i) {
        return zzgv(i);
    }

    private static int zzhb(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzhc(int i) {
        return zzgw(i);
    }

    public static int zzhu(String str) {
        int i;
        try {
            i = zzeno.zzc(str);
        } catch (zzenr unused) {
            i = str.getBytes(zzekk.UTF_8).length;
        }
        return zzgw(i) + i;
    }

    public static int zzi(int i, boolean z) {
        return zzgw(i << 3) + 1;
    }

    @Deprecated
    public static int zzi(zzels zzels) {
        return zzels.zzbhz();
    }

    public static int zzj(int i, String str) {
        return zzgw(i << 3) + zzhu(str);
    }

    public static int zzl(int i, long j) {
        return zzgw(i << 3) + zzfl(j);
    }

    public static int zzm(int i, long j) {
        return zzgw(i << 3) + zzfl(j);
    }

    public static int zzn(int i, long j) {
        return zzgw(i << 3) + zzfl(zzfp(j));
    }

    public static int zzo(int i, long j) {
        return zzgw(i << 3) + 8;
    }

    public static int zzp(int i, long j) {
        return zzgw(i << 3) + 8;
    }

    public static zzejo zzv(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzw(byte[] bArr) {
        int length = bArr.length;
        return zzgw(length) + length;
    }

    public abstract void writeTag(int i, int i2);

    public final void zza(int i, float f) {
        zzaf(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, zzeiu zzeiu);

    public abstract void zza(int i, zzels zzels);

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzels zzels, zzemn zzemn);

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzenr zzenr) {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzenr);
        byte[] bytes = str.getBytes(zzekk.UTF_8);
        try {
            zzgr(bytes.length);
            zzi(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    public abstract void zzac(int i, int i2);

    public abstract void zzad(int i, int i2);

    public final void zzae(int i, int i2) {
        zzad(i, zzhb(i2));
    }

    public abstract void zzaf(int i, int i2);

    public abstract void zzai(zzeiu zzeiu);

    public final void zzb(int i, double d) {
        zzk(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zzb(int i, zzeiu zzeiu);

    public abstract int zzbha();

    public final void zzbhb() {
        if (zzbha() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzbs(boolean z) {
        zzd(z ? (byte) 1 : 0);
    }

    public final void zzc(double d) {
        zzfj(Double.doubleToRawLongBits(d));
    }

    public abstract void zzd(byte b);

    public final void zzf(float f) {
        zzgt(Float.floatToRawIntBits(f));
    }

    public abstract void zzfh(long j);

    public final void zzfi(long j) {
        zzfh(zzfp(j));
    }

    public abstract void zzfj(long j);

    public abstract void zzg(zzels zzels);

    public abstract void zzgq(int i);

    public abstract void zzgr(int i);

    public final void zzgs(int i) {
        zzgr(zzhb(i));
    }

    public abstract void zzgt(int i);

    public abstract void zzh(int i, boolean z);

    public abstract void zzht(String str);

    public abstract void zzi(int i, long j);

    public abstract void zzi(int i, String str);

    public final void zzj(int i, long j) {
        zzi(i, zzfp(j));
    }

    public abstract void zzk(int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i, int i2);
}
