package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.C0957k;
import androidx.work.C1196h;
import androidx.work.impl.background.systemalarm.C1266e;
import androidx.work.impl.utils.C1321i;

public class SystemAlarmService extends C0957k implements C1266e.C1269b {

    /* renamed from: a */
    private static final String f3895a = C1196h.m4737a("SystemAlarmService");

    /* renamed from: b */
    private C1266e f3896b;

    /* renamed from: c */
    private boolean f3897c;

    /* renamed from: b */
    private void m4964b() {
        this.f3896b = new C1266e(this);
        this.f3896b.mo6543a((C1266e.C1269b) this);
    }

    /* renamed from: a */
    public void mo6536a() {
        this.f3897c = true;
        C1196h.m4736a().mo6418b(f3895a, "All commands completed in dispatcher", new Throwable[0]);
        C1321i.m5175a();
        stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        m4964b();
        this.f3897c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3897c = true;
        this.f3896b.mo6542a();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f3897c) {
            C1196h.m4736a().mo6419c(f3895a, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f3896b.mo6542a();
            m4964b();
            this.f3897c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f3896b.mo6545a(intent, i2);
        return 3;
    }
}
