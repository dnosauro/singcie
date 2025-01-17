package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

public class Target extends ASN1Object implements ASN1Choice {
    public static final int targetGroup = 1;
    public static final int targetName = 0;
    private GeneralName targGroup;
    private GeneralName targName;

    public Target(int i, GeneralName generalName) {
        this(new DERTaggedObject(i, generalName));
    }

    private Target(ASN1TaggedObject aSN1TaggedObject) {
        switch (aSN1TaggedObject.getTagNo()) {
            case 0:
                this.targName = GeneralName.getInstance(aSN1TaggedObject, true);
                return;
            case 1:
                this.targGroup = GeneralName.getInstance(aSN1TaggedObject, true);
                return;
            default:
                throw new IllegalArgumentException("unknown tag: " + aSN1TaggedObject.getTagNo());
        }
    }

    public static Target getInstance(Object obj) {
        if (obj == null || (obj instanceof Target)) {
            return (Target) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Target((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass());
    }

    public GeneralName getTargetGroup() {
        return this.targGroup;
    }

    public GeneralName getTargetName() {
        return this.targName;
    }

    public ASN1Primitive toASN1Primitive() {
        GeneralName generalName = this.targName;
        return generalName != null ? new DERTaggedObject(true, 0, generalName) : new DERTaggedObject(true, 1, this.targGroup);
    }
}
