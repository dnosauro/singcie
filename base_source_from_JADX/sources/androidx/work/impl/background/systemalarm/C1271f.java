package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.C1196h;
import androidx.work.impl.C1281d;
import androidx.work.impl.p062b.C1240j;

/* renamed from: androidx.work.impl.background.systemalarm.f */
public class C1271f implements C1281d {

    /* renamed from: a */
    private static final String f3934a = C1196h.m4737a("SystemAlarmScheduler");

    /* renamed from: b */
    private final Context f3935b;

    public C1271f(Context context) {
        this.f3935b = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m5008a(C1240j jVar) {
        C1196h.m4736a().mo6418b(f3934a, String.format("Scheduling work with workSpecId %s", new Object[]{jVar.f3837a}), new Throwable[0]);
        this.f3935b.startService(C1263b.m4971a(this.f3935b, jVar.f3837a));
    }

    /* renamed from: a */
    public void mo6530a(String str) {
        this.f3935b.startService(C1263b.m4977c(this.f3935b, str));
    }

    /* renamed from: a */
    public void mo6531a(C1240j... jVarArr) {
        for (C1240j a : jVarArr) {
            m5008a(a);
        }
    }
}
