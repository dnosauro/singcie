package com.cyberneid.p105d.p114g;

import android.util.Log;
import com.cyberneid.p105d.p106a.C1602a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p114g.p115a.C1689a;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import com.cyberneid.p105d.p114g.p126f.p128b.C1877a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cyberneid.d.g.e */
public class C1831e implements C1602a, C1760c {

    /* renamed from: a */
    private final C1607d f5945a;

    /* renamed from: b */
    private C1931h f5946b;

    /* renamed from: c */
    private C1932i f5947c;

    /* renamed from: d */
    private C1763f f5948d;

    public C1831e() {
        this(C1763f.f5733a);
    }

    C1831e(C1607d dVar, C1932i iVar) {
        this.f5945a = dVar;
        this.f5947c = iVar;
    }

    public C1831e(C1763f fVar) {
        this.f5945a = new C1607d();
        this.f5945a.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5224fo);
        this.f5945a.mo7522a(C1613i.f5172ep, (C1760c) fVar);
    }

    /* renamed from: a */
    private C1763f m7558a(C1763f fVar) {
        C1763f f = mo8247f();
        C1763f fVar2 = new C1763f();
        fVar2.mo7943a(Math.max(f.mo7946c(), fVar.mo7946c()));
        fVar2.mo7945b(Math.max(f.mo7949e(), fVar.mo7949e()));
        fVar2.mo7947c(Math.min(f.mo7950f(), fVar.mo7950f()));
        fVar2.mo7948d(Math.min(f.mo7951g(), fVar.mo7951g()));
        return fVar2;
    }

    /* renamed from: a */
    public InputStream mo7477a() {
        C1605b c = this.f5945a.mo7539c(C1613i.f4934aP);
        if (c instanceof C1619o) {
            return ((C1619o) c).mo7627l();
        }
        if (!(c instanceof C1604a)) {
            return null;
        }
        C1604a aVar = (C1604a) c;
        if (aVar.mo7494b() <= 0) {
            return null;
        }
        byte[] bArr = {10};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.mo7494b(); i++) {
            arrayList.add(((C1619o) aVar.mo7485a(i)).mo7627l());
            arrayList.add(new ByteArrayInputStream(bArr));
        }
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    /* renamed from: a */
    public void mo8241a(C1764g gVar) {
        this.f5945a.mo7522a(C1613i.f4934aP, (C1760c) gVar);
    }

    /* renamed from: a */
    public void mo8242a(C1931h hVar) {
        this.f5946b = hVar;
        if (hVar != null) {
            this.f5945a.mo7522a(C1613i.f5267ge, (C1760c) hVar);
        } else {
            this.f5945a.mo7553j(C1613i.f5267ge);
        }
    }

    /* renamed from: b */
    public C1607d mo7505d() {
        return this.f5945a;
    }

    /* renamed from: c */
    public boolean mo8244c() {
        C1605b c = this.f5945a.mo7539c(C1613i.f4934aP);
        return c instanceof C1619o ? ((C1619o) c).mo7511a() > 0 : (c instanceof C1604a) && ((C1604a) c).mo7494b() > 0;
    }

    /* renamed from: e */
    public C1931h mo8245e() {
        C1607d dVar;
        if (this.f5946b == null && (dVar = (C1607d) C1928g.m7938a(this.f5945a, C1613i.f5267ge)) != null) {
            this.f5946b = new C1931h(dVar, this.f5947c);
        }
        return this.f5946b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1831e) && ((C1831e) obj).mo7505d() == mo7505d();
    }

    /* renamed from: f */
    public C1763f mo8247f() {
        C1604a aVar;
        if (this.f5948d == null && (aVar = (C1604a) C1928g.m7938a(this.f5945a, C1613i.f5172ep)) != null) {
            this.f5948d = new C1763f(aVar);
        }
        if (this.f5948d == null) {
            Log.d("PdfBox-Android", "Can't find MediaBox, will use U.S. Letter");
            this.f5948d = C1763f.f5733a;
        }
        return this.f5948d;
    }

    /* renamed from: g */
    public C1763f mo8248g() {
        C1604a aVar = (C1604a) C1928g.m7938a(this.f5945a, C1613i.f4940aV);
        return aVar != null ? m7558a(new C1763f(aVar)) : mo8247f();
    }

    /* renamed from: h */
    public List<C1877a> mo8249h() {
        C1604a aVar = (C1604a) this.f5945a.mo7539c(C1613i.f5354p);
        if (aVar == null) {
            C1604a aVar2 = new C1604a();
            this.f5945a.mo7521a(C1613i.f5354p, (C1605b) aVar2);
            return new C1689a(new ArrayList(), aVar2);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.mo7494b(); i++) {
            C1605b a = aVar.mo7485a(i);
            if (a != null) {
                arrayList.add(C1877a.m7774a(a));
            }
        }
        return new C1689a(arrayList, aVar);
    }

    public int hashCode() {
        return this.f5945a.hashCode();
    }
}
