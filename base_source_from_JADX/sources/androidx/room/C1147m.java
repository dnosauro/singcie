package androidx.room;

import androidx.p046i.p047a.C0821f;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.room.m */
public abstract class C1147m {

    /* renamed from: a */
    private final AtomicBoolean f3609a = new AtomicBoolean(false);

    /* renamed from: b */
    private final C1138i f3610b;

    /* renamed from: c */
    private volatile C0821f f3611c;

    public C1147m(C1138i iVar) {
        this.f3610b = iVar;
    }

    /* renamed from: a */
    private C0821f m4518a(boolean z) {
        if (!z) {
            return m4519d();
        }
        if (this.f3611c == null) {
            this.f3611c = m4519d();
        }
        return this.f3611c;
    }

    /* renamed from: d */
    private C0821f m4519d() {
        return this.f3610b.mo6156a(mo6192a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo6192a();

    /* renamed from: a */
    public void mo6193a(C0821f fVar) {
        if (fVar == this.f3611c) {
            this.f3609a.set(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6194b() {
        this.f3610b.mo6164e();
    }

    /* renamed from: c */
    public C0821f mo6195c() {
        mo6194b();
        return m4518a(this.f3609a.compareAndSet(false, true));
    }
}
