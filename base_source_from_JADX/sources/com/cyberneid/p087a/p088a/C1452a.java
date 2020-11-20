package com.cyberneid.p087a.p088a;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: com.cyberneid.a.a.a */
public class C1452a {
    /* renamed from: a */
    public static void m5478a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[PKIFailureInfo.certRevoked];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
