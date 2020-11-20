package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.C1188c;
import androidx.work.C1192e;
import androidx.work.C1196h;
import androidx.work.C1326k;
import androidx.work.impl.C1226b;
import androidx.work.impl.C1281d;
import androidx.work.impl.C1282e;
import androidx.work.impl.C1283f;
import androidx.work.impl.C1289h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.List;

/* renamed from: androidx.work.impl.utils.b */
public class C1310b implements Runnable {

    /* renamed from: a */
    private static final String f4070a = C1196h.m4737a("EnqueueRunnable");

    /* renamed from: b */
    private final C1283f f4071b;

    /* renamed from: c */
    private final C1226b f4072c = new C1226b();

    public C1310b(C1283f fVar) {
        this.f4071b = fVar;
    }

    /* renamed from: a */
    private static void m5149a(C1240j jVar) {
        C1188c cVar = jVar.f3846j;
        if (cVar.mo6388d() || cVar.mo6389e()) {
            String str = jVar.f3839c;
            C1192e.C1193a aVar = new C1192e.C1193a();
            aVar.mo6412a(jVar.f3841e).mo6414a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            jVar.f3839c = ConstraintTrackingWorker.class.getName();
            jVar.f3841e = aVar.mo6416a();
        }
    }

    /* renamed from: a */
    private static boolean m5150a(C1283f fVar) {
        List<C1283f> h = fVar.mo6581h();
        boolean z = false;
        if (h != null) {
            boolean z2 = false;
            for (C1283f next : h) {
                if (!next.mo6579f()) {
                    z2 |= m5150a(next);
                } else {
                    C1196h.m4736a().mo6420d(f4070a, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.mo6578e())}), new Throwable[0]);
                }
            }
            z = z2;
        }
        return m5153b(fVar) | z;
    }

    /* renamed from: a */
    private static boolean m5151a(C1289h hVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (C1281d dVar : hVar.mo6594e()) {
                if (cls.isAssignableFrom(dVar.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01a8 A[LOOP:6: B:107:0x01a2->B:109:0x01a8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01d1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0123  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m5152a(androidx.work.impl.C1289h r19, java.util.List<? extends androidx.work.C1338p> r20, java.lang.String[] r21, java.lang.String r22, androidx.work.C1194f r23) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = r23
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r19.mo6591c()
            r8 = 1
            if (r1 == 0) goto L_0x0018
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            if (r9 == 0) goto L_0x005d
            int r10 = r1.length
            r11 = 0
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0060
            r15 = r1[r11]
            androidx.work.impl.b.k r7 = r6.mo6422o()
            androidx.work.impl.b.j r7 = r7.mo6516b(r15)
            if (r7 != 0) goto L_0x0045
            androidx.work.h r0 = androidx.work.C1196h.m4736a()
            java.lang.String r1 = f4070a
            java.lang.String r2 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.Object[] r3 = new java.lang.Object[r8]
            r4 = 0
            r3[r4] = r15
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r4]
            r0.mo6421e(r1, r2, r3)
            return r4
        L_0x0045:
            androidx.work.n$a r7 = r7.f3838b
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.SUCCEEDED
            if (r7 != r15) goto L_0x004d
            r15 = 1
            goto L_0x004e
        L_0x004d:
            r15 = 0
        L_0x004e:
            r12 = r12 & r15
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.FAILED
            if (r7 != r15) goto L_0x0055
            r13 = 1
            goto L_0x005a
        L_0x0055:
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.CANCELLED
            if (r7 != r15) goto L_0x005a
            r14 = 1
        L_0x005a:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x005d:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0060:
            boolean r7 = android.text.TextUtils.isEmpty(r22)
            r7 = r7 ^ r8
            if (r7 == 0) goto L_0x006b
            if (r9 != 0) goto L_0x006b
            r10 = 1
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x00ce
            androidx.work.impl.b.k r10 = r6.mo6422o()
            java.util.List r10 = r10.mo6518c(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x00ce
            androidx.work.f r11 = androidx.work.C1194f.APPEND
            if (r3 != r11) goto L_0x00d0
            androidx.work.impl.b.b r3 = r6.mo6423p()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x008d:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00c2
            java.lang.Object r11 = r10.next()
            androidx.work.impl.b.j$a r11 = (androidx.work.impl.p062b.C1240j.C1242a) r11
            java.lang.String r15 = r11.f3853a
            boolean r15 = r3.mo6488c(r15)
            if (r15 != 0) goto L_0x00c0
            androidx.work.n$a r15 = r11.f3854b
            androidx.work.n$a r8 = androidx.work.C1335n.C1336a.SUCCEEDED
            if (r15 != r8) goto L_0x00a9
            r8 = 1
            goto L_0x00aa
        L_0x00a9:
            r8 = 0
        L_0x00aa:
            r8 = r8 & r12
            androidx.work.n$a r12 = r11.f3854b
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.FAILED
            if (r12 != r15) goto L_0x00b3
            r13 = 1
            goto L_0x00ba
        L_0x00b3:
            androidx.work.n$a r12 = r11.f3854b
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.CANCELLED
            if (r12 != r15) goto L_0x00ba
            r14 = 1
        L_0x00ba:
            java.lang.String r11 = r11.f3853a
            r9.add(r11)
            r12 = r8
        L_0x00c0:
            r8 = 1
            goto L_0x008d
        L_0x00c2:
            java.lang.Object[] r1 = r9.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r3 = r1.length
            if (r3 <= 0) goto L_0x00cd
            r9 = 1
            goto L_0x00ce
        L_0x00cd:
            r9 = 0
        L_0x00ce:
            r3 = 0
            goto L_0x0117
        L_0x00d0:
            androidx.work.f r8 = androidx.work.C1194f.KEEP
            if (r3 != r8) goto L_0x00f2
            java.util.Iterator r3 = r10.iterator()
        L_0x00d8:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x00f2
            java.lang.Object r8 = r3.next()
            androidx.work.impl.b.j$a r8 = (androidx.work.impl.p062b.C1240j.C1242a) r8
            androidx.work.n$a r11 = r8.f3854b
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.ENQUEUED
            if (r11 == r15) goto L_0x00f0
            androidx.work.n$a r8 = r8.f3854b
            androidx.work.n$a r11 = androidx.work.C1335n.C1336a.RUNNING
            if (r8 != r11) goto L_0x00d8
        L_0x00f0:
            r3 = 0
            return r3
        L_0x00f2:
            r3 = 0
            androidx.work.impl.utils.a r8 = androidx.work.impl.utils.C1294a.m5102a(r2, r0, r3)
            r8.run()
            androidx.work.impl.b.k r8 = r6.mo6422o()
            java.util.Iterator r10 = r10.iterator()
        L_0x0102:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0114
            java.lang.Object r11 = r10.next()
            androidx.work.impl.b.j$a r11 = (androidx.work.impl.p062b.C1240j.C1242a) r11
            java.lang.String r11 = r11.f3853a
            r8.mo6511a((java.lang.String) r11)
            goto L_0x0102
        L_0x0114:
            r16 = 1
            goto L_0x0119
        L_0x0117:
            r16 = 0
        L_0x0119:
            java.util.Iterator r8 = r20.iterator()
        L_0x011d:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x01d6
            java.lang.Object r10 = r8.next()
            androidx.work.p r10 = (androidx.work.C1338p) r10
            androidx.work.impl.b.j r11 = r10.mo6682b()
            if (r9 == 0) goto L_0x0140
            if (r12 != 0) goto L_0x0140
            if (r13 == 0) goto L_0x0138
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.FAILED
        L_0x0135:
            r11.f3838b = r15
            goto L_0x0148
        L_0x0138:
            if (r14 == 0) goto L_0x013d
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.CANCELLED
            goto L_0x0135
        L_0x013d:
            androidx.work.n$a r15 = androidx.work.C1335n.C1336a.BLOCKED
            goto L_0x0135
        L_0x0140:
            boolean r15 = r11.mo6498a()
            if (r15 != 0) goto L_0x014b
            r11.f3850n = r4
        L_0x0148:
            r17 = r4
            goto L_0x0151
        L_0x014b:
            r17 = r4
            r3 = 0
            r11.f3850n = r3
        L_0x0151:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 < r4) goto L_0x0161
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 25
            if (r3 > r4) goto L_0x0161
        L_0x015d:
            m5149a((androidx.work.impl.p062b.C1240j) r11)
            goto L_0x0170
        L_0x0161:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 22
            if (r3 > r4) goto L_0x0170
            java.lang.String r3 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r3 = m5151a(r0, r3)
            if (r3 == 0) goto L_0x0170
            goto L_0x015d
        L_0x0170:
            androidx.work.n$a r3 = r11.f3838b
            androidx.work.n$a r4 = androidx.work.C1335n.C1336a.ENQUEUED
            if (r3 != r4) goto L_0x0178
            r16 = 1
        L_0x0178:
            androidx.work.impl.b.k r3 = r6.mo6422o()
            r3.mo6510a((androidx.work.impl.p062b.C1240j) r11)
            if (r9 == 0) goto L_0x019a
            int r3 = r1.length
            r4 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x019a
            r5 = r1[r4]
            androidx.work.impl.b.a r11 = new androidx.work.impl.b.a
            java.lang.String r15 = r10.mo6681a()
            r11.<init>(r15, r5)
            androidx.work.impl.b.b r5 = r6.mo6423p()
            r5.mo6485a((androidx.work.impl.p062b.C1227a) r11)
            int r4 = r4 + 1
            goto L_0x0183
        L_0x019a:
            java.util.Set r3 = r10.mo6683c()
            java.util.Iterator r3 = r3.iterator()
        L_0x01a2:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01bf
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            androidx.work.impl.b.n r5 = r6.mo6424q()
            androidx.work.impl.b.m r11 = new androidx.work.impl.b.m
            java.lang.String r15 = r10.mo6681a()
            r11.<init>(r4, r15)
            r5.mo6528a((androidx.work.impl.p062b.C1254m) r11)
            goto L_0x01a2
        L_0x01bf:
            if (r7 == 0) goto L_0x01d1
            androidx.work.impl.b.h r3 = r6.mo6426s()
            androidx.work.impl.b.g r4 = new androidx.work.impl.b.g
            java.lang.String r5 = r10.mo6681a()
            r4.<init>(r2, r5)
            r3.mo6496a(r4)
        L_0x01d1:
            r4 = r17
            r3 = 0
            goto L_0x011d
        L_0x01d6:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.C1310b.m5152a(androidx.work.impl.h, java.util.List, java.lang.String[], java.lang.String, androidx.work.f):boolean");
    }

    /* renamed from: b */
    private static boolean m5153b(C1283f fVar) {
        boolean a = m5152a(fVar.mo6574a(), fVar.mo6577d(), (String[]) C1283f.m5041a(fVar).toArray(new String[0]), fVar.mo6575b(), fVar.mo6576c());
        fVar.mo6580g();
        return a;
    }

    /* renamed from: a */
    public C1326k mo6644a() {
        return this.f4072c;
    }

    /* renamed from: b */
    public boolean mo6645b() {
        WorkDatabase c = this.f4071b.mo6574a().mo6591c();
        c.mo6166g();
        try {
            boolean a = m5150a(this.f4071b);
            c.mo6169j();
            return a;
        } finally {
            c.mo6167h();
        }
    }

    /* renamed from: c */
    public void mo6646c() {
        C1289h a = this.f4071b.mo6574a();
        C1282e.m5040a(a.mo6593d(), a.mo6591c(), a.mo6594e());
    }

    public void run() {
        try {
            if (!this.f4071b.mo6583j()) {
                if (mo6645b()) {
                    C1315d.m5169a(this.f4071b.mo6574a().mo6589b(), RescheduleReceiver.class, true);
                    mo6646c();
                }
                this.f4072c.mo6484a(C1326k.f4106a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.f4071b}));
        } catch (Throwable th) {
            this.f4072c.mo6484a(new C1326k.C1328a.C1329a(th));
        }
    }
}
