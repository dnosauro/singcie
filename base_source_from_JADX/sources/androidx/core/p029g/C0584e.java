package androidx.core.p029g;

/* renamed from: androidx.core.g.e */
public final class C0584e {

    /* renamed from: androidx.core.g.e$a */
    public interface C0585a<T> {
        /* renamed from: a */
        T mo3611a();

        /* renamed from: a */
        boolean mo3612a(T t);
    }

    /* renamed from: androidx.core.g.e$b */
    public static class C0586b<T> implements C0585a<T> {

        /* renamed from: a */
        private final Object[] f2179a;

        /* renamed from: b */
        private int f2180b;

        public C0586b(int i) {
            if (i > 0) {
                this.f2179a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        /* renamed from: b */
        private boolean m2260b(T t) {
            for (int i = 0; i < this.f2180b; i++) {
                if (this.f2179a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public T mo3611a() {
            int i = this.f2180b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f2179a;
            T t = tArr[i2];
            tArr[i2] = null;
            this.f2180b = i - 1;
            return t;
        }

        /* renamed from: a */
        public boolean mo3612a(T t) {
            if (!m2260b(t)) {
                int i = this.f2180b;
                Object[] objArr = this.f2179a;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.f2180b = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* renamed from: androidx.core.g.e$c */
    public static class C0587c<T> extends C0586b<T> {

        /* renamed from: a */
        private final Object f2181a = new Object();

        public C0587c(int i) {
            super(i);
        }

        /* renamed from: a */
        public T mo3611a() {
            T a;
            synchronized (this.f2181a) {
                a = super.mo3611a();
            }
            return a;
        }

        /* renamed from: a */
        public boolean mo3612a(T t) {
            boolean a;
            synchronized (this.f2181a) {
                a = super.mo3612a(t);
            }
            return a;
        }
    }
}
