package p066b.p067a.p068a.p072d.p073a;

import java.security.MessageDigest;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import p157d.p161d.p163b.C3250h;

/* renamed from: b.a.a.d.a.c */
public final class C1357c {

    /* renamed from: a */
    public static final C1357c f4156a = new C1357c();

    private C1357c() {
    }

    @NotNull
    /* renamed from: a */
    public final byte[] mo6708a(@NotNull byte[] bArr) {
        C3250h.m9056b(bArr, "data");
        byte[] digest = MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA256).digest(bArr);
        C3250h.m9053a((Object) digest, "md.digest(data)");
        return digest;
    }
}
