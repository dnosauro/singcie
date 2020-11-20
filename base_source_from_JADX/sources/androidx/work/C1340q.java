package androidx.work;

import android.content.Context;

/* renamed from: androidx.work.q */
public abstract class C1340q {

    /* renamed from: a */
    private static final String f4128a = C1196h.m4737a("WorkerFactory");

    /* renamed from: a */
    public static C1340q m5202a() {
        return new C1340q() {
            /* renamed from: a */
            public ListenableWorker mo6688a(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    /* renamed from: a */
    public abstract ListenableWorker mo6688a(Context context, String str, WorkerParameters workerParameters);

    /* renamed from: b */
    public final ListenableWorker mo6689b(Context context, String str, WorkerParameters workerParameters) {
        ListenableWorker a = mo6688a(context, str, workerParameters);
        if (a != null) {
            return a;
        }
        try {
            try {
                return (ListenableWorker) Class.forName(str).asSubclass(ListenableWorker.class).getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
            } catch (Exception e) {
                C1196h a2 = C1196h.m4736a();
                String str2 = f4128a;
                a2.mo6421e(str2, "Could not instantiate " + str, e);
                return null;
            }
        } catch (ClassNotFoundException unused) {
            C1196h a3 = C1196h.m4736a();
            String str3 = f4128a;
            a3.mo6421e(str3, "Class not found: " + str, new Throwable[0]);
            return null;
        }
    }
}
