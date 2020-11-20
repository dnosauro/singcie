package com.cyberneid.p105d.p114g.p126f.p129c;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import java.util.Calendar;

/* renamed from: com.cyberneid.d.g.f.c.c */
public class C1896c implements C1760c {

    /* renamed from: a */
    public static final C1613i f6043a = C1613i.f5289h;

    /* renamed from: b */
    public static final C1613i f6044b = C1613i.f5061ck;

    /* renamed from: c */
    public static final C1613i f6045c = C1613i.f4965au;

    /* renamed from: d */
    public static final C1613i f6046d = C1613i.f5298hI;

    /* renamed from: e */
    public static final C1613i f6047e = C1613i.f5236g;

    /* renamed from: f */
    public static final C1613i f6048f = C1613i.f5130e;

    /* renamed from: g */
    public static final C1613i f6049g = C1613i.m6461a("ETSI.CAdES.detached");

    /* renamed from: h */
    public static final C1613i f6050h = C1613i.f5183f;

    /* renamed from: i */
    private final C1607d f6051i;

    public C1896c() {
        this.f6051i = new C1607d();
        this.f6051i.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5286gx);
    }

    public C1896c(C1607d dVar) {
        this.f6051i = dVar;
    }

    /* renamed from: a */
    public C1607d mo7505d() {
        return this.f6051i;
    }

    /* renamed from: a */
    public void mo8367a(C1613i iVar) {
        this.f6051i.mo7521a(C1613i.f5074cx, (C1605b) iVar);
    }

    /* renamed from: a */
    public void mo8368a(String str) {
        this.f6051i.mo7536b(C1613i.f5181ey, str);
    }

    /* renamed from: a */
    public void mo8369a(Calendar calendar) {
        this.f6051i.mo7524a(C1613i.f5162ef, calendar);
    }

    /* renamed from: a */
    public void mo8370a(byte[] bArr) {
        C1622p pVar = new C1622p(bArr);
        pVar.mo7642b(true);
        this.f6051i.mo7521a(C1613i.f4934aP, (C1605b) pVar);
    }

    /* renamed from: a */
    public void mo8371a(int[] iArr) {
        if (iArr.length == 4) {
            C1604a aVar = new C1604a();
            for (int i : iArr) {
                aVar.mo7490a((C1605b) C1612h.m6455a((long) i));
            }
            this.f6051i.mo7521a(C1613i.f4946ab, (C1605b) aVar);
        }
    }

    /* renamed from: b */
    public void mo8372b(C1613i iVar) {
        this.f6051i.mo7521a(C1613i.f5255gS, (C1605b) iVar);
    }

    /* renamed from: b */
    public void mo8373b(String str) {
        this.f6051i.mo7536b(C1613i.f5157ea, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0018  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] mo8374b(byte[] r4) {
        /*
            r3 = this;
            r0 = 0
            com.cyberneid.d.g.f.c.a r1 = new com.cyberneid.d.g.f.c.a     // Catch:{ all -> 0x0015 }
            int[] r2 = r3.mo8375b()     // Catch:{ all -> 0x0015 }
            r1.<init>(r4, r2)     // Catch:{ all -> 0x0015 }
            byte[] r4 = r1.mo8360a()     // Catch:{ all -> 0x0012 }
            r1.close()
            return r4
        L_0x0012:
            r4 = move-exception
            r0 = r1
            goto L_0x0016
        L_0x0015:
            r4 = move-exception
        L_0x0016:
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p126f.p129c.C1896c.mo8374b(byte[]):byte[]");
    }

    /* renamed from: b */
    public int[] mo8375b() {
        C1604a aVar = (C1604a) this.f6051i.mo7539c(C1613i.f4946ab);
        int[] iArr = new int[aVar.mo7494b()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = aVar.mo7498c(i);
        }
        return iArr;
    }

    /* renamed from: c */
    public void mo8376c(String str) {
        this.f6051i.mo7536b(C1613i.f5207fX, str);
    }
}
