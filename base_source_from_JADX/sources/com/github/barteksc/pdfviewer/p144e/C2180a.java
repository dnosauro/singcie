package com.github.barteksc.pdfviewer.p144e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.C0529a;
import com.github.barteksc.pdfviewer.C2187g;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.p146g.C2197f;

/* renamed from: com.github.barteksc.pdfviewer.e.a */
public class C2180a extends RelativeLayout implements C2182b {

    /* renamed from: a */
    protected TextView f6764a;

    /* renamed from: b */
    protected Context f6765b;

    /* renamed from: c */
    private float f6766c;

    /* renamed from: d */
    private boolean f6767d;

    /* renamed from: e */
    private PDFView f6768e;

    /* renamed from: f */
    private float f6769f;

    /* renamed from: g */
    private Handler f6770g;

    /* renamed from: h */
    private Runnable f6771h;

    public C2180a(Context context) {
        this(context, false);
    }

    public C2180a(Context context, boolean z) {
        super(context);
        this.f6766c = 0.0f;
        this.f6770g = new Handler();
        this.f6771h = new Runnable() {
            public void run() {
                C2180a.this.mo9134e();
            }
        };
        this.f6765b = context;
        this.f6767d = z;
        this.f6764a = new TextView(context);
        setVisibility(4);
        setTextColor(-16777216);
        setTextSize(16);
    }

    /* renamed from: f */
    private void m8572f() {
        int i;
        float f;
        float f2;
        if (this.f6768e.mo9006m()) {
            f2 = getY();
            f = (float) getHeight();
            i = this.f6768e.getHeight();
        } else {
            f2 = getX();
            f = (float) getWidth();
            i = this.f6768e.getWidth();
        }
        this.f6766c = ((f2 + this.f6766c) / ((float) i)) * f;
    }

    /* renamed from: g */
    private boolean m8573g() {
        PDFView pDFView = this.f6768e;
        return pDFView != null && pDFView.getPageCount() > 0 && !this.f6768e.mo9002i();
    }

    private void setPosition(float f) {
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            float height = (float) (this.f6768e.mo9006m() ? this.f6768e.getHeight() : this.f6768e.getWidth());
            float f2 = f - this.f6766c;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > height - ((float) C2197f.m8626a(this.f6765b, 40))) {
                f2 = height - ((float) C2197f.m8626a(this.f6765b, 40));
            }
            if (this.f6768e.mo9006m()) {
                setY(f2);
            } else {
                setX(f2);
            }
            m8572f();
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo9130a() {
        this.f6768e.removeView(this);
    }

    /* renamed from: b */
    public void mo9131b() {
        this.f6770g.postDelayed(this.f6771h, 1000);
    }

    /* renamed from: c */
    public boolean mo9132c() {
        return getVisibility() == 0;
    }

    /* renamed from: d */
    public void mo9133d() {
        setVisibility(0);
    }

    /* renamed from: e */
    public void mo9134e() {
        setVisibility(4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PDFView pDFView;
        int i;
        float f;
        float f2;
        float f3;
        if (!m8573g()) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
            case 5:
                this.f6768e.mo8954a();
                this.f6770g.removeCallbacks(this.f6771h);
                if (this.f6768e.mo9006m()) {
                    f3 = motionEvent.getRawY();
                    f2 = getY();
                } else {
                    f3 = motionEvent.getRawX();
                    f2 = getX();
                }
                this.f6769f = f3 - f2;
                break;
            case 1:
            case 3:
            case 6:
                mo9131b();
                this.f6768e.mo8986g();
                return true;
            case 2:
                break;
            default:
                return super.onTouchEvent(motionEvent);
        }
        if (this.f6768e.mo9006m()) {
            setPosition((motionEvent.getRawY() - this.f6769f) + this.f6766c);
            pDFView = this.f6768e;
            f = this.f6766c;
            i = getHeight();
        } else {
            setPosition((motionEvent.getRawX() - this.f6769f) + this.f6766c);
            pDFView = this.f6768e;
            f = this.f6766c;
            i = getWidth();
        }
        pDFView.mo8960a(f / ((float) i), false);
        return true;
    }

    public void setPageNum(int i) {
        String valueOf = String.valueOf(i);
        if (!this.f6764a.getText().equals(valueOf)) {
            this.f6764a.setText(valueOf);
        }
    }

    public void setScroll(float f) {
        if (!mo9132c()) {
            mo9133d();
        } else {
            this.f6770g.removeCallbacks(this.f6771h);
        }
        PDFView pDFView = this.f6768e;
        if (pDFView != null) {
            setPosition(((float) (pDFView.mo9006m() ? this.f6768e.getHeight() : this.f6768e.getWidth())) * f);
        }
    }

    public void setTextColor(int i) {
        this.f6764a.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.f6764a.setTextSize(1, (float) i);
    }

    public void setupLayout(PDFView pDFView) {
        Drawable drawable;
        int i;
        int i2;
        Context context;
        int i3;
        int i4;
        Context context2;
        int i5 = 65;
        int i6 = 40;
        if (pDFView.mo9006m()) {
            if (this.f6767d) {
                i = 9;
                context2 = this.f6765b;
                i4 = C2187g.C2188a.default_scroll_handle_left;
            } else {
                i = 11;
                context2 = this.f6765b;
                i4 = C2187g.C2188a.default_scroll_handle_right;
            }
            drawable = C0529a.m2093a(context2, i4);
        } else {
            if (this.f6767d) {
                i3 = 10;
                context = this.f6765b;
                i2 = C2187g.C2188a.default_scroll_handle_top;
            } else {
                i3 = 12;
                context = this.f6765b;
                i2 = C2187g.C2188a.default_scroll_handle_bottom;
            }
            drawable = C0529a.m2093a(context, i2);
            i5 = 40;
            i6 = 65;
        }
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(C2197f.m8626a(this.f6765b, i5), C2197f.m8626a(this.f6765b, i6));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.f6764a, layoutParams2);
        layoutParams.addRule(i);
        pDFView.addView(this, layoutParams);
        this.f6768e = pDFView;
    }
}
