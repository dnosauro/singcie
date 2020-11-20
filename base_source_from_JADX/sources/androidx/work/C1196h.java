package androidx.work;

import android.util.Log;

/* renamed from: androidx.work.h */
public abstract class C1196h {

    /* renamed from: a */
    private static C1196h f3761a = null;

    /* renamed from: b */
    private static final int f3762b = 20;

    /* renamed from: androidx.work.h$a */
    public static class C1197a extends C1196h {

        /* renamed from: a */
        private int f3763a;

        public C1197a(int i) {
            super(i);
            this.f3763a = i;
        }

        /* renamed from: a */
        public void mo6417a(String str, String str2, Throwable... thArr) {
            if (this.f3763a > 2) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, thArr[0]);
            }
        }

        /* renamed from: b */
        public void mo6418b(String str, String str2, Throwable... thArr) {
            if (this.f3763a > 3) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, thArr[0]);
            }
        }

        /* renamed from: c */
        public void mo6419c(String str, String str2, Throwable... thArr) {
            if (this.f3763a > 4) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, thArr[0]);
            }
        }

        /* renamed from: d */
        public void mo6420d(String str, String str2, Throwable... thArr) {
            if (this.f3763a > 5) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, thArr[0]);
            }
        }

        /* renamed from: e */
        public void mo6421e(String str, String str2, Throwable... thArr) {
            if (this.f3763a > 6) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, thArr[0]);
            }
        }
    }

    public C1196h(int i) {
    }

    /* renamed from: a */
    public static synchronized C1196h m4736a() {
        C1196h hVar;
        synchronized (C1196h.class) {
            if (f3761a == null) {
                f3761a = new C1197a(3);
            }
            hVar = f3761a;
        }
        return hVar;
    }

    /* renamed from: a */
    public static String m4737a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i = f3762b;
        if (length >= i) {
            str = str.substring(0, i);
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static synchronized void m4738a(C1196h hVar) {
        synchronized (C1196h.class) {
            f3761a = hVar;
        }
    }

    /* renamed from: a */
    public abstract void mo6417a(String str, String str2, Throwable... thArr);

    /* renamed from: b */
    public abstract void mo6418b(String str, String str2, Throwable... thArr);

    /* renamed from: c */
    public abstract void mo6419c(String str, String str2, Throwable... thArr);

    /* renamed from: d */
    public abstract void mo6420d(String str, String str2, Throwable... thArr);

    /* renamed from: e */
    public abstract void mo6421e(String str, String str2, Throwable... thArr);
}
