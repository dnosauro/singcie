package androidx.lifecycle;

import androidx.lifecycle.C0947e;

class CompositeGeneratedAdaptersObserver implements C0950f {

    /* renamed from: a */
    private final C0945c[] f3049a;

    CompositeGeneratedAdaptersObserver(C0945c[] cVarArr) {
        this.f3049a = cVarArr;
    }

    /* renamed from: a */
    public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
        C0959m mVar = new C0959m();
        for (C0945c a : this.f3049a) {
            a.mo5110a(hVar, aVar, false, mVar);
        }
        for (C0945c a2 : this.f3049a) {
            a2.mo5110a(hVar, aVar, true, mVar);
        }
    }
}
