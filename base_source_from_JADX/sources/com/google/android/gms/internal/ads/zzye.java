package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

public final class zzye extends zzyc {
    private final MuteThisAdListener zzcjg;

    public zzye(MuteThisAdListener muteThisAdListener) {
        this.zzcjg = muteThisAdListener;
    }

    public final void onAdMuted() {
        this.zzcjg.onAdMuted();
    }
}
