package androidx.constraintlayout.p019a;

/* renamed from: androidx.constraintlayout.a.g */
final class C0447g {

    /* renamed from: androidx.constraintlayout.a.g$a */
    interface C0448a<T> {
        /* renamed from: a */
        T mo3200a();

        /* renamed from: a */
        void mo3201a(T[] tArr, int i);

        /* renamed from: a */
        boolean mo3202a(T t);
    }

    /* renamed from: androidx.constraintlayout.a.g$b */
    static class C0449b<T> implements C0448a<T> {

        /* renamed from: a */
        private final Object[] f1678a;

        /* renamed from: b */
        private int f1679b;

        C0449b(int i) {
            if (i > 0) {
                this.f1678a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        /* renamed from: a */
        public T mo3200a() {
            int i = this.f1679b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f1678a;
            T t = tArr[i2];
            tArr[i2] = null;
            this.f1679b = i - 1;
            return t;
        }

        /* renamed from: a */
        public void mo3201a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.f1679b;
                Object[] objArr = this.f1678a;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.f1679b = i3 + 1;
                }
            }
        }

        /* renamed from: a */
        public boolean mo3202a(T t) {
            int i = this.f1679b;
            Object[] objArr = this.f1678a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.f1679b = i + 1;
            return true;
        }
    }
}
