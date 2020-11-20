package com.cyberneid.p087a;

import java.io.IOException;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.tsp.TSPException;

/* renamed from: com.cyberneid.a.i */
public abstract class C1460i {

    /* renamed from: a */
    private C1457f f4329a = new C1457f();

    /* renamed from: a */
    public static void m5495a(String str, String str2) {
        C1457f.m5490a(str, str2);
    }

    /* renamed from: a */
    public C1451a mo6924a(byte[] bArr, C1454c cVar, boolean z, boolean z2, boolean z3) {
        try {
            return mo6925a(bArr, cVar, z, z2, z3, (C1468p) null);
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public C1451a mo6925a(byte[] bArr, C1454c cVar, boolean z, boolean z2, boolean z3, C1468p pVar) {
        try {
            return C1451a.m5467a(this.f4329a.mo6920a(bArr, mo6927a(cVar), z, z2, z3, pVar));
        } catch (TSPException e) {
            throw new C1458g(-2130706265, e.getMessage());
        }
    }

    /* renamed from: a */
    public C1451a mo6926a(byte[] bArr, X509CertificateHolder x509CertificateHolder, boolean z, boolean z2, boolean z3, C1468p pVar) {
        try {
            return C1451a.m5467a(this.f4329a.mo6920a(bArr, mo6928a(x509CertificateHolder), z, z2, z3, pVar));
        } catch (TSPException e) {
            throw new C1458g(-2130706265, e.getMessage());
        }
    }

    /* renamed from: a */
    public abstract C1465m mo6927a(C1454c cVar);

    /* renamed from: a */
    public abstract C1465m mo6928a(X509CertificateHolder x509CertificateHolder);
}
