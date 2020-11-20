package androidx.work;

import android.os.Build;

/* renamed from: androidx.work.c */
public final class C1188c {

    /* renamed from: a */
    public static final C1188c f3732a = new C1189a().mo6397a();

    /* renamed from: b */
    private C1198i f3733b = C1198i.NOT_REQUIRED;

    /* renamed from: c */
    private boolean f3734c;

    /* renamed from: d */
    private boolean f3735d;

    /* renamed from: e */
    private boolean f3736e;

    /* renamed from: f */
    private boolean f3737f;

    /* renamed from: g */
    private long f3738g = -1;

    /* renamed from: h */
    private long f3739h = -1;

    /* renamed from: i */
    private C1190d f3740i = new C1190d();

    /* renamed from: androidx.work.c$a */
    public static final class C1189a {

        /* renamed from: a */
        boolean f3741a = false;

        /* renamed from: b */
        boolean f3742b = false;

        /* renamed from: c */
        C1198i f3743c = C1198i.NOT_REQUIRED;

        /* renamed from: d */
        boolean f3744d = false;

        /* renamed from: e */
        boolean f3745e = false;

        /* renamed from: f */
        long f3746f = -1;

        /* renamed from: g */
        long f3747g = -1;

        /* renamed from: h */
        C1190d f3748h = new C1190d();

        /* renamed from: a */
        public C1189a mo6396a(C1198i iVar) {
            this.f3743c = iVar;
            return this;
        }

        /* renamed from: a */
        public C1188c mo6397a() {
            return new C1188c(this);
        }
    }

    public C1188c() {
    }

    C1188c(C1189a aVar) {
        this.f3734c = aVar.f3741a;
        this.f3735d = Build.VERSION.SDK_INT >= 23 && aVar.f3742b;
        this.f3733b = aVar.f3743c;
        this.f3736e = aVar.f3744d;
        this.f3737f = aVar.f3745e;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f3740i = aVar.f3748h;
            this.f3738g = aVar.f3746f;
            this.f3739h = aVar.f3747g;
        }
    }

    public C1188c(C1188c cVar) {
        this.f3734c = cVar.f3734c;
        this.f3735d = cVar.f3735d;
        this.f3733b = cVar.f3733b;
        this.f3736e = cVar.f3736e;
        this.f3737f = cVar.f3737f;
        this.f3740i = cVar.f3740i;
    }

    /* renamed from: a */
    public C1198i mo6377a() {
        return this.f3733b;
    }

    /* renamed from: a */
    public void mo6378a(long j) {
        this.f3738g = j;
    }

    /* renamed from: a */
    public void mo6379a(C1190d dVar) {
        this.f3740i = dVar;
    }

    /* renamed from: a */
    public void mo6380a(C1198i iVar) {
        this.f3733b = iVar;
    }

    /* renamed from: a */
    public void mo6381a(boolean z) {
        this.f3734c = z;
    }

    /* renamed from: b */
    public void mo6382b(long j) {
        this.f3739h = j;
    }

    /* renamed from: b */
    public void mo6383b(boolean z) {
        this.f3735d = z;
    }

    /* renamed from: b */
    public boolean mo6384b() {
        return this.f3734c;
    }

    /* renamed from: c */
    public void mo6385c(boolean z) {
        this.f3736e = z;
    }

    /* renamed from: c */
    public boolean mo6386c() {
        return this.f3735d;
    }

    /* renamed from: d */
    public void mo6387d(boolean z) {
        this.f3737f = z;
    }

    /* renamed from: d */
    public boolean mo6388d() {
        return this.f3736e;
    }

    /* renamed from: e */
    public boolean mo6389e() {
        return this.f3737f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1188c cVar = (C1188c) obj;
        if (this.f3734c == cVar.f3734c && this.f3735d == cVar.f3735d && this.f3736e == cVar.f3736e && this.f3737f == cVar.f3737f && this.f3738g == cVar.f3738g && this.f3739h == cVar.f3739h && this.f3733b == cVar.f3733b) {
            return this.f3740i.equals(cVar.f3740i);
        }
        return false;
    }

    /* renamed from: f */
    public long mo6391f() {
        return this.f3738g;
    }

    /* renamed from: g */
    public long mo6392g() {
        return this.f3739h;
    }

    /* renamed from: h */
    public C1190d mo6393h() {
        return this.f3740i;
    }

    public int hashCode() {
        long j = this.f3738g;
        long j2 = this.f3739h;
        return (((((((((((((this.f3733b.hashCode() * 31) + (this.f3734c ? 1 : 0)) * 31) + (this.f3735d ? 1 : 0)) * 31) + (this.f3736e ? 1 : 0)) * 31) + (this.f3737f ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f3740i.hashCode();
    }

    /* renamed from: i */
    public boolean mo6395i() {
        return this.f3740i.mo6400b() > 0;
    }
}
