package p076c.p078b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: c.b.h */
public class C1402h {

    /* renamed from: a */
    protected List<C1400f> f4202a = new ArrayList();

    /* renamed from: b */
    protected List<C1400f> f4203b = new ArrayList();

    /* renamed from: c */
    protected List<C1401g> f4204c = new ArrayList();

    /* renamed from: d */
    protected int f4205d = 0;

    /* renamed from: e */
    private boolean f4206e = false;

    /* renamed from: b */
    private synchronized List<C1401g> m5321b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f4204c);
        return arrayList;
    }

    /* renamed from: a */
    public void mo6853a(C1398d dVar) {
        for (C1401g endTest : m5321b()) {
            endTest.endTest(dVar);
        }
    }

    /* renamed from: a */
    public synchronized void mo6854a(C1398d dVar, C1396b bVar) {
        this.f4202a.add(new C1400f(dVar, bVar));
        for (C1401g addFailure : m5321b()) {
            addFailure.addFailure(dVar, bVar);
        }
    }

    /* renamed from: a */
    public void mo6855a(C1398d dVar, C1397c cVar) {
        try {
            cVar.mo6840a();
        } catch (C1396b e) {
            mo6854a(dVar, e);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            mo6856a(dVar, th);
        }
    }

    /* renamed from: a */
    public synchronized void mo6856a(C1398d dVar, Throwable th) {
        this.f4203b.add(new C1400f(dVar, th));
        for (C1401g addError : m5321b()) {
            addError.addError(dVar, th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6857a(final C1399e eVar) {
        mo6860b(eVar);
        mo6855a((C1398d) eVar, (C1397c) new C1397c() {
            /* renamed from: a */
            public void mo6840a() {
                eVar.mo6841b();
            }
        });
        mo6853a((C1398d) eVar);
    }

    /* renamed from: a */
    public synchronized void mo6858a(C1401g gVar) {
        this.f4204c.add(gVar);
    }

    /* renamed from: a */
    public synchronized boolean mo6859a() {
        return this.f4206e;
    }

    /* renamed from: b */
    public void mo6860b(C1398d dVar) {
        int a = dVar.mo6835a();
        synchronized (this) {
            this.f4205d += a;
        }
        for (C1401g startTest : m5321b()) {
            startTest.startTest(dVar);
        }
    }
}
