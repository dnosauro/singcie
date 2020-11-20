package com.cyberneid.p105d.p109c;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* renamed from: com.cyberneid.d.c.k */
final class C1649k extends C1647i {
    C1649k() {
    }

    /* renamed from: a */
    private static void m6604a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[2048];
        int read = inputStream.read(bArr);
        if (read > 0) {
            Inflater inflater = new Inflater();
            inflater.setInput(bArr, 0, read);
            byte[] bArr2 = new byte[2048];
            while (true) {
                int inflate = inflater.inflate(bArr2);
                if (inflate == 0) {
                    if (inflater.finished() || inflater.needsDictionary() || inputStream.available() == 0) {
                        break;
                    }
                    inflater.setInput(bArr, 0, inputStream.read(bArr));
                } else {
                    outputStream.write(bArr2, 0, inflate);
                }
            }
        }
        outputStream.flush();
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        C1607d a = m6599a(dVar, i);
        int g = a != null ? a.mo7547g(C1613i.f5189fF) : -1;
        if (g > 1) {
            try {
                int min = Math.min(a.mo7529b(C1613i.f4928aJ, 1), 32);
                int b = a.mo7529b(C1613i.f4907P, 8);
                int b2 = a.mo7529b(C1613i.f4930aL, 1);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                m6604a(inputStream, byteArrayOutputStream);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                C1652n.m6615a(g, min, b, b2, byteArrayInputStream, outputStream);
                outputStream.flush();
                byteArrayOutputStream.reset();
                byteArrayInputStream.reset();
            } catch (DataFormatException e) {
                Log.e("PdfBox-Android", "FlateFilter: stop reading corrupt stream due to a DataFormatException");
                throw new IOException(e);
            }
        } else {
            m6604a(inputStream, outputStream);
        }
        return new C1646h(dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar) {
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream);
        int available = inputStream.available();
        if (available > 0) {
            byte[] bArr = new byte[Math.min(available, 16348)];
            while (true) {
                int read = inputStream.read(bArr, 0, Math.min(available, 16348));
                if (read == -1) {
                    break;
                }
                deflaterOutputStream.write(bArr, 0, read);
            }
        }
        deflaterOutputStream.close();
        outputStream.flush();
    }
}
