package com.cyberneid.p089b.p095f;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cyberneid.b.f.aa */
public class C1543aa implements Closeable {

    /* renamed from: a */
    private final C1575w f4570a;

    /* renamed from: b */
    private final List<C1544ab> f4571b;

    C1543aa(C1575w wVar) {
        Object obj;
        this.f4570a = wVar;
        if (wVar.mo7360m().equals("ttcf")) {
            float h = wVar.mo7355h();
            int k = (int) wVar.mo7358k();
            long[] jArr = new long[k];
            for (int i = 0; i < k; i++) {
                jArr[i] = wVar.mo7358k();
            }
            if (h >= 2.0f) {
                wVar.mo7281d();
                wVar.mo7281d();
                wVar.mo7281d();
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < k; i2++) {
                wVar.mo7277a(jArr[i2]);
                if (wVar.mo7360m().equals("OTTO")) {
                    wVar.mo7277a(jArr[i2]);
                    obj = new C1569q(false, true).mo7336d((C1575w) new C1574v(wVar));
                } else {
                    wVar.mo7277a(jArr[i2]);
                    obj = new C1576x(false, true).mo7336d(new C1574v(wVar));
                }
                arrayList.add(obj);
            }
            this.f4571b = Collections.unmodifiableList(arrayList);
            return;
        }
        throw new IOException("Missing TTC header");
    }

    public C1543aa(File file) {
        this((C1575w) new C1573u(file, "r"));
    }

    /* renamed from: a */
    public List<C1544ab> mo7176a() {
        return this.f4571b;
    }

    public void close() {
        this.f4570a.close();
    }
}
