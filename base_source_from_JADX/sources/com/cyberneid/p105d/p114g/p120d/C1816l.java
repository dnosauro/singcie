package com.cyberneid.p105d.p114g.p120d;

import android.graphics.PointF;
import com.cyberneid.p089b.C1479b;
import com.cyberneid.p089b.p091b.C1480a;
import com.cyberneid.p089b.p091b.C1515n;
import com.cyberneid.p089b.p091b.C1528w;
import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p099c.p100a.p101a.C1592a;
import com.cyberneid.p105d.p131h.C1940d;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.l */
public class C1816l extends C1815k {

    /* renamed from: c */
    private final C1480a f5862c;

    /* renamed from: d */
    private final C1479b f5863d;

    /* renamed from: e */
    private final Map<Integer, Float> f5864e = new HashMap();

    /* renamed from: f */
    private final boolean f5865f;

    /* renamed from: g */
    private final boolean f5866g;

    /* renamed from: h */
    private Float f5867h = null;

    /* renamed from: i */
    private C1940d f5868i;

    /* renamed from: j */
    private final C1592a f5869j;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r0 = r8.mo8210q();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1816l(com.cyberneid.p105d.p108b.C1607d r7, com.cyberneid.p105d.p114g.p120d.C1828x r8) {
        /*
            r6 = this;
            r6.<init>(r7, r8)
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r6.f5864e = r7
            r7 = 0
            r6.f5867h = r7
            com.cyberneid.d.g.d.q r8 = r6.mo8146e()
            if (r8 == 0) goto L_0x0022
            com.cyberneid.d.g.a.g r0 = r8.mo8210q()
            if (r0 == 0) goto L_0x0022
            com.cyberneid.d.b.g r0 = r0.mo7958c()
            byte[] r0 = com.cyberneid.p105d.p111d.C1654a.m6620a((java.io.InputStream) r0)
            goto L_0x0023
        L_0x0022:
            r0 = r7
        L_0x0023:
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x004f
            int r3 = r0.length
            if (r3 <= 0) goto L_0x004f
            byte r3 = r0[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 37
            if (r3 != r4) goto L_0x004f
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Found PFB but expected embedded CFF font "
            r3.append(r4)
            java.lang.String r8 = r8.mo8198g()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            android.util.Log.w(r0, r8)
        L_0x004c:
            r0 = r7
            r8 = 1
            goto L_0x007f
        L_0x004f:
            if (r0 == 0) goto L_0x007d
            com.cyberneid.b.b.k r3 = new com.cyberneid.b.b.k
            r3.<init>()
            java.util.List r0 = r3.mo7079a((byte[]) r0)     // Catch:{ IOException -> 0x0061 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ IOException -> 0x0061 }
            com.cyberneid.b.b.h r0 = (com.cyberneid.p089b.p091b.C1489h) r0     // Catch:{ IOException -> 0x0061 }
            goto L_0x007e
        L_0x0061:
            r0 = move-exception
            java.lang.String r3 = "PdfBox-Android"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Can't read the embedded CFF font "
            r4.append(r5)
            java.lang.String r8 = r8.mo8198g()
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            android.util.Log.e(r3, r8, r0)
            goto L_0x004c
        L_0x007d:
            r0 = r7
        L_0x007e:
            r8 = 0
        L_0x007f:
            if (r0 == 0) goto L_0x0095
            boolean r8 = r0 instanceof com.cyberneid.p089b.p091b.C1480a
            if (r8 == 0) goto L_0x008c
            com.cyberneid.b.b.a r0 = (com.cyberneid.p089b.p091b.C1480a) r0
            r6.f5862c = r0
            r6.f5863d = r7
            goto L_0x0090
        L_0x008c:
            r6.f5862c = r7
            r6.f5863d = r0
        L_0x0090:
            r6.f5865f = r1
            r6.f5866g = r2
            goto L_0x00fc
        L_0x0095:
            java.lang.String r0 = r6.mo8142b()
            com.cyberneid.d.g.d.q r1 = r6.mo8146e()
            com.cyberneid.d.g.d.o r3 = r6.mo8150i()
            com.cyberneid.d.g.d.a r0 = com.cyberneid.p105d.p114g.p120d.C1810h.m7346a(r0, r1, r3)
            boolean r1 = r0.mo8085b()
            if (r1 == 0) goto L_0x00c2
            com.cyberneid.b.b r1 = r0.mo8137c()
            com.cyberneid.b.f.s r1 = (com.cyberneid.p089b.p095f.C1571s) r1
            com.cyberneid.b.f.a r1 = r1.mo7337a()
            com.cyberneid.b.b.h r1 = r1.mo7174a()
            com.cyberneid.b.b.a r1 = (com.cyberneid.p089b.p091b.C1480a) r1
            r6.f5862c = r1
            r6.f5863d = r7
            com.cyberneid.b.b.a r7 = r6.f5862c
            goto L_0x00cc
        L_0x00c2:
            r6.f5862c = r7
            com.cyberneid.b.b r7 = r0.mo8084a()
            r6.f5863d = r7
            com.cyberneid.b.b r7 = r6.f5863d
        L_0x00cc:
            boolean r0 = r0.mo8138d()
            if (r0 == 0) goto L_0x00f8
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Using fallback "
            r1.append(r3)
            java.lang.String r7 = r7.mo7033b()
            r1.append(r7)
            java.lang.String r7 = " for CID-keyed font "
            r1.append(r7)
            java.lang.String r7 = r6.mo8142b()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            android.util.Log.w(r0, r7)
        L_0x00f8:
            r6.f5865f = r2
            r6.f5866g = r8
        L_0x00fc:
            com.cyberneid.d.h.d r7 = r6.mo8147f()
            com.cyberneid.c.a.a.a r7 = r7.mo8478a()
            r6.f5869j = r7
            com.cyberneid.c.a.a.a r7 = r6.f5869j
            r0 = 4652007308841189376(0x408f400000000000, double:1000.0)
            r7.mo7415e(r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1816l.<init>(com.cyberneid.d.b.d, com.cyberneid.d.g.d.x):void");
    }

    /* renamed from: f */
    private String m7382f(int i) {
        String e = this.f5854a.mo8165e(i);
        if (e == null) {
            return ".notdef";
        }
        return String.format("uni%04X", new Object[]{Integer.valueOf(e.codePointAt(0))});
    }

    /* renamed from: b */
    public float mo8141b(int i) {
        float f;
        C1528w a;
        int c = mo8143c(i);
        if (this.f5862c != null) {
            a = mo8151e(c);
        } else {
            if (this.f5865f) {
                C1479b bVar = this.f5863d;
                if (bVar instanceof C1515n) {
                    a = ((C1515n) bVar).mo7102a(c);
                }
            }
            f = this.f5863d.mo7032a_(m7382f(i));
            PointF pointF = new PointF(f, 0.0f);
            this.f5869j.mo7402a(pointF, pointF);
            return pointF.x;
        }
        f = (float) a.mo7135a();
        PointF pointF2 = new PointF(f, 0.0f);
        this.f5869j.mo7402a(pointF2, pointF2);
        return pointF2.x;
    }

    /* renamed from: c */
    public int mo8143c(int i) {
        return this.f5854a.mo8235o().mo7150b(i);
    }

    /* renamed from: d */
    public byte[] mo8145d(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public C1528w mo8151e(int i) {
        C1480a aVar = this.f5862c;
        if (aVar != null) {
            return aVar.mo7041b(i);
        }
        C1479b bVar = this.f5863d;
        if (bVar instanceof C1515n) {
            return ((C1515n) bVar).mo7102a(i);
        }
        return null;
    }

    /* renamed from: f */
    public final C1940d mo8147f() {
        List<Number> list;
        if (this.f5868i == null) {
            C1480a aVar = this.f5862c;
            if (aVar != null) {
                list = aVar.mo7036d();
            } else {
                try {
                    list = this.f5863d.mo7036d();
                } catch (IOException unused) {
                    return new C1940d(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
                }
            }
            if (list == null || list.size() != 6) {
                this.f5868i = new C1940d(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
            } else {
                this.f5868i = new C1940d(list.get(0).floatValue(), list.get(1).floatValue(), list.get(2).floatValue(), list.get(3).floatValue(), list.get(4).floatValue(), list.get(5).floatValue());
            }
        }
        return this.f5868i;
    }

    /* renamed from: g */
    public C1586a mo8148g() {
        C1480a aVar = this.f5862c;
        if (aVar != null) {
            return aVar.mo7035c();
        }
        try {
            return this.f5863d.mo7035c();
        } catch (IOException unused) {
            return new C1586a();
        }
    }

    /* renamed from: h */
    public boolean mo8149h() {
        return this.f5865f;
    }
}
