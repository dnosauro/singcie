package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.p030h.C0655t;
import androidx.core.widget.C0691l;

/* renamed from: androidx.appcompat.widget.p */
public class C0343p extends ImageView implements C0655t, C0691l {

    /* renamed from: a */
    private final C0332f f1225a;

    /* renamed from: b */
    private final C0342o f1226b;

    public C0343p(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0343p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0343p(Context context, AttributeSet attributeSet, int i) {
        super(C0299av.m1073a(context), attributeSet, i);
        this.f1225a = new C0332f(this);
        this.f1225a.mo2504a(attributeSet, i);
        this.f1226b = new C0342o(this);
        this.f1226b.mo2578a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0332f fVar = this.f1225a;
        if (fVar != null) {
            fVar.mo2507c();
        }
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            oVar.mo2582d();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0332f fVar = this.f1225a;
        if (fVar != null) {
            return fVar.mo2499a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0332f fVar = this.f1225a;
        if (fVar != null) {
            return fVar.mo2505b();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            return oVar.mo2580b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            return oVar.mo2581c();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1226b.mo2579a() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0332f fVar = this.f1225a;
        if (fVar != null) {
            fVar.mo2503a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0332f fVar = this.f1225a;
        if (fVar != null) {
            fVar.mo2500a(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            oVar.mo2582d();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            oVar.mo2582d();
        }
    }

    public void setImageResource(int i) {
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            oVar.mo2575a(i);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            oVar.mo2582d();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0332f fVar = this.f1225a;
        if (fVar != null) {
            fVar.mo2501a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0332f fVar = this.f1225a;
        if (fVar != null) {
            fVar.mo2502a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            oVar.mo2576a(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0342o oVar = this.f1226b;
        if (oVar != null) {
            oVar.mo2577a(mode);
        }
    }
}
