package com.cyberneid.p105d.p109c;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p131h.C1939c;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.d */
final class C1642d extends C1647i {

    /* renamed from: a */
    private static final int[] f5452a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15};

    C1642d() {
    }

    /* renamed from: a */
    private boolean m6587a(int i) {
        return i == 0 || i == 9 || i == 10 || i == 12 || i == 13 || i == 32;
    }

    /* renamed from: b */
    private boolean m6588b(int i) {
        return i == 62;
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            while (m6587a(read)) {
                read = inputStream.read();
            }
            if (read == -1 || m6588b(read)) {
                break;
            }
            if (f5452a[read] == -1) {
                Log.e("PdfBox-Android", "Invalid hex, int: " + read + " char: " + ((char) read));
            }
            int i2 = f5452a[read] * 16;
            int read2 = inputStream.read();
            if (read2 == -1 || m6588b(read2)) {
                outputStream.write(i2);
            } else {
                if (read2 >= 0) {
                    if (f5452a[read2] == -1) {
                        Log.e("PdfBox-Android", "Invalid hex, int: " + read2 + " char: " + ((char) read2));
                    }
                    i2 += f5452a[read2];
                }
                outputStream.write(i2);
            }
        }
        outputStream.flush();
        return new C1646h(dVar);
    }

    /* renamed from: a */
    public void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar) {
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                outputStream.write(C1939c.m7985b((byte) read));
            } else {
                outputStream.flush();
                return;
            }
        }
    }
}
