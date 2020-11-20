package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.widget.d */
class C0325d extends DataSetObservable {

    /* renamed from: a */
    static final String f1173a = "d";

    /* renamed from: e */
    private static final Object f1174e = new Object();

    /* renamed from: f */
    private static final Map<String, C0325d> f1175f = new HashMap();

    /* renamed from: b */
    final Context f1176b;

    /* renamed from: c */
    final String f1177c;

    /* renamed from: d */
    boolean f1178d;

    /* renamed from: g */
    private final Object f1179g;

    /* renamed from: h */
    private final List<C0326a> f1180h;

    /* renamed from: i */
    private final List<C0328c> f1181i;

    /* renamed from: j */
    private Intent f1182j;

    /* renamed from: k */
    private C0327b f1183k;

    /* renamed from: l */
    private int f1184l;

    /* renamed from: m */
    private boolean f1185m;

    /* renamed from: n */
    private boolean f1186n;

    /* renamed from: o */
    private boolean f1187o;

    /* renamed from: p */
    private C0329d f1188p;

    /* renamed from: androidx.appcompat.widget.d$a */
    public static final class C0326a implements Comparable<C0326a> {

        /* renamed from: a */
        public final ResolveInfo f1189a;

        /* renamed from: b */
        public float f1190b;

        public C0326a(ResolveInfo resolveInfo) {
            this.f1189a = resolveInfo;
        }

        /* renamed from: a */
        public int compareTo(C0326a aVar) {
            return Float.floatToIntBits(aVar.f1190b) - Float.floatToIntBits(this.f1190b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f1190b) == Float.floatToIntBits(((C0326a) obj).f1190b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1190b) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.f1189a.toString() + "; weight:" + new BigDecimal((double) this.f1190b) + "]";
        }
    }

    /* renamed from: androidx.appcompat.widget.d$b */
    public interface C0327b {
        /* renamed from: a */
        void mo2486a(Intent intent, List<C0326a> list, List<C0328c> list2);
    }

    /* renamed from: androidx.appcompat.widget.d$c */
    public static final class C0328c {

        /* renamed from: a */
        public final ComponentName f1191a;

        /* renamed from: b */
        public final long f1192b;

        /* renamed from: c */
        public final float f1193c;

        public C0328c(ComponentName componentName, long j, float f) {
            this.f1191a = componentName;
            this.f1192b = j;
            this.f1193c = f;
        }

        public C0328c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0328c cVar = (C0328c) obj;
            ComponentName componentName = this.f1191a;
            if (componentName == null) {
                if (cVar.f1191a != null) {
                    return false;
                }
            } else if (!componentName.equals(cVar.f1191a)) {
                return false;
            }
            return this.f1192b == cVar.f1192b && Float.floatToIntBits(this.f1193c) == Float.floatToIntBits(cVar.f1193c);
        }

        public int hashCode() {
            ComponentName componentName = this.f1191a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.f1192b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.f1193c);
        }

        public String toString() {
            return "[" + "; activity:" + this.f1191a + "; time:" + this.f1192b + "; weight:" + new BigDecimal((double) this.f1193c) + "]";
        }
    }

    /* renamed from: androidx.appcompat.widget.d$d */
    public interface C0329d {
        /* renamed from: a */
        boolean mo2490a(C0325d dVar, Intent intent);
    }

    /* renamed from: androidx.appcompat.widget.d$e */
    private final class C0330e extends AsyncTask<Object, Void, Void> {
        C0330e() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006f, code lost:
            if (r12 != null) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r12.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0096, code lost:
            if (r12 == null) goto L_0x00dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
            if (r12 == null) goto L_0x00dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00da, code lost:
            if (r12 == null) goto L_0x00dd;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r12) {
            /*
                r11 = this;
                r0 = 0
                r1 = r12[r0]
                java.util.List r1 = (java.util.List) r1
                r2 = 1
                r12 = r12[r2]
                java.lang.String r12 = (java.lang.String) r12
                r3 = 0
                androidx.appcompat.widget.d r4 = androidx.appcompat.widget.C0325d.this     // Catch:{ FileNotFoundException -> 0x00e8 }
                android.content.Context r4 = r4.f1176b     // Catch:{ FileNotFoundException -> 0x00e8 }
                java.io.FileOutputStream r12 = r4.openFileOutput(r12, r0)     // Catch:{ FileNotFoundException -> 0x00e8 }
                org.xmlpull.v1.XmlSerializer r4 = android.util.Xml.newSerializer()
                r4.setOutput(r12, r3)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r5 = "UTF-8"
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r4.startDocument(r5, r6)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r5 = "historical-records"
                r4.startTag(r3, r5)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                int r5 = r1.size()     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r6 = 0
            L_0x002d:
                if (r6 >= r5) goto L_0x0063
                java.lang.Object r7 = r1.remove(r0)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                androidx.appcompat.widget.d$c r7 = (androidx.appcompat.widget.C0325d.C0328c) r7     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r8 = "historical-record"
                r4.startTag(r3, r8)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r8 = "activity"
                android.content.ComponentName r9 = r7.f1191a     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r9 = r9.flattenToString()     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r4.attribute(r3, r8, r9)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r8 = "time"
                long r9 = r7.f1192b     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r4.attribute(r3, r8, r9)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r8 = "weight"
                float r7 = r7.f1193c     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r4.attribute(r3, r8, r7)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r7 = "historical-record"
                r4.endTag(r3, r7)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                int r6 = r6 + 1
                goto L_0x002d
            L_0x0063:
                java.lang.String r0 = "historical-records"
                r4.endTag(r3, r0)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r4.endDocument()     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0325d.this
                r0.f1178d = r2
                if (r12 == 0) goto L_0x00dd
            L_0x0071:
                r12.close()     // Catch:{ IOException -> 0x00dd }
                goto L_0x00dd
            L_0x0075:
                r0 = move-exception
                goto L_0x00de
            L_0x0077:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0325d.f1173a     // Catch:{ all -> 0x0075 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
                r4.<init>()     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = "Error writing historical record file: "
                r4.append(r5)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r5 = androidx.appcompat.widget.C0325d.this     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = r5.f1177c     // Catch:{ all -> 0x0075 }
                r4.append(r5)     // Catch:{ all -> 0x0075 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0075 }
                android.util.Log.e(r1, r4, r0)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0325d.this
                r0.f1178d = r2
                if (r12 == 0) goto L_0x00dd
                goto L_0x0071
            L_0x0099:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0325d.f1173a     // Catch:{ all -> 0x0075 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
                r4.<init>()     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = "Error writing historical record file: "
                r4.append(r5)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r5 = androidx.appcompat.widget.C0325d.this     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = r5.f1177c     // Catch:{ all -> 0x0075 }
                r4.append(r5)     // Catch:{ all -> 0x0075 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0075 }
                android.util.Log.e(r1, r4, r0)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0325d.this
                r0.f1178d = r2
                if (r12 == 0) goto L_0x00dd
                goto L_0x0071
            L_0x00bb:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0325d.f1173a     // Catch:{ all -> 0x0075 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
                r4.<init>()     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = "Error writing historical record file: "
                r4.append(r5)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r5 = androidx.appcompat.widget.C0325d.this     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = r5.f1177c     // Catch:{ all -> 0x0075 }
                r4.append(r5)     // Catch:{ all -> 0x0075 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0075 }
                android.util.Log.e(r1, r4, r0)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0325d.this
                r0.f1178d = r2
                if (r12 == 0) goto L_0x00dd
                goto L_0x0071
            L_0x00dd:
                return r3
            L_0x00de:
                androidx.appcompat.widget.d r1 = androidx.appcompat.widget.C0325d.this
                r1.f1178d = r2
                if (r12 == 0) goto L_0x00e7
                r12.close()     // Catch:{ IOException -> 0x00e7 }
            L_0x00e7:
                throw r0
            L_0x00e8:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0325d.f1173a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "Error writing historical record file: "
                r2.append(r4)
                r2.append(r12)
                java.lang.String r12 = r2.toString()
                android.util.Log.e(r1, r12, r0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0325d.C0330e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    /* renamed from: a */
    private boolean m1203a(C0328c cVar) {
        boolean add = this.f1181i.add(cVar);
        if (add) {
            this.f1186n = true;
            m1209h();
            m1204c();
            m1206e();
            notifyChanged();
        }
        return add;
    }

    /* renamed from: c */
    private void m1204c() {
        if (!this.f1185m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1186n) {
            this.f1186n = false;
            if (!TextUtils.isEmpty(this.f1177c)) {
                new C0330e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f1181i), this.f1177c});
            }
        }
    }

    /* renamed from: d */
    private void m1205d() {
        boolean f = m1207f() | m1208g();
        m1209h();
        if (f) {
            m1206e();
            notifyChanged();
        }
    }

    /* renamed from: e */
    private boolean m1206e() {
        if (this.f1183k == null || this.f1182j == null || this.f1180h.isEmpty() || this.f1181i.isEmpty()) {
            return false;
        }
        this.f1183k.mo2486a(this.f1182j, this.f1180h, Collections.unmodifiableList(this.f1181i));
        return true;
    }

    /* renamed from: f */
    private boolean m1207f() {
        if (!this.f1187o || this.f1182j == null) {
            return false;
        }
        this.f1187o = false;
        this.f1180h.clear();
        List<ResolveInfo> queryIntentActivities = this.f1176b.getPackageManager().queryIntentActivities(this.f1182j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1180h.add(new C0326a(queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: g */
    private boolean m1208g() {
        if (!this.f1178d || !this.f1186n || TextUtils.isEmpty(this.f1177c)) {
            return false;
        }
        this.f1178d = false;
        this.f1185m = true;
        m1210i();
        return true;
    }

    /* renamed from: h */
    private void m1209h() {
        int size = this.f1181i.size() - this.f1184l;
        if (size > 0) {
            this.f1186n = true;
            for (int i = 0; i < size; i++) {
                C0328c remove = this.f1181i.remove(0);
            }
        }
    }

    /* renamed from: i */
    private void m1210i() {
        try {
            FileInputStream openFileInput = this.f1176b.openFileInput(this.f1177c);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<C0328c> list = this.f1181i;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0328c(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e) {
                String str = f1173a;
                Log.e(str, "Error reading historical recrod file: " + this.f1177c, e);
                if (openFileInput == null) {
                }
            } catch (IOException e2) {
                String str2 = f1173a;
                Log.e(str2, "Error reading historical recrod file: " + this.f1177c, e2);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    /* renamed from: a */
    public int mo2475a() {
        int size;
        synchronized (this.f1179g) {
            m1205d();
            size = this.f1180h.size();
        }
        return size;
    }

    /* renamed from: a */
    public int mo2476a(ResolveInfo resolveInfo) {
        synchronized (this.f1179g) {
            m1205d();
            List<C0326a> list = this.f1180h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f1189a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public ResolveInfo mo2477a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1179g) {
            m1205d();
            resolveInfo = this.f1180h.get(i).f1189a;
        }
        return resolveInfo;
    }

    /* renamed from: b */
    public Intent mo2478b(int i) {
        synchronized (this.f1179g) {
            if (this.f1182j == null) {
                return null;
            }
            m1205d();
            C0326a aVar = this.f1180h.get(i);
            ComponentName componentName = new ComponentName(aVar.f1189a.activityInfo.packageName, aVar.f1189a.activityInfo.name);
            Intent intent = new Intent(this.f1182j);
            intent.setComponent(componentName);
            if (this.f1188p != null) {
                if (this.f1188p.mo2490a(this, new Intent(intent))) {
                    return null;
                }
            }
            m1203a(new C0328c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: b */
    public ResolveInfo mo2479b() {
        synchronized (this.f1179g) {
            m1205d();
            if (this.f1180h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.f1180h.get(0).f1189a;
            return resolveInfo;
        }
    }

    /* renamed from: c */
    public void mo2480c(int i) {
        synchronized (this.f1179g) {
            m1205d();
            C0326a aVar = this.f1180h.get(i);
            C0326a aVar2 = this.f1180h.get(0);
            m1203a(new C0328c(new ComponentName(aVar.f1189a.activityInfo.packageName, aVar.f1189a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1190b - aVar.f1190b) + 5.0f : 1.0f));
        }
    }
}
