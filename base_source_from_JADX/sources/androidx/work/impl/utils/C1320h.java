package androidx.work.impl.utils;

import androidx.work.C1196h;
import androidx.work.C1335n;
import androidx.work.impl.C1289h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.p062b.C1243k;

/* renamed from: androidx.work.impl.utils.h */
public class C1320h implements Runnable {

    /* renamed from: a */
    private static final String f4092a = C1196h.m4737a("StopWorkRunnable");

    /* renamed from: b */
    private C1289h f4093b;

    /* renamed from: c */
    private String f4094c;

    public C1320h(C1289h hVar, String str) {
        this.f4093b = hVar;
        this.f4094c = str;
    }

    public void run() {
        WorkDatabase c = this.f4093b.mo6591c();
        C1243k o = c.mo6422o();
        c.mo6166g();
        try {
            if (o.mo6522f(this.f4094c) == C1335n.C1336a.RUNNING) {
                o.mo6507a(C1335n.C1336a.ENQUEUED, this.f4094c);
            }
            boolean b = this.f4093b.mo6595f().mo6569b(this.f4094c);
            C1196h.m4736a().mo6418b(f4092a, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.f4094c, Boolean.valueOf(b)}), new Throwable[0]);
            c.mo6169j();
        } finally {
            c.mo6167h();
        }
    }
}
