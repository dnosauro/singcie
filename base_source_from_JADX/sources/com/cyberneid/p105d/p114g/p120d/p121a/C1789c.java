package com.cyberneid.p105d.p114g.p120d.p121a;

import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.g.d.a.c */
public abstract class C1789c implements C1760c {

    /* renamed from: a */
    protected final Map<Integer, String> f5799a = new HashMap();

    /* renamed from: b */
    protected final Set<String> f5800b = new HashSet();

    /* renamed from: a */
    public static C1789c m7247a(C1613i iVar) {
        if (C1613i.f5242gF.equals(iVar)) {
            return C1793g.f5808c;
        }
        if (C1613i.f5310hU.equals(iVar)) {
            return C1795i.f5809c;
        }
        if (C1613i.f5164eh.equals(iVar)) {
            return C1792f.f5807d;
        }
        return null;
    }

    /* renamed from: a */
    public String mo8088a(int i) {
        String str = this.f5799a.get(Integer.valueOf(i));
        return str != null ? str : ".notdef";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8089a(int i, String str) {
        this.f5799a.put(Integer.valueOf(i), str);
        this.f5800b.add(str);
    }

    /* renamed from: a */
    public boolean mo8090a(String str) {
        return this.f5800b.contains(str);
    }

    /* renamed from: c */
    public Map<Integer, String> mo8091c() {
        return Collections.unmodifiableMap(this.f5799a);
    }
}
