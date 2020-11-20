package com.cyberneid.p105d.p109c.p110a;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.c.a.b */
public final class C1629b extends InputStream {

    /* renamed from: l */
    private static final C1635e f5395l = new C1635e();

    /* renamed from: m */
    private static final C1635e f5396m = new C1635e();

    /* renamed from: n */
    private static final int[] f5397n = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a */
    private InputStream f5398a;

    /* renamed from: b */
    private int f5399b;

    /* renamed from: c */
    private int f5400c;

    /* renamed from: d */
    private boolean f5401d;

    /* renamed from: e */
    private int f5402e;

    /* renamed from: f */
    private int f5403f = 8;

    /* renamed from: g */
    private C1638d f5404g;

    /* renamed from: h */
    private int f5405h;

    /* renamed from: i */
    private int f5406i;

    /* renamed from: j */
    private int f5407j = -1;

    /* renamed from: k */
    private int f5408k;

    /* renamed from: com.cyberneid.d.c.a.b$a */
    private interface C1631a {
        /* renamed from: a */
        int mo7661a();

        /* renamed from: a */
        int mo7662a(C1629b bVar);
    }

    /* renamed from: com.cyberneid.d.c.a.b$b */
    private static class C1632b extends C1633c implements C1631a {
        private C1632b() {
            super();
        }

        /* renamed from: a */
        public int mo7661a() {
            return -2;
        }

        /* renamed from: a */
        public int mo7662a(C1629b bVar) {
            return 0;
        }

        /* renamed from: b */
        public C1631a mo7663b(C1629b bVar) {
            int a;
            do {
                a = bVar.m6545b();
            } while (a == 0);
            if (a < 0) {
                return null;
            }
            return this;
        }

        public String toString() {
            return "EOL";
        }
    }

    /* renamed from: com.cyberneid.d.c.a.b$c */
    private static abstract class C1633c {
        private C1633c() {
        }

        /* renamed from: b */
        public abstract C1631a mo7663b(C1629b bVar);
    }

    /* renamed from: com.cyberneid.d.c.a.b$d */
    private static class C1634d extends C1633c implements C1631a {

        /* renamed from: a */
        private final int f5409a;

        C1634d(int i) {
            super();
            this.f5409a = i;
        }

        /* renamed from: a */
        public int mo7661a() {
            return 0;
        }

        /* renamed from: a */
        public int mo7662a(C1629b bVar) {
            bVar.m6537a(this.f5409a);
            return this.f5409a;
        }

        /* renamed from: b */
        public C1631a mo7663b(C1629b bVar) {
            return this;
        }

        public String toString() {
            return "Make up code for length " + this.f5409a;
        }
    }

    /* renamed from: com.cyberneid.d.c.a.b$e */
    private static class C1635e extends C1633c {

        /* renamed from: a */
        private C1633c f5410a;

        /* renamed from: b */
        private C1633c f5411b;

        private C1635e() {
            super();
        }

        /* renamed from: a */
        public C1633c mo7666a(int i) {
            return i == 0 ? this.f5410a : this.f5411b;
        }

        /* renamed from: a */
        public void mo7667a(int i, C1633c cVar) {
            if (i == 0) {
                this.f5410a = cVar;
            } else {
                this.f5411b = cVar;
            }
        }

        /* renamed from: b */
        public C1631a mo7663b(C1629b bVar) {
            int a = bVar.m6545b();
            if (a < 0) {
                return null;
            }
            C1633c a2 = mo7666a(a);
            if (a2 != null) {
                return a2.mo7663b(bVar);
            }
            throw new IOException("Invalid code word encountered");
        }
    }

    /* renamed from: com.cyberneid.d.c.a.b$f */
    private static class C1636f extends C1633c implements C1631a {

        /* renamed from: a */
        private final int f5412a;

        /* renamed from: b */
        private final int f5413b;

        C1636f(int i, int i2) {
            super();
            this.f5412a = i;
            this.f5413b = i2;
        }

        /* renamed from: a */
        public int mo7661a() {
            return 0;
        }

        /* renamed from: a */
        public int mo7662a(C1629b bVar) {
            bVar.m6538a(this.f5412a, this.f5413b);
            return this.f5413b;
        }

        /* renamed from: b */
        public C1631a mo7663b(C1629b bVar) {
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Run Length for ");
            sb.append(this.f5413b);
            sb.append(" bits of ");
            sb.append(this.f5412a == 0 ? "white" : "black");
            return sb.toString();
        }
    }

    static {
        m6548d();
    }

    public C1629b(InputStream inputStream, int i, int i2, boolean z) {
        this.f5398a = inputStream;
        this.f5399b = i;
        this.f5400c = i2;
        this.f5404g = new C1638d(i);
        this.f5406i = this.f5404g.mo7675c();
        this.f5401d = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6537a(int i) {
        this.f5408k += i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6538a(int i, int i2) {
        this.f5408k += i2;
        if (i != 0) {
            this.f5404g.mo7672a(this.f5405h, this.f5408k);
        }
        this.f5405h += this.f5408k;
        this.f5408k = 0;
    }

    /* renamed from: a */
    private static void m6541a(short s, C1635e eVar, C1633c cVar) {
        int i = s >> 8;
        short s2 = s & 255;
        int i2 = i - 1;
        while (i2 > 0) {
            int i3 = (s2 >> i2) & 1;
            C1633c a = eVar.mo7666a(i3);
            if (a == null) {
                a = new C1635e();
                eVar.mo7667a(i3, a);
            }
            if (a instanceof C1635e) {
                eVar = (C1635e) a;
                i2--;
            } else {
                throw new IllegalStateException("NonLeafLookupTreeNode expected, was " + a.getClass().getName());
            }
        }
        short s3 = s2 & 1;
        if (eVar.mo7666a(s3) == null) {
            eVar.mo7667a(s3, cVar);
            return;
        }
        throw new IllegalStateException("Two codes conflicting in lookup tree");
    }

    /* renamed from: a */
    private static void m6542a(short[] sArr, C1635e eVar) {
        int length = sArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            m6541a(sArr[i], eVar, (C1633c) new C1634d(i2 * 64));
            i = i2;
        }
    }

    /* renamed from: a */
    private static void m6543a(short[] sArr, C1635e eVar, boolean z) {
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            m6541a(sArr[i], eVar, (C1633c) new C1636f(z ^ true ? 1 : 0, i));
        }
    }

    /* renamed from: a */
    private boolean m6544a() {
        if (this.f5401d && this.f5403f != 0) {
            m6547c();
        }
        if (this.f5402e < 0) {
            return false;
        }
        this.f5407j++;
        int i = this.f5400c;
        if (i > 0 && this.f5407j >= i) {
            return false;
        }
        this.f5404g.mo7671a();
        this.f5405h = 0;
        int i2 = 0;
        boolean z = true;
        int i3 = 6;
        while (true) {
            if (i2 < this.f5399b || this.f5408k > 0) {
                C1631a b = (z ? f5395l : f5396m).mo7663b(this);
                if (b == null) {
                    if (i2 <= 0) {
                        return false;
                    }
                    this.f5406i = 0;
                    return true;
                } else if (b.mo7661a() == -2) {
                    i3--;
                    if (i3 == 0) {
                        return false;
                    }
                } else {
                    i2 += b.mo7662a(this);
                    if (this.f5408k == 0) {
                        z = !z;
                    }
                    i3 = -1;
                }
            } else {
                this.f5406i = 0;
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m6545b() {
        if (this.f5403f >= 8) {
            m6547c();
            if (this.f5402e < 0) {
                return -1;
            }
        }
        int i = this.f5402e;
        int[] iArr = f5397n;
        int i2 = this.f5403f;
        this.f5403f = i2 + 1;
        return (i & iArr[i2]) == 0 ? 0 : 1;
    }

    /* renamed from: b */
    private static void m6546b(short[] sArr, C1635e eVar) {
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            m6541a(sArr[i], eVar, (C1633c) new C1634d((i + 28) * 64));
        }
    }

    /* renamed from: c */
    private void m6547c() {
        this.f5402e = this.f5398a.read();
        this.f5403f = 0;
    }

    /* renamed from: d */
    private static void m6548d() {
        m6543a(C1628a.f5390a, f5395l, true);
        m6543a(C1628a.f5391b, f5396m, false);
        m6542a(C1628a.f5392c, f5395l);
        m6542a(C1628a.f5393d, f5396m);
        m6546b(C1628a.f5394e, f5395l);
        m6546b(C1628a.f5394e, f5396m);
        C1632b bVar = new C1632b();
        m6541a(2816, f5395l, (C1633c) bVar);
        m6541a(2816, f5396m, (C1633c) bVar);
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        if (this.f5406i >= this.f5404g.mo7675c() && !m6544a()) {
            return -1;
        }
        byte[] d = this.f5404g.mo7676d();
        int i = this.f5406i;
        this.f5406i = i + 1;
        return d[i] & 255;
    }
}
