package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.C0668y;
import androidx.core.p030h.C0672z;

/* renamed from: androidx.appcompat.widget.a */
abstract class C0250a extends ViewGroup {

    /* renamed from: a */
    protected final C0251a f908a;

    /* renamed from: b */
    protected final Context f909b;

    /* renamed from: c */
    protected ActionMenuView f910c;

    /* renamed from: d */
    protected C0315c f911d;

    /* renamed from: e */
    protected int f912e;

    /* renamed from: f */
    protected C0668y f913f;

    /* renamed from: g */
    private boolean f914g;

    /* renamed from: h */
    private boolean f915h;

    /* renamed from: androidx.appcompat.widget.a$a */
    protected class C0251a implements C0672z {

        /* renamed from: a */
        int f916a;

        /* renamed from: c */
        private boolean f918c = false;

        protected C0251a() {
        }

        /* renamed from: a */
        public C0251a mo2042a(C0668y yVar, int i) {
            C0250a.this.f913f = yVar;
            this.f916a = i;
            return this;
        }

        /* renamed from: a */
        public void mo912a(View view) {
            C0250a.super.setVisibility(0);
            this.f918c = false;
        }

        /* renamed from: b */
        public void mo913b(View view) {
            if (!this.f918c) {
                C0250a aVar = C0250a.this;
                aVar.f913f = null;
                C0250a.super.setVisibility(this.f916a);
            }
        }

        /* renamed from: c */
        public void mo2043c(View view) {
            this.f918c = true;
        }
    }

    C0250a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0250a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f908a = new C0251a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0059a.C0060a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f909b = context;
        } else {
            this.f909b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* renamed from: a */
    protected static int m833a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2039a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2040a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* renamed from: a */
    public C0668y mo1661a(int i, long j) {
        C0668y a;
        C0668y yVar = this.f913f;
        if (yVar != null) {
            yVar.mo3852b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            a = C0656u.m2630m(this).mo3845a(1.0f);
        } else {
            a = C0656u.m2630m(this).mo3845a(0.0f);
        }
        a.mo3846a(j);
        a.mo3849a((C0672z) this.f908a.mo2042a(a, i));
        return a;
    }

    /* renamed from: a */
    public boolean mo1663a() {
        C0315c cVar = this.f911d;
        if (cVar != null) {
            return cVar.mo2460c();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.f913f != null ? this.f908a.f916a : getVisibility();
    }

    public int getContentHeight() {
        return this.f912e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, C0059a.C0069j.ActionBar, C0059a.C0060a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0059a.C0069j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        C0315c cVar = this.f911d;
        if (cVar != null) {
            cVar.mo2453a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f915h = false;
        }
        if (!this.f915h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f915h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f915h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f914g = false;
        }
        if (!this.f914g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f914g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f914g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f912e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            C0668y yVar = this.f913f;
            if (yVar != null) {
                yVar.mo3852b();
            }
            super.setVisibility(i);
        }
    }
}
