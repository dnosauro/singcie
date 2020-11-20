package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

public final class zzaal extends zzyw {
    private final VideoController.VideoLifecycleCallbacks zzadr;

    public zzaal(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzadr = videoLifecycleCallbacks;
    }

    public final void onVideoEnd() {
        this.zzadr.onVideoEnd();
    }

    public final void onVideoMute(boolean z) {
        this.zzadr.onVideoMute(z);
    }

    public final void onVideoPause() {
        this.zzadr.onVideoPause();
    }

    public final void onVideoPlay() {
        this.zzadr.onVideoPlay();
    }

    public final void onVideoStart() {
        this.zzadr.onVideoStart();
    }
}
