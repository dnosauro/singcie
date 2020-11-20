package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.C0059a;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.core.widget.C0683e;

/* renamed from: androidx.appcompat.widget.o */
public class C0342o {

    /* renamed from: a */
    private final ImageView f1221a;

    /* renamed from: b */
    private C0300aw f1222b;

    /* renamed from: c */
    private C0300aw f1223c;

    /* renamed from: d */
    private C0300aw f1224d;

    public C0342o(ImageView imageView) {
        this.f1221a = imageView;
    }

    /* renamed from: a */
    private boolean m1262a(Drawable drawable) {
        if (this.f1224d == null) {
            this.f1224d = new C0300aw();
        }
        C0300aw awVar = this.f1224d;
        awVar.mo2405a();
        ColorStateList a = C0683e.m2790a(this.f1221a);
        if (a != null) {
            awVar.f1091d = true;
            awVar.f1088a = a;
        }
        PorterDuff.Mode b = C0683e.m2793b(this.f1221a);
        if (b != null) {
            awVar.f1090c = true;
            awVar.f1089b = b;
        }
        if (!awVar.f1091d && !awVar.f1090c) {
            return false;
        }
        C0337k.m1242a(drawable, awVar, this.f1221a.getDrawableState());
        return true;
    }

    /* renamed from: e */
    private boolean m1263e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1222b != null : i == 21;
    }

    /* renamed from: a */
    public void mo2575a(int i) {
        if (i != 0) {
            Drawable b = C0070a.m63b(this.f1221a.getContext(), i);
            if (b != null) {
                C0257af.m916b(b);
            }
            this.f1221a.setImageDrawable(b);
        } else {
            this.f1221a.setImageDrawable((Drawable) null);
        }
        mo2582d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2576a(ColorStateList colorStateList) {
        if (this.f1223c == null) {
            this.f1223c = new C0300aw();
        }
        C0300aw awVar = this.f1223c;
        awVar.f1088a = colorStateList;
        awVar.f1091d = true;
        mo2582d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2577a(PorterDuff.Mode mode) {
        if (this.f1223c == null) {
            this.f1223c = new C0300aw();
        }
        C0300aw awVar = this.f1223c;
        awVar.f1089b = mode;
        awVar.f1090c = true;
        mo2582d();
    }

    /* renamed from: a */
    public void mo2578a(AttributeSet attributeSet, int i) {
        int g;
        C0302ay a = C0302ay.m1078a(this.f1221a.getContext(), attributeSet, C0059a.C0069j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f1221a.getDrawable();
            if (!(drawable != null || (g = a.mo2423g(C0059a.C0069j.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = C0070a.m63b(this.f1221a.getContext(), g)) == null)) {
                this.f1221a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                C0257af.m916b(drawable);
            }
            if (a.mo2424g(C0059a.C0069j.AppCompatImageView_tint)) {
                C0683e.m2791a(this.f1221a, a.mo2420e(C0059a.C0069j.AppCompatImageView_tint));
            }
            if (a.mo2424g(C0059a.C0069j.AppCompatImageView_tintMode)) {
                C0683e.m2792a(this.f1221a, C0257af.m914a(a.mo2407a(C0059a.C0069j.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a.mo2410a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2579a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1221a.getBackground() instanceof RippleDrawable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ColorStateList mo2580b() {
        C0300aw awVar = this.f1223c;
        if (awVar != null) {
            return awVar.f1088a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public PorterDuff.Mode mo2581c() {
        C0300aw awVar = this.f1223c;
        if (awVar != null) {
            return awVar.f1089b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo2582d() {
        Drawable drawable = this.f1221a.getDrawable();
        if (drawable != null) {
            C0257af.m916b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!m1263e() || !m1262a(drawable)) {
            C0300aw awVar = this.f1223c;
            if (awVar != null || (awVar = this.f1222b) != null) {
                C0337k.m1242a(drawable, awVar, this.f1221a.getDrawableState());
            }
        }
    }
}
