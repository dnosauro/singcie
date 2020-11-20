package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.p020a.C0420e;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.a.a.p */
public class C0438p {

    /* renamed from: a */
    private int f1611a;

    /* renamed from: b */
    private int f1612b;

    /* renamed from: c */
    private int f1613c;

    /* renamed from: d */
    private int f1614d;

    /* renamed from: e */
    private ArrayList<C0439a> f1615e = new ArrayList<>();

    /* renamed from: androidx.constraintlayout.a.a.p$a */
    static class C0439a {

        /* renamed from: a */
        private C0420e f1616a;

        /* renamed from: b */
        private C0420e f1617b;

        /* renamed from: c */
        private int f1618c;

        /* renamed from: d */
        private C0420e.C0423b f1619d;

        /* renamed from: e */
        private int f1620e;

        public C0439a(C0420e eVar) {
            this.f1616a = eVar;
            this.f1617b = eVar.mo3014g();
            this.f1618c = eVar.mo3012e();
            this.f1619d = eVar.mo3013f();
            this.f1620e = eVar.mo3015h();
        }

        /* renamed from: a */
        public void mo3145a(C0425f fVar) {
            int i;
            this.f1616a = fVar.mo3028a(this.f1616a.mo3011d());
            C0420e eVar = this.f1616a;
            if (eVar != null) {
                this.f1617b = eVar.mo3014g();
                this.f1618c = this.f1616a.mo3012e();
                this.f1619d = this.f1616a.mo3013f();
                i = this.f1616a.mo3015h();
            } else {
                this.f1617b = null;
                i = 0;
                this.f1618c = 0;
                this.f1619d = C0420e.C0423b.STRONG;
            }
            this.f1620e = i;
        }

        /* renamed from: b */
        public void mo3146b(C0425f fVar) {
            fVar.mo3028a(this.f1616a.mo3011d()).mo3008a(this.f1617b, this.f1618c, this.f1619d, this.f1620e);
        }
    }

    public C0438p(C0425f fVar) {
        this.f1611a = fVar.mo3077n();
        this.f1612b = fVar.mo3079o();
        this.f1613c = fVar.mo3081p();
        this.f1614d = fVar.mo3085r();
        ArrayList<C0420e> C = fVar.mo3021C();
        int size = C.size();
        for (int i = 0; i < size; i++) {
            this.f1615e.add(new C0439a(C.get(i)));
        }
    }

    /* renamed from: a */
    public void mo3143a(C0425f fVar) {
        this.f1611a = fVar.mo3077n();
        this.f1612b = fVar.mo3079o();
        this.f1613c = fVar.mo3081p();
        this.f1614d = fVar.mo3085r();
        int size = this.f1615e.size();
        for (int i = 0; i < size; i++) {
            this.f1615e.get(i).mo3145a(fVar);
        }
    }

    /* renamed from: b */
    public void mo3144b(C0425f fVar) {
        fVar.mo3065h(this.f1611a);
        fVar.mo3068i(this.f1612b);
        fVar.mo3070j(this.f1613c);
        fVar.mo3072k(this.f1614d);
        int size = this.f1615e.size();
        for (int i = 0; i < size; i++) {
            this.f1615e.get(i).mo3146b(fVar);
        }
    }
}
