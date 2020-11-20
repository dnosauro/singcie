package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.C0444e;
import androidx.constraintlayout.p019a.p020a.C0420e;
import androidx.constraintlayout.p019a.p020a.C0425f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: androidx.constraintlayout.a.a.g */
public class C0428g extends C0440q {

    /* renamed from: aA */
    private boolean f1549aA = false;

    /* renamed from: aB */
    private C0438p f1550aB;

    /* renamed from: aC */
    private int f1551aC = 7;

    /* renamed from: aD */
    private boolean f1552aD = false;

    /* renamed from: aE */
    private boolean f1553aE = false;

    /* renamed from: ai */
    protected C0444e f1554ai = new C0444e();

    /* renamed from: aj */
    int f1555aj;

    /* renamed from: ak */
    int f1556ak;

    /* renamed from: al */
    int f1557al;

    /* renamed from: am */
    int f1558am;

    /* renamed from: an */
    int f1559an = 0;

    /* renamed from: ao */
    int f1560ao = 0;

    /* renamed from: ap */
    C0419d[] f1561ap = new C0419d[4];

    /* renamed from: aq */
    C0419d[] f1562aq = new C0419d[4];

    /* renamed from: ar */
    public List<C0429h> f1563ar = new ArrayList();

    /* renamed from: as */
    public boolean f1564as = false;

    /* renamed from: at */
    public boolean f1565at = false;

    /* renamed from: au */
    public boolean f1566au = false;

    /* renamed from: av */
    public int f1567av = 0;

    /* renamed from: aw */
    public int f1568aw = 0;

    /* renamed from: ax */
    public boolean f1569ax = false;

    /* renamed from: ay */
    int f1570ay = 0;

    /* renamed from: V */
    private void m1699V() {
        this.f1559an = 0;
        this.f1560ao = 0;
    }

    /* renamed from: d */
    private void m1700d(C0425f fVar) {
        int i = this.f1559an + 1;
        C0419d[] dVarArr = this.f1562aq;
        if (i >= dVarArr.length) {
            this.f1562aq = (C0419d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.f1562aq[this.f1559an] = new C0419d(fVar, 0, mo3101M());
        this.f1559an++;
    }

    /* renamed from: e */
    private void m1701e(C0425f fVar) {
        int i = this.f1560ao + 1;
        C0419d[] dVarArr = this.f1561ap;
        if (i >= dVarArr.length) {
            this.f1561ap = (C0419d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.f1561ap[this.f1560ao] = new C0419d(fVar, 1, mo3101M());
        this.f1560ao++;
    }

    /* renamed from: J */
    public int mo3098J() {
        return this.f1551aC;
    }

    /* renamed from: K */
    public boolean mo3099K() {
        return this.f1552aD;
    }

    /* renamed from: L */
    public boolean mo3100L() {
        return this.f1553aE;
    }

    /* renamed from: M */
    public boolean mo3101M() {
        return this.f1549aA;
    }

    /* JADX WARNING: type inference failed for: r8v15, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e2  */
    /* renamed from: N */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3102N() {
        /*
            r21 = this;
            r1 = r21
            int r2 = r1.f1478I
            int r3 = r1.f1479J
            int r0 = r21.mo3081p()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r21.mo3085r()
            int r6 = java.lang.Math.max(r4, r0)
            r1.f1552aD = r4
            r1.f1553aE = r4
            androidx.constraintlayout.a.a.f r0 = r1.f1473D
            if (r0 == 0) goto L_0x0046
            androidx.constraintlayout.a.a.p r0 = r1.f1550aB
            if (r0 != 0) goto L_0x002a
            androidx.constraintlayout.a.a.p r0 = new androidx.constraintlayout.a.a.p
            r0.<init>(r1)
            r1.f1550aB = r0
        L_0x002a:
            androidx.constraintlayout.a.a.p r0 = r1.f1550aB
            r0.mo3143a(r1)
            int r0 = r1.f1555aj
            r1.mo3065h(r0)
            int r0 = r1.f1556ak
            r1.mo3068i(r0)
            r21.mo3023E()
            androidx.constraintlayout.a.e r0 = r1.f1554ai
            androidx.constraintlayout.a.c r0 = r0.mo3198g()
            r1.mo3038a(r0)
            goto L_0x004a
        L_0x0046:
            r1.f1478I = r4
            r1.f1479J = r4
        L_0x004a:
            int r0 = r1.f1551aC
            r7 = 32
            r8 = 8
            r9 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r1.mo3113u(r8)
            if (r0 != 0) goto L_0x005c
            r21.mo3105Q()
        L_0x005c:
            boolean r0 = r1.mo3113u(r7)
            if (r0 != 0) goto L_0x0065
            r21.mo3106R()
        L_0x0065:
            androidx.constraintlayout.a.e r0 = r1.f1554ai
            r0.f1634c = r9
            goto L_0x006e
        L_0x006a:
            androidx.constraintlayout.a.e r0 = r1.f1554ai
            r0.f1634c = r4
        L_0x006e:
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            r10 = r0[r9]
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            r11 = r0[r4]
            r21.m1699V()
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.f1563ar
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0092
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.f1563ar
            r0.clear()
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.f1563ar
            androidx.constraintlayout.a.a.h r12 = new androidx.constraintlayout.a.a.h
            java.util.ArrayList r13 = r1.f1621az
            r12.<init>(r13)
            r0.add(r4, r12)
        L_0x0092:
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.f1563ar
            int r12 = r0.size()
            java.util.ArrayList r13 = r1.f1621az
            androidx.constraintlayout.a.a.f$a r0 = r21.mo3024F()
            androidx.constraintlayout.a.a.f$a r14 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r0 == r14) goto L_0x00ad
            androidx.constraintlayout.a.a.f$a r0 = r21.mo3025G()
            androidx.constraintlayout.a.a.f$a r14 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r0 != r14) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r14 = 0
            goto L_0x00ae
        L_0x00ad:
            r14 = 1
        L_0x00ae:
            r0 = 0
            r15 = 0
        L_0x00b0:
            if (r15 >= r12) goto L_0x02f2
            boolean r8 = r1.f1569ax
            if (r8 != 0) goto L_0x02f2
            java.util.List<androidx.constraintlayout.a.a.h> r8 = r1.f1563ar
            java.lang.Object r8 = r8.get(r15)
            androidx.constraintlayout.a.a.h r8 = (androidx.constraintlayout.p019a.p020a.C0429h) r8
            boolean r8 = r8.f1574d
            if (r8 == 0) goto L_0x00c6
            r19 = r12
            goto L_0x02e6
        L_0x00c6:
            boolean r8 = r1.mo3113u(r7)
            if (r8 == 0) goto L_0x00f7
            androidx.constraintlayout.a.a.f$a r8 = r21.mo3024F()
            androidx.constraintlayout.a.a.f$a r7 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            if (r8 != r7) goto L_0x00e9
            androidx.constraintlayout.a.a.f$a r7 = r21.mo3025G()
            androidx.constraintlayout.a.a.f$a r8 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            if (r7 != r8) goto L_0x00e9
            java.util.List<androidx.constraintlayout.a.a.h> r7 = r1.f1563ar
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.a.a.h r7 = (androidx.constraintlayout.p019a.p020a.C0429h) r7
            java.util.List r7 = r7.mo3114a()
            goto L_0x00f3
        L_0x00e9:
            java.util.List<androidx.constraintlayout.a.a.h> r7 = r1.f1563ar
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.a.a.h r7 = (androidx.constraintlayout.p019a.p020a.C0429h) r7
            java.util.List<androidx.constraintlayout.a.a.f> r7 = r7.f1571a
        L_0x00f3:
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.f1621az = r7
        L_0x00f7:
            r21.m1699V()
            java.util.ArrayList r7 = r1.f1621az
            int r7 = r7.size()
            r8 = 0
        L_0x0101:
            if (r8 >= r7) goto L_0x0119
            java.util.ArrayList r4 = r1.f1621az
            java.lang.Object r4 = r4.get(r8)
            androidx.constraintlayout.a.a.f r4 = (androidx.constraintlayout.p019a.p020a.C0425f) r4
            boolean r9 = r4 instanceof androidx.constraintlayout.p019a.p020a.C0440q
            if (r9 == 0) goto L_0x0114
            androidx.constraintlayout.a.a.q r4 = (androidx.constraintlayout.p019a.p020a.C0440q) r4
            r4.mo3102N()
        L_0x0114:
            int r8 = r8 + 1
            r4 = 0
            r9 = 1
            goto L_0x0101
        L_0x0119:
            r9 = r0
            r0 = 0
            r4 = 1
        L_0x011c:
            if (r4 == 0) goto L_0x02d5
            r17 = r4
            r8 = 1
            int r4 = r0 + 1
            androidx.constraintlayout.a.e r0 = r1.f1554ai     // Catch:{ Exception -> 0x0160 }
            r0.mo3190b()     // Catch:{ Exception -> 0x0160 }
            r21.m1699V()     // Catch:{ Exception -> 0x0160 }
            androidx.constraintlayout.a.e r0 = r1.f1554ai     // Catch:{ Exception -> 0x0160 }
            r1.mo3046b((androidx.constraintlayout.p019a.C0444e) r0)     // Catch:{ Exception -> 0x0160 }
            r0 = 0
        L_0x0131:
            if (r0 >= r7) goto L_0x0147
            java.util.ArrayList r8 = r1.f1621az     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ Exception -> 0x0160 }
            androidx.constraintlayout.a.a.f r8 = (androidx.constraintlayout.p019a.p020a.C0425f) r8     // Catch:{ Exception -> 0x0160 }
            r18 = r9
            androidx.constraintlayout.a.e r9 = r1.f1554ai     // Catch:{ Exception -> 0x015e }
            r8.mo3046b((androidx.constraintlayout.p019a.C0444e) r9)     // Catch:{ Exception -> 0x015e }
            int r0 = r0 + 1
            r9 = r18
            goto L_0x0131
        L_0x0147:
            r18 = r9
            androidx.constraintlayout.a.e r0 = r1.f1554ai     // Catch:{ Exception -> 0x015e }
            boolean r8 = r1.mo3111d((androidx.constraintlayout.p019a.C0444e) r0)     // Catch:{ Exception -> 0x015e }
            if (r8 == 0) goto L_0x0159
            androidx.constraintlayout.a.e r0 = r1.f1554ai     // Catch:{ Exception -> 0x0157 }
            r0.mo3197f()     // Catch:{ Exception -> 0x0157 }
            goto L_0x0159
        L_0x0157:
            r0 = move-exception
            goto L_0x0165
        L_0x0159:
            r17 = r8
            r19 = r12
            goto L_0x0182
        L_0x015e:
            r0 = move-exception
            goto L_0x0163
        L_0x0160:
            r0 = move-exception
            r18 = r9
        L_0x0163:
            r8 = r17
        L_0x0165:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r17 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r19 = r12
            java.lang.String r12 = "EXCEPTION : "
            r8.append(r12)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r9.println(r0)
        L_0x0182:
            if (r17 == 0) goto L_0x018d
            androidx.constraintlayout.a.e r8 = r1.f1554ai
            boolean[] r9 = androidx.constraintlayout.p019a.p020a.C0433k.f1594a
            r1.mo3109a((androidx.constraintlayout.p019a.C0444e) r8, (boolean[]) r9)
        L_0x018b:
            r9 = 2
            goto L_0x01d6
        L_0x018d:
            androidx.constraintlayout.a.e r8 = r1.f1554ai
            r1.mo3052c((androidx.constraintlayout.p019a.C0444e) r8)
            r8 = 0
        L_0x0193:
            if (r8 >= r7) goto L_0x018b
            java.util.ArrayList r9 = r1.f1621az
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.a.a.f r9 = (androidx.constraintlayout.p019a.p020a.C0425f) r9
            androidx.constraintlayout.a.a.f$a[] r12 = r9.f1472C
            r16 = 0
            r12 = r12[r16]
            androidx.constraintlayout.a.a.f$a r0 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            if (r12 != r0) goto L_0x01b8
            int r0 = r9.mo3081p()
            int r12 = r9.mo3083q()
            if (r0 >= r12) goto L_0x01b8
            boolean[] r0 = androidx.constraintlayout.p019a.p020a.C0433k.f1594a
            r8 = 2
            r12 = 1
            r0[r8] = r12
            goto L_0x018b
        L_0x01b8:
            r12 = 1
            androidx.constraintlayout.a.a.f$a[] r0 = r9.f1472C
            r0 = r0[r12]
            androidx.constraintlayout.a.a.f$a r12 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.MATCH_CONSTRAINT
            if (r0 != r12) goto L_0x01d2
            int r0 = r9.mo3085r()
            int r9 = r9.mo3087s()
            if (r0 >= r9) goto L_0x01d2
            boolean[] r0 = androidx.constraintlayout.p019a.p020a.C0433k.f1594a
            r8 = 1
            r9 = 2
            r0[r9] = r8
            goto L_0x01d6
        L_0x01d2:
            r9 = 2
            int r8 = r8 + 1
            goto L_0x0193
        L_0x01d6:
            if (r14 == 0) goto L_0x0250
            r8 = 8
            if (r4 >= r8) goto L_0x0250
            boolean[] r0 = androidx.constraintlayout.p019a.p020a.C0433k.f1594a
            boolean r0 = r0[r9]
            if (r0 == 0) goto L_0x0250
            r0 = 0
            r9 = 0
            r12 = 0
        L_0x01e5:
            if (r0 >= r7) goto L_0x020f
            java.util.ArrayList r8 = r1.f1621az
            java.lang.Object r8 = r8.get(r0)
            androidx.constraintlayout.a.a.f r8 = (androidx.constraintlayout.p019a.p020a.C0425f) r8
            r17 = r4
            int r4 = r8.f1478I
            int r20 = r8.mo3081p()
            int r4 = r4 + r20
            int r9 = java.lang.Math.max(r9, r4)
            int r4 = r8.f1479J
            int r8 = r8.mo3085r()
            int r4 = r4 + r8
            int r12 = java.lang.Math.max(r12, r4)
            int r0 = r0 + 1
            r4 = r17
            r8 = 8
            goto L_0x01e5
        L_0x020f:
            r17 = r4
            int r0 = r1.f1485P
            int r0 = java.lang.Math.max(r0, r9)
            int r4 = r1.f1486Q
            int r4 = java.lang.Math.max(r4, r12)
            androidx.constraintlayout.a.a.f$a r8 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r11 != r8) goto L_0x0235
            int r8 = r21.mo3081p()
            if (r8 >= r0) goto L_0x0235
            r1.mo3070j(r0)
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            androidx.constraintlayout.a.a.f$a r8 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            r9 = 0
            r0[r9] = r8
            r0 = 1
            r18 = 1
            goto L_0x0236
        L_0x0235:
            r0 = 0
        L_0x0236:
            androidx.constraintlayout.a.a.f$a r8 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r10 != r8) goto L_0x024d
            int r8 = r21.mo3085r()
            if (r8 >= r4) goto L_0x024d
            r1.mo3072k(r4)
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r9 = 1
            goto L_0x0255
        L_0x024d:
            r9 = r18
            goto L_0x0255
        L_0x0250:
            r17 = r4
            r9 = r18
            r0 = 0
        L_0x0255:
            int r4 = r1.f1485P
            int r8 = r21.mo3081p()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.mo3081p()
            if (r4 <= r8) goto L_0x0271
            r1.mo3070j(r4)
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            r8 = 0
            r0[r8] = r4
            r0 = 1
            r9 = 1
        L_0x0271:
            int r4 = r1.f1486Q
            int r8 = r21.mo3085r()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.mo3085r()
            if (r4 <= r8) goto L_0x028e
            r1.mo3072k(r4)
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r9 = 1
            goto L_0x028f
        L_0x028e:
            r8 = 1
        L_0x028f:
            if (r9 != 0) goto L_0x02ce
            androidx.constraintlayout.a.a.f$a[] r4 = r1.f1472C
            r12 = 0
            r4 = r4[r12]
            androidx.constraintlayout.a.a.f$a r12 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r4 != r12) goto L_0x02b0
            if (r5 <= 0) goto L_0x02b0
            int r4 = r21.mo3081p()
            if (r4 <= r5) goto L_0x02b0
            r1.f1552aD = r8
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            r9 = 0
            r0[r9] = r4
            r1.mo3070j(r5)
            r0 = 1
            r9 = 1
        L_0x02b0:
            androidx.constraintlayout.a.a.f$a[] r4 = r1.f1472C
            r4 = r4[r8]
            androidx.constraintlayout.a.a.f$a r12 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.WRAP_CONTENT
            if (r4 != r12) goto L_0x02ce
            if (r6 <= 0) goto L_0x02ce
            int r4 = r21.mo3085r()
            if (r4 <= r6) goto L_0x02ce
            r1.f1553aE = r8
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.p019a.p020a.C0425f.C0427a.FIXED
            r0[r8] = r4
            r1.mo3072k(r6)
            r4 = 1
            r9 = 1
            goto L_0x02cf
        L_0x02ce:
            r4 = r0
        L_0x02cf:
            r0 = r17
            r12 = r19
            goto L_0x011c
        L_0x02d5:
            r18 = r9
            r19 = r12
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.f1563ar
            java.lang.Object r0 = r0.get(r15)
            androidx.constraintlayout.a.a.h r0 = (androidx.constraintlayout.p019a.p020a.C0429h) r0
            r0.mo3118b()
            r0 = r18
        L_0x02e6:
            int r15 = r15 + 1
            r12 = r19
            r4 = 0
            r7 = 32
            r8 = 8
            r9 = 1
            goto L_0x00b0
        L_0x02f2:
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            r1.f1621az = r13
            androidx.constraintlayout.a.a.f r4 = r1.f1473D
            if (r4 == 0) goto L_0x0326
            int r2 = r1.f1485P
            int r3 = r21.mo3081p()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.f1486Q
            int r4 = r21.mo3085r()
            int r3 = java.lang.Math.max(r3, r4)
            androidx.constraintlayout.a.a.p r4 = r1.f1550aB
            r4.mo3144b(r1)
            int r4 = r1.f1555aj
            int r2 = r2 + r4
            int r4 = r1.f1557al
            int r2 = r2 + r4
            r1.mo3070j(r2)
            int r2 = r1.f1556ak
            int r3 = r3 + r2
            int r2 = r1.f1558am
            int r3 = r3 + r2
            r1.mo3072k(r3)
            goto L_0x032a
        L_0x0326:
            r1.f1478I = r2
            r1.f1479J = r3
        L_0x032a:
            if (r0 == 0) goto L_0x0336
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            r2 = 0
            r0[r2] = r11
            androidx.constraintlayout.a.a.f$a[] r0 = r1.f1472C
            r2 = 1
            r0[r2] = r10
        L_0x0336:
            androidx.constraintlayout.a.e r0 = r1.f1554ai
            androidx.constraintlayout.a.c r0 = r0.mo3198g()
            r1.mo3038a(r0)
            androidx.constraintlayout.a.a.g r0 = r21.mo3147T()
            if (r1 != r0) goto L_0x0348
            r21.mo3022D()
        L_0x0348:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.p020a.C0428g.mo3102N():void");
    }

    /* renamed from: O */
    public void mo3103O() {
        mo3105Q();
        mo3001b(this.f1551aC);
    }

    /* renamed from: P */
    public void mo3104P() {
        C0435m a = mo3028a(C0420e.C0424c.LEFT).mo3004a();
        C0435m a2 = mo3028a(C0420e.C0424c.TOP).mo3004a();
        a.mo3126a((C0435m) null, 0.0f);
        a2.mo3126a((C0435m) null, 0.0f);
    }

    /* renamed from: Q */
    public void mo3105Q() {
        int size = this.f1621az.size();
        mo3000b();
        for (int i = 0; i < size; i++) {
            ((C0425f) this.f1621az.get(i)).mo3000b();
        }
    }

    /* renamed from: R */
    public void mo3106R() {
        if (!mo3113u(8)) {
            mo3001b(this.f1551aC);
        }
        mo3104P();
    }

    /* renamed from: S */
    public boolean mo3107S() {
        return false;
    }

    /* renamed from: a */
    public void mo2996a(int i) {
        this.f1551aC = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3108a(C0425f fVar, int i) {
        if (i == 0) {
            m1700d(fVar);
        } else if (i == 1) {
            m1701e(fVar);
        }
    }

    /* renamed from: a */
    public void mo3109a(C0444e eVar, boolean[] zArr) {
        zArr[2] = false;
        mo3052c(eVar);
        int size = this.f1621az.size();
        for (int i = 0; i < size; i++) {
            C0425f fVar = (C0425f) this.f1621az.get(i);
            fVar.mo3052c(eVar);
            if (fVar.f1472C[0] == C0425f.C0427a.MATCH_CONSTRAINT && fVar.mo3081p() < fVar.mo3083q()) {
                zArr[2] = true;
            }
            if (fVar.f1472C[1] == C0425f.C0427a.MATCH_CONSTRAINT && fVar.mo3085r() < fVar.mo3087s()) {
                zArr[2] = true;
            }
        }
    }

    /* renamed from: a */
    public void mo3110a(boolean z) {
        this.f1549aA = z;
    }

    /* renamed from: b */
    public void mo3001b(int i) {
        super.mo3001b(i);
        int size = this.f1621az.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((C0425f) this.f1621az.get(i2)).mo3001b(i);
        }
    }

    /* renamed from: d */
    public boolean mo3111d(C0444e eVar) {
        mo2997a(eVar);
        int size = this.f1621az.size();
        for (int i = 0; i < size; i++) {
            C0425f fVar = (C0425f) this.f1621az.get(i);
            if (fVar instanceof C0428g) {
                C0425f.C0427a aVar = fVar.f1472C[0];
                C0425f.C0427a aVar2 = fVar.f1472C[1];
                if (aVar == C0425f.C0427a.WRAP_CONTENT) {
                    fVar.mo3035a(C0425f.C0427a.FIXED);
                }
                if (aVar2 == C0425f.C0427a.WRAP_CONTENT) {
                    fVar.mo3045b(C0425f.C0427a.FIXED);
                }
                fVar.mo2997a(eVar);
                if (aVar == C0425f.C0427a.WRAP_CONTENT) {
                    fVar.mo3035a(aVar);
                }
                if (aVar2 == C0425f.C0427a.WRAP_CONTENT) {
                    fVar.mo3045b(aVar2);
                }
            } else {
                C0433k.m1743a(this, eVar, fVar);
                fVar.mo2997a(eVar);
            }
        }
        if (this.f1559an > 0) {
            C0418c.m1594a(this, eVar, 0);
        }
        if (this.f1560ao > 0) {
            C0418c.m1594a(this, eVar, 1);
        }
        return true;
    }

    /* renamed from: f */
    public void mo3062f() {
        this.f1554ai.mo3190b();
        this.f1555aj = 0;
        this.f1557al = 0;
        this.f1556ak = 0;
        this.f1558am = 0;
        this.f1563ar.clear();
        this.f1569ax = false;
        super.mo3062f();
    }

    /* renamed from: f */
    public void mo3112f(int i, int i2) {
        if (!(this.f1472C[0] == C0425f.C0427a.WRAP_CONTENT || this.f1518c == null)) {
            this.f1518c.mo3137a(i);
        }
        if (this.f1472C[1] != C0425f.C0427a.WRAP_CONTENT && this.f1519d != null) {
            this.f1519d.mo3137a(i2);
        }
    }

    /* renamed from: u */
    public boolean mo3113u(int i) {
        return (this.f1551aC & i) == i;
    }
}
