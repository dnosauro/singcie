package com.cyberneid.p105d.p114g.p118b;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1606c;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1622p;
import java.io.IOException;

/* renamed from: com.cyberneid.d.g.b.f */
public class C1771f {

    /* renamed from: a */
    private final C1607d f5747a;

    /* renamed from: b */
    private C1778m f5748b;

    public C1771f() {
        this.f5747a = new C1607d();
    }

    public C1771f(C1607d dVar) {
        this.f5747a = dVar;
        this.f5748b = C1779n.f5768a.mo8041a(mo7997c());
    }

    /* renamed from: a */
    public C1770e mo7984a(C1613i iVar) {
        C1607d dVar;
        C1607d dVar2 = (C1607d) this.f5747a.mo7539c(C1613i.f4960ap);
        if (dVar2 == null || (dVar = (C1607d) dVar2.mo7539c(iVar)) == null) {
            return null;
        }
        return new C1770e(dVar);
    }

    /* renamed from: a */
    public C1778m mo7985a() {
        C1778m mVar = this.f5748b;
        if (mVar != null) {
            return mVar;
        }
        throw new IOException("No security handler for filter " + mo7997c());
    }

    /* renamed from: a */
    public void mo7986a(int i) {
        this.f5747a.mo7518a(C1613i.f5297hH, i);
    }

    /* renamed from: a */
    public void mo7987a(C1613i iVar, C1770e eVar) {
        C1607d dVar = (C1607d) this.f5747a.mo7539c(C1613i.f4960ap);
        if (dVar == null) {
            dVar = new C1607d();
            this.f5747a.mo7521a(C1613i.f4960ap, (C1605b) dVar);
        }
        dVar.mo7521a(iVar, (C1605b) eVar.mo7980a());
    }

    /* renamed from: a */
    public void mo7988a(C1770e eVar) {
        mo7987a(C1613i.f5246gJ, eVar);
    }

    /* renamed from: a */
    public void mo7989a(String str) {
        this.f5747a.mo7521a(C1613i.f5074cx, (C1605b) C1613i.m6461a(str));
    }

    /* renamed from: a */
    public void mo7990a(byte[] bArr) {
        this.f5747a.mo7521a(C1613i.f5139eI, (C1605b) new C1622p(bArr));
    }

    /* renamed from: a */
    public void mo7991a(byte[][] bArr) {
        C1604a aVar = new C1604a();
        for (byte[] pVar : bArr) {
            aVar.mo7490a((C1605b) new C1622p(pVar));
        }
        this.f5747a.mo7521a(C1613i.f5209fZ, (C1605b) aVar);
    }

    /* renamed from: b */
    public C1607d mo7992b() {
        return this.f5747a;
    }

    /* renamed from: b */
    public void mo7993b(int i) {
        this.f5747a.mo7518a(C1613i.f5095dR, i);
    }

    /* renamed from: b */
    public void mo7994b(C1613i iVar) {
        this.f5747a.mo7521a(C1613i.f5249gM, (C1605b) iVar);
    }

    /* renamed from: b */
    public void mo7995b(String str) {
        this.f5747a.mo7523a(C1613i.f5255gS, str);
    }

    /* renamed from: b */
    public void mo7996b(byte[] bArr) {
        this.f5747a.mo7521a(C1613i.f5290hA, (C1605b) new C1622p(bArr));
    }

    /* renamed from: c */
    public final String mo7997c() {
        return this.f5747a.mo7544e(C1613i.f5074cx);
    }

    /* renamed from: c */
    public void mo7998c(int i) {
        this.f5747a.mo7518a(C1613i.f5203fT, i);
    }

    /* renamed from: c */
    public void mo7999c(C1613i iVar) {
        this.f5747a.mo7521a(C1613i.f5250gN, (C1605b) iVar);
    }

    /* renamed from: c */
    public void mo8000c(byte[] bArr) {
        this.f5747a.mo7521a(C1613i.f5146eP, (C1605b) new C1622p(bArr));
    }

    /* renamed from: d */
    public int mo8001d() {
        return this.f5747a.mo7529b(C1613i.f5297hH, 0);
    }

    /* renamed from: d */
    public void mo8002d(int i) {
        this.f5747a.mo7518a(C1613i.f5223fn, i);
    }

    /* renamed from: d */
    public void mo8003d(byte[] bArr) {
        this.f5747a.mo7521a(C1613i.f5291hB, (C1605b) new C1622p(bArr));
    }

    /* renamed from: e */
    public int mo8004e() {
        return this.f5747a.mo7529b(C1613i.f5095dR, 40);
    }

    /* renamed from: e */
    public C1622p mo8005e(int i) {
        return (C1622p) ((C1604a) this.f5747a.mo7554k(C1613i.f5209fZ)).mo7495b(i);
    }

    /* renamed from: f */
    public int mo8006f() {
        return this.f5747a.mo7529b(C1613i.f5203fT, 0);
    }

    /* renamed from: g */
    public byte[] mo8007g() {
        C1622p pVar = (C1622p) this.f5747a.mo7539c(C1613i.f5139eI);
        if (pVar != null) {
            return pVar.mo7643c();
        }
        return null;
    }

    /* renamed from: h */
    public byte[] mo8008h() {
        C1622p pVar = (C1622p) this.f5747a.mo7539c(C1613i.f5290hA);
        if (pVar != null) {
            return pVar.mo7643c();
        }
        return null;
    }

    /* renamed from: i */
    public byte[] mo8009i() {
        C1622p pVar = (C1622p) this.f5747a.mo7539c(C1613i.f5146eP);
        if (pVar != null) {
            return pVar.mo7643c();
        }
        return null;
    }

    /* renamed from: j */
    public byte[] mo8010j() {
        C1622p pVar = (C1622p) this.f5747a.mo7539c(C1613i.f5291hB);
        if (pVar != null) {
            return pVar.mo7643c();
        }
        return null;
    }

    /* renamed from: k */
    public int mo8011k() {
        return this.f5747a.mo7529b(C1613i.f5223fn, 0);
    }

    /* renamed from: l */
    public boolean mo8012l() {
        C1605b c = this.f5747a.mo7539c(C1613i.f5059ci);
        if (c instanceof C1606c) {
            return ((C1606c) c).mo7508a();
        }
        return true;
    }

    /* renamed from: m */
    public int mo8013m() {
        return ((C1604a) this.f5747a.mo7554k(C1613i.f5209fZ)).mo7494b();
    }

    /* renamed from: n */
    public C1770e mo8014n() {
        return mo7984a(C1613i.f5246gJ);
    }

    /* renamed from: o */
    public byte[] mo8015o() {
        C1622p pVar = (C1622p) this.f5747a.mo7539c(C1613i.f5186fC);
        if (pVar != null) {
            return pVar.mo7643c();
        }
        return null;
    }

    /* renamed from: p */
    public void mo8016p() {
        this.f5747a.mo7521a(C1613i.f4960ap, (C1605b) null);
        this.f5747a.mo7521a(C1613i.f5249gM, (C1605b) null);
        this.f5747a.mo7521a(C1613i.f5250gN, (C1605b) null);
    }
}
