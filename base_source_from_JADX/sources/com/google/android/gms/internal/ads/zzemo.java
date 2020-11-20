package com.google.android.gms.internal.ads;

import java.io.InputStream;

final class zzemo extends InputStream {
    private int mark;
    private final /* synthetic */ zzemk zziqs;
    private zzeml zzirc;
    private zzejf zzird;
    private int zzire;
    private int zzirf;
    private int zzirg;

    public zzemo(zzemk zzemk) {
        this.zziqs = zzemk;
        initialize();
    }

    private final void initialize() {
        this.zzirc = new zzeml(this.zziqs, (zzemj) null);
        this.zzird = (zzejf) this.zzirc.next();
        this.zzire = this.zzird.size();
        this.zzirf = 0;
        this.zzirg = 0;
    }

    private final void zzbjr() {
        int i;
        if (this.zzird != null && this.zzirf == (i = this.zzire)) {
            this.zzirg += i;
            this.zzirf = 0;
            if (this.zzirc.hasNext()) {
                this.zzird = (zzejf) this.zzirc.next();
                this.zzire = this.zzird.size();
                return;
            }
            this.zzird = null;
            this.zzire = 0;
        }
    }

    private final int zzl(byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 > 0) {
            zzbjr();
            if (this.zzird == null) {
                break;
            }
            int min = Math.min(this.zzire - this.zzirf, i4);
            if (bArr != null) {
                this.zzird.zza(bArr, this.zzirf, i3, min);
                i3 += min;
            }
            this.zzirf += min;
            i4 -= min;
        }
        return i2 - i4;
    }

    public final int available() {
        return this.zziqs.size() - (this.zzirg + this.zzirf);
    }

    public final void mark(int i) {
        this.mark = this.zzirg + this.zzirf;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read() {
        zzbjr();
        zzejf zzejf = this.zzird;
        if (zzejf == null) {
            return -1;
        }
        int i = this.zzirf;
        this.zzirf = i + 1;
        return zzejf.zzfy(i) & 255;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException();
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else {
            int zzl = zzl(bArr, i, i2);
            if (zzl == 0) {
                return -1;
            }
            return zzl;
        }
    }

    public final synchronized void reset() {
        initialize();
        zzl((byte[]) null, 0, this.mark);
    }

    public final long skip(long j) {
        if (j >= 0) {
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) zzl((byte[]) null, 0, (int) j);
        }
        throw new IndexOutOfBoundsException();
    }
}
