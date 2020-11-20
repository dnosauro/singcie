package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.p018c.C0414h;
import androidx.p046i.p047a.C0813b;
import androidx.p046i.p047a.C0814c;
import androidx.p046i.p047a.C0820e;
import androidx.p046i.p047a.C0821f;
import androidx.room.p056a.C1107a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: androidx.room.i */
public abstract class C1138i {
    @Deprecated

    /* renamed from: a */
    protected volatile C0813b f3564a;

    /* renamed from: b */
    boolean f3565b;
    @Deprecated

    /* renamed from: c */
    protected List<C1140b> f3566c;

    /* renamed from: d */
    private Executor f3567d;

    /* renamed from: e */
    private Executor f3568e;

    /* renamed from: f */
    private C0814c f3569f;

    /* renamed from: g */
    private final C1124f f3570g = mo6162c();

    /* renamed from: h */
    private boolean f3571h;

    /* renamed from: i */
    private final ReentrantReadWriteLock f3572i = new ReentrantReadWriteLock();

    /* renamed from: j */
    private final ThreadLocal<Integer> f3573j = new ThreadLocal<>();

    /* renamed from: k */
    private final Map<String, Object> f3574k = new ConcurrentHashMap();

    /* renamed from: androidx.room.i$a */
    public static class C1139a<T extends C1138i> {

        /* renamed from: a */
        private final Class<T> f3575a;

        /* renamed from: b */
        private final String f3576b;

        /* renamed from: c */
        private final Context f3577c;

        /* renamed from: d */
        private ArrayList<C1140b> f3578d;

        /* renamed from: e */
        private Executor f3579e;

        /* renamed from: f */
        private Executor f3580f;

        /* renamed from: g */
        private C0814c.C0818c f3581g;

        /* renamed from: h */
        private boolean f3582h;

        /* renamed from: i */
        private C1141c f3583i = C1141c.AUTOMATIC;

        /* renamed from: j */
        private boolean f3584j;

        /* renamed from: k */
        private boolean f3585k = true;

        /* renamed from: l */
        private boolean f3586l;

        /* renamed from: m */
        private final C1142d f3587m = new C1142d();

        /* renamed from: n */
        private Set<Integer> f3588n;

        /* renamed from: o */
        private Set<Integer> f3589o;

        C1139a(Context context, Class<T> cls, String str) {
            this.f3577c = context;
            this.f3575a = cls;
            this.f3576b = str;
        }

        /* renamed from: a */
        public C1139a<T> mo6171a() {
            this.f3582h = true;
            return this;
        }

        /* renamed from: a */
        public C1139a<T> mo6172a(C1140b bVar) {
            if (this.f3578d == null) {
                this.f3578d = new ArrayList<>();
            }
            this.f3578d.add(bVar);
            return this;
        }

        /* renamed from: a */
        public C1139a<T> mo6173a(Executor executor) {
            this.f3579e = executor;
            return this;
        }

        /* renamed from: a */
        public C1139a<T> mo6174a(C1107a... aVarArr) {
            if (this.f3589o == null) {
                this.f3589o = new HashSet();
            }
            for (C1107a aVar : aVarArr) {
                this.f3589o.add(Integer.valueOf(aVar.f3491a));
                this.f3589o.add(Integer.valueOf(aVar.f3492b));
            }
            this.f3587m.mo6181a(aVarArr);
            return this;
        }

        /* renamed from: b */
        public C1139a<T> mo6175b() {
            this.f3585k = false;
            this.f3586l = true;
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
            if (r0 != null) goto L_0x0016;
         */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
        @android.annotation.SuppressLint({"RestrictedApi"})
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T mo6176c() {
            /*
                r15 = this;
                android.content.Context r0 = r15.f3577c
                if (r0 == 0) goto L_0x00aa
                java.lang.Class<T> r0 = r15.f3575a
                if (r0 == 0) goto L_0x00a2
                java.util.concurrent.Executor r0 = r15.f3579e
                if (r0 != 0) goto L_0x0019
                java.util.concurrent.Executor r0 = r15.f3580f
                if (r0 != 0) goto L_0x0019
                java.util.concurrent.Executor r0 = androidx.p004a.p005a.p006a.C0037a.m7b()
                r15.f3580f = r0
            L_0x0016:
                r15.f3579e = r0
                goto L_0x002d
            L_0x0019:
                java.util.concurrent.Executor r0 = r15.f3579e
                if (r0 == 0) goto L_0x0024
                java.util.concurrent.Executor r1 = r15.f3580f
                if (r1 != 0) goto L_0x0024
                r15.f3580f = r0
                goto L_0x002d
            L_0x0024:
                java.util.concurrent.Executor r0 = r15.f3579e
                if (r0 != 0) goto L_0x002d
                java.util.concurrent.Executor r0 = r15.f3580f
                if (r0 == 0) goto L_0x002d
                goto L_0x0016
            L_0x002d:
                java.util.Set<java.lang.Integer> r0 = r15.f3589o
                if (r0 == 0) goto L_0x0065
                java.util.Set<java.lang.Integer> r1 = r15.f3588n
                if (r1 == 0) goto L_0x0065
                java.util.Iterator r0 = r0.iterator()
            L_0x0039:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0065
                java.lang.Object r1 = r0.next()
                java.lang.Integer r1 = (java.lang.Integer) r1
                java.util.Set<java.lang.Integer> r2 = r15.f3588n
                boolean r2 = r2.contains(r1)
                if (r2 != 0) goto L_0x004e
                goto L_0x0039
            L_0x004e:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x0065:
                androidx.i.a.c$c r0 = r15.f3581g
                if (r0 != 0) goto L_0x0070
                androidx.i.a.a.c r0 = new androidx.i.a.a.c
                r0.<init>()
                r15.f3581g = r0
            L_0x0070:
                androidx.room.a r0 = new androidx.room.a
                android.content.Context r2 = r15.f3577c
                java.lang.String r3 = r15.f3576b
                androidx.i.a.c$c r4 = r15.f3581g
                androidx.room.i$d r5 = r15.f3587m
                java.util.ArrayList<androidx.room.i$b> r6 = r15.f3578d
                boolean r7 = r15.f3582h
                androidx.room.i$c r1 = r15.f3583i
                androidx.room.i$c r8 = r1.mo6179a(r2)
                java.util.concurrent.Executor r9 = r15.f3579e
                java.util.concurrent.Executor r10 = r15.f3580f
                boolean r11 = r15.f3584j
                boolean r12 = r15.f3585k
                boolean r13 = r15.f3586l
                java.util.Set<java.lang.Integer> r14 = r15.f3588n
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                java.lang.Class<T> r1 = r15.f3575a
                java.lang.String r2 = "_Impl"
                java.lang.Object r1 = androidx.room.C1137h.m4459a(r1, (java.lang.String) r2)
                androidx.room.i r1 = (androidx.room.C1138i) r1
                r1.mo6159a((androidx.room.C1106a) r0)
                return r1
            L_0x00a2:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "Must provide an abstract class that extends RoomDatabase"
                r0.<init>(r1)
                throw r0
            L_0x00aa:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "Cannot provide null context for the database."
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.C1138i.C1139a.mo6176c():androidx.room.i");
        }
    }

    /* renamed from: androidx.room.i$b */
    public static abstract class C1140b {
        /* renamed from: a */
        public void mo6177a(C0813b bVar) {
        }

        /* renamed from: b */
        public void mo6178b(C0813b bVar) {
        }
    }

    /* renamed from: androidx.room.i$c */
    public enum C1141c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
            r3 = (android.app.ActivityManager) r3.getSystemService("activity");
         */
        @android.annotation.SuppressLint({"NewApi"})
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.room.C1138i.C1141c mo6179a(android.content.Context r3) {
            /*
                r2 = this;
                androidx.room.i$c r0 = AUTOMATIC
                if (r2 == r0) goto L_0x0005
                return r2
            L_0x0005:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 < r1) goto L_0x001e
                java.lang.String r0 = "activity"
                java.lang.Object r3 = r3.getSystemService(r0)
                android.app.ActivityManager r3 = (android.app.ActivityManager) r3
                if (r3 == 0) goto L_0x001e
                boolean r3 = androidx.core.app.C0497b.m1960a(r3)
                if (r3 != 0) goto L_0x001e
                androidx.room.i$c r3 = WRITE_AHEAD_LOGGING
                return r3
            L_0x001e:
                androidx.room.i$c r3 = TRUNCATE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.C1138i.C1141c.mo6179a(android.content.Context):androidx.room.i$c");
        }
    }

    /* renamed from: androidx.room.i$d */
    public static class C1142d {

        /* renamed from: a */
        private C0414h<C0414h<C1107a>> f3594a = new C0414h<>();

        /* renamed from: a */
        private List<C1107a> m4486a(List<C1107a> list, boolean z, int i, int i2) {
            boolean z2;
            int i3;
            int i4;
            int i5 = z ? -1 : 1;
            do {
                if (z) {
                    if (i >= i2) {
                        return list;
                    }
                } else if (i <= i2) {
                    return list;
                }
                C0414h a = this.f3594a.mo2969a(i);
                if (a != null) {
                    int b = a.mo2971b();
                    z2 = false;
                    if (z) {
                        i4 = b - 1;
                        i3 = -1;
                    } else {
                        i3 = b;
                        i4 = 0;
                    }
                    while (true) {
                        if (i4 == i3) {
                            break;
                        }
                        int c = a.mo2974c(i4);
                        if (!z ? !(c < i2 || c >= i) : !(c > i2 || c <= i)) {
                            list.add(a.mo2978d(i4));
                            i = c;
                            z2 = true;
                            continue;
                            break;
                        }
                        i4 += i5;
                    }
                } else {
                    return null;
                }
            } while (z2);
            return null;
        }

        /* renamed from: a */
        private void m4487a(C1107a aVar) {
            int i = aVar.f3491a;
            int i2 = aVar.f3492b;
            C0414h a = this.f3594a.mo2969a(i);
            if (a == null) {
                a = new C0414h();
                this.f3594a.mo2973b(i, a);
            }
            C1107a aVar2 = (C1107a) a.mo2969a(i2);
            if (aVar2 != null) {
                Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
            }
            a.mo2976c(i2, aVar);
        }

        /* renamed from: a */
        public List<C1107a> mo6180a(int i, int i2) {
            if (i == i2) {
                return Collections.emptyList();
            }
            return m4486a(new ArrayList(), i2 > i, i, i2);
        }

        /* renamed from: a */
        public void mo6181a(C1107a... aVarArr) {
            for (C1107a a : aVarArr) {
                m4487a(a);
            }
        }
    }

    /* renamed from: l */
    private static boolean m4460l() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: a */
    public Cursor mo6155a(C0820e eVar) {
        mo6164e();
        mo6165f();
        return this.f3569f.mo4625a().mo4611a(eVar);
    }

    /* renamed from: a */
    public C0821f mo6156a(String str) {
        mo6164e();
        mo6165f();
        return this.f3569f.mo4625a().mo4612a(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Lock mo6157a() {
        return this.f3572i.readLock();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6158a(C0813b bVar) {
        this.f3570g.mo6132a(bVar);
    }

    /* renamed from: a */
    public void mo6159a(C1106a aVar) {
        this.f3569f = mo6161b(aVar);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 16) {
            if (aVar.f3484g == C1141c.WRITE_AHEAD_LOGGING) {
                z = true;
            }
            this.f3569f.mo4626a(z);
        }
        this.f3566c = aVar.f3482e;
        this.f3567d = aVar.f3485h;
        this.f3568e = new C1148n(aVar.f3486i);
        this.f3571h = aVar.f3483f;
        this.f3565b = z;
        if (aVar.f3487j) {
            this.f3570g.mo6131a(aVar.f3479b, aVar.f3480c);
        }
    }

    /* renamed from: b */
    public C0814c mo6160b() {
        return this.f3569f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract C0814c mo6161b(C1106a aVar);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract C1124f mo6162c();

    /* renamed from: d */
    public boolean mo6163d() {
        C0813b bVar = this.f3564a;
        return bVar != null && bVar.mo4621e();
    }

    /* renamed from: e */
    public void mo6164e() {
        if (!this.f3571h && m4460l()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    /* renamed from: f */
    public void mo6165f() {
        if (!mo6170k() && this.f3573j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    /* renamed from: g */
    public void mo6166g() {
        mo6164e();
        C0813b a = this.f3569f.mo4625a();
        this.f3570g.mo6137b(a);
        a.mo4613a();
    }

    @Deprecated
    /* renamed from: h */
    public void mo6167h() {
        this.f3569f.mo4625a().mo4616b();
        if (!mo6170k()) {
            this.f3570g.mo6136b();
        }
    }

    /* renamed from: i */
    public Executor mo6168i() {
        return this.f3567d;
    }

    @Deprecated
    /* renamed from: j */
    public void mo6169j() {
        this.f3569f.mo4625a().mo4617c();
    }

    /* renamed from: k */
    public boolean mo6170k() {
        return this.f3569f.mo4625a().mo4620d();
    }
}
