package org.spongycastle.tsp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.asn1.cmp.PKIFreeText;
import org.spongycastle.asn1.cms.Attribute;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.tsp.TimeStampResp;
import org.spongycastle.util.Arrays;

public class TimeStampResponse {
    TimeStampResp resp;
    TimeStampToken timeStampToken;

    public TimeStampResponse(InputStream inputStream) {
        this(readTimeStampResp(inputStream));
    }

    TimeStampResponse(DLSequence dLSequence) {
        try {
            this.resp = TimeStampResp.getInstance(dLSequence);
            this.timeStampToken = new TimeStampToken(ContentInfo.getInstance(dLSequence.getObjectAt(1)));
        } catch (IllegalArgumentException e) {
            throw new TSPException("malformed timestamp response: " + e, e);
        } catch (ClassCastException e2) {
            throw new TSPException("malformed timestamp response: " + e2, e2);
        }
    }

    public TimeStampResponse(TimeStampResp timeStampResp) {
        this.resp = timeStampResp;
        if (timeStampResp.getTimeStampToken() != null) {
            this.timeStampToken = new TimeStampToken(timeStampResp.getTimeStampToken());
        }
    }

    public TimeStampResponse(byte[] bArr) {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    private static TimeStampResp readTimeStampResp(InputStream inputStream) {
        try {
            return TimeStampResp.getInstance(new ASN1InputStream(inputStream).readObject());
        } catch (IllegalArgumentException e) {
            throw new TSPException("malformed timestamp response: " + e, e);
        } catch (ClassCastException e2) {
            throw new TSPException("malformed timestamp response: " + e2, e2);
        }
    }

    public byte[] getEncoded() {
        return this.resp.getEncoded();
    }

    public byte[] getEncoded(String str) {
        if (!ASN1Encoding.f7342DL.equals(str)) {
            return this.resp.getEncoded(str);
        }
        return new DLSequence(new ASN1Encodable[]{this.resp.getStatus(), this.timeStampToken.toCMSSignedData().toASN1Structure()}).getEncoded(str);
    }

    public PKIFailureInfo getFailInfo() {
        if (this.resp.getStatus().getFailInfo() != null) {
            return new PKIFailureInfo(this.resp.getStatus().getFailInfo());
        }
        return null;
    }

    public int getStatus() {
        return this.resp.getStatus().getStatus().intValue();
    }

    public String getStatusString() {
        if (this.resp.getStatus().getStatusString() == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        PKIFreeText statusString = this.resp.getStatus().getStatusString();
        for (int i = 0; i != statusString.size(); i++) {
            stringBuffer.append(statusString.getStringAt(i).getString());
        }
        return stringBuffer.toString();
    }

    public TimeStampToken getTimeStampToken() {
        return this.timeStampToken;
    }

    public void validate(TimeStampRequest timeStampRequest) {
        TimeStampToken timeStampToken2 = getTimeStampToken();
        if (timeStampToken2 != null) {
            TimeStampTokenInfo timeStampInfo = timeStampToken2.getTimeStampInfo();
            if (timeStampRequest.getNonce() != null && !timeStampRequest.getNonce().equals(timeStampInfo.getNonce())) {
                throw new TSPValidationException("response contains wrong nonce value.");
            } else if (getStatus() != 0 && getStatus() != 1) {
                throw new TSPValidationException("time stamp token found in failed request.");
            } else if (!Arrays.constantTimeAreEqual(timeStampRequest.getMessageImprintDigest(), timeStampInfo.getMessageImprintDigest())) {
                throw new TSPValidationException("response for different message imprint digest.");
            } else if (timeStampInfo.getMessageImprintAlgOID().equals(timeStampRequest.getMessageImprintAlgOID())) {
                Attribute attribute = timeStampToken2.getSignedAttributes().get(PKCSObjectIdentifiers.id_aa_signingCertificate);
                Attribute attribute2 = timeStampToken2.getSignedAttributes().get(PKCSObjectIdentifiers.id_aa_signingCertificateV2);
                if (attribute == null && attribute2 == null) {
                    throw new TSPValidationException("no signing certificate attribute present.");
                } else if (timeStampRequest.getReqPolicy() != null && !timeStampRequest.getReqPolicy().equals(timeStampInfo.getPolicy())) {
                    throw new TSPValidationException("TSA policy wrong for request.");
                }
            } else {
                throw new TSPValidationException("response for different message imprint algorithm.");
            }
        } else if (getStatus() == 0 || getStatus() == 1) {
            throw new TSPValidationException("no time stamp token found and one expected.");
        }
    }
}
