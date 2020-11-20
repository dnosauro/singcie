package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzafg implements NativeCustomTemplateAd {
    private final VideoController zzcjv = new VideoController();
    private final zzaff zzdfa;
    private final MediaView zzdfb;
    private NativeCustomTemplateAd.DisplayOpenMeasurement zzdfc;

    @VisibleForTesting
    public zzafg(zzaff zzaff) {
        Context context;
        this.zzdfa = zzaff;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzaff.zzta());
        } catch (RemoteException | NullPointerException e) {
            zzaza.zzc("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzdfa.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
        }
        this.zzdfb = mediaView;
    }

    public final void destroy() {
        try {
            this.zzdfa.destroy();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzdfa.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.zzdfa.getCustomTemplateId();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzdfc == null && this.zzdfa.zztb()) {
                this.zzdfc = new zzaef(this.zzdfa);
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
        return this.zzdfc;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzaej zzcu = this.zzdfa.zzcu(str);
            if (zzcu != null) {
                return new zzaek(zzcu);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zzdfa.zzct(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzys videoController = this.zzdfa.getVideoController();
            if (videoController != null) {
                this.zzcjv.zza(videoController);
            }
        } catch (RemoteException e) {
            zzaza.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcjv;
    }

    public final MediaView getVideoMediaView() {
        return this.zzdfb;
    }

    public final void performClick(String str) {
        try {
            this.zzdfa.performClick(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzdfa.recordImpression();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final zzaff zzte() {
        return this.zzdfa;
    }
}
