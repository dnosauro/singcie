package com.cyberneid.p105d.p112e;

import android.util.Log;
import com.cyberneid.p105d.p106a.C1602a;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.cyberneid.d.e.g */
public class C1672g extends C1666a {

    /* renamed from: c */
    private final List<Object> f5545c = new ArrayList(100);

    /* renamed from: d */
    private final byte[] f5546d = new byte[10];

    public C1672g(C1602a aVar) {
        super(new C1669d(aVar.mo7477a()));
    }

    public C1672g(byte[] bArr) {
        super(new C1669d(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: a */
    private boolean m6793a(C1679k kVar) {
        int i = 10;
        int a = kVar.mo7790a(this.f5546d, 0, 10);
        boolean z = true;
        if (a > 0) {
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            while (true) {
                if (i2 >= a) {
                    break;
                }
                byte b = this.f5546d[i2];
                if (b < 9 || (b > 10 && b < 32 && b != 13)) {
                    z = false;
                } else {
                    if (i3 == -1 && b != 9 && b != 32 && b != 10 && b != 13) {
                        i3 = i2;
                    } else if (i3 != -1 && i4 == -1 && (b == 9 || b == 32 || b == 10 || b == 13)) {
                        i4 = i2;
                    }
                    i2++;
                }
            }
            z = false;
            if (a == 10) {
                if (i3 == -1 || i4 != -1) {
                    i = i4;
                }
                if (!(i == -1 || i3 == -1 || i - i3 <= 3)) {
                    z = false;
                }
            }
            kVar.mo7793b(Arrays.copyOfRange(this.f5546d, 0, a));
        }
        if (!z) {
            Log.w("PdfBox-Android", "ignoring 'EI' assumed to be in the middle of inline image");
        }
        return z;
    }

    /* renamed from: g */
    private boolean m6794g(int i) {
        return i == 10 || i == 13 || i == 32;
    }

    /* renamed from: v */
    private boolean m6795v() {
        return m6794g(this.f5510a.mo7795c());
    }

    /* renamed from: r */
    public void mo7778r() {
        while (true) {
            Object t = mo7780t();
            if (t != null) {
                this.f5545c.add(t);
            } else {
                return;
            }
        }
    }

    /* renamed from: s */
    public List<Object> mo7779s() {
        return this.f5545c;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0195 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ad A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0188 A[ADDED_TO_REGION, SYNTHETIC] */
    /* renamed from: t */
    public java.lang.Object mo7780t() {
        /*
            r7 = this;
            r7.mo7762l()
            com.cyberneid.d.e.k r0 = r7.f5510a
            int r0 = r0.mo7795c()
            byte r1 = (byte) r0
            r2 = 0
            r3 = -1
            if (r1 != r3) goto L_0x000f
            return r2
        L_0x000f:
            char r0 = (char) r0
            switch(r0) {
                case 45: goto L_0x0175;
                case 46: goto L_0x0175;
                case 47: goto L_0x0170;
                case 48: goto L_0x0175;
                case 49: goto L_0x0175;
                case 50: goto L_0x0175;
                case 51: goto L_0x0175;
                case 52: goto L_0x0175;
                case 53: goto L_0x0175;
                case 54: goto L_0x0175;
                case 55: goto L_0x0175;
                case 56: goto L_0x0175;
                case 57: goto L_0x0175;
                default: goto L_0x0013;
            }
        L_0x0013:
            switch(r0) {
                case 40: goto L_0x016b;
                case 43: goto L_0x0175;
                case 60: goto L_0x0150;
                case 66: goto L_0x0117;
                case 73: goto L_0x0078;
                case 82: goto L_0x0064;
                case 91: goto L_0x005e;
                case 93: goto L_0x0055;
                case 102: goto L_0x0039;
                case 110: goto L_0x002c;
                case 116: goto L_0x0039;
                default: goto L_0x0016;
            }
        L_0x0016:
            java.lang.String r0 = r7.mo7801u()
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0026
            goto L_0x01a2
        L_0x0026:
            com.cyberneid.d.a.a.a r2 = com.cyberneid.p105d.p106a.p107a.C1603a.m6344a((java.lang.String) r0)
            goto L_0x01a2
        L_0x002c:
            java.lang.String r0 = r7.mo7757g()
            java.lang.String r1 = "null"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0026
            goto L_0x005a
        L_0x0039:
            java.lang.String r0 = r7.mo7757g()
            java.lang.String r1 = "true"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0049
            com.cyberneid.d.b.c r2 = com.cyberneid.p105d.p108b.C1606c.f4866c
            goto L_0x01a2
        L_0x0049:
            java.lang.String r1 = "false"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0026
            com.cyberneid.d.b.c r2 = com.cyberneid.p105d.p108b.C1606c.f4867d
            goto L_0x01a2
        L_0x0055:
            com.cyberneid.d.e.k r0 = r7.f5510a
            r0.mo7788a()
        L_0x005a:
            com.cyberneid.d.b.j r2 = com.cyberneid.p105d.p108b.C1614j.f5368b
            goto L_0x01a2
        L_0x005e:
            com.cyberneid.d.b.a r2 = r7.mo7752d()
            goto L_0x01a2
        L_0x0064:
            java.lang.String r0 = r7.mo7757g()
            java.lang.String r1 = "R"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0026
            com.cyberneid.d.b.l r0 = new com.cyberneid.d.b.l
            r0.<init>(r2)
            r2 = r0
            goto L_0x01a2
        L_0x0078:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            r0.append(r1)
            com.cyberneid.d.e.k r1 = r7.f5510a
            int r1 = r1.mo7788a()
            char r1 = (char) r1
            r0.append(r1)
            com.cyberneid.d.e.k r1 = r7.f5510a
            int r1 = r1.mo7788a()
            char r1 = (char) r1
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ID"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00fb
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            boolean r1 = r7.mo7759i()
            if (r1 == 0) goto L_0x00b2
            com.cyberneid.d.e.k r1 = r7.f5510a
            r1.mo7788a()
        L_0x00b2:
            com.cyberneid.d.e.k r1 = r7.f5510a
            int r1 = r1.mo7788a()
            com.cyberneid.d.e.k r2 = r7.f5510a
            int r2 = r2.mo7788a()
        L_0x00be:
            r3 = 69
            if (r1 != r3) goto L_0x00d4
            r3 = 73
            if (r2 != r3) goto L_0x00d4
            boolean r3 = r7.m6795v()
            if (r3 == 0) goto L_0x00d4
            com.cyberneid.d.e.k r3 = r7.f5510a
            boolean r3 = r7.m6793a(r3)
            if (r3 != 0) goto L_0x00e9
        L_0x00d4:
            com.cyberneid.d.e.k r3 = r7.f5510a
            boolean r3 = r3.mo7797d()
            if (r3 != 0) goto L_0x00e9
            r0.write(r1)
            com.cyberneid.d.e.k r1 = r7.f5510a
            int r1 = r1.mo7788a()
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x00be
        L_0x00e9:
            java.lang.String r1 = "ID"
            com.cyberneid.d.a.a.a r2 = com.cyberneid.p105d.p106a.p107a.C1603a.m6344a((java.lang.String) r1)
            r1 = r2
            com.cyberneid.d.a.a.a r1 = (com.cyberneid.p105d.p106a.p107a.C1603a) r1
            byte[] r0 = r0.toByteArray()
            r1.mo7480a((byte[]) r0)
            goto L_0x01a2
        L_0x00fb:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error: Expected operator 'ID' actual='"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "'"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0117:
            java.lang.String r0 = r7.mo7757g()
            com.cyberneid.d.a.a.a r2 = com.cyberneid.p105d.p106a.p107a.C1603a.m6344a((java.lang.String) r0)
            java.lang.String r1 = "BI"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01a2
            r0 = r2
            com.cyberneid.d.a.a.a r0 = (com.cyberneid.p105d.p106a.p107a.C1603a) r0
            com.cyberneid.d.b.d r1 = new com.cyberneid.d.b.d
            r1.<init>()
            r0.mo7479a((com.cyberneid.p105d.p108b.C1607d) r1)
        L_0x0132:
            java.lang.Object r3 = r7.mo7780t()
            boolean r4 = r3 instanceof com.cyberneid.p105d.p108b.C1613i
            if (r4 == 0) goto L_0x0146
            java.lang.Object r4 = r7.mo7780t()
            com.cyberneid.d.b.i r3 = (com.cyberneid.p105d.p108b.C1613i) r3
            com.cyberneid.d.b.b r4 = (com.cyberneid.p105d.p108b.C1605b) r4
            r1.mo7521a((com.cyberneid.p105d.p108b.C1613i) r3, (com.cyberneid.p105d.p108b.C1605b) r4)
            goto L_0x0132
        L_0x0146:
            com.cyberneid.d.a.a.a r3 = (com.cyberneid.p105d.p106a.p107a.C1603a) r3
            byte[] r1 = r3.mo7481b()
            r0.mo7480a((byte[]) r1)
            goto L_0x01a2
        L_0x0150:
            com.cyberneid.d.e.k r0 = r7.f5510a
            int r0 = r0.mo7788a()
            com.cyberneid.d.e.k r1 = r7.f5510a
            int r1 = r1.mo7795c()
            char r1 = (char) r1
            com.cyberneid.d.e.k r2 = r7.f5510a
            r2.mo7791a((int) r0)
            r0 = 60
            if (r1 != r0) goto L_0x016b
            com.cyberneid.d.b.d r2 = r7.mo7743a()
            goto L_0x01a2
        L_0x016b:
            com.cyberneid.d.b.p r2 = r7.mo7750c()
            goto L_0x01a2
        L_0x0170:
            com.cyberneid.d.b.i r2 = r7.mo7754e()
            goto L_0x01a2
        L_0x0175:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r1.append(r0)
            com.cyberneid.d.e.k r2 = r7.f5510a
            r2.mo7788a()
            r2 = 0
            r3 = 46
            if (r0 == r3) goto L_0x01af
            r0 = 1
        L_0x0188:
            com.cyberneid.d.e.k r4 = r7.f5510a
            int r4 = r4.mo7795c()
            char r4 = (char) r4
            boolean r5 = java.lang.Character.isDigit(r4)
            if (r5 != 0) goto L_0x01a3
            if (r0 == 0) goto L_0x019a
            if (r4 != r3) goto L_0x019a
            goto L_0x01a3
        L_0x019a:
            java.lang.String r0 = r1.toString()
            com.cyberneid.d.b.k r2 = com.cyberneid.p105d.p108b.C1615k.m6468a(r0)
        L_0x01a2:
            return r2
        L_0x01a3:
            r1.append(r4)
            com.cyberneid.d.e.k r5 = r7.f5510a
            r5.mo7788a()
            if (r0 == 0) goto L_0x0188
            if (r4 != r3) goto L_0x0188
        L_0x01af:
            r0 = 0
            goto L_0x0188
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1672g.mo7780t():java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public String mo7801u() {
        mo7762l();
        StringBuffer stringBuffer = new StringBuffer(4);
        loop0:
        while (true) {
            int c = this.f5510a.mo7795c();
            while (c != -1 && !mo7753d(c) && !mo7749b(c) && c != 91 && c != 60 && c != 40 && c != 47 && (c < 48 || c > 57)) {
                char a = (char) this.f5510a.mo7788a();
                int c2 = this.f5510a.mo7795c();
                stringBuffer.append(a);
                if (a == 'd' && (c2 == 48 || c2 == 49)) {
                    stringBuffer.append((char) this.f5510a.mo7788a());
                } else {
                    c = c2;
                }
            }
        }
        return stringBuffer.toString();
    }
}
