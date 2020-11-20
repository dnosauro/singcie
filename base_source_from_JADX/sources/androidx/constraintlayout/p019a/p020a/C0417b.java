package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.C0444e;
import androidx.constraintlayout.p019a.C0450h;
import androidx.constraintlayout.p019a.p020a.C0425f;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.a.a.b */
public class C0417b extends C0432j {

    /* renamed from: ak */
    private int f1421ak = 0;

    /* renamed from: al */
    private ArrayList<C0435m> f1422al = new ArrayList<>(4);

    /* renamed from: am */
    private boolean f1423am = true;

    /* renamed from: a */
    public void mo2996a(int i) {
        this.f1421ak = i;
    }

    /* renamed from: a */
    public void mo2997a(C0444e eVar) {
        boolean z;
        C0450h hVar;
        C0420e eVar2;
        int i;
        int i2;
        this.f1470A[0] = this.f1534s;
        this.f1470A[2] = this.f1535t;
        this.f1470A[1] = this.f1536u;
        this.f1470A[3] = this.f1537v;
        for (int i3 = 0; i3 < this.f1470A.length; i3++) {
            this.f1470A[i3].f1446f = eVar.mo3179a((Object) this.f1470A[i3]);
        }
        int i4 = this.f1421ak;
        if (i4 >= 0 && i4 < 4) {
            C0420e eVar3 = this.f1470A[this.f1421ak];
            int i5 = 0;
            while (true) {
                if (i5 >= this.f1593aj) {
                    z = false;
                    break;
                }
                C0425f fVar = this.f1592ai[i5];
                if ((this.f1423am || fVar.mo2999a()) && ((((i = this.f1421ak) == 0 || i == 1) && fVar.mo3024F() == C0425f.C0427a.MATCH_CONSTRAINT) || (((i2 = this.f1421ak) == 2 || i2 == 3) && fVar.mo3025G() == C0425f.C0427a.MATCH_CONSTRAINT))) {
                    z = true;
                } else {
                    i5++;
                }
            }
            z = true;
            int i6 = this.f1421ak;
            if (i6 == 0 || i6 == 1 ? mo3071k().mo3024F() == C0425f.C0427a.WRAP_CONTENT : mo3071k().mo3025G() == C0425f.C0427a.WRAP_CONTENT) {
                z = false;
            }
            for (int i7 = 0; i7 < this.f1593aj; i7++) {
                C0425f fVar2 = this.f1592ai[i7];
                if (this.f1423am || fVar2.mo2999a()) {
                    C0450h a = eVar.mo3179a((Object) fVar2.f1470A[this.f1421ak]);
                    C0420e[] eVarArr = fVar2.f1470A;
                    int i8 = this.f1421ak;
                    eVarArr[i8].f1446f = a;
                    if (i8 == 0 || i8 == 2) {
                        eVar.mo3192b(eVar3.f1446f, a, z);
                    } else {
                        eVar.mo3188a(eVar3.f1446f, a, z);
                    }
                }
            }
            int i9 = this.f1421ak;
            if (i9 == 0) {
                eVar.mo3194c(this.f1536u.f1446f, this.f1534s.f1446f, 0, 6);
                if (!z) {
                    hVar = this.f1534s.f1446f;
                    eVar2 = this.f1473D.f1536u;
                } else {
                    return;
                }
            } else if (i9 == 1) {
                eVar.mo3194c(this.f1534s.f1446f, this.f1536u.f1446f, 0, 6);
                if (!z) {
                    hVar = this.f1534s.f1446f;
                    eVar2 = this.f1473D.f1534s;
                } else {
                    return;
                }
            } else if (i9 == 2) {
                eVar.mo3194c(this.f1537v.f1446f, this.f1535t.f1446f, 0, 6);
                if (!z) {
                    hVar = this.f1535t.f1446f;
                    eVar2 = this.f1473D.f1537v;
                } else {
                    return;
                }
            } else if (i9 == 3) {
                eVar.mo3194c(this.f1535t.f1446f, this.f1537v.f1446f, 0, 6);
                if (!z) {
                    hVar = this.f1535t.f1446f;
                    eVar2 = this.f1473D.f1535t;
                } else {
                    return;
                }
            } else {
                return;
            }
            eVar.mo3194c(hVar, eVar2.f1446f, 0, 5);
        }
    }

    /* renamed from: a */
    public void mo2998a(boolean z) {
        this.f1423am = z;
    }

    /* renamed from: a */
    public boolean mo2999a() {
        return true;
    }

    /* renamed from: b */
    public void mo3000b() {
        super.mo3000b();
        this.f1422al.clear();
    }

    /* renamed from: b */
    public void mo3001b(int i) {
        C0420e eVar;
        C0420e eVar2;
        C0435m mVar;
        C0420e eVar3;
        if (this.f1473D != null && ((C0428g) this.f1473D).mo3113u(2)) {
            switch (this.f1421ak) {
                case 0:
                    eVar = this.f1534s;
                    break;
                case 1:
                    eVar = this.f1536u;
                    break;
                case 2:
                    eVar = this.f1535t;
                    break;
                case 3:
                    eVar = this.f1537v;
                    break;
                default:
                    return;
            }
            C0435m a = eVar.mo3004a();
            a.mo3131b(5);
            int i2 = this.f1421ak;
            if (i2 == 0 || i2 == 1) {
                this.f1535t.mo3004a().mo3126a((C0435m) null, 0.0f);
                eVar2 = this.f1537v;
            } else {
                this.f1534s.mo3004a().mo3126a((C0435m) null, 0.0f);
                eVar2 = this.f1536u;
            }
            eVar2.mo3004a().mo3126a((C0435m) null, 0.0f);
            this.f1422al.clear();
            for (int i3 = 0; i3 < this.f1593aj; i3++) {
                C0425f fVar = this.f1592ai[i3];
                if (this.f1423am || fVar.mo2999a()) {
                    switch (this.f1421ak) {
                        case 0:
                            eVar3 = fVar.f1534s;
                            break;
                        case 1:
                            eVar3 = fVar.f1536u;
                            break;
                        case 2:
                            eVar3 = fVar.f1535t;
                            break;
                        case 3:
                            eVar3 = fVar.f1537v;
                            break;
                        default:
                            mVar = null;
                            break;
                    }
                    mVar = eVar3.mo3004a();
                    if (mVar != null) {
                        this.f1422al.add(mVar);
                        mVar.mo3139a(a);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r4 >= r2) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r5 = r8.f1422al.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r5.f1610i == 1) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r6 = r8.f1421ak;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r6 == 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r6 != 2) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r5.f1600f <= r1) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r5.f1600f >= r1) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        r1 = r5.f1600f;
        r3 = r5.f1599e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        if (androidx.constraintlayout.p019a.C0444e.m1810a() == null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        androidx.constraintlayout.p019a.C0444e.m1810a().f1677z++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        r0.f1599e = r3;
        r0.f1600f = r1;
        r0.mo3141f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        switch(r8.f1421ak) {
            case 0: goto L_0x0079;
            case 1: goto L_0x0076;
            case 2: goto L_0x0073;
            case 3: goto L_0x0070;
            default: goto L_0x006f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        r0 = r8.f1535t;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0073, code lost:
        r0 = r8.f1537v;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0076, code lost:
        r0 = r8.f1534s;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
        r0 = r8.f1536u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        r0.mo3004a().mo3126a(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0082, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r0.mo3004a();
        r1 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r0 = r0.mo3004a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        r2 = r8.f1422al.size();
        r3 = null;
        r4 = 0;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3002c() {
        /*
            r8 = this;
            int r0 = r8.f1421ak
            r1 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = 0
            switch(r0) {
                case 0: goto L_0x0018;
                case 1: goto L_0x0010;
                case 2: goto L_0x000d;
                case 3: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            return
        L_0x000a:
            androidx.constraintlayout.a.a.e r0 = r8.f1537v
            goto L_0x0012
        L_0x000d:
            androidx.constraintlayout.a.a.e r0 = r8.f1535t
            goto L_0x001a
        L_0x0010:
            androidx.constraintlayout.a.a.e r0 = r8.f1536u
        L_0x0012:
            androidx.constraintlayout.a.a.m r0 = r0.mo3004a()
            r1 = 0
            goto L_0x001e
        L_0x0018:
            androidx.constraintlayout.a.a.e r0 = r8.f1534s
        L_0x001a:
            androidx.constraintlayout.a.a.m r0 = r0.mo3004a()
        L_0x001e:
            java.util.ArrayList<androidx.constraintlayout.a.a.m> r2 = r8.f1422al
            int r2 = r2.size()
            r3 = 0
            r4 = 0
        L_0x0026:
            if (r4 >= r2) goto L_0x0052
            java.util.ArrayList<androidx.constraintlayout.a.a.m> r5 = r8.f1422al
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.a.a.m r5 = (androidx.constraintlayout.p019a.p020a.C0435m) r5
            int r6 = r5.f1610i
            r7 = 1
            if (r6 == r7) goto L_0x0036
            return
        L_0x0036:
            int r6 = r8.f1421ak
            if (r6 == 0) goto L_0x0045
            r7 = 2
            if (r6 != r7) goto L_0x003e
            goto L_0x0045
        L_0x003e:
            float r6 = r5.f1600f
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x004f
            goto L_0x004b
        L_0x0045:
            float r6 = r5.f1600f
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x004f
        L_0x004b:
            float r1 = r5.f1600f
            androidx.constraintlayout.a.a.m r3 = r5.f1599e
        L_0x004f:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0052:
            androidx.constraintlayout.a.f r2 = androidx.constraintlayout.p019a.C0444e.m1810a()
            if (r2 == 0) goto L_0x0063
            androidx.constraintlayout.a.f r2 = androidx.constraintlayout.p019a.C0444e.m1810a()
            long r4 = r2.f1677z
            r6 = 1
            long r4 = r4 + r6
            r2.f1677z = r4
        L_0x0063:
            r0.f1599e = r3
            r0.f1600f = r1
            r0.mo3141f()
            int r0 = r8.f1421ak
            switch(r0) {
                case 0: goto L_0x0079;
                case 1: goto L_0x0076;
                case 2: goto L_0x0073;
                case 3: goto L_0x0070;
                default: goto L_0x006f;
            }
        L_0x006f:
            return
        L_0x0070:
            androidx.constraintlayout.a.a.e r0 = r8.f1535t
            goto L_0x007b
        L_0x0073:
            androidx.constraintlayout.a.a.e r0 = r8.f1537v
            goto L_0x007b
        L_0x0076:
            androidx.constraintlayout.a.a.e r0 = r8.f1534s
            goto L_0x007b
        L_0x0079:
            androidx.constraintlayout.a.a.e r0 = r8.f1536u
        L_0x007b:
            androidx.constraintlayout.a.a.m r0 = r0.mo3004a()
            r0.mo3126a((androidx.constraintlayout.p019a.p020a.C0435m) r3, (float) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.p020a.C0417b.mo3002c():void");
    }
}
