package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.C1196h;
import androidx.work.impl.C1201a;
import androidx.work.impl.background.systemalarm.C1266e;
import androidx.work.impl.background.systemalarm.C1272g;
import androidx.work.impl.p059a.C1224c;
import androidx.work.impl.p059a.C1225d;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.utils.C1321i;
import java.util.Collections;
import java.util.List;

/* renamed from: androidx.work.impl.background.systemalarm.d */
public class C1265d implements C1201a, C1224c, C1272g.C1274a {

    /* renamed from: a */
    private static final String f3908a = C1196h.m4737a("DelayMetCommandHandler");

    /* renamed from: b */
    private final Context f3909b;

    /* renamed from: c */
    private final int f3910c;

    /* renamed from: d */
    private final String f3911d;

    /* renamed from: e */
    private final C1266e f3912e;

    /* renamed from: f */
    private final C1225d f3913f;

    /* renamed from: g */
    private final Object f3914g = new Object();

    /* renamed from: h */
    private int f3915h = 0;

    /* renamed from: i */
    private PowerManager.WakeLock f3916i;

    /* renamed from: j */
    private boolean f3917j = false;

    C1265d(Context context, int i, String str, C1266e eVar) {
        this.f3909b = context;
        this.f3910c = i;
        this.f3912e = eVar;
        this.f3911d = str;
        this.f3913f = new C1225d(this.f3909b, eVar.mo6549e(), this);
    }

    /* renamed from: b */
    private void m4987b() {
        C1196h a;
        String str;
        String format;
        Throwable[] thArr;
        synchronized (this.f3914g) {
            if (this.f3915h < 2) {
                this.f3915h = 2;
                C1196h.m4736a().mo6418b(f3908a, String.format("Stopping work for WorkSpec %s", new Object[]{this.f3911d}), new Throwable[0]);
                this.f3912e.mo6544a((Runnable) new C1266e.C1268a(this.f3912e, C1263b.m4977c(this.f3909b, this.f3911d), this.f3910c));
                if (this.f3912e.mo6546b().mo6572e(this.f3911d)) {
                    C1196h.m4736a().mo6418b(f3908a, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.f3911d}), new Throwable[0]);
                    this.f3912e.mo6544a((Runnable) new C1266e.C1268a(this.f3912e, C1263b.m4971a(this.f3909b, this.f3911d), this.f3910c));
                } else {
                    a = C1196h.m4736a();
                    str = f3908a;
                    format = String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.f3911d});
                    thArr = new Throwable[0];
                }
            } else {
                a = C1196h.m4736a();
                str = f3908a;
                format = String.format("Already stopped work for %s", new Object[]{this.f3911d});
                thArr = new Throwable[0];
            }
            a.mo6418b(str, format, thArr);
        }
    }

    /* renamed from: c */
    private void m4988c() {
        synchronized (this.f3914g) {
            this.f3913f.mo6481a();
            this.f3912e.mo6547c().mo6555a(this.f3911d);
            if (this.f3916i != null && this.f3916i.isHeld()) {
                C1196h.m4736a().mo6418b(f3908a, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.f3916i, this.f3911d}), new Throwable[0]);
                this.f3916i.release();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6540a() {
        this.f3916i = C1321i.m5174a(this.f3909b, String.format("%s (%s)", new Object[]{this.f3911d, Integer.valueOf(this.f3910c)}));
        C1196h.m4736a().mo6418b(f3908a, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.f3916i, this.f3911d}), new Throwable[0]);
        this.f3916i.acquire();
        C1240j b = this.f3912e.mo6548d().mo6591c().mo6422o().mo6516b(this.f3911d);
        if (b == null) {
            m4987b();
            return;
        }
        this.f3917j = b.mo6501d();
        if (!this.f3917j) {
            C1196h.m4736a().mo6418b(f3908a, String.format("No constraints for %s", new Object[]{this.f3911d}), new Throwable[0]);
            mo6479a((List<String>) Collections.singletonList(this.f3911d));
            return;
        }
        this.f3913f.mo6482a((List<C1240j>) Collections.singletonList(b));
    }

    /* renamed from: a */
    public void mo6541a(String str) {
        C1196h.m4736a().mo6418b(f3908a, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        m4987b();
    }

    /* renamed from: a */
    public void mo6433a(String str, boolean z) {
        C1196h.m4736a().mo6418b(f3908a, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z)}), new Throwable[0]);
        m4988c();
        if (z) {
            Intent a = C1263b.m4971a(this.f3909b, this.f3911d);
            C1266e eVar = this.f3912e;
            eVar.mo6544a((Runnable) new C1266e.C1268a(eVar, a, this.f3910c));
        }
        if (this.f3917j) {
            Intent a2 = C1263b.m4970a(this.f3909b);
            C1266e eVar2 = this.f3912e;
            eVar2.mo6544a((Runnable) new C1266e.C1268a(eVar2, a2, this.f3910c));
        }
    }

    /* renamed from: a */
    public void mo6479a(List<String> list) {
        if (list.contains(this.f3911d)) {
            synchronized (this.f3914g) {
                if (this.f3915h == 0) {
                    this.f3915h = 1;
                    C1196h.m4736a().mo6418b(f3908a, String.format("onAllConstraintsMet for %s", new Object[]{this.f3911d}), new Throwable[0]);
                    if (this.f3912e.mo6546b().mo6566a(this.f3911d)) {
                        this.f3912e.mo6547c().mo6556a(this.f3911d, 600000, this);
                    } else {
                        m4988c();
                    }
                } else {
                    C1196h.m4736a().mo6418b(f3908a, String.format("Already started work for %s", new Object[]{this.f3911d}), new Throwable[0]);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo6480b(List<String> list) {
        m4987b();
    }
}
