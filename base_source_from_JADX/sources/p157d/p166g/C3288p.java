package p157d.p166g;

import org.jetbrains.annotations.NotNull;
import p157d.p158a.C3184a;
import p157d.p161d.p163b.C3250h;
import p157d.p164e.C3258a;
import p157d.p164e.C3261c;
import p157d.p164e.C3263d;

/* renamed from: d.g.p */
class C3288p extends C3287o {
    /* renamed from: a */
    public static final int m9083a(@NotNull CharSequence charSequence) {
        C3250h.m9056b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    /* renamed from: a */
    public static final int m9084a(@NotNull CharSequence charSequence, char c, int i, boolean z) {
        C3250h.m9056b(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return C3278f.m9090a(charSequence, new char[]{c}, i, z);
    }

    /* renamed from: a */
    public static /* synthetic */ int m9085a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C3278f.m9084a(charSequence, c, i, z);
    }

    /* renamed from: a */
    private static final int m9086a(@NotNull CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        C3258a cVar = !z2 ? new C3261c(C3263d.m9076b(i, 0), C3263d.m9077c(i2, charSequence.length())) : C3263d.m9075a(C3263d.m9077c(i, C3278f.m9083a(charSequence)), C3263d.m9076b(i2, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a = cVar.mo25707a();
            int b = cVar.mo25708b();
            int c = cVar.mo25709c();
            if (c >= 0) {
                if (a > b) {
                    return -1;
                }
            } else if (a < b) {
                return -1;
            }
            while (true) {
                if (C3278f.m9097a(charSequence2, 0, charSequence, a, charSequence2.length(), z)) {
                    return a;
                }
                if (a == b) {
                    return -1;
                }
                a += c;
            }
        } else {
            int a2 = cVar.mo25707a();
            int b2 = cVar.mo25708b();
            int c2 = cVar.mo25709c();
            if (c2 >= 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (true) {
                if (C3278f.m9081a((String) charSequence2, 0, (String) charSequence, a2, charSequence2.length(), z)) {
                    return a2;
                }
                if (a2 == b2) {
                    return -1;
                }
                a2 += c2;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m9087a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return m9086a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    /* renamed from: a */
    public static final int m9088a(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        C3250h.m9056b(charSequence, "$this$indexOf");
        C3250h.m9056b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return m9087a(charSequence, str, i, charSequence.length(), z, false, 16, (Object) null);
    }

    /* renamed from: a */
    public static /* synthetic */ int m9089a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C3278f.m9088a(charSequence, str, i, z);
    }

    /* renamed from: a */
    public static final int m9090a(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        boolean z2;
        C3250h.m9056b(charSequence, "$this$indexOfAny");
        C3250h.m9056b(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int b = C3263d.m9076b(i, 0);
            int a = C3278f.m9083a(charSequence);
            if (b > a) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(b);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (C3272a.m9080a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return b;
                }
                if (b == a) {
                    return -1;
                }
                b++;
            }
        } else {
            return ((String) charSequence).indexOf(C3184a.m8977a(cArr), i);
        }
    }

    @NotNull
    /* renamed from: a */
    public static final CharSequence m9091a(@NotNull CharSequence charSequence, int i, char c) {
        C3250h.m9056b(charSequence, "$this$padStart");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    @NotNull
    /* renamed from: a */
    public static final String m9092a(@NotNull String str, char c, @NotNull String str2) {
        C3250h.m9056b(str, "$this$substringAfter");
        C3250h.m9056b(str2, "missingDelimiterValue");
        int a = C3278f.m9085a((CharSequence) str, c, 0, false, 6, (Object) null);
        if (a == -1) {
            return str2;
        }
        String substring = str.substring(a + 1, str.length());
        C3250h.m9053a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: a */
    public static /* synthetic */ String m9093a(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return C3278f.m9092a(str, c, str2);
    }

    @NotNull
    /* renamed from: a */
    public static final String m9094a(@NotNull String str, int i, char c) {
        C3250h.m9056b(str, "$this$padStart");
        return C3278f.m9091a((CharSequence) str, i, c).toString();
    }

    @NotNull
    /* renamed from: a */
    public static final String m9095a(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        C3250h.m9056b(str, "$this$substringAfter");
        C3250h.m9056b(str2, "delimiter");
        C3250h.m9056b(str3, "missingDelimiterValue");
        int a = C3278f.m9089a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (a == -1) {
            return str3;
        }
        String substring = str.substring(a + str2.length(), str.length());
        C3250h.m9053a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: a */
    public static /* synthetic */ String m9096a(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return C3278f.m9095a(str, str2, str3);
    }

    /* renamed from: a */
    public static final boolean m9097a(@NotNull CharSequence charSequence, int i, @NotNull CharSequence charSequence2, int i2, int i3, boolean z) {
        C3250h.m9056b(charSequence, "$this$regionMatchesImpl");
        C3250h.m9056b(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!C3272a.m9080a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static final int m9098b(@NotNull CharSequence charSequence, char c, int i, boolean z) {
        C3250h.m9056b(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return C3278f.m9100b(charSequence, new char[]{c}, i, z);
    }

    /* renamed from: b */
    public static /* synthetic */ int m9099b(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = C3278f.m9083a(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C3278f.m9098b(charSequence, c, i, z);
    }

    /* renamed from: b */
    public static final int m9100b(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        C3250h.m9056b(charSequence, "$this$lastIndexOfAny");
        C3250h.m9056b(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int c = C3263d.m9077c(i, C3278f.m9083a(charSequence)); c >= 0; c--) {
                char charAt = charSequence.charAt(c);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (C3272a.m9080a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return c;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(C3184a.m8977a(cArr), i);
    }

    @NotNull
    /* renamed from: b */
    public static final String m9101b(@NotNull String str, char c, @NotNull String str2) {
        C3250h.m9056b(str, "$this$substringAfterLast");
        C3250h.m9056b(str2, "missingDelimiterValue");
        int b = C3278f.m9099b(str, c, 0, false, 6, (Object) null);
        if (b == -1) {
            return str2;
        }
        String substring = str.substring(b + 1, str.length());
        C3250h.m9053a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: b */
    public static /* synthetic */ String m9102b(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return C3278f.m9101b(str, c, str2);
    }
}
