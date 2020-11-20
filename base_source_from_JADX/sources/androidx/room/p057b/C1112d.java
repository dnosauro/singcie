package androidx.room.p057b;

import android.database.Cursor;
import android.os.Build;
import androidx.p046i.p047a.C0813b;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: androidx.room.b.d */
public class C1112d {

    /* renamed from: a */
    public final String f3494a;

    /* renamed from: b */
    public final Map<String, C1113a> f3495b;

    /* renamed from: c */
    public final Set<C1114b> f3496c;

    /* renamed from: d */
    public final Set<C1116d> f3497d;

    /* renamed from: androidx.room.b.d$a */
    public static class C1113a {

        /* renamed from: a */
        public final String f3498a;

        /* renamed from: b */
        public final String f3499b;

        /* renamed from: c */
        public final int f3500c;

        /* renamed from: d */
        public final boolean f3501d;

        /* renamed from: e */
        public final int f3502e;

        public C1113a(String str, String str2, boolean z, int i) {
            this.f3498a = str;
            this.f3499b = str2;
            this.f3501d = z;
            this.f3502e = i;
            this.f3500c = m4419a(str2);
        }

        /* renamed from: a */
        private static int m4419a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        /* renamed from: a */
        public boolean mo6112a() {
            return this.f3502e > 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1113a aVar = (C1113a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f3502e != aVar.f3502e) {
                    return false;
                }
            } else if (mo6112a() != aVar.mo6112a()) {
                return false;
            }
            return this.f3498a.equals(aVar.f3498a) && this.f3501d == aVar.f3501d && this.f3500c == aVar.f3500c;
        }

        public int hashCode() {
            return (((((this.f3498a.hashCode() * 31) + this.f3500c) * 31) + (this.f3501d ? 1231 : 1237)) * 31) + this.f3502e;
        }

        public String toString() {
            return "Column{name='" + this.f3498a + '\'' + ", type='" + this.f3499b + '\'' + ", affinity='" + this.f3500c + '\'' + ", notNull=" + this.f3501d + ", primaryKeyPosition=" + this.f3502e + '}';
        }
    }

    /* renamed from: androidx.room.b.d$b */
    public static class C1114b {

        /* renamed from: a */
        public final String f3503a;

        /* renamed from: b */
        public final String f3504b;

        /* renamed from: c */
        public final String f3505c;

        /* renamed from: d */
        public final List<String> f3506d;

        /* renamed from: e */
        public final List<String> f3507e;

        public C1114b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f3503a = str;
            this.f3504b = str2;
            this.f3505c = str3;
            this.f3506d = Collections.unmodifiableList(list);
            this.f3507e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1114b bVar = (C1114b) obj;
            if (this.f3503a.equals(bVar.f3503a) && this.f3504b.equals(bVar.f3504b) && this.f3505c.equals(bVar.f3505c) && this.f3506d.equals(bVar.f3506d)) {
                return this.f3507e.equals(bVar.f3507e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f3503a.hashCode() * 31) + this.f3504b.hashCode()) * 31) + this.f3505c.hashCode()) * 31) + this.f3506d.hashCode()) * 31) + this.f3507e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f3503a + '\'' + ", onDelete='" + this.f3504b + '\'' + ", onUpdate='" + this.f3505c + '\'' + ", columnNames=" + this.f3506d + ", referenceColumnNames=" + this.f3507e + '}';
        }
    }

    /* renamed from: androidx.room.b.d$c */
    static class C1115c implements Comparable<C1115c> {

        /* renamed from: a */
        final int f3508a;

        /* renamed from: b */
        final int f3509b;

        /* renamed from: c */
        final String f3510c;

        /* renamed from: d */
        final String f3511d;

        C1115c(int i, int i2, String str, String str2) {
            this.f3508a = i;
            this.f3509b = i2;
            this.f3510c = str;
            this.f3511d = str2;
        }

        /* renamed from: a */
        public int compareTo(C1115c cVar) {
            int i = this.f3508a - cVar.f3508a;
            return i == 0 ? this.f3509b - cVar.f3509b : i;
        }
    }

    /* renamed from: androidx.room.b.d$d */
    public static class C1116d {

        /* renamed from: a */
        public final String f3512a;

        /* renamed from: b */
        public final boolean f3513b;

        /* renamed from: c */
        public final List<String> f3514c;

        public C1116d(String str, boolean z, List<String> list) {
            this.f3512a = str;
            this.f3513b = z;
            this.f3514c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1116d dVar = (C1116d) obj;
            if (this.f3513b == dVar.f3513b && this.f3514c.equals(dVar.f3514c)) {
                return this.f3512a.startsWith("index_") ? dVar.f3512a.startsWith("index_") : this.f3512a.equals(dVar.f3512a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f3512a.startsWith("index_") ? "index_" : this.f3512a).hashCode() * 31) + (this.f3513b ? 1 : 0)) * 31) + this.f3514c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f3512a + '\'' + ", unique=" + this.f3513b + ", columns=" + this.f3514c + '}';
        }
    }

    public C1112d(String str, Map<String, C1113a> map, Set<C1114b> set, Set<C1116d> set2) {
        this.f3494a = str;
        this.f3495b = Collections.unmodifiableMap(map);
        this.f3496c = Collections.unmodifiableSet(set);
        this.f3497d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    /* renamed from: a */
    private static C1116d m4413a(C0813b bVar, String str, boolean z) {
        Cursor b = bVar.mo4615b("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = b.getColumnIndex("seqno");
            int columnIndex2 = b.getColumnIndex("cid");
            int columnIndex3 = b.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (b.moveToNext()) {
                        if (b.getInt(columnIndex2) >= 0) {
                            int i = b.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i), b.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    C1116d dVar = new C1116d(str, z, arrayList);
                    b.close();
                    return dVar;
                }
            }
            return null;
        } finally {
            b.close();
        }
    }

    /* renamed from: a */
    public static C1112d m4414a(C0813b bVar, String str) {
        return new C1112d(str, m4417c(bVar, str), m4416b(bVar, str), m4418d(bVar, str));
    }

    /* renamed from: a */
    private static List<C1115c> m4415a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new C1115c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: b */
    private static Set<C1114b> m4416b(C0813b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor b = bVar.mo4615b("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = b.getColumnIndex("id");
            int columnIndex2 = b.getColumnIndex("seq");
            int columnIndex3 = b.getColumnIndex("table");
            int columnIndex4 = b.getColumnIndex("on_delete");
            int columnIndex5 = b.getColumnIndex("on_update");
            List<C1115c> a = m4415a(b);
            int count = b.getCount();
            for (int i = 0; i < count; i++) {
                b.moveToPosition(i);
                if (b.getInt(columnIndex2) == 0) {
                    int i2 = b.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (C1115c next : a) {
                        if (next.f3508a == i2) {
                            arrayList.add(next.f3510c);
                            arrayList2.add(next.f3511d);
                        }
                    }
                    hashSet.add(new C1114b(b.getString(columnIndex3), b.getString(columnIndex4), b.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            b.close();
        }
    }

    /* renamed from: c */
    private static Map<String, C1113a> m4417c(C0813b bVar, String str) {
        Cursor b = bVar.mo4615b("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (b.getColumnCount() > 0) {
                int columnIndex = b.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
                int columnIndex2 = b.getColumnIndex("type");
                int columnIndex3 = b.getColumnIndex("notnull");
                int columnIndex4 = b.getColumnIndex("pk");
                while (b.moveToNext()) {
                    String string = b.getString(columnIndex);
                    hashMap.put(string, new C1113a(string, b.getString(columnIndex2), b.getInt(columnIndex3) != 0, b.getInt(columnIndex4)));
                }
            }
            return hashMap;
        } finally {
            b.close();
        }
    }

    /* renamed from: d */
    private static Set<C1116d> m4418d(C0813b bVar, String str) {
        Cursor b = bVar.mo4615b("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = b.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndex2 = b.getColumnIndex("origin");
            int columnIndex3 = b.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    HashSet hashSet = new HashSet();
                    while (b.moveToNext()) {
                        if ("c".equals(b.getString(columnIndex2))) {
                            String string = b.getString(columnIndex);
                            boolean z = true;
                            if (b.getInt(columnIndex3) != 1) {
                                z = false;
                            }
                            C1116d a = m4413a(bVar, string, z);
                            if (a == null) {
                                b.close();
                                return null;
                            }
                            hashSet.add(a);
                        }
                    }
                    b.close();
                    return hashSet;
                }
            }
            return null;
        } finally {
            b.close();
        }
    }

    public boolean equals(Object obj) {
        Set<C1116d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1112d dVar = (C1112d) obj;
        String str = this.f3494a;
        if (str == null ? dVar.f3494a != null : !str.equals(dVar.f3494a)) {
            return false;
        }
        Map<String, C1113a> map = this.f3495b;
        if (map == null ? dVar.f3495b != null : !map.equals(dVar.f3495b)) {
            return false;
        }
        Set<C1114b> set2 = this.f3496c;
        if (set2 == null ? dVar.f3496c != null : !set2.equals(dVar.f3496c)) {
            return false;
        }
        Set<C1116d> set3 = this.f3497d;
        if (set3 == null || (set = dVar.f3497d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f3494a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, C1113a> map = this.f3495b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<C1114b> set = this.f3496c;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "TableInfo{name='" + this.f3494a + '\'' + ", columns=" + this.f3495b + ", foreignKeys=" + this.f3496c + ", indices=" + this.f3497d + '}';
    }
}
