package com.google.android.gms.internal.ads;

final class zzejb extends zzeje {
    private final int zzijc;
    private final int zzijd;

    zzejb(byte[] bArr, int i, int i2) {
        super(bArr);
        zzi(i, i + i2, bArr.length);
        this.zzijc = i;
        this.zzijd = i2;
    }

    public final int size() {
        return this.zzijd;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzijf, zzbfx() + i, bArr, i2, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzbfx() {
        return this.zzijc;
    }

    public final byte zzfy(int i) {
        zzab(i, size());
        return this.zzijf[this.zzijc + i];
    }

    /* access modifiers changed from: package-private */
    public final byte zzfz(int i) {
        return this.zzijf[this.zzijc + i];
    }
}
