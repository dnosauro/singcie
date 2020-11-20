package androidx.core.p027e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;

/* renamed from: androidx.core.e.c */
public class C0558c {

    /* renamed from: a */
    private final Object f2108a = new Object();

    /* renamed from: b */
    private HandlerThread f2109b;

    /* renamed from: c */
    private Handler f2110c;

    /* renamed from: d */
    private int f2111d;

    /* renamed from: e */
    private Handler.Callback f2112e = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C0558c.this.mo3562a();
                    return true;
                case 1:
                    C0558c.this.mo3563a((Runnable) message.obj);
                    return true;
                default:
                    return true;
            }
        }
    };

    /* renamed from: f */
    private final int f2113f;

    /* renamed from: g */
    private final int f2114g;

    /* renamed from: h */
    private final String f2115h;

    /* renamed from: androidx.core.e.c$a */
    public interface C0563a<T> {
        /* renamed from: a */
        void mo3550a(T t);
    }

    public C0558c(String str, int i, int i2) {
        this.f2115h = str;
        this.f2114g = i;
        this.f2113f = i2;
        this.f2111d = 0;
    }

    /* renamed from: b */
    private void m2199b(Runnable runnable) {
        synchronized (this.f2108a) {
            if (this.f2109b == null) {
                this.f2109b = new HandlerThread(this.f2115h, this.f2114g);
                this.f2109b.start();
                this.f2110c = new Handler(this.f2109b.getLooper(), this.f2112e);
                this.f2111d++;
            }
            this.f2110c.removeMessages(0);
            this.f2110c.sendMessage(this.f2110c.obtainMessage(1, runnable));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T mo3561a(java.util.concurrent.Callable<T> r13, int r14) {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            androidx.core.e.c$3 r11 = new androidx.core.e.c$3
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r2, r3, r4, r5, r6)
            r12.m2199b(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x005c }
            if (r13 != 0) goto L_0x0034
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x0034:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005c }
            long r0 = (long) r14     // Catch:{ all -> 0x005c }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x005c }
        L_0x003b:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x003f }
        L_0x003f:
            boolean r0 = r10.get()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x004d
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x004d:
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0054
            goto L_0x003b
        L_0x0054:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x005c }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x005c }
            throw r13     // Catch:{ all -> 0x005c }
        L_0x005c:
            r13 = move-exception
            r7.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p027e.C0558c.mo3561a(java.util.concurrent.Callable, int):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3562a() {
        synchronized (this.f2108a) {
            if (!this.f2110c.hasMessages(1)) {
                this.f2109b.quit();
                this.f2109b = null;
                this.f2110c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3563a(Runnable runnable) {
        runnable.run();
        synchronized (this.f2108a) {
            this.f2110c.removeMessages(0);
            this.f2110c.sendMessageDelayed(this.f2110c.obtainMessage(0), (long) this.f2113f);
        }
    }

    /* renamed from: a */
    public <T> void mo3564a(final Callable<T> callable, final C0563a<T> aVar) {
        final Handler handler = new Handler();
        m2199b(new Runnable() {
            public void run() {
                final Object obj;
                try {
                    obj = callable.call();
                } catch (Exception unused) {
                    obj = null;
                }
                handler.post(new Runnable() {
                    public void run() {
                        aVar.mo3550a(obj);
                    }
                });
            }
        });
    }
}
