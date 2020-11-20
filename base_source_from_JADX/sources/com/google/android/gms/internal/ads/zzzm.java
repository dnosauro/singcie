package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzzm implements MediaContent {
    private final VideoController zzcjv = new VideoController();
    private final zzaee zzckp;

    public zzzm(zzaee zzaee) {
        this.zzckp = zzaee;
    }

    public final float getAspectRatio() {
        try {
            return this.zzckp.getAspectRatio();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return 0.0f;
        }
    }

    public final float getCurrentTime() {
        try {
            return this.zzckp.getCurrentTime();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return 0.0f;
        }
    }

    public final float getDuration() {
        try {
            return this.zzckp.getDuration();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return 0.0f;
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzsu = this.zzckp.zzsu();
            if (zzsu != null) {
                return (Drawable) ObjectWrapper.unwrap(zzsu);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzckp.getVideoController() != null) {
                this.zzcjv.zza(this.zzckp.getVideoController());
            }
        } catch (RemoteException e) {
            zzaza.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcjv;
    }

    public final boolean hasVideoContent() {
        try {
            return this.zzckp.hasVideoContent();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.zzckp.zzo(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final zzaee zzrc() {
        return this.zzckp;
    }
}
