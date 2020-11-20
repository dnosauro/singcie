package androidx.lifecycle;

import androidx.lifecycle.C0947e;
import androidx.p004a.p005a.p006a.C0037a;
import androidx.p004a.p005a.p007b.C0044b;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: b */
    static final Object f3054b = new Object();

    /* renamed from: a */
    final Object f3055a = new Object();

    /* renamed from: c */
    int f3056c = 0;

    /* renamed from: d */
    volatile Object f3057d;

    /* renamed from: e */
    private C0044b<C0961o<? super T>, LiveData<T>.a> f3058e = new C0044b<>();

    /* renamed from: f */
    private volatile Object f3059f;

    /* renamed from: g */
    private int f3060g;

    /* renamed from: h */
    private boolean f3061h;

    /* renamed from: i */
    private boolean f3062i;

    /* renamed from: j */
    private final Runnable f3063j;

    class LifecycleBoundObserver extends LiveData<T>.a implements C0946d {

        /* renamed from: a */
        final C0952h f3065a;

        LifecycleBoundObserver(C0952h hVar, C0961o<? super T> oVar) {
            super(oVar);
            this.f3065a = hVar;
        }

        /* renamed from: a */
        public void mo659a(C0952h hVar, C0947e.C0948a aVar) {
            if (this.f3065a.getLifecycle().mo5111a() == C0947e.C0949b.DESTROYED) {
                LiveData.this.mo4580a(this.f3067c);
            } else {
                mo5097a(mo5094a());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5094a() {
            return this.f3065a.getLifecycle().mo5111a().mo5114a(C0947e.C0949b.STARTED);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5095a(C0952h hVar) {
            return this.f3065a == hVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5096b() {
            this.f3065a.getLifecycle().mo5113b(this);
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$a */
    private abstract class C0940a {

        /* renamed from: c */
        final C0961o<? super T> f3067c;

        /* renamed from: d */
        boolean f3068d;

        /* renamed from: e */
        int f3069e = -1;

        C0940a(C0961o<? super T> oVar) {
            this.f3067c = oVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5097a(boolean z) {
            if (z != this.f3068d) {
                this.f3068d = z;
                int i = 1;
                boolean z2 = LiveData.this.f3056c == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.f3056c;
                if (!this.f3068d) {
                    i = -1;
                }
                liveData.f3056c = i2 + i;
                if (z2 && this.f3068d) {
                    LiveData.this.mo4582b();
                }
                if (LiveData.this.f3056c == 0 && !this.f3068d) {
                    LiveData.this.mo4584c();
                }
                if (this.f3068d) {
                    LiveData.this.mo5089a((LiveData<T>.a) this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract boolean mo5094a();

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5095a(C0952h hVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5096b() {
        }
    }

    public LiveData() {
        Object obj = f3054b;
        this.f3059f = obj;
        this.f3057d = obj;
        this.f3060g = -1;
        this.f3063j = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f3055a) {
                    obj = LiveData.this.f3057d;
                    LiveData.this.f3057d = LiveData.f3054b;
                }
                LiveData.this.mo4583b(obj);
            }
        };
    }

    /* renamed from: a */
    private static void m3678a(String str) {
        if (!C0037a.m6a().mo625c()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }

    /* renamed from: b */
    private void m3679b(LiveData<T>.a aVar) {
        if (aVar.f3068d) {
            if (!aVar.mo5094a()) {
                aVar.mo5097a(false);
                return;
            }
            int i = aVar.f3069e;
            int i2 = this.f3060g;
            if (i < i2) {
                aVar.f3069e = i2;
                aVar.f3067c.mo4588a(this.f3059f);
            }
        }
    }

    /* renamed from: a */
    public T mo5088a() {
        T t = this.f3059f;
        if (t != f3054b) {
            return t;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5089a(LiveData<T>.a aVar) {
        if (this.f3061h) {
            this.f3062i = true;
            return;
        }
        this.f3061h = true;
        do {
            this.f3062i = false;
            if (aVar == null) {
                C0044b<K, V>.d c = this.f3058e.mo637c();
                while (c.hasNext()) {
                    m3679b((LiveData<T>.a) (C0940a) ((Map.Entry) c.next()).getValue());
                    if (this.f3062i) {
                        break;
                    }
                }
            } else {
                m3679b(aVar);
                aVar = null;
            }
        } while (this.f3062i);
        this.f3061h = false;
    }

    /* renamed from: a */
    public void mo5090a(C0952h hVar, C0961o<? super T> oVar) {
        m3678a("observe");
        if (hVar.getLifecycle().mo5111a() != C0947e.C0949b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(hVar, oVar);
            C0940a a = this.f3058e.mo630a(oVar, lifecycleBoundObserver);
            if (a != null && !a.mo5095a(hVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (a == null) {
                hVar.getLifecycle().mo5112a(lifecycleBoundObserver);
            }
        }
    }

    /* renamed from: a */
    public void mo4580a(C0961o<? super T> oVar) {
        m3678a("removeObserver");
        C0940a b = this.f3058e.mo631b(oVar);
        if (b != null) {
            b.mo5096b();
            b.mo5097a(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5091a(T t) {
        boolean z;
        synchronized (this.f3055a) {
            z = this.f3057d == f3054b;
            this.f3057d = t;
        }
        if (z) {
            C0037a.m6a().mo624b(this.f3063j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4582b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4583b(T t) {
        m3678a("setValue");
        this.f3060g++;
        this.f3059f = t;
        mo5089a((LiveData<T>.a) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4584c() {
    }

    /* renamed from: d */
    public boolean mo5092d() {
        return this.f3056c > 0;
    }
}
