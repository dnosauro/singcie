package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AuthorityInformationAccess;

public class ServiceLocator extends ASN1Object {
    private final X500Name issuer;
    private final AuthorityInformationAccess locator;

    private ServiceLocator(ASN1Sequence aSN1Sequence) {
        this.issuer = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.locator = aSN1Sequence.size() == 2 ? AuthorityInformationAccess.getInstance(aSN1Sequence.getObjectAt(1)) : null;
    }

    public static ServiceLocator getInstance(Object obj) {
        if (obj instanceof ServiceLocator) {
            return (ServiceLocator) obj;
        }
        if (obj != null) {
            return new ServiceLocator(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public AuthorityInformationAccess getLocator() {
        return this.locator;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.issuer);
        AuthorityInformationAccess authorityInformationAccess = this.locator;
        if (authorityInformationAccess != null) {
            aSN1EncodableVector.add(authorityInformationAccess);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
