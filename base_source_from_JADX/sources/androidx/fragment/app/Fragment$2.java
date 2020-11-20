package androidx.fragment.app;

import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0950f;
import androidx.lifecycle.C0952h;

class Fragment$2 implements C0950f {

    /* renamed from: a */
    final /* synthetic */ C0735d f2496a;

    Fragment$2(C0735d dVar) {
        this.f2496a = dVar;
    }

    /* renamed from: a */
    public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
        if (aVar == C0947e.C0948a.ON_STOP && this.f2496a.mView != null) {
            this.f2496a.mView.cancelPendingInputEvents();
        }
    }
}
