package com.cyberneid.p105d.p114g.p120d;

import android.graphics.PointF;
import com.cyberneid.p089b.C1470a;
import com.cyberneid.p089b.C1479b;
import com.cyberneid.p089b.p091b.C1515n;
import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p099c.p100a.p101a.C1592a;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p120d.p121a.C1789c;
import com.cyberneid.p105d.p114g.p120d.p121a.C1793g;
import com.cyberneid.p105d.p114g.p120d.p121a.C1794h;
import com.cyberneid.p105d.p131h.C1940d;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.y */
public class C1829y extends C1826v {

    /* renamed from: e */
    private final Map<String, Float> f5916e = new HashMap();

    /* renamed from: f */
    private Float f5917f;

    /* renamed from: g */
    private C1940d f5918g;

    /* renamed from: h */
    private final C1592a f5919h;

    /* renamed from: i */
    private final C1515n f5920i;

    /* renamed from: j */
    private final C1479b f5921j;

    /* renamed from: k */
    private final boolean f5922k;

    /* renamed from: l */
    private final boolean f5923l;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043 A[SYNTHETIC, Splitter:B:10:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1829y(com.cyberneid.p105d.p108b.C1607d r8) {
        /*
            r7 = this;
            r7.<init>((com.cyberneid.p105d.p108b.C1607d) r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r7.f5916e = r8
            r8 = 0
            r7.f5917f = r8
            com.cyberneid.d.g.d.q r0 = r7.mo8163b()
            if (r0 == 0) goto L_0x003e
            com.cyberneid.d.g.a.g r1 = r0.mo8210q()
            if (r1 == 0) goto L_0x003e
            com.cyberneid.d.b.g r1 = r1.mo7958c()
            byte[] r1 = com.cyberneid.p105d.p111d.C1654a.m6620a((java.io.InputStream) r1)
            int r2 = r1.length
            if (r2 != 0) goto L_0x003f
            java.lang.String r1 = "PdfBox-Android"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid data for embedded Type1C font "
            r2.append(r3)
            java.lang.String r3 = r7.mo8099f()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
        L_0x003e:
            r1 = r8
        L_0x003f:
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0072
            com.cyberneid.b.b.k r4 = new com.cyberneid.b.b.k     // Catch:{ IOException -> 0x0054 }
            r4.<init>()     // Catch:{ IOException -> 0x0054 }
            java.util.List r1 = r4.mo7079a((byte[]) r1)     // Catch:{ IOException -> 0x0054 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ IOException -> 0x0054 }
            com.cyberneid.b.b.n r1 = (com.cyberneid.p089b.p091b.C1515n) r1     // Catch:{ IOException -> 0x0054 }
            r8 = r1
            goto L_0x0072
        L_0x0054:
            r1 = move-exception
            java.lang.String r4 = "PdfBox-Android"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Can't read the embedded Type1C font "
            r5.append(r6)
            java.lang.String r6 = r7.mo8099f()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5, r1)
            r1 = r8
            r8 = 1
            goto L_0x0074
        L_0x0072:
            r1 = r8
            r8 = 0
        L_0x0074:
            r7.f5923l = r8
            r7.f5920i = r1
            com.cyberneid.b.b.n r8 = r7.f5920i
            if (r8 == 0) goto L_0x0081
            r7.f5921j = r8
            r7.f5922k = r2
            goto L_0x00bf
        L_0x0081:
            java.lang.String r8 = r7.mo8238u()
            com.cyberneid.d.g.d.i r8 = com.cyberneid.p105d.p114g.p120d.C1810h.m7357b((java.lang.String) r8, (com.cyberneid.p105d.p114g.p120d.C1821q) r0)
            com.cyberneid.b.b r0 = r8.mo8137c()
            r7.f5921j = r0
            boolean r8 = r8.mo8138d()
            if (r8 == 0) goto L_0x00bd
            java.lang.String r8 = "PdfBox-Android"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Using fallback font "
            r0.append(r1)
            com.cyberneid.b.b r1 = r7.f5921j
            java.lang.String r1 = r1.mo7033b()
            r0.append(r1)
            java.lang.String r1 = " for "
            r0.append(r1)
            java.lang.String r1 = r7.mo8238u()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r8, r0)
        L_0x00bd:
            r7.f5922k = r3
        L_0x00bf:
            r7.mo8102m()
            com.cyberneid.d.h.d r8 = r7.mo8101i()
            com.cyberneid.c.a.a.a r8 = r8.mo8478a()
            r7.f5919h = r8
            com.cyberneid.c.a.a.a r8 = r7.f5919h
            r0 = 4652007308841189376(0x408f400000000000, double:1000.0)
            r8.mo7415e(r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1829y.<init>(com.cyberneid.d.b.d):void");
    }

    /* renamed from: a */
    public int mo8095a(InputStream inputStream) {
        return inputStream.read();
    }

    /* renamed from: b */
    public float mo8162b(String str) {
        float f = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            f += (float) this.f5920i.mo7105c(mo8225p().mo8092a(str.codePointAt(i))).mo7135a();
        }
        return f;
    }

    /* renamed from: c */
    public float mo8096c(int i) {
        PointF pointF = new PointF(this.f5921j.mo7032a_(mo8237g(i)), 0.0f);
        this.f5919h.mo7402a(pointF, pointF);
        return pointF.x;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public byte[] mo8097d(int i) {
        throw new UnsupportedOperationException("Not implemented: Type1C");
    }

    /* renamed from: e */
    public boolean mo8098e() {
        return this.f5922k;
    }

    /* renamed from: f */
    public final String mo8099f() {
        return mo8238u();
    }

    /* renamed from: g */
    public C1586a mo8100g() {
        return this.f5921j.mo7035c();
    }

    /* renamed from: g */
    public String mo8237g(int i) {
        return mo8224o().mo8088a(i);
    }

    /* renamed from: i */
    public final C1940d mo8101i() {
        if (this.f5918g == null) {
            List<Number> list = null;
            try {
                list = this.f5921j.mo7036d();
            } catch (IOException unused) {
                this.f5918g = f5883a;
            }
            if (list == null || list.size() != 6) {
                return super.mo8101i();
            }
            this.f5918g = new C1940d(list.get(0).floatValue(), list.get(1).floatValue(), list.get(2).floatValue(), list.get(3).floatValue(), list.get(4).floatValue(), list.get(5).floatValue());
        }
        return this.f5918g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public C1789c mo8103n() {
        if (mo8157a() != null) {
            return new C1794h(mo8157a());
        }
        C1479b bVar = this.f5921j;
        return bVar instanceof C1470a ? C1794h.m7261a(((C1470a) bVar).mo6952a()) : C1793g.f5808c;
    }

    /* renamed from: u */
    public final String mo8238u() {
        return this.f5884b.mo7544e(C1613i.f4900I);
    }
}
