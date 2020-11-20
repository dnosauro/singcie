package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.lifecycle.e */
public abstract class C0947e {

    /* renamed from: a */
    AtomicReference<Object> f3081a = new AtomicReference<>();

    /* renamed from: androidx.lifecycle.e$a */
    public enum C0948a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* renamed from: androidx.lifecycle.e$b */
    public enum C0949b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: a */
        public boolean mo5114a(C0949b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    /* renamed from: a */
    public abstract C0949b mo5111a();

    /* renamed from: a */
    public abstract void mo5112a(C0951g gVar);

    /* renamed from: b */
    public abstract void mo5113b(C0951g gVar);
}
