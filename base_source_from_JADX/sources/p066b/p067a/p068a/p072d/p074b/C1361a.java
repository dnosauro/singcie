package p066b.p067a.p068a.p072d.p074b;

import org.jetbrains.annotations.NotNull;
import p157d.p158a.C3184a;
import p157d.p161d.p162a.C3219b;
import p157d.p161d.p163b.C3250h;
import p157d.p161d.p163b.C3251i;
import p157d.p166g.C3272a;
import p157d.p166g.C3278f;

/* renamed from: b.a.a.d.b.a */
public final class C1361a {

    /* renamed from: b.a.a.d.b.a$a */
    static final class C1362a extends C3251i implements C3219b<Byte, String> {

        /* renamed from: a */
        public static final C1362a f4158a = new C1362a();

        C1362a() {
            super(1);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo6730a(Object obj) {
            return mo6731a(((Number) obj).byteValue());
        }

        @NotNull
        /* renamed from: a */
        public final String mo6731a(byte b) {
            String num = Integer.toString(b & 255, C3272a.m9079a(16));
            C3250h.m9053a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            return C3278f.m9094a(num, 2, '0');
        }
    }

    @NotNull
    /* renamed from: a */
    public static final String m5244a(@NotNull byte[] bArr) {
        C3250h.m9056b(bArr, "receiver$0");
        return C3184a.m8980a(bArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C1362a.f4158a, 30, (Object) null);
    }

    @NotNull
    /* renamed from: a */
    public static final byte[] m5245a(@NotNull String str) {
        C3250h.m9056b(str, "receiver$0");
        byte[] bArr = new byte[(str.length() / 2)];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String substring = str.substring(i2, i2 + 2);
            C3250h.m9053a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            bArr[i] = (byte) Integer.parseInt(substring, C3272a.m9079a(16));
        }
        return bArr;
    }
}
