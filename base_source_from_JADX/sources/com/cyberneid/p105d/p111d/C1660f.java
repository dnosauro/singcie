package com.cyberneid.p105d.p111d;

import java.io.InputStream;

/* renamed from: com.cyberneid.d.d.f */
public class C1660f extends InputStream {

    /* renamed from: a */
    private final C1662h f5485a;

    /* renamed from: b */
    private long f5486b = 0;

    public C1660f(C1662h hVar) {
        this.f5485a = hVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7726a() {
        this.f5485a.mo7706a(this.f5486b);
    }

    public int available() {
        mo7726a();
        long c = this.f5485a.mo7711c() - this.f5485a.mo7709b();
        if (c > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) c;
    }

    public int read() {
        mo7726a();
        if (this.f5485a.mo7716e()) {
            return -1;
        }
        int read = this.f5485a.read();
        this.f5486b++;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        mo7726a();
        if (this.f5485a.mo7716e()) {
            return -1;
        }
        int read = this.f5485a.read(bArr, i, i2);
        this.f5486b += (long) read;
        return read;
    }

    public long skip(long j) {
        mo7726a();
        this.f5485a.mo7706a(this.f5486b + j);
        this.f5486b += j;
        return j;
    }
}
