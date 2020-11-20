package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertificate extends ASN1Object {
    Time endDate;
    Extensions extensions;
    X500Name issuer;
    DERBitString issuerUniqueId;
    ASN1Sequence seq;
    ASN1Integer serialNumber;
    AlgorithmIdentifier signature;
    Time startDate;
    X500Name subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    DERBitString subjectUniqueId;
    ASN1Integer version;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TBSCertificate(org.spongycastle.asn1.ASN1Sequence r8) {
        /*
            r7 = this;
            r7.<init>()
            r7.seq = r8
            r0 = 0
            org.spongycastle.asn1.ASN1Encodable r1 = r8.getObjectAt(r0)
            boolean r1 = r1 instanceof org.spongycastle.asn1.ASN1TaggedObject
            r2 = 0
            r4 = 1
            if (r1 == 0) goto L_0x001f
            org.spongycastle.asn1.ASN1Encodable r1 = r8.getObjectAt(r0)
            org.spongycastle.asn1.ASN1TaggedObject r1 = (org.spongycastle.asn1.ASN1TaggedObject) r1
            org.spongycastle.asn1.ASN1Integer r1 = org.spongycastle.asn1.ASN1Integer.getInstance(r1, r4)
            r7.version = r1
            r1 = 0
            goto L_0x0027
        L_0x001f:
            org.spongycastle.asn1.ASN1Integer r1 = new org.spongycastle.asn1.ASN1Integer
            r1.<init>((long) r2)
            r7.version = r1
            r1 = -1
        L_0x0027:
            org.spongycastle.asn1.ASN1Integer r5 = r7.version
            java.math.BigInteger r5 = r5.getValue()
            java.math.BigInteger r2 = java.math.BigInteger.valueOf(r2)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x003a
            r2 = 1
        L_0x0038:
            r3 = 0
            goto L_0x0063
        L_0x003a:
            org.spongycastle.asn1.ASN1Integer r2 = r7.version
            java.math.BigInteger r2 = r2.getValue()
            r5 = 1
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r5)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004f
            r2 = 0
            r3 = 1
            goto L_0x0063
        L_0x004f:
            org.spongycastle.asn1.ASN1Integer r2 = r7.version
            java.math.BigInteger r2 = r2.getValue()
            r5 = 2
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r5)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0106
            r2 = 0
            goto L_0x0038
        L_0x0063:
            int r5 = r1 + 1
            org.spongycastle.asn1.ASN1Encodable r5 = r8.getObjectAt(r5)
            org.spongycastle.asn1.ASN1Integer r5 = org.spongycastle.asn1.ASN1Integer.getInstance(r5)
            r7.serialNumber = r5
            int r5 = r1 + 2
            org.spongycastle.asn1.ASN1Encodable r5 = r8.getObjectAt(r5)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r5 = org.spongycastle.asn1.x509.AlgorithmIdentifier.getInstance(r5)
            r7.signature = r5
            int r5 = r1 + 3
            org.spongycastle.asn1.ASN1Encodable r5 = r8.getObjectAt(r5)
            org.spongycastle.asn1.x500.X500Name r5 = org.spongycastle.asn1.x500.X500Name.getInstance(r5)
            r7.issuer = r5
            int r5 = r1 + 4
            org.spongycastle.asn1.ASN1Encodable r5 = r8.getObjectAt(r5)
            org.spongycastle.asn1.ASN1Sequence r5 = (org.spongycastle.asn1.ASN1Sequence) r5
            org.spongycastle.asn1.ASN1Encodable r6 = r5.getObjectAt(r0)
            org.spongycastle.asn1.x509.Time r6 = org.spongycastle.asn1.x509.Time.getInstance(r6)
            r7.startDate = r6
            org.spongycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r4)
            org.spongycastle.asn1.x509.Time r5 = org.spongycastle.asn1.x509.Time.getInstance(r5)
            r7.endDate = r5
            int r5 = r1 + 5
            org.spongycastle.asn1.ASN1Encodable r5 = r8.getObjectAt(r5)
            org.spongycastle.asn1.x500.X500Name r5 = org.spongycastle.asn1.x500.X500Name.getInstance(r5)
            r7.subject = r5
            int r1 = r1 + 6
            org.spongycastle.asn1.ASN1Encodable r5 = r8.getObjectAt(r1)
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r5 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.getInstance(r5)
            r7.subjectPublicKeyInfo = r5
            int r5 = r8.size()
            int r5 = r5 - r1
            int r5 = r5 - r4
            if (r5 == 0) goto L_0x00ce
            if (r2 != 0) goto L_0x00c6
            goto L_0x00ce
        L_0x00c6:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version 1 certificate contains extra data"
            r8.<init>(r0)
            throw r8
        L_0x00ce:
            if (r5 <= 0) goto L_0x0105
            int r2 = r1 + r5
            org.spongycastle.asn1.ASN1Encodable r2 = r8.getObjectAt(r2)
            org.spongycastle.asn1.ASN1TaggedObject r2 = (org.spongycastle.asn1.ASN1TaggedObject) r2
            int r6 = r2.getTagNo()
            switch(r6) {
                case 1: goto L_0x00fc;
                case 2: goto L_0x00f5;
                case 3: goto L_0x00e0;
                default: goto L_0x00df;
            }
        L_0x00df:
            goto L_0x0102
        L_0x00e0:
            if (r3 != 0) goto L_0x00ed
            org.spongycastle.asn1.ASN1Sequence r2 = org.spongycastle.asn1.ASN1Sequence.getInstance(r2, r4)
            org.spongycastle.asn1.x509.Extensions r2 = org.spongycastle.asn1.x509.Extensions.getInstance(r2)
            r7.extensions = r2
            goto L_0x0102
        L_0x00ed:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version 2 certificate cannot contain extensions"
            r8.<init>(r0)
            throw r8
        L_0x00f5:
            org.spongycastle.asn1.DERBitString r2 = org.spongycastle.asn1.DERBitString.getInstance(r2, r0)
            r7.subjectUniqueId = r2
            goto L_0x0102
        L_0x00fc:
            org.spongycastle.asn1.DERBitString r2 = org.spongycastle.asn1.DERBitString.getInstance(r2, r0)
            r7.issuerUniqueId = r2
        L_0x0102:
            int r5 = r5 + -1
            goto L_0x00ce
        L_0x0105:
            return
        L_0x0106:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version number not recognised"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.TBSCertificate.<init>(org.spongycastle.asn1.ASN1Sequence):void");
    }

    public static TBSCertificate getInstance(Object obj) {
        if (obj instanceof TBSCertificate) {
            return (TBSCertificate) obj;
        }
        if (obj != null) {
            return new TBSCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static TBSCertificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public Time getEndDate() {
        return this.endDate;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public DERBitString getIssuerUniqueId() {
        return this.issuerUniqueId;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Time getStartDate() {
        return this.startDate;
    }

    public X500Name getSubject() {
        return this.subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPublicKeyInfo;
    }

    public DERBitString getSubjectUniqueId() {
        return this.subjectUniqueId;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public int getVersionNumber() {
        return this.version.getValue().intValue() + 1;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
