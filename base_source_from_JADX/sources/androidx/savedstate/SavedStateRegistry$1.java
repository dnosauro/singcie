package androidx.savedstate;

import androidx.lifecycle.C0946d;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0952h;

class SavedStateRegistry$1 implements C0946d {

    /* renamed from: a */
    final /* synthetic */ C1150a f3618a;

    SavedStateRegistry$1(C1150a aVar) {
        this.f3618a = aVar;
    }

    /* renamed from: a */
    public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
        C1150a aVar2;
        boolean z;
        if (aVar == C0947e.C0948a.ON_START) {
            aVar2 = this.f3618a;
            z = true;
        } else if (aVar == C0947e.C0948a.ON_STOP) {
            aVar2 = this.f3618a;
            z = false;
        } else {
            return;
        }
        aVar2.f3619a = z;
    }
}
