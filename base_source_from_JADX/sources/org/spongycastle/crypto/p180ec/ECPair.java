package org.spongycastle.crypto.p180ec;

import org.spongycastle.math.p186ec.ECPoint;

/* renamed from: org.spongycastle.crypto.ec.ECPair */
public class ECPair {

    /* renamed from: x */
    private final ECPoint f7625x;

    /* renamed from: y */
    private final ECPoint f7626y;

    public ECPair(ECPoint eCPoint, ECPoint eCPoint2) {
        this.f7625x = eCPoint;
        this.f7626y = eCPoint2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().equals(getX()) && eCPair.getY().equals(getY());
    }

    public ECPoint getX() {
        return this.f7625x;
    }

    public ECPoint getY() {
        return this.f7626y;
    }

    public int hashCode() {
        return this.f7625x.hashCode() + (this.f7626y.hashCode() * 37);
    }
}
