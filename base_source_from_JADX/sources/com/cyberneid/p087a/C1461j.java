package com.cyberneid.p087a;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.spongycastle.asn1.x509.ExtensionsGenerator;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.CertificateID;
import org.spongycastle.cert.ocsp.CertificateStatus;
import org.spongycastle.cert.ocsp.OCSPException;
import org.spongycastle.cert.ocsp.OCSPReq;
import org.spongycastle.cert.ocsp.OCSPReqBuilder;
import org.spongycastle.cert.ocsp.OCSPResp;
import org.spongycastle.cert.ocsp.RevokedStatus;
import org.spongycastle.cert.ocsp.SingleResp;
import org.spongycastle.cert.ocsp.UnknownStatus;
import org.spongycastle.jce.provider.X509CertificateObject;
import org.spongycastle.operator.DigestCalculatorProvider;
import org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

/* renamed from: com.cyberneid.a.j */
public class C1461j {
    /* renamed from: a */
    public static int m5501a(List<String> list, X509Certificate x509Certificate, Date date) {
        BasicOCSPResp basicOCSPResp;
        for (String next : list) {
            X509CertificateObject b = C1455d.m5485a().mo6919b(x509Certificate);
            if (b == null) {
                return 3;
            }
            try {
                OCSPResp a = m5505a(next, m5504a((X509Certificate) b, x509Certificate.getSerialNumber()));
                if (!(a == null || (basicOCSPResp = (BasicOCSPResp) a.getResponseObject()) == null)) {
                    SingleResp[] responses = basicOCSPResp.getResponses();
                    if (responses.length != 1) {
                        continue;
                    } else {
                        CertificateStatus certStatus = responses[0].getCertStatus();
                        if (certStatus == CertificateStatus.GOOD) {
                            return 0;
                        }
                        if (certStatus instanceof RevokedStatus) {
                            if (date.before(((RevokedStatus) certStatus).getRevocationTime())) {
                                return 0;
                            }
                            return ((RevokedStatus) certStatus).getRevocationReason() == 6 ? 2 : 1;
                        } else if (certStatus instanceof UnknownStatus) {
                            return 3;
                        }
                    }
                }
            } catch (OCSPException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (C1458g e3) {
                e3.printStackTrace();
            }
        }
        return 3;
    }

    /* renamed from: a */
    public static List<String> m5502a(X509Certificate x509Certificate) {
        ArrayList arrayList = new ArrayList();
        ASN1Object a = m5503a(x509Certificate, X509Extensions.AuthorityInfoAccess.getId());
        if (a == null) {
            return arrayList;
        }
        DLSequence dLSequence = (DLSequence) DLSequence.fromByteArray(((DEROctetString) a).getOctets());
        int size = dLSequence.size();
        for (int i = 0; i < size; i++) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) dLSequence.getObjectAt(i);
            if (((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId().equals("1.3.6.1.5.5.7.48.1")) {
                arrayList.add(DERIA5String.getInstance(GeneralName.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1)).getName()).getString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected static ASN1Object m5503a(X509Certificate x509Certificate, String str) {
        byte[] extensionValue;
        if (x509Certificate == null || (extensionValue = x509Certificate.getExtensionValue(str)) == null) {
            return null;
        }
        return new ASN1InputStream(extensionValue).readObject();
    }

    /* renamed from: a */
    public static OCSPReq m5504a(X509Certificate x509Certificate, BigInteger bigInteger) {
        try {
            DigestCalculatorProvider build = new JcaDigestCalculatorProviderBuilder().build();
            CertificateID certificateID = new CertificateID(build.get(CertificateID.HASH_SHA1), new X509CertificateHolder(x509Certificate.getEncoded()), bigInteger);
            OCSPReqBuilder oCSPReqBuilder = new OCSPReqBuilder();
            oCSPReqBuilder.addRequest(certificateID);
            BigInteger valueOf = BigInteger.valueOf(System.currentTimeMillis());
            ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
            extensionsGenerator.addExtension(OCSPObjectIdentifiers.id_pkix_ocsp_nonce, false, (ASN1Encodable) new DEROctetString(valueOf.toByteArray()));
            oCSPReqBuilder.setRequestExtensions(extensionsGenerator.generate());
            return oCSPReqBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static OCSPResp m5505a(String str, OCSPReq oCSPReq) {
        byte[] encoded = oCSPReq.getEncoded();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(C1453b.f4318a);
        httpURLConnection.setReadTimeout(C1453b.f4319b);
        httpURLConnection.setRequestProperty("Content-Type", "application/ocsp-request");
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_ACCEPT, "application/ocsp-response");
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
        dataOutputStream.write(encoded);
        dataOutputStream.flush();
        dataOutputStream.close();
        if (httpURLConnection.getResponseCode() / 100 == 2) {
            return new OCSPResp((InputStream) httpURLConnection.getContent());
        }
        throw new C1458g((long) httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage());
    }
}
