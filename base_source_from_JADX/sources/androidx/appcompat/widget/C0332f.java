package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.core.p030h.C0656u;

/* renamed from: androidx.appcompat.widget.f */
class C0332f {

    /* renamed from: a */
    private final View f1198a;

    /* renamed from: b */
    private final C0337k f1199b;

    /* renamed from: c */
    private int f1200c = -1;

    /* renamed from: d */
    private C0300aw f1201d;

    /* renamed from: e */
    private C0300aw f1202e;

    /* renamed from: f */
    private C0300aw f1203f;

    C0332f(View view) {
        this.f1198a = view;
        this.f1199b = C0337k.m1243b();
    }

    /* renamed from: b */
    private boolean m1221b(Drawable drawable) {
        if (this.f1203f == null) {
            this.f1203f = new C0300aw();
        }
        C0300aw awVar = this.f1203f;
        awVar.mo2405a();
        ColorStateList u = C0656u.m2638u(this.f1198a);
        if (u != null) {
            awVar.f1091d = true;
            awVar.f1088a = u;
        }
        PorterDuff.Mode v = C0656u.m2639v(this.f1198a);
        if (v != null) {
            awVar.f1090c = true;
            awVar.f1089b = v;
        }
        if (!awVar.f1091d && !awVar.f1090c) {
            return false;
        }
        C0337k.m1242a(drawable, awVar, this.f1198a.getDrawableState());
        return true;
    }

    /* renamed from: d */
    private boolean m1222d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1201d != null : i == 21;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ColorStateList mo2499a() {
        C0300aw awVar = this.f1202e;
        if (awVar != null) {
            return awVar.f1088a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2500a(int i) {
        this.f1200c = i;
        C0337k kVar = this.f1199b;
        mo2506b(kVar != null ? kVar.mo2553b(this.f1198a.getContext(), i) : null);
        mo2507c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2501a(ColorStateList colorStateList) {
        if (this.f1202e == null) {
            this.f1202e = new C0300aw();
        }
        C0300aw awVar = this.f1202e;
        awVar.f1088a = colorStateList;
        awVar.f1091d = true;
        mo2507c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2502a(PorterDuff.Mode mode) {
        if (this.f1202e == null) {
            this.f1202e = new C0300aw();
        }
        C0300aw awVar = this.f1202e;
        awVar.f1089b = mode;
        awVar.f1090c = true;
        mo2507c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2503a(Drawable drawable) {
        this.f1200c = -1;
        mo2506b((ColorStateList) null);
        mo2507c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2504a(AttributeSet attributeSet, int i) {
        C0302ay a = C0302ay.m1078a(this.f1198a.getContext(), attributeSet, C0059a.C0069j.ViewBackgroundHelper, i, 0);
        try {
            if (a.mo2424g(C0059a.C0069j.ViewBackgroundHelper_android_background)) {
                this.f1200c = a.mo2423g(C0059a.C0069j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.f1199b.mo2553b(this.f1198a.getContext(), this.f1200c);
                if (b != null) {
                    mo2506b(b);
                }
            }
            if (a.mo2424g(C0059a.C0069j.ViewBackgroundHelper_backgroundTint)) {
                C0656u.m2587a(this.f1198a, a.mo2420e(C0059a.C0069j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.mo2424g(C0059a.C0069j.ViewBackgroundHelper_backgroundTintMode)) {
                C0656u.m2588a(this.f1198a, C0257af.m914a(a.mo2407a(C0059a.C0069j.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a.mo2410a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PorterDuff.Mode mo2505b() {
        C0300aw awVar = this.f1202e;
        if (awVar != null) {
            return awVar.f1089b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2506b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1201d == null) {
                this.f1201d = new C0300aw();
            }
            C0300aw awVar = this.f1201d;
            awVar.f1088a = colorStateList;
            awVar.f1091d = true;
        } else {
            this.f1201d = null;
        }
        mo2507c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2507c() {
        Drawable background = this.f1198a.getBackground();
        if (background == null) {
            return;
        }
        if (!m1222d() || !m1221b(background)) {
            C0300aw awVar = this.f1202e;
            if (awVar != null || (awVar = this.f1201d) != null) {
                C0337k.m1242a(background, awVar, this.f1198a.getDrawableState());
            }
        }
    }
}
