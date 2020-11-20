package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p089b.p092c.C1532b;
import com.cyberneid.p089b.p092c.C1533c;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.c */
final class C1802c {

    /* renamed from: a */
    static Map<String, C1532b> f5824a = Collections.synchronizedMap(new HashMap());

    /* renamed from: a */
    public static C1532b m7301a(InputStream inputStream) {
        if (inputStream != null) {
            return new C1533c().mo7162a(inputStream);
        }
        return null;
    }

    /* renamed from: a */
    public static C1532b m7302a(String str) {
        C1532b bVar = f5824a.get(str);
        if (bVar != null) {
            return bVar;
        }
        C1532b a = new C1533c().mo7163a(str);
        f5824a.put(a.mo7153c(), a);
        return a;
    }
}
