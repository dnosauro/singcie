package com.cyberneid.p089b.p091b;

import android.graphics.Path;
import android.graphics.PointF;
import android.util.Log;
import com.cyberneid.p089b.p093d.C1540c;
import com.cyberneid.p089b.p096g.C1582c;
import com.cyberneid.p099c.p100a.p101a.C1592a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.p172io.IOUtils;

/* renamed from: com.cyberneid.b.b.u */
public class C1525u {

    /* renamed from: a */
    protected List<Object> f4516a;

    /* renamed from: b */
    protected int f4517b;

    /* renamed from: c */
    private C1582c f4518c;

    /* renamed from: d */
    private String f4519d;

    /* renamed from: e */
    private String f4520e;

    /* renamed from: f */
    private Path f4521f;

    /* renamed from: g */
    private int f4522g;

    /* renamed from: h */
    private PointF f4523h;

    /* renamed from: i */
    private PointF f4524i;

    /* renamed from: j */
    private boolean f4525j;

    /* renamed from: k */
    private List<PointF> f4526k;

    protected C1525u(C1582c cVar, String str, String str2) {
        this.f4521f = null;
        this.f4522g = 0;
        this.f4523h = null;
        this.f4524i = null;
        this.f4525j = false;
        this.f4526k = new ArrayList();
        this.f4518c = cVar;
        this.f4519d = str;
        this.f4520e = str2;
        this.f4524i = new PointF(0.0f, 0.0f);
    }

    public C1525u(C1582c cVar, String str, String str2, List<Object> list) {
        this(cVar, str, str2);
        this.f4516a = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: java.lang.Object} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Integer> m5835a(java.util.List<java.lang.Integer> r11, com.cyberneid.p089b.p091b.C1519p r12) {
        /*
            r10 = this;
            int r1 = r10.f4517b
            r2 = 1
            int r1 = r1 + r2
            r10.f4517b = r1
            java.util.Map<com.cyberneid.b.b.p$a, java.lang.String> r1 = com.cyberneid.p089b.p091b.C1519p.f4506a
            com.cyberneid.b.b.p$a r3 = r12.mo7108a()
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = "rmoveto"
            boolean r3 = r3.equals(r1)
            r4 = 2
            r5 = 0
            if (r3 == 0) goto L_0x0059
            int r1 = r11.size()
            if (r1 < r4) goto L_0x0378
            boolean r1 = r10.f4525j
            if (r1 == 0) goto L_0x0048
            java.util.List<android.graphics.PointF> r1 = r10.f4526k
            android.graphics.PointF r3 = new android.graphics.PointF
            java.lang.Object r4 = r11.get(r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            float r4 = (float) r4
            java.lang.Object r0 = r11.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            float r0 = (float) r0
            r3.<init>(r4, r0)
            r1.add(r3)
            goto L_0x0378
        L_0x0048:
            java.lang.Object r1 = r11.get(r5)
            java.lang.Number r1 = (java.lang.Number) r1
            java.lang.Object r0 = r11.get(r2)
        L_0x0052:
            java.lang.Number r0 = (java.lang.Number) r0
            r10.m5838a((java.lang.Number) r1, (java.lang.Number) r0)
            goto L_0x0378
        L_0x0059:
            java.lang.String r3 = "vmoveto"
            boolean r3 = r3.equals(r1)
            r6 = 0
            if (r3 == 0) goto L_0x008c
            int r1 = r11.size()
            if (r1 < r2) goto L_0x0378
            boolean r1 = r10.f4525j
            if (r1 == 0) goto L_0x0083
            java.util.List<android.graphics.PointF> r1 = r10.f4526k
            android.graphics.PointF r2 = new android.graphics.PointF
            java.lang.Object r0 = r11.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            float r0 = (float) r0
            r2.<init>(r6, r0)
        L_0x007e:
            r1.add(r2)
            goto L_0x0378
        L_0x0083:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r11.get(r5)
            goto L_0x0052
        L_0x008c:
            java.lang.String r3 = "hmoveto"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00c0
            int r1 = r11.size()
            if (r1 < r2) goto L_0x0378
            boolean r1 = r10.f4525j
            if (r1 == 0) goto L_0x00b1
            java.util.List<android.graphics.PointF> r1 = r10.f4526k
            android.graphics.PointF r2 = new android.graphics.PointF
            java.lang.Object r0 = r11.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            float r0 = (float) r0
            r2.<init>(r0, r6)
            goto L_0x007e
        L_0x00b1:
            java.lang.Object r0 = r11.get(r5)
            java.lang.Number r0 = (java.lang.Number) r0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r10.m5838a((java.lang.Number) r0, (java.lang.Number) r1)
            goto L_0x0378
        L_0x00c0:
            java.lang.String r3 = "rlineto"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00df
            int r1 = r11.size()
            if (r1 < r4) goto L_0x0378
            java.lang.Object r1 = r11.get(r5)
            java.lang.Number r1 = (java.lang.Number) r1
            java.lang.Object r0 = r11.get(r2)
        L_0x00d8:
            java.lang.Number r0 = (java.lang.Number) r0
            r10.m5841b(r1, r0)
            goto L_0x0378
        L_0x00df:
            java.lang.String r3 = "hlineto"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x00fc
            int r1 = r11.size()
            if (r1 < r2) goto L_0x0378
            java.lang.Object r0 = r11.get(r5)
            java.lang.Number r0 = (java.lang.Number) r0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r10.m5841b(r0, r1)
            goto L_0x0378
        L_0x00fc:
            java.lang.String r3 = "vlineto"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0113
            int r1 = r11.size()
            if (r1 < r2) goto L_0x0378
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r11.get(r5)
            goto L_0x00d8
        L_0x0113:
            java.lang.String r3 = "rrcurveto"
            boolean r3 = r3.equals(r1)
            r7 = 5
            r8 = 4
            r9 = 3
            if (r3 == 0) goto L_0x0150
            int r1 = r11.size()
            r3 = 6
            if (r1 < r3) goto L_0x0378
            java.lang.Object r1 = r11.get(r5)
            java.lang.Number r1 = (java.lang.Number) r1
            java.lang.Object r2 = r11.get(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            java.lang.Object r3 = r11.get(r4)
            java.lang.Number r3 = (java.lang.Number) r3
            java.lang.Object r4 = r11.get(r9)
            java.lang.Number r4 = (java.lang.Number) r4
            java.lang.Object r5 = r11.get(r8)
            java.lang.Number r5 = (java.lang.Number) r5
            java.lang.Object r0 = r11.get(r7)
            r6 = r0
            java.lang.Number r6 = (java.lang.Number) r6
            r0 = r10
        L_0x014b:
            r0.m5840a(r1, r2, r3, r4, r5, r6)
            goto L_0x0378
        L_0x0150:
            java.lang.String r3 = "closepath"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x015d
            r10.m5843d()
            goto L_0x0378
        L_0x015d:
            java.lang.String r3 = "sbw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x019d
            int r1 = r11.size()
            if (r1 < r9) goto L_0x0378
            android.graphics.PointF r1 = new android.graphics.PointF
            java.lang.Object r3 = r11.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            float r3 = (float) r3
            java.lang.Object r2 = r11.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            float r2 = (float) r2
            r1.<init>(r3, r2)
            r10.f4523h = r1
            java.lang.Object r0 = r11.get(r4)
        L_0x018c:
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r10.f4522g = r0
            android.graphics.PointF r0 = r10.f4524i
            android.graphics.PointF r1 = r10.f4523h
            r0.set(r1)
            goto L_0x0378
        L_0x019d:
            java.lang.String r3 = "hsbw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x01c2
            int r1 = r11.size()
            if (r1 < r4) goto L_0x0378
            android.graphics.PointF r1 = new android.graphics.PointF
            java.lang.Object r3 = r11.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            float r3 = (float) r3
            r1.<init>(r3, r6)
            r10.f4523h = r1
            java.lang.Object r0 = r11.get(r2)
            goto L_0x018c
        L_0x01c2:
            java.lang.String r3 = "vhcurveto"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x01fa
            int r1 = r11.size()
            if (r1 < r8) goto L_0x0378
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Object r3 = r11.get(r5)
            java.lang.Number r3 = (java.lang.Number) r3
            java.lang.Object r2 = r11.get(r2)
            r6 = r2
            java.lang.Number r6 = (java.lang.Number) r6
            java.lang.Object r2 = r11.get(r4)
            r4 = r2
            java.lang.Number r4 = (java.lang.Number) r4
            java.lang.Object r0 = r11.get(r9)
            r7 = r0
            java.lang.Number r7 = (java.lang.Number) r7
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r0 = r10
            r2 = r3
            r3 = r6
            r5 = r7
            r6 = r8
            goto L_0x014b
        L_0x01fa:
            java.lang.String r3 = "hvcurveto"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0231
            int r1 = r11.size()
            if (r1 < r8) goto L_0x0378
            java.lang.Object r1 = r11.get(r5)
            java.lang.Number r1 = (java.lang.Number) r1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            java.lang.Object r2 = r11.get(r2)
            r6 = r2
            java.lang.Number r6 = (java.lang.Number) r6
            java.lang.Object r2 = r11.get(r4)
            r4 = r2
            java.lang.Number r4 = (java.lang.Number) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r11.get(r9)
            r7 = r0
            java.lang.Number r7 = (java.lang.Number) r7
            r0 = r10
            r2 = r3
            r3 = r6
            r6 = r7
            goto L_0x014b
        L_0x0231:
            java.lang.String r3 = "seac"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0264
            int r1 = r11.size()
            if (r1 < r7) goto L_0x0378
            java.lang.Object r1 = r11.get(r5)
            java.lang.Number r1 = (java.lang.Number) r1
            java.lang.Object r2 = r11.get(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            java.lang.Object r3 = r11.get(r4)
            java.lang.Number r3 = (java.lang.Number) r3
            java.lang.Object r4 = r11.get(r9)
            java.lang.Number r4 = (java.lang.Number) r4
            java.lang.Object r0 = r11.get(r8)
            r5 = r0
            java.lang.Number r5 = (java.lang.Number) r5
            r0 = r10
            r0.m5839a(r1, r2, r3, r4, r5)
            goto L_0x0378
        L_0x0264:
            java.lang.String r3 = "setcurrentpoint"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x028b
            int r1 = r11.size()
            if (r1 < r4) goto L_0x0378
            java.lang.Object r1 = r11.get(r5)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Object r0 = r11.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r10.m5837a((int) r1, (int) r0)
            goto L_0x0378
        L_0x028b:
            java.lang.String r3 = "callothersubr"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x02a8
            int r1 = r11.size()
            if (r1 < r2) goto L_0x0378
            java.lang.Object r0 = r11.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r10.m5836a(r0)
            goto L_0x0378
        L_0x02a8:
            java.lang.String r3 = "div"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x02ec
            int r1 = r11.size()
            int r1 = r1 - r2
            java.lang.Object r1 = r11.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            int r3 = r11.size()
            int r3 = r3 - r4
            java.lang.Object r3 = r11.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            int r3 = r3 / r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r11)
            int r0 = r1.size()
            int r0 = r0 - r2
            r1.remove(r0)
            int r0 = r1.size()
            int r0 = r0 - r2
            r1.remove(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r1.add(r0)
            return r1
        L_0x02ec:
            java.lang.String r0 = "hstem"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0378
            java.lang.String r0 = "vstem"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0378
            java.lang.String r0 = "hstem3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0378
            java.lang.String r0 = "vstem3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0378
            java.lang.String r0 = "dotsection"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0315
            goto L_0x0378
        L_0x0315:
            java.lang.String r0 = "endchar"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x031e
            goto L_0x0378
        L_0x031e:
            java.lang.String r0 = "return"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0355
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected charstring command: "
        L_0x032f:
            r1.append(r2)
            com.cyberneid.b.b.p$a r2 = r12.mo7108a()
            r1.append(r2)
            java.lang.String r2 = " in glyph "
            r1.append(r2)
            java.lang.String r2 = r10.f4520e
            r1.append(r2)
            java.lang.String r2 = " of font "
            r1.append(r2)
            java.lang.String r2 = r10.f4519d
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            goto L_0x0378
        L_0x0355:
            if (r1 != 0) goto L_0x0361
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown charstring command: "
            goto L_0x032f
        L_0x0361:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unhandled command: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0378:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p089b.p091b.C1525u.m5835a(java.util.List, com.cyberneid.b.b.p):java.util.List");
    }

    /* renamed from: a */
    private void m5836a(int i) {
        if (i == 0) {
            this.f4525j = false;
            if (this.f4526k.size() < 7) {
                Log.w("PdfBox-Android", "flex without moveTo in font " + this.f4519d + ", glyph " + this.f4520e + ", command " + this.f4517b);
                return;
            }
            PointF pointF = this.f4526k.get(0);
            pointF.set(this.f4524i.x + pointF.x, this.f4524i.y + pointF.y);
            PointF pointF2 = this.f4526k.get(1);
            pointF2.set(pointF.x + pointF2.x, pointF.y + pointF2.y);
            pointF2.set(pointF2.x - this.f4524i.x, pointF2.y - this.f4524i.y);
            m5840a(Float.valueOf(this.f4526k.get(1).x), Float.valueOf(this.f4526k.get(1).y), Float.valueOf(this.f4526k.get(2).x), Float.valueOf(this.f4526k.get(2).y), Float.valueOf(this.f4526k.get(3).x), Float.valueOf(this.f4526k.get(3).y));
            m5840a(Float.valueOf(this.f4526k.get(4).x), Float.valueOf(this.f4526k.get(4).y), Float.valueOf(this.f4526k.get(5).x), Float.valueOf(this.f4526k.get(5).y), Float.valueOf(this.f4526k.get(6).x), Float.valueOf(this.f4526k.get(6).y));
            this.f4526k.clear();
        } else if (i == 1) {
            this.f4525j = true;
        } else {
            throw new IllegalArgumentException("Unexpected other subroutine: " + i);
        }
    }

    /* renamed from: a */
    private void m5837a(int i, int i2) {
        this.f4524i.set((float) i, (float) i2);
    }

    /* renamed from: a */
    private void m5838a(Number number, Number number2) {
        float floatValue = this.f4524i.x + number.floatValue();
        float floatValue2 = this.f4524i.y + number2.floatValue();
        this.f4521f.moveTo(floatValue, floatValue2);
        this.f4524i.set(floatValue, floatValue2);
    }

    /* renamed from: a */
    private void m5839a(Number number, Number number2, Number number3, Number number4, Number number5) {
        String a = C1540c.f4565c.mo7060a(number4.intValue());
        if (a != null) {
            try {
                this.f4521f.op(this.f4518c.mo7048a(a).mo7136b(), Path.Op.UNION);
            } catch (IOException unused) {
                Log.w("PdfBox-Android", "invalid seac character in glyph " + this.f4520e + " of font " + this.f4519d);
            }
        }
        String a2 = C1540c.f4565c.mo7060a(number5.intValue());
        if (a2 != null) {
            try {
                C1525u a3 = this.f4518c.mo7048a(a2);
                C1592a.m6286c((double) (this.f4523h.x + number2.floatValue()), (double) (this.f4523h.y + number3.floatValue()));
                this.f4521f.op(a3.mo7136b(), Path.Op.UNION);
            } catch (IOException unused2) {
                Log.w("PdfBox-Android", "invalid seac character in glyph " + this.f4520e + " of font " + this.f4519d);
            }
        }
    }

    /* renamed from: a */
    private void m5840a(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        float floatValue = this.f4524i.x + number.floatValue();
        float floatValue2 = this.f4524i.y + number2.floatValue();
        float floatValue3 = floatValue + number3.floatValue();
        float floatValue4 = floatValue2 + number4.floatValue();
        float floatValue5 = number5.floatValue() + floatValue3;
        float floatValue6 = number6.floatValue() + floatValue4;
        if (this.f4521f.isEmpty()) {
            Log.w("PdfBox-Android", "rrcurveTo without initial moveTo in font " + this.f4519d + ", glyph " + this.f4520e);
            this.f4521f.moveTo(floatValue5, floatValue6);
        } else {
            this.f4521f.cubicTo(floatValue, floatValue2, floatValue3, floatValue4, floatValue5, floatValue6);
        }
        this.f4524i.set(floatValue5, floatValue6);
    }

    /* renamed from: b */
    private void m5841b(Number number, Number number2) {
        float floatValue = this.f4524i.x + number.floatValue();
        float floatValue2 = this.f4524i.y + number2.floatValue();
        if (this.f4521f.isEmpty()) {
            Log.w("PdfBox-Android", "rlineTo without initial moveTo in font " + this.f4519d + ", glyph " + this.f4520e);
            this.f4521f.moveTo(floatValue, floatValue2);
        } else {
            this.f4521f.lineTo(floatValue, floatValue2);
        }
        this.f4524i.set(floatValue, floatValue2);
    }

    /* renamed from: c */
    private void m5842c() {
        this.f4521f = new Path();
        this.f4523h = new PointF(0.0f, 0.0f);
        this.f4522g = 0;
        new C1521q() {
            /* renamed from: a */
            public List<Integer> mo7117a(List<Integer> list, C1519p pVar) {
                return C1525u.this.m5835a(list, pVar);
            }
        }.mo7116a(this.f4516a);
    }

    /* renamed from: d */
    private void m5843d() {
        if (this.f4521f.isEmpty()) {
            Log.w("PdfBox-Android", "closepath without initial moveTo in font " + this.f4519d + ", glyph " + this.f4520e);
        } else {
            this.f4521f.close();
        }
        this.f4521f.moveTo(this.f4524i.x, this.f4524i.y);
    }

    /* renamed from: a */
    public int mo7135a() {
        if (this.f4521f == null) {
            m5842c();
        }
        return this.f4522g;
    }

    /* renamed from: b */
    public Path mo7136b() {
        if (this.f4521f == null) {
            m5842c();
        }
        return this.f4521f;
    }

    public String toString() {
        return this.f4516a.toString().replace("|", IOUtils.LINE_SEPARATOR_UNIX).replace(",", " ");
    }
}
