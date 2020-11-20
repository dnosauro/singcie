package com.cyberneid.p087a;

import java.io.IOException;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cms.CMSObjectIdentifiers;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.cms.SignedData;

/* renamed from: com.cyberneid.a.h */
class C1459h {

    /* renamed from: a */
    private C1451a f4327a;

    /* renamed from: b */
    private byte[] f4328b;

    public C1459h(C1451a aVar) {
        this.f4327a = aVar;
        try {
            if (!aVar.mo6916e()) {
                this.f4328b = aVar.mo6914c();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo6922a(byte[] bArr) {
        this.f4328b = bArr;
    }

    /* renamed from: a */
    public byte[] mo6923a() {
        SignedData instance = SignedData.getInstance(this.f4327a.mo6917f().toASN1Structure().getContent());
        ASN1Set digestAlgorithms = instance.getDigestAlgorithms();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CMSObjectIdentifiers.data;
        byte[] bArr = this.f4328b;
        try {
            return new ContentInfo(CMSObjectIdentifiers.signedData, new SignedData(digestAlgorithms, new ContentInfo(aSN1ObjectIdentifier, bArr != null ? new DEROctetString(bArr) : null), instance.getCertificates(), instance.getCRLs(), instance.getSignerInfos())).getEncoded();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
