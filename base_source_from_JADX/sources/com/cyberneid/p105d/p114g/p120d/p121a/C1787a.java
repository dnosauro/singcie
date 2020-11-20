package com.cyberneid.p105d.p114g.p120d.p121a;

import com.cyberneid.p105d.p108b.C1605b;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.a.a */
public class C1787a extends C1789c {
    public C1787a(Map<Integer, String> map) {
        for (Map.Entry next : map.entrySet()) {
            mo8089a(((Integer) next.getKey()).intValue(), (String) next.getValue());
        }
    }

    /* renamed from: d */
    public C1605b mo7505d() {
        throw new UnsupportedOperationException("Built-in encodings cannot be serialized");
    }
}
