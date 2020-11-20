package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.InputStream;

final class zzba extends FilterInputStream {
    private final long zzcm;
    private long zzcn;

    zzba(InputStream inputStream, long j) {
        super(inputStream);
        this.zzcm = j;
    }

    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.zzcn++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzcn += (long) read;
        }
        return read;
    }

    /* access modifiers changed from: package-private */
    public final long zzp() {
        return this.zzcm - this.zzcn;
    }
}
