package org.spongycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a */
    ASN1Integer f7349a;

    /* renamed from: b */
    ASN1Integer f7350b;

    /* renamed from: p */
    ASN1Integer f7351p;

    /* renamed from: q */
    ASN1Integer f7352q;

    /* renamed from: x */
    ASN1Integer f7353x;

    /* renamed from: y */
    ASN1Integer f7354y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.f7349a = new ASN1Integer(bigInteger);
        this.f7350b = new ASN1Integer(bigInteger2);
        this.f7351p = new ASN1Integer(bigInteger3);
        this.f7352q = new ASN1Integer(bigInteger4);
        this.f7353x = new ASN1Integer((long) i);
        this.f7354y = new ASN1Integer(bigInteger5);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f7349a = (ASN1Integer) objects.nextElement();
        this.f7350b = (ASN1Integer) objects.nextElement();
        this.f7351p = (ASN1Integer) objects.nextElement();
        this.f7352q = (ASN1Integer) objects.nextElement();
        this.f7353x = (ASN1Integer) objects.nextElement();
        this.f7354y = (ASN1Integer) objects.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.f7349a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f7351p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f7352q.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f7349a);
        aSN1EncodableVector.add(this.f7350b);
        aSN1EncodableVector.add(this.f7351p);
        aSN1EncodableVector.add(this.f7352q);
        aSN1EncodableVector.add(this.f7353x);
        aSN1EncodableVector.add(this.f7354y);
        return new DERSequence(aSN1EncodableVector);
    }
}
