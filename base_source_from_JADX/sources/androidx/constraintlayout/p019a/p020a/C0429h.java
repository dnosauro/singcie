package androidx.constraintlayout.p019a.p020a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: androidx.constraintlayout.a.a.h */
public class C0429h {

    /* renamed from: a */
    public List<C0425f> f1571a;

    /* renamed from: b */
    int f1572b = -1;

    /* renamed from: c */
    int f1573c = -1;

    /* renamed from: d */
    public boolean f1574d = false;

    /* renamed from: e */
    public final int[] f1575e = {this.f1572b, this.f1573c};

    /* renamed from: f */
    List<C0425f> f1576f = new ArrayList();

    /* renamed from: g */
    List<C0425f> f1577g = new ArrayList();

    /* renamed from: h */
    HashSet<C0425f> f1578h = new HashSet<>();

    /* renamed from: i */
    HashSet<C0425f> f1579i = new HashSet<>();

    /* renamed from: j */
    List<C0425f> f1580j = new ArrayList();

    /* renamed from: k */
    List<C0425f> f1581k = new ArrayList();

    C0429h(List<C0425f> list) {
        this.f1571a = list;
    }

    C0429h(List<C0425f> list, boolean z) {
        this.f1571a = list;
        this.f1574d = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1721a(androidx.constraintlayout.p019a.p020a.C0425f r7) {
        /*
            r6 = this;
            boolean r0 = r7.f1491W
            if (r0 == 0) goto L_0x00ed
            boolean r0 = r7.mo3066h()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            androidx.constraintlayout.a.a.e r0 = r7.f1536u
            androidx.constraintlayout.a.a.e r0 = r0.f1443c
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.a.a.e r3 = r7.f1536u
            goto L_0x001d
        L_0x001b:
            androidx.constraintlayout.a.a.e r3 = r7.f1534s
        L_0x001d:
            androidx.constraintlayout.a.a.e r3 = r3.f1443c
            if (r3 == 0) goto L_0x0049
            androidx.constraintlayout.a.a.f r4 = r3.f1441a
            boolean r4 = r4.f1492X
            if (r4 != 0) goto L_0x002c
            androidx.constraintlayout.a.a.f r4 = r3.f1441a
            r6.m1721a((androidx.constraintlayout.p019a.p020a.C0425f) r4)
        L_0x002c:
            androidx.constraintlayout.a.a.e$c r4 = r3.f1442b
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.RIGHT
            if (r4 != r5) goto L_0x003e
            androidx.constraintlayout.a.a.f r4 = r3.f1441a
            int r4 = r4.f1478I
            androidx.constraintlayout.a.a.f r3 = r3.f1441a
            int r3 = r3.mo3081p()
            int r3 = r3 + r4
            goto L_0x004a
        L_0x003e:
            androidx.constraintlayout.a.a.e$c r4 = r3.f1442b
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.LEFT
            if (r4 != r5) goto L_0x0049
            androidx.constraintlayout.a.a.f r3 = r3.f1441a
            int r3 = r3.f1478I
            goto L_0x004a
        L_0x0049:
            r3 = 0
        L_0x004a:
            if (r0 == 0) goto L_0x0054
            androidx.constraintlayout.a.a.e r0 = r7.f1536u
            int r0 = r0.mo3012e()
            int r3 = r3 - r0
            goto L_0x0060
        L_0x0054:
            androidx.constraintlayout.a.a.e r0 = r7.f1534s
            int r0 = r0.mo3012e()
            int r4 = r7.mo3081p()
            int r0 = r0 + r4
            int r3 = r3 + r0
        L_0x0060:
            int r0 = r7.mo3081p()
            int r0 = r3 - r0
            r7.mo3051c(r0, r3)
            androidx.constraintlayout.a.a.e r0 = r7.f1538w
            androidx.constraintlayout.a.a.e r0 = r0.f1443c
            if (r0 == 0) goto L_0x0093
            androidx.constraintlayout.a.a.e r0 = r7.f1538w
            androidx.constraintlayout.a.a.e r0 = r0.f1443c
            androidx.constraintlayout.a.a.f r1 = r0.f1441a
            boolean r1 = r1.f1492X
            if (r1 != 0) goto L_0x007e
            androidx.constraintlayout.a.a.f r1 = r0.f1441a
            r6.m1721a((androidx.constraintlayout.p019a.p020a.C0425f) r1)
        L_0x007e:
            androidx.constraintlayout.a.a.f r1 = r0.f1441a
            int r1 = r1.f1479J
            androidx.constraintlayout.a.a.f r0 = r0.f1441a
            int r0 = r0.f1484O
            int r1 = r1 + r0
            int r0 = r7.f1484O
            int r1 = r1 - r0
            int r0 = r7.f1475F
            int r0 = r0 + r1
            r7.mo3056d(r1, r0)
            r7.f1492X = r2
            return
        L_0x0093:
            androidx.constraintlayout.a.a.e r0 = r7.f1537v
            androidx.constraintlayout.a.a.e r0 = r0.f1443c
            if (r0 == 0) goto L_0x009a
            r1 = 1
        L_0x009a:
            if (r1 == 0) goto L_0x009f
            androidx.constraintlayout.a.a.e r0 = r7.f1537v
            goto L_0x00a1
        L_0x009f:
            androidx.constraintlayout.a.a.e r0 = r7.f1535t
        L_0x00a1:
            androidx.constraintlayout.a.a.e r0 = r0.f1443c
            if (r0 == 0) goto L_0x00cc
            androidx.constraintlayout.a.a.f r4 = r0.f1441a
            boolean r4 = r4.f1492X
            if (r4 != 0) goto L_0x00b0
            androidx.constraintlayout.a.a.f r4 = r0.f1441a
            r6.m1721a((androidx.constraintlayout.p019a.p020a.C0425f) r4)
        L_0x00b0:
            androidx.constraintlayout.a.a.e$c r4 = r0.f1442b
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.BOTTOM
            if (r4 != r5) goto L_0x00c2
            androidx.constraintlayout.a.a.f r3 = r0.f1441a
            int r3 = r3.f1479J
            androidx.constraintlayout.a.a.f r0 = r0.f1441a
            int r0 = r0.mo3085r()
            int r3 = r3 + r0
            goto L_0x00cc
        L_0x00c2:
            androidx.constraintlayout.a.a.e$c r4 = r0.f1442b
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.p019a.p020a.C0420e.C0424c.TOP
            if (r4 != r5) goto L_0x00cc
            androidx.constraintlayout.a.a.f r0 = r0.f1441a
            int r3 = r0.f1479J
        L_0x00cc:
            if (r1 == 0) goto L_0x00d6
            androidx.constraintlayout.a.a.e r0 = r7.f1537v
            int r0 = r0.mo3012e()
            int r3 = r3 - r0
            goto L_0x00e2
        L_0x00d6:
            androidx.constraintlayout.a.a.e r0 = r7.f1535t
            int r0 = r0.mo3012e()
            int r1 = r7.mo3085r()
            int r0 = r0 + r1
            int r3 = r3 + r0
        L_0x00e2:
            int r0 = r7.mo3085r()
            int r0 = r3 - r0
            r7.mo3056d(r0, r3)
            r7.f1492X = r2
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.p020a.C0429h.m1721a(androidx.constraintlayout.a.a.f):void");
    }

    /* renamed from: a */
    private void m1722a(ArrayList<C0425f> arrayList, C0425f fVar) {
        if (!fVar.f1493Y) {
            arrayList.add(fVar);
            fVar.f1493Y = true;
            if (!fVar.mo3066h()) {
                if (fVar instanceof C0432j) {
                    C0432j jVar = (C0432j) fVar;
                    int i = jVar.f1593aj;
                    for (int i2 = 0; i2 < i; i2++) {
                        m1722a(arrayList, jVar.f1592ai[i2]);
                    }
                }
                for (C0420e eVar : fVar.f1470A) {
                    C0420e eVar2 = eVar.f1443c;
                    if (eVar2 != null) {
                        C0425f fVar2 = eVar2.f1441a;
                        if (!(eVar2 == null || fVar2 == fVar.mo3071k())) {
                            m1722a(arrayList, fVar2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C0425f> mo3114a() {
        if (!this.f1580j.isEmpty()) {
            return this.f1580j;
        }
        int size = this.f1571a.size();
        for (int i = 0; i < size; i++) {
            C0425f fVar = this.f1571a.get(i);
            if (!fVar.f1491W) {
                m1722a((ArrayList<C0425f>) (ArrayList) this.f1580j, fVar);
            }
        }
        this.f1581k.clear();
        this.f1581k.addAll(this.f1571a);
        this.f1581k.removeAll(this.f1580j);
        return this.f1580j;
    }

    /* renamed from: a */
    public List<C0425f> mo3115a(int i) {
        if (i == 0) {
            return this.f1576f;
        }
        if (i == 1) {
            return this.f1577g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3116a(C0425f fVar, int i) {
        HashSet<C0425f> hashSet;
        if (i == 0) {
            hashSet = this.f1578h;
        } else if (i == 1) {
            hashSet = this.f1579i;
        } else {
            return;
        }
        hashSet.add(fVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Set<C0425f> mo3117b(int i) {
        if (i == 0) {
            return this.f1578h;
        }
        if (i == 1) {
            return this.f1579i;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3118b() {
        int size = this.f1581k.size();
        for (int i = 0; i < size; i++) {
            m1721a(this.f1581k.get(i));
        }
    }
}
