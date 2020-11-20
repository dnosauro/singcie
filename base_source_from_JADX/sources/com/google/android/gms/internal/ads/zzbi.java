package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;

public final class zzbi extends ByteArrayOutputStream {
    private final zzat zzce;

    public zzbi(zzat zzat, int i) {
        this.zzce = zzat;
        this.buf = this.zzce.zzf(Math.max(i, 256));
    }

    private final void zzg(int i) {
        if (this.count + i > this.buf.length) {
            byte[] zzf = this.zzce.zzf((this.count + i) << 1);
            System.arraycopy(this.buf, 0, zzf, 0, this.count);
            this.zzce.zza(this.buf);
            this.buf = zzf;
        }
    }

    public final void close() {
        this.zzce.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzce.zza(this.buf);
    }

    public final synchronized void write(int i) {
        zzg(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzg(i2);
        super.write(bArr, i, i2);
    }
}
