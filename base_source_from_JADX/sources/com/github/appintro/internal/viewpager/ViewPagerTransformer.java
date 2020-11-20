package com.github.appintro.internal.viewpager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.p053l.p054a.C0922b;
import com.github.appintro.AppIntroPageTransformerType;
import com.github.appintro.C2142R;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

public final class ViewPagerTransformer implements C0922b.C0933g {
    private double descriptionPF;
    private double imagePF;
    private double titlePF;
    private final AppIntroPageTransformerType transformType;

    public ViewPagerTransformer(@NotNull AppIntroPageTransformerType appIntroPageTransformerType) {
        C3250h.m9056b(appIntroPageTransformerType, "transformType");
        this.transformType = appIntroPageTransformerType;
    }

    private final void applyParallax(View view, float f) {
        View findViewById = view.findViewById(C2142R.C2145id.title);
        C3250h.m9053a((Object) findViewById, "page.findViewById<TextView>(R.id.title)");
        ((TextView) findViewById).setTranslationX(computeParallax(view, f, this.titlePF));
        View findViewById2 = view.findViewById(C2142R.C2145id.image);
        C3250h.m9053a((Object) findViewById2, "page.findViewById<ImageView>(R.id.image)");
        ((ImageView) findViewById2).setTranslationX(computeParallax(view, f, this.imagePF));
        View findViewById3 = view.findViewById(C2142R.C2145id.description);
        C3250h.m9053a((Object) findViewById3, "page.findViewById<TextView>(R.id.description)");
        ((TextView) findViewById3).setTranslationX(computeParallax(view, f, this.descriptionPF));
    }

    private final float computeParallax(View view, float f, double d) {
        return (float) (((double) (-f)) * (((double) view.getWidth()) / d));
    }

    private final void transformDepth(float f, View view) {
        if (f > ((float) 0)) {
            float f2 = (float) 1;
            if (f < f2) {
                view.setAlpha(f2 - f);
                ViewPagerTransformerKt.setScaleXY(view, ((f2 - Math.abs(f)) * 0.25f) + 0.75f);
                view.setTranslationX(((float) view.getWidth()) * (-f));
                return;
            }
        }
        ViewPagerTransformerKt.transformDefaults(view);
    }

    private final void transformFade(float f, View view) {
        boolean z;
        if (f <= -1.0f || f >= 1.0f) {
            view.setTranslationX((float) view.getWidth());
            view.setAlpha(0.0f);
            z = false;
        } else if (f == 0.0f) {
            view.setTranslationX(0.0f);
            view.setAlpha(1.0f);
            z = true;
        } else {
            view.setTranslationX(((float) view.getWidth()) * (-f));
            view.setAlpha(1.0f - Math.abs(f));
            return;
        }
        view.setClickable(z);
    }

    private final void transformParallax(float f, View view) {
        if (f > ((float) -1) && f < ((float) 1)) {
            try {
                applyParallax(view, f);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    private final void transformSlideOver(float f, View view) {
        if (f >= ((float) 0) || f <= ((float) -1)) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f2 = (float) 1;
        ViewPagerTransformerKt.setScaleXY(view, (Math.abs(Math.abs(f) - f2) * 0.14999998f) + 0.85f);
        view.setAlpha(Math.max(0.35f, f2 - Math.abs(f)));
        float f3 = (float) (-view.getWidth());
        float f4 = f * f3;
        if (f4 <= f3) {
            f4 = 0.0f;
        }
        view.setTranslationX(f4);
    }

    private final void transformZoom(float f, View view) {
        if (f >= ((float) -1)) {
            float f2 = (float) 1;
            if (f <= f2) {
                ViewPagerTransformerKt.setScaleXY(view, Math.max(0.85f, f2 - Math.abs(f)));
                view.setAlpha((((ViewPagerTransformerKt.getScaleXY(view) - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
                float f3 = (float) 2;
                float height = (((float) view.getHeight()) * (f2 - ViewPagerTransformerKt.getScaleXY(view))) / f3;
                float width = (((float) view.getWidth()) * (f2 - ViewPagerTransformerKt.getScaleXY(view))) / f3;
                if (f < ((float) 0)) {
                    view.setTranslationX(width - (height / f3));
                    return;
                } else {
                    view.setTranslationX((-width) + (height / f3));
                    return;
                }
            }
        }
        ViewPagerTransformerKt.transformDefaults(view);
    }

    public void transformPage(@NotNull View view, float f) {
        C3250h.m9056b(view, "page");
        AppIntroPageTransformerType appIntroPageTransformerType = this.transformType;
        if (C3250h.m9055a((Object) appIntroPageTransformerType, (Object) AppIntroPageTransformerType.Flow.INSTANCE)) {
            view.setRotationY(f * -30.0f);
        } else if (C3250h.m9055a((Object) appIntroPageTransformerType, (Object) AppIntroPageTransformerType.SlideOver.INSTANCE)) {
            transformSlideOver(f, view);
        } else if (C3250h.m9055a((Object) appIntroPageTransformerType, (Object) AppIntroPageTransformerType.Depth.INSTANCE)) {
            transformDepth(f, view);
        } else if (C3250h.m9055a((Object) appIntroPageTransformerType, (Object) AppIntroPageTransformerType.Zoom.INSTANCE)) {
            transformZoom(f, view);
        } else if (C3250h.m9055a((Object) appIntroPageTransformerType, (Object) AppIntroPageTransformerType.Fade.INSTANCE)) {
            transformFade(f, view);
        } else if (appIntroPageTransformerType instanceof AppIntroPageTransformerType.Parallax) {
            this.titlePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getTitleParallaxFactor();
            this.imagePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getImageParallaxFactor();
            this.descriptionPF = ((AppIntroPageTransformerType.Parallax) this.transformType).getDescriptionParallaxFactor();
            transformParallax(f, view);
        }
    }
}
