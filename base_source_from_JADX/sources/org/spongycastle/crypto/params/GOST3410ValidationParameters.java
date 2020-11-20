package org.spongycastle.crypto.params;

public class GOST3410ValidationParameters {

    /* renamed from: c */
    private int f7870c;

    /* renamed from: cL */
    private long f7871cL;

    /* renamed from: x0 */
    private int f7872x0;
    private long x0L;

    public GOST3410ValidationParameters(int i, int i2) {
        this.f7872x0 = i;
        this.f7870c = i2;
    }

    public GOST3410ValidationParameters(long j, long j2) {
        this.x0L = j;
        this.f7871cL = j2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        return gOST3410ValidationParameters.f7870c == this.f7870c && gOST3410ValidationParameters.f7872x0 == this.f7872x0 && gOST3410ValidationParameters.f7871cL == this.f7871cL && gOST3410ValidationParameters.x0L == this.x0L;
    }

    public int getC() {
        return this.f7870c;
    }

    public long getCL() {
        return this.f7871cL;
    }

    public int getX0() {
        return this.f7872x0;
    }

    public long getX0L() {
        return this.x0L;
    }

    public int hashCode() {
        int i = this.f7872x0 ^ this.f7870c;
        long j = this.x0L;
        long j2 = this.f7871cL;
        return (((i ^ ((int) j)) ^ ((int) (j >> 32))) ^ ((int) j2)) ^ ((int) (j2 >> 32));
    }
}
