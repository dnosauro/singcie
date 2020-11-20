package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.p146g.C2189a;
import com.github.barteksc.pdfviewer.p146g.C2193c;
import com.github.barteksc.pdfviewer.p146g.C2197f;
import com.shockwave.pdfium.util.SizeF;
import java.util.List;

/* renamed from: com.github.barteksc.pdfviewer.e */
class C2175e {

    /* renamed from: a */
    private PDFView f6743a;

    /* renamed from: b */
    private int f6744b;

    /* renamed from: c */
    private float f6745c;

    /* renamed from: d */
    private float f6746d;

    /* renamed from: e */
    private float f6747e;

    /* renamed from: f */
    private float f6748f;

    /* renamed from: g */
    private float f6749g;

    /* renamed from: h */
    private float f6750h;

    /* renamed from: i */
    private final RectF f6751i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: j */
    private final int f6752j;

    /* renamed from: com.github.barteksc.pdfviewer.e$a */
    private class C2177a {

        /* renamed from: a */
        int f6753a;

        /* renamed from: b */
        int f6754b;

        private C2177a() {
        }

        public String toString() {
            return "GridSize{rows=" + this.f6753a + ", cols=" + this.f6754b + '}';
        }
    }

    /* renamed from: com.github.barteksc.pdfviewer.e$b */
    private class C2178b {

        /* renamed from: a */
        int f6756a;

        /* renamed from: b */
        int f6757b;

        private C2178b() {
        }

        public String toString() {
            return "Holder{row=" + this.f6756a + ", col=" + this.f6757b + '}';
        }
    }

    /* renamed from: com.github.barteksc.pdfviewer.e$c */
    private class C2179c {

        /* renamed from: a */
        int f6759a = 0;

        /* renamed from: b */
        C2177a f6760b;

        /* renamed from: c */
        C2178b f6761c;

        /* renamed from: d */
        C2178b f6762d;

        C2179c() {
            this.f6760b = new C2177a();
            this.f6761c = new C2178b();
            this.f6762d = new C2178b();
        }

        public String toString() {
            return "RenderRange{page=" + this.f6759a + ", gridSize=" + this.f6760b + ", leftTop=" + this.f6761c + ", rightBottom=" + this.f6762d + '}';
        }
    }

    C2175e(PDFView pDFView) {
        this.f6743a = pDFView;
        this.f6752j = C2197f.m8626a(pDFView.getContext(), C2189a.f6798d);
    }

    /* renamed from: a */
    private int m8564a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i2 <= i3) {
            int i8 = i7;
            for (int i9 = i4; i9 <= i5; i9++) {
                if (m8569a(i, i2, i9, this.f6747e, this.f6748f)) {
                    i8++;
                }
                if (i8 >= i6) {
                    return i8;
                }
            }
            i2++;
            i7 = i8;
        }
        return i7;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01a1  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.github.barteksc.pdfviewer.C2175e.C2179c> m8565a(float r20, float r21, float r22, float r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r2 = r20
            float r2 = com.github.barteksc.pdfviewer.p146g.C2193c.m8614a(r2, r1)
            float r2 = -r2
            r3 = r21
            float r3 = com.github.barteksc.pdfviewer.p146g.C2193c.m8614a(r3, r1)
            float r3 = -r3
            r4 = r22
            float r4 = com.github.barteksc.pdfviewer.p146g.C2193c.m8614a(r4, r1)
            float r4 = -r4
            r5 = r23
            float r5 = com.github.barteksc.pdfviewer.p146g.C2193c.m8614a(r5, r1)
            float r5 = -r5
            com.github.barteksc.pdfviewer.PDFView r6 = r0.f6743a
            boolean r6 = r6.mo9006m()
            if (r6 == 0) goto L_0x0029
            r6 = r3
            goto L_0x002a
        L_0x0029:
            r6 = r2
        L_0x002a:
            com.github.barteksc.pdfviewer.PDFView r7 = r0.f6743a
            boolean r7 = r7.mo9006m()
            if (r7 == 0) goto L_0x0034
            r7 = r5
            goto L_0x0035
        L_0x0034:
            r7 = r4
        L_0x0035:
            com.github.barteksc.pdfviewer.PDFView r8 = r0.f6743a
            com.github.barteksc.pdfviewer.f r8 = r8.f6624b
            com.github.barteksc.pdfviewer.PDFView r9 = r0.f6743a
            float r9 = r9.getZoom()
            int r6 = r8.mo9144a((float) r6, (float) r9)
            com.github.barteksc.pdfviewer.PDFView r8 = r0.f6743a
            com.github.barteksc.pdfviewer.f r8 = r8.f6624b
            com.github.barteksc.pdfviewer.PDFView r9 = r0.f6743a
            float r9 = r9.getZoom()
            int r7 = r8.mo9144a((float) r7, (float) r9)
            int r8 = r7 - r6
            r9 = 1
            int r8 = r8 + r9
            java.util.LinkedList r10 = new java.util.LinkedList
            r10.<init>()
            r11 = r6
        L_0x005b:
            if (r11 > r7) goto L_0x0215
            com.github.barteksc.pdfviewer.e$c r12 = new com.github.barteksc.pdfviewer.e$c
            r12.<init>()
            r12.f6759a = r11
            if (r11 != r6) goto L_0x00a6
            if (r8 != r9) goto L_0x006f
            r13 = r2
        L_0x0069:
            r14 = r3
        L_0x006a:
            r15 = r4
            r16 = r5
            goto L_0x00f9
        L_0x006f:
            com.github.barteksc.pdfviewer.PDFView r13 = r0.f6743a
            com.github.barteksc.pdfviewer.f r13 = r13.f6624b
            com.github.barteksc.pdfviewer.PDFView r14 = r0.f6743a
            float r14 = r14.getZoom()
            float r13 = r13.mo9157d(r11, r14)
            com.github.barteksc.pdfviewer.PDFView r14 = r0.f6743a
            com.github.barteksc.pdfviewer.f r14 = r14.f6624b
            com.github.barteksc.pdfviewer.PDFView r15 = r0.f6743a
            float r15 = r15.getZoom()
            com.shockwave.pdfium.util.SizeF r14 = r14.mo9147a((int) r11, (float) r15)
            com.github.barteksc.pdfviewer.PDFView r15 = r0.f6743a
            boolean r15 = r15.mo9006m()
            if (r15 == 0) goto L_0x009b
            float r14 = r14.mo24007b()
            float r13 = r13 + r14
            r14 = r13
            r13 = r4
            goto L_0x00a1
        L_0x009b:
            float r14 = r14.mo24006a()
            float r13 = r13 + r14
            r14 = r5
        L_0x00a1:
            r15 = r13
            r16 = r14
            r13 = r2
            goto L_0x00f8
        L_0x00a6:
            if (r11 != r7) goto L_0x00c1
            com.github.barteksc.pdfviewer.PDFView r13 = r0.f6743a
            com.github.barteksc.pdfviewer.f r13 = r13.f6624b
            com.github.barteksc.pdfviewer.PDFView r14 = r0.f6743a
            float r14 = r14.getZoom()
            float r13 = r13.mo9157d(r11, r14)
            com.github.barteksc.pdfviewer.PDFView r14 = r0.f6743a
            boolean r14 = r14.mo9006m()
            if (r14 == 0) goto L_0x0069
            r14 = r13
            r13 = r2
            goto L_0x006a
        L_0x00c1:
            com.github.barteksc.pdfviewer.PDFView r13 = r0.f6743a
            com.github.barteksc.pdfviewer.f r13 = r13.f6624b
            com.github.barteksc.pdfviewer.PDFView r14 = r0.f6743a
            float r14 = r14.getZoom()
            float r13 = r13.mo9157d(r11, r14)
            com.github.barteksc.pdfviewer.PDFView r14 = r0.f6743a
            com.github.barteksc.pdfviewer.f r14 = r14.f6624b
            com.github.barteksc.pdfviewer.PDFView r15 = r0.f6743a
            float r15 = r15.getZoom()
            com.shockwave.pdfium.util.SizeF r14 = r14.mo9147a((int) r11, (float) r15)
            com.github.barteksc.pdfviewer.PDFView r15 = r0.f6743a
            boolean r15 = r15.mo9006m()
            if (r15 == 0) goto L_0x00f0
            float r14 = r14.mo24007b()
            float r14 = r14 + r13
            r15 = r4
            r16 = r14
            r14 = r13
            r13 = r2
            goto L_0x00f9
        L_0x00f0:
            float r14 = r14.mo24006a()
            float r14 = r14 + r13
            r16 = r5
            r15 = r14
        L_0x00f8:
            r14 = r3
        L_0x00f9:
            com.github.barteksc.pdfviewer.e$a r9 = r12.f6760b
            int r1 = r12.f6759a
            r0.m8568a(r9, r1)
            com.github.barteksc.pdfviewer.PDFView r1 = r0.f6743a
            com.github.barteksc.pdfviewer.f r1 = r1.f6624b
            int r9 = r12.f6759a
            r17 = r2
            com.github.barteksc.pdfviewer.PDFView r2 = r0.f6743a
            float r2 = r2.getZoom()
            com.shockwave.pdfium.util.SizeF r1 = r1.mo9147a((int) r9, (float) r2)
            float r2 = r1.mo24007b()
            com.github.barteksc.pdfviewer.e$a r9 = r12.f6760b
            int r9 = r9.f6753a
            float r9 = (float) r9
            float r2 = r2 / r9
            float r1 = r1.mo24006a()
            com.github.barteksc.pdfviewer.e$a r9 = r12.f6760b
            int r9 = r9.f6754b
            float r9 = (float) r9
            float r1 = r1 / r9
            com.github.barteksc.pdfviewer.PDFView r9 = r0.f6743a
            com.github.barteksc.pdfviewer.f r9 = r9.f6624b
            r21 = r3
            com.github.barteksc.pdfviewer.PDFView r3 = r0.f6743a
            float r3 = r3.getZoom()
            float r3 = r9.mo9159e(r11, r3)
            com.github.barteksc.pdfviewer.PDFView r9 = r0.f6743a
            boolean r9 = r9.mo9006m()
            if (r9 == 0) goto L_0x01a1
            com.github.barteksc.pdfviewer.e$b r9 = r12.f6761c
            r22 = r4
            com.github.barteksc.pdfviewer.PDFView r4 = r0.f6743a
            com.github.barteksc.pdfviewer.f r4 = r4.f6624b
            r23 = r5
            int r5 = r12.f6759a
            r18 = r6
            com.github.barteksc.pdfviewer.PDFView r6 = r0.f6743a
            float r6 = r6.getZoom()
            float r4 = r4.mo9157d(r5, r6)
            float r14 = r14 - r4
            float r4 = java.lang.Math.abs(r14)
            float r4 = r4 / r2
            int r4 = com.github.barteksc.pdfviewer.p146g.C2193c.m8616a(r4)
            r9.f6756a = r4
            com.github.barteksc.pdfviewer.e$b r4 = r12.f6761c
            float r13 = r13 - r3
            r5 = 0
            float r6 = com.github.barteksc.pdfviewer.p146g.C2193c.m8617b(r13, r5)
            float r6 = r6 / r1
            int r5 = com.github.barteksc.pdfviewer.p146g.C2193c.m8616a(r6)
            r4.f6757b = r5
            com.github.barteksc.pdfviewer.e$b r4 = r12.f6762d
            com.github.barteksc.pdfviewer.PDFView r5 = r0.f6743a
            com.github.barteksc.pdfviewer.f r5 = r5.f6624b
            int r6 = r12.f6759a
            com.github.barteksc.pdfviewer.PDFView r9 = r0.f6743a
            float r9 = r9.getZoom()
            float r5 = r5.mo9157d(r6, r9)
            float r16 = r16 - r5
            float r5 = java.lang.Math.abs(r16)
            float r5 = r5 / r2
            int r2 = com.github.barteksc.pdfviewer.p146g.C2193c.m8618b(r5)
            r4.f6756a = r2
            com.github.barteksc.pdfviewer.e$b r2 = r12.f6762d
            float r15 = r15 - r3
            r3 = 0
            float r4 = com.github.barteksc.pdfviewer.p146g.C2193c.m8617b(r15, r3)
            float r4 = r4 / r1
            int r1 = com.github.barteksc.pdfviewer.p146g.C2193c.m8616a(r4)
            r2.f6757b = r1
            r4 = 0
            goto L_0x0202
        L_0x01a1:
            r22 = r4
            r23 = r5
            r18 = r6
            com.github.barteksc.pdfviewer.e$b r4 = r12.f6761c
            com.github.barteksc.pdfviewer.PDFView r5 = r0.f6743a
            com.github.barteksc.pdfviewer.f r5 = r5.f6624b
            int r6 = r12.f6759a
            com.github.barteksc.pdfviewer.PDFView r9 = r0.f6743a
            float r9 = r9.getZoom()
            float r5 = r5.mo9157d(r6, r9)
            float r13 = r13 - r5
            float r5 = java.lang.Math.abs(r13)
            float r5 = r5 / r1
            int r5 = com.github.barteksc.pdfviewer.p146g.C2193c.m8616a(r5)
            r4.f6757b = r5
            com.github.barteksc.pdfviewer.e$b r4 = r12.f6761c
            float r14 = r14 - r3
            r5 = 0
            float r6 = com.github.barteksc.pdfviewer.p146g.C2193c.m8617b(r14, r5)
            float r6 = r6 / r2
            int r5 = com.github.barteksc.pdfviewer.p146g.C2193c.m8616a(r6)
            r4.f6756a = r5
            com.github.barteksc.pdfviewer.e$b r4 = r12.f6762d
            com.github.barteksc.pdfviewer.PDFView r5 = r0.f6743a
            com.github.barteksc.pdfviewer.f r5 = r5.f6624b
            int r6 = r12.f6759a
            com.github.barteksc.pdfviewer.PDFView r9 = r0.f6743a
            float r9 = r9.getZoom()
            float r5 = r5.mo9157d(r6, r9)
            float r15 = r15 - r5
            float r5 = java.lang.Math.abs(r15)
            float r5 = r5 / r1
            int r1 = com.github.barteksc.pdfviewer.p146g.C2193c.m8616a(r5)
            r4.f6757b = r1
            com.github.barteksc.pdfviewer.e$b r1 = r12.f6762d
            float r3 = r16 - r3
            r4 = 0
            float r3 = com.github.barteksc.pdfviewer.p146g.C2193c.m8617b(r3, r4)
            float r3 = r3 / r2
            int r2 = com.github.barteksc.pdfviewer.p146g.C2193c.m8616a(r3)
            r1.f6756a = r2
        L_0x0202:
            r10.add(r12)
            int r11 = r11 + 1
            r3 = r21
            r4 = r22
            r5 = r23
            r2 = r17
            r6 = r18
            r1 = 0
            r9 = 1
            goto L_0x005b
        L_0x0215:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.C2175e.m8565a(float, float, float, float):java.util.List");
    }

    /* renamed from: a */
    private void m8566a(int i) {
        SizeF a = this.f6743a.f6624b.mo9146a(i);
        float a2 = a.mo24006a() * C2189a.f6796b;
        float b = a.mo24007b() * C2189a.f6796b;
        if (!this.f6743a.f6623a.mo9059a(i, this.f6751i)) {
            this.f6743a.f6625c.mo9170a(i, a2, b, this.f6751i, true, 0, this.f6743a.mo9005l(), this.f6743a.mo9008o());
        }
    }

    /* renamed from: a */
    private void m8567a(C2177a aVar) {
        this.f6747e = 1.0f / ((float) aVar.f6754b);
        this.f6748f = 1.0f / ((float) aVar.f6753a);
        this.f6749g = C2189a.f6797c / this.f6747e;
        this.f6750h = C2189a.f6797c / this.f6748f;
    }

    /* renamed from: a */
    private void m8568a(C2177a aVar, int i) {
        SizeF a = this.f6743a.f6624b.mo9146a(i);
        float b = (C2189a.f6797c * (1.0f / a.mo24007b())) / this.f6743a.getZoom();
        float a2 = (C2189a.f6797c * (1.0f / a.mo24006a())) / this.f6743a.getZoom();
        aVar.f6753a = C2193c.m8618b(1.0f / b);
        aVar.f6754b = C2193c.m8618b(1.0f / a2);
    }

    /* renamed from: a */
    private boolean m8569a(int i, int i2, int i3, float f, float f2) {
        float f3 = ((float) i3) * f;
        float f4 = ((float) i2) * f2;
        float f5 = this.f6749g;
        float f6 = this.f6750h;
        float f7 = f3 + f > 1.0f ? 1.0f - f3 : f;
        float f8 = f4 + f2 > 1.0f ? 1.0f - f4 : f2;
        float f9 = f5 * f7;
        float f10 = f6 * f8;
        RectF rectF = new RectF(f3, f4, f7 + f3, f8 + f4);
        if (f9 <= 0.0f || f10 <= 0.0f) {
            return false;
        }
        if (!this.f6743a.f6623a.mo9060a(i, rectF, this.f6744b)) {
            this.f6743a.f6625c.mo9170a(i, f9, f10, rectF, false, this.f6744b, this.f6743a.mo9005l(), this.f6743a.mo9008o());
        }
        this.f6744b++;
        return true;
    }

    /* renamed from: b */
    private void m8570b() {
        float f = (float) this.f6752j;
        float f2 = this.f6745c;
        float f3 = this.f6746d;
        List<C2179c> a = m8565a((-f2) + f, (-f3) + f, ((-f2) - ((float) this.f6743a.getWidth())) - f, ((-f3) - ((float) this.f6743a.getHeight())) - f);
        for (C2179c cVar : a) {
            m8566a(cVar.f6759a);
        }
        int i = 0;
        for (C2179c next : a) {
            m8567a(next.f6760b);
            i += m8564a(next.f6759a, next.f6761c.f6756a, next.f6762d.f6756a, next.f6761c.f6757b, next.f6762d.f6757b, C2189a.C2190a.f6799a - i);
            if (i >= C2189a.C2190a.f6799a) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9126a() {
        this.f6744b = 1;
        this.f6745c = -C2193c.m8614a(this.f6743a.getCurrentXOffset(), 0.0f);
        this.f6746d = -C2193c.m8614a(this.f6743a.getCurrentYOffset(), 0.0f);
        m8570b();
    }
}
