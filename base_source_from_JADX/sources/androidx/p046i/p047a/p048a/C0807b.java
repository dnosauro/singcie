package androidx.p046i.p047a.p048a;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.p046i.p047a.C0813b;
import androidx.p046i.p047a.C0814c;

/* renamed from: androidx.i.a.a.b */
class C0807b implements C0814c {

    /* renamed from: a */
    private final C0808a f2760a;

    /* renamed from: androidx.i.a.a.b$a */
    static class C0808a extends SQLiteOpenHelper {

        /* renamed from: a */
        final C0805a[] f2761a;

        /* renamed from: b */
        final C0814c.C0815a f2762b;

        /* renamed from: c */
        private boolean f2763c;

        C0808a(Context context, String str, final C0805a[] aVarArr, final C0814c.C0815a aVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, aVar.f2768a, new DatabaseErrorHandler() {
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    C0814c.C0815a.this.mo4650d(C0808a.m3351a(aVarArr, sQLiteDatabase));
                }
            });
            this.f2762b = aVar;
            this.f2761a = aVarArr;
        }

        /* renamed from: a */
        static C0805a m3351a(C0805a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            C0805a aVar = aVarArr[0];
            if (aVar == null || !aVar.mo4614a(sQLiteDatabase)) {
                aVarArr[0] = new C0805a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0805a mo4627a(SQLiteDatabase sQLiteDatabase) {
            return m3351a(this.f2761a, sQLiteDatabase);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized C0813b mo4628a() {
            this.f2763c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f2763c) {
                close();
                return mo4628a();
            }
            return mo4627a(writableDatabase);
        }

        public synchronized void close() {
            super.close();
            this.f2761a[0] = null;
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f2762b.mo4645a((C0813b) mo4627a(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f2762b.mo4647b(mo4627a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f2763c = true;
            this.f2762b.mo4648b(mo4627a(sQLiteDatabase), i, i2);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f2763c) {
                this.f2762b.mo4649c(mo4627a(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f2763c = true;
            this.f2762b.mo4646a(mo4627a(sQLiteDatabase), i, i2);
        }
    }

    C0807b(Context context, String str, C0814c.C0815a aVar) {
        this.f2760a = m3348a(context, str, aVar);
    }

    /* renamed from: a */
    private C0808a m3348a(Context context, String str, C0814c.C0815a aVar) {
        return new C0808a(context, str, new C0805a[1], aVar);
    }

    /* renamed from: a */
    public C0813b mo4625a() {
        return this.f2760a.mo4628a();
    }

    /* renamed from: a */
    public void mo4626a(boolean z) {
        this.f2760a.setWriteAheadLoggingEnabled(z);
    }
}
