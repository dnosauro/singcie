package com.cyberneid.p089b.p091b;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.b.b.b */
public abstract class C1483b {

    /* renamed from: a */
    private final boolean f4432a;

    /* renamed from: b */
    private final Map<Integer, Integer> f4433b = new HashMap();

    /* renamed from: c */
    private final Map<Integer, Integer> f4434c = new HashMap();

    /* renamed from: d */
    private final Map<String, Integer> f4435d = new HashMap();

    /* renamed from: e */
    private final Map<Integer, Integer> f4436e = new HashMap();

    /* renamed from: f */
    private final Map<Integer, String> f4437f = new HashMap();

    C1483b(boolean z) {
        this.f4432a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7049a(int i) {
        if (!this.f4432a) {
            Integer num = this.f4434c.get(Integer.valueOf(i));
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7050a(String str) {
        if (!this.f4432a) {
            Integer num = this.f4435d.get(str);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    /* renamed from: a */
    public void mo7051a(int i, int i2) {
        if (this.f4432a) {
            this.f4433b.put(Integer.valueOf(i2), Integer.valueOf(i));
            this.f4436e.put(Integer.valueOf(i), Integer.valueOf(i2));
            return;
        }
        throw new IllegalStateException("Not a CIDFont");
    }

    /* renamed from: a */
    public void mo7052a(int i, int i2, String str) {
        if (!this.f4432a) {
            this.f4433b.put(Integer.valueOf(i2), Integer.valueOf(i));
            this.f4434c.put(Integer.valueOf(i), Integer.valueOf(i2));
            this.f4435d.put(str, Integer.valueOf(i2));
            this.f4437f.put(Integer.valueOf(i), str);
            return;
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo7053b(int i) {
        if (!this.f4432a) {
            Integer num = this.f4433b.get(Integer.valueOf(i));
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    /* renamed from: c */
    public int mo7054c(int i) {
        if (this.f4432a) {
            Integer num = this.f4433b.get(Integer.valueOf(i));
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        throw new IllegalStateException("Not a CIDFont");
    }
}
