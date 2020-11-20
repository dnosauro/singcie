package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.C0302ay;
import com.google.android.material.C2246R;

public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0302ay a = C0302ay.m1077a(context, attributeSet, C2246R.styleable.TabItem);
        this.text = a.mo2416c(C2246R.styleable.TabItem_android_text);
        this.icon = a.mo2409a(C2246R.styleable.TabItem_android_icon);
        this.customLayout = a.mo2423g(C2246R.styleable.TabItem_android_layout, 0);
        a.mo2410a();
    }
}
