package androidx.work.impl.background.systemalarm;

import androidx.work.C1196h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.work.impl.background.systemalarm.g */
class C1272g {

    /* renamed from: d */
    private static final String f3936d = C1196h.m4737a("WorkTimer");

    /* renamed from: a */
    final Map<String, C1275b> f3937a = new HashMap();

    /* renamed from: b */
    final Map<String, C1274a> f3938b = new HashMap();

    /* renamed from: c */
    final Object f3939c = new Object();

    /* renamed from: e */
    private final ThreadFactory f3940e = new ThreadFactory() {

        /* renamed from: b */
        private int f3943b = 0;

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f3943b);
            this.f3943b = this.f3943b + 1;
            return newThread;
        }
    };

    /* renamed from: f */
    private final ScheduledExecutorService f3941f = Executors.newSingleThreadScheduledExecutor(this.f3940e);

    /* renamed from: androidx.work.impl.background.systemalarm.g$a */
    interface C1274a {
        /* renamed from: a */
        void mo6541a(String str);
    }

    /* renamed from: androidx.work.impl.background.systemalarm.g$b */
    static class C1275b implements Runnable {

        /* renamed from: a */
        private final C1272g f3944a;

        /* renamed from: b */
        private final String f3945b;

        C1275b(C1272g gVar, String str) {
            this.f3944a = gVar;
            this.f3945b = str;
        }

        public void run() {
            synchronized (this.f3944a.f3939c) {
                if (this.f3944a.f3937a.remove(this.f3945b) != null) {
                    C1274a remove = this.f3944a.f3938b.remove(this.f3945b);
                    if (remove != null) {
                        remove.mo6541a(this.f3945b);
                    }
                } else {
                    C1196h.m4736a().mo6418b("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.f3945b}), new Throwable[0]);
                }
            }
        }
    }

    C1272g() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6554a() {
        if (!this.f3941f.isShutdown()) {
            this.f3941f.shutdownNow();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6555a(String str) {
        synchronized (this.f3939c) {
            if (this.f3937a.remove(str) != null) {
                C1196h.m4736a().mo6418b(f3936d, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                this.f3938b.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6556a(String str, long j, C1274a aVar) {
        synchronized (this.f3939c) {
            C1196h.m4736a().mo6418b(f3936d, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            mo6555a(str);
            C1275b bVar = new C1275b(this, str);
            this.f3937a.put(str, bVar);
            this.f3938b.put(str, aVar);
            this.f3941f.schedule(bVar, j, TimeUnit.MILLISECONDS);
        }
    }
}
