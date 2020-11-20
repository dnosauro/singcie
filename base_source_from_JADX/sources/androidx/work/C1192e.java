package androidx.work;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.work.e */
public final class C1192e {

    /* renamed from: a */
    public static final C1192e f3752a = new C1193a().mo6416a();

    /* renamed from: c */
    private static final String f3753c = C1196h.m4737a("Data");

    /* renamed from: b */
    Map<String, Object> f3754b;

    /* renamed from: androidx.work.e$a */
    public static final class C1193a {

        /* renamed from: a */
        private Map<String, Object> f3755a = new HashMap();

        /* renamed from: a */
        public C1193a mo6412a(C1192e eVar) {
            mo6415a(eVar.f3754b);
            return this;
        }

        /* renamed from: a */
        public C1193a mo6413a(String str, Object obj) {
            Map<String, Object> map;
            if (obj == null) {
                this.f3755a.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    map = this.f3755a;
                } else if (cls == boolean[].class) {
                    map = this.f3755a;
                    obj = C1192e.m4720a((boolean[]) obj);
                } else if (cls == byte[].class) {
                    map = this.f3755a;
                    obj = C1192e.m4725b((byte[]) obj);
                } else if (cls == int[].class) {
                    map = this.f3755a;
                    obj = C1192e.m4723a((int[]) obj);
                } else if (cls == long[].class) {
                    map = this.f3755a;
                    obj = C1192e.m4724a((long[]) obj);
                } else if (cls == float[].class) {
                    map = this.f3755a;
                    obj = C1192e.m4722a((float[]) obj);
                } else if (cls == double[].class) {
                    map = this.f3755a;
                    obj = C1192e.m4721a((double[]) obj);
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{str, cls}));
                }
                map.put(str, obj);
            }
            return this;
        }

        /* renamed from: a */
        public C1193a mo6414a(String str, String str2) {
            this.f3755a.put(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1193a mo6415a(Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                mo6413a((String) next.getKey(), next.getValue());
            }
            return this;
        }

        /* renamed from: a */
        public C1192e mo6416a() {
            C1192e eVar = new C1192e((Map<String, ?>) this.f3755a);
            C1192e.m4719a(eVar);
            return eVar;
        }
    }

    C1192e() {
    }

    public C1192e(C1192e eVar) {
        this.f3754b = new HashMap(eVar.f3754b);
    }

    C1192e(Map<String, ?> map) {
        this.f3754b = new HashMap(map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050 A[SYNTHETIC, Splitter:B:24:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071 A[SYNTHETIC, Splitter:B:36:0x0071] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0035=Splitter:B:14:0x0035, B:28:0x005c=Splitter:B:28:0x005c} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.C1192e m4718a(byte[] r6) {
        /*
            int r0 = r6.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L_0x008a
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0043, ClassNotFoundException -> 0x0041, all -> 0x003d }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0043, ClassNotFoundException -> 0x0041, all -> 0x003d }
            int r6 = r2.readInt()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
        L_0x0019:
            if (r6 <= 0) goto L_0x0029
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            java.lang.Object r4 = r2.readObject()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            r0.put(r3, r4)     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            int r6 = r6 + -1
            goto L_0x0019
        L_0x0029:
            r2.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0035
        L_0x002d:
            r6 = move-exception
            java.lang.String r2 = f3753c
            java.lang.String r3 = "Error in Data#fromByteArray: "
            android.util.Log.e(r2, r3, r6)
        L_0x0035:
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0068
        L_0x0039:
            r6 = move-exception
            goto L_0x0047
        L_0x003b:
            r6 = move-exception
            goto L_0x0047
        L_0x003d:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L_0x006f
        L_0x0041:
            r2 = move-exception
            goto L_0x0044
        L_0x0043:
            r2 = move-exception
        L_0x0044:
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0047:
            java.lang.String r3 = f3753c     // Catch:{ all -> 0x006e }
            java.lang.String r4 = "Error in Data#fromByteArray: "
            android.util.Log.e(r3, r4, r6)     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x005c
        L_0x0054:
            r6 = move-exception
            java.lang.String r2 = f3753c
            java.lang.String r3 = "Error in Data#fromByteArray: "
            android.util.Log.e(r2, r3, r6)
        L_0x005c:
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0068
        L_0x0060:
            r6 = move-exception
            java.lang.String r1 = f3753c
            java.lang.String r2 = "Error in Data#fromByteArray: "
            android.util.Log.e(r1, r2, r6)
        L_0x0068:
            androidx.work.e r6 = new androidx.work.e
            r6.<init>((java.util.Map<java.lang.String, ?>) r0)
            return r6
        L_0x006e:
            r6 = move-exception
        L_0x006f:
            if (r2 == 0) goto L_0x007d
            r2.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x007d
        L_0x0075:
            r0 = move-exception
            java.lang.String r2 = f3753c
            java.lang.String r3 = "Error in Data#fromByteArray: "
            android.util.Log.e(r2, r3, r0)
        L_0x007d:
            r1.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0089
        L_0x0081:
            r0 = move-exception
            java.lang.String r1 = f3753c
            java.lang.String r2 = "Error in Data#fromByteArray: "
            android.util.Log.e(r1, r2, r0)
        L_0x0089:
            throw r6
        L_0x008a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.C1192e.m4718a(byte[]):androidx.work.e");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c A[SYNTHETIC, Splitter:B:31:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0097 A[SYNTHETIC, Splitter:B:41:0x0097] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m4719a(androidx.work.C1192e r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x006e }
            r2.<init>(r0)     // Catch:{ IOException -> 0x006e }
            int r1 = r4.mo6409b()     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.f3754b     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
        L_0x001c:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.lang.Object r3 = r1.getKey()     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            r2.writeObject(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            goto L_0x001c
        L_0x0039:
            r2.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0045
        L_0x003d:
            r4 = move-exception
            java.lang.String r1 = f3753c
            java.lang.String r2 = "Error in Data#toByteArray: "
            android.util.Log.e(r1, r2, r4)
        L_0x0045:
            r0.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x0051
        L_0x0049:
            r4 = move-exception
            java.lang.String r1 = f3753c
            java.lang.String r2 = "Error in Data#toByteArray: "
            android.util.Log.e(r1, r2, r4)
        L_0x0051:
            int r4 = r0.size()
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r4 > r1) goto L_0x005e
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x005e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r4.<init>(r0)
            throw r4
        L_0x0066:
            r4 = move-exception
            goto L_0x0095
        L_0x0068:
            r4 = move-exception
            r1 = r2
            goto L_0x006f
        L_0x006b:
            r4 = move-exception
            r2 = r1
            goto L_0x0095
        L_0x006e:
            r4 = move-exception
        L_0x006f:
            java.lang.String r2 = f3753c     // Catch:{ all -> 0x006b }
            java.lang.String r3 = "Error in Data#toByteArray: "
            android.util.Log.e(r2, r3, r4)     // Catch:{ all -> 0x006b }
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0088
            r1.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0088
        L_0x0080:
            r1 = move-exception
            java.lang.String r2 = f3753c
            java.lang.String r3 = "Error in Data#toByteArray: "
            android.util.Log.e(r2, r3, r1)
        L_0x0088:
            r0.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0094
        L_0x008c:
            r0 = move-exception
            java.lang.String r1 = f3753c
            java.lang.String r2 = "Error in Data#toByteArray: "
            android.util.Log.e(r1, r2, r0)
        L_0x0094:
            return r4
        L_0x0095:
            if (r2 == 0) goto L_0x00a3
            r2.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x00a3
        L_0x009b:
            r1 = move-exception
            java.lang.String r2 = f3753c
            java.lang.String r3 = "Error in Data#toByteArray: "
            android.util.Log.e(r2, r3, r1)
        L_0x00a3:
            r0.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00af
        L_0x00a7:
            r0 = move-exception
            java.lang.String r1 = f3753c
            java.lang.String r2 = "Error in Data#toByteArray: "
            android.util.Log.e(r1, r2, r0)
        L_0x00af:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.C1192e.m4719a(androidx.work.e):byte[]");
    }

    /* renamed from: a */
    static Boolean[] m4720a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    /* renamed from: a */
    static Double[] m4721a(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    /* renamed from: a */
    static Float[] m4722a(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    /* renamed from: a */
    static Integer[] m4723a(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    /* renamed from: a */
    static Long[] m4724a(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    /* renamed from: b */
    static Byte[] m4725b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: a */
    public String mo6407a(String str) {
        Object obj = this.f3754b.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* renamed from: a */
    public Map<String, Object> mo6408a() {
        return Collections.unmodifiableMap(this.f3754b);
    }

    /* renamed from: b */
    public int mo6409b() {
        return this.f3754b.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f3754b.equals(((C1192e) obj).f3754b);
    }

    public int hashCode() {
        return this.f3754b.hashCode() * 31;
    }
}
