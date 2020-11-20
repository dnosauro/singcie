package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: androidx.room.n */
class C1148n implements Executor {

    /* renamed from: a */
    private final Executor f3612a;

    /* renamed from: b */
    private final ArrayDeque<Runnable> f3613b = new ArrayDeque<>();

    /* renamed from: c */
    private Runnable f3614c;

    C1148n(Executor executor) {
        this.f3612a = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo6196a() {
        Runnable poll = this.f3613b.poll();
        this.f3614c = poll;
        if (poll != null) {
            this.f3612a.execute(this.f3614c);
        }
    }

    public synchronized void execute(final Runnable runnable) {
        this.f3613b.offer(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    C1148n.this.mo6196a();
                }
            }
        });
        if (this.f3614c == null) {
            mo6196a();
        }
    }
}
