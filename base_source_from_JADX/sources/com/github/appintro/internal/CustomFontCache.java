package com.github.appintro.internal;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.p025a.C0540f;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;
import p157d.p161d.p163b.C3254k;
import p157d.p165f.C3268b;

public final class CustomFontCache {
    public static final CustomFontCache INSTANCE = new CustomFontCache();
    private static final String TAG = LogHelper.INSTANCE.makeLogTag((C3268b<?>) C3254k.m9059a(CustomFontCache.class));
    private static final HashMap<String, Typeface> cache = new HashMap<>();

    private CustomFontCache() {
    }

    public final void getFont(@NotNull Context context, @Nullable String str, @NotNull C0540f.C0541a aVar) {
        C3250h.m9056b(context, "ctx");
        C3250h.m9056b(aVar, "fontCallback");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            LogHelper.w$default(TAG, "Empty typeface path provided!", (Throwable) null, 4, (Object) null);
            return;
        }
        Typeface typeface = cache.get(str);
        if (typeface != null) {
            aVar.onFontRetrieved(typeface);
            return;
        }
        CustomFontCache customFontCache = this;
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), str);
        C3250h.m9053a((Object) createFromAsset, "newTypeface");
        cache.put(str, createFromAsset);
        aVar.onFontRetrieved(createFromAsset);
    }
}
