package androidx.work.impl.p059a;

import android.content.Context;
import androidx.work.C1196h;
import androidx.work.impl.p059a.p060a.C1203a;
import androidx.work.impl.p059a.p060a.C1204b;
import androidx.work.impl.p059a.p060a.C1205c;
import androidx.work.impl.p059a.p060a.C1207d;
import androidx.work.impl.p059a.p060a.C1208e;
import androidx.work.impl.p059a.p060a.C1209f;
import androidx.work.impl.p059a.p060a.C1210g;
import androidx.work.impl.p059a.p060a.C1211h;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.utils.p065b.C1311a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.work.impl.a.d */
public class C1225d implements C1205c.C1206a {

    /* renamed from: a */
    private static final String f3812a = C1196h.m4737a("WorkConstraintsTracker");

    /* renamed from: b */
    private final C1224c f3813b;

    /* renamed from: c */
    private final C1205c<?>[] f3814c;

    /* renamed from: d */
    private final Object f3815d = new Object();

    public C1225d(Context context, C1311a aVar, C1224c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f3813b = cVar;
        this.f3814c = new C1205c[]{new C1203a(applicationContext, aVar), new C1204b(applicationContext, aVar), new C1211h(applicationContext, aVar), new C1207d(applicationContext, aVar), new C1210g(applicationContext, aVar), new C1209f(applicationContext, aVar), new C1208e(applicationContext, aVar)};
    }

    /* renamed from: a */
    public void mo6481a() {
        synchronized (this.f3815d) {
            for (C1205c<?> a : this.f3814c) {
                a.mo6439a();
            }
        }
    }

    /* renamed from: a */
    public void mo6482a(List<C1240j> list) {
        synchronized (this.f3815d) {
            for (C1205c<?> a : this.f3814c) {
                a.mo6440a((C1205c.C1206a) null);
            }
            for (C1205c<?> a2 : this.f3814c) {
                a2.mo6441a(list);
            }
            for (C1205c<?> a3 : this.f3814c) {
                a3.mo6440a((C1205c.C1206a) this);
            }
        }
    }

    /* renamed from: a */
    public boolean mo6483a(String str) {
        synchronized (this.f3815d) {
            for (C1205c<?> cVar : this.f3814c) {
                if (cVar.mo6442a(str)) {
                    C1196h.m4736a().mo6418b(f3812a, String.format("Work %s constrained by %s", new Object[]{str, cVar.getClass().getSimpleName()}), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: b */
    public void mo6443b(List<String> list) {
        synchronized (this.f3815d) {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (mo6483a(next)) {
                    C1196h.m4736a().mo6418b(f3812a, String.format("Constraints met for %s", new Object[]{next}), new Throwable[0]);
                    arrayList.add(next);
                }
            }
            if (this.f3813b != null) {
                this.f3813b.mo6479a(arrayList);
            }
        }
    }

    /* renamed from: c */
    public void mo6444c(List<String> list) {
        synchronized (this.f3815d) {
            if (this.f3813b != null) {
                this.f3813b.mo6480b(list);
            }
        }
    }
}
