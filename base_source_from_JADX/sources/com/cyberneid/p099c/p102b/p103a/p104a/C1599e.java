package com.cyberneid.p099c.p102b.p103a.p104a;

import java.io.InputStream;

/* renamed from: com.cyberneid.c.b.a.a.e */
public class C1599e extends C1594b {

    /* renamed from: e */
    private InputStream f4851e;

    /* renamed from: f */
    private C1601g f4852f = new C1601g();

    public C1599e(InputStream inputStream) {
        if (inputStream != null) {
            this.f4851e = inputStream;
            return;
        }
        throw new IllegalArgumentException("stream == null!");
    }

    /* renamed from: a */
    public int mo7421a(byte[] bArr, int i, int i2) {
        this.f4843d = 0;
        if (this.f4841b >= this.f4852f.mo7470a()) {
            this.f4852f.mo7469a(this.f4851e, (int) ((this.f4841b - this.f4852f.mo7470a()) + ((long) i2)));
        }
        int b = this.f4852f.mo7474b(bArr, i, i2, this.f4841b);
        if (b > 0) {
            this.f4841b += (long) b;
        }
        return b;
    }

    /* renamed from: a */
    public void mo7420a() {
        super.mo7420a();
        this.f4852f.mo7475b();
    }

    /* renamed from: c */
    public void mo7427c(long j) {
        super.mo7427c(j);
        this.f4852f.mo7476b(mo7435j());
    }

    /* renamed from: d */
    public int mo7428d() {
        this.f4843d = 0;
        if (this.f4841b >= this.f4852f.mo7470a()) {
            int a = (int) ((this.f4841b - this.f4852f.mo7470a()) + 1);
            if (this.f4852f.mo7469a(this.f4851e, a) < a) {
                return -1;
            }
        }
        int a2 = this.f4852f.mo7468a(this.f4841b);
        if (a2 >= 0) {
            this.f4841b++;
        }
        return a2;
    }
}
