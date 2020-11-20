package com.cyberneid.p089b.p092c;

/* renamed from: com.cyberneid.b.c.a */
class C1531a {

    /* renamed from: a */
    private final char f4541a;

    /* renamed from: b */
    private final char f4542b;

    /* renamed from: c */
    private final int f4543c;

    C1531a(char c, char c2, int i) {
        this.f4541a = c;
        this.f4542b = c2;
        this.f4543c = i;
    }

    /* renamed from: a */
    public int mo7140a(char c) {
        char c2 = this.f4541a;
        if (c2 > c || c > this.f4542b) {
            return -1;
        }
        return this.f4543c + (c - c2);
    }
}
