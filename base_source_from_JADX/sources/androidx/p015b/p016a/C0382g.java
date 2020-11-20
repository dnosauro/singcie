package androidx.p015b.p016a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.b.a.g */
class C0382g extends Drawable {

    /* renamed from: a */
    private float f1298a;

    /* renamed from: b */
    private final Paint f1299b;

    /* renamed from: c */
    private final RectF f1300c;

    /* renamed from: d */
    private final Rect f1301d;

    /* renamed from: e */
    private float f1302e;

    /* renamed from: f */
    private boolean f1303f = false;

    /* renamed from: g */
    private boolean f1304g = true;

    /* renamed from: h */
    private ColorStateList f1305h;

    /* renamed from: i */
    private PorterDuffColorFilter f1306i;

    /* renamed from: j */
    private ColorStateList f1307j;

    /* renamed from: k */
    private PorterDuff.Mode f1308k = PorterDuff.Mode.SRC_IN;

    C0382g(ColorStateList colorStateList, float f) {
        this.f1298a = f;
        this.f1299b = new Paint(5);
        m1424b(colorStateList);
        this.f1300c = new RectF();
        this.f1301d = new Rect();
    }

    /* renamed from: a */
    private PorterDuffColorFilter m1422a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* renamed from: a */
    private void m1423a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1300c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1301d.set(rect);
        if (this.f1303f) {
            float a = C0383h.m1431a(this.f1302e, this.f1298a, this.f1304g);
            this.f1301d.inset((int) Math.ceil((double) C0383h.m1434b(this.f1302e, this.f1298a, this.f1304g)), (int) Math.ceil((double) a));
            this.f1300c.set(this.f1301d);
        }
    }

    /* renamed from: b */
    private void m1424b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1305h = colorStateList;
        this.f1299b.setColor(this.f1305h.getColorForState(getState(), this.f1305h.getDefaultColor()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo2756a() {
        return this.f1302e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2757a(float f) {
        if (f != this.f1298a) {
            this.f1298a = f;
            m1423a((Rect) null);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2758a(float f, boolean z, boolean z2) {
        if (f != this.f1302e || this.f1303f != z || this.f1304g != z2) {
            this.f1302e = f;
            this.f1303f = z;
            this.f1304g = z2;
            m1423a((Rect) null);
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public void mo2759a(ColorStateList colorStateList) {
        m1424b(colorStateList);
        invalidateSelf();
    }

    /* renamed from: b */
    public float mo2760b() {
        return this.f1298a;
    }

    /* renamed from: c */
    public ColorStateList mo2761c() {
        return this.f1305h;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1299b;
        if (this.f1306i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1306i);
            z = true;
        }
        RectF rectF = this.f1300c;
        float f = this.f1298a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1301d, this.f1298a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f1305h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f1307j
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f1305h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x0014:
            boolean r0 = super.isStateful()
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p015b.p016a.C0382g.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m1423a(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1305h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f1299b.getColor();
        if (z) {
            this.f1299b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1307j;
        if (colorStateList2 == null || (mode = this.f1308k) == null) {
            return z;
        }
        this.f1306i = m1422a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i) {
        this.f1299b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1299b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1307j = colorStateList;
        this.f1306i = m1422a(this.f1307j, this.f1308k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f1308k = mode;
        this.f1306i = m1422a(this.f1307j, this.f1308k);
        invalidateSelf();
    }
}
