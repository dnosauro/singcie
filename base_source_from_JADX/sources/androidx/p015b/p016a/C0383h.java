package androidx.p015b.p016a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.p015b.C0367a;

/* renamed from: androidx.b.a.h */
class C0383h extends Drawable {

    /* renamed from: a */
    static C0384a f1309a;

    /* renamed from: b */
    private static final double f1310b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c */
    private final int f1311c;

    /* renamed from: d */
    private Paint f1312d;

    /* renamed from: e */
    private Paint f1313e;

    /* renamed from: f */
    private Paint f1314f;

    /* renamed from: g */
    private final RectF f1315g;

    /* renamed from: h */
    private float f1316h;

    /* renamed from: i */
    private Path f1317i;

    /* renamed from: j */
    private float f1318j;

    /* renamed from: k */
    private float f1319k;

    /* renamed from: l */
    private float f1320l;

    /* renamed from: m */
    private ColorStateList f1321m;

    /* renamed from: n */
    private boolean f1322n = true;

    /* renamed from: o */
    private final int f1323o;

    /* renamed from: p */
    private final int f1324p;

    /* renamed from: q */
    private boolean f1325q = true;

    /* renamed from: r */
    private boolean f1326r = false;

    /* renamed from: androidx.b.a.h$a */
    interface C0384a {
        /* renamed from: a */
        void mo2741a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    C0383h(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f1323o = resources.getColor(C0367a.C0369b.cardview_shadow_start_color);
        this.f1324p = resources.getColor(C0367a.C0369b.cardview_shadow_end_color);
        this.f1311c = resources.getDimensionPixelSize(C0367a.C0370c.cardview_compat_inset_shadow);
        this.f1312d = new Paint(5);
        m1435b(colorStateList);
        this.f1313e = new Paint(5);
        this.f1313e.setStyle(Paint.Style.FILL);
        this.f1316h = (float) ((int) (f + 0.5f));
        this.f1315g = new RectF();
        this.f1314f = new Paint(this.f1313e);
        this.f1314f.setAntiAlias(false);
        m1432a(f2, f3);
    }

    /* renamed from: a */
    static float m1431a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f1310b) * ((double) f2))) : f * 1.5f;
    }

    /* renamed from: a */
    private void m1432a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 >= 0.0f) {
            float d = (float) m1437d(f);
            float d2 = (float) m1437d(f2);
            if (d > d2) {
                if (!this.f1326r) {
                    this.f1326r = true;
                }
                d = d2;
            }
            if (this.f1320l != d || this.f1318j != d2) {
                this.f1320l = d;
                this.f1318j = d2;
                this.f1319k = (float) ((int) ((d * 1.5f) + ((float) this.f1311c) + 0.5f));
                this.f1322n = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
    }

    /* renamed from: a */
    private void m1433a(Canvas canvas) {
        float f = this.f1316h;
        float f2 = (-f) - this.f1319k;
        float f3 = f + ((float) this.f1311c) + (this.f1320l / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f1315g.width() - f4 > 0.0f;
        boolean z2 = this.f1315g.height() - f4 > 0.0f;
        int save = canvas.save();
        canvas.translate(this.f1315g.left + f3, this.f1315g.top + f3);
        canvas.drawPath(this.f1317i, this.f1313e);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f1315g.width() - f4, -this.f1316h, this.f1314f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f1315g.right - f3, this.f1315g.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1317i, this.f1313e);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f1315g.width() - f4, (-this.f1316h) + this.f1319k, this.f1314f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f1315g.left + f3, this.f1315g.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1317i, this.f1313e);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f1315g.height() - f4, -this.f1316h, this.f1314f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.f1315g.right - f3, this.f1315g.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1317i, this.f1313e);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f1315g.height() - f4, -this.f1316h, this.f1314f);
        }
        canvas.restoreToCount(save4);
    }

    /* renamed from: b */
    static float m1434b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f1310b) * ((double) f2))) : f;
    }

    /* renamed from: b */
    private void m1435b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1321m = colorStateList;
        this.f1312d.setColor(this.f1321m.getColorForState(getState(), this.f1321m.getDefaultColor()));
    }

    /* renamed from: b */
    private void m1436b(Rect rect) {
        float f = this.f1318j * 1.5f;
        this.f1315g.set(((float) rect.left) + this.f1318j, ((float) rect.top) + f, ((float) rect.right) - this.f1318j, ((float) rect.bottom) - f);
        m1438g();
    }

    /* renamed from: d */
    private int m1437d(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* renamed from: g */
    private void m1438g() {
        float f = this.f1316h;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f1319k;
        rectF2.inset(-f2, -f2);
        Path path = this.f1317i;
        if (path == null) {
            this.f1317i = new Path();
        } else {
            path.reset();
        }
        this.f1317i.setFillType(Path.FillType.EVEN_ODD);
        this.f1317i.moveTo(-this.f1316h, 0.0f);
        this.f1317i.rLineTo(-this.f1319k, 0.0f);
        this.f1317i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1317i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1317i.close();
        float f3 = this.f1316h;
        float f4 = this.f1319k;
        Paint paint = this.f1313e;
        float f5 = f3 + f4;
        int i = this.f1323o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.f1324p}, new float[]{0.0f, f3 / (f3 + f4), 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1314f;
        float f6 = this.f1316h;
        float f7 = this.f1319k;
        int i2 = this.f1323o;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.f1324p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1314f.setAntiAlias(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo2772a() {
        return this.f1316h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2773a(float f) {
        if (f >= 0.0f) {
            float f2 = (float) ((int) (f + 0.5f));
            if (this.f1316h != f2) {
                this.f1316h = f2;
                this.f1322n = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2774a(ColorStateList colorStateList) {
        m1435b(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2775a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2776a(boolean z) {
        this.f1325q = z;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo2777b() {
        return this.f1320l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2778b(float f) {
        m1432a(f, this.f1318j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo2779c() {
        return this.f1318j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2780c(float f) {
        m1432a(this.f1320l, f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo2781d() {
        float f = this.f1318j;
        return (Math.max(f, this.f1316h + ((float) this.f1311c) + (f / 2.0f)) * 2.0f) + ((this.f1318j + ((float) this.f1311c)) * 2.0f);
    }

    public void draw(Canvas canvas) {
        if (this.f1322n) {
            m1436b(getBounds());
            this.f1322n = false;
        }
        canvas.translate(0.0f, this.f1320l / 2.0f);
        m1433a(canvas);
        canvas.translate(0.0f, (-this.f1320l) / 2.0f);
        f1309a.mo2741a(canvas, this.f1315g, this.f1316h, this.f1312d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public float mo2783e() {
        float f = this.f1318j;
        return (Math.max(f, this.f1316h + ((float) this.f1311c) + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.f1318j * 1.5f) + ((float) this.f1311c)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public ColorStateList mo2784f() {
        return this.f1321m;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m1431a(this.f1318j, this.f1316h, this.f1325q));
        int ceil2 = (int) Math.ceil((double) m1434b(this.f1318j, this.f1316h, this.f1325q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f1321m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1322n = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1321m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1312d.getColor() == colorForState) {
            return false;
        }
        this.f1312d.setColor(colorForState);
        this.f1322n = true;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i) {
        this.f1312d.setAlpha(i);
        this.f1313e.setAlpha(i);
        this.f1314f.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1312d.setColorFilter(colorFilter);
    }
}
