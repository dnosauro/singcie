package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaal;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzys;
import javax.annotation.concurrent.GuardedBy;

public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private zzys zzadq;
    @GuardedBy("lock")
    private VideoLifecycleCallbacks zzadr;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @Deprecated
    public final float getAspectRatio() {
        synchronized (this.lock) {
            if (this.zzadq == null) {
                return 0.0f;
            }
            try {
                float aspectRatio = this.zzadq.getAspectRatio();
                return aspectRatio;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.lock) {
            if (this.zzadq == null) {
                return 0;
            }
            try {
                int playbackState = this.zzadq.getPlaybackState();
                return playbackState;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.lock) {
            if (this.zzadq == null) {
                return 0.0f;
            }
            try {
                float currentTime = this.zzadq.getCurrentTime();
                return currentTime;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call getCurrentTime on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.lock) {
            if (this.zzadq == null) {
                return 0.0f;
            }
            try {
                float duration = this.zzadq.getDuration();
                return duration;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call getDuration on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzadr;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzadq != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            if (this.zzadq == null) {
                return false;
            }
            try {
                boolean isClickToExpandEnabled = this.zzadq.isClickToExpandEnabled();
                return isClickToExpandEnabled;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            if (this.zzadq == null) {
                return false;
            }
            try {
                boolean isCustomControlsEnabled = this.zzadq.isCustomControlsEnabled();
                return isCustomControlsEnabled;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            if (this.zzadq == null) {
                return true;
            }
            try {
                boolean isMuted = this.zzadq.isMuted();
                return isMuted;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            if (this.zzadq != null) {
                try {
                    this.zzadq.mute(z);
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            if (this.zzadq != null) {
                try {
                    this.zzadq.pause();
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public final void play() {
        synchronized (this.lock) {
            if (this.zzadq != null) {
                try {
                    this.zzadq.play();
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzadr = videoLifecycleCallbacks;
            if (this.zzadq != null) {
                try {
                    this.zzadq.zza(new zzaal(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            if (this.zzadq != null) {
                try {
                    this.zzadq.stop();
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final void zza(zzys zzys) {
        synchronized (this.lock) {
            this.zzadq = zzys;
            if (this.zzadr != null) {
                setVideoLifecycleCallbacks(this.zzadr);
            }
        }
    }

    public final zzys zzdw() {
        zzys zzys;
        synchronized (this.lock) {
            zzys = this.zzadq;
        }
        return zzys;
    }
}
