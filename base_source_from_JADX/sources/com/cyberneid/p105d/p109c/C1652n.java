package com.cyberneid.p105d.p109c;

import com.cyberneid.p105d.p111d.C1654a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.n */
public final class C1652n {
    /* renamed from: a */
    static void m6615a(int i, int i2, int i3, int i4, InputStream inputStream, OutputStream outputStream) {
        int i5 = i;
        int i6 = i3;
        if (i5 == 1) {
            C1654a.m6618a(inputStream, outputStream);
            return;
        }
        int i7 = i2 * i6;
        int i8 = (i7 + 7) / 8;
        int i9 = ((i7 * i4) + 7) / 8;
        byte[] bArr = new byte[i9];
        byte[] bArr2 = new byte[i9];
        int i10 = i5;
        while (inputStream.available() > 0) {
            if (i5 >= 10) {
                int read = inputStream.read();
                if (read != -1) {
                    i10 = read + 10;
                } else {
                    return;
                }
            }
            int i11 = 0;
            while (true) {
                if (i11 >= i9) {
                    InputStream inputStream2 = inputStream;
                } else {
                    int read2 = inputStream.read(bArr, i11, i9 - i11);
                    if (read2 != -1) {
                        i11 += read2;
                    }
                }
            }
            if (i10 != 2) {
                switch (i10) {
                    case 11:
                        for (int i12 = 0; i12 < i9; i12++) {
                            int i13 = i12 - i8;
                            bArr[i12] = (byte) (bArr[i12] + (i13 >= 0 ? bArr[i13] : 0));
                        }
                        break;
                    case 12:
                        for (int i14 = 0; i14 < i9; i14++) {
                            bArr[i14] = (byte) (((bArr[i14] & 255) + (bArr2[i14] & 255)) & 255);
                        }
                        break;
                    case 13:
                        for (int i15 = 0; i15 < i9; i15++) {
                            int i16 = i15 - i8;
                            bArr[i15] = (byte) (((bArr[i15] & 255) + (((i16 >= 0 ? bArr[i16] & 255 : 0) + (bArr2[i15] & 255)) / 2)) & 255);
                        }
                        break;
                    case 14:
                        for (int i17 = 0; i17 < i9; i17++) {
                            byte b = bArr[i17] & 255;
                            int i18 = i17 - i8;
                            byte b2 = i18 >= 0 ? bArr[i18] & 255 : 0;
                            byte b3 = bArr2[i17] & 255;
                            byte b4 = i18 >= 0 ? bArr2[i18] & 255 : 0;
                            int i19 = (b2 + b3) - b4;
                            int abs = Math.abs(i19 - b2);
                            int abs2 = Math.abs(i19 - b3);
                            int abs3 = Math.abs(i19 - b4);
                            if (abs <= abs2 && abs <= abs3) {
                                bArr[i17] = (byte) ((b + b2) & 255);
                            } else if (abs2 <= abs3) {
                                bArr[i17] = (byte) ((b + b3) & 255);
                            } else {
                                bArr[i17] = (byte) ((b + b4) & 255);
                            }
                        }
                        break;
                }
            } else if (i6 == 16) {
                for (int i20 = 0; i20 < i9; i20 += 2) {
                    int i21 = i20 + 1;
                    int i22 = i20 - i8;
                    int i23 = ((bArr[i20] & 255) << 8) + (bArr[i21] & 255) + (i22 >= 0 ? (bArr[i22 + 1] & 255) + ((bArr[i22] & 255) << 8) : 0);
                    bArr[i20] = (byte) ((i23 >> 8) & 255);
                    bArr[i21] = (byte) (i23 & 255);
                }
            } else if (i6 >= 8) {
                for (int i24 = 0; i24 < i9; i24++) {
                    int i25 = i24 - i8;
                    bArr[i24] = (byte) ((bArr[i24] & 255) + (i25 >= 0 ? bArr[i25] & 255 : 0));
                }
            } else {
                throw new IOException("TIFF-Predictor with " + i6 + " bits per component not supported; please open JIRA issue with sample PDF");
            }
            System.arraycopy(bArr, 0, bArr2, 0, i9);
            outputStream.write(bArr);
        }
    }
}
