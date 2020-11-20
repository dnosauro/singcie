package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class zzeht implements zzedb {
    private final SecretKey zziah;
    private byte[] zzihq;
    private byte[] zzihr = zzegs.zzp(this.zzihq);

    public zzeht(byte[] bArr) {
        zzeic.zzft(bArr.length);
        this.zziah = new SecretKeySpec(bArr, "AES");
        Cipher zzbfa = zzbfa();
        zzbfa.init(1, this.zziah);
        this.zzihq = zzegs.zzp(zzbfa.doFinal(new byte[16]));
    }

    private static Cipher zzbfa() {
        return zzehh.zzihd.zzhq("AES/ECB/NoPadding");
    }

    public final byte[] zzd(byte[] bArr, int i) {
        byte[] bArr2;
        if (i <= 16) {
            Cipher zzbfa = zzbfa();
            zzbfa.init(1, this.zziah);
            int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
            if ((max << 4) == bArr.length) {
                bArr2 = zzegr.zza(bArr, (max - 1) << 4, this.zzihq, 0, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
                if (copyOfRange.length < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                    bArr2 = zzegr.zzd(copyOf, this.zzihr);
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = zzbfa.doFinal(zzegr.zza(bArr3, 0, bArr, i2 << 4, 16));
            }
            return Arrays.copyOf(zzbfa.doFinal(zzegr.zzd(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
