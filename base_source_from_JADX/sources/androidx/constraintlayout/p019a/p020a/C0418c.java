package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.C0444e;

/* renamed from: androidx.constraintlayout.a.a.c */
class C0418c {
    /* renamed from: a */
    static void m1594a(C0428g gVar, C0444e eVar, int i) {
        int i2;
        C0419d[] dVarArr;
        int i3;
        if (i == 0) {
            int i4 = gVar.f1559an;
            dVarArr = gVar.f1562aq;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            int i5 = gVar.f1560ao;
            i2 = i5;
            dVarArr = gVar.f1561ap;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            C0419d dVar = dVarArr[i6];
            dVar.mo3003a();
            if (!gVar.mo3113u(4) || !C0433k.m1745a(gVar, eVar, i, i3, dVar)) {
                m1595a(gVar, eVar, i, i3, dVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.f1494Z == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.f1496aa == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x047c  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04b1  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x04d6  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04e1  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x038b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0196  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m1595a(androidx.constraintlayout.p019a.p020a.C0428g r35, androidx.constraintlayout.p019a.C0444e r36, int r37, int r38, androidx.constraintlayout.p019a.p020a.C0419d r39) {
        /*
            r0 = r35
            r9 = r36
            r1 = r39
            androidx.constraintlayout.a.a.f r10 = r1.f1424a
            androidx.constraintlayout.a.a.f r11 = r1.f1426c
            androidx.constraintlayout.a.a.f r12 = r1.f1425b
            androidx.constraintlayout.a.a.f r13 = r1.f1427d
            androidx.constraintlayout.a.a.f r2 = r1.f1428e
            float r3 = r1.f1434k
            androidx.constraintlayout.a.a.f r4 = r1.f1429f
            androidx.constraintlayout.a.a.f r4 = r1.f1430g
            androidx.constraintlayout.a.a.f$a[] r4 = r0.f1472C
            r4 = r4[r37]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x0021
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r37 != 0) goto L_0x0038
            int r8 = r2.f1494Z
            if (r8 != 0) goto L_0x002b
            r8 = 1
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r14 = r2.f1494Z
            if (r14 != r7) goto L_0x0032
            r14 = 1
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            int r15 = r2.f1494Z
            if (r15 != r5) goto L_0x004c
            goto L_0x004a
        L_0x0038:
            int r8 = r2.f1496aa
            if (r8 != 0) goto L_0x003e
            r8 = 1
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            int r14 = r2.f1496aa
            if (r14 != r7) goto L_0x0045
            r14 = 1
            goto L_0x0046
        L_0x0045:
            r14 = 0
        L_0x0046:
            int r15 = r2.f1496aa
            if (r15 != r5) goto L_0x004c
        L_0x004a:
            r5 = 1
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            r15 = r8
            r8 = r10
            r16 = r14
            r14 = r5
            r5 = 0
        L_0x0053:
            r21 = 0
            if (r5 != 0) goto L_0x012e
            androidx.constraintlayout.a.a.e[] r7 = r8.f1470A
            r7 = r7[r38]
            if (r4 != 0) goto L_0x0063
            if (r14 == 0) goto L_0x0060
            goto L_0x0063
        L_0x0060:
            r23 = 4
            goto L_0x0065
        L_0x0063:
            r23 = 1
        L_0x0065:
            int r24 = r7.mo3012e()
            androidx.constraintlayout.a.a.e r6 = r7.f1443c
            if (r6 == 0) goto L_0x0077
            if (r8 == r10) goto L_0x0077
            androidx.constraintlayout.a.a.e r6 = r7.f1443c
            int r6 = r6.mo3012e()
            int r24 = r24 + r6
        L_0x0077:
            r6 = r24
            if (r14 == 0) goto L_0x0085
            if (r8 == r10) goto L_0x0085
            if (r8 == r12) goto L_0x0085
            r24 = r3
            r23 = r5
            r3 = 6
            goto L_0x0095
        L_0x0085:
            if (r15 == 0) goto L_0x008f
            if (r4 == 0) goto L_0x008f
            r24 = r3
            r23 = r5
            r3 = 4
            goto L_0x0095
        L_0x008f:
            r24 = r3
            r3 = r23
            r23 = r5
        L_0x0095:
            androidx.constraintlayout.a.a.e r5 = r7.f1443c
            if (r5 == 0) goto L_0x00c2
            if (r8 != r12) goto L_0x00aa
            androidx.constraintlayout.a.h r5 = r7.f1446f
            r25 = r15
            androidx.constraintlayout.a.a.e r15 = r7.f1443c
            androidx.constraintlayout.a.h r15 = r15.f1446f
            r26 = r2
            r2 = 5
            r9.mo3186a((androidx.constraintlayout.p019a.C0450h) r5, (androidx.constraintlayout.p019a.C0450h) r15, (int) r6, (int) r2)
            goto L_0x00b8
        L_0x00aa:
            r26 = r2
            r25 = r15
            androidx.constraintlayout.a.h r2 = r7.f1446f
            androidx.constraintlayout.a.a.e r5 = r7.f1443c
            androidx.constraintlayout.a.h r5 = r5.f1446f
            r15 = 6
            r9.mo3186a((androidx.constraintlayout.p019a.C0450h) r2, (androidx.constraintlayout.p019a.C0450h) r5, (int) r6, (int) r15)
        L_0x00b8:
            androidx.constraintlayout.a.h r2 = r7.f1446f
            androidx.constraintlayout.a.a.e r5 = r7.f1443c
            androidx.constraintlayout.a.h r5 = r5.f1446f
            r9.mo3194c(r2, r5, r6, r3)
            goto L_0x00c6
        L_0x00c2:
            r26 = r2
            r25 = r15
        L_0x00c6:
            if (r4 == 0) goto L_0x00fd
            int r2 = r8.mo3073l()
            r3 = 8
            if (r2 == r3) goto L_0x00ec
            androidx.constraintlayout.a.a.f$a[] r2 = r8.f1472C
            r2 = r2[r37]
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00ec
            androidx.constraintlayout.a.a.e[] r2 = r8.f1470A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.h r2 = r2.f1446f
            androidx.constraintlayout.a.a.e[] r3 = r8.f1470A
            r3 = r3[r38]
            androidx.constraintlayout.a.h r3 = r3.f1446f
            r5 = 0
            r6 = 5
            r9.mo3186a((androidx.constraintlayout.p019a.C0450h) r2, (androidx.constraintlayout.p019a.C0450h) r3, (int) r5, (int) r6)
            goto L_0x00ed
        L_0x00ec:
            r5 = 0
        L_0x00ed:
            androidx.constraintlayout.a.a.e[] r2 = r8.f1470A
            r2 = r2[r38]
            androidx.constraintlayout.a.h r2 = r2.f1446f
            androidx.constraintlayout.a.a.e[] r3 = r0.f1470A
            r3 = r3[r38]
            androidx.constraintlayout.a.h r3 = r3.f1446f
            r6 = 6
            r9.mo3186a((androidx.constraintlayout.p019a.C0450h) r2, (androidx.constraintlayout.p019a.C0450h) r3, (int) r5, (int) r6)
        L_0x00fd:
            androidx.constraintlayout.a.a.e[] r2 = r8.f1470A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e r2 = r2.f1443c
            if (r2 == 0) goto L_0x011e
            androidx.constraintlayout.a.a.f r2 = r2.f1441a
            androidx.constraintlayout.a.a.e[] r3 = r2.f1470A
            r3 = r3[r38]
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 == 0) goto L_0x011e
            androidx.constraintlayout.a.a.e[] r3 = r2.f1470A
            r3 = r3[r38]
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            androidx.constraintlayout.a.a.f r3 = r3.f1441a
            if (r3 == r8) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r21 = r2
        L_0x011e:
            if (r21 == 0) goto L_0x0125
            r8 = r21
            r5 = r23
            goto L_0x0126
        L_0x0125:
            r5 = 1
        L_0x0126:
            r3 = r24
            r15 = r25
            r2 = r26
            goto L_0x0053
        L_0x012e:
            r26 = r2
            r24 = r3
            r25 = r15
            if (r13 == 0) goto L_0x0158
            androidx.constraintlayout.a.a.e[] r2 = r11.f1470A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e r2 = r2.f1443c
            if (r2 == 0) goto L_0x0158
            androidx.constraintlayout.a.a.e[] r2 = r13.f1470A
            r2 = r2[r3]
            androidx.constraintlayout.a.h r5 = r2.f1446f
            androidx.constraintlayout.a.a.e[] r6 = r11.f1470A
            r3 = r6[r3]
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            androidx.constraintlayout.a.h r3 = r3.f1446f
            int r2 = r2.mo3012e()
            int r2 = -r2
            r6 = 5
            r9.mo3191b(r5, r3, r2, r6)
            goto L_0x0159
        L_0x0158:
            r6 = 5
        L_0x0159:
            if (r4 == 0) goto L_0x0175
            androidx.constraintlayout.a.a.e[] r0 = r0.f1470A
            int r2 = r38 + 1
            r0 = r0[r2]
            androidx.constraintlayout.a.h r0 = r0.f1446f
            androidx.constraintlayout.a.a.e[] r3 = r11.f1470A
            r3 = r3[r2]
            androidx.constraintlayout.a.h r3 = r3.f1446f
            androidx.constraintlayout.a.a.e[] r4 = r11.f1470A
            r2 = r4[r2]
            int r2 = r2.mo3012e()
            r4 = 6
            r9.mo3186a((androidx.constraintlayout.p019a.C0450h) r0, (androidx.constraintlayout.p019a.C0450h) r3, (int) r2, (int) r4)
        L_0x0175:
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r0 = r1.f1431h
            if (r0 == 0) goto L_0x022d
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x022d
            boolean r4 = r1.f1435l
            if (r4 == 0) goto L_0x018c
            boolean r4 = r1.f1437n
            if (r4 != 0) goto L_0x018c
            int r4 = r1.f1433j
            float r4 = (float) r4
            goto L_0x018e
        L_0x018c:
            r4 = r24
        L_0x018e:
            r5 = 0
            r8 = r21
            r7 = 0
            r28 = 0
        L_0x0194:
            if (r7 >= r2) goto L_0x022d
            java.lang.Object r15 = r0.get(r7)
            androidx.constraintlayout.a.a.f r15 = (androidx.constraintlayout.p019a.p020a.C0425f) r15
            float[] r3 = r15.f1499ad
            r3 = r3[r37]
            int r23 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r23 >= 0) goto L_0x01c2
            boolean r3 = r1.f1437n
            if (r3 == 0) goto L_0x01be
            androidx.constraintlayout.a.a.e[] r3 = r15.f1470A
            int r23 = r38 + 1
            r3 = r3[r23]
            androidx.constraintlayout.a.h r3 = r3.f1446f
            androidx.constraintlayout.a.a.e[] r15 = r15.f1470A
            r15 = r15[r38]
            androidx.constraintlayout.a.h r15 = r15.f1446f
            r5 = 4
            r6 = 0
            r9.mo3194c(r3, r15, r6, r5)
            r5 = 0
            r6 = 6
            goto L_0x01db
        L_0x01be:
            r5 = 4
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01c3
        L_0x01c2:
            r5 = 4
        L_0x01c3:
            r6 = 0
            int r20 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r20 != 0) goto L_0x01e0
            androidx.constraintlayout.a.a.e[] r3 = r15.f1470A
            int r20 = r38 + 1
            r3 = r3[r20]
            androidx.constraintlayout.a.h r3 = r3.f1446f
            androidx.constraintlayout.a.a.e[] r15 = r15.f1470A
            r15 = r15[r38]
            androidx.constraintlayout.a.h r15 = r15.f1446f
            r5 = 0
            r6 = 6
            r9.mo3194c(r3, r15, r5, r6)
        L_0x01db:
            r24 = r0
            r22 = r2
            goto L_0x0222
        L_0x01e0:
            r5 = 0
            r6 = 6
            if (r8 == 0) goto L_0x021b
            androidx.constraintlayout.a.a.e[] r5 = r8.f1470A
            r5 = r5[r38]
            androidx.constraintlayout.a.h r5 = r5.f1446f
            androidx.constraintlayout.a.a.e[] r8 = r8.f1470A
            int r22 = r38 + 1
            r8 = r8[r22]
            androidx.constraintlayout.a.h r8 = r8.f1446f
            androidx.constraintlayout.a.a.e[] r6 = r15.f1470A
            r6 = r6[r38]
            androidx.constraintlayout.a.h r6 = r6.f1446f
            r24 = r0
            androidx.constraintlayout.a.a.e[] r0 = r15.f1470A
            r0 = r0[r22]
            androidx.constraintlayout.a.h r0 = r0.f1446f
            r22 = r2
            androidx.constraintlayout.a.b r2 = r36.mo3193c()
            r27 = r2
            r29 = r4
            r30 = r3
            r31 = r5
            r32 = r8
            r33 = r6
            r34 = r0
            r27.mo3151a((float) r28, (float) r29, (float) r30, (androidx.constraintlayout.p019a.C0450h) r31, (androidx.constraintlayout.p019a.C0450h) r32, (androidx.constraintlayout.p019a.C0450h) r33, (androidx.constraintlayout.p019a.C0450h) r34)
            r9.mo3181a((androidx.constraintlayout.p019a.C0441b) r2)
            goto L_0x021f
        L_0x021b:
            r24 = r0
            r22 = r2
        L_0x021f:
            r28 = r3
            r8 = r15
        L_0x0222:
            int r7 = r7 + 1
            r2 = r22
            r0 = r24
            r3 = 1
            r5 = 0
            r6 = 5
            goto L_0x0194
        L_0x022d:
            if (r12 == 0) goto L_0x0297
            if (r12 == r13) goto L_0x0233
            if (r14 == 0) goto L_0x0297
        L_0x0233:
            androidx.constraintlayout.a.a.e[] r0 = r10.f1470A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r11.f1470A
            int r2 = r38 + 1
            r1 = r1[r2]
            androidx.constraintlayout.a.a.e[] r3 = r10.f1470A
            r3 = r3[r38]
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 == 0) goto L_0x024e
            androidx.constraintlayout.a.a.e[] r3 = r10.f1470A
            r3 = r3[r38]
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            androidx.constraintlayout.a.h r3 = r3.f1446f
            goto L_0x0250
        L_0x024e:
            r3 = r21
        L_0x0250:
            androidx.constraintlayout.a.a.e[] r4 = r11.f1470A
            r4 = r4[r2]
            androidx.constraintlayout.a.a.e r4 = r4.f1443c
            if (r4 == 0) goto L_0x0262
            androidx.constraintlayout.a.a.e[] r4 = r11.f1470A
            r4 = r4[r2]
            androidx.constraintlayout.a.a.e r4 = r4.f1443c
            androidx.constraintlayout.a.h r4 = r4.f1446f
            r5 = r4
            goto L_0x0264
        L_0x0262:
            r5 = r21
        L_0x0264:
            if (r12 != r13) goto L_0x026e
            androidx.constraintlayout.a.a.e[] r0 = r12.f1470A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r12.f1470A
            r1 = r1[r2]
        L_0x026e:
            if (r3 == 0) goto L_0x04c2
            if (r5 == 0) goto L_0x04c2
            if (r37 != 0) goto L_0x0279
            r2 = r26
            float r2 = r2.f1487S
            goto L_0x027d
        L_0x0279:
            r2 = r26
            float r2 = r2.f1488T
        L_0x027d:
            r4 = r2
            int r6 = r0.mo3012e()
            int r7 = r1.mo3012e()
            androidx.constraintlayout.a.h r2 = r0.f1446f
            androidx.constraintlayout.a.h r8 = r1.f1446f
            r10 = 5
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.mo3185a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04c2
        L_0x0297:
            if (r25 == 0) goto L_0x038f
            if (r12 == 0) goto L_0x038f
            int r0 = r1.f1433j
            if (r0 <= 0) goto L_0x02a8
            int r0 = r1.f1432i
            int r1 = r1.f1433j
            if (r0 != r1) goto L_0x02a8
            r17 = 1
            goto L_0x02aa
        L_0x02a8:
            r17 = 0
        L_0x02aa:
            r14 = r12
            r15 = r14
        L_0x02ac:
            if (r14 == 0) goto L_0x04c2
            androidx.constraintlayout.a.a.f[] r0 = r14.f1501af
            r0 = r0[r37]
            r8 = r0
        L_0x02b3:
            if (r8 == 0) goto L_0x02c2
            int r0 = r8.mo3073l()
            r7 = 8
            if (r0 != r7) goto L_0x02c4
            androidx.constraintlayout.a.a.f[] r0 = r8.f1501af
            r8 = r0[r37]
            goto L_0x02b3
        L_0x02c2:
            r7 = 8
        L_0x02c4:
            if (r8 != 0) goto L_0x02d1
            if (r14 != r13) goto L_0x02c9
            goto L_0x02d1
        L_0x02c9:
            r18 = r8
            r19 = 6
            r20 = 4
            goto L_0x0382
        L_0x02d1:
            androidx.constraintlayout.a.a.e[] r0 = r14.f1470A
            r0 = r0[r38]
            androidx.constraintlayout.a.h r1 = r0.f1446f
            androidx.constraintlayout.a.a.e r2 = r0.f1443c
            if (r2 == 0) goto L_0x02e0
            androidx.constraintlayout.a.a.e r2 = r0.f1443c
            androidx.constraintlayout.a.h r2 = r2.f1446f
            goto L_0x02e2
        L_0x02e0:
            r2 = r21
        L_0x02e2:
            if (r15 == r14) goto L_0x02ed
            androidx.constraintlayout.a.a.e[] r2 = r15.f1470A
            int r3 = r38 + 1
            r2 = r2[r3]
        L_0x02ea:
            androidx.constraintlayout.a.h r2 = r2.f1446f
            goto L_0x0302
        L_0x02ed:
            if (r14 != r12) goto L_0x0302
            if (r15 != r14) goto L_0x0302
            androidx.constraintlayout.a.a.e[] r2 = r10.f1470A
            r2 = r2[r38]
            androidx.constraintlayout.a.a.e r2 = r2.f1443c
            if (r2 == 0) goto L_0x0300
            androidx.constraintlayout.a.a.e[] r2 = r10.f1470A
            r2 = r2[r38]
            androidx.constraintlayout.a.a.e r2 = r2.f1443c
            goto L_0x02ea
        L_0x0300:
            r2 = r21
        L_0x0302:
            int r0 = r0.mo3012e()
            androidx.constraintlayout.a.a.e[] r3 = r14.f1470A
            int r4 = r38 + 1
            r3 = r3[r4]
            int r3 = r3.mo3012e()
            if (r8 == 0) goto L_0x031f
            androidx.constraintlayout.a.a.e[] r5 = r8.f1470A
            r5 = r5[r38]
            androidx.constraintlayout.a.h r6 = r5.f1446f
            androidx.constraintlayout.a.a.e[] r7 = r14.f1470A
            r7 = r7[r4]
        L_0x031c:
            androidx.constraintlayout.a.h r7 = r7.f1446f
            goto L_0x0331
        L_0x031f:
            androidx.constraintlayout.a.a.e[] r5 = r11.f1470A
            r5 = r5[r4]
            androidx.constraintlayout.a.a.e r5 = r5.f1443c
            if (r5 == 0) goto L_0x032a
            androidx.constraintlayout.a.h r6 = r5.f1446f
            goto L_0x032c
        L_0x032a:
            r6 = r21
        L_0x032c:
            androidx.constraintlayout.a.a.e[] r7 = r14.f1470A
            r7 = r7[r4]
            goto L_0x031c
        L_0x0331:
            if (r5 == 0) goto L_0x0338
            int r5 = r5.mo3012e()
            int r3 = r3 + r5
        L_0x0338:
            if (r15 == 0) goto L_0x0343
            androidx.constraintlayout.a.a.e[] r5 = r15.f1470A
            r5 = r5[r4]
            int r5 = r5.mo3012e()
            int r0 = r0 + r5
        L_0x0343:
            if (r1 == 0) goto L_0x02c9
            if (r2 == 0) goto L_0x02c9
            if (r6 == 0) goto L_0x02c9
            if (r7 == 0) goto L_0x02c9
            if (r14 != r12) goto L_0x0355
            androidx.constraintlayout.a.a.e[] r0 = r12.f1470A
            r0 = r0[r38]
            int r0 = r0.mo3012e()
        L_0x0355:
            r5 = r0
            if (r14 != r13) goto L_0x0363
            androidx.constraintlayout.a.a.e[] r0 = r13.f1470A
            r0 = r0[r4]
            int r0 = r0.mo3012e()
            r18 = r0
            goto L_0x0365
        L_0x0363:
            r18 = r3
        L_0x0365:
            if (r17 == 0) goto L_0x036a
            r22 = 6
            goto L_0x036c
        L_0x036a:
            r22 = 4
        L_0x036c:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r36
            r3 = r5
            r20 = 4
            r5 = r6
            r23 = 6
            r6 = r7
            r19 = 6
            r7 = r18
            r18 = r8
            r8 = r22
            r0.mo3185a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0382:
            int r0 = r14.mo3073l()
            r8 = 8
            if (r0 == r8) goto L_0x038b
            r15 = r14
        L_0x038b:
            r14 = r18
            goto L_0x02ac
        L_0x038f:
            r8 = 8
            r19 = 6
            r20 = 4
            if (r16 == 0) goto L_0x04c2
            if (r12 == 0) goto L_0x04c2
            int r0 = r1.f1433j
            if (r0 <= 0) goto L_0x03a6
            int r0 = r1.f1432i
            int r1 = r1.f1433j
            if (r0 != r1) goto L_0x03a6
            r17 = 1
            goto L_0x03a8
        L_0x03a6:
            r17 = 0
        L_0x03a8:
            r14 = r12
            r15 = r14
        L_0x03aa:
            if (r14 == 0) goto L_0x0464
            androidx.constraintlayout.a.a.f[] r0 = r14.f1501af
            r0 = r0[r37]
        L_0x03b0:
            if (r0 == 0) goto L_0x03bd
            int r1 = r0.mo3073l()
            if (r1 != r8) goto L_0x03bd
            androidx.constraintlayout.a.a.f[] r0 = r0.f1501af
            r0 = r0[r37]
            goto L_0x03b0
        L_0x03bd:
            if (r14 == r12) goto L_0x0451
            if (r14 == r13) goto L_0x0451
            if (r0 == 0) goto L_0x0451
            if (r0 != r13) goto L_0x03c8
            r7 = r21
            goto L_0x03c9
        L_0x03c8:
            r7 = r0
        L_0x03c9:
            androidx.constraintlayout.a.a.e[] r0 = r14.f1470A
            r0 = r0[r38]
            androidx.constraintlayout.a.h r1 = r0.f1446f
            androidx.constraintlayout.a.a.e r2 = r0.f1443c
            if (r2 == 0) goto L_0x03d7
            androidx.constraintlayout.a.a.e r2 = r0.f1443c
            androidx.constraintlayout.a.h r2 = r2.f1446f
        L_0x03d7:
            androidx.constraintlayout.a.a.e[] r2 = r15.f1470A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.h r2 = r2.f1446f
            int r0 = r0.mo3012e()
            androidx.constraintlayout.a.a.e[] r4 = r14.f1470A
            r4 = r4[r3]
            int r4 = r4.mo3012e()
            if (r7 == 0) goto L_0x03fd
            androidx.constraintlayout.a.a.e[] r5 = r7.f1470A
            r5 = r5[r38]
            androidx.constraintlayout.a.h r6 = r5.f1446f
            androidx.constraintlayout.a.a.e r8 = r5.f1443c
            if (r8 == 0) goto L_0x03fa
            androidx.constraintlayout.a.a.e r8 = r5.f1443c
            goto L_0x040e
        L_0x03fa:
            r8 = r21
            goto L_0x0410
        L_0x03fd:
            androidx.constraintlayout.a.a.e[] r5 = r14.f1470A
            r5 = r5[r3]
            androidx.constraintlayout.a.a.e r5 = r5.f1443c
            if (r5 == 0) goto L_0x0408
            androidx.constraintlayout.a.h r6 = r5.f1446f
            goto L_0x040a
        L_0x0408:
            r6 = r21
        L_0x040a:
            androidx.constraintlayout.a.a.e[] r8 = r14.f1470A
            r8 = r8[r3]
        L_0x040e:
            androidx.constraintlayout.a.h r8 = r8.f1446f
        L_0x0410:
            if (r5 == 0) goto L_0x0417
            int r5 = r5.mo3012e()
            int r4 = r4 + r5
        L_0x0417:
            r18 = r4
            if (r15 == 0) goto L_0x0424
            androidx.constraintlayout.a.a.e[] r4 = r15.f1470A
            r3 = r4[r3]
            int r3 = r3.mo3012e()
            int r0 = r0 + r3
        L_0x0424:
            r3 = r0
            if (r17 == 0) goto L_0x042a
            r22 = 6
            goto L_0x042c
        L_0x042a:
            r22 = 4
        L_0x042c:
            if (r1 == 0) goto L_0x0448
            if (r2 == 0) goto L_0x0448
            if (r6 == 0) goto L_0x0448
            if (r8 == 0) goto L_0x0448
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r36
            r5 = r6
            r6 = r8
            r23 = r7
            r7 = r18
            r18 = r15
            r15 = 8
            r8 = r22
            r0.mo3185a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x044e
        L_0x0448:
            r23 = r7
            r18 = r15
            r15 = 8
        L_0x044e:
            r0 = r23
            goto L_0x0455
        L_0x0451:
            r18 = r15
            r15 = 8
        L_0x0455:
            int r1 = r14.mo3073l()
            if (r1 == r15) goto L_0x045c
            goto L_0x045e
        L_0x045c:
            r14 = r18
        L_0x045e:
            r15 = r14
            r8 = 8
            r14 = r0
            goto L_0x03aa
        L_0x0464:
            androidx.constraintlayout.a.a.e[] r0 = r12.f1470A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r10.f1470A
            r1 = r1[r38]
            androidx.constraintlayout.a.a.e r1 = r1.f1443c
            androidx.constraintlayout.a.a.e[] r2 = r13.f1470A
            int r3 = r38 + 1
            r10 = r2[r3]
            androidx.constraintlayout.a.a.e[] r2 = r11.f1470A
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e r14 = r2.f1443c
            if (r1 == 0) goto L_0x04b1
            if (r12 == r13) goto L_0x048b
            androidx.constraintlayout.a.h r2 = r0.f1446f
            androidx.constraintlayout.a.h r1 = r1.f1446f
            int r0 = r0.mo3012e()
            r15 = 5
            r9.mo3194c(r2, r1, r0, r15)
            goto L_0x04b2
        L_0x048b:
            r15 = 5
            if (r14 == 0) goto L_0x04b2
            androidx.constraintlayout.a.h r2 = r0.f1446f
            androidx.constraintlayout.a.h r3 = r1.f1446f
            int r4 = r0.mo3012e()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.a.h r6 = r10.f1446f
            androidx.constraintlayout.a.h r7 = r14.f1446f
            int r8 = r10.mo3012e()
            r17 = 5
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r17
            r0.mo3185a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04b2
        L_0x04b1:
            r15 = 5
        L_0x04b2:
            if (r14 == 0) goto L_0x04c2
            if (r12 == r13) goto L_0x04c2
            androidx.constraintlayout.a.h r0 = r10.f1446f
            androidx.constraintlayout.a.h r1 = r14.f1446f
            int r2 = r10.mo3012e()
            int r2 = -r2
            r9.mo3194c(r0, r1, r2, r15)
        L_0x04c2:
            if (r25 != 0) goto L_0x04c6
            if (r16 == 0) goto L_0x0529
        L_0x04c6:
            if (r12 == 0) goto L_0x0529
            androidx.constraintlayout.a.a.e[] r0 = r12.f1470A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r13.f1470A
            int r2 = r38 + 1
            r1 = r1[r2]
            androidx.constraintlayout.a.a.e r3 = r0.f1443c
            if (r3 == 0) goto L_0x04db
            androidx.constraintlayout.a.a.e r3 = r0.f1443c
            androidx.constraintlayout.a.h r3 = r3.f1446f
            goto L_0x04dd
        L_0x04db:
            r3 = r21
        L_0x04dd:
            androidx.constraintlayout.a.a.e r4 = r1.f1443c
            if (r4 == 0) goto L_0x04e6
            androidx.constraintlayout.a.a.e r4 = r1.f1443c
            androidx.constraintlayout.a.h r4 = r4.f1446f
            goto L_0x04e8
        L_0x04e6:
            r4 = r21
        L_0x04e8:
            if (r11 == r13) goto L_0x04f9
            androidx.constraintlayout.a.a.e[] r4 = r11.f1470A
            r4 = r4[r2]
            androidx.constraintlayout.a.a.e r5 = r4.f1443c
            if (r5 == 0) goto L_0x04f7
            androidx.constraintlayout.a.a.e r4 = r4.f1443c
            androidx.constraintlayout.a.h r4 = r4.f1446f
            goto L_0x04f9
        L_0x04f7:
            r4 = r21
        L_0x04f9:
            r5 = r4
            if (r12 != r13) goto L_0x0504
            androidx.constraintlayout.a.a.e[] r0 = r12.f1470A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r12.f1470A
            r1 = r1[r2]
        L_0x0504:
            if (r3 == 0) goto L_0x0529
            if (r5 == 0) goto L_0x0529
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.mo3012e()
            if (r13 != 0) goto L_0x0511
            goto L_0x0512
        L_0x0511:
            r11 = r13
        L_0x0512:
            androidx.constraintlayout.a.a.e[] r7 = r11.f1470A
            r2 = r7[r2]
            int r7 = r2.mo3012e()
            androidx.constraintlayout.a.h r2 = r0.f1446f
            androidx.constraintlayout.a.h r8 = r1.f1446f
            r10 = 5
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.mo3185a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0529:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.p020a.C0418c.m1595a(androidx.constraintlayout.a.a.g, androidx.constraintlayout.a.e, int, int, androidx.constraintlayout.a.a.d):void");
    }
}
