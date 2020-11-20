package com.github.gcacace.signaturepad.p147a;

/* renamed from: com.github.gcacace.signaturepad.a.a */
public class C2204a {

    /* renamed from: a */
    public C2209f f6841a;

    /* renamed from: b */
    public C2209f f6842b;

    /* renamed from: c */
    public C2209f f6843c;

    /* renamed from: d */
    public C2209f f6844d;

    /* renamed from: a */
    public double mo9175a(float f, float f2, float f3, float f4, float f5) {
        double d = (double) f;
        double d2 = 1.0d - d;
        return (((double) f2) * d2 * d2 * d2) + (((double) f3) * 3.0d * d2 * d2 * d) + (((double) f4) * 3.0d * d2 * d * d) + ((double) (f5 * f * f * f));
    }

    /* renamed from: a */
    public float mo9176a() {
        double d = 0.0d;
        double d2 = 0.0d;
        int i = 0;
        float f = 0.0f;
        while (i <= 10) {
            float f2 = ((float) i) / ((float) 10);
            double a = mo9175a(f2, this.f6841a.f6857a, this.f6842b.f6857a, this.f6843c.f6857a, this.f6844d.f6857a);
            double a2 = mo9175a(f2, this.f6841a.f6858b, this.f6842b.f6858b, this.f6843c.f6858b, this.f6844d.f6858b);
            if (i > 0) {
                double d3 = a - d;
                double d4 = a2 - d2;
                f = (float) (((double) f) + Math.sqrt((d3 * d3) + (d4 * d4)));
            }
            i++;
            d2 = a2;
            d = a;
        }
        return f;
    }

    /* renamed from: a */
    public C2204a mo9177a(C2209f fVar, C2209f fVar2, C2209f fVar3, C2209f fVar4) {
        this.f6841a = fVar;
        this.f6842b = fVar2;
        this.f6843c = fVar3;
        this.f6844d = fVar4;
        return this;
    }
}
