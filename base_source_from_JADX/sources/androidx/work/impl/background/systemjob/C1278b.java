package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.C1196h;
import androidx.work.C1335n;
import androidx.work.impl.C1281d;
import androidx.work.impl.C1289h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.p062b.C1231d;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.utils.C1314c;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: androidx.work.impl.background.systemjob.b */
public class C1278b implements C1281d {

    /* renamed from: a */
    private static final String f3952a = C1196h.m4737a("SystemJobScheduler");

    /* renamed from: b */
    private final Context f3953b;

    /* renamed from: c */
    private final JobScheduler f3954c;

    /* renamed from: d */
    private final C1289h f3955d;

    /* renamed from: e */
    private final C1314c f3956e;

    /* renamed from: f */
    private final C1276a f3957f;

    public C1278b(Context context, C1289h hVar) {
        this(context, hVar, (JobScheduler) context.getSystemService("jobscheduler"), new C1276a(context));
    }

    public C1278b(Context context, C1289h hVar, JobScheduler jobScheduler, C1276a aVar) {
        this.f3953b = context;
        this.f3955d = hVar;
        this.f3954c = jobScheduler;
        this.f3956e = new C1314c(context);
        this.f3957f = aVar;
    }

    /* renamed from: a */
    private static List<JobInfo> m5019a(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            C1196h.m4736a().mo6421e(f3952a, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<Integer> m5020a(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> a = m5019a(context, jobScheduler);
        if (a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : a) {
            PersistableBundle extras = next.getExtras();
            if (extras != null && extras.containsKey("EXTRA_WORK_SPEC_ID") && str.equals(extras.getString("EXTRA_WORK_SPEC_ID"))) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m5021a(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            C1196h.m4736a().mo6421e(f3952a, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i)}), th);
        }
    }

    /* renamed from: a */
    public static void m5022a(Context context) {
        List<JobInfo> a;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (a = m5019a(context, jobScheduler)) != null && !a.isEmpty()) {
            for (JobInfo id : a) {
                m5021a(jobScheduler, id.getId());
            }
        }
    }

    /* renamed from: b */
    public static void m5023b(Context context) {
        List<JobInfo> a;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (a = m5019a(context, jobScheduler)) != null && !a.isEmpty()) {
            for (JobInfo next : a) {
                PersistableBundle extras = next.getExtras();
                if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                    m5021a(jobScheduler, next.getId());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo6564a(C1240j jVar, int i) {
        JobInfo a = this.f3957f.mo6563a(jVar, i);
        C1196h.m4736a().mo6418b(f3952a, String.format("Scheduling work ID %s Job ID %s", new Object[]{jVar.f3837a, Integer.valueOf(i)}), new Throwable[0]);
        try {
            this.f3954c.schedule(a);
        } catch (IllegalStateException e) {
            List<JobInfo> a2 = m5019a(this.f3953b, this.f3954c);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(a2 != null ? a2.size() : 0), Integer.valueOf(this.f3955d.mo6591c().mo6422o().mo6517c().size()), Integer.valueOf(this.f3955d.mo6593d().mo6374g())});
            C1196h.m4736a().mo6421e(f3952a, format, new Throwable[0]);
            throw new IllegalStateException(format, e);
        } catch (Throwable th) {
            C1196h.m4736a().mo6421e(f3952a, String.format("Unable to schedule %s", new Object[]{jVar}), th);
        }
    }

    /* renamed from: a */
    public void mo6530a(String str) {
        List<Integer> a = m5020a(this.f3953b, this.f3954c, str);
        if (a != null && !a.isEmpty()) {
            for (Integer intValue : a) {
                m5021a(this.f3954c, intValue.intValue());
            }
            this.f3955d.mo6591c().mo6425r().mo6494b(str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public void mo6531a(C1240j... jVarArr) {
        List<Integer> a;
        WorkDatabase c = this.f3955d.mo6591c();
        int length = jVarArr.length;
        int i = 0;
        while (i < length) {
            C1240j jVar = jVarArr[i];
            c.mo6166g();
            try {
                C1240j b = c.mo6422o().mo6516b(jVar.f3837a);
                if (b == null) {
                    C1196h a2 = C1196h.m4736a();
                    String str = f3952a;
                    a2.mo6420d(str, "Skipping scheduling " + jVar.f3837a + " because it's no longer in the DB", new Throwable[0]);
                } else if (b.f3838b != C1335n.C1336a.ENQUEUED) {
                    C1196h a3 = C1196h.m4736a();
                    String str2 = f3952a;
                    a3.mo6420d(str2, "Skipping scheduling " + jVar.f3837a + " because it is no longer enqueued", new Throwable[0]);
                } else {
                    C1231d a4 = c.mo6425r().mo6492a(jVar.f3837a);
                    int a5 = a4 != null ? a4.f3824b : this.f3956e.mo6654a(this.f3955d.mo6593d().mo6372e(), this.f3955d.mo6593d().mo6373f());
                    if (a4 == null) {
                        this.f3955d.mo6591c().mo6425r().mo6493a(new C1231d(jVar.f3837a, a5));
                    }
                    mo6564a(jVar, a5);
                    if (Build.VERSION.SDK_INT == 23 && (a = m5020a(this.f3953b, this.f3954c, jVar.f3837a)) != null) {
                        int indexOf = a.indexOf(Integer.valueOf(a5));
                        if (indexOf >= 0) {
                            a.remove(indexOf);
                        }
                        mo6564a(jVar, !a.isEmpty() ? a.get(0).intValue() : this.f3956e.mo6654a(this.f3955d.mo6593d().mo6372e(), this.f3955d.mo6593d().mo6373f()));
                    }
                }
                c.mo6169j();
                c.mo6167h();
                i++;
            } catch (Throwable th) {
                c.mo6167h();
                throw th;
            }
        }
    }
}
