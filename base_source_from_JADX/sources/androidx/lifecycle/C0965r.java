package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.C0947e;

/* renamed from: androidx.lifecycle.r */
public class C0965r {

    /* renamed from: a */
    private final C0953i f3104a;

    /* renamed from: b */
    private final Handler f3105b = new Handler();

    /* renamed from: c */
    private C0966a f3106c;

    /* renamed from: androidx.lifecycle.r$a */
    static class C0966a implements Runnable {

        /* renamed from: a */
        final C0947e.C0948a f3107a;

        /* renamed from: b */
        private final C0953i f3108b;

        /* renamed from: c */
        private boolean f3109c = false;

        C0966a(C0953i iVar, C0947e.C0948a aVar) {
            this.f3108b = iVar;
            this.f3107a = aVar;
        }

        public void run() {
            if (!this.f3109c) {
                this.f3108b.mo5115a(this.f3107a);
                this.f3109c = true;
            }
        }
    }

    public C0965r(C0952h hVar) {
        this.f3104a = new C0953i(hVar);
    }

    /* renamed from: a */
    private void m3758a(C0947e.C0948a aVar) {
        C0966a aVar2 = this.f3106c;
        if (aVar2 != null) {
            aVar2.run();
        }
        this.f3106c = new C0966a(this.f3104a, aVar);
        this.f3105b.postAtFrontOfQueue(this.f3106c);
    }

    /* renamed from: a */
    public void mo5135a() {
        m3758a(C0947e.C0948a.ON_CREATE);
    }

    /* renamed from: b */
    public void mo5136b() {
        m3758a(C0947e.C0948a.ON_START);
    }

    /* renamed from: c */
    public void mo5137c() {
        m3758a(C0947e.C0948a.ON_START);
    }

    /* renamed from: d */
    public void mo5138d() {
        m3758a(C0947e.C0948a.ON_STOP);
        m3758a(C0947e.C0948a.ON_DESTROY);
    }

    /* renamed from: e */
    public C0947e mo5139e() {
        return this.f3104a;
    }
}
