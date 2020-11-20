package androidx.p046i.p047a.p048a;

import android.database.sqlite.SQLiteStatement;
import androidx.p046i.p047a.C0821f;

/* renamed from: androidx.i.a.a.e */
class C0812e extends C0811d implements C0821f {

    /* renamed from: a */
    private final SQLiteStatement f2767a;

    C0812e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f2767a = sQLiteStatement;
    }

    /* renamed from: a */
    public int mo4643a() {
        return this.f2767a.executeUpdateDelete();
    }

    /* renamed from: b */
    public long mo4644b() {
        return this.f2767a.executeInsert();
    }
}
