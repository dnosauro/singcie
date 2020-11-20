package androidx.core.p030h;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: androidx.core.h.r */
public final class C0653r implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    private final View f2306a;

    /* renamed from: b */
    private ViewTreeObserver f2307b;

    /* renamed from: c */
    private final Runnable f2308c;

    private C0653r(View view, Runnable runnable) {
        this.f2306a = view;
        this.f2307b = view.getViewTreeObserver();
        this.f2308c = runnable;
    }

    /* renamed from: a */
    public static C0653r m2564a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            C0653r rVar = new C0653r(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(rVar);
            view.addOnAttachStateChangeListener(rVar);
            return rVar;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    /* renamed from: a */
    public void mo3817a() {
        (this.f2307b.isAlive() ? this.f2307b : this.f2306a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f2306a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        mo3817a();
        this.f2308c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f2307b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        mo3817a();
    }
}
