package com.github.appintro.model;

import android.os.Bundle;
import com.github.appintro.AppIntroBaseFragmentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public final class SliderPage {
    private int backgroundColor;
    private int backgroundDrawable;
    @Nullable
    private CharSequence description;
    private int descriptionColor;
    @Nullable
    private String descriptionTypeface;
    private int descriptionTypefaceFontRes;
    private int imageDrawable;
    @Nullable
    private CharSequence title;
    private int titleColor;
    @Nullable
    private String titleTypeface;
    private int titleTypefaceFontRes;

    public SliderPage() {
        this((CharSequence) null, (CharSequence) null, 0, 0, 0, 0, 0, 0, (String) null, (String) null, 0, 2047, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence) {
        this(charSequence, (CharSequence) null, 0, 0, 0, 0, 0, 0, (String) null, (String) null, 0, 2046, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this(charSequence, charSequence2, 0, 0, 0, 0, 0, 0, (String) null, (String) null, 0, 2044, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i) {
        this(charSequence, charSequence2, i, 0, 0, 0, 0, 0, (String) null, (String) null, 0, 2040, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2) {
        this(charSequence, charSequence2, i, i2, 0, 0, 0, 0, (String) null, (String) null, 0, 2032, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3) {
        this(charSequence, charSequence2, i, i2, i3, 0, 0, 0, (String) null, (String) null, 0, 2016, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4) {
        this(charSequence, charSequence2, i, i2, i3, i4, 0, 0, (String) null, (String) null, 0, 1984, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, 0, (String) null, (String) null, 0, 1920, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, (String) null, (String) null, 0, 1792, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, @Nullable String str) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, str, (String) null, 0, 1536, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, @Nullable String str, @Nullable String str2) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, str, str2, 0, 1024, (C3247e) null);
    }

    public SliderPage(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, @Nullable String str, @Nullable String str2, int i7) {
        this.title = charSequence;
        this.description = charSequence2;
        this.imageDrawable = i;
        this.backgroundColor = i2;
        this.titleColor = i3;
        this.descriptionColor = i4;
        this.titleTypefaceFontRes = i5;
        this.descriptionTypefaceFontRes = i6;
        this.titleTypeface = str;
        this.descriptionTypeface = str2;
        this.backgroundDrawable = i7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SliderPage(java.lang.CharSequence r14, java.lang.CharSequence r15, int r16, int r17, int r18, int r19, int r20, int r21, java.lang.String r22, java.lang.String r23, int r24, int r25, p157d.p161d.p163b.C3247e r26) {
        /*
            r13 = this;
            r0 = r25
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x000c
        L_0x000b:
            r1 = r14
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0014
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            goto L_0x0015
        L_0x0014:
            r3 = r15
        L_0x0015:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001c
            r4 = 0
            goto L_0x001e
        L_0x001c:
            r4 = r16
        L_0x001e:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0024
            r6 = 0
            goto L_0x0026
        L_0x0024:
            r6 = r17
        L_0x0026:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002c
            r7 = 0
            goto L_0x002e
        L_0x002c:
            r7 = r18
        L_0x002e:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0034
            r8 = 0
            goto L_0x0036
        L_0x0034:
            r8 = r19
        L_0x0036:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003c
            r9 = 0
            goto L_0x003e
        L_0x003c:
            r9 = r20
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0044
            r10 = 0
            goto L_0x0046
        L_0x0044:
            r10 = r21
        L_0x0046:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004e
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0057
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0059
        L_0x0057:
            r2 = r23
        L_0x0059:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r5 = r24
        L_0x0060:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r25 = r5
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.appintro.model.SliderPage.<init>(java.lang.CharSequence, java.lang.CharSequence, int, int, int, int, int, int, java.lang.String, java.lang.String, int, int, d.d.b.e):void");
    }

    public static /* synthetic */ SliderPage copy$default(SliderPage sliderPage, CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, int i7, int i8, Object obj) {
        SliderPage sliderPage2 = sliderPage;
        int i9 = i8;
        return sliderPage.copy((i9 & 1) != 0 ? sliderPage2.title : charSequence, (i9 & 2) != 0 ? sliderPage2.description : charSequence2, (i9 & 4) != 0 ? sliderPage2.imageDrawable : i, (i9 & 8) != 0 ? sliderPage2.backgroundColor : i2, (i9 & 16) != 0 ? sliderPage2.titleColor : i3, (i9 & 32) != 0 ? sliderPage2.descriptionColor : i4, (i9 & 64) != 0 ? sliderPage2.titleTypefaceFontRes : i5, (i9 & 128) != 0 ? sliderPage2.descriptionTypefaceFontRes : i6, (i9 & 256) != 0 ? sliderPage2.titleTypeface : str, (i9 & 512) != 0 ? sliderPage2.descriptionTypeface : str2, (i9 & 1024) != 0 ? sliderPage2.backgroundDrawable : i7);
    }

    @Nullable
    public final CharSequence component1() {
        return this.title;
    }

    @Nullable
    public final String component10() {
        return this.descriptionTypeface;
    }

    public final int component11() {
        return this.backgroundDrawable;
    }

    @Nullable
    public final CharSequence component2() {
        return this.description;
    }

    public final int component3() {
        return this.imageDrawable;
    }

    public final int component4() {
        return this.backgroundColor;
    }

    public final int component5() {
        return this.titleColor;
    }

    public final int component6() {
        return this.descriptionColor;
    }

    public final int component7() {
        return this.titleTypefaceFontRes;
    }

    public final int component8() {
        return this.descriptionTypefaceFontRes;
    }

    @Nullable
    public final String component9() {
        return this.titleTypeface;
    }

    @NotNull
    public final SliderPage copy(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, @Nullable String str, @Nullable String str2, int i7) {
        return new SliderPage(charSequence, charSequence2, i, i2, i3, i4, i5, i6, str, str2, i7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SliderPage)) {
            return false;
        }
        SliderPage sliderPage = (SliderPage) obj;
        return C3250h.m9055a((Object) this.title, (Object) sliderPage.title) && C3250h.m9055a((Object) this.description, (Object) sliderPage.description) && this.imageDrawable == sliderPage.imageDrawable && this.backgroundColor == sliderPage.backgroundColor && this.titleColor == sliderPage.titleColor && this.descriptionColor == sliderPage.descriptionColor && this.titleTypefaceFontRes == sliderPage.titleTypefaceFontRes && this.descriptionTypefaceFontRes == sliderPage.descriptionTypefaceFontRes && C3250h.m9055a((Object) this.titleTypeface, (Object) sliderPage.titleTypeface) && C3250h.m9055a((Object) this.descriptionTypeface, (Object) sliderPage.descriptionTypeface) && this.backgroundDrawable == sliderPage.backgroundDrawable;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    @Nullable
    public final CharSequence getDescription() {
        return this.description;
    }

    public final int getDescriptionColor() {
        return this.descriptionColor;
    }

    @Nullable
    public final String getDescriptionString() {
        CharSequence charSequence = this.description;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Nullable
    public final String getDescriptionTypeface() {
        return this.descriptionTypeface;
    }

    public final int getDescriptionTypefaceFontRes() {
        return this.descriptionTypefaceFontRes;
    }

    public final int getImageDrawable() {
        return this.imageDrawable;
    }

    @Nullable
    public final CharSequence getTitle() {
        return this.title;
    }

    public final int getTitleColor() {
        return this.titleColor;
    }

    @Nullable
    public final String getTitleString() {
        CharSequence charSequence = this.title;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Nullable
    public final String getTitleTypeface() {
        return this.titleTypeface;
    }

    public final int getTitleTypefaceFontRes() {
        return this.titleTypefaceFontRes;
    }

    public int hashCode() {
        CharSequence charSequence = this.title;
        int i = 0;
        int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.description;
        int hashCode2 = (((((((((((((hashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31) + this.imageDrawable) * 31) + this.backgroundColor) * 31) + this.titleColor) * 31) + this.descriptionColor) * 31) + this.titleTypefaceFontRes) * 31) + this.descriptionTypefaceFontRes) * 31;
        String str = this.titleTypeface;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.descriptionTypeface;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.backgroundDrawable;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final void setBackgroundDrawable(int i) {
        this.backgroundDrawable = i;
    }

    public final void setDescription(@Nullable CharSequence charSequence) {
        this.description = charSequence;
    }

    public final void setDescriptionColor(int i) {
        this.descriptionColor = i;
    }

    public final void setDescriptionTypeface(@Nullable String str) {
        this.descriptionTypeface = str;
    }

    public final void setDescriptionTypefaceFontRes(int i) {
        this.descriptionTypefaceFontRes = i;
    }

    public final void setImageDrawable(int i) {
        this.imageDrawable = i;
    }

    public final void setTitle(@Nullable CharSequence charSequence) {
        this.title = charSequence;
    }

    public final void setTitleColor(int i) {
        this.titleColor = i;
    }

    public final void setTitleTypeface(@Nullable String str) {
        this.titleTypeface = str;
    }

    public final void setTitleTypefaceFontRes(int i) {
        this.titleTypefaceFontRes = i;
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("title", getTitleString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, this.titleTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, this.titleTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC, getDescriptionString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, this.descriptionTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, this.descriptionTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descriptionColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DRAWABLE, this.imageDrawable);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.backgroundColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.backgroundDrawable);
        return bundle;
    }

    @NotNull
    public String toString() {
        return "SliderPage(title=" + this.title + ", description=" + this.description + ", imageDrawable=" + this.imageDrawable + ", backgroundColor=" + this.backgroundColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", titleTypefaceFontRes=" + this.titleTypefaceFontRes + ", descriptionTypefaceFontRes=" + this.descriptionTypefaceFontRes + ", titleTypeface=" + this.titleTypeface + ", descriptionTypeface=" + this.descriptionTypeface + ", backgroundDrawable=" + this.backgroundDrawable + ")";
    }
}
