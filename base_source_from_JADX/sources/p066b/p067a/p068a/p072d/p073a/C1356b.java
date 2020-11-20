package p066b.p067a.p068a.p072d.p073a;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import javax.crypto.Cipher;
import org.jetbrains.annotations.NotNull;
import p066b.p067a.p068a.p072d.p074b.C1361a;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;

/* renamed from: b.a.a.d.a.b */
public final class C1356b {

    /* renamed from: a */
    private RSAPrivateKey f4154a;

    /* renamed from: b */
    private Cipher f4155b;

    public C1356b(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        C3250h.m9056b(bArr, "mod");
        C3250h.m9056b(bArr2, "exp");
        mo6706a(bArr, bArr2);
    }

    /* renamed from: a */
    public final void mo6706a(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        C3250h.m9056b(bArr, "modulo");
        C3250h.m9056b(bArr2, "esponente");
        BigInteger bigInteger = new BigInteger(C1361a.m5244a(bArr), 16);
        BigInteger bigInteger2 = new BigInteger(C1361a.m5244a(bArr2), 16);
        KeyFactory instance = KeyFactory.getInstance("RSA");
        RSAPrivateKeySpec rSAPrivateKeySpec = new RSAPrivateKeySpec(bigInteger, bigInteger2);
        this.f4155b = Cipher.getInstance("RSA/ECB/NoPadding");
        if (instance == null) {
            C3250h.m9052a();
        }
        PrivateKey generatePrivate = instance.generatePrivate(rSAPrivateKeySpec);
        if (generatePrivate != null) {
            this.f4154a = (RSAPrivateKey) generatePrivate;
            return;
        }
        throw new C3266f("null cannot be cast to non-null type java.security.interfaces.RSAPrivateKey");
    }

    @NotNull
    /* renamed from: a */
    public final byte[] mo6707a(@NotNull byte[] bArr) {
        C3250h.m9056b(bArr, "data");
        Cipher cipher = this.f4155b;
        if (cipher == null) {
            C3250h.m9052a();
        }
        cipher.init(2, this.f4154a);
        Cipher cipher2 = this.f4155b;
        if (cipher2 == null) {
            C3250h.m9052a();
        }
        byte[] doFinal = cipher2.doFinal(bArr);
        C3250h.m9053a((Object) doFinal, "cipher!!.doFinal(data)");
        return doFinal;
    }
}
