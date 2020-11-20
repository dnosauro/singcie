package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.ads.instream.InstreamAdView;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaju extends InstreamAd {
    private MediaContent zzbnf = zztp();
    private VideoController zzcjv = zzto();
    private final zzajn zzdhv;

    public zzaju(zzajn zzajn) {
        this.zzdhv = zzajn;
    }

    private final VideoController zzto() {
        VideoController videoController = new VideoController();
        try {
            videoController.zza(this.zzdhv.getVideoController());
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return videoController;
    }

    private final MediaContent zztp() {
        try {
            if (this.zzdhv.zzth() != null) {
                return new zzzm(this.zzdhv.zzth());
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzdhv.destroy();
            this.zzcjv = null;
            this.zzbnf = null;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final float getAspectRatio() {
        VideoController videoController = this.zzcjv;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getAspectRatio();
    }

    public final MediaContent getMediaContent() {
        return this.zzbnf;
    }

    public final VideoController getVideoController() {
        return this.zzcjv;
    }

    public final float getVideoCurrentTime() {
        VideoController videoController = this.zzcjv;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getVideoCurrentTime();
    }

    public final float getVideoDuration() {
        VideoController videoController = this.zzcjv;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getVideoDuration();
    }

    public final void zza(InstreamAdView instreamAdView) {
        if (instreamAdView == null) {
            zzaza.zzey("showInView: parameter view must not be null.");
            return;
        }
        try {
            this.zzdhv.zzr(ObjectWrapper.wrap(instreamAdView));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
