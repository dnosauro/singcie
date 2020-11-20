package androidx.p053l.p054a;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.C0529a;
import androidx.core.p030h.C0610a;
import androidx.core.p030h.C0633ac;
import androidx.core.p030h.C0652q;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.p031a.C0614c;
import androidx.p035e.p036a.C0711a;
import com.parse.ParseQuery;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: androidx.l.a.b */
public class C0922b extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<C0928b> COMPARATOR = new Comparator<C0928b>() {
        /* renamed from: a */
        public int compare(C0928b bVar, C0928b bVar2) {
            return bVar.f3034b - bVar2.f3034b;
        }
    };
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final C0937j sPositionComparator = new C0937j();
    private int mActivePointerId = -1;
    C0921a mAdapter;
    private List<C0931e> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        public void run() {
            C0922b.this.setScrollState(0);
            C0922b.this.populate();
        }
    };
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private C0932f mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<C0928b> mItems = new ArrayList<>();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private C0934h mObserver;
    private int mOffscreenPageLimit = 1;
    private C0932f mOnPageChangeListener;
    private List<C0932f> mOnPageChangeListeners;
    private int mPageMargin;
    private C0933g mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final C0928b mTempItem = new C0928b();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.l.a.b$a */
    public @interface C0927a {
    }

    /* renamed from: androidx.l.a.b$b */
    static class C0928b {

        /* renamed from: a */
        Object f3033a;

        /* renamed from: b */
        int f3034b;

        /* renamed from: c */
        boolean f3035c;

        /* renamed from: d */
        float f3036d;

        /* renamed from: e */
        float f3037e;

        C0928b() {
        }
    }

    /* renamed from: androidx.l.a.b$c */
    public static class C0929c extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public boolean f3038a;

        /* renamed from: b */
        public int f3039b;

        /* renamed from: c */
        float f3040c = 0.0f;

        /* renamed from: d */
        boolean f3041d;

        /* renamed from: e */
        int f3042e;

        /* renamed from: f */
        int f3043f;

        public C0929c() {
            super(-1, -1);
        }

        public C0929c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0922b.LAYOUT_ATTRS);
            this.f3039b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.l.a.b$d */
    class C0930d extends C0610a {
        C0930d() {
        }

        /* renamed from: a */
        private boolean m3670a() {
            return C0922b.this.mAdapter != null && C0922b.this.mAdapter.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(C0922b.class.getName());
            accessibilityEvent.setScrollable(m3670a());
            if (accessibilityEvent.getEventType() == 4096 && C0922b.this.mAdapter != null) {
                accessibilityEvent.setItemCount(C0922b.this.mAdapter.getCount());
                accessibilityEvent.setFromIndex(C0922b.this.mCurItem);
                accessibilityEvent.setToIndex(C0922b.this.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0614c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.mo3716b((CharSequence) C0922b.class.getName());
            cVar.mo3741i(m3670a());
            if (C0922b.this.canScrollHorizontally(1)) {
                cVar.mo3704a(4096);
            }
            if (C0922b.this.canScrollHorizontally(-1)) {
                cVar.mo3704a((int) PKIFailureInfo.certRevoked);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            C0922b bVar;
            int i2;
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !C0922b.this.canScrollHorizontally(-1)) {
                    return false;
                }
                bVar = C0922b.this;
                i2 = bVar.mCurItem - 1;
            } else if (!C0922b.this.canScrollHorizontally(1)) {
                return false;
            } else {
                bVar = C0922b.this;
                i2 = bVar.mCurItem + 1;
            }
            bVar.setCurrentItem(i2);
            return true;
        }
    }

    /* renamed from: androidx.l.a.b$e */
    public interface C0931e {
        void onAdapterChanged(C0922b bVar, C0921a aVar, C0921a aVar2);
    }

    /* renamed from: androidx.l.a.b$f */
    public interface C0932f {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: androidx.l.a.b$g */
    public interface C0933g {
        void transformPage(View view, float f);
    }

    /* renamed from: androidx.l.a.b$h */
    private class C0934h extends DataSetObserver {
        C0934h() {
        }

        public void onChanged() {
            C0922b.this.dataSetChanged();
        }

        public void onInvalidated() {
            C0922b.this.dataSetChanged();
        }
    }

    /* renamed from: androidx.l.a.b$i */
    public static class C0935i extends C0711a {
        public static final Parcelable.Creator<C0935i> CREATOR = new Parcelable.ClassLoaderCreator<C0935i>() {
            /* renamed from: a */
            public C0935i createFromParcel(Parcel parcel) {
                return new C0935i(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public C0935i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0935i(parcel, classLoader);
            }

            /* renamed from: a */
            public C0935i[] newArray(int i) {
                return new C0935i[i];
            }
        };

        /* renamed from: a */
        int f3046a;

        /* renamed from: b */
        Parcelable f3047b;

        /* renamed from: c */
        ClassLoader f3048c;

        C0935i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f3046a = parcel.readInt();
            this.f3047b = parcel.readParcelable(classLoader);
            this.f3048c = classLoader;
        }

        public C0935i(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f3046a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3046a);
            parcel.writeParcelable(this.f3047b, i);
        }
    }

    /* renamed from: androidx.l.a.b$j */
    static class C0937j implements Comparator<View> {
        C0937j() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            C0929c cVar = (C0929c) view.getLayoutParams();
            C0929c cVar2 = (C0929c) view2.getLayoutParams();
            return cVar.f3038a != cVar2.f3038a ? cVar.f3038a ? 1 : -1 : cVar.f3042e - cVar2.f3042e;
        }
    }

    public C0922b(Context context) {
        super(context);
        initViewPager();
    }

    public C0922b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    private void calculatePageOffsets(C0928b bVar, int i, C0928b bVar2) {
        C0928b bVar3;
        C0928b bVar4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (bVar2 != null) {
            int i2 = bVar2.f3034b;
            if (i2 < bVar.f3034b) {
                float f2 = bVar2.f3037e + bVar2.f3036d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bVar.f3034b && i4 < this.mItems.size()) {
                    while (true) {
                        bVar4 = this.mItems.get(i4);
                        if (i3 > bVar4.f3034b && i4 < this.mItems.size() - 1) {
                            i4++;
                        }
                    }
                    while (i3 < bVar4.f3034b) {
                        f2 += this.mAdapter.getPageWidth(i3) + f;
                        i3++;
                    }
                    bVar4.f3037e = f2;
                    f2 += bVar4.f3036d + f;
                    i3++;
                }
            } else if (i2 > bVar.f3034b) {
                int size = this.mItems.size() - 1;
                float f3 = bVar2.f3037e;
                while (true) {
                    i2--;
                    if (i2 < bVar.f3034b || size < 0) {
                        break;
                    }
                    while (true) {
                        bVar3 = this.mItems.get(size);
                        if (i2 < bVar3.f3034b && size > 0) {
                            size--;
                        }
                    }
                    while (i2 > bVar3.f3034b) {
                        f3 -= this.mAdapter.getPageWidth(i2) + f;
                        i2--;
                    }
                    f3 -= bVar3.f3036d + f;
                    bVar3.f3037e = f3;
                }
            }
        }
        int size2 = this.mItems.size();
        float f4 = bVar.f3037e;
        int i5 = bVar.f3034b - 1;
        this.mFirstOffset = bVar.f3034b == 0 ? bVar.f3037e : -3.4028235E38f;
        int i6 = count - 1;
        this.mLastOffset = bVar.f3034b == i6 ? (bVar.f3037e + bVar.f3036d) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            C0928b bVar5 = this.mItems.get(i7);
            while (i5 > bVar5.f3034b) {
                f4 -= this.mAdapter.getPageWidth(i5) + f;
                i5--;
            }
            f4 -= bVar5.f3036d + f;
            bVar5.f3037e = f4;
            if (bVar5.f3034b == 0) {
                this.mFirstOffset = f4;
            }
            i7--;
            i5--;
        }
        float f5 = bVar.f3037e + bVar.f3036d + f;
        int i8 = bVar.f3034b + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            C0928b bVar6 = this.mItems.get(i9);
            while (i8 < bVar6.f3034b) {
                f5 += this.mAdapter.getPageWidth(i8) + f;
                i8++;
            }
            if (bVar6.f3034b == i6) {
                this.mLastOffset = (bVar6.f3036d + f5) - 1.0f;
            }
            bVar6.f3037e = f5;
            f5 += bVar6.f3036d + f;
            i9++;
            i8++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (int i = 0; i < this.mItems.size(); i++) {
            C0928b bVar = this.mItems.get(i);
            if (bVar.f3035c) {
                bVar.f3035c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            C0656u.m2597a((View) this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i += (int) (f + (i >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= 0) {
            return i;
        }
        ArrayList<C0928b> arrayList = this.mItems;
        return Math.max(this.mItems.get(0).f3034b, Math.min(i, arrayList.get(arrayList.size() - 1).f3034b));
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        C0932f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.onPageScrolled(i, f, i2);
        }
        List<C0932f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0932f fVar2 = this.mOnPageChangeListeners.get(i3);
                if (fVar2 != null) {
                    fVar2.onPageScrolled(i, f, i2);
                }
            }
        }
        C0932f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        C0932f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.onPageSelected(i);
        }
        List<C0932f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0932f fVar2 = this.mOnPageChangeListeners.get(i2);
                if (fVar2 != null) {
                    fVar2.onPageSelected(i);
                }
            }
        }
        C0932f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.onPageSelected(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        C0932f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.onPageScrollStateChanged(i);
        }
        List<C0932f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0932f fVar2 = this.mOnPageChangeListeners.get(i2);
                if (fVar2 != null) {
                    fVar2.onPageScrollStateChanged(i);
                }
            }
        }
        C0932f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.onPageScrollStateChanged(i);
        }
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.mPageTransformerLayerType : 0, (Paint) null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private C0928b infoForCurrentScrollPosition() {
        int i;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        C0928b bVar = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.mItems.size()) {
            C0928b bVar2 = this.mItems.get(i2);
            if (!z && bVar2.f3034b != (i = i3 + 1)) {
                bVar2 = this.mTempItem;
                bVar2.f3037e = f2 + f3 + f;
                bVar2.f3034b = i;
                bVar2.f3036d = this.mAdapter.getPageWidth(bVar2.f3034b);
                i2--;
            }
            f2 = bVar2.f3037e;
            float f4 = bVar2.f3036d + f2 + f;
            if (!z && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f4 || i2 == this.mItems.size() - 1) {
                return bVar2;
            }
            i3 = bVar2.f3034b;
            f3 = bVar2.f3036d;
            i2++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(C0927a.class) != null;
    }

    private boolean isGutterDrag(float f, float f2) {
        return (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            C0928b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin;
            int i3 = clientWidth + i2;
            float f = (float) clientWidth;
            int i4 = infoForCurrentScrollPosition.f3034b;
            float f2 = ((((float) i) / f) - infoForCurrentScrollPosition.f3037e) / (infoForCurrentScrollPosition.f3036d + (((float) i2) / f));
            this.mCalledSuper = false;
            onPageScrolled(i4, f2, (int) (((float) i3) * f2));
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        boolean z2;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = ((float) getScrollX()) + f2;
        float clientWidth = (float) getClientWidth();
        float f3 = this.mFirstOffset * clientWidth;
        float f4 = this.mLastOffset * clientWidth;
        boolean z3 = false;
        C0928b bVar = this.mItems.get(0);
        ArrayList<C0928b> arrayList = this.mItems;
        C0928b bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f3034b != 0) {
            f3 = bVar.f3037e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f3034b != this.mAdapter.getCount() - 1) {
            f4 = bVar2.f3037e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.mLastMotionX += scrollX - ((float) i);
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z3;
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        int min;
        if (i2 <= 0 || this.mItems.isEmpty()) {
            C0928b infoForPosition = infoForPosition(this.mCurItem);
            min = (int) ((infoForPosition != null ? Math.min(infoForPosition.f3037e, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
            } else {
                return;
            }
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)));
        }
        scrollTo(min, getScrollY());
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0929c) getChildAt(i).getLayoutParams()).f3038a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        C0928b infoForPosition = infoForPosition(i);
        int clientWidth = infoForPosition != null ? (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.f3037e, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C0928b infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f3034b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    /* access modifiers changed from: package-private */
    public C0928b addNewItem(int i, int i2) {
        C0928b bVar = new C0928b();
        bVar.f3034b = i;
        bVar.f3033a = this.mAdapter.instantiateItem((ViewGroup) this, i);
        bVar.f3036d = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(bVar);
        } else {
            this.mItems.add(i2, bVar);
        }
        return bVar;
    }

    public void addOnAdapterChangeListener(C0931e eVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(eVar);
    }

    public void addOnPageChangeListener(C0932f fVar) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(fVar);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        C0928b infoForChild;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f3034b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0929c cVar = (C0929c) layoutParams;
        cVar.f3038a |= isDecorView(view);
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams);
        } else if (cVar == null || !cVar.f3038a) {
            cVar.f3041d = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public boolean arrowScroll(int i) {
        boolean pageRight;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                int i3 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view != null && i2 >= i3) {
                    pageRight = pageLeft();
                    z2 = pageRight;
                }
            } else if (i == 66) {
                int i4 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                int i5 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view != null && i4 <= i5) {
                    pageRight = pageRight();
                    z2 = pageRight;
                }
            }
            pageRight = findNextFocus.requestFocus();
            z2 = pageRight;
        } else if (i == 17 || i == 1) {
            z2 = pageLeft();
        } else if (i == 66 || i == 2) {
            z2 = pageRight();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    public boolean canScrollHorizontally(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.mFirstOffset)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0929c) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<C0932f> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        C0656u.m2617e(this);
    }

    /* access modifiers changed from: package-private */
    public void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i = this.mCurItem;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mItems.size()) {
            C0928b bVar = this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(bVar.f3033a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, bVar.f3034b, bVar.f3033a);
                    if (this.mCurItem == bVar.f3034b) {
                        i = Math.max(0, Math.min(this.mCurItem, count - 1));
                    }
                } else if (bVar.f3034b != itemPosition) {
                    if (bVar.f3034b == this.mCurItem) {
                        i = itemPosition;
                    }
                    bVar.f3034b = itemPosition;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                C0929c cVar = (C0929c) getChildAt(i3).getLayoutParams();
                if (!cVar.f3038a) {
                    cVar.f3040c = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0928b infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f3034b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    public void draw(Canvas canvas) {
        C0921a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.mAdapter) != null && aVar.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                z = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width2));
                this.mRightEdge.setSize(height2, width2);
                z |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z) {
            C0656u.m2617e(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(ParseQuery.MAX_LIMIT, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C0928b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f3034b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f3037e) / infoForCurrentScrollPosition.f3036d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return arrowScroll(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean executeKeyEvent(android.view.KeyEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            if (r0 != 0) goto L_0x004a
            int r0 = r4.getKeyCode()
            r1 = 61
            r2 = 2
            if (r0 == r1) goto L_0x0033
            switch(r0) {
                case 21: goto L_0x0021;
                case 22: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x004a
        L_0x0013:
            boolean r4 = r4.hasModifiers(r2)
            if (r4 == 0) goto L_0x001e
            boolean r4 = r3.pageRight()
            goto L_0x004b
        L_0x001e:
            r4 = 66
            goto L_0x002e
        L_0x0021:
            boolean r4 = r4.hasModifiers(r2)
            if (r4 == 0) goto L_0x002c
            boolean r4 = r3.pageLeft()
            goto L_0x004b
        L_0x002c:
            r4 = 17
        L_0x002e:
            boolean r4 = r3.arrowScroll(r4)
            goto L_0x004b
        L_0x0033:
            boolean r0 = r4.hasNoModifiers()
            if (r0 == 0) goto L_0x003e
            boolean r4 = r3.arrowScroll(r2)
            goto L_0x004b
        L_0x003e:
            r0 = 1
            boolean r4 = r4.hasModifiers(r0)
            if (r4 == 0) goto L_0x004a
            boolean r4 = r3.arrowScroll(r0)
            goto L_0x004b
        L_0x004a:
            r4 = 0
        L_0x004b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p053l.p054a.C0922b.executeKeyEvent(android.view.KeyEvent):boolean");
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            float clientWidth = (float) getClientWidth();
            float f2 = this.mFirstOffset * clientWidth;
            float f3 = this.mLastOffset * clientWidth;
            C0928b bVar = this.mItems.get(0);
            ArrayList<C0928b> arrayList = this.mItems;
            C0928b bVar2 = arrayList.get(arrayList.size() - 1);
            if (bVar.f3034b != 0) {
                f2 = bVar.f3037e * clientWidth;
            }
            if (bVar2.f3034b != this.mAdapter.getCount() - 1) {
                f3 = bVar2.f3037e * clientWidth;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i);
            scrollTo(i, getScrollY());
            pageScrolled(i);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0929c();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0929c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public C0921a getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0929c) this.mDrawingOrderedChildren.get(i2).getLayoutParams()).f3043f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    /* access modifiers changed from: package-private */
    public C0928b infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    public C0928b infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            C0928b bVar = this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, bVar.f3033a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public C0928b infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            C0928b bVar = this.mItems.get(i2);
            if (bVar.f3034b == i) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(PKIFailureInfo.transactionIdInUse);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (f * 16.0f);
        C0656u.m2594a((View) this, (C0610a) new C0930d());
        if (C0656u.m2619f(this) == 0) {
            C0656u.m2606b((View) this, 1);
        }
        C0656u.m2595a((View) this, (C0652q) new C0652q() {

            /* renamed from: b */
            private final Rect f3032b = new Rect();

            public C0633ac onApplyWindowInsets(View view, C0633ac acVar) {
                C0633ac a = C0656u.m2581a(view, acVar);
                if (a.mo3789f()) {
                    return a;
                }
                Rect rect = this.f3032b;
                rect.left = a.mo3782a();
                rect.top = a.mo3784b();
                rect.right = a.mo3785c();
                rect.bottom = a.mo3786d();
                int childCount = C0922b.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    C0633ac b = C0656u.m2605b(C0922b.this.getChildAt(i), a);
                    rect.left = Math.min(b.mo3782a(), rect.left);
                    rect.top = Math.min(b.mo3784b(), rect.top);
                    rect.right = Math.min(b.mo3785c(), rect.right);
                    rect.bottom = Math.min(b.mo3786d(), rect.bottom);
                }
                return a.mo3783a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f4 = (float) width;
            float f5 = ((float) this.mPageMargin) / f4;
            int i = 0;
            C0928b bVar = this.mItems.get(0);
            float f6 = bVar.f3037e;
            int size = this.mItems.size();
            int i2 = bVar.f3034b;
            int i3 = this.mItems.get(size - 1).f3034b;
            while (i2 < i3) {
                while (i2 > bVar.f3034b && i < size) {
                    i++;
                    bVar = this.mItems.get(i);
                }
                if (i2 == bVar.f3034b) {
                    f2 = (bVar.f3037e + bVar.f3036d) * f4;
                    f = bVar.f3037e + bVar.f3036d + f5;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i2);
                    f = f6 + pageWidth + f5;
                    f2 = (f6 + pageWidth) * f4;
                }
                if (((float) this.mPageMargin) + f2 > ((float) scrollX)) {
                    f3 = f5;
                    this.mMarginDrawable.setBounds(Math.round(f2), this.mTopPageBounds, Math.round(((float) this.mPageMargin) + f2), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollX + width))) {
                    i2++;
                    f6 = f;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent2.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.mActivePointerId;
            if (i != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i);
                float x2 = motionEvent2.getX(findPointerIndex);
                float f = x2 - this.mLastMotionX;
                float abs = Math.abs(f);
                float y2 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 != 0 && !isGutterDrag(this.mLastMotionX, f)) {
                    if (canScroll(this, false, (int) f, (int) x2, (int) y2)) {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                if (abs > ((float) this.mTouchSlop) && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    this.mLastMotionX = i2 > 0 ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                    this.mLastMotionY = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.mTouchSlop)) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x2)) {
                    C0656u.m2617e(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        return this.mIsBeingDragged;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        C0928b infoForChild;
        int i5;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = paddingBottom;
        int i10 = 0;
        int i11 = paddingTop;
        int i12 = paddingLeft;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                C0929c cVar = (C0929c) childAt.getLayoutParams();
                if (cVar.f3038a) {
                    int i14 = cVar.f3039b & 7;
                    int i15 = cVar.f3039b & 112;
                    if (i14 == 1) {
                        i5 = Math.max((i7 - childAt.getMeasuredWidth()) / 2, i12);
                    } else if (i14 == 3) {
                        i5 = i12;
                        i12 = childAt.getMeasuredWidth() + i12;
                    } else if (i14 != 5) {
                        i5 = i12;
                    } else {
                        i5 = (i7 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i15 == 16) {
                        i6 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, i11);
                    } else if (i15 == 48) {
                        i6 = i11;
                        i11 = childAt.getMeasuredHeight() + i11;
                    } else if (i15 != 80) {
                        i6 = i11;
                    } else {
                        i6 = (i8 - i9) - childAt.getMeasuredHeight();
                        i9 += childAt.getMeasuredHeight();
                    }
                    int i16 = i5 + scrollX;
                    childAt.layout(i16, i6, childAt.getMeasuredWidth() + i16, i6 + childAt.getMeasuredHeight());
                    i10++;
                }
            }
        }
        int i17 = (i7 - i12) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                C0929c cVar2 = (C0929c) childAt2.getLayoutParams();
                if (!cVar2.f3038a && (infoForChild = infoForChild(childAt2)) != null) {
                    float f = (float) i17;
                    int i19 = ((int) (infoForChild.f3037e * f)) + i12;
                    if (cVar2.f3041d) {
                        cVar2.f3041d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * cVar2.f3040c), 1073741824), View.MeasureSpec.makeMeasureSpec((i8 - i11) - i9, 1073741824));
                    }
                    childAt2.layout(i19, i11, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + i11);
                }
            }
        }
        this.mTopPageBounds = i11;
        this.mBottomPageBounds = i8 - i9;
        this.mDecorChildCount = i10;
        if (this.mFirstLayout) {
            z2 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r2 = r17
            int r2 = getDefaultSize(r1, r2)
            r3 = r18
            int r3 = getDefaultSize(r1, r3)
            r0.setMeasuredDimension(r2, r3)
            int r2 = r16.getMeasuredWidth()
            int r3 = r2 / 10
            int r4 = r0.mDefaultGutterSize
            int r3 = java.lang.Math.min(r3, r4)
            r0.mGutterSize = r3
            int r3 = r16.getPaddingLeft()
            int r2 = r2 - r3
            int r3 = r16.getPaddingRight()
            int r2 = r2 - r3
            int r3 = r16.getMeasuredHeight()
            int r4 = r16.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r16.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r16.getChildCount()
            r5 = r3
            r3 = r2
            r2 = 0
        L_0x003f:
            r6 = 8
            r7 = 1
            r8 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r4) goto L_0x00c7
            android.view.View r9 = r0.getChildAt(r2)
            int r10 = r9.getVisibility()
            if (r10 == r6) goto L_0x00c2
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            androidx.l.a.b$c r6 = (androidx.p053l.p054a.C0922b.C0929c) r6
            if (r6 == 0) goto L_0x00c2
            boolean r10 = r6.f3038a
            if (r10 == 0) goto L_0x00c2
            int r10 = r6.f3039b
            r10 = r10 & 7
            int r11 = r6.f3039b
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 48
            if (r11 == r12) goto L_0x006f
            r12 = 80
            if (r11 != r12) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r11 = 0
            goto L_0x0070
        L_0x006f:
            r11 = 1
        L_0x0070:
            r12 = 3
            if (r10 == r12) goto L_0x0078
            r12 = 5
            if (r10 != r12) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x007f
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0084
        L_0x007f:
            if (r7 == 0) goto L_0x0084
            r12 = 1073741824(0x40000000, float:2.0)
            goto L_0x0086
        L_0x0084:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0086:
            int r13 = r6.width
            r14 = -1
            r15 = -2
            if (r13 == r15) goto L_0x0098
            int r10 = r6.width
            if (r10 == r14) goto L_0x0094
            int r10 = r6.width
            r13 = r10
            goto L_0x0095
        L_0x0094:
            r13 = r3
        L_0x0095:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0099
        L_0x0098:
            r13 = r3
        L_0x0099:
            int r1 = r6.height
            if (r1 == r15) goto L_0x00a6
            int r1 = r6.height
            if (r1 == r14) goto L_0x00a4
            int r1 = r6.height
            goto L_0x00a8
        L_0x00a4:
            r1 = r5
            goto L_0x00a8
        L_0x00a6:
            r1 = r5
            r8 = r12
        L_0x00a8:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            r9.measure(r6, r1)
            if (r11 == 0) goto L_0x00bb
            int r1 = r9.getMeasuredHeight()
            int r5 = r5 - r1
            goto L_0x00c2
        L_0x00bb:
            if (r7 == 0) goto L_0x00c2
            int r1 = r9.getMeasuredWidth()
            int r3 = r3 - r1
        L_0x00c2:
            int r2 = r2 + 1
            r1 = 0
            goto L_0x003f
        L_0x00c7:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r8)
            r0.mChildWidthMeasureSpec = r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            r0.mChildHeightMeasureSpec = r1
            r0.mInLayout = r7
            r16.populate()
            r1 = 0
            r0.mInLayout = r1
            int r2 = r16.getChildCount()
        L_0x00df:
            if (r1 >= r2) goto L_0x0109
            android.view.View r4 = r0.getChildAt(r1)
            int r5 = r4.getVisibility()
            if (r5 == r6) goto L_0x0106
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            androidx.l.a.b$c r5 = (androidx.p053l.p054a.C0922b.C0929c) r5
            if (r5 == 0) goto L_0x00f7
            boolean r7 = r5.f3038a
            if (r7 != 0) goto L_0x0106
        L_0x00f7:
            float r7 = (float) r3
            float r5 = r5.f3040c
            float r7 = r7 * r5
            int r5 = (int) r7
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r7 = r0.mChildHeightMeasureSpec
            r4.measure(r5, r7)
        L_0x0106:
            int r1 = r1 + 1
            goto L_0x00df
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p053l.p054a.C0922b.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageScrolled(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.mDecorChildCount
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L_0x001d:
            if (r3 >= r6) goto L_0x006d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.l.a.b$c r9 = (androidx.p053l.p054a.C0922b.C0929c) r9
            boolean r10 = r9.f3038a
            if (r10 != 0) goto L_0x002e
            goto L_0x006a
        L_0x002e:
            int r9 = r9.f3039b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004f
            r10 = 3
            if (r9 == r10) goto L_0x0049
            r10 = 5
            if (r9 == r10) goto L_0x003c
            r9 = r4
            goto L_0x005e
        L_0x003c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L_0x005b
        L_0x0049:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L_0x005e
        L_0x004f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L_0x005b:
            r11 = r9
            r9 = r4
            r4 = r11
        L_0x005e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L_0x0069
            r8.offsetLeftAndRight(r4)
        L_0x0069:
            r4 = r9
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x006d:
            r12.dispatchOnPageScrolled(r13, r14, r15)
            androidx.l.a.b$g r13 = r12.mPageTransformer
            if (r13 == 0) goto L_0x00a1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007c:
            if (r1 >= r14) goto L_0x00a1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.l.a.b$c r0 = (androidx.p053l.p054a.C0922b.C0929c) r0
            boolean r0 = r0.f3038a
            if (r0 == 0) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.l.a.b$g r3 = r12.mPageTransformer
            r3.transformPage(r15, r0)
        L_0x009e:
            int r1 = r1 + 1
            goto L_0x007c
        L_0x00a1:
            r12.mCalledSuper = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p053l.p054a.C0922b.onPageScrolled(int, float, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        C0928b infoForChild;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = childCount - 1;
            i2 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f3034b == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i3 += i2;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0935i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0935i iVar = (C0935i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        C0921a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.restoreState(iVar.f3047b, iVar.f3048c);
            setCurrentItemInternal(iVar.f3046a, false, true);
            return;
        }
        this.mRestoredCurItem = iVar.f3046a;
        this.mRestoredAdapterState = iVar.f3047b;
        this.mRestoredClassLoader = iVar.f3048c;
    }

    public Parcelable onSaveInstanceState() {
        C0935i iVar = new C0935i(super.onSaveInstanceState());
        iVar.f3046a = this.mCurItem;
        C0921a aVar = this.mAdapter;
        if (aVar != null) {
            iVar.f3047b = aVar.saveState();
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.mPageMargin;
            recomputeScrollPosition(i, i3, i5, i5);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011d, code lost:
        r2 = resetTouch();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.mFakeDragging
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r8.getAction()
            r2 = 0
            if (r0 != 0) goto L_0x0014
            int r0 = r8.getEdgeFlags()
            if (r0 == 0) goto L_0x0014
            return r2
        L_0x0014:
            androidx.l.a.a r0 = r7.mAdapter
            if (r0 == 0) goto L_0x0148
            int r0 = r0.getCount()
            if (r0 != 0) goto L_0x0020
            goto L_0x0148
        L_0x0020:
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            if (r0 != 0) goto L_0x002a
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r7.mVelocityTracker = r0
        L_0x002a:
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            r0.addMovement(r8)
            int r0 = r8.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            switch(r0) {
                case 0: goto L_0x0122;
                case 1: goto L_0x00d5;
                case 2: goto L_0x0066;
                case 3: goto L_0x005b;
                case 4: goto L_0x0038;
                case 5: goto L_0x004b;
                case 6: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x0142
        L_0x003a:
            r7.onSecondaryPointerUp(r8)
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            float r8 = r8.getX(r0)
            r7.mLastMotionX = r8
            goto L_0x0142
        L_0x004b:
            int r0 = r8.getActionIndex()
            float r3 = r8.getX(r0)
            r7.mLastMotionX = r3
            int r8 = r8.getPointerId(r0)
            goto L_0x0140
        L_0x005b:
            boolean r8 = r7.mIsBeingDragged
            if (r8 == 0) goto L_0x0142
            int r8 = r7.mCurItem
            r7.scrollToItem(r8, r1, r2, r2)
            goto L_0x011d
        L_0x0066:
            boolean r0 = r7.mIsBeingDragged
            if (r0 != 0) goto L_0x00c1
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            r3 = -1
            if (r0 != r3) goto L_0x0075
            goto L_0x011d
        L_0x0075:
            float r3 = r8.getX(r0)
            float r4 = r7.mLastMotionX
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            float r0 = r8.getY(r0)
            float r5 = r7.mLastMotionY
            float r5 = r0 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r7.mTouchSlop
            float r6 = (float) r6
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c1
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00c1
            r7.mIsBeingDragged = r1
            r7.requestParentDisallowInterceptTouchEvent(r1)
            float r4 = r7.mInitialMotionX
            float r3 = r3 - r4
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00aa
            int r3 = r7.mTouchSlop
            float r3 = (float) r3
            float r4 = r4 + r3
            goto L_0x00ae
        L_0x00aa:
            int r3 = r7.mTouchSlop
            float r3 = (float) r3
            float r4 = r4 - r3
        L_0x00ae:
            r7.mLastMotionX = r4
            r7.mLastMotionY = r0
            r7.setScrollState(r1)
            r7.setScrollingCacheEnabled(r1)
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto L_0x00c1
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x00c1:
            boolean r0 = r7.mIsBeingDragged
            if (r0 == 0) goto L_0x0142
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            float r8 = r8.getX(r0)
            boolean r8 = r7.performDrag(r8)
            r2 = r2 | r8
            goto L_0x0142
        L_0x00d5:
            boolean r0 = r7.mIsBeingDragged
            if (r0 == 0) goto L_0x0142
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = r7.mMaximumVelocity
            float r3 = (float) r3
            r0.computeCurrentVelocity(r2, r3)
            int r2 = r7.mActivePointerId
            float r0 = r0.getXVelocity(r2)
            int r0 = (int) r0
            r7.mPopulatePending = r1
            int r2 = r7.getClientWidth()
            int r3 = r7.getScrollX()
            androidx.l.a.b$b r4 = r7.infoForCurrentScrollPosition()
            int r5 = r7.mPageMargin
            float r5 = (float) r5
            float r2 = (float) r2
            float r5 = r5 / r2
            int r6 = r4.f3034b
            float r3 = (float) r3
            float r3 = r3 / r2
            float r2 = r4.f3037e
            float r3 = r3 - r2
            float r2 = r4.f3036d
            float r2 = r2 + r5
            float r3 = r3 / r2
            int r2 = r7.mActivePointerId
            int r2 = r8.findPointerIndex(r2)
            float r8 = r8.getX(r2)
            float r2 = r7.mInitialMotionX
            float r8 = r8 - r2
            int r8 = (int) r8
            int r8 = r7.determineTargetPage(r6, r3, r0, r8)
            r7.setCurrentItemInternal(r8, r1, r1, r0)
        L_0x011d:
            boolean r2 = r7.resetTouch()
            goto L_0x0142
        L_0x0122:
            android.widget.Scroller r0 = r7.mScroller
            r0.abortAnimation()
            r7.mPopulatePending = r2
            r7.populate()
            float r0 = r8.getX()
            r7.mInitialMotionX = r0
            r7.mLastMotionX = r0
            float r0 = r8.getY()
            r7.mInitialMotionY = r0
            r7.mLastMotionY = r0
            int r8 = r8.getPointerId(r2)
        L_0x0140:
            r7.mActivePointerId = r8
        L_0x0142:
            if (r2 == 0) goto L_0x0147
            androidx.core.p030h.C0656u.m2617e(r7)
        L_0x0147:
            return r1
        L_0x0148:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p053l.p054a.C0922b.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean pageLeft() {
        int i = this.mCurItem;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pageRight() {
        C0921a aVar = this.mAdapter;
        if (aVar == null || this.mCurItem >= aVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void populate() {
        populate(this.mCurItem);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (r8.f3034b == r0.mCurItem) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c7, code lost:
        if (r15 >= 0) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d5, code lost:
        if (r15 >= 0) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e3, code lost:
        if (r15 >= 0) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ee, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0143, code lost:
        if (r4 < r0.mItems.size()) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x014e, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0161, code lost:
        if (r4 < r0.mItems.size()) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0173, code lost:
        if (r4 < r0.mItems.size()) goto L_0x0145;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populate(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.mCurItem
            if (r2 == r1) goto L_0x000f
            androidx.l.a.b$b r2 = r0.infoForPosition(r2)
            r0.mCurItem = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.l.a.a r1 = r0.mAdapter
            if (r1 != 0) goto L_0x0018
            r17.sortChildDrawingOrder()
            return
        L_0x0018:
            boolean r1 = r0.mPopulatePending
            if (r1 == 0) goto L_0x0020
            r17.sortChildDrawingOrder()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.l.a.a r1 = r0.mAdapter
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.mOffscreenPageLimit
            int r4 = r0.mCurItem
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.l.a.a r6 = r0.mAdapter
            int r6 = r6.getCount()
            int r7 = r6 + -1
            int r8 = r0.mCurItem
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.mExpectedAdapterCount
            if (r6 != r7) goto L_0x01f6
            r7 = 0
        L_0x004a:
            java.util.ArrayList<androidx.l.a.b$b> r8 = r0.mItems
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x006a
            java.util.ArrayList<androidx.l.a.b$b> r8 = r0.mItems
            java.lang.Object r8 = r8.get(r7)
            androidx.l.a.b$b r8 = (androidx.p053l.p054a.C0922b.C0928b) r8
            int r9 = r8.f3034b
            int r10 = r0.mCurItem
            if (r9 < r10) goto L_0x0067
            int r9 = r8.f3034b
            int r10 = r0.mCurItem
            if (r9 != r10) goto L_0x006a
            goto L_0x006b
        L_0x0067:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x006a:
            r8 = 0
        L_0x006b:
            if (r8 != 0) goto L_0x0075
            if (r6 <= 0) goto L_0x0075
            int r8 = r0.mCurItem
            androidx.l.a.b$b r8 = r0.addNewItem(r8, r7)
        L_0x0075:
            r9 = 0
            if (r8 == 0) goto L_0x0183
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0085
            java.util.ArrayList<androidx.l.a.b$b> r11 = r0.mItems
            java.lang.Object r11 = r11.get(r10)
            androidx.l.a.b$b r11 = (androidx.p053l.p054a.C0922b.C0928b) r11
            goto L_0x0086
        L_0x0085:
            r11 = 0
        L_0x0086:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x0090
            r3 = 0
            goto L_0x009d
        L_0x0090:
            float r14 = r8.f3036d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r3 = r14 + r15
        L_0x009d:
            int r14 = r0.mCurItem
            int r14 = r14 + -1
            r15 = r10
            r10 = r7
            r7 = 0
        L_0x00a4:
            if (r14 < 0) goto L_0x00f4
            int r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00ca
            if (r14 >= r4) goto L_0x00ca
            if (r11 != 0) goto L_0x00af
            goto L_0x00f4
        L_0x00af:
            int r5 = r11.f3034b
            if (r14 != r5) goto L_0x00f0
            boolean r5 = r11.f3035c
            if (r5 != 0) goto L_0x00f0
            java.util.ArrayList<androidx.l.a.b$b> r5 = r0.mItems
            r5.remove(r15)
            androidx.l.a.a r5 = r0.mAdapter
            java.lang.Object r11 = r11.f3033a
            r5.destroyItem((android.view.ViewGroup) r0, (int) r14, (java.lang.Object) r11)
            int r15 = r15 + -1
            int r10 = r10 + -1
            if (r15 < 0) goto L_0x00ee
            goto L_0x00e5
        L_0x00ca:
            if (r11 == 0) goto L_0x00d8
            int r5 = r11.f3034b
            if (r14 != r5) goto L_0x00d8
            float r5 = r11.f3036d
            float r7 = r7 + r5
            int r15 = r15 + -1
            if (r15 < 0) goto L_0x00ee
            goto L_0x00e5
        L_0x00d8:
            int r5 = r15 + 1
            androidx.l.a.b$b r5 = r0.addNewItem(r14, r5)
            float r5 = r5.f3036d
            float r7 = r7 + r5
            int r10 = r10 + 1
            if (r15 < 0) goto L_0x00ee
        L_0x00e5:
            java.util.ArrayList<androidx.l.a.b$b> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r15)
            androidx.l.a.b$b r5 = (androidx.p053l.p054a.C0922b.C0928b) r5
            goto L_0x00ef
        L_0x00ee:
            r5 = 0
        L_0x00ef:
            r11 = r5
        L_0x00f0:
            int r14 = r14 + -1
            r5 = 0
            goto L_0x00a4
        L_0x00f4:
            float r3 = r8.f3036d
            int r4 = r10 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0177
            java.util.ArrayList<androidx.l.a.b$b> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x010d
            java.util.ArrayList<androidx.l.a.b$b> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.l.a.b$b r5 = (androidx.p053l.p054a.C0922b.C0928b) r5
            goto L_0x010e
        L_0x010d:
            r5 = 0
        L_0x010e:
            if (r12 > 0) goto L_0x0112
            r7 = 0
            goto L_0x011a
        L_0x0112:
            int r7 = r17.getPaddingRight()
            float r7 = (float) r7
            float r11 = (float) r12
            float r7 = r7 / r11
            float r7 = r7 + r13
        L_0x011a:
            int r11 = r0.mCurItem
        L_0x011c:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x0177
            int r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r12 < 0) goto L_0x0150
            if (r11 <= r1) goto L_0x0150
            if (r5 != 0) goto L_0x0129
            goto L_0x0177
        L_0x0129:
            int r12 = r5.f3034b
            if (r11 != r12) goto L_0x0176
            boolean r12 = r5.f3035c
            if (r12 != 0) goto L_0x0176
            java.util.ArrayList<androidx.l.a.b$b> r12 = r0.mItems
            r12.remove(r4)
            androidx.l.a.a r12 = r0.mAdapter
            java.lang.Object r5 = r5.f3033a
            r12.destroyItem((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r5)
            java.util.ArrayList<androidx.l.a.b$b> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x014e
        L_0x0145:
            java.util.ArrayList<androidx.l.a.b$b> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.l.a.b$b r5 = (androidx.p053l.p054a.C0922b.C0928b) r5
            goto L_0x0176
        L_0x014e:
            r5 = 0
            goto L_0x0176
        L_0x0150:
            if (r5 == 0) goto L_0x0164
            int r12 = r5.f3034b
            if (r11 != r12) goto L_0x0164
            float r5 = r5.f3036d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.l.a.b$b> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x014e
            goto L_0x0145
        L_0x0164:
            androidx.l.a.b$b r5 = r0.addNewItem(r11, r4)
            int r4 = r4 + 1
            float r5 = r5.f3036d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.l.a.b$b> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x014e
            goto L_0x0145
        L_0x0176:
            goto L_0x011c
        L_0x0177:
            r0.calculatePageOffsets(r8, r10, r2)
            androidx.l.a.a r1 = r0.mAdapter
            int r2 = r0.mCurItem
            java.lang.Object r3 = r8.f3033a
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
        L_0x0183:
            androidx.l.a.a r1 = r0.mAdapter
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x018d:
            if (r2 >= r1) goto L_0x01b6
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.l.a.b$c r4 = (androidx.p053l.p054a.C0922b.C0929c) r4
            r4.f3043f = r2
            boolean r5 = r4.f3038a
            if (r5 != 0) goto L_0x01b3
            float r5 = r4.f3040c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01b3
            androidx.l.a.b$b r3 = r0.infoForChild(r3)
            if (r3 == 0) goto L_0x01b3
            float r5 = r3.f3036d
            r4.f3040c = r5
            int r3 = r3.f3034b
            r4.f3042e = r3
        L_0x01b3:
            int r2 = r2 + 1
            goto L_0x018d
        L_0x01b6:
            r17.sortChildDrawingOrder()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x01f5
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01ca
            androidx.l.a.b$b r3 = r0.infoForAnyChild(r1)
            goto L_0x01cb
        L_0x01ca:
            r3 = 0
        L_0x01cb:
            if (r3 == 0) goto L_0x01d3
            int r1 = r3.f3034b
            int r2 = r0.mCurItem
            if (r1 == r2) goto L_0x01f5
        L_0x01d3:
            r1 = 0
        L_0x01d4:
            int r2 = r17.getChildCount()
            if (r1 >= r2) goto L_0x01f5
            android.view.View r2 = r0.getChildAt(r1)
            androidx.l.a.b$b r3 = r0.infoForChild(r2)
            if (r3 == 0) goto L_0x01f2
            int r3 = r3.f3034b
            int r4 = r0.mCurItem
            if (r3 != r4) goto L_0x01f2
            r3 = 2
            boolean r2 = r2.requestFocus(r3)
            if (r2 == 0) goto L_0x01f2
            goto L_0x01f5
        L_0x01f2:
            int r1 = r1 + 1
            goto L_0x01d4
        L_0x01f5:
            return
        L_0x01f6:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0203 }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0203 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0203 }
            goto L_0x020b
        L_0x0203:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x020b:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.mExpectedAdapterCount
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.l.a.a r1 = r0.mAdapter
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p053l.p054a.C0922b.populate(int):void");
    }

    public void removeOnAdapterChangeListener(C0931e eVar) {
        List<C0931e> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(eVar);
        }
    }

    public void removeOnPageChangeListener(C0932f fVar) {
        List<C0932f> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(fVar);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(C0921a aVar) {
        C0921a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.setViewPagerObserver((DataSetObserver) null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                C0928b bVar = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, bVar.f3034b, bVar.f3033a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        C0921a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new C0934h();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<C0931e> list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mAdapterChangeListeners.get(i2).onAdapterChanged(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        C0921a aVar = this.mAdapter;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            boolean z3 = true;
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() - 1;
            }
            int i3 = this.mOffscreenPageLimit;
            int i4 = this.mCurItem;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                    this.mItems.get(i5).f3035c = true;
                }
            }
            if (this.mCurItem == i) {
                z3 = false;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3) {
                    dispatchOnPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public C0932f setInternalPageChangeListener(C0932f fVar) {
        C0932f fVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = fVar;
        return fVar2;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(C0932f fVar) {
        this.mOnPageChangeListener = fVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(C0529a.m2093a(getContext(), i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, C0933g gVar) {
        setPageTransformer(z, gVar, 2);
    }

    public void setPageTransformer(boolean z, C0933g gVar, int i) {
        int i2 = 1;
        boolean z2 = gVar != null;
        boolean z3 = z2 != (this.mPageTransformer != null);
        this.mPageTransformer = gVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.mDrawingOrder = i2;
            this.mPageTransformerLayerType = i;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            i4 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i4 = getScrollX();
        }
        int i5 = i4;
        int scrollY = getScrollY();
        int i6 = i - i5;
        int i7 = i2 - scrollY;
        if (i6 == 0 && i7 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f = (float) clientWidth;
        float f2 = (float) i8;
        float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i6)) * 1.0f) / f)) * f2);
        int abs = Math.abs(i3);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i6)) / ((f * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f), MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i5, scrollY, i6, i7, min);
        C0656u.m2617e(this);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }
}
