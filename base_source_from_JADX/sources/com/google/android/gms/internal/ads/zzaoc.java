package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzaoc extends zzyr {
    private final Object lock = new Object();
    private volatile zzyt zzdmn;

    public final float getAspectRatio() {
        throw new RemoteException();
    }

    public final float getCurrentTime() {
        throw new RemoteException();
    }

    public final float getDuration() {
        throw new RemoteException();
    }

    public final int getPlaybackState() {
        throw new RemoteException();
    }

    public final boolean isClickToExpandEnabled() {
        throw new RemoteException();
    }

    public final boolean isCustomControlsEnabled() {
        throw new RemoteException();
    }

    public final boolean isMuted() {
        throw new RemoteException();
    }

    public final void mute(boolean z) {
        throw new RemoteException();
    }

    public final void pause() {
        throw new RemoteException();
    }

    public final void play() {
        throw new RemoteException();
    }

    public final void stop() {
        throw new RemoteException();
    }

    public final void zza(zzyt zzyt) {
        synchronized (this.lock) {
            this.zzdmn = zzyt;
        }
    }

    public final zzyt zzqq() {
        zzyt zzyt;
        synchronized (this.lock) {
            zzyt = this.zzdmn;
        }
        return zzyt;
    }
}
