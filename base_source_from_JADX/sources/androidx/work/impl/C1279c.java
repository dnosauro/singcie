package androidx.work.impl;

import android.content.Context;
import androidx.work.C1185b;
import androidx.work.C1196h;
import androidx.work.WorkerParameters;
import androidx.work.impl.C1290i;
import androidx.work.impl.utils.p065b.C1311a;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* renamed from: androidx.work.impl.c */
public class C1279c implements C1201a {

    /* renamed from: a */
    private static final String f3958a = C1196h.m4737a("Processor");

    /* renamed from: b */
    private Context f3959b;

    /* renamed from: c */
    private C1185b f3960c;

    /* renamed from: d */
    private C1311a f3961d;

    /* renamed from: e */
    private WorkDatabase f3962e;

    /* renamed from: f */
    private Map<String, C1290i> f3963f = new HashMap();

    /* renamed from: g */
    private List<C1281d> f3964g;

    /* renamed from: h */
    private Set<String> f3965h;

    /* renamed from: i */
    private final List<C1201a> f3966i;

    /* renamed from: j */
    private final Object f3967j;

    /* renamed from: androidx.work.impl.c$a */
    private static class C1280a implements Runnable {

        /* renamed from: a */
        private C1201a f3968a;

        /* renamed from: b */
        private String f3969b;

        /* renamed from: c */
        private ListenableFuture<Boolean> f3970c;

        C1280a(C1201a aVar, String str, ListenableFuture<Boolean> listenableFuture) {
            this.f3968a = aVar;
            this.f3969b = str;
            this.f3970c = listenableFuture;
        }

        public void run() {
            boolean z;
            try {
                z = ((Boolean) this.f3970c.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.f3968a.mo6433a(this.f3969b, z);
        }
    }

    public C1279c(Context context, C1185b bVar, C1311a aVar, WorkDatabase workDatabase, List<C1281d> list) {
        this.f3959b = context;
        this.f3960c = bVar;
        this.f3961d = aVar;
        this.f3962e = workDatabase;
        this.f3964g = list;
        this.f3965h = new HashSet();
        this.f3966i = new ArrayList();
        this.f3967j = new Object();
    }

    /* renamed from: a */
    public void mo6565a(C1201a aVar) {
        synchronized (this.f3967j) {
            this.f3966i.add(aVar);
        }
    }

    /* renamed from: a */
    public void mo6433a(String str, boolean z) {
        synchronized (this.f3967j) {
            this.f3963f.remove(str);
            C1196h.m4736a().mo6418b(f3958a, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z)}), new Throwable[0]);
            for (C1201a a : this.f3966i) {
                a.mo6433a(str, z);
            }
        }
    }

    /* renamed from: a */
    public boolean mo6566a(String str) {
        return mo6567a(str, (WorkerParameters.C1183a) null);
    }

    /* renamed from: a */
    public boolean mo6567a(String str, WorkerParameters.C1183a aVar) {
        synchronized (this.f3967j) {
            if (this.f3963f.containsKey(str)) {
                C1196h.m4736a().mo6418b(f3958a, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                return false;
            }
            C1290i a = new C1290i.C1293a(this.f3959b, this.f3960c, this.f3961d, this.f3962e, str).mo6608a(this.f3964g).mo6607a(aVar).mo6609a();
            ListenableFuture<Boolean> a2 = a.mo6600a();
            a2.addListener(new C1280a(this, str, a2), this.f3961d.mo6648a());
            this.f3963f.put(str, a);
            this.f3961d.mo6650b().execute(a);
            C1196h.m4736a().mo6418b(f3958a, String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str}), new Throwable[0]);
            return true;
        }
    }

    /* renamed from: b */
    public void mo6568b(C1201a aVar) {
        synchronized (this.f3967j) {
            this.f3966i.remove(aVar);
        }
    }

    /* renamed from: b */
    public boolean mo6569b(String str) {
        synchronized (this.f3967j) {
            C1196h.m4736a().mo6418b(f3958a, String.format("Processor stopping %s", new Object[]{str}), new Throwable[0]);
            C1290i remove = this.f3963f.remove(str);
            if (remove != null) {
                remove.mo6601a(false);
                C1196h.m4736a().mo6418b(f3958a, String.format("WorkerWrapper stopped for %s", new Object[]{str}), new Throwable[0]);
                return true;
            }
            C1196h.m4736a().mo6418b(f3958a, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
            return false;
        }
    }

    /* renamed from: c */
    public boolean mo6570c(String str) {
        synchronized (this.f3967j) {
            C1196h.m4736a().mo6418b(f3958a, String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
            this.f3965h.add(str);
            C1290i remove = this.f3963f.remove(str);
            if (remove != null) {
                remove.mo6601a(true);
                C1196h.m4736a().mo6418b(f3958a, String.format("WorkerWrapper cancelled for %s", new Object[]{str}), new Throwable[0]);
                return true;
            }
            C1196h.m4736a().mo6418b(f3958a, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
            return false;
        }
    }

    /* renamed from: d */
    public boolean mo6571d(String str) {
        boolean contains;
        synchronized (this.f3967j) {
            contains = this.f3965h.contains(str);
        }
        return contains;
    }

    /* renamed from: e */
    public boolean mo6572e(String str) {
        boolean containsKey;
        synchronized (this.f3967j) {
            containsKey = this.f3963f.containsKey(str);
        }
        return containsKey;
    }
}
