package com.cyberneid.p105d.p131h;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.h.c */
public final class C1939c {

    /* renamed from: a */
    private static final byte[] f6138a = {ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SET_TYPE, 50, 51, 52, 53, 54, 55, 56, 57, 65, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 67, 68, 69, 70};

    /* renamed from: b */
    private static final char[] f6139b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m7981a(byte b) {
        return Integer.toHexString((b & 255) | 256).substring(1).toUpperCase();
    }

    /* renamed from: a */
    public static void m7982a(byte b, OutputStream outputStream) {
        outputStream.write(f6138a[m7986c(b)]);
        outputStream.write(f6138a[m7987d(b)]);
    }

    /* renamed from: a */
    public static void m7983a(byte[] bArr, OutputStream outputStream) {
        for (byte a : bArr) {
            m7982a(a, outputStream);
        }
    }

    /* renamed from: a */
    public static byte[] m7984a(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr2[i2] = f6138a[m7986c(bArr[i])];
            bArr2[i2 + 1] = f6138a[m7987d(bArr[i])];
        }
        return bArr2;
    }

    /* renamed from: b */
    public static byte[] m7985b(byte b) {
        return m7981a(b).getBytes(C1933a.f6108a);
    }

    /* renamed from: c */
    private static int m7986c(byte b) {
        return (b & 240) >> 4;
    }

    /* renamed from: d */
    private static int m7987d(byte b) {
        return b & 15;
    }
}
