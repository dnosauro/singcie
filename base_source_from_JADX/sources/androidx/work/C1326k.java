package androidx.work;

import android.annotation.SuppressLint;

/* renamed from: androidx.work.k */
public interface C1326k {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a */
    public static final C1328a.C1331c f4106a = new C1328a.C1331c();
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: b */
    public static final C1328a.C1330b f4107b = new C1328a.C1330b();

    /* renamed from: androidx.work.k$a */
    public static abstract class C1328a {

        /* renamed from: androidx.work.k$a$a */
        public static final class C1329a extends C1328a {

            /* renamed from: a */
            private final Throwable f4108a;

            public C1329a(Throwable th) {
                this.f4108a = th;
            }

            /* renamed from: a */
            public Throwable mo6672a() {
                return this.f4108a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.f4108a.getMessage()});
            }
        }

        /* renamed from: androidx.work.k$a$b */
        public static final class C1330b extends C1328a {
            private C1330b() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        /* renamed from: androidx.work.k$a$c */
        public static final class C1331c extends C1328a {
            private C1331c() {
            }

            public String toString() {
                return "SUCCESS";
            }
        }

        C1328a() {
        }
    }
}
