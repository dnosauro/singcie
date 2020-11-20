package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.util.Arrays;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public final class zzjx implements zzjz {
    private static final byte[] zzaop = new byte[4096];
    private long position;
    private final zzon zzaoq;
    private final long zzaor;
    private byte[] zzaos = new byte[PKIFailureInfo.notAuthorized];
    private int zzaot;
    private int zzaou;

    public zzjx(zzon zzon, long j, long j2) {
        this.zzaoq = zzon;
        this.position = j;
        this.zzaor = j2;
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (!Thread.interrupted()) {
            int read = this.zzaoq.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private final int zzai(int i) {
        int min = Math.min(this.zzaou, i);
        zzaj(min);
        return min;
    }

    private final void zzaj(int i) {
        this.zzaou -= i;
        this.zzaot = 0;
        byte[] bArr = this.zzaos;
        int i2 = this.zzaou;
        if (i2 < bArr.length - PKIFailureInfo.signerNotTrusted) {
            bArr = new byte[(i2 + PKIFailureInfo.notAuthorized)];
        }
        System.arraycopy(this.zzaos, i, bArr, 0, this.zzaou);
        this.zzaos = bArr;
    }

    private final void zzak(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }

    private final int zzb(byte[] bArr, int i, int i2) {
        int i3 = this.zzaou;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zzaos, 0, bArr, i, min);
        zzaj(min);
        return min;
    }

    private final boolean zzd(int i, boolean z) {
        int i2 = this.zzaot + i;
        byte[] bArr = this.zzaos;
        if (i2 > bArr.length) {
            this.zzaos = Arrays.copyOf(this.zzaos, zzpt.zzd(bArr.length << 1, PKIFailureInfo.notAuthorized + i2, i2 + PKIFailureInfo.signerNotTrusted));
        }
        int min = Math.min(this.zzaou - this.zzaot, i);
        while (min < i) {
            min = zza(this.zzaos, this.zzaot, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        this.zzaot += i;
        this.zzaou = Math.max(this.zzaou, this.zzaot);
        return true;
    }

    public final long getLength() {
        return this.zzaor;
    }

    public final long getPosition() {
        return this.position;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int zzb = zzb(bArr, i, i2);
        if (zzb == 0) {
            zzb = zza(bArr, i, i2, 0, true);
        }
        zzak(zzb);
        return zzb;
    }

    public final void readFully(byte[] bArr, int i, int i2) {
        zza(bArr, i, i2, false);
    }

    public final void zza(byte[] bArr, int i, int i2) {
        if (zzd(i2, false)) {
            System.arraycopy(this.zzaos, this.zzaot - i2, bArr, i, i2);
        }
    }

    public final boolean zza(byte[] bArr, int i, int i2, boolean z) {
        int zzb = zzb(bArr, i, i2);
        while (zzb < i2 && zzb != -1) {
            zzb = zza(bArr, i, i2, zzb, z);
        }
        zzak(zzb);
        return zzb != -1;
    }

    public final int zzaf(int i) {
        int zzai = zzai(i);
        if (zzai == 0) {
            byte[] bArr = zzaop;
            zzai = zza(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        zzak(zzai);
        return zzai;
    }

    public final void zzag(int i) {
        int zzai = zzai(i);
        while (zzai < i && zzai != -1) {
            byte[] bArr = zzaop;
            zzai = zza(bArr, -zzai, Math.min(i, bArr.length + zzai), zzai, false);
        }
        zzak(zzai);
    }

    public final void zzah(int i) {
        zzd(i, false);
    }

    public final void zzgq() {
        this.zzaot = 0;
    }
}
