package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.C0595a;
import com.google.android.gms.base.C2231R;
import com.google.android.gms.common.util.DeviceProperties;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int zaa(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unknown color scheme: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
        }
    }

    public final void configure(Resources resources, int i, int i2) {
        int i3;
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i4 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i4);
        setMinWidth(i4);
        int zaa = zaa(i2, C2231R.C2233drawable.common_google_signin_btn_icon_dark, C2231R.C2233drawable.common_google_signin_btn_icon_light, C2231R.C2233drawable.common_google_signin_btn_icon_light);
        int zaa2 = zaa(i2, C2231R.C2233drawable.common_google_signin_btn_text_dark, C2231R.C2233drawable.common_google_signin_btn_text_light, C2231R.C2233drawable.common_google_signin_btn_text_light);
        switch (i) {
            case 0:
            case 1:
                zaa = zaa2;
                break;
            case 2:
                break;
            default:
                StringBuilder sb = new StringBuilder(32);
                sb.append("Unknown button size: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
        }
        Drawable g = C0595a.m2330g(resources.getDrawable(zaa));
        C0595a.m2319a(g, resources.getColorStateList(C2231R.C2232color.common_google_signin_btn_tint));
        C0595a.m2322a(g, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(g);
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zaa(i2, C2231R.C2232color.common_google_signin_btn_text_dark, C2231R.C2232color.common_google_signin_btn_text_light, C2231R.C2232color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                i3 = C2231R.string.common_signin_button_text;
                break;
            case 1:
                i3 = C2231R.string.common_signin_button_text_long;
                break;
            case 2:
                setText((CharSequence) null);
                break;
            default:
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown button size: ");
                sb2.append(i);
                throw new IllegalStateException(sb2.toString());
        }
        setText(resources.getString(i3));
        setTransformationMethod((TransformationMethod) null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
    }
}
