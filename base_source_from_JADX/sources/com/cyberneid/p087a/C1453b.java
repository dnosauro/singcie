package com.cyberneid.p087a;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPConnectionOptions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.util.p191io.Streams;

/* renamed from: com.cyberneid.a.b */
public class C1453b {

    /* renamed from: a */
    public static int f4318a = 35000;

    /* renamed from: b */
    public static int f4319b = 35000;

    /* renamed from: a */
    public static int m5479a(X509Certificate x509Certificate, Date date) {
        X509CRL x509crl;
        try {
            for (String a : m5482a(x509Certificate)) {
                try {
                    x509crl = m5481a(a);
                    continue;
                } catch (Exception e) {
                    e.printStackTrace();
                    x509crl = null;
                    continue;
                }
                if (x509crl != null) {
                    if (!x509crl.isRevoked(x509Certificate)) {
                        return 0;
                    }
                    X509CRLEntry revokedCertificate = x509crl.getRevokedCertificate(x509Certificate);
                    if (date == null || !date.before(revokedCertificate.getRevocationDate())) {
                        return x509crl.getRevokedCertificate(x509Certificate).getExtensionValue("2.5.29.21")[2] == 6 ? 2 : 1;
                    }
                    return 0;
                }
            }
        } catch (Exception unused) {
        }
        return 3;
    }

    /* renamed from: a */
    private static LDAPConnection m5480a(String str, int i) {
        LDAPConnection lDAPConnection = new LDAPConnection();
        LDAPConnectionOptions lDAPConnectionOptions = new LDAPConnectionOptions();
        lDAPConnectionOptions.setConnectTimeoutMillis(f4318a);
        lDAPConnectionOptions.setResponseTimeoutMillis((long) f4319b);
        lDAPConnectionOptions.abandonOnTimeout();
        lDAPConnection.setConnectionOptions(lDAPConnectionOptions);
        lDAPConnection.connect(str, i);
        return lDAPConnection;
    }

    /* renamed from: a */
    private static X509CRL m5481a(String str) {
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://")) {
            return m5484c(str);
        }
        if (str.startsWith("ldap://")) {
            return m5483b(str);
        }
        throw new C1456e("Can not download CRL from certificate distribution point: " + str);
    }

    /* renamed from: a */
    public static List<String> m5482a(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.CRLDistributionPoints.getId());
        if (extensionValue == null) {
            return new ArrayList();
        }
        CRLDistPoint instance = CRLDistPoint.getInstance(new ASN1InputStream((InputStream) new ByteArrayInputStream(((DEROctetString) new ASN1InputStream((InputStream) new ByteArrayInputStream(extensionValue)).readObject()).getOctets())).readObject());
        ArrayList arrayList = new ArrayList();
        for (DistributionPoint distributionPoint : instance.getDistributionPoints()) {
            DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
            if (distributionPoint2 != null && distributionPoint2.getType() == 0) {
                GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                for (int i = 0; i < names.length; i++) {
                    if (names[i].getTagNo() == 6) {
                        arrayList.add(DERIA5String.getInstance(names[i].getName()).getString());
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b8, code lost:
        throw new com.cyberneid.p087a.C1456e("Can not download CRL from: " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b9, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bc, code lost:
        throw r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00a2 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.X509CRL m5483b(java.lang.String r9) {
        /*
            r0 = 7
            java.lang.String r0 = r9.substring(r0)
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)
            r1 = 1
            r2 = r0[r1]
            java.lang.String r3 = "?"
            java.lang.String[] r2 = r2.split(r3)
            r3 = 0
            r0 = r0[r3]     // Catch:{ LDAPException -> 0x00bd }
            java.lang.String r4 = ":"
            java.lang.String[] r0 = r0.split(r4)     // Catch:{ LDAPException -> 0x00bd }
            r4 = 389(0x185, float:5.45E-43)
            int r5 = r0.length     // Catch:{ LDAPException -> 0x00bd }
            r6 = 2
            if (r5 != r6) goto L_0x0029
            r4 = r0[r1]     // Catch:{ LDAPException -> 0x00bd }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ LDAPException -> 0x00bd }
        L_0x0029:
            r0 = r0[r3]     // Catch:{ LDAPException -> 0x00bd }
            com.unboundid.ldap.sdk.LDAPConnection r0 = m5480a((java.lang.String) r0, (int) r4)     // Catch:{ LDAPException -> 0x00bd }
            r4 = r2[r3]     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.String r4 = java.net.URLDecoder.decode(r4)     // Catch:{ LDAPSearchException -> 0x00a2 }
            com.unboundid.ldap.sdk.SearchScope r5 = com.unboundid.ldap.sdk.SearchScope.BASE     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.String r6 = "objectClass=*"
            java.lang.String[] r7 = new java.lang.String[r1]     // Catch:{ LDAPSearchException -> 0x00a2 }
            int r8 = r2.length     // Catch:{ LDAPSearchException -> 0x00a2 }
            if (r8 <= r1) goto L_0x0045
            r1 = r2[r1]     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ LDAPSearchException -> 0x00a2 }
            goto L_0x0047
        L_0x0045:
            java.lang.String r1 = "certificateRevocationList;binary"
        L_0x0047:
            r7[r3] = r1     // Catch:{ LDAPSearchException -> 0x00a2 }
            com.unboundid.ldap.sdk.SearchResultEntry r1 = r0.searchForEntry((java.lang.String) r4, (com.unboundid.ldap.sdk.SearchScope) r5, (java.lang.String) r6, (java.lang.String[]) r7)     // Catch:{ LDAPSearchException -> 0x00a2 }
            if (r1 == 0) goto L_0x0089
            java.lang.String r2 = "certificateRevocationList;binary"
            com.unboundid.ldap.sdk.Attribute r1 = r1.getAttribute(r2)     // Catch:{ LDAPSearchException -> 0x00a2 }
            if (r1 == 0) goto L_0x0072
            byte[][] r1 = r1.getValueByteArrays()     // Catch:{ LDAPSearchException -> 0x00a2 }
            r9 = r1[r3]     // Catch:{ LDAPSearchException -> 0x00a2 }
            r0.close()
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r9)
            java.lang.String r9 = "X.509"
            java.security.cert.CertificateFactory r9 = java.security.cert.CertificateFactory.getInstance(r9)
            java.security.cert.CRL r9 = r9.generateCRL(r0)
            java.security.cert.X509CRL r9 = (java.security.cert.X509CRL) r9
            return r9
        L_0x0072:
            com.cyberneid.a.e r1 = new com.cyberneid.a.e     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ LDAPSearchException -> 0x00a2 }
            r2.<init>()     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.String r3 = "Can not download CRL from: "
            r2.append(r3)     // Catch:{ LDAPSearchException -> 0x00a2 }
            r2.append(r9)     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.String r2 = r2.toString()     // Catch:{ LDAPSearchException -> 0x00a2 }
            r1.<init>(r2)     // Catch:{ LDAPSearchException -> 0x00a2 }
            throw r1     // Catch:{ LDAPSearchException -> 0x00a2 }
        L_0x0089:
            com.cyberneid.a.e r1 = new com.cyberneid.a.e     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ LDAPSearchException -> 0x00a2 }
            r2.<init>()     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.String r3 = "Can not download CRL from: "
            r2.append(r3)     // Catch:{ LDAPSearchException -> 0x00a2 }
            r2.append(r9)     // Catch:{ LDAPSearchException -> 0x00a2 }
            java.lang.String r2 = r2.toString()     // Catch:{ LDAPSearchException -> 0x00a2 }
            r1.<init>(r2)     // Catch:{ LDAPSearchException -> 0x00a2 }
            throw r1     // Catch:{ LDAPSearchException -> 0x00a2 }
        L_0x00a0:
            r9 = move-exception
            goto L_0x00b9
        L_0x00a2:
            com.cyberneid.a.e r1 = new com.cyberneid.a.e     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r2.<init>()     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = "Can not download CRL from: "
            r2.append(r3)     // Catch:{ all -> 0x00a0 }
            r2.append(r9)     // Catch:{ all -> 0x00a0 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00a0 }
            r1.<init>(r9)     // Catch:{ all -> 0x00a0 }
            throw r1     // Catch:{ all -> 0x00a0 }
        L_0x00b9:
            r0.close()
            throw r9
        L_0x00bd:
            r0 = move-exception
            r0.printStackTrace()
            com.cyberneid.a.e r0 = new com.cyberneid.a.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can not download CRL from: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p087a.C1453b.m5483b(java.lang.String):java.security.cert.X509CRL");
    }

    /* renamed from: c */
    private static X509CRL m5484c(String str) {
        InputStream openStream = new URL(str).openStream();
        new ByteArrayInputStream(Streams.readAll(openStream));
        try {
            return (X509CRL) CertificateFactory.getInstance("X.509").generateCRL(openStream);
        } finally {
            openStream.close();
        }
    }
}
