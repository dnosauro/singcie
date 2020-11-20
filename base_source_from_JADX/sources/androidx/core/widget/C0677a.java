package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.p030h.C0656u;

/* renamed from: androidx.core.widget.a */
public abstract class C0677a implements View.OnTouchListener {

    /* renamed from: r */
    private static final int f2373r = ViewConfiguration.getTapTimeout();

    /* renamed from: a */
    final C0678a f2374a = new C0678a();

    /* renamed from: b */
    final View f2375b;

    /* renamed from: c */
    boolean f2376c;

    /* renamed from: d */
    boolean f2377d;

    /* renamed from: e */
    boolean f2378e;

    /* renamed from: f */
    private final Interpolator f2379f = new AccelerateInterpolator();

    /* renamed from: g */
    private Runnable f2380g;

    /* renamed from: h */
    private float[] f2381h = {0.0f, 0.0f};

    /* renamed from: i */
    private float[] f2382i = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: j */
    private int f2383j;

    /* renamed from: k */
    private int f2384k;

    /* renamed from: l */
    private float[] f2385l = {0.0f, 0.0f};

    /* renamed from: m */
    private float[] f2386m = {0.0f, 0.0f};

    /* renamed from: n */
    private float[] f2387n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: o */
    private boolean f2388o;

    /* renamed from: p */
    private boolean f2389p;

    /* renamed from: q */
    private boolean f2390q;

    /* renamed from: androidx.core.widget.a$a */
    private static class C0678a {

        /* renamed from: a */
        private int f2391a;

        /* renamed from: b */
        private int f2392b;

        /* renamed from: c */
        private float f2393c;

        /* renamed from: d */
        private float f2394d;

        /* renamed from: e */
        private long f2395e = Long.MIN_VALUE;

        /* renamed from: f */
        private long f2396f = 0;

        /* renamed from: g */
        private int f2397g = 0;

        /* renamed from: h */
        private int f2398h = 0;

        /* renamed from: i */
        private long f2399i = -1;

        /* renamed from: j */
        private float f2400j;

        /* renamed from: k */
        private int f2401k;

        C0678a() {
        }

        /* renamed from: a */
        private float m2772a(float f) {
            return (-4.0f * f * f) + (f * 4.0f);
        }

        /* renamed from: a */
        private float m2773a(long j) {
            if (j < this.f2395e) {
                return 0.0f;
            }
            long j2 = this.f2399i;
            if (j2 < 0 || j < j2) {
                return C0677a.m2750a(((float) (j - this.f2395e)) / ((float) this.f2391a), 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f = this.f2400j;
            return (1.0f - f) + (f * C0677a.m2750a(((float) j3) / ((float) this.f2401k), 0.0f, 1.0f));
        }

        /* renamed from: a */
        public void mo3942a() {
            this.f2395e = AnimationUtils.currentAnimationTimeMillis();
            this.f2399i = -1;
            this.f2396f = this.f2395e;
            this.f2400j = 0.5f;
            this.f2397g = 0;
            this.f2398h = 0;
        }

        /* renamed from: a */
        public void mo3943a(float f, float f2) {
            this.f2393c = f;
            this.f2394d = f2;
        }

        /* renamed from: a */
        public void mo3944a(int i) {
            this.f2391a = i;
        }

        /* renamed from: b */
        public void mo3945b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2401k = C0677a.m2753a((int) (currentAnimationTimeMillis - this.f2395e), 0, this.f2392b);
            this.f2400j = m2773a(currentAnimationTimeMillis);
            this.f2399i = currentAnimationTimeMillis;
        }

        /* renamed from: b */
        public void mo3946b(int i) {
            this.f2392b = i;
        }

        /* renamed from: c */
        public boolean mo3947c() {
            return this.f2399i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2399i + ((long) this.f2401k);
        }

        /* renamed from: d */
        public void mo3948d() {
            if (this.f2396f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a = m2772a(m2773a(currentAnimationTimeMillis));
                this.f2396f = currentAnimationTimeMillis;
                float f = ((float) (currentAnimationTimeMillis - this.f2396f)) * a;
                this.f2397g = (int) (this.f2393c * f);
                this.f2398h = (int) (f * this.f2394d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        /* renamed from: e */
        public int mo3949e() {
            float f = this.f2393c;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: f */
        public int mo3950f() {
            float f = this.f2394d;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: g */
        public int mo3951g() {
            return this.f2397g;
        }

        /* renamed from: h */
        public int mo3952h() {
            return this.f2398h;
        }
    }

    /* renamed from: androidx.core.widget.a$b */
    private class C0679b implements Runnable {
        C0679b() {
        }

        public void run() {
            if (C0677a.this.f2378e) {
                if (C0677a.this.f2376c) {
                    C0677a aVar = C0677a.this;
                    aVar.f2376c = false;
                    aVar.f2374a.mo3942a();
                }
                C0678a aVar2 = C0677a.this.f2374a;
                if (aVar2.mo3947c() || !C0677a.this.mo3930a()) {
                    C0677a.this.f2378e = false;
                    return;
                }
                if (C0677a.this.f2377d) {
                    C0677a aVar3 = C0677a.this;
                    aVar3.f2377d = false;
                    aVar3.mo3933b();
                }
                aVar2.mo3948d();
                C0677a.this.mo3929a(aVar2.mo3951g(), aVar2.mo3952h());
                C0656u.m2597a(C0677a.this.f2375b, (Runnable) this);
            }
        }
    }

    public C0677a(View view) {
        this.f2375b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float f = (float) ((int) ((displayMetrics.density * 1575.0f) + 0.5f));
        mo3926a(f, f);
        float f2 = (float) ((int) ((displayMetrics.density * 315.0f) + 0.5f));
        mo3931b(f2, f2);
        mo3927a(1);
        mo3938e(Float.MAX_VALUE, Float.MAX_VALUE);
        mo3936d(0.2f, 0.2f);
        mo3934c(1.0f, 1.0f);
        mo3932b(f2373r);
        mo3935c(500);
        mo3937d(500);
    }

    /* renamed from: a */
    static float m2750a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* renamed from: a */
    private float m2751a(float f, float f2, float f3, float f4) {
        float f5;
        float a = m2750a(f * f2, 0.0f, f3);
        float f6 = m2756f(f2 - f4, a) - m2756f(f4, a);
        if (f6 < 0.0f) {
            f5 = -this.f2379f.getInterpolation(-f6);
        } else if (f6 <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f2379f.getInterpolation(f6);
        }
        return m2750a(f5, -1.0f, 1.0f);
    }

    /* renamed from: a */
    private float m2752a(int i, float f, float f2, float f3) {
        float a = m2751a(this.f2381h[i], f2, this.f2382i[i], f);
        int i2 = (a > 0.0f ? 1 : (a == 0.0f ? 0 : -1));
        if (i2 == 0) {
            return 0.0f;
        }
        float f4 = this.f2385l[i];
        float f5 = this.f2386m[i];
        float f6 = this.f2387n[i];
        float f7 = f4 * f3;
        return i2 > 0 ? m2750a(a * f7, f5, f6) : -m2750a((-a) * f7, f5, f6);
    }

    /* renamed from: a */
    static int m2753a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: c */
    private void m2754c() {
        int i;
        if (this.f2380g == null) {
            this.f2380g = new C0679b();
        }
        this.f2378e = true;
        this.f2376c = true;
        if (this.f2388o || (i = this.f2384k) <= 0) {
            this.f2380g.run();
        } else {
            C0656u.m2598a(this.f2375b, this.f2380g, (long) i);
        }
        this.f2388o = true;
    }

    /* renamed from: d */
    private void m2755d() {
        if (this.f2376c) {
            this.f2378e = false;
        } else {
            this.f2374a.mo3945b();
        }
    }

    /* renamed from: f */
    private float m2756f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.f2383j;
        switch (i) {
            case 0:
            case 1:
                if (f < f2) {
                    return f >= 0.0f ? 1.0f - (f / f2) : (!this.f2378e || i != 1) ? 0.0f : 1.0f;
                }
                break;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                break;
        }
    }

    /* renamed from: a */
    public C0677a mo3926a(float f, float f2) {
        float[] fArr = this.f2387n;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: a */
    public C0677a mo3927a(int i) {
        this.f2383j = i;
        return this;
    }

    /* renamed from: a */
    public C0677a mo3928a(boolean z) {
        if (this.f2389p && !z) {
            m2755d();
        }
        this.f2389p = z;
        return this;
    }

    /* renamed from: a */
    public abstract void mo3929a(int i, int i2);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3930a() {
        C0678a aVar = this.f2374a;
        int f = aVar.mo3950f();
        int e = aVar.mo3949e();
        return (f != 0 && mo3940f(f)) || (e != 0 && mo3939e(e));
    }

    /* renamed from: b */
    public C0677a mo3931b(float f, float f2) {
        float[] fArr = this.f2386m;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: b */
    public C0677a mo3932b(int i) {
        this.f2384k = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3933b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2375b.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: c */
    public C0677a mo3934c(float f, float f2) {
        float[] fArr = this.f2385l;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: c */
    public C0677a mo3935c(int i) {
        this.f2374a.mo3944a(i);
        return this;
    }

    /* renamed from: d */
    public C0677a mo3936d(float f, float f2) {
        float[] fArr = this.f2381h;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: d */
    public C0677a mo3937d(int i) {
        this.f2374a.mo3946b(i);
        return this;
    }

    /* renamed from: e */
    public C0677a mo3938e(float f, float f2) {
        float[] fArr = this.f2382i;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: e */
    public abstract boolean mo3939e(int i);

    /* renamed from: f */
    public abstract boolean mo3940f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f2389p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f2377d = true;
                this.f2388o = false;
                break;
            case 1:
            case 3:
                m2755d();
                break;
            case 2:
                break;
        }
        this.f2374a.mo3943a(m2752a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f2375b.getWidth()), m2752a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f2375b.getHeight()));
        if (!this.f2378e && mo3930a()) {
            m2754c();
        }
        return this.f2390q && this.f2378e;
    }
}
