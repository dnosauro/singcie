package androidx.p004a.p005a.p006a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.a.a.a.b */
public class C0040b extends C0042c {

    /* renamed from: a */
    private final Object f11a = new Object();

    /* renamed from: b */
    private final ExecutorService f12b = Executors.newFixedThreadPool(4, new ThreadFactory() {

        /* renamed from: b */
        private final AtomicInteger f15b = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f15b.getAndIncrement())}));
            return thread;
        }
    });

    /* renamed from: c */
    private volatile Handler f13c;

    /* renamed from: a */
    public void mo623a(Runnable runnable) {
        this.f12b.execute(runnable);
    }

    /* renamed from: b */
    public void mo624b(Runnable runnable) {
        if (this.f13c == null) {
            synchronized (this.f11a) {
                if (this.f13c == null) {
                    this.f13c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f13c.post(runnable);
    }

    /* renamed from: c */
    public boolean mo625c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
