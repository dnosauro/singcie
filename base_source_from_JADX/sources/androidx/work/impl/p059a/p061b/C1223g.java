package androidx.work.impl.p059a.p061b;

import android.content.Context;
import androidx.work.impl.utils.p065b.C1311a;

/* renamed from: androidx.work.impl.a.b.g */
public class C1223g {

    /* renamed from: a */
    private static C1223g f3807a;

    /* renamed from: b */
    private C1213a f3808b;

    /* renamed from: c */
    private C1214b f3809c;

    /* renamed from: d */
    private C1219e f3810d;

    /* renamed from: e */
    private C1222f f3811e;

    private C1223g(Context context, C1311a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f3808b = new C1213a(applicationContext, aVar);
        this.f3809c = new C1214b(applicationContext, aVar);
        this.f3810d = new C1219e(applicationContext, aVar);
        this.f3811e = new C1222f(applicationContext, aVar);
    }

    /* renamed from: a */
    public static synchronized C1223g m4848a(Context context, C1311a aVar) {
        C1223g gVar;
        synchronized (C1223g.class) {
            if (f3807a == null) {
                f3807a = new C1223g(context, aVar);
            }
            gVar = f3807a;
        }
        return gVar;
    }

    /* renamed from: a */
    public C1213a mo6475a() {
        return this.f3808b;
    }

    /* renamed from: b */
    public C1214b mo6476b() {
        return this.f3809c;
    }

    /* renamed from: c */
    public C1219e mo6477c() {
        return this.f3810d;
    }

    /* renamed from: d */
    public C1222f mo6478d() {
        return this.f3811e;
    }
}
