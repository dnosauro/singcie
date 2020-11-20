package com.github.appintro;

import com.github.appintro.model.SliderPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public final class AppIntroFragment extends AppIntroBaseFragment {
    public static final Companion Companion = new Companion((C3247e) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C3247e eVar) {
            this();
        }

        public static /* synthetic */ AppIntroFragment newInstance$default(Companion companion, CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
            int i9 = i8;
            CharSequence charSequence3 = (i9 & 1) != 0 ? null : charSequence;
            CharSequence charSequence4 = (i9 & 2) != 0 ? null : charSequence2;
            int i10 = 0;
            int i11 = (i9 & 4) != 0 ? 0 : i;
            int i12 = (i9 & 8) != 0 ? 0 : i2;
            int i13 = (i9 & 16) != 0 ? 0 : i3;
            int i14 = (i9 & 32) != 0 ? 0 : i4;
            int i15 = (i9 & 64) != 0 ? 0 : i5;
            int i16 = (i9 & 128) != 0 ? 0 : i6;
            if ((i9 & 256) == 0) {
                i10 = i7;
            }
            return companion.newInstance(charSequence3, charSequence4, i11, i12, i13, i14, i15, i16, i10);
        }

        @NotNull
        public final AppIntroFragment newInstance() {
            return newInstance$default(this, (CharSequence) null, (CharSequence) null, 0, 0, 0, 0, 0, 0, 0, 511, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@NotNull SliderPage sliderPage) {
            C3250h.m9056b(sliderPage, "sliderPage");
            AppIntroFragment appIntroFragment = new AppIntroFragment();
            appIntroFragment.setArguments(sliderPage.toBundle());
            return appIntroFragment;
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence) {
            return newInstance$default(this, charSequence, (CharSequence) null, 0, 0, 0, 0, 0, 0, 0, 510, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
            return newInstance$default(this, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i) {
            return newInstance$default(this, charSequence, charSequence2, i, 0, 0, 0, 0, 0, 0, 504, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, 0, 0, 0, 0, 0, 496, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, 0, 0, 0, 0, 480, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, 448, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, 0, 0, 384, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, i6, 0, 256, (Object) null);
        }

        @NotNull
        public final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            return newInstance(new SliderPage(charSequence, charSequence2, i, i2, i3, i4, i5, i6, (String) null, (String) null, i7, 768, (C3247e) null));
        }
    }

    @NotNull
    public static final AppIntroFragment newInstance() {
        return Companion.newInstance$default(Companion, (CharSequence) null, (CharSequence) null, 0, 0, 0, 0, 0, 0, 0, 511, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@NotNull SliderPage sliderPage) {
        return Companion.newInstance(sliderPage);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence) {
        return Companion.newInstance$default(Companion, charSequence, (CharSequence) null, 0, 0, 0, 0, 0, 0, 0, 510, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i, 0, 0, 0, 0, 0, 0, 504, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i, i2, 0, 0, 0, 0, 0, 496, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i, i2, i3, 0, 0, 0, 0, 480, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, 448, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i, i2, i3, i4, i5, 0, 0, 384, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i, i2, i3, i4, i5, i6, 0, 256, (Object) null);
    }

    @NotNull
    public static final AppIntroFragment newInstance(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return C2142R.layout.appintro_fragment_intro;
    }
}
