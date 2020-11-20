package p157d.p166g;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.g.o */
class C3287o extends C3286n {
    /* renamed from: a */
    public static final boolean m9081a(@NotNull String str, int i, @NotNull String str2, int i2, int i3, boolean z) {
        C3250h.m9056b(str, "$this$regionMatches");
        C3250h.m9056b(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    /* renamed from: a */
    public static final boolean m9082a(@Nullable String str, @Nullable String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }
}
