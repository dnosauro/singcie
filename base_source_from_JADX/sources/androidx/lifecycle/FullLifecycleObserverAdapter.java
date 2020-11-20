package androidx.lifecycle;

import androidx.lifecycle.C0947e;

class FullLifecycleObserverAdapter implements C0950f {

    /* renamed from: a */
    private final C0944b f3050a;

    /* renamed from: b */
    private final C0950f f3051b;

    FullLifecycleObserverAdapter(C0944b bVar, C0950f fVar) {
        this.f3050a = bVar;
        this.f3051b = fVar;
    }

    /* renamed from: a */
    public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f3050a.mo5104a(hVar);
                break;
            case ON_START:
                this.f3050a.mo5105b(hVar);
                break;
            case ON_RESUME:
                this.f3050a.mo5106c(hVar);
                break;
            case ON_PAUSE:
                this.f3050a.mo5107d(hVar);
                break;
            case ON_STOP:
                this.f3050a.mo5108e(hVar);
                break;
            case ON_DESTROY:
                this.f3050a.mo5109f(hVar);
                break;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        C0950f fVar = this.f3051b;
        if (fVar != null) {
            fVar.mo659a(hVar, aVar);
        }
    }
}
