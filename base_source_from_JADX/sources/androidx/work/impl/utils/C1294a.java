package androidx.work.impl.utils;

import androidx.work.C1326k;
import androidx.work.C1335n;
import androidx.work.impl.C1226b;
import androidx.work.impl.C1281d;
import androidx.work.impl.C1282e;
import androidx.work.impl.C1289h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.p062b.C1228b;
import androidx.work.impl.p062b.C1243k;
import java.util.LinkedList;

/* renamed from: androidx.work.impl.utils.a */
public abstract class C1294a implements Runnable {

    /* renamed from: a */
    private final C1226b f4035a = new C1226b();

    /* renamed from: a */
    public static C1294a m5101a(final String str, final C1289h hVar) {
        return new C1294a() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public void mo6618b() {
                WorkDatabase c = hVar.mo6591c();
                c.mo6166g();
                try {
                    for (String a : c.mo6422o().mo6524h(str)) {
                        mo6617a(hVar, a);
                    }
                    c.mo6169j();
                    c.mo6167h();
                    mo6616a(hVar);
                } catch (Throwable th) {
                    c.mo6167h();
                    throw th;
                }
            }
        };
    }

    /* renamed from: a */
    public static C1294a m5102a(final String str, final C1289h hVar, final boolean z) {
        return new C1294a() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public void mo6618b() {
                WorkDatabase c = hVar.mo6591c();
                c.mo6166g();
                try {
                    for (String a : c.mo6422o().mo6525i(str)) {
                        mo6617a(hVar, a);
                    }
                    c.mo6169j();
                    c.mo6167h();
                    if (z) {
                        mo6616a(hVar);
                    }
                } catch (Throwable th) {
                    c.mo6167h();
                    throw th;
                }
            }
        };
    }

    /* renamed from: a */
    private void m5103a(WorkDatabase workDatabase, String str) {
        C1243k o = workDatabase.mo6422o();
        C1228b p = workDatabase.mo6423p();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            C1335n.C1336a f = o.mo6522f(str2);
            if (!(f == C1335n.C1336a.SUCCEEDED || f == C1335n.C1336a.FAILED)) {
                o.mo6507a(C1335n.C1336a.CANCELLED, str2);
            }
            linkedList.addAll(p.mo6487b(str2));
        }
    }

    /* renamed from: a */
    public C1326k mo6615a() {
        return this.f4035a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6616a(C1289h hVar) {
        C1282e.m5040a(hVar.mo6593d(), hVar.mo6591c(), hVar.mo6594e());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6617a(C1289h hVar, String str) {
        m5103a(hVar.mo6591c(), str);
        hVar.mo6595f().mo6570c(str);
        for (C1281d a : hVar.mo6594e()) {
            a.mo6530a(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo6618b();

    public void run() {
        try {
            mo6618b();
            this.f4035a.mo6484a(C1326k.f4106a);
        } catch (Throwable th) {
            this.f4035a.mo6484a(new C1326k.C1328a.C1329a(th));
        }
    }
}
