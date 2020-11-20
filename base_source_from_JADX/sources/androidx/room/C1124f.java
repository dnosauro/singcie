package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.p004a.p005a.p007b.C0044b;
import androidx.p018c.C0400a;
import androidx.p018c.C0402b;
import androidx.p046i.p047a.C0804a;
import androidx.p046i.p047a.C0813b;
import androidx.p046i.p047a.C0820e;
import androidx.p046i.p047a.C0821f;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* renamed from: androidx.room.f */
public class C1124f {

    /* renamed from: h */
    private static final String[] f3519h = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a */
    final C0400a<String, Integer> f3520a;

    /* renamed from: b */
    final String[] f3521b;

    /* renamed from: c */
    final C1138i f3522c;

    /* renamed from: d */
    AtomicBoolean f3523d = new AtomicBoolean(false);

    /* renamed from: e */
    volatile C0821f f3524e;
    @SuppressLint({"RestrictedApi"})

    /* renamed from: f */
    final C0044b<C1127b, C1128c> f3525f = new C0044b<>();

    /* renamed from: g */
    Runnable f3526g = new Runnable() {
        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private Set<Integer> m4445a() {
            C0402b bVar = new C0402b();
            Cursor a = C1124f.this.f3522c.mo6155a((C0820e) new C0804a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (a.moveToNext()) {
                try {
                    bVar.add(Integer.valueOf(a.getInt(0)));
                } catch (Throwable th) {
                    a.close();
                    throw th;
                }
            }
            a.close();
            if (!bVar.isEmpty()) {
                C1124f.this.f3524e.mo4643a();
            }
            return bVar;
        }

        public void run() {
            C0813b a;
            Lock a2 = C1124f.this.f3522c.mo6157a();
            Set<Integer> set = null;
            try {
                a2.lock();
                if (!C1124f.this.mo6135a()) {
                    a2.unlock();
                } else if (!C1124f.this.f3523d.compareAndSet(true, false)) {
                    a2.unlock();
                } else if (C1124f.this.f3522c.mo6170k()) {
                    a2.unlock();
                } else {
                    if (C1124f.this.f3522c.f3565b) {
                        a = C1124f.this.f3522c.mo6160b().mo4625a();
                        a.mo4613a();
                        set = m4445a();
                        a.mo4617c();
                        a.mo4616b();
                    } else {
                        set = m4445a();
                    }
                    a2.unlock();
                    if (set != null && !set.isEmpty()) {
                        synchronized (C1124f.this.f3525f) {
                            Iterator<Map.Entry<C1127b, C1128c>> it = C1124f.this.f3525f.iterator();
                            while (it.hasNext()) {
                                ((C1128c) it.next().getValue()).mo6147a(set);
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e) {
                try {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                } catch (Throwable th) {
                    a2.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                a.mo4616b();
                throw th2;
            }
        }
    };

    /* renamed from: i */
    private Map<String, Set<String>> f3527i;

    /* renamed from: j */
    private volatile boolean f3528j = false;

    /* renamed from: k */
    private C1126a f3529k;

    /* renamed from: l */
    private final C1123e f3530l;

    /* renamed from: m */
    private C1129g f3531m;

    /* renamed from: androidx.room.f$a */
    static class C1126a {

        /* renamed from: a */
        final long[] f3533a;

        /* renamed from: b */
        final boolean[] f3534b;

        /* renamed from: c */
        final int[] f3535c;

        /* renamed from: d */
        boolean f3536d;

        /* renamed from: e */
        boolean f3537e;

        C1126a(int i) {
            this.f3533a = new long[i];
            this.f3534b = new boolean[i];
            this.f3535c = new int[i];
            Arrays.fill(this.f3533a, 0);
            Arrays.fill(this.f3534b, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6141a(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.f3533a[i];
                    this.f3533a[i] = 1 + j;
                    if (j == 0) {
                        this.f3536d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int[] mo6142a() {
            synchronized (this) {
                if (this.f3536d) {
                    if (!this.f3537e) {
                        int length = this.f3533a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.f3533a[i] > 0;
                                if (z != this.f3534b[i]) {
                                    int[] iArr = this.f3535c;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.f3535c[i] = 0;
                                }
                                this.f3534b[i] = z;
                                i++;
                            } else {
                                this.f3537e = true;
                                this.f3536d = false;
                                int[] iArr2 = this.f3535c;
                                return iArr2;
                            }
                        }
                    }
                }
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo6143b() {
            synchronized (this) {
                this.f3537e = false;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo6144b(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.f3533a[i];
                    this.f3533a[i] = j - 1;
                    if (j == 1) {
                        this.f3536d = true;
                        z = true;
                    }
                }
            }
            return z;
        }
    }

    /* renamed from: androidx.room.f$b */
    public static abstract class C1127b {

        /* renamed from: a */
        final String[] f3538a;

        public C1127b(String[] strArr) {
            this.f3538a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        /* renamed from: a */
        public abstract void mo6145a(Set<String> set);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6146a() {
            return false;
        }
    }

    /* renamed from: androidx.room.f$c */
    static class C1128c {

        /* renamed from: a */
        final int[] f3539a;

        /* renamed from: b */
        final C1127b f3540b;

        /* renamed from: c */
        private final String[] f3541c;

        /* renamed from: d */
        private final Set<String> f3542d;

        C1128c(C1127b bVar, int[] iArr, String[] strArr) {
            Set<String> set;
            this.f3540b = bVar;
            this.f3539a = iArr;
            this.f3541c = strArr;
            if (iArr.length == 1) {
                C0402b bVar2 = new C0402b();
                bVar2.add(this.f3541c[0]);
                set = Collections.unmodifiableSet(bVar2);
            } else {
                set = null;
            }
            this.f3542d = set;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6147a(Set<Integer> set) {
            int length = this.f3539a.length;
            Set set2 = null;
            for (int i = 0; i < length; i++) {
                if (set.contains(Integer.valueOf(this.f3539a[i]))) {
                    if (length == 1) {
                        set2 = this.f3542d;
                    } else {
                        if (set2 == null) {
                            set2 = new C0402b(length);
                        }
                        set2.add(this.f3541c[i]);
                    }
                }
            }
            if (set2 != null) {
                this.f3540b.mo6145a(set2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6148a(String[] strArr) {
            Set<String> set = null;
            if (this.f3541c.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (strArr[i].equalsIgnoreCase(this.f3541c[0])) {
                        set = this.f3542d;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                C0402b bVar = new C0402b();
                for (String str : strArr) {
                    String[] strArr2 = this.f3541c;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            bVar.add(str2);
                            break;
                        }
                        i2++;
                    }
                }
                if (bVar.size() > 0) {
                    set = bVar;
                }
            }
            if (set != null) {
                this.f3540b.mo6145a(set);
            }
        }
    }

    public C1124f(C1138i iVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f3522c = iVar;
        this.f3529k = new C1126a(strArr.length);
        this.f3520a = new C0400a<>();
        this.f3527i = map2;
        this.f3530l = new C1123e(this.f3522c);
        int length = strArr.length;
        this.f3521b = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = strArr[i].toLowerCase(Locale.US);
            this.f3520a.put(lowerCase, Integer.valueOf(i));
            String str = map.get(strArr[i]);
            if (str != null) {
                this.f3521b[i] = str.toLowerCase(Locale.US);
            } else {
                this.f3521b[i] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            String lowerCase2 = ((String) next.getValue()).toLowerCase(Locale.US);
            if (this.f3520a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(Locale.US);
                C0400a<String, Integer> aVar = this.f3520a;
                aVar.put(lowerCase3, aVar.get(lowerCase2));
            }
        }
    }

    /* renamed from: a */
    private void m4432a(C0813b bVar, int i) {
        String str = this.f3521b[i];
        StringBuilder sb = new StringBuilder();
        for (String a : f3519h) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            m4433a(sb, str, a);
            bVar.mo4618c(sb.toString());
        }
    }

    /* renamed from: a */
    private static void m4433a(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    /* renamed from: b */
    private void m4434b(C0813b bVar, int i) {
        bVar.mo4618c("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.f3521b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f3519h) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            m4433a(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.mo4618c(sb.toString());
        }
    }

    /* renamed from: b */
    private String[] m4435b(String[] strArr) {
        C0402b bVar = new C0402b();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f3527i.containsKey(lowerCase)) {
                bVar.addAll(this.f3527i.get(lowerCase));
            } else {
                bVar.add(str);
            }
        }
        return (String[]) bVar.toArray(new String[bVar.size()]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6131a(Context context, String str) {
        this.f3531m = new C1129g(context, str, this, this.f3522c.mo6168i());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6132a(C0813b bVar) {
        synchronized (this) {
            if (this.f3528j) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.mo4618c("PRAGMA temp_store = MEMORY;");
            bVar.mo4618c("PRAGMA recursive_triggers='ON';");
            bVar.mo4618c("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            mo6137b(bVar);
            this.f3524e = bVar.mo4612a("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f3528j = true;
        }
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: a */
    public void mo6133a(C1127b bVar) {
        C1128c a;
        String[] b = m4435b(bVar.f3538a);
        int[] iArr = new int[b.length];
        int length = b.length;
        int i = 0;
        while (i < length) {
            Integer num = this.f3520a.get(b[i].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i] = num.intValue();
                i++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + b[i]);
            }
        }
        C1128c cVar = new C1128c(bVar, iArr, b);
        synchronized (this.f3525f) {
            a = this.f3525f.mo630a(bVar, cVar);
        }
        if (a == null && this.f3529k.mo6141a(iArr)) {
            mo6139c();
        }
    }

    /* renamed from: a */
    public void mo6134a(String... strArr) {
        synchronized (this.f3525f) {
            Iterator<Map.Entry<C1127b, C1128c>> it = this.f3525f.iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (!((C1127b) next.getKey()).mo6146a()) {
                    ((C1128c) next.getValue()).mo6148a(strArr);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6135a() {
        if (!this.f3522c.mo6163d()) {
            return false;
        }
        if (!this.f3528j) {
            this.f3522c.mo6160b().mo4625a();
        }
        if (this.f3528j) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* renamed from: b */
    public void mo6136b() {
        if (this.f3523d.compareAndSet(false, true)) {
            this.f3522c.mo6168i().execute(this.f3526g);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6137b(C0813b bVar) {
        if (!bVar.mo4620d()) {
            while (true) {
                try {
                    Lock a = this.f3522c.mo6157a();
                    a.lock();
                    try {
                        int[] a2 = this.f3529k.mo6142a();
                        if (a2 == null) {
                            a.unlock();
                            return;
                        }
                        int length = a2.length;
                        bVar.mo4613a();
                        for (int i = 0; i < length; i++) {
                            switch (a2[i]) {
                                case 1:
                                    m4434b(bVar, i);
                                    break;
                                case 2:
                                    m4432a(bVar, i);
                                    break;
                            }
                        }
                        bVar.mo4617c();
                        bVar.mo4616b();
                        this.f3529k.mo6143b();
                        a.unlock();
                    } catch (Throwable th) {
                        a.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException e) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                    return;
                }
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: b */
    public void mo6138b(C1127b bVar) {
        C1128c b;
        synchronized (this.f3525f) {
            b = this.f3525f.mo631b(bVar);
        }
        if (b != null && this.f3529k.mo6144b(b.f3539a)) {
            mo6139c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6139c() {
        if (this.f3522c.mo6163d()) {
            mo6137b(this.f3522c.mo6160b().mo4625a());
        }
    }
}
