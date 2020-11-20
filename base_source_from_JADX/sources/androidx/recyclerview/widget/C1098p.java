package androidx.recyclerview.widget;

import android.view.View;

/* renamed from: androidx.recyclerview.widget.p */
class C1098p {

    /* renamed from: a */
    final C1100b f3459a;

    /* renamed from: b */
    C1099a f3460b = new C1099a();

    /* renamed from: androidx.recyclerview.widget.p$a */
    static class C1099a {

        /* renamed from: a */
        int f3461a = 0;

        /* renamed from: b */
        int f3462b;

        /* renamed from: c */
        int f3463c;

        /* renamed from: d */
        int f3464d;

        /* renamed from: e */
        int f3465e;

        C1099a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo6078a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6079a() {
            this.f3461a = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6080a(int i) {
            this.f3461a = i | this.f3461a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6081a(int i, int i2, int i3, int i4) {
            this.f3462b = i;
            this.f3463c = i2;
            this.f3464d = i3;
            this.f3465e = i4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo6082b() {
            int i = this.f3461a;
            if ((i & 7) != 0 && (i & (mo6078a(this.f3464d, this.f3462b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f3461a;
            if ((i2 & 112) != 0 && (i2 & (mo6078a(this.f3464d, this.f3463c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f3461a;
            if ((i3 & 1792) != 0 && (i3 & (mo6078a(this.f3465e, this.f3462b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f3461a;
            return (i4 & 28672) == 0 || (i4 & (mo6078a(this.f3465e, this.f3463c) << 12)) != 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.p$b */
    interface C1100b {
        /* renamed from: a */
        int mo5694a();

        /* renamed from: a */
        int mo5695a(View view);

        /* renamed from: a */
        View mo5696a(int i);

        /* renamed from: b */
        int mo5697b();

        /* renamed from: b */
        int mo5698b(View view);
    }

    C1098p(C1100b bVar) {
        this.f3459a = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo6076a(int i, int i2, int i3, int i4) {
        int a = this.f3459a.mo5694a();
        int b = this.f3459a.mo5697b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.f3459a.mo5696a(i);
            this.f3460b.mo6081a(a, b, this.f3459a.mo5695a(a2), this.f3459a.mo5698b(a2));
            if (i3 != 0) {
                this.f3460b.mo6079a();
                this.f3460b.mo6080a(i3);
                if (this.f3460b.mo6082b()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                this.f3460b.mo6079a();
                this.f3460b.mo6080a(i4);
                if (this.f3460b.mo6082b()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6077a(View view, int i) {
        this.f3460b.mo6081a(this.f3459a.mo5694a(), this.f3459a.mo5697b(), this.f3459a.mo5695a(view), this.f3459a.mo5698b(view));
        if (i == 0) {
            return false;
        }
        this.f3460b.mo6079a();
        this.f3460b.mo6080a(i);
        return this.f3460b.mo6082b();
    }
}
