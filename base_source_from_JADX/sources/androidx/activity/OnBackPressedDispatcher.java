package androidx.activity;

import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0950f;
import androidx.lifecycle.C0952h;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a */
    final ArrayDeque<C0057c> f37a;

    /* renamed from: b */
    private final Runnable f38b;

    private class LifecycleOnBackPressedCancellable implements C0053a, C0950f {

        /* renamed from: b */
        private final C0947e f40b;

        /* renamed from: c */
        private final C0057c f41c;

        /* renamed from: d */
        private C0053a f42d;

        LifecycleOnBackPressedCancellable(C0947e eVar, C0057c cVar) {
            this.f40b = eVar;
            this.f41c = cVar;
            eVar.mo5112a(this);
        }

        /* renamed from: a */
        public void mo663a() {
            this.f40b.mo5113b(this);
            this.f41c.mo679b(this);
            C0053a aVar = this.f42d;
            if (aVar != null) {
                aVar.mo663a();
                this.f42d = null;
            }
        }

        /* renamed from: a */
        public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
            if (aVar == C0947e.C0948a.ON_START) {
                this.f42d = OnBackPressedDispatcher.this.mo660a(this.f41c);
            } else if (aVar == C0947e.C0948a.ON_STOP) {
                C0053a aVar2 = this.f42d;
                if (aVar2 != null) {
                    aVar2.mo663a();
                }
            } else if (aVar == C0947e.C0948a.ON_DESTROY) {
                mo663a();
            }
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$a */
    private class C0052a implements C0053a {

        /* renamed from: b */
        private final C0057c f44b;

        C0052a(C0057c cVar) {
            this.f44b = cVar;
        }

        /* renamed from: a */
        public void mo663a() {
            OnBackPressedDispatcher.this.f37a.remove(this.f44b);
            this.f44b.mo679b(this);
        }
    }

    public OnBackPressedDispatcher() {
        this((Runnable) null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f37a = new ArrayDeque<>();
        this.f38b = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0053a mo660a(C0057c cVar) {
        this.f37a.add(cVar);
        C0052a aVar = new C0052a(cVar);
        cVar.mo675a((C0053a) aVar);
        return aVar;
    }

    /* renamed from: a */
    public void mo661a() {
        Iterator<C0057c> descendingIterator = this.f37a.descendingIterator();
        while (descendingIterator.hasNext()) {
            C0057c next = descendingIterator.next();
            if (next.mo677a()) {
                next.mo680c();
                return;
            }
        }
        Runnable runnable = this.f38b;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: a */
    public void mo662a(C0952h hVar, C0057c cVar) {
        C0947e lifecycle = hVar.getLifecycle();
        if (lifecycle.mo5111a() != C0947e.C0949b.DESTROYED) {
            cVar.mo675a((C0053a) new LifecycleOnBackPressedCancellable(lifecycle, cVar));
        }
    }
}
