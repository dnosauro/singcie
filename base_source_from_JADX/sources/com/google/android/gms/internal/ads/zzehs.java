package com.google.android.gms.internal.ads;

public final class zzehs {
    private final byte[] data;

    private zzehs(byte[] bArr, int i, int i2) {
        this.data = new byte[i2];
        System.arraycopy(bArr, 0, this.data, 0, i2);
    }

    public static zzehs zzr(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzehs(bArr, 0, bArr.length);
    }

    public final byte[] getBytes() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
