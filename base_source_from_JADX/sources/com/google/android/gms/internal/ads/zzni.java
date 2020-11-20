package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzni implements zzkh {
    private final zzpn zzapq = new zzpn(32);
    private final zzol zzbdk;
    private final int zzbfw;
    private final zzng zzbfx = new zzng();
    private final zznj zzbfy = new zznj();
    private final AtomicInteger zzbfz = new AtomicInteger();
    private zznl zzbga;
    private zznl zzbgb;
    private zzhp zzbgc;
    private boolean zzbgd;
    private zzhp zzbge;
    private long zzbgf;
    private int zzbgg;
    private zznk zzbgh;

    public zzni(zzol zzol) {
        this.zzbdk = zzol;
        this.zzbfw = zzol.zzio();
        int i = this.zzbfw;
        this.zzbgg = i;
        this.zzbga = new zznl(0, i);
        this.zzbgb = this.zzbga;
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzej(j);
        long j2 = j;
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j2 - this.zzbga.zzbgj);
            int min = Math.min(i - i2, this.zzbfw - i3);
            zzoi zzoi = this.zzbga.zzbgl;
            System.arraycopy(zzoi.data, i3 + 0, bArr, i2, min);
            j2 += (long) min;
            i2 += min;
            if (j2 == this.zzbga.zzawh) {
                this.zzbdk.zza(zzoi);
                this.zzbga = this.zzbga.zzik();
            }
        }
    }

    private final int zzba(int i) {
        if (this.zzbgg == this.zzbfw) {
            this.zzbgg = 0;
            if (this.zzbgb.zzbgk) {
                this.zzbgb = this.zzbgb.zzbgm;
            }
            zznl zznl = this.zzbgb;
            zzoi zzin = this.zzbdk.zzin();
            zznl zznl2 = new zznl(this.zzbgb.zzawh, this.zzbfw);
            zznl.zzbgl = zzin;
            zznl.zzbgm = zznl2;
            zznl.zzbgk = true;
        }
        return Math.min(i, this.zzbfw - this.zzbgg);
    }

    private final void zzej(long j) {
        while (j >= this.zzbga.zzawh) {
            this.zzbdk.zza(this.zzbga.zzbgl);
            this.zzbga = this.zzbga.zzik();
        }
    }

    private final void zzib() {
        this.zzbfx.zzib();
        zznl zznl = this.zzbga;
        if (zznl.zzbgk) {
            zzoi[] zzoiArr = new zzoi[((this.zzbgb.zzbgk ? 1 : 0) + (((int) (this.zzbgb.zzbgj - zznl.zzbgj)) / this.zzbfw))];
            for (int i = 0; i < zzoiArr.length; i++) {
                zzoiArr[i] = zznl.zzbgl;
                zznl = zznl.zzik();
            }
            this.zzbdk.zza(zzoiArr);
        }
        this.zzbga = new zznl(0, this.zzbfw);
        this.zzbgb = this.zzbga;
        this.zzbgf = 0;
        this.zzbgg = this.zzbfw;
        this.zzbdk.zzn();
    }

    private final boolean zzii() {
        return this.zzbfz.compareAndSet(0, 1);
    }

    private final void zzij() {
        if (!this.zzbfz.compareAndSet(1, 0)) {
            zzib();
        }
    }

    public final void disable() {
        if (this.zzbfz.getAndSet(2) == 0) {
            zzib();
        }
    }

    public final int zza(zzhr zzhr, zzjl zzjl, boolean z, boolean z2, long j) {
        int i;
        switch (this.zzbfx.zza(zzhr, zzjl, z, z2, this.zzbgc, this.zzbfy)) {
            case -5:
                this.zzbgc = zzhr.zzahv;
                return -5;
            case -4:
                if (zzjl.zzgl()) {
                    return -4;
                }
                if (zzjl.zzanz < j) {
                    zzjl.zzaa(Integer.MIN_VALUE);
                }
                if (zzjl.isEncrypted()) {
                    zznj zznj = this.zzbfy;
                    long j2 = zznj.zzawl;
                    this.zzapq.reset(1);
                    zza(j2, this.zzapq.data, 1);
                    long j3 = j2 + 1;
                    byte b = this.zzapq.data[0];
                    boolean z3 = (b & 128) != 0;
                    byte b2 = b & Byte.MAX_VALUE;
                    if (zzjl.zzany.f6906iv == null) {
                        zzjl.zzany.f6906iv = new byte[16];
                    }
                    zza(j3, zzjl.zzany.f6906iv, (int) b2);
                    long j4 = j3 + ((long) b2);
                    if (z3) {
                        this.zzapq.reset(2);
                        zza(j4, this.zzapq.data, 2);
                        j4 += 2;
                        i = this.zzapq.readUnsignedShort();
                    } else {
                        i = 1;
                    }
                    int[] iArr = zzjl.zzany.numBytesOfClearData;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzjl.zzany.numBytesOfEncryptedData;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr3 = new int[i];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i2 = i * 6;
                        this.zzapq.reset(i2);
                        zza(j4, this.zzapq.data, i2);
                        j4 += (long) i2;
                        this.zzapq.zzbl(0);
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr2[i3] = this.zzapq.readUnsignedShort();
                            iArr4[i3] = this.zzapq.zzjf();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zznj.size - ((int) (j4 - zznj.zzawl));
                    }
                    zzkg zzkg = zznj.zzaro;
                    zzjl.zzany.set(i, iArr2, iArr4, zzkg.zzaoy, zzjl.zzany.f6906iv, zzkg.zzaox);
                    int i4 = (int) (j4 - zznj.zzawl);
                    zznj.zzawl += (long) i4;
                    zznj.size -= i4;
                }
                zzjl.zzac(this.zzbfy.size);
                long j5 = this.zzbfy.zzawl;
                ByteBuffer byteBuffer = zzjl.zzda;
                int i5 = this.zzbfy.size;
                zzej(j5);
                while (i5 > 0) {
                    int i6 = (int) (j5 - this.zzbga.zzbgj);
                    int min = Math.min(i5, this.zzbfw - i6);
                    zzoi zzoi = this.zzbga.zzbgl;
                    byteBuffer.put(zzoi.data, i6 + 0, min);
                    j5 += (long) min;
                    i5 -= min;
                    if (j5 == this.zzbga.zzawh) {
                        this.zzbdk.zza(zzoi);
                        this.zzbga = this.zzbga.zzik();
                    }
                }
                zzej(this.zzbfy.zzbgi);
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    public final int zza(zzjz zzjz, int i, boolean z) {
        if (!zzii()) {
            int zzaf = zzjz.zzaf(i);
            if (zzaf != -1) {
                return zzaf;
            }
            throw new EOFException();
        }
        try {
            int read = zzjz.read(this.zzbgb.zzbgl.data, this.zzbgg + 0, zzba(i));
            if (read != -1) {
                this.zzbgg += read;
                this.zzbgf += (long) read;
                return read;
            }
            throw new EOFException();
        } finally {
            zzij();
        }
    }

    public final void zza(long j, int i, int i2, int i3, zzkg zzkg) {
        if (!zzii()) {
            long j2 = j;
            this.zzbfx.zzei(j);
            return;
        }
        long j3 = j;
        try {
            this.zzbfx.zza(j, i, (this.zzbgf - ((long) i2)) - ((long) i3), i2, zzkg);
        } finally {
            zzij();
        }
    }

    public final void zza(zznk zznk) {
        this.zzbgh = zznk;
    }

    public final void zza(zzpn zzpn, int i) {
        if (!zzii()) {
            zzpn.zzbm(i);
            return;
        }
        while (i > 0) {
            int zzba = zzba(i);
            zzpn.zze(this.zzbgb.zzbgl.data, this.zzbgg + 0, zzba);
            this.zzbgg += zzba;
            this.zzbgf += (long) zzba;
            i -= zzba;
        }
        zzij();
    }

    public final void zze(zzhp zzhp) {
        zzhp zzhp2 = zzhp == null ? null : zzhp;
        boolean zzg = this.zzbfx.zzg(zzhp2);
        this.zzbge = zzhp;
        this.zzbgd = false;
        zznk zznk = this.zzbgh;
        if (zznk != null && zzg) {
            zznk.zzf(zzhp2);
        }
    }

    public final boolean zze(long j, boolean z) {
        long zzd = this.zzbfx.zzd(j, z);
        if (zzd == -1) {
            return false;
        }
        zzej(zzd);
        return true;
    }

    public final long zzhv() {
        return this.zzbfx.zzhv();
    }

    public final int zzid() {
        return this.zzbfx.zzid();
    }

    public final boolean zzie() {
        return this.zzbfx.zzie();
    }

    public final zzhp zzif() {
        return this.zzbfx.zzif();
    }

    public final void zzih() {
        long zzig = this.zzbfx.zzig();
        if (zzig != -1) {
            zzej(zzig);
        }
    }

    public final void zzk(boolean z) {
        int andSet = this.zzbfz.getAndSet(z ? 0 : 2);
        zzib();
        this.zzbfx.zzic();
        if (andSet == 2) {
            this.zzbgc = null;
        }
    }
}
