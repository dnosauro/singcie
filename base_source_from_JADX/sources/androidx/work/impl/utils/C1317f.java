package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: androidx.work.impl.utils.f */
public class C1317f implements Executor {

    /* renamed from: a */
    private final ArrayDeque<C1318a> f4083a = new ArrayDeque<>();

    /* renamed from: b */
    private final Executor f4084b;

    /* renamed from: c */
    private final Object f4085c = new Object();

    /* renamed from: d */
    private volatile Runnable f4086d;

    /* renamed from: androidx.work.impl.utils.f$a */
    static class C1318a implements Runnable {

        /* renamed from: a */
        final C1317f f4087a;

        /* renamed from: b */
        final Runnable f4088b;

        C1318a(C1317f fVar, Runnable runnable) {
            this.f4087a = fVar;
            this.f4088b = runnable;
        }

        public void run() {
            try {
                this.f4088b.run();
            } finally {
                this.f4087a.mo6657a();
            }
        }
    }

    public C1317f(Executor executor) {
        this.f4084b = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6657a() {
        synchronized (this.f4085c) {
            Runnable poll = this.f4083a.poll();
            this.f4086d = poll;
            if (poll != null) {
                this.f4084b.execute(this.f4086d);
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.f4085c) {
            this.f4083a.add(new C1318a(this, runnable));
            if (this.f4086d == null) {
                mo6657a();
            }
        }
    }
}
