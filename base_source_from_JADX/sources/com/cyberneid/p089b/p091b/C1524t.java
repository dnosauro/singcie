package com.cyberneid.p089b.p091b;

import java.util.Arrays;

/* renamed from: com.cyberneid.b.b.t */
public class C1524t {

    /* renamed from: a */
    private final int f4513a;

    /* renamed from: b */
    private final int[] f4514b;

    /* renamed from: c */
    private int[] f4515c;

    public C1524t(int i) {
        this.f4513a = i;
        this.f4514b = new int[(i + 1)];
    }

    /* renamed from: a */
    public int mo7128a() {
        return this.f4513a;
    }

    /* renamed from: a */
    public void mo7129a(int i, int i2) {
        this.f4514b[i] = i2;
    }

    /* renamed from: a */
    public byte[] mo7130a(int i) {
        int[] iArr = this.f4514b;
        int i2 = iArr[i + 1] - iArr[i];
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) this.f4515c[(this.f4514b[i] - 1) + i3];
        }
        return bArr;
    }

    /* renamed from: b */
    public int mo7131b(int i) {
        return this.f4514b[i];
    }

    /* renamed from: b */
    public void mo7132b(int i, int i2) {
        this.f4515c[i] = i2;
    }

    /* renamed from: c */
    public void mo7133c(int i) {
        this.f4515c = new int[i];
    }

    public String toString() {
        return getClass().getName() + "[count=" + this.f4513a + ", offset=" + Arrays.toString(this.f4514b) + ", data=" + Arrays.toString(this.f4515c) + "]";
    }
}
