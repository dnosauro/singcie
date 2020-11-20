package androidx.lifecycle;

import androidx.lifecycle.C0947e;
import androidx.p004a.p005a.p007b.C0043a;
import androidx.p004a.p005a.p007b.C0044b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.lifecycle.i */
public class C0953i extends C0947e {

    /* renamed from: b */
    private C0043a<C0951g, C0955a> f3088b = new C0043a<>();

    /* renamed from: c */
    private C0947e.C0949b f3089c;

    /* renamed from: d */
    private final WeakReference<C0952h> f3090d;

    /* renamed from: e */
    private int f3091e = 0;

    /* renamed from: f */
    private boolean f3092f = false;

    /* renamed from: g */
    private boolean f3093g = false;

    /* renamed from: h */
    private ArrayList<C0947e.C0949b> f3094h = new ArrayList<>();

    /* renamed from: androidx.lifecycle.i$a */
    static class C0955a {

        /* renamed from: a */
        C0947e.C0949b f3097a;

        /* renamed from: b */
        C0950f f3098b;

        C0955a(C0951g gVar, C0947e.C0949b bVar) {
            this.f3098b = C0958l.m3740a((Object) gVar);
            this.f3097a = bVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5118a(C0952h hVar, C0947e.C0948a aVar) {
            C0947e.C0949b b = C0953i.m3721b(aVar);
            this.f3097a = C0953i.m3719a(this.f3097a, b);
            this.f3098b.mo659a(hVar, aVar);
            this.f3097a = b;
        }
    }

    public C0953i(C0952h hVar) {
        this.f3090d = new WeakReference<>(hVar);
        this.f3089c = C0947e.C0949b.INITIALIZED;
    }

    /* renamed from: a */
    static C0947e.C0949b m3719a(C0947e.C0949b bVar, C0947e.C0949b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* renamed from: a */
    private void m3720a(C0952h hVar) {
        C0044b<K, V>.d c = this.f3088b.mo637c();
        while (c.hasNext() && !this.f3093g) {
            Map.Entry entry = (Map.Entry) c.next();
            C0955a aVar = (C0955a) entry.getValue();
            while (aVar.f3097a.compareTo(this.f3089c) < 0 && !this.f3093g && this.f3088b.mo632c(entry.getKey())) {
                m3728d(aVar.f3097a);
                aVar.mo5118a(hVar, m3730f(aVar.f3097a));
                m3725c();
            }
        }
    }

    /* renamed from: b */
    static C0947e.C0949b m3721b(C0947e.C0948a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return C0947e.C0949b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return C0947e.C0949b.STARTED;
            case ON_RESUME:
                return C0947e.C0949b.RESUMED;
            case ON_DESTROY:
                return C0947e.C0949b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* renamed from: b */
    private void m3722b(C0952h hVar) {
        Iterator<Map.Entry<C0951g, C0955a>> b = this.f3088b.mo636b();
        while (b.hasNext() && !this.f3093g) {
            Map.Entry next = b.next();
            C0955a aVar = (C0955a) next.getValue();
            while (aVar.f3097a.compareTo(this.f3089c) > 0 && !this.f3093g && this.f3088b.mo632c(next.getKey())) {
                C0947e.C0948a e = m3729e(aVar.f3097a);
                m3728d(m3721b(e));
                aVar.mo5118a(hVar, e);
                m3725c();
            }
        }
    }

    /* renamed from: b */
    private boolean m3723b() {
        if (this.f3088b.mo634a() == 0) {
            return true;
        }
        C0947e.C0949b bVar = this.f3088b.mo638d().getValue().f3097a;
        C0947e.C0949b bVar2 = this.f3088b.mo639e().getValue().f3097a;
        return bVar == bVar2 && this.f3089c == bVar2;
    }

    /* renamed from: c */
    private C0947e.C0949b m3724c(C0951g gVar) {
        Map.Entry<C0951g, C0955a> d = this.f3088b.mo633d(gVar);
        C0947e.C0949b bVar = null;
        C0947e.C0949b bVar2 = d != null ? d.getValue().f3097a : null;
        if (!this.f3094h.isEmpty()) {
            ArrayList<C0947e.C0949b> arrayList = this.f3094h;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return m3719a(m3719a(this.f3089c, bVar2), bVar);
    }

    /* renamed from: c */
    private void m3725c() {
        ArrayList<C0947e.C0949b> arrayList = this.f3094h;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: c */
    private void m3726c(C0947e.C0949b bVar) {
        if (this.f3089c != bVar) {
            this.f3089c = bVar;
            if (this.f3092f || this.f3091e != 0) {
                this.f3093g = true;
                return;
            }
            this.f3092f = true;
            m3727d();
            this.f3092f = false;
        }
    }

    /* renamed from: d */
    private void m3727d() {
        C0952h hVar = (C0952h) this.f3090d.get();
        if (hVar != null) {
            while (!m3723b()) {
                this.f3093g = false;
                if (this.f3089c.compareTo(this.f3088b.mo638d().getValue().f3097a) < 0) {
                    m3722b(hVar);
                }
                Map.Entry<C0951g, C0955a> e = this.f3088b.mo639e();
                if (!this.f3093g && e != null && this.f3089c.compareTo(e.getValue().f3097a) > 0) {
                    m3720a(hVar);
                }
            }
            this.f3093g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    /* renamed from: d */
    private void m3728d(C0947e.C0949b bVar) {
        this.f3094h.add(bVar);
    }

    /* renamed from: e */
    private static C0947e.C0948a m3729e(C0947e.C0949b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return C0947e.C0948a.ON_DESTROY;
            case STARTED:
                return C0947e.C0948a.ON_STOP;
            case RESUMED:
                return C0947e.C0948a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    /* renamed from: f */
    private static C0947e.C0948a m3730f(C0947e.C0949b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return C0947e.C0948a.ON_CREATE;
            case CREATED:
                return C0947e.C0948a.ON_START;
            case STARTED:
                return C0947e.C0948a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    /* renamed from: a */
    public C0947e.C0949b mo5111a() {
        return this.f3089c;
    }

    /* renamed from: a */
    public void mo5115a(C0947e.C0948a aVar) {
        m3726c(m3721b(aVar));
    }

    @Deprecated
    /* renamed from: a */
    public void mo5116a(C0947e.C0949b bVar) {
        mo5117b(bVar);
    }

    /* renamed from: a */
    public void mo5112a(C0951g gVar) {
        C0952h hVar;
        C0955a aVar = new C0955a(gVar, this.f3089c == C0947e.C0949b.DESTROYED ? C0947e.C0949b.DESTROYED : C0947e.C0949b.INITIALIZED);
        if (this.f3088b.mo630a(gVar, aVar) == null && (hVar = (C0952h) this.f3090d.get()) != null) {
            boolean z = this.f3091e != 0 || this.f3092f;
            C0947e.C0949b c = m3724c(gVar);
            this.f3091e++;
            while (aVar.f3097a.compareTo(c) < 0 && this.f3088b.mo632c(gVar)) {
                m3728d(aVar.f3097a);
                aVar.mo5118a(hVar, m3730f(aVar.f3097a));
                m3725c();
                c = m3724c(gVar);
            }
            if (!z) {
                m3727d();
            }
            this.f3091e--;
        }
    }

    /* renamed from: b */
    public void mo5117b(C0947e.C0949b bVar) {
        m3726c(bVar);
    }

    /* renamed from: b */
    public void mo5113b(C0951g gVar) {
        this.f3088b.mo631b(gVar);
    }
}
