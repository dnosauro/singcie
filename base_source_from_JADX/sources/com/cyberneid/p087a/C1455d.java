package com.cyberneid.p087a;

import com.p137e.p139b.C2138b;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.jce.provider.X509CertificateObject;

/* renamed from: com.cyberneid.a.d */
public class C1455d {

    /* renamed from: a */
    private static C1455d f4320a;

    /* renamed from: b */
    private HashMap<String, X509Certificate> f4321b = new HashMap<>();

    private C1455d() {
    }

    /* renamed from: a */
    public static C1455d m5485a() {
        if (f4320a == null) {
            f4320a = new C1455d();
        }
        return f4320a;
    }

    /* renamed from: a */
    public void mo6918a(X509Certificate x509Certificate) {
        try {
            SubjectKeyIdentifier fromExtensions = SubjectKeyIdentifier.fromExtensions(new X509CertificateHolder(x509Certificate.getEncoded()).getExtensions());
            this.f4321b.put(fromExtensions != null ? C2138b.m8399b(fromExtensions.getKeyIdentifier()) : x509Certificate.getSubjectX500Principal().getName("RFC1779"), x509Certificate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public X509CertificateObject mo6919b(X509Certificate x509Certificate) {
        try {
            AuthorityKeyIdentifier fromExtensions = AuthorityKeyIdentifier.fromExtensions(new X509CertificateHolder(x509Certificate.getEncoded()).getExtensions());
            X509Certificate x509Certificate2 = this.f4321b.get(fromExtensions != null ? C2138b.m8399b(fromExtensions.getKeyIdentifier()) : x509Certificate.getIssuerX500Principal().getName("RFC1779"));
            if (x509Certificate2 == null || x509Certificate2.getSerialNumber().equals(x509Certificate.getSerialNumber())) {
                return null;
            }
            return new X509CertificateObject(Certificate.getInstance(ASN1TaggedObject.fromByteArray(x509Certificate2.getEncoded())));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
