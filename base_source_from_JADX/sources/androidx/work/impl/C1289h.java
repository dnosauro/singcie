package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.C1185b;
import androidx.work.C1196h;
import androidx.work.C1326k;
import androidx.work.C1332l;
import androidx.work.C1337o;
import androidx.work.C1338p;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.p063a.C1260a;
import androidx.work.impl.background.systemjob.C1278b;
import androidx.work.impl.utils.C1294a;
import androidx.work.impl.utils.C1316e;
import androidx.work.impl.utils.C1319g;
import androidx.work.impl.utils.C1320h;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.p065b.C1311a;
import androidx.work.impl.utils.p065b.C1312b;
import java.util.Arrays;
import java.util.List;

/* renamed from: androidx.work.impl.h */
public class C1289h extends C1337o {

    /* renamed from: j */
    private static C1289h f3986j;

    /* renamed from: k */
    private static C1289h f3987k;

    /* renamed from: l */
    private static final Object f3988l = new Object();

    /* renamed from: a */
    private Context f3989a;

    /* renamed from: b */
    private C1185b f3990b;

    /* renamed from: c */
    private WorkDatabase f3991c;

    /* renamed from: d */
    private C1311a f3992d;

    /* renamed from: e */
    private List<C1281d> f3993e;

    /* renamed from: f */
    private C1279c f3994f;

    /* renamed from: g */
    private C1316e f3995g;

    /* renamed from: h */
    private boolean f3996h;

    /* renamed from: i */
    private BroadcastReceiver.PendingResult f3997i;

    public C1289h(Context context, C1185b bVar, C1311a aVar) {
        this(context, bVar, aVar, context.getResources().getBoolean(C1332l.C1333a.workmanager_test_configuration));
    }

    public C1289h(Context context, C1185b bVar, C1311a aVar, boolean z) {
        Context applicationContext = context.getApplicationContext();
        WorkDatabase a = WorkDatabase.m4749a(applicationContext, bVar.mo6369b(), z);
        C1196h.m4738a((C1196h) new C1196h.C1197a(bVar.mo6371d()));
        Context context2 = context;
        C1185b bVar2 = bVar;
        C1311a aVar2 = aVar;
        WorkDatabase workDatabase = a;
        List<C1281d> a2 = mo6586a(applicationContext, aVar);
        m5058a(context2, bVar2, aVar2, workDatabase, a2, new C1279c(context2, bVar2, aVar2, workDatabase, a2));
    }

    @Deprecated
    /* renamed from: a */
    public static C1289h m5057a() {
        synchronized (f3988l) {
            if (f3986j != null) {
                C1289h hVar = f3986j;
                return hVar;
            }
            C1289h hVar2 = f3987k;
            return hVar2;
        }
    }

    /* renamed from: a */
    private void m5058a(Context context, C1185b bVar, C1311a aVar, WorkDatabase workDatabase, List<C1281d> list, C1279c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f3989a = applicationContext;
        this.f3990b = bVar;
        this.f3992d = aVar;
        this.f3991c = workDatabase;
        this.f3993e = list;
        this.f3994f = cVar;
        this.f3995g = new C1316e(this.f3989a);
        this.f3996h = false;
        this.f3992d.mo6649a(new ForceStopRunnable(applicationContext, this));
    }

    /* renamed from: b */
    public static C1289h m5059b(Context context) {
        C1289h a;
        synchronized (f3988l) {
            a = m5057a();
            if (a == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof C1185b.C1187b) {
                    m5060b(applicationContext, ((C1185b.C1187b) applicationContext).mo6376a());
                    a = m5059b(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return a;
    }

    /* renamed from: b */
    public static void m5060b(Context context, C1185b bVar) {
        synchronized (f3988l) {
            if (f3986j != null) {
                if (f3987k != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class levelJavadoc for more information.");
                }
            }
            if (f3986j == null) {
                Context applicationContext = context.getApplicationContext();
                if (f3987k == null) {
                    f3987k = new C1289h(applicationContext, bVar, new C1312b(bVar.mo6369b()));
                }
                f3986j = f3987k;
            }
        }
    }

    /* renamed from: a */
    public C1326k mo6584a(String str) {
        C1294a a = C1294a.m5101a(str, this);
        this.f3992d.mo6649a(a);
        return a.mo6615a();
    }

    /* renamed from: a */
    public C1326k mo6585a(List<? extends C1338p> list) {
        if (!list.isEmpty()) {
            return new C1283f(this, list).mo6582i();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    /* renamed from: a */
    public List<C1281d> mo6586a(Context context, C1311a aVar) {
        return Arrays.asList(new C1281d[]{C1282e.m5039a(context, this), new C1260a(context, aVar, this)});
    }

    /* renamed from: a */
    public void mo6587a(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f3988l) {
            this.f3997i = pendingResult;
            if (this.f3996h) {
                this.f3997i.finish();
                this.f3997i = null;
            }
        }
    }

    /* renamed from: a */
    public void mo6588a(String str, WorkerParameters.C1183a aVar) {
        this.f3992d.mo6649a(new C1319g(this, str, aVar));
    }

    /* renamed from: b */
    public Context mo6589b() {
        return this.f3989a;
    }

    /* renamed from: b */
    public void mo6590b(String str) {
        mo6588a(str, (WorkerParameters.C1183a) null);
    }

    /* renamed from: c */
    public WorkDatabase mo6591c() {
        return this.f3991c;
    }

    /* renamed from: c */
    public void mo6592c(String str) {
        this.f3992d.mo6649a(new C1320h(this, str));
    }

    /* renamed from: d */
    public C1185b mo6593d() {
        return this.f3990b;
    }

    /* renamed from: e */
    public List<C1281d> mo6594e() {
        return this.f3993e;
    }

    /* renamed from: f */
    public C1279c mo6595f() {
        return this.f3994f;
    }

    /* renamed from: g */
    public C1311a mo6596g() {
        return this.f3992d;
    }

    /* renamed from: h */
    public C1316e mo6597h() {
        return this.f3995g;
    }

    /* renamed from: i */
    public void mo6598i() {
        if (Build.VERSION.SDK_INT >= 23) {
            C1278b.m5022a(mo6589b());
        }
        mo6591c().mo6422o().mo6514b();
        C1282e.m5040a(mo6593d(), mo6591c(), mo6594e());
    }

    /* renamed from: j */
    public void mo6599j() {
        synchronized (f3988l) {
            this.f3996h = true;
            if (this.f3997i != null) {
                this.f3997i.finish();
                this.f3997i = null;
            }
        }
    }
}
