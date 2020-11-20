package com.github.gcacace.signaturepad.p147a;

/* renamed from: com.github.gcacace.signaturepad.a.d */
public class C2207d {

    /* renamed from: a */
    public static final Character f6849a = 'c';

    /* renamed from: b */
    public static final Character f6850b = 'M';

    /* renamed from: c */
    private final StringBuilder f6851c = new StringBuilder();

    /* renamed from: d */
    private final Integer f6852d;

    /* renamed from: e */
    private final C2208e f6853e;

    /* renamed from: f */
    private C2208e f6854f;

    public C2207d(C2208e eVar, Integer num) {
        this.f6852d = num;
        this.f6853e = eVar;
        this.f6854f = eVar;
        this.f6851c.append(f6849a);
    }

    /* renamed from: b */
    private String m8643b(C2208e eVar, C2208e eVar2, C2208e eVar3) {
        String str = eVar.mo9187a(this.f6854f) + " " + eVar2.mo9187a(this.f6854f) + " " + eVar3.mo9187a(this.f6854f) + " ";
        return "c0 0 0 0 0 0".equals(str) ? "" : str;
    }

    /* renamed from: a */
    public C2207d mo9182a(C2208e eVar, C2208e eVar2, C2208e eVar3) {
        this.f6851c.append(m8643b(eVar, eVar2, eVar3));
        this.f6854f = eVar3;
        return this;
    }

    /* renamed from: a */
    public final Integer mo9183a() {
        return this.f6852d;
    }

    /* renamed from: b */
    public final C2208e mo9184b() {
        return this.f6854f;
    }

    public String toString() {
        return "<path " + "stroke-width=\"" + this.f6852d + "\" " + "d=\"" + f6850b + this.f6853e + this.f6851c + "\"/>";
    }
}
