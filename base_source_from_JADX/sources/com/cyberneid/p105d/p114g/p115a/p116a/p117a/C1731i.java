package com.cyberneid.p105d.p114g.p115a.p116a.p117a;

/* renamed from: com.cyberneid.d.g.a.a.a.i */
public final class C1731i {

    /* renamed from: com.cyberneid.d.g.a.a.a.i$a */
    public static abstract class C1733a implements C1735c {
        /* renamed from: c */
        public void mo7910c(CharSequence charSequence) {
        }

        /* renamed from: d */
        public void mo7911d(CharSequence charSequence) {
        }

        /* renamed from: e */
        public void mo7912e(CharSequence charSequence) {
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.i$b */
    private enum C1734b {
        NEWLINE,
        WHITESPACE,
        COMMENT,
        TOKEN
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.i$c */
    public interface C1735c {
        /* renamed from: b */
        void mo7908b(CharSequence charSequence);

        /* renamed from: c */
        void mo7910c(CharSequence charSequence);

        /* renamed from: d */
        void mo7911d(CharSequence charSequence);

        /* renamed from: e */
        void mo7912e(CharSequence charSequence);
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.i$d */
    private static final class C1736d {

        /* renamed from: a */
        static final /* synthetic */ boolean f5705a = (!C1731i.class.desiredAssertionStatus());

        /* renamed from: b */
        private final CharSequence f5706b;

        /* renamed from: c */
        private int f5707c;

        /* renamed from: d */
        private final C1735c f5708d;

        /* renamed from: e */
        private C1734b f5709e;

        /* renamed from: f */
        private final StringBuilder f5710f;

        private C1736d(CharSequence charSequence, C1735c cVar) {
            this.f5709e = C1734b.WHITESPACE;
            this.f5710f = new StringBuilder();
            this.f5706b = charSequence;
            this.f5708d = cVar;
        }

        /* renamed from: a */
        private boolean m6988a() {
            return this.f5707c < this.f5706b.length();
        }

        /* renamed from: b */
        private char m6989b() {
            return this.f5706b.charAt(this.f5707c);
        }

        /* renamed from: c */
        private char m6990c() {
            this.f5707c++;
            if (!m6988a()) {
                return 4;
            }
            return m6989b();
        }

        /* renamed from: d */
        private char m6991d() {
            if (this.f5707c < this.f5706b.length() - 1) {
                return this.f5706b.charAt(this.f5707c + 1);
            }
            return 4;
        }

        /* renamed from: e */
        private C1734b m6992e() {
            C1734b bVar;
            char b = m6989b();
            if (!(b == 0 || b == ' ')) {
                if (b != '%') {
                    switch (b) {
                        case 9:
                            break;
                        case 10:
                            bVar = C1734b.NEWLINE;
                            break;
                        default:
                            switch (b) {
                                case 12:
                                case 13:
                                    break;
                                default:
                                    bVar = C1734b.TOKEN;
                                    break;
                            }
                            bVar = C1734b.NEWLINE;
                            break;
                    }
                } else {
                    bVar = C1734b.COMMENT;
                }
                this.f5709e = bVar;
                return this.f5709e;
            }
            bVar = C1734b.WHITESPACE;
            this.f5709e = bVar;
            return this.f5709e;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public void m6993f() {
            while (m6988a()) {
                this.f5710f.setLength(0);
                m6992e();
                switch (this.f5709e) {
                    case NEWLINE:
                        m6994g();
                        break;
                    case WHITESPACE:
                        m6995h();
                        break;
                    case COMMENT:
                        m6996i();
                        break;
                    default:
                        m6997j();
                        break;
                }
            }
        }

        /* renamed from: g */
        private void m6994g() {
            if (f5705a || this.f5709e == C1734b.NEWLINE) {
                char b = m6989b();
                this.f5710f.append(b);
                if (b == 13 && m6991d() == 10) {
                    this.f5710f.append(m6990c());
                }
                this.f5708d.mo7911d(this.f5710f);
                m6990c();
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: h */
        private void m6995h() {
            char c;
            if (f5705a || this.f5709e == C1734b.WHITESPACE) {
                this.f5710f.append(m6989b());
                while (m6988a() && ((c = m6990c()) == 0 || c == 9 || c == ' ')) {
                    this.f5710f.append(c);
                }
                this.f5708d.mo7912e(this.f5710f);
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: i */
        private void m6996i() {
            if (f5705a || this.f5709e == C1734b.COMMENT) {
                this.f5710f.append(m6989b());
                while (m6988a()) {
                    char c = m6990c();
                    switch (c) {
                        case 10:
                        case 12:
                        case 13:
                            break;
                        default:
                            this.f5710f.append(c);
                    }
                    this.f5708d.mo7910c(this.f5710f);
                    return;
                }
                this.f5708d.mo7910c(this.f5710f);
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: j */
        private void m6997j() {
            char c;
            if (f5705a || this.f5709e == C1734b.TOKEN) {
                char b = m6989b();
                this.f5710f.append(b);
                if (b == '{' || b == '}') {
                    this.f5708d.mo7908b(this.f5710f);
                    m6990c();
                    return;
                }
                while (m6988a() && (c = m6990c()) != 0 && c != 4 && c != ' ' && c != '{' && c != '}') {
                    switch (c) {
                        case 9:
                        case 10:
                            break;
                        default:
                            switch (c) {
                                case 12:
                                case 13:
                                    break;
                                default:
                                    this.f5710f.append(c);
                            }
                    }
                }
                this.f5708d.mo7908b(this.f5710f);
                return;
            }
            throw new AssertionError();
        }
    }

    private C1731i() {
    }

    /* renamed from: a */
    public static void m6979a(CharSequence charSequence, C1735c cVar) {
        new C1736d(charSequence, cVar).m6993f();
    }
}
