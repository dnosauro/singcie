package com.cyberneid.p089b.p091b;

import com.cyberneid.p089b.p091b.C1491j;
import com.parse.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.eac.CertificateBody;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.b.b.k */
public class C1493k {

    /* renamed from: a */
    private C1484c f4454a = null;

    /* renamed from: b */
    private C1511l f4455b = null;

    /* renamed from: c */
    private C1524t f4456c = null;

    /* renamed from: d */
    private C1524t f4457d = null;

    /* renamed from: e */
    private C1524t f4458e = null;

    /* renamed from: f */
    private String f4459f;

    /* renamed from: com.cyberneid.b.b.k$a */
    static abstract class C1495a extends C1485d {
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f4460c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public C1496a[] f4461d;

        /* renamed from: com.cyberneid.b.b.k$a$a */
        static class C1496a {
            /* access modifiers changed from: private */

            /* renamed from: a */
            public int f4462a;
            /* access modifiers changed from: private */

            /* renamed from: b */
            public int f4463b;
            /* access modifiers changed from: private */

            /* renamed from: c */
            public String f4464c;

            C1496a() {
            }

            public String toString() {
                return getClass().getName() + "[code=" + this.f4462a + ", sid=" + this.f4463b + "]";
            }
        }

        C1495a() {
        }
    }

    /* renamed from: com.cyberneid.b.b.k$b */
    private static class C1497b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public List<C1498a> f4465a;

        /* renamed from: com.cyberneid.b.b.k$b$a */
        private static class C1498a {
            /* access modifiers changed from: private */

            /* renamed from: a */
            public List<Number> f4466a;
            /* access modifiers changed from: private */

            /* renamed from: b */
            public C1491j f4467b;

            private C1498a() {
                this.f4466a = new ArrayList();
                this.f4467b = null;
            }

            /* renamed from: a */
            public Number mo7084a(int i) {
                return this.f4466a.get(i);
            }

            /* renamed from: a */
            public List<Number> mo7085a() {
                return this.f4466a;
            }

            /* renamed from: b */
            public Boolean mo7086b(int i) {
                Number number = this.f4466a.get(i);
                if (number instanceof Integer) {
                    switch (number.intValue()) {
                        case 0:
                            return Boolean.FALSE;
                        case 1:
                            return Boolean.TRUE;
                    }
                }
                throw new IllegalArgumentException();
            }

            public String toString() {
                return getClass().getName() + "[operands=" + this.f4466a + ", operator=" + this.f4467b + "]";
            }
        }

        private C1497b() {
            this.f4465a = null;
        }

        /* renamed from: a */
        private C1498a m5732a(C1491j jVar) {
            for (C1498a next : this.f4465a) {
                if (next != null && next.f4467b != null && next.f4467b.equals(jVar)) {
                    return next;
                }
            }
            return null;
        }

        /* renamed from: a */
        public C1498a mo7082a(String str) {
            return m5732a(C1491j.m5683a(str));
        }

        public String toString() {
            return getClass().getName() + "[entries=" + this.f4465a + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$c */
    static abstract class C1499c extends C1483b {
        protected C1499c(boolean z) {
            super(z);
        }
    }

    /* renamed from: com.cyberneid.b.b.k$d */
    private static class C1500d extends C1499c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        protected C1500d(int i) {
            super(true);
            mo7051a(0, 0);
            for (int i2 = 1; i2 <= i; i2++) {
                mo7051a(i2, i2);
            }
        }

        public String toString() {
            return getClass().getName();
        }
    }

    /* renamed from: com.cyberneid.b.b.k$e */
    private static class C1501e extends C1499c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f4468a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int[] f4469b;

        protected C1501e(boolean z) {
            super(z);
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f4468a + ", glyph=" + Arrays.toString(this.f4469b) + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$f */
    private static class C1502f extends C1495a {
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f4470c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f4471d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int[] f4472e;

        private C1502f() {
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f4470c + ", nCodes=" + this.f4471d + ", code=" + Arrays.toString(this.f4472e) + ", supplement=" + Arrays.toString(this.f4461d) + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$g */
    private static class C1503g extends C1523s {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f4473b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int[] f4474c;

        private C1503g(C1480a aVar) {
            super(aVar);
        }

        /* renamed from: a */
        public int mo7091a(int i) {
            int[] iArr = this.f4474c;
            if (i < iArr.length) {
                return iArr[i];
            }
            return 0;
        }

        public String toString() {
            return getClass().getName() + "[fds=" + Arrays.toString(this.f4474c) + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$h */
    private static class C1504h extends C1499c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f4475a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C1505a[] f4476b;

        /* renamed from: com.cyberneid.b.b.k$h$a */
        private static class C1505a {
            /* access modifiers changed from: private */

            /* renamed from: a */
            public int f4477a;
            /* access modifiers changed from: private */

            /* renamed from: b */
            public int f4478b;

            private C1505a() {
            }

            public String toString() {
                return getClass().getName() + "[first=" + this.f4477a + ", nLeft=" + this.f4478b + "]";
            }
        }

        protected C1504h(boolean z) {
            super(z);
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f4475a + ", range=" + Arrays.toString(this.f4476b) + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$i */
    private static class C1506i extends C1495a {
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f4479c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f4480d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public C1507a[] f4481e;

        /* renamed from: com.cyberneid.b.b.k$i$a */
        private static class C1507a {
            /* access modifiers changed from: private */

            /* renamed from: a */
            public int f4482a;
            /* access modifiers changed from: private */

            /* renamed from: b */
            public int f4483b;

            private C1507a() {
            }

            public String toString() {
                return getClass().getName() + "[first=" + this.f4482a + ", nLeft=" + this.f4483b + "]";
            }
        }

        private C1506i() {
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f4479c + ", nRanges=" + this.f4480d + ", range=" + Arrays.toString(this.f4481e) + ", supplement=" + Arrays.toString(this.f4461d) + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$j */
    private static class C1508j extends C1499c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f4484a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C1509a[] f4485b;

        /* renamed from: com.cyberneid.b.b.k$j$a */
        private static class C1509a {
            /* access modifiers changed from: private */

            /* renamed from: a */
            public int f4486a;
            /* access modifiers changed from: private */

            /* renamed from: b */
            public int f4487b;

            private C1509a() {
            }

            public String toString() {
                return getClass().getName() + "[first=" + this.f4486a + ", nLeft=" + this.f4487b + "]";
            }
        }

        protected C1508j(boolean z) {
            super(z);
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f4484a + ", range=" + Arrays.toString(this.f4485b) + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$k */
    private static final class C1510k extends C1523s {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f4488b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f4489c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public C1512m[] f4490d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f4491e;

        private C1510k(C1480a aVar) {
            super(aVar);
        }

        /* renamed from: a */
        public int mo7091a(int i) {
            C1512m mVar;
            for (int i2 = 0; i2 < this.f4489c; i2++) {
                if (this.f4490d[i2].f4496a <= i) {
                    int i3 = i2 + 1;
                    if (i3 < this.f4489c) {
                        if (this.f4490d[i3].f4496a > i) {
                            mVar = this.f4490d[i2];
                        }
                    } else if (this.f4491e <= i) {
                        return -1;
                    } else {
                        mVar = this.f4490d[i2];
                    }
                    return mVar.f4497b;
                }
            }
            return 0;
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f4488b + " nbRanges=" + this.f4489c + ", range3=" + Arrays.toString(this.f4490d) + " sentinel=" + this.f4491e + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$l */
    private static class C1511l {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f4492a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f4493b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f4494c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f4495d;

        private C1511l() {
        }

        public String toString() {
            return getClass().getName() + "[major=" + this.f4492a + ", minor=" + this.f4493b + ", hdrSize=" + this.f4494c + ", offSize=" + this.f4495d + "]";
        }
    }

    /* renamed from: com.cyberneid.b.b.k$m */
    private static final class C1512m {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f4496a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f4497b;

        private C1512m() {
        }

        public String toString() {
            return getClass().getName() + "[first=" + this.f4496a + ", fd=" + this.f4497b + "]";
        }
    }

    /* renamed from: a */
    private C1483b m5691a(C1484c cVar, int i, boolean z) {
        int a = cVar.mo7055a();
        if (a == 0) {
            return m5695a(cVar, a, i, z);
        }
        if (a == 1) {
            return m5710b(cVar, a, i, z);
        }
        if (a == 2) {
            return m5715c(cVar, a, i, z);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private C1485d m5692a(C1484c cVar, C1483b bVar) {
        int a = cVar.mo7055a();
        int i = a & CertificateBody.profileType;
        if (i == 0) {
            return m5696a(cVar, bVar, a);
        }
        if (i == 1) {
            return m5711b(cVar, bVar, a);
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x021d A[LOOP:0: B:26:0x0217->B:28:0x021d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x02a1  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.cyberneid.p089b.p091b.C1489h m5693a(int r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.cyberneid.b.b.r r2 = new com.cyberneid.b.b.r
            com.cyberneid.b.b.t r3 = r0.f4456c
            byte[] r3 = r3.mo7130a(r1)
            r2.<init>(r3)
            java.lang.String r2 = r2.mo7122f()
            com.cyberneid.b.b.c r3 = new com.cyberneid.b.b.c
            com.cyberneid.b.b.t r4 = r0.f4457d
            byte[] r1 = r4.mo7130a(r1)
            r3.<init>(r1)
            com.cyberneid.b.b.k$b r1 = m5720e(r3)
            java.lang.String r3 = "SyntheticBase"
            com.cyberneid.b.b.k$b$a r3 = r1.mo7082a((java.lang.String) r3)
            if (r3 != 0) goto L_0x02a8
            java.lang.String r3 = "ROS"
            com.cyberneid.b.b.k$b$a r3 = r1.mo7082a((java.lang.String) r3)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            r6 = 2
            if (r3 == 0) goto L_0x0072
            com.cyberneid.b.b.a r7 = new com.cyberneid.b.b.a
            r7.<init>()
            java.lang.String r8 = "ROS"
            com.cyberneid.b.b.k$b$a r8 = r1.mo7082a((java.lang.String) r8)
            r9 = r7
            com.cyberneid.b.b.a r9 = (com.cyberneid.p089b.p091b.C1480a) r9
            java.lang.Number r10 = r8.mo7084a((int) r5)
            int r10 = r10.intValue()
            java.lang.String r10 = r0.m5713b((int) r10)
            r9.mo7043c((java.lang.String) r10)
            java.lang.Number r10 = r8.mo7084a((int) r4)
            int r10 = r10.intValue()
            java.lang.String r10 = r0.m5713b((int) r10)
            r9.mo7044d((java.lang.String) r10)
            java.lang.Number r8 = r8.mo7084a((int) r6)
            int r8 = r8.intValue()
            r9.mo7038a((int) r8)
            goto L_0x0077
        L_0x0072:
            com.cyberneid.b.b.n r7 = new com.cyberneid.b.b.n
            r7.<init>()
        L_0x0077:
            r0.f4459f = r2
            r7.mo7067e(r2)
            java.lang.String r2 = "version"
            java.lang.String r8 = "version"
            java.lang.String r8 = r0.m5702a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "Notice"
            java.lang.String r8 = "Notice"
            java.lang.String r8 = r0.m5702a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "Copyright"
            java.lang.String r8 = "Copyright"
            java.lang.String r8 = r0.m5702a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "FullName"
            java.lang.String r8 = "FullName"
            java.lang.String r8 = r0.m5702a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "FamilyName"
            java.lang.String r8 = "FamilyName"
            java.lang.String r8 = r0.m5702a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "Weight"
            java.lang.String r8 = "Weight"
            java.lang.String r8 = r0.m5702a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "isFixedPitch"
            java.lang.String r8 = "isFixedPitch"
            java.lang.Boolean r8 = m5699a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (boolean) r5)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "ItalicAngle"
            java.lang.String r8 = "ItalicAngle"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            java.lang.Number r8 = m5700a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.lang.Number) r9)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "UnderlinePosition"
            java.lang.String r8 = "UnderlinePosition"
            r9 = -100
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Number r8 = m5700a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.lang.Number) r9)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "UnderlineThickness"
            java.lang.String r8 = "UnderlineThickness"
            r9 = 50
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Number r8 = m5700a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.lang.Number) r9)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "PaintType"
            java.lang.String r8 = "PaintType"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            java.lang.Number r8 = m5700a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.lang.Number) r9)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "CharstringType"
            java.lang.String r8 = "CharstringType"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            java.lang.Number r8 = m5700a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.lang.Number) r9)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "FontMatrix"
            java.lang.String r8 = "FontMatrix"
            r9 = 6
            java.lang.Number[] r10 = new java.lang.Number[r9]
            r11 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            java.lang.Double r13 = java.lang.Double.valueOf(r11)
            r10[r5] = r13
            r13 = 0
            java.lang.Double r15 = java.lang.Double.valueOf(r13)
            r10[r4] = r15
            java.lang.Double r15 = java.lang.Double.valueOf(r13)
            r10[r6] = r15
            java.lang.Double r15 = java.lang.Double.valueOf(r11)
            r16 = 3
            r10[r16] = r15
            java.lang.Double r15 = java.lang.Double.valueOf(r13)
            r11 = 4
            r10[r11] = r15
            java.lang.Double r12 = java.lang.Double.valueOf(r13)
            r15 = 5
            r10[r15] = r12
            java.util.List r10 = java.util.Arrays.asList(r10)
            java.util.List r8 = m5703a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.util.List<java.lang.Number>) r10)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "UniqueID"
            java.lang.String r8 = "UniqueID"
            r10 = 0
            java.lang.Number r8 = m5700a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.lang.Number) r10)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "FontBBox"
            java.lang.String r8 = "FontBBox"
            java.lang.Number[] r12 = new java.lang.Number[r11]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)
            r12[r5] = r17
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)
            r12[r4] = r17
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)
            r12[r6] = r17
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)
            r12[r16] = r17
            java.util.List r12 = java.util.Arrays.asList(r12)
            java.util.List r8 = m5703a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.util.List<java.lang.Number>) r12)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "StrokeWidth"
            java.lang.String r8 = "StrokeWidth"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
            java.lang.Number r8 = m5700a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.lang.Number) r12)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "XUID"
            java.lang.String r8 = "XUID"
            java.util.List r8 = m5703a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r8, (java.util.List<java.lang.Number>) r10)
            r7.mo7065a(r2, r8)
            java.lang.String r2 = "CharStrings"
            com.cyberneid.b.b.k$b$a r2 = r1.mo7082a((java.lang.String) r2)
            java.lang.Number r2 = r2.mo7084a((int) r5)
            int r2 = r2.intValue()
            com.cyberneid.b.b.c r8 = r0.f4454a
            r8.mo7118b(r2)
            com.cyberneid.b.b.c r2 = r0.f4454a
            com.cyberneid.b.b.t r2 = m5718d(r2)
            java.lang.String r8 = "charset"
            com.cyberneid.b.b.k$b$a r8 = r1.mo7082a((java.lang.String) r8)
            if (r8 == 0) goto L_0x01f8
            java.lang.Number r8 = r8.mo7084a((int) r5)
            int r8 = r8.intValue()
            if (r3 != 0) goto L_0x01d6
            if (r8 != 0) goto L_0x01d6
            goto L_0x0204
        L_0x01d6:
            if (r3 != 0) goto L_0x01df
            if (r8 != r4) goto L_0x01df
            com.cyberneid.b.b.e r8 = com.cyberneid.p089b.p091b.C1486e.m5670a()
            goto L_0x0208
        L_0x01df:
            if (r3 != 0) goto L_0x01e8
            if (r8 != r6) goto L_0x01e8
            com.cyberneid.b.b.g r8 = com.cyberneid.p089b.p091b.C1488g.m5672a()
            goto L_0x0208
        L_0x01e8:
            com.cyberneid.b.b.c r10 = r0.f4454a
            r10.mo7118b(r8)
            com.cyberneid.b.b.c r8 = r0.f4454a
            int r10 = r2.mo7128a()
            com.cyberneid.b.b.b r8 = r0.m5691a((com.cyberneid.p089b.p091b.C1484c) r8, (int) r10, (boolean) r3)
            goto L_0x0208
        L_0x01f8:
            if (r3 == 0) goto L_0x0204
            com.cyberneid.b.b.k$d r8 = new com.cyberneid.b.b.k$d
            int r10 = r2.mo7128a()
            r8.<init>(r10)
            goto L_0x0208
        L_0x0204:
            com.cyberneid.b.b.i r8 = com.cyberneid.p089b.p091b.C1490i.m5681a()
        L_0x0208:
            r7.mo7063a((com.cyberneid.p089b.p091b.C1483b) r8)
            java.util.List r10 = r7.mo7068h()
            byte[] r12 = r2.mo7130a(r5)
            r10.add(r12)
            r10 = 1
        L_0x0217:
            int r12 = r2.mo7128a()
            if (r10 >= r12) goto L_0x022c
            byte[] r12 = r2.mo7130a(r10)
            java.util.List r15 = r7.mo7068h()
            r15.add(r12)
            int r10 = r10 + 1
            r15 = 5
            goto L_0x0217
        L_0x022c:
            if (r3 == 0) goto L_0x02a1
            r3 = r7
            com.cyberneid.b.b.a r3 = (com.cyberneid.p089b.p091b.C1480a) r3
            r0.m5706a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (com.cyberneid.p089b.p091b.C1480a) r3, (com.cyberneid.p089b.p091b.C1524t) r2)
            java.lang.String r2 = "FontMatrix"
            com.cyberneid.b.b.k$b$a r2 = r1.mo7082a((java.lang.String) r2)
            if (r2 != 0) goto L_0x02a7
            java.util.List r2 = r3.mo7047g()
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x0265
            java.lang.Object r3 = r2.get(r5)
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r8 = "FontMatrix"
            boolean r3 = r3.containsKey(r8)
            if (r3 == 0) goto L_0x0265
            java.lang.Object r1 = r2.get(r5)
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = "FontMatrix"
            java.lang.Object r1 = r1.get(r2)
            java.util.List r1 = (java.util.List) r1
            java.lang.String r2 = "FontMatrix"
            goto L_0x029d
        L_0x0265:
            java.lang.String r2 = "FontMatrix"
            java.lang.String r3 = "FontMatrix"
            java.lang.Number[] r8 = new java.lang.Number[r9]
            r9 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            java.lang.Double r12 = java.lang.Double.valueOf(r9)
            r8[r5] = r12
            java.lang.Double r5 = java.lang.Double.valueOf(r13)
            r8[r4] = r5
            java.lang.Double r4 = java.lang.Double.valueOf(r13)
            r8[r6] = r4
            java.lang.Double r4 = java.lang.Double.valueOf(r9)
            r8[r16] = r4
            java.lang.Double r4 = java.lang.Double.valueOf(r13)
            r8[r11] = r4
            java.lang.Double r4 = java.lang.Double.valueOf(r13)
            r5 = 5
            r8[r5] = r4
            java.util.List r4 = java.util.Arrays.asList(r8)
            java.util.List r1 = m5703a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (java.lang.String) r3, (java.util.List<java.lang.Number>) r4)
        L_0x029d:
            r7.mo7065a(r2, r1)
            goto L_0x02a7
        L_0x02a1:
            r2 = r7
            com.cyberneid.b.b.n r2 = (com.cyberneid.p089b.p091b.C1515n) r2
            r0.m5707a((com.cyberneid.p089b.p091b.C1493k.C1497b) r1, (com.cyberneid.p089b.p091b.C1515n) r2, (com.cyberneid.p089b.p091b.C1483b) r8)
        L_0x02a7:
            return r7
        L_0x02a8:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Synthetic Fonts are not supported"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p089b.p091b.C1493k.m5693a(int):com.cyberneid.b.b.h");
    }

    /* renamed from: a */
    private static C1491j m5694a(C1484c cVar, int i) {
        return C1491j.m5682a(m5709b(cVar, i));
    }

    /* renamed from: a */
    private C1501e m5695a(C1484c cVar, int i, int i2, boolean z) {
        C1501e eVar = new C1501e(z);
        int unused = eVar.f4468a = i;
        int[] unused2 = eVar.f4469b = new int[i2];
        eVar.f4469b[0] = 0;
        if (z) {
            eVar.mo7051a(0, 0);
        } else {
            eVar.mo7052a(0, 0, ".notdef");
        }
        for (int i3 = 1; i3 < eVar.f4469b.length; i3++) {
            int d = cVar.mo7059d();
            eVar.f4469b[i3] = d;
            if (z) {
                eVar.mo7051a(i3, d);
            } else {
                eVar.mo7052a(i3, d, m5713b(d));
            }
        }
        return eVar;
    }

    /* renamed from: a */
    private C1502f m5696a(C1484c cVar, C1483b bVar, int i) {
        C1502f fVar = new C1502f();
        int unused = fVar.f4470c = i;
        int unused2 = fVar.f4471d = cVar.mo7055a();
        int[] unused3 = fVar.f4472e = new int[fVar.f4471d];
        fVar.mo7062a(0, 0, ".notdef");
        for (int i2 = 1; i2 <= fVar.f4471d; i2++) {
            int a = cVar.mo7055a();
            fVar.f4472e[i2 - 1] = a;
            int a2 = bVar.mo7049a(i2);
            fVar.mo7062a(a, a2, m5713b(a2));
        }
        if ((i & 128) != 0) {
            m5705a(cVar, (C1495a) fVar);
        }
        return fVar;
    }

    /* renamed from: a */
    private static C1503g m5697a(C1484c cVar, int i, int i2, C1480a aVar) {
        C1503g gVar = new C1503g(aVar);
        int unused = gVar.f4473b = i;
        int[] unused2 = gVar.f4474c = new int[i2];
        for (int i3 = 0; i3 < gVar.f4474c.length; i3++) {
            gVar.f4474c[i3] = cVar.mo7055a();
        }
        return gVar;
    }

    /* renamed from: a */
    private static C1523s m5698a(C1484c cVar, int i, C1480a aVar) {
        int a = cVar.mo7055a();
        if (a == 0) {
            return m5697a(cVar, a, i, aVar);
        }
        if (a == 3) {
            return m5712b(cVar, a, i, aVar);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private static Boolean m5699a(C1497b bVar, String str, boolean z) {
        C1497b.C1498a a = bVar.mo7082a(str);
        if (a != null) {
            z = a.mo7086b(0).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: a */
    private static Number m5700a(C1497b bVar, String str, Number number) {
        C1497b.C1498a a = bVar.mo7082a(str);
        return a != null ? a.mo7084a(0) : number;
    }

    /* renamed from: a */
    private static String m5701a(C1484c cVar) {
        return new String(cVar.mo7120d(4), LocalizedMessage.DEFAULT_ENCODING);
    }

    /* renamed from: a */
    private String m5702a(C1497b bVar, String str) {
        C1497b.C1498a a = bVar.mo7082a(str);
        if (a != null) {
            return m5713b(a.mo7084a(0).intValue());
        }
        return null;
    }

    /* renamed from: a */
    private static List<Number> m5703a(C1497b bVar, String str, List<Number> list) {
        C1497b.C1498a a = bVar.mo7082a(str);
        return a != null ? a.mo7085a() : list;
    }

    /* renamed from: a */
    private Map<String, Object> m5704a(C1497b bVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BlueValues", m5714b(bVar, "BlueValues", (List<Number>) null));
        linkedHashMap.put("OtherBlues", m5714b(bVar, "OtherBlues", (List<Number>) null));
        linkedHashMap.put("FamilyBlues", m5714b(bVar, "FamilyBlues", (List<Number>) null));
        linkedHashMap.put("FamilyOtherBlues", m5714b(bVar, "FamilyOtherBlues", (List<Number>) null));
        linkedHashMap.put("BlueScale", m5700a(bVar, "BlueScale", (Number) Double.valueOf(0.039625d)));
        linkedHashMap.put("BlueShift", m5700a(bVar, "BlueShift", (Number) 7));
        linkedHashMap.put("BlueFuzz", m5700a(bVar, "BlueFuzz", (Number) 1));
        linkedHashMap.put("StdHW", m5700a(bVar, "StdHW", (Number) null));
        linkedHashMap.put("StdVW", m5700a(bVar, "StdVW", (Number) null));
        linkedHashMap.put("StemSnapH", m5714b(bVar, "StemSnapH", (List<Number>) null));
        linkedHashMap.put("StemSnapV", m5714b(bVar, "StemSnapV", (List<Number>) null));
        linkedHashMap.put("ForceBold", m5699a(bVar, "ForceBold", false));
        linkedHashMap.put("LanguageGroup", m5700a(bVar, "LanguageGroup", (Number) 0));
        linkedHashMap.put("ExpansionFactor", m5700a(bVar, "ExpansionFactor", (Number) Double.valueOf(0.06d)));
        linkedHashMap.put("initialRandomSeed", m5700a(bVar, "initialRandomSeed", (Number) 0));
        linkedHashMap.put("defaultWidthX", m5700a(bVar, "defaultWidthX", (Number) 0));
        linkedHashMap.put("nominalWidthX", m5700a(bVar, "nominalWidthX", (Number) 0));
        return linkedHashMap;
    }

    /* renamed from: a */
    private void m5705a(C1484c cVar, C1495a aVar) {
        int unused = aVar.f4460c = cVar.mo7055a();
        C1495a.C1496a[] unused2 = aVar.f4461d = new C1495a.C1496a[aVar.f4460c];
        for (int i = 0; i < aVar.f4461d.length; i++) {
            C1495a.C1496a aVar2 = new C1495a.C1496a();
            int unused3 = aVar2.f4462a = cVar.mo7055a();
            int unused4 = aVar2.f4463b = cVar.mo7059d();
            String unused5 = aVar2.f4464c = m5713b(aVar2.f4463b);
            aVar.f4461d[i] = aVar2;
            aVar.mo7062a(aVar2.f4462a, aVar2.f4463b, m5713b(aVar2.f4463b));
        }
    }

    /* renamed from: a */
    private void m5706a(C1497b bVar, C1480a aVar, C1524t tVar) {
        C1497b.C1498a a = bVar.mo7082a("FDArray");
        if (a != null) {
            this.f4454a.mo7118b(a.mo7084a(0).intValue());
            C1524t d = m5718d(this.f4454a);
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int i = 0;
            while (i < d.mo7128a()) {
                C1497b e = m5720e(new C1484c(d.mo7130a(i)));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("FontName", m5702a(e, "FontName"));
                linkedHashMap.put("FontType", m5700a(e, "FontType", (Number) 0));
                linkedHashMap.put("FontBBox", m5714b(e, "FontBBox", (List<Number>) null));
                linkedHashMap.put("FontMatrix", m5714b(e, "FontMatrix", (List<Number>) null));
                linkedList2.add(linkedHashMap);
                C1497b.C1498a a2 = e.mo7082a("Private");
                if (a2 != null) {
                    int intValue = a2.mo7084a(1).intValue();
                    this.f4454a.mo7118b(intValue);
                    C1497b e2 = m5720e(new C1484c(this.f4454a.mo7120d(a2.mo7084a(0).intValue())));
                    Map<String, Object> a3 = m5704a(e2);
                    linkedList.add(a3);
                    int intValue2 = ((Integer) m5700a(e2, "Subrs", (Number) 0)).intValue();
                    if (intValue2 == 0) {
                        a3.put("Subrs", new C1524t(0));
                    } else {
                        this.f4454a.mo7118b(intValue + intValue2);
                        a3.put("Subrs", m5718d(this.f4454a));
                    }
                    i++;
                } else {
                    throw new IOException("Font DICT invalid without \"Private\" entry");
                }
            }
            this.f4454a.mo7118b(bVar.mo7082a("FDSelect").mo7084a(0).intValue());
            C1523s a4 = m5698a(this.f4454a, tVar.mo7128a(), aVar);
            aVar.mo7040a((List<Map<String, Object>>) linkedList2);
            aVar.mo7042b((List<Map<String, Object>>) linkedList);
            aVar.mo7039a(a4);
            return;
        }
        throw new IOException("FDArray is missing for a CIDKeyed Font.");
    }

    /* renamed from: a */
    private void m5707a(C1497b bVar, C1515n nVar, C1483b bVar2) {
        C1485d dVar;
        C1524t tVar;
        String str;
        C1497b.C1498a a = bVar.mo7082a("Encoding");
        int intValue = a != null ? a.mo7084a(0).intValue() : 0;
        if (intValue == 0) {
            dVar = C1513l.m5791a();
        } else if (intValue == 1) {
            dVar = C1487f.m5671a();
        } else {
            this.f4454a.mo7118b(intValue);
            dVar = m5692a(this.f4454a, bVar2);
        }
        nVar.mo7103a(dVar);
        C1497b.C1498a a2 = bVar.mo7082a("Private");
        int intValue2 = a2.mo7084a(1).intValue();
        this.f4454a.mo7118b(intValue2);
        C1497b e = m5720e(new C1484c(this.f4454a.mo7120d(a2.mo7084a(0).intValue())));
        for (Map.Entry next : m5704a(e).entrySet()) {
            nVar.mo7104b((String) next.getKey(), next.getValue());
        }
        int intValue3 = ((Integer) m5700a(e, "Subrs", (Number) 0)).intValue();
        if (intValue3 == 0) {
            str = "Subrs";
            tVar = new C1524t(0);
        } else {
            this.f4454a.mo7118b(intValue2 + intValue3);
            str = "Subrs";
            tVar = m5718d(this.f4454a);
        }
        nVar.mo7104b(str, tVar);
    }

    /* renamed from: b */
    private static long m5708b(C1484c cVar) {
        return (long) (cVar.mo7057b() | (cVar.mo7057b() << 16));
    }

    /* renamed from: b */
    private static C1491j.C1492a m5709b(C1484c cVar, int i) {
        return i == 12 ? new C1491j.C1492a(i, cVar.mo7124h()) : new C1491j.C1492a(i);
    }

    /* renamed from: b */
    private C1504h m5710b(C1484c cVar, int i, int i2, boolean z) {
        C1504h hVar = new C1504h(z);
        int unused = hVar.f4475a = i;
        ArrayList arrayList = new ArrayList();
        if (z) {
            hVar.mo7051a(0, 0);
        } else {
            hVar.mo7052a(0, 0, ".notdef");
        }
        int i3 = 1;
        while (i3 < i2) {
            C1504h.C1505a aVar = new C1504h.C1505a();
            int unused2 = aVar.f4477a = cVar.mo7059d();
            int unused3 = aVar.f4478b = cVar.mo7055a();
            arrayList.add(aVar);
            for (int i4 = 0; i4 < aVar.f4478b + 1; i4++) {
                int b = aVar.f4477a + i4;
                if (z) {
                    hVar.mo7051a(i3 + i4, b);
                } else {
                    hVar.mo7052a(i3 + i4, b, m5713b(b));
                }
            }
            i3 = i3 + aVar.f4478b + 1;
        }
        C1504h.C1505a[] unused4 = hVar.f4476b = (C1504h.C1505a[]) arrayList.toArray(new C1504h.C1505a[0]);
        return hVar;
    }

    /* renamed from: b */
    private C1506i m5711b(C1484c cVar, C1483b bVar, int i) {
        C1506i iVar = new C1506i();
        int unused = iVar.f4479c = i;
        int unused2 = iVar.f4480d = cVar.mo7055a();
        C1506i.C1507a[] unused3 = iVar.f4481e = new C1506i.C1507a[iVar.f4480d];
        iVar.mo7062a(0, 0, ".notdef");
        int i2 = 0;
        int i3 = 1;
        while (i2 < iVar.f4481e.length) {
            C1506i.C1507a aVar = new C1506i.C1507a();
            int unused4 = aVar.f4482a = cVar.mo7055a();
            int unused5 = aVar.f4483b = cVar.mo7055a();
            iVar.f4481e[i2] = aVar;
            int i4 = i3;
            for (int i5 = 0; i5 < aVar.f4483b + 1; i5++) {
                int a = bVar.mo7049a(i4);
                iVar.mo7062a(aVar.f4482a + i5, a, m5713b(a));
                i4++;
            }
            i2++;
            i3 = i4;
        }
        if ((i & 128) != 0) {
            m5705a(cVar, (C1495a) iVar);
        }
        return iVar;
    }

    /* renamed from: b */
    private static C1510k m5712b(C1484c cVar, int i, int i2, C1480a aVar) {
        C1510k kVar = new C1510k(aVar);
        int unused = kVar.f4488b = i;
        int unused2 = kVar.f4489c = cVar.mo7057b();
        C1512m[] unused3 = kVar.f4490d = new C1512m[kVar.f4489c];
        for (int i3 = 0; i3 < kVar.f4489c; i3++) {
            C1512m mVar = new C1512m();
            int unused4 = mVar.f4496a = cVar.mo7057b();
            int unused5 = mVar.f4497b = cVar.mo7055a();
            kVar.f4490d[i3] = mVar;
        }
        int unused6 = kVar.f4491e = cVar.mo7057b();
        return kVar;
    }

    /* renamed from: b */
    private String m5713b(int i) {
        if (i >= 0 && i <= 390) {
            return C1514m.m5792a(i);
        }
        int i2 = i - 391;
        if (i2 < this.f4458e.mo7128a()) {
            return new C1522r(this.f4458e.mo7130a(i2)).mo7122f();
        }
        return "SID" + i;
    }

    /* renamed from: b */
    private static List<Number> m5714b(C1497b bVar, String str, List<Number> list) {
        C1497b.C1498a a = bVar.mo7082a(str);
        return a != null ? a.mo7085a() : list;
    }

    /* renamed from: c */
    private C1508j m5715c(C1484c cVar, int i, int i2, boolean z) {
        C1508j jVar = new C1508j(z);
        int unused = jVar.f4484a = i;
        C1508j.C1509a[] unused2 = jVar.f4485b = new C1508j.C1509a[0];
        if (z) {
            jVar.mo7051a(0, 0);
        } else {
            jVar.mo7052a(0, 0, ".notdef");
        }
        int i3 = 1;
        while (i3 < i2) {
            C1508j.C1509a[] aVarArr = new C1508j.C1509a[(jVar.f4485b.length + 1)];
            System.arraycopy(jVar.f4485b, 0, aVarArr, 0, jVar.f4485b.length);
            C1508j.C1509a[] unused3 = jVar.f4485b = aVarArr;
            C1508j.C1509a aVar = new C1508j.C1509a();
            int unused4 = aVar.f4486a = cVar.mo7059d();
            int unused5 = aVar.f4487b = cVar.mo7057b();
            jVar.f4485b[jVar.f4485b.length - 1] = aVar;
            for (int i4 = 0; i4 < aVar.f4487b + 1; i4++) {
                int b = aVar.f4486a + i4;
                if (z) {
                    jVar.mo7051a(i3 + i4, b);
                } else {
                    jVar.mo7052a(i3 + i4, b, m5713b(b));
                }
            }
            i3 = i3 + aVar.f4487b + 1;
        }
        return jVar;
    }

    /* renamed from: c */
    private static C1511l m5716c(C1484c cVar) {
        C1511l lVar = new C1511l();
        int unused = lVar.f4492a = cVar.mo7055a();
        int unused2 = lVar.f4493b = cVar.mo7055a();
        int unused3 = lVar.f4494c = cVar.mo7055a();
        int unused4 = lVar.f4495d = cVar.mo7058c();
        return lVar;
    }

    /* renamed from: c */
    private static Integer m5717c(C1484c cVar, int i) {
        if (i == 28) {
            return Integer.valueOf((short) (cVar.mo7124h() | (cVar.mo7124h() << 8)));
        } else if (i == 29) {
            return Integer.valueOf(cVar.mo7124h() | (cVar.mo7124h() << 24) | (cVar.mo7124h() << 16) | (cVar.mo7124h() << 8));
        } else if (i >= 32 && i <= 246) {
            return Integer.valueOf(i - 139);
        } else {
            if (i >= 247 && i <= 250) {
                return Integer.valueOf(((i - 247) * 256) + cVar.mo7124h() + 108);
            } else if (i < 251 || i > 254) {
                throw new IllegalArgumentException();
            } else {
                return Integer.valueOf((((-(i - ParseException.INVALID_LINKED_SESSION)) * 256) - cVar.mo7124h()) - 108);
            }
        }
    }

    /* renamed from: d */
    private static C1524t m5718d(C1484c cVar) {
        int b = cVar.mo7057b();
        C1524t tVar = new C1524t(b);
        if (b == 0) {
            return tVar;
        }
        int c = cVar.mo7058c();
        int i = 0;
        while (i <= b) {
            int a = cVar.mo7056a(c);
            if (a <= cVar.mo7127k()) {
                tVar.mo7129a(i, a);
                i++;
            } else {
                throw new IOException("illegal offset value " + a + " in CFF font");
            }
        }
        int b2 = tVar.mo7131b(b) - tVar.mo7131b(0);
        tVar.mo7133c(b2);
        for (int i2 = 0; i2 < b2; i2++) {
            tVar.mo7132b(i2, cVar.mo7055a());
        }
        return tVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r9.append(r6);
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r9.append(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        r1 = r1 + 1;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Double m5719d(com.cyberneid.p089b.p091b.C1484c r8, int r9) {
        /*
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x0008:
            if (r1 != 0) goto L_0x004a
            int r3 = r8.mo7124h()
            r4 = 2
            int[] r4 = new int[r4]
            int r5 = r3 / 16
            r4[r0] = r5
            int r3 = r3 % 16
            r5 = 1
            r4[r5] = r3
            int r3 = r4.length
            r6 = r2
            r2 = r1
            r1 = 0
        L_0x001e:
            if (r1 >= r3) goto L_0x0047
            r7 = r4[r1]
            switch(r7) {
                case 0: goto L_0x0040;
                case 1: goto L_0x0040;
                case 2: goto L_0x0040;
                case 3: goto L_0x0040;
                case 4: goto L_0x0040;
                case 5: goto L_0x0040;
                case 6: goto L_0x0040;
                case 7: goto L_0x0040;
                case 8: goto L_0x0040;
                case 9: goto L_0x0040;
                case 10: goto L_0x003a;
                case 11: goto L_0x0033;
                case 12: goto L_0x0030;
                case 13: goto L_0x0044;
                case 14: goto L_0x002d;
                case 15: goto L_0x002b;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>()
            throw r8
        L_0x002b:
            r2 = 1
            goto L_0x0044
        L_0x002d:
            java.lang.String r7 = "-"
            goto L_0x003c
        L_0x0030:
            java.lang.String r6 = "E-"
            goto L_0x0035
        L_0x0033:
            java.lang.String r6 = "E"
        L_0x0035:
            r9.append(r6)
            r6 = 1
            goto L_0x0044
        L_0x003a:
            java.lang.String r7 = "."
        L_0x003c:
            r9.append(r7)
            goto L_0x0044
        L_0x0040:
            r9.append(r7)
            r6 = 0
        L_0x0044:
            int r1 = r1 + 1
            goto L_0x001e
        L_0x0047:
            r1 = r2
            r2 = r6
            goto L_0x0008
        L_0x004a:
            if (r2 == 0) goto L_0x0051
            java.lang.String r8 = "0"
            r9.append(r8)
        L_0x0051:
            java.lang.String r8 = r9.toString()
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p089b.p091b.C1493k.m5719d(com.cyberneid.b.b.c, int):java.lang.Double");
    }

    /* renamed from: e */
    private static C1497b m5720e(C1484c cVar) {
        C1497b bVar = new C1497b();
        List unused = bVar.f4465a = new ArrayList();
        while (cVar.mo7121e()) {
            bVar.f4465a.add(m5721f(cVar));
        }
        return bVar;
    }

    /* renamed from: f */
    private static C1497b.C1498a m5721f(C1484c cVar) {
        List list;
        Object obj;
        C1497b.C1498a aVar = new C1497b.C1498a();
        while (true) {
            int h = cVar.mo7124h();
            if (h < 0 || h > 21) {
                if (!(h == 28 || h == 29)) {
                    if (h == 30) {
                        list = aVar.f4466a;
                        obj = m5719d(cVar, h);
                        list.add(obj);
                    } else if (h < 32 || h > 254) {
                    }
                }
                list = aVar.f4466a;
                obj = m5717c(cVar, h);
                list.add(obj);
            } else {
                C1491j unused = aVar.f4467b = m5694a(cVar, h);
                return aVar;
            }
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public List<C1489h> mo7079a(byte[] bArr) {
        boolean z;
        this.f4454a = new C1484c(bArr);
        String a = m5701a(this.f4454a);
        if ("OTTO".equals(a)) {
            short i = this.f4454a.mo7125i();
            this.f4454a.mo7125i();
            this.f4454a.mo7125i();
            this.f4454a.mo7125i();
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = false;
                    break;
                }
                String a2 = m5701a(this.f4454a);
                m5708b(this.f4454a);
                long b = m5708b(this.f4454a);
                long b2 = m5708b(this.f4454a);
                if (a2.equals("CFF ")) {
                    byte[] bArr2 = new byte[((int) b2)];
                    System.arraycopy(bArr, (int) b, bArr2, 0, bArr2.length);
                    this.f4454a = new C1484c(bArr2);
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                throw new IOException("CFF tag not found in this OpenType font.");
            }
        } else if ("ttcf".equals(a)) {
            throw new IOException("True Type Collection fonts are not supported.");
        } else if (!"\u0000\u0001\u0000\u0000".equals(a)) {
            this.f4454a.mo7118b(0);
        } else {
            throw new IOException("OpenType fonts containing a true type font are not supported.");
        }
        this.f4455b = m5716c(this.f4454a);
        this.f4456c = m5718d(this.f4454a);
        this.f4457d = m5718d(this.f4454a);
        this.f4458e = m5718d(this.f4454a);
        C1524t d = m5718d(this.f4454a);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f4456c.mo7128a(); i3++) {
            C1489h a3 = m5693a(i3);
            a3.mo7064a(d);
            a3.mo7066a(bArr);
            arrayList.add(a3);
        }
        return arrayList;
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.f4459f + "]";
    }
}
