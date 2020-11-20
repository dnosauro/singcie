package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.C1196h;
import androidx.work.impl.C1201a;
import androidx.work.impl.C1279c;
import androidx.work.impl.C1289h;
import androidx.work.impl.utils.C1321i;
import androidx.work.impl.utils.p065b.C1311a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.work.impl.background.systemalarm.e */
public class C1266e implements C1201a {

    /* renamed from: a */
    static final String f3918a = C1196h.m4737a("SystemAlarmDispatcher");

    /* renamed from: b */
    final Context f3919b;

    /* renamed from: c */
    final C1263b f3920c;

    /* renamed from: d */
    final List<Intent> f3921d;

    /* renamed from: e */
    Intent f3922e;

    /* renamed from: f */
    private final C1311a f3923f;

    /* renamed from: g */
    private final C1272g f3924g;

    /* renamed from: h */
    private final C1279c f3925h;

    /* renamed from: i */
    private final C1289h f3926i;

    /* renamed from: j */
    private final Handler f3927j;

    /* renamed from: k */
    private C1269b f3928k;

    /* renamed from: androidx.work.impl.background.systemalarm.e$a */
    static class C1268a implements Runnable {

        /* renamed from: a */
        private final C1266e f3930a;

        /* renamed from: b */
        private final Intent f3931b;

        /* renamed from: c */
        private final int f3932c;

        C1268a(C1266e eVar, Intent intent, int i) {
            this.f3930a = eVar;
            this.f3931b = intent;
            this.f3932c = i;
        }

        public void run() {
            this.f3930a.mo6545a(this.f3931b, this.f3932c);
        }
    }

    /* renamed from: androidx.work.impl.background.systemalarm.e$b */
    interface C1269b {
        /* renamed from: a */
        void mo6536a();
    }

    /* renamed from: androidx.work.impl.background.systemalarm.e$c */
    static class C1270c implements Runnable {

        /* renamed from: a */
        private final C1266e f3933a;

        C1270c(C1266e eVar) {
            this.f3933a = eVar;
        }

        public void run() {
            this.f3933a.mo6550f();
        }
    }

    C1266e(Context context) {
        this(context, (C1279c) null, (C1289h) null);
    }

    C1266e(Context context, C1279c cVar, C1289h hVar) {
        this.f3919b = context.getApplicationContext();
        this.f3920c = new C1263b(this.f3919b);
        this.f3924g = new C1272g();
        this.f3926i = hVar == null ? C1289h.m5059b(context) : hVar;
        this.f3925h = cVar == null ? this.f3926i.mo6595f() : cVar;
        this.f3923f = this.f3926i.mo6596g();
        this.f3925h.mo6565a((C1201a) this);
        this.f3921d = new ArrayList();
        this.f3922e = null;
        this.f3927j = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    private boolean m4994a(String str) {
        m4996h();
        synchronized (this.f3921d) {
            for (Intent action : this.f3921d) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: g */
    private void m4995g() {
        m4996h();
        PowerManager.WakeLock a = C1321i.m5174a(this.f3919b, "ProcessCommand");
        try {
            a.acquire();
            this.f3926i.mo6596g().mo6649a(new Runnable() {
                public void run() {
                    C1270c cVar;
                    C1266e eVar;
                    synchronized (C1266e.this.f3921d) {
                        C1266e.this.f3922e = C1266e.this.f3921d.get(0);
                    }
                    if (C1266e.this.f3922e != null) {
                        String action = C1266e.this.f3922e.getAction();
                        int intExtra = C1266e.this.f3922e.getIntExtra("KEY_START_ID", 0);
                        C1196h.m4736a().mo6418b(C1266e.f3918a, String.format("Processing command %s, %s", new Object[]{C1266e.this.f3922e, Integer.valueOf(intExtra)}), new Throwable[0]);
                        PowerManager.WakeLock a = C1321i.m5174a(C1266e.this.f3919b, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                        try {
                            C1196h.m4736a().mo6418b(C1266e.f3918a, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, a}), new Throwable[0]);
                            a.acquire();
                            C1266e.this.f3920c.mo6537a(C1266e.this.f3922e, intExtra, C1266e.this);
                            C1196h.m4736a().mo6418b(C1266e.f3918a, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a}), new Throwable[0]);
                            a.release();
                            eVar = C1266e.this;
                            cVar = new C1270c(eVar);
                        } catch (Throwable th) {
                            C1196h.m4736a().mo6418b(C1266e.f3918a, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a}), new Throwable[0]);
                            a.release();
                            C1266e eVar2 = C1266e.this;
                            eVar2.mo6544a((Runnable) new C1270c(eVar2));
                            throw th;
                        }
                        eVar.mo6544a((Runnable) cVar);
                    }
                }
            });
        } finally {
            a.release();
        }
    }

    /* renamed from: h */
    private void m4996h() {
        if (this.f3927j.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6542a() {
        C1196h.m4736a().mo6418b(f3918a, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f3925h.mo6568b((C1201a) this);
        this.f3924g.mo6554a();
        this.f3928k = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6543a(C1269b bVar) {
        if (this.f3928k != null) {
            C1196h.m4736a().mo6421e(f3918a, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f3928k = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6544a(Runnable runnable) {
        this.f3927j.post(runnable);
    }

    /* renamed from: a */
    public void mo6433a(String str, boolean z) {
        mo6544a((Runnable) new C1268a(this, C1263b.m4972a(this.f3919b, str, z), 0));
    }

    /* renamed from: a */
    public boolean mo6545a(Intent intent, int i) {
        boolean z = false;
        C1196h.m4736a().mo6418b(f3918a, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i)}), new Throwable[0]);
        m4996h();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            C1196h.m4736a().mo6420d(f3918a, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && m4994a("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i);
            synchronized (this.f3921d) {
                if (!this.f3921d.isEmpty()) {
                    z = true;
                }
                this.f3921d.add(intent);
                if (!z) {
                    m4995g();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1279c mo6546b() {
        return this.f3925h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C1272g mo6547c() {
        return this.f3924g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C1289h mo6548d() {
        return this.f3926i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C1311a mo6549e() {
        return this.f3923f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6550f() {
        C1196h.m4736a().mo6418b(f3918a, "Checking if commands are complete.", new Throwable[0]);
        m4996h();
        synchronized (this.f3921d) {
            if (this.f3922e != null) {
                C1196h.m4736a().mo6418b(f3918a, String.format("Removing command %s", new Object[]{this.f3922e}), new Throwable[0]);
                if (this.f3921d.remove(0).equals(this.f3922e)) {
                    this.f3922e = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            if (!this.f3920c.mo6538a() && this.f3921d.isEmpty()) {
                C1196h.m4736a().mo6418b(f3918a, "No more commands & intents.", new Throwable[0]);
                if (this.f3928k != null) {
                    this.f3928k.mo6536a();
                }
            } else if (!this.f3921d.isEmpty()) {
                m4995g();
            }
        }
    }
}
