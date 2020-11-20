package androidx.room;

import androidx.p046i.p047a.C0821f;

/* renamed from: androidx.room.b */
public abstract class C1108b<T> extends C1147m {
    public C1108b(C1138i iVar) {
        super(iVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6107a(C0821f fVar, T t);

    /* renamed from: a */
    public final void mo6108a(T t) {
        C0821f c = mo6195c();
        try {
            mo6107a(c, t);
            c.mo4644b();
        } finally {
            mo6193a(c);
        }
    }
}
