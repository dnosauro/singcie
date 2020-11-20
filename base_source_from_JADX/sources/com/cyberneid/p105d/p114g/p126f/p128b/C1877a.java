package com.cyberneid.p105d.p114g.p126f.p128b;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1615k;
import com.cyberneid.p105d.p114g.C1831e;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import java.io.IOException;

/* renamed from: com.cyberneid.d.g.f.b.a */
public abstract class C1877a implements C1760c {

    /* renamed from: a */
    private final C1607d f6036a;

    public C1877a() {
        this.f6036a = new C1607d();
        this.f6036a.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5353o);
    }

    public C1877a(C1607d dVar) {
        this.f6036a = dVar;
        this.f6036a.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5353o);
    }

    /* renamed from: a */
    public static C1877a m7774a(C1605b bVar) {
        if (bVar instanceof C1607d) {
            C1607d dVar = (C1607d) bVar;
            String e = dVar.mo7544e(C1613i.f5258gV);
            if ("FileAttachment".equals(e)) {
                return new C1878b(dVar);
            }
            if ("Line".equals(e)) {
                return new C1879c(dVar);
            }
            if ("Link".equals(e)) {
                return new C1880d(dVar);
            }
            if ("Popup".equals(e)) {
                return new C1882f(dVar);
            }
            if ("Stamp".equals(e)) {
                return new C1883g(dVar);
            }
            if ("Square".equals(e) || "Circle".equals(e)) {
                return new C1884h(dVar);
            }
            if ("Text".equals(e)) {
                return new C1885i(dVar);
            }
            if ("Highlight".equals(e) || "Underline".equals(e) || "Squiggly".equals(e) || "StrikeOut".equals(e)) {
                return new C1886j(dVar);
            }
            if ("Link".equals(e)) {
                return new C1880d(dVar);
            }
            if ("Widget".equals(e)) {
                return new C1888l(dVar);
            }
            if ("FreeText".equals(e) || "Polygon".equals(e) || "PolyLine".equals(e) || "Caret".equals(e) || "Ink".equals(e) || "Sound".equals(e)) {
                return new C1881e(dVar);
            }
            C1887k kVar = new C1887k(dVar);
            Log.d("PdfBox-Android", "Unknown or unsupported annotation subtype " + e);
            return kVar;
        }
        throw new IOException("Error: Unknown annotation type " + bVar);
    }

    /* renamed from: a */
    public C1763f mo8338a() {
        C1604a aVar = (C1604a) this.f6036a.mo7539c(C1613i.f5263ga);
        if (aVar != null) {
            if (aVar.mo7494b() == 4 && (aVar.mo7495b(0) instanceof C1615k) && (aVar.mo7495b(1) instanceof C1615k) && (aVar.mo7495b(2) instanceof C1615k) && (aVar.mo7495b(3) instanceof C1615k)) {
                return new C1763f(aVar);
            }
            Log.w("PdfBox-Android", aVar + " is not a rectangle array, returning null");
        }
        return null;
    }

    /* renamed from: a */
    public void mo8339a(C1763f fVar) {
        this.f6036a.mo7521a(C1613i.f5263ga, (C1605b) fVar.mo7944b());
    }

    /* renamed from: a */
    public void mo8340a(C1831e eVar) {
        mo7505d().mo7522a(C1613i.f5223fn, (C1760c) eVar);
    }

    /* renamed from: a */
    public void mo8341a(C1890n nVar) {
        this.f6036a.mo7521a(C1613i.f5356r, (C1605b) nVar != null ? nVar.mo7505d() : null);
    }

    /* renamed from: a */
    public void mo8342a(boolean z) {
        mo7505d().mo7519a(C1613i.f5066cp, 4, z);
    }

    /* renamed from: b */
    public C1607d mo7505d() {
        return this.f6036a;
    }

    /* renamed from: b */
    public void mo8344b(boolean z) {
        mo7505d().mo7519a(C1613i.f5066cp, 128, z);
    }

    /* renamed from: c */
    public C1890n mo8345c() {
        C1607d dVar = (C1607d) this.f6036a.mo7539c(C1613i.f5356r);
        if (dVar != null) {
            return new C1890n(dVar);
        }
        return null;
    }

    /* renamed from: e */
    public boolean mo8346e() {
        return mo7505d().mo7541c(C1613i.f5066cp, 2);
    }

    /* renamed from: f */
    public boolean mo8347f() {
        return mo7505d().mo7541c(C1613i.f5066cp, 32);
    }
}
