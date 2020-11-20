package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzcsw extends zzauz implements zzbtc {
    @GuardedBy("this")
    private zzbtf zzgrz;
    @GuardedBy("this")
    private zzauw zzgsb;
    @GuardedBy("this")
    private zzbyl zzgsc;

    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzava zzava) {
        if (this.zzgsb != null) {
            this.zzgsb.zza(iObjectWrapper, zzava);
        }
    }

    public final synchronized void zza(zzauw zzauw) {
        this.zzgsb = zzauw;
    }

    public final synchronized void zza(zzbtf zzbtf) {
        this.zzgrz = zzbtf;
    }

    public final synchronized void zza(zzbyl zzbyl) {
        this.zzgsc = zzbyl;
    }

    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) {
        if (this.zzgsb != null) {
            this.zzgsb.zzaf(iObjectWrapper);
        }
        if (this.zzgsc != null) {
            this.zzgsc.onInitializationSucceeded();
        }
    }

    public final synchronized void zzag(IObjectWrapper iObjectWrapper) {
        if (this.zzgsb != null) {
            this.zzgsb.zzag(iObjectWrapper);
        }
        if (this.zzgrz != null) {
            this.zzgrz.onAdLoaded();
        }
    }

    public final synchronized void zzah(IObjectWrapper iObjectWrapper) {
        if (this.zzgsb != null) {
            this.zzgsb.zzah(iObjectWrapper);
        }
    }

    public final synchronized void zzai(IObjectWrapper iObjectWrapper) {
        if (this.zzgsb != null) {
            this.zzgsb.zzai(iObjectWrapper);
        }
    }

    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) {
        if (this.zzgsb != null) {
            this.zzgsb.zzaj(iObjectWrapper);
        }
    }

    public final synchronized void zzak(IObjectWrapper iObjectWrapper) {
        if (this.zzgsb != null) {
            this.zzgsb.zzak(iObjectWrapper);
        }
    }

    public final synchronized void zzal(IObjectWrapper iObjectWrapper) {
        if (this.zzgsb != null) {
            this.zzgsb.zzal(iObjectWrapper);
        }
    }

    public final synchronized void zzam(IObjectWrapper iObjectWrapper) {
        if (this.zzgsb != null) {
            this.zzgsb.zzam(iObjectWrapper);
        }
    }

    public final synchronized void zzb(Bundle bundle) {
        if (this.zzgsb != null) {
            this.zzgsb.zzb(bundle);
        }
    }

    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzgsb != null) {
            this.zzgsb.zzd(iObjectWrapper, i);
        }
        if (this.zzgsc != null) {
            this.zzgsc.zzdy(i);
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzgsb != null) {
            this.zzgsb.zze(iObjectWrapper, i);
        }
        if (this.zzgrz != null) {
            this.zzgrz.onAdFailedToLoad(i);
        }
    }
}
