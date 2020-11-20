package com.cyberneid.p105d.p114g.p120d;

import java.io.Serializable;

/* renamed from: com.cyberneid.d.g.d.b */
public final class C1801b implements Serializable {

    /* renamed from: a */
    private final String f5821a;

    /* renamed from: b */
    private final String f5822b;

    /* renamed from: c */
    private final int f5823c;

    C1801b(String str, String str2, int i) {
        this.f5821a = str;
        this.f5822b = str2;
        this.f5823c = i;
    }

    /* renamed from: a */
    public String mo8115a() {
        return this.f5821a;
    }

    /* renamed from: b */
    public String mo8116b() {
        return this.f5822b;
    }

    /* renamed from: c */
    public int mo8117c() {
        return this.f5823c;
    }

    public String toString() {
        return mo8115a() + "-" + mo8116b() + "-" + mo8117c();
    }
}
