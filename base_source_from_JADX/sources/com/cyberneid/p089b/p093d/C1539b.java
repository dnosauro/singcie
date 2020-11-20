package com.cyberneid.p089b.p093d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.b.d.b */
public abstract class C1539b {

    /* renamed from: a */
    protected Map<Integer, String> f4563a = new HashMap();

    /* renamed from: b */
    protected Map<String, Integer> f4564b = new HashMap();

    /* renamed from: a */
    public String mo7060a(int i) {
        String str = this.f4563a.get(Integer.valueOf(i));
        return str != null ? str : ".notdef";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7170a(int i, String str) {
        this.f4563a.put(Integer.valueOf(i), str);
        this.f4564b.put(str, Integer.valueOf(i));
    }

    /* renamed from: b */
    public Map<Integer, String> mo7171b() {
        return Collections.unmodifiableMap(this.f4563a);
    }
}
