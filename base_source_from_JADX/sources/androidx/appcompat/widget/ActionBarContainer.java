package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.C0059a;
import androidx.core.p030h.C0656u;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    Drawable f708a;

    /* renamed from: b */
    Drawable f709b;

    /* renamed from: c */
    Drawable f710c;

    /* renamed from: d */
    boolean f711d;

    /* renamed from: e */
    boolean f712e;

    /* renamed from: f */
    private boolean f713f;

    /* renamed from: g */
    private View f714g;

    /* renamed from: h */
    private View f715h;

    /* renamed from: i */
    private View f716i;

    /* renamed from: j */
    private int f717j;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0656u.m2590a((View) this, (Drawable) new C0306b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.C0069j.ActionBar);
        this.f708a = obtainStyledAttributes.getDrawable(C0059a.C0069j.ActionBar_background);
        this.f709b = obtainStyledAttributes.getDrawable(C0059a.C0069j.ActionBar_backgroundStacked);
        this.f717j = obtainStyledAttributes.getDimensionPixelSize(C0059a.C0069j.ActionBar_height, -1);
        if (getId() == C0059a.C0065f.split_action_bar) {
            this.f711d = true;
            this.f710c = obtainStyledAttributes.getDrawable(C0059a.C0069j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f711d ? this.f708a == null && this.f709b == null : this.f710c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    /* renamed from: a */
    private boolean m690a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: b */
    private int m691b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f708a;
        if (drawable != null && drawable.isStateful()) {
            this.f708a.setState(getDrawableState());
        }
        Drawable drawable2 = this.f709b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f709b.setState(getDrawableState());
        }
        Drawable drawable3 = this.f710c;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f710c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f714g;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f708a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f709b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f710c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f715h = findViewById(C0059a.C0065f.action_bar);
        this.f716i = findViewById(C0059a.C0065f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f713f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z, i, i2, i3, i4);
        View view2 = this.f714g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (!(view2 == null || view2.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            view2.layout(i, (measuredHeight - view2.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f711d) {
            Drawable drawable3 = this.f710c;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f708a != null) {
                if (this.f715h.getVisibility() == 0) {
                    drawable2 = this.f708a;
                    left = this.f715h.getLeft();
                    top = this.f715h.getTop();
                    right = this.f715h.getRight();
                    view = this.f715h;
                } else {
                    View view3 = this.f716i;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f708a.setBounds(0, 0, 0, 0);
                        z3 = true;
                    } else {
                        drawable2 = this.f708a;
                        left = this.f716i.getLeft();
                        top = this.f716i.getTop();
                        right = this.f716i.getRight();
                        view = this.f716i;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.f712e = z4;
            if (!z4 || (drawable = this.f709b) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f715h
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x001c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L_0x001c
            int r0 = r3.f717j
            if (r0 < 0) goto L_0x001c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L_0x001c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f715h
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f714g
            if (r0 == 0) goto L_0x006f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x006f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L_0x006f
            android.view.View r0 = r3.f715h
            boolean r0 = r3.m690a(r0)
            if (r0 != 0) goto L_0x0047
            android.view.View r0 = r3.f715h
        L_0x0042:
            int r0 = r3.m691b(r0)
            goto L_0x0053
        L_0x0047:
            android.view.View r0 = r3.f716i
            boolean r0 = r3.m690a(r0)
            if (r0 != 0) goto L_0x0052
            android.view.View r0 = r3.f716i
            goto L_0x0042
        L_0x0052:
            r0 = 0
        L_0x0053:
            if (r4 != r1) goto L_0x005a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L_0x005d
        L_0x005a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x005d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f714g
            int r1 = r3.m691b(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f708a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f708a);
        }
        this.f708a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f715h;
            if (view != null) {
                this.f708a.setBounds(view.getLeft(), this.f715h.getTop(), this.f715h.getRight(), this.f715h.getBottom());
            }
        }
        boolean z = true;
        if (!this.f711d ? !(this.f708a == null && this.f709b == null) : this.f710c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f710c;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f710c);
        }
        this.f710c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f711d && (drawable2 = this.f710c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f711d ? this.f708a == null && this.f709b == null : this.f710c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f709b;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f709b);
        }
        this.f709b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f712e && (drawable2 = this.f709b) != null) {
                drawable2.setBounds(this.f714g.getLeft(), this.f714g.getTop(), this.f714g.getRight(), this.f714g.getBottom());
            }
        }
        boolean z = true;
        if (!this.f711d ? !(this.f708a == null && this.f709b == null) : this.f710c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(C0288aq aqVar) {
        View view = this.f714g;
        if (view != null) {
            removeView(view);
        }
        this.f714g = aqVar;
        if (aqVar != null) {
            addView(aqVar);
            ViewGroup.LayoutParams layoutParams = aqVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            aqVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f713f = z;
        setDescendantFocusability(z ? 393216 : PKIFailureInfo.transactionIdInUse);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f708a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f709b;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f710c;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f708a && !this.f711d) || (drawable == this.f709b && this.f712e) || ((drawable == this.f710c && this.f711d) || super.verifyDrawable(drawable));
    }
}
