package com.cyberneid.p089b.p097h;

import java.util.List;

/* renamed from: com.cyberneid.b.h.a */
public class C1586a {

    /* renamed from: a */
    private float f4828a;

    /* renamed from: b */
    private float f4829b;

    /* renamed from: c */
    private float f4830c;

    /* renamed from: d */
    private float f4831d;

    public C1586a() {
    }

    public C1586a(float f, float f2, float f3, float f4) {
        this.f4828a = f;
        this.f4829b = f2;
        this.f4830c = f3;
        this.f4831d = f4;
    }

    public C1586a(List<Number> list) {
        this.f4828a = list.get(0).floatValue();
        this.f4829b = list.get(1).floatValue();
        this.f4830c = list.get(2).floatValue();
        this.f4831d = list.get(3).floatValue();
    }

    /* renamed from: a */
    public float mo7388a() {
        return this.f4828a;
    }

    /* renamed from: a */
    public void mo7389a(float f) {
        this.f4828a = f;
    }

    /* renamed from: b */
    public float mo7390b() {
        return this.f4829b;
    }

    /* renamed from: b */
    public void mo7391b(float f) {
        this.f4829b = f;
    }

    /* renamed from: c */
    public float mo7392c() {
        return this.f4830c;
    }

    /* renamed from: c */
    public void mo7393c(float f) {
        this.f4830c = f;
    }

    /* renamed from: d */
    public float mo7394d() {
        return this.f4831d;
    }

    /* renamed from: d */
    public void mo7395d(float f) {
        this.f4831d = f;
    }

    /* renamed from: e */
    public float mo7396e() {
        return mo7394d() - mo7390b();
    }

    public String toString() {
        return "[" + mo7388a() + "," + mo7390b() + "," + mo7392c() + "," + mo7394d() + "]";
    }
}
