package androidx.work.impl.utils.p064a;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: androidx.work.impl.utils.a.a */
public abstract class C1297a<V> implements ListenableFuture<V> {

    /* renamed from: a */
    static final boolean f4041a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: b */
    static final C1299a f4042b;

    /* renamed from: f */
    private static final Logger f4043f = Logger.getLogger(C1297a.class.getName());

    /* renamed from: g */
    private static final Object f4044g = new Object();

    /* renamed from: c */
    volatile Object f4045c;

    /* renamed from: d */
    volatile C1303d f4046d;

    /* renamed from: e */
    volatile C1307h f4047e;

    /* renamed from: androidx.work.impl.utils.a.a$a */
    private static abstract class C1299a {
        private C1299a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo6633a(C1307h hVar, C1307h hVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo6634a(C1307h hVar, Thread thread);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract boolean mo6635a(C1297a<?> aVar, C1303d dVar, C1303d dVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract boolean mo6636a(C1297a<?> aVar, C1307h hVar, C1307h hVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract boolean mo6637a(C1297a<?> aVar, Object obj, Object obj2);
    }

    /* renamed from: androidx.work.impl.utils.a.a$b */
    private static final class C1300b {

        /* renamed from: a */
        static final C1300b f4048a;

        /* renamed from: b */
        static final C1300b f4049b;

        /* renamed from: c */
        final boolean f4050c;

        /* renamed from: d */
        final Throwable f4051d;

        static {
            if (C1297a.f4041a) {
                f4049b = null;
                f4048a = null;
                return;
            }
            f4049b = new C1300b(false, (Throwable) null);
            f4048a = new C1300b(true, (Throwable) null);
        }

        C1300b(boolean z, Throwable th) {
            this.f4050c = z;
            this.f4051d = th;
        }
    }

    /* renamed from: androidx.work.impl.utils.a.a$c */
    private static final class C1301c {

        /* renamed from: a */
        static final C1301c f4052a = new C1301c(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: b */
        final Throwable f4053b;

        C1301c(Throwable th) {
            this.f4053b = (Throwable) C1297a.m5118b(th);
        }
    }

    /* renamed from: androidx.work.impl.utils.a.a$d */
    private static final class C1303d {

        /* renamed from: a */
        static final C1303d f4054a = new C1303d((Runnable) null, (Executor) null);

        /* renamed from: b */
        final Runnable f4055b;

        /* renamed from: c */
        final Executor f4056c;

        /* renamed from: d */
        C1303d f4057d;

        C1303d(Runnable runnable, Executor executor) {
            this.f4055b = runnable;
            this.f4056c = executor;
        }
    }

    /* renamed from: androidx.work.impl.utils.a.a$e */
    private static final class C1304e extends C1299a {

        /* renamed from: a */
        final AtomicReferenceFieldUpdater<C1307h, Thread> f4058a;

        /* renamed from: b */
        final AtomicReferenceFieldUpdater<C1307h, C1307h> f4059b;

        /* renamed from: c */
        final AtomicReferenceFieldUpdater<C1297a, C1307h> f4060c;

        /* renamed from: d */
        final AtomicReferenceFieldUpdater<C1297a, C1303d> f4061d;

        /* renamed from: e */
        final AtomicReferenceFieldUpdater<C1297a, Object> f4062e;

        C1304e(AtomicReferenceFieldUpdater<C1307h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<C1307h, C1307h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<C1297a, C1307h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<C1297a, C1303d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<C1297a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f4058a = atomicReferenceFieldUpdater;
            this.f4059b = atomicReferenceFieldUpdater2;
            this.f4060c = atomicReferenceFieldUpdater3;
            this.f4061d = atomicReferenceFieldUpdater4;
            this.f4062e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6633a(C1307h hVar, C1307h hVar2) {
            this.f4059b.lazySet(hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6634a(C1307h hVar, Thread thread) {
            this.f4058a.lazySet(hVar, thread);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6635a(C1297a<?> aVar, C1303d dVar, C1303d dVar2) {
            return this.f4061d.compareAndSet(aVar, dVar, dVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6636a(C1297a<?> aVar, C1307h hVar, C1307h hVar2) {
            return this.f4060c.compareAndSet(aVar, hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6637a(C1297a<?> aVar, Object obj, Object obj2) {
            return this.f4062e.compareAndSet(aVar, obj, obj2);
        }
    }

    /* renamed from: androidx.work.impl.utils.a.a$f */
    private static final class C1305f<V> implements Runnable {

        /* renamed from: a */
        final C1297a<V> f4063a;

        /* renamed from: b */
        final ListenableFuture<? extends V> f4064b;

        C1305f(C1297a<V> aVar, ListenableFuture<? extends V> listenableFuture) {
            this.f4063a = aVar;
            this.f4064b = listenableFuture;
        }

        public void run() {
            if (this.f4063a.f4045c == this) {
                if (C1297a.f4042b.mo6637a((C1297a<?>) this.f4063a, (Object) this, C1297a.m5117b((ListenableFuture<?>) this.f4064b))) {
                    C1297a.m5114a((C1297a<?>) this.f4063a);
                }
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.a.a$g */
    private static final class C1306g extends C1299a {
        C1306g() {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6633a(C1307h hVar, C1307h hVar2) {
            hVar.f4067c = hVar2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6634a(C1307h hVar, Thread thread) {
            hVar.f4066b = thread;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6635a(C1297a<?> aVar, C1303d dVar, C1303d dVar2) {
            synchronized (aVar) {
                if (aVar.f4046d != dVar) {
                    return false;
                }
                aVar.f4046d = dVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6636a(C1297a<?> aVar, C1307h hVar, C1307h hVar2) {
            synchronized (aVar) {
                if (aVar.f4047e != hVar) {
                    return false;
                }
                aVar.f4047e = hVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6637a(C1297a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f4045c != obj) {
                    return false;
                }
                aVar.f4045c = obj2;
                return true;
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.a.a$h */
    private static final class C1307h {

        /* renamed from: a */
        static final C1307h f4065a = new C1307h(false);

        /* renamed from: b */
        volatile Thread f4066b;

        /* renamed from: c */
        volatile C1307h f4067c;

        C1307h() {
            C1297a.f4042b.mo6634a(this, Thread.currentThread());
        }

        C1307h(boolean z) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6640a() {
            Thread thread = this.f4066b;
            if (thread != null) {
                this.f4066b = null;
                LockSupport.unpark(thread);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6641a(C1307h hVar) {
            C1297a.f4042b.mo6633a(this, hVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: androidx.work.impl.utils.a.a$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: androidx.work.impl.utils.a.a$g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: androidx.work.impl.utils.a.a$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: androidx.work.impl.utils.a.a$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.String r0 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r1 = "false"
            java.lang.String r0 = java.lang.System.getProperty(r0, r1)
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            f4041a = r0
            java.lang.Class<androidx.work.impl.utils.a.a> r0 = androidx.work.impl.utils.p064a.C1297a.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            f4043f = r0
            androidx.work.impl.utils.a.a$e r0 = new androidx.work.impl.utils.a.a$e     // Catch:{ Throwable -> 0x0054 }
            java.lang.Class<androidx.work.impl.utils.a.a$h> r1 = androidx.work.impl.utils.p064a.C1297a.C1307h.class
            java.lang.Class<java.lang.Thread> r2 = java.lang.Thread.class
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r2, r3)     // Catch:{ Throwable -> 0x0054 }
            java.lang.Class<androidx.work.impl.utils.a.a$h> r1 = androidx.work.impl.utils.p064a.C1297a.C1307h.class
            java.lang.Class<androidx.work.impl.utils.a.a$h> r3 = androidx.work.impl.utils.p064a.C1297a.C1307h.class
            java.lang.String r4 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r3, r4)     // Catch:{ Throwable -> 0x0054 }
            java.lang.Class<androidx.work.impl.utils.a.a> r1 = androidx.work.impl.utils.p064a.C1297a.class
            java.lang.Class<androidx.work.impl.utils.a.a$h> r4 = androidx.work.impl.utils.p064a.C1297a.C1307h.class
            java.lang.String r5 = "e"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r4, r5)     // Catch:{ Throwable -> 0x0054 }
            java.lang.Class<androidx.work.impl.utils.a.a> r1 = androidx.work.impl.utils.p064a.C1297a.class
            java.lang.Class<androidx.work.impl.utils.a.a$d> r5 = androidx.work.impl.utils.p064a.C1297a.C1303d.class
            java.lang.String r6 = "d"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r5, r6)     // Catch:{ Throwable -> 0x0054 }
            java.lang.Class<androidx.work.impl.utils.a.a> r1 = androidx.work.impl.utils.p064a.C1297a.class
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            java.lang.String r7 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r6, r7)     // Catch:{ Throwable -> 0x0054 }
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ Throwable -> 0x0054 }
            r1 = 0
            goto L_0x005b
        L_0x0054:
            r0 = move-exception
            r1 = r0
            androidx.work.impl.utils.a.a$g r0 = new androidx.work.impl.utils.a.a$g
            r0.<init>()
        L_0x005b:
            f4042b = r0
            java.lang.Class<java.util.concurrent.locks.LockSupport> r0 = java.util.concurrent.locks.LockSupport.class
            if (r1 == 0) goto L_0x006a
            java.util.logging.Logger r0 = f4043f
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r0.log(r2, r3, r1)
        L_0x006a:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f4044g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.p064a.C1297a.<clinit>():void");
    }

    protected C1297a() {
    }

    /* renamed from: a */
    private C1303d m5110a(C1303d dVar) {
        C1303d dVar2;
        do {
            dVar2 = this.f4046d;
        } while (!f4042b.mo6635a((C1297a<?>) this, dVar2, C1303d.f4054a));
        C1303d dVar3 = dVar2;
        C1303d dVar4 = dVar;
        C1303d dVar5 = dVar3;
        while (dVar5 != null) {
            C1303d dVar6 = dVar5.f4057d;
            dVar5.f4057d = dVar4;
            dVar4 = dVar5;
            dVar5 = dVar6;
        }
        return dVar4;
    }

    /* renamed from: a */
    private static <V> V m5111a(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* renamed from: a */
    private static CancellationException m5112a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    /* renamed from: a */
    private void m5113a(C1307h hVar) {
        hVar.f4066b = null;
        while (true) {
            C1307h hVar2 = this.f4047e;
            if (hVar2 != C1307h.f4065a) {
                C1307h hVar3 = null;
                while (hVar2 != null) {
                    C1307h hVar4 = hVar2.f4067c;
                    if (hVar2.f4066b != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f4067c = hVar4;
                        if (hVar3.f4066b == null) {
                        }
                    } else if (!f4042b.mo6636a((C1297a<?>) this, hVar2, hVar4)) {
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
    }

    /* renamed from: a */
    static void m5114a(C1297a<?> aVar) {
        C1303d dVar = null;
        C1297a<V> aVar2 = aVar;
        while (true) {
            aVar2.m5121d();
            aVar2.mo6625b();
            C1303d a = aVar2.m5110a(dVar);
            while (true) {
                if (a != null) {
                    dVar = a.f4057d;
                    Runnable runnable = a.f4055b;
                    if (runnable instanceof C1305f) {
                        C1305f fVar = (C1305f) runnable;
                        C1297a<V> aVar3 = fVar.f4063a;
                        if (aVar3.f4045c == fVar) {
                            if (f4042b.mo6637a((C1297a<?>) aVar3, (Object) fVar, m5117b((ListenableFuture<?>) fVar.f4064b))) {
                                aVar2 = aVar3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        m5115a(runnable, a.f4056c);
                    }
                    a = dVar;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private static void m5115a(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = f4043f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
        }
    }

    /* renamed from: a */
    private void m5116a(StringBuilder sb) {
        String str;
        try {
            Object a = m5111a(this);
            sb.append("SUCCESS, result=[");
            sb.append(m5120d(a));
            sb.append("]");
            return;
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            str = "]";
        } catch (CancellationException unused) {
            str = "CANCELLED";
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            str = " thrown from get()]";
        }
        sb.append(str);
    }

    /* renamed from: b */
    static Object m5117b(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof C1297a) {
            Object obj = ((C1297a) listenableFuture).f4045c;
            if (!(obj instanceof C1300b)) {
                return obj;
            }
            C1300b bVar = (C1300b) obj;
            return bVar.f4050c ? bVar.f4051d != null ? new C1300b(false, bVar.f4051d) : C1300b.f4049b : obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f4041a) && isCancelled) {
            return C1300b.f4049b;
        }
        try {
            Object a = m5111a(listenableFuture);
            return a == null ? f4044g : a;
        } catch (ExecutionException e) {
            return new C1301c(e.getCause());
        } catch (CancellationException e2) {
            if (isCancelled) {
                return new C1300b(false, e2);
            }
            return new C1301c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e2));
        } catch (Throwable th) {
            return new C1301c(th);
        }
    }

    /* renamed from: b */
    static <T> T m5118b(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: c */
    private V m5119c(Object obj) {
        if (obj instanceof C1300b) {
            throw m5112a("Task was cancelled.", ((C1300b) obj).f4051d);
        } else if (obj instanceof C1301c) {
            throw new ExecutionException(((C1301c) obj).f4053b);
        } else if (obj == f4044g) {
            return null;
        } else {
            return obj;
        }
    }

    /* renamed from: d */
    private String m5120d(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    /* renamed from: d */
    private void m5121d() {
        C1307h hVar;
        do {
            hVar = this.f4047e;
        } while (!f4042b.mo6636a((C1297a<?>) this, hVar, C1307h.f4065a));
        while (hVar != null) {
            hVar.mo6640a();
            hVar = hVar.f4067c;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6620a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6621a(ListenableFuture<? extends V> listenableFuture) {
        C1305f fVar;
        C1301c cVar;
        m5118b(listenableFuture);
        Object obj = this.f4045c;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f4042b.mo6637a((C1297a<?>) this, (Object) null, m5117b((ListenableFuture<?>) listenableFuture))) {
                    return false;
                }
                m5114a((C1297a<?>) this);
                return true;
            }
            fVar = new C1305f(this, listenableFuture);
            if (f4042b.mo6637a((C1297a<?>) this, (Object) null, (Object) fVar)) {
                try {
                    listenableFuture.addListener(fVar, C1308b.INSTANCE);
                } catch (Throwable unused) {
                    cVar = C1301c.f4052a;
                }
                return true;
            }
            obj = this.f4045c;
        }
        if (obj instanceof C1300b) {
            listenableFuture.cancel(((C1300b) obj).f4050c);
        }
        return false;
        f4042b.mo6637a((C1297a<?>) this, (Object) fVar, (Object) cVar);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6622a(V v) {
        if (v == null) {
            v = f4044g;
        }
        if (!f4042b.mo6637a((C1297a<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        m5114a((C1297a<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6623a(Throwable th) {
        if (!f4042b.mo6637a((C1297a<?>) this, (Object) null, (Object) new C1301c((Throwable) m5118b(th)))) {
            return false;
        }
        m5114a((C1297a<?>) this);
        return true;
    }

    public final void addListener(Runnable runnable, Executor executor) {
        m5118b(runnable);
        m5118b(executor);
        C1303d dVar = this.f4046d;
        if (dVar != C1303d.f4054a) {
            C1303d dVar2 = new C1303d(runnable, executor);
            do {
                dVar2.f4057d = dVar;
                if (!f4042b.mo6635a((C1297a<?>) this, dVar, dVar2)) {
                    dVar = this.f4046d;
                } else {
                    return;
                }
            } while (dVar != C1303d.f4054a);
        }
        m5115a(runnable, executor);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6625b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo6626c() {
        Object obj = this.f4045c;
        if (obj instanceof C1305f) {
            return "setFuture=[" + m5120d(((C1305f) obj).f4064b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    public final boolean cancel(boolean z) {
        Object obj = this.f4045c;
        if (!(obj == null) && !(obj instanceof C1305f)) {
            return false;
        }
        C1300b bVar = f4041a ? new C1300b(z, new CancellationException("Future.cancel() was called.")) : z ? C1300b.f4048a : C1300b.f4049b;
        boolean z2 = false;
        Object obj2 = obj;
        C1297a aVar = this;
        while (true) {
            if (f4042b.mo6637a((C1297a<?>) aVar, obj2, (Object) bVar)) {
                if (z) {
                    aVar.mo6620a();
                }
                m5114a((C1297a<?>) aVar);
                if (!(obj2 instanceof C1305f)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((C1305f) obj2).f4064b;
                if (listenableFuture instanceof C1297a) {
                    aVar = (C1297a) listenableFuture;
                    obj2 = aVar.f4045c;
                    if (!(obj2 == null) && !(obj2 instanceof C1305f)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj2 = aVar.f4045c;
                if (!(obj2 instanceof C1305f)) {
                    return z2;
                }
            }
        }
    }

    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f4045c;
            if ((obj2 != null) && (!(obj2 instanceof C1305f))) {
                return m5119c(obj2);
            }
            C1307h hVar = this.f4047e;
            if (hVar != C1307h.f4065a) {
                C1307h hVar2 = new C1307h();
                do {
                    hVar2.mo6641a(hVar);
                    if (f4042b.mo6636a((C1297a<?>) this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f4045c;
                            } else {
                                m5113a(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof C1305f))));
                        return m5119c(obj);
                    }
                    hVar = this.f4047e;
                } while (hVar != C1307h.f4065a);
            }
            return m5119c(this.f4045c);
        }
        throw new InterruptedException();
    }

    public final V get(long j, TimeUnit timeUnit) {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f4045c;
            if ((obj != null) && (!(obj instanceof C1305f))) {
                return m5119c(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                C1307h hVar = this.f4047e;
                if (hVar != C1307h.f4065a) {
                    C1307h hVar2 = new C1307h();
                    do {
                        hVar2.mo6641a(hVar);
                        if (f4042b.mo6636a((C1297a<?>) this, hVar, hVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f4045c;
                                    if ((obj2 != null) && (!(obj2 instanceof C1305f))) {
                                        return m5119c(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    m5113a(hVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            m5113a(hVar2);
                        } else {
                            hVar = this.f4047e;
                        }
                    } while (hVar != C1307h.f4065a);
                }
                return m5119c(this.f4045c);
            }
            while (nanos > 0) {
                Object obj3 = this.f4045c;
                if ((obj3 != null) && (!(obj3 instanceof C1305f))) {
                    return m5119c(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                int i = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + aVar);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f4045c instanceof C1300b;
    }

    public final boolean isDone() {
        Object obj = this.f4045c;
        boolean z = true;
        boolean z2 = obj != null;
        if (obj instanceof C1305f) {
            z = false;
        }
        return z2 & z;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            str2 = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str = mo6626c();
                } catch (RuntimeException e) {
                    str = "Exception thrown from implementation: " + e.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    str2 = "]";
                } else if (!isDone()) {
                    str2 = "PENDING";
                }
            }
            m5116a(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
