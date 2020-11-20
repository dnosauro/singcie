package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p114g.C1867f;
import com.cyberneid.p105d.p114g.p126f.p130d.C1919t;
import java.util.List;

/* renamed from: com.cyberneid.d.g.f.d.u */
class C1924u {

    /* renamed from: a */
    private final C1901b f6079a;

    /* renamed from: b */
    private final boolean f6080b;

    /* renamed from: c */
    private final float f6081c;

    /* renamed from: d */
    private final C1867f f6082d;

    /* renamed from: e */
    private final C1919t f6083e;

    /* renamed from: f */
    private final C1927b f6084f;

    /* renamed from: g */
    private float f6085g;

    /* renamed from: h */
    private float f6086h;

    /* renamed from: com.cyberneid.d.g.f.d.u$a */
    static class C1926a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public C1867f f6088a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C1901b f6089b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f6090c = false;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public float f6091d = 0.0f;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public C1919t f6092e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public C1927b f6093f = C1927b.LEFT;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public float f6094g = 0.0f;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public float f6095h = 0.0f;

        C1926a(C1867f fVar) {
            this.f6088a = fVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1926a mo8447a(float f) {
            this.f6091d = f;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1926a mo8448a(float f, float f2) {
            this.f6094g = f;
            this.f6095h = f2;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1926a mo8449a(int i) {
            this.f6093f = C1927b.m7936a(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1926a mo8450a(C1901b bVar) {
            this.f6089b = bVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1926a mo8451a(C1919t tVar) {
            this.f6092e = tVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1926a mo8452a(boolean z) {
            this.f6090c = z;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1924u mo8453a() {
            return new C1924u(this);
        }
    }

    /* renamed from: com.cyberneid.d.g.f.d.u$b */
    enum C1927b {
        LEFT(0),
        CENTER(1),
        RIGHT(2),
        JUSTIFY(4);
        

        /* renamed from: e */
        private final int f6101e;

        private C1927b(int i) {
            this.f6101e = i;
        }

        /* renamed from: a */
        public static C1927b m7936a(int i) {
            for (C1927b bVar : values()) {
                if (bVar.mo8454a() == i) {
                    return bVar;
                }
            }
            return LEFT;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo8454a() {
            return this.f6101e;
        }
    }

    private C1924u(C1926a aVar) {
        this.f6079a = aVar.f6089b;
        this.f6080b = aVar.f6090c;
        this.f6081c = aVar.f6091d;
        this.f6082d = aVar.f6088a;
        this.f6083e = aVar.f6092e;
        this.f6084f = aVar.f6093f;
        this.f6085g = aVar.f6094g;
        this.f6086h = aVar.f6095h;
    }

    /* renamed from: a */
    private void m7919a(List<C1919t.C1920a> list) {
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (C1919t.C1920a next : list) {
            switch (this.f6084f) {
                case CENTER:
                    f2 = (this.f6081c - next.mo8435a()) / 2.0f;
                    break;
                case RIGHT:
                    f2 = this.f6081c - next.mo8435a();
                    break;
                case JUSTIFY:
                    if (list.indexOf(next) != list.size() - 1) {
                        f3 = next.mo8439b(this.f6081c);
                        break;
                    }
                    break;
                default:
                    f2 = 0.0f;
                    break;
            }
            float f4 = (-f) + f2 + this.f6085g;
            if (list.indexOf(next) == 0) {
                this.f6082d.mo8315a(f4, this.f6086h);
                this.f6086h = 0.0f;
                this.f6085g = 0.0f;
            } else {
                this.f6086h -= this.f6079a.mo8391c();
                this.f6082d.mo8315a(f4, -this.f6079a.mo8391c());
            }
            List<C1919t.C1923d> b = next.mo8440b();
            float f5 = f2;
            for (C1919t.C1923d next2 : b) {
                this.f6082d.mo8324a(next2.mo8443a());
                float floatValue = ((Float) next2.mo8445b().getIterator().getAttribute(C1919t.C1922c.f6076a)).floatValue();
                if (b.indexOf(next2) != b.size() - 1) {
                    this.f6082d.mo8315a(floatValue + f3, 0.0f);
                    f5 = f5 + floatValue + f3;
                }
            }
            f = f5;
        }
        this.f6085g -= f;
    }

    /* renamed from: a */
    public void mo8446a() {
        C1919t tVar = this.f6083e;
        if (tVar != null && !tVar.mo8434a().isEmpty()) {
            for (C1919t.C1921b next : this.f6083e.mo8434a()) {
                if (this.f6080b) {
                    m7919a(next.mo8442a(this.f6079a.mo8386a(), this.f6079a.mo8389b(), this.f6081c));
                } else {
                    float b = (this.f6079a.mo8386a().mo8162b(next.mo8441a()) * this.f6079a.mo8389b()) / 1000.0f;
                    float f = 0.0f;
                    if (b < this.f6081c) {
                        switch (this.f6084f) {
                            case CENTER:
                                f = (this.f6081c - b) / 2.0f;
                                break;
                            case RIGHT:
                                f = this.f6081c - b;
                                break;
                        }
                    }
                    this.f6082d.mo8315a(this.f6085g + f, this.f6086h);
                    this.f6082d.mo8324a(next.mo8441a());
                }
            }
        }
    }
}
