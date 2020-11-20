package androidx.p046i.p047a;

/* renamed from: androidx.i.a.a */
public final class C0804a implements C0820e {

    /* renamed from: a */
    private final String f2753a;

    /* renamed from: b */
    private final Object[] f2754b;

    public C0804a(String str) {
        this(str, (Object[]) null);
    }

    public C0804a(String str, Object[] objArr) {
        this.f2753a = str;
        this.f2754b = objArr;
    }

    /* renamed from: a */
    private static void m3332a(C0819d dVar, int i, Object obj) {
        long j;
        int byteValue;
        double doubleValue;
        if (obj == null) {
            dVar.mo4637a(i);
        } else if (obj instanceof byte[]) {
            dVar.mo4641a(i, (byte[]) obj);
        } else {
            if (obj instanceof Float) {
                doubleValue = (double) ((Float) obj).floatValue();
            } else if (obj instanceof Double) {
                doubleValue = ((Double) obj).doubleValue();
            } else {
                if (obj instanceof Long) {
                    j = ((Long) obj).longValue();
                } else {
                    if (obj instanceof Integer) {
                        byteValue = ((Integer) obj).intValue();
                    } else if (obj instanceof Short) {
                        byteValue = ((Short) obj).shortValue();
                    } else if (obj instanceof Byte) {
                        byteValue = ((Byte) obj).byteValue();
                    } else if (obj instanceof String) {
                        dVar.mo4640a(i, (String) obj);
                        return;
                    } else if (obj instanceof Boolean) {
                        j = ((Boolean) obj).booleanValue() ? 1 : 0;
                    } else {
                        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte," + " string");
                    }
                    j = (long) byteValue;
                }
                dVar.mo4639a(i, j);
                return;
            }
            dVar.mo4638a(i, doubleValue);
        }
    }

    /* renamed from: a */
    public static void m3333a(C0819d dVar, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                m3332a(dVar, i, obj);
            }
        }
    }

    /* renamed from: a */
    public void mo4609a(C0819d dVar) {
        m3333a(dVar, this.f2754b);
    }

    /* renamed from: b */
    public String mo4610b() {
        return this.f2753a;
    }
}
