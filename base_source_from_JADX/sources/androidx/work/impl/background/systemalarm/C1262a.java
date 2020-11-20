package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.C1196h;
import androidx.work.impl.C1289h;
import androidx.work.impl.p062b.C1231d;
import androidx.work.impl.p062b.C1232e;
import androidx.work.impl.utils.C1314c;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: androidx.work.impl.background.systemalarm.a */
class C1262a {

    /* renamed from: a */
    private static final String f3898a = C1196h.m4737a("Alarms");

    /* renamed from: a */
    public static void m4966a(Context context, C1289h hVar, String str) {
        C1232e r = hVar.mo6591c().mo6425r();
        C1231d a = r.mo6492a(str);
        if (a != null) {
            m4968a(context, str, a.f3824b);
            C1196h.m4736a().mo6418b(f3898a, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            r.mo6494b(str);
        }
    }

    /* renamed from: a */
    public static void m4967a(Context context, C1289h hVar, String str, long j) {
        C1232e r = hVar.mo6591c().mo6425r();
        C1231d a = r.mo6492a(str);
        if (a != null) {
            m4968a(context, str, a.f3824b);
            m4969a(context, str, a.f3824b, j);
            return;
        }
        int a2 = new C1314c(context).mo6653a();
        r.mo6493a(new C1231d(str, a2));
        m4969a(context, str, a2, j);
    }

    /* renamed from: a */
    private static void m4968a(Context context, String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, C1263b.m4975b(context, str), PKIFailureInfo.duplicateCertReq);
        if (service != null && alarmManager != null) {
            C1196h.m4736a().mo6418b(f3898a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i)}), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    /* renamed from: a */
    private static void m4969a(Context context, String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, C1263b.m4975b(context, str), 1073741824);
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, j, service);
        } else {
            alarmManager.set(0, j, service);
        }
    }
}
