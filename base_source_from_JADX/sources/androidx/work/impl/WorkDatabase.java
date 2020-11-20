package androidx.work.impl;

import android.content.Context;
import androidx.p046i.p047a.C0813b;
import androidx.room.C1137h;
import androidx.room.C1138i;
import androidx.work.impl.C1284g;
import androidx.work.impl.p062b.C1228b;
import androidx.work.impl.p062b.C1232e;
import androidx.work.impl.p062b.C1237h;
import androidx.work.impl.p062b.C1243k;
import androidx.work.impl.p062b.C1255n;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase extends C1138i {

    /* renamed from: d */
    private static final long f3770d = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a */
    public static WorkDatabase m4749a(Context context, Executor executor, boolean z) {
        return (z ? C1137h.m4457a(context, WorkDatabase.class).mo6171a() : C1137h.m4458a(context, WorkDatabase.class, "androidx.work.workdb").mo6173a(executor)).mo6172a(m4750l()).mo6174a(C1284g.f3982a).mo6174a(new C1284g.C1288a(context, 2, 3)).mo6174a(C1284g.f3983b).mo6174a(C1284g.f3984c).mo6174a(new C1284g.C1288a(context, 5, 6)).mo6175b().mo6176c();
    }

    /* renamed from: l */
    static C1138i.C1140b m4750l() {
        return new C1138i.C1140b() {
            /* renamed from: b */
            public void mo6178b(C0813b bVar) {
                super.mo6178b(bVar);
                bVar.mo4613a();
                try {
                    bVar.mo4618c(WorkDatabase.m4751m());
                    bVar.mo4617c();
                } finally {
                    bVar.mo4616b();
                }
            }
        };
    }

    /* renamed from: m */
    static String m4751m() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + m4752n() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    /* renamed from: n */
    static long m4752n() {
        return System.currentTimeMillis() - f3770d;
    }

    /* renamed from: o */
    public abstract C1243k mo6422o();

    /* renamed from: p */
    public abstract C1228b mo6423p();

    /* renamed from: q */
    public abstract C1255n mo6424q();

    /* renamed from: r */
    public abstract C1232e mo6425r();

    /* renamed from: s */
    public abstract C1237h mo6426s();
}
