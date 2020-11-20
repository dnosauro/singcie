package com.github.appintro;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public abstract class AppIntro2 extends AppIntroBase {
    @Nullable
    private Drawable backgroundDrawable;
    private ConstraintLayout backgroundFrame;
    @Nullable
    private Integer backgroundResource;
    private View bottomBar;
    private final int layoutId = C2142R.layout.appintro_intro_layout2;
    private ImageButton skipImageButton;

    @Nullable
    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    @Nullable
    public final Integer getBackgroundResource() {
        return this.backgroundResource;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return this.layoutId;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View findViewById = findViewById(C2142R.C2145id.background);
        C3250h.m9053a((Object) findViewById, "findViewById(R.id.background)");
        this.backgroundFrame = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(C2142R.C2145id.bottom);
        C3250h.m9053a((Object) findViewById2, "findViewById(R.id.bottom)");
        this.bottomBar = findViewById2;
        View findViewById3 = findViewById(C2142R.C2145id.skip);
        C3250h.m9053a((Object) findViewById3, "findViewById(R.id.skip)");
        this.skipImageButton = (ImageButton) findViewById3;
        if (isRtl$appintro_release()) {
            ImageButton imageButton = this.skipImageButton;
            if (imageButton == null) {
                C3250h.m9057b("skipImageButton");
            }
            imageButton.setScaleX(-1.0f);
        }
    }

    public final void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.backgroundDrawable = drawable;
        if (this.backgroundDrawable != null && Build.VERSION.SDK_INT >= 16) {
            ConstraintLayout constraintLayout = this.backgroundFrame;
            if (constraintLayout == null) {
                C3250h.m9057b("backgroundFrame");
            }
            constraintLayout.setBackground(this.backgroundDrawable);
        }
    }

    public final void setBackgroundResource(@Nullable Integer num) {
        this.backgroundResource = num;
        Integer num2 = this.backgroundResource;
        if (num2 != null && num2 != null) {
            int intValue = num2.intValue();
            ConstraintLayout constraintLayout = this.backgroundFrame;
            if (constraintLayout == null) {
                C3250h.m9057b("backgroundFrame");
            }
            constraintLayout.setBackgroundResource(intValue);
        }
    }

    public final void setBarColor(int i) {
        View view = this.bottomBar;
        if (view == null) {
            C3250h.m9057b("bottomBar");
        }
        view.setBackgroundColor(i);
    }

    public final void setImageSkipButton(@NotNull Drawable drawable) {
        C3250h.m9056b(drawable, "imageSkipButton");
        ImageButton imageButton = this.skipImageButton;
        if (imageButton == null) {
            C3250h.m9057b("skipImageButton");
        }
        imageButton.setImageDrawable(drawable);
    }
}
