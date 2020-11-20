package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbdv;

@VisibleForTesting
public final class zzk {
    public final Context context;
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdrc;

    public zzk(zzbdv zzbdv) {
        this.zzdrc = zzbdv.getLayoutParams();
        ViewParent parent2 = zzbdv.getParent();
        this.context = zzbdv.zzacn();
        if (parent2 == null || !(parent2 instanceof ViewGroup)) {
            throw new zzi("Could not get the parent of the WebView for an overlay.");
        }
        this.parent = (ViewGroup) parent2;
        this.index = this.parent.indexOfChild(zzbdv.getView());
        this.parent.removeView(zzbdv.getView());
        zzbdv.zzaz(true);
    }
}
