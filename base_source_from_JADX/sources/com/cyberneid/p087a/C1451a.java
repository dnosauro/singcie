package com.cyberneid.p087a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.cms.SignedData;
import org.spongycastle.cms.CMSSignedData;
import org.spongycastle.cms.SignerInformation;
import org.spongycastle.util.Store;

/* renamed from: com.cyberneid.a.a */
public class C1451a {

    /* renamed from: a */
    private CMSSignedData f4317a;

    private C1451a() {
    }

    /* renamed from: a */
    public static C1451a m5466a(InputStream inputStream) {
        try {
            return m5468a(new CMSSignedData(inputStream));
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1458g(-2130706266);
        }
    }

    /* renamed from: a */
    public static C1451a m5467a(ContentInfo contentInfo) {
        try {
            return m5468a(new CMSSignedData(contentInfo));
        } catch (Exception unused) {
            throw new C1458g(-2130706266);
        }
    }

    /* renamed from: a */
    static C1451a m5468a(CMSSignedData cMSSignedData) {
        C1451a aVar = new C1451a();
        aVar.f4317a = cMSSignedData;
        return aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cyberneid.p087a.C1451a m5469a(byte[] r3) {
        /*
            r0 = 0
            byte r0 = r3[r0]     // Catch:{ Exception -> 0x0030 }
            r1 = 48
            if (r0 == r1) goto L_0x0026
            org.spongycastle.util.io.pem.PemReader r0 = new org.spongycastle.util.io.pem.PemReader     // Catch:{ Exception -> 0x0022 }
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ Exception -> 0x0022 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0022 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0022 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0022 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0022 }
            org.spongycastle.util.io.pem.PemObject r1 = r0.readPemObject()     // Catch:{ Exception -> 0x0022 }
            byte[] r3 = r1.getContent()     // Catch:{ Exception -> 0x0022 }
            r0.close()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            byte[] r3 = org.spongycastle.util.encoders.Base64.decode((byte[]) r3)     // Catch:{ Exception -> 0x0030 }
        L_0x0026:
            org.spongycastle.cms.CMSSignedData r0 = new org.spongycastle.cms.CMSSignedData     // Catch:{ Exception -> 0x0030 }
            r0.<init>((byte[]) r3)     // Catch:{ Exception -> 0x0030 }
            com.cyberneid.a.a r3 = m5468a((org.spongycastle.cms.CMSSignedData) r0)     // Catch:{ Exception -> 0x0030 }
            return r3
        L_0x0030:
            com.cyberneid.a.g r3 = new com.cyberneid.a.g
            r0 = -2130706266(0xffffffff810000a6, double:NaN)
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p087a.C1451a.m5469a(byte[]):com.cyberneid.a.a");
    }

    /* renamed from: a */
    public int mo6910a() {
        return this.f4317a.getSignerInfos().size();
    }

    /* renamed from: a */
    public C1467o mo6911a(int i) {
        return new C1467o(this, (SignerInformation) this.f4317a.getSignerInfos().getSigners().toArray()[i]);
    }

    /* renamed from: a */
    public void mo6912a(OutputStream outputStream) {
        try {
            new ASN1OutputStream(outputStream).writeObject(this.f4317a.toASN1Structure());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Store mo6913b() {
        return this.f4317a.getCertificates();
    }

    /* renamed from: c */
    public byte[] mo6914c() {
        if (mo6916e()) {
            return null;
        }
        return ((ASN1OctetString) SignedData.getInstance(this.f4317a.toASN1Structure().getContent()).getEncapContentInfo().getContent()).getOctets();
    }

    /* renamed from: d */
    public byte[] mo6915d() {
        try {
            System.gc();
            return this.f4317a.toASN1Structure().getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public boolean mo6916e() {
        try {
            return this.f4317a.toASN1Structure().getContent() == null;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public CMSSignedData mo6917f() {
        return this.f4317a;
    }
}
