package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;

public final class zzejh extends OutputStream {
    private static final byte[] zzijg = new byte[0];
    private byte[] buffer = new byte[128];
    private final int zzijh = 128;
    private final ArrayList<zzeiu> zziji = new ArrayList<>();
    private int zzijj;
    private int zzijk;

    zzejh(int i) {
    }

    private final synchronized int size() {
        return this.zzijj + this.zzijk;
    }

    private final void zzgb(int i) {
        this.zziji.add(new zzeje(this.buffer));
        this.zzijj += this.buffer.length;
        this.buffer = new byte[Math.max(this.zzijh, Math.max(i, this.zzijj >>> 1))];
        this.zzijk = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public final synchronized void write(int i) {
        if (this.zzijk == this.buffer.length) {
            zzgb(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.zzijk;
        this.zzijk = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (i2 <= this.buffer.length - this.zzijk) {
            System.arraycopy(bArr, i, this.buffer, this.zzijk, i2);
            this.zzijk += i2;
            return;
        }
        int length = this.buffer.length - this.zzijk;
        System.arraycopy(bArr, i, this.buffer, this.zzijk, length);
        int i3 = i2 - length;
        zzgb(i3);
        System.arraycopy(bArr, i + length, this.buffer, 0, i3);
        this.zzijk = i3;
    }

    public final synchronized zzeiu zzbfg() {
        if (this.zzijk >= this.buffer.length) {
            this.zziji.add(new zzeje(this.buffer));
            this.buffer = zzijg;
        } else if (this.zzijk > 0) {
            byte[] bArr = this.buffer;
            int i = this.zzijk;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            this.zziji.add(new zzeje(bArr2));
        }
        this.zzijj += this.zzijk;
        this.zzijk = 0;
        return zzeiu.zzl(this.zziji);
    }
}
