package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* renamed from: g */
    private GF2Matrix f8163g;

    /* renamed from: n */
    private int f8164n;

    /* renamed from: t */
    private int f8165t;

    public McEliecePublicKeyParameters(int i, int i2, GF2Matrix gF2Matrix) {
        super(false, (McElieceParameters) null);
        this.f8164n = i;
        this.f8165t = i2;
        this.f8163g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f8163g;
    }

    public int getK() {
        return this.f8163g.getNumRows();
    }

    public int getN() {
        return this.f8164n;
    }

    public int getT() {
        return this.f8165t;
    }
}
