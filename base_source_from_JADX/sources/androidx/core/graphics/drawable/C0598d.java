package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.core.graphics.drawable.d */
class C0598d extends Drawable implements Drawable.Callback, C0596b, C0597c {

    /* renamed from: a */
    static final PorterDuff.Mode f2208a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    C0600f f2209b;

    /* renamed from: c */
    Drawable f2210c;

    /* renamed from: d */
    private int f2211d;

    /* renamed from: e */
    private PorterDuff.Mode f2212e;

    /* renamed from: f */
    private boolean f2213f;

    /* renamed from: g */
    private boolean f2214g;

    C0598d(Drawable drawable) {
        this.f2209b = m2337c();
        mo3625a(drawable);
    }

    C0598d(C0600f fVar, Resources resources) {
        this.f2209b = fVar;
        m2335a(resources);
    }

    /* renamed from: a */
    private void m2335a(Resources resources) {
        C0600f fVar = this.f2209b;
        if (fVar != null && fVar.f2217b != null) {
            mo3625a(this.f2209b.f2217b.newDrawable(resources));
        }
    }

    /* renamed from: a */
    private boolean m2336a(int[] iArr) {
        if (!mo3626b()) {
            return false;
        }
        ColorStateList colorStateList = this.f2209b.f2218c;
        PorterDuff.Mode mode = this.f2209b.f2219d;
        if (colorStateList == null || mode == null) {
            this.f2213f = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f2213f && colorForState == this.f2211d && mode == this.f2212e)) {
                setColorFilter(colorForState, mode);
                this.f2211d = colorForState;
                this.f2212e = mode;
                this.f2213f = true;
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private C0600f m2337c() {
        return new C0600f(this.f2209b);
    }

    /* renamed from: a */
    public final Drawable mo3624a() {
        return this.f2210c;
    }

    /* renamed from: a */
    public final void mo3625a(Drawable drawable) {
        Drawable drawable2 = this.f2210c;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f2210c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            C0600f fVar = this.f2209b;
            if (fVar != null) {
                fVar.f2217b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo3626b() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f2210c.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        C0600f fVar = this.f2209b;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f2210c.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        C0600f fVar = this.f2209b;
        if (fVar == null || !fVar.mo3661a()) {
            return null;
        }
        this.f2209b.f2216a = getChangingConfigurations();
        return this.f2209b;
    }

    public Drawable getCurrent() {
        return this.f2210c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2210c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2210c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f2210c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f2210c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2210c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f2210c.getPadding(rect);
    }

    public int[] getState() {
        return this.f2210c.getState();
    }

    public Region getTransparentRegion() {
        return this.f2210c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f2210c.isAutoMirrored();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f2209b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.mo3626b()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.f r0 = r1.f2209b
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f2218c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.f2210c
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.C0598d.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.f2210c.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f2214g && super.mutate() == this) {
            this.f2209b = m2337c();
            Drawable drawable = this.f2210c;
            if (drawable != null) {
                drawable.mutate();
            }
            C0600f fVar = this.f2209b;
            if (fVar != null) {
                Drawable drawable2 = this.f2210c;
                fVar.f2217b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f2214g = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2210c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f2210c.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f2210c.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        this.f2210c.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i) {
        this.f2210c.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2210c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f2210c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f2210c.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m2336a(iArr) || this.f2210c.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2209b.f2218c = colorStateList;
        m2336a(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f2209b.f2219d = mode;
        m2336a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2210c.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
