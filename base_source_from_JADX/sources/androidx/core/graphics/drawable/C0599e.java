package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: androidx.core.graphics.drawable.e */
class C0599e extends C0598d {

    /* renamed from: d */
    private static Method f2215d;

    C0599e(Drawable drawable) {
        super(drawable);
        m2341c();
    }

    C0599e(C0600f fVar, Resources resources) {
        super(fVar, resources);
        m2341c();
    }

    /* renamed from: c */
    private void m2341c() {
        if (f2215d == null) {
            try {
                f2215d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo3626b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f2210c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public Rect getDirtyBounds() {
        return this.f2210c.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f2210c.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        if (!(this.f2210c == null || (method = f2215d) == null)) {
            try {
                return ((Boolean) method.invoke(this.f2210c, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    public void setHotspot(float f, float f2) {
        this.f2210c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f2210c.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (mo3626b()) {
            super.setTint(i);
        } else {
            this.f2210c.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo3626b()) {
            super.setTintList(colorStateList);
        } else {
            this.f2210c.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (mo3626b()) {
            super.setTintMode(mode);
        } else {
            this.f2210c.setTintMode(mode);
        }
    }
}
