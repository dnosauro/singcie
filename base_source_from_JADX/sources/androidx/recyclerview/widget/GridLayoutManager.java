package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p030h.p031a.C0614c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a */
    boolean f3143a = false;

    /* renamed from: b */
    int f3144b = -1;

    /* renamed from: c */
    int[] f3145c;

    /* renamed from: d */
    View[] f3146d;

    /* renamed from: e */
    final SparseIntArray f3147e = new SparseIntArray();

    /* renamed from: f */
    final SparseIntArray f3148f = new SparseIntArray();

    /* renamed from: g */
    C0999c f3149g = new C0997a();

    /* renamed from: h */
    final Rect f3150h = new Rect();

    /* renamed from: i */
    private boolean f3151i;

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$a */
    public static final class C0997a extends C0999c {
        /* renamed from: a */
        public int mo5211a(int i) {
            return 1;
        }

        /* renamed from: a */
        public int mo5212a(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$b */
    public static class C0998b extends RecyclerView.C1027j {

        /* renamed from: a */
        int f3152a = -1;

        /* renamed from: b */
        int f3153b = 0;

        public C0998b(int i, int i2) {
            super(i, i2);
        }

        public C0998b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0998b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0998b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        /* renamed from: a */
        public int mo5213a() {
            return this.f3152a;
        }

        /* renamed from: b */
        public int mo5214b() {
            return this.f3153b;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$c */
    public static abstract class C0999c {

        /* renamed from: a */
        final SparseIntArray f3154a = new SparseIntArray();

        /* renamed from: b */
        final SparseIntArray f3155b = new SparseIntArray();

        /* renamed from: c */
        private boolean f3156c = false;

        /* renamed from: d */
        private boolean f3157d = false;

        /* renamed from: a */
        static int m3821a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        /* renamed from: a */
        public abstract int mo5211a(int i);

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo5212a(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.mo5211a(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.f3156c
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.f3154a
                int r2 = m3821a((android.util.SparseIntArray) r2, (int) r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.f3154a
                int r3 = r3.get(r2)
                int r4 = r5.mo5211a(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r3 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.mo5211a(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = 0
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.C0999c.mo5212a(int, int):int");
        }

        /* renamed from: a */
        public void mo5215a() {
            this.f3154a.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5216b(int i, int i2) {
            if (!this.f3156c) {
                return mo5212a(i, i2);
            }
            int i3 = this.f3154a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int a = mo5212a(i, i2);
            this.f3154a.put(i, a);
            return a;
        }

        /* renamed from: b */
        public void mo5217b() {
            this.f3155b.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo5218c(int i, int i2) {
            if (!this.f3157d) {
                return mo5219d(i, i2);
            }
            int i3 = this.f3155b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int d = mo5219d(i, i2);
            this.f3155b.put(i, d);
            return d;
        }

        /* renamed from: d */
        public int mo5219d(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int a;
            if (!this.f3157d || (a = m3821a(this.f3155b, i)) == -1) {
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                i4 = this.f3155b.get(a);
                i3 = a + 1;
                i5 = mo5211a(a) + mo5216b(a, i2);
                if (i5 == i2) {
                    i4++;
                    i5 = 0;
                }
            }
            int a2 = mo5211a(i);
            while (i3 < i) {
                int a3 = mo5211a(i3);
                int i6 = i5 + a3;
                if (i6 == i2) {
                    i4++;
                    i6 = 0;
                } else if (i6 > i2) {
                    i4++;
                    i6 = a3;
                }
                i3++;
            }
            return i5 + a2 > i2 ? i4 + 1 : i4;
        }
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        mo5182a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo5182a(getProperties(context, attributeSet, i, i2).f3202b);
    }

    /* renamed from: a */
    private int m3798a(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, int i) {
        if (!uVar.mo5792a()) {
            return this.f3149g.mo5218c(i, this.f3144b);
        }
        int b = pVar.mo5736b(i);
        if (b != -1) {
            return this.f3149g.mo5218c(b, this.f3144b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    /* renamed from: a */
    private int m3799a(RecyclerView.C1042u uVar) {
        if (!(getChildCount() == 0 || uVar.mo5796e() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.f3149g.mo5218c(uVar.mo5796e() - 1, this.f3144b) + 1;
                }
                int b = this.mOrientationHelper.mo6039b(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.mo6035a(findFirstVisibleChildClosestToStart);
                int c = this.f3149g.mo5218c(getPosition(findFirstVisibleChildClosestToStart), this.f3144b);
                return (int) ((((float) b) / ((float) ((this.f3149g.mo5218c(getPosition(findFirstVisibleChildClosestToEnd), this.f3144b) - c) + 1))) * ((float) (this.f3149g.mo5218c(uVar.mo5796e() - 1, this.f3144b) + 1)));
            }
        }
        return 0;
    }

    /* renamed from: a */
    private void m3800a(float f, int i) {
        m3809b(Math.max(Math.round(f * ((float) this.f3144b)), i));
    }

    /* renamed from: a */
    private void m3801a(View view, int i, int i2, boolean z) {
        RecyclerView.C1027j jVar = (RecyclerView.C1027j) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i, i2, jVar) : shouldMeasureChild(view, i, i2, jVar)) {
            view.measure(i, i2);
        }
    }

    /* renamed from: a */
    private void m3802a(View view, int i, boolean z) {
        int i2;
        int i3;
        C0998b bVar = (C0998b) view.getLayoutParams();
        Rect rect = bVar.f3206d;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int a = mo5181a(bVar.f3152a, bVar.f3153b);
        if (this.mOrientation == 1) {
            i2 = getChildMeasureSpec(a, i, i5, bVar.width, false);
            i3 = getChildMeasureSpec(this.mOrientationHelper.mo6046f(), getHeightMode(), i4, bVar.height, true);
        } else {
            int childMeasureSpec = getChildMeasureSpec(a, i, i4, bVar.height, false);
            int childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.mo6046f(), getWidthMode(), i5, bVar.width, true);
            i3 = childMeasureSpec;
            i2 = childMeasureSpec2;
        }
        m3801a(view, i2, i3, z);
    }

    /* renamed from: a */
    private void m3803a(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = i - 1;
            i2 = -1;
        }
        while (i3 != i5) {
            View view = this.f3146d[i3];
            C0998b bVar = (C0998b) view.getLayoutParams();
            bVar.f3153b = m3810c(pVar, uVar, getPosition(view));
            bVar.f3152a = i4;
            i4 += bVar.f3153b;
            i3 += i2;
        }
    }

    /* renamed from: a */
    private void m3804a(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, LinearLayoutManager.C1000a aVar, int i) {
        boolean z = i == 1;
        int b = m3806b(pVar, uVar, aVar.f3159b);
        if (z) {
            while (b > 0 && aVar.f3159b > 0) {
                aVar.f3159b--;
                b = m3806b(pVar, uVar, aVar.f3159b);
            }
            return;
        }
        int e = uVar.mo5796e() - 1;
        int i2 = aVar.f3159b;
        while (i2 < e) {
            int i3 = i2 + 1;
            int b2 = m3806b(pVar, uVar, i3);
            if (b2 <= b) {
                break;
            }
            i2 = i3;
            b = b2;
        }
        aVar.f3159b = i2;
    }

    /* renamed from: a */
    static int[] m3805a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* renamed from: b */
    private int m3806b(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, int i) {
        if (!uVar.mo5792a()) {
            return this.f3149g.mo5216b(i, this.f3144b);
        }
        int i2 = this.f3148f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b = pVar.mo5736b(i);
        if (b != -1) {
            return this.f3149g.mo5216b(b, this.f3144b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    /* renamed from: b */
    private int m3807b(RecyclerView.C1042u uVar) {
        if (!(getChildCount() == 0 || uVar.mo5796e() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int c = this.f3149g.mo5218c(getPosition(findFirstVisibleChildClosestToStart), this.f3144b);
                int c2 = this.f3149g.mo5218c(getPosition(findFirstVisibleChildClosestToEnd), this.f3144b);
                int min = Math.min(c, c2);
                int max = this.mShouldReverseLayout ? Math.max(0, ((this.f3149g.mo5218c(uVar.mo5796e() - 1, this.f3144b) + 1) - Math.max(c, c2)) - 1) : Math.max(0, min);
                if (!isSmoothScrollbarEnabled) {
                    return max;
                }
                return Math.round((((float) max) * (((float) Math.abs(this.mOrientationHelper.mo6039b(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.mo6035a(findFirstVisibleChildClosestToStart))) / ((float) ((this.f3149g.mo5218c(getPosition(findFirstVisibleChildClosestToEnd), this.f3144b) - this.f3149g.mo5218c(getPosition(findFirstVisibleChildClosestToStart), this.f3144b)) + 1)))) + ((float) (this.mOrientationHelper.mo6040c() - this.mOrientationHelper.mo6035a(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    /* renamed from: b */
    private void m3808b() {
        this.f3147e.clear();
        this.f3148f.clear();
    }

    /* renamed from: b */
    private void m3809b(int i) {
        this.f3145c = m3805a(this.f3145c, this.f3144b, i);
    }

    /* renamed from: c */
    private int m3810c(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, int i) {
        if (!uVar.mo5792a()) {
            return this.f3149g.mo5211a(i);
        }
        int i2 = this.f3147e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b = pVar.mo5736b(i);
        if (b != -1) {
            return this.f3149g.mo5211a(b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    /* renamed from: c */
    private void m3811c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0998b bVar = (C0998b) getChildAt(i).getLayoutParams();
            int f = bVar.mo5703f();
            this.f3147e.put(f, bVar.mo5214b());
            this.f3148f.put(f, bVar.mo5213a());
        }
    }

    /* renamed from: d */
    private void m3812d() {
        int i;
        int i2;
        if (getOrientation() == 1) {
            i2 = getWidth() - getPaddingRight();
            i = getPaddingLeft();
        } else {
            i2 = getHeight() - getPaddingBottom();
            i = getPaddingTop();
        }
        m3809b(i2 - i);
    }

    /* renamed from: e */
    private void m3813e() {
        View[] viewArr = this.f3146d;
        if (viewArr == null || viewArr.length != this.f3144b) {
            this.f3146d = new View[this.f3144b];
        }
    }

    /* renamed from: a */
    public int mo5180a() {
        return this.f3144b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5181a(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f3145c;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f3145c;
        int i3 = this.f3144b;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    /* renamed from: a */
    public void mo5182a(int i) {
        if (i != this.f3144b) {
            this.f3143a = true;
            if (i >= 1) {
                this.f3144b = i;
                this.f3149g.mo5215a();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public boolean checkLayoutParams(RecyclerView.C1027j jVar) {
        return jVar instanceof C0998b;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.C1042u uVar, LinearLayoutManager.C1002c cVar, RecyclerView.C1022i.C1025a aVar) {
        int i = this.f3144b;
        for (int i2 = 0; i2 < this.f3144b && cVar.mo5278a(uVar) && i > 0; i2++) {
            int i3 = cVar.f3170d;
            aVar.mo5699b(i3, Math.max(0, cVar.f3173g));
            i -= this.f3149g.mo5211a(i3);
            cVar.f3170d += cVar.f3171e;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.C1042u uVar) {
        return this.f3151i ? m3807b(uVar) : super.computeHorizontalScrollOffset(uVar);
    }

    public int computeHorizontalScrollRange(RecyclerView.C1042u uVar) {
        return this.f3151i ? m3799a(uVar) : super.computeHorizontalScrollRange(uVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.C1042u uVar) {
        return this.f3151i ? m3807b(uVar) : super.computeVerticalScrollOffset(uVar);
    }

    public int computeVerticalScrollRange(RecyclerView.C1042u uVar) {
        return this.f3151i ? m3799a(uVar) : super.computeVerticalScrollRange(uVar);
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
            if (position >= 0 && position < i3 && m3806b(pVar, uVar, position) == 0) {
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

    public RecyclerView.C1027j generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new C0998b(-2, -1) : new C0998b(-1, -2);
    }

    public RecyclerView.C1027j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C0998b(context, attributeSet);
    }

    public RecyclerView.C1027j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0998b((ViewGroup.MarginLayoutParams) layoutParams) : new C0998b(layoutParams);
    }

    public int getColumnCountForAccessibility(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        if (this.mOrientation == 1) {
            return this.f3144b;
        }
        if (uVar.mo5796e() < 1) {
            return 0;
        }
        return m3798a(pVar, uVar, uVar.mo5796e() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        if (this.mOrientation == 0) {
            return this.f3144b;
        }
        if (uVar.mo5796e() < 1) {
            return 0;
        }
        return m3798a(pVar, uVar, uVar.mo5796e() - 1) + 1;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, LinearLayoutManager.C1002c cVar, LinearLayoutManager.C1001b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        View a;
        RecyclerView.C1034p pVar2 = pVar;
        RecyclerView.C1042u uVar2 = uVar;
        LinearLayoutManager.C1002c cVar2 = cVar;
        LinearLayoutManager.C1001b bVar2 = bVar;
        int i11 = this.mOrientationHelper.mo6050i();
        boolean z = false;
        boolean z2 = i11 != 1073741824;
        int i12 = getChildCount() > 0 ? this.f3145c[this.f3144b] : 0;
        if (z2) {
            m3812d();
        }
        boolean z3 = cVar2.f3171e == 1;
        int i13 = this.f3144b;
        if (!z3) {
            i13 = m3806b(pVar2, uVar2, cVar2.f3170d) + m3810c(pVar2, uVar2, cVar2.f3170d);
        }
        int i14 = i13;
        int i15 = 0;
        while (i15 < this.f3144b && cVar2.mo5278a(uVar2) && i14 > 0) {
            int i16 = cVar2.f3170d;
            int c = m3810c(pVar2, uVar2, i16);
            if (c <= this.f3144b) {
                i14 -= c;
                if (i14 < 0 || (a = cVar2.mo5275a(pVar2)) == null) {
                    break;
                }
                this.f3146d[i15] = a;
                i15++;
            } else {
                throw new IllegalArgumentException("Item at position " + i16 + " requires " + c + " spans but GridLayoutManager has only " + this.f3144b + " spans.");
            }
        }
        if (i15 == 0) {
            bVar2.f3164b = true;
            return;
        }
        float f = 0.0f;
        m3803a(pVar2, uVar2, i15, z3);
        int i17 = 0;
        int i18 = 0;
        while (i17 < i15) {
            View view = this.f3146d[i17];
            if (cVar2.f3178l == null) {
                if (z3) {
                    addView(view);
                } else {
                    addView(view, z);
                }
            } else if (z3) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, z ? 1 : 0);
            }
            calculateItemDecorationsForChild(view, this.f3150h);
            m3802a(view, i11, z);
            int e = this.mOrientationHelper.mo6045e(view);
            if (e > i18) {
                i18 = e;
            }
            float f2 = (((float) this.mOrientationHelper.mo6047f(view)) * 1.0f) / ((float) ((C0998b) view.getLayoutParams()).f3153b);
            if (f2 > f) {
                f = f2;
            }
            i17++;
            z = false;
        }
        if (z2) {
            m3800a(f, i12);
            i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                View view2 = this.f3146d[i19];
                m3802a(view2, 1073741824, true);
                int e2 = this.mOrientationHelper.mo6045e(view2);
                if (e2 > i18) {
                    i18 = e2;
                }
            }
        }
        for (int i20 = 0; i20 < i15; i20++) {
            View view3 = this.f3146d[i20];
            if (this.mOrientationHelper.mo6045e(view3) != i18) {
                C0998b bVar3 = (C0998b) view3.getLayoutParams();
                Rect rect = bVar3.f3206d;
                int i21 = rect.top + rect.bottom + bVar3.topMargin + bVar3.bottomMargin;
                int i22 = rect.left + rect.right + bVar3.leftMargin + bVar3.rightMargin;
                int a2 = mo5181a(bVar3.f3152a, bVar3.f3153b);
                if (this.mOrientation == 1) {
                    i10 = getChildMeasureSpec(a2, 1073741824, i22, bVar3.width, false);
                    i9 = View.MeasureSpec.makeMeasureSpec(i18 - i21, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - i22, 1073741824);
                    i9 = getChildMeasureSpec(a2, 1073741824, i21, bVar3.height, false);
                    i10 = makeMeasureSpec;
                }
                m3801a(view3, i10, i9, true);
            }
        }
        int i23 = 0;
        bVar2.f3163a = i18;
        if (this.mOrientation == 1) {
            if (cVar2.f3172f == -1) {
                int i24 = cVar2.f3168b;
                i3 = i24 - i18;
                i2 = i24;
            } else {
                int i25 = cVar2.f3168b;
                i2 = i25 + i18;
                i3 = i25;
            }
            i4 = 0;
            i = 0;
        } else if (cVar2.f3172f == -1) {
            i = cVar2.f3168b;
            i4 = i - i18;
            i3 = 0;
            i2 = 0;
        } else {
            int i26 = cVar2.f3168b;
            int i27 = i26 + i18;
            i3 = 0;
            i2 = 0;
            int i28 = i26;
            i = i27;
            i4 = i28;
        }
        while (i23 < i15) {
            View view4 = this.f3146d[i23];
            C0998b bVar4 = (C0998b) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                int paddingTop = getPaddingTop() + this.f3145c[bVar4.f3152a];
                i8 = i4;
                i7 = paddingTop;
                i5 = this.mOrientationHelper.mo6047f(view4) + paddingTop;
                i6 = i;
            } else if (isLayoutRTL()) {
                int paddingLeft = getPaddingLeft() + this.f3145c[this.f3144b - bVar4.f3152a];
                i6 = paddingLeft;
                i7 = i3;
                i5 = i2;
                i8 = paddingLeft - this.mOrientationHelper.mo6047f(view4);
            } else {
                int paddingLeft2 = getPaddingLeft() + this.f3145c[bVar4.f3152a];
                i8 = paddingLeft2;
                i7 = i3;
                i5 = i2;
                i6 = this.mOrientationHelper.mo6047f(view4) + paddingLeft2;
            }
            layoutDecoratedWithMargins(view4, i8, i7, i6, i5);
            if (bVar4.mo5701d() || bVar4.mo5702e()) {
                bVar2.f3165c = true;
            }
            bVar2.f3166d |= view4.hasFocusable();
            i23++;
            i4 = i8;
            i3 = i7;
            i = i6;
            i2 = i5;
        }
        Arrays.fill(this.f3146d, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, LinearLayoutManager.C1000a aVar, int i) {
        super.onAnchorReady(pVar, uVar, aVar, i);
        m3812d();
        if (uVar.mo5796e() > 0 && !uVar.mo5792a()) {
            m3804a(pVar, uVar, aVar, i);
        }
        m3813e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f4, code lost:
        if (r13 == r10) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.C1034p r25, androidx.recyclerview.widget.RecyclerView.C1042u r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r25
            r2 = r26
            android.view.View r3 = r22.findContainingItemView(r23)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.C0998b) r5
            int r6 = r5.f3152a
            int r7 = r5.f3152a
            int r5 = r5.f3153b
            int r7 = r7 + r5
            android.view.View r5 = super.onFocusSearchFailed(r23, r24, r25, r26)
            if (r5 != 0) goto L_0x0022
            return r4
        L_0x0022:
            r5 = r24
            int r5 = r0.convertFocusDirectionToLayoutDirection(r5)
            r9 = 1
            if (r5 != r9) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            boolean r10 = r0.mShouldReverseLayout
            if (r5 == r10) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            r10 = -1
            if (r5 == 0) goto L_0x0040
            int r5 = r22.getChildCount()
            int r5 = r5 - r9
            r11 = -1
            r12 = -1
            goto L_0x0047
        L_0x0040:
            int r5 = r22.getChildCount()
            r11 = r5
            r5 = 0
            r12 = 1
        L_0x0047:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x0053
            boolean r13 = r22.isLayoutRTL()
            if (r13 == 0) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            int r14 = r0.m3798a((androidx.recyclerview.widget.RecyclerView.C1034p) r1, (androidx.recyclerview.widget.RecyclerView.C1042u) r2, (int) r5)
            r10 = r4
            r8 = -1
            r15 = 0
            r16 = 0
            r17 = -1
        L_0x005f:
            if (r5 == r11) goto L_0x0140
            int r9 = r0.m3798a((androidx.recyclerview.widget.RecyclerView.C1034p) r1, (androidx.recyclerview.widget.RecyclerView.C1042u) r2, (int) r5)
            android.view.View r1 = r0.getChildAt(r5)
            if (r1 != r3) goto L_0x006d
            goto L_0x0140
        L_0x006d:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0087
            if (r9 == r14) goto L_0x0087
            if (r4 == 0) goto L_0x0079
            goto L_0x0140
        L_0x0079:
            r18 = r3
            r20 = r8
            r23 = r10
            r19 = r11
            r8 = r16
            r11 = r17
            goto L_0x012c
        L_0x0087:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.C0998b) r9
            int r2 = r9.f3152a
            r18 = r3
            int r3 = r9.f3152a
            r19 = r11
            int r11 = r9.f3153b
            int r3 = r3 + r11
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a3
            if (r2 != r6) goto L_0x00a3
            if (r3 != r7) goto L_0x00a3
            return r1
        L_0x00a3:
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00ab
            if (r4 == 0) goto L_0x00b3
        L_0x00ab:
            boolean r11 = r1.hasFocusable()
            if (r11 != 0) goto L_0x00bd
            if (r10 != 0) goto L_0x00bd
        L_0x00b3:
            r20 = r8
            r23 = r10
            r8 = r16
        L_0x00b9:
            r11 = r17
        L_0x00bb:
            r10 = 1
            goto L_0x0100
        L_0x00bd:
            int r11 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r7)
            int r11 = r20 - r11
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x00da
            if (r11 <= r15) goto L_0x00d0
            goto L_0x00b3
        L_0x00d0:
            if (r11 != r15) goto L_0x00f7
            if (r2 <= r8) goto L_0x00d6
            r11 = 1
            goto L_0x00d7
        L_0x00d6:
            r11 = 0
        L_0x00d7:
            if (r13 != r11) goto L_0x00f7
            goto L_0x00b3
        L_0x00da:
            if (r4 != 0) goto L_0x00f7
            r20 = r8
            r23 = r10
            r8 = 1
            r10 = 0
            boolean r21 = r0.isViewPartiallyVisible(r1, r10, r8)
            if (r21 == 0) goto L_0x00fb
            r8 = r16
            if (r11 <= r8) goto L_0x00ed
            goto L_0x00b9
        L_0x00ed:
            if (r11 != r8) goto L_0x00fd
            r11 = r17
            if (r2 <= r11) goto L_0x00f4
            r10 = 1
        L_0x00f4:
            if (r13 != r10) goto L_0x00ff
            goto L_0x00bb
        L_0x00f7:
            r20 = r8
            r23 = r10
        L_0x00fb:
            r8 = r16
        L_0x00fd:
            r11 = r17
        L_0x00ff:
            r10 = 0
        L_0x0100:
            if (r10 == 0) goto L_0x012c
            boolean r10 = r1.hasFocusable()
            if (r10 == 0) goto L_0x011c
            int r4 = r9.f3152a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r23
            r15 = r3
            r20 = r4
            r17 = r11
            r4 = r1
            goto L_0x0130
        L_0x011c:
            int r8 = r9.f3152a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r17 = r8
            r8 = r3
            goto L_0x0130
        L_0x012c:
            r10 = r23
            r17 = r11
        L_0x0130:
            int r5 = r5 + r12
            r16 = r8
            r3 = r18
            r11 = r19
            r8 = r20
            r1 = r25
            r2 = r26
            r9 = 1
            goto L_0x005f
        L_0x0140:
            r23 = r10
            if (r4 == 0) goto L_0x0145
            goto L_0x0147
        L_0x0145:
            r4 = r23
        L_0x0147:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar, View view, C0614c cVar) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0998b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        C0998b bVar = (C0998b) layoutParams;
        int a = m3798a(pVar, uVar, bVar.mo5703f());
        if (this.mOrientation == 0) {
            i4 = bVar.mo5213a();
            i3 = bVar.mo5214b();
            i = 1;
            z2 = false;
            z = false;
            i2 = a;
        } else {
            i3 = 1;
            i2 = bVar.mo5213a();
            i = bVar.mo5214b();
            z2 = false;
            z = false;
            i4 = a;
        }
        cVar.mo3717b((Object) C0614c.C0617c.m2482a(i4, i3, i2, i, z2, z));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f3149g.mo5215a();
        this.f3149g.mo5217b();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3149g.mo5215a();
        this.f3149g.mo5217b();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f3149g.mo5215a();
        this.f3149g.mo5217b();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f3149g.mo5215a();
        this.f3149g.mo5217b();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f3149g.mo5215a();
        this.f3149g.mo5217b();
    }

    public void onLayoutChildren(RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        if (uVar.mo5792a()) {
            m3811c();
        }
        super.onLayoutChildren(pVar, uVar);
        m3808b();
    }

    public void onLayoutCompleted(RecyclerView.C1042u uVar) {
        super.onLayoutCompleted(uVar);
        this.f3143a = false;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        m3812d();
        m3813e();
        return super.scrollHorizontallyBy(i, pVar, uVar);
    }

    public int scrollVerticallyBy(int i, RecyclerView.C1034p pVar, RecyclerView.C1042u uVar) {
        m3812d();
        m3813e();
        return super.scrollVerticallyBy(i, pVar, uVar);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.f3145c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i4 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f3145c;
            i3 = chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i3 = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f3145c;
            i4 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f3143a;
    }
}
