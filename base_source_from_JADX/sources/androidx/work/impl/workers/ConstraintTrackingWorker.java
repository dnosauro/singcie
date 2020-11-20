package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.C1196h;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.C1289h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.p059a.C1224c;
import androidx.work.impl.p059a.C1225d;
import androidx.work.impl.p062b.C1240j;
import androidx.work.impl.utils.p064a.C1309c;
import androidx.work.impl.utils.p065b.C1311a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements C1224c {

    /* renamed from: d */
    private static final String f4097d = C1196h.m4737a("ConstraintTrkngWrkr");

    /* renamed from: a */
    final Object f4098a = new Object();

    /* renamed from: b */
    volatile boolean f4099b = false;

    /* renamed from: c */
    C1309c<ListenableWorker.C1178a> f4100c = C1309c.m5145d();

    /* renamed from: e */
    private WorkerParameters f4101e;

    /* renamed from: f */
    private ListenableWorker f4102f;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f4101e = workerParameters;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6662a() {
        String a = getInputData().mo6407a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(a)) {
            C1196h.m4736a().mo6421e(f4097d, "No worker to delegate to.", new Throwable[0]);
        } else {
            this.f4102f = getWorkerFactory().mo6689b(getApplicationContext(), a, this.f4101e);
            if (this.f4102f == null) {
                C1196h.m4736a().mo6418b(f4097d, "No worker to delegate to.", new Throwable[0]);
            } else {
                C1240j b = mo6665d().mo6422o().mo6516b(getId().toString());
                if (b == null) {
                    mo6663b();
                    return;
                }
                C1225d dVar = new C1225d(getApplicationContext(), getTaskExecutor(), this);
                dVar.mo6482a((List<C1240j>) Collections.singletonList(b));
                if (dVar.mo6483a(getId().toString())) {
                    C1196h.m4736a().mo6418b(f4097d, String.format("Constraints met for delegate %s", new Object[]{a}), new Throwable[0]);
                    try {
                        final ListenableFuture<ListenableWorker.C1178a> startWork = this.f4102f.startWork();
                        startWork.addListener(new Runnable() {
                            public void run() {
                                synchronized (ConstraintTrackingWorker.this.f4098a) {
                                    if (ConstraintTrackingWorker.this.f4099b) {
                                        ConstraintTrackingWorker.this.mo6664c();
                                    } else {
                                        ConstraintTrackingWorker.this.f4100c.mo6621a(startWork);
                                    }
                                }
                            }
                        }, getBackgroundExecutor());
                        return;
                    } catch (Throwable th) {
                        C1196h.m4736a().mo6418b(f4097d, String.format("Delegated worker %s threw exception in startWork.", new Object[]{a}), th);
                        synchronized (this.f4098a) {
                            if (this.f4099b) {
                                C1196h.m4736a().mo6418b(f4097d, "Constraints were unmet, Retrying.", new Throwable[0]);
                                mo6664c();
                            } else {
                                mo6663b();
                            }
                            return;
                        }
                    }
                } else {
                    C1196h.m4736a().mo6418b(f4097d, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{a}), new Throwable[0]);
                    mo6664c();
                    return;
                }
            }
        }
        mo6663b();
    }

    /* renamed from: a */
    public void mo6479a(List<String> list) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6663b() {
        this.f4100c.mo6622a(ListenableWorker.C1178a.m4670c());
    }

    /* renamed from: b */
    public void mo6480b(List<String> list) {
        C1196h.m4736a().mo6418b(f4097d, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.f4098a) {
            this.f4099b = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6664c() {
        this.f4100c.mo6622a(ListenableWorker.C1178a.m4669b());
    }

    /* renamed from: d */
    public WorkDatabase mo6665d() {
        return C1289h.m5059b(getApplicationContext()).mo6591c();
    }

    public C1311a getTaskExecutor() {
        return C1289h.m5059b(getApplicationContext()).mo6596g();
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f4102f;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    public ListenableFuture<ListenableWorker.C1178a> startWork() {
        getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ConstraintTrackingWorker.this.mo6662a();
            }
        });
        return this.f4100c;
    }
}
