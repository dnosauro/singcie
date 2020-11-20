package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public final class zzasi {
    /* access modifiers changed from: private */
    @Nonnull
    public View zzaaq;
    /* access modifiers changed from: private */
    public final Map<String, WeakReference<View>> zzdse = new HashMap();

    public final zzasi zzh(Map<String, View> map) {
        this.zzdse.clear();
        for (Map.Entry next : map.entrySet()) {
            View view = (View) next.getValue();
            if (view != null) {
                this.zzdse.put((String) next.getKey(), new WeakReference(view));
            }
        }
        return this;
    }

    public final zzasi zzk(View view) {
        this.zzaaq = view;
        return this;
    }
}
