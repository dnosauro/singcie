package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0950f;
import androidx.lifecycle.C0952h;

class FragmentStateAdapter$5 implements C0950f {

    /* renamed from: a */
    final /* synthetic */ Handler f3688a;

    /* renamed from: b */
    final /* synthetic */ Runnable f3689b;

    /* renamed from: a */
    public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
        if (aVar == C0947e.C0948a.ON_DESTROY) {
            this.f3688a.removeCallbacks(this.f3689b);
            hVar.getLifecycle().mo5113b(this);
        }
    }
}
