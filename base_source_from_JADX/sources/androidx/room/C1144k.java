package androidx.room;

import android.database.Cursor;
import androidx.p046i.p047a.C0804a;
import androidx.p046i.p047a.C0813b;
import androidx.p046i.p047a.C0814c;
import androidx.p046i.p047a.C0820e;
import androidx.room.p056a.C1107a;
import java.util.List;

/* renamed from: androidx.room.k */
public class C1144k extends C0814c.C0815a {

    /* renamed from: b */
    private C1106a f3595b;

    /* renamed from: c */
    private final C1145a f3596c;

    /* renamed from: d */
    private final String f3597d;

    /* renamed from: e */
    private final String f3598e;

    /* renamed from: androidx.room.k$a */
    public static abstract class C1145a {

        /* renamed from: a */
        public final int f3599a;

        public C1145a(int i) {
            this.f3599a = i;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo6182a(C0813b bVar);

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract void mo6183b(C0813b bVar);

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public abstract void mo6184c(C0813b bVar);

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public abstract void mo6185d(C0813b bVar);

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public abstract void mo6186e(C0813b bVar);

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public void mo6187f(C0813b bVar) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public void mo6188g(C0813b bVar) {
        }
    }

    public C1144k(C1106a aVar, C1145a aVar2, String str, String str2) {
        super(aVar2.f3599a);
        this.f3595b = aVar;
        this.f3596c = aVar2;
        this.f3597d = str;
        this.f3598e = str2;
    }

    /* renamed from: e */
    private void m4491e(C0813b bVar) {
        String str = null;
        if (m4494h(bVar)) {
            Cursor a = bVar.mo4611a((C0820e) new C0804a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (a.moveToFirst()) {
                    str = a.getString(0);
                }
            } finally {
                a.close();
            }
        }
        if (!this.f3597d.equals(str) && !this.f3598e.equals(str)) {
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
        }
    }

    /* renamed from: f */
    private void m4492f(C0813b bVar) {
        m4493g(bVar);
        bVar.mo4618c(C1143j.m4490a(this.f3597d));
    }

    /* renamed from: g */
    private void m4493g(C0813b bVar) {
        bVar.mo4618c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    /* renamed from: h */
    private static boolean m4494h(C0813b bVar) {
        Cursor b = bVar.mo4615b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (b.moveToFirst() && b.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            b.close();
        }
    }

    /* renamed from: a */
    public void mo4645a(C0813b bVar) {
        super.mo4645a(bVar);
    }

    /* renamed from: a */
    public void mo4646a(C0813b bVar, int i, int i2) {
        boolean z;
        List<C1107a> a;
        C1106a aVar = this.f3595b;
        if (aVar == null || (a = aVar.f3481d.mo6180a(i, i2)) == null) {
            z = false;
        } else {
            this.f3596c.mo6187f(bVar);
            for (C1107a a2 : a) {
                a2.mo6106a(bVar);
            }
            this.f3596c.mo6186e(bVar);
            this.f3596c.mo6188g(bVar);
            m4492f(bVar);
            z = true;
        }
        if (!z) {
            C1106a aVar2 = this.f3595b;
            if (aVar2 == null || aVar2.mo6105a(i, i2)) {
                throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.f3596c.mo6182a(bVar);
            this.f3596c.mo6183b(bVar);
        }
    }

    /* renamed from: b */
    public void mo4647b(C0813b bVar) {
        m4492f(bVar);
        this.f3596c.mo6183b(bVar);
        this.f3596c.mo6185d(bVar);
    }

    /* renamed from: b */
    public void mo4648b(C0813b bVar, int i, int i2) {
        mo4646a(bVar, i, i2);
    }

    /* renamed from: c */
    public void mo4649c(C0813b bVar) {
        super.mo4649c(bVar);
        m4491e(bVar);
        this.f3596c.mo6184c(bVar);
        this.f3595b = null;
    }
}
