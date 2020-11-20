package com.cyberneid.p105d.p114g;

import android.util.Log;
import com.cyberneid.p099c.p100a.p101a.C1592a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p113f.C1685b;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import com.cyberneid.p105d.p114g.p120d.C1820p;
import com.cyberneid.p105d.p114g.p122e.p123a.C1837e;
import com.cyberneid.p105d.p114g.p122e.p123a.C1838f;
import com.cyberneid.p105d.p114g.p122e.p123a.C1841i;
import com.cyberneid.p105d.p114g.p122e.p123a.C1845m;
import com.cyberneid.p105d.p114g.p122e.p125c.C1861e;
import com.cyberneid.p105d.p114g.p126f.p128b.C1892p;
import com.cyberneid.p105d.p131h.C1933a;
import com.cyberneid.p105d.p131h.C1940d;
import java.io.Closeable;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Stack;

/* renamed from: com.cyberneid.d.g.f */
public final class C1867f implements Closeable {

    /* renamed from: a */
    private final C1783c f6026a;

    /* renamed from: b */
    private OutputStream f6027b;

    /* renamed from: c */
    private C1931h f6028c;

    /* renamed from: d */
    private boolean f6029d;

    /* renamed from: e */
    private final Stack<C1820p> f6030e;

    /* renamed from: f */
    private final Stack<C1838f> f6031f;

    /* renamed from: g */
    private Stack<C1838f> f6032g;

    /* renamed from: h */
    private final NumberFormat f6033h;

    public C1867f(C1783c cVar, C1831e eVar) {
        this(cVar, eVar, false, true);
    }

    public C1867f(C1783c cVar, C1831e eVar, boolean z, boolean z2) {
        this(cVar, eVar, z, z2, false);
    }

    public C1867f(C1783c cVar, C1831e eVar, boolean z, boolean z2, boolean z3) {
        C1604a aVar;
        this.f6029d = false;
        this.f6030e = new Stack<>();
        this.f6031f = new Stack<>();
        this.f6032g = new Stack<>();
        this.f6033h = NumberFormat.getNumberInstance(Locale.US);
        this.f6026a = cVar;
        C1613i iVar = z2 ? C1613i.f5028cD : null;
        if (!z || !eVar.mo8244c()) {
            if (eVar.mo8244c()) {
                Log.w("PdfBox-Android", "You are overwriting an existing content, you should use the append mode");
            }
            C1764g gVar = new C1764g(cVar);
            eVar.mo8241a(gVar);
            this.f6027b = gVar.mo7956a(iVar);
        } else {
            C1764g gVar2 = new C1764g(cVar);
            C1605b c = eVar.mo7505d().mo7539c(C1613i.f4934aP);
            if (c instanceof C1604a) {
                aVar = (C1604a) c;
                aVar.mo7491a((C1760c) gVar2);
            } else {
                C1604a aVar2 = new C1604a();
                aVar2.mo7490a(c);
                aVar2.mo7491a((C1760c) gVar2);
                aVar = aVar2;
            }
            if (z3) {
                C1764g gVar3 = new C1764g(cVar);
                this.f6027b = gVar3.mo7956a(iVar);
                mo8327c();
                close();
                aVar.mo7488a(0, (C1605b) gVar3.mo7959e());
            }
            eVar.mo7505d().mo7521a(C1613i.f4934aP, (C1605b) aVar);
            this.f6027b = gVar2.mo7956a(iVar);
            if (z3) {
                mo8329d();
            }
        }
        this.f6028c = eVar.mo8245e();
        if (this.f6028c == null) {
            this.f6028c = new C1931h();
            eVar.mo8242a(this.f6028c);
        }
        this.f6033h.setMaximumFractionDigits(10);
        this.f6033h.setGroupingUsed(false);
    }

    public C1867f(C1783c cVar, C1892p pVar) {
        this.f6029d = false;
        this.f6030e = new Stack<>();
        this.f6031f = new Stack<>();
        this.f6032g = new Stack<>();
        this.f6033h = NumberFormat.getNumberInstance(Locale.US);
        this.f6026a = cVar;
        this.f6027b = pVar.mo8252c().mo7957b();
        this.f6028c = pVar.mo8297f();
        this.f6033h.setMaximumFractionDigits(4);
        this.f6033h.setGroupingUsed(false);
    }

    public C1867f(C1783c cVar, C1892p pVar, OutputStream outputStream) {
        this.f6029d = false;
        this.f6030e = new Stack<>();
        this.f6031f = new Stack<>();
        this.f6032g = new Stack<>();
        this.f6033h = NumberFormat.getNumberInstance(Locale.US);
        this.f6026a = cVar;
        this.f6027b = outputStream;
        this.f6028c = pVar.mo8297f();
        this.f6033h.setMaximumFractionDigits(4);
        this.f6033h.setGroupingUsed(false);
    }

    /* renamed from: a */
    private C1613i m7738a(C1838f fVar) {
        return ((fVar instanceof C1841i) || (fVar instanceof C1845m)) ? C1613i.m6461a(fVar.mo8258b()) : this.f6028c.mo8466a(fVar);
    }

    /* renamed from: a */
    private void m7739a(C1592a aVar) {
        double[] dArr = new double[6];
        aVar.mo7407a(dArr);
        for (double d : dArr) {
            m7741b((float) d);
        }
    }

    /* renamed from: a */
    private void m7740a(C1613i iVar) {
        iVar.mo7597a(this.f6027b);
        this.f6027b.write(32);
    }

    /* renamed from: b */
    private void m7741b(float f) {
        m7742b(this.f6033h.format((double) f));
        this.f6027b.write(32);
    }

    /* renamed from: b */
    private void m7742b(String str) {
        this.f6027b.write(str.getBytes(C1933a.f6108a));
        this.f6027b.write(10);
    }

    /* renamed from: b */
    private boolean m7743b(int i) {
        return i < 0 || i > 255;
    }

    /* renamed from: c */
    private void m7744c(String str) {
        this.f6027b.write(str.getBytes(C1933a.f6108a));
    }

    /* renamed from: c */
    private boolean m7745c(double d) {
        return d < 0.0d || d > 1.0d;
    }

    /* renamed from: a */
    public void mo8312a() {
        if (!this.f6029d) {
            m7742b("BT");
            this.f6029d = true;
            return;
        }
        throw new IllegalStateException("Error: Nested beginText() calls are not allowed.");
    }

    /* renamed from: a */
    public void mo8313a(double d) {
        m7741b((float) d);
        m7742b("TL");
    }

    /* renamed from: a */
    public void mo8314a(float f) {
        if (!this.f6029d) {
            m7741b(f);
            m7742b("w");
            return;
        }
        throw new IllegalStateException("Error: setLineWidth is not allowed within a text block.");
    }

    /* renamed from: a */
    public void mo8315a(float f, float f2) {
        if (this.f6029d) {
            m7741b(f);
            m7741b(f2);
            m7742b("Td");
            return;
        }
        throw new IllegalStateException("Error: must call beginText() before newLineAtOffset()");
    }

    /* renamed from: a */
    public void mo8316a(float f, float f2, float f3, float f4) {
        if (!this.f6029d) {
            m7741b(f);
            m7741b(f2);
            m7741b(f3);
            m7741b(f4);
            m7742b("re");
            return;
        }
        throw new IllegalStateException("Error: addRect is not allowed within a text block.");
    }

    /* renamed from: a */
    public void mo8317a(int i) {
        if (!m7743b(i)) {
            mo8326b((double) (((float) i) / 255.0f));
            return;
        }
        throw new IllegalArgumentException("Parameter must be within 0..255, but is " + i);
    }

    /* renamed from: a */
    public void mo8318a(int i, int i2, int i3) {
        if (m7743b(i) || m7743b(i2) || m7743b(i3)) {
            throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
        m7741b(((float) i) / 255.0f);
        m7741b(((float) i2) / 255.0f);
        m7741b(((float) i3) / 255.0f);
        m7742b("rg");
    }

    /* renamed from: a */
    public void mo8319a(C1820p pVar, float f) {
        if (this.f6030e.isEmpty()) {
            this.f6030e.add(pVar);
        } else {
            Stack<C1820p> stack = this.f6030e;
            stack.setElementAt(pVar, stack.size() - 1);
        }
        if (pVar.mo8172l() && !this.f6026a.mo8069g().contains(pVar)) {
            this.f6026a.mo8069g().add(pVar);
        }
        m7740a(this.f6028c.mo8465a(pVar));
        m7741b(f);
        m7742b("Tf");
    }

    /* renamed from: a */
    public void mo8320a(C1837e eVar) {
        if (this.f6031f.isEmpty() || this.f6031f.peek() != eVar.mo8265b()) {
            m7740a(m7738a(eVar.mo8265b()));
            m7742b("cs");
            if (this.f6031f.isEmpty()) {
                this.f6031f.add(eVar.mo8265b());
            } else {
                this.f6031f.setElementAt(eVar.mo8265b(), this.f6031f.size() - 1);
            }
        }
        for (float b : eVar.mo8264a()) {
            m7741b(b);
        }
        m7742b("sc");
    }

    /* renamed from: a */
    public void mo8321a(C1861e eVar, float f, float f2) {
        mo8322a(eVar, f, f2, (float) eVar.mo8306f(), (float) eVar.mo8305e());
    }

    /* renamed from: a */
    public void mo8322a(C1861e eVar, float f, float f2, float f3, float f4) {
        if (!this.f6029d) {
            mo8327c();
            mo8323a(new C1940d(new C1592a(f3, 0.0f, 0.0f, f4, f, f2)));
            m7740a(this.f6028c.mo8467a(eVar));
            m7742b("Do");
            mo8329d();
            return;
        }
        throw new IllegalStateException("Error: drawImage is not allowed within a text block.");
    }

    /* renamed from: a */
    public void mo8323a(C1940d dVar) {
        m7739a(dVar.mo8478a());
        m7742b("cm");
    }

    /* renamed from: a */
    public void mo8324a(String str) {
        if (!this.f6029d) {
            throw new IllegalStateException("Must call beginText() before showText()");
        } else if (!this.f6030e.isEmpty()) {
            C1820p peek = this.f6030e.peek();
            if (peek.mo8172l()) {
                int i = 0;
                while (i < str.length()) {
                    int codePointAt = str.codePointAt(i);
                    peek.mo8167f(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
            C1685b.m6850a(peek.mo8160a(str), this.f6027b);
            m7744c(" ");
            m7742b("Tj");
        } else {
            throw new IllegalStateException("Must call setFont() before showText()");
        }
    }

    /* renamed from: b */
    public void mo8325b() {
        if (this.f6029d) {
            m7742b("ET");
            this.f6029d = false;
            return;
        }
        throw new IllegalStateException("Error: You must call beginText() before calling endText.");
    }

    /* renamed from: b */
    public void mo8326b(double d) {
        if (!m7745c(d)) {
            m7741b((float) d);
            m7742b("g");
            return;
        }
        throw new IllegalArgumentException("Parameter must be within 0..1, but is " + d);
    }

    /* renamed from: c */
    public void mo8327c() {
        if (!this.f6030e.isEmpty()) {
            Stack<C1820p> stack = this.f6030e;
            stack.push(stack.peek());
        }
        if (!this.f6032g.isEmpty()) {
            Stack<C1838f> stack2 = this.f6032g;
            stack2.push(stack2.peek());
        }
        if (!this.f6031f.isEmpty()) {
            Stack<C1838f> stack3 = this.f6031f;
            stack3.push(stack3.peek());
        }
        m7742b("q");
    }

    public void close() {
        this.f6027b.close();
    }

    /* renamed from: d */
    public void mo8329d() {
        if (!this.f6030e.isEmpty()) {
            this.f6030e.pop();
        }
        if (!this.f6032g.isEmpty()) {
            this.f6032g.pop();
        }
        if (!this.f6031f.isEmpty()) {
            this.f6031f.pop();
        }
        m7742b("Q");
    }

    /* renamed from: e */
    public void mo8330e() {
        if (!this.f6029d) {
            m7742b("s");
            return;
        }
        throw new IllegalStateException("Error: closeAndStroke is not allowed within a text block.");
    }

    /* renamed from: f */
    public void mo8331f() {
        if (!this.f6029d) {
            m7742b("f");
            return;
        }
        throw new IllegalStateException("Error: fill is not allowed within a text block.");
    }

    /* renamed from: g */
    public void mo8332g() {
        if (!this.f6029d) {
            m7742b("W");
            m7742b("n");
            return;
        }
        throw new IllegalStateException("Error: clip is not allowed within a text block.");
    }
}
