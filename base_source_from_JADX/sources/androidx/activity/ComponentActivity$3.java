package androidx.activity;

import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0950f;
import androidx.lifecycle.C0952h;

class ComponentActivity$3 implements C0950f {

    /* renamed from: a */
    final /* synthetic */ C0054b f31a;

    ComponentActivity$3(C0054b bVar) {
        this.f31a = bVar;
    }

    /* renamed from: a */
    public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
        if (aVar == C0947e.C0948a.ON_DESTROY && !this.f31a.isChangingConfigurations()) {
            this.f31a.getViewModelStore().mo5146a();
        }
    }
}
