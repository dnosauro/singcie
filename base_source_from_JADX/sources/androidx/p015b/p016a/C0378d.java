package androidx.p015b.p016a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.p015b.p016a.C0383h;

/* renamed from: androidx.b.a.d */
class C0378d implements C0381f {

    /* renamed from: a */
    final RectF f1296a = new RectF();

    C0378d() {
    }

    /* renamed from: a */
    private C0383h m1382a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new C0383h(context.getResources(), colorStateList, f, f2, f3);
    }

    /* renamed from: j */
    private C0383h m1383j(C0380e eVar) {
        return (C0383h) eVar.mo2738c();
    }

    /* renamed from: a */
    public float mo2742a(C0380e eVar) {
        return m1383j(eVar).mo2779c();
    }

    /* renamed from: a */
    public void mo2740a() {
        C0383h.f1309a = new C0383h.C0384a() {
            /* renamed from: a */
            public void mo2741a(Canvas canvas, RectF rectF, float f, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    C0378d.this.f1296a.set(f4, f4, f3, f3);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                    Paint paint2 = paint;
                    canvas.drawArc(C0378d.this.f1296a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(C0378d.this.f1296a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(C0378d.this.f1296a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(C0378d.this.f1296a, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(save);
                    canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint2);
                    canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.bottom - f3, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint2);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
            }
        };
    }

    /* renamed from: a */
    public void mo2743a(C0380e eVar, float f) {
        m1383j(eVar).mo2773a(f);
        mo2752f(eVar);
    }

    /* renamed from: a */
    public void mo2744a(C0380e eVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C0383h a = m1382a(context, colorStateList, f, f2, f3);
        a.mo2776a(eVar.mo2737b());
        eVar.mo2735a(a);
        mo2752f(eVar);
    }

    /* renamed from: a */
    public void mo2745a(C0380e eVar, ColorStateList colorStateList) {
        m1383j(eVar).mo2774a(colorStateList);
    }

    /* renamed from: b */
    public float mo2746b(C0380e eVar) {
        return m1383j(eVar).mo2781d();
    }

    /* renamed from: b */
    public void mo2747b(C0380e eVar, float f) {
        m1383j(eVar).mo2780c(f);
        mo2752f(eVar);
    }

    /* renamed from: c */
    public float mo2748c(C0380e eVar) {
        return m1383j(eVar).mo2783e();
    }

    /* renamed from: c */
    public void mo2749c(C0380e eVar, float f) {
        m1383j(eVar).mo2778b(f);
    }

    /* renamed from: d */
    public float mo2750d(C0380e eVar) {
        return m1383j(eVar).mo2772a();
    }

    /* renamed from: e */
    public float mo2751e(C0380e eVar) {
        return m1383j(eVar).mo2777b();
    }

    /* renamed from: f */
    public void mo2752f(C0380e eVar) {
        Rect rect = new Rect();
        m1383j(eVar).mo2775a(rect);
        eVar.mo2733a((int) Math.ceil((double) mo2746b(eVar)), (int) Math.ceil((double) mo2748c(eVar)));
        eVar.mo2734a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: g */
    public void mo2753g(C0380e eVar) {
    }

    /* renamed from: h */
    public void mo2754h(C0380e eVar) {
        m1383j(eVar).mo2776a(eVar.mo2737b());
        mo2752f(eVar);
    }

    /* renamed from: i */
    public ColorStateList mo2755i(C0380e eVar) {
        return m1383j(eVar).mo2784f();
    }
}
