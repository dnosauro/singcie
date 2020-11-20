package com.github.appintro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.C0735d;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.TypefaceContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public abstract class AppIntroBaseFragment extends C0735d implements SlideBackgroundColorHolder, SlideSelectionListener {
    private int bgDrawable;
    private int defaultBackgroundColor;
    private int descColor;
    private TypefaceContainer descTypeface;
    private String description;
    private int drawable;
    private final String logTAG = LogHelper.makeLogTag((Class<?>) AppIntroBaseFragment.class);
    private ConstraintLayout mainLayout;
    private String title;
    private int titleColor;
    private TypefaceContainer titleTypeface;

    public final int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.drawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_DRAWABLE);
            this.title = bundle.getString("title");
            this.description = bundle.getString(AppIntroBaseFragmentKt.ARG_DESC);
            this.titleTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, 0));
            this.descTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, 0));
            this.defaultBackgroundColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            this.bgDrawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
            this.titleColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR);
            this.descColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() != 0) {
            this.drawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_DRAWABLE);
            this.title = arguments.getString("title");
            this.description = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC);
            this.bgDrawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
            String string = arguments.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE);
            String string2 = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE);
            int i = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES);
            int i2 = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES);
            this.titleTypeface = new TypefaceContainer(string, i);
            this.descTypeface = new TypefaceContainer(string2, i2);
            this.defaultBackgroundColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            this.titleColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, 0);
            this.descColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, 0);
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C3250h.m9056b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(C2142R.C2145id.title);
        TextView textView2 = (TextView) inflate.findViewById(C2142R.C2145id.description);
        ImageView imageView = (ImageView) inflate.findViewById(C2142R.C2145id.image);
        this.mainLayout = (ConstraintLayout) inflate.findViewById(C2142R.C2145id.main);
        C3250h.m9053a((Object) textView, "titleText");
        textView.setText(this.title);
        C3250h.m9053a((Object) textView2, "descriptionText");
        textView2.setText(this.description);
        int i = this.titleColor;
        if (i != 0) {
            textView.setTextColor(i);
        }
        int i2 = this.descColor;
        if (i2 != 0) {
            textView2.setTextColor(i2);
        }
        TypefaceContainer typefaceContainer = this.titleTypeface;
        if (typefaceContainer != null) {
            typefaceContainer.applyTo(textView);
        }
        TypefaceContainer typefaceContainer2 = this.descTypeface;
        if (typefaceContainer2 != null) {
            typefaceContainer2.applyTo(textView2);
        }
        imageView.setImageResource(this.drawable);
        int i3 = this.bgDrawable;
        if (i3 != 0) {
            ConstraintLayout constraintLayout = this.mainLayout;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(i3);
            }
        } else {
            ConstraintLayout constraintLayout2 = this.mainLayout;
            if (constraintLayout2 != null) {
                constraintLayout2.setBackgroundColor(this.defaultBackgroundColor);
            }
        }
        return inflate;
    }

    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C3250h.m9056b(bundle, "outState");
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DRAWABLE, this.drawable);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.bgDrawable);
        bundle.putString("title", this.title);
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC, this.description);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.defaultBackgroundColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descColor);
        TypefaceContainer typefaceContainer = this.titleTypeface;
        int i = 0;
        String str = null;
        if (typefaceContainer != null) {
            bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, typefaceContainer != null ? typefaceContainer.getTypeFaceUrl() : null);
            TypefaceContainer typefaceContainer2 = this.titleTypeface;
            bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, typefaceContainer2 != null ? typefaceContainer2.getTypeFaceResource() : 0);
        }
        TypefaceContainer typefaceContainer3 = this.descTypeface;
        if (typefaceContainer3 != null) {
            if (typefaceContainer3 != null) {
                str = typefaceContainer3.getTypeFaceUrl();
            }
            bundle.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, str);
            TypefaceContainer typefaceContainer4 = this.descTypeface;
            if (typefaceContainer4 != null) {
                i = typefaceContainer4.getTypeFaceResource();
            }
            bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, i);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSlideDeselected() {
        String str = this.logTAG;
        LogHelper.m8403d(str, "Slide " + this.title + " has been deselected.");
    }

    public void onSlideSelected() {
        String str = this.logTAG;
        LogHelper.m8403d(str, "Slide " + this.title + " has been selected.");
    }

    public void setBackgroundColor(int i) {
        ConstraintLayout constraintLayout = this.mainLayout;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(i);
        }
    }
}
