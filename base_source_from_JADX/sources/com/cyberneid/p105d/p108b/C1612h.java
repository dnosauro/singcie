package com.cyberneid.p105d.p108b;

import java.io.OutputStream;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.d.b.h */
public final class C1612h extends C1615k {

    /* renamed from: a */
    public static final C1612h f4886a = m6455a(0);

    /* renamed from: b */
    public static final C1612h f4887b = m6455a(1);

    /* renamed from: c */
    public static final C1612h f4888c = m6455a(2);

    /* renamed from: d */
    public static final C1612h f4889d = m6455a(3);

    /* renamed from: g */
    private static final C1612h[] f4890g = new C1612h[357];

    /* renamed from: h */
    private final long f4891h;

    private C1612h(long j) {
        this.f4891h = j;
    }

    /* renamed from: a */
    public static C1612h m6455a(long j) {
        if (-100 > j || j > 256) {
            return new C1612h(j);
        }
        int i = ((int) j) + 100;
        C1612h[] hVarArr = f4890g;
        if (hVarArr[i] == null) {
            hVarArr[i] = new C1612h(j);
        }
        return f4890g[i];
    }

    /* renamed from: a */
    public float mo7583a() {
        return (float) this.f4891h;
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7652a(this);
    }

    /* renamed from: a */
    public void mo7591a(OutputStream outputStream) {
        outputStream.write(String.valueOf(this.f4891h).getBytes(LocalizedMessage.DEFAULT_ENCODING));
    }

    /* renamed from: b */
    public long mo7585b() {
        return this.f4891h;
    }

    /* renamed from: c */
    public int mo7586c() {
        return (int) this.f4891h;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1612h) && ((C1612h) obj).mo7586c() == mo7586c();
    }

    public int hashCode() {
        long j = this.f4891h;
        return (int) (j ^ (j >> 32));
    }

    public String toString() {
        return "COSInt{" + this.f4891h + "}";
    }
}
