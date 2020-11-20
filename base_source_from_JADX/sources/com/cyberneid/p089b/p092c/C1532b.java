package com.cyberneid.p089b.p092c;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.b.c.b */
public class C1532b {

    /* renamed from: a */
    private int f4544a = 0;

    /* renamed from: b */
    private String f4545b = null;

    /* renamed from: c */
    private String f4546c = null;

    /* renamed from: d */
    private int f4547d = -1;

    /* renamed from: e */
    private String f4548e = null;

    /* renamed from: f */
    private String f4549f = null;

    /* renamed from: g */
    private int f4550g = 0;

    /* renamed from: h */
    private final List<C1537d> f4551h = new ArrayList();

    /* renamed from: i */
    private final Map<Integer, String> f4552i = new HashMap();

    /* renamed from: j */
    private final Map<Integer, Integer> f4553j = new HashMap();

    /* renamed from: k */
    private final List<C1531a> f4554k = new LinkedList();

    /* renamed from: l */
    private int f4555l = -1;

    C1532b() {
    }

    /* renamed from: a */
    private int m5873a(List<Byte> list) {
        int i = 0;
        for (Byte byteValue : list) {
            i = (i << 8) | ((byteValue.byteValue() + 256) % 256);
        }
        return i;
    }

    /* renamed from: a */
    private int m5874a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 << 8) | ((bArr[i + i4] + 256) % 256);
        }
        return i3;
    }

    /* renamed from: a */
    public int mo7141a(InputStream inputStream) {
        inputStream.mark(4);
        ArrayList arrayList = new ArrayList(4);
        for (int i = 0; i < 4; i++) {
            arrayList.add(Byte.valueOf((byte) inputStream.read()));
            for (C1537d a : this.f4551h) {
                if (a.mo7167a((List<Byte>) arrayList)) {
                    return m5873a((List<Byte>) arrayList);
                }
            }
        }
        inputStream.reset();
        ArrayList arrayList2 = new ArrayList(4);
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList2.add(Byte.valueOf((byte) inputStream.read()));
            C1537d dVar = null;
            C1537d dVar2 = null;
            for (C1537d next : this.f4551h) {
                if (next.mo7166a(((Byte) arrayList2.get(i2)).byteValue(), i2) && (dVar == null || next.mo7168a().length < dVar.mo7168a().length)) {
                    dVar = next;
                }
                if (dVar2 == null || next.mo7168a().length < dVar2.mo7168a().length) {
                    dVar2 = next;
                }
            }
            if (dVar == null) {
                dVar = dVar2;
            }
            if (dVar != null && dVar.mo7168a().length == arrayList2.size()) {
                return m5873a((List<Byte>) arrayList2);
            }
        }
        throw new IOException("CMap is invalid");
    }

    /* renamed from: a */
    public String mo7142a(int i) {
        return this.f4552i.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7143a(char c, char c2, int i) {
        this.f4554k.add(0, new C1531a(c, c2, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7144a(int i, int i2) {
        this.f4553j.put(Integer.valueOf(i2), Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7145a(C1532b bVar) {
        this.f4551h.addAll(bVar.f4551h);
        this.f4552i.putAll(bVar.f4552i);
        this.f4553j.putAll(bVar.f4553j);
        this.f4554k.addAll(bVar.f4554k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7146a(C1537d dVar) {
        this.f4551h.add(dVar);
    }

    /* renamed from: a */
    public void mo7147a(String str) {
        this.f4545b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7148a(byte[] bArr, String str) {
        int a = m5874a(bArr, 0, bArr.length);
        this.f4552i.put(Integer.valueOf(a), str);
        if (" ".equals(str)) {
            this.f4555l = a;
        }
    }

    /* renamed from: a */
    public boolean mo7149a() {
        return !this.f4553j.isEmpty() || !this.f4554k.isEmpty();
    }

    /* renamed from: b */
    public int mo7150b(int i) {
        Integer num = this.f4553j.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        for (C1531a a : this.f4554k) {
            int a2 = a.mo7140a((char) i);
            if (a2 != -1) {
                return a2;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public void mo7151b(String str) {
        this.f4546c = str;
    }

    /* renamed from: b */
    public boolean mo7152b() {
        return !this.f4552i.isEmpty();
    }

    /* renamed from: c */
    public String mo7153c() {
        return this.f4545b;
    }

    /* renamed from: c */
    public void mo7154c(int i) {
        this.f4544a = i;
    }

    /* renamed from: c */
    public void mo7155c(String str) {
        this.f4548e = str;
    }

    /* renamed from: d */
    public String mo7156d() {
        return this.f4548e;
    }

    /* renamed from: d */
    public void mo7157d(int i) {
        this.f4547d = i;
    }

    /* renamed from: d */
    public void mo7158d(String str) {
        this.f4549f = str;
    }

    /* renamed from: e */
    public String mo7159e() {
        return this.f4549f;
    }

    /* renamed from: e */
    public void mo7160e(int i) {
        this.f4550g = i;
    }

    public String toString() {
        return this.f4545b;
    }
}
