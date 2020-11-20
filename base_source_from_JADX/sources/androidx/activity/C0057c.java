package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.activity.c */
public abstract class C0057c {

    /* renamed from: a */
    private boolean f48a;

    /* renamed from: b */
    private CopyOnWriteArrayList<C0053a> f49b = new CopyOnWriteArrayList<>();

    public C0057c(boolean z) {
        this.f48a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo675a(C0053a aVar) {
        this.f49b.add(aVar);
    }

    /* renamed from: a */
    public final void mo676a(boolean z) {
        this.f48a = z;
    }

    /* renamed from: a */
    public final boolean mo677a() {
        return this.f48a;
    }

    /* renamed from: b */
    public final void mo678b() {
        Iterator<C0053a> it = this.f49b.iterator();
        while (it.hasNext()) {
            it.next().mo663a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo679b(C0053a aVar) {
        this.f49b.remove(aVar);
    }

    /* renamed from: c */
    public abstract void mo680c();
}
