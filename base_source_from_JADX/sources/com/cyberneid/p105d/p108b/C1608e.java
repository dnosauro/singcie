package com.cyberneid.p105d.p108b;

import android.util.Log;
import com.cyberneid.p105d.p111d.C1664j;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.d.b.e */
public class C1608e extends C1605b implements Closeable {

    /* renamed from: a */
    private float f4871a;

    /* renamed from: b */
    private final Map<C1617m, C1616l> f4872b;

    /* renamed from: c */
    private final Map<C1617m, Long> f4873c;

    /* renamed from: d */
    private C1607d f4874d;

    /* renamed from: e */
    private boolean f4875e;

    /* renamed from: f */
    private boolean f4876f;

    /* renamed from: g */
    private long f4877g;

    /* renamed from: h */
    private boolean f4878h;

    /* renamed from: i */
    private boolean f4879i;

    /* renamed from: j */
    private C1664j f4880j;

    /* renamed from: k */
    private long f4881k;

    public C1608e() {
        this(false);
    }

    public C1608e(C1664j jVar) {
        this.f4871a = 1.4f;
        this.f4872b = new HashMap();
        this.f4873c = new HashMap();
        this.f4875e = true;
        this.f4876f = false;
        this.f4878h = false;
        this.f4880j = jVar;
    }

    public C1608e(File file, boolean z) {
        this.f4871a = 1.4f;
        this.f4872b = new HashMap();
        this.f4873c = new HashMap();
        this.f4875e = true;
        this.f4876f = false;
        this.f4878h = false;
        if (z) {
            try {
                this.f4880j = new C1664j(file);
            } catch (IOException e) {
                Log.e("PdfBox-Android", "Can't create temp file, using memory buffer instead", e);
            }
        }
    }

    public C1608e(boolean z) {
        this((File) null, z);
    }

    /* renamed from: a */
    public C1616l mo7557a(C1613i iVar) {
        for (C1616l next : this.f4872b.values()) {
            C1605b a = next.mo7604a();
            if (a instanceof C1607d) {
                try {
                    C1605b k = ((C1607d) a).mo7554k(C1613i.f5338hw);
                    if (k instanceof C1613i) {
                        if (((C1613i) k).equals(iVar)) {
                            return next;
                        }
                    } else if (k != null) {
                        Log.d("PdfBox-Android", "Expected a /Name object after /Type, got '" + k + "' instead");
                    }
                } catch (ClassCastException e) {
                    Log.w("PdfBox-Android", e.getMessage(), e);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1616l mo7558a(C1617m mVar) {
        C1616l lVar = mVar != null ? this.f4872b.get(mVar) : null;
        if (lVar == null) {
            lVar = new C1616l((C1605b) null);
            if (mVar != null) {
                lVar.mo7606a(mVar.mo7613b());
                lVar.mo7605a(mVar.mo7611a());
                this.f4872b.put(mVar, lVar);
            }
        }
        return lVar;
    }

    /* renamed from: a */
    public C1619o mo7559a() {
        return new C1619o(this.f4880j);
    }

    /* renamed from: a */
    public C1619o mo7560a(C1607d dVar) {
        C1619o oVar = new C1619o(this.f4880j);
        for (Map.Entry next : dVar.mo7546f()) {
            oVar.mo7521a((C1613i) next.getKey(), (C1605b) next.getValue());
        }
        return oVar;
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7650a(this);
    }

    /* renamed from: a */
    public void mo7561a(float f) {
        this.f4871a = f;
    }

    /* renamed from: a */
    public void mo7562a(long j) {
        this.f4877g = j;
    }

    /* renamed from: a */
    public void mo7563a(C1604a aVar) {
        mo7577k().mo7521a(C1613i.f5114dk, (C1605b) aVar);
    }

    /* renamed from: a */
    public void mo7564a(Map<C1617m, Long> map) {
        this.f4873c.putAll(map);
    }

    /* renamed from: b */
    public float mo7565b() {
        return this.f4871a;
    }

    /* renamed from: b */
    public void mo7566b(C1607d dVar) {
        this.f4874d.mo7521a(C1613i.f5058ch, (C1605b) dVar);
    }

    /* renamed from: b */
    public void mo7567b(boolean z) {
        this.f4879i = z;
    }

    /* renamed from: c */
    public void mo7568c() {
        this.f4876f = true;
    }

    /* renamed from: c */
    public void mo7569c(C1607d dVar) {
        this.f4874d = dVar;
    }

    public void close() {
        if (!this.f4878h) {
            List<C1616l> j = mo7576j();
            if (j != null) {
                for (C1616l a : j) {
                    C1605b a2 = a.mo7604a();
                    if (a2 instanceof C1619o) {
                        ((C1619o) a2).close();
                    }
                }
            }
            C1664j jVar = this.f4880j;
            if (jVar != null) {
                jVar.close();
            }
            this.f4878h = true;
        }
    }

    /* renamed from: f */
    public boolean mo7571f() {
        C1607d dVar = this.f4874d;
        return (dVar == null || dVar.mo7539c(C1613i.f5058ch) == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (!this.f4878h) {
            if (this.f4875e) {
                Log.w("PdfBox-Android", "Warning: You did not close a PDF Document");
            }
            close();
        }
    }

    /* renamed from: g */
    public C1607d mo7573g() {
        return (C1607d) this.f4874d.mo7539c(C1613i.f5058ch);
    }

    /* renamed from: h */
    public C1604a mo7574h() {
        return (C1604a) mo7577k().mo7539c(C1613i.f5114dk);
    }

    /* renamed from: i */
    public C1616l mo7575i() {
        C1616l a = mo7557a(C1613i.f4956al);
        if (a != null) {
            return a;
        }
        throw new IOException("Catalog cannot be found");
    }

    /* renamed from: j */
    public List<C1616l> mo7576j() {
        return new ArrayList(this.f4872b.values());
    }

    /* renamed from: k */
    public C1607d mo7577k() {
        return this.f4874d;
    }

    /* renamed from: l */
    public long mo7578l() {
        return this.f4881k;
    }

    /* renamed from: m */
    public boolean mo7579m() {
        return this.f4878h;
    }

    /* renamed from: n */
    public Map<C1617m, Long> mo7580n() {
        return this.f4873c;
    }

    /* renamed from: o */
    public long mo7581o() {
        return this.f4877g;
    }

    /* renamed from: p */
    public boolean mo7582p() {
        return this.f4879i;
    }
}
