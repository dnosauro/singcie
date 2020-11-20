package androidx.work.impl.p062b;

import androidx.p046i.p047a.C0821f;
import androidx.room.C1108b;
import androidx.room.C1138i;

/* renamed from: androidx.work.impl.b.i */
public final class C1238i implements C1237h {

    /* renamed from: a */
    private final C1138i f3832a;

    /* renamed from: b */
    private final C1108b f3833b;

    public C1238i(C1138i iVar) {
        this.f3832a = iVar;
        this.f3833b = new C1108b<C1236g>(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "INSERT OR IGNORE INTO `WorkName`(`name`,`work_spec_id`) VALUES (?,?)";
            }

            /* renamed from: a */
            public void mo6107a(C0821f fVar, C1236g gVar) {
                if (gVar.f3830a == null) {
                    fVar.mo4637a(1);
                } else {
                    fVar.mo4640a(1, gVar.f3830a);
                }
                if (gVar.f3831b == null) {
                    fVar.mo4637a(2);
                } else {
                    fVar.mo4640a(2, gVar.f3831b);
                }
            }
        };
    }

    /* renamed from: a */
    public void mo6496a(C1236g gVar) {
        this.f3832a.mo6165f();
        this.f3832a.mo6166g();
        try {
            this.f3833b.mo6108a(gVar);
            this.f3832a.mo6169j();
        } finally {
            this.f3832a.mo6167h();
        }
    }
}
