package com.cyberneid.p105d.p114g.p115a.p116a.p117a;

import java.util.Stack;

/* renamed from: com.cyberneid.d.g.a.a.a.d */
public class C1726d {

    /* renamed from: a */
    private final C1730h f5649a;

    /* renamed from: b */
    private final Stack<Object> f5650b = new Stack<>();

    public C1726d(C1730h hVar) {
        this.f5649a = hVar;
    }

    /* renamed from: a */
    public Stack<Object> mo7897a() {
        return this.f5650b;
    }

    /* renamed from: b */
    public C1730h mo7898b() {
        return this.f5649a;
    }

    /* renamed from: c */
    public Number mo7899c() {
        return (Number) this.f5650b.pop();
    }

    /* renamed from: d */
    public int mo7900d() {
        return ((Integer) this.f5650b.pop()).intValue();
    }

    /* renamed from: e */
    public float mo7901e() {
        return ((Number) this.f5650b.pop()).floatValue();
    }
}
