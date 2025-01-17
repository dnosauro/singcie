package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import org.apache.commons.p172io.FilenameUtils;

@KeepForSdk
public final class HexDumpUtils {
    @KeepForSdk
    public static String dump(byte[] bArr, int i, int i2, boolean z) {
        Object[] objArr;
        String str;
        if (bArr == null || bArr.length == 0 || i < 0 || i2 <= 0 || i + i2 > bArr.length) {
            return null;
        }
        int i3 = 57;
        if (z) {
            i3 = 75;
        }
        StringBuilder sb = new StringBuilder(i3 * (((i2 + 16) - 1) / 16));
        int i4 = i;
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i5 > 0) {
            if (i6 == 0) {
                if (i2 < 65536) {
                    str = "%04X:";
                    objArr = new Object[]{Integer.valueOf(i4)};
                } else {
                    str = "%08X:";
                    objArr = new Object[]{Integer.valueOf(i4)};
                }
                sb.append(String.format(str, objArr));
                i7 = i4;
            } else if (i6 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i4] & 255)}));
            i5--;
            i6++;
            if (z && (i6 == 16 || i5 == 0)) {
                int i8 = 16 - i6;
                if (i8 > 0) {
                    for (int i9 = 0; i9 < i8; i9++) {
                        sb.append("   ");
                    }
                }
                if (i8 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i10 = 0; i10 < i6; i10++) {
                    char c = (char) bArr[i7 + i10];
                    if (c < ' ' || c > '~') {
                        c = FilenameUtils.EXTENSION_SEPARATOR;
                    }
                    sb.append(c);
                }
            }
            if (i6 == 16 || i5 == 0) {
                sb.append(10);
                i6 = 0;
            }
            i4++;
        }
        return sb.toString();
    }
}
