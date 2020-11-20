package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.p030h.C0610a;
import androidx.core.p030h.C0646k;
import androidx.core.p030h.C0647l;
import androidx.core.p030h.C0650o;
import androidx.core.p030h.C0651p;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.p031a.C0614c;
import androidx.core.p030h.p031a.C0621e;
import java.util.ArrayList;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public class NestedScrollView extends FrameLayout implements C0646k, C0650o {

    /* renamed from: w */
    private static final C0673a f2344w = new C0673a();

    /* renamed from: x */
    private static final int[] f2345x = {16843130};

    /* renamed from: A */
    private float f2346A;

    /* renamed from: B */
    private C0674b f2347B;

    /* renamed from: a */
    private long f2348a;

    /* renamed from: b */
    private final Rect f2349b;

    /* renamed from: c */
    private OverScroller f2350c;

    /* renamed from: d */
    private EdgeEffect f2351d;

    /* renamed from: e */
    private EdgeEffect f2352e;

    /* renamed from: f */
    private int f2353f;

    /* renamed from: g */
    private boolean f2354g;

    /* renamed from: h */
    private boolean f2355h;

    /* renamed from: i */
    private View f2356i;

    /* renamed from: j */
    private boolean f2357j;

    /* renamed from: k */
    private VelocityTracker f2358k;

    /* renamed from: l */
    private boolean f2359l;

    /* renamed from: m */
    private boolean f2360m;

    /* renamed from: n */
    private int f2361n;

    /* renamed from: o */
    private int f2362o;

    /* renamed from: p */
    private int f2363p;

    /* renamed from: q */
    private int f2364q;

    /* renamed from: r */
    private final int[] f2365r;

    /* renamed from: s */
    private final int[] f2366s;

    /* renamed from: t */
    private int f2367t;

    /* renamed from: u */
    private int f2368u;

    /* renamed from: v */
    private C0675c f2369v;

    /* renamed from: y */
    private final C0651p f2370y;

    /* renamed from: z */
    private final C0647l f2371z;

    /* renamed from: androidx.core.widget.NestedScrollView$a */
    static class C0673a extends C0610a {
        C0673a() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            C0621e.m2488a(accessibilityEvent, nestedScrollView.getScrollX());
            C0621e.m2490b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0614c cVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.mo3716b((CharSequence) ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                cVar.mo3741i(true);
                if (nestedScrollView.getScrollY() > 0) {
                    cVar.mo3707a(C0614c.C0615a.f2266n);
                    cVar.mo3707a(C0614c.C0615a.f2277y);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    cVar.mo3707a(C0614c.C0615a.f2265m);
                    cVar.mo3707a(C0614c.C0615a.f2242A);
                }
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.mo3861a(0, max, true);
                    return true;
                } else if (i != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.mo3861a(0, min, true);
            return true;
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$b */
    public interface C0674b {
        /* renamed from: a */
        void mo696a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    /* renamed from: androidx.core.widget.NestedScrollView$c */
    static class C0675c extends View.BaseSavedState {
        public static final Parcelable.Creator<C0675c> CREATOR = new Parcelable.Creator<C0675c>() {
            /* renamed from: a */
            public C0675c createFromParcel(Parcel parcel) {
                return new C0675c(parcel);
            }

            /* renamed from: a */
            public C0675c[] newArray(int i) {
                return new C0675c[i];
            }
        };

        /* renamed from: a */
        public int f2372a;

        C0675c(Parcel parcel) {
            super(parcel);
            this.f2372a = parcel.readInt();
        }

        C0675c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2372a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2372a);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2349b = new Rect();
        this.f2354g = true;
        this.f2355h = false;
        this.f2356i = null;
        this.f2357j = false;
        this.f2360m = true;
        this.f2364q = -1;
        this.f2365r = new int[2];
        this.f2366s = new int[2];
        m2712a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2345x, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2370y = new C0651p(this);
        this.f2371z = new C0647l(this);
        setNestedScrollingEnabled(true);
        C0656u.m2594a((View) this, (C0610a) f2344w);
    }

    /* renamed from: a */
    private View m2711a(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3) {
                            if (!z4) {
                            }
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (!z4) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    private void m2712a() {
        this.f2350c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(PKIFailureInfo.transactionIdInUse);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2361n = viewConfiguration.getScaledTouchSlop();
        this.f2362o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2363p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: a */
    private void m2713a(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2371z.mo3798a(0, scrollY2, 0, i - scrollY2, (int[]) null, i2, iArr);
    }

    /* renamed from: a */
    private void m2714a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2364q) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f2353f = (int) motionEvent.getY(i);
            this.f2364q = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f2358k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: a */
    private void m2715a(boolean z) {
        if (z) {
            mo3862a(2, 1);
        } else {
            mo3859a(1);
        }
        this.f2368u = getScrollY();
        C0656u.m2617e(this);
    }

    /* renamed from: a */
    private boolean m2716a(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View a = m2711a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2731g(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m2717a(Rect rect, boolean z) {
        int a = mo3858a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                mo3870b(0, a);
            }
        }
        return z2;
    }

    /* renamed from: a */
    private boolean m2718a(View view) {
        return !m2719a(view, 0, getHeight());
    }

    /* renamed from: a */
    private boolean m2719a(View view, int i, int i2) {
        view.getDrawingRect(this.f2349b);
        offsetDescendantRectToMyCoords(view, this.f2349b);
        return this.f2349b.bottom + i >= getScrollY() && this.f2349b.top - i <= getScrollY() + i2;
    }

    /* renamed from: a */
    private static boolean m2720a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m2720a((View) parent, view2);
    }

    /* renamed from: b */
    private static int m2721b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    /* renamed from: b */
    private void m2722b(int i, int i2, boolean z) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2348a > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f2350c;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY);
                m2715a(z);
            } else {
                if (!this.f2350c.isFinished()) {
                    m2729f();
                }
                scrollBy(i, i2);
            }
            this.f2348a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    /* renamed from: b */
    private void m2723b(View view) {
        view.getDrawingRect(this.f2349b);
        offsetDescendantRectToMyCoords(view, this.f2349b);
        int a = mo3858a(this.f2349b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    /* renamed from: b */
    private boolean m2724b() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* renamed from: c */
    private void m2725c() {
        VelocityTracker velocityTracker = this.f2358k;
        if (velocityTracker == null) {
            this.f2358k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* renamed from: c */
    private boolean m2726c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    /* renamed from: d */
    private void m2727d() {
        if (this.f2358k == null) {
            this.f2358k = VelocityTracker.obtain();
        }
    }

    /* renamed from: e */
    private void m2728e() {
        VelocityTracker velocityTracker = this.f2358k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2358k = null;
        }
    }

    /* renamed from: f */
    private void m2729f() {
        this.f2350c.abortAnimation();
        mo3859a(1);
    }

    /* renamed from: g */
    private void m2730g() {
        this.f2357j = false;
        m2728e();
        mo3859a(0);
        EdgeEffect edgeEffect = this.f2351d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f2352e.onRelease();
        }
    }

    /* renamed from: g */
    private void m2731g(int i) {
        if (i == 0) {
            return;
        }
        if (this.f2360m) {
            mo3870b(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f2346A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f2346A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f2346A;
    }

    /* renamed from: h */
    private void m2732h() {
        if (getOverScrollMode() == 2) {
            this.f2351d = null;
            this.f2352e = null;
        } else if (this.f2351d == null) {
            Context context = getContext();
            this.f2351d = new EdgeEffect(context);
            this.f2352e = new EdgeEffect(context);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo3858a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        if (rect.bottom > i2 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i2) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        } else if (rect.top >= scrollY || rect.bottom >= i2) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    /* renamed from: a */
    public void mo3859a(int i) {
        this.f2371z.mo3812c(i);
    }

    /* renamed from: a */
    public void mo3860a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.f2371z.mo3798a(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3861a(int i, int i2, boolean z) {
        m2722b(i - getScrollX(), i2 - getScrollY(), z);
    }

    /* renamed from: a */
    public boolean mo3862a(int i, int i2) {
        return this.f2371z.mo3804a(i, i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3863a(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x002a
            if (r1 != r5) goto L_0x0028
            if (r2 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x0034
            if (r1 != r5) goto L_0x0032
            if (r3 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            int r3 = r15 + r13
            if (r2 != 0) goto L_0x003b
            r2 = 0
            goto L_0x003d
        L_0x003b:
            r2 = r19
        L_0x003d:
            int r6 = r16 + r14
            if (r1 != 0) goto L_0x0043
            r1 = 0
            goto L_0x0045
        L_0x0043:
            r1 = r20
        L_0x0045:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L_0x0050
            r7 = r2
        L_0x004e:
            r2 = 1
            goto L_0x0055
        L_0x0050:
            if (r3 >= r7) goto L_0x0053
            goto L_0x004e
        L_0x0053:
            r7 = r3
            r2 = 0
        L_0x0055:
            if (r6 <= r1) goto L_0x005a
            r6 = r1
        L_0x0058:
            r1 = 1
            goto L_0x005f
        L_0x005a:
            if (r6 >= r8) goto L_0x005e
            r6 = r8
            goto L_0x0058
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x007e
            boolean r3 = r12.mo3871b((int) r5)
            if (r3 != 0) goto L_0x007e
            android.widget.OverScroller r3 = r0.f2350c
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r3
            r14 = r7
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L_0x007e:
            r12.onOverScrolled(r7, r6, r2, r1)
            if (r2 != 0) goto L_0x0085
            if (r1 == 0) goto L_0x0086
        L_0x0085:
            r4 = 1
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.mo3863a(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    /* renamed from: a */
    public boolean mo3864a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f2371z.mo3808a(i, i2, iArr, iArr2, i3);
    }

    /* renamed from: a */
    public boolean mo3865a(KeyEvent keyEvent) {
        this.f2349b.setEmpty();
        int i = 130;
        if (!m2724b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 62) {
                switch (keyCode) {
                    case 19:
                        return !keyEvent.isAltPressed() ? mo3887e(33) : mo3880d(33);
                    case 20:
                        return !keyEvent.isAltPressed() ? mo3887e(130) : mo3880d(130);
                    default:
                        return false;
                }
            } else {
                if (keyEvent.isShiftPressed()) {
                    i = 33;
                }
                mo3872c(i);
                return false;
            }
        }
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* renamed from: b */
    public final void mo3870b(int i, int i2) {
        m2722b(i, i2, false);
    }

    /* renamed from: b */
    public boolean mo3871b(int i) {
        return this.f2371z.mo3803a(i);
    }

    /* renamed from: c */
    public boolean mo3872c(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f2349b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.f2349b.top + height > bottom) {
                    this.f2349b.top = bottom - height;
                }
            }
        } else {
            this.f2349b.top = getScrollY() - height;
            if (this.f2349b.top < 0) {
                this.f2349b.top = 0;
            }
        }
        Rect rect = this.f2349b;
        rect.bottom = rect.top + height;
        return m2716a(i, this.f2349b.top, this.f2349b.bottom);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (!this.f2350c.isFinished()) {
            this.f2350c.computeScrollOffset();
            int currY = this.f2350c.getCurrY();
            int i = currY - this.f2368u;
            this.f2368u = currY;
            int[] iArr = this.f2366s;
            boolean z = false;
            iArr[1] = 0;
            mo3864a(0, i, iArr, (int[]) null, 1);
            int i2 = i - this.f2366s[1];
            int scrollRange = getScrollRange();
            if (i2 != 0) {
                int scrollY = getScrollY();
                mo3863a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i2 - scrollY2;
                int[] iArr2 = this.f2366s;
                iArr2[1] = 0;
                mo3860a(0, scrollY2, 0, i3, this.f2365r, 1, iArr2);
                i2 = i3 - this.f2366s[1];
            }
            if (i2 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z = true;
                }
                if (z) {
                    m2732h();
                    if (i2 < 0) {
                        if (this.f2351d.isFinished()) {
                            edgeEffect = this.f2351d;
                        }
                    } else if (this.f2352e.isFinished()) {
                        edgeEffect = this.f2352e;
                    }
                    edgeEffect.onAbsorb((int) this.f2350c.getCurrVelocity());
                }
                m2729f();
            }
            if (!this.f2350c.isFinished()) {
                C0656u.m2617e(this);
            } else {
                mo3859a(1);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    /* renamed from: d */
    public boolean mo3880d(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f2349b;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2349b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2349b;
            rect2.top = rect2.bottom - height;
        }
        return m2716a(i, this.f2349b.top, this.f2349b.bottom);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo3865a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f2371z.mo3802a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f2371z.mo3801a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return mo3864a(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f2371z.mo3805a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f2351d != null) {
            int scrollY = getScrollY();
            int i2 = 0;
            if (!this.f2351d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i = getPaddingLeft() + 0;
                } else {
                    i = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i, (float) min);
                this.f2351d.setSize(width, height);
                if (this.f2351d.draw(canvas)) {
                    C0656u.m2617e(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f2352e.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i2 = 0 + getPaddingLeft();
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i2 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.f2352e.setSize(width2, height2);
                if (this.f2352e.draw(canvas)) {
                    C0656u.m2617e(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* renamed from: e */
    public boolean mo3887e(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2719a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2731g(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f2349b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2349b);
            m2731g(mo3858a(this.f2349b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus == null || !findFocus.isFocused() || !m2718a(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    /* renamed from: f */
    public void mo3888f(int i) {
        if (getChildCount() > 0) {
            this.f2350c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m2715a(true);
        }
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.f2370y.mo3813a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return mo3871b(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2371z.mo3800a();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2355h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f2357j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    verticalScrollFactorCompat = 0;
                } else if (verticalScrollFactorCompat > scrollRange) {
                    verticalScrollFactorCompat = scrollRange;
                }
                if (verticalScrollFactorCompat != scrollY) {
                    super.scrollTo(getScrollX(), verticalScrollFactorCompat);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f2357j) {
            return true;
        }
        int i = action & 255;
        if (i != 6) {
            switch (i) {
                case 0:
                    int y = (int) motionEvent.getY();
                    if (m2726c((int) motionEvent.getX(), y)) {
                        this.f2353f = y;
                        this.f2364q = motionEvent.getPointerId(0);
                        m2725c();
                        this.f2358k.addMovement(motionEvent);
                        this.f2350c.computeScrollOffset();
                        this.f2357j = !this.f2350c.isFinished();
                        mo3862a(2, 0);
                        break;
                    } else {
                        this.f2357j = false;
                        m2728e();
                        break;
                    }
                case 1:
                case 3:
                    this.f2357j = false;
                    this.f2364q = -1;
                    m2728e();
                    if (this.f2350c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        C0656u.m2617e(this);
                    }
                    mo3859a(0);
                    break;
                case 2:
                    int i2 = this.f2364q;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex != -1) {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.f2353f) > this.f2361n && (2 & getNestedScrollAxes()) == 0) {
                                this.f2357j = true;
                                this.f2353f = y2;
                                m2727d();
                                this.f2358k.addMovement(motionEvent);
                                this.f2367t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                    break;
                                }
                            }
                        } else {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                            break;
                        }
                    }
                    break;
            }
        } else {
            m2714a(motionEvent);
        }
        return this.f2357j;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.f2354g = false;
        View view = this.f2356i;
        if (view != null && m2720a(view, (View) this)) {
            m2723b(this.f2356i);
        }
        this.f2356i = null;
        if (!this.f2355h) {
            if (this.f2369v != null) {
                scrollTo(getScrollX(), this.f2369v.f2372a);
                this.f2369v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int b = m2721b(scrollY, paddingTop, i5);
            if (b != scrollY) {
                scrollTo(getScrollX(), b);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2355h = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2359l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        mo3888f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        mo3864a(i, i2, iArr, (int[]) null, i3);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        m2713a(i4, 0, (int[]) null);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        m2713a(i4, i5, (int[]) null);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        m2713a(i4, i5, iArr);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.f2370y.mo3816a(view, view2, i, i2);
        mo3862a(2, i2);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, (View) null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus != null && !m2718a(findNextFocus)) {
            return findNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0675c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0675c cVar = (C0675c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f2369v = cVar;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C0675c cVar = new C0675c(super.onSaveInstanceState());
        cVar.f2372a = getScrollY();
        return cVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        C0674b bVar = this.f2347B;
        if (bVar != null) {
            bVar.mo696a(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2719a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f2349b);
            offsetDescendantRectToMyCoords(findFocus, this.f2349b);
            m2731g(mo3858a(this.f2349b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.f2370y.mo3814a(view, i);
        mo3859a(i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0066, code lost:
        if (r10.f2350c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0068, code lost:
        androidx.core.p030h.C0656u.m2617e(r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0202, code lost:
        if (r10.f2350c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r23) {
        /*
            r22 = this;
            r10 = r22
            r11 = r23
            r22.m2727d()
            int r0 = r23.getActionMasked()
            r12 = 0
            if (r0 != 0) goto L_0x0010
            r10.f2367t = r12
        L_0x0010:
            android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r23)
            int r1 = r10.f2367t
            float r1 = (float) r1
            r2 = 0
            r13.offsetLocation(r2, r1)
            r1 = -1
            r14 = 1
            switch(r0) {
                case 0: goto L_0x0206;
                case 1: goto L_0x01c1;
                case 2: goto L_0x0072;
                case 3: goto L_0x0047;
                case 4: goto L_0x0020;
                case 5: goto L_0x0034;
                case 6: goto L_0x0022;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x023d
        L_0x0022:
            r22.m2714a((android.view.MotionEvent) r23)
            int r0 = r10.f2364q
            int r0 = r11.findPointerIndex(r0)
            float r0 = r11.getY(r0)
            int r0 = (int) r0
            r10.f2353f = r0
            goto L_0x023d
        L_0x0034:
            int r0 = r23.getActionIndex()
            float r1 = r11.getY(r0)
            int r1 = (int) r1
            r10.f2353f = r1
            int r0 = r11.getPointerId(r0)
            r10.f2364q = r0
            goto L_0x023d
        L_0x0047:
            boolean r0 = r10.f2357j
            if (r0 == 0) goto L_0x006b
            int r0 = r22.getChildCount()
            if (r0 <= 0) goto L_0x006b
            android.widget.OverScroller r2 = r10.f2350c
            int r3 = r22.getScrollX()
            int r4 = r22.getScrollY()
            r5 = 0
            r6 = 0
            r7 = 0
            int r8 = r22.getScrollRange()
            boolean r0 = r2.springBack(r3, r4, r5, r6, r7, r8)
            if (r0 == 0) goto L_0x006b
        L_0x0068:
            androidx.core.p030h.C0656u.m2617e(r22)
        L_0x006b:
            r10.f2364q = r1
            r22.m2730g()
            goto L_0x023d
        L_0x0072:
            int r0 = r10.f2364q
            int r15 = r11.findPointerIndex(r0)
            if (r15 != r1) goto L_0x0099
            java.lang.String r0 = "NestedScrollView"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid pointerId="
            r1.append(r2)
            int r2 = r10.f2364q
            r1.append(r2)
            java.lang.String r2 = " in onTouchEvent"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r0, r1)
            goto L_0x023d
        L_0x0099:
            float r0 = r11.getY(r15)
            int r6 = (int) r0
            int r0 = r10.f2353f
            int r0 = r0 - r6
            boolean r1 = r10.f2357j
            if (r1 != 0) goto L_0x00c1
            int r1 = java.lang.Math.abs(r0)
            int r2 = r10.f2361n
            if (r1 <= r2) goto L_0x00c1
            android.view.ViewParent r1 = r22.getParent()
            if (r1 == 0) goto L_0x00b6
            r1.requestDisallowInterceptTouchEvent(r14)
        L_0x00b6:
            r10.f2357j = r14
            if (r0 <= 0) goto L_0x00be
            int r1 = r10.f2361n
            int r0 = r0 - r1
            goto L_0x00c1
        L_0x00be:
            int r1 = r10.f2361n
            int r0 = r0 + r1
        L_0x00c1:
            r7 = r0
            boolean r0 = r10.f2357j
            if (r0 == 0) goto L_0x023d
            r1 = 0
            int[] r3 = r10.f2366s
            int[] r4 = r10.f2365r
            r5 = 0
            r0 = r22
            r2 = r7
            boolean r0 = r0.mo3864a(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00e3
            int[] r0 = r10.f2366s
            r0 = r0[r14]
            int r7 = r7 - r0
            int r0 = r10.f2367t
            int[] r1 = r10.f2365r
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.f2367t = r0
        L_0x00e3:
            r16 = r7
            int[] r0 = r10.f2365r
            r0 = r0[r14]
            int r6 = r6 - r0
            r10.f2353f = r6
            int r17 = r22.getScrollY()
            int r9 = r22.getScrollRange()
            int r0 = r22.getOverScrollMode()
            if (r0 == 0) goto L_0x0102
            if (r0 != r14) goto L_0x00ff
            if (r9 <= 0) goto L_0x00ff
            goto L_0x0102
        L_0x00ff:
            r18 = 0
            goto L_0x0104
        L_0x0102:
            r18 = 1
        L_0x0104:
            r1 = 0
            r3 = 0
            int r4 = r22.getScrollY()
            r5 = 0
            r7 = 0
            r8 = 0
            r19 = 1
            r0 = r22
            r2 = r16
            r6 = r9
            r20 = r9
            r9 = r19
            boolean r0 = r0.mo3863a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0129
            boolean r0 = r10.mo3871b((int) r12)
            if (r0 != 0) goto L_0x0129
            android.view.VelocityTracker r0 = r10.f2358k
            r0.clear()
        L_0x0129:
            int r0 = r22.getScrollY()
            int r2 = r0 - r17
            int r4 = r16 - r2
            int[] r7 = r10.f2366s
            r7[r14] = r12
            r1 = 0
            r3 = 0
            int[] r5 = r10.f2365r
            r6 = 0
            r0 = r22
            r0.mo3860a(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r10.f2353f
            int[] r1 = r10.f2365r
            r2 = r1[r14]
            int r0 = r0 - r2
            r10.f2353f = r0
            int r0 = r10.f2367t
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.f2367t = r0
            if (r18 == 0) goto L_0x023d
            int[] r0 = r10.f2366s
            r0 = r0[r14]
            int r0 = r16 - r0
            r22.m2732h()
            int r1 = r17 + r0
            if (r1 >= 0) goto L_0x0182
            android.widget.EdgeEffect r1 = r10.f2351d
            float r0 = (float) r0
            int r2 = r22.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            float r2 = r11.getX(r15)
            int r3 = r22.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            androidx.core.widget.C0682d.m2789a(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.f2352e
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01aa
            android.widget.EdgeEffect r0 = r10.f2352e
        L_0x017e:
            r0.onRelease()
            goto L_0x01aa
        L_0x0182:
            r2 = r20
            if (r1 <= r2) goto L_0x01aa
            android.widget.EdgeEffect r1 = r10.f2352e
            float r0 = (float) r0
            int r2 = r22.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = r11.getX(r15)
            int r4 = r22.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            float r2 = r2 - r3
            androidx.core.widget.C0682d.m2789a(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.f2351d
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01aa
            android.widget.EdgeEffect r0 = r10.f2351d
            goto L_0x017e
        L_0x01aa:
            android.widget.EdgeEffect r0 = r10.f2351d
            if (r0 == 0) goto L_0x023d
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x01bc
            android.widget.EdgeEffect r0 = r10.f2352e
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x023d
        L_0x01bc:
            androidx.core.p030h.C0656u.m2617e(r22)
            goto L_0x023d
        L_0x01c1:
            android.view.VelocityTracker r0 = r10.f2358k
            r3 = 1000(0x3e8, float:1.401E-42)
            int r4 = r10.f2363p
            float r4 = (float) r4
            r0.computeCurrentVelocity(r3, r4)
            int r3 = r10.f2364q
            float r0 = r0.getYVelocity(r3)
            int r0 = (int) r0
            int r3 = java.lang.Math.abs(r0)
            int r4 = r10.f2362o
            if (r3 < r4) goto L_0x01ea
            int r0 = -r0
            float r3 = (float) r0
            boolean r4 = r10.dispatchNestedPreFling(r2, r3)
            if (r4 != 0) goto L_0x006b
            r10.dispatchNestedFling(r2, r3, r14)
            r10.mo3888f(r0)
            goto L_0x006b
        L_0x01ea:
            android.widget.OverScroller r15 = r10.f2350c
            int r16 = r22.getScrollX()
            int r17 = r22.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r22.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x006b
            goto L_0x0068
        L_0x0206:
            int r0 = r22.getChildCount()
            if (r0 != 0) goto L_0x020d
            return r12
        L_0x020d:
            android.widget.OverScroller r0 = r10.f2350c
            boolean r0 = r0.isFinished()
            r0 = r0 ^ r14
            r10.f2357j = r0
            if (r0 == 0) goto L_0x0221
            android.view.ViewParent r0 = r22.getParent()
            if (r0 == 0) goto L_0x0221
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x0221:
            android.widget.OverScroller r0 = r10.f2350c
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x022c
            r22.m2729f()
        L_0x022c:
            float r0 = r23.getY()
            int r0 = (int) r0
            r10.f2353f = r0
            int r0 = r11.getPointerId(r12)
            r10.f2364q = r0
            r0 = 2
            r10.mo3862a((int) r0, (int) r12)
        L_0x023d:
            android.view.VelocityTracker r0 = r10.f2358k
            if (r0 == 0) goto L_0x0244
            r0.addMovement(r13)
        L_0x0244:
            r13.recycle()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f2354g) {
            m2723b(view2);
        } else {
            this.f2356i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2717a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2728e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f2354g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int b = m2721b(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int b2 = m2721b(i2, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f2359l) {
            this.f2359l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f2371z.mo3799a(z);
    }

    public void setOnScrollChangeListener(C0674b bVar) {
        this.f2347B = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f2360m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return mo3862a(i, 0);
    }

    public void stopNestedScroll() {
        mo3859a(0);
    }
}
