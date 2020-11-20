package androidx.work.impl.p062b;

import android.database.Cursor;
import androidx.p046i.p047a.C0821f;
import androidx.room.C1108b;
import androidx.room.C1138i;
import androidx.room.C1146l;
import androidx.room.p057b.C1110b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.work.impl.b.o */
public final class C1256o implements C1255n {

    /* renamed from: a */
    private final C1138i f3876a;

    /* renamed from: b */
    private final C1108b f3877b;

    public C1256o(C1138i iVar) {
        this.f3876a = iVar;
        this.f3877b = new C1108b<C1254m>(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "INSERT OR IGNORE INTO `WorkTag`(`tag`,`work_spec_id`) VALUES (?,?)";
            }

            /* renamed from: a */
            public void mo6107a(C0821f fVar, C1254m mVar) {
                if (mVar.f3874a == null) {
                    fVar.mo4637a(1);
                } else {
                    fVar.mo4640a(1, mVar.f3874a);
                }
                if (mVar.f3875b == null) {
                    fVar.mo4637a(2);
                } else {
                    fVar.mo4640a(2, mVar.f3875b);
                }
            }
        };
    }

    /* renamed from: a */
    public List<String> mo6527a(String str) {
        C1146l a = C1146l.m4507a("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3876a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3876a, a, false);
        try {
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                arrayList.add(a2.getString(0));
            }
            return arrayList;
        } finally {
            a2.close();
            a.mo6189a();
        }
    }

    /* renamed from: a */
    public void mo6528a(C1254m mVar) {
        this.f3876a.mo6165f();
        this.f3876a.mo6166g();
        try {
            this.f3877b.mo6108a(mVar);
            this.f3876a.mo6169j();
        } finally {
            this.f3876a.mo6167h();
        }
    }
}
