package com.p137e.p139b;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: com.e.b.c */
public class C2139c {
    /* renamed from: a */
    public static byte[] m8400a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[10000];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
