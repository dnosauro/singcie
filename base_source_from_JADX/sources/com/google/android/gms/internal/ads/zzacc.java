package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

public final class zzacc extends zzaca {
    private final OnCustomRenderedAdLoadedListener zzcjx;

    public zzacc(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcjx = onCustomRenderedAdLoadedListener;
    }

    public final void zza(zzabw zzabw) {
        this.zzcjx.onCustomRenderedAdLoaded(new zzabx(zzabw));
    }
}
