package org.spongycastle.cert;

import java.math.BigInteger;
import java.util.ArrayList;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.Holder;
import org.spongycastle.asn1.x509.IssuerSerial;
import org.spongycastle.asn1.x509.ObjectDigestInfo;
import org.spongycastle.operator.DigestCalculatorProvider;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;

public class AttributeCertificateHolder implements Selector {
    private static DigestCalculatorProvider digestCalculatorProvider;
    final Holder holder;

    public AttributeCertificateHolder(int i, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, byte[] bArr) {
        this.holder = new Holder(new ObjectDigestInfo(i, aSN1ObjectIdentifier2, new AlgorithmIdentifier(aSN1ObjectIdentifier), Arrays.clone(bArr)));
    }

    AttributeCertificateHolder(ASN1Sequence aSN1Sequence) {
        this.holder = Holder.getInstance(aSN1Sequence);
    }

    public AttributeCertificateHolder(X500Name x500Name) {
        this.holder = new Holder(generateGeneralNames(x500Name));
    }

    public AttributeCertificateHolder(X500Name x500Name, BigInteger bigInteger) {
        this.holder = new Holder(new IssuerSerial(generateGeneralNames(x500Name), new ASN1Integer(bigInteger)));
    }

    public AttributeCertificateHolder(X509CertificateHolder x509CertificateHolder) {
        this.holder = new Holder(new IssuerSerial(generateGeneralNames(x509CertificateHolder.getIssuer()), new ASN1Integer(x509CertificateHolder.getSerialNumber())));
    }

    private GeneralNames generateGeneralNames(X500Name x500Name) {
        return new GeneralNames(new GeneralName(x500Name));
    }

    private X500Name[] getPrincipals(GeneralName[] generalNameArr) {
        ArrayList arrayList = new ArrayList(generalNameArr.length);
        for (int i = 0; i != generalNameArr.length; i++) {
            if (generalNameArr[i].getTagNo() == 4) {
                arrayList.add(X500Name.getInstance(generalNameArr[i].getName()));
            }
        }
        return (X500Name[]) arrayList.toArray(new X500Name[arrayList.size()]);
    }

    private boolean matchesDN(X500Name x500Name, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            GeneralName generalName = names[i];
            if (generalName.getTagNo() == 4 && X500Name.getInstance(generalName.getName()).equals(x500Name)) {
                return true;
            }
        }
        return false;
    }

    public static void setDigestCalculatorProvider(DigestCalculatorProvider digestCalculatorProvider2) {
        digestCalculatorProvider = digestCalculatorProvider2;
    }

    public Object clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.holder.toASN1Primitive());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateHolder)) {
            return false;
        }
        return this.holder.equals(((AttributeCertificateHolder) obj).holder);
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestAlgorithm();
        }
        return null;
    }

    public int getDigestedObjectType() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestedObjectType().getValue().intValue();
        }
        return -1;
    }

    public X500Name[] getEntityNames() {
        if (this.holder.getEntityName() != null) {
            return getPrincipals(this.holder.getEntityName().getNames());
        }
        return null;
    }

    public X500Name[] getIssuer() {
        if (this.holder.getBaseCertificateID() != null) {
            return getPrincipals(this.holder.getBaseCertificateID().getIssuer().getNames());
        }
        return null;
    }

    public byte[] getObjectDigest() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    public ASN1ObjectIdentifier getOtherObjectTypeID() {
        if (this.holder.getObjectDigestInfo() == null) {
            return null;
        }
        new ASN1ObjectIdentifier(this.holder.getObjectDigestInfo().getOtherObjectTypeID().getId());
        return null;
    }

    public BigInteger getSerialNumber() {
        if (this.holder.getBaseCertificateID() != null) {
            return this.holder.getBaseCertificateID().getSerial().getValue();
        }
        return null;
    }

    public int hashCode() {
        return this.holder.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
        r2.write(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009c, code lost:
        if (org.spongycastle.util.Arrays.areEqual(r0.getDigest(), getObjectDigest()) != false) goto L_0x009e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean match(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof org.spongycastle.cert.X509CertificateHolder
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            org.spongycastle.cert.X509CertificateHolder r5 = (org.spongycastle.cert.X509CertificateHolder) r5
            org.spongycastle.asn1.x509.Holder r0 = r4.holder
            org.spongycastle.asn1.x509.IssuerSerial r0 = r0.getBaseCertificateID()
            r2 = 1
            if (r0 == 0) goto L_0x003f
            org.spongycastle.asn1.x509.Holder r0 = r4.holder
            org.spongycastle.asn1.x509.IssuerSerial r0 = r0.getBaseCertificateID()
            org.spongycastle.asn1.ASN1Integer r0 = r0.getSerial()
            java.math.BigInteger r0 = r0.getValue()
            java.math.BigInteger r3 = r5.getSerialNumber()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x003e
            org.spongycastle.asn1.x500.X500Name r5 = r5.getIssuer()
            org.spongycastle.asn1.x509.Holder r0 = r4.holder
            org.spongycastle.asn1.x509.IssuerSerial r0 = r0.getBaseCertificateID()
            org.spongycastle.asn1.x509.GeneralNames r0 = r0.getIssuer()
            boolean r5 = r4.matchesDN(r5, r0)
            if (r5 == 0) goto L_0x003e
            r1 = 1
        L_0x003e:
            return r1
        L_0x003f:
            org.spongycastle.asn1.x509.Holder r0 = r4.holder
            org.spongycastle.asn1.x509.GeneralNames r0 = r0.getEntityName()
            if (r0 == 0) goto L_0x0058
            org.spongycastle.asn1.x500.X500Name r0 = r5.getSubject()
            org.spongycastle.asn1.x509.Holder r3 = r4.holder
            org.spongycastle.asn1.x509.GeneralNames r3 = r3.getEntityName()
            boolean r0 = r4.matchesDN(r0, r3)
            if (r0 == 0) goto L_0x0058
            return r2
        L_0x0058:
            org.spongycastle.asn1.x509.Holder r0 = r4.holder
            org.spongycastle.asn1.x509.ObjectDigestInfo r0 = r0.getObjectDigestInfo()
            if (r0 == 0) goto L_0x009e
            org.spongycastle.operator.DigestCalculatorProvider r0 = digestCalculatorProvider     // Catch:{ Exception -> 0x009e }
            org.spongycastle.asn1.x509.Holder r2 = r4.holder     // Catch:{ Exception -> 0x009e }
            org.spongycastle.asn1.x509.ObjectDigestInfo r2 = r2.getObjectDigestInfo()     // Catch:{ Exception -> 0x009e }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r2 = r2.getDigestAlgorithm()     // Catch:{ Exception -> 0x009e }
            org.spongycastle.operator.DigestCalculator r0 = r0.get(r2)     // Catch:{ Exception -> 0x009e }
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ Exception -> 0x009e }
            int r3 = r4.getDigestedObjectType()     // Catch:{ Exception -> 0x009e }
            switch(r3) {
                case 0: goto L_0x0084;
                case 1: goto L_0x007c;
                default: goto L_0x007b;
            }     // Catch:{ Exception -> 0x009e }
        L_0x007b:
            goto L_0x008d
        L_0x007c:
            byte[] r5 = r5.getEncoded()     // Catch:{ Exception -> 0x009e }
        L_0x0080:
            r2.write(r5)     // Catch:{ Exception -> 0x009e }
            goto L_0x008d
        L_0x0084:
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r5 = r5.getSubjectPublicKeyInfo()     // Catch:{ Exception -> 0x009e }
            byte[] r5 = r5.getEncoded()     // Catch:{ Exception -> 0x009e }
            goto L_0x0080
        L_0x008d:
            r2.close()     // Catch:{ Exception -> 0x009e }
            byte[] r5 = r0.getDigest()     // Catch:{ Exception -> 0x009e }
            byte[] r0 = r4.getObjectDigest()     // Catch:{ Exception -> 0x009e }
            boolean r5 = org.spongycastle.util.Arrays.areEqual((byte[]) r5, (byte[]) r0)     // Catch:{ Exception -> 0x009e }
            if (r5 != 0) goto L_0x009e
        L_0x009e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cert.AttributeCertificateHolder.match(java.lang.Object):boolean");
    }
}
