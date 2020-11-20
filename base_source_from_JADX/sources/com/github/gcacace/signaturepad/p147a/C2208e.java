package com.github.gcacace.signaturepad.p147a;

/* renamed from: com.github.gcacace.signaturepad.a.e */
class C2208e {

    /* renamed from: a */
    final Integer f6855a;

    /* renamed from: b */
    final Integer f6856b;

    public C2208e(int i, int i2) {
        this.f6855a = Integer.valueOf(i);
        this.f6856b = Integer.valueOf(i2);
    }

    public C2208e(C2209f fVar) {
        this.f6855a = Integer.valueOf(Math.round(fVar.f6857a));
        this.f6856b = Integer.valueOf(Math.round(fVar.f6858b));
    }

    /* renamed from: a */
    public String mo9186a() {
        return this.f6855a + "," + this.f6856b;
    }

    /* renamed from: a */
    public String mo9187a(C2208e eVar) {
        return new C2208e(this.f6855a.intValue() - eVar.f6855a.intValue(), this.f6856b.intValue() - eVar.f6856b.intValue()).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2208e eVar = (C2208e) obj;
        if (!this.f6855a.equals(eVar.f6855a)) {
            return false;
        }
        return this.f6856b.equals(eVar.f6856b);
    }

    public int hashCode() {
        return (this.f6855a.hashCode() * 31) + this.f6856b.hashCode();
    }

    public String toString() {
        return mo9186a();
    }
}
