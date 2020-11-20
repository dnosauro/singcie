package androidx.p046i.p047a.p048a;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Pair;
import androidx.p046i.p047a.C0804a;
import androidx.p046i.p047a.C0813b;
import androidx.p046i.p047a.C0820e;
import androidx.p046i.p047a.C0821f;
import java.util.List;

/* renamed from: androidx.i.a.a.a */
class C0805a implements C0813b {

    /* renamed from: a */
    private static final String[] f2755a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b */
    private static final String[] f2756b = new String[0];

    /* renamed from: c */
    private final SQLiteDatabase f2757c;

    C0805a(SQLiteDatabase sQLiteDatabase) {
        this.f2757c = sQLiteDatabase;
    }

    /* renamed from: a */
    public Cursor mo4611a(final C0820e eVar) {
        return this.f2757c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.mo4609a(new C0811d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.mo4610b(), f2756b, (String) null);
    }

    /* renamed from: a */
    public C0821f mo4612a(String str) {
        return new C0812e(this.f2757c.compileStatement(str));
    }

    /* renamed from: a */
    public void mo4613a() {
        this.f2757c.beginTransaction();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4614a(SQLiteDatabase sQLiteDatabase) {
        return this.f2757c == sQLiteDatabase;
    }

    /* renamed from: b */
    public Cursor mo4615b(String str) {
        return mo4611a((C0820e) new C0804a(str));
    }

    /* renamed from: b */
    public void mo4616b() {
        this.f2757c.endTransaction();
    }

    /* renamed from: c */
    public void mo4617c() {
        this.f2757c.setTransactionSuccessful();
    }

    /* renamed from: c */
    public void mo4618c(String str) {
        this.f2757c.execSQL(str);
    }

    public void close() {
        this.f2757c.close();
    }

    /* renamed from: d */
    public boolean mo4620d() {
        return this.f2757c.inTransaction();
    }

    /* renamed from: e */
    public boolean mo4621e() {
        return this.f2757c.isOpen();
    }

    /* renamed from: f */
    public String mo4622f() {
        return this.f2757c.getPath();
    }

    /* renamed from: g */
    public List<Pair<String, String>> mo4623g() {
        return this.f2757c.getAttachedDbs();
    }
}
