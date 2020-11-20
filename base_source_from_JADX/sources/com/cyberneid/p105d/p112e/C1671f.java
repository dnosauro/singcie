package com.cyberneid.p105d.p112e;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1614j;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p111d.C1662h;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p118b.C1766a;
import com.cyberneid.p105d.p114g.p118b.C1767b;
import com.cyberneid.p105d.p114g.p118b.C1771f;
import com.cyberneid.p105d.p114g.p118b.C1773h;
import com.cyberneid.p105d.p114g.p118b.C1780o;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

/* renamed from: com.cyberneid.d.e.f */
public class C1671f extends C1667b {

    /* renamed from: l */
    private String f5541l;

    /* renamed from: m */
    private InputStream f5542m;

    /* renamed from: n */
    private String f5543n;

    /* renamed from: o */
    private C1766a f5544o;

    public C1671f(C1662h hVar) {
        this(hVar, "", false);
    }

    public C1671f(C1662h hVar, String str, InputStream inputStream, String str2, boolean z) {
        super(hVar);
        this.f5541l = "";
        this.f5542m = null;
        this.f5543n = null;
        this.f5520h = hVar.mo7711c();
        this.f5541l = str;
        this.f5542m = inputStream;
        this.f5543n = str2;
        m6789a(z);
    }

    public C1671f(C1662h hVar, String str, boolean z) {
        this(hVar, str, (InputStream) null, (String) null, z);
    }

    /* renamed from: C */
    private void m6787C() {
        C1767b bVar;
        C1605b k = this.f5511b.mo7577k().mo7554k(C1613i.f5058ch);
        if (k != null && !(k instanceof C1614j)) {
            if (k instanceof C1616l) {
                m6788a((C1616l) k);
            }
            try {
                C1771f fVar = new C1771f(this.f5511b.mo7573g());
                if (this.f5542m != null) {
                    KeyStore instance = KeyStore.getInstance("PKCS12");
                    instance.load(this.f5542m, this.f5541l.toCharArray());
                    bVar = new C1773h(instance, this.f5543n, this.f5541l);
                } else {
                    bVar = new C1780o(this.f5541l);
                }
                this.f5522j = fVar.mo7985a();
                this.f5522j.mo8023a(fVar, this.f5511b.mo7574h(), bVar);
                this.f5544o = this.f5522j.mo8039b();
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new IOException("Error (" + e2.getClass().getSimpleName() + ") while creating security handler for decryption", e2);
            }
        }
    }

    /* renamed from: a */
    private void m6788a(C1616l lVar) {
        mo7770a(lVar, true);
        for (C1605b next : ((C1607d) lVar.mo7604a()).mo7548g()) {
            if (next instanceof C1616l) {
                C1616l lVar2 = (C1616l) next;
                if (lVar2.mo7604a() == null) {
                    m6788a(lVar2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m6789a(boolean z) {
        String property = System.getProperty("com.cyberneid.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange");
        if (property != null) {
            try {
                mo7777g(Integer.parseInt(property));
            } catch (NumberFormatException unused) {
                Log.w("PdfBox-Android", "System property com.cyberneid.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange does not contain an integer value, but: '" + property + "'");
            }
        }
        this.f5511b = new C1608e(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public void mo7798A() {
        long r = mo7778r();
        C1607d a = r > -1 ? mo7771a(r) : mo7779s() ? mo7780t() : null;
        m6787C();
        mo7775b(a);
        C1616l i = this.f5511b.mo7575i();
        if (i != null && (i.mo7604a() instanceof C1607d)) {
            mo7773a((C1607d) i.mo7604a(), (C1613i[]) null);
            this.f5511b.mo7568c();
        }
        this.f5521i = true;
    }

    /* renamed from: B */
    public void mo7799B() {
        try {
            if (!mo7783w()) {
                if (!mo7784x()) {
                    throw new IOException("Error: Header doesn't contain versioninfo");
                }
            }
            if (!this.f5521i) {
                mo7798A();
            }
            C1654a.m6619a((Closeable) this.f5542m);
        } catch (Throwable th) {
            C1654a.m6619a((Closeable) this.f5542m);
            if (this.f5511b != null) {
                C1654a.m6619a((Closeable) this.f5511b);
                this.f5511b = null;
            }
            throw th;
        }
    }

    /* renamed from: z */
    public C1783c mo7800z() {
        return new C1783c(mo7785y(), this.f5519e, this.f5544o);
    }
}
