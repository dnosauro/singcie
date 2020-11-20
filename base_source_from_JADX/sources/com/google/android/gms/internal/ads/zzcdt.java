package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

final /* synthetic */ class zzcdt implements ViewTreeObserver.OnScrollChangedListener {
    private final String zzdgt;
    private final View zzgfi;
    private final zzbdv zzgfj;
    private final WindowManager.LayoutParams zzgfk;
    private final int zzgfl;
    private final WindowManager zzgfm;

    zzcdt(View view, zzbdv zzbdv, String str, WindowManager.LayoutParams layoutParams, int i, WindowManager windowManager) {
        this.zzgfi = view;
        this.zzgfj = zzbdv;
        this.zzdgt = str;
        this.zzgfk = layoutParams;
        this.zzgfl = i;
        this.zzgfm = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.zzgfi;
        zzbdv zzbdv = this.zzgfj;
        String str = this.zzdgt;
        WindowManager.LayoutParams layoutParams = this.zzgfk;
        int i = this.zzgfl;
        WindowManager windowManager = this.zzgfm;
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && zzbdv.getView().getWindowToken() != null) {
            layoutParams.y = (("1".equals(str) || "2".equals(str)) ? rect.bottom : rect.top) - i;
            windowManager.updateViewLayout(zzbdv.getView(), layoutParams);
        }
    }
}
