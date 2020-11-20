package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0950f;
import androidx.lifecycle.C0952h;

class ComponentActivity$2 implements C0950f {

    /* renamed from: a */
    final /* synthetic */ C0054b f30a;

    ComponentActivity$2(C0054b bVar) {
        this.f30a = bVar;
    }

    /* renamed from: a */
    public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
        if (aVar == C0947e.C0948a.ON_STOP) {
            Window window = this.f30a.getWindow();
            View peekDecorView = window != null ? window.peekDecorView() : null;
            if (peekDecorView != null) {
                peekDecorView.cancelPendingInputEvents();
            }
        }
    }
}
