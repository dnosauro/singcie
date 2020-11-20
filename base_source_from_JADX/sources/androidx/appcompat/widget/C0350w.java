package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.C0059a;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p030h.C0656u;

/* renamed from: androidx.appcompat.widget.w */
class C0350w extends C0346s {

    /* renamed from: a */
    private final SeekBar f1237a;

    /* renamed from: b */
    private Drawable f1238b;

    /* renamed from: c */
    private ColorStateList f1239c = null;

    /* renamed from: d */
    private PorterDuff.Mode f1240d = null;

    /* renamed from: e */
    private boolean f1241e = false;

    /* renamed from: f */
    private boolean f1242f = false;

    C0350w(SeekBar seekBar) {
        super(seekBar);
        this.f1237a = seekBar;
    }

    /* renamed from: d */
    private void m1279d() {
        if (this.f1238b == null) {
            return;
        }
        if (this.f1241e || this.f1242f) {
            this.f1238b = C0595a.m2330g(this.f1238b.mutate());
            if (this.f1241e) {
                C0595a.m2319a(this.f1238b, this.f1239c);
            }
            if (this.f1242f) {
                C0595a.m2322a(this.f1238b, this.f1240d);
            }
            if (this.f1238b.isStateful()) {
                this.f1238b.setState(this.f1237a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2613a(Canvas canvas) {
        if (this.f1238b != null) {
            int max = this.f1237a.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1238b.getIntrinsicWidth();
                int intrinsicHeight = this.f1238b.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f1238b.setBounds(-i2, -i, i2, i);
                float width = ((float) ((this.f1237a.getWidth() - this.f1237a.getPaddingLeft()) - this.f1237a.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1237a.getPaddingLeft(), (float) (this.f1237a.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f1238b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2614a(Drawable drawable) {
        Drawable drawable2 = this.f1238b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1238b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1237a);
            C0595a.m2325b(drawable, C0656u.m2621g(this.f1237a));
            if (drawable.isStateful()) {
                drawable.setState(this.f1237a.getDrawableState());
            }
            m1279d();
        }
        this.f1237a.invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2601a(AttributeSet attributeSet, int i) {
        super.mo2601a(attributeSet, i);
        C0302ay a = C0302ay.m1078a(this.f1237a.getContext(), attributeSet, C0059a.C0069j.AppCompatSeekBar, i, 0);
        Drawable b = a.mo2414b(C0059a.C0069j.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.f1237a.setThumb(b);
        }
        mo2614a(a.mo2409a(C0059a.C0069j.AppCompatSeekBar_tickMark));
        if (a.mo2424g(C0059a.C0069j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1240d = C0257af.m914a(a.mo2407a(C0059a.C0069j.AppCompatSeekBar_tickMarkTintMode, -1), this.f1240d);
            this.f1242f = true;
        }
        if (a.mo2424g(C0059a.C0069j.AppCompatSeekBar_tickMarkTint)) {
            this.f1239c = a.mo2420e(C0059a.C0069j.AppCompatSeekBar_tickMarkTint);
            this.f1241e = true;
        }
        a.mo2410a();
        m1279d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2615b() {
        Drawable drawable = this.f1238b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2616c() {
        Drawable drawable = this.f1238b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1237a.getDrawableState())) {
            this.f1237a.invalidateDrawable(drawable);
        }
    }
}
