package com.github.appintro.internal;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.p025a.C0540f;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

public final class TypefaceContainer$applyTo$callback$1 extends C0540f.C0541a {
    final /* synthetic */ TextView $textView;

    TypefaceContainer$applyTo$callback$1(TextView textView) {
        this.$textView = textView;
    }

    public void onFontRetrievalFailed(int i) {
    }

    public void onFontRetrieved(@NotNull Typeface typeface) {
        C3250h.m9056b(typeface, "typeface");
        this.$textView.setTypeface(typeface);
    }
}
