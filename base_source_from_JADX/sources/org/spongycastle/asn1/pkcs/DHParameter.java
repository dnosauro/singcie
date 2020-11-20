package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class DHParameter extends ASN1Object {

    /* renamed from: g */
    ASN1Integer f7375g;

    /* renamed from: l */
    ASN1Integer f7376l;

    /* renamed from: p */
    ASN1Integer f7377p;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f7377p = new ASN1Integer(bigInteger);
        this.f7375g = new ASN1Integer(bigInteger2);
        this.f7376l = i != 0 ? new ASN1Integer((long) i) : null;
    }

    private DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f7377p = ASN1Integer.getInstance(objects.nextElement());
        this.f7375g = ASN1Integer.getInstance(objects.nextElement());
        this.f7376l = objects.hasMoreElements() ? (ASN1Integer) objects.nextElement() : null;
    }

    public static DHParameter getInstance(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        if (obj != null) {
            return new DHParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f7375g.getPositiveValue();
    }

    public BigInteger getL() {
        ASN1Integer aSN1Integer = this.f7376l;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f7377p.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f7377p);
        aSN1EncodableVector.add(this.f7375g);
        if (getL() != null) {
            aSN1EncodableVector.add(this.f7376l);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
