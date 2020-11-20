package com.cyberneid.p105d.p131h;

import com.cyberneid.p099c.p100a.p101a.C1592a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1615k;

/* renamed from: com.cyberneid.d.h.d */
public final class C1940d implements Cloneable {

    /* renamed from: a */
    static final float[] f6140a = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: b */
    private final float[] f6141b;

    public C1940d() {
        float[] fArr = f6140a;
        this.f6141b = new float[fArr.length];
        System.arraycopy(fArr, 0, this.f6141b, 0, fArr.length);
    }

    public C1940d(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f6141b = new float[f6140a.length];
        float[] fArr = this.f6141b;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[6] = f5;
        fArr[7] = f6;
        fArr[8] = 1.0f;
    }

    public C1940d(C1592a aVar) {
        float[] fArr = f6140a;
        this.f6141b = new float[fArr.length];
        System.arraycopy(fArr, 0, this.f6141b, 0, fArr.length);
        this.f6141b[0] = (float) aVar.mo7401a();
        this.f6141b[1] = (float) aVar.mo7413d();
        this.f6141b[3] = (float) aVar.mo7411c();
        this.f6141b[4] = (float) aVar.mo7408b();
        this.f6141b[6] = (float) aVar.mo7414e();
        this.f6141b[7] = (float) aVar.mo7417f();
    }

    public C1940d(C1604a aVar) {
        this.f6141b = new float[f6140a.length];
        this.f6141b[0] = ((C1615k) aVar.mo7495b(0)).mo7583a();
        this.f6141b[1] = ((C1615k) aVar.mo7495b(1)).mo7583a();
        this.f6141b[3] = ((C1615k) aVar.mo7495b(2)).mo7583a();
        this.f6141b[4] = ((C1615k) aVar.mo7495b(3)).mo7583a();
        this.f6141b[6] = ((C1615k) aVar.mo7495b(4)).mo7583a();
        this.f6141b[7] = ((C1615k) aVar.mo7495b(5)).mo7583a();
        this.f6141b[8] = 1.0f;
    }

    /* renamed from: a */
    public static C1940d m7988a(float f, float f2) {
        C1940d dVar = new C1940d();
        float[] fArr = dVar.f6141b;
        fArr[0] = f;
        fArr[4] = f2;
        return dVar;
    }

    /* renamed from: a */
    public C1592a mo8478a() {
        float[] fArr = this.f6141b;
        return new C1592a(fArr[0], fArr[1], fArr[3], fArr[4], fArr[6], fArr[7]);
    }

    /* renamed from: b */
    public C1940d clone() {
        C1940d dVar = new C1940d();
        System.arraycopy(this.f6141b, 0, dVar.f6141b, 0, 9);
        return dVar;
    }

    /* renamed from: c */
    public float mo8480c() {
        return this.f6141b[0];
    }

    /* renamed from: d */
    public float mo8482d() {
        return this.f6141b[4];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("[");
        stringBuffer.append(this.f6141b[0] + ",");
        stringBuffer.append(this.f6141b[1] + ",");
        stringBuffer.append(this.f6141b[3] + ",");
        stringBuffer.append(this.f6141b[4] + ",");
        stringBuffer.append(this.f6141b[6] + ",");
        stringBuffer.append(this.f6141b[7] + "]");
        return stringBuffer.toString();
    }
}
