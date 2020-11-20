package androidx.work.impl.p062b;

import android.database.Cursor;
import androidx.p046i.p047a.C0821f;
import androidx.room.C1108b;
import androidx.room.C1138i;
import androidx.room.C1146l;
import androidx.room.C1147m;
import androidx.room.p057b.C1109a;
import androidx.room.p057b.C1110b;
import androidx.room.p057b.C1111c;
import androidx.work.C1188c;
import androidx.work.C1192e;
import androidx.work.C1335n;
import androidx.work.impl.p062b.C1240j;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.work.impl.b.l */
public final class C1244l implements C1243k {

    /* renamed from: a */
    private final C1138i f3855a;

    /* renamed from: b */
    private final C1108b f3856b;

    /* renamed from: c */
    private final C1147m f3857c;

    /* renamed from: d */
    private final C1147m f3858d;

    /* renamed from: e */
    private final C1147m f3859e;

    /* renamed from: f */
    private final C1147m f3860f;

    /* renamed from: g */
    private final C1147m f3861g;

    /* renamed from: h */
    private final C1147m f3862h;

    /* renamed from: i */
    private final C1147m f3863i;

    /* renamed from: j */
    private final C1147m f3864j;

    public C1244l(C1138i iVar) {
        this.f3855a = iVar;
        this.f3856b = new C1108b<C1240j>(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "INSERT OR IGNORE INTO `WorkSpec`(`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: a */
            public void mo6107a(C0821f fVar, C1240j jVar) {
                if (jVar.f3837a == null) {
                    fVar.mo4637a(1);
                } else {
                    fVar.mo4640a(1, jVar.f3837a);
                }
                fVar.mo4639a(2, (long) C1258p.m4949a(jVar.f3838b));
                if (jVar.f3839c == null) {
                    fVar.mo4637a(3);
                } else {
                    fVar.mo4640a(3, jVar.f3839c);
                }
                if (jVar.f3840d == null) {
                    fVar.mo4637a(4);
                } else {
                    fVar.mo4640a(4, jVar.f3840d);
                }
                byte[] a = C1192e.m4719a(jVar.f3841e);
                if (a == null) {
                    fVar.mo4637a(5);
                } else {
                    fVar.mo4641a(5, a);
                }
                byte[] a2 = C1192e.m4719a(jVar.f3842f);
                if (a2 == null) {
                    fVar.mo4637a(6);
                } else {
                    fVar.mo4641a(6, a2);
                }
                fVar.mo4639a(7, jVar.f3843g);
                fVar.mo4639a(8, jVar.f3844h);
                fVar.mo4639a(9, jVar.f3845i);
                fVar.mo4639a(10, (long) jVar.f3847k);
                fVar.mo4639a(11, (long) C1258p.m4947a(jVar.f3848l));
                fVar.mo4639a(12, jVar.f3849m);
                fVar.mo4639a(13, jVar.f3850n);
                fVar.mo4639a(14, jVar.f3851o);
                fVar.mo4639a(15, jVar.f3852p);
                C1188c cVar = jVar.f3846j;
                if (cVar != null) {
                    fVar.mo4639a(16, (long) C1258p.m4948a(cVar.mo6377a()));
                    fVar.mo4639a(17, cVar.mo6384b() ? 1 : 0);
                    fVar.mo4639a(18, cVar.mo6386c() ? 1 : 0);
                    fVar.mo4639a(19, cVar.mo6388d() ? 1 : 0);
                    fVar.mo4639a(20, cVar.mo6389e() ? 1 : 0);
                    fVar.mo4639a(21, cVar.mo6391f());
                    fVar.mo4639a(22, cVar.mo6392g());
                    byte[] a3 = C1258p.m4952a(cVar.mo6393h());
                    if (a3 != null) {
                        fVar.mo4641a(23, a3);
                        return;
                    }
                } else {
                    fVar.mo4637a(16);
                    fVar.mo4637a(17);
                    fVar.mo4637a(18);
                    fVar.mo4637a(19);
                    fVar.mo4637a(20);
                    fVar.mo4637a(21);
                    fVar.mo4637a(22);
                }
                fVar.mo4637a(23);
            }
        };
        this.f3857c = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.f3858d = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.f3859e = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.f3860f = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.f3861g = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.f3862h = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.f3863i = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.f3864j = new C1147m(iVar) {
            /* renamed from: a */
            public String mo6192a() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    /* renamed from: a */
    public int mo6507a(C1335n.C1336a aVar, String... strArr) {
        this.f3855a.mo6165f();
        StringBuilder a = C1111c.m4411a();
        a.append("UPDATE workspec SET state=");
        a.append("?");
        a.append(" WHERE id IN (");
        C1111c.m4412a(a, strArr.length);
        a.append(")");
        C0821f a2 = this.f3855a.mo6156a(a.toString());
        a2.mo4639a(1, (long) C1258p.m4949a(aVar));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                a2.mo4637a(i);
            } else {
                a2.mo4640a(i, str);
            }
            i++;
        }
        this.f3855a.mo6166g();
        try {
            int a3 = a2.mo4643a();
            this.f3855a.mo6169j();
            return a3;
        } finally {
            this.f3855a.mo6167h();
        }
    }

    /* renamed from: a */
    public List<String> mo6508a() {
        C1146l a = C1146l.m4507a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
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
    public List<C1240j> mo6509a(int i) {
        C1146l lVar;
        C1146l a = C1146l.m4507a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        a.mo4639a(1, (long) i);
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
        try {
            int a3 = C1109a.m4407a(a2, "id");
            int a4 = C1109a.m4407a(a2, "state");
            int a5 = C1109a.m4407a(a2, "worker_class_name");
            int a6 = C1109a.m4407a(a2, "input_merger_class_name");
            int a7 = C1109a.m4407a(a2, "input");
            int a8 = C1109a.m4407a(a2, "output");
            int a9 = C1109a.m4407a(a2, "initial_delay");
            int a10 = C1109a.m4407a(a2, "interval_duration");
            int a11 = C1109a.m4407a(a2, "flex_duration");
            int a12 = C1109a.m4407a(a2, "run_attempt_count");
            int a13 = C1109a.m4407a(a2, "backoff_policy");
            int a14 = C1109a.m4407a(a2, "backoff_delay_duration");
            int a15 = C1109a.m4407a(a2, "period_start_time");
            int a16 = C1109a.m4407a(a2, "minimum_retention_duration");
            lVar = a;
            try {
                int a17 = C1109a.m4407a(a2, "schedule_requested_at");
                int a18 = C1109a.m4407a(a2, "required_network_type");
                int i2 = a16;
                int a19 = C1109a.m4407a(a2, "requires_charging");
                int i3 = a15;
                int a20 = C1109a.m4407a(a2, "requires_device_idle");
                int i4 = a14;
                int a21 = C1109a.m4407a(a2, "requires_battery_not_low");
                int i5 = a13;
                int a22 = C1109a.m4407a(a2, "requires_storage_not_low");
                int i6 = a12;
                int a23 = C1109a.m4407a(a2, "trigger_content_update_delay");
                int i7 = a11;
                int a24 = C1109a.m4407a(a2, "trigger_max_content_delay");
                int i8 = a10;
                int a25 = C1109a.m4407a(a2, "content_uri_triggers");
                int i9 = a9;
                int i10 = a8;
                ArrayList arrayList = new ArrayList(a2.getCount());
                while (a2.moveToNext()) {
                    String string = a2.getString(a3);
                    int i11 = a3;
                    String string2 = a2.getString(a5);
                    int i12 = a5;
                    C1188c cVar = new C1188c();
                    int i13 = a18;
                    cVar.mo6380a(C1258p.m4954c(a2.getInt(a18)));
                    cVar.mo6381a(a2.getInt(a19) != 0);
                    cVar.mo6383b(a2.getInt(a20) != 0);
                    cVar.mo6385c(a2.getInt(a21) != 0);
                    cVar.mo6387d(a2.getInt(a22) != 0);
                    int i14 = a19;
                    int i15 = a21;
                    cVar.mo6378a(a2.getLong(a23));
                    cVar.mo6382b(a2.getLong(a24));
                    cVar.mo6379a(C1258p.m4950a(a2.getBlob(a25)));
                    C1240j jVar = new C1240j(string, string2);
                    jVar.f3838b = C1258p.m4951a(a2.getInt(a4));
                    jVar.f3840d = a2.getString(a6);
                    jVar.f3841e = C1192e.m4718a(a2.getBlob(a7));
                    int i16 = i10;
                    jVar.f3842f = C1192e.m4718a(a2.getBlob(i16));
                    int i17 = a20;
                    int i18 = i9;
                    int i19 = i14;
                    jVar.f3843g = a2.getLong(i18);
                    int i20 = a6;
                    int i21 = i8;
                    int i22 = a7;
                    jVar.f3844h = a2.getLong(i21);
                    int i23 = i18;
                    int i24 = i7;
                    int i25 = i21;
                    jVar.f3845i = a2.getLong(i24);
                    int i26 = i6;
                    jVar.f3847k = a2.getInt(i26);
                    int i27 = i5;
                    i10 = i16;
                    jVar.f3848l = C1258p.m4953b(a2.getInt(i27));
                    i6 = i26;
                    i5 = i27;
                    int i28 = i4;
                    jVar.f3849m = a2.getLong(i28);
                    int i29 = i3;
                    int i30 = i20;
                    jVar.f3850n = a2.getLong(i29);
                    int i31 = i24;
                    int i32 = i2;
                    int i33 = i23;
                    jVar.f3851o = a2.getLong(i32);
                    int i34 = i29;
                    int i35 = a17;
                    int i36 = i32;
                    jVar.f3852p = a2.getLong(i35);
                    jVar.f3846j = cVar;
                    arrayList.add(jVar);
                    i4 = i28;
                    a19 = i19;
                    a3 = i11;
                    a5 = i12;
                    a21 = i15;
                    a18 = i13;
                    i9 = i33;
                    i2 = i36;
                    a17 = i35;
                    a6 = i30;
                    i3 = i34;
                    a7 = i22;
                    i8 = i25;
                    i7 = i31;
                    a20 = i17;
                }
                a2.close();
                lVar.mo6189a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a2.close();
                lVar.mo6189a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = a;
            a2.close();
            lVar.mo6189a();
            throw th;
        }
    }

    /* renamed from: a */
    public void mo6510a(C1240j jVar) {
        this.f3855a.mo6165f();
        this.f3855a.mo6166g();
        try {
            this.f3856b.mo6108a(jVar);
            this.f3855a.mo6169j();
        } finally {
            this.f3855a.mo6167h();
        }
    }

    /* renamed from: a */
    public void mo6511a(String str) {
        this.f3855a.mo6165f();
        C0821f c = this.f3857c.mo6195c();
        if (str == null) {
            c.mo4637a(1);
        } else {
            c.mo4640a(1, str);
        }
        this.f3855a.mo6166g();
        try {
            c.mo4643a();
            this.f3855a.mo6169j();
        } finally {
            this.f3855a.mo6167h();
            this.f3857c.mo6193a(c);
        }
    }

    /* renamed from: a */
    public void mo6512a(String str, long j) {
        this.f3855a.mo6165f();
        C0821f c = this.f3859e.mo6195c();
        c.mo4639a(1, j);
        if (str == null) {
            c.mo4637a(2);
        } else {
            c.mo4640a(2, str);
        }
        this.f3855a.mo6166g();
        try {
            c.mo4643a();
            this.f3855a.mo6169j();
        } finally {
            this.f3855a.mo6167h();
            this.f3859e.mo6193a(c);
        }
    }

    /* renamed from: a */
    public void mo6513a(String str, C1192e eVar) {
        this.f3855a.mo6165f();
        C0821f c = this.f3858d.mo6195c();
        byte[] a = C1192e.m4719a(eVar);
        if (a == null) {
            c.mo4637a(1);
        } else {
            c.mo4641a(1, a);
        }
        if (str == null) {
            c.mo4637a(2);
        } else {
            c.mo4640a(2, str);
        }
        this.f3855a.mo6166g();
        try {
            c.mo4643a();
            this.f3855a.mo6169j();
        } finally {
            this.f3855a.mo6167h();
            this.f3858d.mo6193a(c);
        }
    }

    /* renamed from: b */
    public int mo6514b() {
        this.f3855a.mo6165f();
        C0821f c = this.f3863i.mo6195c();
        this.f3855a.mo6166g();
        try {
            int a = c.mo4643a();
            this.f3855a.mo6169j();
            return a;
        } finally {
            this.f3855a.mo6167h();
            this.f3863i.mo6193a(c);
        }
    }

    /* renamed from: b */
    public int mo6515b(String str, long j) {
        this.f3855a.mo6165f();
        C0821f c = this.f3862h.mo6195c();
        c.mo4639a(1, j);
        if (str == null) {
            c.mo4637a(2);
        } else {
            c.mo4640a(2, str);
        }
        this.f3855a.mo6166g();
        try {
            int a = c.mo4643a();
            this.f3855a.mo6169j();
            return a;
        } finally {
            this.f3855a.mo6167h();
            this.f3862h.mo6193a(c);
        }
    }

    /* renamed from: b */
    public C1240j mo6516b(String str) {
        C1146l lVar;
        C1240j jVar;
        String str2 = str;
        C1146l a = C1146l.m4507a("SELECT * FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str2);
        }
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
        try {
            int a3 = C1109a.m4407a(a2, "id");
            int a4 = C1109a.m4407a(a2, "state");
            int a5 = C1109a.m4407a(a2, "worker_class_name");
            int a6 = C1109a.m4407a(a2, "input_merger_class_name");
            int a7 = C1109a.m4407a(a2, "input");
            int a8 = C1109a.m4407a(a2, "output");
            int a9 = C1109a.m4407a(a2, "initial_delay");
            int a10 = C1109a.m4407a(a2, "interval_duration");
            int a11 = C1109a.m4407a(a2, "flex_duration");
            int a12 = C1109a.m4407a(a2, "run_attempt_count");
            int a13 = C1109a.m4407a(a2, "backoff_policy");
            int a14 = C1109a.m4407a(a2, "backoff_delay_duration");
            int a15 = C1109a.m4407a(a2, "period_start_time");
            int a16 = C1109a.m4407a(a2, "minimum_retention_duration");
            lVar = a;
            try {
                int a17 = C1109a.m4407a(a2, "schedule_requested_at");
                int a18 = C1109a.m4407a(a2, "required_network_type");
                int i = a16;
                int a19 = C1109a.m4407a(a2, "requires_charging");
                int i2 = a15;
                int a20 = C1109a.m4407a(a2, "requires_device_idle");
                int i3 = a14;
                int a21 = C1109a.m4407a(a2, "requires_battery_not_low");
                int i4 = a13;
                int a22 = C1109a.m4407a(a2, "requires_storage_not_low");
                int i5 = a12;
                int a23 = C1109a.m4407a(a2, "trigger_content_update_delay");
                int i6 = a11;
                int a24 = C1109a.m4407a(a2, "trigger_max_content_delay");
                int i7 = a10;
                int a25 = C1109a.m4407a(a2, "content_uri_triggers");
                if (a2.moveToFirst()) {
                    String string = a2.getString(a3);
                    String string2 = a2.getString(a5);
                    int i8 = a9;
                    C1188c cVar = new C1188c();
                    cVar.mo6380a(C1258p.m4954c(a2.getInt(a18)));
                    cVar.mo6381a(a2.getInt(a19) != 0);
                    cVar.mo6383b(a2.getInt(a20) != 0);
                    cVar.mo6385c(a2.getInt(a21) != 0);
                    cVar.mo6387d(a2.getInt(a22) != 0);
                    cVar.mo6378a(a2.getLong(a23));
                    cVar.mo6382b(a2.getLong(a24));
                    cVar.mo6379a(C1258p.m4950a(a2.getBlob(a25)));
                    jVar = new C1240j(string, string2);
                    jVar.f3838b = C1258p.m4951a(a2.getInt(a4));
                    jVar.f3840d = a2.getString(a6);
                    jVar.f3841e = C1192e.m4718a(a2.getBlob(a7));
                    jVar.f3842f = C1192e.m4718a(a2.getBlob(a8));
                    jVar.f3843g = a2.getLong(i8);
                    jVar.f3844h = a2.getLong(i7);
                    jVar.f3845i = a2.getLong(i6);
                    jVar.f3847k = a2.getInt(i5);
                    jVar.f3848l = C1258p.m4953b(a2.getInt(i4));
                    jVar.f3849m = a2.getLong(i3);
                    jVar.f3850n = a2.getLong(i2);
                    jVar.f3851o = a2.getLong(i);
                    jVar.f3852p = a2.getLong(a17);
                    jVar.f3846j = cVar;
                } else {
                    jVar = null;
                }
                a2.close();
                lVar.mo6189a();
                return jVar;
            } catch (Throwable th) {
                th = th;
                a2.close();
                lVar.mo6189a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = a;
            a2.close();
            lVar.mo6189a();
            throw th;
        }
    }

    /* renamed from: c */
    public List<C1240j> mo6517c() {
        C1146l lVar;
        C1146l a = C1146l.m4507a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
        try {
            int a3 = C1109a.m4407a(a2, "id");
            int a4 = C1109a.m4407a(a2, "state");
            int a5 = C1109a.m4407a(a2, "worker_class_name");
            int a6 = C1109a.m4407a(a2, "input_merger_class_name");
            int a7 = C1109a.m4407a(a2, "input");
            int a8 = C1109a.m4407a(a2, "output");
            int a9 = C1109a.m4407a(a2, "initial_delay");
            int a10 = C1109a.m4407a(a2, "interval_duration");
            int a11 = C1109a.m4407a(a2, "flex_duration");
            int a12 = C1109a.m4407a(a2, "run_attempt_count");
            int a13 = C1109a.m4407a(a2, "backoff_policy");
            int a14 = C1109a.m4407a(a2, "backoff_delay_duration");
            int a15 = C1109a.m4407a(a2, "period_start_time");
            int a16 = C1109a.m4407a(a2, "minimum_retention_duration");
            lVar = a;
            try {
                int a17 = C1109a.m4407a(a2, "schedule_requested_at");
                int a18 = C1109a.m4407a(a2, "required_network_type");
                int i = a16;
                int a19 = C1109a.m4407a(a2, "requires_charging");
                int i2 = a15;
                int a20 = C1109a.m4407a(a2, "requires_device_idle");
                int i3 = a14;
                int a21 = C1109a.m4407a(a2, "requires_battery_not_low");
                int i4 = a13;
                int a22 = C1109a.m4407a(a2, "requires_storage_not_low");
                int i5 = a12;
                int a23 = C1109a.m4407a(a2, "trigger_content_update_delay");
                int i6 = a11;
                int a24 = C1109a.m4407a(a2, "trigger_max_content_delay");
                int i7 = a10;
                int a25 = C1109a.m4407a(a2, "content_uri_triggers");
                int i8 = a9;
                int i9 = a8;
                ArrayList arrayList = new ArrayList(a2.getCount());
                while (a2.moveToNext()) {
                    String string = a2.getString(a3);
                    int i10 = a3;
                    String string2 = a2.getString(a5);
                    int i11 = a5;
                    C1188c cVar = new C1188c();
                    int i12 = a18;
                    cVar.mo6380a(C1258p.m4954c(a2.getInt(a18)));
                    cVar.mo6381a(a2.getInt(a19) != 0);
                    cVar.mo6383b(a2.getInt(a20) != 0);
                    cVar.mo6385c(a2.getInt(a21) != 0);
                    cVar.mo6387d(a2.getInt(a22) != 0);
                    int i13 = a19;
                    int i14 = a20;
                    cVar.mo6378a(a2.getLong(a23));
                    cVar.mo6382b(a2.getLong(a24));
                    cVar.mo6379a(C1258p.m4950a(a2.getBlob(a25)));
                    C1240j jVar = new C1240j(string, string2);
                    jVar.f3838b = C1258p.m4951a(a2.getInt(a4));
                    jVar.f3840d = a2.getString(a6);
                    jVar.f3841e = C1192e.m4718a(a2.getBlob(a7));
                    int i15 = i9;
                    jVar.f3842f = C1192e.m4718a(a2.getBlob(i15));
                    int i16 = a6;
                    int i17 = i8;
                    int i18 = a7;
                    jVar.f3843g = a2.getLong(i17);
                    int i19 = i13;
                    int i20 = i7;
                    int i21 = i17;
                    jVar.f3844h = a2.getLong(i20);
                    int i22 = i20;
                    int i23 = i6;
                    int i24 = i19;
                    jVar.f3845i = a2.getLong(i23);
                    int i25 = i5;
                    jVar.f3847k = a2.getInt(i25);
                    int i26 = i4;
                    i9 = i15;
                    jVar.f3848l = C1258p.m4953b(a2.getInt(i26));
                    int i27 = i22;
                    int i28 = i3;
                    int i29 = i23;
                    jVar.f3849m = a2.getLong(i28);
                    i5 = i25;
                    int i30 = i2;
                    jVar.f3850n = a2.getLong(i30);
                    i2 = i30;
                    int i31 = i;
                    jVar.f3851o = a2.getLong(i31);
                    i = i31;
                    int i32 = i26;
                    int i33 = a17;
                    jVar.f3852p = a2.getLong(i33);
                    jVar.f3846j = cVar;
                    arrayList.add(jVar);
                    a17 = i33;
                    a6 = i16;
                    a19 = i24;
                    a7 = i18;
                    a5 = i11;
                    a20 = i14;
                    i6 = i29;
                    i8 = i21;
                    i3 = i28;
                    i7 = i27;
                    a3 = i10;
                    i4 = i32;
                    a18 = i12;
                }
                a2.close();
                lVar.mo6189a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a2.close();
                lVar.mo6189a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = a;
            a2.close();
            lVar.mo6189a();
            throw th;
        }
    }

    /* renamed from: c */
    public List<C1240j.C1242a> mo6518c(String str) {
        C1146l a = C1146l.m4507a("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
        try {
            int a3 = C1109a.m4407a(a2, "id");
            int a4 = C1109a.m4407a(a2, "state");
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                C1240j.C1242a aVar = new C1240j.C1242a();
                aVar.f3853a = a2.getString(a3);
                aVar.f3854b = C1258p.m4951a(a2.getInt(a4));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            a2.close();
            a.mo6189a();
        }
    }

    /* renamed from: d */
    public int mo6519d(String str) {
        this.f3855a.mo6165f();
        C0821f c = this.f3860f.mo6195c();
        if (str == null) {
            c.mo4637a(1);
        } else {
            c.mo4640a(1, str);
        }
        this.f3855a.mo6166g();
        try {
            int a = c.mo4643a();
            this.f3855a.mo6169j();
            return a;
        } finally {
            this.f3855a.mo6167h();
            this.f3860f.mo6193a(c);
        }
    }

    /* renamed from: d */
    public List<C1240j> mo6520d() {
        C1146l lVar;
        C1146l a = C1146l.m4507a("SELECT * FROM workspec WHERE state=1", 0);
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
        try {
            int a3 = C1109a.m4407a(a2, "id");
            int a4 = C1109a.m4407a(a2, "state");
            int a5 = C1109a.m4407a(a2, "worker_class_name");
            int a6 = C1109a.m4407a(a2, "input_merger_class_name");
            int a7 = C1109a.m4407a(a2, "input");
            int a8 = C1109a.m4407a(a2, "output");
            int a9 = C1109a.m4407a(a2, "initial_delay");
            int a10 = C1109a.m4407a(a2, "interval_duration");
            int a11 = C1109a.m4407a(a2, "flex_duration");
            int a12 = C1109a.m4407a(a2, "run_attempt_count");
            int a13 = C1109a.m4407a(a2, "backoff_policy");
            int a14 = C1109a.m4407a(a2, "backoff_delay_duration");
            int a15 = C1109a.m4407a(a2, "period_start_time");
            int a16 = C1109a.m4407a(a2, "minimum_retention_duration");
            lVar = a;
            try {
                int a17 = C1109a.m4407a(a2, "schedule_requested_at");
                int a18 = C1109a.m4407a(a2, "required_network_type");
                int i = a16;
                int a19 = C1109a.m4407a(a2, "requires_charging");
                int i2 = a15;
                int a20 = C1109a.m4407a(a2, "requires_device_idle");
                int i3 = a14;
                int a21 = C1109a.m4407a(a2, "requires_battery_not_low");
                int i4 = a13;
                int a22 = C1109a.m4407a(a2, "requires_storage_not_low");
                int i5 = a12;
                int a23 = C1109a.m4407a(a2, "trigger_content_update_delay");
                int i6 = a11;
                int a24 = C1109a.m4407a(a2, "trigger_max_content_delay");
                int i7 = a10;
                int a25 = C1109a.m4407a(a2, "content_uri_triggers");
                int i8 = a9;
                int i9 = a8;
                ArrayList arrayList = new ArrayList(a2.getCount());
                while (a2.moveToNext()) {
                    String string = a2.getString(a3);
                    int i10 = a3;
                    String string2 = a2.getString(a5);
                    int i11 = a5;
                    C1188c cVar = new C1188c();
                    int i12 = a18;
                    cVar.mo6380a(C1258p.m4954c(a2.getInt(a18)));
                    cVar.mo6381a(a2.getInt(a19) != 0);
                    cVar.mo6383b(a2.getInt(a20) != 0);
                    cVar.mo6385c(a2.getInt(a21) != 0);
                    cVar.mo6387d(a2.getInt(a22) != 0);
                    int i13 = a19;
                    int i14 = a20;
                    cVar.mo6378a(a2.getLong(a23));
                    cVar.mo6382b(a2.getLong(a24));
                    cVar.mo6379a(C1258p.m4950a(a2.getBlob(a25)));
                    C1240j jVar = new C1240j(string, string2);
                    jVar.f3838b = C1258p.m4951a(a2.getInt(a4));
                    jVar.f3840d = a2.getString(a6);
                    jVar.f3841e = C1192e.m4718a(a2.getBlob(a7));
                    int i15 = i9;
                    jVar.f3842f = C1192e.m4718a(a2.getBlob(i15));
                    int i16 = a6;
                    int i17 = i8;
                    int i18 = a7;
                    jVar.f3843g = a2.getLong(i17);
                    int i19 = i13;
                    int i20 = i7;
                    int i21 = i17;
                    jVar.f3844h = a2.getLong(i20);
                    int i22 = i20;
                    int i23 = i6;
                    int i24 = i19;
                    jVar.f3845i = a2.getLong(i23);
                    int i25 = i5;
                    jVar.f3847k = a2.getInt(i25);
                    int i26 = i4;
                    i9 = i15;
                    jVar.f3848l = C1258p.m4953b(a2.getInt(i26));
                    int i27 = i22;
                    int i28 = i3;
                    int i29 = i23;
                    jVar.f3849m = a2.getLong(i28);
                    i5 = i25;
                    int i30 = i2;
                    jVar.f3850n = a2.getLong(i30);
                    i2 = i30;
                    int i31 = i;
                    jVar.f3851o = a2.getLong(i31);
                    i = i31;
                    int i32 = i26;
                    int i33 = a17;
                    jVar.f3852p = a2.getLong(i33);
                    jVar.f3846j = cVar;
                    arrayList.add(jVar);
                    a17 = i33;
                    a6 = i16;
                    a19 = i24;
                    a7 = i18;
                    a5 = i11;
                    a20 = i14;
                    i6 = i29;
                    i8 = i21;
                    i3 = i28;
                    i7 = i27;
                    a3 = i10;
                    i4 = i32;
                    a18 = i12;
                }
                a2.close();
                lVar.mo6189a();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                a2.close();
                lVar.mo6189a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = a;
            a2.close();
            lVar.mo6189a();
            throw th;
        }
    }

    /* renamed from: e */
    public int mo6521e(String str) {
        this.f3855a.mo6165f();
        C0821f c = this.f3861g.mo6195c();
        if (str == null) {
            c.mo4637a(1);
        } else {
            c.mo4640a(1, str);
        }
        this.f3855a.mo6166g();
        try {
            int a = c.mo4643a();
            this.f3855a.mo6169j();
            return a;
        } finally {
            this.f3855a.mo6167h();
            this.f3861g.mo6193a(c);
        }
    }

    /* renamed from: f */
    public C1335n.C1336a mo6522f(String str) {
        C1146l a = C1146l.m4507a("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
        try {
            return a2.moveToFirst() ? C1258p.m4951a(a2.getInt(0)) : null;
        } finally {
            a2.close();
            a.mo6189a();
        }
    }

    /* renamed from: g */
    public List<C1192e> mo6523g(String str) {
        C1146l a = C1146l.m4507a("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
        try {
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                arrayList.add(C1192e.m4718a(a2.getBlob(0)));
            }
            return arrayList;
        } finally {
            a2.close();
            a.mo6189a();
        }
    }

    /* renamed from: h */
    public List<String> mo6524h(String str) {
        C1146l a = C1146l.m4507a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
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

    /* renamed from: i */
    public List<String> mo6525i(String str) {
        C1146l a = C1146l.m4507a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a.mo4637a(1);
        } else {
            a.mo4640a(1, str);
        }
        this.f3855a.mo6165f();
        Cursor a2 = C1110b.m4409a(this.f3855a, a, false);
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
}
