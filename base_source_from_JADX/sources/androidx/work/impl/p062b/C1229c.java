package androidx.work.impl.p062b;

import android.database.Cursor;
import androidx.p046i.p047a.C0821f;
import androidx.room.C1108b;
import androidx.room.C1138i;
import androidx.room.C1146l;
import androidx.room.p057b.C1110b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.work.impl.b.c */
public final class C1229c implements C1228b {

    /* renamed from: a */
    private final C1138i f3820a;

    /* renamed from: b */
    private final C1108b f3821b;

    public C1229c(C1138i iVar) {
        this.f3820a = iVar;
        this.f3821b = new C1108b<C1227a>(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "INSERT OR IGNORE INTO `Dependency`(`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            /* renamed from: a */
            public void mo6107a(C0821f fVar, C1227a aVar) {
                if (aVar.f3818a == null) {
                    fVar.mo4637a(1);
                } else {
                    fVar.mo4640a(1, aVar.f3818a);
                }
                if (aVar.f3819b == null) {
                    fVar.mo4637a(2);
                } else {
                    fVar.mo4640a(2, aVar.f3819b);
                }
            }
        };
    }

    /* renamed from: a */
    public void mo6485a(C1227a aVar) {
        this.f3820a.mo6165f();
        this.f3820a.mo6166g();
        try {
            this.f3821b.mo6108a(aVar);
            this.f3820a.mo6169j();
        } finally {
            this.f3820a.mo6167h();
        }
    }

    /* renamed from: a */
    public boolean mo6486a(String str) {
        C1146l a = C1146l.m4507a("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3820a.mo6165f();
        boolean z = false;
        Cursor a2 = C1110b.m4409a(this.f3820a, a, false);
        try {
            if (a2.moveToFirst() && a2.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            a2.close();
            a.mo6189a();
        }
    }

    /* renamed from: b */
    public List<String> mo6487b(String str) {
        C1146l a = C1146l.m4507a("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3820a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3820a, a, false);
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

    /* renamed from: c */
    public boolean mo6488c(String str) {
        C1146l a = C1146l.m4507a("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3820a.mo6165f();
        boolean z = false;
        Cursor a2 = C1110b.m4409a(this.f3820a, a, false);
        try {
            if (a2.moveToFirst() && a2.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            a2.close();
            a.mo6189a();
        }
    }
}
