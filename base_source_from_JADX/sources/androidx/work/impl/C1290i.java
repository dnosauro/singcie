package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.C1185b;
import androidx.work.C1192e;
import androidx.work.C1195g;
import androidx.work.C1196h;
import androidx.work.C1335n;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.p062b.C1228b;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.p062b.C1243k;
import androidx.work.impl.p062b.C1255n;
import androidx.work.impl.utils.p064a.C1309c;
import androidx.work.impl.utils.p065b.C1311a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* renamed from: androidx.work.impl.i */
public class C1290i implements Runnable {

    /* renamed from: a */
    static final String f3998a = C1196h.m4737a("WorkerWrapper");

    /* renamed from: b */
    C1240j f3999b;

    /* renamed from: c */
    ListenableWorker f4000c;

    /* renamed from: d */
    ListenableWorker.C1178a f4001d = ListenableWorker.C1178a.m4670c();

    /* renamed from: e */
    ListenableFuture<ListenableWorker.C1178a> f4002e = null;

    /* renamed from: f */
    private Context f4003f;

    /* renamed from: g */
    private String f4004g;

    /* renamed from: h */
    private List<C1281d> f4005h;

    /* renamed from: i */
    private WorkerParameters.C1183a f4006i;

    /* renamed from: j */
    private C1185b f4007j;

    /* renamed from: k */
    private C1311a f4008k;

    /* renamed from: l */
    private WorkDatabase f4009l;

    /* renamed from: m */
    private C1243k f4010m;

    /* renamed from: n */
    private C1228b f4011n;

    /* renamed from: o */
    private C1255n f4012o;

    /* renamed from: p */
    private List<String> f4013p;

    /* renamed from: q */
    private String f4014q;

    /* renamed from: r */
    private C1309c<Boolean> f4015r = C1309c.m5145d();

    /* renamed from: s */
    private volatile boolean f4016s;

    /* renamed from: androidx.work.impl.i$a */
    public static class C1293a {

        /* renamed from: a */
        Context f4022a;

        /* renamed from: b */
        ListenableWorker f4023b;

        /* renamed from: c */
        C1311a f4024c;

        /* renamed from: d */
        C1185b f4025d;

        /* renamed from: e */
        WorkDatabase f4026e;

        /* renamed from: f */
        String f4027f;

        /* renamed from: g */
        List<C1281d> f4028g;

        /* renamed from: h */
        WorkerParameters.C1183a f4029h = new WorkerParameters.C1183a();

        public C1293a(Context context, C1185b bVar, C1311a aVar, WorkDatabase workDatabase, String str) {
            this.f4022a = context.getApplicationContext();
            this.f4024c = aVar;
            this.f4025d = bVar;
            this.f4026e = workDatabase;
            this.f4027f = str;
        }

        /* renamed from: a */
        public C1293a mo6607a(WorkerParameters.C1183a aVar) {
            if (aVar != null) {
                this.f4029h = aVar;
            }
            return this;
        }

        /* renamed from: a */
        public C1293a mo6608a(List<C1281d> list) {
            this.f4028g = list;
            return this;
        }

        /* renamed from: a */
        public C1290i mo6609a() {
            return new C1290i(this);
        }
    }

    C1290i(C1293a aVar) {
        this.f4003f = aVar.f4022a;
        this.f4008k = aVar.f4024c;
        this.f4004g = aVar.f4027f;
        this.f4005h = aVar.f4028g;
        this.f4006i = aVar.f4029h;
        this.f4000c = aVar.f4023b;
        this.f4007j = aVar.f4025d;
        this.f4009l = aVar.f4026e;
        this.f4010m = this.f4009l.mo6422o();
        this.f4011n = this.f4009l.mo6423p();
        this.f4012o = this.f4009l.mo6424q();
    }

    /* renamed from: a */
    private String m5077a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f4004g);
        sb.append(", tags={ ");
        boolean z = true;
        for (String next : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    /* renamed from: a */
    private void m5078a(ListenableWorker.C1178a aVar) {
        if (aVar instanceof ListenableWorker.C1178a.C1181c) {
            C1196h.m4736a().mo6419c(f3998a, String.format("Worker result SUCCESS for %s", new Object[]{this.f4014q}), new Throwable[0]);
            if (!this.f3999b.mo6498a()) {
                m5087j();
                return;
            }
        } else if (aVar instanceof ListenableWorker.C1178a.C1180b) {
            C1196h.m4736a().mo6419c(f3998a, String.format("Worker result RETRY for %s", new Object[]{this.f4014q}), new Throwable[0]);
            m5085h();
            return;
        } else {
            C1196h.m4736a().mo6419c(f3998a, String.format("Worker result FAILURE for %s", new Object[]{this.f4014q}), new Throwable[0]);
            if (!this.f3999b.mo6498a()) {
                mo6603c();
                return;
            }
        }
        m5086i();
    }

    /* renamed from: a */
    private void m5079a(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f4010m.mo6522f(str2) != C1335n.C1336a.CANCELLED) {
                this.f4010m.mo6507a(C1335n.C1336a.FAILED, str2);
            }
            linkedList.addAll(this.f4011n.mo6487b(str2));
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ all -> 0x0039 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5080b(boolean r4) {
        /*
            r3 = this;
            androidx.work.impl.WorkDatabase r0 = r3.f4009l
            r0.mo6166g()
            androidx.work.impl.WorkDatabase r0 = r3.f4009l     // Catch:{ all -> 0x0039 }
            androidx.work.impl.b.k r0 = r0.mo6422o()     // Catch:{ all -> 0x0039 }
            java.util.List r0 = r0.mo6508a()     // Catch:{ all -> 0x0039 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r0 = 0
            goto L_0x001c
        L_0x001b:
            r0 = 1
        L_0x001c:
            if (r0 == 0) goto L_0x0025
            android.content.Context r0 = r3.f4003f     // Catch:{ all -> 0x0039 }
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r2 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            androidx.work.impl.utils.C1315d.m5169a(r0, r2, r1)     // Catch:{ all -> 0x0039 }
        L_0x0025:
            androidx.work.impl.WorkDatabase r0 = r3.f4009l     // Catch:{ all -> 0x0039 }
            r0.mo6169j()     // Catch:{ all -> 0x0039 }
            androidx.work.impl.WorkDatabase r0 = r3.f4009l
            r0.mo6167h()
            androidx.work.impl.utils.a.c<java.lang.Boolean> r0 = r3.f4015r
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r0.mo6622a(r4)
            return
        L_0x0039:
            r4 = move-exception
            androidx.work.impl.WorkDatabase r0 = r3.f4009l
            r0.mo6167h()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.C1290i.m5080b(boolean):void");
    }

    /* renamed from: d */
    private void m5081d() {
        C1192e a;
        if (!m5083f()) {
            this.f4009l.mo6166g();
            try {
                this.f3999b = this.f4010m.mo6516b(this.f4004g);
                if (this.f3999b == null) {
                    C1196h.m4736a().mo6421e(f3998a, String.format("Didn't find WorkSpec for id %s", new Object[]{this.f4004g}), new Throwable[0]);
                    m5080b(false);
                } else if (this.f3999b.f3838b != C1335n.C1336a.ENQUEUED) {
                    m5082e();
                    this.f4009l.mo6169j();
                    C1196h.m4736a().mo6418b(f3998a, String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.f3999b.f3839c}), new Throwable[0]);
                    this.f4009l.mo6167h();
                } else {
                    if (this.f3999b.mo6498a() || this.f3999b.mo6499b()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!(this.f3999b.f3850n == 0) && currentTimeMillis < this.f3999b.mo6500c()) {
                            C1196h.m4736a().mo6418b(f3998a, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f3999b.f3839c}), new Throwable[0]);
                            m5080b(true);
                            this.f4009l.mo6167h();
                            return;
                        }
                    }
                    this.f4009l.mo6169j();
                    this.f4009l.mo6167h();
                    if (this.f3999b.mo6498a()) {
                        a = this.f3999b.f3841e;
                    } else {
                        C1195g a2 = C1195g.m4734a(this.f3999b.f3840d);
                        if (a2 == null) {
                            C1196h.m4736a().mo6421e(f3998a, String.format("Could not create Input Merger %s", new Object[]{this.f3999b.f3840d}), new Throwable[0]);
                            mo6603c();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f3999b.f3841e);
                        arrayList.addAll(this.f4010m.mo6523g(this.f4004g));
                        a = a2.mo6327a((List<C1192e>) arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f4004g), a, this.f4013p, this.f4006i, this.f3999b.f3847k, this.f4007j.mo6368a(), this.f4008k, this.f4007j.mo6370c());
                    if (this.f4000c == null) {
                        this.f4000c = this.f4007j.mo6370c().mo6689b(this.f4003f, this.f3999b.f3839c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f4000c;
                    if (listenableWorker == null) {
                        C1196h.m4736a().mo6421e(f3998a, String.format("Could not create Worker %s", new Object[]{this.f3999b.f3839c}), new Throwable[0]);
                        mo6603c();
                    } else if (listenableWorker.isUsed()) {
                        C1196h.m4736a().mo6421e(f3998a, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.f3999b.f3839c}), new Throwable[0]);
                        mo6603c();
                    } else {
                        this.f4000c.setUsed();
                        if (!m5084g()) {
                            m5082e();
                        } else if (!m5083f()) {
                            final C1309c d = C1309c.m5145d();
                            this.f4008k.mo6648a().execute(new Runnable() {
                                public void run() {
                                    try {
                                        C1196h.m4736a().mo6418b(C1290i.f3998a, String.format("Starting work for %s", new Object[]{C1290i.this.f3999b.f3839c}), new Throwable[0]);
                                        C1290i.this.f4002e = C1290i.this.f4000c.startWork();
                                        d.mo6621a(C1290i.this.f4002e);
                                    } catch (Throwable th) {
                                        d.mo6623a(th);
                                    }
                                }
                            });
                            final String str = this.f4014q;
                            d.addListener(new Runnable() {
                                @SuppressLint({"SyntheticAccessor"})
                                public void run() {
                                    try {
                                        ListenableWorker.C1178a aVar = (ListenableWorker.C1178a) d.get();
                                        if (aVar == null) {
                                            C1196h.m4736a().mo6421e(C1290i.f3998a, String.format("%s returned a null result. Treating it as a failure.", new Object[]{C1290i.this.f3999b.f3839c}), new Throwable[0]);
                                        } else {
                                            C1196h.m4736a().mo6418b(C1290i.f3998a, String.format("%s returned a %s result.", new Object[]{C1290i.this.f3999b.f3839c, aVar}), new Throwable[0]);
                                            C1290i.this.f4001d = aVar;
                                        }
                                    } catch (CancellationException e) {
                                        C1196h.m4736a().mo6419c(C1290i.f3998a, String.format("%s was cancelled", new Object[]{str}), e);
                                    } catch (InterruptedException | ExecutionException e2) {
                                        C1196h.m4736a().mo6421e(C1290i.f3998a, String.format("%s failed because it threw an exception/error", new Object[]{str}), e2);
                                    } catch (Throwable th) {
                                        C1290i.this.mo6602b();
                                        throw th;
                                    }
                                    C1290i.this.mo6602b();
                                }
                            }, this.f4008k.mo6650b());
                        }
                    }
                }
            } finally {
                this.f4009l.mo6167h();
            }
        }
    }

    /* renamed from: e */
    private void m5082e() {
        C1335n.C1336a f = this.f4010m.mo6522f(this.f4004g);
        if (f == C1335n.C1336a.RUNNING) {
            C1196h.m4736a().mo6418b(f3998a, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.f4004g}), new Throwable[0]);
            m5080b(true);
            return;
        }
        C1196h.m4736a().mo6418b(f3998a, String.format("Status for %s is %s; not doing any work", new Object[]{this.f4004g, f}), new Throwable[0]);
        m5080b(false);
    }

    /* renamed from: f */
    private boolean m5083f() {
        if (!this.f4016s) {
            return false;
        }
        C1196h.m4736a().mo6418b(f3998a, String.format("Work interrupted for %s", new Object[]{this.f4014q}), new Throwable[0]);
        C1335n.C1336a f = this.f4010m.mo6522f(this.f4004g);
        if (f == null) {
            m5080b(false);
        } else {
            m5080b(!f.mo6679a());
        }
        return true;
    }

    /* renamed from: g */
    private boolean m5084g() {
        this.f4009l.mo6166g();
        try {
            boolean z = true;
            if (this.f4010m.mo6522f(this.f4004g) == C1335n.C1336a.ENQUEUED) {
                this.f4010m.mo6507a(C1335n.C1336a.RUNNING, this.f4004g);
                this.f4010m.mo6519d(this.f4004g);
            } else {
                z = false;
            }
            this.f4009l.mo6169j();
            return z;
        } finally {
            this.f4009l.mo6167h();
        }
    }

    /* renamed from: h */
    private void m5085h() {
        this.f4009l.mo6166g();
        try {
            this.f4010m.mo6507a(C1335n.C1336a.ENQUEUED, this.f4004g);
            this.f4010m.mo6512a(this.f4004g, System.currentTimeMillis());
            this.f4010m.mo6515b(this.f4004g, -1);
            this.f4009l.mo6169j();
        } finally {
            this.f4009l.mo6167h();
            m5080b(true);
        }
    }

    /* renamed from: i */
    private void m5086i() {
        this.f4009l.mo6166g();
        try {
            this.f4010m.mo6512a(this.f4004g, System.currentTimeMillis());
            this.f4010m.mo6507a(C1335n.C1336a.ENQUEUED, this.f4004g);
            this.f4010m.mo6521e(this.f4004g);
            this.f4010m.mo6515b(this.f4004g, -1);
            this.f4009l.mo6169j();
        } finally {
            this.f4009l.mo6167h();
            m5080b(false);
        }
    }

    /* renamed from: j */
    private void m5087j() {
        this.f4009l.mo6166g();
        try {
            this.f4010m.mo6507a(C1335n.C1336a.SUCCEEDED, this.f4004g);
            this.f4010m.mo6513a(this.f4004g, ((ListenableWorker.C1178a.C1181c) this.f4001d).mo6352d());
            long currentTimeMillis = System.currentTimeMillis();
            for (String next : this.f4011n.mo6487b(this.f4004g)) {
                if (this.f4010m.mo6522f(next) == C1335n.C1336a.BLOCKED && this.f4011n.mo6486a(next)) {
                    C1196h.m4736a().mo6419c(f3998a, String.format("Setting status to enqueued for %s", new Object[]{next}), new Throwable[0]);
                    this.f4010m.mo6507a(C1335n.C1336a.ENQUEUED, next);
                    this.f4010m.mo6512a(next, currentTimeMillis);
                }
            }
            this.f4009l.mo6169j();
        } finally {
            this.f4009l.mo6167h();
            m5080b(false);
        }
    }

    /* renamed from: a */
    public ListenableFuture<Boolean> mo6600a() {
        return this.f4015r;
    }

    /* renamed from: a */
    public void mo6601a(boolean z) {
        this.f4016s = true;
        m5083f();
        ListenableFuture<ListenableWorker.C1178a> listenableFuture = this.f4002e;
        if (listenableFuture != null) {
            listenableFuture.cancel(true);
        }
        ListenableWorker listenableWorker = this.f4000c;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6602b() {
        boolean z = false;
        if (!m5083f()) {
            this.f4009l.mo6166g();
            try {
                C1335n.C1336a f = this.f4010m.mo6522f(this.f4004g);
                if (f == null) {
                    m5080b(false);
                    z = true;
                } else if (f == C1335n.C1336a.RUNNING) {
                    m5078a(this.f4001d);
                    z = this.f4010m.mo6522f(this.f4004g).mo6679a();
                } else if (!f.mo6679a()) {
                    m5085h();
                }
                this.f4009l.mo6169j();
            } finally {
                this.f4009l.mo6167h();
            }
        }
        List<C1281d> list = this.f4005h;
        if (list != null) {
            if (z) {
                for (C1281d a : list) {
                    a.mo6530a(this.f4004g);
                }
            }
            C1282e.m5040a(this.f4007j, this.f4009l, this.f4005h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6603c() {
        this.f4009l.mo6166g();
        try {
            m5079a(this.f4004g);
            this.f4010m.mo6513a(this.f4004g, ((ListenableWorker.C1178a.C1179a) this.f4001d).mo6345d());
            this.f4009l.mo6169j();
        } finally {
            this.f4009l.mo6167h();
            m5080b(false);
        }
    }

    public void run() {
        this.f4013p = this.f4012o.mo6527a(this.f4004g);
        this.f4014q = m5077a(this.f4013p);
        m5081d();
    }
}
