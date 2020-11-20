package com.cyberneid.p105d.p114g.p120d;

import android.util.Log;
import com.cyberneid.p089b.p090a.C1475e;
import com.cyberneid.p089b.p092c.C1532b;
import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p114g.p115a.C1689a;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p120d.p121a.C1790d;
import com.cyberneid.p105d.p131h.C1940d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cyberneid.d.g.d.p */
public abstract class C1820p implements C1760c {

    /* renamed from: a */
    protected static final C1940d f5883a = new C1940d(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);

    /* renamed from: b */
    protected final C1607d f5884b;

    /* renamed from: c */
    private final C1532b f5885c;

    /* renamed from: d */
    private final C1475e f5886d;

    /* renamed from: e */
    private C1821q f5887e;

    /* renamed from: f */
    private List<Integer> f5888f;

    /* renamed from: g */
    private float f5889g;

    C1820p() {
        this.f5889g = -1.0f;
        this.f5884b = new C1607d();
        this.f5884b.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5030cF);
        this.f5885c = null;
        this.f5887e = null;
        this.f5886d = null;
    }

    protected C1820p(C1607d dVar) {
        this.f5889g = -1.0f;
        this.f5884b = dVar;
        this.f5886d = C1798ac.m7277a(mo8099f());
        C1607d dVar2 = (C1607d) this.f5884b.mo7539c(C1613i.f5032cH);
        if (dVar2 != null) {
            this.f5887e = new C1821q(dVar2);
        } else {
            C1475e eVar = this.f5886d;
            if (eVar != null) {
                this.f5887e = C1796aa.m7264a(eVar);
            } else {
                this.f5887e = null;
            }
        }
        C1605b c = this.f5884b.mo7539c(C1613i.f5327hl);
        if (c != null) {
            this.f5885c = mo8158a(c);
            C1532b bVar = this.f5885c;
            if (bVar != null && !bVar.mo7152b()) {
                Log.w("PdfBox-Android", "Invalid ToUnicode CMap in font " + mo8099f());
                return;
            }
            return;
        }
        this.f5885c = null;
    }

    C1820p(String str) {
        this.f5889g = -1.0f;
        this.f5884b = new C1607d();
        this.f5885c = null;
        this.f5886d = C1798ac.m7277a(str);
        C1475e eVar = this.f5886d;
        if (eVar != null) {
            this.f5887e = C1796aa.m7264a(eVar);
            return;
        }
        throw new IllegalArgumentException("No AFM for font " + str);
    }

    /* renamed from: a */
    public float mo8094a(int i) {
        if (this.f5884b.mo7555l(C1613i.f5309hT) || this.f5884b.mo7555l(C1613i.f5174er)) {
            int b = this.f5884b.mo7529b(C1613i.f5076cz, -1);
            int b2 = this.f5884b.mo7529b(C1613i.f5089dL, -1);
            if (mo8168h().size() > 0 && i >= b && i <= b2) {
                return mo8168h().get(i - b).floatValue();
            }
            C1821q b3 = mo8163b();
            if (b3 != null) {
                return b3.mo8207n();
            }
        }
        return mo8170j() ? mo8161b(i) : mo8096c(i);
    }

    /* renamed from: a */
    public abstract int mo8095a(InputStream inputStream);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C1475e mo8157a() {
        return this.f5886d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C1532b mo8158a(C1605b bVar) {
        if (bVar instanceof C1613i) {
            return C1802c.m7302a(((C1613i) bVar).mo7596a());
        }
        if (bVar instanceof C1619o) {
            InputStream inputStream = null;
            try {
                inputStream = ((C1619o) bVar).mo7627l();
                return C1802c.m7301a(inputStream);
            } finally {
                C1654a.m6619a(inputStream);
            }
        } else {
            throw new IOException("Expected Name or Stream");
        }
    }

    /* renamed from: a */
    public String mo8159a(int i, C1790d dVar) {
        return mo8165e(i);
    }

    /* renamed from: a */
    public final byte[] mo8160a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            byteArrayOutputStream.write(mo8097d(codePointAt));
            i += Character.charCount(codePointAt);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract float mo8161b(int i);

    /* renamed from: b */
    public float mo8162b(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mo8160a(str));
        float f = 0.0f;
        while (byteArrayInputStream.available() > 0) {
            f += mo8094a(mo8095a((InputStream) byteArrayInputStream));
        }
        return f;
    }

    /* renamed from: b */
    public C1821q mo8163b() {
        return this.f5887e;
    }

    /* renamed from: c */
    public abstract float mo8096c(int i);

    /* renamed from: c */
    public C1607d mo7505d() {
        return this.f5884b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract byte[] mo8097d(int i);

    /* renamed from: e */
    public String mo8165e(int i) {
        C1532b bVar = this.f5885c;
        if (bVar == null) {
            return null;
        }
        if (bVar.mo7153c() == null || !this.f5885c.mo7153c().startsWith("Identity-")) {
            return this.f5885c.mo7142a(i);
        }
        return new String(new char[]{(char) i});
    }

    /* renamed from: e */
    public abstract boolean mo8098e();

    public boolean equals(Object obj) {
        return (obj instanceof C1820p) && ((C1820p) obj).mo7505d() == mo7505d();
    }

    /* renamed from: f */
    public abstract String mo8099f();

    /* renamed from: f */
    public abstract void mo8167f(int i);

    /* renamed from: g */
    public abstract C1586a mo8100g();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final List<Integer> mo8168h() {
        if (this.f5888f == null) {
            C1604a aVar = (C1604a) this.f5884b.mo7539c(C1613i.f5309hT);
            this.f5888f = aVar != null ? C1689a.m6904a(aVar) : Collections.emptyList();
        }
        return this.f5888f;
    }

    public int hashCode() {
        return mo7505d().hashCode();
    }

    /* renamed from: i */
    public C1940d mo8101i() {
        return f5883a;
    }

    /* renamed from: j */
    public boolean mo8170j() {
        if (mo8098e()) {
            return false;
        }
        return C1798ac.m7280b(mo8099f());
    }

    /* renamed from: k */
    public abstract void mo8171k();

    /* renamed from: l */
    public abstract boolean mo8172l();

    public String toString() {
        return getClass().getSimpleName() + " " + mo8099f();
    }
}
