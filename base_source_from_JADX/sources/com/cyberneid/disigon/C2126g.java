package com.cyberneid.disigon;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: com.cyberneid.disigon.g */
public class C2126g {
    /* renamed from: a */
    public static void m8374a(InputStream inputStream, OutputStream outputStream) {
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
