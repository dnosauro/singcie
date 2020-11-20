package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0198m;
import androidx.core.p030h.C0648m;
import androidx.core.p030h.C0649n;
import androidx.core.p030h.C0650o;
import androidx.core.p030h.C0651p;
import androidx.core.p030h.C0656u;

public class ActionBarOverlayLayout extends ViewGroup implements C0255ad, C0648m, C0649n, C0650o {

    /* renamed from: e */
    static final int[] f731e = {C0059a.C0060a.actionBarSize, 16842841};

    /* renamed from: A */
    private final Runnable f732A = new Runnable() {
        public void run() {
            ActionBarOverlayLayout.this.mo1694d();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f736c = actionBarOverlayLayout.f734a.animate().translationY((float) (-ActionBarOverlayLayout.this.f734a.getHeight())).setListener(ActionBarOverlayLayout.this.f737d);
        }
    };

    /* renamed from: B */
    private final C0651p f733B;

    /* renamed from: a */
    ActionBarContainer f734a;

    /* renamed from: b */
    boolean f735b;

    /* renamed from: c */
    ViewPropertyAnimator f736c;

    /* renamed from: d */
    final AnimatorListenerAdapter f737d = new AnimatorListenerAdapter() {
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f736c = null;
            actionBarOverlayLayout.f735b = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f736c = null;
            actionBarOverlayLayout.f735b = false;
        }
    };

    /* renamed from: f */
    private int f738f;

    /* renamed from: g */
    private int f739g = 0;

    /* renamed from: h */
    private ContentFrameLayout f740h;

    /* renamed from: i */
    private C0256ae f741i;

    /* renamed from: j */
    private Drawable f742j;

    /* renamed from: k */
    private boolean f743k;

    /* renamed from: l */
    private boolean f744l;

    /* renamed from: m */
    private boolean f745m;

    /* renamed from: n */
    private boolean f746n;

    /* renamed from: o */
    private int f747o;

    /* renamed from: p */
    private int f748p;

    /* renamed from: q */
    private final Rect f749q = new Rect();

    /* renamed from: r */
    private final Rect f750r = new Rect();

    /* renamed from: s */
    private final Rect f751s = new Rect();

    /* renamed from: t */
    private final Rect f752t = new Rect();

    /* renamed from: u */
    private final Rect f753u = new Rect();

    /* renamed from: v */
    private final Rect f754v = new Rect();

    /* renamed from: w */
    private final Rect f755w = new Rect();

    /* renamed from: x */
    private C0213a f756x;

    /* renamed from: y */
    private OverScroller f757y;

    /* renamed from: z */
    private final Runnable f758z = new Runnable() {
        public void run() {
            ActionBarOverlayLayout.this.mo1694d();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f736c = actionBarOverlayLayout.f734a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f737d);
        }
    };

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$a */
    public interface C0213a {
        /* renamed from: a */
        void mo968a(int i);

        /* renamed from: h */
        void mo972h(boolean z);

        /* renamed from: j */
        void mo975j();

        /* renamed from: k */
        void mo977k();

        /* renamed from: l */
        void mo979l();

        /* renamed from: m */
        void mo980m();
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$b */
    public static class C0214b extends ViewGroup.MarginLayoutParams {
        public C0214b(int i, int i2) {
            super(i, i2);
        }

        public C0214b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0214b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m700a(context);
        this.f733B = new C0651p(this);
    }

    /* renamed from: a */
    private C0256ae m699a(View view) {
        if (view instanceof C0256ae) {
            return (C0256ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* renamed from: a */
    private void m700a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f731e);
        boolean z = false;
        this.f738f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f742j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f742j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.f743k = z;
        this.f757y = new OverScroller(context);
    }

    /* renamed from: a */
    private boolean m701a(float f, float f2) {
        this.f757y.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f757y.getFinalY() > this.f734a.getHeight();
    }

    /* renamed from: a */
    private boolean m702a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        C0214b bVar = (C0214b) view.getLayoutParams();
        if (!z || bVar.leftMargin == rect.left) {
            z5 = false;
        } else {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    /* renamed from: l */
    private void m703l() {
        mo1694d();
        postDelayed(this.f758z, 600);
    }

    /* renamed from: m */
    private void m704m() {
        mo1694d();
        postDelayed(this.f732A, 600);
    }

    /* renamed from: n */
    private void m705n() {
        mo1694d();
        this.f758z.run();
    }

    /* renamed from: o */
    private void m706o() {
        mo1694d();
        this.f732A.run();
    }

    /* renamed from: a */
    public C0214b generateLayoutParams(AttributeSet attributeSet) {
        return new C0214b(getContext(), attributeSet);
    }

    /* renamed from: a */
    public void mo1688a(int i) {
        mo1692c();
        if (i == 2) {
            this.f741i.mo2120f();
        } else if (i == 5) {
            this.f741i.mo2121g();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    /* renamed from: a */
    public void mo1689a(Menu menu, C0198m.C0199a aVar) {
        mo1692c();
        this.f741i.mo2106a(menu, aVar);
    }

    /* renamed from: a */
    public boolean mo1690a() {
        return this.f744l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0214b generateDefaultLayoutParams() {
        return new C0214b(-1, -1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1692c() {
        if (this.f740h == null) {
            this.f740h = (ContentFrameLayout) findViewById(C0059a.C0065f.action_bar_activity_content);
            this.f734a = (ActionBarContainer) findViewById(C0059a.C0065f.action_bar_container);
            this.f741i = m699a(findViewById(C0059a.C0065f.action_bar));
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0214b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1694d() {
        removeCallbacks(this.f758z);
        removeCallbacks(this.f732A);
        ViewPropertyAnimator viewPropertyAnimator = this.f736c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f742j != null && !this.f743k) {
            int bottom = this.f734a.getVisibility() == 0 ? (int) (((float) this.f734a.getBottom()) + this.f734a.getTranslationY() + 0.5f) : 0;
            this.f742j.setBounds(0, bottom, getWidth(), this.f742j.getIntrinsicHeight() + bottom);
            this.f742j.draw(canvas);
        }
    }

    /* renamed from: e */
    public boolean mo1696e() {
        mo1692c();
        return this.f741i.mo2122h();
    }

    /* renamed from: f */
    public boolean mo1697f() {
        mo1692c();
        return this.f741i.mo2123i();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        mo1692c();
        int p = C0656u.m2633p(this) & 256;
        boolean a = m702a(this.f734a, rect, true, true, false, true);
        this.f752t.set(rect);
        C0313be.m1162a(this, this.f752t, this.f749q);
        if (!this.f753u.equals(this.f752t)) {
            this.f753u.set(this.f752t);
            a = true;
        }
        if (!this.f750r.equals(this.f749q)) {
            this.f750r.set(this.f749q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    /* renamed from: g */
    public boolean mo1699g() {
        mo1692c();
        return this.f741i.mo2124j();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0214b(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f734a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.f733B.mo3813a();
    }

    public CharSequence getTitle() {
        mo1692c();
        return this.f741i.mo2119e();
    }

    /* renamed from: h */
    public boolean mo1706h() {
        mo1692c();
        return this.f741i.mo2125k();
    }

    /* renamed from: i */
    public boolean mo1707i() {
        mo1692c();
        return this.f741i.mo2126l();
    }

    /* renamed from: j */
    public void mo1708j() {
        mo1692c();
        this.f741i.mo2127m();
    }

    /* renamed from: k */
    public void mo1709k() {
        mo1692c();
        this.f741i.mo2128n();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m700a(getContext());
        C0656u.m2634q(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo1694d();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0214b bVar = (C0214b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = bVar.leftMargin + paddingLeft;
                int i7 = bVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        Rect rect;
        mo1692c();
        measureChildWithMargins(this.f734a, i, 0, i2, 0);
        C0214b bVar = (C0214b) this.f734a.getLayoutParams();
        int max = Math.max(0, this.f734a.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int max2 = Math.max(0, this.f734a.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f734a.getMeasuredState());
        boolean z = (C0656u.m2633p(this) & 256) != 0;
        if (z) {
            i3 = this.f738f;
            if (this.f745m && this.f734a.getTabContainer() != null) {
                i3 += this.f738f;
            }
        } else {
            i3 = this.f734a.getVisibility() != 8 ? this.f734a.getMeasuredHeight() : 0;
        }
        this.f751s.set(this.f749q);
        this.f754v.set(this.f752t);
        if (this.f744l || z) {
            this.f754v.top += i3;
            rect = this.f754v;
        } else {
            this.f751s.top += i3;
            rect = this.f751s;
        }
        rect.bottom += 0;
        m702a(this.f740h, this.f751s, true, true, true, true);
        if (!this.f755w.equals(this.f754v)) {
            this.f755w.set(this.f754v);
            this.f740h.mo1819a(this.f754v);
        }
        measureChildWithMargins(this.f740h, i, 0, i2, 0);
        C0214b bVar2 = (C0214b) this.f740h.getLayoutParams();
        int max3 = Math.max(max, this.f740h.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int max4 = Math.max(max2, this.f740h.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f740h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f746n || !z) {
            return false;
        }
        if (m701a(f, f2)) {
            m706o();
        } else {
            m705n();
        }
        this.f735b = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f747o += i2;
        setActionBarHideOffset(this.f747o);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f733B.mo3815a(view, view2, i);
        this.f747o = getActionBarHideOffset();
        mo1694d();
        C0213a aVar = this.f756x;
        if (aVar != null) {
            aVar.mo979l();
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f734a.getVisibility() != 0) {
            return false;
        }
        return this.f746n;
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    public void onStopNestedScroll(View view) {
        if (this.f746n && !this.f735b) {
            if (this.f747o <= this.f734a.getHeight()) {
                m703l();
            } else {
                m704m();
            }
        }
        C0213a aVar = this.f756x;
        if (aVar != null) {
            aVar.mo980m();
        }
    }

    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        mo1692c();
        int i2 = this.f748p ^ i;
        this.f748p = i;
        boolean z = false;
        boolean z2 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        }
        C0213a aVar = this.f756x;
        if (aVar != null) {
            aVar.mo972h(!z);
            if (z2 || !z) {
                this.f756x.mo975j();
            } else {
                this.f756x.mo977k();
            }
        }
        if ((i2 & 256) != 0 && this.f756x != null) {
            C0656u.m2634q(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f739g = i;
        C0213a aVar = this.f756x;
        if (aVar != null) {
            aVar.mo968a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        mo1694d();
        this.f734a.setTranslationY((float) (-Math.max(0, Math.min(i, this.f734a.getHeight()))));
    }

    public void setActionBarVisibilityCallback(C0213a aVar) {
        this.f756x = aVar;
        if (getWindowToken() != null) {
            this.f756x.mo968a(this.f739g);
            int i = this.f748p;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                C0656u.m2634q(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f745m = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f746n) {
            this.f746n = z;
            if (!z) {
                mo1694d();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        mo1692c();
        this.f741i.mo2104a(i);
    }

    public void setIcon(Drawable drawable) {
        mo1692c();
        this.f741i.mo2105a(drawable);
    }

    public void setLogo(int i) {
        mo1692c();
        this.f741i.mo2113b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f744l = z;
        this.f743k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        mo1692c();
        this.f741i.mo2107a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        mo1692c();
        this.f741i.mo2110a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
