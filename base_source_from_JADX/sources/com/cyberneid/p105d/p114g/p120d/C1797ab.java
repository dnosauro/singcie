package com.cyberneid.p105d.p114g.p120d;

import android.util.Log;
import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import com.cyberneid.p105d.p114g.p120d.p121a.C1788b;
import com.cyberneid.p105d.p114g.p120d.p121a.C1789c;
import com.cyberneid.p105d.p114g.p120d.p121a.C1790d;
import com.cyberneid.p105d.p131h.C1940d;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.g.d.ab */
public class C1797ab extends C1826v {

    /* renamed from: e */
    private C1940d f5810e;

    public C1797ab(C1607d dVar) {
        super(dVar);
        mo8102m();
    }

    /* renamed from: a */
    public float mo8094a(int i) {
        int b = this.f5884b.mo7529b(C1613i.f5076cz, -1);
        int b2 = this.f5884b.mo7529b(C1613i.f5089dL, -1);
        if (mo8168h().size() > 0 && i >= b && i <= b2) {
            return mo8168h().get(i - b).floatValue();
        }
        C1821q b3 = mo8163b();
        if (b3 != null) {
            return b3.mo8207n();
        }
        Log.e("PdfBox-Android", "No width for glyph " + i + " in font " + mo8099f());
        return 0.0f;
    }

    /* renamed from: a */
    public int mo8095a(InputStream inputStream) {
        return inputStream.read();
    }

    /* renamed from: c */
    public float mo8096c(int i) {
        throw new UnsupportedOperationException("not suppported");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public byte[] mo8097d(int i) {
        throw new UnsupportedOperationException("Not implemented: Type3");
    }

    /* renamed from: e */
    public boolean mo8098e() {
        return true;
    }

    /* renamed from: f */
    public String mo8099f() {
        return this.f5884b.mo7544e(C1613i.f5181ey);
    }

    /* renamed from: g */
    public C1586a mo8100g() {
        C1763f u = mo8105u();
        return new C1586a(u.mo7946c(), u.mo7949e(), u.mo7952h(), u.mo7953i());
    }

    /* renamed from: i */
    public C1940d mo8101i() {
        if (this.f5810e == null) {
            C1604a aVar = (C1604a) this.f5884b.mo7539c(C1613i.f5037cM);
            if (aVar == null) {
                return super.mo8101i();
            }
            this.f5810e = new C1940d(aVar);
        }
        return this.f5810e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public final void mo8102m() {
        this.f5896c = new C1788b((C1607d) this.f5884b.mo7539c(C1613i.f5053cc));
        this.f5897d = C1790d.m7254b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public C1789c mo8103n() {
        throw new UnsupportedOperationException("not supported for Type 3 fonts");
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public Boolean mo8104s() {
        return false;
    }

    /* renamed from: u */
    public C1763f mo8105u() {
        C1604a aVar = (C1604a) this.f5884b.mo7539c(C1613i.f5031cG);
        if (aVar != null) {
            return new C1763f(aVar);
        }
        return null;
    }
}
