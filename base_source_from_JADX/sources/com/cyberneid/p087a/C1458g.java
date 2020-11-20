package com.cyberneid.p087a;

/* renamed from: com.cyberneid.a.g */
public class C1458g extends Exception {

    /* renamed from: a */
    private long f4326a;

    public C1458g(long j) {
        super("Error n. " + j);
        this.f4326a = j;
    }

    public C1458g(long j, String str) {
        super(str + " Error n. " + j);
        this.f4326a = j;
    }

    /* renamed from: a */
    public long mo6921a() {
        return this.f4326a;
    }
}
