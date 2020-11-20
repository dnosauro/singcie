package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.h */
public class C1083h extends C1095o {

    /* renamed from: b */
    private C1086j f3441b;

    /* renamed from: c */
    private C1086j f3442c;

    /* renamed from: a */
    private int m4246a(RecyclerView.C1022i iVar, View view, C1086j jVar) {
        return (jVar.mo6035a(view) + (jVar.mo6045e(view) / 2)) - (jVar.mo6040c() + (jVar.mo6046f() / 2));
    }

    /* renamed from: a */
    private int m4247a(RecyclerView.C1022i iVar, C1086j jVar, int i, int i2) {
        int[] b = mo6074b(i, i2);
        float b2 = m4249b(iVar, jVar);
        if (b2 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(b[0]) > Math.abs(b[1]) ? b[0] : b[1])) / b2);
    }

    /* renamed from: a */
    private View m4248a(RecyclerView.C1022i iVar, C1086j jVar) {
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
    private float m4249b(RecyclerView.C1022i iVar, C1086j jVar) {
        int max;
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = iVar.getChildAt(i3);
            int position = iVar.getPosition(childAt);
            if (position != -1) {
                if (position < i) {
                    view = childAt;
                    i = position;
                }
                if (position > i2) {
                    view2 = childAt;
                    i2 = position;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(jVar.mo6039b(view), jVar.mo6039b(view2)) - Math.min(jVar.mo6035a(view), jVar.mo6035a(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i2 - i) + 1));
    }

    /* renamed from: d */
    private C1086j m4250d(RecyclerView.C1022i iVar) {
        C1086j jVar = this.f3441b;
        if (jVar == null || jVar.f3444a != iVar) {
            this.f3441b = C1086j.m4265b(iVar);
        }
        return this.f3441b;
    }

    /* renamed from: e */
    private C1086j m4251e(RecyclerView.C1022i iVar) {
        C1086j jVar = this.f3442c;
        if (jVar == null || jVar.f3444a != iVar) {
            this.f3442c = C1086j.m4263a(iVar);
        }
        return this.f3442c;
    }

    /* renamed from: a */
    public int mo6029a(RecyclerView.C1022i iVar, int i, int i2) {
        int itemCount;
        View a;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(iVar instanceof RecyclerView.C1039t.C1041b) || (itemCount = iVar.getItemCount()) == 0 || (a = mo6030a(iVar)) == null || (position = iVar.getPosition(a)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.C1039t.C1041b) iVar).computeScrollVectorForPosition(i3)) == null) {
            return -1;
        }
        if (iVar.canScrollHorizontally()) {
            i4 = m4247a(iVar, m4251e(iVar), i, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (iVar.canScrollVertically()) {
            i5 = m4247a(iVar, m4250d(iVar), 0, i2);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (iVar.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = position + i4;
        if (i6 < 0) {
            i6 = 0;
        }
        return i6 >= itemCount ? itemCount - 1 : i6;
    }

    /* renamed from: a */
    public View mo6030a(RecyclerView.C1022i iVar) {
        C1086j e;
        if (iVar.canScrollVertically()) {
            e = m4250d(iVar);
        } else if (!iVar.canScrollHorizontally()) {
            return null;
        } else {
            e = m4251e(iVar);
        }
        return m4248a(iVar, e);
    }

    /* renamed from: a */
    public int[] mo6031a(RecyclerView.C1022i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.canScrollHorizontally()) {
            iArr[0] = m4246a(iVar, view, m4251e(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.canScrollVertically()) {
            iArr[1] = m4246a(iVar, view, m4250d(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
