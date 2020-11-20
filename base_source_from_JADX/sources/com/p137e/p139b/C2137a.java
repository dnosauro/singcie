package com.p137e.p139b;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.e.b.a */
public class C2137a {

    /* renamed from: a */
    static final char[] f6598a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* renamed from: a */
    static int m8390a(byte b) {
        int i;
        if (b >= 65 && b <= 90) {
            return b - 65;
        }
        if (b >= 97 && b <= 122) {
            i = b - LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE;
        } else if (b >= 48 && b <= 57) {
            i = (b - ASN1Constants.UNIVERSAL_SEQUENCE_TYPE) + 26;
        } else if (b == 43) {
            return 62;
        } else {
            if (b == 47) {
                return 63;
            }
            if (b == 61) {
                return 0;
            }
            throw new RuntimeException("unexpected code: " + b);
        }
        return i + 26;
    }

    /* renamed from: a */
    public static void m8391a(String str, OutputStream outputStream) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else if (i != length) {
                int i2 = i + 2;
                int i3 = i + 3;
                int a = (m8390a((byte) str.charAt(i)) << 18) + (m8390a((byte) str.charAt(i + 1)) << 12) + (m8390a((byte) str.charAt(i2)) << 6) + m8390a((byte) str.charAt(i3));
                outputStream.write((a >> 16) & 255);
                if (str.charAt(i2) != '=') {
                    outputStream.write((a >> 8) & 255);
                    if (str.charAt(i3) != '=') {
                        outputStream.write(a & 255);
                        i += 4;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static byte[] m8392a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m8391a(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new RuntimeException();
        }
    }
}
