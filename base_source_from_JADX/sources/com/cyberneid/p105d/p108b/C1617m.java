package com.cyberneid.p105d.p108b;

/* renamed from: com.cyberneid.d.b.m */
public class C1617m implements Comparable<C1617m> {

    /* renamed from: a */
    private final long f5375a;

    /* renamed from: b */
    private final int f5376b;

    public C1617m(long j, int i) {
        this.f5375a = j;
        this.f5376b = i;
    }

    public C1617m(C1616l lVar) {
        this(lVar.mo7608b(), lVar.mo7609c());
    }

    /* renamed from: a */
    public int mo7611a() {
        return this.f5376b;
    }

    /* renamed from: a */
    public int compareTo(C1617m mVar) {
        if (mo7613b() < mVar.mo7613b()) {
            return -1;
        }
        if (mo7613b() > mVar.mo7613b()) {
            return 1;
        }
        if (mo7611a() < mVar.mo7611a()) {
            return -1;
        }
        return mo7611a() > mVar.mo7611a() ? 1 : 0;
    }

    /* renamed from: b */
    public long mo7613b() {
        return this.f5375a;
    }

    public boolean equals(Object obj) {
        C1617m mVar = obj instanceof C1617m ? (C1617m) obj : null;
        return mVar != null && mVar.mo7613b() == mo7613b() && mVar.mo7611a() == mo7611a();
    }

    public int hashCode() {
        return Long.valueOf(this.f5375a + ((long) this.f5376b)).hashCode();
    }

    public String toString() {
        return Long.toString(this.f5375a) + " " + Integer.toString(this.f5376b) + " R";
    }
}
