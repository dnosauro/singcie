package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcbr extends zzaeh {
    private final zzcce zzgaq;
    private IObjectWrapper zzgbr;

    public zzcbr(zzcce zzcce) {
        this.zzgaq = zzcce;
    }

    private final float zzamw() {
        try {
            return this.zzgaq.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzd.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private static float zzas(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public final float getAspectRatio() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwx)).booleanValue()) {
            return 0.0f;
        }
        if (this.zzgaq.getMediaContentAspectRatio() != 0.0f) {
            return this.zzgaq.getMediaContentAspectRatio();
        }
        if (this.zzgaq.getVideoController() != null) {
            return zzamw();
        }
        IObjectWrapper iObjectWrapper = this.zzgbr;
        if (iObjectWrapper != null) {
            return zzas(iObjectWrapper);
        }
        zzaej zzane = this.zzgaq.zzane();
        if (zzane == null) {
            return 0.0f;
        }
        float width = (zzane == null || zzane.getWidth() == -1 || zzane.getHeight() == -1) ? 0.0f : ((float) zzane.getWidth()) / ((float) zzane.getHeight());
        return width != 0.0f ? width : zzas(zzane.zzsr());
    }

    public final float getCurrentTime() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue() && this.zzgaq.getVideoController() != null) {
            return this.zzgaq.getVideoController().getCurrentTime();
        }
        return 0.0f;
    }

    public final float getDuration() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue() && this.zzgaq.getVideoController() != null) {
            return this.zzgaq.getVideoController().getDuration();
        }
        return 0.0f;
    }

    public final zzys getVideoController() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue()) {
            return null;
        }
        return this.zzgaq.getVideoController();
    }

    public final boolean hasVideoContent() {
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue() && this.zzgaq.getVideoController() != null;
    }

    public final void zza(zzafv zzafv) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwy)).booleanValue() && (this.zzgaq.getVideoController() instanceof zzbep)) {
            ((zzbep) this.zzgaq.getVideoController()).zza(zzafv);
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcsd)).booleanValue()) {
            this.zzgbr = iObjectWrapper;
        }
    }

    public final IObjectWrapper zzsu() {
        IObjectWrapper iObjectWrapper = this.zzgbr;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzaej zzane = this.zzgaq.zzane();
        if (zzane == null) {
            return null;
        }
        return zzane.zzsr();
    }
}
