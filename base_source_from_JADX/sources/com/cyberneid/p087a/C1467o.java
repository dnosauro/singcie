package com.cyberneid.p087a;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.cms.Attribute;
import org.spongycastle.asn1.cms.CMSAttributes;
import org.spongycastle.cms.SignerInformation;

/* renamed from: com.cyberneid.a.o */
public class C1467o {

    /* renamed from: a */
    private C1451a f4351a;

    /* renamed from: b */
    private SignerInformation f4352b;

    private C1467o() {
    }

    C1467o(C1451a aVar, SignerInformation signerInformation) {
        this.f4351a = aVar;
        this.f4352b = signerInformation;
    }

    /* renamed from: a */
    public int mo6946a(Date date) {
        try {
            return C1466n.m5528a(this.f4352b, this.f4351a.mo6917f().getCertificates(), date);
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1458g(-2130706262, e.getMessage());
        }
    }

    /* renamed from: a */
    public X509Certificate mo6947a() {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(C1466n.m5529a(this.f4352b, this.f4351a.mo6913b()).getEncoded()));
        } catch (Exception e) {
            throw new C1458g(-2130706265, e.getMessage());
        }
    }

    /* renamed from: b */
    public int mo6948b() {
        return mo6946a((Date) null);
    }

    /* renamed from: c */
    public Date mo6949c() {
        try {
            Attribute attribute = this.f4352b.getSignedAttributes().get(CMSAttributes.signingTime);
            if (attribute != null) {
                return ASN1UTCTime.getInstance(attribute.getAttrValues().getObjectAt(0)).getDate();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
