package androidx.core.p027e;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.content.p025a.C0532c;
import androidx.core.graphics.C0593c;
import androidx.core.graphics.C0609j;
import androidx.core.p027e.C0558c;
import androidx.core.p029g.C0588f;
import androidx.p018c.C0406e;
import androidx.p018c.C0413g;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.core.e.b */
public class C0550b {

    /* renamed from: a */
    static final C0406e<String, Typeface> f2087a = new C0406e<>(16);

    /* renamed from: b */
    static final Object f2088b = new Object();

    /* renamed from: c */
    static final C0413g<String, ArrayList<C0558c.C0563a<C0557c>>> f2089c = new C0413g<>();

    /* renamed from: d */
    private static final C0558c f2090d = new C0558c("fonts", 10, 10000);

    /* renamed from: e */
    private static final Comparator<byte[]> f2091e = new Comparator<byte[]>() {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(byte[] r5, byte[] r6) {
            /*
                r4 = this;
                int r0 = r5.length
                int r1 = r6.length
                if (r0 == r1) goto L_0x0008
                int r5 = r5.length
                int r6 = r6.length
            L_0x0006:
                int r5 = r5 - r6
                return r5
            L_0x0008:
                r0 = 0
                r1 = 0
            L_0x000a:
                int r2 = r5.length
                if (r1 >= r2) goto L_0x001b
                byte r2 = r5[r1]
                byte r3 = r6[r1]
                if (r2 == r3) goto L_0x0018
                byte r5 = r5[r1]
                byte r6 = r6[r1]
                goto L_0x0006
            L_0x0018:
                int r1 = r1 + 1
                goto L_0x000a
            L_0x001b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p027e.C0550b.C05544.compare(byte[], byte[]):int");
        }
    };

    /* renamed from: androidx.core.e.b$a */
    public static class C0555a {

        /* renamed from: a */
        private final int f2099a;

        /* renamed from: b */
        private final C0556b[] f2100b;

        public C0555a(int i, C0556b[] bVarArr) {
            this.f2099a = i;
            this.f2100b = bVarArr;
        }

        /* renamed from: a */
        public int mo3554a() {
            return this.f2099a;
        }

        /* renamed from: b */
        public C0556b[] mo3555b() {
            return this.f2100b;
        }
    }

    /* renamed from: androidx.core.e.b$b */
    public static class C0556b {

        /* renamed from: a */
        private final Uri f2101a;

        /* renamed from: b */
        private final int f2102b;

        /* renamed from: c */
        private final int f2103c;

        /* renamed from: d */
        private final boolean f2104d;

        /* renamed from: e */
        private final int f2105e;

        public C0556b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f2101a = (Uri) C0588f.m2266a(uri);
            this.f2102b = i;
            this.f2103c = i2;
            this.f2104d = z;
            this.f2105e = i3;
        }

        /* renamed from: a */
        public Uri mo3556a() {
            return this.f2101a;
        }

        /* renamed from: b */
        public int mo3557b() {
            return this.f2102b;
        }

        /* renamed from: c */
        public int mo3558c() {
            return this.f2103c;
        }

        /* renamed from: d */
        public boolean mo3559d() {
            return this.f2104d;
        }

        /* renamed from: e */
        public int mo3560e() {
            return this.f2105e;
        }
    }

    /* renamed from: androidx.core.e.b$c */
    private static final class C0557c {

        /* renamed from: a */
        final Typeface f2106a;

        /* renamed from: b */
        final int f2107b;

        C0557c(Typeface typeface, int i) {
            this.f2106a = typeface;
            this.f2107b = i;
        }
    }

    /* renamed from: a */
    public static ProviderInfo m2177a(PackageManager packageManager, C0549a aVar, Resources resources) {
        String a = aVar.mo3540a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + a);
        } else if (resolveContentProvider.packageName.equals(aVar.mo3541b())) {
            List<byte[]> a2 = m2182a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, f2091e);
            List<List<byte[]>> a3 = m2181a(aVar, resources);
            for (int i = 0; i < a3.size(); i++) {
                ArrayList arrayList = new ArrayList(a3.get(i));
                Collections.sort(arrayList, f2091e);
                if (m2184a(a2, (List<byte[]>) arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + a + ", but package was not " + aVar.mo3541b());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        f2090d.mo3564a(r1, new androidx.core.p027e.C0550b.C05533());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface m2178a(final android.content.Context r2, final androidx.core.p027e.C0549a r3, final androidx.core.content.p025a.C0540f.C0541a r4, final android.os.Handler r5, boolean r6, int r7, final int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.mo3545f()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            androidx.c.e<java.lang.String, android.graphics.Typeface> r1 = f2087a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0027
            r4.onFontRetrieved(r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r6 == 0) goto L_0x0045
            r1 = -1
            if (r7 != r1) goto L_0x0045
            androidx.core.e.b$c r2 = m2180a((android.content.Context) r2, (androidx.core.p027e.C0549a) r3, (int) r8)
            if (r4 == 0) goto L_0x0042
            int r3 = r2.f2107b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f2106a
            r4.callbackSuccessAsync(r3, r5)
            goto L_0x0042
        L_0x003d:
            int r3 = r2.f2107b
            r4.callbackFailAsync(r3, r5)
        L_0x0042:
            android.graphics.Typeface r2 = r2.f2106a
            return r2
        L_0x0045:
            androidx.core.e.b$1 r1 = new androidx.core.e.b$1
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0058
            androidx.core.e.c r3 = f2090d     // Catch:{ InterruptedException -> 0x0057 }
            java.lang.Object r3 = r3.mo3561a(r1, (int) r7)     // Catch:{ InterruptedException -> 0x0057 }
            androidx.core.e.b$c r3 = (androidx.core.p027e.C0550b.C0557c) r3     // Catch:{ InterruptedException -> 0x0057 }
            android.graphics.Typeface r2 = r3.f2106a     // Catch:{ InterruptedException -> 0x0057 }
        L_0x0057:
            return r2
        L_0x0058:
            if (r4 != 0) goto L_0x005c
            r3 = r2
            goto L_0x0061
        L_0x005c:
            androidx.core.e.b$2 r3 = new androidx.core.e.b$2
            r3.<init>(r4, r5)
        L_0x0061:
            java.lang.Object r4 = f2088b
            monitor-enter(r4)
            androidx.c.g<java.lang.String, java.util.ArrayList<androidx.core.e.c$a<androidx.core.e.b$c>>> r5 = f2089c     // Catch:{ all -> 0x0090 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0090 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0090 }
            if (r5 == 0) goto L_0x0075
            if (r3 == 0) goto L_0x0073
            r5.add(r3)     // Catch:{ all -> 0x0090 }
        L_0x0073:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            return r2
        L_0x0075:
            if (r3 == 0) goto L_0x0084
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0090 }
            r5.<init>()     // Catch:{ all -> 0x0090 }
            r5.add(r3)     // Catch:{ all -> 0x0090 }
            androidx.c.g<java.lang.String, java.util.ArrayList<androidx.core.e.c$a<androidx.core.e.b$c>>> r3 = f2089c     // Catch:{ all -> 0x0090 }
            r3.put(r0, r5)     // Catch:{ all -> 0x0090 }
        L_0x0084:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            androidx.core.e.c r3 = f2090d
            androidx.core.e.b$3 r4 = new androidx.core.e.b$3
            r4.<init>(r0)
            r3.mo3564a(r1, r4)
            return r2
        L_0x0090:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p027e.C0550b.m2178a(android.content.Context, androidx.core.e.a, androidx.core.content.a.f$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public static C0555a m2179a(Context context, CancellationSignal cancellationSignal, C0549a aVar) {
        ProviderInfo a = m2177a(context.getPackageManager(), aVar, context.getResources());
        return a == null ? new C0555a(1, (C0556b[]) null) : new C0555a(0, m2185a(context, aVar, a.authority, cancellationSignal));
    }

    /* renamed from: a */
    static C0557c m2180a(Context context, C0549a aVar, int i) {
        try {
            C0555a a = m2179a(context, (CancellationSignal) null, aVar);
            int i2 = -3;
            if (a.mo3554a() == 0) {
                Typeface a2 = C0593c.m2291a(context, (CancellationSignal) null, a.mo3555b(), i);
                if (a2 != null) {
                    i2 = 0;
                }
                return new C0557c(a2, i2);
            }
            if (a.mo3554a() == 1) {
                i2 = -2;
            }
            return new C0557c((Typeface) null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0557c((Typeface) null, -1);
        }
    }

    /* renamed from: a */
    private static List<List<byte[]>> m2181a(C0549a aVar, Resources resources) {
        return aVar.mo3543d() != null ? aVar.mo3543d() : C0532c.m2124a(resources, aVar.mo3544e());
    }

    /* renamed from: a */
    private static List<byte[]> m2182a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map<Uri, ByteBuffer> m2183a(Context context, C0556b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0556b bVar : bVarArr) {
            if (bVar.mo3560e() == 0) {
                Uri a = bVar.mo3556a();
                if (!hashMap.containsKey(a)) {
                    hashMap.put(a, C0609j.m2396a(context, cancellationSignal, a));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    private static boolean m2184a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static C0556b[] m2185a(Context context, C0549a aVar, String str, CancellationSignal cancellationSignal) {
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str2).build();
        Uri build2 = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            cursor = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.mo3542c()}, (String) null, cancellationSignal) : context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.mo3542c()}, (String) null);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    arrayList2.add(new C0556b(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (C0556b[]) arrayList.toArray(new C0556b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
