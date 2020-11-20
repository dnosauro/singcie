package com.cyberneid.p105d.p114g.p126f.p129c;

import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p111d.C1658e;
import com.cyberneid.p105d.p112e.C1671f;
import java.io.Closeable;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.g.f.c.e */
public class C1898e implements Closeable {

    /* renamed from: a */
    private C1608e f6052a;

    /* renamed from: b */
    private int f6053b;

    /* renamed from: c */
    private int f6054c = 0;

    /* renamed from: a */
    public int mo8378a() {
        return this.f6054c;
    }

    /* renamed from: a */
    public void mo8379a(int i) {
        this.f6054c = i;
    }

    /* renamed from: a */
    public void mo8380a(InputStream inputStream) {
        C1671f fVar = new C1671f(new C1658e(inputStream));
        fVar.mo7799B();
        this.f6052a = fVar.mo7785y();
    }

    /* renamed from: b */
    public C1608e mo8381b() {
        return this.f6052a;
    }

    /* renamed from: c */
    public int mo8382c() {
        return this.f6053b;
    }

    public void close() {
        C1608e eVar = this.f6052a;
        if (eVar != null) {
            eVar.close();
        }
    }
}
