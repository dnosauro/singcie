package org.spongycastle.cert.ocsp;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Exception;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ocsp.OCSPRequest;
import org.spongycastle.asn1.ocsp.Request;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.cert.CertIOException;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.operator.ContentVerifier;
import org.spongycastle.operator.ContentVerifierProvider;

public class OCSPReq {
    private static final X509CertificateHolder[] EMPTY_CERTS = new X509CertificateHolder[0];
    private Extensions extensions;
    private OCSPRequest req;

    private OCSPReq(ASN1InputStream aSN1InputStream) {
        try {
            this.req = OCSPRequest.getInstance(aSN1InputStream.readObject());
            if (this.req != null) {
                this.extensions = this.req.getTbsRequest().getRequestExtensions();
                return;
            }
            throw new CertIOException("malformed request: no request data found");
        } catch (IllegalArgumentException e) {
            throw new CertIOException("malformed request: " + e.getMessage(), e);
        } catch (ClassCastException e2) {
            throw new CertIOException("malformed request: " + e2.getMessage(), e2);
        } catch (ASN1Exception e3) {
            throw new CertIOException("malformed request: " + e3.getMessage(), e3);
        }
    }

    public OCSPReq(OCSPRequest oCSPRequest) {
        this.req = oCSPRequest;
        this.extensions = oCSPRequest.getTbsRequest().getRequestExtensions();
    }

    public OCSPReq(byte[] bArr) {
        this(new ASN1InputStream(bArr));
    }

    public X509CertificateHolder[] getCerts() {
        if (this.req.getOptionalSignature() == null) {
            return EMPTY_CERTS;
        }
        ASN1Sequence certs = this.req.getOptionalSignature().getCerts();
        if (certs == null) {
            return EMPTY_CERTS;
        }
        X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[certs.size()];
        for (int i = 0; i != x509CertificateHolderArr.length; i++) {
            x509CertificateHolderArr[i] = new X509CertificateHolder(Certificate.getInstance(certs.getObjectAt(i)));
        }
        return x509CertificateHolderArr;
    }

    public Set getCriticalExtensionOIDs() {
        return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
    }

    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ASN1OutputStream(byteArrayOutputStream).writeObject(this.req);
        return byteArrayOutputStream.toByteArray();
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions2 = this.extensions;
        if (extensions2 != null) {
            return extensions2.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return OCSPUtils.getExtensionOIDs(this.extensions);
    }

    public Set getNonCriticalExtensionOIDs() {
        return OCSPUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public Req[] getRequestList() {
        ASN1Sequence requestList = this.req.getTbsRequest().getRequestList();
        Req[] reqArr = new Req[requestList.size()];
        for (int i = 0; i != reqArr.length; i++) {
            reqArr[i] = new Req(Request.getInstance(requestList.getObjectAt(i)));
        }
        return reqArr;
    }

    public GeneralName getRequestorName() {
        return GeneralName.getInstance(this.req.getTbsRequest().getRequestorName());
    }

    public byte[] getSignature() {
        if (!isSigned()) {
            return null;
        }
        return this.req.getOptionalSignature().getSignature().getOctets();
    }

    public ASN1ObjectIdentifier getSignatureAlgOID() {
        if (!isSigned()) {
            return null;
        }
        return this.req.getOptionalSignature().getSignatureAlgorithm().getAlgorithm();
    }

    public int getVersionNumber() {
        return this.req.getTbsRequest().getVersion().getValue().intValue() + 1;
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) {
        if (isSigned()) {
            try {
                ContentVerifier contentVerifier = contentVerifierProvider.get(this.req.getOptionalSignature().getSignatureAlgorithm());
                contentVerifier.getOutputStream().write(this.req.getTbsRequest().getEncoded(ASN1Encoding.DER));
                return contentVerifier.verify(getSignature());
            } catch (Exception e) {
                throw new OCSPException("exception processing signature: " + e, e);
            }
        } else {
            throw new OCSPException("attempt to verify signature on unsigned object");
        }
    }

    public boolean isSigned() {
        return this.req.getOptionalSignature() != null;
    }
}
