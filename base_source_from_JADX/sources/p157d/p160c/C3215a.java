package p157d.p160c;

/* renamed from: d.c.a */
public final class C3215a {
    /* renamed from: a */
    private static final int m9024a(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* renamed from: a */
    public static final int m9025a(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - m9026b(i2, i, i3);
        }
        if (i3 < 0) {
            return i <= i2 ? i2 : i2 + m9026b(i, i2, -i3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: b */
    private static final int m9026b(int i, int i2, int i3) {
        return m9024a(m9024a(i, i3) - m9024a(i2, i3), i3);
    }
}
