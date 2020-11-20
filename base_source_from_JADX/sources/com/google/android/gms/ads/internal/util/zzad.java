package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;

public final class zzad {
    private float zzdth = 1.0f;
    private boolean zzdtn = false;

    public static float zzbi(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return ((float) streamVolume) / ((float) streamMaxVolume);
    }

    private final synchronized boolean zzyo() {
        return this.zzdth >= 0.0f;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzdtn = z;
    }

    public final synchronized void setAppVolume(float f) {
        this.zzdth = f;
    }

    public final synchronized float zzqk() {
        if (!zzyo()) {
            return 1.0f;
        }
        return this.zzdth;
    }

    public final synchronized boolean zzql() {
        return this.zzdtn;
    }
}
