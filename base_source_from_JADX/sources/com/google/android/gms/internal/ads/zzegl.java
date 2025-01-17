package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzegl implements zzdzt {
    private static final ThreadLocal<Cipher> zzify = new zzego();
    private static final ThreadLocal<Cipher> zzifz = new zzegn();
    private final SecretKeySpec zzifv;
    private final byte[] zziga;
    private final byte[] zzigb;
    private final int zzigc;

    public zzegl(byte[] bArr, int i) {
        if (i == 12 || i == 16) {
            this.zzigc = i;
            zzeic.zzft(bArr.length);
            this.zzifv = new SecretKeySpec(bArr, "AES");
            Cipher cipher = zzify.get();
            cipher.init(1, this.zzifv);
            this.zziga = zzo(cipher.doFinal(new byte[16]));
            this.zzigb = zzo(this.zziga);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        byte[] zzd;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            zzd = zzd(bArr3, this.zziga);
        } else {
            byte[] doFinal = cipher.doFinal(bArr3);
            byte[] bArr4 = doFinal;
            int i4 = 0;
            while (i3 - i4 > 16) {
                for (int i5 = 0; i5 < 16; i5++) {
                    bArr4[i5] = (byte) (bArr4[i5] ^ bArr[(i2 + i4) + i5]);
                }
                bArr4 = cipher.doFinal(bArr4);
                i4 += 16;
            }
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
            if (copyOfRange.length == 16) {
                bArr2 = zzd(copyOfRange, this.zziga);
            } else {
                byte[] copyOf = Arrays.copyOf(this.zzigb, 16);
                for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                    copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
                }
                copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
                bArr2 = copyOf;
            }
            zzd = zzd(bArr4, bArr2);
        }
        return cipher.doFinal(zzd);
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] zzo(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7));
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        int length = bArr3.length;
        int i = this.zzigc;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr4 = new byte[(bArr3.length + i + 16)];
            byte[] zzfs = zzehx.zzfs(i);
            System.arraycopy(zzfs, 0, bArr4, 0, this.zzigc);
            Cipher cipher = zzify.get();
            cipher.init(1, this.zzifv);
            byte[] zza = zza(cipher, 0, zzfs, 0, zzfs.length);
            byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
            byte[] zza2 = zza(cipher, 1, bArr5, 0, bArr5.length);
            Cipher cipher2 = zzifz.get();
            cipher2.init(1, this.zzifv, new IvParameterSpec(zza));
            cipher2.doFinal(bArr, 0, bArr3.length, bArr4, this.zzigc);
            byte[] zza3 = zza(cipher, 2, bArr4, this.zzigc, bArr3.length);
            int length2 = bArr3.length + this.zzigc;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr4[length2 + i2] = (byte) ((zza2[i2] ^ zza[i2]) ^ zza3[i2]);
            }
            return bArr4;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
