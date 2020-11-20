package androidx.core.p028f;

import java.util.Locale;

/* renamed from: androidx.core.f.e */
public final class C0572e {

    /* renamed from: a */
    public static final C0571d f2162a = new C0577e((C0575c) null, false);

    /* renamed from: b */
    public static final C0571d f2163b = new C0577e((C0575c) null, true);

    /* renamed from: c */
    public static final C0571d f2164c = new C0577e(C0574b.f2170a, false);

    /* renamed from: d */
    public static final C0571d f2165d = new C0577e(C0574b.f2170a, true);

    /* renamed from: e */
    public static final C0571d f2166e = new C0577e(C0573a.f2168a, false);

    /* renamed from: f */
    public static final C0571d f2167f = C0578f.f2173a;

    /* renamed from: androidx.core.f.e$a */
    private static class C0573a implements C0575c {

        /* renamed from: a */
        static final C0573a f2168a = new C0573a(true);

        /* renamed from: b */
        private final boolean f2169b;

        private C0573a(boolean z) {
            this.f2169b = z;
        }

        /* renamed from: a */
        public int mo3603a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                switch (C0572e.m2241a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.f2169b) {
                            return 0;
                        }
                        break;
                    case 1:
                        if (!this.f2169b) {
                            return 1;
                        }
                        break;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f2169b ? 1 : 0;
            }
            return 2;
        }
    }

    /* renamed from: androidx.core.f.e$b */
    private static class C0574b implements C0575c {

        /* renamed from: a */
        static final C0574b f2170a = new C0574b();

        private C0574b() {
        }

        /* renamed from: a */
        public int mo3603a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = C0572e.m2242b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* renamed from: androidx.core.f.e$c */
    private interface C0575c {
        /* renamed from: a */
        int mo3603a(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: androidx.core.f.e$d */
    private static abstract class C0576d implements C0571d {

        /* renamed from: a */
        private final C0575c f2171a;

        C0576d(C0575c cVar) {
            this.f2171a = cVar;
        }

        /* renamed from: b */
        private boolean m2246b(CharSequence charSequence, int i, int i2) {
            switch (this.f2171a.mo3603a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return mo3604a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo3604a();

        /* renamed from: a */
        public boolean mo3602a(CharSequence charSequence, int i, int i2) {
            if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                return this.f2171a == null ? mo3604a() : m2246b(charSequence, i, i2);
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: androidx.core.f.e$e */
    private static class C0577e extends C0576d {

        /* renamed from: a */
        private final boolean f2172a;

        C0577e(C0575c cVar, boolean z) {
            super(cVar);
            this.f2172a = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo3604a() {
            return this.f2172a;
        }
    }

    /* renamed from: androidx.core.f.e$f */
    private static class C0578f extends C0576d {

        /* renamed from: a */
        static final C0578f f2173a = new C0578f();

        C0578f() {
            super((C0575c) null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo3604a() {
            return C0579f.m2251a(Locale.getDefault()) == 1;
        }
    }

    /* renamed from: a */
    static int m2241a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* renamed from: b */
    static int m2242b(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                switch (i) {
                    case 14:
                    case 15:
                        return 1;
                    case 16:
                    case 17:
                        return 0;
                    default:
                        return 2;
                }
        }
    }
}
