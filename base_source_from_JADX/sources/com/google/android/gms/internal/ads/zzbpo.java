package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbpo implements zzbru, zzbsm, zzbtj, zzbui, zzva {
    private final Clock zzbpw;
    private final zzayf zzfwc;

    public zzbpo(Clock clock, zzayf zzayf) {
        this.zzbpw = clock;
        this.zzfwc = zzayf;
    }

    public final void onAdClicked() {
        this.zzfwc.zzwq();
    }

    public final void onAdClosed() {
        this.zzfwc.zzwr();
    }

    public final void onAdImpression() {
        this.zzfwc.zzwp();
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdLoaded() {
        this.zzfwc.zzan(true);
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
    }

    public final void zzb(zzdnj zzdnj) {
        this.zzfwc.zzey(this.zzbpw.elapsedRealtime());
    }

    public final void zzd(zzatl zzatl) {
    }

    public final void zzf(zzvk zzvk) {
        this.zzfwc.zze(zzvk);
    }

    public final String zzws() {
        return this.zzfwc.zzws();
    }
}
