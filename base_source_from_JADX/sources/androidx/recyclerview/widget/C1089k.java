package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.k */
public class C1089k extends C1095o {

    /* renamed from: b */
    private C1086j f3447b;

    /* renamed from: c */
    private C1086j f3448c;

    /* renamed from: a */
    private int m4310a(RecyclerView.C1022i iVar, View view, C1086j jVar) {
        return (jVar.mo6035a(view) + (jVar.mo6045e(view) / 2)) - (jVar.mo6040c() + (jVar.mo6046f() / 2));
    }

    /* renamed from: a */
    private View m4311a(RecyclerView.C1022i iVar, C1086j jVar) {
        int childCount = iVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int c = jVar.mo6040c() + (jVar.mo6046f() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = iVar.getChildAt(i2);
            int abs = Math.abs((jVar.mo6035a(childAt) + (jVar.mo6045e(childAt) / 2)) - c);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    /* renamed from: b */
    private boolean m4312b(RecyclerView.C1022i iVar, int i, int i2) {
        return iVar.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    /* renamed from: d */
    private boolean m4313d(RecyclerView.C1022i iVar) {
        PointF computeScrollVectorForPosition;
        int itemCount = iVar.getItemCount();
        if (!(iVar instanceof RecyclerView.C1039t.C1041b) || (computeScrollVectorForPosition = ((RecyclerView.C1039t.C1041b) iVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    /* renamed from: e */
    private C1086j m4314e(RecyclerView.C1022i iVar) {
        if (iVar.canScrollVertically()) {
            return m4315f(iVar);
        }
        if (iVar.canScrollHorizontally()) {
            return m4316g(iVar);
        }
        return null;
    }

    /* renamed from: f */
    private C1086j m4315f(RecyclerView.C1022i iVar) {
        C1086j jVar = this.f3447b;
        if (jVar == null || jVar.f3444a != iVar) {
            this.f3447b = C1086j.m4265b(iVar);
        }
        return this.f3447b;
    }

    /* renamed from: g */
    private C1086j m4316g(RecyclerView.C1022i iVar) {
        C1086j jVar = this.f3448c;
        if (jVar == null || jVar.f3444a != iVar) {
            this.f3448c = C1086j.m4263a(iVar);
        }
        return this.f3448c;
    }

    /* renamed from: a */
    public int mo6029a(RecyclerView.C1022i iVar, int i, int i2) {
        C1086j e;
        int itemCount = iVar.getItemCount();
        if (itemCount == 0 || (e = m4314e(iVar)) == null) {
            return -1;
        }
        int childCount = iVar.getChildCount();
        View view = null;
        View view2 = null;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = iVar.getChildAt(i5);
            if (childAt != null) {
                int a = m4310a(iVar, childAt, e);
                if (a <= 0 && a > i3) {
                    view2 = childAt;
                    i3 = a;
                }
                if (a >= 0 && a < i4) {
                    view = childAt;
                    i4 = a;
                }
            }
        }
        boolean b = m4312b(iVar, i, i2);
        if (b && view != null) {
            return iVar.getPosition(view);
        }
        if (!b && view2 != null) {
            return iVar.getPosition(view2);
        }
        if (!b) {
            view2 = view;
        }
        if (view2 == null) {
            return -1;
        }
        int position = iVar.getPosition(view2) + (m4313d(iVar) == b ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    /* renamed from: a */
    public View mo6030a(RecyclerView.C1022i iVar) {
        C1086j g;
        if (iVar.canScrollVertically()) {
            g = m4315f(iVar);
        } else if (!iVar.canScrollHorizontally()) {
            return null;
        } else {
            g = m4316g(iVar);
        }
        return m4311a(iVar, g);
    }

    /* renamed from: a */
    public int[] mo6031a(RecyclerView.C1022i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.canScrollHorizontally()) {
            iArr[0] = m4310a(iVar, view, m4316g(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.canScrollVertically()) {
            iArr[1] = m4310a(iVar, view, m4315f(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1082g mo6051b(RecyclerView.C1022i iVar) {
        if (!(iVar instanceof RecyclerView.C1039t.C1041b)) {
            return null;
        }
        return new C1082g(this.f3453a.getContext()) {
            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }

            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.C1042u uVar, RecyclerView.C1039t.C1040a aVar) {
                C1089k kVar = C1089k.this;
                int[] a = kVar.mo6031a(kVar.f3453a.getLayoutManager(), view);
                int i = a[0];
                int i2 = a[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    aVar.mo5787a(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }
}
