package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.C1196h;
import androidx.work.impl.background.systemalarm.C1266e;
import androidx.work.impl.p059a.C1224c;
import androidx.work.impl.p059a.C1225d;
import androidx.work.impl.p062b.C1240j;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.work.impl.background.systemalarm.c */
class C1264c {

    /* renamed from: a */
    private static final String f3903a = C1196h.m4737a("ConstraintsCmdHandler");

    /* renamed from: b */
    private final Context f3904b;

    /* renamed from: c */
    private final int f3905c;

    /* renamed from: d */
    private final C1266e f3906d;

    /* renamed from: e */
    private final C1225d f3907e = new C1225d(this.f3904b, this.f3906d.mo6549e(), (C1224c) null);

    C1264c(Context context, int i, C1266e eVar) {
        this.f3904b = context;
        this.f3905c = i;
        this.f3906d = eVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6539a() {
        List<C1240j> c = this.f3906d.mo6548d().mo6591c().mo6422o().mo6517c();
        ConstraintProxy.m4962a(this.f3904b, c);
        this.f3907e.mo6482a(c);
        ArrayList<C1240j> arrayList = new ArrayList<>(c.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (C1240j next : c) {
            String str = next.f3837a;
            if (currentTimeMillis >= next.mo6500c() && (!next.mo6501d() || this.f3907e.mo6483a(str))) {
                arrayList.add(next);
            }
        }
        for (C1240j jVar : arrayList) {
            String str2 = jVar.f3837a;
            Intent b = C1263b.m4975b(this.f3904b, str2);
            C1196h.m4736a().mo6418b(f3903a, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            C1266e eVar = this.f3906d;
            eVar.mo6544a((Runnable) new C1266e.C1268a(eVar, b, this.f3905c));
        }
        this.f3907e.mo6481a();
    }
}
