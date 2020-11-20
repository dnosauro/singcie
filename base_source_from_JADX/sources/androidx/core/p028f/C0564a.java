package androidx.core.p028f;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* renamed from: androidx.core.f.a */
public final class C0564a {

    /* renamed from: a */
    static final C0571d f2129a = C0572e.f2164c;

    /* renamed from: b */
    static final C0564a f2130b = new C0564a(false, 2, f2129a);

    /* renamed from: c */
    static final C0564a f2131c = new C0564a(true, 2, f2129a);

    /* renamed from: d */
    private static final String f2132d = Character.toString(8206);

    /* renamed from: e */
    private static final String f2133e = Character.toString(8207);

    /* renamed from: f */
    private final boolean f2134f;

    /* renamed from: g */
    private final int f2135g;

    /* renamed from: h */
    private final C0571d f2136h;

    /* renamed from: androidx.core.f.a$a */
    public static final class C0565a {

        /* renamed from: a */
        private boolean f2137a;

        /* renamed from: b */
        private int f2138b;

        /* renamed from: c */
        private C0571d f2139c;

        public C0565a() {
            m2214a(C0564a.m2207a(Locale.getDefault()));
        }

        /* renamed from: a */
        private void m2214a(boolean z) {
            this.f2137a = z;
            this.f2139c = C0564a.f2129a;
            this.f2138b = 2;
        }

        /* renamed from: b */
        private static C0564a m2215b(boolean z) {
            return z ? C0564a.f2131c : C0564a.f2130b;
        }

        /* renamed from: a */
        public C0564a mo3572a() {
            return (this.f2138b == 2 && this.f2139c == C0564a.f2129a) ? m2215b(this.f2137a) : new C0564a(this.f2137a, this.f2138b, this.f2139c);
        }
    }

    /* renamed from: androidx.core.f.a$b */
    private static class C0566b {

        /* renamed from: a */
        private static final byte[] f2140a = new byte[1792];

        /* renamed from: b */
        private final CharSequence f2141b;

        /* renamed from: c */
        private final boolean f2142c;

        /* renamed from: d */
        private final int f2143d;

        /* renamed from: e */
        private int f2144e;

        /* renamed from: f */
        private char f2145f;

        static {
            for (int i = 0; i < 1792; i++) {
                f2140a[i] = Character.getDirectionality(i);
            }
        }

        C0566b(CharSequence charSequence, boolean z) {
            this.f2141b = charSequence;
            this.f2142c = z;
            this.f2143d = charSequence.length();
        }

        /* renamed from: a */
        private static byte m2217a(char c) {
            return c < 1792 ? f2140a[c] : Character.getDirectionality(c);
        }

        /* renamed from: e */
        private byte m2218e() {
            char charAt;
            int i = this.f2144e;
            while (true) {
                int i2 = this.f2144e;
                if (i2 < this.f2143d) {
                    CharSequence charSequence = this.f2141b;
                    this.f2144e = i2 + 1;
                    this.f2145f = charSequence.charAt(i2);
                    char c = this.f2145f;
                    if (c == '>') {
                        return 12;
                    }
                    if (c == '\"' || c == '\'') {
                        char c2 = this.f2145f;
                        do {
                            int i3 = this.f2144e;
                            if (i3 >= this.f2143d) {
                                break;
                            }
                            CharSequence charSequence2 = this.f2141b;
                            this.f2144e = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.f2145f = charAt;
                        } while (charAt != c2);
                    }
                } else {
                    this.f2144e = i;
                    this.f2145f = '<';
                    return 13;
                }
            }
        }

        /* renamed from: f */
        private byte m2219f() {
            char charAt;
            int i = this.f2144e;
            while (true) {
                int i2 = this.f2144e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2141b;
                int i3 = i2 - 1;
                this.f2144e = i3;
                this.f2145f = charSequence.charAt(i3);
                char c = this.f2145f;
                if (c == '<') {
                    return 12;
                }
                if (c == '>') {
                    break;
                } else if (c == '\"' || c == '\'') {
                    char c2 = this.f2145f;
                    do {
                        int i4 = this.f2144e;
                        if (i4 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f2141b;
                        int i5 = i4 - 1;
                        this.f2144e = i5;
                        charAt = charSequence2.charAt(i5);
                        this.f2145f = charAt;
                    } while (charAt != c2);
                }
            }
            this.f2144e = i;
            this.f2145f = '>';
            return 13;
        }

        /* renamed from: g */
        private byte m2220g() {
            char charAt;
            do {
                int i = this.f2144e;
                if (i >= this.f2143d) {
                    return 12;
                }
                CharSequence charSequence = this.f2141b;
                this.f2144e = i + 1;
                charAt = charSequence.charAt(i);
                this.f2145f = charAt;
            } while (charAt != ';');
            return 12;
        }

        /* renamed from: h */
        private byte m2221h() {
            char c;
            int i = this.f2144e;
            do {
                int i2 = this.f2144e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2141b;
                int i3 = i2 - 1;
                this.f2144e = i3;
                this.f2145f = charSequence.charAt(i3);
                c = this.f2145f;
                if (c == '&') {
                    return 12;
                }
            } while (c != ';');
            this.f2144e = i;
            this.f2145f = ';';
            return 13;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo3573a() {
            this.f2144e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f2144e < this.f2143d && i == 0) {
                byte c = mo3575c();
                if (c != 9) {
                    switch (c) {
                        case 0:
                            if (i3 == 0) {
                                return -1;
                            }
                            break;
                        case 1:
                        case 2:
                            if (i3 == 0) {
                                return 1;
                            }
                            break;
                        default:
                            switch (c) {
                                case 14:
                                case 15:
                                    i3++;
                                    i2 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i3++;
                                    i2 = 1;
                                    continue;
                                case 18:
                                    i3--;
                                    i2 = 0;
                                    continue;
                                    continue;
                            }
                    }
                    i = i3;
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f2144e > 0) {
                switch (mo3576d()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
            r2 = r2 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
            r1 = r2;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo3574b() {
            /*
                r6 = this;
                int r0 = r6.f2143d
                r6.f2144e = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r6.f2144e
                if (r3 <= 0) goto L_0x0037
                byte r3 = r6.mo3576d()
                r4 = 9
                if (r3 == r4) goto L_0x0007
                r4 = 1
                r5 = -1
                switch(r3) {
                    case 0: goto L_0x0030;
                    case 1: goto L_0x002a;
                    case 2: goto L_0x002a;
                    default: goto L_0x0018;
                }
            L_0x0018:
                switch(r3) {
                    case 14: goto L_0x0024;
                    case 15: goto L_0x0024;
                    case 16: goto L_0x0021;
                    case 17: goto L_0x0021;
                    case 18: goto L_0x001e;
                    default: goto L_0x001b;
                }
            L_0x001b:
                if (r1 != 0) goto L_0x0007
                goto L_0x0035
            L_0x001e:
                int r2 = r2 + 1
                goto L_0x0007
            L_0x0021:
                if (r1 != r2) goto L_0x0027
                return r4
            L_0x0024:
                if (r1 != r2) goto L_0x0027
                return r5
            L_0x0027:
                int r2 = r2 + -1
                goto L_0x0007
            L_0x002a:
                if (r2 != 0) goto L_0x002d
                return r4
            L_0x002d:
                if (r1 != 0) goto L_0x0007
                goto L_0x0035
            L_0x0030:
                if (r2 != 0) goto L_0x0033
                return r5
            L_0x0033:
                if (r1 != 0) goto L_0x0007
            L_0x0035:
                r1 = r2
                goto L_0x0007
            L_0x0037:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p028f.C0564a.C0566b.mo3574b():int");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public byte mo3575c() {
            this.f2145f = this.f2141b.charAt(this.f2144e);
            if (Character.isHighSurrogate(this.f2145f)) {
                int codePointAt = Character.codePointAt(this.f2141b, this.f2144e);
                this.f2144e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f2144e++;
            byte a = m2217a(this.f2145f);
            if (!this.f2142c) {
                return a;
            }
            char c = this.f2145f;
            return c == '<' ? m2218e() : c == '&' ? m2220g() : a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public byte mo3576d() {
            this.f2145f = this.f2141b.charAt(this.f2144e - 1);
            if (Character.isLowSurrogate(this.f2145f)) {
                int codePointBefore = Character.codePointBefore(this.f2141b, this.f2144e);
                this.f2144e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f2144e--;
            byte a = m2217a(this.f2145f);
            if (!this.f2142c) {
                return a;
            }
            char c = this.f2145f;
            return c == '>' ? m2219f() : c == ';' ? m2221h() : a;
        }
    }

    C0564a(boolean z, int i, C0571d dVar) {
        this.f2134f = z;
        this.f2135g = i;
        this.f2136h = dVar;
    }

    /* renamed from: a */
    public static C0564a m2205a() {
        return new C0565a().mo3572a();
    }

    /* renamed from: a */
    private String m2206a(CharSequence charSequence, C0571d dVar) {
        boolean a = dVar.mo3602a(charSequence, 0, charSequence.length());
        return (this.f2134f || (!a && m2208b(charSequence) != 1)) ? this.f2134f ? (!a || m2208b(charSequence) == -1) ? f2133e : "" : "" : f2132d;
    }

    /* renamed from: a */
    static boolean m2207a(Locale locale) {
        return C0579f.m2251a(locale) == 1;
    }

    /* renamed from: b */
    private static int m2208b(CharSequence charSequence) {
        return new C0566b(charSequence, false).mo3574b();
    }

    /* renamed from: b */
    private String m2209b(CharSequence charSequence, C0571d dVar) {
        boolean a = dVar.mo3602a(charSequence, 0, charSequence.length());
        return (this.f2134f || (!a && m2210c(charSequence) != 1)) ? this.f2134f ? (!a || m2210c(charSequence) == -1) ? f2133e : "" : "" : f2132d;
    }

    /* renamed from: c */
    private static int m2210c(CharSequence charSequence) {
        return new C0566b(charSequence, false).mo3573a();
    }

    /* renamed from: a */
    public CharSequence mo3569a(CharSequence charSequence) {
        return mo3570a(charSequence, this.f2136h, true);
    }

    /* renamed from: a */
    public CharSequence mo3570a(CharSequence charSequence, C0571d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a = dVar.mo3602a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (mo3571b() && z) {
            spannableStringBuilder.append(m2209b(charSequence, a ? C0572e.f2163b : C0572e.f2162a));
        }
        if (a != this.f2134f) {
            spannableStringBuilder.append(a ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(m2206a(charSequence, a ? C0572e.f2163b : C0572e.f2162a));
        }
        return spannableStringBuilder;
    }

    /* renamed from: b */
    public boolean mo3571b() {
        return (this.f2135g & 2) != 0;
    }
}
