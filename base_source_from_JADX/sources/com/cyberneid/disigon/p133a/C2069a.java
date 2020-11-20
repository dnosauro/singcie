package com.cyberneid.disigon.p133a;

import android.content.Context;
import com.cyberneid.p087a.C1454c;
import com.cyberneid.p087a.C1458g;
import com.cyberneid.p087a.C1460i;
import com.cyberneid.p087a.C1465m;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.IOException;
import org.spongycastle.cert.X509CertificateHolder;
import p066b.p067a.p068a.p072d.C1366e;

/* renamed from: com.cyberneid.disigon.a.a */
public class C2069a extends C1460i {

    /* renamed from: a */
    C2071c f6482a;

    public C2069a(Context context) {
        C1460i.m5495a("cyberneid.com", "AJDO-S6D7-4VTR-6WAR-64WG-6AAX-4QUC");
        this.f6482a = new C2071c(context);
    }

    /* renamed from: a */
    public int mo8674a(int i) {
        return this.f6482a.mo8681a();
    }

    /* renamed from: a */
    public int mo8675a(String str) {
        return this.f6482a.mo8682a(str);
    }

    /* renamed from: a */
    public C1465m mo6927a(C1454c cVar) {
        return this.f6482a;
    }

    /* renamed from: a */
    public C1465m mo6928a(X509CertificateHolder x509CertificateHolder) {
        return this.f6482a;
    }

    /* renamed from: a */
    public void mo8676a() {
        this.f6482a.mo8686b();
    }

    /* renamed from: a */
    public void mo8677a(C1366e eVar) {
        this.f6482a.mo8684a(eVar);
    }

    /* renamed from: b */
    public X509CertificateHolder mo8678b(C1454c cVar) {
        try {
            return new X509CertificateHolder(this.f6482a.mo6943c());
        } catch (IOException e) {
            FirebaseCrashlytics.getInstance().log("Certificate Exception");
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
            throw new C1458g(-2130706268);
        }
    }

    /* renamed from: b */
    public void mo8679b() {
    }
}
