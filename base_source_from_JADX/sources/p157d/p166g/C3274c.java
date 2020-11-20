package p157d.p166g;

/* renamed from: d.g.c */
class C3274c extends C3273b {
    /* renamed from: a */
    public static final boolean m9080a(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }
}
