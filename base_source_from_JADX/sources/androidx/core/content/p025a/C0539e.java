package androidx.core.content.p025a;

import java.lang.reflect.Array;

/* renamed from: androidx.core.content.a.e */
final class C0539e {

    /* renamed from: a */
    static final /* synthetic */ boolean f2071a = (!C0539e.class.desiredAssertionStatus());

    private C0539e() {
    }

    /* renamed from: a */
    public static int m2144a(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    /* renamed from: a */
    public static int[] m2145a(int[] iArr, int i, int i2) {
        if (f2071a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[m2144a(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static <T> T[] m2146a(T[] tArr, int i, T t) {
        if (f2071a || i <= tArr.length) {
            if (i + 1 > tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), m2144a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
                tArr = tArr2;
            }
            tArr[i] = t;
            return tArr;
        }
        throw new AssertionError();
    }
}
