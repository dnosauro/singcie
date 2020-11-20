package com.cyberneid.p105d.p109c;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1607d;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.o */
final class C1653o extends C1647i {
    C1653o() {
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        byte[] bArr = new byte[128];
        while (true) {
            int read = inputStream.read();
            if (read != -1 && read != 128) {
                if (read <= 127) {
                    int i2 = read + 1;
                    while (i2 > 0) {
                        int read2 = inputStream.read(bArr, 0, i2);
                        outputStream.write(bArr, 0, read2);
                        i2 -= read2;
                    }
                } else {
                    int read3 = inputStream.read();
                    for (int i3 = 0; i3 < 257 - read; i3++) {
                        outputStream.write(read3);
                    }
                }
            }
        }
        return new C1646h(dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar) {
        Log.w("PdfBox-Android", "RunLengthDecodeFilter.encode is not implemented yet, skipping this stream.");
    }
}
