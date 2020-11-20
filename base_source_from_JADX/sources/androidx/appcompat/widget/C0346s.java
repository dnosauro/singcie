package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.C0597c;

/* renamed from: androidx.appcompat.widget.s */
class C0346s {

    /* renamed from: a */
    private static final int[] f1232a = {16843067, 16843068};

    /* renamed from: b */
    private final ProgressBar f1233b;

    /* renamed from: c */
    private Bitmap f1234c;

    C0346s(ProgressBar progressBar) {
        this.f1233b = progressBar;
    }

    /* renamed from: a */
    private Drawable mo2614a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m1275a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* renamed from: a */
    private Drawable m1275a(Drawable drawable, boolean z) {
        if (drawable instanceof C0597c) {
            C0597c cVar = (C0597c) drawable;
            Drawable a = cVar.mo3624a();
            if (a == null) {
                return drawable;
            }
            cVar.mo3625a(m1275a(a, z));
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = m1275a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1234c == null) {
                this.f1234c = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(mo2615b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
    }

    /* renamed from: b */
    private Shape mo2615b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo2600a() {
        return this.f1234c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2601a(AttributeSet attributeSet, int i) {
        C0302ay a = C0302ay.m1078a(this.f1233b.getContext(), attributeSet, f1232a, i, 0);
        Drawable b = a.mo2414b(0);
        if (b != null) {
            this.f1233b.setIndeterminateDrawable(mo2614a(b));
        }
        Drawable b2 = a.mo2414b(1);
        if (b2 != null) {
            this.f1233b.setProgressDrawable(m1275a(b2, false));
        }
        a.mo2410a();
    }
}
