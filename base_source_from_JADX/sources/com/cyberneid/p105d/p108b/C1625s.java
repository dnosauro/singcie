package com.cyberneid.p105d.p108b;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.eac.CertificateBody;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.cyberneid.d.b.s */
final class C1625s {

    /* renamed from: a */
    private static final int[] f5388a = new int[256];

    /* renamed from: b */
    private static final Map<Character, Integer> f5389b = new HashMap(256);

    static {
        for (int i = 0; i < 256; i++) {
            m6519a(i, (char) i);
        }
        m6519a(24, 728);
        m6519a(25, 711);
        m6519a(26, 710);
        m6519a(27, 729);
        m6519a(28, 733);
        m6519a(29, 731);
        m6519a(30, 730);
        m6519a(31, 732);
        m6519a(CertificateBody.profileType, 65533);
        m6519a(128, 8226);
        m6519a(129, 8224);
        m6519a(130, 8225);
        m6519a(131, 8230);
        m6519a(CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, 8212);
        m6519a(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 8211);
        m6519a(CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA, 402);
        m6519a(135, 8260);
        m6519a(CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, 8249);
        m6519a(137, 8250);
        m6519a(CipherSuite.TLS_PSK_WITH_RC4_128_SHA, 8722);
        m6519a(139, 8240);
        m6519a(140, 8222);
        m6519a(141, 8220);
        m6519a(142, 8221);
        m6519a(CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 8216);
        m6519a(CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 8217);
        m6519a(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 8218);
        m6519a(CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 8482);
        m6519a(CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 64257);
        m6519a(CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, 64258);
        m6519a(CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 321);
        m6519a(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 338);
        m6519a(CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 352);
        m6519a(CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 376);
        m6519a(153, 381);
        m6519a(CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 305);
        m6519a(155, 322);
        m6519a(CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 339);
        m6519a(CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, 353);
        m6519a(CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 382);
        m6519a(CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, 65533);
        m6519a(160, 8364);
    }

    /* renamed from: a */
    public static String m6518a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            byte b2 = b & 255;
            int[] iArr = f5388a;
            sb.append(b2 >= iArr.length ? '?' : (char) iArr[b2]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m6519a(int i, char c) {
        f5388a[i] = c;
        f5389b.put(Character.valueOf(c), Integer.valueOf(i));
    }

    /* renamed from: a */
    public static boolean m6520a(char c) {
        return f5389b.containsKey(Character.valueOf(c));
    }

    /* renamed from: a */
    public static byte[] m6521a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (char valueOf : str.toCharArray()) {
            Integer num = f5389b.get(Character.valueOf(valueOf));
            if (num == null) {
                byteArrayOutputStream.write(0);
            } else {
                byteArrayOutputStream.write(num.intValue());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
