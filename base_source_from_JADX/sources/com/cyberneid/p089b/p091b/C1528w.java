package com.cyberneid.p089b.p091b;

import com.cyberneid.p089b.p096g.C1582c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cyberneid.b.b.w */
public class C1528w extends C1525u {

    /* renamed from: c */
    private int f4530c = 0;

    /* renamed from: d */
    private int f4531d = 0;

    /* renamed from: e */
    private int f4532e = 0;

    /* renamed from: f */
    private final List<Object> f4533f;

    /* renamed from: g */
    private final int f4534g;

    public C1528w(C1582c cVar, String str, String str2, int i, List<Object> list, int i2, int i3) {
        super(cVar, str, str2);
        this.f4534g = i;
        this.f4533f = list;
        this.f4530c = i2;
        this.f4531d = i3;
        m5856a(list);
    }

    /* renamed from: a */
    private static <E> List<List<E>> m5853a(List<E> list, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size() / i) {
            int i3 = i2 * i;
            i2++;
            arrayList.add(list.subList(i3, i2 * i));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        if (r14.size() > 1) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0021, code lost:
        if ((r14.size() % 2) != 0) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dc, code lost:
        if (r14.size() > 2) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ec, code lost:
        if (r14.size() > 1) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02e1, code lost:
        if ((r14.size() % 2) != 0) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0304, code lost:
        if ((r14.size() % 2) != 0) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        if ((r14.size() % 2) != 0) goto L_0x003e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Integer> m5854a(java.util.List<java.lang.Integer> r14, com.cyberneid.p089b.p091b.C1519p r15) {
        /*
            r13 = this;
            int r0 = r13.f4517b
            r1 = 1
            int r0 = r0 + r1
            r13.f4517b = r0
            java.util.Map<com.cyberneid.b.b.p$a, java.lang.String> r0 = com.cyberneid.p089b.p091b.C1519p.f4507b
            com.cyberneid.b.b.p$a r2 = r15.mo7108a()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "hstem"
            boolean r2 = r2.equals(r0)
            r3 = 2
            r4 = 0
            if (r2 == 0) goto L_0x002d
            int r15 = r14.size()
            int r15 = r15 % r3
            if (r15 == 0) goto L_0x0024
        L_0x0023:
            r4 = 1
        L_0x0024:
            java.util.List r14 = r13.m5855a((java.util.List<java.lang.Integer>) r14, (boolean) r4)
            r13.m5858b((java.util.List<java.lang.Integer>) r14, (boolean) r1)
            goto L_0x0397
        L_0x002d:
            java.lang.String r2 = "vstem"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0047
            int r15 = r14.size()
            int r15 = r15 % r3
            if (r15 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            java.util.List r14 = r13.m5855a((java.util.List<java.lang.Integer>) r14, (boolean) r1)
        L_0x0042:
            r13.m5858b((java.util.List<java.lang.Integer>) r14, (boolean) r4)
            goto L_0x0397
        L_0x0047:
            java.lang.String r2 = "vmoveto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0063
            int r0 = r14.size()
            if (r0 <= r1) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            java.util.List r14 = r13.m5855a((java.util.List<java.lang.Integer>) r14, (boolean) r1)
            r13.m5859c()
        L_0x005e:
            r13.m5860c((java.util.List<java.lang.Integer>) r14, (com.cyberneid.p089b.p091b.C1519p) r15)
            goto L_0x0397
        L_0x0063:
            java.lang.String r2 = "rlineto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0074
            java.util.List r14 = m5853a(r14, (int) r3)
        L_0x006f:
            r13.m5857b((java.util.List<java.util.List<java.lang.Integer>>) r14, (com.cyberneid.p089b.p091b.C1519p) r15)
            goto L_0x0397
        L_0x0074:
            java.lang.String r2 = "hlineto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0081
            r13.m5861c((java.util.List<java.lang.Integer>) r14, (boolean) r1)
            goto L_0x0397
        L_0x0081:
            java.lang.String r2 = "vlineto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x008e
            r13.m5861c((java.util.List<java.lang.Integer>) r14, (boolean) r4)
            goto L_0x0397
        L_0x008e:
            java.lang.String r2 = "rrcurveto"
            boolean r2 = r2.equals(r0)
            r5 = 6
            if (r2 == 0) goto L_0x009c
            java.util.List r14 = m5853a(r14, (int) r5)
            goto L_0x006f
        L_0x009c:
            java.lang.String r2 = "endchar"
            boolean r2 = r2.equals(r0)
            r6 = 12
            r7 = 4
            r8 = 5
            if (r2 == 0) goto L_0x00d0
            int r0 = r14.size()
            if (r0 == r8) goto L_0x00b6
            int r0 = r14.size()
            if (r0 != r1) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r1 = 0
        L_0x00b6:
            java.util.List r14 = r13.m5855a((java.util.List<java.lang.Integer>) r14, (boolean) r1)
            r13.m5862d()
            int r0 = r14.size()
            if (r0 != r7) goto L_0x005e
            java.lang.Integer r15 = java.lang.Integer.valueOf(r4)
            r14.add(r4, r15)
            com.cyberneid.b.b.p r15 = new com.cyberneid.b.b.p
            r15.<init>(r6, r5)
            goto L_0x005e
        L_0x00d0:
            java.lang.String r2 = "rmoveto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00e0
            int r0 = r14.size()
            if (r0 <= r3) goto L_0x0056
            goto L_0x0057
        L_0x00e0:
            java.lang.String r2 = "hmoveto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00f0
            int r0 = r14.size()
            if (r0 <= r1) goto L_0x0056
            goto L_0x0057
        L_0x00f0:
            java.lang.String r2 = "vhcurveto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00fd
            r13.m5863d(r14, r4)
            goto L_0x0397
        L_0x00fd:
            java.lang.String r2 = "hvcurveto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x010a
            r13.m5863d(r14, r1)
            goto L_0x0397
        L_0x010a:
            java.lang.String r2 = "hflex"
            boolean r2 = r2.equals(r0)
            r9 = 3
            r10 = 8
            if (r2 == 0) goto L_0x0193
            java.lang.Integer[] r15 = new java.lang.Integer[r5]
            java.lang.Object r0 = r14.get(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r4] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r15[r1] = r0
            java.lang.Object r0 = r14.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r3] = r0
            java.lang.Object r0 = r14.get(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r9] = r0
            java.lang.Object r0 = r14.get(r9)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r7] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r15[r8] = r0
            java.util.List r15 = java.util.Arrays.asList(r15)
            java.lang.Integer[] r0 = new java.lang.Integer[r5]
            java.lang.Object r2 = r14.get(r7)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r0[r4] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0[r1] = r2
            java.lang.Object r2 = r14.get(r8)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r0[r3] = r2
            java.lang.Object r2 = r14.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r2 = -r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r9] = r2
            java.lang.Object r14 = r14.get(r5)
            java.lang.Integer r14 = (java.lang.Integer) r14
            r0[r7] = r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r4)
            r0[r8] = r14
            java.util.List r14 = java.util.Arrays.asList(r0)
            java.util.List[] r0 = new java.util.List[r3]
            r0[r4] = r15
            r0[r1] = r14
            java.util.List r14 = java.util.Arrays.asList(r0)
            com.cyberneid.b.b.p r15 = new com.cyberneid.b.b.p
            r15.<init>((int) r10)
            goto L_0x006f
        L_0x0193:
            java.lang.String r2 = "flex"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01b4
            java.util.List r15 = r14.subList(r4, r5)
            java.util.List r14 = r14.subList(r5, r6)
            java.util.List[] r0 = new java.util.List[r3]
            r0[r4] = r15
            r0[r1] = r14
            java.util.List r14 = java.util.Arrays.asList(r0)
            com.cyberneid.b.b.p r15 = new com.cyberneid.b.b.p
            r15.<init>((int) r10)
            goto L_0x006f
        L_0x01b4:
            java.lang.String r2 = "hflex1"
            boolean r2 = r2.equals(r0)
            r6 = 7
            if (r2 == 0) goto L_0x0234
            java.lang.Integer[] r15 = new java.lang.Integer[r5]
            java.lang.Object r0 = r14.get(r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r4] = r0
            java.lang.Object r0 = r14.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r1] = r0
            java.lang.Object r0 = r14.get(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r3] = r0
            java.lang.Object r0 = r14.get(r9)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r9] = r0
            java.lang.Object r0 = r14.get(r7)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r15[r7] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r15[r8] = r0
            java.util.List r15 = java.util.Arrays.asList(r15)
            java.lang.Integer[] r0 = new java.lang.Integer[r5]
            java.lang.Object r2 = r14.get(r8)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r0[r4] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0[r1] = r2
            java.lang.Object r2 = r14.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r0[r3] = r2
            java.lang.Object r2 = r14.get(r6)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r0[r9] = r2
            java.lang.Object r14 = r14.get(r10)
            java.lang.Integer r14 = (java.lang.Integer) r14
            r0[r7] = r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r4)
            r0[r8] = r14
            java.util.List r14 = java.util.Arrays.asList(r0)
            java.util.List[] r0 = new java.util.List[r3]
            r0[r4] = r15
            r0[r1] = r14
            java.util.List r14 = java.util.Arrays.asList(r0)
            com.cyberneid.b.b.p r15 = new com.cyberneid.b.b.p
            r15.<init>((int) r10)
            goto L_0x006f
        L_0x0234:
            java.lang.String r2 = "flex1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x02d4
            r15 = 0
            r0 = 0
            r2 = 0
        L_0x023f:
            if (r15 >= r8) goto L_0x025d
            int r11 = r15 * 2
            java.lang.Object r12 = r14.get(r11)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            int r0 = r0 + r12
            int r11 = r11 + r1
            java.lang.Object r11 = r14.get(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            int r2 = r2 + r11
            int r15 = r15 + 1
            goto L_0x023f
        L_0x025d:
            java.util.List r15 = r14.subList(r4, r5)
            java.lang.Integer[] r11 = new java.lang.Integer[r5]
            java.lang.Object r5 = r14.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            r11[r4] = r5
            java.lang.Object r5 = r14.get(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            r11[r1] = r5
            java.lang.Object r5 = r14.get(r10)
            java.lang.Integer r5 = (java.lang.Integer) r5
            r11[r3] = r5
            r5 = 9
            java.lang.Object r5 = r14.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            r11[r9] = r5
            int r5 = java.lang.Math.abs(r0)
            int r6 = java.lang.Math.abs(r2)
            r9 = 10
            if (r5 <= r6) goto L_0x029c
            java.lang.Object r5 = r14.get(r9)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x029d
        L_0x029c:
            int r5 = -r0
        L_0x029d:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r11[r7] = r5
            int r0 = java.lang.Math.abs(r0)
            int r5 = java.lang.Math.abs(r2)
            if (r0 <= r5) goto L_0x02af
            int r14 = -r2
            goto L_0x02b9
        L_0x02af:
            java.lang.Object r14 = r14.get(r9)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
        L_0x02b9:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r11[r8] = r14
            java.util.List r14 = java.util.Arrays.asList(r11)
            java.util.List[] r0 = new java.util.List[r3]
            r0[r4] = r15
            r0[r1] = r14
            java.util.List r14 = java.util.Arrays.asList(r0)
            com.cyberneid.b.b.p r15 = new com.cyberneid.b.b.p
            r15.<init>((int) r10)
            goto L_0x006f
        L_0x02d4:
            java.lang.String r2 = "hstemhm"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x02e5
            int r15 = r14.size()
            int r15 = r15 % r3
            if (r15 == 0) goto L_0x0024
            goto L_0x0023
        L_0x02e5:
            java.lang.String r2 = "hintmask"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0382
            java.lang.String r2 = "cntrmask"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x02f7
            goto L_0x0382
        L_0x02f7:
            java.lang.String r2 = "vstemhm"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0308
            int r15 = r14.size()
            int r15 = r15 % r3
            if (r15 == 0) goto L_0x003d
            goto L_0x003e
        L_0x0308:
            java.lang.String r2 = "rcurveline"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0339
            int r15 = r14.size()
            int r15 = r15 - r3
            java.util.List r15 = r14.subList(r4, r15)
            java.util.List r15 = m5853a(r15, (int) r5)
            com.cyberneid.b.b.p r0 = new com.cyberneid.b.b.p
            r0.<init>((int) r10)
            r13.m5857b((java.util.List<java.util.List<java.lang.Integer>>) r15, (com.cyberneid.p089b.p091b.C1519p) r0)
            int r15 = r14.size()
            int r15 = r15 - r3
            int r0 = r14.size()
            java.util.List r14 = r14.subList(r15, r0)
            com.cyberneid.b.b.p r15 = new com.cyberneid.b.b.p
            r15.<init>((int) r8)
            goto L_0x005e
        L_0x0339:
            java.lang.String r2 = "rlinecurve"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x036a
            int r15 = r14.size()
            int r15 = r15 - r5
            java.util.List r15 = r14.subList(r4, r15)
            java.util.List r15 = m5853a(r15, (int) r3)
            com.cyberneid.b.b.p r0 = new com.cyberneid.b.b.p
            r0.<init>((int) r8)
            r13.m5857b((java.util.List<java.util.List<java.lang.Integer>>) r15, (com.cyberneid.p089b.p091b.C1519p) r0)
            int r15 = r14.size()
            int r15 = r15 - r5
            int r0 = r14.size()
            java.util.List r14 = r14.subList(r15, r0)
            com.cyberneid.b.b.p r15 = new com.cyberneid.b.b.p
            r15.<init>((int) r10)
            goto L_0x005e
        L_0x036a:
            java.lang.String r2 = "vvcurveto"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0376
            r13.m5864e(r14, r4)
            goto L_0x0397
        L_0x0376:
            java.lang.String r2 = "hhcurveto"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x005e
            r13.m5864e(r14, r1)
            goto L_0x0397
        L_0x0382:
            int r15 = r14.size()
            int r15 = r15 % r3
            if (r15 == 0) goto L_0x038a
            goto L_0x038b
        L_0x038a:
            r1 = 0
        L_0x038b:
            java.util.List r14 = r13.m5855a((java.util.List<java.lang.Integer>) r14, (boolean) r1)
            int r15 = r14.size()
            if (r15 <= 0) goto L_0x0397
            goto L_0x0042
        L_0x0397:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p089b.p091b.C1528w.m5854a(java.util.List, com.cyberneid.b.b.p):java.util.List");
    }

    /* renamed from: a */
    private List<Integer> m5855a(List<Integer> list, boolean z) {
        if (!this.f4516a.isEmpty()) {
            return list;
        }
        if (z) {
            m5860c((List<Integer>) Arrays.asList(new Integer[]{0, Integer.valueOf(list.get(0).intValue() + this.f4531d)}), new C1519p(13));
            return list.subList(1, list.size());
        }
        m5860c((List<Integer>) Arrays.asList(new Integer[]{0, Integer.valueOf(this.f4530c)}), new C1519p(13));
        return list;
    }

    /* renamed from: a */
    private void m5856a(List<Object> list) {
        this.f4516a = new ArrayList();
        this.f4532e = 0;
        new C1521q() {
            /* renamed from: a */
            public List<Integer> mo7117a(List<Integer> list, C1519p pVar) {
                return C1528w.this.m5854a(list, pVar);
            }
        }.mo7116a(list);
    }

    /* renamed from: b */
    private void m5857b(List<List<Integer>> list, C1519p pVar) {
        for (List<Integer> c : list) {
            m5860c(c, pVar);
        }
    }

    /* renamed from: b */
    private void m5858b(List<Integer> list, boolean z) {
    }

    /* renamed from: c */
    private void m5859c() {
        if (this.f4532e > 0) {
            m5862d();
        }
        this.f4532e++;
    }

    /* renamed from: c */
    private void m5860c(List<Integer> list, C1519p pVar) {
        this.f4516a.addAll(list);
        this.f4516a.add(pVar);
    }

    /* renamed from: c */
    private void m5861c(List<Integer> list, boolean z) {
        while (list.size() > 0) {
            m5860c(list.subList(0, 1), new C1519p(z ? 6 : 7));
            list = list.subList(1, list.size());
            z = !z;
        }
    }

    /* renamed from: d */
    private void m5862d() {
        C1519p pVar = this.f4532e > 0 ? (C1519p) this.f4516a.get(this.f4516a.size() - 1) : null;
        C1519p pVar2 = new C1519p(9);
        if (pVar != null && !pVar2.equals(pVar)) {
            m5860c((List<Integer>) Collections.emptyList(), pVar2);
        }
    }

    /* renamed from: d */
    private void m5863d(List<Integer> list, boolean z) {
        C1519p pVar;
        List list2;
        while (list.size() > 0) {
            int i = 5;
            boolean z2 = list.size() == 5;
            if (z) {
                Integer[] numArr = new Integer[6];
                numArr[0] = list.get(0);
                numArr[1] = 0;
                numArr[2] = list.get(1);
                numArr[3] = list.get(2);
                numArr[4] = Integer.valueOf(z2 ? list.get(4).intValue() : 0);
                numArr[5] = list.get(3);
                list2 = Arrays.asList(numArr);
                pVar = new C1519p(8);
            } else {
                Integer[] numArr2 = new Integer[6];
                numArr2[0] = 0;
                numArr2[1] = list.get(0);
                numArr2[2] = list.get(1);
                numArr2[3] = list.get(2);
                numArr2[4] = list.get(3);
                numArr2[5] = Integer.valueOf(z2 ? list.get(4).intValue() : 0);
                list2 = Arrays.asList(numArr2);
                pVar = new C1519p(8);
            }
            m5860c((List<Integer>) list2, pVar);
            if (!z2) {
                i = 4;
            }
            list = list.subList(i, list.size());
            z = !z;
        }
    }

    /* renamed from: e */
    private void m5864e(List<Integer> list, boolean z) {
        C1519p pVar;
        List list2;
        while (list.size() > 0) {
            int i = 4;
            int i2 = 1;
            int i3 = list.size() % 4 == 1 ? 1 : 0;
            int i4 = 3;
            int i5 = 2;
            if (z) {
                Integer[] numArr = new Integer[6];
                numArr[0] = list.get(i3);
                numArr[1] = Integer.valueOf(i3 != 0 ? list.get(0).intValue() : 0);
                if (i3 != 0) {
                    i2 = 2;
                }
                numArr[2] = list.get(i2);
                if (i3 != 0) {
                    i5 = 3;
                }
                numArr[3] = list.get(i5);
                if (i3 != 0) {
                    i4 = 4;
                }
                numArr[4] = list.get(i4);
                numArr[5] = 0;
                list2 = Arrays.asList(numArr);
                pVar = new C1519p(8);
            } else {
                Integer[] numArr2 = new Integer[6];
                numArr2[0] = Integer.valueOf(i3 != 0 ? list.get(0).intValue() : 0);
                numArr2[1] = list.get(i3);
                if (i3 != 0) {
                    i2 = 2;
                }
                numArr2[2] = list.get(i2);
                if (i3 != 0) {
                    i5 = 3;
                }
                numArr2[3] = list.get(i5);
                numArr2[4] = 0;
                if (i3 != 0) {
                    i4 = 4;
                }
                numArr2[5] = list.get(i4);
                list2 = Arrays.asList(numArr2);
                pVar = new C1519p(8);
            }
            m5860c((List<Integer>) list2, pVar);
            if (i3 != 0) {
                i = 5;
            }
            list = list.subList(i, list.size());
        }
    }
}
