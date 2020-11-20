package com.cyberneid.disigon.p133a;

import com.cyberneid.disigon.MainApplication;
import java.io.IOException;
import p066b.p067a.p068a.p072d.C1366e;

/* renamed from: com.cyberneid.disigon.a.b */
public class C2070b {

    /* renamed from: a */
    private static C2070b f6483a;

    /* renamed from: b */
    private static C2069a f6484b;

    private C2070b() {
        try {
            f6484b = new C2069a(MainApplication.m8072a());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static C2070b m8242a() {
        if (f6483a == null) {
            f6483a = new C2070b();
        }
        return f6483a;
    }

    /* renamed from: a */
    public C2069a mo8680a(C1366e eVar) {
        f6484b.mo8677a(eVar);
        return f6484b;
    }
}
