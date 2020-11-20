package com.cyberneid.p105d.p114g.p115a.p116a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1762e;

/* renamed from: com.cyberneid.d.g.a.a.d */
public class C1756d extends C1690a {

    /* renamed from: a */
    private C1604a f5724a = null;

    /* renamed from: b */
    private C1604a f5725b = null;

    /* renamed from: c */
    private C1604a f5726c = null;

    public C1756d(C1605b bVar) {
        super(bVar);
    }

    /* renamed from: c */
    private C1762e m7032c(int i) {
        return new C1762e(mo7923j(), i);
    }

    /* renamed from: a */
    public int mo7883a() {
        return 3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float[] mo7885a(float[] r11) {
        /*
            r10 = this;
            r0 = 0
            r11 = r11[r0]
            com.cyberneid.d.g.a.e r1 = r10.mo7887b((int) r0)
            float r2 = r1.mo7939a()
            float r3 = r1.mo7940b()
            float r5 = r10.mo7881a(r11, r2, r3)
            com.cyberneid.d.b.a r11 = r10.mo7917h()
            int r2 = r11.mo7494b()
            r3 = 1
            if (r2 != r3) goto L_0x0040
            com.cyberneid.d.b.b r11 = r11.mo7495b((int) r0)
            com.cyberneid.d.g.a.a.a r11 = com.cyberneid.p105d.p114g.p115a.p116a.C1690a.m6909a((com.cyberneid.p105d.p108b.C1605b) r11)
            com.cyberneid.d.g.a.e r2 = r10.m7032c(r0)
            float r6 = r1.mo7939a()
            float r7 = r1.mo7940b()
            float r8 = r2.mo7939a()
            float r9 = r2.mo7940b()
            r4 = r10
        L_0x003b:
            float r5 = r4.mo7882a(r5, r6, r7, r8, r9)
            goto L_0x0099
        L_0x0040:
            com.cyberneid.d.b.a r2 = r10.mo7922i()
            float[] r2 = r2.mo7500c()
            int r4 = r2.length
            int r6 = r4 + 2
            float[] r6 = new float[r6]
            int r7 = r6.length
            float r8 = r1.mo7939a()
            r6[r0] = r8
            int r8 = r7 + -1
            float r1 = r1.mo7940b()
            r6[r8] = r1
            java.lang.System.arraycopy(r2, r0, r6, r3, r4)
            r1 = 0
        L_0x0060:
            if (r1 >= r8) goto L_0x0098
            r2 = r6[r1]
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0095
            int r2 = r1 + 1
            r4 = r6[r2]
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x007a
            int r4 = r7 + -2
            if (r1 != r4) goto L_0x0095
            r4 = r6[r2]
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0095
        L_0x007a:
            com.cyberneid.d.b.b r11 = r11.mo7495b((int) r1)
            com.cyberneid.d.g.a.a.a r11 = com.cyberneid.p105d.p114g.p115a.p116a.C1690a.m6909a((com.cyberneid.p105d.p108b.C1605b) r11)
            com.cyberneid.d.g.a.e r4 = r10.m7032c(r1)
            r1 = r6[r1]
            r7 = r6[r2]
            float r8 = r4.mo7939a()
            float r9 = r4.mo7940b()
            r4 = r10
            r6 = r1
            goto L_0x003b
        L_0x0095:
            int r1 = r1 + 1
            goto L_0x0060
        L_0x0098:
            r11 = 0
        L_0x0099:
            if (r11 == 0) goto L_0x00a8
            float[] r1 = new float[r3]
            r1[r0] = r5
            float[] r11 = r11.mo7885a((float[]) r1)
            float[] r11 = r10.mo7888b((float[]) r11)
            return r11
        L_0x00a8:
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "partition not found in type 3 function"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p115a.p116a.C1756d.mo7885a(float[]):float[]");
    }

    /* renamed from: h */
    public C1604a mo7917h() {
        if (this.f5724a == null) {
            this.f5724a = (C1604a) mo7505d().mo7539c(C1613i.f5047cW);
        }
        return this.f5724a;
    }

    /* renamed from: i */
    public C1604a mo7922i() {
        if (this.f5726c == null) {
            this.f5726c = (C1604a) mo7505d().mo7539c(C1613i.f4915X);
        }
        return this.f5726c;
    }

    /* renamed from: j */
    public C1604a mo7923j() {
        if (this.f5725b == null) {
            this.f5725b = (C1604a) mo7505d().mo7539c(C1613i.f5051ca);
        }
        return this.f5725b;
    }
}
