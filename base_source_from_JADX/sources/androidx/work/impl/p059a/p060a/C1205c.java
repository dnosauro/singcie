package androidx.work.impl.p059a.p060a;

import androidx.work.impl.p059a.C1202a;
import androidx.work.impl.p059a.p061b.C1217d;
import androidx.work.impl.p062b.C1240j;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.work.impl.a.a.c */
public abstract class C1205c<T> implements C1202a<T> {

    /* renamed from: a */
    private final List<String> f3777a = new ArrayList();

    /* renamed from: b */
    private T f3778b;

    /* renamed from: c */
    private C1217d<T> f3779c;

    /* renamed from: d */
    private C1206a f3780d;

    /* renamed from: androidx.work.impl.a.a.c$a */
    public interface C1206a {
        /* renamed from: b */
        void mo6443b(List<String> list);

        /* renamed from: c */
        void mo6444c(List<String> list);
    }

    C1205c(C1217d<T> dVar) {
        this.f3779c = dVar;
    }

    /* renamed from: b */
    private void m4789b() {
        if (!this.f3777a.isEmpty() && this.f3780d != null) {
            T t = this.f3778b;
            if (t == null || mo6437b(t)) {
                this.f3780d.mo6444c(this.f3777a);
            } else {
                this.f3780d.mo6443b(this.f3777a);
            }
        }
    }

    /* renamed from: a */
    public void mo6439a() {
        if (!this.f3777a.isEmpty()) {
            this.f3777a.clear();
            this.f3779c.mo6467b(this);
        }
    }

    /* renamed from: a */
    public void mo6440a(C1206a aVar) {
        if (this.f3780d != aVar) {
            this.f3780d = aVar;
            m4789b();
        }
    }

    /* renamed from: a */
    public void mo6434a(T t) {
        this.f3778b = t;
        m4789b();
    }

    /* renamed from: a */
    public void mo6441a(List<C1240j> list) {
        this.f3777a.clear();
        for (C1240j next : list) {
            if (mo6435a(next)) {
                this.f3777a.add(next.f3837a);
            }
        }
        if (this.f3777a.isEmpty()) {
            this.f3779c.mo6467b(this);
        } else {
            this.f3779c.mo6465a(this);
        }
        m4789b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo6435a(C1240j jVar);

    /* renamed from: a */
    public boolean mo6442a(String str) {
        T t = this.f3778b;
        return t != null && mo6437b(t) && this.f3777a.contains(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo6437b(T t);
}
