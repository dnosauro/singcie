package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.n */
public abstract class C1094n extends RecyclerView.C1016f {

    /* renamed from: h */
    boolean f3452h = true;

    /* renamed from: a */
    public final void mo6056a(RecyclerView.C1045x xVar, boolean z) {
        mo6059d(xVar, z);
        mo5562f(xVar);
    }

    /* renamed from: a */
    public abstract boolean mo5970a(RecyclerView.C1045x xVar);

    /* renamed from: a */
    public abstract boolean mo5971a(RecyclerView.C1045x xVar, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public boolean mo5552a(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar, RecyclerView.C1016f.C1019c cVar2) {
        int i = cVar.f3194a;
        int i2 = cVar.f3195b;
        View view = xVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3194a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3195b;
        if (xVar.isRemoved() || (i == left && i2 == top)) {
            return mo5970a(xVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo5971a(xVar, i, i2, left, top);
    }

    /* renamed from: a */
    public abstract boolean mo5972a(RecyclerView.C1045x xVar, RecyclerView.C1045x xVar2, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public boolean mo5553a(RecyclerView.C1045x xVar, RecyclerView.C1045x xVar2, RecyclerView.C1016f.C1019c cVar, RecyclerView.C1016f.C1019c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f3194a;
        int i4 = cVar.f3195b;
        if (xVar2.shouldIgnore()) {
            int i5 = cVar.f3194a;
            i = cVar.f3195b;
            i2 = i5;
        } else {
            i2 = cVar2.f3194a;
            i = cVar2.f3195b;
        }
        return mo5972a(xVar, xVar2, i3, i4, i2, i);
    }

    /* renamed from: b */
    public final void mo6057b(RecyclerView.C1045x xVar, boolean z) {
        mo6058c(xVar, z);
    }

    /* renamed from: b */
    public abstract boolean mo5974b(RecyclerView.C1045x xVar);

    /* renamed from: b */
    public boolean mo5556b(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar, RecyclerView.C1016f.C1019c cVar2) {
        if (cVar == null || (cVar.f3194a == cVar2.f3194a && cVar.f3195b == cVar2.f3195b)) {
            return mo5974b(xVar);
        }
        return mo5971a(xVar, cVar.f3194a, cVar.f3195b, cVar2.f3194a, cVar2.f3195b);
    }

    /* renamed from: c */
    public void mo6058c(RecyclerView.C1045x xVar, boolean z) {
    }

    /* renamed from: c */
    public boolean mo5557c(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar, RecyclerView.C1016f.C1019c cVar2) {
        if (cVar.f3194a == cVar2.f3194a && cVar.f3195b == cVar2.f3195b) {
            mo6061j(xVar);
            return false;
        }
        return mo5971a(xVar, cVar.f3194a, cVar.f3195b, cVar2.f3194a, cVar2.f3195b);
    }

    /* renamed from: d */
    public void mo6059d(RecyclerView.C1045x xVar, boolean z) {
    }

    /* renamed from: h */
    public boolean mo5566h(RecyclerView.C1045x xVar) {
        return !this.f3452h || xVar.isInvalid();
    }

    /* renamed from: i */
    public final void mo6060i(RecyclerView.C1045x xVar) {
        mo6067p(xVar);
        mo5562f(xVar);
    }

    /* renamed from: j */
    public final void mo6061j(RecyclerView.C1045x xVar) {
        mo6071t(xVar);
        mo5562f(xVar);
    }

    /* renamed from: k */
    public final void mo6062k(RecyclerView.C1045x xVar) {
        mo6069r(xVar);
        mo5562f(xVar);
    }

    /* renamed from: l */
    public final void mo6063l(RecyclerView.C1045x xVar) {
        mo6066o(xVar);
    }

    /* renamed from: m */
    public final void mo6064m(RecyclerView.C1045x xVar) {
        mo6070s(xVar);
    }

    /* renamed from: n */
    public final void mo6065n(RecyclerView.C1045x xVar) {
        mo6068q(xVar);
    }

    /* renamed from: o */
    public void mo6066o(RecyclerView.C1045x xVar) {
    }

    /* renamed from: p */
    public void mo6067p(RecyclerView.C1045x xVar) {
    }

    /* renamed from: q */
    public void mo6068q(RecyclerView.C1045x xVar) {
    }

    /* renamed from: r */
    public void mo6069r(RecyclerView.C1045x xVar) {
    }

    /* renamed from: s */
    public void mo6070s(RecyclerView.C1045x xVar) {
    }

    /* renamed from: t */
    public void mo6071t(RecyclerView.C1045x xVar) {
    }
}
