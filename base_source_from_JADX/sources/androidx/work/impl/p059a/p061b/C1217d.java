package androidx.work.impl.p059a.p061b;

import android.content.Context;
import androidx.work.C1196h;
import androidx.work.impl.p059a.C1202a;
import androidx.work.impl.utils.p065b.C1311a;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: androidx.work.impl.a.b.d */
public abstract class C1217d<T> {

    /* renamed from: d */
    private static final String f3792d = C1196h.m4737a("ConstraintTracker");

    /* renamed from: a */
    protected final C1311a f3793a;

    /* renamed from: b */
    protected final Context f3794b;

    /* renamed from: c */
    T f3795c;

    /* renamed from: e */
    private final Object f3796e = new Object();

    /* renamed from: f */
    private final Set<C1202a<T>> f3797f = new LinkedHashSet();

    C1217d(Context context, C1311a aVar) {
        this.f3794b = context.getApplicationContext();
        this.f3793a = aVar;
    }

    /* renamed from: a */
    public void mo6465a(C1202a<T> aVar) {
        synchronized (this.f3796e) {
            if (this.f3797f.add(aVar)) {
                if (this.f3797f.size() == 1) {
                    this.f3795c = mo6460c();
                    C1196h.m4736a().mo6418b(f3792d, String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.f3795c}), new Throwable[0]);
                    mo6462d();
                }
                aVar.mo6434a(this.f3795c);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6466a(T r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3796e
            monitor-enter(r0)
            T r1 = r3.f3795c     // Catch:{ all -> 0x002f }
            if (r1 == r4) goto L_0x002d
            T r1 = r3.f3795c     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0014
            T r1 = r3.f3795c     // Catch:{ all -> 0x002f }
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0014
            goto L_0x002d
        L_0x0014:
            r3.f3795c = r4     // Catch:{ all -> 0x002f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            java.util.Set<androidx.work.impl.a.a<T>> r1 = r3.f3797f     // Catch:{ all -> 0x002f }
            r4.<init>(r1)     // Catch:{ all -> 0x002f }
            androidx.work.impl.utils.b.a r1 = r3.f3793a     // Catch:{ all -> 0x002f }
            java.util.concurrent.Executor r1 = r1.mo6648a()     // Catch:{ all -> 0x002f }
            androidx.work.impl.a.b.d$1 r2 = new androidx.work.impl.a.b.d$1     // Catch:{ all -> 0x002f }
            r2.<init>(r4)     // Catch:{ all -> 0x002f }
            r1.execute(r2)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.p059a.p061b.C1217d.mo6466a(java.lang.Object):void");
    }

    /* renamed from: b */
    public void mo6467b(C1202a<T> aVar) {
        synchronized (this.f3796e) {
            if (this.f3797f.remove(aVar) && this.f3797f.isEmpty()) {
                mo6463e();
            }
        }
    }

    /* renamed from: c */
    public abstract T mo6460c();

    /* renamed from: d */
    public abstract void mo6462d();

    /* renamed from: e */
    public abstract void mo6463e();
}
