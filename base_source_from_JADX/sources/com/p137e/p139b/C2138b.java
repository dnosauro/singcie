package com.p137e.p139b;

/* renamed from: com.e.b.b */
public final class C2138b {

    /* renamed from: a */
    private static char[] f6599a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static char[] f6600b = {'0', '1'};

    /* renamed from: a */
    public static byte m8393a(char c) {
        int i;
        if (c >= '0' && c <= '9') {
            i = c - '0';
        } else if (c >= 'A' && c <= 'F') {
            i = c - '7';
        } else if (c < 'a' || c > 'g') {
            throw new IllegalArgumentException("Invalid hex digit " + c);
        } else {
            i = c - 'W';
        }
        return (byte) i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m8394a(byte[] r3) {
        /*
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 4
            if (r0 >= r2) goto L_0x0011
            int r1 = r1 << 8
            byte r2 = r3[r0]
            if (r2 >= 0) goto L_0x000d
            int r2 = r2 + 256
        L_0x000d:
            r1 = r1 | r2
            int r0 = r0 + 1
            goto L_0x0002
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p137e.p139b.C2138b.m8394a(byte[]):int");
    }

    /* renamed from: a */
    public static final String m8395a(int i) {
        StringBuffer stringBuffer = new StringBuffer(8);
        for (int i2 = 0; i2 < 8; i2++) {
            stringBuffer.append(f6599a[(i >>> (60 - (i2 * 4))) & 15]);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static final String m8396a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        for (int i3 = i; i3 < i + i2; i3++) {
            stringBuffer.append(f6599a[(bArr[i3] >>> 4) & 15]);
            stringBuffer.append(f6599a[bArr[i3] & 15]);
        }
        return stringBuffer.toString().toUpperCase();
    }

    /* renamed from: a */
    public static byte[] m8397a(String str) {
        int i = 0;
        String str2 = "";
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != ' ') {
                str2 = str2 + str.charAt(i2);
            }
        }
        int i3 = 1;
        int length = (str2.length() + 1) / 2;
        byte[] bArr = new byte[length];
        if (str2.length() % 2 == 1) {
            bArr[0] = m8393a(str2.charAt(0));
            i = 1;
        } else {
            i3 = 0;
        }
        while (i3 < length) {
            int i4 = i + 1;
            bArr[i3] = (byte) ((m8393a(str2.charAt(i)) << 4) | m8393a(str2.charAt(i4)));
            i3++;
            i = i4 + 1;
        }
        return bArr;
    }

    /* renamed from: b */
    public static int m8398b(String str) {
        return m8394a(m8397a(str));
    }

    /* renamed from: b */
    public static final String m8399b(byte[] bArr) {
        return m8396a(bArr, 0, bArr.length);
    }
}
