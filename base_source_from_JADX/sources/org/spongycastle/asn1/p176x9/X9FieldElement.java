package org.spongycastle.asn1.p176x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.p186ec.ECFieldElement;

/* renamed from: org.spongycastle.asn1.x9.X9FieldElement */
public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f */
    protected ECFieldElement f7438f;

    public X9FieldElement(int i, int i2, int i3, int i4, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.F2m(i, i2, i3, i4, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(BigInteger bigInteger, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.C3629Fp(bigInteger, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f7438f = eCFieldElement;
    }

    public ECFieldElement getValue() {
        return this.f7438f;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(converter.integerToBytes(this.f7438f.toBigInteger(), converter.getByteLength(this.f7438f)));
    }
}
