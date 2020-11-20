package p066b.p067a.p068a.p072d.p073a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

/* renamed from: b.a.a.d.a.a */
public final class C1355a {

    /* renamed from: a */
    public static final C1355a f4153a = new C1355a();

    private C1355a() {
    }

    @NotNull
    /* renamed from: a */
    public final byte[] mo6702a(@NotNull byte[] bArr, int i, int i2) {
        C3250h.m9056b(bArr, "array");
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        return bArr2;
    }

    @NotNull
    /* renamed from: a */
    public final byte[] mo6703a(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        C3250h.m9056b(bArr, "masterKey");
        C3250h.m9056b(bArr2, "data");
        byte[] bArr3 = new byte[8];
        byte[] bArr4 = new byte[8];
        byte[] bArr5 = new byte[8];
        System.arraycopy(bArr, 0, bArr3, 0, 8);
        int i = 16;
        System.arraycopy(bArr, bArr.length >= 16 ? 8 : 0, bArr4, 0, 8);
        if (bArr.length < 24) {
            i = 0;
        }
        System.arraycopy(bArr, i, bArr5, 0, 8);
        byte[] b = mo6704b(bArr3, bArr2);
        return mo6704b(bArr5, mo6702a(mo6705c(bArr4, mo6702a(b, b.length - 8, 8)), 0, 8));
    }

    @NotNull
    /* renamed from: b */
    public final byte[] mo6704b(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        C3250h.m9056b(bArr, "masterKey");
        C3250h.m9056b(bArr2, "data");
        byte[] bArr3 = new byte[24];
        if (bArr.length == 8) {
            System.arraycopy(bArr, 0, bArr3, 0, 8);
            System.arraycopy(bArr, 0, bArr3, 8, 8);
        } else {
            if (bArr.length == 16) {
                System.arraycopy(bArr, 0, bArr3, 0, 16);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "TripleDES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[8]);
            Cipher instance = Cipher.getInstance("DESede/CBC/NoPadding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            byte[] doFinal = instance.doFinal(bArr2);
            C3250h.m9053a((Object) doFinal, "cipher.doFinal(data)");
            return doFinal;
        }
        System.arraycopy(bArr, 0, bArr3, 16, 8);
        bArr = bArr3;
        SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "TripleDES");
        IvParameterSpec ivParameterSpec2 = new IvParameterSpec(new byte[8]);
        Cipher instance2 = Cipher.getInstance("DESede/CBC/NoPadding");
        instance2.init(1, secretKeySpec2, ivParameterSpec2);
        byte[] doFinal2 = instance2.doFinal(bArr2);
        C3250h.m9053a((Object) doFinal2, "cipher.doFinal(data)");
        return doFinal2;
    }

    @NotNull
    /* renamed from: c */
    public final byte[] mo6705c(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        C3250h.m9056b(bArr, "masterKey");
        C3250h.m9056b(bArr2, "data");
        byte[] bArr3 = new byte[24];
        if (bArr.length == 8) {
            System.arraycopy(bArr, 0, bArr3, 0, 8);
            System.arraycopy(bArr, 0, bArr3, 8, 8);
        } else {
            if (bArr.length == 16) {
                System.arraycopy(bArr, 0, bArr3, 0, 16);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "TripleDES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[8]);
            Cipher instance = Cipher.getInstance("DESede/CBC/NoPadding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            byte[] doFinal = instance.doFinal(bArr2);
            C3250h.m9053a((Object) doFinal, "decipher.doFinal(data)");
            return doFinal;
        }
        System.arraycopy(bArr, 0, bArr3, 16, 8);
        bArr = bArr3;
        SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "TripleDES");
        IvParameterSpec ivParameterSpec2 = new IvParameterSpec(new byte[8]);
        Cipher instance2 = Cipher.getInstance("DESede/CBC/NoPadding");
        instance2.init(2, secretKeySpec2, ivParameterSpec2);
        byte[] doFinal2 = instance2.doFinal(bArr2);
        C3250h.m9053a((Object) doFinal2, "decipher.doFinal(data)");
        return doFinal2;
    }
}
