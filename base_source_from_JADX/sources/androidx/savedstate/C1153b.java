package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.C0947e;

/* renamed from: androidx.savedstate.b */
public final class C1153b {

    /* renamed from: a */
    private final C1154c f3623a;

    /* renamed from: b */
    private final C1150a f3624b = new C1150a();

    private C1153b(C1154c cVar) {
        this.f3623a = cVar;
    }

    /* renamed from: a */
    public static C1153b m4533a(C1154c cVar) {
        return new C1153b(cVar);
    }

    /* renamed from: a */
    public C1150a mo6204a() {
        return this.f3624b;
    }

    /* renamed from: a */
    public void mo6205a(Bundle bundle) {
        C0947e lifecycle = this.f3623a.getLifecycle();
        if (lifecycle.mo5111a() == C0947e.C0949b.INITIALIZED) {
            lifecycle.mo5112a(new Recreator(this.f3623a));
            this.f3624b.mo6201a(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    /* renamed from: b */
    public void mo6206b(Bundle bundle) {
        this.f3624b.mo6200a(bundle);
    }
}
