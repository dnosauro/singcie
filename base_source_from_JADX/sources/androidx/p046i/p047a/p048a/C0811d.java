package androidx.p046i.p047a.p048a;

import android.database.sqlite.SQLiteProgram;
import androidx.p046i.p047a.C0819d;

/* renamed from: androidx.i.a.a.d */
class C0811d implements C0819d {

    /* renamed from: a */
    private final SQLiteProgram f2766a;

    C0811d(SQLiteProgram sQLiteProgram) {
        this.f2766a = sQLiteProgram;
    }

    /* renamed from: a */
    public void mo4637a(int i) {
        this.f2766a.bindNull(i);
    }

    /* renamed from: a */
    public void mo4638a(int i, double d) {
        this.f2766a.bindDouble(i, d);
    }

    /* renamed from: a */
    public void mo4639a(int i, long j) {
        this.f2766a.bindLong(i, j);
    }

    /* renamed from: a */
    public void mo4640a(int i, String str) {
        this.f2766a.bindString(i, str);
    }

    /* renamed from: a */
    public void mo4641a(int i, byte[] bArr) {
        this.f2766a.bindBlob(i, bArr);
    }

    public void close() {
        this.f2766a.close();
    }
}
