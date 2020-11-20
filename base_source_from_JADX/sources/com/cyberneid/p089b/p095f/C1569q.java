package com.cyberneid.p089b.p095f;

import java.io.File;
import java.io.InputStream;

/* renamed from: com.cyberneid.b.f.q */
public final class C1569q extends C1576x {
    public C1569q() {
    }

    public C1569q(boolean z) {
        this(z, false);
    }

    public C1569q(boolean z, boolean z2) {
        super(z, z2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1571s mo7336d(C1575w wVar) {
        return (C1571s) super.mo7336d(wVar);
    }

    /* renamed from: a */
    public C1571s mo7332b(File file) {
        return (C1571s) super.mo7332b(file);
    }

    /* renamed from: a */
    public C1571s mo7333b(InputStream inputStream) {
        return (C1571s) super.mo7333b(inputStream);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1578z mo7331a(C1544ab abVar, String str) {
        return (str.equals("BASE") || str.equals("GDEF") || str.equals("GPOS") || str.equals("GSUB") || str.equals("JSTF")) ? new C1570r(abVar) : str.equals("CFF ") ? new C1542a(abVar) : super.mo7331a(abVar, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1571s mo7335c(C1575w wVar) {
        return new C1571s(wVar);
    }
}
