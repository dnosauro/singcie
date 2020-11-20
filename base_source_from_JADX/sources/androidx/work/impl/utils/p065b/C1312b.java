package androidx.work.impl.utils.p065b;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.C1317f;
import java.util.concurrent.Executor;

/* renamed from: androidx.work.impl.utils.b.b */
public class C1312b implements C1311a {

    /* renamed from: a */
    private final Executor f4073a;

    /* renamed from: b */
    private final Handler f4074b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private final Executor f4075c = new Executor() {
        public void execute(Runnable runnable) {
            C1312b.this.mo6651b(runnable);
        }
    };

    public C1312b(Executor executor) {
        this.f4073a = new C1317f(executor);
    }

    /* renamed from: a */
    public Executor mo6648a() {
        return this.f4075c;
    }

    /* renamed from: a */
    public void mo6649a(Runnable runnable) {
        this.f4073a.execute(runnable);
    }

    /* renamed from: b */
    public Executor mo6650b() {
        return this.f4073a;
    }

    /* renamed from: b */
    public void mo6651b(Runnable runnable) {
        this.f4074b.post(runnable);
    }
}
