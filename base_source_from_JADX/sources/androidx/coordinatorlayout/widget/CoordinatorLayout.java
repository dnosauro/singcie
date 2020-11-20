package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.C0465a;
import androidx.core.content.C0529a;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p029g.C0582c;
import androidx.core.p029g.C0584e;
import androidx.core.p030h.C0633ac;
import androidx.core.p030h.C0637c;
import androidx.core.p030h.C0649n;
import androidx.core.p030h.C0650o;
import androidx.core.p030h.C0651p;
import androidx.core.p030h.C0652q;
import androidx.core.p030h.C0656u;
import androidx.p035e.p036a.C0711a;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.p172io.FilenameUtils;

public class CoordinatorLayout extends ViewGroup implements C0649n, C0650o {
    static final Class<?>[] CONSTRUCTOR_PARAMS = {Context.class, AttributeSet.class};
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<C0471b>>> sConstructors = new ThreadLocal<>();
    private static final C0584e.C0585a<Rect> sRectPool = new C0584e.C0587c(12);
    private C0652q mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final C0479a<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private C0633ac mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final C0651p mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private C0475f mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$a */
    public interface C0470a {
        C0471b getBehavior();
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$b */
    public static abstract class C0471b<V extends View> {
        public C0471b() {
        }

        public C0471b(Context context, AttributeSet attributeSet) {
        }

        public static Object getTag(View view) {
            return ((C0474e) view.getLayoutParams()).f1905n;
        }

        public static void setTag(View view, Object obj) {
            ((C0474e) view.getLayoutParams()).f1905n = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public C0633ac onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, C0633ac acVar) {
            return acVar;
        }

        public void onAttachedToLayoutParams(C0474e eVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4, i5);
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
            }
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$c */
    public @interface C0472c {
        /* renamed from: a */
        Class<? extends C0471b> mo3362a();
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$d */
    private class C0473d implements ViewGroup.OnHierarchyChangeListener {
        C0473d() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$e */
    public static class C0474e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        C0471b f1892a;

        /* renamed from: b */
        boolean f1893b = false;

        /* renamed from: c */
        public int f1894c = 0;

        /* renamed from: d */
        public int f1895d = 0;

        /* renamed from: e */
        public int f1896e = -1;

        /* renamed from: f */
        int f1897f = -1;

        /* renamed from: g */
        public int f1898g = 0;

        /* renamed from: h */
        public int f1899h = 0;

        /* renamed from: i */
        int f1900i;

        /* renamed from: j */
        int f1901j;

        /* renamed from: k */
        View f1902k;

        /* renamed from: l */
        View f1903l;

        /* renamed from: m */
        final Rect f1904m = new Rect();

        /* renamed from: n */
        Object f1905n;

        /* renamed from: o */
        private boolean f1906o;

        /* renamed from: p */
        private boolean f1907p;

        /* renamed from: q */
        private boolean f1908q;

        /* renamed from: r */
        private boolean f1909r;

        public C0474e(int i, int i2) {
            super(i, i2);
        }

        C0474e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0465a.C0468c.CoordinatorLayout_Layout);
            this.f1894c = obtainStyledAttributes.getInteger(C0465a.C0468c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f1897f = obtainStyledAttributes.getResourceId(C0465a.C0468c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f1895d = obtainStyledAttributes.getInteger(C0465a.C0468c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f1896e = obtainStyledAttributes.getInteger(C0465a.C0468c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f1898g = obtainStyledAttributes.getInt(C0465a.C0468c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f1899h = obtainStyledAttributes.getInt(C0465a.C0468c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f1893b = obtainStyledAttributes.hasValue(C0465a.C0468c.CoordinatorLayout_Layout_layout_behavior);
            if (this.f1893b) {
                this.f1892a = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(C0465a.C0468c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            C0471b bVar = this.f1892a;
            if (bVar != null) {
                bVar.onAttachedToLayoutParams(this);
            }
        }

        public C0474e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0474e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0474e(C0474e eVar) {
            super(eVar);
        }

        /* renamed from: a */
        private void m1899a(View view, CoordinatorLayout coordinatorLayout) {
            this.f1902k = coordinatorLayout.findViewById(this.f1897f);
            View view2 = this.f1902k;
            if (view2 != null) {
                if (view2 != coordinatorLayout) {
                    ViewParent parent = view2.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f1903l = view2;
                    return;
                } else if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f1897f) + " to anchor view " + view);
            }
            this.f1903l = null;
            this.f1902k = null;
        }

        /* renamed from: a */
        private boolean m1900a(View view, int i) {
            int a = C0637c.m2519a(((C0474e) view.getLayoutParams()).f1898g, i);
            return a != 0 && (C0637c.m2519a(this.f1899h, i) & a) == a;
        }

        /* renamed from: b */
        private boolean m1901b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1902k.getId() != this.f1897f) {
                return false;
            }
            View view2 = this.f1902k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f1903l = null;
                    this.f1902k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f1903l = view2;
            return true;
        }

        /* renamed from: a */
        public int mo3365a() {
            return this.f1897f;
        }

        /* renamed from: a */
        public void mo3366a(int i) {
            mo3383i();
            this.f1897f = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3367a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.f1907p = z;
                    return;
                case 1:
                    this.f1908q = z;
                    return;
                default:
                    return;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3368a(Rect rect) {
            this.f1904m.set(rect);
        }

        /* renamed from: a */
        public void mo3369a(C0471b bVar) {
            C0471b bVar2 = this.f1892a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.onDetachedFromLayoutParams();
                }
                this.f1892a = bVar;
                this.f1905n = null;
                this.f1893b = true;
                if (bVar != null) {
                    bVar.onAttachedToLayoutParams(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3370a(boolean z) {
            this.f1909r = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo3371a(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.f1906o;
            if (z) {
                return true;
            }
            C0471b bVar = this.f1892a;
            boolean blocksInteractionBelow = (bVar != null ? bVar.blocksInteractionBelow(coordinatorLayout, view) : false) | z;
            this.f1906o = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r0 = r1.f1892a;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo3372a(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4) {
            /*
                r1 = this;
                android.view.View r0 = r1.f1903l
                if (r4 == r0) goto L_0x001b
                int r0 = androidx.core.p030h.C0656u.m2621g(r2)
                boolean r0 = r1.m1900a((android.view.View) r4, (int) r0)
                if (r0 != 0) goto L_0x001b
                androidx.coordinatorlayout.widget.CoordinatorLayout$b r0 = r1.f1892a
                if (r0 == 0) goto L_0x0019
                boolean r2 = r0.layoutDependsOn(r2, r3, r4)
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r2 = 0
                goto L_0x001c
            L_0x001b:
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.C0474e.mo3372a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):boolean");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public View mo3373b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1897f == -1) {
                this.f1903l = null;
                this.f1902k = null;
                return null;
            }
            if (this.f1902k == null || !m1901b(view, coordinatorLayout)) {
                m1899a(view, coordinatorLayout);
            }
            return this.f1902k;
        }

        /* renamed from: b */
        public C0471b mo3374b() {
            return this.f1892a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo3375b(int i) {
            mo3367a(i, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Rect mo3376c() {
            return this.f1904m;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo3377c(int i) {
            switch (i) {
                case 0:
                    return this.f1907p;
                case 1:
                    return this.f1908q;
                default:
                    return false;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo3378d() {
            return this.f1902k == null && this.f1897f != -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public boolean mo3379e() {
            if (this.f1892a == null) {
                this.f1906o = false;
            }
            return this.f1906o;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo3380f() {
            this.f1906o = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public boolean mo3381g() {
            return this.f1909r;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo3382h() {
            this.f1909r = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo3383i() {
            this.f1903l = null;
            this.f1902k = null;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$f */
    class C0475f implements ViewTreeObserver.OnPreDrawListener {
        C0475f() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$g */
    protected static class C0476g extends C0711a {
        public static final Parcelable.Creator<C0476g> CREATOR = new Parcelable.ClassLoaderCreator<C0476g>() {
            /* renamed from: a */
            public C0476g createFromParcel(Parcel parcel) {
                return new C0476g(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public C0476g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0476g(parcel, classLoader);
            }

            /* renamed from: a */
            public C0476g[] newArray(int i) {
                return new C0476g[i];
            }
        };

        /* renamed from: a */
        SparseArray<Parcelable> f1911a;

        public C0476g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1911a = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f1911a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public C0476g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f1911a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f1911a.keyAt(i2);
                parcelableArr[i2] = this.f1911a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$h */
    static class C0478h implements Comparator<View> {
        C0478h() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float z = C0656u.m2643z(view);
            float z2 = C0656u.m2643z(view2);
            if (z > z2) {
                return -1;
            }
            return z < z2 ? 1 : 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getName()
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            WIDGET_PACKAGE_NAME = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x001f
            androidx.coordinatorlayout.widget.CoordinatorLayout$h r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$h
            r0.<init>()
            TOP_SORTED_CHILDREN_COMPARATOR = r0
            goto L_0x0021
        L_0x001f:
            TOP_SORTED_CHILDREN_COMPARATOR = r1
        L_0x0021:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            CONSTRUCTOR_PARAMS = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            sConstructors = r0
            androidx.core.g.e$c r0 = new androidx.core.g.e$c
            r1 = 12
            r0.<init>(r1)
            sRectPool = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0465a.C0466a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        int i3;
        TypedArray typedArray;
        AttributeSet attributeSet2;
        int[] iArr;
        Context context2;
        CoordinatorLayout coordinatorLayout;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new C0479a<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new C0651p(this);
        TypedArray obtainStyledAttributes = i == 0 ? context.obtainStyledAttributes(attributeSet, C0465a.C0468c.CoordinatorLayout, 0, C0465a.C0467b.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, C0465a.C0468c.CoordinatorLayout, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                iArr = C0465a.C0468c.CoordinatorLayout;
                i3 = 0;
                i2 = C0465a.C0467b.Widget_Support_CoordinatorLayout;
                coordinatorLayout = this;
                context2 = context;
                attributeSet2 = attributeSet;
                typedArray = obtainStyledAttributes;
            } else {
                iArr = C0465a.C0468c.CoordinatorLayout;
                i2 = 0;
                coordinatorLayout = this;
                context2 = context;
                attributeSet2 = attributeSet;
                typedArray = obtainStyledAttributes;
                i3 = i;
            }
            coordinatorLayout.saveAttributeDataForStyleable(context2, iArr, attributeSet2, typedArray, i3, i2);
        }
        int resourceId = obtainStyledAttributes.getResourceId(C0465a.C0468c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i4 = 0; i4 < length; i4++) {
                int[] iArr2 = this.mKeylines;
                iArr2[i4] = (int) (((float) iArr2[i4]) * f);
            }
        }
        this.mStatusBarBackground = obtainStyledAttributes.getDrawable(C0465a.C0468c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new C0473d());
        if (C0656u.m2619f(this) == 0) {
            C0656u.m2606b((View) this, 1);
        }
    }

    private static Rect acquireTempRect() {
        Rect a = sRectPool.mo3611a();
        return a == null ? new Rect() : a;
    }

    private static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private void constrainChildRect(C0474e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - eVar.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    private C0633ac dispatchApplyWindowInsetsToBehaviors(C0633ac acVar) {
        C0471b b;
        if (acVar.mo3789f()) {
            return acVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (C0656u.m2635r(childAt) && (b = ((C0474e) childAt.getLayoutParams()).mo3374b()) != null) {
                acVar = b.onApplyWindowInsets(this, childAt, acVar);
                if (acVar.mo3789f()) {
                    break;
                }
            }
        }
        return acVar;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, C0474e eVar, int i2, int i3) {
        int a = C0637c.m2519a(resolveAnchoredChildGravity(eVar.f1894c), i);
        int a2 = C0637c.m2519a(resolveGravity(eVar.f1895d), i);
        int i4 = a & 7;
        int i5 = a & 112;
        int i6 = a2 & 7;
        int i7 = a2 & 112;
        int width = i6 != 1 ? i6 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i7 != 16 ? i7 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i4 == 1) {
            width -= i2 / 2;
        } else if (i4 != 5) {
            width -= i2;
        }
        if (i5 == 16) {
            height -= i3 / 2;
        } else if (i5 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    private int getKeyline(int i) {
        String str;
        StringBuilder sb;
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            str = TAG;
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i);
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            str = TAG;
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e(str, sb.toString());
        return 0;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.mo3400e(view);
    }

    private void layoutChild(View view, int i) {
        C0474e eVar = (C0474e) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + eVar.leftMargin, getPaddingTop() + eVar.topMargin, (getWidth() - getPaddingRight()) - eVar.rightMargin, (getHeight() - getPaddingBottom()) - eVar.bottomMargin);
        if (this.mLastInsets != null && C0656u.m2635r(this) && !C0656u.m2635r(view)) {
            acquireTempRect.left += this.mLastInsets.mo3782a();
            acquireTempRect.top += this.mLastInsets.mo3784b();
            acquireTempRect.right -= this.mLastInsets.mo3785c();
            acquireTempRect.bottom -= this.mLastInsets.mo3786d();
        }
        Rect acquireTempRect2 = acquireTempRect();
        C0637c.m2520a(resolveGravity(eVar.f1894c), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        C0474e eVar = (C0474e) view.getLayoutParams();
        int a = C0637c.m2519a(resolveKeylineGravity(eVar.f1894c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            keyline += measuredWidth / 2;
        } else if (i3 == 5) {
            keyline += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void offsetChildByInset(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int height;
        int i3;
        if (C0656u.m2642y(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0474e eVar = (C0474e) view.getLayoutParams();
            C0471b b = eVar.mo3374b();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (b == null || !b.getInsetDodgeRect(this, view, acquireTempRect)) {
                acquireTempRect.set(acquireTempRect2);
            } else if (!acquireTempRect2.contains(acquireTempRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int a = C0637c.m2519a(eVar.f1899h, i);
            if ((a & 48) != 48 || (i3 = (acquireTempRect.top - eVar.topMargin) - eVar.f1901j) >= rect.top) {
                z = false;
            } else {
                setInsetOffsetY(view, rect.top - i3);
                z = true;
            }
            if ((a & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - eVar.bottomMargin) + eVar.f1901j) < rect.bottom) {
                setInsetOffsetY(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                setInsetOffsetY(view, 0);
            }
            if ((a & 3) != 3 || (i2 = (acquireTempRect.left - eVar.leftMargin) - eVar.f1900i) >= rect.left) {
                z2 = false;
            } else {
                setInsetOffsetX(view, rect.left - i2);
                z2 = true;
            }
            if ((a & 5) == 5 && (width = ((getWidth() - acquireTempRect.right) - eVar.rightMargin) + eVar.f1900i) < rect.right) {
                setInsetOffsetX(view, width - rect.right);
                z2 = true;
            }
            if (!z2) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    static C0471b parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            str = WIDGET_PACKAGE_NAME + FilenameUtils.EXTENSION_SEPARATOR + str;
        }
        try {
            Map map = sConstructors.get();
            if (map == null) {
                map = new HashMap();
                sConstructors.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0471b) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            C0474e eVar = (C0474e) view.getLayoutParams();
            C0471b b = eVar.mo3374b();
            if ((z || z2) && actionMasked != 0) {
                if (b != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    switch (i) {
                        case 0:
                            b.onInterceptTouchEvent(this, view, motionEvent3);
                            break;
                        case 1:
                            b.onTouchEvent(this, view, motionEvent3);
                            break;
                    }
                }
            } else {
                if (!z && b != null) {
                    switch (i) {
                        case 0:
                            z = b.onInterceptTouchEvent(this, view, motionEvent2);
                            break;
                        case 1:
                            z = b.onTouchEvent(this, view, motionEvent2);
                            break;
                    }
                    if (z) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean e = eVar.mo3379e();
                boolean a = eVar.mo3371a(this, view);
                z2 = a && !e;
                if (a && !z2) {
                    list.clear();
                    return z;
                }
            }
        }
        list.clear();
        return z;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.mo3393a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0474e resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.mo3373b(this, childAt);
            this.mChildDag.mo3394a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (resolvedLayoutParams.mo3372a(this, childAt, childAt2)) {
                        if (!this.mChildDag.mo3397b(childAt2)) {
                            this.mChildDag.mo3394a(childAt2);
                        }
                        this.mChildDag.mo3395a(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.mo3396b());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.mo3612a(rect);
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0471b b = ((C0474e) childAt.getLayoutParams()).mo3374b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    b.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    b.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0474e) getChildAt(i2).getLayoutParams()).mo3380f();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int resolveKeylineGravity(int i) {
        return i == 0 ? BadgeDrawable.TOP_END : i;
    }

    private void setInsetOffsetX(View view, int i) {
        C0474e eVar = (C0474e) view.getLayoutParams();
        if (eVar.f1900i != i) {
            C0656u.m2620f(view, i - eVar.f1900i);
            eVar.f1900i = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        C0474e eVar = (C0474e) view.getLayoutParams();
        if (eVar.f1901j != i) {
            C0656u.m2618e(view, i - eVar.f1901j);
            eVar.f1901j = i;
        }
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (C0656u.m2635r(this)) {
                if (this.mApplyWindowInsetsListener == null) {
                    this.mApplyWindowInsetsListener = new C0652q() {
                        public C0633ac onApplyWindowInsets(View view, C0633ac acVar) {
                            return CoordinatorLayout.this.setWindowInsets(acVar);
                        }
                    };
                }
                C0656u.m2595a((View) this, this.mApplyWindowInsetsListener);
                setSystemUiVisibility(1280);
                return;
            }
            C0656u.m2595a((View) this, (C0652q) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new C0475f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0474e) && super.checkLayoutParams(layoutParams);
    }

    public void dispatchDependentViewsChanged(View view) {
        List c = this.mChildDag.mo3398c(view);
        if (c != null && !c.isEmpty()) {
            for (int i = 0; i < c.size(); i++) {
                View view2 = (View) c.get(i);
                C0471b b = ((C0474e) view2.getLayoutParams()).mo3374b();
                if (b != null) {
                    b.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        getChildRect(view2, view2.getParent() != this, acquireTempRect2);
        try {
            if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left && acquireTempRect.bottom >= acquireTempRect2.top) {
                z = true;
            }
            return z;
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        C0474e eVar = (C0474e) view.getLayoutParams();
        if (eVar.f1892a != null) {
            float scrimOpacity = eVar.f1892a.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(eVar.f1892a.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z == this.mNeedsPreDrawListener) {
            return;
        }
        if (z) {
            addPreDrawListener();
        } else {
            removePreDrawListener();
        }
    }

    /* access modifiers changed from: protected */
    public C0474e generateDefaultLayoutParams() {
        return new C0474e(-2, -2);
    }

    public C0474e generateLayoutParams(AttributeSet attributeSet) {
        return new C0474e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0474e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0474e ? new C0474e((C0474e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0474e((ViewGroup.MarginLayoutParams) layoutParams) : new C0474e(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> getDependencies(View view) {
        List<View> d = this.mChildDag.mo3399d(view);
        this.mTempDependenciesList.clear();
        if (d != null) {
            this.mTempDependenciesList.addAll(d);
        }
        return this.mTempDependenciesList;
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List<View> getDependents(View view) {
        List c = this.mChildDag.mo3398c(view);
        this.mTempDependenciesList.clear();
        if (c != null) {
            this.mTempDependenciesList.addAll(c);
        }
        return this.mTempDependenciesList;
    }

    /* access modifiers changed from: package-private */
    public void getDescendantRect(View view, Rect rect) {
        C0480b.m1938b(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        C0474e eVar = (C0474e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, eVar, measuredWidth, measuredHeight);
        constrainChildRect(eVar, rect2, measuredWidth, measuredHeight);
    }

    /* access modifiers changed from: package-private */
    public void getLastChildRect(View view, Rect rect) {
        rect.set(((C0474e) view.getLayoutParams()).mo3376c());
    }

    public final C0633ac getLastWindowInsets() {
        return this.mLastInsets;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.mo3813a();
    }

    /* access modifiers changed from: package-private */
    public C0474e getResolvedLayoutParams(View view) {
        C0474e eVar = (C0474e) view.getLayoutParams();
        if (!eVar.f1893b) {
            if (view instanceof C0470a) {
                C0471b behavior = ((C0470a) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                eVar.mo3369a(behavior);
            } else {
                C0472c cVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (C0472c) cls.getAnnotation(C0472c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.mo3369a((C0471b) cVar.mo3362a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        Log.e(TAG, "Default behavior class " + cVar.mo3362a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                    }
                }
            }
            eVar.f1893b = true;
        }
        return eVar;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i, i2);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetChildToAnchor(View view, int i) {
        C0471b b;
        View view2 = view;
        C0474e eVar = (C0474e) view.getLayoutParams();
        if (eVar.f1902k != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(eVar.f1902k, acquireTempRect);
            boolean z = false;
            getChildRect(view2, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i2 = measuredHeight;
            getDesiredAnchoredChildRectWithoutConstraints(view, i, acquireTempRect, acquireTempRect3, eVar, measuredWidth, measuredHeight);
            if (!(acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top)) {
                z = true;
            }
            constrainChildRect(eVar, acquireTempRect3, measuredWidth, i2);
            int i3 = acquireTempRect3.left - acquireTempRect2.left;
            int i4 = acquireTempRect3.top - acquireTempRect2.top;
            if (i3 != 0) {
                C0656u.m2620f(view2, i3);
            }
            if (i4 != 0) {
                C0656u.m2618e(view2, i4);
            }
            if (z && (b = eVar.mo3374b()) != null) {
                b.onDependentViewChanged(this, view2, eVar.f1902k);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new C0475f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && C0656u.m2635r(this)) {
            C0656u.m2634q(this);
        }
        this.mIsAttachedToWindow = true;
    }

    /* access modifiers changed from: package-private */
    public final void onChildViewsChanged(int i) {
        boolean z;
        int i2 = i;
        int g = C0656u.m2621g(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.mDependencySortedChildren.get(i3);
            C0474e eVar = (C0474e) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (eVar.f1903l == this.mDependencySortedChildren.get(i4)) {
                        offsetChildToAnchor(view, g);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (eVar.f1898g != 0 && !acquireTempRect2.isEmpty()) {
                    int a = C0637c.m2519a(eVar.f1898g, g);
                    int i5 = a & 112;
                    if (i5 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i5 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    int i6 = a & 7;
                    if (i6 == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (i6 == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (eVar.f1899h != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, g);
                }
                if (i2 != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i7 = i3 + 1; i7 < size; i7++) {
                    View view2 = this.mDependencySortedChildren.get(i7);
                    C0474e eVar2 = (C0474e) view2.getLayoutParams();
                    C0471b b = eVar2.mo3374b();
                    if (b != null && b.layoutDependsOn(this, view2, view)) {
                        if (i2 != 0 || !eVar2.mo3381g()) {
                            if (i2 != 2) {
                                z = b.onDependentViewChanged(this, view2, view);
                            } else {
                                b.onDependentViewRemoved(this, view2, view);
                                z = true;
                            }
                            if (i2 == 1) {
                                eVar2.mo3370a(z);
                            }
                        } else {
                            eVar2.mo3382h();
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            C0633ac acVar = this.mLastInsets;
            int b = acVar != null ? acVar.mo3784b() : 0;
            if (b > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), b);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0471b b;
        int g = C0656u.m2621g(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8 && ((b = ((C0474e) view.getLayoutParams()).mo3374b()) == null || !b.onLayoutChild(this, view, g))) {
                onLayoutChild(view, g);
            }
        }
    }

    public void onLayoutChild(View view, int i) {
        C0474e eVar = (C0474e) view.getLayoutParams();
        if (eVar.mo3378d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (eVar.f1902k != null) {
            layoutChildWithAnchor(view, eVar.f1902k, i);
        } else if (eVar.f1896e >= 0) {
            layoutChildWithKeyline(view, eVar.f1896e, i);
        } else {
            layoutChild(view, i);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0119, code lost:
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L_0x0128;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.prepareChildren()
            r30.ensurePreDrawListener()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.p030h.C0656u.m2621g(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = 1
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.h.ac r3 = r7.mLastInsets
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.p030h.C0656u.m2635r(r30)
            if (r3 == 0) goto L_0x004b
            r19 = 1
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.mDependencySortedChildren
            int r6 = r2.size()
            r4 = r0
            r2 = r1
            r3 = 0
            r5 = 0
        L_0x0057:
            if (r5 >= r6) goto L_0x016e
            java.util.List<android.view.View> r0 = r7.mDependencySortedChildren
            java.lang.Object r0 = r0.get(r5)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0071
            r22 = r5
            r29 = r6
            goto L_0x0168
        L_0x0071:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0474e) r1
            int r0 = r1.f1896e
            if (r0 < 0) goto L_0x00ba
            if (r13 == 0) goto L_0x00ba
            int r0 = r1.f1896e
            int r0 = r7.getKeyline(r0)
            int r11 = r1.f1894c
            int r11 = resolveKeylineGravity(r11)
            int r11 = androidx.core.p030h.C0637c.m2519a(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r11 = 0
            goto L_0x00bf
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00bc
            if (r12 == 0) goto L_0x00bc
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00bf
        L_0x00ba:
            r22 = r2
        L_0x00bc:
            r11 = 0
            r21 = 0
        L_0x00bf:
            if (r19 == 0) goto L_0x00f1
            boolean r0 = androidx.core.p030h.C0656u.m2635r(r20)
            if (r0 != 0) goto L_0x00f1
            androidx.core.h.ac r0 = r7.mLastInsets
            int r0 = r0.mo3782a()
            androidx.core.h.ac r2 = r7.mLastInsets
            int r2 = r2.mo3785c()
            int r0 = r0 + r2
            androidx.core.h.ac r2 = r7.mLastInsets
            int r2 = r2.mo3784b()
            androidx.core.h.ac r11 = r7.mLastInsets
            int r11 = r11.mo3786d()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f5
        L_0x00f1:
            r11 = r31
            r23 = r32
        L_0x00f5:
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r0 = r1.mo3374b()
            if (r0 == 0) goto L_0x011c
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r27 = r3
            r3 = r11
            r28 = r4
            r4 = r21
            r22 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.onMeasureChild(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0135
            goto L_0x0128
        L_0x011c:
            r26 = r1
            r27 = r3
            r28 = r4
            r29 = r6
            r25 = r22
            r22 = r5
        L_0x0128:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.onMeasureChild(r1, r2, r3, r4, r5)
        L_0x0135:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            r2 = r28
            int r0 = java.lang.Math.max(r2, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r25
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r27
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r4 = r0
            r3 = r2
            r2 = r1
        L_0x0168:
            int r5 = r22 + 1
            r6 = r29
            goto L_0x0057
        L_0x016e:
            r1 = r2
            r11 = r3
            r2 = r4
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r3 = r31
            int r0 = android.view.View.resolveSizeAndState(r2, r3, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        C0471b b;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0474e eVar = (C0474e) childAt.getLayoutParams();
                if (eVar.mo3377c(0) && (b = eVar.mo3374b()) != null) {
                    z2 |= b.onNestedFling(this, childAt, view, f, f2, z);
                }
            }
        }
        if (z2) {
            onChildViewsChanged(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        C0471b b;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0474e eVar = (C0474e) childAt.getLayoutParams();
                if (eVar.mo3377c(0) && (b = eVar.mo3374b()) != null) {
                    z |= b.onNestedPreFling(this, childAt, view, f, f2);
                }
            }
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        C0471b b;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                int i7 = i3;
            } else {
                C0474e eVar = (C0474e) childAt.getLayoutParams();
                if (eVar.mo3377c(i3) && (b = eVar.mo3374b()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    b.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                    i4 = i > 0 ? Math.max(i4, this.mBehaviorConsumed[0]) : Math.min(i4, this.mBehaviorConsumed[0]);
                    i5 = i2 > 0 ? Math.max(i5, this.mBehaviorConsumed[1]) : Math.min(i5, this.mBehaviorConsumed[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        C0471b b;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0474e eVar = (C0474e) childAt.getLayoutParams();
                if (eVar.mo3377c(i5) && (b = eVar.mo3374b()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    b.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    i6 = i3 > 0 ? Math.max(i6, this.mBehaviorConsumed[0]) : Math.min(i6, this.mBehaviorConsumed[0]);
                    i7 = i4 > 0 ? Math.max(i7, this.mBehaviorConsumed[1]) : Math.min(i7, this.mBehaviorConsumed[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        C0471b b;
        this.mNestedScrollingParentHelper.mo3816a(view, view2, i, i2);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0474e eVar = (C0474e) childAt.getLayoutParams();
            if (eVar.mo3377c(i2) && (b = eVar.mo3374b()) != null) {
                b.onNestedScrollAccepted(this, childAt, view, view2, i, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0476g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0476g gVar = (C0476g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        SparseArray<Parcelable> sparseArray = gVar.f1911a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0471b b = getResolvedLayoutParams(childAt).mo3374b();
            if (!(id == -1 || b == null || (parcelable2 = sparseArray.get(id)) == null)) {
                b.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        C0476g gVar = new C0476g(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0471b b = ((C0474e) childAt.getLayoutParams()).mo3374b();
            if (!(id == -1 || b == null || (onSaveInstanceState = b.onSaveInstanceState(this, childAt)) == null)) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        gVar.f1911a = sparseArray;
        return gVar;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int i3 = i2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                C0474e eVar = (C0474e) childAt.getLayoutParams();
                C0471b b = eVar.mo3374b();
                if (b != null) {
                    boolean onStartNestedScroll = b.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    eVar.mo3367a(i3, onStartNestedScroll);
                    z |= onStartNestedScroll;
                } else {
                    eVar.mo3367a(i3, false);
                }
            }
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.mo3814a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0474e eVar = (C0474e) childAt.getLayoutParams();
            if (eVar.mo3377c(i)) {
                C0471b b = eVar.mo3374b();
                if (b != null) {
                    b.onStopNestedScroll(this, childAt, view, i);
                }
                eVar.mo3375b(i);
                eVar.mo3382h();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0474e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r6 = r6.mo3374b()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.resetTouchBehaviors(r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void recordLastChildRect(View view, Rect rect) {
        ((C0474e) view.getLayoutParams()).mo3368a(rect);
    }

    /* access modifiers changed from: package-private */
    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        C0471b b = ((C0474e) view.getLayoutParams()).mo3374b();
        if (b == null || !b.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            Drawable drawable4 = this.mStatusBarBackground;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                C0595a.m2325b(this.mStatusBarBackground, C0656u.m2621g(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            C0656u.m2617e(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0529a.m2093a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final C0633ac setWindowInsets(C0633ac acVar) {
        if (C0582c.m2256a(this.mLastInsets, acVar)) {
            return acVar;
        }
        this.mLastInsets = acVar;
        boolean z = true;
        this.mDrawStatusBarBackground = acVar != null && acVar.mo3784b() > 0;
        if (this.mDrawStatusBarBackground || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        C0633ac dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(acVar);
        requestLayout();
        return dispatchApplyWindowInsetsToBehaviors;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }
}
