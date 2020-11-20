package androidx.work.impl.background.p063a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.C1196h;
import androidx.work.C1335n;
import androidx.work.impl.C1201a;
import androidx.work.impl.C1281d;
import androidx.work.impl.C1289h;
import androidx.work.impl.p059a.C1224c;
import androidx.work.impl.p059a.C1225d;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.utils.p065b.C1311a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.work.impl.background.a.a */
public class C1260a implements C1201a, C1224c, C1281d {

    /* renamed from: a */
    private static final String f3882a = C1196h.m4737a("GreedyScheduler");

    /* renamed from: b */
    private C1289h f3883b;

    /* renamed from: c */
    private C1225d f3884c;

    /* renamed from: d */
    private List<C1240j> f3885d = new ArrayList();

    /* renamed from: e */
    private boolean f3886e;

    /* renamed from: f */
    private final Object f3887f;

    public C1260a(Context context, C1311a aVar, C1289h hVar) {
        this.f3883b = hVar;
        this.f3884c = new C1225d(context, aVar, this);
        this.f3887f = new Object();
    }

    /* renamed from: a */
    private void m4955a() {
        if (!this.f3886e) {
            this.f3883b.mo6595f().mo6565a((C1201a) this);
            this.f3886e = true;
        }
    }

    /* renamed from: b */
    private void m4956b(String str) {
        synchronized (this.f3887f) {
            int size = this.f3885d.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.f3885d.get(i).f3837a.equals(str)) {
                    C1196h.m4736a().mo6418b(f3882a, String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                    this.f3885d.remove(i);
                    this.f3884c.mo6482a(this.f3885d);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo6530a(String str) {
        m4955a();
        C1196h.m4736a().mo6418b(f3882a, String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        this.f3883b.mo6592c(str);
    }

    /* renamed from: a */
    public void mo6433a(String str, boolean z) {
        m4956b(str);
    }

    /* renamed from: a */
    public void mo6479a(List<String> list) {
        for (String next : list) {
            C1196h.m4736a().mo6418b(f3882a, String.format("Constraints met: Scheduling work ID %s", new Object[]{next}), new Throwable[0]);
            this.f3883b.mo6590b(next);
        }
    }

    /* renamed from: a */
    public void mo6531a(C1240j... jVarArr) {
        m4955a();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C1240j jVar : jVarArr) {
            if (jVar.f3838b == C1335n.C1336a.ENQUEUED && !jVar.mo6498a() && jVar.f3843g == 0 && !jVar.mo6499b()) {
                if (!jVar.mo6501d()) {
                    C1196h.m4736a().mo6418b(f3882a, String.format("Starting work for %s", new Object[]{jVar.f3837a}), new Throwable[0]);
                    this.f3883b.mo6590b(jVar.f3837a);
                } else if (Build.VERSION.SDK_INT < 24 || !jVar.f3846j.mo6395i()) {
                    arrayList.add(jVar);
                    arrayList2.add(jVar.f3837a);
                }
            }
        }
        synchronized (this.f3887f) {
            if (!arrayList.isEmpty()) {
                C1196h.m4736a().mo6418b(f3882a, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", arrayList2)}), new Throwable[0]);
                this.f3885d.addAll(arrayList);
                this.f3884c.mo6482a(this.f3885d);
            }
        }
    }

    /* renamed from: b */
    public void mo6480b(List<String> list) {
        for (String next : list) {
            C1196h.m4736a().mo6418b(f3882a, String.format("Constraints not met: Cancelling work ID %s", new Object[]{next}), new Throwable[0]);
            this.f3883b.mo6592c(next);
        }
    }
}
