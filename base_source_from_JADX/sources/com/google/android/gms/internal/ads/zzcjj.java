package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzcjj implements zzbrz, zzbsm, zzbtj, zzbui, zzbwl, zzva {
    private final zzts zzgjl;
    @GuardedBy("this")
    private boolean zzgjm = false;

    public zzcjj(zzts zzts, @Nullable zzdkt zzdkt) {
        this.zzgjl = zzts;
        zzts.zza(zztu.zza.C3718zza.AD_REQUEST);
        if (zzdkt != null) {
            zzts.zza(zztu.zza.C3718zza.REQUEST_IS_PREFETCH);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzgjm) {
            this.zzgjl.zza(zztu.zza.C3718zza.AD_FIRST_CLICK);
            this.zzgjm = true;
            return;
        }
        this.zzgjl.zza(zztu.zza.C3718zza.AD_SUBSEQUENT_CLICK);
    }

    public final synchronized void onAdImpression() {
        this.zzgjl.zza(zztu.zza.C3718zza.AD_IMPRESSION);
    }

    public final void onAdLoaded() {
        this.zzgjl.zza(zztu.zza.C3718zza.AD_LOADED);
    }

    public final void zzalg() {
        this.zzgjl.zza(zztu.zza.C3718zza.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    public final void zzb(zzdnj zzdnj) {
        this.zzgjl.zza((zztv) new zzcjm(zzdnj));
    }

    public final void zzbf(boolean z) {
        this.zzgjl.zza(z ? zztu.zza.C3718zza.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED : zztu.zza.C3718zza.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED);
    }

    public final void zzbg(boolean z) {
        this.zzgjl.zza(z ? zztu.zza.C3718zza.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED : zztu.zza.C3718zza.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED);
    }

    public final void zzc(zzue.zzb zzb) {
        this.zzgjl.zza((zztv) new zzcjl(zzb));
        this.zzgjl.zza(zztu.zza.C3718zza.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzd(zzatl zzatl) {
    }

    public final void zzd(zzue.zzb zzb) {
        this.zzgjl.zza((zztv) new zzcjo(zzb));
        this.zzgjl.zza(zztu.zza.C3718zza.REQUEST_SAVED_TO_CACHE);
    }

    public final void zze(zzue.zzb zzb) {
        this.zzgjl.zza((zztv) new zzcjn(zzb));
        this.zzgjl.zza(zztu.zza.C3718zza.REQUEST_PREFETCH_INTERCEPTED);
    }

    public final void zzk(zzve zzve) {
        zzts zzts;
        zztu.zza.C3718zza zza;
        switch (zzve.errorCode) {
            case 1:
                zzts = this.zzgjl;
                zza = zztu.zza.C3718zza.AD_FAILED_TO_LOAD_INVALID_REQUEST;
                break;
            case 2:
                zzts = this.zzgjl;
                zza = zztu.zza.C3718zza.AD_FAILED_TO_LOAD_NETWORK_ERROR;
                break;
            case 3:
                zzts = this.zzgjl;
                zza = zztu.zza.C3718zza.AD_FAILED_TO_LOAD_NO_FILL;
                break;
            case 4:
                zzts = this.zzgjl;
                zza = zztu.zza.C3718zza.AD_FAILED_TO_LOAD_TIMEOUT;
                break;
            case 5:
                zzts = this.zzgjl;
                zza = zztu.zza.C3718zza.AD_FAILED_TO_LOAD_CANCELLED;
                break;
            case 6:
                zzts = this.zzgjl;
                zza = zztu.zza.C3718zza.AD_FAILED_TO_LOAD_NO_ERROR;
                break;
            case 7:
                zzts = this.zzgjl;
                zza = zztu.zza.C3718zza.AD_FAILED_TO_LOAD_NOT_FOUND;
                break;
            default:
                zzts = this.zzgjl;
                zza = zztu.zza.C3718zza.AD_FAILED_TO_LOAD;
                break;
        }
        zzts.zza(zza);
    }
}
