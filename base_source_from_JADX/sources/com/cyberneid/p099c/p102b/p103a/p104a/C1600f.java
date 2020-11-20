package com.cyberneid.p099c.p102b.p103a.p104a;

import java.io.OutputStream;

/* renamed from: com.cyberneid.c.b.a.a.f */
public class C1600f extends C1598d {

    /* renamed from: e */
    OutputStream f4853e;

    /* renamed from: f */
    C1601g f4854f = new C1601g();

    public C1600f(OutputStream outputStream) {
        if (outputStream != null) {
            this.f4853e = outputStream;
            return;
        }
        throw new IllegalArgumentException("stream == null!");
    }

    /* renamed from: a */
    public int mo7421a(byte[] bArr, int i, int i2) {
        this.f4843d = 0;
        int b = this.f4854f.mo7474b(bArr, i, i2, this.f4841b);
        if (b > 0) {
            this.f4841b += (long) b;
        }
        return b;
    }

    /* renamed from: a */
    public void mo7420a() {
        long h = mo7433h();
        mo7425b(h);
        mo7427c(h);
        super.mo7420a();
        this.f4854f.mo7475b();
    }

    /* renamed from: c */
    public void mo7427c(long j) {
        long j2 = mo7435j();
        super.mo7427c(j);
        long j3 = mo7435j();
        this.f4854f.mo7472a(this.f4853e, (int) (j3 - j2), j2);
        this.f4854f.mo7476b(j3);
        this.f4853e.flush();
    }

    /* renamed from: d */
    public int mo7428d() {
        this.f4843d = 0;
        int a = this.f4854f.mo7468a(this.f4841b);
        if (a >= 0) {
            this.f4841b++;
        }
        return a;
    }

    /* renamed from: h */
    public long mo7433h() {
        return this.f4854f.mo7470a();
    }

    public void write(int i) {
        mo7453k();
        this.f4854f.mo7471a(i, this.f4841b);
        this.f4841b++;
    }

    public void write(byte[] bArr, int i, int i2) {
        mo7453k();
        this.f4854f.mo7473a(bArr, i, i2, this.f4841b);
        this.f4841b += (long) i2;
    }
}
