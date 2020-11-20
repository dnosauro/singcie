package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.C0444e;
import androidx.constraintlayout.p019a.p020a.C0425f;

/* renamed from: androidx.constraintlayout.a.a.k */
public class C0433k {

    /* renamed from: a */
    static boolean[] f1594a = new boolean[3];

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01e0, code lost:
        if (r6 != false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r6 != false) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e9, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010f, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01c4, code lost:
        if (r6 != false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01cf, code lost:
        r4.mo3127a(r2, r1);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m1741a(int r16, androidx.constraintlayout.p019a.p020a.C0425f r17) {
        /*
            r0 = r17
            r17.mo3064g()
            androidx.constraintlayout.a.a.e r1 = r0.f1534s
            androidx.constraintlayout.a.a.m r1 = r1.mo3004a()
            androidx.constraintlayout.a.a.e r2 = r0.f1535t
            androidx.constraintlayout.a.a.m r2 = r2.mo3004a()
            androidx.constraintlayout.a.a.e r3 = r0.f1536u
            androidx.constraintlayout.a.a.m r3 = r3.mo3004a()
            androidx.constraintlayout.a.a.e r4 = r0.f1537v
            androidx.constraintlayout.a.a.m r4 = r4.mo3004a()
            r5 = 8
            r6 = r16 & 8
            r7 = 0
            r8 = 1
            if (r6 != r5) goto L_0x0027
            r6 = 1
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            androidx.constraintlayout.a.a.f$a[] r9 = r0.f1472C
            r9 = r9[r7]
            androidx.constraintlayout.a.a.f$a r10 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            if (r9 != r10) goto L_0x0038
            boolean r9 = m1744a((androidx.constraintlayout.p019a.p020a.C0425f) r0, (int) r7)
            if (r9 == 0) goto L_0x0038
            r9 = 1
            goto L_0x0039
        L_0x0038:
            r9 = 0
        L_0x0039:
            int r10 = r1.f1601g
            r11 = 3
            r12 = 4
            r13 = 0
            r14 = -1
            r15 = 2
            if (r10 == r12) goto L_0x0181
            int r10 = r3.f1601g
            if (r10 == r12) goto L_0x0181
            androidx.constraintlayout.a.a.f$a[] r10 = r0.f1472C
            r10 = r10[r7]
            androidx.constraintlayout.a.a.f$a r7 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            if (r10 == r7) goto L_0x00d7
            if (r9 == 0) goto L_0x0058
            int r7 = r17.mo3073l()
            if (r7 != r5) goto L_0x0058
            goto L_0x00d7
        L_0x0058:
            if (r9 == 0) goto L_0x0181
            int r7 = r17.mo3081p()
            r1.mo3131b(r8)
            r3.mo3131b(r8)
            androidx.constraintlayout.a.a.e r9 = r0.f1534s
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 != 0) goto L_0x0074
            androidx.constraintlayout.a.a.e r9 = r0.f1536u
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 != 0) goto L_0x0074
            if (r6 == 0) goto L_0x00f8
            goto L_0x00eb
        L_0x0074:
            androidx.constraintlayout.a.a.e r9 = r0.f1534s
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 == 0) goto L_0x0083
            androidx.constraintlayout.a.a.e r9 = r0.f1536u
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 != 0) goto L_0x0083
            if (r6 == 0) goto L_0x00f8
            goto L_0x00eb
        L_0x0083:
            androidx.constraintlayout.a.a.e r9 = r0.f1534s
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 != 0) goto L_0x0093
            androidx.constraintlayout.a.a.e r9 = r0.f1536u
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 == 0) goto L_0x0093
            if (r6 == 0) goto L_0x013a
            goto L_0x012e
        L_0x0093:
            androidx.constraintlayout.a.a.e r9 = r0.f1534s
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 == 0) goto L_0x0181
            androidx.constraintlayout.a.a.e r9 = r0.f1536u
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 == 0) goto L_0x0181
            if (r6 == 0) goto L_0x00af
            androidx.constraintlayout.a.a.n r9 = r17.mo3067i()
            r9.mo3139a(r1)
            androidx.constraintlayout.a.a.n r9 = r17.mo3067i()
            r9.mo3139a(r3)
        L_0x00af:
            float r9 = r0.f1476G
            int r9 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r9 != 0) goto L_0x00c3
            r1.mo3131b(r11)
            r3.mo3131b(r11)
            r1.mo3132b(r3, r13)
            r3.mo3132b(r1, r13)
            goto L_0x0181
        L_0x00c3:
            r1.mo3131b(r15)
            r3.mo3131b(r15)
            int r9 = -r7
            float r9 = (float) r9
            r1.mo3132b(r3, r9)
            float r9 = (float) r7
            r3.mo3132b(r1, r9)
            r0.mo3070j(r7)
            goto L_0x0181
        L_0x00d7:
            androidx.constraintlayout.a.a.e r7 = r0.f1534s
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 != 0) goto L_0x00fd
            androidx.constraintlayout.a.a.e r7 = r0.f1536u
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 != 0) goto L_0x00fd
            r1.mo3131b(r8)
            r3.mo3131b(r8)
            if (r6 == 0) goto L_0x00f4
        L_0x00eb:
            androidx.constraintlayout.a.a.n r7 = r17.mo3067i()
            r3.mo3128a((androidx.constraintlayout.p019a.p020a.C0435m) r1, (int) r8, (androidx.constraintlayout.p019a.p020a.C0436n) r7)
            goto L_0x0181
        L_0x00f4:
            int r7 = r17.mo3081p()
        L_0x00f8:
            r3.mo3127a((androidx.constraintlayout.p019a.p020a.C0435m) r1, (int) r7)
            goto L_0x0181
        L_0x00fd:
            androidx.constraintlayout.a.a.e r7 = r0.f1534s
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 == 0) goto L_0x0112
            androidx.constraintlayout.a.a.e r7 = r0.f1536u
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 != 0) goto L_0x0112
            r1.mo3131b(r8)
            r3.mo3131b(r8)
            if (r6 == 0) goto L_0x00f4
            goto L_0x00eb
        L_0x0112:
            androidx.constraintlayout.a.a.e r7 = r0.f1534s
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 != 0) goto L_0x013f
            androidx.constraintlayout.a.a.e r7 = r0.f1536u
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 == 0) goto L_0x013f
            r1.mo3131b(r8)
            r3.mo3131b(r8)
            int r7 = r17.mo3081p()
            int r7 = -r7
            r1.mo3127a((androidx.constraintlayout.p019a.p020a.C0435m) r3, (int) r7)
            if (r6 == 0) goto L_0x0136
        L_0x012e:
            androidx.constraintlayout.a.a.n r7 = r17.mo3067i()
            r1.mo3128a((androidx.constraintlayout.p019a.p020a.C0435m) r3, (int) r14, (androidx.constraintlayout.p019a.p020a.C0436n) r7)
            goto L_0x0181
        L_0x0136:
            int r7 = r17.mo3081p()
        L_0x013a:
            int r7 = -r7
            r1.mo3127a((androidx.constraintlayout.p019a.p020a.C0435m) r3, (int) r7)
            goto L_0x0181
        L_0x013f:
            androidx.constraintlayout.a.a.e r7 = r0.f1534s
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 == 0) goto L_0x0181
            androidx.constraintlayout.a.a.e r7 = r0.f1536u
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 == 0) goto L_0x0181
            r1.mo3131b(r15)
            r3.mo3131b(r15)
            if (r6 == 0) goto L_0x0170
            androidx.constraintlayout.a.a.n r7 = r17.mo3067i()
            r7.mo3139a(r1)
            androidx.constraintlayout.a.a.n r7 = r17.mo3067i()
            r7.mo3139a(r3)
            androidx.constraintlayout.a.a.n r7 = r17.mo3067i()
            r1.mo3133b(r3, r14, r7)
            androidx.constraintlayout.a.a.n r7 = r17.mo3067i()
            r3.mo3133b(r1, r8, r7)
            goto L_0x0181
        L_0x0170:
            int r7 = r17.mo3081p()
            int r7 = -r7
            float r7 = (float) r7
            r1.mo3132b(r3, r7)
            int r7 = r17.mo3081p()
            float r7 = (float) r7
            r3.mo3132b(r1, r7)
        L_0x0181:
            androidx.constraintlayout.a.a.f$a[] r1 = r0.f1472C
            r1 = r1[r8]
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            if (r1 != r3) goto L_0x0191
            boolean r1 = m1744a((androidx.constraintlayout.p019a.p020a.C0425f) r0, (int) r8)
            if (r1 == 0) goto L_0x0191
            r1 = 1
            goto L_0x0192
        L_0x0191:
            r1 = 0
        L_0x0192:
            int r3 = r2.f1601g
            if (r3 == r12) goto L_0x032b
            int r3 = r4.f1601g
            if (r3 == r12) goto L_0x032b
            androidx.constraintlayout.a.a.f$a[] r3 = r0.f1472C
            r3 = r3[r8]
            androidx.constraintlayout.a.a.f$a r7 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            if (r3 == r7) goto L_0x0247
            if (r1 == 0) goto L_0x01ac
            int r3 = r17.mo3073l()
            if (r3 != r5) goto L_0x01ac
            goto L_0x0247
        L_0x01ac:
            if (r1 == 0) goto L_0x032b
            int r1 = r17.mo3085r()
            r2.mo3131b(r8)
            r4.mo3131b(r8)
            androidx.constraintlayout.a.a.e r3 = r0.f1535t
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 != 0) goto L_0x01d4
            androidx.constraintlayout.a.a.e r3 = r0.f1537v
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 != 0) goto L_0x01d4
            if (r6 == 0) goto L_0x01cf
        L_0x01c6:
            androidx.constraintlayout.a.a.n r0 = r17.mo3069j()
            r4.mo3128a((androidx.constraintlayout.p019a.p020a.C0435m) r2, (int) r8, (androidx.constraintlayout.p019a.p020a.C0436n) r0)
            goto L_0x032b
        L_0x01cf:
            r4.mo3127a((androidx.constraintlayout.p019a.p020a.C0435m) r2, (int) r1)
            goto L_0x032b
        L_0x01d4:
            androidx.constraintlayout.a.a.e r3 = r0.f1535t
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 == 0) goto L_0x01e3
            androidx.constraintlayout.a.a.e r3 = r0.f1537v
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 != 0) goto L_0x01e3
            if (r6 == 0) goto L_0x01cf
            goto L_0x01c6
        L_0x01e3:
            androidx.constraintlayout.a.a.e r3 = r0.f1535t
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 != 0) goto L_0x0200
            androidx.constraintlayout.a.a.e r3 = r0.f1537v
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 == 0) goto L_0x0200
            if (r6 == 0) goto L_0x01fa
            androidx.constraintlayout.a.a.n r0 = r17.mo3069j()
            r2.mo3128a((androidx.constraintlayout.p019a.p020a.C0435m) r4, (int) r14, (androidx.constraintlayout.p019a.p020a.C0436n) r0)
            goto L_0x032b
        L_0x01fa:
            int r0 = -r1
            r2.mo3127a((androidx.constraintlayout.p019a.p020a.C0435m) r4, (int) r0)
            goto L_0x032b
        L_0x0200:
            androidx.constraintlayout.a.a.e r3 = r0.f1535t
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 == 0) goto L_0x032b
            androidx.constraintlayout.a.a.e r3 = r0.f1537v
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 == 0) goto L_0x032b
            if (r6 == 0) goto L_0x021c
            androidx.constraintlayout.a.a.n r3 = r17.mo3069j()
            r3.mo3139a(r2)
            androidx.constraintlayout.a.a.n r3 = r17.mo3067i()
            r3.mo3139a(r4)
        L_0x021c:
            float r3 = r0.f1476G
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x0230
            r2.mo3131b(r11)
            r4.mo3131b(r11)
            r2.mo3132b(r4, r13)
            r4.mo3132b(r2, r13)
            goto L_0x032b
        L_0x0230:
            r2.mo3131b(r15)
            r4.mo3131b(r15)
            int r3 = -r1
            float r3 = (float) r3
            r2.mo3132b(r4, r3)
            float r3 = (float) r1
            r4.mo3132b(r2, r3)
            r0.mo3072k(r1)
            int r1 = r0.f1484O
            if (r1 <= 0) goto L_0x032b
            goto L_0x02ae
        L_0x0247:
            androidx.constraintlayout.a.a.e r1 = r0.f1535t
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 != 0) goto L_0x0287
            androidx.constraintlayout.a.a.e r1 = r0.f1537v
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 != 0) goto L_0x0287
            r2.mo3131b(r8)
            r4.mo3131b(r8)
            if (r6 == 0) goto L_0x0263
            androidx.constraintlayout.a.a.n r1 = r17.mo3069j()
            r4.mo3128a((androidx.constraintlayout.p019a.p020a.C0435m) r2, (int) r8, (androidx.constraintlayout.p019a.p020a.C0436n) r1)
            goto L_0x026a
        L_0x0263:
            int r1 = r17.mo3085r()
            r4.mo3127a((androidx.constraintlayout.p019a.p020a.C0435m) r2, (int) r1)
        L_0x026a:
            androidx.constraintlayout.a.a.e r1 = r0.f1538w
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 == 0) goto L_0x032b
            androidx.constraintlayout.a.a.e r1 = r0.f1538w
            androidx.constraintlayout.a.a.m r1 = r1.mo3004a()
            r1.mo3131b(r8)
            androidx.constraintlayout.a.a.e r1 = r0.f1538w
            androidx.constraintlayout.a.a.m r1 = r1.mo3004a()
            int r0 = r0.f1484O
            int r0 = -r0
            r2.mo3125a((int) r8, (androidx.constraintlayout.p019a.p020a.C0435m) r1, (int) r0)
            goto L_0x032b
        L_0x0287:
            androidx.constraintlayout.a.a.e r1 = r0.f1535t
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 == 0) goto L_0x02bb
            androidx.constraintlayout.a.a.e r1 = r0.f1537v
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 != 0) goto L_0x02bb
            r2.mo3131b(r8)
            r4.mo3131b(r8)
            if (r6 == 0) goto L_0x02a3
            androidx.constraintlayout.a.a.n r1 = r17.mo3069j()
            r4.mo3128a((androidx.constraintlayout.p019a.p020a.C0435m) r2, (int) r8, (androidx.constraintlayout.p019a.p020a.C0436n) r1)
            goto L_0x02aa
        L_0x02a3:
            int r1 = r17.mo3085r()
            r4.mo3127a((androidx.constraintlayout.p019a.p020a.C0435m) r2, (int) r1)
        L_0x02aa:
            int r1 = r0.f1484O
            if (r1 <= 0) goto L_0x032b
        L_0x02ae:
            androidx.constraintlayout.a.a.e r1 = r0.f1538w
            androidx.constraintlayout.a.a.m r1 = r1.mo3004a()
            int r0 = r0.f1484O
            r1.mo3125a((int) r8, (androidx.constraintlayout.p019a.p020a.C0435m) r2, (int) r0)
            goto L_0x032b
        L_0x02bb:
            androidx.constraintlayout.a.a.e r1 = r0.f1535t
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 != 0) goto L_0x02e4
            androidx.constraintlayout.a.a.e r1 = r0.f1537v
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 == 0) goto L_0x02e4
            r2.mo3131b(r8)
            r4.mo3131b(r8)
            if (r6 == 0) goto L_0x02d7
            androidx.constraintlayout.a.a.n r1 = r17.mo3069j()
            r2.mo3128a((androidx.constraintlayout.p019a.p020a.C0435m) r4, (int) r14, (androidx.constraintlayout.p019a.p020a.C0436n) r1)
            goto L_0x02df
        L_0x02d7:
            int r1 = r17.mo3085r()
            int r1 = -r1
            r2.mo3127a((androidx.constraintlayout.p019a.p020a.C0435m) r4, (int) r1)
        L_0x02df:
            int r1 = r0.f1484O
            if (r1 <= 0) goto L_0x032b
            goto L_0x02ae
        L_0x02e4:
            androidx.constraintlayout.a.a.e r1 = r0.f1535t
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 == 0) goto L_0x032b
            androidx.constraintlayout.a.a.e r1 = r0.f1537v
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            if (r1 == 0) goto L_0x032b
            r2.mo3131b(r15)
            r4.mo3131b(r15)
            if (r6 == 0) goto L_0x0315
            androidx.constraintlayout.a.a.n r1 = r17.mo3069j()
            r2.mo3133b(r4, r14, r1)
            androidx.constraintlayout.a.a.n r1 = r17.mo3069j()
            r4.mo3133b(r2, r8, r1)
            androidx.constraintlayout.a.a.n r1 = r17.mo3069j()
            r1.mo3139a(r2)
            androidx.constraintlayout.a.a.n r1 = r17.mo3067i()
            r1.mo3139a(r4)
            goto L_0x0326
        L_0x0315:
            int r1 = r17.mo3085r()
            int r1 = -r1
            float r1 = (float) r1
            r2.mo3132b(r4, r1)
            int r1 = r17.mo3085r()
            float r1 = (float) r1
            r4.mo3132b(r2, r1)
        L_0x0326:
            int r1 = r0.f1484O
            if (r1 <= 0) goto L_0x032b
            goto L_0x02ae
        L_0x032b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.p020a.C0433k.m1741a(int, androidx.constraintlayout.a.a.f):void");
    }

    /* renamed from: a */
    static void m1742a(C0425f fVar, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        fVar.f1470A[i3].mo3004a().f1599e = fVar.mo3071k().f1534s.mo3004a();
        fVar.f1470A[i3].mo3004a().f1600f = (float) i2;
        fVar.f1470A[i3].mo3004a().f1610i = 1;
        fVar.f1470A[i4].mo3004a().f1599e = fVar.f1470A[i3].mo3004a();
        fVar.f1470A[i4].mo3004a().f1600f = (float) fVar.mo3061f(i);
        fVar.f1470A[i4].mo3004a().f1610i = 1;
    }

    /* renamed from: a */
    static void m1743a(C0428g gVar, C0444e eVar, C0425f fVar) {
        if (gVar.f1472C[0] != C0425f.C0427a.WRAP_CONTENT && fVar.f1472C[0] == C0425f.C0427a.MATCH_PARENT) {
            int i = fVar.f1534s.f1444d;
            int p = gVar.mo3081p() - fVar.f1536u.f1444d;
            fVar.f1534s.f1446f = eVar.mo3179a((Object) fVar.f1534s);
            fVar.f1536u.f1446f = eVar.mo3179a((Object) fVar.f1536u);
            eVar.mo3184a(fVar.f1534s.f1446f, i);
            eVar.mo3184a(fVar.f1536u.f1446f, p);
            fVar.f1495a = 2;
            fVar.mo3051c(i, p);
        }
        if (gVar.f1472C[1] != C0425f.C0427a.WRAP_CONTENT && fVar.f1472C[1] == C0425f.C0427a.MATCH_PARENT) {
            int i2 = fVar.f1535t.f1444d;
            int r = gVar.mo3085r() - fVar.f1537v.f1444d;
            fVar.f1535t.f1446f = eVar.mo3179a((Object) fVar.f1535t);
            fVar.f1537v.f1446f = eVar.mo3179a((Object) fVar.f1537v);
            eVar.mo3184a(fVar.f1535t.f1446f, i2);
            eVar.mo3184a(fVar.f1537v.f1446f, r);
            if (fVar.f1484O > 0 || fVar.mo3073l() == 8) {
                fVar.f1538w.f1446f = eVar.mo3179a((Object) fVar.f1538w);
                eVar.mo3184a(fVar.f1538w.f1446f, fVar.f1484O + i2);
            }
            fVar.f1517b = 2;
            fVar.mo3056d(i2, r);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003d A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m1744a(androidx.constraintlayout.p019a.p020a.C0425f r4, int r5) {
        /*
            androidx.constraintlayout.a.a.f$a[] r0 = r4.f1472C
            r0 = r0[r5]
            androidx.constraintlayout.a.a.f$a r1 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r4.f1476G
            r1 = 0
            r3 = 1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.a.a.f$a[] r4 = r4.f1472C
            if (r5 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            r4 = r4[r3]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x001e
        L_0x001e:
            return r2
        L_0x001f:
            if (r5 != 0) goto L_0x002f
            int r5 = r4.f1520e
            if (r5 == 0) goto L_0x0026
            return r2
        L_0x0026:
            int r5 = r4.f1523h
            if (r5 != 0) goto L_0x002e
            int r4 = r4.f1524i
            if (r4 == 0) goto L_0x003d
        L_0x002e:
            return r2
        L_0x002f:
            int r5 = r4.f1521f
            if (r5 == 0) goto L_0x0034
            return r2
        L_0x0034:
            int r5 = r4.f1526k
            if (r5 != 0) goto L_0x003e
            int r4 = r4.f1527l
            if (r4 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            return r3
        L_0x003e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.p020a.C0433k.m1744a(androidx.constraintlayout.a.a.f, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r7.f1494Z == 2) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r7.f1496aa == 2) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0109  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m1745a(androidx.constraintlayout.p019a.p020a.C0428g r23, androidx.constraintlayout.p019a.C0444e r24, int r25, int r26, androidx.constraintlayout.p019a.p020a.C0419d r27) {
        /*
            r0 = r24
            r1 = r25
            r2 = r27
            androidx.constraintlayout.a.a.f r3 = r2.f1424a
            androidx.constraintlayout.a.a.f r4 = r2.f1426c
            androidx.constraintlayout.a.a.f r5 = r2.f1425b
            androidx.constraintlayout.a.a.f r6 = r2.f1427d
            androidx.constraintlayout.a.a.f r7 = r2.f1428e
            float r8 = r2.f1434k
            androidx.constraintlayout.a.a.f r9 = r2.f1429f
            androidx.constraintlayout.a.a.f r2 = r2.f1430g
            r9 = r23
            androidx.constraintlayout.a.a.f$a[] r2 = r9.f1472C
            r2 = r2[r1]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            r2 = 2
            r10 = 1
            if (r1 != 0) goto L_0x0038
            int r11 = r7.f1494Z
            if (r11 != 0) goto L_0x0028
            r11 = 1
            goto L_0x0029
        L_0x0028:
            r11 = 0
        L_0x0029:
            int r12 = r7.f1494Z
            if (r12 != r10) goto L_0x002f
            r12 = 1
            goto L_0x0030
        L_0x002f:
            r12 = 0
        L_0x0030:
            int r7 = r7.f1494Z
            if (r7 != r2) goto L_0x0036
        L_0x0034:
            r2 = 1
            goto L_0x004b
        L_0x0036:
            r2 = 0
            goto L_0x004b
        L_0x0038:
            int r11 = r7.f1496aa
            if (r11 != 0) goto L_0x003e
            r11 = 1
            goto L_0x003f
        L_0x003e:
            r11 = 0
        L_0x003f:
            int r12 = r7.f1496aa
            if (r12 != r10) goto L_0x0045
            r12 = 1
            goto L_0x0046
        L_0x0045:
            r12 = 0
        L_0x0046:
            int r7 = r7.f1496aa
            if (r7 != r2) goto L_0x0036
            goto L_0x0034
        L_0x004b:
            r14 = r3
            r10 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0053:
            r7 = 8
            if (r13 != 0) goto L_0x010c
            int r9 = r14.mo3073l()
            if (r9 == r7) goto L_0x00a1
            int r15 = r15 + 1
            if (r1 != 0) goto L_0x0066
            int r9 = r14.mo3081p()
            goto L_0x006a
        L_0x0066:
            int r9 = r14.mo3085r()
        L_0x006a:
            float r9 = (float) r9
            float r16 = r16 + r9
            if (r14 == r5) goto L_0x007a
            androidx.constraintlayout.a.a.e[] r9 = r14.f1470A
            r9 = r9[r26]
            int r9 = r9.mo3012e()
            float r9 = (float) r9
            float r16 = r16 + r9
        L_0x007a:
            if (r14 == r6) goto L_0x0089
            androidx.constraintlayout.a.a.e[] r9 = r14.f1470A
            int r19 = r26 + 1
            r9 = r9[r19]
            int r9 = r9.mo3012e()
            float r9 = (float) r9
            float r16 = r16 + r9
        L_0x0089:
            androidx.constraintlayout.a.a.e[] r9 = r14.f1470A
            r9 = r9[r26]
            int r9 = r9.mo3012e()
            float r9 = (float) r9
            float r17 = r17 + r9
            androidx.constraintlayout.a.a.e[] r9 = r14.f1470A
            int r19 = r26 + 1
            r9 = r9[r19]
            int r9 = r9.mo3012e()
            float r9 = (float) r9
            float r17 = r17 + r9
        L_0x00a1:
            androidx.constraintlayout.a.a.e[] r9 = r14.f1470A
            r9 = r9[r26]
            int r9 = r14.mo3073l()
            if (r9 == r7) goto L_0x00df
            androidx.constraintlayout.a.a.f$a[] r7 = r14.f1472C
            r7 = r7[r1]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            if (r7 != r9) goto L_0x00df
            int r10 = r10 + 1
            if (r1 != 0) goto L_0x00c7
            int r7 = r14.f1520e
            if (r7 == 0) goto L_0x00bd
            r7 = 0
            return r7
        L_0x00bd:
            r7 = 0
            int r9 = r14.f1523h
            if (r9 != 0) goto L_0x00c6
            int r9 = r14.f1524i
            if (r9 == 0) goto L_0x00d6
        L_0x00c6:
            return r7
        L_0x00c7:
            r7 = 0
            int r9 = r14.f1521f
            if (r9 == 0) goto L_0x00cd
            return r7
        L_0x00cd:
            int r9 = r14.f1526k
            if (r9 != 0) goto L_0x00de
            int r9 = r14.f1527l
            if (r9 == 0) goto L_0x00d6
            goto L_0x00de
        L_0x00d6:
            float r9 = r14.f1476G
            r18 = 0
            int r9 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r9 == 0) goto L_0x00df
        L_0x00de:
            return r7
        L_0x00df:
            androidx.constraintlayout.a.a.e[] r7 = r14.f1470A
            int r9 = r26 + 1
            r7 = r7[r9]
            androidx.constraintlayout.a.a.e r7 = r7.f1443c
            if (r7 == 0) goto L_0x0101
            androidx.constraintlayout.a.a.f r7 = r7.f1441a
            androidx.constraintlayout.a.a.e[] r9 = r7.f1470A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            if (r9 == 0) goto L_0x0101
            androidx.constraintlayout.a.a.e[] r9 = r7.f1470A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.e r9 = r9.f1443c
            androidx.constraintlayout.a.a.f r9 = r9.f1441a
            if (r9 == r14) goto L_0x00fe
            goto L_0x0101
        L_0x00fe:
            r19 = r7
            goto L_0x0103
        L_0x0101:
            r19 = 0
        L_0x0103:
            if (r19 == 0) goto L_0x0109
            r14 = r19
            goto L_0x0053
        L_0x0109:
            r13 = 1
            goto L_0x0053
        L_0x010c:
            androidx.constraintlayout.a.a.e[] r9 = r3.f1470A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.m r9 = r9.mo3004a()
            androidx.constraintlayout.a.a.e[] r13 = r4.f1470A
            int r19 = r26 + 1
            r13 = r13[r19]
            androidx.constraintlayout.a.a.m r13 = r13.mo3004a()
            androidx.constraintlayout.a.a.m r7 = r9.f1597c
            if (r7 == 0) goto L_0x0390
            androidx.constraintlayout.a.a.m r7 = r13.f1597c
            if (r7 != 0) goto L_0x0128
            goto L_0x0390
        L_0x0128:
            androidx.constraintlayout.a.a.m r7 = r9.f1597c
            int r7 = r7.f1610i
            r20 = r3
            r3 = 1
            if (r7 != r3) goto L_0x038e
            androidx.constraintlayout.a.a.m r7 = r13.f1597c
            int r7 = r7.f1610i
            if (r7 == r3) goto L_0x0139
            goto L_0x038e
        L_0x0139:
            if (r10 <= 0) goto L_0x013f
            if (r10 == r15) goto L_0x013f
            r3 = 0
            return r3
        L_0x013f:
            if (r2 != 0) goto L_0x0148
            if (r11 != 0) goto L_0x0148
            if (r12 == 0) goto L_0x0146
            goto L_0x0148
        L_0x0146:
            r7 = 0
            goto L_0x0161
        L_0x0148:
            if (r5 == 0) goto L_0x0154
            androidx.constraintlayout.a.a.e[] r3 = r5.f1470A
            r3 = r3[r26]
            int r3 = r3.mo3012e()
            float r7 = (float) r3
            goto L_0x0155
        L_0x0154:
            r7 = 0
        L_0x0155:
            if (r6 == 0) goto L_0x0161
            androidx.constraintlayout.a.a.e[] r3 = r6.f1470A
            r3 = r3[r19]
            int r3 = r3.mo3012e()
            float r3 = (float) r3
            float r7 = r7 + r3
        L_0x0161:
            androidx.constraintlayout.a.a.m r3 = r9.f1597c
            float r3 = r3.f1600f
            androidx.constraintlayout.a.a.m r6 = r13.f1597c
            float r6 = r6.f1600f
            int r13 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r13 >= 0) goto L_0x016f
            float r6 = r6 - r3
            goto L_0x0171
        L_0x016f:
            float r6 = r3 - r6
        L_0x0171:
            float r6 = r6 - r16
            r21 = 1
            if (r10 <= 0) goto L_0x0227
            if (r10 != r15) goto L_0x0227
            androidx.constraintlayout.a.a.f r2 = r14.mo3071k()
            if (r2 == 0) goto L_0x018d
            androidx.constraintlayout.a.a.f r2 = r14.mo3071k()
            androidx.constraintlayout.a.a.f$a[] r2 = r2.f1472C
            r2 = r2[r1]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r2 != r5) goto L_0x018d
            r2 = 0
            return r2
        L_0x018d:
            float r6 = r6 + r16
            float r6 = r6 - r17
            r2 = r20
        L_0x0193:
            if (r2 == 0) goto L_0x0225
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.p019a.C0444e.f1630g
            if (r5 == 0) goto L_0x01b1
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r11 = r5.f1649B
            long r11 = r11 - r21
            r5.f1649B = r11
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r11 = r5.f1670s
            long r11 = r11 + r21
            r5.f1670s = r11
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r11 = r5.f1676y
            long r11 = r11 + r21
            r5.f1676y = r11
        L_0x01b1:
            androidx.constraintlayout.a.a.f[] r5 = r2.f1501af
            r5 = r5[r1]
            if (r5 != 0) goto L_0x01b9
            if (r2 != r4) goto L_0x0222
        L_0x01b9:
            float r7 = (float) r10
            float r7 = r6 / r7
            r11 = 0
            int r12 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x01d4
            float[] r7 = r2.f1499ad
            r7 = r7[r1]
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x01cd
            r7 = 0
            goto L_0x01d4
        L_0x01cd:
            float[] r7 = r2.f1499ad
            r7 = r7[r1]
            float r7 = r7 * r6
            float r7 = r7 / r8
        L_0x01d4:
            int r11 = r2.mo3073l()
            r12 = 8
            if (r11 != r12) goto L_0x01dd
            r7 = 0
        L_0x01dd:
            androidx.constraintlayout.a.a.e[] r11 = r2.f1470A
            r11 = r11[r26]
            int r11 = r11.mo3012e()
            float r11 = (float) r11
            float r3 = r3 + r11
            androidx.constraintlayout.a.a.e[] r11 = r2.f1470A
            r11 = r11[r26]
            androidx.constraintlayout.a.a.m r11 = r11.mo3004a()
            androidx.constraintlayout.a.a.m r12 = r9.f1599e
            r11.mo3126a((androidx.constraintlayout.p019a.p020a.C0435m) r12, (float) r3)
            androidx.constraintlayout.a.a.e[] r11 = r2.f1470A
            r11 = r11[r19]
            androidx.constraintlayout.a.a.m r11 = r11.mo3004a()
            androidx.constraintlayout.a.a.m r12 = r9.f1599e
            float r3 = r3 + r7
            r11.mo3126a((androidx.constraintlayout.p019a.p020a.C0435m) r12, (float) r3)
            androidx.constraintlayout.a.a.e[] r7 = r2.f1470A
            r7 = r7[r26]
            androidx.constraintlayout.a.a.m r7 = r7.mo3004a()
            r7.mo3129a((androidx.constraintlayout.p019a.C0444e) r0)
            androidx.constraintlayout.a.a.e[] r7 = r2.f1470A
            r7 = r7[r19]
            androidx.constraintlayout.a.a.m r7 = r7.mo3004a()
            r7.mo3129a((androidx.constraintlayout.p019a.C0444e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.f1470A
            r2 = r2[r19]
            int r2 = r2.mo3012e()
            float r2 = (float) r2
            float r3 = r3 + r2
        L_0x0222:
            r2 = r5
            goto L_0x0193
        L_0x0225:
            r2 = 1
            return r2
        L_0x0227:
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x022f
            r2 = 1
            r11 = 0
            r12 = 0
        L_0x022f:
            if (r2 == 0) goto L_0x02b4
            float r6 = r6 - r7
            r2 = r20
            float r5 = r2.mo3063g(r1)
            float r6 = r6 * r5
            float r3 = r3 + r6
        L_0x023b:
            if (r2 == 0) goto L_0x02bb
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.p019a.C0444e.f1630g
            if (r5 == 0) goto L_0x0259
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r6 = r5.f1649B
            long r6 = r6 - r21
            r5.f1649B = r6
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r6 = r5.f1670s
            long r6 = r6 + r21
            r5.f1670s = r6
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r6 = r5.f1676y
            long r6 = r6 + r21
            r5.f1676y = r6
        L_0x0259:
            androidx.constraintlayout.a.a.f[] r5 = r2.f1501af
            r5 = r5[r1]
            if (r5 != 0) goto L_0x0261
            if (r2 != r4) goto L_0x02b2
        L_0x0261:
            if (r1 != 0) goto L_0x0268
            int r6 = r2.mo3081p()
            goto L_0x026c
        L_0x0268:
            int r6 = r2.mo3085r()
        L_0x026c:
            float r6 = (float) r6
            androidx.constraintlayout.a.a.e[] r7 = r2.f1470A
            r7 = r7[r26]
            int r7 = r7.mo3012e()
            float r7 = (float) r7
            float r3 = r3 + r7
            androidx.constraintlayout.a.a.e[] r7 = r2.f1470A
            r7 = r7[r26]
            androidx.constraintlayout.a.a.m r7 = r7.mo3004a()
            androidx.constraintlayout.a.a.m r8 = r9.f1599e
            r7.mo3126a((androidx.constraintlayout.p019a.p020a.C0435m) r8, (float) r3)
            androidx.constraintlayout.a.a.e[] r7 = r2.f1470A
            r7 = r7[r19]
            androidx.constraintlayout.a.a.m r7 = r7.mo3004a()
            androidx.constraintlayout.a.a.m r8 = r9.f1599e
            float r3 = r3 + r6
            r7.mo3126a((androidx.constraintlayout.p019a.p020a.C0435m) r8, (float) r3)
            androidx.constraintlayout.a.a.e[] r6 = r2.f1470A
            r6 = r6[r26]
            androidx.constraintlayout.a.a.m r6 = r6.mo3004a()
            r6.mo3129a((androidx.constraintlayout.p019a.C0444e) r0)
            androidx.constraintlayout.a.a.e[] r6 = r2.f1470A
            r6 = r6[r19]
            androidx.constraintlayout.a.a.m r6 = r6.mo3004a()
            r6.mo3129a((androidx.constraintlayout.p019a.C0444e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.f1470A
            r2 = r2[r19]
            int r2 = r2.mo3012e()
            float r2 = (float) r2
            float r3 = r3 + r2
        L_0x02b2:
            r2 = r5
            goto L_0x023b
        L_0x02b4:
            r2 = r20
            if (r11 != 0) goto L_0x02be
            if (r12 == 0) goto L_0x02bb
            goto L_0x02be
        L_0x02bb:
            r0 = 1
            goto L_0x038d
        L_0x02be:
            if (r11 == 0) goto L_0x02c2
        L_0x02c0:
            float r6 = r6 - r7
            goto L_0x02c5
        L_0x02c2:
            if (r12 == 0) goto L_0x02c5
            goto L_0x02c0
        L_0x02c5:
            int r7 = r15 + 1
            float r7 = (float) r7
            float r7 = r6 / r7
            if (r12 == 0) goto L_0x02d7
            r8 = 1
            if (r15 <= r8) goto L_0x02d3
            int r7 = r15 + -1
            float r7 = (float) r7
            goto L_0x02d5
        L_0x02d3:
            r7 = 1073741824(0x40000000, float:2.0)
        L_0x02d5:
            float r7 = r6 / r7
        L_0x02d7:
            int r6 = r2.mo3073l()
            r8 = 8
            if (r6 == r8) goto L_0x02e2
            float r6 = r3 + r7
            goto L_0x02e3
        L_0x02e2:
            r6 = r3
        L_0x02e3:
            if (r12 == 0) goto L_0x02f2
            r8 = 1
            if (r15 <= r8) goto L_0x02f2
            androidx.constraintlayout.a.a.e[] r6 = r5.f1470A
            r6 = r6[r26]
            int r6 = r6.mo3012e()
            float r6 = (float) r6
            float r6 = r6 + r3
        L_0x02f2:
            if (r11 == 0) goto L_0x0300
            if (r5 == 0) goto L_0x0300
            androidx.constraintlayout.a.a.e[] r3 = r5.f1470A
            r3 = r3[r26]
            int r3 = r3.mo3012e()
            float r3 = (float) r3
            float r6 = r6 + r3
        L_0x0300:
            if (r2 == 0) goto L_0x02bb
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.p019a.C0444e.f1630g
            if (r3 == 0) goto L_0x031e
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r10 = r3.f1649B
            long r10 = r10 - r21
            r3.f1649B = r10
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r10 = r3.f1670s
            long r10 = r10 + r21
            r3.f1670s = r10
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.p019a.C0444e.f1630g
            long r10 = r3.f1676y
            long r10 = r10 + r21
            r3.f1676y = r10
        L_0x031e:
            androidx.constraintlayout.a.a.f[] r3 = r2.f1501af
            r3 = r3[r1]
            if (r3 != 0) goto L_0x032a
            if (r2 != r4) goto L_0x0327
            goto L_0x032a
        L_0x0327:
            r8 = 8
            goto L_0x038a
        L_0x032a:
            if (r1 != 0) goto L_0x0331
            int r8 = r2.mo3081p()
            goto L_0x0335
        L_0x0331:
            int r8 = r2.mo3085r()
        L_0x0335:
            float r8 = (float) r8
            if (r2 == r5) goto L_0x0342
            androidx.constraintlayout.a.a.e[] r10 = r2.f1470A
            r10 = r10[r26]
            int r10 = r10.mo3012e()
            float r10 = (float) r10
            float r6 = r6 + r10
        L_0x0342:
            androidx.constraintlayout.a.a.e[] r10 = r2.f1470A
            r10 = r10[r26]
            androidx.constraintlayout.a.a.m r10 = r10.mo3004a()
            androidx.constraintlayout.a.a.m r11 = r9.f1599e
            r10.mo3126a((androidx.constraintlayout.p019a.p020a.C0435m) r11, (float) r6)
            androidx.constraintlayout.a.a.e[] r10 = r2.f1470A
            r10 = r10[r19]
            androidx.constraintlayout.a.a.m r10 = r10.mo3004a()
            androidx.constraintlayout.a.a.m r11 = r9.f1599e
            float r12 = r6 + r8
            r10.mo3126a((androidx.constraintlayout.p019a.p020a.C0435m) r11, (float) r12)
            androidx.constraintlayout.a.a.e[] r10 = r2.f1470A
            r10 = r10[r26]
            androidx.constraintlayout.a.a.m r10 = r10.mo3004a()
            r10.mo3129a((androidx.constraintlayout.p019a.C0444e) r0)
            androidx.constraintlayout.a.a.e[] r10 = r2.f1470A
            r10 = r10[r19]
            androidx.constraintlayout.a.a.m r10 = r10.mo3004a()
            r10.mo3129a((androidx.constraintlayout.p019a.C0444e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.f1470A
            r2 = r2[r19]
            int r2 = r2.mo3012e()
            float r2 = (float) r2
            float r8 = r8 + r2
            float r6 = r6 + r8
            if (r3 == 0) goto L_0x0327
            int r2 = r3.mo3073l()
            r8 = 8
            if (r2 == r8) goto L_0x038a
            float r6 = r6 + r7
        L_0x038a:
            r2 = r3
            goto L_0x0300
        L_0x038d:
            return r0
        L_0x038e:
            r0 = 0
            return r0
        L_0x0390:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.p020a.C0433k.m1745a(androidx.constraintlayout.a.a.g, androidx.constraintlayout.a.e, int, int, androidx.constraintlayout.a.a.d):boolean");
    }
}
