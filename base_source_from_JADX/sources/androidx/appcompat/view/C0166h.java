package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.p030h.C0631aa;
import androidx.core.p030h.C0668y;
import androidx.core.p030h.C0672z;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.appcompat.view.h */
public class C0166h {

    /* renamed from: a */
    final ArrayList<C0668y> f489a = new ArrayList<>();

    /* renamed from: b */
    C0672z f490b;

    /* renamed from: c */
    private long f491c = -1;

    /* renamed from: d */
    private Interpolator f492d;

    /* renamed from: e */
    private boolean f493e;

    /* renamed from: f */
    private final C0631aa f494f = new C0631aa() {

        /* renamed from: b */
        private boolean f496b = false;

        /* renamed from: c */
        private int f497c = 0;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1183a() {
            this.f497c = 0;
            this.f496b = false;
            C0166h.this.mo1181b();
        }

        /* renamed from: a */
        public void mo912a(View view) {
            if (!this.f496b) {
                this.f496b = true;
                if (C0166h.this.f490b != null) {
                    C0166h.this.f490b.mo912a((View) null);
                }
            }
        }

        /* renamed from: b */
        public void mo913b(View view) {
            int i = this.f497c + 1;
            this.f497c = i;
            if (i == C0166h.this.f489a.size()) {
                if (C0166h.this.f490b != null) {
                    C0166h.this.f490b.mo913b((View) null);
                }
                mo1183a();
            }
        }
    };

    /* renamed from: a */
    public C0166h mo1175a(long j) {
        if (!this.f493e) {
            this.f491c = j;
        }
        return this;
    }

    /* renamed from: a */
    public C0166h mo1176a(Interpolator interpolator) {
        if (!this.f493e) {
            this.f492d = interpolator;
        }
        return this;
    }

    /* renamed from: a */
    public C0166h mo1177a(C0668y yVar) {
        if (!this.f493e) {
            this.f489a.add(yVar);
        }
        return this;
    }

    /* renamed from: a */
    public C0166h mo1178a(C0668y yVar, C0668y yVar2) {
        this.f489a.add(yVar);
        yVar2.mo3851b(yVar.mo3844a());
        this.f489a.add(yVar2);
        return this;
    }

    /* renamed from: a */
    public C0166h mo1179a(C0672z zVar) {
        if (!this.f493e) {
            this.f490b = zVar;
        }
        return this;
    }

    /* renamed from: a */
    public void mo1180a() {
        if (!this.f493e) {
            Iterator<C0668y> it = this.f489a.iterator();
            while (it.hasNext()) {
                C0668y next = it.next();
                long j = this.f491c;
                if (j >= 0) {
                    next.mo3846a(j);
                }
                Interpolator interpolator = this.f492d;
                if (interpolator != null) {
                    next.mo3847a(interpolator);
                }
                if (this.f490b != null) {
                    next.mo3849a((C0672z) this.f494f);
                }
                next.mo3853c();
            }
            this.f493e = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1181b() {
        this.f493e = false;
    }

    /* renamed from: c */
    public void mo1182c() {
        if (this.f493e) {
            Iterator<C0668y> it = this.f489a.iterator();
            while (it.hasNext()) {
                it.next().mo3852b();
            }
            this.f493e = false;
        }
    }
}
