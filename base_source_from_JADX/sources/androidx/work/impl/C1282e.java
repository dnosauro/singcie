package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.C1185b;
import androidx.work.C1196h;
import androidx.work.impl.background.systemalarm.C1271f;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.C1278b;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.p062b.C1243k;
import androidx.work.impl.utils.C1315d;
import java.util.List;

/* renamed from: androidx.work.impl.e */
public class C1282e {

    /* renamed from: a */
    private static final String f3971a = C1196h.m4737a("Schedulers");

    /* renamed from: a */
    private static C1281d m5038a(Context context) {
        try {
            C1281d dVar = (C1281d) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            C1196h.m4736a().mo6418b(f3971a, String.format("Created %s", new Object[]{"androidx.work.impl.background.gcm.GcmScheduler"}), new Throwable[0]);
            return dVar;
        } catch (Throwable th) {
            C1196h.m4736a().mo6418b(f3971a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }

    /* renamed from: a */
    static C1281d m5039a(Context context, C1289h hVar) {
        C1281d dVar;
        C1196h a;
        String str;
        String str2;
        if (Build.VERSION.SDK_INT >= 23) {
            dVar = new C1278b(context, hVar);
            C1315d.m5169a(context, SystemJobService.class, true);
            a = C1196h.m4736a();
            str = f3971a;
            str2 = "Created SystemJobScheduler and enabled SystemJobService";
        } else {
            dVar = m5038a(context);
            if (dVar == null) {
                dVar = new C1271f(context);
                C1315d.m5169a(context, SystemAlarmService.class, true);
                a = C1196h.m4736a();
                str = f3971a;
                str2 = "Created SystemAlarmScheduler";
            }
            return dVar;
        }
        a.mo6418b(str, str2, new Throwable[0]);
        return dVar;
    }

    /* renamed from: a */
    public static void m5040a(C1185b bVar, WorkDatabase workDatabase, List<C1281d> list) {
        if (list != null && list.size() != 0) {
            C1243k o = workDatabase.mo6422o();
            workDatabase.mo6166g();
            try {
                List<C1240j> a = o.mo6509a(bVar.mo6374g());
                if (a != null && a.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (C1240j jVar : a) {
                        o.mo6515b(jVar.f3837a, currentTimeMillis);
                    }
                }
                workDatabase.mo6169j();
                if (a != null && a.size() > 0) {
                    C1240j[] jVarArr = (C1240j[]) a.toArray(new C1240j[0]);
                    for (C1281d a2 : list) {
                        a2.mo6531a(jVarArr);
                    }
                }
            } finally {
                workDatabase.mo6167h();
            }
        }
    }
}
