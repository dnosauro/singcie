package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.C1196h;
import androidx.work.C1335n;
import androidx.work.impl.C1282e;
import androidx.work.impl.C1289h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.C1278b;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.p062b.C1243k;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public class ForceStopRunnable implements Runnable {

    /* renamed from: a */
    private static final String f4030a = C1196h.m4737a("ForceStopRunnable");

    /* renamed from: b */
    private static final long f4031b = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: c */
    private final Context f4032c;

    /* renamed from: d */
    private final C1289h f4033d;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a */
        private static final String f4034a = C1196h.m4737a("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                C1196h.m4736a().mo6417a(f4034a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.m5097b(context);
            }
        }
    }

    public ForceStopRunnable(Context context, C1289h hVar) {
        this.f4032c = context.getApplicationContext();
        this.f4033d = hVar;
    }

    /* renamed from: a */
    private static PendingIntent m5095a(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, m5096a(context), i);
    }

    /* renamed from: a */
    static Intent m5096a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    /* renamed from: b */
    static void m5097b(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent a = m5095a(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f4031b;
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, currentTimeMillis, a);
        } else {
            alarmManager.set(0, currentTimeMillis, a);
        }
    }

    /* renamed from: a */
    public boolean mo6610a() {
        if (m5095a(this.f4032c, PKIFailureInfo.duplicateCertReq) != null) {
            return false;
        }
        m5097b(this.f4032c);
        return true;
    }

    /* renamed from: b */
    public boolean mo6611b() {
        if (Build.VERSION.SDK_INT >= 23) {
            C1278b.m5023b(this.f4032c);
        }
        WorkDatabase c = this.f4033d.mo6591c();
        C1243k o = c.mo6422o();
        c.mo6166g();
        try {
            List<C1240j> d = o.mo6520d();
            boolean z = d != null && !d.isEmpty();
            if (z) {
                for (C1240j next : d) {
                    o.mo6507a(C1335n.C1336a.ENQUEUED, next.f3837a);
                    o.mo6515b(next.f3837a, -1);
                }
            }
            c.mo6169j();
            return z;
        } finally {
            c.mo6167h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6612c() {
        return this.f4033d.mo6597h().mo6656a();
    }

    public void run() {
        C1196h.m4736a().mo6418b(f4030a, "Performing cleanup operations.", new Throwable[0]);
        boolean b = mo6611b();
        if (mo6612c()) {
            C1196h.m4736a().mo6418b(f4030a, "Rescheduling Workers.", new Throwable[0]);
            this.f4033d.mo6598i();
            this.f4033d.mo6597h().mo6655a(false);
        } else if (mo6610a()) {
            C1196h.m4736a().mo6418b(f4030a, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f4033d.mo6598i();
        } else if (b) {
            C1196h.m4736a().mo6418b(f4030a, "Found unfinished work, scheduling it.", new Throwable[0]);
            C1282e.m5040a(this.f4033d.mo6593d(), this.f4033d.mo6591c(), this.f4033d.mo6594e());
        }
        this.f4033d.mo6599j();
    }
}
