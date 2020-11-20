package com.github.gcacace.signaturepad.p147a;

/* renamed from: com.github.gcacace.signaturepad.a.c */
public class C2206c {

    /* renamed from: a */
    private final StringBuilder f6847a = new StringBuilder();

    /* renamed from: b */
    private C2207d f6848b = null;

    /* renamed from: a */
    private void m8637a(Integer num, C2208e eVar) {
        this.f6848b = new C2207d(eVar, num);
    }

    /* renamed from: b */
    private void m8638b() {
        this.f6847a.append(this.f6848b);
    }

    /* renamed from: c */
    private boolean m8639c() {
        return this.f6848b != null;
    }

    /* renamed from: a */
    public C2206c mo9179a(C2204a aVar, float f) {
        Integer valueOf = Integer.valueOf(Math.round(f));
        C2208e eVar = new C2208e(aVar.f6841a);
        C2208e eVar2 = new C2208e(aVar.f6842b);
        C2208e eVar3 = new C2208e(aVar.f6843c);
        C2208e eVar4 = new C2208e(aVar.f6844d);
        if (!m8639c()) {
            m8637a(valueOf, eVar);
        }
        if (!eVar.equals(this.f6848b.mo9184b()) || !valueOf.equals(this.f6848b.mo9183a())) {
            m8638b();
            m8637a(valueOf, eVar);
        }
        this.f6848b.mo9182a(eVar2, eVar3, eVar4);
        return this;
    }

    /* renamed from: a */
    public String mo9180a(int i, int i2) {
        if (m8639c()) {
            m8638b();
        }
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" + "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.2\" baseProfile=\"tiny\" " + "height=\"" + i2 + "\" " + "width=\"" + i + "\" " + "viewBox=\"" + 0 + " " + 0 + " " + i + " " + i2 + "\">" + "<g " + "stroke-linejoin=\"round\" " + "stroke-linecap=\"round\" " + "fill=\"none\" " + "stroke=\"black\"" + ">" + this.f6847a + "</g>" + "</svg>";
    }

    /* renamed from: a */
    public void mo9181a() {
        this.f6847a.setLength(0);
        this.f6848b = null;
    }
}
