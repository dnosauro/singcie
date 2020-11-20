package com.google.android.gms.internal.ads;

public final class zzeil {
    private final byte[] zziik = new byte[256];
    private int zziil;
    private int zziim;

    public zzeil(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zziik[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr2 = this.zziik;
            b = (b + bArr2[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[b];
            bArr2[b] = b2;
        }
        this.zziil = 0;
        this.zziim = 0;
    }

    public final void zzs(byte[] bArr) {
        int i = this.zziil;
        int i2 = this.zziim;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.zziik;
            i2 = (i2 + bArr2[i]) & 255;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.zziil = i;
        this.zziim = i2;
    }
}
