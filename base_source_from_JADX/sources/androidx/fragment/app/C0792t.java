package androidx.fragment.app;

import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0952h;
import androidx.lifecycle.C0953i;

/* renamed from: androidx.fragment.app.t */
class C0792t implements C0952h {

    /* renamed from: a */
    private C0953i f2730a = null;

    C0792t() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4571a() {
        if (this.f2730a == null) {
            this.f2730a = new C0953i(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4572a(C0947e.C0948a aVar) {
        this.f2730a.mo5115a(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4573b() {
        return this.f2730a != null;
    }

    public C0947e getLifecycle() {
        mo4571a();
        return this.f2730a;
    }
}
