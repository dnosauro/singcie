package org.spongycastle.dvcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.cms.SignedData;
import org.spongycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.spongycastle.cms.CMSSignedData;

public class DVCSResponse extends DVCSMessage {
    private org.spongycastle.asn1.dvcs.DVCSResponse asn1;

    public DVCSResponse(ContentInfo contentInfo) {
        super(contentInfo);
        if (DVCSObjectIdentifiers.id_ct_DVCSResponseData.equals(contentInfo.getContentType())) {
            try {
                this.asn1 = contentInfo.getContent().toASN1Primitive() instanceof ASN1Sequence ? org.spongycastle.asn1.dvcs.DVCSResponse.getInstance(contentInfo.getContent()) : org.spongycastle.asn1.dvcs.DVCSResponse.getInstance(ASN1OctetString.getInstance(contentInfo.getContent()).getOctets());
            } catch (Exception e) {
                throw new DVCSConstructionException("Unable to parse content: " + e.getMessage(), e);
            }
        } else {
            throw new DVCSConstructionException("ContentInfo not a DVCS Response");
        }
    }

    public DVCSResponse(CMSSignedData cMSSignedData) {
        this(SignedData.getInstance(cMSSignedData.toASN1Structure().getContent()).getEncapContentInfo());
    }

    public ASN1Encodable getContent() {
        return this.asn1;
    }
}
