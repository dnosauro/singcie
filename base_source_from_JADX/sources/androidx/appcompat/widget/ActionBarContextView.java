package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.C0668y;

public class ActionBarContextView extends C0250a {

    /* renamed from: g */
    private CharSequence f718g;

    /* renamed from: h */
    private CharSequence f719h;

    /* renamed from: i */
    private View f720i;

    /* renamed from: j */
    private View f721j;

    /* renamed from: k */
    private LinearLayout f722k;

    /* renamed from: l */
    private TextView f723l;

    /* renamed from: m */
    private TextView f724m;

    /* renamed from: n */
    private int f725n;

    /* renamed from: o */
    private int f726o;

    /* renamed from: p */
    private boolean f727p;

    /* renamed from: q */
    private int f728q;

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0302ay a = C0302ay.m1078a(context, attributeSet, C0059a.C0069j.ActionMode, i, 0);
        C0656u.m2590a((View) this, a.mo2409a(C0059a.C0069j.ActionMode_background));
        this.f725n = a.mo2423g(C0059a.C0069j.ActionMode_titleTextStyle, 0);
        this.f726o = a.mo2423g(C0059a.C0069j.ActionMode_subtitleTextStyle, 0);
        this.f912e = a.mo2421f(C0059a.C0069j.ActionMode_height, 0);
        this.f728q = a.mo2423g(C0059a.C0069j.ActionMode_closeItemLayout, C0059a.C0066g.abc_action_mode_close_item_material);
        a.mo2410a();
    }

    /* renamed from: e */
    private void m692e() {
        if (this.f722k == null) {
            LayoutInflater.from(getContext()).inflate(C0059a.C0066g.abc_action_bar_title_item, this);
            this.f722k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f723l = (TextView) this.f722k.findViewById(C0059a.C0065f.action_bar_title);
            this.f724m = (TextView) this.f722k.findViewById(C0059a.C0065f.action_bar_subtitle);
            if (this.f725n != 0) {
                this.f723l.setTextAppearance(getContext(), this.f725n);
            }
            if (this.f726o != 0) {
                this.f724m.setTextAppearance(getContext(), this.f726o);
            }
        }
        this.f723l.setText(this.f718g);
        this.f724m.setText(this.f719h);
        boolean z = !TextUtils.isEmpty(this.f718g);
        boolean z2 = !TextUtils.isEmpty(this.f719h);
        int i = 0;
        this.f724m.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.f722k;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        if (this.f722k.getParent() == null) {
            addView(this.f722k);
        }
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C0668y mo1661a(int i, long j) {
        return super.mo1661a(i, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        if (r0.getParent() == null) goto L_0x0015;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1662a(final androidx.appcompat.view.C0156b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f720i
            if (r0 != 0) goto L_0x001b
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.f728q
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.f720i = r0
        L_0x0015:
            android.view.View r0 = r3.f720i
            r3.addView(r0)
            goto L_0x0022
        L_0x001b:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0022
            goto L_0x0015
        L_0x0022:
            android.view.View r0 = r3.f720i
            int r1 = androidx.appcompat.C0059a.C0065f.action_mode_close_button
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.ActionBarContextView$1 r1 = new androidx.appcompat.widget.ActionBarContextView$1
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.mo987b()
            androidx.appcompat.view.menu.g r4 = (androidx.appcompat.view.menu.C0183g) r4
            androidx.appcompat.widget.c r0 = r3.f911d
            if (r0 == 0) goto L_0x0041
            androidx.appcompat.widget.c r0 = r3.f911d
            r0.mo2462e()
        L_0x0041:
            androidx.appcompat.widget.c r0 = new androidx.appcompat.widget.c
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.f911d = r0
            androidx.appcompat.widget.c r0 = r3.f911d
            r1 = 1
            r0.mo2456a((boolean) r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.c r1 = r3.f911d
            android.content.Context r2 = r3.f909b
            r4.addMenuPresenter(r1, r2)
            androidx.appcompat.widget.c r4 = r3.f911d
            androidx.appcompat.view.menu.n r4 = r4.mo1299a((android.view.ViewGroup) r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.f910c = r4
            androidx.appcompat.widget.ActionMenuView r4 = r3.f910c
            r1 = 0
            androidx.core.p030h.C0656u.m2590a((android.view.View) r4, (android.graphics.drawable.Drawable) r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.f910c
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.mo1662a(androidx.appcompat.view.b):void");
    }

    /* renamed from: a */
    public boolean mo1663a() {
        if (this.f911d != null) {
            return this.f911d.mo2460c();
        }
        return false;
    }

    /* renamed from: b */
    public void mo1664b() {
        if (this.f720i == null) {
            mo1665c();
        }
    }

    /* renamed from: c */
    public void mo1665c() {
        removeAllViews();
        this.f721j = null;
        this.f910c = null;
    }

    /* renamed from: d */
    public boolean mo1666d() {
        return this.f727p;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f719h;
    }

    public CharSequence getTitle() {
        return this.f718g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f911d != null) {
            this.f911d.mo2461d();
            this.f911d.mo2463f();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f718g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = C0313be.m1163a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f720i;
        if (view == null || view.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f720i.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a2 = m833a(paddingRight, i6, a);
            i5 = m833a(a2 + mo2040a(this.f720i, a2, paddingTop, paddingTop2, a), i7, a);
        }
        LinearLayout linearLayout = this.f722k;
        if (!(linearLayout == null || this.f721j != null || linearLayout.getVisibility() == 8)) {
            i5 += mo2040a(this.f722k, i5, paddingTop, paddingTop2, a);
        }
        int i8 = i5;
        View view2 = this.f721j;
        if (view2 != null) {
            mo2040a(view2, i8, paddingTop, paddingTop2, a);
        }
        int paddingLeft = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f910c != null) {
            mo2040a(this.f910c, paddingLeft, paddingTop, paddingTop2, !a);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = this.f912e > 0 ? this.f912e : View.MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i4 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
            View view = this.f720i;
            if (view != null) {
                int a = mo2039a(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f720i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.f910c != null && this.f910c.getParent() == this) {
                paddingLeft = mo2039a(this.f910c, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f722k;
            if (linearLayout != null && this.f721j == null) {
                if (this.f727p) {
                    this.f722k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f722k.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f722k.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = mo2039a(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f721j;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i5 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i4 = Math.min(layoutParams.height, i4);
                }
                this.f721j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(i4, i3));
            }
            if (this.f912e <= 0) {
                int childCount = getChildCount();
                int i6 = 0;
                for (int i7 = 0; i7 < childCount; i7++) {
                    int measuredHeight = getChildAt(i7).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i6) {
                        i6 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i6);
                return;
            }
            setMeasuredDimension(size, size2);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.f912e = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f721j;
        if (view2 != null) {
            removeView(view2);
        }
        this.f721j = view;
        if (!(view == null || (linearLayout = this.f722k) == null)) {
            removeView(linearLayout);
            this.f722k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f719h = charSequence;
        m692e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f718g = charSequence;
        m692e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f727p) {
            requestLayout();
        }
        this.f727p = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
