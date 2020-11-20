package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.C1184a;
import androidx.work.C1188c;
import androidx.work.C1190d;
import androidx.work.C1196h;
import androidx.work.C1198i;
import androidx.work.impl.p062b.C1240j;

/* renamed from: androidx.work.impl.background.systemjob.a */
class C1276a {

    /* renamed from: a */
    private static final String f3949a = C1196h.m4737a("SystemJobInfoConverter");

    /* renamed from: b */
    private final ComponentName f3950b;

    C1276a(Context context) {
        this.f3950b = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    /* renamed from: a */
    static int m5016a(C1198i iVar) {
        switch (iVar) {
            case NOT_REQUIRED:
                return 0;
            case CONNECTED:
                return 1;
            case UNMETERED:
                return 2;
            case NOT_ROAMING:
                if (Build.VERSION.SDK_INT >= 24) {
                    return 3;
                }
                break;
            case METERED:
                if (Build.VERSION.SDK_INT >= 26) {
                    return 4;
                }
                break;
        }
        C1196h.m4736a().mo6418b(f3949a, String.format("API version too low. Cannot convert network type value %s", new Object[]{iVar}), new Throwable[0]);
        return 1;
    }

    /* renamed from: a */
    private static JobInfo.TriggerContentUri m5017a(C1190d.C1191a aVar) {
        return new JobInfo.TriggerContentUri(aVar.mo6403a(), aVar.mo6404b() ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JobInfo mo6563a(C1240j jVar, int i) {
        C1188c cVar = jVar.f3846j;
        int a = m5016a(cVar.mo6377a());
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", jVar.f3837a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", jVar.mo6498a());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.f3950b).setRequiredNetworkType(a).setRequiresCharging(cVar.mo6384b()).setRequiresDeviceIdle(cVar.mo6386c()).setExtras(persistableBundle);
        if (!cVar.mo6386c()) {
            extras.setBackoffCriteria(jVar.f3849m, jVar.f3848l == C1184a.LINEAR ? 0 : 1);
        }
        extras.setMinimumLatency(Math.max(jVar.mo6500c() - System.currentTimeMillis(), 0));
        if (Build.VERSION.SDK_INT >= 24 && cVar.mo6395i()) {
            for (C1190d.C1191a a2 : cVar.mo6393h().mo6398a()) {
                extras.addTriggerContentUri(m5017a(a2));
            }
            extras.setTriggerContentUpdateDelay(cVar.mo6391f());
            extras.setTriggerContentMaxDelay(cVar.mo6392g());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(cVar.mo6388d());
            extras.setRequiresStorageNotLow(cVar.mo6389e());
        }
        return extras.build();
    }
}
