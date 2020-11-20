package androidx.constraintlayout.p019a.p020a;

import java.util.HashSet;
import java.util.Iterator;

/* renamed from: androidx.constraintlayout.a.a.o */
public class C0437o {

    /* renamed from: h */
    HashSet<C0437o> f1609h = new HashSet<>(2);

    /* renamed from: i */
    int f1610i = 0;

    /* renamed from: a */
    public void mo3124a() {
    }

    /* renamed from: a */
    public void mo3139a(C0437o oVar) {
        this.f1609h.add(oVar);
    }

    /* renamed from: b */
    public void mo3130b() {
        this.f1610i = 0;
        this.f1609h.clear();
    }

    /* renamed from: e */
    public void mo3140e() {
        this.f1610i = 0;
        Iterator<C0437o> it = this.f1609h.iterator();
        while (it.hasNext()) {
            it.next().mo3140e();
        }
    }

    /* renamed from: f */
    public void mo3141f() {
        this.f1610i = 1;
        Iterator<C0437o> it = this.f1609h.iterator();
        while (it.hasNext()) {
            it.next().mo3124a();
        }
    }

    /* renamed from: g */
    public boolean mo3142g() {
        return this.f1610i == 1;
    }
}
