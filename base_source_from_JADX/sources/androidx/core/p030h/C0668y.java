package androidx.core.p030h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: androidx.core.h.y */
public final class C0668y {

    /* renamed from: a */
    Runnable f2332a = null;

    /* renamed from: b */
    Runnable f2333b = null;

    /* renamed from: c */
    int f2334c = -1;

    /* renamed from: d */
    private WeakReference<View> f2335d;

    /* renamed from: androidx.core.h.y$a */
    static class C0671a implements C0672z {

        /* renamed from: a */
        C0668y f2342a;

        /* renamed from: b */
        boolean f2343b;

        C0671a(C0668y yVar) {
            this.f2342a = yVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.h.z} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo912a(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f2343b = r0
                androidx.core.h.y r0 = r3.f2342a
                int r0 = r0.f2334c
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.h.y r0 = r3.f2342a
                java.lang.Runnable r0 = r0.f2332a
                if (r0 == 0) goto L_0x0020
                androidx.core.h.y r0 = r3.f2342a
                java.lang.Runnable r0 = r0.f2332a
                androidx.core.h.y r2 = r3.f2342a
                r2.f2332a = r1
                r0.run()
            L_0x0020:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.p030h.C0672z
                if (r2 == 0) goto L_0x002d
                r1 = r0
                androidx.core.h.z r1 = (androidx.core.p030h.C0672z) r1
            L_0x002d:
                if (r1 == 0) goto L_0x0032
                r1.mo912a(r4)
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p030h.C0668y.C0671a.mo912a(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.h.z} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo913b(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.h.y r0 = r3.f2342a
                int r0 = r0.f2334c
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x0013
                androidx.core.h.y r0 = r3.f2342a
                int r0 = r0.f2334c
                r4.setLayerType(r0, r2)
                androidx.core.h.y r0 = r3.f2342a
                r0.f2334c = r1
            L_0x0013:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x001d
                boolean r0 = r3.f2343b
                if (r0 != 0) goto L_0x0043
            L_0x001d:
                androidx.core.h.y r0 = r3.f2342a
                java.lang.Runnable r0 = r0.f2333b
                if (r0 == 0) goto L_0x002e
                androidx.core.h.y r0 = r3.f2342a
                java.lang.Runnable r0 = r0.f2333b
                androidx.core.h.y r1 = r3.f2342a
                r1.f2333b = r2
                r0.run()
            L_0x002e:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.p030h.C0672z
                if (r1 == 0) goto L_0x003b
                r2 = r0
                androidx.core.h.z r2 = (androidx.core.p030h.C0672z) r2
            L_0x003b:
                if (r2 == 0) goto L_0x0040
                r2.mo913b(r4)
            L_0x0040:
                r4 = 1
                r3.f2343b = r4
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p030h.C0668y.C0671a.mo913b(android.view.View):void");
        }

        /* renamed from: c */
        public void mo2043c(View view) {
            Object tag = view.getTag(2113929216);
            C0672z zVar = tag instanceof C0672z ? (C0672z) tag : null;
            if (zVar != null) {
                zVar.mo2043c(view);
            }
        }
    }

    C0668y(View view) {
        this.f2335d = new WeakReference<>(view);
    }

    /* renamed from: a */
    private void m2694a(final View view, final C0672z zVar) {
        if (zVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    zVar.mo2043c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    zVar.mo913b(view);
                }

                public void onAnimationStart(Animator animator) {
                    zVar.mo912a(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    /* renamed from: a */
    public long mo3844a() {
        View view = (View) this.f2335d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    /* renamed from: a */
    public C0668y mo3845a(float f) {
        View view = (View) this.f2335d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* renamed from: a */
    public C0668y mo3846a(long j) {
        View view = (View) this.f2335d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* renamed from: a */
    public C0668y mo3847a(Interpolator interpolator) {
        View view = (View) this.f2335d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: a */
    public C0668y mo3848a(final C0632ab abVar) {
        final View view = (View) this.f2335d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            C06702 r1 = null;
            if (abVar != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        abVar.mo981a(view);
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }

    /* renamed from: a */
    public C0668y mo3849a(C0672z zVar) {
        View view = (View) this.f2335d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, zVar);
                zVar = new C0671a(this);
            }
            m2694a(view, zVar);
        }
        return this;
    }

    /* renamed from: b */
    public C0668y mo3850b(float f) {
        View view = (View) this.f2335d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    /* renamed from: b */
    public C0668y mo3851b(long j) {
        View view = (View) this.f2335d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* renamed from: b */
    public void mo3852b() {
        View view = (View) this.f2335d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: c */
    public void mo3853c() {
        View view = (View) this.f2335d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
