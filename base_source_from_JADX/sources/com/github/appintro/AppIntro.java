package com.github.appintro;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.appintro.internal.TypefaceContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public abstract class AppIntro extends AppIntroBase {
    private final int layoutId = C2142R.layout.appintro_intro_layout;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return this.layoutId;
    }

    public final void setBarColor(int i) {
        findViewById(C2142R.C2145id.bottom).setBackgroundColor(i);
    }

    public final void setColorDoneText(int i) {
        ((TextView) findViewById(C2142R.C2145id.done)).setTextColor(i);
    }

    public final void setColorSkipButton(int i) {
        ((TextView) findViewById(C2142R.C2145id.skip)).setTextColor(i);
    }

    public final void setDoneText(int i) {
        ((TextView) findViewById(C2142R.C2145id.done)).setText(i);
    }

    public final void setDoneText(@Nullable CharSequence charSequence) {
        TextView textView = (TextView) findViewById(C2142R.C2145id.done);
        C3250h.m9053a((Object) textView, "doneText");
        textView.setText(charSequence);
    }

    public final void setDoneTextTypeface(int i) {
        new TypefaceContainer((String) null, i).applyTo((TextView) findViewById(C2142R.C2145id.done));
    }

    public final void setDoneTextTypeface(@Nullable String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(C2142R.C2145id.done));
    }

    public final void setImageNextButton(@NotNull Drawable drawable) {
        C3250h.m9056b(drawable, "imageNextButton");
        ((ImageView) findViewById(C2142R.C2145id.next)).setImageDrawable(drawable);
    }

    public final void setNextArrowColor(int i) {
        ((ImageButton) findViewById(C2142R.C2145id.next)).setColorFilter(i);
    }

    public final void setSeparatorColor(int i) {
        findViewById(C2142R.C2145id.bottom_separator).setBackgroundColor(i);
    }

    public final void setSkipText(int i) {
        ((TextView) findViewById(C2142R.C2145id.skip)).setText(i);
    }

    public final void setSkipText(@Nullable CharSequence charSequence) {
        TextView textView = (TextView) findViewById(C2142R.C2145id.skip);
        C3250h.m9053a((Object) textView, "skipText");
        textView.setText(charSequence);
    }

    public final void setSkipTextTypeface(int i) {
        new TypefaceContainer((String) null, i).applyTo((TextView) findViewById(C2142R.C2145id.skip));
    }

    public final void setSkipTextTypeface(@Nullable String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(C2142R.C2145id.skip));
    }

    public final void showSeparator(boolean z) {
        int i;
        View findViewById = findViewById(C2142R.C2145id.bottom_separator);
        if (z) {
            C3250h.m9053a((Object) findViewById, "bottomSeparator");
            i = 0;
        } else {
            C3250h.m9053a((Object) findViewById, "bottomSeparator");
            i = 4;
        }
        findViewById.setVisibility(i);
    }
}
