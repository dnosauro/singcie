package com.cyberneid.p089b.p091b;

import com.cyberneid.p089b.C1479b;
import com.cyberneid.p089b.p097h.C1586a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.b.b.h */
public abstract class C1489h implements C1479b {

    /* renamed from: a */
    protected String f4442a;

    /* renamed from: b */
    protected final Map<String, Object> f4443b = new LinkedHashMap();

    /* renamed from: c */
    protected C1483b f4444c;

    /* renamed from: d */
    protected final List<byte[]> f4445d = new ArrayList();

    /* renamed from: e */
    protected C1524t f4446e;

    /* renamed from: f */
    private byte[] f4447f;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7063a(C1483b bVar) {
        this.f4444c = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7064a(C1524t tVar) {
        this.f4446e = tVar;
    }

    /* renamed from: a */
    public void mo7065a(String str, Object obj) {
        if (obj != null) {
            this.f4443b.put(str, obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7066a(byte[] bArr) {
        this.f4447f = bArr;
    }

    /* renamed from: b */
    public String mo7033b() {
        return this.f4442a;
    }

    /* renamed from: c */
    public C1586a mo7035c() {
        return new C1586a((List) this.f4443b.get("FontBBox"));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo7067e(String str) {
        this.f4442a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public List<byte[]> mo7068h() {
        return this.f4445d;
    }

    public String toString() {
        return getClass().getSimpleName() + "[name=" + this.f4442a + ", topDict=" + this.f4443b + ", charset=" + this.f4444c + ", charStrings=" + this.f4445d + "]";
    }
}
