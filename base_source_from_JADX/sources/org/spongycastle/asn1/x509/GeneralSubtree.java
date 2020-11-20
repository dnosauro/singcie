package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class GeneralSubtree extends ASN1Object {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private GeneralName base;
    private ASN1Integer maximum;
    private ASN1Integer minimum;

    private GeneralSubtree(ASN1Sequence aSN1Sequence) {
        ASN1TaggedObject aSN1TaggedObject;
        this.base = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        switch (aSN1Sequence.size()) {
            case 1:
                return;
            case 2:
                aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
                switch (aSN1TaggedObject.getTagNo()) {
                    case 0:
                        this.minimum = ASN1Integer.getInstance(aSN1TaggedObject, false);
                        return;
                    case 1:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad tag number: " + aSN1TaggedObject.getTagNo());
                }
            case 3:
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
                if (instance.getTagNo() == 0) {
                    this.minimum = ASN1Integer.getInstance(instance, false);
                    aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2));
                    if (aSN1TaggedObject.getTagNo() != 1) {
                        throw new IllegalArgumentException("Bad tag number for 'maximum': " + aSN1TaggedObject.getTagNo());
                    }
                } else {
                    throw new IllegalArgumentException("Bad tag number for 'minimum': " + instance.getTagNo());
                }
                break;
            default:
                throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.maximum = ASN1Integer.getInstance(aSN1TaggedObject, false);
    }

    public GeneralSubtree(GeneralName generalName) {
        this(generalName, (BigInteger) null, (BigInteger) null);
    }

    public GeneralSubtree(GeneralName generalName, BigInteger bigInteger, BigInteger bigInteger2) {
        this.base = generalName;
        if (bigInteger2 != null) {
            this.maximum = new ASN1Integer(bigInteger2);
        }
        this.minimum = bigInteger == null ? null : new ASN1Integer(bigInteger);
    }

    public static GeneralSubtree getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof GeneralSubtree ? (GeneralSubtree) obj : new GeneralSubtree(ASN1Sequence.getInstance(obj));
    }

    public static GeneralSubtree getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralSubtree(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralName getBase() {
        return this.base;
    }

    public BigInteger getMaximum() {
        ASN1Integer aSN1Integer = this.maximum;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getValue();
    }

    public BigInteger getMinimum() {
        ASN1Integer aSN1Integer = this.minimum;
        return aSN1Integer == null ? ZERO : aSN1Integer.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.base);
        ASN1Integer aSN1Integer = this.minimum;
        if (aSN1Integer != null && !aSN1Integer.getValue().equals(ZERO)) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.minimum));
        }
        ASN1Integer aSN1Integer2 = this.maximum;
        if (aSN1Integer2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Integer2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
