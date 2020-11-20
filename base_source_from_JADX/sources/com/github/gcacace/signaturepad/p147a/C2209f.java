package com.github.gcacace.signaturepad.p147a;

/* renamed from: com.github.gcacace.signaturepad.a.f */
public class C2209f {

    /* renamed from: a */
    public float f6857a;

    /* renamed from: b */
    public float f6858b;

    /* renamed from: c */
    public long f6859c;

    /* renamed from: a */
    public float mo9191a(C2209f fVar) {
        long j = this.f6859c - fVar.f6859c;
        if (j <= 0) {
            j = 1;
        }
        float b = mo9193b(fVar) / ((float) j);
        if (Float.isInfinite(b) || Float.isNaN(b)) {
            return 0.0f;
        }
        return b;
    }

    /* renamed from: a */
    public C2209f mo9192a(float f, float f2) {
        this.f6857a = f;
        this.f6858b = f2;
        this.f6859c = System.currentTimeMillis();
        return this;
    }

    /* renamed from: b */
    public float mo9193b(C2209f fVar) {
        return (float) Math.sqrt(Math.pow((double) (fVar.f6857a - this.f6857a), 2.0d) + Math.pow((double) (fVar.f6858b - this.f6858b), 2.0d));
    }
}
