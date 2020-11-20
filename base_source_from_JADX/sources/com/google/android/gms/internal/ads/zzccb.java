package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

public final class zzccb extends zzyr {
    private final Object lock = new Object();
    @Nullable
    private zzys zzgcp;
    @Nullable
    private final zzaob zzgcq;

    public zzccb(@Nullable zzys zzys, @Nullable zzaob zzaob) {
        this.zzgcp = zzys;
        this.zzgcq = zzaob;
    }

    public final float getAspectRatio() {
        throw new RemoteException();
    }

    public final float getCurrentTime() {
        zzaob zzaob = this.zzgcq;
        if (zzaob != null) {
            return zzaob.getVideoCurrentTime();
        }
        return 0.0f;
    }

    public final float getDuration() {
        zzaob zzaob = this.zzgcq;
        if (zzaob != null) {
            return zzaob.getVideoDuration();
        }
        return 0.0f;
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
            if (this.zzgcp != null) {
                this.zzgcp.zza(zzyt);
            }
        }
    }

    public final zzyt zzqq() {
        synchronized (this.lock) {
            if (this.zzgcp == null) {
                return null;
            }
            zzyt zzqq = this.zzgcp.zzqq();
            return zzqq;
        }
    }
}
