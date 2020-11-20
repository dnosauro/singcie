package com.github.appintro.model;

import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

public final class SliderPagerBuilder {
    private int backgroundColor;
    private int backgroundDrawable;
    private CharSequence description;
    private int descriptionColor;
    private String descriptionTypeface;
    private int descriptionTypefaceFontRes;
    private int imageDrawable;
    private CharSequence title;
    private int titleColor;
    private String titleTypeface;
    private int titleTypefaceFontRes;

    @NotNull
    public final SliderPagerBuilder backgroundColor(int i) {
        this.backgroundColor = i;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder backgroundDrawable(int i) {
        this.backgroundDrawable = i;
        return this;
    }

    @NotNull
    public final SliderPage build() {
        CharSequence charSequence = this.title;
        CharSequence charSequence2 = this.description;
        int i = this.imageDrawable;
        int i2 = this.backgroundColor;
        int i3 = this.titleColor;
        int i4 = this.descriptionColor;
        int i5 = this.titleTypefaceFontRes;
        String str = this.descriptionTypeface;
        return new SliderPage(charSequence, charSequence2, i, i2, i3, i4, i5, this.descriptionTypefaceFontRes, this.titleTypeface, str, this.backgroundDrawable);
    }

    @NotNull
    public final SliderPagerBuilder description(@NotNull CharSequence charSequence) {
        C3250h.m9056b(charSequence, "description");
        this.description = charSequence;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder descriptionColor(int i) {
        this.descriptionColor = i;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder descriptionTypeface(@NotNull String str) {
        C3250h.m9056b(str, "descriptionTypeface");
        this.descriptionTypeface = str;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder descriptionTypefaceFontRes(int i) {
        this.descriptionTypefaceFontRes = i;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder imageDrawable(int i) {
        this.imageDrawable = i;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder title(@NotNull CharSequence charSequence) {
        C3250h.m9056b(charSequence, "title");
        this.title = charSequence;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder titleColor(int i) {
        this.titleColor = i;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder titleTypeface(@NotNull String str) {
        C3250h.m9056b(str, "titleTypeface");
        this.titleTypeface = str;
        return this;
    }

    @NotNull
    public final SliderPagerBuilder titleTypefaceFontRes(int i) {
        this.titleTypefaceFontRes = i;
        return this;
    }
}
