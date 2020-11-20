package com.cyberneid.p105d.p114g.p118b;

/* renamed from: com.cyberneid.d.g.b.a */
public class C1766a {

    /* renamed from: a */
    private int f5744a;

    /* renamed from: b */
    private boolean f5745b;

    public C1766a() {
        this.f5744a = -4;
        this.f5745b = false;
        this.f5744a = -4;
    }

    public C1766a(int i) {
        this.f5744a = -4;
        this.f5745b = false;
        this.f5744a = i;
    }

    public C1766a(byte[] bArr) {
        this.f5744a = -4;
        this.f5745b = false;
        this.f5744a = 0;
        this.f5744a = (bArr[0] & 255) | this.f5744a;
        this.f5744a <<= 8;
        this.f5744a |= bArr[1] & 255;
        this.f5744a <<= 8;
        this.f5744a |= bArr[2] & 255;
        this.f5744a <<= 8;
        this.f5744a = (bArr[3] & 255) | this.f5744a;
    }

    /* renamed from: a */
    public static C1766a m7067a() {
        C1766a aVar = new C1766a();
        aVar.mo7973g(true);
        aVar.mo7966c(true);
        aVar.mo7971f(true);
        aVar.mo7969e(true);
        aVar.mo7964b(true);
        aVar.mo7967d(true);
        aVar.mo7962a(true);
        aVar.mo7975h(true);
        return aVar;
    }

    /* renamed from: a */
    private boolean m7068a(int i) {
        return ((1 << (i - 1)) & this.f5744a) != 0;
    }

    /* renamed from: a */
    private boolean m7069a(int i, boolean z) {
        int i2 = this.f5744a;
        this.f5744a = z ? (1 << (i - 1)) | i2 : ((1 << (i - 1)) ^ -1) & i2;
        return ((1 << (i - 1)) & this.f5744a) != 0;
    }

    /* renamed from: a */
    public void mo7962a(boolean z) {
        if (!this.f5745b) {
            m7069a(3, z);
        }
    }

    /* renamed from: b */
    public int mo7963b() {
        m7069a(1, true);
        m7069a(7, false);
        m7069a(8, false);
        for (int i = 13; i <= 32; i++) {
            m7069a(i, false);
        }
        return this.f5744a;
    }

    /* renamed from: b */
    public void mo7964b(boolean z) {
        if (!this.f5745b) {
            m7069a(4, z);
        }
    }

    /* renamed from: c */
    public int mo7965c() {
        return this.f5744a;
    }

    /* renamed from: c */
    public void mo7966c(boolean z) {
        if (!this.f5745b) {
            m7069a(5, z);
        }
    }

    /* renamed from: d */
    public void mo7967d(boolean z) {
        if (!this.f5745b) {
            m7069a(6, z);
        }
    }

    /* renamed from: d */
    public boolean mo7968d() {
        return m7068a(6);
    }

    /* renamed from: e */
    public void mo7969e(boolean z) {
        if (!this.f5745b) {
            m7069a(9, z);
        }
    }

    /* renamed from: e */
    public boolean mo7970e() {
        return m7068a(9);
    }

    /* renamed from: f */
    public void mo7971f(boolean z) {
        if (!this.f5745b) {
            m7069a(10, z);
        }
    }

    /* renamed from: f */
    public boolean mo7972f() {
        return m7068a(10);
    }

    /* renamed from: g */
    public void mo7973g(boolean z) {
        if (!this.f5745b) {
            m7069a(11, z);
        }
    }

    /* renamed from: g */
    public boolean mo7974g() {
        return m7068a(11);
    }

    /* renamed from: h */
    public void mo7975h(boolean z) {
        if (!this.f5745b) {
            m7069a(12, z);
        }
    }

    /* renamed from: h */
    public boolean mo7976h() {
        return m7068a(12);
    }

    /* renamed from: i */
    public void mo7977i() {
        this.f5745b = true;
    }

    /* renamed from: j */
    public boolean mo7978j() {
        return this.f5745b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo7979k() {
        if (!mo7970e() && !mo7972f() && !mo7974g()) {
            return mo7976h();
        }
        return true;
    }
}
