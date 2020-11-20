package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKey extends ASN1Object {

    /* renamed from: g */
    private final GF2Matrix f8104g;

    /* renamed from: n */
    private final int f8105n;

    /* renamed from: t */
    private final int f8106t;

    public McEliecePublicKey(int i, int i2, GF2Matrix gF2Matrix) {
        this.f8105n = i;
        this.f8106t = i2;
        this.f8104g = new GF2Matrix(gF2Matrix);
    }

    private McEliecePublicKey(ASN1Sequence aSN1Sequence) {
        this.f8105n = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue().intValue();
        this.f8106t = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).getValue().intValue();
        this.f8104g = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
    }

    public static McEliecePublicKey getInstance(Object obj) {
        if (obj instanceof McEliecePublicKey) {
            return (McEliecePublicKey) obj;
        }
        if (obj != null) {
            return new McEliecePublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GF2Matrix getG() {
        return new GF2Matrix(this.f8104g);
    }

    public int getN() {
        return this.f8105n;
    }

    public int getT() {
        return this.f8106t;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.f8105n));
        aSN1EncodableVector.add(new ASN1Integer((long) this.f8106t));
        aSN1EncodableVector.add(new DEROctetString(this.f8104g.getEncoded()));
        return new DERSequence(aSN1EncodableVector);
    }
}
