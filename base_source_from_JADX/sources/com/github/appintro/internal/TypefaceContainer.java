package com.github.appintro.internal;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import androidx.core.content.p025a.C0540f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public final class TypefaceContainer {
    private int typeFaceResource;
    @Nullable
    private String typeFaceUrl;

    public TypefaceContainer() {
        this((String) null, 0, 3, (C3247e) null);
    }

    public TypefaceContainer(@Nullable String str, int i) {
        this.typeFaceUrl = str;
        this.typeFaceResource = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypefaceContainer(String str, int i, int i2, C3247e eVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i);
    }

    public static /* synthetic */ TypefaceContainer copy$default(TypefaceContainer typefaceContainer, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = typefaceContainer.typeFaceUrl;
        }
        if ((i2 & 2) != 0) {
            i = typefaceContainer.typeFaceResource;
        }
        return typefaceContainer.copy(str, i);
    }

    public final void applyTo(@Nullable TextView textView) {
        if (textView != null && textView.getContext() != null) {
            if (this.typeFaceUrl != null || this.typeFaceResource != 0) {
                TypefaceContainer$applyTo$callback$1 typefaceContainer$applyTo$callback$1 = new TypefaceContainer$applyTo$callback$1(textView);
                if (this.typeFaceResource != 0) {
                    C0540f.m2152a(textView.getContext(), this.typeFaceResource, typefaceContainer$applyTo$callback$1, (Handler) null);
                    return;
                }
                CustomFontCache customFontCache = CustomFontCache.INSTANCE;
                Context context = textView.getContext();
                C3250h.m9053a((Object) context, "textView.context");
                customFontCache.getFont(context, this.typeFaceUrl, typefaceContainer$applyTo$callback$1);
            }
        }
    }

    @Nullable
    public final String component1() {
        return this.typeFaceUrl;
    }

    public final int component2() {
        return this.typeFaceResource;
    }

    @NotNull
    public final TypefaceContainer copy(@Nullable String str, int i) {
        return new TypefaceContainer(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceContainer)) {
            return false;
        }
        TypefaceContainer typefaceContainer = (TypefaceContainer) obj;
        return C3250h.m9055a((Object) this.typeFaceUrl, (Object) typefaceContainer.typeFaceUrl) && this.typeFaceResource == typefaceContainer.typeFaceResource;
    }

    public final int getTypeFaceResource() {
        return this.typeFaceResource;
    }

    @Nullable
    public final String getTypeFaceUrl() {
        return this.typeFaceUrl;
    }

    public int hashCode() {
        String str = this.typeFaceUrl;
        return ((str != null ? str.hashCode() : 0) * 31) + this.typeFaceResource;
    }

    public final void setTypeFaceResource(int i) {
        this.typeFaceResource = i;
    }

    public final void setTypeFaceUrl(@Nullable String str) {
        this.typeFaceUrl = str;
    }

    @NotNull
    public String toString() {
        return "TypefaceContainer(typeFaceUrl=" + this.typeFaceUrl + ", typeFaceResource=" + this.typeFaceResource + ")";
    }
}
