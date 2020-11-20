package com.cyberneid.p105d.p109c.p110a;

/* renamed from: com.cyberneid.d.c.a.d */
final class C1638d {

    /* renamed from: a */
    private int f5415a;

    /* renamed from: b */
    private byte[] f5416b;

    C1638d(int i) {
        this.f5415a = i;
        this.f5416b = new byte[((i + 7) / 8)];
    }

    /* renamed from: a */
    private int m6564a(int i) {
        return i / 8;
    }

    /* renamed from: a */
    public static String m6565a(byte[] bArr) {
        return m6566a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static String m6566a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            for (int i4 = 0; i4 < 8; i4++) {
                stringBuffer.append(((1 << i4) & bArr[i]) != 0 ? '1' : '0');
            }
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private int m6567b(int i) {
        return i % 8;
    }

    /* renamed from: a */
    public void mo7671a() {
        mo7674b(0, mo7673b());
    }

    /* renamed from: a */
    public void mo7672a(int i, int i2) {
        if (i2 != 0) {
            int b = m6567b(i);
            int a = m6564a(i);
            int i3 = i + i2;
            if (i3 <= mo7673b()) {
                int a2 = m6564a(i3);
                int b2 = m6567b(i3);
                if (a == a2) {
                    byte[] bArr = this.f5416b;
                    bArr[a] = (byte) (((1 << b2) - (1 << b)) | bArr[a]);
                    return;
                }
                byte[] bArr2 = this.f5416b;
                bArr2[a] = (byte) ((255 << b) | bArr2[a]);
                for (int i4 = a + 1; i4 < a2; i4++) {
                    this.f5416b[i4] = -1;
                }
                if (b2 > 0) {
                    byte[] bArr3 = this.f5416b;
                    bArr3[a2] = (byte) ((255 >> (8 - b2)) | bArr3[a2]);
                    return;
                }
                return;
            }
            throw new IndexOutOfBoundsException("offset + length > bit count");
        }
    }

    /* renamed from: b */
    public int mo7673b() {
        return this.f5415a;
    }

    /* renamed from: b */
    public void mo7674b(int i, int i2) {
        if (i2 != 0) {
            int i3 = i % 8;
            int a = m6564a(i);
            int i4 = i + i2;
            int a2 = m6564a(i4);
            int i5 = i4 % 8;
            if (a == a2) {
                int i6 = (1 << i5) - (1 << i3);
                byte[] bArr = this.f5416b;
                bArr[a] = (byte) ((~i6) & bArr[a]);
                return;
            }
            byte[] bArr2 = this.f5416b;
            bArr2[a] = (byte) ((~(255 << i3)) & bArr2[a]);
            for (int i7 = a + 1; i7 < a2; i7++) {
                this.f5416b[i7] = 0;
            }
            if (i5 > 0) {
                byte[] bArr3 = this.f5416b;
                bArr3[a2] = (byte) ((~(255 >> (8 - i5))) & bArr3[a2]);
            }
        }
    }

    /* renamed from: c */
    public int mo7675c() {
        return this.f5416b.length;
    }

    /* renamed from: d */
    public byte[] mo7676d() {
        return this.f5416b;
    }

    public String toString() {
        return m6565a(this.f5416b).substring(0, this.f5415a);
    }
}
