package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbsu extends zzbwk<zzbru> {
    public zzbsu(Set<zzbxy<zzbru>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbsx.zzfxs);
    }

    public final void onAdLeftApplication() {
        zza(zzbsw.zzfxs);
    }

    public final void onAdOpened() {
        zza(zzbsz.zzfxs);
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbta.zzfxs);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbsy.zzfxs);
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
        zza(new zzbtb(zzauf, str, str2));
    }
}
