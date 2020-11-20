package com.cyberneid.p089b.p095f;

import android.util.Log;

/* renamed from: com.cyberneid.b.f.k */
public class C1563k extends C1578z {

    /* renamed from: a */
    private C1559j[] f4665a;

    C1563k(C1544ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    public void mo7175a(C1544ab abVar, C1575w wVar) {
        int i;
        int d = wVar.mo7281d();
        if (d != 0) {
            d = (d << 16) | wVar.mo7281d();
        }
        if (d == 0) {
            i = wVar.mo7281d();
        } else if (d == 1) {
            i = (int) wVar.mo7358k();
        } else {
            Log.d("PdfBox-Android", "Skipped kerning table due to an unsupported kerning table version: " + d);
            i = 0;
        }
        if (i > 0) {
            this.f4665a = new C1559j[i];
            for (int i2 = 0; i2 < i; i2++) {
                C1559j jVar = new C1559j();
                jVar.mo7257a(wVar, d);
                this.f4665a[i2] = jVar;
            }
        }
        this.f4757b = true;
    }
}
