package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class zzvt extends zzxn {
    private final AppEventListener zzbnz;

    public zzvt(AppEventListener appEventListener) {
        this.zzbnz = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnz;
    }

    public final void onAppEvent(String str, String str2) {
        this.zzbnz.onAppEvent(str, str2);
    }
}
