package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

final class zzaqh implements zzp {
    private final /* synthetic */ zzaqe zzdoe;

    zzaqh(zzaqe zzaqe) {
        this.zzdoe = zzaqe;
    }

    public final void onPause() {
        zzaza.zzeb("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        zzaza.zzeb("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
        zzaza.zzeb("AdMobCustomTabsAdapter overlay is closed.");
        this.zzdoe.zzdoc.onAdClosed(this.zzdoe);
    }

    public final void zzux() {
        zzaza.zzeb("Opening AdMobCustomTabsAdapter overlay.");
        this.zzdoe.zzdoc.onAdOpened(this.zzdoe);
    }
}
