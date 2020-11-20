package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.p026d.C0547b;
import androidx.core.p029g.C0588f;
import androidx.core.p030h.C0610a;
import androidx.core.p030h.C0643h;
import androidx.core.p030h.C0645j;
import androidx.core.p030h.C0646k;
import androidx.core.p030h.C0647l;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.C0665v;
import androidx.core.p030h.p031a.C0613b;
import androidx.core.p030h.p031a.C0614c;
import androidx.p035e.p036a.C0711a;
import androidx.recyclerview.C0993a;
import androidx.recyclerview.widget.C1055a;
import androidx.recyclerview.widget.C1058b;
import androidx.recyclerview.widget.C1077e;
import androidx.recyclerview.widget.C1091l;
import androidx.recyclerview.widget.C1098p;
import androidx.recyclerview.widget.C1101q;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.p172io.FilenameUtils;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public class RecyclerView extends ViewGroup implements C0645j, C0646k {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = (Build.VERSION.SDK_INT >= 23);
    static final boolean ALLOW_THREAD_GAP_WORK = (Build.VERSION.SDK_INT >= 21);
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = (Build.VERSION.SDK_INT <= 15);
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = (Build.VERSION.SDK_INT <= 15);
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = (Build.VERSION.SDK_INT >= 16);
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    C1091l mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    C1011a mAdapter;
    C1055a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private C1014d mChildDrawingOrderCallback;
    C1058b mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private C1015e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    C1077e mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private C1030m mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    C1016f mItemAnimator;
    private C1016f.C1018b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<C1021h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    C1022i mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C1036r mObserver;
    private List<C1028k> mOnChildAttachStateListeners;
    private C1029l mOnFlingListener;
    private final ArrayList<C1030m> mOnItemTouchListeners;
    final List<C1045x> mPendingAccessibilityImportanceChange;
    private C1037s mPendingSavedState;
    boolean mPostedAnimatorRunner;
    C1077e.C1079a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final C1034p mRecycler;
    C1035q mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private C1031n mScrollListener;
    private List<C1031n> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private C0647l mScrollingChildHelper;
    final C1042u mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final C1044w mViewFlinger;
    private final C1101q.C1103b mViewInfoProcessCallback;
    final C1101q mViewInfoStore;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a */
    public static abstract class C1011a<VH extends C1045x> {
        private boolean mHasStableIds = false;
        private final C1012b mObservable = new C1012b();

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            C0547b.m2169a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof C1027j) {
                ((C1027j) layoutParams).f3207e = true;
            }
            C0547b.m2168a();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                C0547b.m2169a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                C0547b.m2168a();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.mo5535a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.mo5536b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.mo5533a(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.mo5534a(i, 1, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.mo5537b(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.mo5539d(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.mo5533a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.mo5534a(i, i2, obj);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.mo5537b(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.mo5538c(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.mo5538c(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(C1013c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(C1013c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b */
    static class C1012b extends Observable<C1013c> {
        C1012b() {
        }

        /* renamed from: a */
        public void mo5533a(int i, int i2) {
            mo5534a(i, i2, (Object) null);
        }

        /* renamed from: a */
        public void mo5534a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1013c) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        /* renamed from: a */
        public boolean mo5535a() {
            return !this.mObservers.isEmpty();
        }

        /* renamed from: b */
        public void mo5536b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1013c) this.mObservers.get(size)).onChanged();
            }
        }

        /* renamed from: b */
        public void mo5537b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1013c) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        /* renamed from: c */
        public void mo5538c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1013c) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        /* renamed from: d */
        public void mo5539d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1013c) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c */
    public static abstract class C1013c {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$d */
    public interface C1014d {
        /* renamed from: a */
        int mo5546a(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$e */
    public static class C1015e {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public EdgeEffect mo5547a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$f */
    public static abstract class C1016f {

        /* renamed from: a */
        private C1018b f3188a = null;

        /* renamed from: b */
        private ArrayList<C1017a> f3189b = new ArrayList<>();

        /* renamed from: c */
        private long f3190c = 120;

        /* renamed from: d */
        private long f3191d = 120;

        /* renamed from: e */
        private long f3192e = 250;

        /* renamed from: f */
        private long f3193f = 250;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$f$a */
        public interface C1017a {
            /* renamed from: a */
            void mo5569a();
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$f$b */
        interface C1018b {
            /* renamed from: a */
            void mo5570a(C1045x xVar);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$f$c */
        public static class C1019c {

            /* renamed from: a */
            public int f3194a;

            /* renamed from: b */
            public int f3195b;

            /* renamed from: c */
            public int f3196c;

            /* renamed from: d */
            public int f3197d;

            /* renamed from: a */
            public C1019c mo5571a(C1045x xVar) {
                return mo5572a(xVar, 0);
            }

            /* renamed from: a */
            public C1019c mo5572a(C1045x xVar, int i) {
                View view = xVar.itemView;
                this.f3194a = view.getLeft();
                this.f3195b = view.getTop();
                this.f3196c = view.getRight();
                this.f3197d = view.getBottom();
                return this;
            }
        }

        /* renamed from: e */
        static int m3878e(C1045x xVar) {
            int i = xVar.mFlags & 14;
            if (xVar.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = xVar.getOldPosition();
            int adapterPosition = xVar.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        /* renamed from: a */
        public C1019c mo5548a(C1042u uVar, C1045x xVar) {
            return mo5568j().mo5571a(xVar);
        }

        /* renamed from: a */
        public C1019c mo5549a(C1042u uVar, C1045x xVar, int i, List<Object> list) {
            return mo5568j().mo5571a(xVar);
        }

        /* renamed from: a */
        public abstract void mo5550a();

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5551a(C1018b bVar) {
            this.f3188a = bVar;
        }

        /* renamed from: a */
        public abstract boolean mo5552a(C1045x xVar, C1019c cVar, C1019c cVar2);

        /* renamed from: a */
        public abstract boolean mo5553a(C1045x xVar, C1045x xVar2, C1019c cVar, C1019c cVar2);

        /* renamed from: a */
        public boolean mo5554a(C1045x xVar, List<Object> list) {
            return mo5566h(xVar);
        }

        /* renamed from: b */
        public abstract boolean mo5555b();

        /* renamed from: b */
        public abstract boolean mo5556b(C1045x xVar, C1019c cVar, C1019c cVar2);

        /* renamed from: c */
        public abstract boolean mo5557c(C1045x xVar, C1019c cVar, C1019c cVar2);

        /* renamed from: d */
        public abstract void mo5558d();

        /* renamed from: d */
        public abstract void mo5559d(C1045x xVar);

        /* renamed from: e */
        public long mo5560e() {
            return this.f3192e;
        }

        /* renamed from: f */
        public long mo5561f() {
            return this.f3190c;
        }

        /* renamed from: f */
        public final void mo5562f(C1045x xVar) {
            mo5564g(xVar);
            C1018b bVar = this.f3188a;
            if (bVar != null) {
                bVar.mo5570a(xVar);
            }
        }

        /* renamed from: g */
        public long mo5563g() {
            return this.f3191d;
        }

        /* renamed from: g */
        public void mo5564g(C1045x xVar) {
        }

        /* renamed from: h */
        public long mo5565h() {
            return this.f3193f;
        }

        /* renamed from: h */
        public boolean mo5566h(C1045x xVar) {
            return true;
        }

        /* renamed from: i */
        public final void mo5567i() {
            int size = this.f3189b.size();
            for (int i = 0; i < size; i++) {
                this.f3189b.get(i).mo5569a();
            }
            this.f3189b.clear();
        }

        /* renamed from: j */
        public C1019c mo5568j() {
            return new C1019c();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$g */
    private class C1020g implements C1016f.C1018b {
        C1020g() {
        }

        /* renamed from: a */
        public void mo5570a(C1045x xVar) {
            xVar.setIsRecyclable(true);
            if (xVar.mShadowedHolder != null && xVar.mShadowingHolder == null) {
                xVar.mShadowedHolder = null;
            }
            xVar.mShadowingHolder = null;
            if (!xVar.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(xVar.itemView) && xVar.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(xVar.itemView, false);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$h */
    public static abstract class C1021h {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1042u uVar) {
            getItemOffsets(rect, ((C1027j) view.getLayoutParams()).mo5703f(), recyclerView);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, C1042u uVar) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C1042u uVar) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$i */
    public static abstract class C1022i {
        boolean mAutoMeasure = false;
        C1058b mChildHelper;
        private int mHeight;
        private int mHeightMode;
        C1098p mHorizontalBoundCheck = new C1098p(this.mHorizontalBoundCheckCallback);
        private final C1098p.C1100b mHorizontalBoundCheckCallback = new C1098p.C1100b() {
            /* renamed from: a */
            public int mo5694a() {
                return C1022i.this.getPaddingLeft();
            }

            /* renamed from: a */
            public int mo5695a(View view) {
                return C1022i.this.getDecoratedLeft(view) - ((C1027j) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: a */
            public View mo5696a(int i) {
                return C1022i.this.getChildAt(i);
            }

            /* renamed from: b */
            public int mo5697b() {
                return C1022i.this.getWidth() - C1022i.this.getPaddingRight();
            }

            /* renamed from: b */
            public int mo5698b(View view) {
                return C1022i.this.getDecoratedRight(view) + ((C1027j) view.getLayoutParams()).rightMargin;
            }
        };
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        C1039t mSmoothScroller;
        C1098p mVerticalBoundCheck = new C1098p(this.mVerticalBoundCheckCallback);
        private final C1098p.C1100b mVerticalBoundCheckCallback = new C1098p.C1100b() {
            /* renamed from: a */
            public int mo5694a() {
                return C1022i.this.getPaddingTop();
            }

            /* renamed from: a */
            public int mo5695a(View view) {
                return C1022i.this.getDecoratedTop(view) - ((C1027j) view.getLayoutParams()).topMargin;
            }

            /* renamed from: a */
            public View mo5696a(int i) {
                return C1022i.this.getChildAt(i);
            }

            /* renamed from: b */
            public int mo5697b() {
                return C1022i.this.getHeight() - C1022i.this.getPaddingBottom();
            }

            /* renamed from: b */
            public int mo5698b(View view) {
                return C1022i.this.getDecoratedBottom(view) + ((C1027j) view.getLayoutParams()).bottomMargin;
            }
        };
        private int mWidth;
        private int mWidthMode;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$i$a */
        public interface C1025a {
            /* renamed from: b */
            void mo5699b(int i, int i2);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$i$b */
        public static class C1026b {

            /* renamed from: a */
            public int f3201a;

            /* renamed from: b */
            public int f3202b;

            /* renamed from: c */
            public boolean f3203c;

            /* renamed from: d */
            public boolean f3204d;
        }

        private void addViewInt(View view, int i, boolean z) {
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.mo6095e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.mo6096f(childViewHolderInt);
            }
            C1027j jVar = (C1027j) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.mo5945a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int b = this.mChildHelper.mo5949b(view);
                if (i == -1) {
                    i = this.mChildHelper.mo5948b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                } else if (b != i) {
                    this.mRecyclerView.mLayout.moveView(b, i);
                }
            } else {
                this.mChildHelper.mo5946a(view, i, false);
                jVar.f3207e = true;
                C1039t tVar = this.mSmoothScroller;
                if (tVar != null && tVar.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (jVar.f3208f) {
                childViewHolderInt.itemView.invalidate();
                jVar.f3208f = false;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.mo5956e(i);
        }

        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                        return View.MeasureSpec.makeMeasureSpec(max, i7);
                    }
                    max = 0;
                    return View.MeasureSpec.makeMeasureSpec(max, i7);
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i7 = i2;
                } else {
                    if (i4 == -2) {
                        if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                            i7 = Integer.MIN_VALUE;
                        }
                    }
                    max = 0;
                }
                return View.MeasureSpec.makeMeasureSpec(max, i7);
            }
            max = i4;
            i7 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x000f
                if (r3 < 0) goto L_0x000d
                goto L_0x0011
            L_0x000d:
                r1 = 0
                goto L_0x001e
            L_0x000f:
                if (r3 < 0) goto L_0x0015
            L_0x0011:
                r1 = r3
            L_0x0012:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x001e
            L_0x0015:
                r4 = -1
                if (r3 != r4) goto L_0x0019
                goto L_0x0012
            L_0x0019:
                r4 = -2
                if (r3 != r4) goto L_0x000d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L_0x001e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1022i.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static C1026b getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            C1026b bVar = new C1026b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0993a.C0996c.RecyclerView, i, i2);
            bVar.f3201a = obtainStyledAttributes.getInt(C0993a.C0996c.RecyclerView_android_orientation, 1);
            bVar.f3202b = obtainStyledAttributes.getInt(C0993a.C0996c.RecyclerView_spanCount, 1);
            bVar.f3203c = obtainStyledAttributes.getBoolean(C0993a.C0996c.RecyclerView_reverseLayout, false);
            bVar.f3204d = obtainStyledAttributes.getBoolean(C0993a.C0996c.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private void scrapOrRecycleView(C1034p pVar, int i, View view) {
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i);
                    pVar.mo5745c(view);
                    this.mRecyclerView.mViewInfoStore.mo6098h(childViewHolderInt);
                    return;
                }
                removeViewAt(i);
                pVar.mo5741b(childViewHolderInt);
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void attachView(View view, int i) {
            attachView(view, i, (C1027j) view.getLayoutParams());
        }

        public void attachView(View view, int i, C1027j jVar) {
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.mo6095e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.mo6096f(childViewHolderInt);
            }
            this.mChildHelper.mo5945a(view, i, jVar, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(C1027j jVar) {
            return jVar != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, C1042u uVar, C1025a aVar) {
        }

        public void collectInitialPrefetchPositions(int i, C1025a aVar) {
        }

        public int computeHorizontalScrollExtent(C1042u uVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(C1042u uVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(C1042u uVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(C1042u uVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(C1042u uVar) {
            return 0;
        }

        public int computeVerticalScrollRange(C1042u uVar) {
            return 0;
        }

        public void detachAndScrapAttachedViews(C1034p pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(pVar, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, C1034p pVar) {
            scrapOrRecycleView(pVar, this.mChildHelper.mo5949b(view), view);
        }

        public void detachAndScrapViewAt(int i, C1034p pVar) {
            scrapOrRecycleView(pVar, i, getChildAt(i));
        }

        public void detachView(View view) {
            int b = this.mChildHelper.mo5949b(view);
            if (b >= 0) {
                detachViewInternal(b, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        /* access modifiers changed from: package-private */
        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void dispatchDetachedFromWindow(RecyclerView recyclerView, C1034p pVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, pVar);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.mo5559d(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.mo5953c(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.mo5792a() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract C1027j generateDefaultLayoutParams();

        public C1027j generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new C1027j(context, attributeSet);
        }

        public C1027j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof C1027j ? new C1027j((C1027j) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C1027j((ViewGroup.MarginLayoutParams) layoutParams) : new C1027j(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((C1027j) view.getLayoutParams()).f3206d.bottom;
        }

        public View getChildAt(int i) {
            C1058b bVar = this.mChildHelper;
            if (bVar != null) {
                return bVar.mo5950b(i);
            }
            return null;
        }

        public int getChildCount() {
            C1058b bVar = this.mChildHelper;
            if (bVar != null) {
                return bVar.mo5948b();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(C1034p pVar, C1042u uVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((C1027j) view.getLayoutParams()).f3206d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((C1027j) view.getLayoutParams()).f3206d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.mo5953c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            C1011a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return C0656u.m2621g(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((C1027j) view.getLayoutParams()).f3206d.left;
        }

        public int getMinimumHeight() {
            return C0656u.m2629l(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return C0656u.m2628k(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return C0656u.m2627j(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return C0656u.m2625i(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((C1027j) view.getLayoutParams()).mo5703f();
        }

        public int getRightDecorationWidth(View view) {
            return ((C1027j) view.getLayoutParams()).f3206d.right;
        }

        public int getRowCountForAccessibility(C1034p pVar, C1042u uVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(C1034p pVar, C1042u uVar) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((C1027j) view.getLayoutParams()).f3206d.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((C1027j) view.getLayoutParams()).f3206d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        /* access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.mo6097g(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(C1034p pVar, C1042u uVar) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            C1039t tVar = this.mSmoothScroller;
            return tVar != null && tVar.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.mo6077a(view, 24579) && this.mVerticalBoundCheck.mo6077a(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((C1027j) view.getLayoutParams()).f3206d;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            C1027j jVar = (C1027j) view.getLayoutParams();
            Rect rect = jVar.f3206d;
            view.layout(i + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            C1027j jVar = (C1027j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, jVar.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, jVar.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, jVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            C1027j jVar = (C1027j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + jVar.leftMargin + jVar.rightMargin + i3, jVar.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, jVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(C1011a aVar, C1011a aVar2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, C1034p pVar) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, C1034p pVar, C1042u uVar) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(C1034p pVar, C1042u uVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.mRecyclerView.mAdapter != null) {
                    accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(C0614c cVar) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, cVar);
        }

        public void onInitializeAccessibilityNodeInfo(C1034p pVar, C1042u uVar, C0614c cVar) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                cVar.mo3704a((int) PKIFailureInfo.certRevoked);
                cVar.mo3741i(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                cVar.mo3704a(4096);
                cVar.mo3741i(true);
            }
            cVar.mo3710a((Object) C0614c.C0616b.m2481a(getRowCountForAccessibility(pVar, uVar), getColumnCountForAccessibility(pVar, uVar), isLayoutHierarchical(pVar, uVar), getSelectionModeForAccessibility(pVar, uVar)));
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, C0614c cVar) {
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.mo5953c(childViewHolderInt.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, cVar);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(C1034p pVar, C1042u uVar, View view, C0614c cVar) {
            cVar.mo3717b((Object) C0614c.C0617c.m2482a(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(C1034p pVar, C1042u uVar) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(C1042u uVar) {
        }

        public void onMeasure(C1034p pVar, C1042u uVar, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, C1042u uVar, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        /* access modifiers changed from: package-private */
        public void onSmoothScrollerStopped(C1039t tVar) {
            if (this.mSmoothScroller == tVar) {
                this.mSmoothScroller = null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.C1034p r8, androidx.recyclerview.widget.RecyclerView.C1042u r9, int r10, android.os.Bundle r11) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView r8 = r7.mRecyclerView
                r9 = 0
                if (r8 != 0) goto L_0x0006
                return r9
            L_0x0006:
                r11 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r10 == r11) goto L_0x0042
                r11 = 8192(0x2000, float:1.14794E-41)
                if (r10 == r11) goto L_0x0012
                r2 = 0
                r3 = 0
                goto L_0x0073
            L_0x0012:
                r10 = -1
                boolean r8 = r8.canScrollVertically(r10)
                if (r8 == 0) goto L_0x0029
                int r8 = r7.getHeight()
                int r11 = r7.getPaddingTop()
                int r8 = r8 - r11
                int r11 = r7.getPaddingBottom()
                int r8 = r8 - r11
                int r8 = -r8
                goto L_0x002a
            L_0x0029:
                r8 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r11 = r7.mRecyclerView
                boolean r10 = r11.canScrollHorizontally(r10)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
                int r10 = -r10
                goto L_0x006e
            L_0x0042:
                boolean r8 = r8.canScrollVertically(r0)
                if (r8 == 0) goto L_0x0057
                int r8 = r7.getHeight()
                int r10 = r7.getPaddingTop()
                int r8 = r8 - r10
                int r10 = r7.getPaddingBottom()
                int r8 = r8 - r10
                goto L_0x0058
            L_0x0057:
                r8 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r10 = r7.mRecyclerView
                boolean r10 = r10.canScrollHorizontally(r0)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
            L_0x006e:
                r3 = r8
                r2 = r10
                goto L_0x0073
            L_0x0071:
                r3 = r8
                r2 = 0
            L_0x0073:
                if (r3 != 0) goto L_0x0078
                if (r2 != 0) goto L_0x0078
                return r9
            L_0x0078:
                androidx.recyclerview.widget.RecyclerView r1 = r7.mRecyclerView
                r4 = 0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = 1
                r1.smoothScrollBy(r2, r3, r4, r5, r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1022i.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
        }

        public boolean performAccessibilityActionForItem(C1034p pVar, C1042u uVar, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                C0656u.m2597a((View) recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.mo5943a(childCount);
            }
        }

        public void removeAndRecycleAllViews(C1034p pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, pVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void removeAndRecycleScrapInt(C1034p pVar) {
            int e = pVar.mo5750e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = pVar.mo5751e(i);
                C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(e2);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(e2, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.mo5559d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    pVar.mo5740b(e2);
                }
            }
            pVar.mo5753f();
            if (e > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, C1034p pVar) {
            removeView(view);
            pVar.mo5730a(view);
        }

        public void removeAndRecycleViewAt(int i, C1034p pVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            pVar.mo5730a(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.mChildHelper.mo5944a(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.mo5943a(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, C1034p pVar, C1042u uVar) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, C1034p pVar, C1042u uVar) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        /* access modifiers changed from: package-private */
        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.mo5738b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            this.mWidthMode = View.MeasureSpec.getMode(i);
            if (this.mWidthMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            this.mHeightMode = View.MeasureSpec.getMode(i2);
            if (this.mHeightMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        /* access modifiers changed from: package-private */
        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i3, i4, i5, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        /* access modifiers changed from: package-private */
        public void setRecyclerView(RecyclerView recyclerView) {
            int i;
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                i = 0;
                this.mWidth = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                i = recyclerView.getHeight();
            }
            this.mHeight = i;
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i, int i2, C1027j jVar) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i, jVar.width) || !isMeasurementUpToDate(view.getHeight(), i2, jVar.height);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureTwice() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i, int i2, C1027j jVar) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i, jVar.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i2, jVar.height);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, C1042u uVar, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(C1039t tVar) {
            C1039t tVar2 = this.mSmoothScroller;
            if (!(tVar2 == null || tVar == tVar2 || !tVar2.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = tVar;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        /* access modifiers changed from: package-private */
        public void stopSmoothScroller() {
            C1039t tVar = this.mSmoothScroller;
            if (tVar != null) {
                tVar.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$j */
    public static class C1027j extends ViewGroup.MarginLayoutParams {

        /* renamed from: c */
        C1045x f3205c;

        /* renamed from: d */
        final Rect f3206d = new Rect();

        /* renamed from: e */
        boolean f3207e = true;

        /* renamed from: f */
        boolean f3208f = false;

        public C1027j(int i, int i2) {
            super(i, i2);
        }

        public C1027j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C1027j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C1027j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1027j(C1027j jVar) {
            super(jVar);
        }

        /* renamed from: c */
        public boolean mo5700c() {
            return this.f3205c.isInvalid();
        }

        /* renamed from: d */
        public boolean mo5701d() {
            return this.f3205c.isRemoved();
        }

        /* renamed from: e */
        public boolean mo5702e() {
            return this.f3205c.isUpdated();
        }

        /* renamed from: f */
        public int mo5703f() {
            return this.f3205c.getLayoutPosition();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$k */
    public interface C1028k {
        /* renamed from: a */
        void mo5704a(View view);

        /* renamed from: b */
        void mo5705b(View view);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$l */
    public static abstract class C1029l {
        /* renamed from: a */
        public abstract boolean mo5706a(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$m */
    public interface C1030m {
        /* renamed from: a */
        void mo5707a(boolean z);

        /* renamed from: a */
        boolean mo5708a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: b */
        void mo5709b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$n */
    public static abstract class C1031n {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$o */
    public static class C1032o {

        /* renamed from: a */
        SparseArray<C1033a> f3209a = new SparseArray<>();

        /* renamed from: b */
        private int f3210b = 0;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$a */
        static class C1033a {

            /* renamed from: a */
            final ArrayList<C1045x> f3211a = new ArrayList<>();

            /* renamed from: b */
            int f3212b = 5;

            /* renamed from: c */
            long f3213c = 0;

            /* renamed from: d */
            long f3214d = 0;

            C1033a() {
            }
        }

        /* renamed from: b */
        private C1033a m3926b(int i) {
            C1033a aVar = this.f3209a.get(i);
            if (aVar != null) {
                return aVar;
            }
            C1033a aVar2 = new C1033a();
            this.f3209a.put(i, aVar2);
            return aVar2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo5712a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* renamed from: a */
        public C1045x mo5713a(int i) {
            C1033a aVar = this.f3209a.get(i);
            if (aVar == null || aVar.f3211a.isEmpty()) {
                return null;
            }
            ArrayList<C1045x> arrayList = aVar.f3211a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* renamed from: a */
        public void mo5714a() {
            for (int i = 0; i < this.f3209a.size(); i++) {
                this.f3209a.valueAt(i).f3211a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5715a(int i, long j) {
            C1033a b = m3926b(i);
            b.f3213c = mo5712a(b.f3213c, j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5716a(C1011a aVar, C1011a aVar2, boolean z) {
            if (aVar != null) {
                mo5722c();
            }
            if (!z && this.f3210b == 0) {
                mo5714a();
            }
            if (aVar2 != null) {
                mo5719b();
            }
        }

        /* renamed from: a */
        public void mo5717a(C1045x xVar) {
            int itemViewType = xVar.getItemViewType();
            ArrayList<C1045x> arrayList = m3926b(itemViewType).f3211a;
            if (this.f3209a.get(itemViewType).f3212b > arrayList.size()) {
                xVar.resetInternal();
                arrayList.add(xVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5718a(int i, long j, long j2) {
            long j3 = m3926b(i).f3213c;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5719b() {
            this.f3210b++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5720b(int i, long j) {
            C1033a b = m3926b(i);
            b.f3214d = mo5712a(b.f3214d, j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo5721b(int i, long j, long j2) {
            long j3 = m3926b(i).f3214d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5722c() {
            this.f3210b--;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$p */
    public final class C1034p {

        /* renamed from: a */
        final ArrayList<C1045x> f3215a = new ArrayList<>();

        /* renamed from: b */
        ArrayList<C1045x> f3216b = null;

        /* renamed from: c */
        final ArrayList<C1045x> f3217c = new ArrayList<>();

        /* renamed from: d */
        int f3218d = 2;

        /* renamed from: e */
        C1032o f3219e;

        /* renamed from: g */
        private final List<C1045x> f3221g = Collections.unmodifiableList(this.f3215a);

        /* renamed from: h */
        private int f3222h = 2;

        /* renamed from: i */
        private C1043v f3223i;

        public C1034p() {
        }

        /* renamed from: a */
        private void m3938a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m3938a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* renamed from: a */
        private boolean m3939a(C1045x xVar, int i, int i2, long j) {
            xVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = xVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS && !this.f3219e.mo5721b(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(xVar, i);
            this.f3219e.mo5720b(xVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            m3940e(xVar);
            if (!RecyclerView.this.mState.mo5792a()) {
                return true;
            }
            xVar.mPreLayoutPosition = i2;
            return true;
        }

        /* renamed from: e */
        private void m3940e(C1045x xVar) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = xVar.itemView;
                if (C0656u.m2619f(view) == 0) {
                    C0656u.m2606b(view, 1);
                }
                if (RecyclerView.this.mAccessibilityDelegate != null) {
                    C0610a itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                    if (itemDelegate instanceof C1091l.C1092a) {
                        ((C1091l.C1092a) itemDelegate).mo6054a(view);
                    }
                    C0656u.m2594a(view, itemDelegate);
                }
            }
        }

        /* renamed from: f */
        private void m3941f(C1045x xVar) {
            if (xVar.itemView instanceof ViewGroup) {
                m3938a((ViewGroup) xVar.itemView, false);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo5723a(int i, boolean z) {
            return mo5724a(i, z, (long) RecyclerView.FOREVER_NS).itemView;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01a3  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01ce  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01d1  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0201  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x020f  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.C1045x mo5724a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x022b
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r1 = r1.mState
                int r1 = r1.mo5796e()
                if (r3 >= r1) goto L_0x022b
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r1 = r1.mState
                boolean r1 = r1.mo5792a()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$x r1 = r16.mo5752f((int) r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$x r1 = r16.mo5737b((int) r17, (boolean) r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.mo5735a((androidx.recyclerview.widget.RecyclerView.C1045x) r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.mo5741b((androidx.recyclerview.widget.RecyclerView.C1045x) r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0182
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.mAdapterHelper
                int r5 = r5.mo5929b((int) r3)
                if (r5 < 0) goto L_0x014a
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.mAdapter
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x014a
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.mAdapter
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r10 = r10.mAdapter
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r1 = r1.mAdapter
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$x r1 = r6.mo5725a((long) r10, (int) r9, (boolean) r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$v r0 = r6.f3223i
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.mo5798a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$x r1 = r1.getChildViewHolder(r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.shouldIgnore()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0101
                androidx.recyclerview.widget.RecyclerView$o r0 = r16.mo5754g()
                androidx.recyclerview.widget.RecyclerView$x r1 = r0.mo5713a((int) r9)
                if (r1 == 0) goto L_0x0101
                r1.resetInternal()
                boolean r0 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
                if (r0 == 0) goto L_0x0101
                r6.m3941f((androidx.recyclerview.widget.RecyclerView.C1045x) r1)
            L_0x0101:
                if (r1 != 0) goto L_0x0182
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x011f
                androidx.recyclerview.widget.RecyclerView$o r10 = r6.f3219e
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.mo5718a((int) r11, (long) r12, (long) r14)
                if (r5 != 0) goto L_0x011f
                return r2
            L_0x011f:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r2 = r2.mAdapter
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$x r2 = r2.createViewHolder(r5, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r5 == 0) goto L_0x013c
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r5)
                if (r5 == 0) goto L_0x013c
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.mNestedRecyclerView = r10
            L_0x013c:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$o r5 = r6.f3219e
                long r10 = r10 - r0
                r5.mo5715a((int) r9, (long) r10)
                r10 = r2
                goto L_0x0183
            L_0x014a:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r2 = r2.mState
                int r2 = r2.mo5796e()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0182:
                r10 = r1
            L_0x0183:
                r9 = r4
                if (r9 == 0) goto L_0x01be
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.mState
                boolean r0 = r0.mo5792a()
                if (r0 != 0) goto L_0x01be
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r10.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01be
                r10.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.mState
                boolean r0 = r0.f3242j
                if (r0 == 0) goto L_0x01be
                int r0 = androidx.recyclerview.widget.RecyclerView.C1016f.m3878e(r10)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$f r1 = r1.mItemAnimator
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r2 = r2.mState
                java.util.List r4 = r10.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$f$c r0 = r1.mo5549a((androidx.recyclerview.widget.RecyclerView.C1042u) r2, (androidx.recyclerview.widget.RecyclerView.C1045x) r10, (int) r0, (java.util.List<java.lang.Object>) r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.recordAnimationInfoIfBouncedHiddenView(r10, r0)
            L_0x01be:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.mState
                boolean r0 = r0.mo5792a()
                if (r0 == 0) goto L_0x01d1
                boolean r0 = r10.isBound()
                if (r0 == 0) goto L_0x01d1
                r10.mPreLayoutPosition = r3
                goto L_0x01e4
            L_0x01d1:
                boolean r0 = r10.isBound()
                if (r0 == 0) goto L_0x01e6
                boolean r0 = r10.needsUpdate()
                if (r0 != 0) goto L_0x01e6
                boolean r0 = r10.isInvalid()
                if (r0 == 0) goto L_0x01e4
                goto L_0x01e6
            L_0x01e4:
                r0 = 0
                goto L_0x01f9
            L_0x01e6:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.mAdapterHelper
                int r2 = r0.mo5929b((int) r3)
                r0 = r16
                r1 = r10
                r3 = r17
                r4 = r19
                boolean r0 = r0.m3939a(r1, r2, r3, r4)
            L_0x01f9:
                android.view.View r1 = r10.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x020f
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
            L_0x0207:
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.C1027j) r1
                android.view.View r2 = r10.itemView
                r2.setLayoutParams(r1)
                goto L_0x0220
            L_0x020f:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x021e
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                goto L_0x0207
            L_0x021e:
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.C1027j) r1
            L_0x0220:
                r1.f3205c = r10
                if (r9 == 0) goto L_0x0227
                if (r0 == 0) goto L_0x0227
                goto L_0x0228
            L_0x0227:
                r7 = 0
            L_0x0228:
                r1.f3208f = r7
                return r10
            L_0x022b:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r2 = r2.mState
                int r2 = r2.mo5796e()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1034p.mo5724a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$x");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1045x mo5725a(long j, int i, boolean z) {
            for (int size = this.f3215a.size() - 1; size >= 0; size--) {
                C1045x xVar = this.f3215a.get(size);
                if (xVar.getItemId() == j && !xVar.wasReturnedFromScrap()) {
                    if (i == xVar.getItemViewType()) {
                        xVar.addFlags(32);
                        if (xVar.isRemoved() && !RecyclerView.this.mState.mo5792a()) {
                            xVar.setFlags(2, 14);
                        }
                        return xVar;
                    } else if (!z) {
                        this.f3215a.remove(size);
                        RecyclerView.this.removeDetachedView(xVar.itemView, false);
                        mo5740b(xVar.itemView);
                    }
                }
            }
            int size2 = this.f3217c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                C1045x xVar2 = this.f3217c.get(size2);
                if (xVar2.getItemId() == j && !xVar2.isAttachedToTransitionOverlay()) {
                    if (i == xVar2.getItemViewType()) {
                        if (!z) {
                            this.f3217c.remove(size2);
                        }
                        return xVar2;
                    } else if (!z) {
                        mo5748d(size2);
                        return null;
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo5726a() {
            this.f3215a.clear();
            mo5747d();
        }

        /* renamed from: a */
        public void mo5727a(int i) {
            this.f3222h = i;
            mo5738b();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5728a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i5 = i;
                i4 = i2;
                i3 = -1;
            } else {
                i4 = i;
                i5 = i2;
                i3 = 1;
            }
            int size = this.f3217c.size();
            for (int i6 = 0; i6 < size; i6++) {
                C1045x xVar = this.f3217c.get(i6);
                if (xVar != null && xVar.mPosition >= i5 && xVar.mPosition <= i4) {
                    if (xVar.mPosition == i) {
                        xVar.offsetPosition(i2 - i, false);
                    } else {
                        xVar.offsetPosition(i3, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5729a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f3217c.size() - 1; size >= 0; size--) {
                C1045x xVar = this.f3217c.get(size);
                if (xVar != null) {
                    if (xVar.mPosition >= i3) {
                        xVar.offsetPosition(-i2, z);
                    } else if (xVar.mPosition >= i) {
                        xVar.addFlags(8);
                        mo5748d(size);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo5730a(View view) {
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            mo5741b(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.mo5559d(childViewHolderInt);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5731a(C1011a aVar, C1011a aVar2, boolean z) {
            mo5726a();
            mo5754g().mo5716a(aVar, aVar2, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5732a(C1032o oVar) {
            C1032o oVar2 = this.f3219e;
            if (oVar2 != null) {
                oVar2.mo5722c();
            }
            this.f3219e = oVar;
            if (this.f3219e != null && RecyclerView.this.getAdapter() != null) {
                this.f3219e.mo5719b();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5733a(C1043v vVar) {
            this.f3223i = vVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5734a(C1045x xVar, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(xVar);
            View view = xVar.itemView;
            if (RecyclerView.this.mAccessibilityDelegate != null) {
                C0610a itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                C0656u.m2594a(view, itemDelegate instanceof C1091l.C1092a ? ((C1091l.C1092a) itemDelegate).mo6055b(view) : null);
            }
            if (z) {
                mo5749d(xVar);
            }
            xVar.mOwnerRecyclerView = null;
            mo5754g().mo5717a(xVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5735a(C1045x xVar) {
            if (xVar.isRemoved()) {
                return RecyclerView.this.mState.mo5792a();
            }
            if (xVar.mPosition < 0 || xVar.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + xVar + RecyclerView.this.exceptionLabel());
            } else if (RecyclerView.this.mState.mo5792a() || RecyclerView.this.mAdapter.getItemViewType(xVar.mPosition) == xVar.getItemViewType()) {
                return !RecyclerView.this.mAdapter.hasStableIds() || xVar.getItemId() == RecyclerView.this.mAdapter.getItemId(xVar.mPosition);
            } else {
                return false;
            }
        }

        /* renamed from: b */
        public int mo5736b(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.mo5796e()) {
                return !RecyclerView.this.mState.mo5792a() ? i : RecyclerView.this.mAdapterHelper.mo5929b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.mo5796e() + RecyclerView.this.exceptionLabel());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C1045x mo5737b(int i, boolean z) {
            View c;
            int size = this.f3215a.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                C1045x xVar = this.f3215a.get(i3);
                if (xVar.wasReturnedFromScrap() || xVar.getLayoutPosition() != i || xVar.isInvalid() || (!RecyclerView.this.mState.f3239g && xVar.isRemoved())) {
                    i3++;
                } else {
                    xVar.addFlags(32);
                    return xVar;
                }
            }
            if (z || (c = RecyclerView.this.mChildHelper.mo5952c(i)) == null) {
                int size2 = this.f3217c.size();
                while (i2 < size2) {
                    C1045x xVar2 = this.f3217c.get(i2);
                    if (xVar2.isInvalid() || xVar2.getLayoutPosition() != i || xVar2.isAttachedToTransitionOverlay()) {
                        i2++;
                    } else {
                        if (!z) {
                            this.f3217c.remove(i2);
                        }
                        return xVar2;
                    }
                }
                return null;
            }
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(c);
            RecyclerView.this.mChildHelper.mo5957e(c);
            int b = RecyclerView.this.mChildHelper.mo5949b(c);
            if (b != -1) {
                RecyclerView.this.mChildHelper.mo5956e(b);
                mo5745c(c);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5738b() {
            this.f3218d = this.f3222h + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.f3217c.size() - 1; size >= 0 && this.f3217c.size() > this.f3218d; size--) {
                mo5748d(size);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5739b(int i, int i2) {
            int size = this.f3217c.size();
            for (int i3 = 0; i3 < size; i3++) {
                C1045x xVar = this.f3217c.get(i3);
                if (xVar != null && xVar.mPosition >= i) {
                    xVar.offsetPosition(i2, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5740b(View view) {
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            mo5741b(childViewHolderInt);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5741b(C1045x xVar) {
            boolean z;
            boolean z2 = false;
            if (xVar.isScrap() || xVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(xVar.isScrap());
                sb.append(" isAttached:");
                if (xVar.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            } else if (xVar.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + xVar + RecyclerView.this.exceptionLabel());
            } else if (!xVar.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = xVar.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.mAdapter != null && doesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(xVar)) || xVar.isRecyclable()) {
                    if (this.f3218d <= 0 || xVar.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.f3217c.size();
                        if (size >= this.f3218d && size > 0) {
                            mo5748d(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.mo6015a(xVar.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.mPrefetchRegistry.mo6015a(this.f3217c.get(i).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.f3217c.add(size, xVar);
                        z = true;
                    }
                    if (!z) {
                        mo5734a(xVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.mViewInfoStore.mo6097g(xVar);
                if (!z && !z2 && doesTransientStatePreventRecycling) {
                    xVar.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
        }

        /* renamed from: c */
        public View mo5742c(int i) {
            return mo5723a(i, false);
        }

        /* renamed from: c */
        public List<C1045x> mo5743c() {
            return this.f3221g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5744c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f3217c.size() - 1; size >= 0; size--) {
                C1045x xVar = this.f3217c.get(size);
                if (xVar != null && (i3 = xVar.mPosition) >= i && i3 < i4) {
                    xVar.addFlags(2);
                    mo5748d(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5745c(View view) {
            ArrayList<C1045x> arrayList;
            C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f3216b == null) {
                    this.f3216b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                arrayList = this.f3216b;
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                arrayList = this.f3215a;
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
            arrayList.add(childViewHolderInt);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5746c(C1045x xVar) {
            (xVar.mInChangeScrap ? this.f3216b : this.f3215a).remove(xVar);
            xVar.mScrapContainer = null;
            xVar.mInChangeScrap = false;
            xVar.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5747d() {
            for (int size = this.f3217c.size() - 1; size >= 0; size--) {
                mo5748d(size);
            }
            this.f3217c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.mo6012a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5748d(int i) {
            mo5734a(this.f3217c.get(i), true);
            this.f3217c.remove(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5749d(C1045x xVar) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.mo5758a(xVar);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(xVar);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.mo6097g(xVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public int mo5750e() {
            return this.f3215a.size();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public View mo5751e(int i) {
            return this.f3215a.get(i).itemView;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public C1045x mo5752f(int i) {
            int size;
            int b;
            ArrayList<C1045x> arrayList = this.f3216b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    C1045x xVar = this.f3216b.get(i3);
                    if (xVar.wasReturnedFromScrap() || xVar.getLayoutPosition() != i) {
                        i3++;
                    } else {
                        xVar.addFlags(32);
                        return xVar;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (b = RecyclerView.this.mAdapterHelper.mo5929b(i)) > 0 && b < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(b);
                    while (i2 < size) {
                        C1045x xVar2 = this.f3216b.get(i2);
                        if (xVar2.wasReturnedFromScrap() || xVar2.getItemId() != itemId) {
                            i2++;
                        } else {
                            xVar2.addFlags(32);
                            return xVar2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo5753f() {
            this.f3215a.clear();
            ArrayList<C1045x> arrayList = this.f3216b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public C1032o mo5754g() {
            if (this.f3219e == null) {
                this.f3219e = new C1032o();
            }
            return this.f3219e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo5755h() {
            int size = this.f3217c.size();
            for (int i = 0; i < size; i++) {
                C1045x xVar = this.f3217c.get(i);
                if (xVar != null) {
                    xVar.addFlags(6);
                    xVar.addChangePayload((Object) null);
                }
            }
            if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
                mo5747d();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo5756i() {
            int size = this.f3217c.size();
            for (int i = 0; i < size; i++) {
                this.f3217c.get(i).clearOldPosition();
            }
            int size2 = this.f3215a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f3215a.get(i2).clearOldPosition();
            }
            ArrayList<C1045x> arrayList = this.f3216b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f3216b.get(i3).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo5757j() {
            int size = this.f3217c.size();
            for (int i = 0; i < size; i++) {
                C1027j jVar = (C1027j) this.f3217c.get(i).itemView.getLayoutParams();
                if (jVar != null) {
                    jVar.f3207e = true;
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$q */
    public interface C1035q {
        /* renamed from: a */
        void mo5758a(C1045x xVar);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$r */
    private class C1036r extends C1013c {
        C1036r() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5759a() {
            if (!RecyclerView.POST_UPDATES_ON_ANIMATION || !RecyclerView.this.mHasFixedSize || !RecyclerView.this.mIsAttached) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mAdapterUpdateDuringMeasure = true;
                recyclerView.requestLayout();
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            C0656u.m2597a((View) recyclerView2, recyclerView2.mUpdateChildViewsRunnable);
        }

        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            RecyclerView.this.mState.f3238f = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.mo5935d()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.mo5928a(i, i2, obj)) {
                mo5759a();
            }
        }

        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.mo5931b(i, i2)) {
                mo5759a();
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.mo5927a(i, i2, i3)) {
                mo5759a();
            }
        }

        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.mo5934c(i, i2)) {
                mo5759a();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$s */
    public static class C1037s extends C0711a {
        public static final Parcelable.Creator<C1037s> CREATOR = new Parcelable.ClassLoaderCreator<C1037s>() {
            /* renamed from: a */
            public C1037s createFromParcel(Parcel parcel) {
                return new C1037s(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public C1037s createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C1037s(parcel, classLoader);
            }

            /* renamed from: a */
            public C1037s[] newArray(int i) {
                return new C1037s[i];
            }
        };

        /* renamed from: a */
        Parcelable f3225a;

        C1037s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3225a = parcel.readParcelable(classLoader == null ? C1022i.class.getClassLoader() : classLoader);
        }

        C1037s(Parcelable parcelable) {
            super(parcelable);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5760a(C1037s sVar) {
            this.f3225a = sVar.f3225a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f3225a, 0);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$t */
    public static abstract class C1039t {
        private C1022i mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final C1040a mRecyclingAction = new C1040a(0, 0);
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$t$a */
        public static class C1040a {

            /* renamed from: a */
            private int f3226a;

            /* renamed from: b */
            private int f3227b;

            /* renamed from: c */
            private int f3228c;

            /* renamed from: d */
            private int f3229d;

            /* renamed from: e */
            private Interpolator f3230e;

            /* renamed from: f */
            private boolean f3231f;

            /* renamed from: g */
            private int f3232g;

            public C1040a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, (Interpolator) null);
            }

            public C1040a(int i, int i2, int i3, Interpolator interpolator) {
                this.f3229d = -1;
                this.f3231f = false;
                this.f3232g = 0;
                this.f3226a = i;
                this.f3227b = i2;
                this.f3228c = i3;
                this.f3230e = interpolator;
            }

            /* renamed from: b */
            private void m3983b() {
                if (this.f3230e != null && this.f3228c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f3228c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* renamed from: a */
            public void mo5786a(int i) {
                this.f3229d = i;
            }

            /* renamed from: a */
            public void mo5787a(int i, int i2, int i3, Interpolator interpolator) {
                this.f3226a = i;
                this.f3227b = i2;
                this.f3228c = i3;
                this.f3230e = interpolator;
                this.f3231f = true;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo5788a(RecyclerView recyclerView) {
                int i = this.f3229d;
                if (i >= 0) {
                    this.f3229d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f3231f = false;
                } else if (this.f3231f) {
                    m3983b();
                    recyclerView.mViewFlinger.mo5801a(this.f3226a, this.f3227b, this.f3228c, this.f3230e);
                    this.f3232g++;
                    if (this.f3232g > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f3231f = false;
                } else {
                    this.f3232g = 0;
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo5789a() {
                return this.f3229d >= 0;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$t$b */
        public interface C1041b {
            PointF computeScrollVectorForPosition(int i);
        }

        public PointF computeScrollVectorForPosition(int i) {
            C1022i layoutManager = getLayoutManager();
            if (layoutManager instanceof C1041b) {
                return ((C1041b) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + C1041b.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public C1022i getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        /* access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: package-private */
        public void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (!(!this.mPendingInitialRun || this.mTargetView != null || this.mLayoutManager == null || (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) == null || (computeScrollVectorForPosition.x == 0.0f && computeScrollVectorForPosition.y == 0.0f))) {
                recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.mo5788a(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean a = this.mRecyclingAction.mo5789a();
                this.mRecyclingAction.mo5788a(recyclerView);
                if (a && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.mo5799a();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void onSeekTargetStep(int i, int i2, C1042u uVar, C1040a aVar);

        /* access modifiers changed from: protected */
        public abstract void onStart();

        /* access modifiers changed from: protected */
        public abstract void onStop();

        /* access modifiers changed from: protected */
        public abstract void onTargetFound(View view, C1042u uVar, C1040a aVar);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        /* access modifiers changed from: package-private */
        public void start(RecyclerView recyclerView, C1022i iVar) {
            recyclerView.mViewFlinger.mo5802b();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = iVar;
            if (this.mTargetPosition != -1) {
                this.mRecyclerView.mState.f3233a = this.mTargetPosition;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.mo5799a();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f3233a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$u */
    public static class C1042u {

        /* renamed from: a */
        int f3233a = -1;

        /* renamed from: b */
        int f3234b = 0;

        /* renamed from: c */
        int f3235c = 0;

        /* renamed from: d */
        int f3236d = 1;

        /* renamed from: e */
        int f3237e = 0;

        /* renamed from: f */
        boolean f3238f = false;

        /* renamed from: g */
        boolean f3239g = false;

        /* renamed from: h */
        boolean f3240h = false;

        /* renamed from: i */
        boolean f3241i = false;

        /* renamed from: j */
        boolean f3242j = false;

        /* renamed from: k */
        boolean f3243k = false;

        /* renamed from: l */
        int f3244l;

        /* renamed from: m */
        long f3245m;

        /* renamed from: n */
        int f3246n;

        /* renamed from: o */
        int f3247o;

        /* renamed from: p */
        int f3248p;

        /* renamed from: q */
        private SparseArray<Object> f3249q;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5790a(int i) {
            if ((this.f3236d & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f3236d));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5791a(C1011a aVar) {
            this.f3236d = 1;
            this.f3237e = aVar.getItemCount();
            this.f3239g = false;
            this.f3240h = false;
            this.f3241i = false;
        }

        /* renamed from: a */
        public boolean mo5792a() {
            return this.f3239g;
        }

        /* renamed from: b */
        public boolean mo5793b() {
            return this.f3243k;
        }

        /* renamed from: c */
        public int mo5794c() {
            return this.f3233a;
        }

        /* renamed from: d */
        public boolean mo5795d() {
            return this.f3233a != -1;
        }

        /* renamed from: e */
        public int mo5796e() {
            return this.f3239g ? this.f3234b - this.f3235c : this.f3237e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f3233a + ", mData=" + this.f3249q + ", mItemCount=" + this.f3237e + ", mIsMeasuring=" + this.f3241i + ", mPreviousLayoutItemCount=" + this.f3234b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f3235c + ", mStructureChanged=" + this.f3238f + ", mInPreLayout=" + this.f3239g + ", mRunSimpleAnimations=" + this.f3242j + ", mRunPredictiveAnimations=" + this.f3243k + '}';
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$v */
    public static abstract class C1043v {
        /* renamed from: a */
        public abstract View mo5798a(C1034p pVar, int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$w */
    class C1044w implements Runnable {

        /* renamed from: a */
        OverScroller f3250a;

        /* renamed from: b */
        Interpolator f3251b = RecyclerView.sQuinticInterpolator;

        /* renamed from: d */
        private int f3253d;

        /* renamed from: e */
        private int f3254e;

        /* renamed from: f */
        private boolean f3255f = false;

        /* renamed from: g */
        private boolean f3256g = false;

        C1044w() {
            this.f3250a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        /* renamed from: a */
        private float m3996a(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        /* renamed from: a */
        private int m3997a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f = (float) width;
            float f2 = (float) i6;
            float a = f2 + (m3996a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, RecyclerView.MAX_SCROLL_DURATION);
        }

        /* renamed from: c */
        private void m3998c() {
            RecyclerView.this.removeCallbacks(this);
            C0656u.m2597a((View) RecyclerView.this, (Runnable) this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5799a() {
            if (this.f3255f) {
                this.f3256g = true;
            } else {
                m3998c();
            }
        }

        /* renamed from: a */
        public void mo5800a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f3254e = 0;
            this.f3253d = 0;
            if (this.f3251b != RecyclerView.sQuinticInterpolator) {
                this.f3251b = RecyclerView.sQuinticInterpolator;
                this.f3250a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
            }
            this.f3250a.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            mo5799a();
        }

        /* renamed from: a */
        public void mo5801a(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = m3997a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f3251b != interpolator) {
                this.f3251b = interpolator;
                this.f3250a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f3254e = 0;
            this.f3253d = 0;
            RecyclerView.this.setScrollState(2);
            this.f3250a.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f3250a.computeScrollOffset();
            }
            mo5799a();
        }

        /* renamed from: b */
        public void mo5802b() {
            RecyclerView.this.removeCallbacks(this);
            this.f3250a.abortAnimation();
        }

        public void run() {
            int i;
            int i2;
            if (RecyclerView.this.mLayout == null) {
                mo5802b();
                return;
            }
            this.f3256g = false;
            this.f3255f = true;
            RecyclerView.this.consumePendingUpdateOperations();
            OverScroller overScroller = this.f3250a;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f3253d;
                int i4 = currY - this.f3254e;
                this.f3253d = currX;
                this.f3254e = currY;
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.dispatchNestedPreScroll(i3, i4, recyclerView.mReusableIntPair, (int[]) null, 1)) {
                    i3 -= RecyclerView.this.mReusableIntPair[0];
                    i4 -= RecyclerView.this.mReusableIntPair[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView.this.mReusableIntPair[0] = 0;
                    RecyclerView.this.mReusableIntPair[1] = 0;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.scrollStep(i3, i4, recyclerView2.mReusableIntPair);
                    i2 = RecyclerView.this.mReusableIntPair[0];
                    i = RecyclerView.this.mReusableIntPair[1];
                    i3 -= i2;
                    i4 -= i;
                    C1039t tVar = RecyclerView.this.mLayout.mSmoothScroller;
                    if (tVar != null && !tVar.isPendingInitialRun() && tVar.isRunning()) {
                        int e = RecyclerView.this.mState.mo5796e();
                        if (e == 0) {
                            tVar.stop();
                        } else {
                            if (tVar.getTargetPosition() >= e) {
                                tVar.setTargetPosition(e - 1);
                            }
                            tVar.onAnimation(i2, i);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.dispatchNestedScroll(i2, i, i3, i4, (int[]) null, 1, recyclerView3.mReusableIntPair);
                int i5 = i3 - RecyclerView.this.mReusableIntPair[0];
                int i6 = i4 - RecyclerView.this.mReusableIntPair[1];
                if (!(i2 == 0 && i == 0)) {
                    RecyclerView.this.dispatchOnScrolled(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                C1039t tVar2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((tVar2 != null && tVar2.isPendingInitialRun()) || !z) {
                    mo5799a();
                    if (RecyclerView.this.mGapWorker != null) {
                        RecyclerView.this.mGapWorker.mo6007a(RecyclerView.this, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.mo6012a();
                    }
                }
            }
            C1039t tVar3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (tVar3 != null && tVar3.isPendingInitialRun()) {
                tVar3.onAnimation(0, 0);
            }
            this.f3255f = false;
            if (this.f3256g) {
                m3998c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$x */
    public static abstract class C1045x {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        C1034p mScrapContainer = null;
        C1045x mShadowedHolder = null;
        C1045x mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public C1045x(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && C0656u.m2615d(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !C0656u.m2615d(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((C1027j) this.itemView.getLayoutParams()).f3207e = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i == -1) {
                i = C0656u.m2619f(this.itemView);
            }
            this.mWasImportantForAccessibilityBeforeHidden = i;
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i;
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int i2 = this.mIsRecyclableCount;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                i = this.mFlags | 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                i = this.mFlags & -17;
            } else {
                return;
            }
            this.mFlags = i;
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(C1034p pVar, boolean z) {
            this.mScrapContainer = pVar;
            this.mInChangeScrap = z;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.mo5746c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0993a.C0994a.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new C1036r();
        this.mRecycler = new C1034p();
        this.mViewInfoStore = new C1101q();
        this.mUpdateChildViewsRunnable = new Runnable() {
            public void run() {
                if (RecyclerView.this.mFirstLayoutComplete && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.mIsAttached) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.mLayoutSuppressed) {
                        RecyclerView.this.mLayoutWasDefered = true;
                    } else {
                        RecyclerView.this.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new C1015e();
        this.mItemAnimator = new C1061c();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new C1044w();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new C1077e.C1079a() : null;
        this.mState = new C1042u();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new C1020g();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() {
            public void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.mo5550a();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new C1101q.C1103b() {
            /* renamed from: a */
            public void mo5480a(C1045x xVar) {
                RecyclerView.this.mLayout.removeAndRecycleView(xVar.itemView, RecyclerView.this.mRecycler);
            }

            /* renamed from: a */
            public void mo5481a(C1045x xVar, C1016f.C1019c cVar, C1016f.C1019c cVar2) {
                RecyclerView.this.mRecycler.mo5746c(xVar);
                RecyclerView.this.animateDisappearance(xVar, cVar, cVar2);
            }

            /* renamed from: b */
            public void mo5482b(C1045x xVar, C1016f.C1019c cVar, C1016f.C1019c cVar2) {
                RecyclerView.this.animateAppearance(xVar, cVar, cVar2);
            }

            /* renamed from: c */
            public void mo5483c(C1045x xVar, C1016f.C1019c cVar, C1016f.C1019c cVar2) {
                xVar.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (!RecyclerView.this.mItemAnimator.mo5553a(xVar, xVar, cVar, cVar2)) {
                        return;
                    }
                } else if (!RecyclerView.this.mItemAnimator.mo5557c(xVar, cVar, cVar2)) {
                    return;
                }
                RecyclerView.this.postAnimationRunner();
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = C0665v.m2680a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = C0665v.m2682b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.mo5551a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (C0656u.m2619f(this) == 0) {
            C0656u.m2606b((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C1091l(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0993a.C0996c.RecyclerView, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, C0993a.C0996c.RecyclerView, attributeSet, obtainStyledAttributes, i, 0);
        }
        String string = obtainStyledAttributes.getString(C0993a.C0996c.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(C0993a.C0996c.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(PKIFailureInfo.transactionIdInUse);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(C0993a.C0996c.RecyclerView_android_clipToPadding, true);
        this.mEnableFastScroller = obtainStyledAttributes.getBoolean(C0993a.C0996c.RecyclerView_fastScrollEnabled, false);
        if (this.mEnableFastScroller) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(C0993a.C0996c.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(C0993a.C0996c.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(C0993a.C0996c.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(C0993a.C0996c.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i, 0);
            }
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    private void addAnimatingView(C1045x xVar) {
        View view = xVar.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.mo5746c(getChildViewHolder(view));
        if (xVar.isTmpDetached()) {
            this.mChildHelper.mo5945a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.mo5947a(view, true);
        } else {
            this.mChildHelper.mo5955d(view);
        }
    }

    private void animateChange(C1045x xVar, C1045x xVar2, C1016f.C1019c cVar, C1016f.C1019c cVar2, boolean z, boolean z2) {
        xVar.setIsRecyclable(false);
        if (z) {
            addAnimatingView(xVar);
        }
        if (xVar != xVar2) {
            if (z2) {
                addAnimatingView(xVar2);
            }
            xVar.mShadowedHolder = xVar2;
            addAnimatingView(xVar);
            this.mRecycler.mo5746c(xVar);
            xVar2.setIsRecyclable(false);
            xVar2.mShadowingHolder = xVar;
        }
        if (this.mItemAnimator.mo5553a(xVar, xVar2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(C1045x xVar) {
        if (xVar.mNestedRecyclerView != null) {
            Object obj = xVar.mNestedRecyclerView.get();
            while (true) {
                View view = (View) obj;
                while (true) {
                    if (view == null) {
                        xVar.mNestedRecyclerView = null;
                        return;
                    } else if (view != xVar.itemView) {
                        obj = view.getParent();
                        if (!(obj instanceof View)) {
                            view = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(C1022i.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C1022i) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                } catch (ClassNotFoundException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e3);
                } catch (InvocationTargetException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e4);
                } catch (InstantiationException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e7);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0613b.m2402a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        boolean z = true;
        this.mState.mo5790a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f3241i = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.mo6084a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        C1042u uVar = this.mState;
        if (!uVar.f3242j || !this.mItemsChanged) {
            z = false;
        }
        uVar.f3240h = z;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        C1042u uVar2 = this.mState;
        uVar2.f3239g = uVar2.f3243k;
        this.mState.f3237e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f3242j) {
            int b = this.mChildHelper.mo5948b();
            for (int i = 0; i < b; i++) {
                C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5950b(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.mo6086a(childViewHolderInt, this.mItemAnimator.mo5549a(this.mState, childViewHolderInt, C1016f.m3878e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f3240h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.mo6085a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f3243k) {
            saveOldPositions();
            boolean z2 = this.mState.f3238f;
            C1042u uVar3 = this.mState;
            uVar3.f3238f = false;
            this.mLayout.onLayoutChildren(this.mRecycler, uVar3);
            this.mState.f3238f = z2;
            for (int i2 = 0; i2 < this.mChildHelper.mo5948b(); i2++) {
                C1045x childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.mo5950b(i2));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.mo6094d(childViewHolderInt2)) {
                    int e = C1016f.m3878e(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(PKIFailureInfo.certRevoked);
                    if (!hasAnyOfTheFlags) {
                        e |= 4096;
                    }
                    C1016f.C1019c a = this.mItemAnimator.mo5549a(this.mState, childViewHolderInt2, e, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, a);
                    } else {
                        this.mViewInfoStore.mo6091b(childViewHolderInt2, a);
                    }
                }
            }
        }
        clearOldPositions();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f3236d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.mo5790a(6);
        this.mAdapterHelper.mo5936e();
        this.mState.f3237e = this.mAdapter.getItemCount();
        C1042u uVar = this.mState;
        uVar.f3235c = 0;
        uVar.f3239g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, uVar);
        C1042u uVar2 = this.mState;
        uVar2.f3238f = false;
        this.mPendingSavedState = null;
        uVar2.f3242j = uVar2.f3242j && this.mItemAnimator != null;
        this.mState.f3236d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.mo5790a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C1042u uVar = this.mState;
        uVar.f3236d = 1;
        if (uVar.f3242j) {
            for (int b = this.mChildHelper.mo5948b() - 1; b >= 0; b--) {
                C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5950b(b));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    C1016f.C1019c a = this.mItemAnimator.mo5548a(this.mState, childViewHolderInt);
                    C1045x a2 = this.mViewInfoStore.mo6083a(changedHolderKey);
                    if (a2 != null && !a2.shouldIgnore()) {
                        boolean a3 = this.mViewInfoStore.mo6088a(a2);
                        boolean a4 = this.mViewInfoStore.mo6088a(childViewHolderInt);
                        if (!a3 || a2 != childViewHolderInt) {
                            C1016f.C1019c b2 = this.mViewInfoStore.mo6089b(a2);
                            this.mViewInfoStore.mo6093c(childViewHolderInt, a);
                            C1016f.C1019c c = this.mViewInfoStore.mo6092c(childViewHolderInt);
                            if (b2 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a2);
                            } else {
                                animateChange(a2, childViewHolderInt, b2, c, a3, a4);
                            }
                        }
                    }
                    this.mViewInfoStore.mo6093c(childViewHolderInt, a);
                }
            }
            this.mViewInfoStore.mo6087a(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        C1042u uVar2 = this.mState;
        uVar2.f3234b = uVar2.f3237e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        C1042u uVar3 = this.mState;
        uVar3.f3242j = false;
        uVar3.f3243k = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.f3216b != null) {
            this.mRecycler.f3216b.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            C1022i iVar = this.mLayout;
            iVar.mPrefetchMaxCountObserved = 0;
            iVar.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.mo5738b();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.mo6084a();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        C1030m mVar = this.mInterceptingOnItemTouchListener;
        if (mVar != null) {
            mVar.mo5709b(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i = 0;
        while (i < size) {
            C1030m mVar = this.mOnItemTouchListeners.get(i);
            if (!mVar.mo5708a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.mInterceptingOnItemTouchListener = mVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int b = this.mChildHelper.mo5948b();
        if (b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < b; i3++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5950b(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        C1045x findViewHolderForAdapterPosition;
        int i = this.mState.f3244l != -1 ? this.mState.f3244l : 0;
        int e = this.mState.mo5796e();
        int i2 = i;
        while (i2 < e) {
            C1045x findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            } else {
                i2++;
            }
        }
        int min = Math.min(e, i);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    static C1045x getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((C1027j) view.getLayoutParams()).f3205c;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        C1027j jVar = (C1027j) view.getLayoutParams();
        Rect rect2 = jVar.f3206d;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id;
        loop0:
        while (true) {
            id = view.getId();
            while (true) {
                if (view.isFocused() || !(view instanceof ViewGroup) || !view.hasFocus()) {
                    return id;
                }
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                }
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + FilenameUtils.EXTENSION_SEPARATOR + str;
        }
    }

    private C0647l getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new C0647l(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j, C1045x xVar, C1045x xVar2) {
        int b = this.mChildHelper.mo5948b();
        for (int i = 0; i < b; i++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5950b(i));
            if (childViewHolderInt != xVar && getChangedHolderKey(childViewHolderInt) == j) {
                C1011a aVar = this.mAdapter;
                if (aVar == null || !aVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + xVar + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + xVar + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + xVar2 + " cannot be found but it is necessary for " + xVar + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int b = this.mChildHelper.mo5948b();
        for (int i = 0; i < b; i++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5950b(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (C0656u.m2580a(this) == 0) {
            C0656u.m2584a((View) this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new C1058b(new C1058b.C1060b() {
            /* renamed from: a */
            public int mo5484a() {
                return RecyclerView.this.getChildCount();
            }

            /* renamed from: a */
            public int mo5485a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            /* renamed from: a */
            public void mo5486a(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            /* renamed from: a */
            public void mo5487a(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.dispatchChildAttached(view);
            }

            /* renamed from: a */
            public void mo5488a(View view, int i, ViewGroup.LayoutParams layoutParams) {
                C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.clearTmpDetachFlag();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            /* renamed from: b */
            public View mo5489b(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            /* renamed from: b */
            public C1045x mo5490b(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            /* renamed from: b */
            public void mo5491b() {
                int a = mo5484a();
                for (int i = 0; i < a; i++) {
                    View b = mo5489b(i);
                    RecyclerView.this.dispatchChildDetached(b);
                    b.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            /* renamed from: c */
            public void mo5492c(int i) {
                C1045x childViewHolderInt;
                View b = mo5489b(i);
                if (!(b == null || (childViewHolderInt = RecyclerView.getChildViewHolderInt(b)) == null)) {
                    if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            /* renamed from: c */
            public void mo5493c(View view) {
                C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            /* renamed from: d */
            public void mo5494d(View view) {
                C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }
        });
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        int i2 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        int i3 = ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) ? 1 : ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c = 0;
        }
        if (i == 17) {
            return i3 < 0;
        }
        if (i == 33) {
            return c < 0;
        }
        if (i == 66) {
            return i3 > 0;
        }
        if (i == 130) {
            return c > 0;
        }
        switch (i) {
            case 1:
                return c < 0 || (c == 0 && i3 * i2 <= 0);
            case 2:
                return c > 0 || (c == 0 && i3 * i2 >= 0);
            default:
                throw new IllegalArgumentException("Invalid direction: " + i + exceptionLabel());
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.mo5922a();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.mo5930b();
        } else {
            this.mAdapterHelper.mo5936e();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f3242j = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        C1042u uVar = this.mState;
        if (uVar.f3242j && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        uVar.f3243k = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L_0x001c:
            androidx.core.widget.C0682d.m2789a(r3, r4, r9)
            r9 = 1
            goto L_0x0039
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0038
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L_0x001c
        L_0x0038:
            r9 = 0
        L_0x0039:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0053
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.C0682d.m2789a(r9, r0, r7)
            goto L_0x006f
        L_0x0053:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x006e
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.C0682d.m2789a(r9, r3, r0)
            goto L_0x006f
        L_0x006e:
            r1 = r9
        L_0x006f:
            if (r1 != 0) goto L_0x0079
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0079
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007c
        L_0x0079:
            androidx.core.p030h.C0656u.m2617e(r6)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View view;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.mo5953c(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.mo5948b() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view2 = null;
                C1045x findViewHolderForItemId = (this.mState.f3245m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f3245m);
                if (findViewHolderForItemId != null && !this.mChildHelper.mo5953c(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view2 = findViewHolderForItemId.itemView;
                } else if (this.mChildHelper.mo5948b() > 0) {
                    view2 = findNextViewToFocus();
                }
                if (view2 != null) {
                    if (((long) this.mState.f3246n) == -1 || (view = view2.findViewById(this.mState.f3246n)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            C0656u.m2617e(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C1027j) {
            C1027j jVar = (C1027j) layoutParams;
            if (!jVar.f3207e) {
                Rect rect = jVar.f3206d;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        C1042u uVar = this.mState;
        uVar.f3245m = -1;
        uVar.f3244l = -1;
        uVar.f3246n = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        C1045x xVar = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            xVar = findContainingViewHolder(focusedChild);
        }
        if (xVar == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f3245m = this.mAdapter.hasStableIds() ? xVar.getItemId() : -1;
        this.mState.f3244l = this.mDataSetHasChangedAfterLayout ? -1 : xVar.isRemoved() ? xVar.mOldPosition : xVar.getAdapterPosition();
        this.mState.f3246n = getDeepestFocusedViewWithId(xVar.itemView);
    }

    private void setAdapterInternal(C1011a aVar, boolean z, boolean z2) {
        C1011a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.mo5922a();
        C1011a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mObserver);
            aVar.onAttachedToRecyclerView(this);
        }
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            iVar.onAdapterChanged(aVar3, this.mAdapter);
        }
        this.mRecycler.mo5731a(aVar3, this.mAdapter, z);
        this.mState.f3238f = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.mo5802b();
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            iVar.stopSmoothScroller();
        }
    }

    /* access modifiers changed from: package-private */
    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i != 0 || i2 != 0) {
            C0656u.m2617e(this);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C1022i iVar = this.mLayout;
        if (iVar == null || !iVar.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(C1021h hVar) {
        addItemDecoration(hVar, -1);
    }

    public void addItemDecoration(C1021h hVar, int i) {
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(hVar);
        } else {
            this.mItemDecorations.add(i, hVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(C1028k kVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(kVar);
    }

    public void addOnItemTouchListener(C1030m mVar) {
        this.mOnItemTouchListeners.add(mVar);
    }

    public void addOnScrollListener(C1031n nVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(nVar);
    }

    /* access modifiers changed from: package-private */
    public void animateAppearance(C1045x xVar, C1016f.C1019c cVar, C1016f.C1019c cVar2) {
        xVar.setIsRecyclable(false);
        if (this.mItemAnimator.mo5556b(xVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void animateDisappearance(C1045x xVar, C1016f.C1019c cVar, C1016f.C1019c cVar2) {
        addAnimatingView(xVar);
        xVar.setIsRecyclable(false);
        if (this.mItemAnimator.mo5552a(xVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canReuseUpdatedViewHolder(C1045x xVar) {
        C1016f fVar = this.mItemAnimator;
        return fVar == null || fVar.mo5554a(xVar, xVar.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C1027j) && this.mLayout.checkLayoutParams((C1027j) layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void clearOldPositions() {
        int c = this.mChildHelper.mo5951c();
        for (int i = 0; i < c; i++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.mo5756i();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<C1028k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<C1031n> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        C1022i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        C1022i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        C1022i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        C1022i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        C1022i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        C1022i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            C0656u.m2617e(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            C0547b.m2169a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            C0547b.m2168a();
        } else if (this.mAdapterHelper.mo5935d()) {
            if (this.mAdapterHelper.mo5926a(4) && !this.mAdapterHelper.mo5926a(11)) {
                C0547b.m2169a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.mo5930b();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.mo5933c();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
            } else if (this.mAdapterHelper.mo5935d()) {
                C0547b.m2169a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
            } else {
                return;
            }
            C0547b.m2168a();
        }
    }

    /* access modifiers changed from: package-private */
    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(C1022i.chooseSize(i, getPaddingLeft() + getPaddingRight(), C0656u.m2628k(this)), C1022i.chooseSize(i2, getPaddingTop() + getPaddingBottom(), C0656u.m2629l(this)));
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildAttached(View view) {
        C1045x childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        C1011a aVar = this.mAdapter;
        if (!(aVar == null || childViewHolderInt == null)) {
            aVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<C1028k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).mo5704a(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildDetached(View view) {
        C1045x childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        C1011a aVar = this.mAdapter;
        if (!(aVar == null || childViewHolderInt == null)) {
            aVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<C1028k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).mo5705b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchLayout() {
        String str;
        String str2;
        if (this.mAdapter == null) {
            str = TAG;
            str2 = "No adapter attached; skipping layout";
        } else if (this.mLayout == null) {
            str = TAG;
            str2 = "No layout manager attached; skipping layout";
        } else {
            C1042u uVar = this.mState;
            uVar.f3241i = false;
            if (uVar.f3236d == 1) {
                dispatchLayoutStep1();
            } else if (!this.mAdapterHelper.mo5937f() && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep3();
                return;
            }
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
            dispatchLayoutStep3();
            return;
        }
        Log.e(str, str2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().mo3802a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().mo3801a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().mo3807a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().mo3808a(i, i2, iArr, iArr2, i3);
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().mo3798a(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().mo3805a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().mo3806a(i, i2, i3, i4, iArr, i5);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrollStateChanged(int i) {
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            iVar.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        C1031n nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrollStateChanged(this, i);
        }
        List<C1031n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        C1031n nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrolled(this, i, i2);
        }
        List<C1031n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    /* access modifiers changed from: package-private */
    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            C1045x xVar = this.mPendingAccessibilityImportanceChange.get(size);
            if (xVar.itemView.getParent() == this && !xVar.shouldIgnore() && (i = xVar.mPendingAccessibilityState) != -1) {
                C0656u.m2606b(xVar.itemView, i);
                xVar.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        int i;
        float f;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                f = (float) ((-getWidth()) + getPaddingRight());
                i = (-getHeight()) + getPaddingBottom();
            } else {
                f = (float) (-getWidth());
                i = -getHeight();
            }
            canvas.translate(f, (float) i);
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.mo5555b()) {
            z2 = true;
        }
        if (z2) {
            C0656u.m2617e(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* access modifiers changed from: package-private */
    public void ensureBottomGlow() {
        int i;
        int i2;
        EdgeEffect edgeEffect;
        if (this.mBottomGlow == null) {
            this.mBottomGlow = this.mEdgeEffectFactory.mo5547a(this, 3);
            if (this.mClipToPadding) {
                edgeEffect = this.mBottomGlow;
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                edgeEffect = this.mBottomGlow;
                i2 = getMeasuredWidth();
                i = getMeasuredHeight();
            }
            edgeEffect.setSize(i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureLeftGlow() {
        int i;
        int i2;
        EdgeEffect edgeEffect;
        if (this.mLeftGlow == null) {
            this.mLeftGlow = this.mEdgeEffectFactory.mo5547a(this, 0);
            if (this.mClipToPadding) {
                edgeEffect = this.mLeftGlow;
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                edgeEffect = this.mLeftGlow;
                i2 = getMeasuredHeight();
                i = getMeasuredWidth();
            }
            edgeEffect.setSize(i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureRightGlow() {
        int i;
        int i2;
        EdgeEffect edgeEffect;
        if (this.mRightGlow == null) {
            this.mRightGlow = this.mEdgeEffectFactory.mo5547a(this, 2);
            if (this.mClipToPadding) {
                edgeEffect = this.mRightGlow;
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                edgeEffect = this.mRightGlow;
                i2 = getMeasuredHeight();
                i = getMeasuredWidth();
            }
            edgeEffect.setSize(i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureTopGlow() {
        int i;
        int i2;
        EdgeEffect edgeEffect;
        if (this.mTopGlow == null) {
            this.mTopGlow = this.mEdgeEffectFactory.mo5547a(this, 1);
            if (this.mClipToPadding) {
                edgeEffect = this.mTopGlow;
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                edgeEffect = this.mTopGlow;
                i2 = getMeasuredWidth();
                i = getMeasuredHeight();
            }
            edgeEffect.setSize(i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    /* access modifiers changed from: package-private */
    public final void fillRemainingScrollValues(C1042u uVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f3250a;
            uVar.f3247o = overScroller.getFinalX() - overScroller.getCurrX();
            uVar.f3248p = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        uVar.f3247o = 0;
        uVar.f3248p = 0;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int b = this.mChildHelper.mo5948b() - 1; b >= 0; b--) {
            View b2 = this.mChildHelper.mo5950b(b);
            float translationX = b2.getTranslationX();
            float translationY = b2.getTranslationY();
            if (f >= ((float) b2.getLeft()) + translationX && f <= ((float) b2.getRight()) + translationX && f2 >= ((float) b2.getTop()) + translationY && f2 <= ((float) b2.getBottom()) + translationY) {
                return b2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
        L_0x0000:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L_0x0010
            if (r0 == r2) goto L_0x0010
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x0010
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L_0x0000
        L_0x0010:
            if (r0 != r2) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public C1045x findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public C1045x findViewHolderForAdapterPosition(int i) {
        C1045x xVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int c = this.mChildHelper.mo5951c();
        for (int i2 = 0; i2 < c; i2++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                if (!this.mChildHelper.mo5953c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                xVar = childViewHolderInt;
            }
        }
        return xVar;
    }

    public C1045x findViewHolderForItemId(long j) {
        C1011a aVar = this.mAdapter;
        C1045x xVar = null;
        if (aVar != null && aVar.hasStableIds()) {
            int c = this.mChildHelper.mo5951c();
            for (int i = 0; i < c; i++) {
                C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (!this.mChildHelper.mo5953c(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    xVar = childViewHolderInt;
                }
            }
        }
        return xVar;
    }

    public C1045x findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Deprecated
    public C1045x findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    /* access modifiers changed from: package-private */
    public C1045x findViewHolderForPosition(int i, boolean z) {
        int c = this.mChildHelper.mo5951c();
        C1045x xVar = null;
        for (int i2 = 0; i2 < c; i2++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i) {
                    continue;
                }
                if (!this.mChildHelper.mo5953c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                xVar = childViewHolderInt;
            }
        }
        return xVar;
    }

    public boolean fling(int i, int i2) {
        C1022i iVar = this.mLayout;
        int i3 = 0;
        if (iVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean canScrollHorizontally = iVar.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) {
                i = 0;
            }
            if (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f = (float) i;
            float f2 = (float) i2;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f, f2, z);
                C1029l lVar = this.mOnFlingListener;
                if (lVar != null && lVar.mo5706a(i, i2)) {
                    return true;
                }
                if (z) {
                    if (canScrollHorizontally) {
                        i3 = 1;
                    }
                    if (canScrollVertically) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3, 1);
                    int i4 = this.mMaxFlingVelocity;
                    int max = Math.max(-i4, Math.min(i, i4));
                    int i5 = this.mMaxFlingVelocity;
                    this.mViewFlinger.mo5800a(max, Math.max(-i5, Math.min(i2, i5)));
                    return true;
                }
            }
            return false;
        }
    }

    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z2 || !(i == 2 || i == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus != null || !z2) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.canScrollVertically()) {
                int i2 = i == 2 ? 130 : 33;
                z = instance.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i3 = (this.mLayout.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                z = instance.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i);
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i) ? view2 : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        requestChildOnScreen(view2, (View) null);
        return view;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public C1011a getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: package-private */
    public int getAdapterPositionFor(C1045x xVar) {
        if (xVar.hasAnyOfTheFlags(524) || !xVar.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.mo5932c(xVar.mPosition);
    }

    public int getBaseline() {
        C1022i iVar = this.mLayout;
        return iVar != null ? iVar.getBaseline() : super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public long getChangedHolderKey(C1045x xVar) {
        return this.mAdapter.hasStableIds() ? xVar.getItemId() : (long) xVar.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        C1045x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        C1014d dVar = this.mChildDrawingOrderCallback;
        return dVar == null ? super.getChildDrawingOrder(i, i2) : dVar.mo5546a(i, i2);
    }

    public long getChildItemId(View view) {
        C1045x childViewHolderInt;
        C1011a aVar = this.mAdapter;
        if (aVar == null || !aVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        C1045x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public C1045x getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public C1091l getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public C1015e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public C1016f getItemAnimator() {
        return this.mItemAnimator;
    }

    /* access modifiers changed from: package-private */
    public Rect getItemDecorInsetsForChild(View view) {
        C1027j jVar = (C1027j) view.getLayoutParams();
        if (!jVar.f3207e) {
            return jVar.f3206d;
        }
        if (this.mState.mo5792a() && (jVar.mo5702e() || jVar.mo5700c())) {
            return jVar.f3206d;
        }
        Rect rect = jVar.f3206d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        jVar.f3207e = false;
        return rect;
    }

    public C1021h getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public C1022i getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public C1029l getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public C1032o getRecycledViewPool() {
        return this.mRecycler.mo5754g();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().mo3809b();
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().mo3803a(i);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.mo5935d();
    }

    /* access modifiers changed from: package-private */
    public void initAdapterManager() {
        this.mAdapterHelper = new C1055a(new C1055a.C1056a() {
            /* renamed from: a */
            public C1045x mo5495a(int i) {
                C1045x findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.mo5953c(findViewHolderForPosition.itemView)) {
                    return findViewHolderForPosition;
                }
                return null;
            }

            /* renamed from: a */
            public void mo5496a(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.f3235c += i2;
            }

            /* renamed from: a */
            public void mo5497a(int i, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(i, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            /* renamed from: a */
            public void mo5498a(C1055a.C1057b bVar) {
                mo5502c(bVar);
            }

            /* renamed from: b */
            public void mo5499b(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            /* renamed from: b */
            public void mo5500b(C1055a.C1057b bVar) {
                mo5502c(bVar);
            }

            /* renamed from: c */
            public void mo5501c(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: c */
            public void mo5502c(C1055a.C1057b bVar) {
                int i = bVar.f3321a;
                if (i == 4) {
                    RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, bVar.f3322b, bVar.f3324d, bVar.f3323c);
                } else if (i != 8) {
                    switch (i) {
                        case 1:
                            RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, bVar.f3322b, bVar.f3324d);
                            return;
                        case 2:
                            RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, bVar.f3322b, bVar.f3324d);
                            return;
                        default:
                            return;
                    }
                } else {
                    RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, bVar.f3322b, bVar.f3324d, 1);
                }
            }

            /* renamed from: d */
            public void mo5503d(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new C1072d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(C0993a.C0995b.fastscroll_default_thickness), resources.getDimensionPixelSize(C0993a.C0995b.fastscroll_minimum_range), resources.getDimensionPixelOffset(C0993a.C0995b.fastscroll_margin));
    }

    /* access modifiers changed from: package-private */
    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            C1022i iVar = this.mLayout;
            if (iVar != null) {
                iVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        C1016f fVar = this.mItemAnimator;
        return fVar != null && fVar.mo5555b();
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().mo3800a();
    }

    /* access modifiers changed from: package-private */
    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void markItemDecorInsetsDirty() {
        int c = this.mChildHelper.mo5951c();
        for (int i = 0; i < c; i++) {
            ((C1027j) this.mChildHelper.mo5954d(i).getLayoutParams()).f3207e = true;
        }
        this.mRecycler.mo5757j();
    }

    /* access modifiers changed from: package-private */
    public void markKnownViewsInvalid() {
        int c = this.mChildHelper.mo5951c();
        for (int i = 0; i < c; i++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.mo5755h();
    }

    public void offsetChildrenHorizontal(int i) {
        int b = this.mChildHelper.mo5948b();
        for (int i2 = 0; i2 < b; i2++) {
            this.mChildHelper.mo5950b(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int b = this.mChildHelper.mo5948b();
        for (int i2 = 0; i2 < b; i2++) {
            this.mChildHelper.mo5950b(i2).offsetTopAndBottom(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForInsert(int i, int i2) {
        int c = this.mChildHelper.mo5951c();
        for (int i3 = 0; i3 < c; i3++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.f3238f = true;
            }
        }
        this.mRecycler.mo5739b(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int c = this.mChildHelper.mo5951c();
        if (i < i2) {
            i5 = i;
            i4 = i2;
            i3 = -1;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i6 = 0; i6 < c; i6++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i6));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i5 && childViewHolderInt.mPosition <= i4) {
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i3, false);
                }
                this.mState.f3238f = true;
            }
        }
        this.mRecycler.mo5728a(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.mChildHelper.mo5951c();
        for (int i4 = 0; i4 < c; i4++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                }
                this.mState.f3238f = true;
            }
        }
        this.mRecycler.mo5729a(i, i2, z);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.mLayoutOrScrollCounter = r0
            r1 = 1
            r4.mIsAttached = r1
            boolean r2 = r4.mFirstLayoutComplete
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.mLayout
            if (r1 == 0) goto L_0x001e
            r1.dispatchAttachedToWindow(r4)
        L_0x001e:
            r4.mPostedAnimatorRunner = r0
            boolean r0 = ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L_0x0069
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.C1077e.f3417a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.e r0 = (androidx.recyclerview.widget.C1077e) r0
            r4.mGapWorker = r0
            androidx.recyclerview.widget.e r0 = r4.mGapWorker
            if (r0 != 0) goto L_0x0064
            androidx.recyclerview.widget.e r0 = new androidx.recyclerview.widget.e
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = androidx.core.p030h.C0656u.m2571D(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x0052
            if (r0 == 0) goto L_0x0052
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x0054:
            androidx.recyclerview.widget.e r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f3421d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.C1077e.f3417a
            androidx.recyclerview.widget.e r1 = r4.mGapWorker
            r0.set(r1)
        L_0x0064:
            androidx.recyclerview.widget.e r0 = r4.mGapWorker
            r0.mo6006a((androidx.recyclerview.widget.RecyclerView) r4)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        C1077e eVar;
        super.onDetachedFromWindow();
        C1016f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.mo5558d();
        }
        stopScroll();
        this.mIsAttached = false;
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            iVar.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.mo6090b();
        if (ALLOW_THREAD_GAP_WORK && (eVar = this.mGapWorker) != null) {
            eVar.mo6008b(this);
            this.mGapWorker = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    /* access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    f = motionEvent.getAxisValue(10);
                    if (!(f2 == 0.0f && f == 0.0f)) {
                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f2 = -axisValue;
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f = axisValue;
                        f2 = 0.0f;
                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f2 = 0.0f;
            }
            f = 0.0f;
            scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        C1022i iVar = this.mLayout;
        if (iVar == null) {
            return false;
        }
        boolean canScrollHorizontally = iVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                if (this.mIgnoreMotionEventTillDown) {
                    this.mIgnoreMotionEventTillDown = false;
                }
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y;
                this.mInitialTouchY = y;
                if (this.mScrollState == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    stopNestedScroll(1);
                }
                int[] iArr = this.mNestedOffsets;
                iArr[1] = 0;
                iArr[0] = 0;
                int i = canScrollHorizontally ? 1 : 0;
                if (canScrollVertically) {
                    i |= 2;
                }
                startNestedScroll(i, 0);
                break;
            case 1:
                this.mVelocityTracker.clear();
                stopNestedScroll(0);
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (findPointerIndex >= 0) {
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i2 = x2 - this.mInitialTouchX;
                        int i3 = y2 - this.mInitialTouchY;
                        if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                            z = false;
                        } else {
                            this.mLastTouchX = x2;
                            z = true;
                        }
                        if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                            this.mLastTouchY = y2;
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                            break;
                        }
                    }
                } else {
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                break;
            case 3:
                cancelScroll();
                break;
            case 5:
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x3;
                this.mInitialTouchX = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y3;
                this.mInitialTouchY = y3;
                break;
            case 6:
                onPointerUp(motionEvent);
                break;
        }
        return this.mScrollState == 1;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0547b.m2169a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        C0547b.m2168a();
        this.mFirstLayoutComplete = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        C1022i iVar = this.mLayout;
        if (iVar == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (iVar.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.mAdapter != null) {
                if (this.mState.f3236d == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i, i2);
                this.mState.f3241i = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f3241i = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.f3243k) {
                    this.mState.f3239g = true;
                } else {
                    this.mAdapterHelper.mo5936e();
                    this.mState.f3239g = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f3243k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            C1011a aVar = this.mAdapter;
            if (aVar != null) {
                this.mState.f3237e = aVar.getItemCount();
            } else {
                this.mState.f3237e = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.f3239g = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1037s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (C1037s) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        if (this.mLayout != null && this.mPendingSavedState.f3225a != null) {
            this.mLayout.onRestoreInstanceState(this.mPendingSavedState.f3225a);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C1037s sVar = new C1037s(super.onSaveInstanceState());
        C1037s sVar2 = this.mPendingSavedState;
        if (sVar2 != null) {
            sVar.mo5760a(sVar2);
        } else {
            C1022i iVar = this.mLayout;
            sVar.f3225a = iVar != null ? iVar.onSaveInstanceState() : null;
        }
        return sVar;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.mLayoutSuppressed
            r8 = 0
            if (r0 != 0) goto L_0x01db
            boolean r0 = r6.mIgnoreMotionEventTillDown
            if (r0 == 0) goto L_0x000f
            goto L_0x01db
        L_0x000f:
            boolean r0 = r17.dispatchToOnItemTouchListeners(r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.cancelScroll()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$i r0 = r6.mLayout
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$i r0 = r6.mLayout
            boolean r11 = r0.canScrollVertically()
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.mNestedOffsets
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.mNestedOffsets
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            switch(r0) {
                case 0: goto L_0x01aa;
                case 1: goto L_0x0168;
                case 2: goto L_0x007f;
                case 3: goto L_0x007a;
                case 4: goto L_0x0057;
                case 5: goto L_0x005e;
                case 6: goto L_0x0059;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x01d0
        L_0x0059:
            r17.onPointerUp(r18)
            goto L_0x01d0
        L_0x005e:
            int r0 = r7.getPointerId(r1)
            r6.mScrollPointerId = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            goto L_0x01d0
        L_0x007a:
            r17.cancelScroll()
            goto L_0x01d0
        L_0x007f:
            int r0 = r6.mScrollPointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00a5
            java.lang.String r0 = "RecyclerView"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error processing scroll; pointer index for id "
            r1.append(r2)
            int r2 = r6.mScrollPointerId
            r1.append(r2)
            java.lang.String r2 = " not found. Did any MotionEvents get skipped?"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r0, r1)
            return r8
        L_0x00a5:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.mLastTouchX
            int r0 = r0 - r13
            int r1 = r6.mLastTouchY
            int r1 = r1 - r14
            int r2 = r6.mScrollState
            if (r2 == r9) goto L_0x00ee
            if (r10 == 0) goto L_0x00d2
            if (r0 <= 0) goto L_0x00c7
            int r2 = r6.mTouchSlop
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00ce
        L_0x00c7:
            int r2 = r6.mTouchSlop
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00ce:
            if (r0 == 0) goto L_0x00d2
            r2 = 1
            goto L_0x00d3
        L_0x00d2:
            r2 = 0
        L_0x00d3:
            if (r11 == 0) goto L_0x00e9
            if (r1 <= 0) goto L_0x00df
            int r3 = r6.mTouchSlop
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00e6
        L_0x00df:
            int r3 = r6.mTouchSlop
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00e6:
            if (r1 == 0) goto L_0x00e9
            r2 = 1
        L_0x00e9:
            if (r2 == 0) goto L_0x00ee
            r6.setScrollState(r9)
        L_0x00ee:
            r15 = r0
            r16 = r1
            int r0 = r6.mScrollState
            if (r0 != r9) goto L_0x01d0
            int[] r0 = r6.mReusableIntPair
            r0[r8] = r8
            r0[r9] = r8
            if (r10 == 0) goto L_0x00ff
            r1 = r15
            goto L_0x0100
        L_0x00ff:
            r1 = 0
        L_0x0100:
            if (r11 == 0) goto L_0x0105
            r2 = r16
            goto L_0x0106
        L_0x0105:
            r2 = 0
        L_0x0106:
            int[] r3 = r6.mReusableIntPair
            int[] r4 = r6.mScrollOffset
            r5 = 0
            r0 = r17
            boolean r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0135
            int[] r0 = r6.mReusableIntPair
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.mNestedOffsets
            r1 = r0[r8]
            int[] r2 = r6.mScrollOffset
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x0135:
            r0 = r16
            int[] r1 = r6.mScrollOffset
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.mLastTouchX = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.mLastTouchY = r14
            if (r10 == 0) goto L_0x0147
            r1 = r15
            goto L_0x0148
        L_0x0147:
            r1 = 0
        L_0x0148:
            if (r11 == 0) goto L_0x014c
            r2 = r0
            goto L_0x014d
        L_0x014c:
            r2 = 0
        L_0x014d:
            boolean r1 = r6.scrollByInternal(r1, r2, r7)
            if (r1 == 0) goto L_0x015a
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x015a:
            androidx.recyclerview.widget.e r1 = r6.mGapWorker
            if (r1 == 0) goto L_0x01d0
            if (r15 != 0) goto L_0x0162
            if (r0 == 0) goto L_0x01d0
        L_0x0162:
            androidx.recyclerview.widget.e r1 = r6.mGapWorker
            r1.mo6007a((androidx.recyclerview.widget.RecyclerView) r6, (int) r15, (int) r0)
            goto L_0x01d0
        L_0x0168:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.mMaxFlingVelocity
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0184
            android.view.VelocityTracker r1 = r6.mVelocityTracker
            int r2 = r6.mScrollPointerId
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x0185
        L_0x0184:
            r1 = 0
        L_0x0185:
            if (r11 == 0) goto L_0x0191
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            int r3 = r6.mScrollPointerId
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x0192
        L_0x0191:
            r2 = 0
        L_0x0192:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x019a
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01a2
        L_0x019a:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.fling(r0, r1)
            if (r0 != 0) goto L_0x01a5
        L_0x01a2:
            r6.setScrollState(r8)
        L_0x01a5:
            r17.resetScroll()
            r8 = 1
            goto L_0x01d0
        L_0x01aa:
            int r0 = r7.getPointerId(r8)
            r6.mScrollPointerId = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            if (r10 == 0) goto L_0x01c8
            r0 = 1
            goto L_0x01c9
        L_0x01c8:
            r0 = 0
        L_0x01c9:
            if (r11 == 0) goto L_0x01cd
            r0 = r0 | 2
        L_0x01cd:
            r6.startNestedScroll(r0, r8)
        L_0x01d0:
            if (r8 != 0) goto L_0x01d7
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
        L_0x01d7:
            r12.recycle()
            return r9
        L_0x01db:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            C0656u.m2597a((View) this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    /* access modifiers changed from: package-private */
    public void recordAnimationInfoIfBouncedHiddenView(C1045x xVar, C1016f.C1019c cVar) {
        xVar.setFlags(0, PKIFailureInfo.certRevoked);
        if (this.mState.f3240h && xVar.isUpdated() && !xVar.isRemoved() && !xVar.shouldIgnore()) {
            this.mViewInfoStore.mo6085a(getChangedHolderKey(xVar), xVar);
        }
        this.mViewInfoStore.mo6086a(xVar, cVar);
    }

    /* access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        C1016f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.mo5558d();
        }
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            iVar.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.mo5726a();
    }

    /* access modifiers changed from: package-private */
    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean f = this.mChildHelper.mo5958f(view);
        if (f) {
            C1045x childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.mo5746c(childViewHolderInt);
            this.mRecycler.mo5741b(childViewHolderInt);
        }
        stopInterceptRequestLayout(!f);
        return f;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        C1045x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(C1021h hVar) {
        C1022i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(hVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeOnChildAttachStateChangeListener(C1028k kVar) {
        List<C1028k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(kVar);
        }
    }

    public void removeOnItemTouchListener(C1030m mVar) {
        this.mOnItemTouchListeners.remove(mVar);
        if (this.mInterceptingOnItemTouchListener == mVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(C1031n nVar) {
        List<C1031n> list = this.mScrollListeners;
        if (list != null) {
            list.remove(nVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void repositionShadowingViews() {
        int b = this.mChildHelper.mo5948b();
        for (int i = 0; i < b; i++) {
            View b2 = this.mChildHelper.mo5950b(i);
            C1045x childViewHolder = getChildViewHolder(b2);
            if (!(childViewHolder == null || childViewHolder.mShadowingHolder == null)) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).mo5707a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void saveOldPositions() {
        int c = this.mChildHelper.mo5951c();
        for (int i = 0; i < c; i++) {
            C1045x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5954d(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    public void scrollBy(int i, int i2) {
        C1022i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = iVar.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        MotionEvent motionEvent2 = motionEvent;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i7, i8, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i5 = i10;
            i6 = i9;
            i4 = i7 - i9;
            i3 = i8 - i10;
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        int i11 = i6;
        dispatchNestedScroll(i6, i5, i4, i3, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i12 = i4 - iArr4[0];
        int i13 = i3 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i14 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i14 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !C0643h.m2540a(motionEvent2, 8194)) {
                pullGlows(motionEvent.getX(), (float) i12, motionEvent.getY(), (float) i13);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        int i15 = i11;
        if (!(i15 == 0 && i5 == 0)) {
            dispatchOnScrolled(i15, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i15 == 0 && i5 == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C0547b.m2169a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        C0547b.m2168a();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            C1022i iVar = this.mLayout;
            if (iVar == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            iVar.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(C1091l lVar) {
        this.mAccessibilityDelegate = lVar;
        C0656u.m2594a((View) this, (C0610a) this.mAccessibilityDelegate);
    }

    public void setAdapter(C1011a aVar) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C1014d dVar) {
        if (dVar != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = dVar;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setChildImportantForAccessibilityInternal(C1045x xVar, int i) {
        if (isComputingLayout()) {
            xVar.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(xVar);
            return false;
        }
        C0656u.m2606b(xVar.itemView, i);
        return true;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(C1015e eVar) {
        C0588f.m2266a(eVar);
        this.mEdgeEffectFactory = eVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(C1016f fVar) {
        C1016f fVar2 = this.mItemAnimator;
        if (fVar2 != null) {
            fVar2.mo5558d();
            this.mItemAnimator.mo5551a((C1016f.C1018b) null);
        }
        this.mItemAnimator = fVar;
        C1016f fVar3 = this.mItemAnimator;
        if (fVar3 != null) {
            fVar3.mo5551a(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.mo5727a(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(C1022i iVar) {
        if (iVar != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                C1016f fVar = this.mItemAnimator;
                if (fVar != null) {
                    fVar.mo5558d();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.mo5726a();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView((RecyclerView) null);
                this.mLayout = null;
            } else {
                this.mRecycler.mo5726a();
            }
            this.mChildHelper.mo5942a();
            this.mLayout = iVar;
            if (iVar != null) {
                if (iVar.mRecyclerView == null) {
                    this.mLayout.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.mRecyclerView.exceptionLabel());
                }
            }
            this.mRecycler.mo5738b();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().mo3799a(z);
    }

    public void setOnFlingListener(C1029l lVar) {
        this.mOnFlingListener = lVar;
    }

    @Deprecated
    public void setOnScrollListener(C1031n nVar) {
        this.mScrollListener = nVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(C1032o oVar) {
        this.mRecycler.mo5732a(oVar);
    }

    public void setRecyclerListener(C1035q qVar) {
        this.mRecyclerListener = qVar;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void setScrollingTouchSlop(int i) {
        int i2;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                i2 = viewConfiguration.getScaledPagingTouchSlop();
                break;
            default:
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        i2 = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop = i2;
    }

    public void setViewCacheExtension(C1043v vVar) {
        this.mRecycler.mo5733a(vVar);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int a = accessibilityEvent != null ? C0613b.m2401a(accessibilityEvent) : 0;
        if (a == 0) {
            a = 0;
        }
        this.mEatenAccessibilityChangeFlags = a | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, (Interpolator) null);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        C1022i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i4 = 0;
            if (!iVar.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                if (i3 == Integer.MIN_VALUE || i3 > 0) {
                    if (z) {
                        if (i != 0) {
                            i4 = 1;
                        }
                        if (i2 != 0) {
                            i4 |= 2;
                        }
                        startNestedScroll(i4, 1);
                    }
                    this.mViewFlinger.mo5801a(i, i2, i3, interpolator);
                    return;
                }
                scrollBy(i, i2);
            }
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            C1022i iVar = this.mLayout;
            if (iVar == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                iVar.smoothScrollToPosition(this, this.mState, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().mo3810b(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().mo3804a(i, i2);
    }

    /* access modifiers changed from: package-private */
    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().mo3811c();
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().mo3812c(i);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(C1011a aVar, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void viewRangeUpdate(int i, int i2, Object obj) {
        int c = this.mChildHelper.mo5951c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View d = this.mChildHelper.mo5954d(i4);
            C1045x childViewHolderInt = getChildViewHolderInt(d);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i3) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((C1027j) d.getLayoutParams()).f3207e = true;
            }
        }
        this.mRecycler.mo5744c(i, i2);
    }
}
