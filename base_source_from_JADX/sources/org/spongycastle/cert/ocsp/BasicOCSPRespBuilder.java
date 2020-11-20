package org.spongycastle.cert.ocsp;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.ocsp.BasicOCSPResponse;
import org.spongycastle.asn1.ocsp.CertStatus;
import org.spongycastle.asn1.ocsp.ResponseData;
import org.spongycastle.asn1.ocsp.RevokedInfo;
import org.spongycastle.asn1.ocsp.SingleResponse;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.CRLReason;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.operator.ContentSigner;
import org.spongycastle.operator.DigestCalculator;

public class BasicOCSPRespBuilder {
    private List list = new ArrayList();
    private RespID responderID;
    private Extensions responseExtensions = null;

    private class ResponseObject {
        CertificateID certId;
        CertStatus certStatus;
        Extensions extensions;
        ASN1GeneralizedTime nextUpdate;
        ASN1GeneralizedTime thisUpdate;

        public ResponseObject(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2, Extensions extensions2) {
            CertStatus certStatus2;
            this.certId = certificateID;
            DERGeneralizedTime dERGeneralizedTime = null;
            if (certificateStatus == null) {
                certStatus2 = new CertStatus();
            } else if (certificateStatus instanceof UnknownStatus) {
                certStatus2 = new CertStatus(2, DERNull.INSTANCE);
            } else {
                RevokedStatus revokedStatus = (RevokedStatus) certificateStatus;
                certStatus2 = revokedStatus.hasRevocationReason() ? new CertStatus(new RevokedInfo(new ASN1GeneralizedTime(revokedStatus.getRevocationTime()), CRLReason.lookup(revokedStatus.getRevocationReason()))) : new CertStatus(new RevokedInfo(new ASN1GeneralizedTime(revokedStatus.getRevocationTime()), (CRLReason) null));
            }
            this.certStatus = certStatus2;
            this.thisUpdate = new DERGeneralizedTime(date);
            this.nextUpdate = date2 != null ? new DERGeneralizedTime(date2) : dERGeneralizedTime;
            this.extensions = extensions2;
        }

        public SingleResponse toResponse() {
            return new SingleResponse(this.certId.toASN1Primitive(), this.certStatus, this.thisUpdate, this.nextUpdate, this.extensions);
        }
    }

    public BasicOCSPRespBuilder(SubjectPublicKeyInfo subjectPublicKeyInfo, DigestCalculator digestCalculator) {
        this.responderID = new RespID(subjectPublicKeyInfo, digestCalculator);
    }

    public BasicOCSPRespBuilder(RespID respID) {
        this.responderID = respID;
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus) {
        addResponse(certificateID, certificateStatus, new Date(), (Date) null, (Extensions) null);
        return this;
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2) {
        addResponse(certificateID, certificateStatus, date, date2, (Extensions) null);
        return this;
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2, Extensions extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, date, date2, extensions));
        return this;
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Extensions extensions) {
        addResponse(certificateID, certificateStatus, new Date(), date, extensions);
        return this;
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Extensions extensions) {
        addResponse(certificateID, certificateStatus, new Date(), (Date) null, extensions);
        return this;
    }

    public BasicOCSPResp build(ContentSigner contentSigner, X509CertificateHolder[] x509CertificateHolderArr, Date date) {
        DERSequence dERSequence;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (ResponseObject response : this.list) {
            try {
                aSN1EncodableVector.add(response.toResponse());
            } catch (Exception e) {
                throw new OCSPException("exception creating Request", e);
            }
        }
        ResponseData responseData = new ResponseData(this.responderID.toASN1Primitive(), new ASN1GeneralizedTime(date), (ASN1Sequence) new DERSequence(aSN1EncodableVector), this.responseExtensions);
        try {
            OutputStream outputStream = contentSigner.getOutputStream();
            outputStream.write(responseData.getEncoded(ASN1Encoding.DER));
            outputStream.close();
            DERBitString dERBitString = new DERBitString(contentSigner.getSignature());
            AlgorithmIdentifier algorithmIdentifier = contentSigner.getAlgorithmIdentifier();
            if (x509CertificateHolderArr == null || x509CertificateHolderArr.length <= 0) {
                dERSequence = null;
            } else {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                for (int i = 0; i != x509CertificateHolderArr.length; i++) {
                    aSN1EncodableVector2.add(x509CertificateHolderArr[i].toASN1Structure());
                }
                dERSequence = new DERSequence(aSN1EncodableVector2);
            }
            return new BasicOCSPResp(new BasicOCSPResponse(responseData, algorithmIdentifier, dERBitString, dERSequence));
        } catch (Exception e2) {
            throw new OCSPException("exception processing TBSRequest: " + e2.getMessage(), e2);
        }
    }

    public BasicOCSPRespBuilder setResponseExtensions(Extensions extensions) {
        this.responseExtensions = extensions;
        return this;
    }
}
