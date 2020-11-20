package com.cyberneid.p105d.p108b;

import com.cyberneid.p105d.p109c.C1647i;
import com.cyberneid.p105d.p109c.C1648j;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p111d.C1656c;
import com.cyberneid.p105d.p111d.C1657d;
import com.cyberneid.p105d.p111d.C1660f;
import com.cyberneid.p105d.p111d.C1661g;
import com.cyberneid.p105d.p111d.C1664j;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.d.b.o */
public class C1619o extends C1607d implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1656c f5380b;

    /* renamed from: c */
    private final C1664j f5381c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f5382d;

    public C1619o() {
        this.f5380b = new C1657d();
        this.f5381c = null;
    }

    public C1619o(C1664j jVar) {
        this.f5380b = m6484a(jVar);
        this.f5381c = jVar;
    }

    /* renamed from: a */
    private C1656c m6484a(C1664j jVar) {
        if (jVar == null) {
            return new C1657d();
        }
        try {
            return jVar.mo7741d();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: t */
    private void m6486t() {
        if (this.f5380b.mo7715d()) {
            throw new IOException("COSStream has been closed and cannot be read. Perhaps its enclosing PDDocument has been closed?");
        }
    }

    /* renamed from: u */
    private List<C1647i> m6487u() {
        ArrayList arrayList = new ArrayList();
        C1605b q = mo7632q();
        if (q instanceof C1613i) {
            arrayList.add(C1648j.f5455a.mo7694a((C1613i) q));
        } else if (q instanceof C1604a) {
            C1604a aVar = (C1604a) q;
            for (int i = 0; i < aVar.mo7494b(); i++) {
                arrayList.add(C1648j.f5455a.mo7694a((C1613i) aVar.mo7495b(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public OutputStream mo7623a(C1605b bVar) {
        m6486t();
        if (!this.f5382d) {
            if (bVar != null) {
                mo7521a(C1613i.f5074cx, bVar);
            }
            this.f5380b = m6484a(this.f5381c);
            C1618n nVar = new C1618n(m6487u(), this, new C1661g(this.f5380b), this.f5381c);
            this.f5382d = true;
            return new FilterOutputStream(nVar) {
                public void close() {
                    super.close();
                    C1619o.this.mo7518a(C1613i.f5095dR, (int) C1619o.this.f5380b.mo7711c());
                    boolean unused = C1619o.this.f5382d = false;
                }

                public void write(byte[] bArr, int i, int i2) {
                    this.out.write(bArr, i, i2);
                }
            };
        }
        throw new IllegalStateException("Cannot have more than one open stream writer.");
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7655a(this);
    }

    public void close() {
        this.f5380b.close();
    }

    @Deprecated
    /* renamed from: j */
    public InputStream mo7625j() {
        return mo7626k();
    }

    /* renamed from: k */
    public InputStream mo7626k() {
        m6486t();
        if (!this.f5382d) {
            return new C1660f(this.f5380b);
        }
        throw new IllegalStateException("Cannot read while there is an open stream writer");
    }

    @Deprecated
    /* renamed from: l */
    public InputStream mo7627l() {
        return mo7628m();
    }

    /* renamed from: m */
    public C1610g mo7628m() {
        m6486t();
        if (!this.f5382d) {
            return C1610g.m6454a(m6487u(), this, new C1660f(this.f5380b), this.f5381c);
        }
        throw new IllegalStateException("Cannot read while there is an open stream writer");
    }

    @Deprecated
    /* renamed from: n */
    public OutputStream mo7629n() {
        return mo7630o();
    }

    /* renamed from: o */
    public OutputStream mo7630o() {
        return mo7623a((C1605b) null);
    }

    /* renamed from: p */
    public OutputStream mo7631p() {
        m6486t();
        if (!this.f5382d) {
            this.f5380b = m6484a(this.f5381c);
            C1661g gVar = new C1661g(this.f5380b);
            this.f5382d = true;
            return new FilterOutputStream(gVar) {
                public void close() {
                    super.close();
                    C1619o.this.mo7518a(C1613i.f5095dR, (int) C1619o.this.f5380b.mo7711c());
                    boolean unused = C1619o.this.f5382d = false;
                }

                public void write(byte[] bArr, int i, int i2) {
                    this.out.write(bArr, i, i2);
                }
            };
        }
        throw new IllegalStateException("Cannot have more than one open stream writer.");
    }

    /* renamed from: q */
    public C1605b mo7632q() {
        return mo7539c(C1613i.f5074cx);
    }

    @Deprecated
    /* renamed from: r */
    public String mo7633r() {
        return mo7634s();
    }

    /* renamed from: s */
    public String mo7634s() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1610g gVar = null;
        try {
            gVar = mo7628m();
            C1654a.m6618a(gVar, byteArrayOutputStream);
            C1654a.m6619a((Closeable) gVar);
            return new C1622p(byteArrayOutputStream.toByteArray()).mo7641b();
        } catch (IOException unused) {
            C1654a.m6619a((Closeable) gVar);
            return "";
        }
    }
}
