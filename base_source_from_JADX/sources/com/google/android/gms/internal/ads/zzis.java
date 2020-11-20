package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

final class zzis extends Thread {
    private final /* synthetic */ AudioTrack zzalv;
    private final /* synthetic */ zzip zzalw;

    zzis(zzip zzip, AudioTrack audioTrack) {
        this.zzalw = zzip;
        this.zzalv = audioTrack;
    }

    public final void run() {
        try {
            this.zzalv.flush();
            this.zzalv.release();
        } finally {
            this.zzalw.zzajs.open();
        }
    }
}
