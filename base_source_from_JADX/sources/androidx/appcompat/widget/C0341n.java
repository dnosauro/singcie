package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.C0059a;
import androidx.core.p030h.C0655t;
import androidx.core.widget.C0691l;

/* renamed from: androidx.appcompat.widget.n */
public class C0341n extends ImageButton implements C0655t, C0691l {
    private final C0332f mBackgroundTintHelper;
    private final C0342o mImageHelper;

    public C0341n(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0341n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.imageButtonStyle);
    }

    public C0341n(Context context, AttributeSet attributeSet, int i) {
        super(C0299av.m1073a(context), attributeSet, i);
        this.mBackgroundTintHelper = new C0332f(this);
        this.mBackgroundTintHelper.mo2504a(attributeSet, i);
        this.mImageHelper = new C0342o(this);
        this.mImageHelper.mo2578a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2507c();
        }
        C0342o oVar = this.mImageHelper;
        if (oVar != null) {
            oVar.mo2582d();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.mo2499a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.mo2505b();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0342o oVar = this.mImageHelper;
        if (oVar != null) {
            return oVar.mo2580b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0342o oVar = this.mImageHelper;
        if (oVar != null) {
            return oVar.mo2581c();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.mo2579a() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2503a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2500a(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0342o oVar = this.mImageHelper;
        if (oVar != null) {
            oVar.mo2582d();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0342o oVar = this.mImageHelper;
        if (oVar != null) {
            oVar.mo2582d();
        }
    }

    public void setImageResource(int i) {
        this.mImageHelper.mo2575a(i);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0342o oVar = this.mImageHelper;
        if (oVar != null) {
            oVar.mo2582d();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2501a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2502a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0342o oVar = this.mImageHelper;
        if (oVar != null) {
            oVar.mo2576a(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0342o oVar = this.mImageHelper;
        if (oVar != null) {
            oVar.mo2577a(mode);
        }
    }
}
