package org.spongycastle.asn1.esf;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.x500.DirectoryString;

public class SignerLocation extends ASN1Object {
    private DirectoryString countryName;
    private DirectoryString localityName;
    private ASN1Sequence postalAddress;

    private SignerLocation(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            switch (aSN1TaggedObject.getTagNo()) {
                case 0:
                    this.countryName = DirectoryString.getInstance(aSN1TaggedObject, true);
                    break;
                case 1:
                    this.localityName = DirectoryString.getInstance(aSN1TaggedObject, true);
                    break;
                case 2:
                    this.postalAddress = aSN1TaggedObject.isExplicit() ? ASN1Sequence.getInstance(aSN1TaggedObject, true) : ASN1Sequence.getInstance(aSN1TaggedObject, false);
                    ASN1Sequence aSN1Sequence2 = this.postalAddress;
                    if (aSN1Sequence2 != null && aSN1Sequence2.size() > 6) {
                        throw new IllegalArgumentException("postal address must contain less than 6 strings");
                    }
                default:
                    throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public SignerLocation(DERUTF8String dERUTF8String, DERUTF8String dERUTF8String2, ASN1Sequence aSN1Sequence) {
        this(DirectoryString.getInstance(dERUTF8String), DirectoryString.getInstance(dERUTF8String2), aSN1Sequence);
    }

    private SignerLocation(DirectoryString directoryString, DirectoryString directoryString2, ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null || aSN1Sequence.size() <= 6) {
            this.countryName = directoryString;
            this.localityName = directoryString2;
            this.postalAddress = aSN1Sequence;
            return;
        }
        throw new IllegalArgumentException("postal address must contain less than 6 strings");
    }

    public SignerLocation(DirectoryString directoryString, DirectoryString directoryString2, DirectoryString[] directoryStringArr) {
        this(directoryString, directoryString2, (ASN1Sequence) new DERSequence((ASN1Encodable[]) directoryStringArr));
    }

    public static SignerLocation getInstance(Object obj) {
        return (obj == null || (obj instanceof SignerLocation)) ? (SignerLocation) obj : new SignerLocation(ASN1Sequence.getInstance(obj));
    }

    public DirectoryString getCountry() {
        return this.countryName;
    }

    public DERUTF8String getCountryName() {
        if (this.countryName == null) {
            return null;
        }
        return new DERUTF8String(getCountry().getString());
    }

    public DirectoryString getLocality() {
        return this.localityName;
    }

    public DERUTF8String getLocalityName() {
        if (this.localityName == null) {
            return null;
        }
        return new DERUTF8String(getLocality().getString());
    }

    public DirectoryString[] getPostal() {
        ASN1Sequence aSN1Sequence = this.postalAddress;
        if (aSN1Sequence == null) {
            return null;
        }
        DirectoryString[] directoryStringArr = new DirectoryString[aSN1Sequence.size()];
        for (int i = 0; i != directoryStringArr.length; i++) {
            directoryStringArr[i] = DirectoryString.getInstance(this.postalAddress.getObjectAt(i));
        }
        return directoryStringArr;
    }

    public ASN1Sequence getPostalAddress() {
        return this.postalAddress;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DirectoryString directoryString = this.countryName;
        if (directoryString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, directoryString));
        }
        DirectoryString directoryString2 = this.localityName;
        if (directoryString2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, directoryString2));
        }
        ASN1Sequence aSN1Sequence = this.postalAddress;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, aSN1Sequence));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
