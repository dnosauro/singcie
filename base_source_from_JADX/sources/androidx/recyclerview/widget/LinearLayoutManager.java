package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.C1022i implements RecyclerView.C1039t.C1041b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final C1000a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final C1001b mLayoutChunkResult;
    private C1002c mLayoutState;
    int mOrientation;
    C1086j mOrientationHelper;
    C1003d mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$a */
    static class C1000a {

        /* renamed from: a */
        C1086j f3158a;

        /* renamed from: b */
        int f3159b;

        /* renamed from: c */
        int f3160c;

        /* renamed from: d */
        boolean f3161d;

        /* renamed from: e */
        boolean f3162e;

        C1000a() {
            mo5268a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5268a() {
            this.f3159b = -1;
            this.f3160c = Integer.MIN_VALUE;
            this.f3161d = false;
            this.f3162e = false;
        }

        /* renamed from: a */
        public void mo5269a(View view, int i) {
            int b = this.f3158a.mo6038b();
            if (b >= 0) {
                mo5272b(view, i);
                return;
            }
            this.f3159b = i;
            if (this.f3161d) {
                int d = (this.f3158a.mo6042d() - b) - this.f3158a.mo6039b(view);
                this.f3160c = this.f3158a.mo6042d() - d;
                if (d > 0) {
                    int e = this.f3160c - this.f3158a.mo6045e(view);
                    int c = this.f3158a.mo6040c();
                    int min = e - (c + Math.min(this.f3158a.mo6035a(view) - c, 0));
                    if (min < 0) {
                        this.f3160c += Math.min(d, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a = this.f3158a.mo6035a(view);
            int c2 = a - this.f3158a.mo6040c();
            this.f3160c = a;
            if (c2 > 0) {
                int d2 = (this.f3158a.mo6042d() - Math.min(0, (this.f3158a.mo6042d() - b) - this.f3158a.mo6039b(view))) - (a + this.f3158a.mo6045e(view));
                if (d2 < 0) {
                    this.f3160c -= Math.min(c2, -d2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5270a(View view, RecyclerView.C1042u uVar) {
            RecyclerView.C1027j jVar = (RecyclerView.C1027j) view.getLayoutParams();
            return !jVar.mo5701d() && jVar.mo5703f() >= 0 && jVar.mo5703f() < uVar.mo5796e();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5271b() {
            this.f3160c = this.f3161d ? this.f3158a.mo6042d() : this.f3158a.mo6040c();
        }

        /* renamed from: b */
        public void mo5272b(View view, int i) {
            this.f3160c = this.f3161d ? this.f3158a.mo6039b(view) + this.f3158a.mo6038b() : this.f3158a.mo6035a(view);
            this.f3159b = i;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3159b + ", mCoordinate=" + this.f3160c + ", mLayoutFromEnd=" + this.f3161d + ", mValid=" + this.f3162e + '}';
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$b */
    protected static class C1001b {

        /* renamed from: a */
        public int f3163a;

        /* renamed from: b */
        public boolean f3164b;

        /* renamed from: c */
        public boolean f3165c;

        /* renamed from: d */
        public boolean f3166d;

        protected C1001b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5274a() {
            this.f3163a = 0;
            this.f3164b = false;
            this.f3165c = false;
            this.f3166d = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$c */
    static class C1002c {

        /* renamed from: a */
        boolean f3167a = true;

        /* renamed from: b */
        int f3168b;

        /* renamed from: c */
        int f3169c;

        /* renamed from: d */
        int f3170d;

        /* renamed from: e */
        int f3171e;

        /* renamed from: f */
        int f3172f;

        /* renamed from: g */
        int f3173g;

        /* renamed from: h */
        int f3174h = 0;

        /* renamed from: i */
        int f3175i = 0;

        /* renamed from: j */
        boolean f3176j = false;

        /* renamed from: k */
        int f3177k;

        /* renamed from: l */
        List<RecyclerView.C1045x> f3178l = null;

        /* renamed from: m */
        boolean f3179m;

        C1002c() {
        }

        /* renamed from: b */
        private View m3835b() {
            int size = this.f3178l.size();
            for (int i = 0; i < size; i++) {
                View view = this.f3178l.get(i).itemView;
                RecyclerView.C1027j jVar = (RecyclerView.C1027j) view.getLayoutParams();
                if (!jVar.mo5701d() && this.f3170d == jVar.mo5703f()) {
                    mo5277a(view);
                    return view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo5275a(RecyclerView.C1034p pVar) {
            if (this.f3178l != null) {
                return m3835b();
            }
            View c = pVar.mo5742c(this.f3170d);
            this.f3170d += this.f3171e;
            return c;
        }

        /* renamed from: a */
        public void mo5276a() {
            mo5277a((View) null);
        }

        /* renamed from: a */
        public void mo5277a(View view) {
            View b = mo5279b(view);
            this.f3170d = b == null ? -1 : ((RecyclerView.C1027j) b.getLayoutParams()).mo5703f();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5278a(RecyclerView.C1042u uVar) {
            int i = this.f3170d;
            return i >= 0 && i < uVar.mo5796e();
        }

        /* renamed from: b */
        public View mo5279b(View view) {
            int f;
            int size = this.f3178l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f3178l.get(i2).itemView;
                RecyclerView.C1027j jVar = (RecyclerView.C1027j) view3.getLayoutParams();
                if (view3 != view && !jVar.mo5701d() && (f = (jVar.mo5703f() - this.f3170d) * this.f3171e) >= 0 && f < i) {
                    if (f == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = f;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$d */
    public static class C1003d implements Parcelable {
        public static final Parcelable.Creator<C1003d> CREATOR = new Parcelable.Creator<C1003d>() {
            /* renamed from: a */
            public C1003d createFromParcel(Parcel parcel) {
                return new C1003d(parcel);
            }

            /* renamed from: a */
            public C1003d[] newArray(int i) {
                return new C1003d[i];
            }
        };

        /* renamed from: a */
        int f3180a;

        /* renamed from: b */
        int f3181b;

        /* renamed from: c */
        boolean f3182c;

        public C1003d() {
        }

        C1003d(Parcel parcel) {
            this.f3180a = parcel.readInt();
            this.f3181b = parcel.readInt();
            this.f3182c = parcel.readInt() != 1 ? false : true;
        }

        public C1003d(C1003d dVar) {
            this.f3180a = dVar.f3180a;
            this.f3181b = dVar.f3181b;
            this.f3182c = dVar.f3182c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5280a() {
            return this.f3180a >= 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5281b() {
            this.f3180a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3180a);
            parcel.writeInt(this.f3181b);
            parcel.writeInt(this.f3182c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C1000a();
        this.mLayoutChunkResult = new C1001b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C1000a();
        this.mLayoutChunkResult = new C1001b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.C1022i.C1026b properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f3201a);
        setReverseLayout(properties.f3203c);
        setStackFromEnd(properties.f3204d);
    }

    private int computeScrollExtent(RecyclerView.C1042u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        C1086j jVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return C1093m.m4323a(uVar, jVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.C1042u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        C1086j jVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return C1093m.m4324a(uVar, jVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.C1042u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        C1086j jVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return C1093m.m4325b(uVar, jVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        return findReferenceChild(pVar, uVar, 0, getChildCount(), uVar.mo5796e());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        return findReferenceChild(pVar, uVar, getChildCount() - 1, -1, uVar.mo5796e());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(pVar, uVar) : findLastReferenceChild(pVar, uVar);
    }

    private View findReferenceChildClosestToStart(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        return this.mShouldReverseLayout ? findLastReferenceChild(pVar, uVar) : findFirstReferenceChild(pVar, uVar);
    }

    private int fixLayoutEndGap(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, boolean z) {
        int d;
        int d2 = this.mOrientationHelper.mo6042d() - i;
        if (d2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-d2, pVar, uVar);
        int i3 = i + i2;
        if (!z || (d = this.mOrientationHelper.mo6042d() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.mo6037a(d);
        return d + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, boolean z) {
        int c;
        int c2 = i - this.mOrientationHelper.mo6040c();
        if (c2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(c2, pVar, uVar);
        int i3 = i + i2;
        if (!z || (c = i3 - this.mOrientationHelper.mo6040c()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.mo6037a(-c);
        return i2 - c;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, int i, int i2) {
        RecyclerView.C1034p pVar2 = pVar;
        RecyclerView.C1042u uVar2 = uVar;
        if (uVar.mo5793b() && getChildCount() != 0 && !uVar.mo5792a() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.C1045x> c = pVar.mo5743c();
            int size = c.size();
            int position = getPosition(getChildAt(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.C1045x xVar = c.get(i5);
                if (!xVar.isRemoved()) {
                    char c2 = 1;
                    if ((xVar.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                        c2 = 65535;
                    }
                    if (c2 == 65535) {
                        i3 += this.mOrientationHelper.mo6045e(xVar.itemView);
                    } else {
                        i4 += this.mOrientationHelper.mo6045e(xVar.itemView);
                    }
                }
            }
            this.mLayoutState.f3178l = c;
            if (i3 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                C1002c cVar = this.mLayoutState;
                cVar.f3174h = i3;
                cVar.f3169c = 0;
                cVar.mo5276a();
                fill(pVar2, this.mLayoutState, uVar2, false);
            }
            if (i4 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                C1002c cVar2 = this.mLayoutState;
                cVar2.f3174h = i4;
                cVar2.f3169c = 0;
                cVar2.mo5276a();
                fill(pVar2, this.mLayoutState, uVar2, false);
            }
            this.mLayoutState.f3178l = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.mo6035a(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.C1034p pVar, C1002c cVar) {
        if (cVar.f3167a && !cVar.f3179m) {
            int i = cVar.f3173g;
            int i2 = cVar.f3175i;
            if (cVar.f3172f == -1) {
                recycleViewsFromEnd(pVar, i, i2);
            } else {
                recycleViewsFromStart(pVar, i, i2);
            }
        }
    }

    private void recycleChildren(RecyclerView.C1034p pVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, pVar);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, pVar);
                i--;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.C1034p pVar, int i, int i2) {
        int childCount = getChildCount();
        if (i >= 0) {
            int e = (this.mOrientationHelper.mo6044e() - i) + i2;
            if (this.mShouldReverseLayout) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (this.mOrientationHelper.mo6035a(childAt) < e || this.mOrientationHelper.mo6043d(childAt) < e) {
                        recycleChildren(pVar, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = childCount - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (this.mOrientationHelper.mo6035a(childAt2) < e || this.mOrientationHelper.mo6043d(childAt2) < e) {
                    recycleChildren(pVar, i4, i5);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.C1034p pVar, int i, int i2) {
        if (i >= 0) {
            int i3 = i - i2;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i4 = childCount - 1;
                for (int i5 = i4; i5 >= 0; i5--) {
                    View childAt = getChildAt(i5);
                    if (this.mOrientationHelper.mo6039b(childAt) > i3 || this.mOrientationHelper.mo6041c(childAt) > i3) {
                        recycleChildren(pVar, i4, i5);
                        return;
                    }
                }
                return;
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt2 = getChildAt(i6);
                if (this.mOrientationHelper.mo6039b(childAt2) > i3 || this.mOrientationHelper.mo6041c(childAt2) > i3) {
                    recycleChildren(pVar, 0, i6);
                    return;
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        this.mShouldReverseLayout = (this.mOrientation == 1 || !isLayoutRTL()) ? this.mReverseLayout : !this.mReverseLayout;
    }

    private boolean updateAnchorFromChildren(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, C1000a aVar) {
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.mo5270a(focusedChild, uVar)) {
            aVar.mo5269a(focusedChild, getPosition(focusedChild));
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        } else {
            View findReferenceChildClosestToEnd = aVar.f3161d ? findReferenceChildClosestToEnd(pVar, uVar) : findReferenceChildClosestToStart(pVar, uVar);
            if (findReferenceChildClosestToEnd == null) {
                return false;
            }
            aVar.mo5272b(findReferenceChildClosestToEnd, getPosition(findReferenceChildClosestToEnd));
            if (!uVar.mo5792a() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.mo6035a(findReferenceChildClosestToEnd) >= this.mOrientationHelper.mo6042d() || this.mOrientationHelper.mo6039b(findReferenceChildClosestToEnd) < this.mOrientationHelper.mo6040c()) {
                    z = true;
                }
                if (z) {
                    aVar.f3160c = aVar.f3161d ? this.mOrientationHelper.mo6042d() : this.mOrientationHelper.mo6040c();
                }
            }
            return true;
        }
    }

    private boolean updateAnchorFromPendingData(RecyclerView.C1042u uVar, C1000a aVar) {
        int i;
        boolean z = false;
        if (!uVar.mo5792a() && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= uVar.mo5796e()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.f3159b = this.mPendingScrollPosition;
                C1003d dVar = this.mPendingSavedState;
                if (dVar != null && dVar.mo5280a()) {
                    aVar.f3161d = this.mPendingSavedState.f3182c;
                    aVar.f3160c = aVar.f3161d ? this.mOrientationHelper.mo6042d() - this.mPendingSavedState.f3181b : this.mOrientationHelper.mo6040c() + this.mPendingSavedState.f3181b;
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if ((this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout) {
                                z = true;
                            }
                            aVar.f3161d = z;
                        }
                        aVar.mo5271b();
                    } else if (this.mOrientationHelper.mo6045e(findViewByPosition) > this.mOrientationHelper.mo6046f()) {
                        aVar.mo5271b();
                        return true;
                    } else if (this.mOrientationHelper.mo6035a(findViewByPosition) - this.mOrientationHelper.mo6040c() < 0) {
                        aVar.f3160c = this.mOrientationHelper.mo6040c();
                        aVar.f3161d = false;
                        return true;
                    } else if (this.mOrientationHelper.mo6042d() - this.mOrientationHelper.mo6039b(findViewByPosition) < 0) {
                        aVar.f3160c = this.mOrientationHelper.mo6042d();
                        aVar.f3161d = true;
                        return true;
                    } else {
                        aVar.f3160c = aVar.f3161d ? this.mOrientationHelper.mo6039b(findViewByPosition) + this.mOrientationHelper.mo6038b() : this.mOrientationHelper.mo6035a(findViewByPosition);
                    }
                    return true;
                } else {
                    boolean z2 = this.mShouldReverseLayout;
                    aVar.f3161d = z2;
                    aVar.f3160c = z2 ? this.mOrientationHelper.mo6042d() - this.mPendingScrollPositionOffset : this.mOrientationHelper.mo6040c() + this.mPendingScrollPositionOffset;
                    return true;
                }
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, C1000a aVar) {
        if (!updateAnchorFromPendingData(uVar, aVar) && !updateAnchorFromChildren(pVar, uVar, aVar)) {
            aVar.mo5271b();
            aVar.f3159b = this.mStackFromEnd ? uVar.mo5796e() - 1 : 0;
        }
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.C1042u uVar) {
        int i3;
        this.mLayoutState.f3179m = resolveIsInfinite();
        this.mLayoutState.f3172f = i;
        int[] iArr = this.mReusableIntPair;
        boolean z2 = false;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(uVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i == 1) {
            z2 = true;
        }
        this.mLayoutState.f3174h = z2 ? max2 : max;
        C1002c cVar = this.mLayoutState;
        if (!z2) {
            max = max2;
        }
        cVar.f3175i = max;
        int i4 = -1;
        if (z2) {
            this.mLayoutState.f3174h += this.mOrientationHelper.mo6048g();
            View childClosestToEnd = getChildClosestToEnd();
            C1002c cVar2 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i4 = 1;
            }
            cVar2.f3171e = i4;
            this.mLayoutState.f3170d = getPosition(childClosestToEnd) + this.mLayoutState.f3171e;
            this.mLayoutState.f3168b = this.mOrientationHelper.mo6039b(childClosestToEnd);
            i3 = this.mOrientationHelper.mo6039b(childClosestToEnd) - this.mOrientationHelper.mo6042d();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f3174h += this.mOrientationHelper.mo6040c();
            C1002c cVar3 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i4 = 1;
            }
            cVar3.f3171e = i4;
            this.mLayoutState.f3170d = getPosition(childClosestToStart) + this.mLayoutState.f3171e;
            this.mLayoutState.f3168b = this.mOrientationHelper.mo6035a(childClosestToStart);
            i3 = (-this.mOrientationHelper.mo6035a(childClosestToStart)) + this.mOrientationHelper.mo6040c();
        }
        C1002c cVar4 = this.mLayoutState;
        cVar4.f3169c = i2;
        if (z) {
            cVar4.f3169c -= i3;
        }
        this.mLayoutState.f3173g = i3;
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.f3169c = this.mOrientationHelper.mo6042d() - i2;
        this.mLayoutState.f3171e = this.mShouldReverseLayout ? -1 : 1;
        C1002c cVar = this.mLayoutState;
        cVar.f3170d = i;
        cVar.f3172f = 1;
        cVar.f3168b = i2;
        cVar.f3173g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillEnd(C1000a aVar) {
        updateLayoutStateToFillEnd(aVar.f3159b, aVar.f3160c);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.f3169c = i2 - this.mOrientationHelper.mo6040c();
        C1002c cVar = this.mLayoutState;
        cVar.f3170d = i;
        cVar.f3171e = this.mShouldReverseLayout ? 1 : -1;
        C1002c cVar2 = this.mLayoutState;
        cVar2.f3172f = -1;
        cVar2.f3168b = i2;
        cVar2.f3173g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(C1000a aVar) {
        updateLayoutStateToFillStart(aVar.f3159b, aVar.f3160c);
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(RecyclerView.C1042u uVar, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(uVar);
        if (this.mLayoutState.f3172f == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.C1042u uVar, RecyclerView.C1022i.C1025a aVar) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            ensureLayoutState();
            updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, uVar);
            collectPrefetchPositionsForLayoutState(uVar, this.mLayoutState, aVar);
        }
    }

    public void collectInitialPrefetchPositions(int i, RecyclerView.C1022i.C1025a aVar) {
        int i2;
        boolean z;
        C1003d dVar = this.mPendingSavedState;
        int i3 = -1;
        if (dVar == null || !dVar.mo5280a()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = this.mPendingSavedState.f3182c;
            i2 = this.mPendingSavedState.f3180a;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            aVar.mo5699b(i2, 0);
            i2 += i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.C1042u uVar, C1002c cVar, RecyclerView.C1022i.C1025a aVar) {
        int i = cVar.f3170d;
        if (i >= 0 && i < uVar.mo5796e()) {
            aVar.mo5699b(i, Math.max(0, cVar.f3173g));
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.C1042u uVar) {
        return computeScrollExtent(uVar);
    }

    public int computeHorizontalScrollOffset(RecyclerView.C1042u uVar) {
        return computeScrollOffset(uVar);
    }

    public int computeHorizontalScrollRange(RecyclerView.C1042u uVar) {
        return computeScrollRange(uVar);
    }

    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.mShouldReverseLayout) {
            i2 = -1;
        }
        return this.mOrientation == 0 ? new PointF((float) i2, 0.0f) : new PointF(0.0f, (float) i2);
    }

    public int computeVerticalScrollExtent(RecyclerView.C1042u uVar) {
        return computeScrollExtent(uVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.C1042u uVar) {
        return computeScrollOffset(uVar);
    }

    public int computeVerticalScrollRange(RecyclerView.C1042u uVar) {
        return computeScrollRange(uVar);
    }

    /* access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i) {
        if (i == 17) {
            return this.mOrientation == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.mOrientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.mOrientation == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i == 130) {
            return this.mOrientation == 1 ? 1 : Integer.MIN_VALUE;
        }
        switch (i) {
            case 1:
                return (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
            case 2:
                return (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* access modifiers changed from: package-private */
    public C1002c createLayoutState() {
        return new C1002c();
    }

    /* access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    /* access modifiers changed from: package-private */
    public int fill(RecyclerView.C1034p pVar, C1002c cVar, RecyclerView.C1042u uVar, boolean z) {
        int i = cVar.f3169c;
        if (cVar.f3173g != Integer.MIN_VALUE) {
            if (cVar.f3169c < 0) {
                cVar.f3173g += cVar.f3169c;
            }
            recycleByLayoutState(pVar, cVar);
        }
        int i2 = cVar.f3169c + cVar.f3174h;
        C1001b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.f3179m && i2 <= 0) || !cVar.mo5278a(uVar)) {
                break;
            }
            bVar.mo5274a();
            layoutChunk(pVar, uVar, cVar, bVar);
            if (!bVar.f3164b) {
                cVar.f3168b += bVar.f3163a * cVar.f3172f;
                if (!bVar.f3165c || cVar.f3178l != null || !uVar.mo5792a()) {
                    cVar.f3169c -= bVar.f3163a;
                    i2 -= bVar.f3163a;
                }
                if (cVar.f3173g != Integer.MIN_VALUE) {
                    cVar.f3173g += bVar.f3163a;
                    if (cVar.f3169c < 0) {
                        cVar.f3173g += cVar.f3169c;
                    }
                    recycleByLayoutState(pVar, cVar);
                }
                if (z && bVar.f3166d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f3169c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        int childCount;
        int i;
        if (this.mShouldReverseLayout) {
            childCount = 0;
            i = getChildCount();
        } else {
            childCount = getChildCount() - 1;
            i = -1;
        }
        return findOneVisibleChild(childCount, i, z, z2);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        int i;
        int childCount;
        if (this.mShouldReverseLayout) {
            i = getChildCount() - 1;
            childCount = -1;
        } else {
            i = 0;
            childCount = getChildCount();
        }
        return findOneVisibleChild(i, childCount, z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.mo6035a(getChildAt(i)) < this.mOrientationHelper.mo6040c()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        return (this.mOrientation == 0 ? this.mHorizontalBoundCheck : this.mVerticalBoundCheck).mo6076a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    public View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        return (this.mOrientation == 0 ? this.mHorizontalBoundCheck : this.mVerticalBoundCheck).mo6076a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, int i, int i2, int i3) {
        ensureLayoutState();
        int c = this.mOrientationHelper.mo6040c();
        int d = this.mOrientationHelper.mo6042d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.C1027j) childAt.getLayoutParams()).mo5701d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.mo6035a(childAt) < d && this.mOrientationHelper.mo6039b(childAt) >= c) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    public RecyclerView.C1027j generateDefaultLayoutParams() {
        return new RecyclerView.C1027j(-2, -2);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.C1042u uVar) {
        if (uVar.mo5795d()) {
            return this.mOrientationHelper.mo6046f();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, C1002c cVar, C1001b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a = cVar.mo5275a(pVar);
        if (a == null) {
            bVar.f3164b = true;
            return;
        }
        RecyclerView.C1027j jVar = (RecyclerView.C1027j) a.getLayoutParams();
        if (cVar.f3178l == null) {
            if (this.mShouldReverseLayout == (cVar.f3172f == -1)) {
                addView(a);
            } else {
                addView(a, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f3172f == -1)) {
                addDisappearingView(a);
            } else {
                addDisappearingView(a, 0);
            }
        }
        measureChildWithMargins(a, 0, 0);
        bVar.f3163a = this.mOrientationHelper.mo6045e(a);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i5 = getWidth() - getPaddingRight();
                i4 = i5 - this.mOrientationHelper.mo6047f(a);
            } else {
                i4 = getPaddingLeft();
                i5 = this.mOrientationHelper.mo6047f(a) + i4;
            }
            if (cVar.f3172f == -1) {
                int i6 = cVar.f3168b;
                i3 = cVar.f3168b - bVar.f3163a;
                i2 = i5;
                i = i6;
            } else {
                int i7 = cVar.f3168b;
                i = cVar.f3168b + bVar.f3163a;
                i2 = i5;
                i3 = i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f = this.mOrientationHelper.mo6047f(a) + paddingTop;
            if (cVar.f3172f == -1) {
                i3 = paddingTop;
                i2 = cVar.f3168b;
                i = f;
                i4 = cVar.f3168b - bVar.f3163a;
            } else {
                int i8 = cVar.f3168b;
                i2 = cVar.f3168b + bVar.f3163a;
                i3 = paddingTop;
                i = f;
                i4 = i8;
            }
        }
        layoutDecoratedWithMargins(a, i4, i3, i2, i);
        if (jVar.mo5701d() || jVar.mo5702e()) {
            bVar.f3165c = true;
        }
        bVar.f3166d = a.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, C1000a aVar, int i) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C1034p pVar) {
        super.onDetachedFromWindow(recyclerView, pVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(pVar);
            pVar.mo5726a();
        }
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        int convertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.mo6046f()) * MAX_SCROLL_FACTOR), false, uVar);
        C1002c cVar = this.mLayoutState;
        cVar.f3173g = Integer.MIN_VALUE;
        cVar.f3167a = false;
        fill(pVar, cVar, uVar, true);
        View findPartiallyOrCompletelyInvisibleChildClosestToStart = convertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = convertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return findPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (findPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public void onLayoutChildren(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View findViewByPosition;
        int i7;
        int i8;
        int i9 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && uVar.mo5796e() == 0) {
            removeAndRecycleAllViews(pVar);
            return;
        }
        C1003d dVar = this.mPendingSavedState;
        if (dVar != null && dVar.mo5280a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f3180a;
        }
        ensureLayoutState();
        this.mLayoutState.f3167a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.f3162e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.mo5268a();
            C1000a aVar = this.mAnchorInfo;
            aVar.f3161d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(pVar, uVar, aVar);
            this.mAnchorInfo.f3162e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.mo6035a(focusedChild) >= this.mOrientationHelper.mo6042d() || this.mOrientationHelper.mo6039b(focusedChild) <= this.mOrientationHelper.mo6040c())) {
            this.mAnchorInfo.mo5269a(focusedChild, getPosition(focusedChild));
        }
        C1002c cVar = this.mLayoutState;
        cVar.f3172f = cVar.f3177k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(uVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.mo6040c();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.mo6048g();
        if (!(!uVar.mo5792a() || (i6 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i6)) == null)) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.mo6042d() - this.mOrientationHelper.mo6039b(findViewByPosition);
                i8 = this.mPendingScrollPositionOffset;
            } else {
                i8 = this.mOrientationHelper.mo6035a(findViewByPosition) - this.mOrientationHelper.mo6040c();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i10 = i7 - i8;
            if (i10 > 0) {
                max += i10;
            } else {
                max2 -= i10;
            }
        }
        if (!this.mAnchorInfo.f3161d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i9 = 1;
        }
        onAnchorReady(pVar, uVar, this.mAnchorInfo, i9);
        detachAndScrapAttachedViews(pVar);
        this.mLayoutState.f3179m = resolveIsInfinite();
        this.mLayoutState.f3176j = uVar.mo5792a();
        this.mLayoutState.f3175i = 0;
        if (this.mAnchorInfo.f3161d) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            C1002c cVar2 = this.mLayoutState;
            cVar2.f3174h = max;
            fill(pVar, cVar2, uVar, false);
            i2 = this.mLayoutState.f3168b;
            int i11 = this.mLayoutState.f3170d;
            if (this.mLayoutState.f3169c > 0) {
                max2 += this.mLayoutState.f3169c;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            C1002c cVar3 = this.mLayoutState;
            cVar3.f3174h = max2;
            cVar3.f3170d += this.mLayoutState.f3171e;
            fill(pVar, this.mLayoutState, uVar, false);
            i = this.mLayoutState.f3168b;
            if (this.mLayoutState.f3169c > 0) {
                int i12 = this.mLayoutState.f3169c;
                updateLayoutStateToFillStart(i11, i2);
                C1002c cVar4 = this.mLayoutState;
                cVar4.f3174h = i12;
                fill(pVar, cVar4, uVar, false);
                i2 = this.mLayoutState.f3168b;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            C1002c cVar5 = this.mLayoutState;
            cVar5.f3174h = max2;
            fill(pVar, cVar5, uVar, false);
            i = this.mLayoutState.f3168b;
            int i13 = this.mLayoutState.f3170d;
            if (this.mLayoutState.f3169c > 0) {
                max += this.mLayoutState.f3169c;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            C1002c cVar6 = this.mLayoutState;
            cVar6.f3174h = max;
            cVar6.f3170d += this.mLayoutState.f3171e;
            fill(pVar, this.mLayoutState, uVar, false);
            i2 = this.mLayoutState.f3168b;
            if (this.mLayoutState.f3169c > 0) {
                int i14 = this.mLayoutState.f3169c;
                updateLayoutStateToFillEnd(i13, i);
                C1002c cVar7 = this.mLayoutState;
                cVar7.f3174h = i14;
                fill(pVar, cVar7, uVar, false);
                i = this.mLayoutState.f3168b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap = fixLayoutEndGap(i, pVar, uVar, true);
                i5 = i2 + fixLayoutEndGap;
                i3 = i + fixLayoutEndGap;
                i4 = fixLayoutStartGap(i5, pVar, uVar, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i2, pVar, uVar, true);
                i5 = i2 + fixLayoutStartGap;
                i3 = i + fixLayoutStartGap;
                i4 = fixLayoutEndGap(i3, pVar, uVar, false);
            }
            i2 = i5 + i4;
            i = i3 + i4;
        }
        layoutForPredictiveAnimations(pVar, uVar, i2, i);
        if (!uVar.mo5792a()) {
            this.mOrientationHelper.mo6036a();
        } else {
            this.mAnchorInfo.mo5268a();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(RecyclerView.C1042u uVar) {
        super.onLayoutCompleted(uVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.mo5268a();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1003d) {
            this.mPendingSavedState = (C1003d) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        C1003d dVar = this.mPendingSavedState;
        if (dVar != null) {
            return new C1003d(dVar);
        }
        C1003d dVar2 = new C1003d();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            dVar2.f3182c = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                dVar2.f3181b = this.mOrientationHelper.mo6042d() - this.mOrientationHelper.mo6039b(childClosestToEnd);
                dVar2.f3180a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                dVar2.f3180a = getPosition(childClosestToStart);
                dVar2.f3181b = this.mOrientationHelper.mo6035a(childClosestToStart) - this.mOrientationHelper.mo6040c();
            }
        } else {
            dVar2.mo5281b();
        }
        return dVar2;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        int i3;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : 65535;
        if (this.mShouldReverseLayout) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo6042d() - (this.mOrientationHelper.mo6035a(view2) + this.mOrientationHelper.mo6045e(view)));
                return;
            }
            i3 = this.mOrientationHelper.mo6042d() - this.mOrientationHelper.mo6039b(view2);
        } else if (c == 65535) {
            i3 = this.mOrientationHelper.mo6035a(view2);
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo6039b(view2) - this.mOrientationHelper.mo6045e(view));
            return;
        }
        scrollToPositionWithOffset(position2, i3);
    }

    /* access modifiers changed from: package-private */
    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.mo6049h() == 0 && this.mOrientationHelper.mo6044e() == 0;
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f3167a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, uVar);
        int fill = this.mLayoutState.f3173g + fill(pVar, this.mLayoutState, uVar, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.mo6037a(-i);
        this.mLayoutState.f3177k = i;
        return i;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, pVar, uVar);
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        C1003d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.mo5281b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        C1003d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.mo5281b();
        }
        requestLayout();
    }

    public int scrollVerticallyBy(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, pVar, uVar);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.mOrientation || this.mOrientationHelper == null) {
                this.mOrientationHelper = C1086j.m4264a(this, i);
                this.mAnchorInfo.f3158a = this.mOrientationHelper;
                this.mOrientation = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C1042u uVar, int i) {
        C1082g gVar = new C1082g(recyclerView.getContext());
        gVar.setTargetPosition(i);
        startSmoothScroll(gVar);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    /* access modifiers changed from: package-private */
    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() >= 1) {
            boolean z = false;
            int position = getPosition(getChildAt(0));
            int a = this.mOrientationHelper.mo6035a(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i = 1;
                while (i < getChildCount()) {
                    View childAt = getChildAt(i);
                    int position2 = getPosition(childAt);
                    int a2 = this.mOrientationHelper.mo6035a(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder();
                        sb.append("detected invalid position. loc invalid? ");
                        if (a2 < a) {
                            z = true;
                        }
                        sb.append(z);
                        throw new RuntimeException(sb.toString());
                    } else if (a2 <= a) {
                        i++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i2 = 1;
            while (i2 < getChildCount()) {
                View childAt2 = getChildAt(i2);
                int position3 = getPosition(childAt2);
                int a3 = this.mOrientationHelper.mo6035a(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    if (a3 < a) {
                        z = true;
                    }
                    sb2.append(z);
                    throw new RuntimeException(sb2.toString());
                } else if (a3 >= a) {
                    i2++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }
}
