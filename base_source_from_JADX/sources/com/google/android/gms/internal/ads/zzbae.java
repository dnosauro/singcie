package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

final class zzbae implements Runnable {
    private final /* synthetic */ MediaPlayer zzeia;
    private final /* synthetic */ zzbac zzeib;

    zzbae(zzbac zzbac, MediaPlayer mediaPlayer) {
        this.zzeib = zzbac;
        this.zzeia = mediaPlayer;
    }

    public final void run() {
        this.zzeib.zza(this.zzeia);
        if (this.zzeib.zzehx != null) {
            this.zzeib.zzehx.zzfb();
        }
    }
}
