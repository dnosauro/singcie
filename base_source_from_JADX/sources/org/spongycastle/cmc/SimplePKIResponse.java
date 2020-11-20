package org.spongycastle.cmc;

import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.cert.X509CRLHolder;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cms.CMSException;
import org.spongycastle.cms.CMSSignedData;
import org.spongycastle.util.Encodable;
import org.spongycastle.util.Store;

public class SimplePKIResponse implements Encodable {
    private final CMSSignedData certificateResponse;

    public SimplePKIResponse(ContentInfo contentInfo) {
        try {
            this.certificateResponse = new CMSSignedData(contentInfo);
            if (this.certificateResponse.getSignerInfos().size() != 0) {
                throw new CMCException("malformed response: SignerInfo structures found");
            } else if (this.certificateResponse.getSignedContent() != null) {
                throw new CMCException("malformed response: Signed Content found");
            }
        } catch (CMSException e) {
            throw new CMCException("malformed response: " + e.getMessage(), e);
        }
    }

    public SimplePKIResponse(byte[] bArr) {
        this(parseBytes(bArr));
    }

    private static ContentInfo parseBytes(byte[] bArr) {
        try {
            return ContentInfo.getInstance(ASN1Primitive.fromByteArray(bArr));
        } catch (Exception e) {
            throw new CMCException("malformed data: " + e.getMessage(), e);
        }
    }

    public Store<X509CRLHolder> getCRLs() {
        return this.certificateResponse.getCRLs();
    }

    public Store<X509CertificateHolder> getCertificates() {
        return this.certificateResponse.getCertificates();
    }

    public byte[] getEncoded() {
        return this.certificateResponse.getEncoded();
    }
}
