package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.util.zzd;

public final class zzcgy extends VideoController.VideoLifecycleCallbacks {
    private final zzcce zzgaq;

    public zzcgy(zzcce zzcce) {
        this.zzgaq = zzcce;
    }

    private static zzyt zza(zzcce zzcce) {
        zzys videoController = zzcce.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzqq();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzyt zza = zza(this.zzgaq);
        if (zza != null) {
            try {
                zza.onVideoEnd();
            } catch (RemoteException e) {
                zzd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzyt zza = zza(this.zzgaq);
        if (zza != null) {
            try {
                zza.onVideoPause();
            } catch (RemoteException e) {
                zzd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoStart() {
        zzyt zza = zza(this.zzgaq);
        if (zza != null) {
            try {
                zza.onVideoStart();
            } catch (RemoteException e) {
                zzd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }
}
