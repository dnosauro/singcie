package com.cyberneid.p089b.p095f;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cyberneid.b.f.x */
public class C1576x {

    /* renamed from: a */
    private boolean f4746a;

    /* renamed from: b */
    private boolean f4747b;

    public C1576x() {
        this(false);
    }

    public C1576x(boolean z) {
        this(z, false);
    }

    public C1576x(boolean z, boolean z2) {
        this.f4746a = false;
        this.f4747b = false;
        this.f4746a = z;
        this.f4747b = z2;
    }

    /* renamed from: a */
    private void m6172a(C1544ab abVar, C1575w wVar) {
        for (C1578z next : abVar.mo7187h()) {
            if (!next.mo7370F()) {
                abVar.mo7184c(next);
            }
        }
        if (abVar.mo7193n() == null) {
            throw new IOException("head is mandatory");
        } else if (abVar.mo7194o() == null) {
            throw new IOException("hhead is mandatory");
        } else if (abVar.mo7192m() == null) {
            throw new IOException("maxp is mandatory");
        } else if (abVar.mo7190k() == null && !this.f4746a) {
            throw new IOException("post is mandatory");
        } else if (abVar.mo7196q() == null) {
            throw new IOException("loca is mandatory");
        } else if (abVar.mo7186e() == null) {
            throw new IOException("glyf is mandatory");
        } else if (abVar.mo7189j() == null && !this.f4746a) {
            throw new IOException("name is mandatory");
        } else if (abVar.mo7195p() == null) {
            throw new IOException("hmtx is mandatory");
        } else if (!this.f4746a && abVar.mo7197r() == null) {
            throw new IOException("cmap is mandatory");
        }
    }

    /* renamed from: b */
    private C1578z m6173b(C1544ab abVar, C1575w wVar) {
        String a = wVar.mo7350a(4);
        C1578z cVar = a.equals("cmap") ? new C1552c(abVar) : a.equals("glyf") ? new C1554e(abVar) : a.equals("head") ? new C1555f(abVar) : a.equals("hhea") ? new C1556g(abVar) : a.equals("hmtx") ? new C1557h(abVar) : a.equals("loca") ? new C1558i(abVar) : a.equals("maxp") ? new C1564l(abVar) : a.equals(AppMeasurementSdk.ConditionalUserProperty.NAME) ? new C1567o(abVar) : a.equals("OS/2") ? new C1568p(abVar) : a.equals("post") ? new C1572t(abVar) : a.equals("DSIG") ? new C1553d(abVar) : a.equals("kern") ? new C1563k(abVar) : a.equals("vhea") ? new C1545ac(abVar) : a.equals("vmtx") ? new C1546ad(abVar) : a.equals("VORG") ? new C1547ae(abVar) : mo7331a(abVar, a);
        cVar.mo7372a(a);
        cVar.mo7371a(wVar.mo7358k());
        cVar.mo7374c(wVar.mo7358k());
        cVar.mo7373b(wVar.mo7358k());
        return cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1578z mo7331a(C1544ab abVar, String str) {
        return new C1578z(abVar);
    }

    /* renamed from: b */
    public C1544ab mo7332b(File file) {
        return mo7336d(new C1573u(file, "r"));
    }

    /* renamed from: b */
    public C1544ab mo7333b(InputStream inputStream) {
        return mo7336d(new C1565m(inputStream));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C1544ab mo7335c(C1575w wVar) {
        return new C1544ab(wVar);
    }

    /* renamed from: c */
    public C1544ab mo7361c(InputStream inputStream) {
        this.f4746a = true;
        return mo7336d(new C1565m(inputStream));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C1544ab mo7336d(C1575w wVar) {
        C1544ab c = mo7335c(wVar);
        c.mo7180a(wVar.mo7355h());
        int d = wVar.mo7281d();
        wVar.mo7281d();
        wVar.mo7281d();
        wVar.mo7281d();
        for (int i = 0; i < d; i++) {
            c.mo7181a(m6173b(c, wVar));
        }
        if (!this.f4747b) {
            m6172a(c, wVar);
        }
        return c;
    }
}
