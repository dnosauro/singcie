package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.C1289h;

/* renamed from: androidx.work.impl.utils.g */
public class C1319g implements Runnable {

    /* renamed from: a */
    private C1289h f4089a;

    /* renamed from: b */
    private String f4090b;

    /* renamed from: c */
    private WorkerParameters.C1183a f4091c;

    public C1319g(C1289h hVar, String str, WorkerParameters.C1183a aVar) {
        this.f4089a = hVar;
        this.f4090b = str;
        this.f4091c = aVar;
    }

    public void run() {
        this.f4089a.mo6595f().mo6567a(this.f4090b, this.f4091c);
    }
}
