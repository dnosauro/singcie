package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzegk implements zzehr {
    private static final ThreadLocal<Cipher> zziag = new zzegm();
    private final SecretKeySpec zzifv;
    private final int zzifw;
    private final int zzifx = zziag.get().getBlockSize();

    public zzegk(byte[] bArr, int i) {
        zzeic.zzft(bArr.length);
        this.zzifv = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.zzifx) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzifw = i;
    }

    public final byte[] zzn(byte[] bArr) {
        int length = bArr.length;
        int i = this.zzifw;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] zzfs = zzehx.zzfs(i);
            System.arraycopy(zzfs, 0, bArr2, 0, this.zzifw);
            int length2 = bArr.length;
            int i2 = this.zzifw;
            Cipher cipher = zziag.get();
            byte[] bArr3 = new byte[this.zzifx];
            System.arraycopy(zzfs, 0, bArr3, 0, this.zzifw);
            cipher.init(1, this.zzifv, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        int i3 = Integer.MAX_VALUE - i;
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(i3);
        throw new GeneralSecurityException(sb.toString());
    }
}
