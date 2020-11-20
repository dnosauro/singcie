package com.cyberneid.p089b.p091b;

import com.cyberneid.p089b.p093d.C1539b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.b.b.d */
public abstract class C1485d extends C1539b {

    /* renamed from: c */
    private final Map<Integer, String> f4438c = new HashMap();

    C1485d() {
    }

    /* renamed from: a */
    public String mo7060a(int i) {
        String str = this.f4438c.get(Integer.valueOf(i));
        return str == null ? ".notdef" : str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7061a(int i, int i2) {
        String a = C1514m.m5792a(i2);
        this.f4438c.put(Integer.valueOf(i), a);
        mo7170a(i, a);
    }

    /* renamed from: a */
    public void mo7062a(int i, int i2, String str) {
        this.f4438c.put(Integer.valueOf(i), str);
        mo7170a(i, str);
    }
}
