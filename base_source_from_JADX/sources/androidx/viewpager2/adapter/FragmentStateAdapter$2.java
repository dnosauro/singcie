package androidx.viewpager2.adapter;

import androidx.core.p030h.C0656u;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0950f;
import androidx.lifecycle.C0952h;

class FragmentStateAdapter$2 implements C0950f {

    /* renamed from: a */
    final /* synthetic */ C1176b f3686a;

    /* renamed from: b */
    final /* synthetic */ C1173a f3687b;

    FragmentStateAdapter$2(C1173a aVar, C1176b bVar) {
        this.f3687b = aVar;
        this.f3686a = bVar;
    }

    /* renamed from: a */
    public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
        if (!this.f3687b.mo6322a()) {
            hVar.getLifecycle().mo5113b(this);
            if (C0656u.m2569B(this.f3686a.mo6324a())) {
                this.f3687b.mo6321a(this.f3686a);
            }
        }
    }
}
