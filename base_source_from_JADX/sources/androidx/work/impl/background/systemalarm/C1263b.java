package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.C1196h;
import androidx.work.impl.C1201a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.C1266e;
import androidx.work.impl.p062b.C1240j;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.work.impl.background.systemalarm.b */
public class C1263b implements C1201a {

    /* renamed from: a */
    private static final String f3899a = C1196h.m4737a("CommandHandler");

    /* renamed from: b */
    private final Context f3900b;

    /* renamed from: c */
    private final Map<String, C1201a> f3901c = new HashMap();

    /* renamed from: d */
    private final Object f3902d = new Object();

    C1263b(Context context) {
        this.f3900b = context;
    }

    /* renamed from: a */
    static Intent m4970a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    /* renamed from: a */
    static Intent m4971a(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* renamed from: a */
    static Intent m4972a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    /* renamed from: a */
    private static boolean m4973a(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    static Intent m4974b(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    /* renamed from: b */
    static Intent m4975b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* renamed from: b */
    private void m4976b(Intent intent, int i, C1266e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        C1196h.m4736a().mo6418b(f3899a, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        WorkDatabase c = eVar.mo6548d().mo6591c();
        c.mo6166g();
        try {
            C1240j b = c.mo6422o().mo6516b(string);
            if (b == null) {
                C1196h a = C1196h.m4736a();
                String str = f3899a;
                a.mo6420d(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (b.f3838b.mo6679a()) {
                C1196h a2 = C1196h.m4736a();
                String str2 = f3899a;
                a2.mo6420d(str2, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                c.mo6167h();
            } else {
                long c2 = b.mo6500c();
                if (!b.mo6501d()) {
                    C1196h.m4736a().mo6418b(f3899a, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(c2)}), new Throwable[0]);
                    C1262a.m4967a(this.f3900b, eVar.mo6548d(), string, c2);
                } else {
                    C1196h.m4736a().mo6418b(f3899a, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(c2)}), new Throwable[0]);
                    C1262a.m4967a(this.f3900b, eVar.mo6548d(), string, c2);
                    eVar.mo6544a((Runnable) new C1266e.C1268a(eVar, m4970a(this.f3900b), i));
                }
                c.mo6169j();
                c.mo6167h();
            }
        } finally {
            c.mo6167h();
        }
    }

    /* renamed from: c */
    static Intent m4977c(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* renamed from: c */
    private void m4978c(Intent intent, int i, C1266e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f3902d) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            C1196h.m4736a().mo6418b(f3899a, String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
            if (!this.f3901c.containsKey(string)) {
                C1265d dVar = new C1265d(this.f3900b, i, string, eVar);
                this.f3901c.put(string, dVar);
                dVar.mo6540a();
            } else {
                C1196h.m4736a().mo6418b(f3899a, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string}), new Throwable[0]);
            }
        }
    }

    /* renamed from: d */
    private void m4979d(Intent intent, int i, C1266e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        C1196h.m4736a().mo6418b(f3899a, String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        eVar.mo6548d().mo6592c(string);
        C1262a.m4966a(this.f3900b, eVar.mo6548d(), string);
        eVar.mo6433a(string, false);
    }

    /* renamed from: e */
    private void m4980e(Intent intent, int i, C1266e eVar) {
        C1196h.m4736a().mo6418b(f3899a, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new C1264c(this.f3900b, i, eVar).mo6539a();
    }

    /* renamed from: f */
    private void m4981f(Intent intent, int i, C1266e eVar) {
        C1196h.m4736a().mo6418b(f3899a, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        eVar.mo6548d().mo6598i();
    }

    /* renamed from: g */
    private void m4982g(Intent intent, int i, C1266e eVar) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        C1196h.m4736a().mo6418b(f3899a, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        mo6433a(string, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6537a(Intent intent, int i, C1266e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            m4980e(intent, i, eVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            m4981f(intent, i, eVar);
        } else if (!m4973a(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            C1196h.m4736a().mo6421e(f3899a, String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            m4976b(intent, i, eVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            m4978c(intent, i, eVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            m4979d(intent, i, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            m4982g(intent, i, eVar);
        } else {
            C1196h.m4736a().mo6420d(f3899a, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
        }
    }

    /* renamed from: a */
    public void mo6433a(String str, boolean z) {
        synchronized (this.f3902d) {
            C1201a remove = this.f3901c.remove(str);
            if (remove != null) {
                remove.mo6433a(str, z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6538a() {
        boolean z;
        synchronized (this.f3902d) {
            z = !this.f3901c.isEmpty();
        }
        return z;
    }
}
