package com.cyberneid.p099c.p100a.p101a;

import android.graphics.PointF;
import java.io.Serializable;

/* renamed from: com.cyberneid.c.a.a.a */
public class C1592a implements Serializable, Cloneable {

    /* renamed from: a */
    double f4833a;

    /* renamed from: b */
    double f4834b;

    /* renamed from: c */
    double f4835c;

    /* renamed from: d */
    double f4836d;

    /* renamed from: e */
    double f4837e;

    /* renamed from: f */
    double f4838f;

    /* renamed from: g */
    transient int f4839g;

    public C1592a() {
        this.f4839g = 0;
        this.f4836d = 1.0d;
        this.f4833a = 1.0d;
        this.f4838f = 0.0d;
        this.f4837e = 0.0d;
        this.f4835c = 0.0d;
        this.f4834b = 0.0d;
    }

    public C1592a(double d, double d2, double d3, double d4, double d5, double d6) {
        this.f4839g = -1;
        this.f4833a = d;
        this.f4834b = d2;
        this.f4835c = d3;
        this.f4836d = d4;
        this.f4837e = d5;
        this.f4838f = d6;
    }

    public C1592a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f4839g = -1;
        this.f4833a = (double) f;
        this.f4834b = (double) f2;
        this.f4835c = (double) f3;
        this.f4836d = (double) f4;
        this.f4837e = (double) f5;
        this.f4838f = (double) f6;
    }

    /* renamed from: c */
    public static C1592a m6286c(double d, double d2) {
        C1592a aVar = new C1592a();
        aVar.mo7404a(d, d2);
        return aVar;
    }

    /* renamed from: d */
    public static C1592a m6287d(double d, double d2) {
        C1592a aVar = new C1592a();
        aVar.mo7409b(d, d2);
        return aVar;
    }

    /* renamed from: a */
    public double mo7401a() {
        return this.f4833a;
    }

    /* renamed from: a */
    public PointF mo7402a(PointF pointF, PointF pointF2) {
        pointF2.set((float) ((((double) pointF.x) * this.f4833a) + (((double) pointF.y) * this.f4835c) + this.f4837e), (float) ((((double) pointF.x) * this.f4834b) + (((double) pointF.y) * this.f4836d) + this.f4838f));
        return pointF2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1592a mo7403a(C1592a aVar, C1592a aVar2) {
        C1592a aVar3 = aVar;
        C1592a aVar4 = aVar2;
        double d = aVar3.f4833a;
        double d2 = aVar4.f4833a;
        double d3 = aVar3.f4834b;
        double d4 = aVar4.f4835c;
        double d5 = aVar4.f4834b;
        double d6 = (d * d2) + (d3 * d4);
        double d7 = aVar4.f4836d;
        double d8 = (d3 * d7) + (d * d5);
        double d9 = aVar3.f4835c;
        double d10 = d8;
        double d11 = aVar3.f4836d;
        double d12 = (d9 * d2) + (d11 * d4);
        double d13 = (d11 * d7) + (d9 * d5);
        double d14 = aVar3.f4837e;
        double d15 = d13;
        double d16 = aVar3.f4838f;
        return new C1592a(d6, d10, d12, d15, aVar4.f4837e + (d2 * d14) + (d4 * d16), (d14 * d5) + (d16 * d7) + aVar4.f4838f);
    }

    /* renamed from: a */
    public void mo7404a(double d, double d2) {
        this.f4836d = 1.0d;
        this.f4833a = 1.0d;
        this.f4834b = 0.0d;
        this.f4835c = 0.0d;
        this.f4837e = d;
        this.f4838f = d2;
        this.f4839g = (d == 0.0d && d2 == 0.0d) ? 0 : 1;
    }

    /* renamed from: a */
    public void mo7405a(double d, double d2, double d3, double d4, double d5, double d6) {
        this.f4839g = -1;
        this.f4833a = d;
        this.f4834b = d2;
        this.f4835c = d3;
        this.f4836d = d4;
        this.f4837e = d5;
        this.f4838f = d6;
    }

    /* renamed from: a */
    public void mo7406a(C1592a aVar) {
        this.f4839g = aVar.f4839g;
        mo7405a(aVar.f4833a, aVar.f4834b, aVar.f4835c, aVar.f4836d, aVar.f4837e, aVar.f4838f);
    }

    /* renamed from: a */
    public void mo7407a(double[] dArr) {
        dArr[0] = this.f4833a;
        dArr[1] = this.f4834b;
        dArr[2] = this.f4835c;
        dArr[3] = this.f4836d;
        if (dArr.length > 4) {
            dArr[4] = this.f4837e;
            dArr[5] = this.f4838f;
        }
    }

    /* renamed from: b */
    public double mo7408b() {
        return this.f4836d;
    }

    /* renamed from: b */
    public void mo7409b(double d, double d2) {
        this.f4833a = d;
        this.f4836d = d2;
        this.f4838f = 0.0d;
        this.f4837e = 0.0d;
        this.f4835c = 0.0d;
        this.f4834b = 0.0d;
        this.f4839g = (d == 1.0d && d2 == 1.0d) ? 0 : -1;
    }

    /* renamed from: b */
    public void mo7410b(C1592a aVar) {
        mo7406a(mo7403a(aVar, this));
    }

    /* renamed from: c */
    public double mo7411c() {
        return this.f4835c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    /* renamed from: d */
    public double mo7413d() {
        return this.f4834b;
    }

    /* renamed from: e */
    public double mo7414e() {
        return this.f4837e;
    }

    /* renamed from: e */
    public void mo7415e(double d, double d2) {
        mo7410b(m6287d(d, d2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1592a)) {
            return false;
        }
        C1592a aVar = (C1592a) obj;
        return this.f4833a == aVar.f4833a && this.f4835c == aVar.f4835c && this.f4837e == aVar.f4837e && this.f4834b == aVar.f4834b && this.f4836d == aVar.f4836d && this.f4838f == aVar.f4838f;
    }

    /* renamed from: f */
    public double mo7417f() {
        return this.f4838f;
    }

    public String toString() {
        return getClass().getName() + "[[" + this.f4833a + ", " + this.f4835c + ", " + this.f4837e + "], [" + this.f4834b + ", " + this.f4836d + ", " + this.f4838f + "]]";
    }
}
