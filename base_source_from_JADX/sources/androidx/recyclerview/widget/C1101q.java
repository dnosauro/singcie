package androidx.recyclerview.widget;

import androidx.core.p029g.C0584e;
import androidx.p018c.C0405d;
import androidx.p018c.C0413g;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.q */
class C1101q {

    /* renamed from: a */
    final C0413g<RecyclerView.C1045x, C1102a> f3466a = new C0413g<>();

    /* renamed from: b */
    final C0405d<RecyclerView.C1045x> f3467b = new C0405d<>();

    /* renamed from: androidx.recyclerview.widget.q$a */
    static class C1102a {

        /* renamed from: d */
        static C0584e.C0585a<C1102a> f3468d = new C0584e.C0586b(20);

        /* renamed from: a */
        int f3469a;

        /* renamed from: b */
        RecyclerView.C1016f.C1019c f3470b;

        /* renamed from: c */
        RecyclerView.C1016f.C1019c f3471c;

        private C1102a() {
        }

        /* renamed from: a */
        static C1102a m4392a() {
            C1102a a = f3468d.mo3611a();
            return a == null ? new C1102a() : a;
        }

        /* renamed from: a */
        static void m4393a(C1102a aVar) {
            aVar.f3469a = 0;
            aVar.f3470b = null;
            aVar.f3471c = null;
            f3468d.mo3612a(aVar);
        }

        /* renamed from: b */
        static void m4394b() {
            do {
            } while (f3468d.mo3611a() != null);
        }
    }

    /* renamed from: androidx.recyclerview.widget.q$b */
    interface C1103b {
        /* renamed from: a */
        void mo5480a(RecyclerView.C1045x xVar);

        /* renamed from: a */
        void mo5481a(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar, RecyclerView.C1016f.C1019c cVar2);

        /* renamed from: b */
        void mo5482b(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar, RecyclerView.C1016f.C1019c cVar2);

        /* renamed from: c */
        void mo5483c(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar, RecyclerView.C1016f.C1019c cVar2);
    }

    C1101q() {
    }

    /* renamed from: a */
    private RecyclerView.C1016f.C1019c m4375a(RecyclerView.C1045x xVar, int i) {
        C1102a c;
        RecyclerView.C1016f.C1019c cVar;
        int a = this.f3466a.mo2942a((Object) xVar);
        if (a < 0 || (c = this.f3466a.mo2949c(a)) == null || (c.f3469a & i) == 0) {
            return null;
        }
        c.f3469a &= ~i;
        if (i == 4) {
            cVar = c.f3470b;
        } else if (i == 8) {
            cVar = c.f3471c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c.f3469a & 12) == 0) {
            this.f3466a.mo2953d(a);
            C1102a.m4393a(c);
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public RecyclerView.C1045x mo6083a(long j) {
        return this.f3467b.mo2846a(j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6084a() {
        this.f3466a.clear();
        this.f3467b.mo2859d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6085a(long j, RecyclerView.C1045x xVar) {
        this.f3467b.mo2852b(j, xVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6086a(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar) {
        C1102a aVar = this.f3466a.get(xVar);
        if (aVar == null) {
            aVar = C1102a.m4392a();
            this.f3466a.put(xVar, aVar);
        }
        aVar.f3470b = cVar;
        aVar.f3469a |= 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6087a(C1103b bVar) {
        RecyclerView.C1016f.C1019c cVar;
        RecyclerView.C1016f.C1019c cVar2;
        for (int size = this.f3466a.size() - 1; size >= 0; size--) {
            RecyclerView.C1045x b = this.f3466a.mo2948b(size);
            C1102a d = this.f3466a.mo2953d(size);
            if ((d.f3469a & 3) != 3) {
                if ((d.f3469a & 1) == 0) {
                    if ((d.f3469a & 14) != 14) {
                        if ((d.f3469a & 12) == 12) {
                            bVar.mo5483c(b, d.f3470b, d.f3471c);
                        } else if ((d.f3469a & 4) != 0) {
                            cVar = d.f3470b;
                            cVar2 = null;
                        } else if ((d.f3469a & 8) == 0) {
                            int i = d.f3469a;
                        }
                        C1102a.m4393a(d);
                    }
                    bVar.mo5482b(b, d.f3470b, d.f3471c);
                    C1102a.m4393a(d);
                } else if (d.f3470b != null) {
                    cVar = d.f3470b;
                    cVar2 = d.f3471c;
                }
                bVar.mo5481a(b, cVar, cVar2);
                C1102a.m4393a(d);
            }
            bVar.mo5480a(b);
            C1102a.m4393a(d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6088a(RecyclerView.C1045x xVar) {
        C1102a aVar = this.f3466a.get(xVar);
        return (aVar == null || (aVar.f3469a & 1) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public RecyclerView.C1016f.C1019c mo6089b(RecyclerView.C1045x xVar) {
        return m4375a(xVar, 4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6090b() {
        C1102a.m4394b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6091b(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar) {
        C1102a aVar = this.f3466a.get(xVar);
        if (aVar == null) {
            aVar = C1102a.m4392a();
            this.f3466a.put(xVar, aVar);
        }
        aVar.f3469a |= 2;
        aVar.f3470b = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public RecyclerView.C1016f.C1019c mo6092c(RecyclerView.C1045x xVar) {
        return m4375a(xVar, 8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6093c(RecyclerView.C1045x xVar, RecyclerView.C1016f.C1019c cVar) {
        C1102a aVar = this.f3466a.get(xVar);
        if (aVar == null) {
            aVar = C1102a.m4392a();
            this.f3466a.put(xVar, aVar);
        }
        aVar.f3471c = cVar;
        aVar.f3469a |= 8;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo6094d(RecyclerView.C1045x xVar) {
        C1102a aVar = this.f3466a.get(xVar);
        return (aVar == null || (aVar.f3469a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6095e(RecyclerView.C1045x xVar) {
        C1102a aVar = this.f3466a.get(xVar);
        if (aVar == null) {
            aVar = C1102a.m4392a();
            this.f3466a.put(xVar, aVar);
        }
        aVar.f3469a |= 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6096f(RecyclerView.C1045x xVar) {
        C1102a aVar = this.f3466a.get(xVar);
        if (aVar != null) {
            aVar.f3469a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6097g(RecyclerView.C1045x xVar) {
        int b = this.f3467b.mo2849b() - 1;
        while (true) {
            if (b < 0) {
                break;
            } else if (xVar == this.f3467b.mo2853c(b)) {
                this.f3467b.mo2848a(b);
                break;
            } else {
                b--;
            }
        }
        C1102a remove = this.f3466a.remove(xVar);
        if (remove != null) {
            C1102a.m4393a(remove);
        }
    }

    /* renamed from: h */
    public void mo6098h(RecyclerView.C1045x xVar) {
        mo6096f(xVar);
    }
}
