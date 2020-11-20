package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.b */
class C1058b {

    /* renamed from: a */
    final C1060b f3325a;

    /* renamed from: b */
    final C1059a f3326b = new C1059a();

    /* renamed from: c */
    final List<View> f3327c = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.b$a */
    static class C1059a {

        /* renamed from: a */
        long f3328a = 0;

        /* renamed from: b */
        C1059a f3329b;

        C1059a() {
        }

        /* renamed from: b */
        private void m4166b() {
            if (this.f3329b == null) {
                this.f3329b = new C1059a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5960a() {
            this.f3328a = 0;
            C1059a aVar = this.f3329b;
            if (aVar != null) {
                aVar.mo5960a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5961a(int i) {
            if (i >= 64) {
                m4166b();
                this.f3329b.mo5961a(i - 64);
                return;
            }
            this.f3328a |= 1 << i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5962a(int i, boolean z) {
            if (i >= 64) {
                m4166b();
                this.f3329b.mo5962a(i - 64, z);
                return;
            }
            boolean z2 = (this.f3328a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f3328a;
            this.f3328a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                mo5961a(i);
            } else {
                mo5963b(i);
            }
            if (z2 || this.f3329b != null) {
                m4166b();
                this.f3329b.mo5962a(0, z2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5963b(int i) {
            if (i >= 64) {
                C1059a aVar = this.f3329b;
                if (aVar != null) {
                    aVar.mo5963b(i - 64);
                    return;
                }
                return;
            }
            this.f3328a &= ~(1 << i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo5964c(int i) {
            if (i < 64) {
                return (this.f3328a & (1 << i)) != 0;
            }
            m4166b();
            return this.f3329b.mo5964c(i - 64);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo5965d(int i) {
            if (i >= 64) {
                m4166b();
                return this.f3329b.mo5965d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f3328a & j) != 0;
            this.f3328a &= ~j;
            long j2 = j - 1;
            long j3 = this.f3328a;
            this.f3328a = Long.rotateRight(j3 & (~j2), 1) | (j3 & j2);
            C1059a aVar = this.f3329b;
            if (aVar != null) {
                if (aVar.mo5964c(0)) {
                    mo5961a(63);
                }
                this.f3329b.mo5965d(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public int mo5966e(int i) {
            C1059a aVar = this.f3329b;
            return aVar == null ? i >= 64 ? Long.bitCount(this.f3328a) : Long.bitCount(this.f3328a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f3328a & ((1 << i) - 1)) : aVar.mo5966e(i - 64) + Long.bitCount(this.f3328a);
        }

        public String toString() {
            if (this.f3329b == null) {
                return Long.toBinaryString(this.f3328a);
            }
            return this.f3329b.toString() + "xx" + Long.toBinaryString(this.f3328a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b */
    interface C1060b {
        /* renamed from: a */
        int mo5484a();

        /* renamed from: a */
        int mo5485a(View view);

        /* renamed from: a */
        void mo5486a(int i);

        /* renamed from: a */
        void mo5487a(View view, int i);

        /* renamed from: a */
        void mo5488a(View view, int i, ViewGroup.LayoutParams layoutParams);

        /* renamed from: b */
        View mo5489b(int i);

        /* renamed from: b */
        RecyclerView.C1045x mo5490b(View view);

        /* renamed from: b */
        void mo5491b();

        /* renamed from: c */
        void mo5492c(int i);

        /* renamed from: c */
        void mo5493c(View view);

        /* renamed from: d */
        void mo5494d(View view);
    }

    C1058b(C1060b bVar) {
        this.f3325a = bVar;
    }

    /* renamed from: f */
    private int m4146f(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f3325a.mo5484a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f3326b.mo5966e(i2));
            if (e == 0) {
                while (this.f3326b.mo5964c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    /* renamed from: g */
    private void m4147g(View view) {
        this.f3327c.add(view);
        this.f3325a.mo5493c(view);
    }

    /* renamed from: h */
    private boolean m4148h(View view) {
        if (!this.f3327c.remove(view)) {
            return false;
        }
        this.f3325a.mo5494d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5942a() {
        this.f3326b.mo5960a();
        for (int size = this.f3327c.size() - 1; size >= 0; size--) {
            this.f3325a.mo5494d(this.f3327c.get(size));
            this.f3327c.remove(size);
        }
        this.f3325a.mo5491b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5943a(int i) {
        int f = m4146f(i);
        View b = this.f3325a.mo5489b(f);
        if (b != null) {
            if (this.f3326b.mo5965d(f)) {
                m4148h(b);
            }
            this.f3325a.mo5486a(f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5944a(View view) {
        int a = this.f3325a.mo5485a(view);
        if (a >= 0) {
            if (this.f3326b.mo5965d(a)) {
                m4148h(view);
            }
            this.f3325a.mo5486a(a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5945a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int a = i < 0 ? this.f3325a.mo5484a() : m4146f(i);
        this.f3326b.mo5962a(a, z);
        if (z) {
            m4147g(view);
        }
        this.f3325a.mo5488a(view, a, layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5946a(View view, int i, boolean z) {
        int a = i < 0 ? this.f3325a.mo5484a() : m4146f(i);
        this.f3326b.mo5962a(a, z);
        if (z) {
            m4147g(view);
        }
        this.f3325a.mo5487a(view, a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5947a(View view, boolean z) {
        mo5946a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5948b() {
        return this.f3325a.mo5484a() - this.f3327c.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5949b(View view) {
        int a = this.f3325a.mo5485a(view);
        if (a != -1 && !this.f3326b.mo5964c(a)) {
            return a - this.f3326b.mo5966e(a);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo5950b(int i) {
        return this.f3325a.mo5489b(m4146f(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo5951c() {
        return this.f3325a.mo5484a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo5952c(int i) {
        int size = this.f3327c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f3327c.get(i2);
            RecyclerView.C1045x b = this.f3325a.mo5490b(view);
            if (b.getLayoutPosition() == i && !b.isInvalid() && !b.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5953c(View view) {
        return this.f3327c.contains(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public View mo5954d(int i) {
        return this.f3325a.mo5489b(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5955d(View view) {
        int a = this.f3325a.mo5485a(view);
        if (a >= 0) {
            this.f3326b.mo5961a(a);
            m4147g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5956e(int i) {
        int f = m4146f(i);
        this.f3326b.mo5965d(f);
        this.f3325a.mo5492c(f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5957e(View view) {
        int a = this.f3325a.mo5485a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f3326b.mo5964c(a)) {
            this.f3326b.mo5963b(a);
            m4148h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo5958f(View view) {
        int a = this.f3325a.mo5485a(view);
        if (a == -1) {
            m4148h(view);
            return true;
        } else if (!this.f3326b.mo5964c(a)) {
            return false;
        } else {
            this.f3326b.mo5965d(a);
            m4148h(view);
            this.f3325a.mo5486a(a);
            return true;
        }
    }

    public String toString() {
        return this.f3326b.toString() + ", hidden list:" + this.f3327c.size();
    }
}
