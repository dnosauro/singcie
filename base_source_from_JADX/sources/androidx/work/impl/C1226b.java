package androidx.work.impl;

import androidx.lifecycle.C0960n;
import androidx.work.C1326k;
import androidx.work.impl.utils.p064a.C1309c;

/* renamed from: androidx.work.impl.b */
public class C1226b implements C1326k {

    /* renamed from: c */
    private final C0960n<C1326k.C1328a> f3816c = new C0960n<>();

    /* renamed from: d */
    private final C1309c<C1326k.C1328a.C1331c> f3817d = C1309c.m5145d();

    public C1226b() {
        mo6484a(C1326k.f4107b);
    }

    /* renamed from: a */
    public void mo6484a(C1326k.C1328a aVar) {
        this.f3816c.mo5091a(aVar);
        if (aVar instanceof C1326k.C1328a.C1331c) {
            this.f3817d.mo6622a((C1326k.C1328a.C1331c) aVar);
        } else if (aVar instanceof C1326k.C1328a.C1329a) {
            this.f3817d.mo6623a(((C1326k.C1328a.C1329a) aVar).mo6672a());
        }
    }
}
