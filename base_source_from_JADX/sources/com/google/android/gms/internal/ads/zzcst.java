package com.google.android.gms.internal.ads;

import android.os.Bundle;
import javax.annotation.concurrent.GuardedBy;

public final class zzcst extends zzanr implements zzbtc {
    @GuardedBy("this")
    private zzano zzdoa;
    @GuardedBy("this")
    private zzbtf zzgrz;

    public final synchronized void onAdClicked() {
        if (this.zzdoa != null) {
            this.zzdoa.onAdClicked();
        }
    }

    public final synchronized void onAdClosed() {
        if (this.zzdoa != null) {
            this.zzdoa.onAdClosed();
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzdoa != null) {
            this.zzdoa.onAdFailedToLoad(i);
        }
        if (this.zzgrz != null) {
            this.zzgrz.onAdFailedToLoad(i);
        }
    }

    public final synchronized void onAdImpression() {
        if (this.zzdoa != null) {
            this.zzdoa.onAdImpression();
        }
    }

    public final synchronized void onAdLeftApplication() {
        if (this.zzdoa != null) {
            this.zzdoa.onAdLeftApplication();
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.zzdoa != null) {
            this.zzdoa.onAdLoaded();
        }
        if (this.zzgrz != null) {
            this.zzgrz.onAdLoaded();
        }
    }

    public final synchronized void onAdOpened() {
        if (this.zzdoa != null) {
            this.zzdoa.onAdOpened();
        }
    }

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzdoa != null) {
            this.zzdoa.onAppEvent(str, str2);
        }
    }

    public final synchronized void onVideoEnd() {
        if (this.zzdoa != null) {
            this.zzdoa.onVideoEnd();
        }
    }

    public final synchronized void onVideoPause() {
        if (this.zzdoa != null) {
            this.zzdoa.onVideoPause();
        }
    }

    public final synchronized void onVideoPlay() {
        if (this.zzdoa != null) {
            this.zzdoa.onVideoPlay();
        }
    }

    public final synchronized void zza(zzaff zzaff, String str) {
        if (this.zzdoa != null) {
            this.zzdoa.zza(zzaff, str);
        }
    }

    public final synchronized void zza(zzant zzant) {
        if (this.zzdoa != null) {
            this.zzdoa.zza(zzant);
        }
    }

    public final synchronized void zza(zzavc zzavc) {
        if (this.zzdoa != null) {
            this.zzdoa.zza(zzavc);
        }
    }

    public final synchronized void zza(zzbtf zzbtf) {
        this.zzgrz = zzbtf;
    }

    public final synchronized void zzb(Bundle bundle) {
        if (this.zzdoa != null) {
            this.zzdoa.zzb(bundle);
        }
    }

    public final synchronized void zzb(zzano zzano) {
        this.zzdoa = zzano;
    }

    public final synchronized void zzb(zzava zzava) {
        if (this.zzdoa != null) {
            this.zzdoa.zzb(zzava);
        }
    }

    public final synchronized void zzc(int i, String str) {
        if (this.zzdoa != null) {
            this.zzdoa.zzc(i, str);
        }
        if (this.zzgrz != null) {
            this.zzgrz.zzf(i, str);
        }
    }

    public final synchronized void zzc(zzve zzve) {
        if (this.zzdoa != null) {
            this.zzdoa.zzc(zzve);
        }
        if (this.zzgrz != null) {
            this.zzgrz.zzk(zzve);
        }
    }

    public final synchronized void zzdc(int i) {
        if (this.zzdoa != null) {
            this.zzdoa.zzdc(i);
        }
    }

    public final synchronized void zzdj(String str) {
        if (this.zzdoa != null) {
            this.zzdoa.zzdj(str);
        }
    }

    public final synchronized void zzdk(String str) {
        if (this.zzdoa != null) {
            this.zzdoa.zzdk(str);
        }
    }

    public final synchronized void zze(zzve zzve) {
        if (this.zzdoa != null) {
            this.zzdoa.zze(zzve);
        }
    }

    public final synchronized void zzun() {
        if (this.zzdoa != null) {
            this.zzdoa.zzun();
        }
    }

    public final synchronized void zzuo() {
        if (this.zzdoa != null) {
            this.zzdoa.zzuo();
        }
    }
}
