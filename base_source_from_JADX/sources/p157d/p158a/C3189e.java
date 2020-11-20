package p157d.p158a;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p162a.C3219b;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.a.e */
class C3189e extends C3188d {
    /* renamed from: a */
    public static final char m8977a(@NotNull char[] cArr) {
        C3250h.m9056b(cArr, "$this$single");
        switch (cArr.length) {
            case 0:
                throw new NoSuchElementException("Array is empty.");
            case 1:
                return cArr[0];
            default:
                throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @NotNull
    /* renamed from: a */
    public static final <A extends Appendable> A m8978a(@NotNull byte[] bArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable C3219b<? super Byte, ? extends CharSequence> bVar) {
        C3250h.m9056b(bArr, "$this$joinTo");
        C3250h.m9056b(a, "buffer");
        C3250h.m9056b(charSequence, "separator");
        C3250h.m9056b(charSequence2, "prefix");
        C3250h.m9056b(charSequence3, "postfix");
        C3250h.m9056b(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            a.append((CharSequence) (bVar != null ? bVar.mo6730a(Byte.valueOf(b)) : String.valueOf(b)));
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    /* renamed from: a */
    public static final String m8979a(@NotNull byte[] bArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable C3219b<? super Byte, ? extends CharSequence> bVar) {
        C3250h.m9056b(bArr, "$this$joinToString");
        C3250h.m9056b(charSequence, "separator");
        C3250h.m9056b(charSequence2, "prefix");
        C3250h.m9056b(charSequence3, "postfix");
        C3250h.m9056b(charSequence4, "truncated");
        String sb = ((StringBuilder) C3184a.m8978a(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        C3250h.m9053a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    /* renamed from: a */
    public static /* synthetic */ String m8980a(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, C3219b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        CharSequence charSequence5 = charSequence2;
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        CharSequence charSequence6 = charSequence3;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            bVar = null;
        }
        return C3184a.m8979a(bArr, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }
}
