package p066b.p067a.p068a.p072d;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;
import p157d.p161d.p163b.C3256m;

/* renamed from: b.a.a.d.a */
public final class C1354a {
    @NotNull

    /* renamed from: a */
    private byte[] f4151a = new byte[0];
    @NotNull

    /* renamed from: b */
    private byte[] f4152b = new byte[0];

    public C1354a(@NotNull byte[] bArr) {
        C3250h.m9056b(bArr, "fullResponse");
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - 2);
        C3250h.m9053a((Object) copyOfRange, "Arrays.copyOfRange(fullR…0, fullResponse.size - 2)");
        this.f4151a = copyOfRange;
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - 2, bArr.length);
        C3250h.m9053a((Object) copyOfRange2, "Arrays.copyOfRange(fullR…e - 2, fullResponse.size)");
        this.f4152b = copyOfRange2;
    }

    public C1354a(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        C3250h.m9056b(bArr, "res");
        C3250h.m9056b(bArr2, "sw");
        this.f4151a = bArr;
        this.f4152b = bArr2;
    }

    /* renamed from: a */
    private final String m5210a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            C3256m mVar = C3256m.f7307a;
            Object[] objArr = {Byte.valueOf(bArr[i])};
            String format = String.format("%02x", Arrays.copyOf(objArr, objArr.length));
            C3250h.m9053a((Object) format, "java.lang.String.format(format, *args)");
            sb.append(format);
        }
        String sb2 = sb.toString();
        C3250h.m9053a((Object) sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    /* renamed from: a */
    public final byte[] mo6698a() {
        return this.f4151a;
    }

    @NotNull
    /* renamed from: b */
    public final byte[] mo6699b() {
        return this.f4152b;
    }

    @NotNull
    /* renamed from: c */
    public final String mo6700c() {
        return m5210a(this.f4152b);
    }

    /* renamed from: d */
    public final int mo6701d() {
        return C1358b.f4157a.mo6711a(this.f4152b);
    }
}
