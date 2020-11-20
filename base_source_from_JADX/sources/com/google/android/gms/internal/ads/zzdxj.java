package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public final class zzdxj {
    private static final OutputStream zzhvt = new zzdxi();

    public static byte[] toByteArray(InputStream inputStream) {
        int i;
        zzdvv.checkNotNull(inputStream);
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int i2 = PKIFailureInfo.certRevoked;
        for (int i3 = 0; i3 < 2147483639; i3 = i) {
            byte[] bArr = new byte[Math.min(i2, 2147483639 - i3)];
            arrayDeque.add(bArr);
            i = i3;
            int i4 = 0;
            while (i4 < bArr.length) {
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                if (read == -1) {
                    return zza(arrayDeque, i);
                }
                i4 += read;
                i += read;
            }
            i2 = zzdxk.zzy(i2, 2);
        }
        if (inputStream.read() == -1) {
            return zza(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] zza(Queue<byte[]> queue, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            byte[] remove = queue.remove();
            int min = Math.min(i2, remove.length);
            System.arraycopy(remove, 0, bArr, i - i2, min);
            i2 -= min;
        }
        return bArr;
    }
}
