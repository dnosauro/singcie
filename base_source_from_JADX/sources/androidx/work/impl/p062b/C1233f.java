package androidx.work.impl.p062b;

import android.database.Cursor;
import androidx.p046i.p047a.C0821f;
import androidx.room.C1108b;
import androidx.room.C1138i;
import androidx.room.C1146l;
import androidx.room.C1147m;
import androidx.room.p057b.C1109a;
import androidx.room.p057b.C1110b;

/* renamed from: androidx.work.impl.b.f */
public final class C1233f implements C1232e {

    /* renamed from: a */
    private final C1138i f3825a;

    /* renamed from: b */
    private final C1108b f3826b;

    /* renamed from: c */
    private final C1147m f3827c;

    public C1233f(C1138i iVar) {
        this.f3825a = iVar;
        this.f3826b = new C1108b<C1231d>(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "INSERT OR REPLACE INTO `SystemIdInfo`(`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            /* renamed from: a */
            public void mo6107a(C0821f fVar, C1231d dVar) {
                if (dVar.f3823a == null) {
                    fVar.mo4637a(1);
                } else {
                    fVar.mo4640a(1, dVar.f3823a);
                }
                fVar.mo4639a(2, (long) dVar.f3824b);
            }
        };
        this.f3827c = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    /* renamed from: a */
    public C1231d mo6492a(String str) {
        C1146l a = C1146l.m4507a("SELECT * FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3825a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3825a, a, false);
        try {
            return a2.moveToFirst() ? new C1231d(a2.getString(C1109a.m4407a(a2, "work_spec_id")), a2.getInt(C1109a.m4407a(a2, "system_id"))) : null;
        } finally {
            a2.close();
            a.mo6189a();
        }
    }

    /* renamed from: a */
    public void mo6493a(C1231d dVar) {
        this.f3825a.mo6165f();
        this.f3825a.mo6166g();
        try {
            this.f3826b.mo6108a(dVar);
            this.f3825a.mo6169j();
        } finally {
            this.f3825a.mo6167h();
        }
    }

    /* renamed from: b */
    public void mo6494b(String str) {
        this.f3825a.mo6165f();
        C0821f c = this.f3827c.mo6195c();
        if (str == null) {
            c.mo4637a(1);
        } else {
            c.mo4640a(1, str);
        }
        this.f3825a.mo6166g();
        try {
            c.mo4643a();
            this.f3825a.mo6169j();
        } finally {
            this.f3825a.mo6167h();
            this.f3827c.mo6193a(c);
        }
    }
}
