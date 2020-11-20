package com.google.android.gms.internal.ads;

final class zzkt {
    private static final long[] zzawf = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private int state;
    private final byte[] zzaoz = new byte[8];

    public static long zza(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~zzawf[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    public static int zzar(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = zzawf;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long zza(zzjz zzjz, boolean z, boolean z2, int i) {
        if (this.state == 0) {
            if (!zzjz.zza(this.zzaoz, 0, 1, z)) {
                return -1;
            }
            this.length = zzar(this.zzaoz[0] & 255);
            if (this.length != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.length;
        if (i2 > i) {
            this.state = 0;
            return -2;
        }
        if (i2 != 1) {
            zzjz.readFully(this.zzaoz, 1, i2 - 1);
        }
        this.state = 0;
        return zza(this.zzaoz, this.length, z2);
    }

    public final int zzgw() {
        return this.length;
    }
}
